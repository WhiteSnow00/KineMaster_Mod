// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import android.app.Activity;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.GoogleApiAvailability;
import androidx.collection.b;

public final class zaae extends zap
{
    private final b f;
    private final GoogleApiManager g;
    
    @VisibleForTesting
    zaae(final LifecycleFragment lifecycleFragment, final GoogleApiManager g, final GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment, googleApiAvailability);
        this.f = new b();
        this.g = g;
        super.a.J("ConnectionlessLifecycleHelper", this);
    }
    
    public static void u(final Activity activity, final GoogleApiManager googleApiManager, final ApiKey apiKey) {
        final LifecycleFragment c = LifecycleCallback.c(activity);
        zaae zaae;
        if ((zaae = c.u0("ConnectionlessLifecycleHelper", zaae.class)) == null) {
            zaae = new zaae(c, googleApiManager, GoogleApiAvailability.q());
        }
        Preconditions.l(apiKey, "ApiKey cannot be null");
        zaae.f.add(apiKey);
        googleApiManager.d(zaae);
    }
    
    private final void v() {
        if (!this.f.isEmpty()) {
            this.g.d(this);
        }
    }
    
    @Override
    public final void h() {
        super.h();
        this.v();
    }
    
    @Override
    public final void j() {
        super.j();
        this.v();
    }
    
    @Override
    public final void k() {
        super.k();
        this.g.e(this);
    }
    
    @Override
    protected final void m(final ConnectionResult connectionResult, final int n) {
        this.g.K(connectionResult, n);
    }
    
    @Override
    protected final void n() {
        this.g.b();
    }
    
    final b t() {
        return this.f;
    }
}
