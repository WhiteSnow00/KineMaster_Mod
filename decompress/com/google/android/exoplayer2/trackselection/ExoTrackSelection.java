// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.util.List;
import com.google.android.exoplayer2.source.chunk.Chunk;

public interface ExoTrackSelection extends TrackSelection
{
    int a();
    
    boolean b(final int p0, final long p1);
    
    boolean c(final int p0, final long p1);
    
    default boolean d(final long n, final Chunk chunk, final List<? extends MediaChunk> list) {
        return false;
    }
    
    void e();
    
    void h(final float p0);
    
    Object i();
    
    default void j() {
    }
    
    default void m(final boolean b) {
    }
    
    void n();
    
    int o(final long p0, final List<? extends MediaChunk> p1);
    
    void q(final long p0, final long p1, final long p2, final List<? extends MediaChunk> p3, final MediaChunkIterator[] p4);
    
    int r();
    
    Format s();
    
    int t();
    
    default void u() {
    }
    
    public static final class Definition
    {
        public final TrackGroup a;
        public final int[] b;
        public final int c;
        
        public Definition(final TrackGroup trackGroup, final int... array) {
            this(trackGroup, array, 0);
        }
        
        public Definition(final TrackGroup a, final int[] b, final int c) {
            if (b.length == 0) {
                Log.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    public interface Factory
    {
        ExoTrackSelection[] a(final Definition[] p0, final BandwidthMeter p1, final MediaSource.MediaPeriodId p2, final Timeline p3);
    }
}
