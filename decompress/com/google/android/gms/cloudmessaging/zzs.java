// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zze;
import java.util.concurrent.ScheduledExecutorService;
import android.content.Context;
import javax.annotation.concurrent.GuardedBy;

public final class zzs
{
    @GuardedBy
    private static zzs e;
    private final Context a;
    private final ScheduledExecutorService b;
    @GuardedBy
    private c c;
    @GuardedBy
    private int d;
    
    zzs(final Context context, final ScheduledExecutorService b) {
        this.c = new c(this, null);
        this.d = 1;
        this.b = b;
        this.a = context.getApplicationContext();
    }
    
    static /* bridge */ Context a(final zzs zzs) {
        return zzs.a;
    }
    
    public static zzs b(final Context context) {
        synchronized (zzs.class) {
            if (zzs.e == null) {
                zze.zza();
                zzs.e = new zzs(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
            return zzs.e;
        }
    }
    
    static /* bridge */ ScheduledExecutorService e(final zzs zzs) {
        return zzs.b;
    }
    
    private final int f() {
        synchronized (this) {
            return this.d++;
        }
    }
    
    private final <T> Task<T> g(final f<T> f) {
        synchronized (this) {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                final String value = String.valueOf(f);
                final StringBuilder sb = new StringBuilder(value.length() + 9);
                sb.append("Queueing ");
                sb.append(value);
                Log.d("MessengerIpcClient", sb.toString());
            }
            if (!this.c.g(f)) {
                (this.c = new c(this, null)).g(f);
            }
            return (Task<T>)f.b.a();
        }
    }
    
    public final Task<Void> c(final int n, final Bundle bundle) {
        return this.g((f<Void>)new e(this.f(), 2, bundle));
    }
    
    public final Task<Bundle> d(final int n, final Bundle bundle) {
        return this.g((f<Bundle>)new g(this.f(), 1, bundle));
    }
}
