// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.util.ParsableByteArray;

final class g implements a
{
    public final String a;
    
    private g(final String a) {
        this.a = a;
    }
    
    public static g a(final ParsableByteArray parsableByteArray) {
        return new g(parsableByteArray.A(parsableByteArray.a()));
    }
    
    @Override
    public int getType() {
        return 1852994675;
    }
}
