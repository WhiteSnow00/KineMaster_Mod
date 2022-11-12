// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;

final class a implements RtpPayloadReader
{
    private final RtpPayloadFormat a;
    private final ParsableBitArray b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private long g;
    private TrackOutput h;
    private long i;
    
    public a(final RtpPayloadFormat a) {
        this.a = a;
        this.b = new ParsableBitArray();
        this.c = a.b;
        final String s = Assertions.e(a.d.get((Object)"mode"));
        if (Ascii.a((CharSequence)s, (CharSequence)"AAC-hbr")) {
            this.d = 13;
            this.e = 3;
        }
        else {
            if (!Ascii.a((CharSequence)s, (CharSequence)"AAC-lbr")) {
                throw new UnsupportedOperationException("AAC mode not supported");
            }
            this.d = 6;
            this.e = 2;
        }
        this.f = this.e + this.d;
    }
    
    private static void e(final TrackOutput trackOutput, final long n, final int n2) {
        trackOutput.e(n, 1, n2, 0, null);
    }
    
    private static long f(final long n, final long n2, final long n3, final int n4) {
        return n + Util.O0(n2 - n3, 1000000L, n4);
    }
    
    @Override
    public void a(final long g, final long i) {
        this.g = g;
        this.i = i;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray, long f, int i, final boolean b) {
        Assertions.e(this.h);
        i = parsableByteArray.z();
        final int n = i / this.f;
        f = f(this.i, f, this.g, this.c);
        this.b.m(parsableByteArray);
        if (n == 1) {
            i = this.b.h(this.d);
            this.b.r(this.e);
            this.h.c(parsableByteArray, parsableByteArray.a());
            if (b) {
                e(this.h, f, i);
            }
        }
        else {
            parsableByteArray.Q((i + 7) / 8);
            int h;
            for (i = 0; i < n; ++i) {
                h = this.b.h(this.d);
                this.b.r(this.e);
                this.h.c(parsableByteArray, h);
                e(this.h, f, h);
                f += Util.O0(n, 1000000L, this.c);
            }
        }
    }
    
    @Override
    public void c(final ExtractorOutput extractorOutput, final int n) {
        (this.h = extractorOutput.e(n, 1)).d(this.a.c);
    }
    
    @Override
    public void d(final long g, final int n) {
        this.g = g;
    }
}
