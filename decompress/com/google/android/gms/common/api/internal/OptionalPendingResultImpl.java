// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.Result;

@KeepForSdk
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R>
{
    private final BasePendingResult a;
    
    public OptionalPendingResultImpl(final PendingResult pendingResult) {
        this.a = (BasePendingResult)pendingResult;
    }
    
    @Override
    public final void b(final StatusListener statusListener) {
        this.a.b(statusListener);
    }
    
    @Override
    public final R c(final long n, final TimeUnit timeUnit) {
        return this.a.c(n, timeUnit);
    }
    
    @Override
    public final void d() {
        this.a.d();
    }
}
