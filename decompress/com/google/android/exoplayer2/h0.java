// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class h0 implements Event
{
    public final MediaItem a;
    public final int b;
    
    public h0(final MediaItem a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.I0(this.a, this.b, (Player.Listener)o);
    }
}
