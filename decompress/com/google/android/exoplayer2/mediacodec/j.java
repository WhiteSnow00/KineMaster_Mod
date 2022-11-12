// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import java.util.List;

public final class j implements MediaCodecSelector
{
    public static final j b;
    
    static {
        b = new j();
    }
    
    private j() {
    }
    
    @Override
    public final List a(final String s, final boolean b, final boolean b2) {
        return MediaCodecUtil.s(s, b, b2);
    }
}
