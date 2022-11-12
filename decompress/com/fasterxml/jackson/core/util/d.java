// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.f;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.ArrayList;

public final class d
{
    static final char[] l;
    private final a a;
    private char[] b;
    private int c;
    private int d;
    private ArrayList<char[]> e;
    private boolean f;
    private int g;
    private char[] h;
    private int i;
    private String j;
    private char[] k;
    
    static {
        l = new char[0];
    }
    
    public d(final a a) {
        this.a = a;
    }
    
    private char[] B() {
        final String j = this.j;
        if (j != null) {
            return j.toCharArray();
        }
        final int c = this.c;
        if (c >= 0) {
            final int d = this.d;
            if (d < 1) {
                return com.fasterxml.jackson.core.util.d.l;
            }
            if (c == 0) {
                return Arrays.copyOf(this.b, d);
            }
            return Arrays.copyOfRange(this.b, c, d + c);
        }
        else {
            final int e = this.E();
            if (e < 1) {
                return com.fasterxml.jackson.core.util.d.l;
            }
            final char[] e2 = this.e(e);
            final ArrayList<char[]> e3 = this.e;
            int n3;
            if (e3 != null) {
                final int size = e3.size();
                int n = 0;
                int n2 = 0;
                while (true) {
                    n3 = n2;
                    if (n >= size) {
                        break;
                    }
                    final char[] array = this.e.get(n);
                    final int length = array.length;
                    System.arraycopy(array, 0, e2, n2, length);
                    n2 += length;
                    ++n;
                }
            }
            else {
                n3 = 0;
            }
            System.arraycopy(this.h, 0, e2, n3, this.i);
            return e2;
        }
    }
    
    private void F(int n) {
        final int d = this.d;
        this.d = 0;
        final char[] b = this.b;
        this.b = null;
        final int c = this.c;
        this.c = -1;
        n += d;
        final char[] h = this.h;
        if (h == null || n > h.length) {
            this.h = this.d(n);
        }
        if (d > 0) {
            System.arraycopy(b, c, this.h, 0, d);
        }
        this.g = 0;
        this.i = d;
    }
    
    private char[] d(final int n) {
        final a a = this.a;
        if (a != null) {
            return a.d(2, n);
        }
        return new char[Math.max(n, 1000)];
    }
    
    private char[] e(final int n) {
        return new char[n];
    }
    
    private void f() {
        this.f = false;
        this.e.clear();
        this.g = 0;
        this.i = 0;
    }
    
    private void n(int length) {
        if (this.e == null) {
            this.e = new ArrayList<char[]>();
        }
        final char[] h = this.h;
        this.f = true;
        this.e.add(h);
        this.g += h.length;
        this.i = 0;
        length = h.length;
        final int n = length + (length >> 1);
        if (n < 1000) {
            length = 1000;
        }
        else if ((length = n) > 262144) {
            length = 262144;
        }
        this.h = this.e(length);
    }
    
    public void A(final String j) {
        this.b = null;
        this.c = -1;
        this.d = 0;
        this.j = j;
        this.k = null;
        if (this.f) {
            this.f();
        }
        this.i = 0;
    }
    
    public String C(final int i) {
        this.i = i;
        if (this.g > 0) {
            return this.l();
        }
        String j;
        if (i == 0) {
            j = "";
        }
        else {
            j = new String(this.h, 0, i);
        }
        return this.j = j;
    }
    
    public void D(final int i) {
        this.i = i;
    }
    
    public int E() {
        if (this.c >= 0) {
            return this.d;
        }
        final char[] k = this.k;
        if (k != null) {
            return k.length;
        }
        final String j = this.j;
        if (j != null) {
            return j.length();
        }
        return this.g + this.i;
    }
    
    public void a(final char c) {
        if (this.c >= 0) {
            this.F(16);
        }
        this.j = null;
        this.k = null;
        char[] array;
        if (this.i >= (array = this.h).length) {
            this.n(1);
            array = this.h;
        }
        array[this.i++] = c;
    }
    
