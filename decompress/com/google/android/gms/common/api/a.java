// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

final class a<R extends Result> extends BasePendingResult<R>
{
    private final Result r;
    
    public a(final GoogleApiClient googleApiClient, final Result r) {
        super(googleApiClient);
        this.r = r;
    }
    
    @Override
    protected final R e(final Status status) {
        return (R)this.r;
    }
}
