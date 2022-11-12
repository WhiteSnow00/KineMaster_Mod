// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import android.util.Pair;
import com.google.android.exoplayer2.source.ShuffleOrder;

public abstract class AbstractConcatenatedTimeline extends Timeline
{
    private final int c;
    private final ShuffleOrder d;
    private final boolean e;
    
    public AbstractConcatenatedTimeline(final boolean e, final ShuffleOrder d) {
        this.e = e;
        this.d = d;
        this.c = d.getLength();
    }
    
    public static Object B(final Object o) {
        return ((Pair)o).second;
    }
    
    public static Object C(final Object o) {
        return ((Pair)o).first;
    }
    
    public static Object E(final Object o, final Object o2) {
        return Pair.create(o, o2);
    }
    
    private int H(int c, final boolean b) {
        if (b) {
            c = this.d.c(c);
        }
        else if (c < this.c - 1) {
            ++c;
        }
        else {
            c = -1;
        }
        return c;
    }
    
    private int I(int b, final boolean b2) {
        if (b2) {
            b = this.d.b(b);
        }
        else if (b > 0) {
            --b;
        }
        else {
            b = -1;
        }
        return b;
    }
    
    protected abstract int A(final int p0);
    
    protected abstract Object D(final int p0);
    
    protected abstract int F(final int p0);
    
    protected abstract int G(final int p0);
    
    protected abstract Timeline J(final int p0);
    
    @Override
    public int e(boolean b) {
        if (this.c == 0) {
            return -1;
        }
        final boolean e = this.e;
        int n = 0;
        if (e) {
            b = false;
        }
        if (b) {
            n = this.d.f();
        }
        while (this.J(n).u()) {
            if ((n = this.H(n, b)) == -1) {
                return -1;
            }
        }
        return this.G(n) + this.J(n).e(b);
    }
    
    @Override
    public final int f(Object b) {
        final boolean b2 = b instanceof Pair;
        int n = -1;
        if (!b2) {
            return -1;
        }
        final Object c = C(b);
        b = B(b);
        final int y = this.y(c);
        if (y == -1) {
            return -1;
        }
        final int f = this.J(y).f(b);
        if (f != -1) {
            n = this.F(y) + f;
        }
        return n;
    }
    
    @Override
    public int g(boolean b) {
        int n = this.c;
        if (n == 0) {
            return -1;
        }
        if (this.e) {
            b = false;
        }
        if (b) {
            n = this.d.d();
        }
        else {
            --n;
        }
        while (this.J(n).u()) {
            if ((n = this.I(n, b)) == -1) {
                return -1;
            }
        }
        return this.G(n) + this.J(n).g(b);
    }
    
    @Override
    public int i(int n, int n2, boolean b) {
        final boolean e = this.e;
        final int n3 = 0;
        int n4 = n2;
        if (e) {
            if ((n4 = n2) == 1) {
                n4 = 2;
            }
            b = false;
        }
        final int a = this.A(n);
        final int g = this.G(a);
        final Timeline j = this.J(a);
        if (n4 == 2) {
            n2 = n3;
        }
        else {
            n2 = n4;
        }
        n = j.i(n - g, n2, b);
        if (n != -1) {
            return g + n;
        }
        for (n = this.H(a, b); n != -1 && this.J(n).u(); n = this.H(n, b)) {}
        if (n != -1) {
            return this.G(n) + this.J(n).e(b);
        }
        if (n4 == 2) {
            return this.e(b);
        }
        return -1;
    }
    
    @Override
    public final Period k(final int n, final Period period, final boolean b) {
        final int z = this.z(n);
        final int g = this.G(z);
        this.J(z).k(n - this.F(z), period, b);
        period.c += g;
        if (b) {
            period.b = E(this.D(z), Assertions.e(period.b));
        }
        return period;
    }
    
    @Override
    public final Period l(final Object b, final Period period) {
        final Object c = C(b);
        final Object b2 = B(b);
        final int y = this.y(c);
        final int g = this.G(y);
        this.J(y).l(b2, period);
        period.c += g;
        period.b = b;
        return period;
    }
    
    @Override
    public int p(int n, int n2, boolean b) {
        final boolean e = this.e;
        final int n3 = 0;
        int n4 = n2;
        if (e) {
            if ((n4 = n2) == 1) {
                n4 = 2;
            }
            b = false;
        }
        final int a = this.A(n);
        final int g = this.G(a);
        final Timeline j = this.J(a);
        if (n4 == 2) {
            n2 = n3;
        }
        else {
            n2 = n4;
        }
        n = j.p(n - g, n2, b);
        if (n != -1) {
            return g + n;
        }
        for (n = this.I(a, b); n != -1 && this.J(n).u(); n = this.I(n, b)) {}
        if (n != -1) {
            return this.G(n) + this.J(n).g(b);
        }
        if (n4 == 2) {
            return this.g(b);
        }
        return -1;
    }
    
    @Override
    public final Object q(final int n) {
        final int z = this.z(n);
        return E(this.D(z), this.J(z).q(n - this.F(z)));
    }
    
    @Override
    public final Window s(final int n, final Window window, final long n2) {
        final int a = this.A(n);
        final int g = this.G(a);
        final int f = this.F(a);
        this.J(a).s(n - g, window, n2);
        Object a2 = this.D(a);
        if (!Window.C.equals(window.a)) {
            a2 = E(a2, window.a);
        }
        window.a = a2;
        window.z += f;
        window.A += f;
        return window;
    }
    
    protected abstract int y(final Object p0);
    
    protected abstract int z(final int p0);
}