    public void b(final String s, int n, int min) {
        if (this.c >= 0) {
            this.F(min);
        }
        this.j = null;
        this.k = null;
        final char[] h = this.h;
        final int length = h.length;
        final int i = this.i;
        final int n2 = length - i;
        if (n2 >= min) {
            s.getChars(n, n + min, h, i);
            this.i += min;
            return;
        }
        int n3 = n;
        int n4 = min;
        if (n2 > 0) {
            n3 = n + n2;
            s.getChars(n, n3, h, i);
            n4 = min - n2;
        }
        while (true) {
            this.n(n4);
            min = Math.min(this.h.length, n4);
            n = n3 + min;
            s.getChars(n3, n, this.h, 0);
            this.i += min;
            n4 -= min;
            if (n4 <= 0) {
                break;
            }
            n3 = n;
        }
    }
    
    public void c(final char[] array, int min, final int n) {
        if (this.c >= 0) {
            this.F(n);
        }
        this.j = null;
        this.k = null;
        final char[] h = this.h;
        final int length = h.length;
        final int i = this.i;
        final int n2 = length - i;
        if (n2 >= n) {
            System.arraycopy(array, min, h, i, n);
            this.i += n;
            return;
        }
        int n3 = min;
        int n4 = n;
        if (n2 > 0) {
            System.arraycopy(array, min, h, i, n2);
            n3 = min + n2;
            n4 = n - n2;
        }
        do {
            this.n(n4);
            min = Math.min(this.h.length, n4);
            System.arraycopy(array, n3, this.h, 0, min);
            this.i += min;
            n3 += min;
            min = n4 - min;
        } while ((n4 = min) > 0);
    }
    
    public char[] g() {
        char[] k;
        if ((k = this.k) == null) {
            k = this.B();
            this.k = k;
        }
        return k;
    }
    
    public BigDecimal h() throws NumberFormatException {
        final char[] k = this.k;
        if (k != null) {
            return com.fasterxml.jackson.core.io.f.d(k);
        }
        final int c = this.c;
        if (c >= 0) {
            final char[] b = this.b;
            if (b != null) {
                return com.fasterxml.jackson.core.io.f.e(b, c, this.d);
            }
        }
        if (this.g == 0) {
            final char[] h = this.h;
            if (h != null) {
                return com.fasterxml.jackson.core.io.f.e(h, 0, this.i);
            }
        }
        return com.fasterxml.jackson.core.io.f.d(this.g());
    }
    
    public double i() throws NumberFormatException {
        return com.fasterxml.jackson.core.io.f.f(this.l());
    }
    
    public int j(final boolean b) {
        final int c = this.c;
        if (c >= 0) {
            final char[] b2 = this.b;
            if (b2 != null) {
                if (b) {
                    return -com.fasterxml.jackson.core.io.f.g(b2, c + 1, this.d - 1);
                }
                return com.fasterxml.jackson.core.io.f.g(b2, c, this.d);
            }
        }
        if (b) {
            return -com.fasterxml.jackson.core.io.f.g(this.h, 1, this.i - 1);
        }
        return com.fasterxml.jackson.core.io.f.g(this.h, 0, this.i);
    }
    
    public long k(final boolean b) {
        final int c = this.c;
        if (c >= 0) {
            final char[] b2 = this.b;
            if (b2 != null) {
                if (b) {
                    return -com.fasterxml.jackson.core.io.f.h(b2, c + 1, this.d - 1);
                }
                return com.fasterxml.jackson.core.io.f.h(b2, c, this.d);
            }
        }
        if (b) {
            return -com.fasterxml.jackson.core.io.f.h(this.h, 1, this.i - 1);
        }
        return com.fasterxml.jackson.core.io.f.h(this.h, 0, this.i);
    }
    
