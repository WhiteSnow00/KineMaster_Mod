// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class SlidingPercentile
{
    private static final Comparator<b> h;
    private static final Comparator<b> i;
    private final int a;
    private final ArrayList<b> b;
    private final b[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    
    static {
        h = e.a;
        i = d.a;
    }
    
    public SlidingPercentile(final int a) {
        this.a = a;
        this.c = new b[5];
        this.b = new ArrayList<b>();
        this.d = -1;
    }
    
    public static int a(final b b, final b b2) {
        return h(b, b2);
    }
    
    public static int b(final b b, final b b2) {
        return g(b, b2);
    }
    
    private void d() {
        if (this.d != 1) {
            Collections.sort(this.b, SlidingPercentile.h);
            this.d = 1;
        }
    }
    
    private void e() {
        if (this.d != 0) {
            Collections.sort(this.b, SlidingPercentile.i);
            this.d = 0;
        }
    }
    
    private static int g(final b b, final b b2) {
        return b.a - b2.a;
    }
    
    private static int h(final b b, final b b2) {
        return Float.compare(b.c, b2.c);
    }
    
    public void c(int b, final float c) {
        this.d();
        int g = this.g;
        b b2;
        if (g > 0) {
            final b[] c2 = this.c;
            --g;
            this.g = g;
            b2 = c2[g];
        }
        else {
            b2 = new b(null);
        }
        b2.a = this.e++;
        b2.b = b;
        b2.c = c;
        this.b.add(b2);
        this.f += b;
        while (true) {
            b = this.f;
            final int a = this.a;
            if (b <= a) {
                break;
            }
            b -= a;
            final b b3 = this.b.get(0);
            final int b4 = b3.b;
            if (b4 <= b) {
                this.f -= b4;
                this.b.remove(0);
                b = this.g;
                if (b >= 5) {
                    continue;
                }
                final b[] c3 = this.c;
                this.g = b + 1;
                c3[b] = b3;
            }
            else {
                b3.b = b4 - b;
                this.f -= b;
            }
        }
    }
    
    public float f(float c) {
        this.e();
        final float n = (float)this.f;
        int i = 0;
        int n2 = 0;
        while (i < this.b.size()) {
            final b b = this.b.get(i);
            n2 += b.b;
            if (n2 >= c * n) {
                return b.c;
            }
            ++i;
        }
        if (this.b.isEmpty()) {
            c = Float.NaN;
        }
        else {
            final ArrayList<b> b2 = this.b;
            c = ((b)b2.get(b2.size() - 1)).c;
        }
        return c;
    }
    
    public void i() {
        this.b.clear();
        this.d = -1;
        this.e = 0;
        this.f = 0;
    }
    
    private static class b
    {
        public int a;
        public int b;
        public float c;
        
        private b() {
        }
        
        b(final SlidingPercentile$a object) {
            this();
        }
    }
}
