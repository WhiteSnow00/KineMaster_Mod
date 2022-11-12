// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import java.util.concurrent.Executor;
import android.content.ServiceConnection;
import android.content.ComponentName;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import android.os.HandlerThread;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class GmsClientSupervisor
{
    private static int a = 4225;
    private static final Object b;
    private static o c;
    @VisibleForTesting
    static HandlerThread d;
    private static boolean e = false;
    
    static {
        b = new Object();
    }
    
    @KeepForSdk
    public static int b() {
        return GmsClientSupervisor.a;
    }
    
    @KeepForSdk
    public static GmsClientSupervisor c(final Context context) {
        synchronized (GmsClientSupervisor.b) {
            if (GmsClientSupervisor.c == null) {
                final Context applicationContext = context.getApplicationContext();
                Looper looper;
                if (GmsClientSupervisor.e) {
                    looper = d().getLooper();
                }
                else {
                    looper = context.getMainLooper();
                }
                GmsClientSupervisor.c = new o(applicationContext, looper);
            }
            return GmsClientSupervisor.c;
        }
    }
    
    @KeepForSdk
    public static HandlerThread d() {
        synchronized (GmsClientSupervisor.b) {
            final HandlerThread d = GmsClientSupervisor.d;
            if (d != null) {
                return d;
            }
            (GmsClientSupervisor.d = new HandlerThread("GoogleApiHandler", 9)).start();
            return GmsClientSupervisor.d;
        }
    }
    
    @KeepForSdk
    public boolean a(final ComponentName componentName, final ServiceConnection serviceConnection, final String s) {
        return this.h(new zzn(componentName, b()), serviceConnection, s, null);
    }
    
    @KeepForSdk
    public void e(final ComponentName componentName, final ServiceConnection serviceConnection, final String s) {
        this.f(new zzn(componentName, b()), serviceConnection, s);
    }
    
    protected abstract void f(final zzn p0, final ServiceConnection p1, final String p2);
    
    public final void g(final String s, final String s2, final int n, final ServiceConnection serviceConnection, final String s3, final boolean b) {
        this.f(new zzn(s, s2, n, b), serviceConnection, s3);
    }
    
    protected abstract boolean h(final zzn p0, final ServiceConnection p1, final String p2, final Executor p3);
}
