// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class o0 implements Event
{
    public final l0.c a;
    
    public o0(final l0.c a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.c.H(this.a, (Player.Listener)o);
    }
}
