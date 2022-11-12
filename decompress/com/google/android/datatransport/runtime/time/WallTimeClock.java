// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.time;

public class WallTimeClock implements Clock
{
    @Override
    public long a() {
        return System.currentTimeMillis();
    }
}
