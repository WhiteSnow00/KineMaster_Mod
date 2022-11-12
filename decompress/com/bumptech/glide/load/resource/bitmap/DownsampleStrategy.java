// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import c2.d;

public abstract class DownsampleStrategy
{
    public static final DownsampleStrategy a;
    public static final DownsampleStrategy b;
    public static final DownsampleStrategy c;
    public static final DownsampleStrategy d;
    public static final DownsampleStrategy e;
    public static final DownsampleStrategy f;
    public static final DownsampleStrategy g;
    public static final c2.d<DownsampleStrategy> h;
    static final boolean i;
    
    static {
        a = new a();
        b = new b();
        c = new e();
        d = new c();
        final DownsampleStrategy g2 = e = new d();
        f = new f();
        g = g2;
        h = c2.d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", g2);
        i = true;
    }
    
    public abstract SampleSizeRounding a(final int p0, final int p1, final int p2, final int p3);
    
    public abstract float b(final int p0, final int p1, final int p2, final int p3);
    
    public enum SampleSizeRounding
    {
        private static final SampleSizeRounding[] $VALUES;
        
        MEMORY, 
        QUALITY;
    }
    
    private static class a extends DownsampleStrategy
    {
        a() {
        }
        
        @Override
        public SampleSizeRounding a(final int n, final int n2, final int n3, final int n4) {
            return SampleSizeRounding.QUALITY;
        }
        
        @Override
        public float b(int min, final int n, final int n2, final int n3) {
            min = Math.min(n / n3, min / n2);
            float n4 = 1.0f;
            if (min != 0) {
                n4 = 1.0f / Integer.highestOneBit(min);
            }
            return n4;
        }
    }
    
    private static class b extends DownsampleStrategy
    {
        b() {
        }
        
        @Override
        public SampleSizeRounding a(final int n, final int n2, final int n3, final int n4) {
            return SampleSizeRounding.MEMORY;
        }
        
        @Override
        public float b(int n, int n2, int n3, final int n4) {
            n3 = (int)Math.ceil(Math.max(n2 / (float)n4, n / (float)n3));
            n2 = Integer.highestOneBit(n3);
            n = 1;
            n2 = Math.max(1, n2);
            if (n2 >= n3) {
                n = 0;
            }
            return 1.0f / (n2 << n);
        }
    }
    
    private static class c extends DownsampleStrategy
    {
        c() {
        }
        
        @Override
        public SampleSizeRounding a(final int n, final int n2, final int n3, final int n4) {
            SampleSizeRounding sampleSizeRounding;
            if (this.b(n, n2, n3, n4) == 1.0f) {
                sampleSizeRounding = SampleSizeRounding.QUALITY;
            }
            else {
                sampleSizeRounding = DownsampleStrategy.c.a(n, n2, n3, n4);
            }
            return sampleSizeRounding;
        }
        
        @Override
        public float b(final int n, final int n2, final int n3, final int n4) {
            return Math.min(1.0f, DownsampleStrategy.c.b(n, n2, n3, n4));
        }
    }
    
    private static class d extends DownsampleStrategy
    {
        d() {
        }
        
        @Override
        public SampleSizeRounding a(final int n, final int n2, final int n3, final int n4) {
            return SampleSizeRounding.QUALITY;
        }
        
        @Override
        public float b(final int n, final int n2, final int n3, final int n4) {
            return Math.max(n3 / (float)n, n4 / (float)n2);
        }
    }
    
    private static class e extends DownsampleStrategy
    {
        e() {
        }
        
        @Override
        public SampleSizeRounding a(final int n, final int n2, final int n3, final int n4) {
            if (DownsampleStrategy.i) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }
        
        @Override
        public float b(int max, final int n, final int n2, final int n3) {
            if (DownsampleStrategy.i) {
                return Math.min(n2 / (float)max, n3 / (float)n);
            }
            max = Math.max(n / n3, max / n2);
            float n4 = 1.0f;
            if (max != 0) {
                n4 = 1.0f / Integer.highestOneBit(max);
            }
            return n4;
        }
    }
    
    private static class f extends DownsampleStrategy
    {
        f() {
        }
        
        @Override
        public SampleSizeRounding a(final int n, final int n2, final int n3, final int n4) {
            return SampleSizeRounding.QUALITY;
        }
        
        @Override
        public float b(final int n, final int n2, final int n3, final int n4) {
            return 1.0f;
        }
    }
}
