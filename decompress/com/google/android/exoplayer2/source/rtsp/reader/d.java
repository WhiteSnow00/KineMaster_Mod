// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class d implements RtpPayloadReader
{
    private final ParsableByteArray a;
    private final ParsableByteArray b;
    private final RtpPayloadFormat c;
    private TrackOutput d;
    private int e;
    private long f;
    private int g;
    private int h;
    private long i;
    
    public d(final RtpPayloadFormat c) {
        this.b = new ParsableByteArray(NalUnitUtil.a);
        this.c = c;
        this.a = new ParsableByteArray();
        this.f = -9223372036854775807L;
        this.g = -1;
    }
    
    private static int e(int n) {
        if (n == 5) {
            n = 1;
        }
        else {
            n = 0;
        }
        return n;
    }
    
    private void f(final ParsableByteArray parsableByteArray, int a) {
        final byte b = parsableByteArray.d()[0];
        final byte b2 = parsableByteArray.d()[1];
        final int n = (b & 0xE0) | (b2 & 0x1F);
        final boolean b3 = (b2 & 0x80) > 0;
        final boolean b4 = (b2 & 0x40) > 0;
        if (b3) {
            this.h += this.j();
            parsableByteArray.d()[1] = (byte)n;
            this.a.M(parsableByteArray.d());
            this.a.P(1);
        }
        else {
            final int b5 = RtpPacket.b(this.g);
            if (a != b5) {
                Log.i("RtpH264Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", b5, a));
                return;
            }
            this.a.M(parsableByteArray.d());
            this.a.P(2);
        }
        a = this.a.a();
        this.d.c(this.a, a);
        this.h += a;
        if (b4) {
            this.e = e(n & 0x1F);
        }
    }
    
    private void g(final ParsableByteArray parsableByteArray) {
        final int a = parsableByteArray.a();
        this.h += this.j();
        this.d.c(parsableByteArray, a);
        this.h += a;
        this.e = e(parsableByteArray.d()[0] & 0x1F);
    }
    
    private void h(final ParsableByteArray parsableByteArray) {
        parsableByteArray.D();
        while (parsableByteArray.a() > 4) {
            final int j = parsableByteArray.J();
            this.h += this.j();
            this.d.c(parsableByteArray, j);
            this.h += j;
        }
        this.e = 0;
    }
    
    private static long i(final long n, final long n2, final long n3) {
        return n + Util.O0(n2 - n3, 1000000L, 90000L);
    }
    
    private int j() {
        this.b.P(0);
        final int a = this.b.a();
        Assertions.e(this.d).c(this.b, a);
        return a;
    }
    
    @Override
    public void a(final long f, final long i) {
        this.f = f;
        this.h = 0;
        this.i = i;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray, long i, final int g, final boolean b) throws ParserException {
        try {
            final int n = parsableByteArray.d()[0] & 0x1F;
            Assertions.i(this.d);
            if (n > 0 && n < 24) {
                this.g(parsableByteArray);
            }
            else if (n == 24) {
                this.h(parsableByteArray);
            }
            else {
                if (n != 28) {
                    throw ParserException.createForMalformedManifest(String.format("RTP H264 packetization mode [%d] not supported.", n), null);
                }
                this.f(parsableByteArray, g);
            }
            if (b) {
                if (this.f == -9223372036854775807L) {
                    this.f = i;
                }
                i = i(this.i, i, this.f);
                this.d.e(i, this.e, this.h, 0, null);
                this.h = 0;
            }
            this.g = g;
        }
        catch (final IndexOutOfBoundsException ex) {
            throw ParserException.createForMalformedManifest(null, ex);
        }
    }
    
    @Override
    public void c(final ExtractorOutput extractorOutput, final int n) {
        final TrackOutput e = extractorOutput.e(n, 2);
        this.d = e;
        Util.j(e).d(this.c.c);
    }
    
    @Override
    public void d(final long n, final int n2) {
    }
}
