// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;

final class h implements RtpPayloadReader
{
    private final RtpPayloadFormat a;
    private TrackOutput b;
    private long c;
    private int d;
    private int e;
    private long f;
    private long g;
    private boolean h;
    private boolean i;
    private boolean j;
    
    public h(final RtpPayloadFormat a) {
        this.a = a;
        this.c = -9223372036854775807L;
        this.d = -1;
        this.e = -1;
        this.f = -9223372036854775807L;
        this.g = 0L;
        this.h = false;
        this.i = false;
        this.j = false;
    }
    
    private void e() {
        Assertions.e(this.b).e(this.f, this.i ? 1 : 0, this.e, 0, null);
        this.e = 0;
        this.f = -9223372036854775807L;
        this.h = false;
    }
    
    private static long f(final long n, final long n2, final long n3) {
        return n + Util.O0(n2 - n3, 1000000L, 90000L);
    }
    
    private boolean g(final ParsableByteArray parsableByteArray, int d) {
        final int d2 = parsableByteArray.D();
        if ((d2 & 0x10) == 0x10 && (d2 & 0x7) == 0x0) {
            if (this.h && this.e > 0) {
                this.e();
            }
            this.h = true;
        }
        else {
            if (!this.h) {
                Log.i("RtpVP8Reader", "RTP packet is not the start of a new VP8 partition, skipping.");
                return false;
            }
            final int b = RtpPacket.b(this.d);
            if (d < b) {
                Log.i("RtpVP8Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", b, d));
                return false;
            }
        }
        if ((d2 & 0x80) != 0x0) {
            d = parsableByteArray.D();
            if ((d & 0x80) != 0x0 && (parsableByteArray.D() & 0x80) != 0x0) {
                parsableByteArray.Q(1);
            }
            if ((d & 0x40) != 0x0) {
                parsableByteArray.Q(1);
            }
            if ((d & 0x20) != 0x0 || (d & 0x10) != 0x0) {
                parsableByteArray.Q(1);
            }
        }
        return true;
    }
    
    @Override
    public void a(final long c, final long g) {
        this.c = c;
        this.e = -1;
        this.g = g;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray, final long n, final int d, final boolean b) {
        Assertions.i(this.b);
        if (this.g(parsableByteArray, d)) {
            if (this.e == -1 && this.h) {
                this.i = ((parsableByteArray.h() & 0x1) == 0x0);
            }
            if (!this.j) {
                final int e = parsableByteArray.e();
                parsableByteArray.P(e + 6);
                final int n2 = parsableByteArray.v() & 0x3FFF;
                final int n3 = parsableByteArray.v() & 0x3FFF;
                parsableByteArray.P(e);
                final Format c = this.a.c;
                if (n2 != c.B || n3 != c.C) {
                    this.b.d(c.b().j0(n2).Q(n3).E());
                }
                this.j = true;
            }
            final int a = parsableByteArray.a();
            this.b.c(parsableByteArray, a);
            final int e2 = this.e;
            if (e2 == -1) {
                this.e = a;
            }
            else {
                this.e = e2 + a;
            }
            this.f = f(this.g, n, this.c);
            if (b) {
                this.e();
            }
            this.d = d;
        }
    }
    
    @Override
    public void c(final ExtractorOutput extractorOutput, final int n) {
        (this.b = extractorOutput.e(n, 2)).d(this.a.c);
    }
    
    @Override
    public void d(final long c, final int n) {
        Assertions.g(this.c == -9223372036854775807L);
        this.c = c;
    }
}
