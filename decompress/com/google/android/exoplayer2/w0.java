// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

public final class w0 implements Runnable
{
    public final ExoPlayerImplInternal a;
    public final PlayerMessage b;
    
    public w0(final ExoPlayerImplInternal a, final PlayerMessage b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        ExoPlayerImplInternal.e(this.a, this.b);
    }
}
