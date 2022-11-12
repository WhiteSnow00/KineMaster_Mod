// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.stats;

import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.internal.zzs;
import android.content.ComponentName;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.Executor;
import android.content.Intent;
import java.util.NoSuchElementException;
import android.content.ServiceConnection;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ConnectionTracker
{
    private static final Object b;
    @Nullable
    private static volatile ConnectionTracker c;
    @VisibleForTesting
    public ConcurrentHashMap a;
    
    static {
        b = new Object();
    }
    
    private ConnectionTracker() {
        this.a = new ConcurrentHashMap();
    }
    
    @KeepForSdk
    public static ConnectionTracker b() {
        if (ConnectionTracker.c == null) {
            synchronized (ConnectionTracker.b) {
                if (ConnectionTracker.c == null) {
                    ConnectionTracker.c = new ConnectionTracker();
                }
            }
        }
        final ConnectionTracker c = ConnectionTracker.c;
        Preconditions.k(c);
        return c;
    }
    
    private static void e(final Context context, final ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        }
        catch (final IllegalArgumentException | IllegalStateException | NoSuchElementException ex) {}
    }
    
    private final boolean f(final Context context, final String s, final Intent intent, final ServiceConnection serviceConnection, final int n, boolean b, @Nullable final Executor executor) {
        final ComponentName component = intent.getComponent();
        while (true) {
            if (component == null) {
                break Label_0062;
            }
            final String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((Wrappers.a(context).c(packageName, 0).flags & 0x200000) != 0x0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
                if (g(serviceConnection)) {
                    final ServiceConnection serviceConnection2 = this.a.putIfAbsent(serviceConnection, serviceConnection);
                    if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
                        Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, s, intent.getAction()));
                    }
                    try {
                        b = h(context, intent, serviceConnection, n, executor);
                        if (b) {
                            return b;
                        }
                        return false;
                    }
                    finally {
                        this.a.remove(serviceConnection, serviceConnection);
                    }
                }
                b = h(context, intent, serviceConnection, n, executor);
                return b;
            }
            catch (final PackageManager$NameNotFoundException ex) {
                continue;
            }
            break;
        }
    }
    
    private static boolean g(final ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof zzs);
    }
    
    private static final boolean h(final Context context, final Intent intent, final ServiceConnection serviceConnection, final int n, @Nullable final Executor executor) {
        if (PlatformVersion.k() && executor != null) {
            return context.bindService(intent, n, executor, serviceConnection);
        }
        return context.bindService(intent, serviceConnection, n);
    }
    
    @KeepForSdk
    public boolean a(final Context context, final Intent intent, final ServiceConnection serviceConnection, final int n) {
        return this.f(context, context.getClass().getName(), intent, serviceConnection, n, true, null);
    }
    
    @KeepForSdk
    public void c(final Context context, final ServiceConnection serviceConnection) {
        if (g(serviceConnection) && this.a.containsKey(serviceConnection)) {
            try {
                e(context, this.a.get(serviceConnection));
                return;
            }
            finally {
                this.a.remove(serviceConnection);
            }
        }
        e(context, serviceConnection);
    }
    
    public final boolean d(final Context context, final String s, final Intent intent, final ServiceConnection serviceConnection, final int n, @Nullable final Executor executor) {
        return this.f(context, s, intent, serviceConnection, n, true, executor);
    }
}
