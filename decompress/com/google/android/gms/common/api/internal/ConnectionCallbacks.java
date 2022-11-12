// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.ShowFirstParty;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface ConnectionCallbacks
{
    @KeepForSdk
    @ShowFirstParty
    void onConnected(final Bundle p0);
    
    @KeepForSdk
    @ShowFirstParty
    void onConnectionSuspended(final int p0);
}
