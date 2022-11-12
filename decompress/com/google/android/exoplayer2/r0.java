// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.util.ListenerSet;

public final class r0 implements Event
{
    public final VideoSize a;
    
    public r0(final VideoSize a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.c.D(this.a, (Player.Listener)o);
    }
}
