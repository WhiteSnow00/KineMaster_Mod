// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class e implements RtpPayloadReader
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
    
    public e(final RtpPayloadFormat c) {
        this.a = new ParsableByteArray();
        this.b = new ParsableByteArray(NalUnitUtil.a);
        this.c = c;
        this.f = -9223372036854775807L;
        this.g = -1;
    }
    
    private static int e(int n) {
        if (n != 19 && n != 20) {
            n = 0;
        }
        else {
            n = 1;
        }
        return n;
    }
    
    private void f(final ParsableByteArray parsableByteArray, int a) throws ParserException {
        if (parsableByteArray.d().length >= 3) {
            final byte b = parsableByteArray.d()[1];
            final byte b2 = parsableByteArray.d()[2];
            final int n = b2 & 0x3F;
            final boolean b3 = (b2 & 0x80) > 0;
            final boolean b4 = (b2 & 0x40) > 0;
            if (b3) {
                this.h += this.i();
                parsableByteArray.d()[1] = (byte)(n << 1 & 0x7F);
                parsableByteArray.d()[2] = (byte)(b & 0x7);
                this.a.M(parsableByteArray.d());
                this.a.P(1);
            }
            else {
                final int n2 = (this.g + 1) % 65535;
                if (a != n2) {
                    Log.i("RtpH265Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", n2, a));
                    return;
                }
                this.a.M(parsableByteArray.d());
                this.a.P(3);
            }
            a = this.a.a();
            this.d.c(this.a, a);
            this.h += a;
            if (b4) {
                this.e = e(n);
            }
            return;
        }
        throw ParserException.createForMalformedManifest("Malformed FU header.", null);
    }
    
    private void g(final ParsableByteArray parsableByteArray) {
        final int a = parsableByteArray.a();
        this.h += this.i();
        this.d.c(parsableByteArray, a);
        this.h += a;
        this.e = e(parsableByteArray.d()[0] >> 1 & 0x3F);
    }
    
    private static long h(final long n, final long n2, final long n3) {
        return n + Util.O0(n2 - n3, 1000000L, 90000L);
    }
    
    private int i() {
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
    public void b(final ParsableByteArray parsableByteArray, long h, final int g, final boolean b) throws ParserException {
        if (parsableByteArray.d().length != 0) {
            final int n = parsableByteArray.d()[0] >> 1 & 0x3F;
            Assertions.i(this.d);
            if (n >= 0 && n < 48) {
                this.g(parsableByteArray);
            }
            else {
                if (n == 48) {
                    throw new UnsupportedOperationException("need to implement processAggregationPacket");
                }
                if (n != 49) {
                    throw ParserException.createForMalformedManifest(String.format("RTP H265 payload type [%d] not supported.", n), null);
                }
                this.f(parsableByteArray, g);
            }
            if (b) {
                if (this.f == -9223372036854775807L) {
                    this.f = h;
                }
                h = h(this.i, h, this.f);
                this.d.e(h, this.e, this.h, 0, null);
                this.h = 0;
            }
            this.g = g;
            return;
        }
        throw ParserException.createForMalformedManifest("Empty RTP data packet.", null);
    }
    
    @Override
    public void c(final ExtractorOutput extractorOutput, final int n) {
        (this.d = extractorOutput.e(n, 2)).d(this.c.c);
    }
    
    @Override
    public void d(final long n, final int n2) {
    }
}
