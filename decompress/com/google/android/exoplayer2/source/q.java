// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

public final class q implements Runnable
{
    public final u a;
    
    public q(final u a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        u.r(this.a);
    }
}
