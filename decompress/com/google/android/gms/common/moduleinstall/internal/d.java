// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

final class d extends zaa
{
    final TaskCompletionSource a;
    
    d(final zay zay, final TaskCompletionSource a) {
        this.a = a;
    }
    
    @Override
    public final void R0(final Status status, final ModuleInstallResponse moduleInstallResponse) {
        TaskUtil.c(status, moduleInstallResponse, (com.google.android.gms.tasks.TaskCompletionSource<ModuleInstallResponse>)this.a);
    }
}
