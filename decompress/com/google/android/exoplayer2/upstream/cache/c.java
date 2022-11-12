// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.util.Iterator;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.TreeSet;

final class c
{
    public final int a;
    public final String b;
    private final TreeSet<f> c;
    private final ArrayList<a> d;
    private DefaultContentMetadata e;
    
    public c(final int n, final String s) {
        this(n, s, DefaultContentMetadata.c);
    }
    
    public c(final int a, final String b, final DefaultContentMetadata e) {
        this.a = a;
        this.b = b;
        this.e = e;
        this.c = new TreeSet<f>();
        this.d = new ArrayList<a>();
    }
    
    public void a(final f f) {
        this.c.add(f);
    }
    
    public boolean b(final ContentMetadataMutations contentMetadataMutations) {
        final DefaultContentMetadata e = this.e;
        final DefaultContentMetadata g = e.g(contentMetadataMutations);
        this.e = g;
        return g.equals(e) ^ true;
    }
    
    public long c(final long n, final long n2) {
        final boolean b = true;
        Assertions.a(n >= 0L);
        Assertions.a(n2 >= 0L && b);
        final f e = this.e(n, n2);
        final boolean c = e.c();
        long c2 = Long.MAX_VALUE;
        if (c) {
            if (!e.d()) {
                c2 = e.c;
            }
            return -Math.min(c2, n2);
        }
        final long n3 = n + n2;
        if (n3 >= 0L) {
            c2 = n3;
        }
        long n4;
        long max = n4 = e.b + e.c;
        if (max < c2) {
            final Iterator<f> iterator = this.c.tailSet(e, false).iterator();
            do {
                n4 = max;
                if (!iterator.hasNext()) {
                    break;
                }
                final f f = iterator.next();
                final long b2 = f.b;
                if (b2 > max) {
                    n4 = max;
                    break;
                }
                n4 = (max = Math.max(max, b2 + f.c));
            } while (n4 < c2);
        }
        return Math.min(n4 - n, n2);
    }
    
    public DefaultContentMetadata d() {
        return this.e;
    }
    
    public f e(final long n, final long n2) {
        final f k = f.k(this.b, n);
        final f f = this.c.floor(k);
        if (f != null && f.b + f.c > n) {
            return f;
        }
        final f f2 = this.c.ceiling(k);
        long min = n2;
        if (f2 != null) {
            min = f2.b - n;
            if (n2 != -1L) {
                min = Math.min(min, n2);
            }
        }
        return com.google.android.exoplayer2.upstream.cache.f.i(this.b, n, min);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && c.class == o.getClass()) {
            final c c = (c)o;
            if (this.a != c.a || !this.b.equals(c.b) || !this.c.equals(c.c) || !this.e.equals(c.e)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public TreeSet<f> f() {
        return this.c;
    }
    
    public boolean g() {
        return this.c.isEmpty();
    }
    
    public boolean h(final long n, final long n2) {
        for (int i = 0; i < this.d.size(); ++i) {
            if (this.d.get(i).a(n, n2)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (this.a * 31 + this.b.hashCode()) * 31 + this.e.hashCode();
    }
    
    public boolean i() {
        return this.d.isEmpty();
    }
    
    public boolean j(final long n, final long n2) {
        for (int i = 0; i < this.d.size(); ++i) {
            if (this.d.get(i).b(n, n2)) {
                return false;
            }
        }
        this.d.add(new a(n, n2));
        return true;
    }
    
    public boolean k(final CacheSpan cacheSpan) {
        if (this.c.remove(cacheSpan)) {
            final File e = cacheSpan.e;
            if (e != null) {
                e.delete();
            }
            return true;
        }
        return false;
    }
    
    public f l(f f, final long n, final boolean b) {
        Assertions.g(this.c.remove(f));
        File l;
        final File file = l = Assertions.e(f.e);
        if (b) {
            l = f.l(Assertions.e(file.getParentFile()), this.a, f.b, n);
            if (!file.renameTo(l)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to rename ");
                sb.append(file);
                sb.append(" to ");
                sb.append(l);
                Log.i("CachedContent", sb.toString());
                l = file;
            }
        }
        f = f.f(l, n);
        this.c.add(f);
        return f;
    }
    
    public void m(final long n) {
        for (int i = 0; i < this.d.size(); ++i) {
            if (this.d.get(i).a == n) {
                this.d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }
    
    private static final class a
    {
        public final long a;
        public final long b;
        
        public a(final long a, final long b) {
            this.a = a;
            this.b = b;
        }
        
        public boolean a(final long n, final long n2) {
            final long b = this.b;
            final boolean b2 = true;
            boolean b3 = true;
            if (b == -1L) {
                if (n < this.a) {
                    b3 = false;
                }
                return b3;
            }
            if (n2 == -1L) {
                return false;
            }
            final long a = this.a;
            return a <= n && n + n2 <= a + b && b2;
        }
        
        public boolean b(final long n, long b) {
            final long a = this.a;
            boolean b2 = false;
            final boolean b3 = false;
            if (a <= n) {
                b = this.b;
                if (b != -1L) {
                    final boolean b4 = b3;
                    if (a + b <= n) {
                        return b4;
                    }
                }
                return true;
            }
            if (b == -1L || n + b > a) {
                b2 = true;
            }
            return b2;
        }
    }
}
