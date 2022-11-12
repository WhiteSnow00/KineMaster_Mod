// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.scheduler;

public interface Scheduler
{
    boolean a(final Requirements p0, final String p1, final String p2);
    
    Requirements b(final Requirements p0);
    
    boolean cancel();
}