    public String l() {
        if (this.j == null) {
            final char[] k = this.k;
            if (k != null) {
                this.j = new String(k);
            }
            else {
                final int c = this.c;
                String j = "";
                if (c >= 0) {
                    final int d = this.d;
                    if (d < 1) {
                        return this.j = "";
                    }
                    this.j = new String(this.b, c, d);
                }
                else {
                    final int g = this.g;
                    final int i = this.i;
                    if (g == 0) {
                        if (i != 0) {
                            j = new String(this.h, 0, i);
                        }
                        this.j = j;
                    }
                    else {
                        final StringBuilder sb = new StringBuilder(g + i);
                        final ArrayList<char[]> e = this.e;
                        if (e != null) {
                            for (int size = e.size(), l = 0; l < size; ++l) {
                                final char[] array = this.e.get(l);
                                sb.append(array, 0, array.length);
                            }
                        }
                        sb.append(this.h, 0, this.i);
                        this.j = sb.toString();
                    }
                }
            }
        }
        return this.j;
    }
    
    public char[] m() {
        this.c = -1;
        this.i = 0;
        this.d = 0;
        this.b = null;
        this.j = null;
        this.k = null;
        if (this.f) {
            this.f();
        }
        char[] h;
        if ((h = this.h) == null) {
            h = this.d(0);
            this.h = h;
        }
        return h;
    }
    
    public char[] o() {
        final char[] h = this.h;
        final int length = h.length;
        int n;
        if ((n = (length >> 1) + length) > 262144) {
            n = (length >> 2) + length;
        }
        return this.h = Arrays.copyOf(h, n);
    }
    
    public char[] p() {
        if (this.e == null) {
            this.e = new ArrayList<char[]>();
        }
        this.f = true;
        this.e.add(this.h);
        final int length = this.h.length;
        this.g += length;
        this.i = 0;
        final int n = length + (length >> 1);
        int n2;
        if (n < 1000) {
            n2 = 1000;
        }
        else if ((n2 = n) > 262144) {
            n2 = 262144;
        }
        return this.h = this.e(n2);
    }
    
    public char[] q() {
        return this.h;
    }
    
    public char[] r() {
        if (this.c >= 0) {
            this.F(1);
        }
        else {
            final char[] h = this.h;
            if (h == null) {
                this.h = this.d(0);
            }
            else if (this.i >= h.length) {
                this.n(1);
            }
        }
        return this.h;
    }
    
    public int s() {
        return this.i;
    }
    
    public char[] t() {
        if (this.c >= 0) {
            return this.b;
        }
        final char[] k = this.k;
        if (k != null) {
            return k;
        }
        final String j = this.j;
        if (j != null) {
            return this.k = j.toCharArray();
        }
        if (!this.f) {
            char[] array;
            if ((array = this.h) == null) {
                array = com.fasterxml.jackson.core.util.d.l;
            }
            return array;
        }
        return this.g();
    }
    
    @Override
    public String toString() {
        return this.l();
    }
    
    public int u() {
        int c = this.c;
        if (c < 0) {
            c = 0;
        }
        return c;
    }
    
    public void v() {
        if (this.a == null) {
            this.y();
        }
        else if (this.h != null) {
            this.y();
            final char[] h = this.h;
            this.h = null;
            this.a.j(2, h);
        }
    }
    
    public void w(final String s, final int n, final int n2) {
        this.b = null;
        this.c = -1;
        this.d = 0;
        this.j = null;
        this.k = null;
        if (this.f) {
            this.f();
        }
        else if (this.h == null) {
            this.h = this.d(n2);
        }
        this.g = 0;
        this.i = 0;
        this.b(s, n, n2);
    }
    
    public void x(final char[] array, final int n, final int n2) {
        this.b = null;
        this.c = -1;
        this.d = 0;
        this.j = null;
        this.k = null;
        if (this.f) {
            this.f();
        }
        else if (this.h == null) {
            this.h = this.d(n2);
        }
        this.g = 0;
        this.i = 0;
        this.c(array, n, n2);
    }
    
    public void y() {
        this.c = -1;
        this.i = 0;
        this.d = 0;
        this.b = null;
        this.j = null;
        this.k = null;
        if (this.f) {
            this.f();
        }
    }
    
    public void z(final char[] b, final int c, final int d) {
        this.j = null;
        this.k = null;
        this.b = b;
        this.c = c;
        this.d = d;
        if (this.f) {
            this.f();
        }
    }
}
