// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class d0 implements Event
{
    public final int a;
    
    public d0(final int a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.H0(this.a, (Player.Listener)o);
    }
}
