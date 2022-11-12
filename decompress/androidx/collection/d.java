// 
// Decompiled by Procyon v0.6.0
// 

package androidx.collection;

public class d<E> implements Cloneable
{
    private static final Object e;
    private boolean a;
    private long[] b;
    private Object[] c;
    private int d;
    
    static {
        e = new Object();
    }
    
    public d() {
        this(10);
    }
    
    public d(int f) {
        this.a = false;
        if (f == 0) {
            this.b = androidx.collection.c.b;
            this.c = androidx.collection.c.c;
        }
        else {
            f = androidx.collection.c.f(f);
            this.b = new long[f];
            this.c = new Object[f];
        }
    }
    
    private void e() {
        final int d = this.d;
        final long[] b = this.b;
        final Object[] c = this.c;
        int i = 0;
        int d2 = 0;
        while (i < d) {
            final Object o = c[i];
            int n = d2;
            if (o != androidx.collection.d.e) {
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
    
    public void b() {
        final int d = this.d;
        final Object[] c = this.c;
        for (int i = 0; i < d; ++i) {
            c[i] = null;
        }
        this.d = 0;
        this.a = false;
    }
    
    public d<E> c() {
        try {
            final d d = (d)super.clone();
            d.b = this.b.clone();
            d.c = this.c.clone();
            return d;
        }
        catch (final CloneNotSupportedException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.c();
    }
    
    public boolean d(final long n) {
        return this.h(n) >= 0;
    }
    
    public E f(final long n) {
        return this.g(n, null);
    }
    
    public E g(final long n, final E e) {
        final int b = androidx.collection.c.b(this.b, this.d, n);
        if (b >= 0) {
            final Object[] c = this.c;
            if (c[b] != androidx.collection.d.e) {
                return (E)c[b];
            }
        }
        return e;
    }
    
    public int h(final long n) {
        if (this.a) {
            this.e();
        }
        return androidx.collection.c.b(this.b, this.d, n);
    }
    
    public boolean i() {
        return this.o() == 0;
    }
    
    public long j(final int n) {
        if (this.a) {
            this.e();
        }
        return this.b[n];
    }
    
    public void l(final long n, final E e) {
        final int b = androidx.collection.c.b(this.b, this.d, n);
        if (b >= 0) {
            this.c[b] = e;
        }
        else {
            final int n2 = ~b;
            final int d = this.d;
            if (n2 < d) {
                final Object[] c = this.c;
                if (c[n2] == androidx.collection.d.e) {
                    this.b[n2] = n;
                    c[n2] = e;
                    return;
                }
            }
            int n3 = n2;
            if (this.a) {
                n3 = n2;
                if (d >= this.b.length) {
                    this.e();
                    n3 = ~androidx.collection.c.b(this.b, this.d, n);
                }
            }
            final int d2 = this.d;
            if (d2 >= this.b.length) {
                final int f = androidx.collection.c.f(d2 + 1);
                final long[] b2 = new long[f];
                final Object[] c2 = new Object[f];
                final long[] b3 = this.b;
                System.arraycopy(b3, 0, b2, 0, b3.length);
                final Object[] c3 = this.c;
                System.arraycopy(c3, 0, c2, 0, c3.length);
                this.b = b2;
                this.c = c2;
            }
            final int d3 = this.d;
            if (d3 - n3 != 0) {
                final long[] b4 = this.b;
                final int n4 = n3 + 1;
                System.arraycopy(b4, n3, b4, n4, d3 - n3);
                final Object[] c4 = this.c;
                System.arraycopy(c4, n3, c4, n4, this.d - n3);
            }
            this.b[n3] = n;
            this.c[n3] = e;
            ++this.d;
        }
    }
    
    public void m(final long n) {
        final int b = androidx.collection.c.b(this.b, this.d, n);
        if (b >= 0) {
            final Object[] c = this.c;
            final Object o = c[b];
            final Object e = androidx.collection.d.e;
            if (o != e) {
                c[b] = e;
                this.a = true;
            }
        }
    }
    
    public void n(final int n) {
        final Object[] c = this.c;
        final Object o = c[n];
        final Object e = androidx.collection.d.e;
        if (o != e) {
            c[n] = e;
            this.a = true;
        }
    }
    
    public int o() {
        if (this.a) {
            this.e();
        }
        return this.d;
    }
    
    public E p(final int n) {
        if (this.a) {
            this.e();
        }
        return (E)this.c[n];
    }
    
    @Override
    public String toString() {
        if (this.o() <= 0) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i = 0; i < this.d; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.j(i));
            sb.append('=');
            final E p = this.p(i);
            if (p != this) {
                sb.append(p);
            }
            else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
