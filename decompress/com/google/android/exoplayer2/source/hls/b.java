// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import java.util.AbstractCollection;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.InterruptedIOException;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import java.math.BigInteger;
import com.google.common.base.Ascii;
import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import java.io.EOFException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.Format;
import java.util.List;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSource;
import android.net.Uri;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.analytics.PlayerId;
import java.util.concurrent.atomic.AtomicInteger;
import com.google.android.exoplayer2.source.chunk.MediaChunk;

final class b extends MediaChunk
{
    private static final AtomicInteger M;
    private final boolean A;
    private final boolean B;
    private final PlayerId C;
    private HlsMediaChunkExtractor D;
    private HlsSampleStreamWrapper E;
    private int F;
    private boolean G;
    private volatile boolean H;
    private boolean I;
    private ImmutableList<Integer> J;
    private boolean K;
    private boolean L;
    public final int k;
    public final int l;
    public final Uri m;
    public final boolean n;
    public final int o;
    private final DataSource p;
    private final DataSpec q;
    private final HlsMediaChunkExtractor r;
    private final boolean s;
    private final boolean t;
    private final TimestampAdjuster u;
    private final HlsExtractorFactory v;
    private final List<Format> w;
    private final DrmInitData x;
    private final Id3Decoder y;
    private final ParsableByteArray z;
    
    static {
        M = new AtomicInteger();
    }
    
    private b(final HlsExtractorFactory v, final DataSource dataSource, final DataSpec dataSpec, final Format format, final boolean a, final DataSource p27, final DataSpec q, final boolean b, final Uri m, final List<Format> w, final int n, final Object o, final long n2, final long n3, final long n4, final int o2, final boolean l, final int i, final boolean t, final boolean s, final TimestampAdjuster u, final DrmInitData x, final HlsMediaChunkExtractor r, final Id3Decoder y, final ParsableByteArray z, final boolean n5, final PlayerId c) {
        super(dataSource, dataSpec, format, n, o, n2, n3, n4);
        this.A = a;
        this.o = o2;
        this.L = l;
        this.l = i;
        this.q = q;
        this.p = p27;
        this.G = (q != null);
        this.B = b;
        this.m = m;
        this.s = s;
        this.u = u;
        this.t = t;
        this.v = v;
        this.w = w;
        this.x = x;
        this.r = r;
        this.y = y;
        this.z = z;
        this.n = n5;
        this.C = c;
        this.J = (ImmutableList<Integer>)ImmutableList.of();
        this.k = b.M.getAndIncrement();
    }
    
    private static DataSource i(final DataSource dataSource, final byte[] array, final byte[] array2) {
        if (array != null) {
            Assertions.e(array2);
            return new a(dataSource, array, array2);
        }
        return dataSource;
    }
    
