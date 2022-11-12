// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import v2.l;
import java.util.Queue;
import v2.h;

public class m<A, B>
{
    private final h<b<A>, B> a;
    
    public m(final long n) {
        this.a = new h<b<A>, B>(this, n) {
            final m e;
            
            @Override
            protected /* bridge */ void j(final Object o, final Object o2) {
                this.n((b<A>)o, o2);
            }
            
            protected void n(final b<A> b, final B b2) {
                b.c();
            }
        };
    }
    
    public B a(final A a, final int n, final int n2) {
        final b<A> a2 = b.a(a, n, n2);
        final B g = this.a.g(a2);
        a2.c();
        return g;
    }
    
    public void b(final A a, final int n, final int n2, final B b) {
        this.a.k(m.b.a(a, n, n2), b);
    }
    
    static final class b<A>
    {
        private static final Queue<b<?>> d;
        private int a;
        private int b;
        private A c;
        
        static {
            d = l.f(0);
        }
        
        private b() {
        }
        
        static <A> b<A> a(final A a, final int n, final int n2) {
            Object d = b.d;
            synchronized (d) {
                final b<A> b = ((Queue<b<A>>)d).poll();
                monitorexit(d);
                d = b;
                if (b == null) {
                    d = new b();
                }
                ((b<A>)d).b(a, n, n2);
                return (b<A>)d;
            }
        }
        
        private void b(final A c, final int b, final int a) {
            this.c = c;
            this.b = b;
            this.a = a;
        }
        
        public void c() {
            final Queue<b<?>> d = m.b.d;
            synchronized (d) {
                d.offer(this);
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            final boolean b = o instanceof b;
            boolean b3;
            final boolean b2 = b3 = false;
            if (b) {
                final b b4 = (b)o;
                b3 = b2;
                if (this.b == b4.b) {
                    b3 = b2;
                    if (this.a == b4.a) {
                        b3 = b2;
                        if (this.c.equals(b4.c)) {
                            b3 = true;
                        }
                    }
                }
            }
            return b3;
        }
        
        @Override
        public int hashCode() {
            return (this.a * 31 + this.b) * 31 + this.c.hashCode();
        }
    }
}
