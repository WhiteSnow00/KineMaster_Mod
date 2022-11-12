// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.ListenerSet;

public final class w implements Event
{
    public final TrackSelectionParameters a;
    
    public w(final TrackSelectionParameters a) {
        this.a = a;
    }
    
    @Override
    public final void invoke(final Object o) {
        l0.q0(this.a, (Player.Listener)o);
    }
}
