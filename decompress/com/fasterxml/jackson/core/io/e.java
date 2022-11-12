// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;

public final class e extends InputStream
{
    private final c a;
    private final InputStream b;
    private byte[] c;
    private int d;
    private final int e;
    
    public e(final c a, final InputStream b, final byte[] c, final int d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    private void a() {
        final byte[] c = this.c;
        if (c != null) {
            this.c = null;
            final c a = this.a;
            if (a != null) {
                a.o(c);
            }
        }
    }
    
    @Override
    public int available() throws IOException {
        if (this.c != null) {
            return this.e - this.d;
        }
        return this.b.available();
    }
    
    @Override
    public void close() throws IOException {
        this.a();
        this.b.close();
    }
    
    @Override
    public void mark(final int n) {
        if (this.c == null) {
            this.b.mark(n);
        }
    }
    
    @Override
    public boolean markSupported() {
        return this.c == null && this.b.markSupported();
    }
    
    @Override
    public int read() throws IOException {
        final byte[] c = this.c;
        if (c != null) {
            final int d = this.d;
            final int d2 = d + 1;
            this.d = d2;
            final byte b = c[d];
            if (d2 >= this.e) {
                this.a();
            }
            return b & 0xFF;
        }
        return this.b.read();
    }
    
    @Override
    public int read(final byte[] array) throws IOException {
        return this.read(array, 0, array.length);
    }
    
    @Override
    public int read(final byte[] array, int d, final int n) throws IOException {
        final byte[] c = this.c;
        if (c != null) {
            final int e = this.e;
            final int d2 = this.d;
            final int n2 = e - d2;
            int n3;
            if ((n3 = n) > n2) {
                n3 = n2;
            }
            System.arraycopy(c, d2, array, d, n3);
            d = this.d + n3;
            if ((this.d = d) >= this.e) {
                this.a();
            }
            return n3;
        }
        return this.b.read(array, d, n);
    }
    
    @Override
    public void reset() throws IOException {
        if (this.c == null) {
            this.b.reset();
        }
    }
    
    @Override
    public long skip(long n) throws IOException {
        long n5;
        if (this.c != null) {
            final int e = this.e;
            final int d = this.d;
            final long n2 = e - d;
            if (n2 > n) {
                this.d = d + (int)n;
                return n;
            }
            this.a();
            final long n3 = n2 + 0L;
            final long n4 = n - n2;
            n = n3;
            n5 = n4;
        }
        else {
            final long n6 = 0L;
            n5 = n;
            n = n6;
        }
        long n7 = n;
        if (n5 > 0L) {
            n7 = n + this.b.skip(n5);
        }
        return n7;
    }
}
