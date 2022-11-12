// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.content.DialogInterface;
import android.os.Parcelable;
import android.os.Bundle;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zau;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicReference;
import android.content.DialogInterface$OnCancelListener;

public abstract class zap extends LifecycleCallback implements DialogInterface$OnCancelListener
{
    protected volatile boolean b;
    protected final AtomicReference c;
    private final Handler d;
    protected final GoogleApiAvailability e;
    
    @VisibleForTesting
    zap(final LifecycleFragment lifecycleFragment, final GoogleApiAvailability e) {
        super(lifecycleFragment);
        this.c = new AtomicReference(null);
        this.d = (Handler)new zau(Looper.getMainLooper());
        this.e = e;
    }
    
    private final void l(final ConnectionResult connectionResult, final int n) {
        this.c.set(null);
        this.m(connectionResult, n);
    }
    
    private final void o() {
        this.c.set(null);
        this.n();
    }
    
    private static final int p(final n0 n0) {
        if (n0 == null) {
            return -1;
        }
        return n0.a();
    }
    
    static /* bridge */ void q(final zap zap, final ConnectionResult connectionResult, final int n) {
        zap.l(connectionResult, n);
    }
    
    static /* bridge */ void r(final zap zap) {
        zap.o();
    }
    
    @Override
    public final void e(int n, final int n2, final Intent intent) {
        final n0 n3 = this.c.get();
        if (n != 1) {
            if (n == 2) {
                n = this.e.i((Context)this.b());
                if (n == 0) {
                    this.o();
                    return;
                }
                if (n3 == null) {
                    return;
                }
                if (n3.b().K1() == 18 && n == 18) {
                    return;
                }
            }
        }
        else {
            if (n2 == -1) {
                this.o();
                return;
            }
            if (n2 == 0) {
                if (n3 == null) {
                    return;
                }
                n = 13;
                if (intent != null) {
                    n = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                this.l(new ConnectionResult(n, null, n3.b().toString()), p(n3));
                return;
            }
        }
        if (n3 != null) {
            this.l(n3.b(), n3.a());
        }
    }
    
    @Override
    public final void f(final Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            final AtomicReference c = this.c;
            n0 n0;
            if (bundle.getBoolean("resolving_error", false)) {
                n0 = new n0(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            }
            else {
                n0 = null;
            }
            c.set(n0);
        }
    }
    
    @Override
    public final void i(final Bundle bundle) {
        super.i(bundle);
        final n0 n0 = this.c.get();
        if (n0 == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", n0.a());
        bundle.putInt("failed_status", n0.b().K1());
        bundle.putParcelable("failed_resolution", (Parcelable)n0.b().M1());
    }
    
    @Override
    public void j() {
        super.j();
        this.b = true;
    }
    
    @Override
    public void k() {
        super.k();
        this.b = false;
    }
    
    protected abstract void m(final ConnectionResult p0, final int p1);
    
    protected abstract void n();
    
    public final void onCancel(final DialogInterface dialogInterface) {
        this.l(new ConnectionResult(13, null), p(this.c.get()));
    }
    
    public final void s(final ConnectionResult connectionResult, final int n) {
        final n0 n2 = new n0(connectionResult, n);
        final AtomicReference c = this.c;
        while (!c.compareAndSet(null, n2)) {
            if (c.get() != null) {
                return;
            }
        }
        this.d.post((Runnable)new p0(this, n2));
    }
}
