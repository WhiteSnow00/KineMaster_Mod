// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class a0 implements Event
{
    public static final a0 a;
    
    static {
        a = new a0();
    }
    
    private a0() {
    }
    
    @Override
    public final void invoke(final Object o) {
        ((Player.Listener)o).onSeekProcessed();
    }
}
