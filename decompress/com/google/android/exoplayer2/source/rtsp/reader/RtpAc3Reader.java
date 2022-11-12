// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;

public final class RtpAc3Reader implements RtpPayloadReader
{
    private final RtpPayloadFormat a;
    private final ParsableBitArray b;
    private TrackOutput c;
    private int d;
    private long e;
    private long f;
    private long g;
    
    public RtpAc3Reader(final RtpPayloadFormat a) {
        this.a = a;
        this.b = new ParsableBitArray();
        this.e = -9223372036854775807L;
    }
    
    private void e() {
        if (this.d > 0) {
            this.f();
        }
    }
    
    private void f() {
        Util.j(this.c).e(this.f, 1, this.d, 0, null);
        this.d = 0;
    }
    
    private void g(final ParsableByteArray parsableByteArray, final boolean b, final int n, final long f) {
        final int a = parsableByteArray.a();
        Assertions.e(this.c).c(parsableByteArray, a);
        this.d += a;
        this.f = f;
        if (b && n == 3) {
            this.f();
        }
    }
    
    private void h(final ParsableByteArray parsableByteArray, final int n, long n2) {
        this.b.n(parsableByteArray.d());
        this.b.s(2);
        for (int i = 0; i < n; ++i) {
            final Ac3Util.SyncFrameInfo e = Ac3Util.e(this.b);
            Assertions.e(this.c).c(parsableByteArray, e.e);
            Util.j(this.c).e(n2, 1, e.e, 0, null);
            n2 += e.f / e.c * 1000000L;
            this.b.s(e.e);
        }
    }
    
    private void i(final ParsableByteArray parsableByteArray, final long n) {
        final int a = parsableByteArray.a();
        Assertions.e(this.c).c(parsableByteArray, a);
        Util.j(this.c).e(n, 1, a, 0, null);
    }
    
    private static long j(final long n, final long n2, final long n3, final int n4) {
        return n + Util.O0(n2 - n3, 1000000L, n4);
    }
    
    @Override
    public void a(final long e, final long g) {
        this.e = e;
        this.g = g;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray, long j, int n, final boolean b) {
        n = (parsableByteArray.D() & 0x3);
        final int n2 = parsableByteArray.D() & 0xFF;
        j = j(this.g, j, this.e, this.a.b);
        if (n != 0) {
            if (n != 1 && n != 2) {
                if (n != 3) {
                    throw new IllegalArgumentException(String.valueOf(n));
                }
            }
            else {
                this.e();
            }
            this.g(parsableByteArray, b, n, j);
        }
        else {
            this.e();
            if (n2 == 1) {
                this.i(parsableByteArray, j);
            }
            else {
                this.h(parsableByteArray, n2, j);
            }
        }
    }
    
    @Override
    public void c(final ExtractorOutput extractorOutput, final int n) {
        (this.c = extractorOutput.e(n, 1)).d(this.a.c);
    }
    
    @Override
    public void d(final long e, final int n) {
        Assertions.g(this.e == -9223372036854775807L);
        this.e = e;
    }
}
