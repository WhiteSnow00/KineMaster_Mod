// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface OnConnectionFailedListener
{
    @KeepForSdk
    @ShowFirstParty
    void onConnectionFailed(final ConnectionResult p0);
}
