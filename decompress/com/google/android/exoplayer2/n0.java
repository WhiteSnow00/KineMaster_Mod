// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.ListenerSet;

public final class n0 implements Event
{
    public final DeviceInfo a;
    
    public n0(final DeviceInfo a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.c.I(this.a, (Player.Listener)o);
    }
}
