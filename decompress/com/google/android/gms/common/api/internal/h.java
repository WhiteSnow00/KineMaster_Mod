// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.lang.ref.WeakReference;
import com.google.android.gms.common.internal.BaseGmsClient;

final class h implements ConnectionProgressReportCallbacks
{
    private final WeakReference a;
    private final Api b;
    private final boolean c;
    
    public h(final zaaw zaaw, final Api b, final boolean c) {
        this.a = new WeakReference((T)zaaw);
        this.b = b;
        this.c = c;
    }
    
    static /* bridge */ boolean b(final h h) {
        return h.c;
    }
    
    @Override
    public final void a(final ConnectionResult connectionResult) {
        final zaaw zaaw = (zaaw)this.a.get();
        if (zaaw == null) {
            return;
        }
        Preconditions.p(Looper.myLooper() == com.google.android.gms.common.api.internal.zaaw.u(zaaw).y.m(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        com.google.android.gms.common.api.internal.zaaw.z(zaaw).lock();
        try {
            Lock lock;
            if (!com.google.android.gms.common.api.internal.zaaw.G(zaaw, 0)) {
                lock = com.google.android.gms.common.api.internal.zaaw.z(zaaw);
            }
            else {
                if (!connectionResult.O1()) {
                    com.google.android.gms.common.api.internal.zaaw.D(zaaw, connectionResult, this.b, this.c);
                }
                if (com.google.android.gms.common.api.internal.zaaw.H(zaaw)) {
                    com.google.android.gms.common.api.internal.zaaw.E(zaaw);
                }
                lock = com.google.android.gms.common.api.internal.zaaw.z(zaaw);
            }
            lock.unlock();
        }
        finally {
            com.google.android.gms.common.api.internal.zaaw.z(zaaw).unlock();
        }
    }
}
