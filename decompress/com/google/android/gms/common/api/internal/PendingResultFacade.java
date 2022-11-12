// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@KeepForSdk
public abstract class PendingResultFacade<A extends Result, B extends Result> extends PendingResult<B>
{
    @Override
    public final void b(final StatusListener statusListener) {
        throw null;
    }
    
    @Override
    public final B c(final long n, final TimeUnit timeUnit) {
        throw null;
    }
    
    @Override
    public final void d() {
        throw null;
    }
}
