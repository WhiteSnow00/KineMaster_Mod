// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import android.os.Handler$Callback;
import android.os.Looper;

public interface Clock
{
    public static final Clock a = new SystemClock();
    
    long c();
    
    long d();
    
    HandlerWrapper e(final Looper p0, final Handler$Callback p1);
    
    void f();
}