    public static b j(final HlsExtractorFactory hlsExtractorFactory, final DataSource dataSource, final Format format, long c, final HlsMediaPlaylist hlsMediaPlaylist, final HlsChunkSource.d d, final Uri uri, final List<Format> list, final int n, final Object o, final boolean b, final TimestampAdjusterProvider timestampAdjusterProvider, final b b2, byte[] l, final byte[] array, final boolean b3, final PlayerId playerId) {
        final HlsMediaPlaylist.SegmentBase a = d.a;
        final DataSpec.Builder g = new DataSpec.Builder().i(UriUtil.e(hlsMediaPlaylist.a, a.a)).h(a.i).g(a.j);
        int n2;
        if (d.d) {
            n2 = 8;
        }
        else {
            n2 = 0;
        }
        final DataSpec a2 = g.b(n2).a();
        final boolean b4 = l != null;
        byte[] i;
        if (b4) {
            i = l(Assertions.e(a.h));
        }
        else {
            i = null;
        }
        final DataSource j = i(dataSource, l, i);
        final HlsMediaPlaylist.Segment b5 = a.b;
        boolean b6;
        DataSource k;
        DataSpec dataSpec2;
        if (b5 != null) {
            b6 = (array != null);
            if (b6) {
                l = l(Assertions.e(b5.h));
            }
            else {
                l = null;
            }
            final DataSpec dataSpec = new DataSpec(UriUtil.e(hlsMediaPlaylist.a, b5.a), b5.i, b5.j);
            k = i(dataSource, array, l);
            dataSpec2 = dataSpec;
        }
        else {
            k = null;
            dataSpec2 = null;
            b6 = false;
        }
        final long n3 = c + a.e;
        c = a.c;
        final int n4 = hlsMediaPlaylist.j + a.d;
        Id3Decoder y;
        HlsMediaChunkExtractor d2;
        ParsableByteArray parsableByteArray;
        if (b2 != null) {
            final DataSpec q = b2.q;
            final boolean b7 = dataSpec2 == q || (dataSpec2 != null && q != null && dataSpec2.a.equals((Object)q.a) && dataSpec2.g == b2.q.g);
            final boolean b8 = uri.equals((Object)b2.m) && b2.I;
            y = b2.y;
            final ParsableByteArray z = b2.z;
            if (b7 && b8 && !b2.K && b2.l == n4) {
                d2 = b2.D;
            }
            else {
                d2 = null;
            }
            parsableByteArray = z;
        }
        else {
            final Id3Decoder id3Decoder = new Id3Decoder();
            parsableByteArray = new ParsableByteArray(10);
            final HlsMediaChunkExtractor hlsMediaChunkExtractor = null;
            y = id3Decoder;
            d2 = hlsMediaChunkExtractor;
        }
        return new b(hlsExtractorFactory, j, a2, format, b4, k, dataSpec2, b6, uri, list, n, o, n3, n3 + c, d.b, d.c, d.d ^ true, n4, a.p, b, timestampAdjusterProvider.a(n4), a.f, d2, y, parsableByteArray, b3, playerId);
    }
    
    private void k(final DataSource dataSource, final DataSpec dataSpec, final boolean b, final boolean b2) throws IOException {
        int n = 0;
        final int n2 = 0;
        Object o;
        if (b) {
            n = n2;
            if (this.F != 0) {
                n = 1;
            }
            o = dataSpec;
        }
        else {
            o = dataSpec.e(this.F);
        }
        try {
            o = this.u(dataSource, (DataSpec)o, b2);
            Label_0068: {
                if (n == 0) {
                    break Label_0068;
                }
                ((ExtractorInput)o).o(this.F);
                while (true) {
                    try {
                        try {
                            while (!this.H && this.D.a((ExtractorInput)o)) {}
                            final long n3 = ((ExtractorInput)o).getPosition();
                            final long n4 = dataSpec.g;
                            this.F = (int)(n3 - n4);
                        }
                        finally {}
                    }
                    catch (final EOFException ex) {
                        if ((super.d.e & 0x4000) != 0x0) {
                            this.D.c();
                            final long n3 = ((ExtractorInput)o).getPosition();
                            final long n4 = dataSpec.g;
                            continue;
                        }
                        throw ex;
                    }
                    break;
                }
            }
            return;
            this.F = (int)(((ExtractorInput)o).getPosition() - dataSpec.g);
        }
        finally {
            DataSourceUtil.a(dataSource);
        }
    }
    
    private static byte[] l(final String s) {
        String substring = s;
        if (Ascii.e(s).startsWith("0x")) {
            substring = s.substring(2);
        }
        final byte[] byteArray = new BigInteger(substring, 16).toByteArray();
        final byte[] array = new byte[16];
        int n;
        if (byteArray.length > 16) {
            n = byteArray.length - 16;
        }
        else {
            n = 0;
        }
        System.arraycopy(byteArray, n, array, 16 - byteArray.length + n, byteArray.length - n);
        return array;
    }
    
    private static boolean p(final HlsChunkSource.d d, final HlsMediaPlaylist hlsMediaPlaylist) {
        final HlsMediaPlaylist.SegmentBase a = d.a;
        if (a instanceof HlsMediaPlaylist.Part) {
            return ((HlsMediaPlaylist.Part)a).w || (d.c == 0 && hlsMediaPlaylist.c);
        }
        return hlsMediaPlaylist.c;
    }
    
    private void r() throws IOException {
        this.k(super.i, super.b, this.A, true);
    }
    
    private void s() throws IOException {
        if (!this.G) {
            return;
        }
        Assertions.e(this.p);
        Assertions.e(this.q);
        this.k(this.p, this.q, this.B, false);
        this.F = 0;
        this.G = false;
    }
    
