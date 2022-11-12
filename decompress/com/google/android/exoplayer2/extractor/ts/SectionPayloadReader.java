// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public interface SectionPayloadReader
{
    void a(final TimestampAdjuster p0, final ExtractorOutput p1, final TsPayloadReader.TrackIdGenerator p2);
    
    void b(final ParsableByteArray p0);
}
