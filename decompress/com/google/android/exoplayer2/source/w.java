// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.Allocation;
import java.io.IOException;
import java.io.EOFException;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.util.Arrays;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.upstream.Allocator;

class w
{
    private final Allocator a;
    private final int b;
    private final ParsableByteArray c;
    private a d;
    private a e;
    private a f;
    private long g;
    
    public w(final Allocator a) {
        this.a = a;
        final int e = a.e();
        this.b = e;
        this.c = new ParsableByteArray(32);
        final a f = new a(0L, e);
        this.d = f;
        this.e = f;
        this.f = f;
    }
    
    private void a(final a a) {
        if (a.c == null) {
            return;
        }
        this.a.a((Allocator.AllocationNode)a);
        a.b();
    }
    
    private static a d(a d, final long n) {
        while (n >= d.b) {
            d = d.d;
        }
        return d;
    }
    
    private void g(final int n) {
        final long g = this.g + n;
        this.g = g;
        final a f = this.f;
        if (g == f.b) {
            this.f = f.d;
        }
    }
    
    private int h(final int n) {
        final a f = this.f;
        if (f.c == null) {
            f.c(this.a.b(), new a(this.f.b, this.b));
        }
        return Math.min(n, (int)(this.f.b - this.g));
    }
    
    private static a i(a a, long n, final ByteBuffer byteBuffer, int i) {
        a = d(a, n);
        while (i > 0) {
            final int min = Math.min(i, (int)(a.b - n));
            byteBuffer.put(a.c.a, a.e(n), min);
            final int n2 = i - min;
            final long n3 = n += min;
            i = n2;
            if (n3 == a.b) {
                a = a.d;
                n = n3;
                i = n2;
            }
        }
        return a;
    }
    
    private static a j(a a, long n, final byte[] array, final int n2) {
        a = d(a, n);
        int n3;
        long n4;
        for (int i = n2; i > 0; i = n3, n = n4) {
            final int min = Math.min(i, (int)(a.b - n));
            System.arraycopy(a.c.a, a.e(n), array, n2 - i, min);
            n3 = i - min;
            n4 = n + min;
            i = n3;
            n = n4;
            if (n4 == a.b) {
                a = a.d;
            }
        }
        return a;
    }
    
    private static a k(a a, final DecoderInputBuffer decoderInputBuffer, final SampleQueue.b b, final ParsableByteArray parsableByteArray) {
        final long b2 = b.b;
        int j = 1;
        parsableByteArray.L(1);
        a = j(a, b2, parsableByteArray.d(), 1);
        final long n = b2 + 1L;
        final byte[] d = parsableByteArray.d();
        final int n2 = 0;
        final byte b3 = d[0];
        final boolean b4 = (b3 & 0x80) != 0x0;
        final int n3 = b3 & 0x7F;
        final CryptoInfo c = decoderInputBuffer.c;
        final byte[] a2 = c.a;
        if (a2 == null) {
            c.a = new byte[16];
        }
        else {
            Arrays.fill(a2, (byte)0);
        }
        final a i = j(a, n, c.a, n3);
        long n5;
        final long n4 = n5 = n + n3;
        a = i;
        if (b4) {
            parsableByteArray.L(2);
            a = j(i, n4, parsableByteArray.d(), 2);
            n5 = n4 + 2L;
            j = parsableByteArray.J();
        }
        final int[] d2 = c.d;
        int[] array = null;
        Label_0197: {
            if (d2 != null) {
                array = d2;
                if (d2.length >= j) {
                    break Label_0197;
                }
            }
            array = new int[j];
        }
        final int[] e = c.e;
        int[] array2 = null;
        Label_0227: {
            if (e != null) {
                array2 = e;
                if (e.length >= j) {
                    break Label_0227;
                }
            }
            array2 = new int[j];
        }
        if (b4) {
            final int n6 = j * 6;
            parsableByteArray.L(n6);
            final a k = j(a, n5, parsableByteArray.d(), n6);
            final long n7 = n5 + n6;
            parsableByteArray.P(0);
            int n8 = n2;
            while (true) {
                n5 = n7;
                a = k;
                if (n8 >= j) {
                    break;
                }
                array[n8] = parsableByteArray.J();
                array2[n8] = parsableByteArray.H();
                ++n8;
            }
        }
        else {
            array2[array[0] = 0] = b.a - (int)(n5 - b.b);
        }
        final TrackOutput.CryptoData cryptoData = Util.j(b.c);
        c.c(j, array, array2, cryptoData.b, c.a, cryptoData.a, cryptoData.c, cryptoData.d);
        final long b5 = b.b;
        final int n9 = (int)(n5 - b5);
        b.b = b5 + n9;
        b.a -= n9;
        return a;
    }
    
