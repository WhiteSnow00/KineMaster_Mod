// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Handler$Callback;
import android.os.Looper;

public class SystemClock implements Clock
{
    protected SystemClock() {
    }
    
    @Override
    public long c() {
        return android.os.SystemClock.elapsedRealtime();
    }
    
    @Override
    public long d() {
        return android.os.SystemClock.uptimeMillis();
    }
    
    @Override
    public HandlerWrapper e(final Looper looper, final Handler$Callback handler$Callback) {
        return new d(new Handler(looper, handler$Callback));
    }
    
    @Override
    public void f() {
    }
}
