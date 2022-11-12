// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work;

import e1.a;
import java.util.HashSet;
import java.util.Set;
import m1.p;
import java.util.UUID;

public abstract class d
{
    private UUID a;
    private p b;
    private Set<String> c;
    
    protected d(final UUID a, final p b, final Set<String> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public String a() {
        return this.a.toString();
    }
    
    public Set<String> b() {
        return this.c;
    }
    
    public p c() {
        return this.b;
    }
    
    public abstract static class a<B extends a<?, ?>, W extends d>
    {
        boolean a;
        UUID b;
        p c;
        Set<String> d;
        Class<? extends ListenableWorker> e;
        
        a(final Class<? extends ListenableWorker> e) {
            this.a = false;
            this.d = new HashSet<String>();
            this.b = UUID.randomUUID();
            this.e = e;
            this.c = new p(this.b.toString(), e.getName());
            this.a(e.getName());
        }
        
        public final B a(final String s) {
            this.d.add(s);
            return this.d();
        }
        
        public final W b() {
            final d c = this.c();
            final e1.a j = this.c.j;
            final boolean b = j.e() || j.f() || j.g() || j.h();
            if (this.c.q && b) {
                throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
            }
            this.b = UUID.randomUUID();
            final p c2 = new p(this.c);
            this.c = c2;
            c2.a = this.b.toString();
            return (W)c;
        }
        
        abstract W c();
        
        abstract B d();
        
        public final B e(final e1.a j) {
            this.c.j = j;
            return this.d();
        }
        
        public final B f(final b e) {
            this.c.e = e;
            return this.d();
        }
    }
}
