// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.service;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.api.internal.RemoteCall;

public final class zam implements RemoteCall
{
    public final TelemetryData a;
    
    public zam(final TelemetryData a) {
        this.a = a;
    }
    
    @Override
    public final void accept(final Object o, final Object o2) {
        final TelemetryData a = this.a;
        final zap zap = (zap)o;
        final TaskCompletionSource taskCompletionSource = (TaskCompletionSource)o2;
        final int d = zao.d;
        ((zai)zap.getService()).M0(a);
        taskCompletionSource.c((Object)null);
    }
}
