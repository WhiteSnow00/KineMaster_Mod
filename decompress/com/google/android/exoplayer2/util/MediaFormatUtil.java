// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.List;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import android.media.MediaFormat;

public final class MediaFormatUtil
{
    private MediaFormatUtil() {
    }
    
    public static void a(final MediaFormat mediaFormat, final String s, final byte[] array) {
        if (array != null) {
            mediaFormat.setByteBuffer(s, ByteBuffer.wrap(array));
        }
    }
    
    public static void b(final MediaFormat mediaFormat, final ColorInfo colorInfo) {
        if (colorInfo != null) {
            d(mediaFormat, "color-transfer", colorInfo.c);
            d(mediaFormat, "color-standard", colorInfo.a);
            d(mediaFormat, "color-range", colorInfo.b);
            a(mediaFormat, "hdr-static-info", colorInfo.d);
        }
    }
    
    public static void c(final MediaFormat mediaFormat, final String s, final float n) {
        if (n != -1.0f) {
            mediaFormat.setFloat(s, n);
        }
    }
    
    public static void d(final MediaFormat mediaFormat, final String s, final int n) {
        if (n != -1) {
            mediaFormat.setInteger(s, n);
        }
    }
    
    public static void e(final MediaFormat mediaFormat, final List<byte[]> list) {
        for (int i = 0; i < list.size(); ++i) {
            final StringBuilder sb = new StringBuilder();
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(list.get(i)));
        }
    }
}
