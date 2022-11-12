// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.util.List;
import com.google.android.exoplayer2.source.TrackGroup;

public final class FixedTrackSelection extends BaseTrackSelection
{
    private final int h;
    private final Object i;
    
    public FixedTrackSelection(final TrackGroup trackGroup, final int n, final int n2) {
        this(trackGroup, n, n2, 0, null);
    }
    
    public FixedTrackSelection(final TrackGroup trackGroup, final int n, final int n2, final int h, final Object i) {
        super(trackGroup, new int[] { n }, n2);
        this.h = h;
        this.i = i;
    }
    
    @Override
    public int a() {
        return 0;
    }
    
    @Override
    public Object i() {
        return this.i;
    }
    
    @Override
    public void q(final long n, final long n2, final long n3, final List<? extends MediaChunk> list, final MediaChunkIterator[] array) {
    }
    
    @Override
    public int t() {
        return this.h;
    }
}
