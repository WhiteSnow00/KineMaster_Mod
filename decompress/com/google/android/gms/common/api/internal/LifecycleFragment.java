// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.app.Activity;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface LifecycleFragment
{
    @KeepForSdk
    void J(final String p0, final LifecycleCallback p1);
    
    @KeepForSdk
    Activity T2();
    
    @KeepForSdk
    void startActivityForResult(final Intent p0, final int p1);
    
    @KeepForSdk
     <T extends LifecycleCallback> T u0(final String p0, final Class<T> p1);
}
