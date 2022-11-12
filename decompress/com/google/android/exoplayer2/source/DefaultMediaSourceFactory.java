// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import java.util.List;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.util.Iterator;
import java.util.Collection;
import com.google.common.primitives.Ints;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import com.google.common.base.Supplier;
import java.util.Map;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.text.SubtitleExtractor;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import android.content.Context;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.upstream.DataSource;

public final class DefaultMediaSourceFactory implements MediaSourceFactory
{
    private final a a;
    private DataSource.Factory b;
    private Factory c;
    private AdsLoader.Provider d;
    private AdViewProvider e;
    private LoadErrorHandlingPolicy f;
    private long g;
    private long h;
    private long i;
    private float j;
    private float k;
    private boolean l;
    
    public DefaultMediaSourceFactory(final Context context, final ExtractorsFactory extractorsFactory) {
        this(new DefaultDataSource.Factory(context), extractorsFactory);
    }
    
    public DefaultMediaSourceFactory(final DataSource.Factory b, final ExtractorsFactory extractorsFactory) {
        this.b = b;
        (this.a = new a(extractorsFactory)).o(b);
        this.g = -9223372036854775807L;
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
        this.j = -3.4028235E38f;
        this.k = -3.4028235E38f;
    }
    
    public static Extractor[] e(final Format format) {
        return h(format);
    }
    
    static Factory f(final Class clazz) {
        return k(clazz);
    }
    
    static Factory g(final Class clazz, final DataSource.Factory factory) {
        return l(clazz, factory);
    }
    
    private static Extractor[] h(final Format format) {
        final SubtitleDecoderFactory a = SubtitleDecoderFactory.a;
        Extractor extractor;
        if (a.a(format)) {
            extractor = new SubtitleExtractor(a.b(format), format);
        }
        else {
            extractor = new b(format);
        }
        return new Extractor[] { extractor };
    }
    
    private static MediaSource i(final MediaItem mediaItem, final MediaSource mediaSource) {
        final MediaItem.ClippingConfiguration f = mediaItem.f;
        final long a = f.a;
        if (a == 0L && f.b == Long.MIN_VALUE && !f.d) {
            return mediaSource;
        }
        final long c0 = Util.C0(a);
        final long c2 = Util.C0(mediaItem.f.b);
        final MediaItem.ClippingConfiguration f2 = mediaItem.f;
        return new ClippingMediaSource(mediaSource, c0, c2, f2.e ^ true, f2.c, f2.d);
    }
    
