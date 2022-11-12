// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zat implements ConnectionCallbacks, OnConnectionFailedListener
{
    public final Api a;
    private final boolean b;
    private zau c;
    
    public zat(final Api a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    private final zau b() {
        Preconditions.l(this.c, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.c;
    }
    
    public final void a(final zau c) {
        this.c = c;
    }
    
    @Override
    public final void onConnected(final Bundle bundle) {
        this.b().onConnected(bundle);
    }
    
    @Override
    public final void onConnectionFailed(final ConnectionResult connectionResult) {
        this.b().M0(connectionResult, this.a, this.b);
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
        this.b().onConnectionSuspended(n);
    }
}
