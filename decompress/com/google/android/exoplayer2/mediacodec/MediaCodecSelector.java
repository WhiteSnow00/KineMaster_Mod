// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import java.util.List;

public interface MediaCodecSelector
{
    public static final MediaCodecSelector a = j.b;
    
    List<MediaCodecInfo> a(final String p0, final boolean p1, final boolean p2) throws MediaCodecUtil.DecoderQueryException;
}
