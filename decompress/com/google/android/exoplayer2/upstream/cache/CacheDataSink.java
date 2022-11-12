// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Closeable;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import java.io.OutputStream;
import java.io.File;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSink;

public final class CacheDataSink implements DataSink
{
    private final Cache a;
    private final long b;
    private final int c;
    private DataSpec d;
    private long e;
    private File f;
    private OutputStream g;
    private long h;
    private long i;
    private e j;
    
    public CacheDataSink(final Cache cache, long b, final int c) {
        Assertions.h(b > 0L || b == -1L, "fragmentSize must be positive or C.LENGTH_UNSET.");
        final long n = lcmp(b, -1L);
        if (n != 0 && b < 2097152L) {
            Log.i("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.a = Assertions.e(cache);
        if (n == 0) {
            b = Long.MAX_VALUE;
        }
        this.b = b;
        this.c = c;
    }
    
    private void a() throws IOException {
        final OutputStream g = this.g;
        if (g == null) {
            return;
        }
        try {
            g.flush();
            Util.n(this.g);
            this.g = null;
            final File file = Util.j(this.f);
            this.f = null;
            this.a.k(file, this.h);
        }
        finally {
            Util.n(this.g);
            this.g = null;
            final File file2 = Util.j(this.f);
            this.f = null;
            file2.delete();
        }
    }
    
    private void c(final DataSpec dataSpec) throws IOException {
        final long h = dataSpec.h;
        long min = -1L;
        if (h != -1L) {
            min = Math.min(h - this.i, this.e);
        }
        this.f = this.a.a(Util.j(dataSpec.i), dataSpec.g + this.i, min);
        final FileOutputStream g = new FileOutputStream(this.f);
        if (this.c > 0) {
            final e j = this.j;
            if (j == null) {
                this.j = new e(g, this.c);
            }
            else {
                j.a(g);
            }
            this.g = this.j;
        }
        else {
            this.g = g;
        }
        this.h = 0L;
    }
    
    @Override
    public void b(final DataSpec d) throws CacheDataSinkException {
        Assertions.e(d.i);
        if (d.h == -1L && d.d(2)) {
            this.d = null;
            return;
        }
        this.d = d;
        long b;
        if (d.d(4)) {
            b = this.b;
        }
        else {
            b = Long.MAX_VALUE;
        }
        this.e = b;
        this.i = 0L;
        try {
            this.c(d);
        }
        catch (final IOException ex) {
            throw new CacheDataSinkException(ex);
        }
    }
    
    @Override
    public void close() throws CacheDataSinkException {
        if (this.d == null) {
            return;
        }
        try {
            this.a();
        }
        catch (final IOException ex) {
            throw new CacheDataSinkException(ex);
        }
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) throws CacheDataSinkException {
        final DataSpec d = this.d;
        if (d == null) {
            return;
        }
        int i = 0;
        while (i < n2) {
            try {
                if (this.h == this.e) {
                    this.a();
                    this.c(d);
                }
                final int n3 = (int)Math.min(n2 - i, this.e - this.h);
                Util.j(this.g).write(array, n + i, n3);
                i += n3;
                final long h = this.h;
                final long n4 = n3;
                this.h = h + n4;
                this.i += n4;
                continue;
            }
            catch (final IOException ex) {
                throw new CacheDataSinkException(ex);
            }
            break;
        }
    }
    
    public static final class CacheDataSinkException extends CacheException
    {
        public CacheDataSinkException(final IOException ex) {
            super(ex);
        }
    }
    
    public static final class Factory implements DataSink.Factory
    {
        private Cache a;
        private long b;
        private int c;
        
        public Factory() {
            this.b = 5242880L;
            this.c = 20480;
        }
        
        @Override
        public DataSink a() {
            return new CacheDataSink(Assertions.e(this.a), this.b, this.c);
        }
        
        public Factory b(final Cache a) {
            this.a = a;
            return this;
        }
    }
}
