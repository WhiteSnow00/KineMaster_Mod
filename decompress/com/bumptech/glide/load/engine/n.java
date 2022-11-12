// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import v2.k;
import c2.b;

class n<Z> implements s<Z>
{
    private final boolean a;
    private final boolean b;
    private final s<Z> c;
    private final a d;
    private final b e;
    private int f;
    private boolean g;
    
    n(final s<Z> s, final boolean a, final boolean b, final b e, final a a2) {
        this.c = k.d(s);
        this.a = a;
        this.b = b;
        this.e = e;
        this.d = k.d(a2);
    }
    
    @Override
    public int a() {
        return this.c.a();
    }
    
    @Override
    public void b() {
        synchronized (this) {
            if (this.f > 0) {
                throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
            }
            if (!this.g) {
                this.g = true;
                if (this.b) {
                    this.c.b();
                }
                return;
            }
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }
    
    @Override
    public Class<Z> c() {
        return this.c.c();
    }
    
    void d() {
        synchronized (this) {
            if (!this.g) {
                ++this.f;
                return;
            }
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }
    
    s<Z> e() {
        return this.c;
    }
    
    boolean f() {
        return this.a;
    }
    
    void g() {
        synchronized (this) {
            int f = this.f;
            if (f > 0) {
                boolean b = true;
                --f;
                if ((this.f = f) != 0) {
                    b = false;
                }
                monitorexit(this);
                if (b) {
                    this.d.c(this.e, this);
                }
                return;
            }
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
    }
    
    @Override
    public Z get() {
        return this.c.get();
    }
    
    @Override
    public String toString() {
        synchronized (this) {
            final StringBuilder sb = new StringBuilder();
            sb.append("EngineResource{isMemoryCacheable=");
            sb.append(this.a);
            sb.append(", listener=");
            sb.append(this.d);
            sb.append(", key=");
            sb.append(this.e);
            sb.append(", acquired=");
            sb.append(this.f);
            sb.append(", isRecycled=");
            sb.append(this.g);
            sb.append(", resource=");
            sb.append(this.c);
            sb.append('}');
            return sb.toString();
        }
    }
    
    interface a
    {
        void c(final b p0, final n<?> p1);
    }
}
