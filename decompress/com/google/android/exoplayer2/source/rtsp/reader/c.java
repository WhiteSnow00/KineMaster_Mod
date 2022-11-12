// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;

final class c implements RtpPayloadReader
{
    private final RtpPayloadFormat a;
    private TrackOutput b;
    private long c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    
    public c(final RtpPayloadFormat a) {
        this.a = a;
        this.c = -9223372036854775807L;
        this.e = -1;
    }
    
    private void e(final ParsableByteArray parsableByteArray, final boolean b) {
        final int e = parsableByteArray.e();
        final long f = parsableByteArray.F();
        final boolean b2 = false;
        if ((f >> 10 & 0x3FL) == 0x20L) {
            final int h = parsableByteArray.h();
            final int n = h >> 1 & 0x1;
            if (!b && n == 0) {
                int n2 = h >> 2 & 0x7;
                if (n2 == 1) {
                    this.f = 128;
                    this.g = 96;
                }
                else {
                    n2 -= 2;
                    this.f = 176 << n2;
                    this.g = 144 << n2;
                }
            }
            parsableByteArray.P(e);
            boolean h2 = b2;
            if (n == 0) {
                h2 = true;
            }
            this.h = h2;
            return;
        }
        parsableByteArray.P(e);
        this.h = false;
    }
    
    private static long f(final long n, final long n2, final long n3) {
        return n + Util.O0(n2 - n3, 1000000L, 90000L);
    }
    
    @Override
    public void a(final long c, final long j) {
        this.c = c;
        this.d = 0;
        this.j = j;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray, long f, final int e, final boolean b) {
        Assertions.i(this.b);
        final int e2 = parsableByteArray.e();
        final int j = parsableByteArray.J();
        final boolean b2 = (j & 0x400) > 0;
        if ((j & 0x200) == 0x0 && (j & 0x1F8) == 0x0 && (j & 0x7) == 0x0) {
            if (b2) {
                if ((parsableByteArray.h() & 0xFC) < 128) {
                    Log.i("RtpH263Reader", "Picture start Code (PSC) missing, dropping packet.");
                    return;
                }
                parsableByteArray.d()[e2] = 0;
                parsableByteArray.d()[e2 + 1] = 0;
                parsableByteArray.P(e2);
            }
            else {
                final int b3 = RtpPacket.b(this.e);
                if (e != b3) {
                    Log.i("RtpH263Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", b3, e));
                    return;
                }
            }
            if (this.d == 0) {
                this.e(parsableByteArray, this.i);
                if (!this.i && this.h) {
                    final int f2 = this.f;
                    final Format c = this.a.c;
                    if (f2 != c.B || this.g != c.C) {
                        this.b.d(c.b().j0(this.f).Q(this.g).E());
                    }
                    this.i = true;
                }
            }
            final int a = parsableByteArray.a();
            this.b.c(parsableByteArray, a);
            this.d += a;
            if (b) {
                if (this.c == -9223372036854775807L) {
                    this.c = f;
                }
                f = f(this.j, f, this.c);
                this.b.e(f, this.h ? 1 : 0, this.d, 0, null);
                this.d = 0;
                this.h = false;
            }
            this.e = e;
            return;
        }
        Log.i("RtpH263Reader", "Dropping packet: video reduncancy coding is not supported, packet header VRC, or PLEN or PEBIT is non-zero");
    }
    
    @Override
    public void c(final ExtractorOutput extractorOutput, final int n) {
        (this.b = extractorOutput.e(n, 2)).d(this.a.c);
    }
    
    @Override
    public void d(final long n, final int n2) {
    }
}
