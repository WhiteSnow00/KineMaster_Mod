// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class i extends Writer
{
    private final c a;
    private OutputStream b;
    private byte[] c;
    private final int d;
    private int e;
    private int f;
    
    public i(final c a, final OutputStream b) {
        this.a = a;
        this.b = b;
        final byte[] h = a.h();
        this.c = h;
        this.d = h.length - 4;
        this.e = 0;
    }
    
    protected static void c(final int n) throws IOException {
        throw new IOException(d(n));
    }
    
    protected static String d(final int n) {
        if (n > 1114111) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Illegal character point (0x");
            sb.append(Integer.toHexString(n));
            sb.append(") to output; max is 0x10FFFF as per RFC 4627");
            return sb.toString();
        }
        if (n < 55296) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Illegal character point (0x");
            sb2.append(Integer.toHexString(n));
            sb2.append(") to output");
            return sb2.toString();
        }
        if (n <= 56319) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Unmatched first part of surrogate pair (0x");
            sb3.append(Integer.toHexString(n));
            sb3.append(")");
            return sb3.toString();
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("Unmatched second part of surrogate pair (0x");
        sb4.append(Integer.toHexString(n));
        sb4.append(")");
        return sb4.toString();
    }
    
    protected int a(final int n) throws IOException {
        final int f = this.f;
        this.f = 0;
        if (n >= 56320 && n <= 57343) {
            return (f - 55296 << 10) + 65536 + (n - 56320);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Broken surrogate pair: first char 0x");
        sb.append(Integer.toHexString(f));
        sb.append(", second 0x");
        sb.append(Integer.toHexString(n));
        sb.append("; illegal combination");
        throw new IOException(sb.toString());
    }
    
    @Override
    public Writer append(final char c) throws IOException {
        this.write(c);
        return this;
    }
    
    @Override
    public /* bridge */ Appendable append(final char c) throws IOException {
        return this.append(c);
    }
    
    @Override
    public void close() throws IOException {
        final OutputStream b = this.b;
        if (b != null) {
            final int e = this.e;
            if (e > 0) {
                b.write(this.c, 0, e);
                this.e = 0;
            }
            final OutputStream b2 = this.b;
            this.b = null;
            final byte[] c = this.c;
            if (c != null) {
                this.c = null;
                this.a.q(c);
            }
            b2.close();
            final int f = this.f;
            this.f = 0;
            if (f > 0) {
                c(f);
            }
        }
    }
    
    @Override
    public void flush() throws IOException {
        final OutputStream b = this.b;
        if (b != null) {
            final int e = this.e;
            if (e > 0) {
                b.write(this.c, 0, e);
                this.e = 0;
            }
            this.b.flush();
        }
    }
    
    @Override
    public void write(int n) throws IOException {
        int a;
        if (this.f > 0) {
            a = this.a(n);
        }
        else {
            a = n;
            if (n >= 55296 && (a = n) <= 57343) {
                if (n > 56319) {
                    c(n);
                }
                this.f = n;
                return;
            }
        }
        n = this.e;
        if (n >= this.d) {
            this.b.write(this.c, 0, n);
            this.e = 0;
        }
        if (a < 128) {
            final byte[] c = this.c;
            n = this.e++;
            c[n] = (byte)a;
        }
        else {
            n = this.e;
            if (a < 2048) {
                final byte[] c2 = this.c;
                final int n2 = n + 1;
                c2[n] = (byte)(a >> 6 | 0xC0);
                n = n2 + 1;
                c2[n2] = (byte)((a & 0x3F) | 0x80);
            }
            else if (a <= 65535) {
                final byte[] c3 = this.c;
                final int n3 = n + 1;
                c3[n] = (byte)(a >> 12 | 0xE0);
                n = n3 + 1;
                c3[n3] = (byte)((a >> 6 & 0x3F) | 0x80);
                c3[n] = (byte)((a & 0x3F) | 0x80);
                ++n;
            }
            else {
                if (a > 1114111) {
                    c(a);
                }
                final byte[] c4 = this.c;
                final int n4 = n + 1;
                c4[n] = (byte)(a >> 18 | 0xF0);
                n = n4 + 1;
                c4[n4] = (byte)((a >> 12 & 0x3F) | 0x80);
                final int n5 = n + 1;
                c4[n] = (byte)((a >> 6 & 0x3F) | 0x80);
                n = n5 + 1;
                c4[n5] = (byte)((a & 0x3F) | 0x80);
            }
            this.e = n;
        }
    }
    
    @Override
    public void write(final String s) throws IOException {
        this.write(s, 0, s.length());
    }
    
    @Override
    public void write(final String s, int e, int i) throws IOException {
        if (i < 2) {
            if (i == 1) {
                this.write(s.charAt(e));
            }
            return;
        }
        int n = e;
        int n2 = i;
        if (this.f > 0) {
            final char char1 = s.charAt(e);
            n2 = i - 1;
            this.write(this.a(char1));
            n = e + 1;
        }
        e = this.e;
        final byte[] c = this.c;
        final int d = this.d;
        final int n3 = n2 + n;
        i = n;
        int e2;
        while (true) {
            e2 = e;
            if (i >= n3) {
                break;
            }
            int n4;
            if ((n4 = e) >= d) {
                this.b.write(c, 0, e);
                n4 = 0;
            }
            final int n5 = i + 1;
            final char char2 = s.charAt(i);
            i = n4;
            e = n5;
            char f = '\0';
            Label_0255: {
                if ((f = char2) < '\u0080') {
                    e = n4 + 1;
                    c[n4] = (byte)char2;
                    i = n3 - n5;
                    final int n6 = d - e;
                    int n7;
                    if ((n7 = i) > n6) {
                        n7 = n6;
                    }
                    int n8;
                    char char3;
                    int n9;
                    for (i = n5; i < n7 + n5; i = n8, e = n9) {
                        n8 = i + 1;
                        char3 = s.charAt(i);
                        if (char3 >= '\u0080') {
                            i = e;
                            e = n8;
                            f = char3;
                            break Label_0255;
                        }
                        n9 = e + 1;
                        c[e] = (byte)char3;
                    }
                    continue;
                }
            }
            if (f < '\u0800') {
                final int n10 = i + 1;
                c[i] = (byte)(f >> 6 | 0xC0);
                final int n11 = n10 + 1;
                c[n10] = (byte)((f & '?') | 0x80);
                i = e;
                e = n11;
            }
            else if (f >= '\ud800' && f <= '\udfff') {
                if (f > '\udbff') {
                    this.e = i;
                    c(f);
                }
                this.f = f;
                if (e >= n3) {
                    e2 = i;
                    break;
                }
                final int n12 = e + 1;
                final int a = this.a(s.charAt(e));
                if (a > 1114111) {
                    this.e = i;
                    c(a);
                }
                e = i + 1;
                c[i] = (byte)(a >> 18 | 0xF0);
                final int n13 = e + 1;
                c[e] = (byte)((a >> 12 & 0x3F) | 0x80);
                i = n13 + 1;
                c[n13] = (byte)((a >> 6 & 0x3F) | 0x80);
                e = i + 1;
                c[i] = (byte)((a & 0x3F) | 0x80);
                i = n12;
            }
            else {
                final int n14 = i + 1;
                c[i] = (byte)(f >> 12 | 0xE0);
                final int n15 = n14 + 1;
                c[n14] = (byte)((f >> 6 & 0x3F) | 0x80);
                c[n15] = (byte)((f & '?') | 0x80);
                i = e;
                e = n15 + 1;
            }
        }
        this.e = e2;
    }
    
    @Override
    public void write(final char[] array) throws IOException {
        this.write(array, 0, array.length);
    }
    
    @Override
    public void write(final char[] array, int e, int i) throws IOException {
        if (i < 2) {
            if (i == 1) {
                this.write(array[e]);
            }
            return;
        }
        int n = e;
        int n2 = i;
        if (this.f > 0) {
            final char c = array[e];
            n2 = i - 1;
            this.write(this.a(c));
            n = e + 1;
        }
        e = this.e;
        final byte[] c2 = this.c;
        final int d = this.d;
        final int n3 = n2 + n;
        i = n;
        int e2;
        while (true) {
            e2 = e;
            if (i >= n3) {
                break;
            }
            int n4;
            if ((n4 = e) >= d) {
                this.b.write(c2, 0, e);
                n4 = 0;
            }
            final int n5 = i + 1;
            final char c3 = array[i];
            i = n4;
            e = n5;
            char f = '\0';
            Label_0247: {
                if ((f = c3) < '\u0080') {
                    e = n4 + 1;
                    c2[n4] = (byte)c3;
                    i = n3 - n5;
                    final int n6 = d - e;
                    int n7;
                    if ((n7 = i) > n6) {
                        n7 = n6;
                    }
                    int n8;
                    char c4;
                    int n9;
                    for (i = n5; i < n7 + n5; i = n8, e = n9) {
                        n8 = i + 1;
                        c4 = array[i];
                        if (c4 >= '\u0080') {
                            i = e;
                            e = n8;
                            f = c4;
                            break Label_0247;
                        }
                        n9 = e + 1;
                        c2[e] = (byte)c4;
                    }
                    continue;
                }
            }
            if (f < '\u0800') {
                final int n10 = i + 1;
                c2[i] = (byte)(f >> 6 | 0xC0);
                final int n11 = n10 + 1;
                c2[n10] = (byte)((f & '?') | 0x80);
                i = e;
                e = n11;
            }
            else if (f >= '\ud800' && f <= '\udfff') {
                if (f > '\udbff') {
                    this.e = i;
                    c(f);
                }
                this.f = f;
                if (e >= n3) {
                    e2 = i;
                    break;
                }
                final int n12 = e + 1;
                final int a = this.a(array[e]);
                if (a > 1114111) {
                    this.e = i;
                    c(a);
                }
                final int n13 = i + 1;
                c2[i] = (byte)(a >> 18 | 0xF0);
                e = n13 + 1;
                c2[n13] = (byte)((a >> 12 & 0x3F) | 0x80);
                i = e + 1;
                c2[e] = (byte)((a >> 6 & 0x3F) | 0x80);
                e = i + 1;
                c2[i] = (byte)((a & 0x3F) | 0x80);
                i = n12;
            }
            else {
                final int n14 = i + 1;
                c2[i] = (byte)(f >> 12 | 0xE0);
                final int n15 = n14 + 1;
                c2[n14] = (byte)((f >> 6 & 0x3F) | 0x80);
                c2[n15] = (byte)((f & '?') | 0x80);
                i = e;
                e = n15 + 1;
            }
        }
        this.e = e2;
    }
}
