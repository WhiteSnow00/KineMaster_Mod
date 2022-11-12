// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;

public final class j1 implements MediaSourceCaller
{
    public final MediaSourceList a;
    
    public j1(final MediaSourceList a) {
        this.a = a;
    }
    
    @Override
    public final void N(final MediaSource mediaSource, final Timeline timeline) {
        MediaSourceList.a(this.a, mediaSource, timeline);
    }
}
