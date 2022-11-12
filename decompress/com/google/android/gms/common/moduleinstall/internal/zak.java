// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.atomic.AtomicReference;
import com.google.android.gms.tasks.SuccessContinuation;

public final class zak implements SuccessContinuation
{
    public final AtomicReference a;
    
    public final Task a(final Object o) {
        final AtomicReference a = this.a;
        final Void void1 = (Void)o;
        final int d = zay.d;
        Task task;
        if (a.get() != null) {
            task = Tasks.e((Object)a.get());
        }
        else {
            task = Tasks.d((Exception)new ApiException(Status.i));
        }
        return task;
    }
}
