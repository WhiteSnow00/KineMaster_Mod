// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

import java.util.concurrent.ExecutionException;
import com.google.android.exoplayer2.util.Util;
import v3.a;
import com.google.android.exoplayer2.util.Assertions;
import com.google.firebase.messaging.e;
import com.google.android.exoplayer2.MediaItem;
import java.io.IOException;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.concurrent.Executor;

public final class ProgressiveDownloader implements Downloader
{
    private final Executor a;
    private final DataSpec b;
    private final CacheDataSource c;
    private final CacheWriter d;
    private final PriorityTaskManager e;
    private ProgressListener f;
    private volatile RunnableFutureTask<Void, IOException> g;
    private volatile boolean h;
    
    public ProgressiveDownloader(final MediaItem mediaItem, final CacheDataSource.Factory factory) {
        this(mediaItem, factory, (Executor)com.google.firebase.messaging.e.a);
    }
    
    public ProgressiveDownloader(final MediaItem mediaItem, final CacheDataSource.Factory factory, final Executor executor) {
        this.a = Assertions.e(executor);
        Assertions.e(mediaItem.b);
        final DataSpec a = new DataSpec.Builder().i(mediaItem.b.a).f(mediaItem.b.f).b(4).a();
        this.b = a;
        final CacheDataSource b = factory.b();
        this.c = b;
        this.d = new CacheWriter(b, a, null, (CacheWriter.ProgressListener)new a(this));
        this.e = factory.f();
    }
    
    public static void a(final ProgressiveDownloader progressiveDownloader, final long n, final long n2, final long n3) {
        progressiveDownloader.e(n, n2, n3);
    }
    
    static CacheWriter b(final ProgressiveDownloader progressiveDownloader) {
        return progressiveDownloader.d;
    }
    
    private void e(final long n, final long n2, final long n3) {
        final ProgressListener f = this.f;
        if (f == null) {
            return;
        }
        float n4;
        if (n != -1L && n != 0L) {
            n4 = n2 * 100.0f / n;
        }
        else {
            n4 = -1.0f;
        }
        f.a(n, n2, n4);
    }
    
    public void c() {
        this.h = true;
        final RunnableFutureTask<Void, IOException> g = this.g;
        if (g != null) {
            g.cancel(true);
        }
    }
    
    public void d(final ProgressListener f) throws IOException, InterruptedException {
        this.f = f;
        this.g = new RunnableFutureTask<Void, IOException>(this) {
            final ProgressiveDownloader h;
            
            @Override
            protected void b() {
                ProgressiveDownloader.b(this.h).b();
            }
            
            @Override
            protected /* bridge */ Object c() throws Exception {
                return this.e();
            }
            
            protected Void e() throws IOException {
                ProgressiveDownloader.b(this.h).a();
                return null;
            }
        };
        final PriorityTaskManager e = this.e;
        if (e != null) {
            e.a(-1000);
        }
        int i = 0;
        while (i == 0) {
            try {
                if (!this.h) {
                    final PriorityTaskManager e2 = this.e;
                    if (e2 != null) {
                        e2.b(-1000);
                    }
                    this.a.execute(this.g);
                    try {
                        this.g.get();
                        i = 1;
                    }
                    catch (final ExecutionException ex) {
                        final Throwable t = Assertions.e(ex.getCause());
                        if (t instanceof PriorityTaskManager.PriorityTooLowException) {
                            continue;
                        }
                        if (!(t instanceof IOException)) {
                            Util.R0(t);
                            continue;
                        }
                        throw (IOException)t;
                    }
                }
            }
            finally {
                this.g.a();
                final PriorityTaskManager e3 = this.e;
                if (e3 != null) {
                    e3.d(-1000);
                }
            }
            break;
        }
        this.g.a();
        final PriorityTaskManager e4 = this.e;
        if (e4 != null) {
            e4.d(-1000);
        }
    }
}
