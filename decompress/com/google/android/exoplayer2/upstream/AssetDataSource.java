// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.FileNotFoundException;
import com.google.android.exoplayer2.util.Assertions;
import android.content.Context;
import java.io.InputStream;
import android.net.Uri;
import android.content.res.AssetManager;

public final class AssetDataSource extends BaseDataSource
{
    private final AssetManager e;
    private Uri f;
    private InputStream g;
    private long h;
    private boolean i;
    
    public AssetDataSource(final Context context) {
        super(false);
        this.e = context.getAssets();
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws AssetDataSourceException {
        try {
            final Uri a = dataSpec.a;
            this.f = a;
            final String s = Assertions.e(a.getPath());
            String s2;
            if (s.startsWith("/android_asset/")) {
                s2 = s.substring(15);
            }
            else {
                s2 = s;
                if (s.startsWith("/")) {
                    s2 = s.substring(1);
                }
            }
            this.u(dataSpec);
            final InputStream open = this.e.open(s2, 1);
            this.g = open;
            if (open.skip(dataSpec.g) >= dataSpec.g) {
                final long h = dataSpec.h;
                if (h != -1L) {
                    this.h = h;
                }
                else {
                    final long h2 = this.g.available();
                    this.h = h2;
                    if (h2 == 2147483647L) {
                        this.h = -1L;
                    }
                }
                this.i = true;
                this.v(dataSpec);
                return this.h;
            }
            throw new AssetDataSourceException((Throwable)null, 2008);
        }
        catch (final IOException ex) {
            int n;
            if (ex instanceof FileNotFoundException) {
                n = 2005;
            }
            else {
                n = 2000;
            }
            throw new AssetDataSourceException(ex, n);
        }
        catch (final AssetDataSourceException ex2) {
            throw ex2;
        }
    }
    
    @Override
    public void close() throws AssetDataSourceException {
        this.f = null;
        try {
            try {
                try (final InputStream g = this.g) {}
                this.g = null;
                if (this.i) {
                    this.i = false;
                    this.t();
                }
            }
            finally {
                this.g = null;
                if (this.i) {
                    this.i = false;
                    this.t();
                }
            }
        }
        catch (final IOException ex) {}
    }
    
    @Override
    public Uri q() {
        return this.f;
    }
    
    @Override
    public int read(final byte[] array, int read, int n) throws AssetDataSourceException {
        if (n == 0) {
            return 0;
        }
        final long h = this.h;
        if (h == 0L) {
            return -1;
        }
        Label_0046: {
            if (h == -1L) {
                break Label_0046;
            }
            final long n2 = n;
            try {
                n = (int)Math.min(h, n2);
                read = Util.j(this.g).read(array, read, n);
                if (read == -1) {
                    return -1;
                }
                final long h2 = this.h;
                if (h2 != -1L) {
                    this.h = h2 - read;
                }
                this.s(read);
                return read;
            }
            catch (final IOException ex) {
                throw new AssetDataSourceException(ex, 2000);
            }
        }
    }
    
    public static final class AssetDataSourceException extends DataSourceException
    {
        @Deprecated
        public AssetDataSourceException(final IOException ex) {
            super(ex, 2000);
        }
        
        public AssetDataSourceException(final Throwable t, final int n) {
            super(t, n);
        }
    }
}
