// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.util.Util;
import android.net.Uri;
import java.util.Collection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import java.util.concurrent.Executor;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import java.util.ArrayList;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.DataSpec;

public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader
{
    private final DataSpec a;
    private final ParsingLoadable.Parser<M> b;
    private final ArrayList<StreamKey> c;
    private final CacheDataSource.Factory d;
    private final Cache e;
    private final CacheKeyFactory f;
    private final PriorityTaskManager g;
    private final Executor h;
    private final ArrayList<RunnableFutureTask<?, ?>> i;
    
    public SegmentDownloader(final MediaItem mediaItem, final ParsingLoadable.Parser<M> b, final CacheDataSource.Factory d, final Executor h) {
        Assertions.e(mediaItem.b);
        this.a = a(mediaItem.b.a);
        this.b = b;
        this.c = new ArrayList<StreamKey>(mediaItem.b.e);
        this.d = d;
        this.h = h;
        this.e = Assertions.e(d.d());
        this.f = d.e();
        this.g = d.f();
        this.i = new ArrayList<RunnableFutureTask<?, ?>>();
    }
    
    protected static DataSpec a(final Uri uri) {
        return new DataSpec.Builder().i(uri).b(1).a();
    }
    
    protected static class Segment implements Comparable<Segment>
    {
        public final long a;
        
        public int a(final Segment segment) {
            return Util.o(this.a, segment.a);
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((Segment)o);
        }
    }
}
