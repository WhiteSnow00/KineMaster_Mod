// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import java.io.IOException;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.util.Map;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.List;
import com.google.android.exoplayer2.Format;
import android.net.Uri;

public interface HlsExtractorFactory
{
    public static final HlsExtractorFactory a = new DefaultHlsExtractorFactory();
    
    HlsMediaChunkExtractor a(final Uri p0, final Format p1, final List<Format> p2, final TimestampAdjuster p3, final Map<String, List<String>> p4, final ExtractorInput p5, final PlayerId p6) throws IOException;
}
