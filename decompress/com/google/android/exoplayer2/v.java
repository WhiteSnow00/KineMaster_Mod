// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class v implements Event
{
    public final m1 a;
    public final int b;
    
    public v(final m1 a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.N0(this.a, this.b, (Player.Listener)o);
    }
}
