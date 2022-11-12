// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.PositionHolder;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import r3.d;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public final class PsExtractor implements Extractor
{
    public static final ExtractorsFactory l;
    private final TimestampAdjuster a;
    private final SparseArray<a> b;
    private final ParsableByteArray c;
    private final c d;
    private boolean e;
    private boolean f;
    private boolean g;
    private long h;
    private b i;
    private ExtractorOutput j;
    private boolean k;
    
    static {
        l = (ExtractorsFactory)d.b;
    }
    
    public PsExtractor() {
        this(new TimestampAdjuster(0L));
    }
    
    public PsExtractor(final TimestampAdjuster a) {
        this.a = a;
        this.c = new ParsableByteArray(4096);
        this.b = (SparseArray<a>)new SparseArray();
        this.d = new c();
    }
    
    public static Extractor[] c() {
        return f();
    }
    
    private static Extractor[] f() {
        return new Extractor[] { new PsExtractor() };
    }
    
    private void g(final long n) {
        if (!this.k) {
            this.k = true;
            if (this.d.c() != -9223372036854775807L) {
                final b i = new b(this.d.d(), this.d.c(), n);
                this.i = i;
                this.j.l(i.b());
            }
            else {
                this.j.l(new SeekMap.Unseekable(this.d.c()));
            }
        }
    }
    
    @Override
    public void a(long n, final long n2) {
        n = this.a.e();
        final int n3 = 1;
        final int n4 = 0;
        int n5;
        if ((n5 = ((n == -9223372036854775807L) ? 1 : 0)) == 0) {
            n = this.a.c();
            int n6;
            if (n != -9223372036854775807L && n != 0L && n != n2) {
                n6 = n3;
            }
            else {
                n6 = 0;
            }
            n5 = n6;
        }
        if (n5 != 0) {
            this.a.g(n2);
        }
        final b i = this.i;
        int j = n4;
        if (i != null) {
            i.h(n2);
            j = n4;
        }
        while (j < this.b.size()) {
            ((a)this.b.valueAt(j)).d();
            ++j;
        }
    }
    
    @Override
    public void b(final ExtractorOutput j) {
        this.j = j;
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        final byte[] array = new byte[14];
        boolean b = false;
        extractorInput.r(array, 0, 14);
        if (0x1BA != ((array[0] & 0xFF) << 24 | (array[1] & 0xFF) << 16 | (array[2] & 0xFF) << 8 | (array[3] & 0xFF))) {
            return false;
        }
        if ((array[4] & 0xC4) != 0x44) {
            return false;
        }
        if ((array[6] & 0x4) != 0x4) {
            return false;
        }
        if ((array[8] & 0x4) != 0x4) {
            return false;
        }
        if ((array[9] & 0x1) != 0x1) {
            return false;
        }
        if ((array[12] & 0x3) != 0x3) {
            return false;
        }
        extractorInput.m(array[13] & 0x7);
        extractorInput.r(array, 0, 3);
        if (0x1 == ((array[0] & 0xFF) << 16 | (array[1] & 0xFF) << 8 | (array[2] & 0xFF))) {
            b = true;
        }
        return b;
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        Assertions.i(this.j);
        final long length = extractorInput.getLength();
        final long n = lcmp(length, -1L);
        if (n != 0 && !this.d.e()) {
            return this.d.g(extractorInput, positionHolder);
        }
        this.g(length);
        final b i = this.i;
        if (i != null && i.d()) {
            return this.i.c(extractorInput, positionHolder);
        }
        extractorInput.h();
        long n2;
        if (n != 0) {
            n2 = length - extractorInput.k();
        }
        else {
            n2 = -1L;
        }
        if (n2 != -1L && n2 < 4L) {
            return -1;
        }
        if (!extractorInput.f(this.c.d(), 0, 4, true)) {
            return -1;
        }
        this.c.P(0);
        final int n3 = this.c.n();
        if (n3 == 441) {
            return -1;
        }
        if (n3 == 442) {
            extractorInput.r(this.c.d(), 0, 10);
            this.c.P(9);
            extractorInput.o((this.c.D() & 0x7) + 14);
            return 0;
        }
        if (n3 == 443) {
            extractorInput.r(this.c.d(), 0, 2);
            this.c.P(0);
            extractorInput.o(this.c.J() + 6);
            return 0;
        }
        if ((n3 & 0xFFFFFF00) >> 8 != 1) {
            extractorInput.o(1);
            return 0;
        }
        final int n4 = n3 & 0xFF;
        a a2;
        final a a = a2 = (a)this.b.get(n4);
        if (!this.e) {
            a a3;
            if ((a3 = a) == null) {
                ElementaryStreamReader elementaryStreamReader = null;
                if (n4 == 189) {
                    elementaryStreamReader = new Ac3Reader();
                    this.f = true;
                    this.h = extractorInput.getPosition();
                }
                else if ((n4 & 0xE0) == 0xC0) {
                    elementaryStreamReader = new MpegAudioReader();
                    this.f = true;
                    this.h = extractorInput.getPosition();
                }
                else if ((n4 & 0xF0) == 0xE0) {
                    elementaryStreamReader = new H262Reader();
                    this.g = true;
                    this.h = extractorInput.getPosition();
                }
                a3 = a;
                if (elementaryStreamReader != null) {
                    elementaryStreamReader.d(this.j, new TsPayloadReader.TrackIdGenerator(n4, 256));
                    a3 = new a(elementaryStreamReader, this.a);
                    this.b.put(n4, (Object)a3);
                }
            }
            long n5;
            if (this.f && this.g) {
                n5 = this.h + 8192L;
            }
            else {
                n5 = 1048576L;
            }
            a2 = a3;
            if (extractorInput.getPosition() > n5) {
                this.e = true;
                this.j.o();
                a2 = a3;
            }
        }
        extractorInput.r(this.c.d(), 0, 2);
        this.c.P(0);
        final int n6 = this.c.J() + 6;
        if (a2 == null) {
            extractorInput.o(n6);
        }
        else {
            this.c.L(n6);
            extractorInput.readFully(this.c.d(), 0, n6);
            this.c.P(6);
            a2.a(this.c);
            final ParsableByteArray c = this.c;
            c.O(c.b());
        }
        return 0;
    }
    
    @Override
    public void release() {
    }
    
    private static final class a
    {
        private final ElementaryStreamReader a;
        private final TimestampAdjuster b;
        private final ParsableBitArray c;
        private boolean d;
        private boolean e;
        private boolean f;
        private int g;
        private long h;
        
        public a(final ElementaryStreamReader a, final TimestampAdjuster b) {
            this.a = a;
            this.b = b;
            this.c = new ParsableBitArray(new byte[64]);
        }
        
        private void b() {
            this.c.r(8);
            this.d = this.c.g();
            this.e = this.c.g();
            this.c.r(6);
            this.g = this.c.h(8);
        }
        
        private void c() {
            this.h = 0L;
            if (this.d) {
                this.c.r(4);
                final long n = this.c.h(3);
                this.c.r(1);
                final long n2 = this.c.h(15) << 15;
                this.c.r(1);
                final long n3 = this.c.h(15);
                this.c.r(1);
                if (!this.f && this.e) {
                    this.c.r(4);
                    final long n4 = this.c.h(3);
                    this.c.r(1);
                    final long n5 = this.c.h(15) << 15;
                    this.c.r(1);
                    final long n6 = this.c.h(15);
                    this.c.r(1);
                    this.b.b(n4 << 30 | n5 | n6);
                    this.f = true;
                }
                this.h = this.b.b(n << 30 | n2 | n3);
            }
        }
        
        public void a(final ParsableByteArray parsableByteArray) throws ParserException {
            parsableByteArray.j(this.c.a, 0, 3);
            this.c.p(0);
            this.b();
            parsableByteArray.j(this.c.a, 0, this.g);
            this.c.p(0);
            this.c();
            this.a.f(this.h, 4);
            this.a.b(parsableByteArray);
            this.a.e();
        }
        
        public void d() {
            this.f = false;
            this.a.c();
        }
    }
}
