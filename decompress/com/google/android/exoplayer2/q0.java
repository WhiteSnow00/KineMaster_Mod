// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.util.ListenerSet;

public final class q0 implements Event
{
    public final CueGroup a;
    
    public q0(final CueGroup a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.c.F(this.a, (Player.Listener)o);
    }
}
