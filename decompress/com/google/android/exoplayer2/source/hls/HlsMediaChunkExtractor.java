// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;

public interface HlsMediaChunkExtractor
{
    boolean a(final ExtractorInput p0) throws IOException;
    
    void b(final ExtractorOutput p0);
    
    void c();
    
    boolean d();
    
    boolean e();
    
    HlsMediaChunkExtractor f();
}
