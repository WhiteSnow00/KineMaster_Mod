// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import java.util.Comparator;

public final class n implements Comparator
{
    public final MediaCodecUtil.f a;
    
    public n(final MediaCodecUtil.f a) {
        this.a = a;
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return MediaCodecUtil.d(this.a, o, o2);
    }
}
