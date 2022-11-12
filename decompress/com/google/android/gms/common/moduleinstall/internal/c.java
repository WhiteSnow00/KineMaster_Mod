// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

final class c extends zaa
{
    final TaskCompletionSource a;
    
    c(final zay zay, final TaskCompletionSource a) {
        this.a = a;
    }
    
    @Override
    public final void e1(final Status status) {
        TaskUtil.c(status, null, (com.google.android.gms.tasks.TaskCompletionSource<Object>)this.a);
    }
}
