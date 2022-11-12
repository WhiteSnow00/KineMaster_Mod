// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.signin.zae;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;

final class o implements ConnectionCallbacks, OnConnectionFailedListener
{
    final zaaw a;
    
    o(final zaaw a, final zaas zaas) {
        this.a = a;
    }
    
    @Override
    public final void onConnected(final Bundle bundle) {
        final ClientSettings clientSettings = Preconditions.k(zaaw.v(this.a));
        Preconditions.k(zaaw.x(this.a)).c((com.google.android.gms.signin.internal.zae)new n(this.a));
    }
    
    @Override
    public final void onConnectionFailed(final ConnectionResult connectionResult) {
        zaaw.z(this.a).lock();
        try {
            if (zaaw.I(this.a, connectionResult)) {
                zaaw.A(this.a);
                zaaw.E(this.a);
            }
            else {
                zaaw.C(this.a, connectionResult);
            }
        }
        finally {
            zaaw.z(this.a).unlock();
        }
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
    }
}
