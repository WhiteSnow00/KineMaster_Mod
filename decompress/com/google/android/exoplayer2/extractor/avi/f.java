// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.avi;

import java.util.List;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.Format;

final class f implements a
{
    public final Format a;
    
    public f(final Format a) {
        this.a = a;
    }
    
    private static String a(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case 1196444237:
            case 1735420525: {
                return "video/mjpeg";
            }
            case 859066445: {
                return "video/mp43";
            }
            case 842289229: {
                return "video/mp42";
            }
            case 826496577:
            case 828601953:
            case 875967048: {
                return "video/avc";
            }
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148: {
                return "video/mp4v-es";
            }
        }
    }
    
    private static String b(final int n) {
        if (n == 1) {
            return "audio/raw";
        }
        if (n == 85) {
            return "audio/mpeg";
        }
        if (n == 255) {
            return "audio/mp4a-latm";
        }
        if (n == 8192) {
            return "audio/ac3";
        }
        if (n != 8193) {
            return null;
        }
        return "audio/vnd.dts";
    }
    
    private static a c(final ParsableByteArray parsableByteArray) {
        parsableByteArray.Q(4);
        final int q = parsableByteArray.q();
        final int q2 = parsableByteArray.q();
        parsableByteArray.Q(4);
        final int q3 = parsableByteArray.q();
        final String a = a(q3);
        if (a == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring track with unsupported compression ");
            sb.append(q3);
            Log.i("StreamFormatChunk", sb.toString());
            return null;
        }
        final Format.Builder builder = new Format.Builder();
        builder.j0(q).Q(q2).e0(a);
        return new f(builder.E());
    }
    
    public static a d(final int n, final ParsableByteArray parsableByteArray) {
        if (n == 2) {
            return c(parsableByteArray);
        }
        if (n == 1) {
            return e(parsableByteArray);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Ignoring strf box for unsupported track type: ");
        sb.append(Util.m0(n));
        Log.i("StreamFormatChunk", sb.toString());
        return null;
    }
    
    private static a e(final ParsableByteArray parsableByteArray) {
        final int v = parsableByteArray.v();
        final String b = b(v);
        if (b == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring track with unsupported format tag ");
            sb.append(v);
            Log.i("StreamFormatChunk", sb.toString());
            return null;
        }
        final int v2 = parsableByteArray.v();
        final int q = parsableByteArray.q();
        parsableByteArray.Q(6);
        final int c0 = Util.c0(parsableByteArray.J());
        final int v3 = parsableByteArray.v();
        final byte[] array = new byte[v3];
        parsableByteArray.j(array, 0, v3);
        final Format.Builder builder = new Format.Builder();
        builder.e0(b).H(v2).f0(q);
        if ("audio/raw".equals(b) && c0 != 0) {
            builder.Y(c0);
        }
        if ("audio/mp4a-latm".equals(b) && v3 > 0) {
            builder.T((List<byte[]>)ImmutableList.of((Object)array));
        }
        return new f(builder.E());
    }
    
    @Override
    public int getType() {
        return 1718776947;
    }
}
