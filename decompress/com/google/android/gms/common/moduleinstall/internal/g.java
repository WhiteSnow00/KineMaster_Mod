// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

final class g extends zaa
{
    final TaskCompletionSource a;
    
    g(final zay zay, final TaskCompletionSource a) {
        this.a = a;
    }
    
    @Override
    public final void t(final Status status, final ModuleInstallIntentResponse moduleInstallIntentResponse) {
        TaskUtil.c(status, moduleInstallIntentResponse, (com.google.android.gms.tasks.TaskCompletionSource<ModuleInstallIntentResponse>)this.a);
    }
}
