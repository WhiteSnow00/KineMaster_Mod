// 
// Decompiled by Procyon v0.6.0
// 

package v2;

import java.io.IOException;
import java.io.InputStream;
import java.io.FilterInputStream;

public final class c extends FilterInputStream
{
    private final long a;
    private int b;
    
    private c(final InputStream inputStream, final long a) {
        super(inputStream);
        this.a = a;
    }
    
    private int a(final int n) throws IOException {
        if (n >= 0) {
            this.b += n;
        }
        else if (this.a - this.b > 0L) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to read all expected data, expected: ");
            sb.append(this.a);
            sb.append(", but read: ");
            sb.append(this.b);
            throw new IOException(sb.toString());
        }
        return n;
    }
    
    public static InputStream c(final InputStream inputStream, final long n) {
        return new c(inputStream, n);
    }
    
    @Override
    public int available() throws IOException {
        synchronized (this) {
            return (int)Math.max(this.a - this.b, super.in.available());
        }
    }
    
    @Override
    public int read() throws IOException {
        synchronized (this) {
            final int read = super.read();
            int n;
            if (read >= 0) {
                n = 1;
            }
            else {
                n = -1;
            }
            this.a(n);
            return read;
        }
    }
    
    @Override
    public int read(final byte[] array) throws IOException {
        return this.read(array, 0, array.length);
    }
    
    @Override
    public int read(final byte[] array, int a, final int n) throws IOException {
        synchronized (this) {
            a = this.a(super.read(array, a, n));
            return a;
        }
    }
}
