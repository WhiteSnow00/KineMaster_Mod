// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class e0 implements Event
{
    public final int a;
    public final int b;
    
    public e0(final int a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.x0(this.a, this.b, (Player.Listener)o);
    }
}
