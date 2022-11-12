// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.analytics.PlayerId;

public final class i implements Factory
{
    public static final i a;
    
    static {
        a = new i();
    }
    
    private i() {
    }
    
    @Override
    public final ProgressiveMediaExtractor a(final PlayerId playerId) {
        return new MediaParserExtractorAdapter(playerId);
    }
}
