// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;

public final class c implements ExtractorsFactory
{
    public static final c b;
    
    static {
        b = new c();
    }
    
    private c() {
    }
    
    @Override
    public final Extractor[] c() {
        return MatroskaExtractor.c();
    }
}
