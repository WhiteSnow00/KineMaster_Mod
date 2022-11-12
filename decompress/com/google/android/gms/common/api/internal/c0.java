// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;

final class c0 implements ConnectionProgressReportCallbacks, zacs
{
    private final Api.Client a;
    private final ApiKey b;
    private IAccountAccessor c;
    private Set d;
    private boolean e;
    final GoogleApiManager f;
    
    public c0(final GoogleApiManager f, final Api.Client a, final ApiKey b) {
        this.f = f;
        this.c = null;
        this.d = null;
        this.e = false;
        this.a = a;
        this.b = b;
    }
    
    static /* bridge */ Api.Client d(final c0 c0) {
        return c0.a;
    }
    
    static /* bridge */ ApiKey e(final c0 c0) {
        return c0.b;
    }
    
    static /* bridge */ void f(final c0 c0, final boolean b) {
        c0.e = true;
    }
    
    static /* bridge */ void g(final c0 c0) {
        c0.h();
    }
    
    private final void h() {
        if (this.e) {
            final IAccountAccessor c = this.c;
            if (c != null) {
                this.a.getRemoteService(c, this.d);
            }
        }
    }
    
    @Override
    public final void a(final ConnectionResult connectionResult) {
        GoogleApiManager.s(this.f).post((Runnable)new b0(this, connectionResult));
    }
    
    @Override
    public final void b(final IAccountAccessor c, final Set d) {
        if (c != null && d != null) {
            this.c = c;
            this.d = d;
            this.h();
            return;
        }
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", (Throwable)new Exception());
        this.c(new ConnectionResult(4));
    }
    
    @Override
    public final void c(final ConnectionResult connectionResult) {
        final zabq zabq = GoogleApiManager.E(this.f).get(this.b);
        if (zabq != null) {
            zabq.F(connectionResult);
        }
    }
}
