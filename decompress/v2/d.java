// 
// Decompiled by Procyon v0.6.0
// 

package v2;

import java.io.IOException;
import java.util.Queue;
import java.io.InputStream;

public final class d extends InputStream
{
    private static final Queue<d> c;
    private InputStream a;
    private IOException b;
    
    static {
        c = l.f(0);
    }
    
    d() {
    }
    
    public static d c(final InputStream inputStream) {
        Object c = d.c;
        synchronized (c) {
            final d d = ((Queue<d>)c).poll();
            monitorexit(c);
            c = d;
            if (d == null) {
                c = new d();
            }
            ((d)c).e(inputStream);
            return (d)c;
        }
    }
    
    public IOException a() {
        return this.b;
    }
    
    @Override
    public int available() throws IOException {
        return this.a.available();
    }
    
    @Override
    public void close() throws IOException {
        this.a.close();
    }
    
    public void d() {
        this.b = null;
        this.a = null;
        final Queue<d> c = d.c;
        synchronized (c) {
            c.offer(this);
        }
    }
    
    void e(final InputStream a) {
        this.a = a;
    }
    
    @Override
    public void mark(final int n) {
        this.a.mark(n);
    }
    
    @Override
    public boolean markSupported() {
        return this.a.markSupported();
    }
    
    @Override
    public int read() throws IOException {
        try {
            return this.a.read();
        }
        catch (final IOException b) {
            throw this.b = b;
        }
    }
    
    @Override
    public int read(final byte[] array) throws IOException {
        try {
            return this.a.read(array);
        }
        catch (final IOException b) {
            throw this.b = b;
        }
    }
    
    @Override
    public int read(final byte[] array, int read, final int n) throws IOException {
        try {
            read = this.a.read(array, read, n);
            return read;
        }
        catch (final IOException b) {
            throw this.b = b;
        }
    }
    
    @Override
    public void reset() throws IOException {
        synchronized (this) {
            this.a.reset();
        }
    }
    
    @Override
    public long skip(long skip) throws IOException {
        try {
            skip = this.a.skip(skip);
            return skip;
        }
        catch (final IOException b) {
            throw this.b = b;
        }
    }
}
