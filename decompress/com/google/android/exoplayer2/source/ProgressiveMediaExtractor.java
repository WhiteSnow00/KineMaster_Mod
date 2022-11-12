// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.util.List;
import java.util.Map;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.PositionHolder;

public interface ProgressiveMediaExtractor
{
    void a(final long p0, final long p1);
    
    int b(final PositionHolder p0) throws IOException;
    
    void c();
    
    void d(final DataReader p0, final Uri p1, final Map<String, List<String>> p2, final long p3, final long p4, final ExtractorOutput p5) throws IOException;
    
    long e();
    
    void release();
    
    public interface Factory
    {
        ProgressiveMediaExtractor a(final PlayerId p0);
    }
}
