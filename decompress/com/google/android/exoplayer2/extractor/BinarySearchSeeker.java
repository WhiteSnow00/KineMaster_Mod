// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import com.google.android.exoplayer2.util.Assertions;

public abstract class BinarySearchSeeker
{
    protected final BinarySearchSeekMap a;
    protected final TimestampSeeker b;
    protected SeekOperationParams c;
    private final int d;
    
    protected BinarySearchSeeker(final SeekTimestampConverter seekTimestampConverter, final TimestampSeeker b, final long n, final long n2, final long n3, final long n4, final long n5, final long n6, final int d) {
        this.b = b;
        this.d = d;
        this.a = new BinarySearchSeekMap(seekTimestampConverter, n, n2, n3, n4, n5, n6);
    }
    
    protected SeekOperationParams a(final long n) {
        return new SeekOperationParams(n, this.a.k(n), BinarySearchSeekMap.a(this.a), BinarySearchSeekMap.b(this.a), BinarySearchSeekMap.d(this.a), BinarySearchSeekMap.e(this.a), BinarySearchSeekMap.j(this.a));
    }
    
    public final SeekMap b() {
        return this.a;
    }
    
    public int c(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        while (true) {
            final SeekOperationParams seekOperationParams = Assertions.i(this.c);
            final long b = SeekOperationParams.b(seekOperationParams);
            final long c = SeekOperationParams.c(seekOperationParams);
            final long d = SeekOperationParams.d(seekOperationParams);
            if (c - b <= this.d) {
                this.e(false, b);
                return this.g(extractorInput, b, positionHolder);
            }
            if (!this.i(extractorInput, d)) {
                return this.g(extractorInput, d, positionHolder);
            }
            extractorInput.h();
            final TimestampSearchResult a = this.b.a(extractorInput, SeekOperationParams.e(seekOperationParams));
            final int a2 = TimestampSearchResult.a(a);
            if (a2 == -3) {
                this.e(false, d);
                return this.g(extractorInput, d, positionHolder);
            }
            if (a2 != -2) {
                if (a2 != -1) {
                    if (a2 == 0) {
                        this.i(extractorInput, TimestampSearchResult.c(a));
                        this.e(true, TimestampSearchResult.c(a));
                        return this.g(extractorInput, TimestampSearchResult.c(a), positionHolder);
                    }
                    throw new IllegalStateException("Invalid case");
                }
                else {
                    SeekOperationParams.f(seekOperationParams, TimestampSearchResult.b(a), TimestampSearchResult.c(a));
                }
            }
            else {
                SeekOperationParams.g(seekOperationParams, TimestampSearchResult.b(a), TimestampSearchResult.c(a));
            }
        }
    }
    
    public final boolean d() {
        return this.c != null;
    }
    
    protected final void e(final boolean b, final long n) {
        this.c = null;
        this.b.b();
        this.f(b, n);
    }
    
    protected void f(final boolean b, final long n) {
    }
    
    protected final int g(final ExtractorInput extractorInput, final long a, final PositionHolder positionHolder) {
        if (a == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.a = a;
        return 1;
    }
    
    public final void h(final long n) {
        final SeekOperationParams c = this.c;
        if (c != null && SeekOperationParams.a(c) == n) {
            return;
        }
        this.c = this.a(n);
    }
    
    protected final boolean i(final ExtractorInput extractorInput, long n) throws IOException {
        n -= extractorInput.getPosition();
        if (n >= 0L && n <= 262144L) {
            extractorInput.o((int)n);
            return true;
        }
        return false;
    }
    
    public static class BinarySearchSeekMap implements SeekMap
    {
        private final SeekTimestampConverter a;
        private final long b;
        private final long c;
        private final long d;
        private final long e;
        private final long f;
        private final long g;
        
        public BinarySearchSeekMap(final SeekTimestampConverter a, final long b, final long c, final long d, final long e, final long f, final long g) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
        }
        
        static long a(final BinarySearchSeekMap binarySearchSeekMap) {
            return binarySearchSeekMap.c;
        }
        
        static long b(final BinarySearchSeekMap binarySearchSeekMap) {
            return binarySearchSeekMap.d;
        }
        
        static long d(final BinarySearchSeekMap binarySearchSeekMap) {
            return binarySearchSeekMap.e;
        }
        
        static long e(final BinarySearchSeekMap binarySearchSeekMap) {
            return binarySearchSeekMap.f;
        }
        
        static long j(final BinarySearchSeekMap binarySearchSeekMap) {
            return binarySearchSeekMap.g;
        }
        
        @Override
        public SeekPoints f(final long n) {
            return new SeekPoints(new SeekPoint(n, SeekOperationParams.h(this.a.a(n), this.c, this.d, this.e, this.f, this.g)));
        }
        
        @Override
        public boolean h() {
            return true;
        }
        
        @Override
        public long i() {
            return this.b;
        }
        
        public long k(final long n) {
            return this.a.a(n);
        }
    }
    
