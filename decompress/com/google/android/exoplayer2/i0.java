// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class i0 implements Event
{
    public final MediaMetadata a;
    
    public i0(final MediaMetadata a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.F0(this.a, (Player.Listener)o);
    }
}
