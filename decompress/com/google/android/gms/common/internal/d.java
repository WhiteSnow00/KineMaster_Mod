// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;

final class d implements BaseOnConnectionFailedListener
{
    final OnConnectionFailedListener a;
    
    d(final OnConnectionFailedListener a) {
        this.a = a;
    }
    
    @Override
    public final void onConnectionFailed(final ConnectionResult connectionResult) {
        this.a.onConnectionFailed(connectionResult);
    }
}
