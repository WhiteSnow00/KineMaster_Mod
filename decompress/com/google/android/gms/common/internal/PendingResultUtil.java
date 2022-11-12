// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class PendingResultUtil
{
    private static final zas a;
    
    static {
        a = new e();
    }
    
    @KeepForSdk
    public static <R extends Result, T extends Response<R>> Task<T> a(final PendingResult<R> pendingResult, final T t) {
        return b(pendingResult, (ResultConverter<R, T>)new g(t));
    }
    
    @KeepForSdk
    public static <R extends Result, T> Task<T> b(final PendingResult<R> pendingResult, final ResultConverter<R, T> resultConverter) {
        final zas a = PendingResultUtil.a;
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.b((PendingResult.StatusListener)new f(pendingResult, taskCompletionSource, (ResultConverter)resultConverter, a));
        return (Task<T>)taskCompletionSource.a();
    }
    
    @KeepForSdk
    public static <R extends Result> Task<Void> c(final PendingResult<R> pendingResult) {
        return b(pendingResult, (ResultConverter<R, Void>)new h());
    }
    
    @KeepForSdk
    public interface ResultConverter<R extends Result, T>
    {
        @KeepForSdk
        T a(final R p0);
    }
}
