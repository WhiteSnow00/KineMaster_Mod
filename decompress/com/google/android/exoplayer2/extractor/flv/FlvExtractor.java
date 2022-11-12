// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.IndexSeekMap;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public final class FlvExtractor implements Extractor
{
    public static final ExtractorsFactory q;
    private final ParsableByteArray a;
    private final ParsableByteArray b;
    private final ParsableByteArray c;
    private final ParsableByteArray d;
    private final b e;
    private ExtractorOutput f;
    private int g;
    private boolean h;
    private long i;
    private int j;
    private int k;
    private int l;
    private long m;
    private boolean n;
    private a o;
    private c p;
    
    static {
        q = (ExtractorsFactory)n3.a.b;
    }
    
    public FlvExtractor() {
        this.a = new ParsableByteArray(4);
        this.b = new ParsableByteArray(9);
        this.c = new ParsableByteArray(11);
        this.d = new ParsableByteArray();
        this.e = new b();
        this.g = 1;
    }
    
    public static Extractor[] c() {
        return h();
    }
    
    private void f() {
        if (!this.n) {
            this.f.l(new SeekMap.Unseekable(-9223372036854775807L));
            this.n = true;
        }
    }
    
    private long g() {
        long m;
        if (this.h) {
            m = this.i + this.m;
        }
        else if (this.e.d() == -9223372036854775807L) {
            m = 0L;
        }
        else {
            m = this.m;
        }
        return m;
    }
    
    private static Extractor[] h() {
        return new Extractor[] { new FlvExtractor() };
    }
    
    private ParsableByteArray i(final ExtractorInput extractorInput) throws IOException {
        if (this.l > this.d.b()) {
            final ParsableByteArray d = this.d;
            d.N(new byte[Math.max(d.b() * 2, this.l)], 0);
        }
        else {
            this.d.P(0);
        }
        this.d.O(this.l);
        extractorInput.readFully(this.d.d(), 0, this.l);
        return this.d;
    }
    
    private boolean j(final ExtractorInput extractorInput) throws IOException {
        final byte[] d = this.b.d();
        boolean b = false;
        if (!extractorInput.i(d, 0, 9, true)) {
            return false;
        }
        this.b.P(0);
        this.b.Q(4);
        final int d2 = this.b.D();
        final boolean b2 = (d2 & 0x4) != 0x0;
        if ((d2 & 0x1) != 0x0) {
            b = true;
        }
        if (b2 && this.o == null) {
            this.o = new a(this.f.e(8, 1));
        }
        if (b && this.p == null) {
            this.p = new c(this.f.e(9, 2));
        }
        this.f.o();
        this.j = this.b.n() - 9 + 4;
        this.g = 2;
        return true;
    }
    
    private boolean k(final ExtractorInput extractorInput) throws IOException {
        final long g = this.g();
        final int k = this.k;
        int n = 0;
        boolean b = false;
        Label_0192: {
            if (k == 8 && this.o != null) {
                this.f();
                n = (this.o.a(this.i(extractorInput), g) ? 1 : 0);
            }
            else if (k == 9 && this.p != null) {
                this.f();
                n = (this.p.a(this.i(extractorInput), g) ? 1 : 0);
            }
            else {
                if (k != 18 || this.n) {
                    extractorInput.o(this.l);
                    b = false;
                    break Label_0192;
                }
                final boolean a = this.e.a(this.i(extractorInput), g);
                final long d = this.e.d();
                n = (a ? 1 : 0);
                if (d != -9223372036854775807L) {
                    this.f.l(new IndexSeekMap(this.e.e(), this.e.f(), d));
                    this.n = true;
                    n = (a ? 1 : 0);
                }
            }
            b = true;
        }
        if (!this.h && n != 0) {
            this.h = true;
            long i;
            if (this.e.d() == -9223372036854775807L) {
                i = -this.m;
            }
            else {
                i = 0L;
            }
            this.i = i;
        }
        this.j = 4;
        this.g = 2;
        return b;
    }
    
    private boolean l(final ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.i(this.c.d(), 0, 11, true)) {
            return false;
        }
        this.c.P(0);
        this.k = this.c.D();
        this.l = this.c.G();
        this.m = this.c.G();
        this.m = ((long)(this.c.D() << 24) | this.m) * 1000L;
        this.c.Q(3);
        this.g = 4;
        return true;
    }
    
    private void m(final ExtractorInput extractorInput) throws IOException {
        extractorInput.o(this.j);
        this.j = 0;
        this.g = 3;
    }
    
    @Override
    public void a(final long n, final long n2) {
        if (n == 0L) {
            this.g = 1;
            this.h = false;
        }
        else {
            this.g = 3;
        }
        this.j = 0;
    }
    
    @Override
    public void b(final ExtractorOutput f) {
        this.f = f;
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        final byte[] d = this.a.d();
        boolean b = false;
        extractorInput.r(d, 0, 3);
        this.a.P(0);
        if (this.a.G() != 4607062) {
            return false;
        }
        extractorInput.r(this.a.d(), 0, 2);
        this.a.P(0);
        if ((this.a.J() & 0xFA) != 0x0) {
            return false;
        }
        extractorInput.r(this.a.d(), 0, 4);
        this.a.P(0);
        final int n = this.a.n();
        extractorInput.h();
        extractorInput.m(n);
        extractorInput.r(this.a.d(), 0, 4);
        this.a.P(0);
        if (this.a.n() == 0) {
            b = true;
        }
        return b;
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        Assertions.i(this.f);
        while (true) {
            final int g = this.g;
            if (g != 1) {
                if (g != 2) {
                    if (g != 3) {
                        if (g != 4) {
                            throw new IllegalStateException();
                        }
                        if (this.k(extractorInput)) {
                            return 0;
                        }
                        continue;
                    }
                    else {
                        if (!this.l(extractorInput)) {
                            return -1;
                        }
                        continue;
                    }
                }
                else {
                    this.m(extractorInput);
                }
            }
            else {
                if (!this.j(extractorInput)) {
                    return -1;
                }
                continue;
            }
        }
    }
    
    @Override
    public void release() {
    }
}