    private MediaSource j(final MediaItem mediaItem, final MediaSource mediaSource) {
        Assertions.e(mediaItem.b);
        final MediaItem.AdsConfiguration d = mediaItem.b.d;
        if (d == null) {
            return mediaSource;
        }
        final AdsLoader.Provider d2 = this.d;
        final AdViewProvider e = this.e;
        if (d2 == null || e == null) {
            Log.i("DMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        final AdsLoader a = d2.a(d);
        if (a == null) {
            Log.i("DMediaSourceFactory", "Playing media without ads, as no AdsLoader was provided.");
            return mediaSource;
        }
        final DataSpec dataSpec = new DataSpec(d.a);
        final Object b = d.b;
        Object of;
        if (b != null) {
            of = b;
        }
        else {
            of = ImmutableList.of((Object)mediaItem.a, (Object)mediaItem.b.a, (Object)d.a);
        }
        return new AdsMediaSource(mediaSource, dataSpec, of, this, a, e);
    }
    
    private static Factory k(final Class<? extends Factory> clazz) {
        try {
            return (Factory)clazz.getConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
        }
        catch (final Exception ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    private static Factory l(final Class<? extends Factory> clazz, final DataSource.Factory factory) {
        try {
            return (Factory)clazz.getConstructor(DataSource.Factory.class).newInstance(factory);
        }
        catch (final Exception ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public MediaSource a(final MediaItem mediaItem) {
        Assertions.e(mediaItem.b);
        final String scheme = mediaItem.b.a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return Assertions.e(this.c).a(mediaItem);
        }
        final MediaItem.LocalConfiguration b = mediaItem.b;
        final int q0 = Util.q0(b.a, b.b);
        final Factory g = this.a.g(q0);
        final StringBuilder sb = new StringBuilder();
        sb.append("No suitable media source factory found for content type: ");
        sb.append(q0);
        Assertions.j(g, sb.toString());
        final MediaItem.LiveConfiguration.Builder b2 = mediaItem.d.b();
        if (mediaItem.d.a == -9223372036854775807L) {
            b2.k(this.g);
        }
        if (mediaItem.d.d == -3.4028235E38f) {
            b2.j(this.j);
        }
        if (mediaItem.d.e == -3.4028235E38f) {
            b2.h(this.k);
        }
        if (mediaItem.d.b == -9223372036854775807L) {
            b2.i(this.h);
        }
        if (mediaItem.d.c == -9223372036854775807L) {
            b2.g(this.i);
        }
        final MediaItem.LiveConfiguration f = b2.f();
        MediaItem a = mediaItem;
        if (!f.equals(mediaItem.d)) {
            a = mediaItem.b().d(f).a();
        }
        final MediaSource a2 = g.a(a);
        final ImmutableList<MediaItem.SubtitleConfiguration> g2 = Util.j(a.b).g;
        MediaSource mediaSource = a2;
        if (!((List)g2).isEmpty()) {
            final MediaSource[] array = new MediaSource[((List)g2).size() + 1];
            int i = 0;
            array[0] = a2;
            while (i < ((List)g2).size()) {
                if (this.l) {
                    final ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(this.b, new c(new Format.Builder().e0(((List<MediaItem.SubtitleConfiguration>)g2).get(i).b).V(((List<MediaItem.SubtitleConfiguration>)g2).get(i).c).g0(((List<MediaItem.SubtitleConfiguration>)g2).get(i).d).c0(((List<MediaItem.SubtitleConfiguration>)g2).get(i).e).U(((List<MediaItem.SubtitleConfiguration>)g2).get(i).f).S(((List<MediaItem.SubtitleConfiguration>)g2).get(i).g).E()));
                    final LoadErrorHandlingPolicy f2 = this.f;
                    if (f2 != null) {
                        factory.i(f2);
                    }
                    array[i + 1] = factory.f(MediaItem.e(((List<MediaItem.SubtitleConfiguration>)g2).get(i).a.toString()));
                }
                else {
                    final SingleSampleMediaSource.Factory factory2 = new SingleSampleMediaSource.Factory(this.b);
                    final LoadErrorHandlingPolicy f3 = this.f;
                    if (f3 != null) {
                        factory2.b(f3);
                    }
                    array[i + 1] = factory2.a(((List<MediaItem.SubtitleConfiguration>)g2).get(i), -9223372036854775807L);
                }
                ++i;
            }
            mediaSource = new MergingMediaSource(array);
        }
        return this.j(a, i(a, mediaSource));
    }
    
    @Override
    public int[] b() {
        return this.a.h();
    }
    
    @Override
    public /* bridge */ Factory c(final DrmSessionManagerProvider drmSessionManagerProvider) {
        return this.m(drmSessionManagerProvider);
    }
    
    @Override
    public /* bridge */ Factory d(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        return this.n(loadErrorHandlingPolicy);
    }
    
    public DefaultMediaSourceFactory m(final DrmSessionManagerProvider drmSessionManagerProvider) {
        this.a.p(Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }
    
    public DefaultMediaSourceFactory n(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.f = Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.a.q(loadErrorHandlingPolicy);
        return this;
    }
    
    @Deprecated
    public interface AdsLoaderProvider extends Provider
    {
    }
    
    private static final class a
    {
        private final ExtractorsFactory a;
        private final Map<Integer, Supplier<Factory>> b;
        private final Set<Integer> c;
        private final Map<Integer, Factory> d;
        private DataSource.Factory e;
        private DrmSessionManagerProvider f;
        private LoadErrorHandlingPolicy g;
        
        public a(final ExtractorsFactory a) {
            this.a = a;
            this.b = new HashMap<Integer, Supplier<Factory>>();
            this.c = new HashSet<Integer>();
            this.d = new HashMap<Integer, Factory>();
        }
        
        public static Factory a(final Class clazz) {
            return l(clazz);
        }
        
        public static Factory b(final Class clazz, final DataSource.Factory factory) {
            return j(clazz, factory);
        }
        
        public static Factory c(final Class clazz, final DataSource.Factory factory) {
            return i(clazz, factory);
        }
        
        public static Factory d(final Class clazz, final DataSource.Factory factory) {
            return k(clazz, factory);
        }
        
        public static Factory e(final a a, final DataSource.Factory factory) {
            return a.m(factory);
        }
        
        private void f() {
            this.n(0);
            this.n(1);
            this.n(2);
            this.n(3);
            this.n(4);
        }
        
        private static Factory i(final Class clazz, final DataSource.Factory factory) {
            return DefaultMediaSourceFactory.g(clazz, factory);
        }
        
        private static Factory j(final Class clazz, final DataSource.Factory factory) {
            return DefaultMediaSourceFactory.g(clazz, factory);
        }
        
        private static Factory k(final Class clazz, final DataSource.Factory factory) {
            return DefaultMediaSourceFactory.g(clazz, factory);
        }
        
        private static Factory l(final Class clazz) {
            return DefaultMediaSourceFactory.f(clazz);
        }
        
        private Factory m(final DataSource.Factory factory) {
            return new ProgressiveMediaSource.Factory(factory, this.a);
        }
        
        private Supplier<Factory> n(final int n) {
            if (this.b.containsKey(n)) {
                return this.b.get(n);
            }
            Object o = null;
            final DataSource.Factory factory = Assertions.e(this.e);
            Label_0154: {
                if (n == 0) {
                    break Label_0154;
                }
                Label_0132: {
                    if (n == 1) {
                        break Label_0132;
                    }
                    Label_0110: {
                        if (n == 2) {
                            break Label_0110;
                        }
                        Label_0090: {
                            if (n == 3) {
                                break Label_0090;
                            }
                            while (true) {
                                if (n != 4) {
                                    break Label_0173;
                                }
                                try {
                                    o = new d(this, factory);
                                    this.b.put(n, (Supplier<Factory>)o);
                                    if (o != null) {
                                        this.c.add(n);
                                    }
                                    return (Supplier<Factory>)o;
                                    o = new h(HlsMediaSource.Factory.class.asSubclass(Factory.class), factory);
                                    continue;
                                    o = new e(RtspMediaSource.Factory.class.asSubclass(Factory.class));
                                    continue;
                                    o = new f(SsMediaSource.Factory.class.asSubclass(Factory.class), factory);
                                    continue;
                                    o = new g(DashMediaSource.Factory.class.asSubclass(Factory.class), factory);
                                    continue;
                                }
                                catch (final ClassNotFoundException ex) {
                                    continue;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        public Factory g(final int n) {
            final Factory factory = this.d.get(n);
            if (factory != null) {
                return factory;
            }
            final Supplier<Factory> n2 = this.n(n);
            if (n2 == null) {
                return null;
            }
            final Factory factory2 = (Factory)n2.get();
            final DrmSessionManagerProvider f = this.f;
            if (f != null) {
                factory2.c(f);
            }
            final LoadErrorHandlingPolicy g = this.g;
            if (g != null) {
                factory2.d(g);
            }
            this.d.put(n, factory2);
            return factory2;
        }
        
        public int[] h() {
            this.f();
            return Ints.n((Collection)this.c);
        }
        
        public void o(final DataSource.Factory e) {
            if (e != this.e) {
                this.e = e;
                this.b.clear();
                this.d.clear();
            }
        }
        
        public void p(final DrmSessionManagerProvider f) {
            this.f = f;
            final Iterator<Factory> iterator = this.d.values().iterator();
            while (iterator.hasNext()) {
                iterator.next().c(f);
            }
        }
        
        public void q(final LoadErrorHandlingPolicy g) {
            this.g = g;
            final Iterator<Factory> iterator = this.d.values().iterator();
            while (iterator.hasNext()) {
                iterator.next().d(g);
            }
        }
    }
    
    private static final class b implements Extractor
    {
        private final Format a;
        
        public b(final Format a) {
            this.a = a;
        }
        
        @Override
        public void a(final long n, final long n2) {
        }
        
        @Override
        public void b(final ExtractorOutput extractorOutput) {
            final TrackOutput e = extractorOutput.e(0, 3);
            extractorOutput.l(new SeekMap.Unseekable(-9223372036854775807L));
            extractorOutput.o();
            e.d(this.a.b().e0("text/x-unknown").I(this.a.w).E());
        }
        
        @Override
        public boolean d(final ExtractorInput extractorInput) {
            return true;
        }
        
        @Override
        public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
            if (extractorInput.a(Integer.MAX_VALUE) == -1) {
                return -1;
            }
            return 0;
        }
        
        @Override
        public void release() {
        }
    }
}
