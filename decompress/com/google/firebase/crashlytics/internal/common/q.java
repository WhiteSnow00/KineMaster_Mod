// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Continuation;

public final class q implements Continuation
{
    public final TaskCompletionSource a;
    
    public q(final TaskCompletionSource a) {
        this.a = a;
    }
    
    public final Object then(final Task task) {
        return Utils.b(this.a, task);
    }
}
