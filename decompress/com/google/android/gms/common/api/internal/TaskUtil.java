// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class TaskUtil
{
    @KeepForSdk
    public static void a(final Status status, final TaskCompletionSource<Void> taskCompletionSource) {
        b(status, null, (com.google.android.gms.tasks.TaskCompletionSource<Object>)taskCompletionSource);
    }
    
    @KeepForSdk
    public static <ResultT> void b(final Status status, final ResultT resultT, final TaskCompletionSource<ResultT> taskCompletionSource) {
        if (status.P1()) {
            taskCompletionSource.c((Object)resultT);
            return;
        }
        taskCompletionSource.b((Exception)ApiExceptionUtil.a(status));
    }
    
    @KeepForSdk
    public static <ResultT> boolean c(final Status status, final ResultT resultT, final TaskCompletionSource<ResultT> taskCompletionSource) {
        if (status.P1()) {
            return taskCompletionSource.e((Object)resultT);
        }
        return taskCompletionSource.d((Exception)ApiExceptionUtil.a(status));
    }
}
