// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.util.ArrayDeque;

final class a implements com.google.android.exoplayer2.extractor.mkv.b
{
    private final byte[] a;
    private final ArrayDeque<b> b;
    private final e c;
    private EbmlProcessor d;
    private int e;
    private int f;
    private long g;
    
    public a() {
        this.a = new byte[8];
        this.b = new ArrayDeque<b>();
        this.c = new e();
    }
    
    private long c(final ExtractorInput extractorInput) throws IOException {
        extractorInput.h();
        int c;
        int n;
        while (true) {
            extractorInput.r(this.a, 0, 4);
            c = com.google.android.exoplayer2.extractor.mkv.e.c(this.a[0]);
            if (c != -1 && c <= 4) {
                n = (int)com.google.android.exoplayer2.extractor.mkv.e.a(this.a, c, false);
                if (this.d.e(n)) {
                    break;
                }
            }
            extractorInput.o(1);
        }
        extractorInput.o(c);
        return n;
    }
    
    private double d(final ExtractorInput extractorInput, final int n) throws IOException {
        final long e = this.e(extractorInput, n);
        double longBitsToDouble;
        if (n == 4) {
            longBitsToDouble = Float.intBitsToFloat((int)e);
        }
        else {
            longBitsToDouble = Double.longBitsToDouble(e);
        }
        return longBitsToDouble;
    }
    
    private long e(final ExtractorInput extractorInput, final int n) throws IOException {
        final byte[] a = this.a;
        int i = 0;
        extractorInput.readFully(a, 0, n);
        long n2 = 0L;
        while (i < n) {
            n2 = (n2 << 8 | (long)(this.a[i] & 0xFF));
            ++i;
        }
        return n2;
    }
    
    private static String f(final ExtractorInput extractorInput, int n) throws IOException {
        if (n == 0) {
            return "";
        }
        final byte[] array = new byte[n];
        extractorInput.readFully(array, 0, n);
        while (n > 0 && array[n - 1] == 0) {
            --n;
        }
        return new String(array, 0, n);
    }
    
    @Override
    public boolean a(final ExtractorInput extractorInput) throws IOException {
        Assertions.i(this.d);
        while (true) {
            final b b = this.b.peek();
            if (b != null && extractorInput.getPosition() >= com.google.android.exoplayer2.extractor.mkv.a.b.a(b)) {
                this.d.a(com.google.android.exoplayer2.extractor.mkv.a.b.b(this.b.pop()));
                return true;
            }
            if (this.e == 0) {
                long n;
                if ((n = this.c.d(extractorInput, true, false, 4)) == -2L) {
                    n = this.c(extractorInput);
                }
                if (n == -1L) {
                    return false;
                }
                this.f = (int)n;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.d(extractorInput, false, true, 8);
                this.e = 2;
            }
            final int d = this.d.d(this.f);
            if (d != 0) {
                if (d == 1) {
                    final long position = extractorInput.getPosition();
                    this.b.push(new b(this.f, this.g + position, null));
                    this.d.h(this.f, position, this.g);
                    this.e = 0;
                    return true;
                }
                if (d != 2) {
                    if (d != 3) {
                        if (d == 4) {
                            this.d.f(this.f, (int)this.g, extractorInput);
                            this.e = 0;
                            return true;
                        }
                        if (d != 5) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Invalid element type ");
                            sb.append(d);
                            throw ParserException.createForMalformedContainer(sb.toString(), null);
                        }
                        final long g = this.g;
                        if (g != 4L && g != 8L) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Invalid float size: ");
                            sb2.append(this.g);
                            throw ParserException.createForMalformedContainer(sb2.toString(), null);
                        }
                        this.d.b(this.f, this.d(extractorInput, (int)g));
                        this.e = 0;
                        return true;
                    }
                    else {
                        final long g2 = this.g;
                        if (g2 <= 2147483647L) {
                            this.d.g(this.f, f(extractorInput, (int)g2));
                            this.e = 0;
                            return true;
                        }
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("String element size: ");
                        sb3.append(this.g);
                        throw ParserException.createForMalformedContainer(sb3.toString(), null);
                    }
                }
                else {
                    final long g3 = this.g;
                    if (g3 <= 8L) {
                        this.d.c(this.f, this.e(extractorInput, (int)g3));
                        this.e = 0;
                        return true;
                    }
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid integer size: ");
                    sb4.append(this.g);
                    throw ParserException.createForMalformedContainer(sb4.toString(), null);
                }
            }
            else {
                extractorInput.o((int)this.g);
                this.e = 0;
            }
        }
    }
    
    @Override
    public void b(final EbmlProcessor d) {
        this.d = d;
    }
    
    @Override
    public void reset() {
        this.e = 0;
        this.b.clear();
        this.c.e();
    }
    
    private static final class b
    {
        private final int a;
        private final long b;
        
        private b(final int a, final long b) {
            this.a = a;
            this.b = b;
        }
        
        b(final int n, final long n2, final a$a object) {
            this(n, n2);
        }
        
        static long a(final b b) {
            return b.b;
        }
        
        static int b(final b b) {
            return b.a;
        }
    }
}
