// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

@KeepForSdk
public abstract class DataHolderResult implements Result, Releasable
{
    @KeepForSdk
    protected final Status a;
    @KeepForSdk
    protected final DataHolder b;
    
    @KeepForSdk
    @Override
    public Status getStatus() {
        return this.a;
    }
    
    @KeepForSdk
    @Override
    public void release() {
        try (final DataHolder b = this.b) {}
    }
}
