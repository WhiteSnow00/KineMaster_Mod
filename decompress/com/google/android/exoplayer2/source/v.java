// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;

public final class v implements Factory
{
    public final ExtractorsFactory a;
    
    public v(final ExtractorsFactory a) {
        this.a = a;
    }
    
    @Override
    public final ProgressiveMediaExtractor a(final PlayerId playerId) {
        return ProgressiveMediaSource.Factory.e(this.a, playerId);
    }
}
