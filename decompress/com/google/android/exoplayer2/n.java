// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class n implements Event
{
    public final m1 a;
    
    public n(final m1 a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.y0(this.a, (Player.Listener)o);
    }
}
