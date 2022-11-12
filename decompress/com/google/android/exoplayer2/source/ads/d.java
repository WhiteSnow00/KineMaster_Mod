// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.ads;

import java.io.IOException;
import com.google.android.exoplayer2.source.MediaSource;

public final class d implements Runnable
{
    public final AdsMediaSource.b a;
    public final MediaSource.MediaPeriodId b;
    public final IOException c;
    
    public d(final AdsMediaSource.b a, final MediaSource.MediaPeriodId b, final IOException c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        AdsMediaSource.b.c(this.a, this.b, this.c);
    }
}
