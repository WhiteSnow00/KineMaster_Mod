// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

public abstract class ResultTransform<R extends Result, S extends Result>
{
    public Status a(final Status status) {
        return status;
    }
    
    public abstract PendingResult<S> b(final R p0);
}