    private static a l(a a, final DecoderInputBuffer decoderInputBuffer, final SampleQueue.b b, final ParsableByteArray parsableByteArray) {
        a k = a;
        if (decoderInputBuffer.u()) {
            k = k(a, decoderInputBuffer, b, parsableByteArray);
        }
        if (decoderInputBuffer.l()) {
            parsableByteArray.L(4);
            a = j(k, b.b, parsableByteArray.d(), 4);
            final int h = parsableByteArray.H();
            b.b += 4L;
            b.a -= 4;
            decoderInputBuffer.s(h);
            a = i(a, b.b, decoderInputBuffer.d, h);
            b.b += h;
            decoderInputBuffer.x(b.a -= h);
            a = i(a, b.b, decoderInputBuffer.g, b.a);
        }
        else {
            decoderInputBuffer.s(b.a);
            a = i(k, b.b, decoderInputBuffer.d, b.a);
        }
        return a;
    }
    
    public void b(final long n) {
        if (n == -1L) {
            return;
        }
        a d;
        while (true) {
            d = this.d;
            if (n < d.b) {
                break;
            }
            this.a.c(d.c);
            this.d = this.d.b();
        }
        if (this.e.a < d.a) {
            this.e = d;
        }
    }
    
    public void c(final long g) {
        Assertions.a(g <= this.g);
        this.g = g;
        a a;
        if (g != 0L && g != (a = this.d).a) {
            while (this.g > a.b) {
                a = a.d;
            }
            final a a2 = Assertions.e(a.d);
            this.a(a2);
            final a a3 = new a(a.b, this.b);
            a.d = a3;
            a f = a;
            if (this.g == a.b) {
                f = a3;
            }
            this.f = f;
            if (this.e == a2) {
                this.e = a3;
            }
        }
        else {
            this.a(this.d);
            final a f2 = new a(this.g, this.b);
            this.d = f2;
            this.e = f2;
            this.f = f2;
        }
    }
    
    public long e() {
        return this.g;
    }
    
    public void f(final DecoderInputBuffer decoderInputBuffer, final SampleQueue.b b) {
        l(this.e, decoderInputBuffer, b, this.c);
    }
    
    public void m(final DecoderInputBuffer decoderInputBuffer, final SampleQueue.b b) {
        this.e = l(this.e, decoderInputBuffer, b, this.c);
    }
    
    public void n() {
        this.a(this.d);
        this.d.d(0L, this.b);
        final a d = this.d;
        this.e = d;
        this.f = d;
        this.g = 0L;
        this.a.d();
    }
    
    public void o() {
        this.e = this.d;
    }
    
    public int p(final DataReader dataReader, int n, final boolean b) throws IOException {
        n = this.h(n);
        final a f = this.f;
        n = dataReader.read(f.c.a, f.e(this.g), n);
        if (n != -1) {
            this.g(n);
            return n;
        }
        if (b) {
            return -1;
        }
        throw new EOFException();
    }
    
    public void q(final ParsableByteArray parsableByteArray, int i) {
        while (i > 0) {
            final int h = this.h(i);
            final a f = this.f;
            parsableByteArray.j(f.c.a, f.e(this.g), h);
            i -= h;
            this.g(h);
        }
    }
    
    private static final class a implements AllocationNode
    {
        public long a;
        public long b;
        public Allocation c;
        public a d;
        
        public a(final long n, final int n2) {
            this.d(n, n2);
        }
        
        @Override
        public Allocation a() {
            return Assertions.e(this.c);
        }
        
        public a b() {
            this.c = null;
            final a d = this.d;
            this.d = null;
            return d;
        }
        
        public void c(final Allocation c, final a d) {
            this.c = c;
            this.d = d;
        }
        
        public void d(final long a, final int n) {
            Assertions.g(this.c == null);
            this.a = a;
            this.b = a + n;
        }
        
        public int e(final long n) {
            return (int)(n - this.a) + this.c.b;
        }
        
        @Override
        public AllocationNode next() {
            final a d = this.d;
            if (d != null && d.c != null) {
                return d;
            }
            return null;
        }
    }
}
