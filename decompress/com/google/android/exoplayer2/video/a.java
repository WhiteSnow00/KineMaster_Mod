// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import java.util.Arrays;

final class a
{
    private a a;
    private a b;
    private boolean c;
    private boolean d;
    private long e;
    private int f;
    
    public a() {
        this.a = new a();
        this.b = new a();
        this.e = -9223372036854775807L;
    }
    
    public long a() {
        long a;
        if (this.e()) {
            a = this.a.a();
        }
        else {
            a = -9223372036854775807L;
        }
        return a;
    }
    
    public float b() {
        float n;
        if (this.e()) {
            n = (float)(1.0E9 / this.a.a());
        }
        else {
            n = -1.0f;
        }
        return n;
    }
    
    public int c() {
        return this.f;
    }
    
    public long d() {
        long b;
        if (this.e()) {
            b = this.a.b();
        }
        else {
            b = -9223372036854775807L;
        }
        return b;
    }
    
    public boolean e() {
        return this.a.e();
    }
    
    public void f(final long e) {
        this.a.f(e);
        final boolean e2 = this.a.e();
        int f = 0;
        if (e2 && !this.d) {
            this.c = false;
        }
        else if (this.e != -9223372036854775807L) {
            if (!this.c || this.b.d()) {
                this.b.g();
                this.b.f(this.e);
            }
            this.c = true;
            this.b.f(e);
        }
        if (this.c && this.b.e()) {
            final a a = this.a;
            this.a = this.b;
            this.b = a;
            this.c = false;
            this.d = false;
        }
        this.e = e;
        if (!this.a.e()) {
            f = this.f + 1;
        }
        this.f = f;
    }
    
    public void g() {
        this.a.g();
        this.b.g();
        this.c = false;
        this.e = -9223372036854775807L;
        this.f = 0;
    }
    
    private static final class a
    {
        private long a;
        private long b;
        private long c;
        private long d;
        private long e;
        private long f;
        private final boolean[] g;
        private int h;
        
        public a() {
            this.g = new boolean[15];
        }
        
        private static int c(final long n) {
            return (int)(n % 15L);
        }
        
        public long a() {
            final long e = this.e;
            long n = 0L;
            if (e != 0L) {
                n = this.f / e;
            }
            return n;
        }
        
        public long b() {
            return this.f;
        }
        
        public boolean d() {
            final long d = this.d;
            return d != 0L && this.g[c(d - 1L)];
        }
        
        public boolean e() {
            return this.d > 15L && this.h == 0;
        }
        
        public void f(final long n) {
            final long d = this.d;
            if (d == 0L) {
                this.a = n;
            }
            else if (d == 1L) {
                final long n2 = n - this.a;
                this.b = n2;
                this.f = n2;
                this.e = 1L;
            }
            else {
                final long n3 = n - this.c;
                final int c = c(d);
                if (Math.abs(n3 - this.b) <= 1000000L) {
                    ++this.e;
                    this.f += n3;
                    final boolean[] g = this.g;
                    if (g[c]) {
                        g[c] = false;
                        --this.h;
                    }
                }
                else {
                    final boolean[] g2 = this.g;
                    if (!g2[c]) {
                        g2[c] = true;
                        ++this.h;
                    }
                }
            }
            ++this.d;
            this.c = n;
        }
        
        public void g() {
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
            this.h = 0;
            Arrays.fill(this.g, false);
        }
    }
}
