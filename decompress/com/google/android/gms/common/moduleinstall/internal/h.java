// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.internal.IStatusCallback;

final class h extends Stub
{
    final TaskCompletionSource a;
    
    h(final zay zay, final TaskCompletionSource a) {
        this.a = a;
    }
    
    public final void C0(final Status status) {
        TaskUtil.c(status, null, (com.google.android.gms.tasks.TaskCompletionSource<Object>)this.a);
    }
}
