// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

public final class ParsableNalUnitBitArray
{
    private byte[] a;
    private int b;
    private int c;
    private int d;
    
    public ParsableNalUnitBitArray(final byte[] array, final int n, final int n2) {
        this.i(array, n, n2);
    }
    
    private void a() {
        final int c = this.c;
        boolean b2 = false;
        Label_0038: {
            if (c >= 0) {
                final int b = this.b;
                if (c < b || (c == b && this.d == 0)) {
                    b2 = true;
                    break Label_0038;
                }
            }
            b2 = false;
        }
        Assertions.g(b2);
    }
    
    private int f() {
        int e = 0;
        int n = 0;
        while (!this.d()) {
            ++n;
        }
        if (n > 0) {
            e = this.e(n);
        }
        return (1 << n) - 1 + e;
    }
    
    private boolean j(final int n) {
        boolean b = true;
        if (2 <= n && n < this.b) {
            final byte[] a = this.a;
            if (a[n] == 3 && a[n - 2] == 0 && a[n - 1] == 0) {
                return b;
            }
        }
        b = false;
        return b;
    }
    
    public boolean b(int b) {
        final int c = this.c;
        final int n = b / 8;
        final int n2 = c + n;
        final int n3 = this.d + b - n * 8;
        b = n2;
        int n4 = n3;
        if (n3 > 7) {
            b = n2 + 1;
            n4 = n3 - 8;
        }
        final boolean b2 = true;
        int n5 = b;
        b = c;
        while (true) {
            final int n6 = b + 1;
            if (n6 > n5 || n5 >= this.b) {
                break;
            }
            b = n6;
            if (!this.j(n6)) {
                continue;
            }
            ++n5;
            b = n6 + 2;
        }
        b = this.b;
        boolean b3 = b2;
        if (n5 >= b) {
            b3 = (n5 == b && n4 == 0 && b2);
        }
        return b3;
    }
    
    public boolean c() {
        final int c = this.c;
        final int d = this.d;
        final boolean b = false;
        int n = 0;
        while (this.c < this.b && !this.d()) {
            ++n;
        }
        final boolean b2 = this.c == this.b;
        this.c = c;
        this.d = d;
        boolean b3 = b;
        if (!b2) {
            b3 = b;
            if (this.b(n * 2 + 1)) {
                b3 = true;
            }
        }
        return b3;
    }
    
    public boolean d() {
        final boolean b = (this.a[this.c] & 128 >> this.d) != 0x0;
        this.k();
        return b;
    }
    
    public int e(final int n) {
        this.d += n;
        int n2 = 0;
        int d;
        int n3;
        while (true) {
            d = this.d;
            n3 = 2;
            if (d <= 8) {
                break;
            }
            final int d2 = d - 8;
            this.d = d2;
            final byte[] a = this.a;
            final int c = this.c;
            n2 |= (a[c] & 0xFF) << d2;
            if (!this.j(c + 1)) {
                n3 = 1;
            }
            this.c = c + n3;
        }
        final byte[] a2 = this.a;
        final int c2 = this.c;
        final byte b = a2[c2];
        if (d == 8) {
            this.d = 0;
            if (!this.j(c2 + 1)) {
                n3 = 1;
            }
            this.c = c2 + n3;
        }
        this.a();
        return -1 >>> 32 - n & (n2 | (b & 0xFF) >> 8 - d);
    }
    
    public int g() {
        final int f = this.f();
        int n;
        if (f % 2 == 0) {
            n = -1;
        }
        else {
            n = 1;
        }
        return n * ((f + 1) / 2);
    }
    
    public int h() {
        return this.f();
    }
    
    public void i(final byte[] a, final int c, final int b) {
        this.a = a;
        this.c = c;
        this.b = b;
        this.d = 0;
        this.a();
    }
    
    public void k() {
        int d = this.d;
        int n = 1;
        ++d;
        this.d = d;
        if (d == 8) {
            this.d = 0;
            final int c = this.c;
            if (this.j(c + 1)) {
                n = 2;
            }
            this.c = c + n;
        }
        this.a();
    }
    
    public void l(int n) {
        final int c = this.c;
        final int n2 = n / 8;
        final int c2 = c + n2;
        this.c = c2;
        final int d = this.d + (n - n2 * 8);
        this.d = d;
        n = c;
        if (d > 7) {
            this.c = c2 + 1;
            this.d = d - 8;
            n = c;
        }
        while (true) {
            final int n3 = n + 1;
            if (n3 > this.c) {
                break;
            }
            n = n3;
            if (!this.j(n3)) {
                continue;
            }
            ++this.c;
            n = n3 + 2;
        }
        this.a();
    }
}
