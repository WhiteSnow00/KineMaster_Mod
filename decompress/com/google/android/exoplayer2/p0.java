// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ListenerSet;

public final class p0 implements Event
{
    public final Metadata a;
    
    public p0(final Metadata a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.c.C(this.a, (Player.Listener)o);
    }
}
