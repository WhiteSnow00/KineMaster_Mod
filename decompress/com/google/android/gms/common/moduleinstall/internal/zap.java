// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.internal.RemoteCall;

public final class zap implements RemoteCall
{
    public final zay a;
    public final ApiFeatureRequest b;
    
    @Override
    public final void accept(final Object o, final Object o2) {
        ((zaz)o).getService().M0(new b(this.a, (TaskCompletionSource)o2), this.b);
    }
}