// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.io.InputStream;

public final class DataSourceInputStream extends InputStream
{
    private final DataSource a;
    private final DataSpec b;
    private final byte[] c;
    private boolean d;
    private boolean e;
    private long f;
    
    public DataSourceInputStream(final DataSource a, final DataSpec b) {
        this.d = false;
        this.e = false;
        this.a = a;
        this.b = b;
        this.c = new byte[1];
    }
    
    private void a() throws IOException {
        if (!this.d) {
            this.a.b(this.b);
            this.d = true;
        }
    }
    
    public void c() throws IOException {
        this.a();
    }
    
    @Override
    public void close() throws IOException {
        if (!this.e) {
            this.a.close();
            this.e = true;
        }
    }
    
    @Override
    public int read() throws IOException {
        final int read = this.read(this.c);
        int n = -1;
        if (read != -1) {
            n = (this.c[0] & 0xFF);
        }
        return n;
    }
    
    @Override
    public int read(final byte[] array) throws IOException {
        return this.read(array, 0, array.length);
    }
    
    @Override
    public int read(final byte[] array, int read, final int n) throws IOException {
        Assertions.g(this.e ^ true);
        this.a();
        read = this.a.read(array, read, n);
        if (read == -1) {
            return -1;
        }
        this.f += read;
        return read;
    }
}
