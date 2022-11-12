// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;
import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;

final class t0 implements zabz
{
    final a a;
    
    t0(final a a, final zaw zaw) {
        this.a = a;
    }
    
    @Override
    public final void a(final Bundle bundle) {
        com.google.android.gms.common.api.internal.a.t(this.a).lock();
        try {
            com.google.android.gms.common.api.internal.a.y(this.a, bundle);
            com.google.android.gms.common.api.internal.a.u(this.a, ConnectionResult.e);
            com.google.android.gms.common.api.internal.a.z(this.a);
        }
        finally {
            com.google.android.gms.common.api.internal.a.t(this.a).unlock();
        }
    }
    
    @Override
    public final void b(final int n, final boolean b) {
        com.google.android.gms.common.api.internal.a.t(this.a).lock();
        try {
            final a a = this.a;
            Lock lock;
            if (!com.google.android.gms.common.api.internal.a.A(a) && com.google.android.gms.common.api.internal.a.p(a) != null && com.google.android.gms.common.api.internal.a.p(a).O1()) {
                com.google.android.gms.common.api.internal.a.w(this.a, true);
                com.google.android.gms.common.api.internal.a.s(this.a).onConnectionSuspended(n);
                lock = com.google.android.gms.common.api.internal.a.t(this.a);
            }
            else {
                com.google.android.gms.common.api.internal.a.w(this.a, false);
                com.google.android.gms.common.api.internal.a.x(this.a, n, b);
                lock = com.google.android.gms.common.api.internal.a.t(this.a);
            }
            lock.unlock();
        }
        finally {
            com.google.android.gms.common.api.internal.a.t(this.a).unlock();
        }
    }
    
    @Override
    public final void c(final ConnectionResult connectionResult) {
        com.google.android.gms.common.api.internal.a.t(this.a).lock();
        try {
            com.google.android.gms.common.api.internal.a.u(this.a, connectionResult);
            com.google.android.gms.common.api.internal.a.z(this.a);
        }
        finally {
            com.google.android.gms.common.api.internal.a.t(this.a).unlock();
        }
    }
}
