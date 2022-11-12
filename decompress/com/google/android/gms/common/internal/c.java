// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;

final class c implements BaseConnectionCallbacks
{
    final ConnectionCallbacks a;
    
    c(final ConnectionCallbacks a) {
        this.a = a;
    }
    
    @Override
    public final void onConnected(final Bundle bundle) {
        this.a.onConnected(bundle);
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
        this.a.onConnectionSuspended(n);
    }
}
