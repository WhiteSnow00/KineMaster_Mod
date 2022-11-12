// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class c extends TagPayloadReader
{
    private final ParsableByteArray b;
    private final ParsableByteArray c;
    private int d;
    private boolean e;
    private boolean f;
    private int g;
    
    public c(final TrackOutput trackOutput) {
        super(trackOutput);
        this.b = new ParsableByteArray(NalUnitUtil.a);
        this.c = new ParsableByteArray(4);
    }
    
    @Override
    protected boolean b(final ParsableByteArray parsableByteArray) throws UnsupportedFormatException {
        final int d = parsableByteArray.D();
        final int g = d >> 4 & 0xF;
        final int n = d & 0xF;
        if (n == 7) {
            this.g = g;
            return g != 5;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Video format not supported: ");
        sb.append(n);
        throw new UnsupportedFormatException(sb.toString());
    }
    
    @Override
    protected boolean c(final ParsableByteArray parsableByteArray, final long n) throws ParserException {
        final int d = parsableByteArray.D();
        final long n2 = parsableByteArray.o();
        if (d == 0 && !this.e) {
            final ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.a()]);
            parsableByteArray.j(parsableByteArray2.d(), 0, parsableByteArray.a());
            final AvcConfig b = AvcConfig.b(parsableByteArray2);
            this.d = b.b;
            super.a.d(new Format.Builder().e0("video/avc").I(b.f).j0(b.c).Q(b.d).a0(b.e).T(b.a).E());
            this.e = true;
            return false;
        }
        if (d != 1 || !this.e) {
            return false;
        }
        int n3;
        if (this.g == 1) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        if (!this.f && n3 == 0) {
            return false;
        }
        final byte[] d2 = this.c.d();
        d2[0] = 0;
        d2[2] = (d2[1] = 0);
        final int d3 = this.d;
        int n4 = 0;
        while (parsableByteArray.a() > 0) {
            parsableByteArray.j(this.c.d(), 4 - d3, this.d);
            this.c.P(0);
            final int h = this.c.H();
            this.b.P(0);
            super.a.c(this.b, 4);
            super.a.c(parsableByteArray, h);
            n4 = n4 + 4 + h;
        }
        super.a.e(n + n2 * 1000L, n3, n4, 0, null);
        return this.f = true;
    }
}
