// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.retries;

public final class Retries
{
    private Retries() {
    }
    
    public static <TInput, TResult, TException extends Throwable> TResult a(int n, final TInput tInput, final Function<TInput, TResult, TException> function, final RetryStrategy<TInput, TResult> retryStrategy) throws TException, Throwable {
        int n2 = n;
        TInput a = tInput;
        if (n < 1) {
            return function.apply(tInput);
        }
        TResult apply;
        do {
            apply = function.apply(a);
            a = retryStrategy.a(a, apply);
            if (a == null) {
                break;
            }
            n = n2 - 1;
        } while ((n2 = n) >= 1);
        return apply;
    }
}
