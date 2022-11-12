// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;

final class b implements RtpPayloadReader
{
    private static final int[] h;
    private static final int[] i;
    private final RtpPayloadFormat a;
    private final boolean b;
    private final int c;
    private TrackOutput d;
    private long e;
    private long f;
    private int g;
    
    static {
        h = new int[] { 13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1 };
        i = new int[] { 18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1 };
    }
    
    public b(final RtpPayloadFormat a) {
        this.a = a;
        this.b = "audio/amr-wb".equals(Assertions.e(a.c.w));
        this.c = a.b;
        this.e = -9223372036854775807L;
        this.g = -1;
        this.f = 0L;
    }
    
    public static int e(int n, final boolean b) {
        final boolean b2 = (n >= 0 && n <= 8) || n == 15;
        final StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        String s;
        if (b) {
            s = "WB";
        }
        else {
            s = "NB";
        }
        sb.append(s);
        sb.append(" frame type ");
        sb.append(n);
        Assertions.b(b2, sb.toString());
        if (b) {
            n = b.i[n];
        }
        else {
            n = b.h[n];
        }
        return n;
    }
    
    private static long f(final long n, final long n2, final long n3, final int n4) {
        return n + Util.O0(n2 - n3, 1000000L, n4);
    }
    
    @Override
    public void a(final long e, final long f) {
        this.e = e;
        this.f = f;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray, long f, final int g, final boolean b) {
        Assertions.i(this.d);
        final int g2 = this.g;
        boolean b2 = false;
        if (g2 != -1) {
            final int b3 = RtpPacket.b(g2);
            if (g != b3) {
                Log.i("RtpAmrReader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", b3, g));
            }
        }
        parsableByteArray.Q(1);
        final int e = e(parsableByteArray.h() >> 3 & 0xF, this.b);
        final int a = parsableByteArray.a();
        if (a == e) {
            b2 = true;
        }
        Assertions.b(b2, "compound payload not supported currently");
        this.d.c(parsableByteArray, a);
        f = f(this.f, f, this.e, this.c);
        this.d.e(f, 1, a, 0, null);
        this.g = g;
    }
    
    @Override
    public void c(final ExtractorOutput extractorOutput, final int n) {
        (this.d = extractorOutput.e(n, 1)).d(this.a.c);
    }
    
    @Override
    public void d(final long e, final int n) {
        this.e = e;
    }
}
