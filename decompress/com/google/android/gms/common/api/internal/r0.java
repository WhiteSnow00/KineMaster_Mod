// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;

final class r0
{
    final BasePendingResult a;
    
    r0(final BasePendingResult a, final zar zar) {
        this.a = a;
    }
    
    @Override
    protected final void finalize() throws Throwable {
        BasePendingResult.n(BasePendingResult.l((BasePendingResult<Result>)this.a));
        super.finalize();
    }
}
