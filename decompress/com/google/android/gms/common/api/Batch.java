// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

public final class Batch extends BasePendingResult<BatchResult>
{
    private final PendingResult[] r;
    
    @Override
    public void d() {
        super.d();
        final PendingResult[] r = this.r;
        for (int length = r.length, i = 0; i < length; ++i) {
            r[i].d();
        }
    }
    
    public final /* bridge */ Result e(final Status status) {
        return this.q(status);
    }
    
    public BatchResult q(final Status status) {
        return new BatchResult(status, this.r);
    }
    
    public static final class Builder
    {
    }
}
