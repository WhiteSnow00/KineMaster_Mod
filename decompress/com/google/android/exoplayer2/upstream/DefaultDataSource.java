// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.io.IOException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Log;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;
import android.content.Context;

public final class DefaultDataSource implements DataSource
{
    private final Context a;
    private final List<TransferListener> b;
    private final DataSource c;
    private DataSource d;
    private DataSource e;
    private DataSource f;
    private DataSource g;
    private DataSource h;
    private DataSource i;
    private DataSource j;
    private DataSource k;
    
    public DefaultDataSource(final Context context, final DataSource dataSource) {
        this.a = context.getApplicationContext();
        this.c = Assertions.e(dataSource);
        this.b = new ArrayList<TransferListener>();
    }
    
    private void j(final DataSource dataSource) {
        for (int i = 0; i < this.b.size(); ++i) {
            dataSource.e(this.b.get(i));
        }
    }
    
    private DataSource s() {
        if (this.e == null) {
            this.j(this.e = new AssetDataSource(this.a));
        }
        return this.e;
    }
    
    private DataSource t() {
        if (this.f == null) {
            this.j(this.f = new ContentDataSource(this.a));
        }
        return this.f;
    }
    
    private DataSource u() {
        if (this.i == null) {
            this.j(this.i = new DataSchemeDataSource());
        }
        return this.i;
    }
    
    private DataSource v() {
        if (this.d == null) {
            this.j(this.d = new FileDataSource());
        }
        return this.d;
    }
    
    private DataSource w() {
        if (this.j == null) {
            this.j(this.j = new RawResourceDataSource(this.a));
        }
        return this.j;
    }
    
    private DataSource x() {
        if (this.g == null) {
            try {
                this.j(this.g = (DataSource)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]));
            }
            catch (final Exception ex) {
                throw new RuntimeException("Error instantiating RTMP extension", ex);
            }
            catch (final ClassNotFoundException ex2) {
                Log.i("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            }
            if (this.g == null) {
                this.g = this.c;
            }
        }
        return this.g;
    }
    
    private DataSource y() {
        if (this.h == null) {
            this.j(this.h = new UdpDataSource());
        }
        return this.h;
    }
    
    private void z(final DataSource dataSource, final TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.e(transferListener);
        }
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws IOException {
        Assertions.g(this.k == null);
        final String scheme = dataSpec.a.getScheme();
        if (Util.w0(dataSpec.a)) {
            final String path = dataSpec.a.getPath();
            if (path != null && path.startsWith("/android_asset/")) {
                this.k = this.s();
            }
            else {
                this.k = this.v();
            }
        }
        else if ("asset".equals(scheme)) {
            this.k = this.s();
        }
        else if ("content".equals(scheme)) {
            this.k = this.t();
        }
        else if ("rtmp".equals(scheme)) {
            this.k = this.x();
        }
        else if ("udp".equals(scheme)) {
            this.k = this.y();
        }
        else if ("data".equals(scheme)) {
            this.k = this.u();
        }
        else if (!"rawresource".equals(scheme) && !"android.resource".equals(scheme)) {
            this.k = this.c;
        }
        else {
            this.k = this.w();
        }
        return this.k.b(dataSpec);
    }
    
    @Override
    public void close() throws IOException {
        final DataSource k = this.k;
        if (k != null) {
            try {
                k.close();
            }
            finally {
                this.k = null;
            }
        }
    }
    
    @Override
    public void e(final TransferListener transferListener) {
        Assertions.e(transferListener);
        this.c.e(transferListener);
        this.b.add(transferListener);
        this.z(this.d, transferListener);
        this.z(this.e, transferListener);
        this.z(this.f, transferListener);
        this.z(this.g, transferListener);
        this.z(this.h, transferListener);
        this.z(this.i, transferListener);
        this.z(this.j, transferListener);
    }
    
    @Override
    public Map<String, List<String>> g() {
        final DataSource k = this.k;
        Object o;
        if (k == null) {
            o = Collections.emptyMap();
        }
        else {
            o = k.g();
        }
        return (Map<String, List<String>>)o;
    }
    
    @Override
    public Uri q() {
        final DataSource k = this.k;
        Uri q;
        if (k == null) {
            q = null;
        }
        else {
            q = k.q();
        }
        return q;
    }
    
    @Override
    public int read(final byte[] array, final int n, final int n2) throws IOException {
        return Assertions.e(this.k).read(array, n, n2);
    }
    
    public static final class Factory implements DataSource.Factory
    {
        private final Context a;
        private final DataSource.Factory b;
        private TransferListener c;
        
        public Factory(final Context context) {
            this(context, new DefaultHttpDataSource.Factory());
        }
        
        public Factory(final Context context, final DataSource.Factory b) {
            this.a = context.getApplicationContext();
            this.b = b;
        }
        
        public DefaultDataSource a() {
            final DefaultDataSource defaultDataSource = new DefaultDataSource(this.a, this.b.createDataSource());
            final TransferListener c = this.c;
            if (c != null) {
                defaultDataSource.e(c);
            }
            return defaultDataSource;
        }
        
        @Override
        public /* bridge */ DataSource createDataSource() {
            return this.a();
        }
    }
}
