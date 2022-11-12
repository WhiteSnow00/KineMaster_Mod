// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.util.List;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import android.net.Uri;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;

public class DefaultSsChunkSource implements SsChunkSource
{
    private final LoaderErrorThrower a;
    private final int b;
    private final ChunkExtractor[] c;
    private final DataSource d;
    private ExoTrackSelection e;
    private SsManifest f;
    private int g;
    private IOException h;
    
    public DefaultSsChunkSource(final LoaderErrorThrower a, final SsManifest f, int i, final ExoTrackSelection e, final DataSource d) {
        this.a = a;
        this.f = f;
        this.b = i;
        this.e = e;
        this.d = d;
        final SsManifest.StreamElement streamElement = f.f[i];
        this.c = new ChunkExtractor[e.length()];
        int g;
        Format format;
        TrackEncryptionBox[] c;
        int a2;
        int n;
        for (i = 0; i < this.c.length; ++i) {
            g = e.g(i);
            format = streamElement.j[g];
            if (format.z != null) {
                c = Assertions.e(f.e).c;
            }
            else {
                c = null;
            }
            a2 = streamElement.a;
            if (a2 == 2) {
                n = 4;
            }
            else {
                n = 0;
            }
            this.c[i] = new BundledChunkExtractor(new FragmentedMp4Extractor(3, null, new Track(g, a2, streamElement.c, -9223372036854775807L, f.g, format, 0, c, n, null, null)), streamElement.a, format);
        }
    }
    
    private static MediaChunk k(final Format format, final DataSource dataSource, final Uri uri, final int n, final long n2, final long n3, final long n4, final int n5, final Object o, final ChunkExtractor chunkExtractor) {
        return new ContainerMediaChunk(dataSource, new DataSpec(uri), format, n5, o, n2, n3, n4, -9223372036854775807L, n, 1, n2, chunkExtractor);
    }
    
    private long l(final long n) {
        final SsManifest f = this.f;
        if (!f.d) {
            return -9223372036854775807L;
        }
        final SsManifest.StreamElement streamElement = f.f[this.b];
        final int n2 = streamElement.k - 1;
        return streamElement.e(n2) + streamElement.c(n2) - n;
    }
    
    @Override
    public void a() throws IOException {
        final IOException h = this.h;
        if (h == null) {
            this.a.a();
            return;
        }
        throw h;
    }
    
    @Override
    public void b(final ExoTrackSelection e) {
        this.e = e;
    }
    
    @Override
    public long c(final long n, final SeekParameters seekParameters) {
        final SsManifest.StreamElement streamElement = this.f.f[this.b];
        final int d = streamElement.d(n);
        final long e = streamElement.e(d);
        long e2;
        if (e < n && d < streamElement.k - 1) {
            e2 = streamElement.e(d + 1);
        }
        else {
            e2 = e;
        }
        return seekParameters.a(n, e, e2);
    }
    
    @Override
    public boolean d(final long n, final Chunk chunk, final List<? extends MediaChunk> list) {
        return this.h == null && this.e.d(n, chunk, list);
    }
    
    @Override
    public void e(final SsManifest f) {
        final SsManifest.StreamElement[] f2 = this.f.f;
        final int b = this.b;
        final SsManifest.StreamElement streamElement = f2[b];
        final int k = streamElement.k;
        final SsManifest.StreamElement streamElement2 = f.f[b];
        if (k != 0 && streamElement2.k != 0) {
            final int n = k - 1;
            final long e = streamElement.e(n);
            final long c = streamElement.c(n);
            final long e2 = streamElement2.e(0);
            if (e + c <= e2) {
                this.g += k;
            }
            else {
                this.g += streamElement.d(e2);
            }
        }
        else {
            this.g += k;
        }
        this.f = f;
    }
    
    @Override
    public void f(final Chunk chunk) {
    }
    
    @Override
    public boolean g(final Chunk chunk, final boolean b, final LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        final LoadErrorHandlingPolicy.FallbackSelection c = loadErrorHandlingPolicy.c(TrackSelectionUtil.c(this.e), loadErrorInfo);
        if (b && c != null && c.a == 2) {
            final ExoTrackSelection e = this.e;
            if (e.b(e.p(chunk.d), c.b)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int i(final long n, final List<? extends MediaChunk> list) {
        if (this.h == null && this.e.length() >= 2) {
            return this.e.o(n, list);
        }
        return list.size();
    }
    
    @Override
    public final void j(long e, long n, final List<? extends MediaChunk> list, final ChunkHolder chunkHolder) {
        if (this.h != null) {
            return;
        }
        final SsManifest f = this.f;
        final SsManifest.StreamElement streamElement = f.f[this.b];
        if (streamElement.k == 0) {
            chunkHolder.b = (f.d ^ true);
            return;
        }
        int d;
        if (list.isEmpty()) {
            d = streamElement.d(n);
        }
        else if ((d = (int)(list.get(list.size() - 1).g() - this.g)) < 0) {
            this.h = new BehindLiveWindowException();
            return;
        }
        if (d >= streamElement.k) {
            chunkHolder.b = (this.f.d ^ true);
            return;
        }
        final long l = this.l(e);
        final int length = this.e.length();
        final MediaChunkIterator[] array = new MediaChunkIterator[length];
        for (int i = 0; i < length; ++i) {
            array[i] = new a(streamElement, this.e.g(i), d);
        }
        this.e.q(e, n - e, l, list, array);
        e = streamElement.e(d);
        final long c = streamElement.c(d);
        if (!list.isEmpty()) {
            n = -9223372036854775807L;
        }
        final int g = this.g;
        final int a = this.e.a();
        chunkHolder.a = k(this.e.s(), this.d, streamElement.a(this.e.g(a), d), d + g, e, e + c, n, this.e.t(), this.e.i(), this.c[a]);
    }
    
    @Override
    public void release() {
        final ChunkExtractor[] c = this.c;
        for (int length = c.length, i = 0; i < length; ++i) {
            c[i].release();
        }
    }
    
    public static final class Factory implements SsChunkSource.Factory
    {
        private final DataSource.Factory a;
        
        public Factory(final DataSource.Factory a) {
            this.a = a;
        }
        
        @Override
        public SsChunkSource a(final LoaderErrorThrower loaderErrorThrower, final SsManifest ssManifest, final int n, final ExoTrackSelection exoTrackSelection, final TransferListener transferListener) {
            final DataSource dataSource = this.a.createDataSource();
            if (transferListener != null) {
                dataSource.e(transferListener);
            }
            return new DefaultSsChunkSource(loaderErrorThrower, ssManifest, n, exoTrackSelection, dataSource);
        }
    }
    
    private static final class a extends BaseMediaChunkIterator
    {
        private final SsManifest.StreamElement e;
        private final int f;
        
        public a(final SsManifest.StreamElement e, final int f, final int n) {
            super(n, e.k - 1);
            this.e = e;
            this.f = f;
        }
        
        @Override
        public long a() {
            this.c();
            return this.e.e((int)this.d());
        }
        
        @Override
        public long b() {
            return this.a() + this.e.c((int)this.d());
        }
    }
}
