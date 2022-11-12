// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class f0 implements Event
{
    public final int a;
    public final Player.PositionInfo b;
    public final Player.PositionInfo c;
    
    public f0(final int a, final Player.PositionInfo b, final Player.PositionInfo c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.E0(this.a, this.b, this.c, (Player.Listener)o);
    }
}
