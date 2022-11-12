// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

public final class b0 implements IterationFinishedEvent
{
    public final l0 a;
    
    public b0(final l0 a) {
        this.a = a;
    }
    
    @Override
    public final void a(final Object o, final FlagSet set) {
        l0.t0(this.a, (Player.Listener)o, set);
    }
}
