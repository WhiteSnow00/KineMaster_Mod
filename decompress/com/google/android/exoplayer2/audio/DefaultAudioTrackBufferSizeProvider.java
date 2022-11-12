// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;

public class DefaultAudioTrackBufferSizeProvider implements c
{
    protected final int b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final int f;
    public final int g;
    
    protected DefaultAudioTrackBufferSizeProvider(final Builder builder) {
        this.b = Builder.a(builder);
        this.c = Builder.b(builder);
        this.d = Builder.c(builder);
        this.e = Builder.d(builder);
        this.f = Builder.e(builder);
        this.g = Builder.f(builder);
    }
    
    protected static int b(final int n, final int n2, final int n3) {
        return Ints.d(n * (long)n2 * n3 / 1000000L);
    }
    
    protected static int d(final int n) {
        switch (n) {
            default: {
                throw new IllegalArgumentException();
            }
            case 17: {
                return 336000;
            }
            case 16: {
                return 256000;
            }
            case 15: {
                return 8000;
            }
            case 14: {
                return 3062500;
            }
            case 12: {
                return 7000;
            }
            case 11: {
                return 16000;
            }
            case 10: {
                return 100000;
            }
            case 9: {
                return 40000;
            }
            case 8: {
                return 2250000;
            }
            case 7: {
                return 192000;
            }
            case 6:
            case 18: {
                return 768000;
            }
            case 5: {
                return 80000;
            }
        }
    }
    
    @Override
    public int a(final int n, final int n2, final int n3, final int n4, final int n5, final double n6) {
        return (Math.max(n, (int)(this.c(n, n2, n3, n4, n5) * n6)) + n4 - 1) / n4 * n4;
    }
    
    protected int c(final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n3 == 0) {
            return this.g(n, n5, n4);
        }
        if (n3 == 1) {
            return this.e(n2);
        }
        if (n3 == 2) {
            return this.f(n2);
        }
        throw new IllegalArgumentException();
    }
    
    protected int e(int d) {
        d = d(d);
        return Ints.d(this.f * (long)d / 1000000L);
    }
    
    protected int f(int d) {
        int e = this.e;
        if (d == 5) {
            e *= this.g;
        }
        d = d(d);
        return Ints.d(e * (long)d / 1000000L);
    }
    
    protected int g(final int n, final int n2, final int n3) {
        return Util.q(n * this.d, b(this.b, n2, n3), b(this.c, n2, n3));
    }
    
    public static class Builder
    {
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        
        public Builder() {
            this.a = 250000;
            this.b = 750000;
            this.c = 4;
            this.d = 250000;
            this.e = 50000000;
            this.f = 2;
        }
        
        static int a(final Builder builder) {
            return builder.a;
        }
        
        static int b(final Builder builder) {
            return builder.b;
        }
        
        static int c(final Builder builder) {
            return builder.c;
        }
        
        static int d(final Builder builder) {
            return builder.d;
        }
        
        static int e(final Builder builder) {
            return builder.e;
        }
        
        static int f(final Builder builder) {
            return builder.f;
        }
        
        public DefaultAudioTrackBufferSizeProvider g() {
            return new DefaultAudioTrackBufferSizeProvider(this);
        }
    }
}
