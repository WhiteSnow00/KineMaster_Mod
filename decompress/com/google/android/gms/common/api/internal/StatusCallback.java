// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class StatusCallback extends Stub
{
    @KeepForSdk
    private final BaseImplementation.ResultHolder<Status> a;
    
    @KeepForSdk
    public void C0(final Status status) {
        this.a.a(status);
    }
}
