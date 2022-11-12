// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class DefaultClock implements Clock
{
    private static final DefaultClock a;
    
    static {
        a = new DefaultClock();
    }
    
    private DefaultClock() {
    }
    
    @KeepForSdk
    public static Clock d() {
        return DefaultClock.a;
    }
    
    @Override
    public final long a() {
        return System.currentTimeMillis();
    }
    
    @Override
    public final long b() {
        return System.nanoTime();
    }
    
    @Override
    public final long c() {
        return SystemClock.elapsedRealtime();
    }
}
