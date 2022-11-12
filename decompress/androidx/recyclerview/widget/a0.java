// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import androidx.core.util.f;
import androidx.core.util.e;
import androidx.collection.d;
import androidx.collection.g;

class a0
{
    final g<RecyclerView.c0, a> a;
    final d<RecyclerView.c0> b;
    
    a0() {
        this.a = new g<RecyclerView.c0, a>();
        this.b = new d<RecyclerView.c0>();
    }
    
    private RecyclerView.l.c l(final RecyclerView.c0 c0, final int n) {
        final int f = this.a.f(c0);
        if (f < 0) {
            return null;
        }
        final a a = this.a.m(f);
        if (a != null) {
            final int a2 = a.a;
            if ((a2 & n) != 0x0) {
                final int a3 = ~n & a2;
                a.a = a3;
                RecyclerView.l.c c2;
                if (n == 4) {
                    c2 = a.b;
                }
                else {
                    if (n != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    c2 = a.c;
                }
                if ((a3 & 0xC) == 0x0) {
                    this.a.k(f);
                    a0.a.c(a);
                }
                return c2;
            }
        }
        return null;
    }
    
    void a(final RecyclerView.c0 c0, final RecyclerView.l.c b) {
        a b2;
        if ((b2 = this.a.get(c0)) == null) {
            b2 = a0.a.b();
            this.a.put(c0, b2);
        }
        b2.a |= 0x2;
        b2.b = b;
    }
    
    void b(final RecyclerView.c0 c0) {
        a b;
        if ((b = this.a.get(c0)) == null) {
            b = a0.a.b();
            this.a.put(c0, b);
        }
        b.a |= 0x1;
    }
    
    void c(final long n, final RecyclerView.c0 c0) {
        this.b.l(n, c0);
    }
    
    void d(final RecyclerView.c0 c0, final RecyclerView.l.c c2) {
        a b;
        if ((b = this.a.get(c0)) == null) {
            b = a0.a.b();
            this.a.put(c0, b);
        }
        b.c = c2;
        b.a |= 0x8;
    }
    
    void e(final RecyclerView.c0 c0, final RecyclerView.l.c b) {
        a b2;
        if ((b2 = this.a.get(c0)) == null) {
            b2 = a0.a.b();
            this.a.put(c0, b2);
        }
        b2.b = b;
        b2.a |= 0x4;
    }
    
    void f() {
        this.a.clear();
        this.b.b();
    }
    
    RecyclerView.c0 g(final long n) {
        return this.b.f(n);
    }
    
    boolean h(final RecyclerView.c0 c0) {
        final a a = this.a.get(c0);
        boolean b = true;
        if (a == null || (a.a & 0x1) == 0x0) {
            b = false;
        }
        return b;
    }
    
    boolean i(final RecyclerView.c0 c0) {
        final a a = this.a.get(c0);
        return a != null && (a.a & 0x4) != 0x0;
    }
    
    void j() {
        a0.a.a();
    }
    
    public void k(final RecyclerView.c0 c0) {
        this.p(c0);
    }
    
    RecyclerView.l.c m(final RecyclerView.c0 c0) {
        return this.l(c0, 8);
    }
    
    RecyclerView.l.c n(final RecyclerView.c0 c0) {
        return this.l(c0, 4);
    }
    
    void o(final b b) {
        for (int i = this.a.size() - 1; i >= 0; --i) {
            final RecyclerView.c0 c0 = this.a.i(i);
            final a a = this.a.k(i);
            final int a2 = a.a;
            if ((a2 & 0x3) == 0x3) {
                b.b(c0);
            }
            else if ((a2 & 0x1) != 0x0) {
                final RecyclerView.l.c b2 = a.b;
                if (b2 == null) {
                    b.b(c0);
                }
                else {
                    b.c(c0, b2, a.c);
                }
            }
            else if ((a2 & 0xE) == 0xE) {
                b.a(c0, a.b, a.c);
            }
            else if ((a2 & 0xC) == 0xC) {
                b.d(c0, a.b, a.c);
            }
            else if ((a2 & 0x4) != 0x0) {
                b.c(c0, a.b, null);
            }
            else if ((a2 & 0x8) != 0x0) {
                b.a(c0, a.b, a.c);
            }
            a0.a.c(a);
        }
    }
    
    void p(final RecyclerView.c0 c0) {
        final a a = this.a.get(c0);
        if (a == null) {
            return;
        }
        a.a &= 0xFFFFFFFE;
    }
    
    void q(final RecyclerView.c0 c0) {
        for (int i = this.b.o() - 1; i >= 0; --i) {
            if (c0 == this.b.p(i)) {
                this.b.n(i);
                break;
            }
        }
        final a a = this.a.remove(c0);
        if (a != null) {
            a0.a.c(a);
        }
    }
    
    static class a
    {
        static e<a> d;
        int a;
        RecyclerView.l.c b;
        RecyclerView.l.c c;
        
        static {
            a.d = new f<a>(20);
        }
        
        private a() {
        }
        
        static void a() {
            while (a.d.a() != null) {}
        }
        
        static a b() {
            a a;
            if ((a = a0.a.d.a()) == null) {
                a = new a();
            }
            return a;
        }
        
        static void c(final a a) {
            a.a = 0;
            a.b = null;
            a.c = null;
            a0.a.d.b(a);
        }
    }
    
    interface b
    {
        void a(final RecyclerView.c0 p0, final RecyclerView.l.c p1, final RecyclerView.l.c p2);
        
        void b(final RecyclerView.c0 p0);
        
        void c(final RecyclerView.c0 p0, final RecyclerView.l.c p1, final RecyclerView.l.c p2);
        
        void d(final RecyclerView.c0 p0, final RecyclerView.l.c p1, final RecyclerView.l.c p2);
    }
}
