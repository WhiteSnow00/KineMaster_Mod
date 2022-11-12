// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.retries;

public interface Function<TInput, TResult, TException extends Throwable>
{
    TResult apply(final TInput p0) throws TException, Throwable;
}
