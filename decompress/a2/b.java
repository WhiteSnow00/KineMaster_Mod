// 
// Decompiled by Procyon v0.6.0
// 

package a2;

import java.io.UnsupportedEncodingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.io.InputStream;
import java.io.Closeable;

class b implements Closeable
{
    private final InputStream a;
    private final Charset b;
    private byte[] c;
    private int d;
    private int e;
    
    public b(final InputStream a, final int n, final Charset b) {
        if (a == null || b == null) {
            throw null;
        }
        if (n < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (b.equals(a2.c.a)) {
            this.a = a;
            this.b = b;
            this.c = new byte[n];
            return;
        }
        throw new IllegalArgumentException("Unsupported encoding");
    }
    
    public b(final InputStream inputStream, final Charset charset) {
        this(inputStream, 8192, charset);
    }
    
    static Charset a(final b b) {
        return b.b;
    }
    
    private void c() throws IOException {
        final InputStream a = this.a;
        final byte[] c = this.c;
        final int read = a.read(c, 0, c.length);
        if (read != -1) {
            this.d = 0;
            this.e = read;
            return;
        }
        throw new EOFException();
    }
    
    @Override
    public void close() throws IOException {
        synchronized (this.a) {
            if (this.c != null) {
                this.c = null;
                this.a.close();
            }
        }
    }
    
    public boolean d() {
        return this.e == -1;
    }
    
    public String e() throws IOException {
        synchronized (this.a) {
            if (this.c != null) {
                if (this.d >= this.e) {
                    this.c();
                }
                for (int i = this.d; i != this.e; ++i) {
                    final byte[] c = this.c;
                    if (c[i] == 10) {
                        final int d = this.d;
                        int n = 0;
                        Label_0087: {
                            if (i != d) {
                                n = i - 1;
                                if (c[n] == 13) {
                                    break Label_0087;
                                }
                            }
                            n = i;
                        }
                        final String s = new String(c, d, n - d, this.b.name());
                        this.d = i + 1;
                        return s;
                    }
                }
                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this, this.e - this.d + 80) {
                    final b a;
                    
                    @Override
                    public String toString() {
                        int count;
                        final int n = count = super.count;
                        if (n > 0) {
                            count = n;
                            if (super.buf[n - 1] == 13) {
                                count = n - 1;
                            }
                        }
                        try {
                            return new String(super.buf, 0, count, a2.b.a(this.a).name());
                        }
                        catch (final UnsupportedEncodingException ex) {
                            throw new AssertionError((Object)ex);
                        }
                    }
                };
                int j = 0;
                byte[] c3 = null;
            Block_10:
                while (true) {
                    final byte[] c2 = this.c;
                    final int d2 = this.d;
                    byteArrayOutputStream.write(c2, d2, this.e - d2);
                    this.e = -1;
                    this.c();
                    for (j = this.d; j != this.e; ++j) {
                        c3 = this.c;
                        if (c3[j] == 10) {
                            break Block_10;
                        }
                    }
                }
                final int d3 = this.d;
                if (j != d3) {
                    byteArrayOutputStream.write(c3, d3, j - d3);
                }
                this.d = j + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }
}
