// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Bytes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;

final class f implements RtpPayloadReader
{
    private final RtpPayloadFormat a;
    private TrackOutput b;
    private int c;
    private long d;
    private int e;
    private long f;
    private int g;
    
    public f(final RtpPayloadFormat a) {
        this.a = a;
        this.d = -9223372036854775807L;
        this.e = -1;
        this.g = 0;
    }
    
    private static int e(final ParsableByteArray parsableByteArray) {
        final int a = Bytes.a(parsableByteArray.d(), new byte[] { 0, 0, 1, -74 });
        int n = 0;
        if (a != -1) {
            parsableByteArray.P(a + 4);
            n = n;
            if (parsableByteArray.h() >> 6 == 0) {
                n = 1;
            }
        }
        return n;
    }
    
    private static long f(final long n, final long n2, final long n3) {
        return n + Util.O0(n2 - n3, 1000000L, 90000L);
    }
    
    @Override
    public void a(final long d, final long f) {
        this.d = d;
        this.f = f;
        this.g = 0;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray, long f, final int e, final boolean b) {
        Assertions.i(this.b);
        final int e2 = this.e;
        if (e2 != -1) {
            final int b2 = RtpPacket.b(e2);
            if (e != b2) {
                Log.i("RtpMpeg4Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", b2, e));
            }
        }
        final int a = parsableByteArray.a();
        this.b.c(parsableByteArray, a);
        if (this.g == 0) {
            this.c = e(parsableByteArray);
        }
        this.g += a;
        if (b) {
            if (this.d == -9223372036854775807L) {
                this.d = f;
            }
            f = f(this.f, f, this.d);
            this.b.e(f, this.c, this.g, 0, null);
            this.g = 0;
        }
        this.e = e;
    }
    
    @Override
    public void c(final ExtractorOutput extractorOutput, final int n) {
        final TrackOutput e = extractorOutput.e(n, 2);
        this.b = e;
        Util.j(e).d(this.a.c);
    }
    
    @Override
    public void d(final long n, final int n2) {
    }
}
