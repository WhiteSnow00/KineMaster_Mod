// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

final class b extends zaa
{
    final TaskCompletionSource a;
    
    b(final zay zay, final TaskCompletionSource a) {
        this.a = a;
    }
    
    @Override
    public final void T0(final Status status, final ModuleAvailabilityResponse moduleAvailabilityResponse) {
        TaskUtil.c(status, moduleAvailabilityResponse, (com.google.android.gms.tasks.TaskCompletionSource<ModuleAvailabilityResponse>)this.a);
    }
}
