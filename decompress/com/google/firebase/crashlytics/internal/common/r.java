// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;
import com.google.android.gms.tasks.Continuation;

public final class r implements Continuation
{
    public final CountDownLatch a;
    
    public r(final CountDownLatch a) {
        this.a = a;
    }
    
    public final Object then(final Task task) {
        return Utils.c(this.a, task);
    }
}
