// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.util.List;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;

public interface ChunkExtractor
{
    boolean a(final ExtractorInput p0) throws IOException;
    
    void b(final TrackOutputProvider p0, final long p1, final long p2);
    
    ChunkIndex c();
    
    Format[] d();
    
    void release();
    
    public interface Factory
    {
        ChunkExtractor a(final int p0, final Format p1, final boolean p2, final List<Format> p3, final TrackOutput p4, final PlayerId p5);
    }
    
    public interface TrackOutputProvider
    {
        TrackOutput e(final int p0, final int p1);
    }
}
