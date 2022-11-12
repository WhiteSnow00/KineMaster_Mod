// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

public final class e implements Runnable
{
    public final HlsSampleStreamWrapper a;
    
    public e(final HlsSampleStreamWrapper a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        HlsSampleStreamWrapper.r(this.a);
    }
}
