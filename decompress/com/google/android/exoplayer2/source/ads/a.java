// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.ads;

public final class a implements Runnable
{
    public final AdsMediaSource a;
    public final AdsMediaSource.c b;
    
    public a(final AdsMediaSource a, final AdsMediaSource.c b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        AdsMediaSource.z0(this.a, this.b);
    }
}
