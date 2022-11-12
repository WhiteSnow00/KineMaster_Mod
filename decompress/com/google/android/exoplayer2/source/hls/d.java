// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

public final class d implements Runnable
{
    public final HlsSampleStreamWrapper.Callback a;
    
    public d(final HlsSampleStreamWrapper.Callback a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        this.a.onPrepared();
    }
}
