// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.SeekMap;
import java.io.IOException;
import java.io.EOFException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import r3.c;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public final class AdtsExtractor implements Extractor
{
    public static final ExtractorsFactory m;
    private final int a;
    private final AdtsReader b;
    private final ParsableByteArray c;
    private final ParsableByteArray d;
    private final ParsableBitArray e;
    private ExtractorOutput f;
    private long g;
    private long h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    
    static {
        m = (ExtractorsFactory)c.b;
    }
    
    public AdtsExtractor() {
        this(0);
    }
    
    public AdtsExtractor(final int n) {
        int a = n;
        if ((n & 0x2) != 0x0) {
            a = (n | 0x1);
        }
        this.a = a;
        this.b = new AdtsReader(true);
        this.c = new ParsableByteArray(2048);
        this.i = -1;
        this.h = -1L;
        final ParsableByteArray d = new ParsableByteArray(10);
        this.d = d;
        this.e = new ParsableBitArray(d.d());
    }
    
    public static Extractor[] c() {
        return i();
    }
    
    private void f(final ExtractorInput extractorInput) throws IOException {
        if (this.j) {
            return;
        }
        this.i = -1;
        extractorInput.h();
        final long position = extractorInput.getPosition();
        long n = 0L;
        if (position == 0L) {
            this.k(extractorInput);
        }
        final int n2 = 0;
        int n3 = 0;
    Label_0276_Outer:
        while (true) {
            int n4 = n3;
            long n5 = n;
            int n6 = n3;
            long n7 = n;
            while (true) {
                try {
                    Label_0280: {
                        if (extractorInput.f(this.d.d(), 0, 2, true)) {
                            n6 = n3;
                            n7 = n;
                            this.d.P(0);
                            n6 = n3;
                            n7 = n;
                            if (!AdtsReader.m(this.d.J())) {
                                n4 = n2;
                                break Label_0280;
                            }
                            n6 = n3;
                            n7 = n;
                            if (!extractorInput.f(this.d.d(), 0, 4, true)) {
                                n4 = n3;
                                n5 = n;
                            }
                            else {
                                n6 = n3;
                                n7 = n;
                                this.e.p(14);
                                n6 = n3;
                                n7 = n;
                                final int h = this.e.h(13);
                                if (h <= 6) {
                                    n6 = n3;
                                    n7 = n;
                                    this.j = true;
                                    n6 = n3;
                                    n7 = n;
                                    throw ParserException.createForMalformedContainer("Malformed ADTS stream", null);
                                }
                                n5 = n + h;
                                n4 = n3 + 1;
                                if (n4 != 1000) {
                                    n3 = n4;
                                    n = n5;
                                    n6 = n4;
                                    n7 = n5;
                                    if (extractorInput.p(h - 6, true)) {
                                        continue Label_0276_Outer;
                                    }
                                }
                            }
                        }
                        n = n5;
                    }
                    extractorInput.h();
                    if (n4 > 0) {
                        this.i = (int)(n / n4);
                    }
                    else {
                        this.i = -1;
                    }
                    this.j = true;
                }
                catch (final EOFException ex) {
                    n4 = n6;
                    n5 = n7;
                    continue;
                }
                break;
            }
        }
    }
    
    private static int g(final int n, final long n2) {
        return (int)(n * 8L * 1000000L / n2);
    }
    
    private SeekMap h(final long n, final boolean b) {
        return new ConstantBitrateSeekMap(n, this.h, g(this.i, this.b.k()), this.i, b);
    }
    
    private static Extractor[] i() {
        return new Extractor[] { new AdtsExtractor() };
    }
    
    private void j(final long n, final boolean b) {
        if (this.l) {
            return;
        }
        final int a = this.a;
        final boolean b2 = false;
        final boolean b3 = (a & 0x1) != 0x0 && this.i > 0;
        if (b3 && this.b.k() == -9223372036854775807L && !b) {
            return;
        }
        if (b3 && this.b.k() != -9223372036854775807L) {
            final ExtractorOutput f = this.f;
            boolean b4 = b2;
            if ((this.a & 0x2) != 0x0) {
                b4 = true;
            }
            f.l(this.h(n, b4));
        }
        else {
            this.f.l(new SeekMap.Unseekable(-9223372036854775807L));
        }
        this.l = true;
    }
    
    private int k(final ExtractorInput extractorInput) throws IOException {
        int n = 0;
        while (true) {
            extractorInput.r(this.d.d(), 0, 10);
            this.d.P(0);
            if (this.d.G() != 4801587) {
                break;
            }
            this.d.Q(3);
            final int c = this.d.C();
            n += c + 10;
            extractorInput.m(c);
        }
        extractorInput.h();
        extractorInput.m(n);
        if (this.h == -1L) {
            this.h = n;
        }
        return n;
    }
    
    @Override
    public void a(final long n, final long g) {
        this.k = false;
        this.b.c();
        this.g = g;
    }
    
    @Override
    public void b(final ExtractorOutput f) {
        this.f = f;
        this.b.d(f, new TsPayloadReader.TrackIdGenerator(0, 1));
        f.o();
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        int k;
        final int n = k = this.k(extractorInput);
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        do {
            extractorInput.r(this.d.d(), 0, 2);
            this.d.P(0);
            int n6 = 0;
            Label_0184: {
                int n5;
                if (!AdtsReader.m(this.d.J())) {
                    n5 = k + 1;
                    extractorInput.h();
                    extractorInput.m(n5);
                }
                else {
                    if (++n2 >= 4 && n3 > 188) {
                        return true;
                    }
                    extractorInput.r(this.d.d(), 0, 4);
                    this.e.p(14);
                    final int h = this.e.h(13);
                    if (h > 6) {
                        extractorInput.m(h - 6);
                        n3 += h;
                        n4 = k;
                        n6 = n2;
                        break Label_0184;
                    }
                    n5 = k + 1;
                    extractorInput.h();
                    extractorInput.m(n5);
                }
                n6 = 0;
                final int n7 = 0;
                n4 = n5;
                n3 = n7;
            }
            n2 = n6;
            k = n4;
        } while (n4 - n < 8192);
        return false;
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        Assertions.i(this.f);
        final long length = extractorInput.getLength();
        final int a = this.a;
        if ((a & 0x2) != 0x0 || ((a & 0x1) != 0x0 && length != -1L)) {
            this.f(extractorInput);
        }
        final int read = extractorInput.read(this.c.d(), 0, 2048);
        final boolean b = read == -1;
        this.j(length, b);
        if (b) {
            return -1;
        }
        this.c.P(0);
        this.c.O(read);
        if (!this.k) {
            this.b.f(this.g, 4);
            this.k = true;
        }
        this.b.b(this.c);
        return 0;
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
