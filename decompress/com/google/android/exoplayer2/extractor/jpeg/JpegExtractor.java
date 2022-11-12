// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.Extractor;

public final class JpegExtractor implements Extractor
{
    private final ParsableByteArray a;
    private ExtractorOutput b;
    private int c;
    private int d;
    private int e;
    private long f;
    private MotionPhotoMetadata g;
    private ExtractorInput h;
    private a i;
    private Mp4Extractor j;
    
    public JpegExtractor() {
        this.a = new ParsableByteArray(6);
        this.f = -1L;
    }
    
    private void c(final ExtractorInput extractorInput) throws IOException {
        this.a.L(2);
        extractorInput.r(this.a.d(), 0, 2);
        extractorInput.m(this.a.J() - 2);
    }
    
    private void f() {
        this.h(new Metadata.Entry[0]);
        Assertions.e(this.b).o();
        this.b.l(new SeekMap.Unseekable(-9223372036854775807L));
        this.c = 6;
    }
    
    private static MotionPhotoMetadata g(final String s, final long n) throws IOException {
        if (n == -1L) {
            return null;
        }
        final MotionPhotoDescription a = b.a(s);
        if (a == null) {
            return null;
        }
        return a.a(n);
    }
    
    private void h(final Metadata.Entry... array) {
        Assertions.e(this.b).e(1024, 4).d(new Format.Builder().K("image/jpeg").X(new Metadata(array)).E());
    }
    
    private int i(final ExtractorInput extractorInput) throws IOException {
        this.a.L(2);
        extractorInput.r(this.a.d(), 0, 2);
        return this.a.J();
    }
    
    private void j(final ExtractorInput extractorInput) throws IOException {
        this.a.L(2);
        extractorInput.readFully(this.a.d(), 0, 2);
        final int j = this.a.J();
        this.d = j;
        if (j == 65498) {
            if (this.f != -1L) {
                this.c = 4;
            }
            else {
                this.f();
            }
        }
        else if ((j < 65488 || j > 65497) && j != 65281) {
            this.c = 1;
        }
    }
    
    private void k(final ExtractorInput extractorInput) throws IOException {
        if (this.d == 65505) {
            final ParsableByteArray parsableByteArray = new ParsableByteArray(this.e);
            extractorInput.readFully(parsableByteArray.d(), 0, this.e);
            if (this.g == null && "http://ns.adobe.com/xap/1.0/".equals(parsableByteArray.x())) {
                final String x = parsableByteArray.x();
                if (x != null) {
                    final MotionPhotoMetadata g = g(x, extractorInput.getLength());
                    if ((this.g = g) != null) {
                        this.f = g.d;
                    }
                }
            }
        }
        else {
            extractorInput.o(this.e);
        }
        this.c = 0;
    }
    
    private void l(final ExtractorInput extractorInput) throws IOException {
        this.a.L(2);
        extractorInput.readFully(this.a.d(), 0, 2);
        this.e = this.a.J() - 2;
        this.c = 2;
    }
    
    private void m(final ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.f(this.a.d(), 0, 1, true)) {
            this.f();
        }
        else {
            extractorInput.h();
            if (this.j == null) {
                this.j = new Mp4Extractor();
            }
            final a i = new a(extractorInput, this.f);
            this.i = i;
            if (this.j.d(i)) {
                this.j.b(new StartOffsetExtractorOutput(this.f, Assertions.e(this.b)));
                this.n();
            }
            else {
                this.f();
            }
        }
    }
    
    private void n() {
        this.h(Assertions.e(this.g));
        this.c = 5;
    }
    
    @Override
    public void a(final long n, final long n2) {
        if (n == 0L) {
            this.c = 0;
            this.j = null;
        }
        else if (this.c == 5) {
            Assertions.e(this.j).a(n, n2);
        }
    }
    
    @Override
    public void b(final ExtractorOutput b) {
        this.b = b;
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        final int i = this.i(extractorInput);
        final boolean b = false;
        if (i != 65496) {
            return false;
        }
        if ((this.d = this.i(extractorInput)) == 65504) {
            this.c(extractorInput);
            this.d = this.i(extractorInput);
        }
        if (this.d != 65505) {
            return false;
        }
        extractorInput.m(2);
        this.a.L(6);
        extractorInput.r(this.a.d(), 0, 6);
        boolean b2 = b;
        if (this.a.F() == 1165519206L) {
            b2 = b;
            if (this.a.J() == 0) {
                b2 = true;
            }
        }
        return b2;
    }
    
    @Override
    public int e(final ExtractorInput h, final PositionHolder positionHolder) throws IOException {
        final int c = this.c;
        if (c == 0) {
            this.j(h);
            return 0;
        }
        if (c == 1) {
            this.l(h);
            return 0;
        }
        if (c == 2) {
            this.k(h);
            return 0;
        }
        if (c != 4) {
            if (c == 5) {
                if (this.i == null || h != this.h) {
                    this.h = h;
                    this.i = new a(h, this.f);
                }
                final int e = Assertions.e(this.j).e(this.i, positionHolder);
                if (e == 1) {
                    positionHolder.a += this.f;
                }
                return e;
            }
            if (c == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        else {
            final long position = h.getPosition();
            final long f = this.f;
            if (position != f) {
                positionHolder.a = f;
                return 1;
            }
            this.m(h);
            return 0;
        }
    }
    
    @Override
    public void release() {
        final Mp4Extractor j = this.j;
        if (j != null) {
            j.release();
        }
    }
}
