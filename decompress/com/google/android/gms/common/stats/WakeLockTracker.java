// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;

@Deprecated
@KeepForSdk
public class WakeLockTracker
{
    private static WakeLockTracker a;
    
    static {
        WakeLockTracker.a = new WakeLockTracker();
    }
}
