// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import android.system.OsConstants;
import android.system.ErrnoException;
import java.io.IOException;
import java.io.FileNotFoundException;
import com.google.android.exoplayer2.util.Util;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import android.net.Uri;
import java.io.RandomAccessFile;

public final class FileDataSource extends BaseDataSource
{
    private RandomAccessFile e;
    private Uri f;
    private long g;
    private boolean h;
    
    public FileDataSource() {
        super(false);
    }
    
    private static RandomAccessFile w(final Uri uri) throws FileDataSourceException {
        int n = 2006;
        try {
            return new RandomAccessFile(Assertions.e(uri.getPath()), "r");
        }
        catch (final RuntimeException ex) {
            throw new FileDataSourceException(ex, 2000);
        }
        catch (final SecurityException ex2) {
            throw new FileDataSourceException(ex2, 2006);
        }
        catch (final FileNotFoundException ex3) {
            if (TextUtils.isEmpty((CharSequence)uri.getQuery()) && TextUtils.isEmpty((CharSequence)uri.getFragment())) {
                if (Util.a < 21 || !a.a(ex3.getCause())) {
                    n = 2005;
                }
                throw new FileDataSourceException(ex3, n);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), ex3, 1004);
        }
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws FileDataSourceException {
        final Uri a = dataSpec.a;
        this.f = a;
        this.u(dataSpec);
        final RandomAccessFile w = w(a);
        this.e = w;
        try {
            w.seek(dataSpec.g);
            long h;
            if ((h = dataSpec.h) == -1L) {
                h = this.e.length() - dataSpec.g;
            }
            this.g = h;
            if (h >= 0L) {
                this.h = true;
                this.v(dataSpec);
                return this.g;
            }
            throw new FileDataSourceException(null, null, 2008);
        }
        catch (final IOException ex) {
            throw new FileDataSourceException(ex, 2000);
        }
    }
    
    @Override
    public void close() throws FileDataSourceException {
        this.f = null;
        try {
            try {
                try (final RandomAccessFile e = this.e) {}
                this.e = null;
                if (this.h) {
                    this.h = false;
                    this.t();
                }
            }
            finally {
                this.e = null;
                if (this.h) {
                    this.h = false;
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
    public int read(final byte[] array, int read, final int n) throws FileDataSourceException {
        if (n == 0) {
            return 0;
        }
        if (this.g == 0L) {
            return -1;
        }
        try {
            read = Util.j(this.e).read(array, read, (int)Math.min(this.g, n));
            if (read > 0) {
                this.g -= read;
                this.s(read);
            }
            return read;
        }
        catch (final IOException ex) {
            throw new FileDataSourceException(ex, 2000);
        }
    }
    
    public static final class Factory implements DataSource.Factory
    {
        private TransferListener a;
        
        public FileDataSource a() {
            final FileDataSource fileDataSource = new FileDataSource();
            final TransferListener a = this.a;
            if (a != null) {
                fileDataSource.e(a);
            }
            return fileDataSource;
        }
        
        @Override
        public /* bridge */ DataSource createDataSource() {
            return this.a();
        }
    }
    
    public static class FileDataSourceException extends DataSourceException
    {
        @Deprecated
        public FileDataSourceException(final Exception ex) {
            super(ex, 2000);
        }
        
        @Deprecated
        public FileDataSourceException(final String s, final IOException ex) {
            super(s, ex, 2000);
        }
        
        public FileDataSourceException(final String s, final Throwable t, final int n) {
            super(s, t, n);
        }
        
        public FileDataSourceException(final Throwable t, final int n) {
            super(t, n);
        }
    }
    
    private static final class a
    {
        static boolean a(final Throwable t) {
            return b(t);
        }
        
        private static boolean b(final Throwable t) {
            return t instanceof ErrnoException && ((ErrnoException)t).errno == OsConstants.EACCES;
        }
    }
}
