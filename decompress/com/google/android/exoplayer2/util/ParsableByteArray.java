// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.Arrays;
import java.nio.charset.Charset;
import com.google.common.base.Charsets;

public final class ParsableByteArray
{
    private byte[] a;
    private int b;
    private int c;
    
    public ParsableByteArray() {
        this.a = Util.f;
    }
    
    public ParsableByteArray(final int c) {
        this.a = new byte[c];
        this.c = c;
    }
    
    public ParsableByteArray(final byte[] a) {
        this.a = a;
        this.c = a.length;
    }
    
    public ParsableByteArray(final byte[] a, final int c) {
        this.a = a;
        this.c = c;
    }
    
    public String A(final int n) {
        return this.B(n, Charsets.c);
    }
    
    public String B(final int n, final Charset charset) {
        final String s = new String(this.a, this.b, n, charset);
        this.b += n;
        return s;
    }
    
    public int C() {
        return this.D() << 21 | this.D() << 14 | this.D() << 7 | this.D();
    }
    
    public int D() {
        return this.a[this.b++] & 0xFF;
    }
    
    public int E() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final byte b3 = a[b];
        final int b4 = b2 + 1;
        this.b = b4;
        final byte b5 = a[b2];
        this.b = b4 + 2;
        return (b5 & 0xFF) | (b3 & 0xFF) << 8;
    }
    
    public long F() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final long n = a[b];
        final int b3 = b2 + 1;
        this.b = b3;
        final long n2 = a[b2];
        final int b4 = b3 + 1;
        this.b = b4;
        final long n3 = a[b3];
        this.b = b4 + 1;
        return (n & 0xFFL) << 24 | (n2 & 0xFFL) << 16 | (n3 & 0xFFL) << 8 | ((long)a[b4] & 0xFFL);
    }
    
    public int G() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final byte b3 = a[b];
        final int b4 = b2 + 1;
        this.b = b4;
        final byte b5 = a[b2];
        this.b = b4 + 1;
        return (a[b4] & 0xFF) | ((b3 & 0xFF) << 16 | (b5 & 0xFF) << 8);
    }
    
    public int H() {
        final int n = this.n();
        if (n >= 0) {
            return n;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Top bit not zero: ");
        sb.append(n);
        throw new IllegalStateException(sb.toString());
    }
    
    public long I() {
        final long w = this.w();
        if (w >= 0L) {
            return w;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Top bit not zero: ");
        sb.append(w);
        throw new IllegalStateException(sb.toString());
    }
    
    public int J() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final byte b3 = a[b];
        this.b = b2 + 1;
        return (a[b2] & 0xFF) | (b3 & 0xFF) << 8;
    }
    
    public long K() {
        long n = this.a[this.b];
        int n2 = 7;
        int i = 0;
        int n4 = 0;
        Label_0077: {
            while (true) {
                i = 1;
                if (n2 < 0) {
                    break;
                }
                final int n3 = 1 << n2;
                if (((long)n3 & n) == 0x0L) {
                    if (n2 < 6) {
                        n &= n3 - 1;
                        n4 = 7 - n2;
                        break Label_0077;
                    }
                    if (n2 == 7) {
                        n4 = 1;
                        break Label_0077;
                    }
                    break;
                }
                else {
                    --n2;
                }
            }
            n4 = 0;
        }
        if (n4 != 0) {
            while (i < n4) {
                final byte b = this.a[this.b + i];
                if ((b & 0xC0) != 0x80) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid UTF-8 sequence continuation byte: ");
                    sb.append(n);
                    throw new NumberFormatException(sb.toString());
                }
                n = (n << 6 | (long)(b & 0x3F));
                ++i;
            }
            this.b += n4;
            return n;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Invalid UTF-8 sequence first byte: ");
        sb2.append(n);
        throw new NumberFormatException(sb2.toString());
    }
    
    public void L(final int n) {
        byte[] a;
        if (this.b() < n) {
            a = new byte[n];
        }
        else {
            a = this.a;
        }
        this.N(a, n);
    }
    
    public void M(final byte[] array) {
        this.N(array, array.length);
    }
    
    public void N(final byte[] a, final int c) {
        this.a = a;
        this.c = c;
        this.b = 0;
    }
    
    public void O(final int c) {
        Assertions.a(c >= 0 && c <= this.a.length);
        this.c = c;
    }
    
    public void P(final int b) {
        Assertions.a(b >= 0 && b <= this.c);
        this.b = b;
    }
    
    public void Q(final int n) {
        this.P(this.b + n);
    }
    
    public int a() {
        return this.c - this.b;
    }
    
    public int b() {
        return this.a.length;
    }
    
    public void c(final int n) {
        if (n > this.b()) {
            this.a = Arrays.copyOf(this.a, n);
        }
    }
    
    public byte[] d() {
        return this.a;
    }
    
    public int e() {
        return this.b;
    }
    
    public int f() {
        return this.c;
    }
    
    public char g() {
        final byte[] a = this.a;
        final int b = this.b;
        return (char)((a[b + 1] & 0xFF) | (a[b] & 0xFF) << 8);
    }
    
    public int h() {
        return this.a[this.b] & 0xFF;
    }
    
    public void i(final ParsableBitArray parsableBitArray, final int n) {
        this.j(parsableBitArray.a, 0, n);
        parsableBitArray.p(0);
    }
    
    public void j(final byte[] array, final int n, final int n2) {
        System.arraycopy(this.a, this.b, array, n, n2);
        this.b += n2;
    }
    
    public String k(final char c) {
        if (this.a() == 0) {
            return null;
        }
        int b;
        for (b = this.b; b < this.c && this.a[b] != c; ++b) {}
        final byte[] a = this.a;
        final int b2 = this.b;
        final String e = Util.E(a, b2, b - b2);
        if ((this.b = b) < this.c) {
            this.b = b + 1;
        }
        return e;
    }
    
    public double l() {
        return Double.longBitsToDouble(this.w());
    }
    
    public float m() {
        return Float.intBitsToFloat(this.n());
    }
    
    public int n() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final byte b3 = a[b];
        final int b4 = b2 + 1;
        this.b = b4;
        final byte b5 = a[b2];
        final int b6 = b4 + 1;
        this.b = b6;
        final byte b7 = a[b4];
        this.b = b6 + 1;
        return (a[b6] & 0xFF) | ((b3 & 0xFF) << 24 | (b5 & 0xFF) << 16 | (b7 & 0xFF) << 8);
    }
    
    public int o() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final byte b3 = a[b];
        final int b4 = b2 + 1;
        this.b = b4;
        final byte b5 = a[b2];
        this.b = b4 + 1;
        return (a[b4] & 0xFF) | ((b3 & 0xFF) << 24 >> 8 | (b5 & 0xFF) << 8);
    }
    
    public String p() {
        if (this.a() == 0) {
            return null;
        }
        int b;
        for (b = this.b; b < this.c && !Util.v0(this.a[b]); ++b) {}
        final int b2 = this.b;
        if (b - b2 >= 3) {
            final byte[] a = this.a;
            if (a[b2] == -17 && a[b2 + 1] == -69 && a[b2 + 2] == -65) {
                this.b = b2 + 3;
            }
        }
        final byte[] a2 = this.a;
        final int b3 = this.b;
        final String e = Util.E(a2, b3, b - b3);
        this.b = b;
        final int c = this.c;
        if (b == c) {
            return e;
        }
        final byte[] a3 = this.a;
        if (a3[b] == 13) {
            ++b;
            if ((this.b = b) == c) {
                return e;
            }
        }
        final int b4 = this.b;
        if (a3[b4] == 10) {
            this.b = b4 + 1;
        }
        return e;
    }
    
    public int q() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final byte b3 = a[b];
        final int b4 = b2 + 1;
        this.b = b4;
        final byte b5 = a[b2];
        final int b6 = b4 + 1;
        this.b = b6;
        final byte b7 = a[b4];
        this.b = b6 + 1;
        return (a[b6] & 0xFF) << 24 | ((b3 & 0xFF) | (b5 & 0xFF) << 8 | (b7 & 0xFF) << 16);
    }
    
    public long r() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final long n = a[b];
        final int b3 = b2 + 1;
        this.b = b3;
        final long n2 = a[b2];
        final int b4 = b3 + 1;
        this.b = b4;
        final long n3 = a[b3];
        final int b5 = b4 + 1;
        this.b = b5;
        final long n4 = a[b4];
        final int b6 = b5 + 1;
        this.b = b6;
        final long n5 = a[b5];
        final int b7 = b6 + 1;
        this.b = b7;
        final long n6 = a[b6];
        final int b8 = b7 + 1;
        this.b = b8;
        final long n7 = a[b7];
        this.b = b8 + 1;
        return (n & 0xFFL) | (n2 & 0xFFL) << 8 | (n3 & 0xFFL) << 16 | (n4 & 0xFFL) << 24 | (n5 & 0xFFL) << 32 | (n6 & 0xFFL) << 40 | (n7 & 0xFFL) << 48 | ((long)a[b8] & 0xFFL) << 56;
    }
    
    public short s() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final byte b3 = a[b];
        this.b = b2 + 1;
        return (short)((a[b2] & 0xFF) << 8 | (b3 & 0xFF));
    }
    
    public long t() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final long n = a[b];
        final int b3 = b2 + 1;
        this.b = b3;
        final long n2 = a[b2];
        final int b4 = b3 + 1;
        this.b = b4;
        final long n3 = a[b3];
        this.b = b4 + 1;
        return (n & 0xFFL) | (n2 & 0xFFL) << 8 | (n3 & 0xFFL) << 16 | ((long)a[b4] & 0xFFL) << 24;
    }
    
    public int u() {
        final int q = this.q();
        if (q >= 0) {
            return q;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Top bit not zero: ");
        sb.append(q);
        throw new IllegalStateException(sb.toString());
    }
    
    public int v() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final byte b3 = a[b];
        this.b = b2 + 1;
        return (a[b2] & 0xFF) << 8 | (b3 & 0xFF);
    }
    
    public long w() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final long n = a[b];
        final int b3 = b2 + 1;
        this.b = b3;
        final long n2 = a[b2];
        final int b4 = b3 + 1;
        this.b = b4;
        final long n3 = a[b3];
        final int b5 = b4 + 1;
        this.b = b5;
        final long n4 = a[b4];
        final int b6 = b5 + 1;
        this.b = b6;
        final long n5 = a[b5];
        final int b7 = b6 + 1;
        this.b = b7;
        final long n6 = a[b6];
        final int b8 = b7 + 1;
        this.b = b8;
        final long n7 = a[b7];
        this.b = b8 + 1;
        return (n & 0xFFL) << 56 | (n2 & 0xFFL) << 48 | (n3 & 0xFFL) << 40 | (n4 & 0xFFL) << 32 | (n5 & 0xFFL) << 24 | (n6 & 0xFFL) << 16 | (n7 & 0xFFL) << 8 | ((long)a[b8] & 0xFFL);
    }
    
    public String x() {
        return this.k('\0');
    }
    
    public String y(final int n) {
        if (n == 0) {
            return "";
        }
        final int b = this.b;
        final int n2 = b + n - 1;
        int n3;
        if (n2 < this.c && this.a[n2] == 0) {
            n3 = n - 1;
        }
        else {
            n3 = n;
        }
        final String e = Util.E(this.a, b, n3);
        this.b += n;
        return e;
    }
    
    public short z() {
        final byte[] a = this.a;
        final int b = this.b;
        final int b2 = b + 1;
        this.b = b2;
        final byte b3 = a[b];
        this.b = b2 + 1;
        return (short)((a[b2] & 0xFF) | (b3 & 0xFF) << 8);
    }
}
