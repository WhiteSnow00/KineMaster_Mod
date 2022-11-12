// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

public final class c0 implements Runnable
{
    public final l0 a;
    public final ExoPlayerImplInternal.PlaybackInfoUpdate b;
    
    public c0(final l0 a, final ExoPlayerImplInternal.PlaybackInfoUpdate b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        l0.M0(this.a, this.b);
    }
}
