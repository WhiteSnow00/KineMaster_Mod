// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class t0 implements Event
{
    public final boolean a;
    
    public t0(final boolean a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.c.J(this.a, (Player.Listener)o);
    }
}
