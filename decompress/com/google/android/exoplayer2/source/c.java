// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;

public final class c implements ExtractorsFactory
{
    public final Format b;
    
    public c(final Format b) {
        this.b = b;
    }
    
    @Override
    public final Extractor[] c() {
        return DefaultMediaSourceFactory.e(this.b);
    }
}
