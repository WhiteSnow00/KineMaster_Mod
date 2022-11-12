// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import d4.j;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.util.List;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.Random;

public final class RandomTrackSelection extends BaseTrackSelection
{
    private final Random h;
    private int i;
    
    public RandomTrackSelection(final TrackGroup trackGroup, final int[] array, final int n, final Random h) {
        super(trackGroup, array, n);
        this.h = h;
        this.i = h.nextInt(super.b);
    }
    
    @Override
    public int a() {
        return this.i;
    }
    
    @Override
    public Object i() {
        return null;
    }
    
    @Override
    public void q(long elapsedRealtime, final long n, final long n2, final List<? extends MediaChunk> list, final MediaChunkIterator[] array) {
        elapsedRealtime = SystemClock.elapsedRealtime();
        final int n3 = 0;
        int i = 0;
        int n4 = 0;
        while (i < super.b) {
            int n5 = n4;
            if (!this.c(i, elapsedRealtime)) {
                n5 = n4 + 1;
            }
            ++i;
            n4 = n5;
        }
        this.i = this.h.nextInt(n4);
        if (n4 != super.b) {
            int n6 = 0;
            int n7;
            for (int j = n3; j < super.b; ++j, n6 = n7) {
                n7 = n6;
                if (!this.c(j, elapsedRealtime)) {
                    if (this.i == n6) {
                        this.i = j;
                        return;
                    }
                    n7 = n6 + 1;
                }
            }
        }
    }
    
    @Override
    public int t() {
        return 3;
    }
    
    public static final class Factory implements ExoTrackSelection.Factory
    {
        private final Random a;
        
        public Factory() {
            this.a = new Random();
        }
        
        public static ExoTrackSelection b(final Factory factory, final Definition definition) {
            return factory.c(definition);
        }
        
        private ExoTrackSelection c(final Definition definition) {
            return new RandomTrackSelection(definition.a, definition.b, definition.c, this.a);
        }
        
        @Override
        public ExoTrackSelection[] a(final Definition[] array, final BandwidthMeter bandwidthMeter, final MediaSource.MediaPeriodId mediaPeriodId, final Timeline timeline) {
            return TrackSelectionUtil.d(array, (TrackSelectionUtil.AdaptiveTrackSelectionFactory)new j(this));
        }
    }
}
