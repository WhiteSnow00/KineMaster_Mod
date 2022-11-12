// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class g0 implements Event
{
    public final l0 a;
    
    public g0(final l0 a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.G0(this.a, (Player.Listener)o);
    }
}
