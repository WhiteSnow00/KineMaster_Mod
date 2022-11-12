// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class u0 implements Event
{
    public static final u0 a;
    
    static {
        a = new u0();
    }
    
    private u0() {
    }
    
    @Override
    public final void invoke(final Object o) {
        ((Player.Listener)o).onRenderedFirstFrame();
    }
}
