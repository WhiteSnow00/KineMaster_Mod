// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.nio.charset.Charset;

public final class ParsableBitArray
{
    public byte[] a;
    private int b;
    private int c;
    private int d;
    
    public ParsableBitArray() {
        this.a = Util.f;
    }
    
    public ParsableBitArray(final byte[] array) {
        this(array, array.length);
    }
    
    public ParsableBitArray(final byte[] a, final int d) {
        this.a = a;
        this.d = d;
    }
    
    private void a() {
        final int b = this.b;
        boolean b2 = false;
        Label_0038: {
            if (b >= 0) {
                final int d = this.d;
                if (b < d || (b == d && this.c == 0)) {
                    b2 = true;
                    break Label_0038;
                }
            }
            b2 = false;
        }
        Assertions.g(b2);
    }
    
    public int b() {
        return (this.d - this.b) * 8 - this.c;
    }
    
    public void c() {
        if (this.c == 0) {
            return;
        }
        this.c = 0;
        ++this.b;
        this.a();
    }
    
    public int d() {
        Assertions.g(this.c == 0);
        return this.b;
    }
    
    public int e() {
        return this.b * 8 + this.c;
    }
    
    public void f(int n, final int n2) {
        int n3 = n;
        if (n2 < 32) {
            n3 = (n & (1 << n2) - 1);
        }
        final int min = Math.min(8 - this.c, n2);
        final int c = this.c;
        n = 8 - c - min;
        final byte[] a = this.a;
        final int b = this.b;
        a[b] &= (byte)(65280 >> c | (1 << n) - 1);
        int i = n2 - min;
        a[b] |= (byte)(n3 >>> i << n);
        for (n = b + 1; i > 8; i -= 8, ++n) {
            this.a[n] = (byte)(n3 >>> i - 8);
        }
        final int n4 = 8 - i;
        final byte[] a2 = this.a;
        a2[n] &= (byte)((1 << n4) - 1);
        a2[n] |= (byte)((n3 & (1 << i) - 1) << n4);
        this.r(n2);
        this.a();
    }
    
    public boolean g() {
        final boolean b = (this.a[this.b] & 128 >> this.c) != 0x0;
        this.q();
        return b;
    }
    
    public int h(final int n) {
        if (n == 0) {
            return 0;
        }
        this.c += n;
        int n2 = 0;
        int c;
        while (true) {
            c = this.c;
            if (c <= 8) {
                break;
            }
            final int c2 = c - 8;
            this.c = c2;
            n2 |= (this.a[this.b++] & 0xFF) << c2;
        }
        final byte[] a = this.a;
        final int b = this.b;
        final byte b2 = a[b];
        if (c == 8) {
            this.c = 0;
            this.b = b + 1;
        }
        this.a();
        return -1 >>> 32 - n & (n2 | (b2 & 0xFF) >> 8 - c);
    }
    
    public void i(final byte[] array, int i, int c) {
        int n;
        for (n = (c >> 3) + i; i < n; ++i) {
            final byte[] a = this.a;
            final int b = this.b;
            final int b2 = b + 1;
            this.b = b2;
            final byte b3 = a[b];
            final int c2 = this.c;
            array[i] = (byte)(b3 << c2);
            array[i] |= (byte)((0xFF & a[b2]) >> 8 - c2);
        }
        i = (c & 0x7);
        if (i == 0) {
            return;
        }
        array[n] &= (byte)(255 >> i);
        c = this.c;
        if (c + i > 8) {
            array[n] |= (byte)((this.a[this.b++] & 0xFF) << c);
            this.c = c - 8;
        }
        c = this.c + i;
        this.c = c;
        final byte[] a2 = this.a;
        final int b4 = this.b;
        array[n] |= (byte)((0xFF & a2[b4]) >> 8 - c << 8 - i);
        if (c == 8) {
            this.c = 0;
            this.b = b4 + 1;
        }
        this.a();
    }
    
    public long j(final int n) {
        if (n <= 32) {
            return Util.c1(this.h(n));
        }
        return Util.b1(this.h(n - 32), this.h(32));
    }
    
    public void k(final byte[] array, final int n, final int n2) {
        Assertions.g(this.c == 0);
        System.arraycopy(this.a, this.b, array, n, n2);
        this.b += n2;
        this.a();
    }
    
    public String l(final int n, final Charset charset) {
        final byte[] array = new byte[n];
        this.k(array, 0, n);
        return new String(array, charset);
    }
    
    public void m(final ParsableByteArray parsableByteArray) {
        this.o(parsableByteArray.d(), parsableByteArray.f());
        this.p(parsableByteArray.e() * 8);
    }
    
    public void n(final byte[] array) {
        this.o(array, array.length);
    }
    
    public void o(final byte[] a, final int d) {
        this.a = a;
        this.b = 0;
        this.c = 0;
        this.d = d;
    }
    
    public void p(final int n) {
        final int b = n / 8;
        this.b = b;
        this.c = n - b * 8;
        this.a();
    }
    
    public void q() {
        final int c = this.c + 1;
        this.c = c;
        if (c == 8) {
            this.c = 0;
            ++this.b;
        }
        this.a();
    }
    
    public void r(int c) {
        final int n = c / 8;
        final int b = this.b + n;
        this.b = b;
        c = this.c + (c - n * 8);
        this.c = c;
        if (c > 7) {
            this.b = b + 1;
            this.c = c - 8;
        }
        this.a();
    }
    
    public void s(final int n) {
        Assertions.g(this.c == 0);
        this.b += n;
        this.a();
    }
}
