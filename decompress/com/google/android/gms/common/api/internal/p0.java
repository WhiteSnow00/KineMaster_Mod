// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import android.content.DialogInterface$OnCancelListener;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;
import android.app.PendingIntent;

final class p0 implements Runnable
{
    private final n0 a;
    final zap b;
    
    p0(final zap b, final n0 a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void run() {
        if (!this.b.b) {
            return;
        }
        final ConnectionResult b = this.a.b();
        if (b.N1()) {
            final zap b2 = this.b;
            b2.a.startActivityForResult(GoogleApiActivity.a((Context)b2.b(), Preconditions.k(b.M1()), this.a.a(), false), 1);
            return;
        }
        final zap b3 = this.b;
        if (b3.e.d((Context)b3.b(), b.K1(), null) != null) {
            final zap b4 = this.b;
            b4.e.A(b4.b(), this.b.a, b.K1(), 2, (DialogInterface$OnCancelListener)this.b);
            return;
        }
        if (b.K1() == 18) {
            final zap b5 = this.b;
            final Dialog v = b5.e.v(b5.b(), (DialogInterface$OnCancelListener)this.b);
            final zap b6 = this.b;
            b6.e.w(b6.b().getApplicationContext(), new o0(this, v));
            return;
        }
        zap.q(this.b, b, this.a.a());
    }
}
