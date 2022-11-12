// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import java.util.concurrent.Executor;
import android.content.ServiceConnection;
import android.os.Handler$Callback;
import com.google.android.gms.internal.common.zzi;
import android.os.Looper;
import com.google.android.gms.common.stats.ConnectionTracker;
import android.os.Handler;
import android.content.Context;
import javax.annotation.concurrent.GuardedBy;
import java.util.HashMap;

final class o extends GmsClientSupervisor
{
    @GuardedBy
    private final HashMap f;
    private final Context g;
    private volatile Handler h;
    private final n i;
    private final ConnectionTracker j;
    private final long k;
    private final long l;
    
    o(final Context context, final Looper looper) {
        this.f = new HashMap();
        final n i = new n(this, null);
        this.i = i;
        this.g = context.getApplicationContext();
        this.h = (Handler)new zzi(looper, (Handler$Callback)i);
        this.j = ConnectionTracker.b();
        this.k = 5000L;
        this.l = 300000L;
    }
    
    static /* bridge */ long i(final o o) {
        return o.l;
    }
    
    static /* bridge */ Context j(final o o) {
        return o.g;
    }
    
    static /* bridge */ Handler k(final o o) {
        return o.h;
    }
    
    static /* bridge */ ConnectionTracker l(final o o) {
        return o.j;
    }
    
    static /* bridge */ HashMap m(final o o) {
        return o.f;
    }
    
    @Override
    protected final void f(final zzn zzn, final ServiceConnection serviceConnection, String string) {
        Preconditions.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f) {
            final m m = this.f.get(zzn);
            if (m == null) {
                final String string2 = zzn.toString();
                final StringBuilder sb = new StringBuilder();
                sb.append("Nonexistent connection status for service config: ");
                sb.append(string2);
                throw new IllegalStateException(sb.toString());
            }
            if (m.h(serviceConnection)) {
                m.f(serviceConnection, string);
                if (m.i()) {
                    this.h.sendMessageDelayed(this.h.obtainMessage(0, (Object)zzn), this.k);
                }
                return;
            }
            string = zzn.toString();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
            sb2.append(string);
            throw new IllegalStateException(sb2.toString());
        }
    }
    
    @Override
    protected final boolean h(final zzn zzn, final ServiceConnection serviceConnection, String string, final Executor executor) {
        Preconditions.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f) {
            final m m = this.f.get(zzn);
            m j;
            if (m == null) {
                final m i = new m(this, zzn);
                i.d(serviceConnection, serviceConnection, string);
                i.e(string, executor);
                this.f.put(zzn, i);
                j = i;
            }
            else {
                this.h.removeMessages(0, (Object)zzn);
                if (m.h(serviceConnection)) {
                    string = zzn.toString();
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(string);
                    throw new IllegalStateException(sb.toString());
                }
                m.d(serviceConnection, serviceConnection, string);
                final int a = m.a();
                if (a != 1) {
                    if (a != 2) {
                        j = m;
                    }
                    else {
                        m.e(string, executor);
                        j = m;
                    }
                }
                else {
                    serviceConnection.onServiceConnected(m.b(), m.c());
                    j = m;
                }
            }
            return j.j();
        }
    }
}
