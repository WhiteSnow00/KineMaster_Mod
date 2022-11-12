// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.FileDataSource;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.DataSourceException;
import java.io.IOException;
import com.google.android.exoplayer2.util.Assertions;
import java.io.File;
import java.io.InterruptedIOException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.upstream.PlaceholderDataSource;
import com.google.android.exoplayer2.upstream.TeeDataSource;
import com.google.android.exoplayer2.upstream.PriorityDataSource;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;

public final class CacheDataSource implements DataSource
{
    private final Cache a;
    private final DataSource b;
    private final DataSource c;
    private final DataSource d;
    private final CacheKeyFactory e;
    private final EventListener f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private Uri j;
    private DataSpec k;
    private DataSpec l;
    private DataSource m;
    private long n;
    private long o;
    private long p;
    private CacheSpan q;
    private boolean r;
    private boolean s;
    private long t;
    private long u;
    
    private CacheDataSource(final Cache a, final DataSource dataSource, final DataSource b, final DataSink dataSink, CacheKeyFactory a2, final int n, final PriorityTaskManager priorityTaskManager, final int n2, final EventListener f) {
        this.a = a;
        this.b = b;
        if (a2 == null) {
            a2 = CacheKeyFactory.a;
        }
        this.e = a2;
        final boolean b2 = false;
        this.g = ((n & 0x1) != 0x0);
        this.h = ((n & 0x2) != 0x0);
        boolean i = b2;
        if ((n & 0x4) != 0x0) {
            i = true;
        }
        this.i = i;
        final DataSource dataSource2 = null;
        if (dataSource != null) {
            DataSource d = dataSource;
            if (priorityTaskManager != null) {
                d = new PriorityDataSource(dataSource, priorityTaskManager, n2);
            }
            this.d = d;
            DataSource c = dataSource2;
            if (dataSink != null) {
                c = new TeeDataSource(d, dataSink);
            }
            this.c = c;
        }
        else {
            this.d = PlaceholderDataSource.a;
            this.c = null;
        }
        this.f = f;
    }
    
    CacheDataSource(final Cache cache, final DataSource dataSource, final DataSource dataSource2, final DataSink dataSink, final CacheKeyFactory cacheKeyFactory, final int n, final PriorityTaskManager priorityTaskManager, final int n2, final EventListener eventListener, final CacheDataSource$a object) {
        this(cache, dataSource, dataSource2, dataSink, cacheKeyFactory, n, priorityTaskManager, n2, eventListener);
    }
    
    private void A() {
        final EventListener f = this.f;
        if (f != null && this.t > 0L) {
            f.b(this.a.g(), this.t);
            this.t = 0L;
        }
    }
    
    private void B(final int n) {
        final EventListener f = this.f;
        if (f != null) {
            f.a(n);
        }
    }
    
