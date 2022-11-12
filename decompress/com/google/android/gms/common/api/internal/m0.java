// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class m0 implements OnConnectionFailedListener
{
    public final int a;
    public final GoogleApiClient b;
    public final OnConnectionFailedListener c;
    final zak d;
    
    public m0(final zak d, final int a, final GoogleApiClient b, final OnConnectionFailedListener c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void onConnectionFailed(final ConnectionResult connectionResult) {
        Log.d("AutoManageHelper", "beginFailureResolution for ".concat(String.valueOf(connectionResult)));
        this.d.s(connectionResult, this.a);
    }
}
