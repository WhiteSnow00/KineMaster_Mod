// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.flac;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.SeekMap;
import java.io.IOException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import m3.b;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public final class FlacExtractor implements Extractor
{
    public static final ExtractorsFactory o;
    private final byte[] a;
    private final ParsableByteArray b;
    private final boolean c;
    private final FlacFrameReader.SampleNumberHolder d;
    private ExtractorOutput e;
    private TrackOutput f;
    private int g;
    private Metadata h;
    private FlacStreamMetadata i;
    private int j;
    private int k;
    private a l;
    private int m;
    private long n;
    
    static {
        o = (ExtractorsFactory)b.b;
    }
    
    public FlacExtractor() {
        this(0);
    }
    
    public FlacExtractor(final int n) {
        this.a = new byte[42];
        this.b = new ParsableByteArray(new byte[32768], 0);
        boolean c = true;
        if ((n & 0x1) == 0x0) {
            c = false;
        }
        this.c = c;
        this.d = new FlacFrameReader.SampleNumberHolder();
        this.g = 0;
    }
    
    public static Extractor[] c() {
        return j();
    }
    
    private long f(final ParsableByteArray parsableByteArray, final boolean b) {
        Assertions.e(this.i);
        int i;
        for (i = parsableByteArray.e(); i <= parsableByteArray.f() - 16; ++i) {
            parsableByteArray.P(i);
            if (FlacFrameReader.d(parsableByteArray, this.i, this.k, this.d)) {
                parsableByteArray.P(i);
                return this.d.a;
            }
        }
        if (b) {
            while (i <= parsableByteArray.f() - this.j) {
                parsableByteArray.P(i);
                final int n = 0;
                int d;
                try {
                    d = (FlacFrameReader.d(parsableByteArray, this.i, this.k, this.d) ? 1 : 0);
                }
                catch (final IndexOutOfBoundsException ex) {
                    d = 0;
                }
                if (parsableByteArray.e() > parsableByteArray.f()) {
                    d = n;
                }
                if (d != 0) {
                    parsableByteArray.P(i);
                    return this.d.a;
                }
                ++i;
            }
            parsableByteArray.P(parsableByteArray.f());
        }
        else {
            parsableByteArray.P(i);
        }
        return -1L;
    }
    
    private void g(final ExtractorInput extractorInput) throws IOException {
        this.k = FlacMetadataReader.b(extractorInput);
        Util.j(this.e).l(this.h(extractorInput.getPosition(), extractorInput.getLength()));
        this.g = 5;
    }
    
    private SeekMap h(final long n, final long n2) {
        Assertions.e(this.i);
        final FlacStreamMetadata i = this.i;
        if (i.k != null) {
            return new FlacSeekTableSeekMap(i, n);
        }
        if (n2 != -1L && i.j > 0L) {
            final a l = new a(i, this.k, n, n2);
            this.l = l;
            return l.b();
        }
        return new SeekMap.Unseekable(i.f());
    }
    
    private void i(final ExtractorInput extractorInput) throws IOException {
        final byte[] a = this.a;
        extractorInput.r(a, 0, a.length);
        extractorInput.h();
        this.g = 2;
    }
    
    private static Extractor[] j() {
        return new Extractor[] { new FlacExtractor() };
    }
    
    private void k() {
        Util.j(this.f).e(this.n * 1000000L / Util.j(this.i).e, 1, this.m, 0, null);
    }
    
    private int l(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        Assertions.e(this.f);
        Assertions.e(this.i);
        final a l = this.l;
        if (l != null && l.d()) {
            return this.l.c(extractorInput, positionHolder);
        }
        if (this.n == -1L) {
            this.n = FlacFrameReader.i(extractorInput, this.i);
            return 0;
        }
        final int f = this.b.f();
        boolean b;
        if (f < 32768) {
            final int read = extractorInput.read(this.b.d(), f, 32768 - f);
            b = (read == -1);
            if (!b) {
                this.b.O(f + read);
            }
            else if (this.b.a() == 0) {
                this.k();
                return -1;
            }
        }
        else {
            b = false;
        }
        final int e = this.b.e();
        final int m = this.m;
        final int j = this.j;
        if (m < j) {
            final ParsableByteArray b2 = this.b;
            b2.Q(Math.min(j - m, b2.a()));
        }
        final long f2 = this.f(this.b, b);
        final int n = this.b.e() - e;
        this.b.P(e);
        this.f.c(this.b, n);
        this.m += n;
        if (f2 != -1L) {
            this.k();
            this.m = 0;
            this.n = f2;
        }
        if (this.b.a() < 16) {
            final int a = this.b.a();
            System.arraycopy(this.b.d(), this.b.e(), this.b.d(), 0, a);
            this.b.P(0);
            this.b.O(a);
        }
        return 0;
    }
    
    private void m(final ExtractorInput extractorInput) throws IOException {
        this.h = FlacMetadataReader.d(extractorInput, this.c ^ true);
        this.g = 1;
    }
    
    private void n(final ExtractorInput extractorInput) throws IOException {
        final FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder = new FlacMetadataReader.FlacStreamMetadataHolder(this.i);
        for (boolean e = false; !e; e = FlacMetadataReader.e(extractorInput, flacStreamMetadataHolder), this.i = Util.j(flacStreamMetadataHolder.a)) {}
        Assertions.e(this.i);
        this.j = Math.max(this.i.c, 6);
        Util.j(this.f).d(this.i.g(this.a, this.h));
        this.g = 4;
    }
    
    private void o(final ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.i(extractorInput);
        this.g = 3;
    }
    
    @Override
    public void a(long n, final long n2) {
        final long n3 = 0L;
        if (n == 0L) {
            this.g = 0;
        }
        else {
            final a l = this.l;
            if (l != null) {
                l.h(n2);
            }
        }
        if (n2 == 0L) {
            n = n3;
        }
        else {
            n = -1L;
        }
        this.n = n;
        this.m = 0;
        this.b.L(0);
    }
    
    @Override
    public void b(final ExtractorOutput e) {
        this.e = e;
        this.f = e.e(0, 1);
        e.o();
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.c(extractorInput, false);
        return FlacMetadataReader.a(extractorInput);
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final int g = this.g;
        if (g == 0) {
            this.m(extractorInput);
            return 0;
        }
        if (g == 1) {
            this.i(extractorInput);
            return 0;
        }
        if (g == 2) {
            this.o(extractorInput);
            return 0;
        }
        if (g == 3) {
            this.n(extractorInput);
            return 0;
        }
        if (g == 4) {
            this.g(extractorInput);
            return 0;
        }
        if (g == 5) {
            return this.l(extractorInput, positionHolder);
        }
        throw new IllegalStateException();
    }
    
    @Override
    public void release() {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Flags {
    }
}
