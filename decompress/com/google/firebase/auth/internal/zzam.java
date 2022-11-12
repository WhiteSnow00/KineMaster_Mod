// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_auth_api.zzg;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.android.gms.common.logging.Logger;

public final class zzam
{
    private static final Logger h;
    private final FirebaseApp a;
    @VisibleForTesting
    volatile long b;
    @VisibleForTesting
    volatile long c;
    @VisibleForTesting
    final long d;
    @VisibleForTesting
    final HandlerThread e;
    @VisibleForTesting
    final Handler f;
    @VisibleForTesting
    final Runnable g;
    
    static {
        h = new Logger("TokenRefresher", new String[] { "FirebaseAuth:" });
    }
    
    public zzam(final FirebaseApp firebaseApp) {
        zzam.h.g("Initializing TokenRefresher", new Object[0]);
        final FirebaseApp a = Preconditions.k(firebaseApp);
        this.a = a;
        final HandlerThread e = new HandlerThread("TokenRefresher", 10);
        (this.e = e).start();
        this.f = (Handler)new zzg(e.getLooper());
        this.g = new c(this, a.o());
        this.d = 300000L;
    }
    
    static /* bridge */ Logger a() {
        return zzam.h;
    }
    
    public final void b() {
        this.f.removeCallbacks(this.g);
    }
    
    public final void c() {
        final Logger h = zzam.h;
        final long b = this.b;
        final long d = this.d;
        final StringBuilder sb = new StringBuilder();
        sb.append("Scheduling refresh for ");
        sb.append(b - d);
        h.g(sb.toString(), new Object[0]);
        this.b();
        this.c = Math.max(this.b - DefaultClock.d().a() - this.d, 0L) / 1000L;
        this.f.postDelayed(this.g, this.c * 1000L);
    }
    
    final void d() {
        final int n = (int)this.c;
        long c;
        if (n != 30 && n != 60 && n != 120 && n != 240 && n != 480) {
            if (n != 960) {
                c = 30L;
            }
            else {
                c = 960L;
            }
        }
        else {
            final long c2 = this.c;
            c = c2 + c2;
        }
        this.c = c;
        this.b = DefaultClock.d().a() + this.c * 1000L;
        final Logger h = zzam.h;
        final long b = this.b;
        final StringBuilder sb = new StringBuilder();
        sb.append("Scheduling refresh for ");
        sb.append(b);
        h.g(sb.toString(), new Object[0]);
        this.f.postDelayed(this.g, this.c * 1000L);
    }
}
