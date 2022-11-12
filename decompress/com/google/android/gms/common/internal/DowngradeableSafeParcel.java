// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable
{
    private static final Object b;
    private boolean a;
    
    static {
        b = new Object();
    }
    
    public DowngradeableSafeParcel() {
        this.a = false;
    }
}
