// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;

final class a extends ConstantBitrateSeekMap implements Seeker
{
    public a(final long n, final long n2, final MpegAudioUtil.Header header, final boolean b) {
        super(n, n2, header.f, header.c, b);
    }
    
    @Override
    public long c(final long n) {
        return this.b(n);
    }
    
    @Override
    public long g() {
        return -1L;
    }
}
