// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class d
{
    public int a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public final int[] j;
    private final ParsableByteArray k;
    
    d() {
        this.j = new int[255];
        this.k = new ParsableByteArray(255);
    }
    
    public boolean a(final ExtractorInput extractorInput, final boolean b) throws IOException {
        this.b();
        this.k.L(27);
        final byte[] d = this.k.d();
        int i = 0;
        if (!ExtractorUtil.b(extractorInput, d, 0, 27, b) || this.k.F() != 1332176723L) {
            return false;
        }
        if ((this.a = this.k.D()) != 0) {
            if (b) {
                return false;
            }
            throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
        }
        else {
            this.b = this.k.D();
            this.c = this.k.r();
            this.d = this.k.t();
            this.e = this.k.t();
            this.f = this.k.t();
            final int d2 = this.k.D();
            this.g = d2;
            this.h = d2 + 27;
            this.k.L(d2);
            if (!ExtractorUtil.b(extractorInput, this.k.d(), 0, this.g, b)) {
                return false;
            }
            while (i < this.g) {
                this.j[i] = this.k.D();
                this.i += this.j[i];
                ++i;
            }
            return true;
        }
    }
    
    public void b() {
        this.a = 0;
        this.b = 0;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }
    
    public boolean c(final ExtractorInput extractorInput) throws IOException {
        return this.d(extractorInput, -1L);
    }
    
    public boolean d(final ExtractorInput extractorInput, final long n) throws IOException {
        Assertions.a(extractorInput.getPosition() == extractorInput.k());
        this.k.L(4);
        long n2;
        while (true) {
            n2 = lcmp(n, -1L);
            if ((n2 != 0 && extractorInput.getPosition() + 4L >= n) || !ExtractorUtil.b(extractorInput, this.k.d(), 0, 4, true)) {
                break;
            }
            this.k.P(0);
            if (this.k.F() == 1332176723L) {
                extractorInput.h();
                return true;
            }
            extractorInput.o(1);
        }
        while ((n2 == 0 || extractorInput.getPosition() < n) && extractorInput.a(1) != -1) {}
        return false;
    }
}
