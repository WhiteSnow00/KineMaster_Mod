// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;

public interface ElementaryStreamReader
{
    void b(final ParsableByteArray p0) throws ParserException;
    
    void c();
    
    void d(final ExtractorOutput p0, final TsPayloadReader.TrackIdGenerator p1);
    
    void e();
    
    void f(final long p0, final int p1);
}
