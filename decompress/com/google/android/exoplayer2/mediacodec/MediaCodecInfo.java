// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo$AudioCapabilities;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import android.media.MediaCodecInfo$CodecProfileLevel;
import android.graphics.Point;
import android.media.MediaCodecInfo$VideoCapabilities;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Assertions;
import android.media.MediaCodecInfo$CodecCapabilities;

public final class MediaCodecInfo
{
    public final String a;
    public final String b;
    public final String c;
    public final MediaCodecInfo$CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    private final boolean k;
    
    MediaCodecInfo(final String s, final String b, final String c, final MediaCodecInfo$CodecCapabilities d, final boolean h, final boolean i, final boolean j, final boolean e, final boolean f, final boolean g) {
        this.a = Assertions.e(s);
        this.b = b;
        this.c = c;
        this.d = d;
        this.h = h;
        this.i = i;
        this.j = j;
        this.e = e;
        this.f = f;
        this.g = g;
        this.k = MimeTypes.s(b);
    }
    
    private static boolean A(String b, final int n) {
        if ("video/hevc".equals(b) && 2 == n) {
            b = Util.b;
            if ("sailfish".equals(b) || "marlin".equals(b)) {
                return true;
            }
        }
        return false;
    }
    
    private static final boolean B(final String s) {
        return !"OMX.MTK.VIDEO.DECODER.HEVC".equals(s) || !"mcv5a".equals(Util.b);
    }
    
    public static MediaCodecInfo C(final String s, final String s2, final String s3, final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5) {
        return new MediaCodecInfo(s, s2, s3, mediaCodecInfo$CodecCapabilities, b, b2, b3, !b4 && mediaCodecInfo$CodecCapabilities != null && h(mediaCodecInfo$CodecCapabilities) && !z(s), mediaCodecInfo$CodecCapabilities != null && s(mediaCodecInfo$CodecCapabilities), b5 || (mediaCodecInfo$CodecCapabilities != null && q(mediaCodecInfo$CodecCapabilities)));
    }
    
    private static int a(final String s, final String s2, final int n) {
        if (n <= 1) {
            if (Util.a < 26 || n <= 0) {
                if (!"audio/mpeg".equals(s2) && !"audio/3gpp".equals(s2) && !"audio/amr-wb".equals(s2) && !"audio/mp4a-latm".equals(s2) && !"audio/vorbis".equals(s2) && !"audio/opus".equals(s2) && !"audio/raw".equals(s2) && !"audio/flac".equals(s2) && !"audio/g711-alaw".equals(s2) && !"audio/g711-mlaw".equals(s2)) {
                    if (!"audio/gsm".equals(s2)) {
                        int n2;
                        if ("audio/ac3".equals(s2)) {
                            n2 = 6;
                        }
                        else if ("audio/eac3".equals(s2)) {
                            n2 = 16;
                        }
                        else {
                            n2 = 30;
                        }
                        final StringBuilder sb = new StringBuilder();
                        sb.append("AssumedMaxChannelAdjustment: ");
                        sb.append(s);
                        sb.append(", [");
                        sb.append(n);
                        sb.append(" to ");
                        sb.append(n2);
                        sb.append("]");
                        Log.i("MediaCodecInfo", sb.toString());
                        return n2;
                    }
                }
            }
        }
        return n;
    }
    
    private static Point c(final MediaCodecInfo$VideoCapabilities mediaCodecInfo$VideoCapabilities, final int n, final int n2) {
        final int widthAlignment = mediaCodecInfo$VideoCapabilities.getWidthAlignment();
        final int heightAlignment = mediaCodecInfo$VideoCapabilities.getHeightAlignment();
        return new Point(Util.l(n, widthAlignment) * widthAlignment, Util.l(n2, heightAlignment) * heightAlignment);
    }
    
    private static boolean d(final MediaCodecInfo$VideoCapabilities mediaCodecInfo$VideoCapabilities, int y, int x, final double n) {
        final Point c = c(mediaCodecInfo$VideoCapabilities, y, x);
        x = c.x;
        y = c.y;
        if (n != -1.0 && n >= 1.0) {
            return mediaCodecInfo$VideoCapabilities.areSizeAndRateSupported(x, y, Math.floor(n));
        }
        return mediaCodecInfo$VideoCapabilities.isSizeSupported(x, y);
    }
    
