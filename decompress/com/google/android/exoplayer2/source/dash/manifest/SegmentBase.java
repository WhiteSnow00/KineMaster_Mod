// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import com.google.common.math.BigIntegerMath;
import java.math.RoundingMode;
import java.math.BigInteger;
import com.google.android.exoplayer2.Format;
import java.util.List;
import com.google.android.exoplayer2.util.Util;

public abstract class SegmentBase
{
    final RangedUri a;
    final long b;
    final long c;
    
    public SegmentBase(final RangedUri a, final long b, final long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public RangedUri a(final Representation representation) {
        return this.a;
    }
    
    public long b() {
        return Util.O0(this.c, 1000000L, this.b);
    }
    
    public abstract static class MultiSegmentBase extends SegmentBase
    {
        final long d;
        final long e;
        final List<SegmentTimelineElement> f;
        private final long g;
        private final long h;
        final long i;
        
        public MultiSegmentBase(final RangedUri rangedUri, final long n, final long n2, final long d, final long e, final List<SegmentTimelineElement> f, final long i, final long g, final long h) {
            super(rangedUri, n, n2);
            this.d = d;
            this.e = e;
            this.f = f;
            this.i = i;
            this.g = g;
            this.h = h;
        }
        
        public long c(final long n, final long n2) {
            final long g = this.g(n);
            if (g != -1L) {
                return g;
            }
            return (int)(this.i(n2 - this.h + this.i, n) - this.d(n, n2));
        }
        
        public long d(long i, final long n) {
            if (this.g(i) == -1L) {
                final long g = this.g;
                if (g != -9223372036854775807L) {
                    i = this.i(n - this.h - g, i);
                    return Math.max(this.e(), i);
                }
            }
            return this.e();
        }
        
        public long e() {
            return this.d;
        }
        
        public long f(final long n, long n2) {
            if (this.f != null) {
                return -9223372036854775807L;
            }
            n2 = this.d(n, n2) + this.c(n, n2);
            return this.j(n2) + this.h(n2, n) - this.i;
        }
        
        public abstract long g(final long p0);
        
        public final long h(long n, final long n2) {
            final List<SegmentTimelineElement> f = this.f;
            if (f != null) {
                return f.get((int)(n - this.d)).b * 1000000L / super.b;
            }
            final long g = this.g(n2);
            if (g != -1L && n == this.e() + g - 1L) {
                n = n2 - this.j(n);
            }
            else {
                n = this.e * 1000000L / super.b;
            }
            return n;
        }
        
        public long i(long min, long g) {
            final long e = this.e();
            g = this.g(g);
            if (g == 0L) {
                return e;
            }
            if (this.f == null) {
                min = this.d + min / (this.e * 1000000L / super.b);
                if (min < e) {
                    min = e;
                }
                else if (g != -1L) {
                    min = Math.min(min, e + g - 1L);
                }
                return min;
            }
            long n = g + e - 1L;
            g = e;
            while (g <= n) {
                final long n2 = (n - g) / 2L + g;
                final long n3 = lcmp(this.j(n2), min);
                if (n3 < 0) {
                    g = n2 + 1L;
                }
                else {
                    if (n3 <= 0) {
                        return n2;
                    }
                    n = n2 - 1L;
                }
            }
            if (g == e) {
                n = g;
            }
            return n;
        }
        
        public final long j(long n) {
            final List<SegmentTimelineElement> f = this.f;
            if (f != null) {
                n = f.get((int)(n - this.d)).a - super.c;
            }
            else {
                n = (n - this.d) * this.e;
            }
            return Util.O0(n, 1000000L, super.b);
        }
        
        public abstract RangedUri k(final Representation p0, final long p1);
        
        public boolean l() {
            return this.f != null;
        }
    }
    
    public static final class SegmentList extends MultiSegmentBase
    {
        final List<RangedUri> j;
        
        public SegmentList(final RangedUri rangedUri, final long n, final long n2, final long n3, final long n4, final List<SegmentTimelineElement> list, final long n5, final List<RangedUri> j, final long n6, final long n7) {
            super(rangedUri, n, n2, n3, n4, list, n5, n6, n7);
            this.j = j;
        }
        
        @Override
        public long g(final long n) {
            return this.j.size();
        }
        
        @Override
        public RangedUri k(final Representation representation, final long n) {
            return this.j.get((int)(n - super.d));
        }
        
        @Override
        public boolean l() {
            return true;
        }
    }
    
    public static final class SegmentTemplate extends MultiSegmentBase
    {
        final UrlTemplate j;
        final UrlTemplate k;
        final long l;
        
        public SegmentTemplate(final RangedUri rangedUri, final long n, final long n2, final long n3, final long l, final long n4, final List<SegmentTimelineElement> list, final long n5, final UrlTemplate j, final UrlTemplate k, final long n6, final long n7) {
            super(rangedUri, n, n2, n3, n4, list, n5, n6, n7);
            this.j = j;
            this.k = k;
            this.l = l;
        }
        
        @Override
        public RangedUri a(final Representation representation) {
            final UrlTemplate j = this.j;
            if (j != null) {
                final Format b = representation.b;
                return new RangedUri(j.a(b.a, 0L, b.h, 0L), 0L, -1L);
            }
            return super.a(representation);
        }
        
        @Override
        public long g(final long n) {
            final List<SegmentTimelineElement> f = super.f;
            if (f != null) {
                return f.size();
            }
            final long l = this.l;
            if (l != -1L) {
                return l - super.d + 1L;
            }
            if (n != -9223372036854775807L) {
                return BigIntegerMath.a(BigInteger.valueOf(n).multiply(BigInteger.valueOf(super.b)), BigInteger.valueOf(super.e).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
            }
            return -1L;
        }
        
        @Override
        public RangedUri k(final Representation representation, final long n) {
            final List<SegmentTimelineElement> f = super.f;
            long a;
            if (f != null) {
                a = f.get((int)(n - super.d)).a;
            }
            else {
                a = (n - super.d) * super.e;
            }
            final UrlTemplate k = this.k;
            final Format b = representation.b;
            return new RangedUri(k.a(b.a, n, b.h, a), 0L, -1L);
        }
    }
    
    public static final class SegmentTimelineElement
    {
        final long a;
        final long b;
        
        public SegmentTimelineElement(final long a, final long b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && SegmentTimelineElement.class == o.getClass()) {
                final SegmentTimelineElement segmentTimelineElement = (SegmentTimelineElement)o;
                if (this.a != segmentTimelineElement.a || this.b != segmentTimelineElement.b) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return (int)this.a * 31 + (int)this.b;
        }
    }
    
    public static class SingleSegmentBase extends SegmentBase
    {
        final long d;
        final long e;
        
        public SingleSegmentBase() {
            this(null, 1L, 0L, 0L, 0L);
        }
        
        public SingleSegmentBase(final RangedUri rangedUri, final long n, final long n2, final long d, final long e) {
            super(rangedUri, n, n2);
            this.d = d;
            this.e = e;
        }
        
        public RangedUri c() {
            final long e = this.e;
            RangedUri rangedUri;
            if (e <= 0L) {
                rangedUri = null;
            }
            else {
                rangedUri = new RangedUri(null, this.d, e);
            }
            return rangedUri;
        }
    }
}
