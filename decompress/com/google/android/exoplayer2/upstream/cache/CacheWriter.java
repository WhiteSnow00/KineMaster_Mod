// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import java.io.InterruptedIOException;
import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;

public final class CacheWriter
{
    private final CacheDataSource a;
    private final Cache b;
    private final DataSpec c;
    private final String d;
    private final byte[] e;
    private final ProgressListener f;
    private long g;
    private long h;
    private long i;
    private volatile boolean j;
    
    public CacheWriter(final CacheDataSource a, final DataSpec c, final byte[] array, final ProgressListener f) {
        this.a = a;
        this.b = a.s();
        this.c = c;
        byte[] e = array;
        if (array == null) {
            e = new byte[131072];
        }
        this.e = e;
        this.f = f;
        this.d = a.t().a(c);
        this.g = c.g;
    }
    
    private long c() {
        final long h = this.h;
        long n = -1L;
        if (h != -1L) {
            n = h - this.c.g;
        }
        return n;
    }
    
    private void d(final long n) {
        this.i += n;
        final ProgressListener f = this.f;
        if (f != null) {
            f.a(this.c(), this.i, n);
        }
    }
    
    private void e(final long h) {
        if (this.h == h) {
            return;
        }
        this.h = h;
        final ProgressListener f = this.f;
        if (f != null) {
            f.a(this.c(), this.i, 0L);
        }
    }
    
    private long f(final long n, long n2) throws IOException {
        final long h = this.h;
        boolean b = true;
        final boolean b2 = n + n2 == h || n2 == -1L;
        Label_0095: {
            if (n2 != -1L) {
                final DataSpec a = this.c.a().h(n).g(n2).a();
                try {
                    n2 = this.a.b(a);
                    break Label_0095;
                }
                catch (final IOException ex) {
                    DataSourceUtil.a(this.a);
                }
            }
            b = false;
            n2 = -1L;
        }
        if (!b) {
            this.g();
            final DataSpec a2 = this.c.a().h(n).g(-1L).a();
            try {
                n2 = this.a.b(a2);
            }
            catch (final IOException ex2) {
                DataSourceUtil.a(this.a);
                throw ex2;
            }
        }
        Label_0179: {
            if (b2 && n2 != -1L) {
                Label_0268: {
                    try {
                        this.e(n2 + n);
                    }
                    catch (final IOException ex3) {
                        break Label_0268;
                    }
                    break Label_0179;
                }
                DataSourceUtil.a(this.a);
                throw;
            }
        }
        int i = 0;
        int n3 = 0;
        while (i != -1) {
            this.g();
            final CacheDataSource a3 = this.a;
            final byte[] e = this.e;
            final int read = a3.read(e, 0, e.length);
            if ((i = read) != -1) {
                this.d(read);
                n3 += read;
                i = read;
            }
        }
        if (b2) {
            this.e(n + n3);
        }
        this.a.close();
        return n3;
    }
    
    private void g() throws InterruptedIOException {
        if (!this.j) {
            return;
        }
        throw new InterruptedIOException();
    }
    
    public void a() throws IOException {
        this.g();
        final Cache b = this.b;
        final String d = this.d;
        final DataSpec c = this.c;
        this.i = b.d(d, c.g, c.h);
        final DataSpec c2 = this.c;
        final long h = c2.h;
        if (h != -1L) {
            this.h = c2.g + h;
        }
        else {
            long d2;
            if ((d2 = ContentMetadata.d(this.b.b(this.d))) == -1L) {
                d2 = -1L;
            }
            this.h = d2;
        }
        final ProgressListener f = this.f;
        if (f != null) {
            f.a(this.c(), this.i, 0L);
        }
        while (true) {
            final long h2 = this.h;
            if (h2 != -1L && this.g >= h2) {
                break;
            }
            this.g();
            final long h3 = this.h;
            long n;
            if (h3 == -1L) {
                n = Long.MAX_VALUE;
            }
            else {
                n = h3 - this.g;
            }
            final long f2 = this.b.f(this.d, this.g, n);
            if (f2 > 0L) {
                this.g += f2;
            }
            else {
                long n2;
                if ((n2 = -f2) == Long.MAX_VALUE) {
                    n2 = -1L;
                }
                final long g = this.g;
                this.g = g + this.f(g, n2);
            }
        }
    }
    
    public void b() {
        this.j = true;
    }
    
    public interface ProgressListener
    {
        void a(final long p0, final long p1, final long p2);
    }
}
