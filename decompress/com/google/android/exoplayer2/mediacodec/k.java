// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;

public final class k implements f
{
    public final Format a;
    
    public k(final Format a) {
        this.a = a;
    }
    
    @Override
    public final int a(final Object o) {
        return MediaCodecUtil.c(this.a, (MediaCodecInfo)o);
    }
}
