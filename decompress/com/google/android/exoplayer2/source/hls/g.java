// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.util.Map;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.List;
import com.google.android.exoplayer2.Format;
import android.net.Uri;

public final class g implements HlsExtractorFactory
{
    public static final g b;
    
    static {
        b = new g();
    }
    
    private g() {
    }
    
    @Override
    public final HlsMediaChunkExtractor a(final Uri uri, final Format format, final List list, final TimestampAdjuster timestampAdjuster, final Map map, final ExtractorInput extractorInput, final PlayerId playerId) {
        return MediaParserHlsMediaChunkExtractor.g(uri, format, list, timestampAdjuster, map, extractorInput, playerId);
    }
}
