// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.android;

import android.os.Handler;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.core.RunLoop;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.ConnectionContext;
import java.io.File;
import android.os.Build$VERSION;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.persistence.CachePolicy;
import com.google.firebase.database.core.persistence.PersistenceStorageEngine;
import com.google.firebase.database.core.persistence.DefaultPersistenceManager;
import com.google.firebase.database.core.persistence.LRUCachePolicy;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.logging.AndroidLogger;
import java.util.List;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.core.EventTarget;
import android.util.Log;
import java.util.HashSet;
import com.google.firebase.FirebaseApp;
import java.util.Set;
import android.content.Context;
import com.google.firebase.database.core.Platform;

public class AndroidPlatform implements Platform
{
    private final Context a;
    private final Set<String> b;
    private final FirebaseApp c;
    
    public AndroidPlatform(final FirebaseApp c) {
        this.b = new HashSet<String>();
        this.c = c;
        if (c != null) {
            this.a = c.l();
            return;
        }
        Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Log.e("FirebaseDatabase", "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
        Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
    }
    
    static Context h(final AndroidPlatform androidPlatform) {
        return androidPlatform.a;
    }
    
    @Override
    public EventTarget a(final com.google.firebase.database.core.Context context) {
        return new AndroidEventTarget();
    }
    
    @Override
    public Logger b(final com.google.firebase.database.core.Context context, final Logger.Level level, final List<String> list) {
        return new AndroidLogger(level, list);
    }
    
    @Override
    public PersistenceManager c(final com.google.firebase.database.core.Context context, String string) {
        final String x = context.x();
        final StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append("_");
        sb.append(x);
        string = sb.toString();
        if (!this.b.contains(string)) {
            this.b.add(string);
            return new DefaultPersistenceManager(context, new SqlPersistenceStorageEngine(this.a, context, string), new LRUCachePolicy(context.s()));
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("SessionPersistenceKey '");
        sb2.append(x);
        sb2.append("' has already been used.");
        throw new DatabaseException(sb2.toString());
    }
    
    @Override
    public String d(final com.google.firebase.database.core.Context context) {
        final StringBuilder sb = new StringBuilder();
        sb.append(Build$VERSION.SDK_INT);
        sb.append("/Android");
        return sb.toString();
    }
    
    @Override
    public File e() {
        return this.a.getApplicationContext().getDir("sslcache", 0);
    }
    
    @Override
    public PersistentConnection f(final com.google.firebase.database.core.Context context, final ConnectionContext connectionContext, final HostInfo hostInfo, final PersistentConnection.Delegate delegate) {
        final PersistentConnectionImpl persistentConnectionImpl = new PersistentConnectionImpl(connectionContext, hostInfo, delegate);
        this.c.g((FirebaseApp.BackgroundStateChangeListener)new FirebaseApp.BackgroundStateChangeListener(this, persistentConnectionImpl) {
            final PersistentConnection a;
            final AndroidPlatform b;
            
            @Override
            public void a(final boolean b) {
                if (b) {
                    this.a.g("app_in_background");
                }
                else {
                    this.a.i("app_in_background");
                }
            }
        });
        return persistentConnectionImpl;
    }
    
    @Override
    public RunLoop g(final com.google.firebase.database.core.Context context) {
        return new DefaultRunLoop(this, context.q("RunLoop")) {
            final LogWrapper b;
            final AndroidPlatform c;
            
            @Override
            public void f(final Throwable t) {
                final String g = DefaultRunLoop.g(t);
                this.b.c(g, t);
                new Handler(AndroidPlatform.h(this.c).getMainLooper()).post((Runnable)new Runnable(this, g, t) {
                    final String a;
                    final Throwable b;
                    final AndroidPlatform$a c;
                    
                    @Override
                    public void run() {
                        throw new RuntimeException(this.a, this.b);
                    }
                });
                this.c().shutdownNow();
            }
        };
    }
}
