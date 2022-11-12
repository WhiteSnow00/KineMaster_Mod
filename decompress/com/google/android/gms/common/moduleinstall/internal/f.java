// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.internal.IStatusCallback;

final class f extends Stub
{
    final TaskCompletionSource a;
    
    f(final zay zay, final TaskCompletionSource a) {
        this.a = a;
    }
    
    public final void C0(final Status status) {
        TaskUtil.c(status, Boolean.TRUE, (com.google.android.gms.tasks.TaskCompletionSource<Boolean>)this.a);
    }
}
