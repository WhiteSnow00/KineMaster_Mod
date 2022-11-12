// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import java.io.IOException;
import e2.b;
import java.io.OutputStream;

public final class c extends OutputStream
{
    private final OutputStream a;
    private byte[] b;
    private b c;
    private int d;
    
    public c(final OutputStream outputStream, final b b) {
        this(outputStream, b, 65536);
    }
    
    c(final OutputStream a, final b c, final int n) {
        this.a = a;
        this.c = c;
        this.b = c.c(n, byte[].class);
    }
    
    private void a() throws IOException {
        final int d = this.d;
        if (d > 0) {
            this.a.write(this.b, 0, d);
            this.d = 0;
        }
    }
    
    private void c() throws IOException {
        if (this.d == this.b.length) {
            this.a();
        }
    }
    
    private void d() {
        final byte[] b = this.b;
        if (b != null) {
            this.c.put(b);
            this.b = null;
        }
    }
    
    @Override
    public void close() throws IOException {
        try {
            this.flush();
            this.a.close();
            this.d();
        }
        finally {
            this.a.close();
        }
    }
    
    @Override
    public void flush() throws IOException {
        this.a();
        this.a.flush();
    }
    
    @Override
    public void write(final int n) throws IOException {
        this.b[this.d++] = (byte)n;
        this.c();
    }
    
    @Override
    public void write(final byte[] array) throws IOException {
        this.write(array, 0, array.length);
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) throws IOException {
        int n3 = 0;
        int n4;
        do {
            final int n5 = n2 - n3;
            final int n6 = n + n3;
            final int d = this.d;
            if (d == 0 && n5 >= this.b.length) {
                this.a.write(array, n6, n5);
                return;
            }
            final int min = Math.min(n5, this.b.length - d);
            System.arraycopy(array, n6, this.b, this.d, min);
            this.d += min;
            n4 = n3 + min;
            this.c();
        } while ((n3 = n4) < n2);
    }
}
