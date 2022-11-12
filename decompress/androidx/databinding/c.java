// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

public class c<C, T, A> implements Cloneable
{
    private List<C> a;
    private long b;
    private long[] c;
    private int d;
    private final a<C, T, A> e;
    
    public c(final a<C, T, A> e) {
        this.a = new ArrayList<C>();
        this.b = 0L;
        this.e = e;
    }
    
    private boolean d(final int n) {
        final boolean b = true;
        boolean b2 = true;
        if (n < 64) {
            if ((1L << n & this.b) == 0x0L) {
                b2 = false;
            }
            return b2;
        }
        final long[] c = this.c;
        if (c == null) {
            return false;
        }
        final int n2 = n / 64 - 1;
        return n2 < c.length && (1L << n % 64 & c[n2]) != 0x0L && b;
    }
    
    private void f(final T t, final int n, final A a, int i, final int n2, final long n3) {
        long n4 = 1L;
        while (i < n2) {
            if ((n3 & n4) == 0x0L) {
                this.e.a(this.a.get(i), t, n, a);
            }
            n4 <<= 1;
            ++i;
        }
    }
    
    private void g(final T t, final int n, final A a) {
        this.f(t, n, a, 0, Math.min(64, this.a.size()), this.b);
    }
    
    private void h(final T t, final int n, final A a) {
        final int size = this.a.size();
        final long[] c = this.c;
        int n2;
        if (c == null) {
            n2 = -1;
        }
        else {
            n2 = c.length - 1;
        }
        this.i(t, n, a, n2);
        this.f(t, n, a, (n2 + 2) * 64, size, 0L);
    }
    
    private void i(final T t, final int n, final A a, final int n2) {
        if (n2 < 0) {
            this.g(t, n, a);
        }
        else {
            final long n3 = this.c[n2];
            final int n4 = (n2 + 1) * 64;
            final int min = Math.min(this.a.size(), n4 + 64);
            this.i(t, n, a, n2 - 1);
            this.f(t, n, a, n4, min, n3);
        }
    }
    
    private void l(final int n, final long n2) {
        int i = n + 64 - 1;
        long n3 = Long.MIN_VALUE;
        while (i >= n) {
            if ((n2 & n3) != 0x0L) {
                this.a.remove(i);
            }
            n3 >>>= 1;
            --i;
        }
    }
    
    private void m(final int n) {
        if (n < 64) {
            this.b |= 1L << n;
        }
        else {
            final int n2 = n / 64 - 1;
            final long[] c = this.c;
            if (c == null) {
                this.c = new long[this.a.size() / 64];
            }
            else if (c.length <= n2) {
                final long[] c2 = new long[this.a.size() / 64];
                final long[] c3 = this.c;
                System.arraycopy(c3, 0, c2, 0, c3.length);
                this.c = c2;
            }
            final long[] c4 = this.c;
            c4[n2] |= 1L << n % 64;
        }
    }
    
    public void b(final C c) {
        monitorenter(this);
        if (c != null) {
            Label_0059: {
                try {
                    final int lastIndex = this.a.lastIndexOf(c);
                    if (lastIndex < 0 || this.d(lastIndex)) {
                        this.a.add(c);
                    }
                    monitorexit(this);
                    return;
                }
                finally {
                    break Label_0059;
                }
                throw new IllegalArgumentException("callback cannot be null");
            }
            monitorexit(this);
        }
        throw new IllegalArgumentException("callback cannot be null");
    }
    
    public c<C, T, A> c() {
        monitorenter(this);
        Object a = null;
        Label_0116: {
            List<C> list;
            try {
                try {
                    final c c = (c)super.clone();
                    try {
                        c.b = 0L;
                        c.c = null;
                        int n = 0;
                        c.d = 0;
                        a = new ArrayList<C>();
                        c.a = (List<C>)a;
                        final int size = this.a.size();
                        while (true) {
                            a = c;
                            if (n >= size) {
                                break Label_0116;
                            }
                            if (!this.d(n)) {
                                c.a.add(this.a.get(n));
                            }
                            ++n;
                        }
                    }
                    catch (final CloneNotSupportedException a) {}
                }
                finally {}
            }
            catch (final CloneNotSupportedException a) {
                list = null;
            }
            ((CloneNotSupportedException)a).printStackTrace();
            a = list;
        }
        monitorexit(this);
        return (c<C, T, A>)a;
        monitorexit(this);
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.c();
    }
    
    public void e(final T t, int i, final A a) {
        synchronized (this) {
            ++this.d;
            this.h(t, i, a);
            i = this.d - 1;
            this.d = i;
            if (i == 0) {
                final long[] c = this.c;
                if (c != null) {
                    long n;
                    for (i = c.length - 1; i >= 0; --i) {
                        n = this.c[i];
                        if (n != 0L) {
                            this.l((i + 1) * 64, n);
                            this.c[i] = 0L;
                        }
                    }
                }
                final long b = this.b;
                if (b != 0L) {
                    this.l(0, b);
                    this.b = 0L;
                }
            }
        }
    }
    
    public void j(final C c) {
        synchronized (this) {
            if (this.d == 0) {
                this.a.remove(c);
            }
            else {
                final int lastIndex = this.a.lastIndexOf(c);
                if (lastIndex >= 0) {
                    this.m(lastIndex);
                }
            }
        }
    }
    
    public abstract static class a<C, T, A>
    {
        public abstract void a(final C p0, final T p1, final int p2, final A p3);
    }
}
