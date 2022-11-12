// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.scheduler;

public final class b implements Runnable
{
    public final RequirementsWatcher.c a;
    
    public b(final RequirementsWatcher.c a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        RequirementsWatcher.c.b(this.a);
    }
}
