// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import java.util.List;
import java.util.Collections;
import z1.c;
import z1.b;

public class p<K, A> extends a<K, A>
{
    private final z1.b<A> i;
    private final A j;
    
    public p(final z1.c<A> c) {
        this((z1.c<Object>)c, null);
    }
    
    public p(final z1.c<A> c, final A j) {
        super(Collections.emptyList());
        this.i = new z1.b<A>();
        this.n(c);
        this.j = j;
    }
    
    @Override
    float c() {
        return 1.0f;
    }
    
    @Override
    public A h() {
        final z1.c<A> e = super.e;
        final A j = this.j;
        return e.b(0.0f, 0.0f, j, j, this.f(), this.f(), this.f());
    }
    
    @Override
    A i(final z1.a<K> a, final float n) {
        return this.h();
    }
    
    @Override
    public void k() {
        if (super.e != null) {
            super.k();
        }
    }
    
    @Override
    public void m(final float d) {
        super.d = d;
    }
}
