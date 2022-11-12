// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class y implements Event
{
    public final boolean a;
    
    public y(final boolean a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.r0(this.a, (Player.Listener)o);
    }
}
