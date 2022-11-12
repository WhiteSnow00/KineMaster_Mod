// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.time;

import android.os.SystemClock;

public class UptimeClock implements Clock
{
    @Override
    public long a() {
        return SystemClock.elapsedRealtime();
    }
}
