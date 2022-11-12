// 
// Decompiled by Procyon v0.6.0
// 

package v2;

import java.io.IOException;
import java.io.InputStream;
import java.io.FilterInputStream;

public class i extends FilterInputStream
{
    private int a;
    
    public i(final InputStream inputStream) {
        super(inputStream);
        this.a = Integer.MIN_VALUE;
    }
    
    private long a(final long n) {
        final int a = this.a;
        if (a == 0) {
            return -1L;
        }
        long n2 = n;
        if (a != Integer.MIN_VALUE) {
            n2 = n;
            if (n > a) {
                n2 = a;
            }
        }
        return n2;
    }
    
    private void c(final long n) {
        final int a = this.a;
        if (a != Integer.MIN_VALUE && n != -1L) {
            this.a = (int)(a - n);
        }
    }
    
    @Override
    public int available() throws IOException {
        final int a = this.a;
        int n;
        if (a == Integer.MIN_VALUE) {
            n = super.available();
        }
        else {
            n = Math.min(a, super.available());
        }
        return n;
    }
    
    @Override
    public void mark(final int a) {
        synchronized (this) {
            super.mark(a);
            this.a = a;
        }
    }
    
    @Override
    public int read() throws IOException {
        if (this.a(1L) == -1L) {
            return -1;
        }
        final int read = super.read();
        this.c(1L);
        return read;
    }
    
    @Override
    public int read(final byte[] array, int read, int n) throws IOException {
        n = (int)this.a(n);
        if (n == -1) {
            return -1;
        }
        read = super.read(array, read, n);
        this.c(read);
        return read;
    }
    
    @Override
    public void reset() throws IOException {
        synchronized (this) {
            super.reset();
            this.a = Integer.MIN_VALUE;
        }
    }
    
    @Override
    public long skip(long n) throws IOException {
        n = this.a(n);
        if (n == -1L) {
            return 0L;
        }
        n = super.skip(n);
        this.c(n);
        return n;
    }
}
