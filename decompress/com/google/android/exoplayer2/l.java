// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

public final class l implements PlaybackInfoUpdateListener
{
    public final l0 a;
    
    public l(final l0 a) {
        this.a = a;
    }
    
    @Override
    public final void a(final PlaybackInfoUpdate playbackInfoUpdate) {
        l0.D0(this.a, playbackInfoUpdate);
    }
}
