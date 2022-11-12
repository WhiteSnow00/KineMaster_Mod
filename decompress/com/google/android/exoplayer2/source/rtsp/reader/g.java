// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.Format;
import java.util.List;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;

final class g implements RtpPayloadReader
{
    private final RtpPayloadFormat a;
    private TrackOutput b;
    private long c;
    private long d;
    private int e;
    private boolean f;
    private boolean g;
    
    public g(final RtpPayloadFormat a) {
        this.a = a;
        this.c = -1L;
        this.e = -1;
    }
    
    private static long e(final long n, final long n2, final long n3) {
        return n + Util.O0(n2 - n3, 1000000L, 48000L);
    }
    
    private static void f(final ParsableByteArray parsableByteArray) {
        final int e = parsableByteArray.e();
        final int f = parsableByteArray.f();
        final boolean b = false;
        Assertions.b(f > 18, "ID Header has insufficient data");
        Assertions.b(parsableByteArray.A(8).equals("OpusHead"), "ID Header missing");
        boolean b2 = b;
        if (parsableByteArray.D() == 1) {
            b2 = true;
        }
        Assertions.b(b2, "version number must always be 1");
        parsableByteArray.P(e);
    }
    
    @Override
    public void a(final long c, final long d) {
        this.c = c;
        this.d = d;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray, long e, final int e2, final boolean b) {
        Assertions.i(this.b);
        if (!this.f) {
            f(parsableByteArray);
            final List<byte[]> a = OpusUtil.a(parsableByteArray.d());
            final Format.Builder b2 = this.a.c.b();
            b2.T(a);
            this.b.d(b2.E());
            this.f = true;
        }
        else {
            final boolean g = this.g;
            boolean b3 = false;
            if (!g) {
                if (parsableByteArray.f() >= 8) {
                    b3 = true;
                }
                Assertions.b(b3, "Comment Header has insufficient data");
                Assertions.b(parsableByteArray.A(8).equals("OpusTags"), "Comment Header should follow ID Header");
                this.g = true;
            }
            else {
                final int b4 = RtpPacket.b(this.e);
                if (e2 != b4) {
                    Log.i("RtpOpusReader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", b4, e2));
                }
                final int a2 = parsableByteArray.a();
                this.b.c(parsableByteArray, a2);
                e = e(this.d, e, this.c);
                this.b.e(e, 1, a2, 0, null);
            }
        }
        this.e = e2;
    }
    
    @Override
    public void c(final ExtractorOutput extractorOutput, final int n) {
        (this.b = extractorOutput.e(n, 1)).d(this.a.c);
    }
    
    @Override
    public void d(final long c, final int n) {
        this.c = c;
    }
}
