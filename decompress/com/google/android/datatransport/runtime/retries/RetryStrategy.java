// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.retries;

public interface RetryStrategy<TInput, TResult>
{
    TInput a(final TInput p0, final TResult p1);
}
