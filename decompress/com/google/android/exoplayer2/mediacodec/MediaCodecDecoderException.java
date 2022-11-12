// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec$CodecException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.decoder.DecoderException;

public class MediaCodecDecoderException extends DecoderException
{
    public final MediaCodecInfo codecInfo;
    public final String diagnosticInfo;
    
    public MediaCodecDecoderException(final Throwable t, final MediaCodecInfo codecInfo) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Decoder failed: ");
        final String s = null;
        String a;
        if (codecInfo == null) {
            a = null;
        }
        else {
            a = codecInfo.a;
        }
        sb.append(a);
        super(sb.toString(), t);
        this.codecInfo = codecInfo;
        String a2 = s;
        if (Util.a >= 21) {
            a2 = a(t);
        }
        this.diagnosticInfo = a2;
    }
    
    private static String a(final Throwable t) {
        if (t instanceof MediaCodec$CodecException) {
            return ((MediaCodec$CodecException)t).getDiagnosticInfo();
        }
        return null;
    }
}
