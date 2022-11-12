// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

final class b<R extends Result> extends BasePendingResult<R>
{
    public b(final GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }
    
    @Override
    protected final R e(final Status status) {
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
