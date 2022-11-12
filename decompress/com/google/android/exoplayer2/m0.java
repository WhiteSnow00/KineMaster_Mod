// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class m0 implements Event
{
    public final int a;
    public final boolean b;
    
    public m0(final int a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.c.E(this.a, this.b, (Player.Listener)o);
    }
}
