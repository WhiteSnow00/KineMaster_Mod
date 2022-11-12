// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.util.List;
import com.google.android.exoplayer2.util.ListenerSet;

public final class s0 implements Event
{
    public final List a;
    
    public s0(final List a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.c.G(this.a, (Player.Listener)o);
    }
}
