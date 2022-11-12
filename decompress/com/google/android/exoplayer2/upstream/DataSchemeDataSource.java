// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.IOException;
import android.net.Uri;
import java.net.URLDecoder;
import com.google.common.base.Charsets;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;

public final class DataSchemeDataSource extends BaseDataSource
{
    private DataSpec e;
    private byte[] f;
    private int g;
    private int h;
    
    public DataSchemeDataSource() {
        super(false);
    }
    
    @Override
    public long b(final DataSpec e) throws IOException {
        this.u(e);
        this.e = e;
        final Uri a = e.a;
        final String scheme = a.getScheme();
        final boolean equals = "data".equals(scheme);
        final StringBuilder sb = new StringBuilder();
        sb.append("Unsupported scheme: ");
        sb.append(scheme);
        Assertions.b(equals, sb.toString());
        final String[] t0 = Util.T0(a.getSchemeSpecificPart(), ",");
        if (t0.length != 2) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected URI format: ");
            sb2.append(a);
            throw ParserException.createForMalformedDataOfUnknownType(sb2.toString(), null);
        }
        final String s = t0[1];
        Label_0169: {
            if (t0[0].contains(";base64")) {
                try {
                    this.f = Base64.decode(s, 0);
                    break Label_0169;
                }
                catch (final IllegalArgumentException ex) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Error while parsing Base64 encoded string: ");
                    sb3.append(s);
                    throw ParserException.createForMalformedDataOfUnknownType(sb3.toString(), ex);
                }
            }
            this.f = Util.n0(URLDecoder.decode(s, Charsets.a.name()));
        }
        final long g = e.g;
        final byte[] f = this.f;
        if (g <= f.length) {
            final int g2 = (int)g;
            this.g = g2;
            final int h = f.length - g2;
            this.h = h;
            final long h2 = e.h;
            if (h2 != -1L) {
                this.h = (int)Math.min(h, h2);
            }
            this.v(e);
            long h3 = e.h;
            if (h3 == -1L) {
                h3 = this.h;
            }
            return h3;
        }
        this.f = null;
        throw new DataSourceException(2008);
    }
    
    @Override
    public void close() {
        if (this.f != null) {
            this.f = null;
            this.t();
        }
        this.e = null;
    }
    
    @Override
    public Uri q() {
        final DataSpec e = this.e;
        Uri a;
        if (e != null) {
            a = e.a;
        }
        else {
            a = null;
        }
        return a;
    }
    
    @Override
    public int read(final byte[] array, final int n, int min) {
        if (min == 0) {
            return 0;
        }
        final int h = this.h;
        if (h == 0) {
            return -1;
        }
        min = Math.min(min, h);
        System.arraycopy(Util.j(this.f), this.g, array, n, min);
        this.g += min;
        this.h -= min;
        this.s(min);
        return min;
    }
}
