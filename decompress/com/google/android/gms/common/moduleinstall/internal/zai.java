// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import java.util.concurrent.atomic.AtomicReference;
import com.google.android.gms.common.api.internal.RemoteCall;

public final class zai implements RemoteCall
{
    public final zay a;
    public final AtomicReference b;
    public final InstallStatusListener c;
    public final ApiFeatureRequest d;
    
    @Override
    public final void accept(final Object o, final Object o2) {
        ((zaz)o).getService().q1(new e(this.a, this.b, (TaskCompletionSource)o2, this.c), this.d, null);
    }
}