    public static final class DefaultSeekTimestampConverter implements SeekTimestampConverter
    {
        @Override
        public long a(final long n) {
            return n;
        }
    }
    
    protected static class SeekOperationParams
    {
        private final long a;
        private final long b;
        private final long c;
        private long d;
        private long e;
        private long f;
        private long g;
        private long h;
        
        protected SeekOperationParams(final long a, final long b, final long d, final long e, final long f, final long g, final long c) {
            this.a = a;
            this.b = b;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.c = c;
            this.h = h(b, d, e, f, g, c);
        }
        
        static long a(final SeekOperationParams seekOperationParams) {
            return seekOperationParams.l();
        }
        
        static long b(final SeekOperationParams seekOperationParams) {
            return seekOperationParams.j();
        }
        
        static long c(final SeekOperationParams seekOperationParams) {
            return seekOperationParams.i();
        }
        
        static long d(final SeekOperationParams seekOperationParams) {
            return seekOperationParams.k();
        }
        
        static long e(final SeekOperationParams seekOperationParams) {
            return seekOperationParams.m();
        }
        
        static void f(final SeekOperationParams seekOperationParams, final long n, final long n2) {
            seekOperationParams.o(n, n2);
        }
        
        static void g(final SeekOperationParams seekOperationParams, final long n, final long n2) {
            seekOperationParams.p(n, n2);
        }
        
        protected static long h(long n, final long n2, final long n3, final long n4, final long n5, final long n6) {
            if (n4 + 1L < n5 && n2 + 1L < n3) {
                n = (long)((n - n2) * ((n5 - n4) / (float)(n3 - n2)));
                return Util.r(n + n4 - n6 - n / 20L, n4, n5 - 1L);
            }
            return n4;
        }
        
        private long i() {
            return this.g;
        }
        
        private long j() {
            return this.f;
        }
        
        private long k() {
            return this.h;
        }
        
        private long l() {
            return this.a;
        }
        
        private long m() {
            return this.b;
        }
        
        private void n() {
            this.h = h(this.b, this.d, this.e, this.f, this.g, this.c);
        }
        
        private void o(final long e, final long g) {
            this.e = e;
            this.g = g;
            this.n();
        }
        
        private void p(final long d, final long f) {
            this.d = d;
            this.f = f;
            this.n();
        }
    }
    
    protected interface SeekTimestampConverter
    {
        long a(final long p0);
    }
    
    public static final class TimestampSearchResult
    {
        public static final TimestampSearchResult d;
        private final int a;
        private final long b;
        private final long c;
        
        static {
            d = new TimestampSearchResult(-3, -9223372036854775807L, -1L);
        }
        
        private TimestampSearchResult(final int a, final long b, final long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        static int a(final TimestampSearchResult timestampSearchResult) {
            return timestampSearchResult.a;
        }
        
        static long b(final TimestampSearchResult timestampSearchResult) {
            return timestampSearchResult.b;
        }
        
        static long c(final TimestampSearchResult timestampSearchResult) {
            return timestampSearchResult.c;
        }
        
        public static TimestampSearchResult d(final long n, final long n2) {
            return new TimestampSearchResult(-1, n, n2);
        }
        
        public static TimestampSearchResult e(final long n) {
            return new TimestampSearchResult(0, -9223372036854775807L, n);
        }
        
        public static TimestampSearchResult f(final long n, final long n2) {
            return new TimestampSearchResult(-2, n, n2);
        }
    }
    
    protected interface TimestampSeeker
    {
        TimestampSearchResult a(final ExtractorInput p0, final long p1) throws IOException;
        
        default void b() {
        }
    }
}
