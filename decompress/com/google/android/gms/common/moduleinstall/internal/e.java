// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicReference;

final class e extends zaa
{
    final AtomicReference a;
    final TaskCompletionSource b;
    final InstallStatusListener c;
    final zay d;
    
    e(final zay d, final AtomicReference a, final TaskCompletionSource b, final InstallStatusListener c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void R0(final Status status, final ModuleInstallResponse moduleInstallResponse) {
        if (moduleInstallResponse != null) {
            this.a.set(moduleInstallResponse);
        }
        TaskUtil.c(status, null, (com.google.android.gms.tasks.TaskCompletionSource<Object>)this.b);
        if (status.P1() && (moduleInstallResponse == null || !moduleInstallResponse.L1())) {
            return;
        }
        this.d.doUnregisterEventListener(ListenerHolders.b((Object)this.c, InstallStatusListener.class.getSimpleName()), 27306);
    }
}
