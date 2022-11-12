// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view;

import java.util.Iterator;
import android.view.View;
import androidx.core.view.k0;
import androidx.core.view.j0;
import android.view.animation.Interpolator;
import androidx.core.view.i0;
import java.util.ArrayList;

public class h
{
    final ArrayList<i0> a;
    private long b;
    private Interpolator c;
    j0 d;
    private boolean e;
    private final k0 f;
    
    public h() {
        this.b = -1L;
        this.f = new k0() {
            private boolean a = false;
            private int b = 0;
            final h c;
            
            @Override
            public void b(final View view) {
                final int b = this.b + 1;
                this.b = b;
                if (b == this.c.a.size()) {
                    final j0 d = this.c.d;
                    if (d != null) {
                        d.b(null);
                    }
                    this.d();
                }
            }
            
            @Override
            public void c(final View view) {
                if (this.a) {
                    return;
                }
                this.a = true;
                final j0 d = this.c.d;
                if (d != null) {
                    d.c(null);
                }
            }
            
            void d() {
                this.b = 0;
                this.a = false;
                this.c.b();
            }
        };
        this.a = new ArrayList<i0>();
    }
    
    public void a() {
        if (!this.e) {
            return;
        }
        final Iterator<i0> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next().c();
        }
        this.e = false;
    }
    
    void b() {
        this.e = false;
    }
    
    public h c(final i0 i0) {
        if (!this.e) {
            this.a.add(i0);
        }
        return this;
    }
    
    public h d(final i0 i0, final i0 i2) {
        this.a.add(i0);
        i2.k(i0.d());
        this.a.add(i2);
        return this;
    }
    
    public h e(final long b) {
        if (!this.e) {
            this.b = b;
        }
        return this;
    }
    
    public h f(final Interpolator c) {
        if (!this.e) {
            this.c = c;
        }
        return this;
    }
    
    public h g(final j0 d) {
        if (!this.e) {
            this.d = d;
        }
        return this;
    }
    
    public void h() {
        if (this.e) {
            return;
        }
        for (final i0 i0 : this.a) {
            final long b = this.b;
            if (b >= 0L) {
                i0.g(b);
            }
            final Interpolator c = this.c;
            if (c != null) {
                i0.h(c);
            }
            if (this.d != null) {
                i0.i(this.f);
            }
            i0.m();
        }
        this.e = true;
    }
}
