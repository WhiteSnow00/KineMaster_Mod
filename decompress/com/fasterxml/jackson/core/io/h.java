// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class h extends Reader
{
    protected final c a;
    protected InputStream b;
    protected byte[] c;
    protected int d;
    protected int e;
    protected final boolean f;
    protected char g;
    protected int h;
    protected int i;
    protected final boolean j;
    protected char[] p;
    
    public h(final c a, final InputStream b, final byte[] c, final int d, final int e, final boolean f) {
        final boolean b2 = false;
        this.g = '\0';
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        boolean j = b2;
        if (b != null) {
            j = true;
        }
        this.j = j;
    }
    
    private void a() {
        final byte[] c = this.c;
        if (c != null) {
            this.c = null;
            this.a.o(c);
        }
    }
    
    private boolean c(int n) throws IOException {
        this.i += this.e - n;
        if (n > 0) {
            final int d = this.d;
            if (d > 0) {
                final byte[] c = this.c;
                System.arraycopy(c, d, c, 0, n);
                this.d = 0;
            }
            this.e = n;
        }
        else {
            this.d = 0;
            final InputStream b = this.b;
            if (b == null) {
                n = -1;
            }
            else {
                n = b.read(this.c);
            }
            if (n < 1) {
                this.e = 0;
                if (n < 0) {
                    if (this.j) {
                        this.a();
                    }
                    return false;
                }
                this.h();
            }
            this.e = n;
        }
        while (true) {
            n = this.e;
            if (n >= 4) {
                break;
            }
            final InputStream b2 = this.b;
            if (b2 == null) {
                n = -1;
            }
            else {
                final byte[] c2 = this.c;
                n = b2.read(c2, n, c2.length - n);
            }
            if (n < 1) {
                if (n < 0) {
                    if (this.j) {
                        this.a();
                    }
                    this.i(this.e, 4);
                }
                this.h();
            }
            this.e += n;
        }
        return true;
    }
    
    private void d(final char[] array, final int n, final int n2) throws IOException {
        final StringBuilder sb = new StringBuilder();
        sb.append("read(buf,");
        sb.append(n);
        sb.append(",");
        sb.append(n2);
        sb.append("), cbuf[");
        sb.append(array.length);
        sb.append("]");
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }
    
    private void e(final int n, final int n2, final String s) throws IOException {
        final int i = this.i;
        final int d = this.d;
        final int h = this.h;
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-32 character 0x");
        sb.append(Integer.toHexString(n));
        sb.append(s);
        sb.append(" at char #");
        sb.append(h + n2);
        sb.append(", byte #");
        sb.append(i + d - 1);
        sb.append(")");
        throw new CharConversionException(sb.toString());
    }
    
    private void h() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
    
    private void i(final int n, final int n2) throws IOException {
        final int i = this.i;
        final int h = this.h;
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected EOF in the middle of a 4-byte UTF-32 char: got ");
        sb.append(n);
        sb.append(", needed ");
        sb.append(n2);
        sb.append(", at char #");
        sb.append(h);
        sb.append(", byte #");
        sb.append(i + n);
        sb.append(")");
        throw new CharConversionException(sb.toString());
    }
    
    @Override
    public void close() throws IOException {
        final InputStream b = this.b;
        if (b != null) {
            this.b = null;
            this.a();
            b.close();
        }
    }
    
    @Override
    public int read() throws IOException {
        if (this.p == null) {
            this.p = new char[1];
        }
        if (this.read(this.p, 0, 1) < 1) {
            return -1;
        }
        return this.p[0];
    }
    
    @Override
    public int read(final char[] array, int n, int n2) throws IOException {
        if (this.c == null) {
            return -1;
        }
        if (n2 < 1) {
            return n2;
        }
        if (n < 0 || n + n2 > array.length) {
            this.d(array, n, n2);
        }
        final int n3 = n2 + n;
        final char g = this.g;
        if (g != '\0') {
            n2 = n + 1;
            array[n] = g;
            this.g = '\0';
        }
        else {
            n2 = this.e - this.d;
            if (n2 < 4 && !this.c(n2)) {
                if (n2 == 0) {
                    return -1;
                }
                this.i(this.e - this.d, 4);
            }
            n2 = n;
        }
        final int e = this.e;
        int n4 = 0;
        Label_0428: {
            Label_0419: {
                int n10;
                int n11;
                while (true) {
                    n4 = n2;
                    if (n2 >= n3) {
                        break Label_0428;
                    }
                    final int d = this.d;
                    int n5;
                    int n6;
                    if (this.f) {
                        final byte[] c = this.c;
                        n5 = (c[d] << 8 | (c[d + 1] & 0xFF));
                        n6 = ((c[d + 3] & 0xFF) | (c[d + 2] & 0xFF) << 8);
                    }
                    else {
                        final byte[] c2 = this.c;
                        final byte b = c2[d];
                        final byte b2 = c2[d + 1];
                        n5 = (c2[d + 3] << 8 | (c2[d + 2] & 0xFF));
                        n6 = ((b & 0xFF) | (b2 & 0xFF) << 8);
                    }
                    this.d = d + 4;
                    int n7 = n2;
                    int n8 = n6;
                    if (n5 != 0) {
                        final int n9 = 0xFFFF & n5;
                        n10 = (n6 | n9 - 1 << 16);
                        if (n9 > 16) {
                            this.e(n10, n2 - n, String.format(" (above 0x%08x)", 1114111));
                        }
                        n11 = n2 + 1;
                        array[n2] = (char)((n10 >> 10) + 55296);
                        if (n11 >= n3) {
                            break;
                        }
                        n8 = (0xDC00 | (n10 & 0x3FF));
                        n7 = n11;
                    }
                    n2 = n7 + 1;
                    array[n7] = (char)n8;
                    if (this.d > e - 4) {
                        break Label_0419;
                    }
                }
                this.g = (char)n10;
                n2 = n11;
            }
            n4 = n2;
        }
        n = n4 - n;
        this.h += n;
        return n;
    }
}