    private void C(final DataSpec dataSpec, final boolean b) throws IOException {
        final String s = Util.j(dataSpec.i);
        final boolean s2 = this.s;
        final Uri uri = null;
        CacheSpan cacheSpan = null;
        Label_0097: {
            if (s2) {
                cacheSpan = null;
            }
            else {
                if (this.g) {
                    try {
                        cacheSpan = this.a.j(s, this.o, this.p);
                        break Label_0097;
                    }
                    catch (final InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                cacheSpan = this.a.e(s, this.o, this.p);
            }
        }
        DataSpec l;
        CacheSpan q;
        DataSource m;
        if (cacheSpan == null) {
            final DataSource d = this.d;
            l = dataSpec.a().h(this.o).g(this.p).a();
            q = cacheSpan;
            m = d;
        }
        else if (cacheSpan.d) {
            final Uri fromFile = Uri.fromFile((File)Util.j(cacheSpan.e));
            final long b2 = cacheSpan.b;
            final long n = this.o - b2;
            final long n2 = cacheSpan.c - n;
            final long p2 = this.p;
            long min = n2;
            if (p2 != -1L) {
                min = Math.min(n2, p2);
            }
            l = dataSpec.a().i(fromFile).k(b2).h(n).g(min).a();
            final DataSource b3 = this.b;
            q = cacheSpan;
            m = b3;
        }
        else {
            long n3;
            if (cacheSpan.d()) {
                n3 = this.p;
            }
            else {
                final long c = cacheSpan.c;
                final long p3 = this.p;
                n3 = c;
                if (p3 != -1L) {
                    n3 = Math.min(c, p3);
                }
            }
            l = dataSpec.a().h(this.o).g(n3).a();
            final DataSource c2 = this.c;
            if (c2 != null) {
                q = cacheSpan;
                m = c2;
            }
            else {
                final DataSource d2 = this.d;
                this.a.h(cacheSpan);
                q = null;
                m = d2;
            }
        }
        long u;
        if (!this.s && m == this.d) {
            u = this.o + 102400L;
        }
        else {
            u = Long.MAX_VALUE;
        }
        this.u = u;
        if (b) {
            Assertions.g(this.w());
            if (m == this.d) {
                return;
            }
            try {
                this.j();
            }
            finally {
                if (Util.j(q).c()) {
                    this.a.h(q);
                }
            }
        }
        if (q != null && q.c()) {
            this.q = q;
        }
        this.m = m;
        this.l = l;
        this.n = 0L;
        final long b4 = m.b(l);
        final ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (l.h == -1L && b4 != -1L) {
            this.p = b4;
            ContentMetadataMutations.g(contentMetadataMutations, this.o + b4);
        }
        if (this.y()) {
            final Uri q2 = m.q();
            this.j = q2;
            Uri j = uri;
            if (dataSpec.a.equals((Object)q2) ^ true) {
                j = this.j;
            }
            ContentMetadataMutations.h(contentMetadataMutations, j);
        }
        if (this.z()) {
            this.a.c(s, contentMetadataMutations);
        }
    }
    
    private void D(final String s) throws IOException {
        this.p = 0L;
        if (this.z()) {
            final ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataMutations.g(contentMetadataMutations, this.o);
            this.a.c(s, contentMetadataMutations);
        }
    }
    
    private int E(final DataSpec dataSpec) {
        if (this.h && this.r) {
            return 0;
        }
        if (this.i && dataSpec.h == -1L) {
            return 1;
        }
        return -1;
    }
    
    private void j() throws IOException {
        final DataSource m = this.m;
        if (m == null) {
            return;
        }
        try {
            m.close();
        }
        finally {
            this.l = null;
            this.m = null;
            final CacheSpan q = this.q;
            if (q != null) {
                this.a.h(q);
                this.q = null;
            }
        }
    }
    
    private static Uri u(final Cache cache, final String s, Uri uri) {
        final Uri b = ContentMetadata.b(cache.b(s));
        if (b != null) {
            uri = b;
        }
        return uri;
    }
    
    private void v(final Throwable t) {
        if (this.x() || t instanceof Cache.CacheException) {
            this.r = true;
        }
    }
    
    private boolean w() {
        return this.m == this.d;
    }
    
    private boolean x() {
        return this.m == this.b;
    }
    
    private boolean y() {
        return this.x() ^ true;
    }
    
    private boolean z() {
        return this.m == this.c;
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws IOException {
        try {
            final String a = this.e.a(dataSpec);
            final DataSpec a2 = dataSpec.a().f(a).a();
            this.k = a2;
            this.j = u(this.a, a, a2.a);
            this.o = dataSpec.g;
            final int e = this.E(dataSpec);
            final boolean s = e != -1;
            this.s = s;
            if (s) {
                this.B(e);
            }
            if (this.s) {
                this.p = -1L;
            }
            else {
                final long d = ContentMetadata.d(this.a.b(a));
                this.p = d;
                if (d != -1L) {
                    final long p = d - dataSpec.g;
                    this.p = p;
                    if (p < 0L) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long p2 = dataSpec.h;
            if (p2 != -1L) {
                final long p3 = this.p;
                if (p3 != -1L) {
                    p2 = Math.min(p3, p2);
                }
                this.p = p2;
            }
            final long p4 = this.p;
            if (p4 > 0L || p4 == -1L) {
                this.C(a2, false);
            }
            long n = dataSpec.h;
            if (n == -1L) {
                n = this.p;
            }
            return n;
        }
        finally {
            final Throwable t;
            this.v(t);
        }
    }
    
    @Override
    public void close() throws IOException {
        this.k = null;
        this.j = null;
        this.o = 0L;
        this.A();
        try {
            this.j();
        }
        finally {
            final Throwable t;
            this.v(t);
        }
    }
    
    @Override
    public void e(final TransferListener transferListener) {
        Assertions.e(transferListener);
        this.b.e(transferListener);
        this.d.e(transferListener);
    }
    
    @Override
    public Map<String, List<String>> g() {
        Object o;
        if (this.y()) {
            o = this.d.g();
        }
        else {
            o = Collections.emptyMap();
        }
        return (Map<String, List<String>>)o;
    }
    
    @Override
    public Uri q() {
        return this.j;
    }
    
    @Override
    public int read(final byte[] array, int read, final int n) throws IOException {
        if (n == 0) {
            return 0;
        }
        if (this.p == 0L) {
            return -1;
        }
        final DataSpec dataSpec = Assertions.e(this.k);
        final DataSpec dataSpec2 = Assertions.e(this.l);
        try {
            if (this.o >= this.u) {
                this.C(dataSpec, true);
            }
            final int read2 = Assertions.e(this.m).read(array, read, n);
            if (read2 != -1) {
                if (this.x()) {
                    this.t += read2;
                }
                final long o = this.o;
                final long n2 = read2;
                this.o = o + n2;
                this.n += n2;
                final long p3 = this.p;
                if (p3 != -1L) {
                    this.p = p3 - n2;
                }
            }
            else {
                if (this.y()) {
                    final long h = dataSpec2.h;
                    if (h == -1L || this.n < h) {
                        this.D(Util.j(dataSpec.i));
                        return read2;
                    }
                }
                final long p4 = this.p;
                if (p4 > 0L || p4 == -1L) {
                    this.j();
                    this.C(dataSpec, false);
                    read = this.read(array, read, n);
                    return read;
                }
            }
            return read2;
        }
        finally {
            final Throwable t;
            this.v(t);
        }
    }
    
    public Cache s() {
        return this.a;
    }
    
    public CacheKeyFactory t() {
        return this.e;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface CacheIgnoredReason {
    }
    
    public interface EventListener
    {
        void a(final int p0);
        
        void b(final long p0, final long p1);
    }
    
    public static final class Factory implements DataSource.Factory
    {
        private Cache a;
        private DataSource.Factory b;
        private DataSink.Factory c;
        private CacheKeyFactory d;
        private boolean e;
        private DataSource.Factory f;
        private PriorityTaskManager g;
        private int h;
        private int i;
        private EventListener j;
        
        public Factory() {
            this.b = new FileDataSource.Factory();
            this.d = CacheKeyFactory.a;
        }
        
        private CacheDataSource c(final DataSource dataSource, final int n, final int n2) {
            final Cache cache = Assertions.e(this.a);
            DataSink dataSink;
            if (!this.e && dataSource != null) {
                final DataSink.Factory c = this.c;
                if (c != null) {
                    dataSink = c.a();
                }
                else {
                    dataSink = new CacheDataSink.Factory().b(cache).a();
                }
            }
            else {
                dataSink = null;
            }
            return new CacheDataSource(cache, dataSource, this.b.createDataSource(), dataSink, this.d, n, this.g, n2, this.j, null);
        }
        
        public CacheDataSource a() {
            final DataSource.Factory f = this.f;
            DataSource dataSource;
            if (f != null) {
                dataSource = f.createDataSource();
            }
            else {
                dataSource = null;
            }
            return this.c(dataSource, this.i, this.h);
        }
        
        public CacheDataSource b() {
            final DataSource.Factory f = this.f;
            DataSource dataSource;
            if (f != null) {
                dataSource = f.createDataSource();
            }
            else {
                dataSource = null;
            }
            return this.c(dataSource, this.i | 0x1, -1000);
        }
        
        @Override
        public /* bridge */ DataSource createDataSource() {
            return this.a();
        }
        
        public Cache d() {
            return this.a;
        }
        
        public CacheKeyFactory e() {
            return this.d;
        }
        
        public PriorityTaskManager f() {
            return this.g;
        }
        
        public Factory g(final Cache a) {
            this.a = a;
            return this;
        }
        
        public Factory h(final int i) {
            this.i = i;
            return this;
        }
        
        public Factory i(final DataSource.Factory f) {
            this.f = f;
            return this;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Flags {
    }
}
