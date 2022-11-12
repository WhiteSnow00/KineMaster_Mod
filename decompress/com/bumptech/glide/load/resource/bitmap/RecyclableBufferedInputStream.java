// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;
import java.io.InputStream;
import e2.b;
import java.io.FilterInputStream;

public class RecyclableBufferedInputStream extends FilterInputStream
{
    private volatile byte[] a;
    private int b;
    private int c;
    private int d;
    private int e;
    private final b f;
    
    public RecyclableBufferedInputStream(final InputStream inputStream, final b b) {
        this(inputStream, b, 65536);
    }
    
    RecyclableBufferedInputStream(final InputStream inputStream, final b f, final int n) {
        super(inputStream);
        this.d = -1;
        this.f = f;
        this.a = f.c(n, byte[].class);
    }
    
    private int a(final InputStream inputStream, final byte[] array) throws IOException {
        final int d = this.d;
        if (d != -1) {
            final int e = this.e;
            int c = this.c;
            if (e - d < c) {
                byte[] a;
                if (d == 0 && c > array.length && this.b == array.length) {
                    final int n = array.length * 2;
                    if (n <= c) {
                        c = n;
                    }
                    a = this.f.c(c, byte[].class);
                    System.arraycopy(array, 0, a, 0, array.length);
                    this.a = a;
                    this.f.put(array);
                }
                else {
                    a = array;
                    if (d > 0) {
                        System.arraycopy(array, d, array, 0, array.length - d);
                        a = array;
                    }
                }
                final int e2 = this.e - this.d;
                this.e = e2;
                this.d = 0;
                this.b = 0;
                final int read = inputStream.read(a, e2, a.length - e2);
                int e3 = this.e;
                if (read > 0) {
                    e3 += read;
                }
                this.b = e3;
                return read;
            }
        }
        final int read2 = inputStream.read(array);
        if (read2 > 0) {
            this.d = -1;
            this.e = 0;
            this.b = read2;
        }
        return read2;
    }
    
    private static IOException e() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }
    
    @Override
    public int available() throws IOException {
        synchronized (this) {
            final InputStream in = super.in;
            if (this.a != null && in != null) {
                final int b = this.b;
                final int e = this.e;
                final int available = in.available();
                monitorexit(this);
                return b - e + available;
            }
            throw e();
        }
    }
    
    public void c() {
        synchronized (this) {
            this.c = this.a.length;
        }
    }
    
    @Override
    public void close() throws IOException {
        if (this.a != null) {
            this.f.put(this.a);
            this.a = null;
        }
        final InputStream in = super.in;
        super.in = null;
        if (in != null) {
            in.close();
        }
    }
    
    public void d() {
        synchronized (this) {
            if (this.a != null) {
                this.f.put(this.a);
                this.a = null;
            }
        }
    }
    
    @Override
    public void mark(final int n) {
        synchronized (this) {
            this.c = Math.max(this.c, n);
            this.d = this.e;
        }
    }
    
    @Override
    public boolean markSupported() {
        return true;
    }
    
    @Override
    public int read() throws IOException {
        synchronized (this) {
            final byte[] a = this.a;
            final InputStream in = super.in;
            if (a == null || in == null) {
                throw e();
            }
            if (this.e >= this.b && this.a(in, a) == -1) {
                return -1;
            }
            byte[] a2;
            if ((a2 = a) != this.a) {
                a2 = this.a;
                if (a2 == null) {
                    throw e();
                }
            }
            final int b = this.b;
            final int e = this.e;
            if (b - e > 0) {
                this.e = e + 1;
                final byte b2 = a2[e];
                monitorexit(this);
                return b2 & 0xFF;
            }
            return -1;
        }
    }
    
    @Override
    public int read(final byte[] array, int n, final int n2) throws IOException {
        synchronized (this) {
            byte[] a = this.a;
            if (a == null) {
                throw e();
            }
            if (n2 == 0) {
                return 0;
            }
            final InputStream in = super.in;
            if (in == null) {
                throw e();
            }
            final int e = this.e;
            final int b = this.b;
            int n5;
            if (e < b) {
                int n3;
                if (b - e >= n2) {
                    n3 = n2;
                }
                else {
                    n3 = b - e;
                }
                System.arraycopy(a, e, array, n, n3);
                this.e += n3;
                if (n3 == n2 || in.available() == 0) {
                    return n3;
                }
                final int n4 = n + n3;
                n = n2 - n3;
                n5 = n4;
            }
            else {
                n5 = n;
                n = n2;
            }
            while (true) {
                final int d = this.d;
                int n6 = -1;
                int read;
                if (d == -1 && n >= a.length) {
                    if ((read = in.read(array, n5, n)) == -1) {
                        if (n != n2) {
                            n6 = n2 - n;
                        }
                        return n6;
                    }
                }
                else {
                    if (this.a(in, a) == -1) {
                        if (n != n2) {
                            n6 = n2 - n;
                        }
                        return n6;
                    }
                    byte[] a2;
                    if ((a2 = a) != this.a) {
                        a2 = this.a;
                        if (a2 == null) {
                            throw e();
                        }
                    }
                    final int b2 = this.b;
                    final int e2 = this.e;
                    int n7;
                    if (b2 - e2 >= n) {
                        n7 = n;
                    }
                    else {
                        n7 = b2 - e2;
                    }
                    System.arraycopy(a2, e2, array, n5, n7);
                    this.e += n7;
                    read = n7;
                    a = a2;
                }
                n -= read;
                if (n == 0) {
                    return n2;
                }
                if (in.available() == 0) {
                    monitorexit(this);
                    return n2 - n;
                }
                n5 += read;
            }
        }
    }
    
    @Override
    public void reset() throws IOException {
        synchronized (this) {
            if (this.a == null) {
                throw new IOException("Stream is closed");
            }
            final int d = this.d;
            if (-1 != d) {
                this.e = d;
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Mark has been invalidated, pos: ");
            sb.append(this.e);
            sb.append(" markLimit: ");
            sb.append(this.c);
            throw new InvalidMarkException(sb.toString());
        }
    }
    
    @Override
    public long skip(long skip) throws IOException {
        monitorenter(this);
        if (skip < 1L) {
            monitorexit(this);
            return 0L;
        }
        try {
            final byte[] a = this.a;
            if (a == null) {
                throw e();
            }
            final InputStream in = super.in;
            if (in == null) {
                throw e();
            }
            final int b = this.b;
            final int e = this.e;
            if (b - e >= skip) {
                this.e = (int)(e + skip);
                return skip;
            }
            final long n = b - (long)e;
            this.e = b;
            if (this.d == -1 || skip > this.c) {
                skip = in.skip(skip - n);
                if (skip > 0L) {
                    this.d = -1;
                }
                monitorexit(this);
                return n + skip;
            }
            if (this.a(in, a) == -1) {
                return n;
            }
            final int b2 = this.b;
            final int e2 = this.e;
            if (b2 - e2 >= skip - n) {
                this.e = (int)(e2 + skip - n);
                return skip;
            }
            final long n2 = b2;
            skip = e2;
            this.e = b2;
            monitorexit(this);
            return n + n2 - skip;
        }
        finally {
            monitorexit(this);
        }
    }
    
    static class InvalidMarkException extends IOException
    {
        private static final long serialVersionUID = -4338378848813561757L;
        
        InvalidMarkException(final String s) {
            super(s);
        }
    }
}
