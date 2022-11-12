// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.amr;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import l3.a;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public final class AmrExtractor implements Extractor
{
    public static final ExtractorsFactory p;
    private static final int[] q;
    private static final int[] r;
    private static final byte[] s;
    private static final byte[] t;
    private static final int u;
    private final byte[] a;
    private final int b;
    private boolean c;
    private long d;
    private int e;
    private int f;
    private boolean g;
    private long h;
    private int i;
    private int j;
    private long k;
    private ExtractorOutput l;
    private TrackOutput m;
    private SeekMap n;
    private boolean o;
    
    static {
        p = (ExtractorsFactory)a.b;
        q = new int[] { 13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1 };
        final int[] array;
        final int[] r2 = array = new int[16];
        array[0] = 18;
        array[1] = 24;
        array[2] = 33;
        array[3] = 37;
        array[4] = 41;
        array[5] = 47;
        array[6] = 51;
        array[7] = 59;
        array[8] = 61;
        array[9] = 6;
        array[11] = (array[10] = 1);
        array[13] = (array[12] = 1);
        array[15] = (array[14] = 1);
        r = r2;
        s = Util.n0("#!AMR\n");
        t = Util.n0("#!AMR-WB\n");
        u = r2[8];
    }
    
    public AmrExtractor() {
        this(0);
    }
    
    public AmrExtractor(final int n) {
        int b = n;
        if ((n & 0x2) != 0x0) {
            b = (n | 0x1);
        }
        this.b = b;
        this.a = new byte[1];
        this.i = -1;
    }
    
    public static Extractor[] c() {
        return m();
    }
    
    private void f() {
        Assertions.i(this.m);
        Util.j(this.l);
    }
    
    private static int g(final int n, final long n2) {
        return (int)(n * 8L * 1000000L / n2);
    }
    
    private SeekMap h(final long n, final boolean b) {
        return new ConstantBitrateSeekMap(n, this.h, g(this.i, 20000L), this.i, b);
    }
    
    private int i(int n) throws ParserException {
        if (!this.k(n)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Illegal AMR ");
            String s;
            if (this.c) {
                s = "WB";
            }
            else {
                s = "NB";
            }
            sb.append(s);
            sb.append(" frame type ");
            sb.append(n);
            throw ParserException.createForMalformedContainer(sb.toString(), null);
        }
        if (this.c) {
            n = AmrExtractor.r[n];
        }
        else {
            n = AmrExtractor.q[n];
        }
        return n;
    }
    
    private boolean j(final int n) {
        return !this.c && (n < 12 || n > 14);
    }
    
    private boolean k(final int n) {
        return n >= 0 && n <= 15 && (this.l(n) || this.j(n));
    }
    
    private boolean l(final int n) {
        return this.c && (n < 10 || n > 13);
    }
    
    private static Extractor[] m() {
        return new Extractor[] { new AmrExtractor() };
    }
    
    private void n() {
        if (!this.o) {
            this.o = true;
            final boolean c = this.c;
            String s;
            if (c) {
                s = "audio/amr-wb";
            }
            else {
                s = "audio/3gpp";
            }
            int n;
            if (c) {
                n = 16000;
            }
            else {
                n = 8000;
            }
            this.m.d(new Format.Builder().e0(s).W(AmrExtractor.u).H(1).f0(n).E());
        }
    }
    
    private void o(final long n, final int n2) {
        if (this.g) {
            return;
        }
        final int b = this.b;
        if ((b & 0x1) != 0x0 && n != -1L) {
            final int i = this.i;
            if (i == -1 || i == this.e) {
                if (this.j >= 20 || n2 == -1) {
                    final SeekMap h = this.h(n, (b & 0x2) != 0x0);
                    this.n = h;
                    this.l.l(h);
                    this.g = true;
                }
                return;
            }
        }
        final SeekMap.Unseekable n3 = new SeekMap.Unseekable(-9223372036854775807L);
        this.n = n3;
        this.l.l(n3);
        this.g = true;
    }
    
    private static boolean p(final ExtractorInput extractorInput, final byte[] array) throws IOException {
        extractorInput.h();
        final byte[] array2 = new byte[array.length];
        extractorInput.r(array2, 0, array.length);
        return Arrays.equals(array2, array);
    }
    
    private int q(final ExtractorInput extractorInput) throws IOException {
        extractorInput.h();
        extractorInput.r(this.a, 0, 1);
        final byte b = this.a[0];
        if ((b & 0x83) <= 0) {
            return this.i(b >> 3 & 0xF);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid padding bits for frame header ");
        sb.append(b);
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }
    
    private boolean r(final ExtractorInput extractorInput) throws IOException {
        final byte[] s = AmrExtractor.s;
        if (p(extractorInput, s)) {
            this.c = false;
            extractorInput.o(s.length);
            return true;
        }
        final byte[] t = AmrExtractor.t;
        if (p(extractorInput, t)) {
            this.c = true;
            extractorInput.o(t.length);
            return true;
        }
        return false;
    }
    
    private int s(final ExtractorInput extractorInput) throws IOException {
        if (this.f == 0) {
            try {
                final int q = this.q(extractorInput);
                this.e = q;
                this.f = q;
                if (this.i == -1) {
                    this.h = extractorInput.getPosition();
                    this.i = this.e;
                }
                if (this.i == this.e) {
                    ++this.j;
                }
            }
            catch (final EOFException ex) {
                return -1;
            }
        }
        final int b = this.m.b(extractorInput, this.f, true);
        if (b == -1) {
            return -1;
        }
        if ((this.f -= b) > 0) {
            return 0;
        }
        this.m.e(this.k + this.d, 1, this.e, 0, null);
        this.d += 20000L;
        return 0;
    }
    
    @Override
    public void a(final long n, final long n2) {
        this.d = 0L;
        this.e = 0;
        this.f = 0;
        if (n != 0L) {
            final SeekMap n3 = this.n;
            if (n3 instanceof ConstantBitrateSeekMap) {
                this.k = ((ConstantBitrateSeekMap)n3).b(n);
                return;
            }
        }
        this.k = 0L;
    }
    
    @Override
    public void b(final ExtractorOutput l) {
        this.l = l;
        this.m = l.e(0, 1);
        l.o();
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        return this.r(extractorInput);
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        this.f();
        if (extractorInput.getPosition() == 0L && !this.r(extractorInput)) {
            throw ParserException.createForMalformedContainer("Could not find AMR header.", null);
        }
        this.n();
        final int s = this.s(extractorInput);
        this.o(extractorInput.getLength(), s);
        return s;
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
