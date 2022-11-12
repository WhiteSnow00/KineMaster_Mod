// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class x implements Event
{
    public final float a;
    
    public x(final float a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.u0(this.a, (Player.Listener)o);
    }
}
