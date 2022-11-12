// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamic;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate>
{
    private final OnDelegateCreatedListener a;
    
    @KeepForSdk
    public DeferredLifecycleHelper() {
        this.a = new a(this);
    }
}
