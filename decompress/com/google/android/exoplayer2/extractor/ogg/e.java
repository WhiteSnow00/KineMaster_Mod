// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.SeekMap;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;

interface e
{
    long a(final ExtractorInput p0) throws IOException;
    
    SeekMap b();
    
    void c(final long p0);
}
