// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;

public interface RtpPayloadReader
{
    void a(final long p0, final long p1);
    
    void b(final ParsableByteArray p0, final long p1, final int p2, final boolean p3) throws ParserException;
    
    void c(final ExtractorOutput p0, final int p1);
    
    void d(final long p0, final int p1);
    
    public interface Factory
    {
    }
}
