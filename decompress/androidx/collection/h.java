// 
// Decompiled by Procyon v0.6.0
// 

package androidx.collection;

public class h<E> implements Cloneable
{
    private static final Object e;
    private boolean a;
    private int[] b;
    private Object[] c;
    private int d;
    
    static {
        e = new Object();
    }
    
    public h() {
        this(10);
    }
    
    public h(int e) {
        this.a = false;
        if (e == 0) {
            this.b = androidx.collection.c.a;
            this.c = androidx.collection.c.c;
        }
        else {
            e = androidx.collection.c.e(e);
            this.b = new int[e];
            this.c = new Object[e];
        }
    }
    
    private void f() {
        final int d = this.d;
        final int[] b = this.b;
        final Object[] c = this.c;
        int i = 0;
        int d2 = 0;
        while (i < d) {
            final Object o = c[i];
            int n = d2;
            if (o != h.e) {
                if (i != d2) {
                    b[d2] = b[i];
                    c[d2] = o;
                    c[i] = null;
                }
                n = d2 + 1;
            }
            ++i;
            d2 = n;
        }
        this.a = false;
        this.d = d2;
    }
    
    public void b(final int n, final E e) {
        final int d = this.d;
        if (d != 0 && n <= this.b[d - 1]) {
            this.n(n, e);
            return;
        }
        if (this.a && d >= this.b.length) {
            this.f();
        }
        final int d2 = this.d;
        if (d2 >= this.b.length) {
            final int e2 = androidx.collection.c.e(d2 + 1);
            final int[] b = new int[e2];
            final Object[] c = new Object[e2];
            final int[] b2 = this.b;
            System.arraycopy(b2, 0, b, 0, b2.length);
            final Object[] c2 = this.c;
            System.arraycopy(c2, 0, c, 0, c2.length);
            this.b = b;
            this.c = c;
        }
        this.b[d2] = n;
        this.c[d2] = e;
        this.d = d2 + 1;
    }
    
    public void c() {
        final int d = this.d;
        final Object[] c = this.c;
        for (int i = 0; i < d; ++i) {
            c[i] = null;
        }
        this.d = 0;
        this.a = false;
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.d();
    }
    
    public h<E> d() {
        try {
            final h h = (h)super.clone();
            h.b = this.b.clone();
            h.c = this.c.clone();
            return h;
        }
        catch (final CloneNotSupportedException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public boolean e(final E e) {
        return this.j(e) >= 0;
    }
    
    public E g(final int n) {
        return this.h(n, null);
    }
    
    public E h(int a, final E e) {
        a = androidx.collection.c.a(this.b, this.d, a);
        if (a >= 0) {
            final Object[] c = this.c;
            if (c[a] != h.e) {
                return (E)c[a];
            }
        }
        return e;
    }
    
    public int i(final int n) {
        if (this.a) {
            this.f();
        }
        return androidx.collection.c.a(this.b, this.d, n);
    }
    
    public int j(final E e) {
        if (this.a) {
            this.f();
        }
        for (int i = 0; i < this.d; ++i) {
            if (this.c[i] == e) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean l() {
        return this.q() == 0;
    }
    
    public int m(final int n) {
        if (this.a) {
            this.f();
        }
        return this.b[n];
    }
    
    public void n(final int n, final E e) {
        final int a = androidx.collection.c.a(this.b, this.d, n);
        if (a >= 0) {
            this.c[a] = e;
        }
        else {
            final int n2 = ~a;
            final int d = this.d;
            if (n2 < d) {
                final Object[] c = this.c;
                if (c[n2] == h.e) {
                    this.b[n2] = n;
                    c[n2] = e;
                    return;
                }
            }
            int n3 = n2;
            if (this.a) {
                n3 = n2;
                if (d >= this.b.length) {
                    this.f();
                    n3 = ~androidx.collection.c.a(this.b, this.d, n);
                }
            }
            final int d2 = this.d;
            if (d2 >= this.b.length) {
                final int e2 = androidx.collection.c.e(d2 + 1);
                final int[] b = new int[e2];
                final Object[] c2 = new Object[e2];
                final int[] b2 = this.b;
                System.arraycopy(b2, 0, b, 0, b2.length);
                final Object[] c3 = this.c;
                System.arraycopy(c3, 0, c2, 0, c3.length);
                this.b = b;
                this.c = c2;
            }
            final int d3 = this.d;
            if (d3 - n3 != 0) {
                final int[] b3 = this.b;
                final int n4 = n3 + 1;
                System.arraycopy(b3, n3, b3, n4, d3 - n3);
                final Object[] c4 = this.c;
                System.arraycopy(c4, n3, c4, n4, this.d - n3);
            }
            this.b[n3] = n;
            this.c[n3] = e;
            ++this.d;
        }
    }
    
    public void o(final int n) {
        final Object[] c = this.c;
        final Object o = c[n];
        final Object e = h.e;
        if (o != e) {
            c[n] = e;
            this.a = true;
        }
    }
    
    public E p(int i, final E e) {
        i = this.i(i);
        if (i >= 0) {
            final Object[] c = this.c;
            final Object o = c[i];
            c[i] = e;
            return (E)o;
        }
        return null;
    }
    
    public int q() {
        if (this.a) {
            this.f();
        }
        return this.d;
    }
    
    public E r(final int n) {
        if (this.a) {
            this.f();
        }
        return (E)this.c[n];
    }
    
    @Override
    public String toString() {
        if (this.q() <= 0) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i = 0; i < this.d; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.m(i));
            sb.append('=');
            final E r = this.r(i);
            if (r != this) {
                sb.append(r);
            }
            else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