    private long t(final ExtractorInput extractorInput) throws IOException {
        extractorInput.h();
        try {
            this.z.L(10);
            extractorInput.r(this.z.d(), 0, 10);
            if (this.z.G() != 4801587) {
                return -9223372036854775807L;
            }
            this.z.Q(3);
            final int c = this.z.C();
            final int n = c + 10;
            if (n > this.z.b()) {
                final byte[] d = this.z.d();
                this.z.L(n);
                System.arraycopy(d, 0, this.z.d(), 0, 10);
            }
            extractorInput.r(this.z.d(), 10, c);
            final Metadata e = this.y.e(this.z.d(), c);
            if (e == null) {
                return -9223372036854775807L;
            }
            for (int d2 = e.d(), i = 0; i < d2; ++i) {
                final Metadata.Entry c2 = e.c(i);
                if (c2 instanceof PrivFrame) {
                    final PrivFrame privFrame = (PrivFrame)c2;
                    if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.b)) {
                        System.arraycopy(privFrame.c, 0, this.z.d(), 0, 8);
                        this.z.P(0);
                        this.z.O(8);
                        return this.z.w() & 0x1FFFFFFFFL;
                    }
                }
            }
            return -9223372036854775807L;
        }
        catch (final EOFException ex) {
            return -9223372036854775807L;
        }
    }
    
    private DefaultExtractorInput u(final DataSource dataSource, final DataSpec dataSpec, final boolean b) throws IOException {
        final long b2 = dataSource.b(dataSpec);
        if (b) {
            try {
                this.u.h(this.s, super.g);
            }
            catch (final InterruptedException ex) {
                throw new InterruptedIOException();
            }
        }
        final DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataSource, dataSpec.g, b2);
        if (this.D == null) {
            final long t = this.t(defaultExtractorInput);
            defaultExtractorInput.h();
            final HlsMediaChunkExtractor r = this.r;
            HlsMediaChunkExtractor d;
            if (r != null) {
                d = r.f();
            }
            else {
                d = this.v.a(dataSpec.a, super.d, this.w, this.u, dataSource.g(), defaultExtractorInput, this.C);
            }
            this.D = d;
            if (d.e()) {
                final HlsSampleStreamWrapper e = this.E;
                long n;
                if (t != -9223372036854775807L) {
                    n = this.u.b(t);
                }
                else {
                    n = super.g;
                }
                e.m0(n);
            }
            else {
                this.E.m0(0L);
            }
            this.E.Y();
            this.D.b(this.E);
        }
        this.E.j0(this.x);
        return defaultExtractorInput;
    }
    
    public static boolean w(final b b, final Uri uri, final HlsMediaPlaylist hlsMediaPlaylist, final HlsChunkSource.d d, final long n) {
        boolean b2 = false;
        if (b == null) {
            return false;
        }
        if (uri.equals((Object)b.m) && b.I) {
            return false;
        }
        final long e = d.a.e;
        if (!p(d, hlsMediaPlaylist) || n + e < b.h) {
            b2 = true;
        }
        return b2;
    }
    
    @Override
    public void a() throws IOException {
        Assertions.e(this.E);
        if (this.D == null) {
            final HlsMediaChunkExtractor r = this.r;
            if (r != null && r.d()) {
                this.D = this.r;
                this.G = false;
            }
        }
        this.s();
        if (!this.H) {
            if (!this.t) {
                this.r();
            }
            this.I = (this.H ^ true);
        }
    }
    
    @Override
    public void c() {
        this.H = true;
    }
    
    @Override
    public boolean h() {
        return this.I;
    }
    
    public int m(final int n) {
        Assertions.g(this.n ^ true);
        if (n >= ((AbstractCollection)this.J).size()) {
            return 0;
        }
        return ((List<Integer>)this.J).get(n);
    }
    
    public void n(final HlsSampleStreamWrapper e, final ImmutableList<Integer> j) {
        this.E = e;
        this.J = j;
    }
    
    public void o() {
        this.K = true;
    }
    
    public boolean q() {
        return this.L;
    }
    
    public void v() {
        this.L = true;
    }
}
