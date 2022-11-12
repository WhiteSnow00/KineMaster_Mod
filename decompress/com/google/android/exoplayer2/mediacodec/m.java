// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

public final class m implements f
{
    public static final m a;
    
    static {
        a = new m();
    }
    
    private m() {
    }
    
    @Override
    public final int a(final Object o) {
        return MediaCodecUtil.b((MediaCodecInfo)o);
    }
}
