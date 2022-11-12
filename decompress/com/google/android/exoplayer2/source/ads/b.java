// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.ads;

public final class b implements Runnable
{
    public final AdsMediaSource a;
    public final AdsMediaSource.c b;
    
    public b(final AdsMediaSource a, final AdsMediaSource.c b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        AdsMediaSource.A0(this.a, this.b);
    }
}
