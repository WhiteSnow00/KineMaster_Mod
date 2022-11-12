// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import java.io.IOException;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.SeekParameters;

public interface MediaPeriod extends SequenceableLoader
{
    long b();
    
    long c(final long p0, final SeekParameters p1);
    
    boolean d(final long p0);
    
    long f();
    
    void g(final long p0);
    
    long h(final long p0);
    
    long i();
    
    boolean isLoading();
    
    void j(final Callback p0, final long p1);
    
    long k(final ExoTrackSelection[] p0, final boolean[] p1, final SampleStream[] p2, final boolean[] p3, final long p4);
    
    void n() throws IOException;
    
    TrackGroupArray p();
    
    void q(final long p0, final boolean p1);
    
    public interface Callback extends SequenceableLoader.Callback<MediaPeriod>
    {
        void o(final MediaPeriod p0);
    }
}
