// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mkv;

import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;

interface b
{
    boolean a(final ExtractorInput p0) throws IOException;
    
    void b(final EbmlProcessor p0);
    
    void reset();
}
