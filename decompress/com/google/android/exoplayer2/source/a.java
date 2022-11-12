// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;

public final class a implements MediaSourceCaller
{
    public final CompositeMediaSource a;
    public final Object b;
    
    public a(final CompositeMediaSource a, final Object b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void N(final MediaSource mediaSource, final Timeline timeline) {
        CompositeMediaSource.p0(this.a, this.b, mediaSource, timeline);
    }
}
