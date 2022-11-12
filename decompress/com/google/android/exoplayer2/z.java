// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class z implements Event
{
    public static final z a;
    
    static {
        a = new z();
    }
    
    private z() {
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.L0((Player.Listener)o);
    }
}
