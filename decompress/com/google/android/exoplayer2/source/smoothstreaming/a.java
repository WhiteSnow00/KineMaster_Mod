// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.smoothstreaming;

import java.io.IOException;
import java.util.ArrayList;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.MediaPeriod;

final class a implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<SsChunkSource>>
{
    private final SsChunkSource.Factory a;
    private final TransferListener b;
    private final LoaderErrorThrower c;
    private final DrmSessionManager d;
    private final DrmSessionEventListener.EventDispatcher e;
    private final LoadErrorHandlingPolicy f;
    private final MediaSourceEventListener.EventDispatcher g;
    private final Allocator h;
    private final TrackGroupArray i;
    private final CompositeSequenceableLoaderFactory j;
    private MediaPeriod.Callback p;
    private SsManifest w;
    private ChunkSampleStream<SsChunkSource>[] x;
    private SequenceableLoader y;
    
    public a(final SsManifest w, final SsChunkSource.Factory a, final TransferListener b, final CompositeSequenceableLoaderFactory j, final DrmSessionManager d, final DrmSessionEventListener.EventDispatcher e, final LoadErrorHandlingPolicy f, final MediaSourceEventListener.EventDispatcher g, final LoaderErrorThrower c, final Allocator h) {
        this.w = w;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.j = j;
        this.i = e(w, d);
        final ChunkSampleStream<SsChunkSource>[] r = r(0);
        this.x = r;
        this.y = j.a((SequenceableLoader[])r);
    }
    
    private ChunkSampleStream<SsChunkSource> a(final ExoTrackSelection exoTrackSelection, final long n) {
        final int c = this.i.c(exoTrackSelection.l());
        return new ChunkSampleStream<SsChunkSource>(this.w.f[c].a, null, null, this.a.a(this.c, this.w, c, exoTrackSelection, this.b), (SequenceableLoader.Callback<ChunkSampleStream<ChunkSource>>)this, this.h, n, this.d, this.e, this.f, this.g);
    }
    
    private static TrackGroupArray e(final SsManifest ssManifest, final DrmSessionManager drmSessionManager) {
        final TrackGroup[] array = new TrackGroup[ssManifest.f.length];
        int n = 0;
        while (true) {
            final SsManifest.StreamElement[] f = ssManifest.f;
            if (n >= f.length) {
                break;
            }
            final Format[] j = f[n].j;
            final Format[] array2 = new Format[j.length];
            for (int i = 0; i < j.length; ++i) {
                final Format format = j[i];
                array2[i] = format.c(drmSessionManager.a(format));
            }
            array[n] = new TrackGroup(Integer.toString(n), array2);
            ++n;
        }
        return new TrackGroupArray(array);
    }
    
    private static ChunkSampleStream<SsChunkSource>[] r(final int n) {
        return new ChunkSampleStream[n];
    }
    
    @Override
    public long b() {
        return this.y.b();
    }
    
    @Override
    public long c(final long n, final SeekParameters seekParameters) {
        for (final ChunkSampleStream<SsChunkSource> chunkSampleStream : this.x) {
            if (chunkSampleStream.a == 2) {
                return chunkSampleStream.c(n, seekParameters);
            }
        }
        return n;
    }
    
    @Override
    public boolean d(final long n) {
        return this.y.d(n);
    }
    
    @Override
    public long f() {
        return this.y.f();
    }
    
    @Override
    public void g(final long n) {
        this.y.g(n);
    }
    
    @Override
    public long h(final long n) {
        final ChunkSampleStream<SsChunkSource>[] x = this.x;
        for (int length = x.length, i = 0; i < length; ++i) {
            x[i].Q(n);
        }
        return n;
    }
    
    @Override
    public long i() {
        return -9223372036854775807L;
    }
    
    @Override
    public boolean isLoading() {
        return this.y.isLoading();
    }
    
    @Override
    public void j(final MediaPeriod.Callback p2, final long n) {
        (this.p = p2).o(this);
    }
    
    @Override
    public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, final long n) {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < array.length; ++i) {
            if (array3[i] != null) {
                final ChunkSampleStream chunkSampleStream = (ChunkSampleStream)array3[i];
                if (array[i] != null && array2[i]) {
                    ((SsChunkSource)chunkSampleStream.B()).b(array[i]);
                    list.add(chunkSampleStream);
                }
                else {
                    chunkSampleStream.N();
                    array3[i] = null;
                }
            }
            if (array3[i] == null && array[i] != null) {
                final ChunkSampleStream<SsChunkSource> a = this.a(array[i], n);
                list.add(a);
                array3[i] = a;
                array4[i] = true;
            }
        }
        list.toArray(this.x = r(list.size()));
        this.y = this.j.a((SequenceableLoader[])this.x);
        return n;
    }
    
    @Override
    public /* bridge */ void l(final SequenceableLoader sequenceableLoader) {
        this.s((ChunkSampleStream<SsChunkSource>)sequenceableLoader);
    }
    
    @Override
    public void n() throws IOException {
        this.c.a();
    }
    
    @Override
    public TrackGroupArray p() {
        return this.i;
    }
    
    @Override
    public void q(final long n, final boolean b) {
        final ChunkSampleStream<SsChunkSource>[] x = this.x;
        for (int length = x.length, i = 0; i < length; ++i) {
            x[i].q(n, b);
        }
    }
    
    public void s(final ChunkSampleStream<SsChunkSource> chunkSampleStream) {
        ((SequenceableLoader.Callback<a>)this.p).l(this);
    }
    
    public void t() {
        final ChunkSampleStream<SsChunkSource>[] x = this.x;
        for (int length = x.length, i = 0; i < length; ++i) {
            x[i].N();
        }
        this.p = null;
    }
    
    public void u(final SsManifest w) {
        this.w = w;
        final ChunkSampleStream<SsChunkSource>[] x = this.x;
        for (int length = x.length, i = 0; i < length; ++i) {
            x[i].B().e(w);
        }
        ((SequenceableLoader.Callback<a>)this.p).l(this);
    }
}