    private static MediaCodecInfo$CodecProfileLevel[] f(final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        int intValue = 0;
        Label_0032: {
            if (mediaCodecInfo$CodecCapabilities != null) {
                final MediaCodecInfo$VideoCapabilities videoCapabilities = mediaCodecInfo$CodecCapabilities.getVideoCapabilities();
                if (videoCapabilities != null) {
                    intValue = (int)videoCapabilities.getBitrateRange().getUpper();
                    break Label_0032;
                }
            }
            intValue = 0;
        }
        int level;
        if (intValue >= 180000000) {
            level = 1024;
        }
        else if (intValue >= 120000000) {
            level = 512;
        }
        else if (intValue >= 60000000) {
            level = 256;
        }
        else if (intValue >= 30000000) {
            level = 128;
        }
        else if (intValue >= 18000000) {
            level = 64;
        }
        else if (intValue >= 12000000) {
            level = 32;
        }
        else if (intValue >= 7200000) {
            level = 16;
        }
        else if (intValue >= 3600000) {
            level = 8;
        }
        else if (intValue >= 1800000) {
            level = 4;
        }
        else if (intValue >= 800000) {
            level = 2;
        }
        else {
            level = 1;
        }
        final MediaCodecInfo$CodecProfileLevel mediaCodecInfo$CodecProfileLevel = new MediaCodecInfo$CodecProfileLevel();
        mediaCodecInfo$CodecProfileLevel.profile = 1;
        mediaCodecInfo$CodecProfileLevel.level = level;
        return new MediaCodecInfo$CodecProfileLevel[] { mediaCodecInfo$CodecProfileLevel };
    }
    
    private static boolean h(final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return Util.a >= 19 && i(mediaCodecInfo$CodecCapabilities);
    }
    
    private static boolean i(final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return mediaCodecInfo$CodecCapabilities.isFeatureSupported("adaptive-playback");
    }
    
