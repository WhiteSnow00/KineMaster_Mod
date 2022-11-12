// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

public class TestClock implements Clock
{
    private final AtomicLong a;
    
    @Override
    public long a() {
        return this.a.get();
    }
}
