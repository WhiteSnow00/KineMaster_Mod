// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.MediaSource;

public final class c implements Runnable
{
    public final AdsMediaSource.b a;
    public final MediaSource.MediaPeriodId b;
    
    public c(final AdsMediaSource.b a, final MediaSource.MediaPeriodId b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        AdsMediaSource.b.d(this.a, this.b);
    }
}