    private boolean l(final Format format) {
        if (format.i == null) {
            return true;
        }
        final Pair<Integer, Integer> q = MediaCodecUtil.q(format);
        if (q == null) {
            return true;
        }
        final int intValue = (int)q.first;
        int intValue2 = (int)q.second;
        int n = intValue;
        Label_0111: {
            if ("video/dolby-vision".equals(format.w)) {
                if ("video/avc".equals(this.b)) {
                    n = 8;
                }
                else {
                    intValue2 = intValue2;
                    n = intValue;
                    if (!"video/hevc".equals(this.b)) {
                        break Label_0111;
                    }
                    n = 2;
                }
                intValue2 = 0;
            }
        }
        if (!this.k && n != 42) {
            return true;
        }
        MediaCodecInfo$CodecProfileLevel[] array2;
        final MediaCodecInfo$CodecProfileLevel[] array = array2 = this.g();
        if (Util.a <= 23) {
            array2 = array;
            if ("video/x-vnd.on2.vp9".equals(this.b)) {
                array2 = array;
                if (array.length == 0) {
                    array2 = f(this.d);
                }
            }
        }
        for (final MediaCodecInfo$CodecProfileLevel mediaCodecInfo$CodecProfileLevel : array2) {
            if (mediaCodecInfo$CodecProfileLevel.profile == n && mediaCodecInfo$CodecProfileLevel.level >= intValue2 && !A(this.b, n)) {
                return true;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("codec.profileLevel, ");
        sb.append(format.i);
        sb.append(", ");
        sb.append(this.c);
        this.w(sb.toString());
        return false;
    }
    
    private boolean o(final Format format) {
        return this.b.equals(format.w) || this.b.equals(MediaCodecUtil.m(format));
    }
    
    private static boolean q(final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return Util.a >= 21 && r(mediaCodecInfo$CodecCapabilities);
    }
    
    private static boolean r(final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return mediaCodecInfo$CodecCapabilities.isFeatureSupported("secure-playback");
    }
    
    private static boolean s(final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return Util.a >= 21 && t(mediaCodecInfo$CodecCapabilities);
    }
    
    private static boolean t(final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return mediaCodecInfo$CodecCapabilities.isFeatureSupported("tunneled-playback");
    }
    
    private void v(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("AssumedSupport [");
        sb.append(s);
        sb.append("] [");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append("] [");
        sb.append(Util.e);
        sb.append("]");
        Log.b("MediaCodecInfo", sb.toString());
    }
    
    private void w(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("NoSupport [");
        sb.append(s);
        sb.append("] [");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append("] [");
        sb.append(Util.e);
        sb.append("]");
        Log.b("MediaCodecInfo", sb.toString());
    }
    
    private static boolean x(final String s) {
        return "audio/opus".equals(s);
    }
    
    private static boolean y(final String s) {
        return Util.d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(s);
    }
    
    private static boolean z(final String s) {
        if (Util.a <= 22) {
            final String d = Util.d;
            if (("ODROID-XU3".equals(d) || "Nexus 10".equals(d)) && ("OMX.Exynos.AVC.Decoder".equals(s) || "OMX.Exynos.AVC.Decoder.secure".equals(s))) {
                return true;
            }
        }
        return false;
    }
    
    public Point b(final int n, final int n2) {
        final MediaCodecInfo$CodecCapabilities d = this.d;
        if (d == null) {
            return null;
        }
        final MediaCodecInfo$VideoCapabilities videoCapabilities = d.getVideoCapabilities();
        if (videoCapabilities == null) {
            return null;
        }
        return c(videoCapabilities, n, n2);
    }
    
    public DecoderReuseEvaluation e(final Format format, final Format format2) {
        int n;
        if (!Util.c(format.w, format2.w)) {
            n = 8;
        }
        else {
            n = 0;
        }
        int n6;
        if (this.k) {
            int n2 = n;
            if (format.E != format2.E) {
                n2 = (n | 0x400);
            }
            int n3 = n2;
            Label_0095: {
                if (!this.e) {
                    if (format.B == format2.B) {
                        n3 = n2;
                        if (format.C == format2.C) {
                            break Label_0095;
                        }
                    }
                    n3 = (n2 | 0x200);
                }
            }
            int n4 = n3;
            if (!Util.c(format.I, format2.I)) {
                n4 = (n3 | 0x800);
            }
            int n5 = n4;
            if (y(this.a)) {
                n5 = n4;
                if (!format.g(format2)) {
                    n5 = (n4 | 0x2);
                }
            }
            if ((n6 = n5) == 0) {
                final String a = this.a;
                int n7;
                if (format.g(format2)) {
                    n7 = 3;
                }
                else {
                    n7 = 2;
                }
                return new DecoderReuseEvaluation(a, format, format2, n7, 0);
            }
        }
        else {
            int n8 = n;
            if (format.J != format2.J) {
                n8 = (n | 0x1000);
            }
            int n9 = n8;
            if (format.K != format2.K) {
                n9 = (n8 | 0x2000);
            }
            int n10 = n9;
            if (format.L != format2.L) {
                n10 = (n9 | 0x4000);
            }
            if (n10 == 0 && "audio/mp4a-latm".equals(this.b)) {
                final Pair<Integer, Integer> q = MediaCodecUtil.q(format);
                final Pair<Integer, Integer> q2 = MediaCodecUtil.q(format2);
                if (q != null && q2 != null) {
                    final int intValue = (int)q.first;
                    final int intValue2 = (int)q2.first;
                    if (intValue == 42 && intValue2 == 42) {
                        return new DecoderReuseEvaluation(this.a, format, format2, 3, 0);
                    }
                }
            }
            int n11 = n10;
            if (!format.g(format2)) {
                n11 = (n10 | 0x20);
            }
            int n12 = n11;
            if (x(this.b)) {
                n12 = (n11 | 0x2);
            }
            if ((n6 = n12) == 0) {
                return new DecoderReuseEvaluation(this.a, format, format2, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.a, format, format2, 0, n6);
    }
    
    public MediaCodecInfo$CodecProfileLevel[] g() {
        final MediaCodecInfo$CodecCapabilities d = this.d;
        MediaCodecInfo$CodecProfileLevel[] profileLevels;
        if (d == null || (profileLevels = d.profileLevels) == null) {
            profileLevels = new MediaCodecInfo$CodecProfileLevel[0];
        }
        return profileLevels;
    }
    
    public boolean j(final int n) {
        final MediaCodecInfo$CodecCapabilities d = this.d;
        if (d == null) {
            this.w("channelCount.caps");
            return false;
        }
        final MediaCodecInfo$AudioCapabilities audioCapabilities = d.getAudioCapabilities();
        if (audioCapabilities == null) {
            this.w("channelCount.aCaps");
            return false;
        }
        if (a(this.a, this.b, audioCapabilities.getMaxInputChannelCount()) < n) {
            final StringBuilder sb = new StringBuilder();
            sb.append("channelCount.support, ");
            sb.append(n);
            this.w(sb.toString());
            return false;
        }
        return true;
    }
    
    public boolean k(final int n) {
        final MediaCodecInfo$CodecCapabilities d = this.d;
        if (d == null) {
            this.w("sampleRate.caps");
            return false;
        }
        final MediaCodecInfo$AudioCapabilities audioCapabilities = d.getAudioCapabilities();
        if (audioCapabilities == null) {
            this.w("sampleRate.aCaps");
            return false;
        }
        if (!audioCapabilities.isSampleRateSupported(n)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("sampleRate.support, ");
            sb.append(n);
            this.w(sb.toString());
            return false;
        }
        return true;
    }
    
    public boolean m(final Format format) throws MediaCodecUtil.DecoderQueryException {
        final boolean o = this.o(format);
        final boolean b = false;
        boolean b2 = false;
        if (!o) {
            return false;
        }
        if (!this.l(format)) {
            return false;
        }
        if (this.k) {
            final int b3 = format.B;
            if (b3 > 0) {
                final int c = format.C;
                if (c > 0) {
                    if (Util.a >= 21) {
                        return this.u(b3, c, format.D);
                    }
                    if (b3 * c <= MediaCodecUtil.N()) {
                        b2 = true;
                    }
                    if (!b2) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("legacyFrameSize, ");
                        sb.append(format.B);
                        sb.append("x");
                        sb.append(format.C);
                        this.w(sb.toString());
                    }
                    return b2;
                }
            }
            return true;
        }
        if (Util.a >= 21) {
            final int k = format.K;
            if (k != -1) {
                final boolean b4 = b;
                if (!this.k(k)) {
                    return b4;
                }
            }
            final int j = format.J;
            if (j != -1) {
                final boolean b4 = b;
                if (!this.j(j)) {
                    return b4;
                }
            }
        }
        return true;
    }
    
    public boolean n() {
        if (Util.a >= 29 && "video/x-vnd.on2.vp9".equals(this.b)) {
            final MediaCodecInfo$CodecProfileLevel[] g = this.g();
            for (int length = g.length, i = 0; i < length; ++i) {
                if (g[i].profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean p(final Format format) {
        if (this.k) {
            return this.e;
        }
        final Pair<Integer, Integer> q = MediaCodecUtil.q(format);
        return q != null && (int)q.first == 42;
    }
    
    @Override
    public String toString() {
        return this.a;
    }
    
    public boolean u(final int n, final int n2, final double n3) {
        final MediaCodecInfo$CodecCapabilities d = this.d;
        if (d == null) {
            this.w("sizeAndRate.caps");
            return false;
        }
        final MediaCodecInfo$VideoCapabilities videoCapabilities = d.getVideoCapabilities();
        if (videoCapabilities == null) {
            this.w("sizeAndRate.vCaps");
            return false;
        }
        if (!d(videoCapabilities, n, n2, n3)) {
            if (n >= n2 || !B(this.a) || !d(videoCapabilities, n2, n, n3)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("sizeAndRate.support, ");
                sb.append(n);
                sb.append("x");
                sb.append(n2);
                sb.append("x");
                sb.append(n3);
                this.w(sb.toString());
                return false;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("sizeAndRate.rotated, ");
            sb2.append(n);
            sb2.append("x");
            sb2.append(n2);
            sb2.append("x");
            sb2.append(n3);
            this.v(sb2.toString());
        }
        return true;
    }
}
