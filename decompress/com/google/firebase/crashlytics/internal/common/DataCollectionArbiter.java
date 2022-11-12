// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.Executor;
import com.google.android.gms.tasks.Task;
import android.content.SharedPreferences$Editor;
import android.os.Bundle;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.firebase.crashlytics.internal.Logger;
import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import android.content.SharedPreferences;

public class DataCollectionArbiter
{
    private final SharedPreferences a;
    private final FirebaseApp b;
    private final Object c;
    TaskCompletionSource<Void> d;
    boolean e;
    private boolean f;
    private Boolean g;
    private final TaskCompletionSource<Void> h;
    
    public DataCollectionArbiter(final FirebaseApp b) {
        final Object c = new Object();
        this.c = c;
        this.d = (TaskCompletionSource<Void>)new TaskCompletionSource();
        this.e = false;
        this.f = false;
        this.h = (TaskCompletionSource<Void>)new TaskCompletionSource();
        final Context l = b.l();
        this.b = b;
        this.a = CommonUtils.r(l);
        Boolean g;
        if ((g = this.b()) == null) {
            g = this.a(l);
        }
        this.g = g;
        synchronized (c) {
            if (this.d()) {
                this.d.e((Object)null);
                this.e = true;
            }
        }
    }
    
    private Boolean a(final Context context) {
        final Boolean f = f(context);
        if (f == null) {
            this.f = false;
            return null;
        }
        this.f = true;
        return Boolean.TRUE.equals(f);
    }
    
    private Boolean b() {
        if (this.a.contains("firebase_crashlytics_collection_enabled")) {
            this.f = false;
            return this.a.getBoolean("firebase_crashlytics_collection_enabled", true);
        }
        return null;
    }
    
    private void e(final boolean b) {
        String s;
        if (b) {
            s = "ENABLED";
        }
        else {
            s = "DISABLED";
        }
        String s2;
        if (this.g == null) {
            s2 = "global Firebase setting";
        }
        else if (this.f) {
            s2 = "firebase_crashlytics_collection_enabled manifest flag";
        }
        else {
            s2 = "API";
        }
        Logger.f().b(String.format("Crashlytics automatic data collection %s by %s.", s, s2));
    }
    
    private static Boolean f(final Context context) {
        try {
            final PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                final ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    final Bundle metaData = applicationInfo.metaData;
                    if (metaData != null && metaData.containsKey("firebase_crashlytics_collection_enabled")) {
                        return applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled");
                    }
                }
            }
        }
        catch (final PackageManager$NameNotFoundException ex) {
            Logger.f().e("Could not read data collection permission from manifest", (Throwable)ex);
        }
        return null;
    }
    
    private static void h(final SharedPreferences sharedPreferences, final Boolean b) {
        final SharedPreferences$Editor edit = sharedPreferences.edit();
        if (b != null) {
            edit.putBoolean("firebase_crashlytics_collection_enabled", (boolean)b);
        }
        else {
            edit.remove("firebase_crashlytics_collection_enabled");
        }
        edit.apply();
    }
    
    public void c(final boolean b) {
        if (b) {
            this.h.e((Object)null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }
    
    public boolean d() {
        synchronized (this) {
            final Boolean g = this.g;
            boolean b;
            if (g != null) {
                b = g;
            }
            else {
                b = this.b.v();
            }
            this.e(b);
            return b;
        }
    }
    
    public void g(final Boolean b) {
        monitorenter(this);
        Label_0125: {
            if (b != null) {
                try {
                    this.f = false;
                }
                finally {
                    break Label_0125;
                }
            }
            Boolean a;
            if (b != null) {
                a = b;
            }
            else {
                a = this.a(this.b.l());
            }
            this.g = a;
            h(this.a, b);
            synchronized (this.c) {
                if (this.d()) {
                    if (!this.e) {
                        this.d.e((Object)null);
                        this.e = true;
                    }
                }
                else if (this.e) {
                    this.d = (TaskCompletionSource<Void>)new TaskCompletionSource();
                    this.e = false;
                }
                monitorexit(this.c);
                return;
            }
        }
        monitorexit(this);
    }
    
    public Task<Void> i() {
        synchronized (this.c) {
            return (Task<Void>)this.d.a();
        }
    }
    
    public Task<Void> j(final Executor executor) {
        return Utils.j(executor, (com.google.android.gms.tasks.Task<Void>)this.h.a(), this.i());
    }
}
