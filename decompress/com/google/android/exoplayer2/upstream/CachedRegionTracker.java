// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Log;
import java.util.Arrays;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import java.util.TreeSet;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.upstream.cache.Cache;

public final class CachedRegionTracker implements Listener
{
    private final ChunkIndex a;
    private final TreeSet<a> b;
    
    private void g(final CacheSpan cacheSpan) {
        final long b = cacheSpan.b;
        final a a = new a(b, cacheSpan.c + b);
        final a a2 = this.b.floor(a);
        final a a3 = this.b.ceiling(a);
        final boolean h = this.h(a2, a);
        if (this.h(a, a3)) {
            if (h) {
                a2.b = a3.b;
                a2.c = a3.c;
            }
            else {
                a.b = a3.b;
                a.c = a3.c;
                this.b.add(a);
            }
            this.b.remove(a3);
        }
        else if (h) {
            a2.b = a.b;
            int c = a2.c;
            while (true) {
                final ChunkIndex a4 = this.a;
                if (c >= a4.a - 1) {
                    break;
                }
                final long[] c2 = a4.c;
                final int n = c + 1;
                if (c2[n] > a2.b) {
                    break;
                }
                c = n;
            }
            a2.c = c;
        }
        else {
            final int binarySearch = Arrays.binarySearch(this.a.c, a.b);
            int c3;
            if ((c3 = binarySearch) < 0) {
                c3 = -binarySearch - 2;
            }
            a.c = c3;
            this.b.add(a);
        }
    }
    
    private boolean h(final a a, final a a2) {
        return a != null && a2 != null && a.b == a2.a;
    }
    
    @Override
    public void a(final Cache cache, final CacheSpan cacheSpan) {
        synchronized (this) {
            this.g(cacheSpan);
        }
    }
    
    @Override
    public void d(final Cache cache, final CacheSpan cacheSpan) {
        synchronized (this) {
            final long b = cacheSpan.b;
            final a a = new a(b, cacheSpan.c + b);
            final a a2 = this.b.floor(a);
            if (a2 == null) {
                Log.c("CachedRegionTracker", "Removed a span we were not aware of");
                return;
            }
            this.b.remove(a2);
            final long a3 = a2.a;
            final long a4 = a.a;
            if (a3 < a4) {
                final a a5 = new a(a3, a4);
                final int binarySearch = Arrays.binarySearch(this.a.c, a5.b);
                int c;
                if ((c = binarySearch) < 0) {
                    c = -binarySearch - 2;
                }
                a5.c = c;
                this.b.add(a5);
            }
            final long b2 = a2.b;
            final long b3 = a.b;
            if (b2 > b3) {
                final a a6 = new a(b3 + 1L, b2);
                a6.c = a2.c;
                this.b.add(a6);
            }
        }
    }
    
    @Override
    public void e(final Cache cache, final CacheSpan cacheSpan, final CacheSpan cacheSpan2) {
    }
    
    private static class a implements Comparable<a>
    {
        public long a;
        public long b;
        public int c;
        
        public a(final long a, final long b) {
            this.a = a;
            this.b = b;
        }
        
        public int a(final a a) {
            return Util.o(this.a, a.a);
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((a)o);
        }
    }
}
