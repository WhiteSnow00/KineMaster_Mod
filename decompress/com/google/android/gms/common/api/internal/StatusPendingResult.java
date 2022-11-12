// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public class StatusPendingResult extends BasePendingResult<Status>
{
    @KeepForSdk
    public StatusPendingResult(final GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }
    
    @Override
    protected final /* bridge */ Result e(final Status status) {
        return status;
    }
}
