// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

public final class l implements f
{
    public static final l a;
    
    static {
        a = new l();
    }
    
    private l() {
    }
    
    @Override
    public final int a(final Object o) {
        return MediaCodecUtil.a((MediaCodecInfo)o);
    }
}
