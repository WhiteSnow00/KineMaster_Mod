// 
// Decompiled by Procyon v0.6.0
// 

package i2;

import h2.r;
import h2.o;
import c2.b;
import com.bumptech.glide.load.data.j;
import c2.e;
import h2.m;
import c2.d;
import java.io.InputStream;
import h2.g;
import h2.n;

public class a implements n<g, InputStream>
{
    public static final d<Integer> b;
    private final m<g, g> a;
    
    static {
        b = d.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    }
    
    public a(final m<g, g> a) {
        this.a = a;
    }
    
    @Override
    public /* bridge */ boolean a(final Object o) {
        return this.d((g)o);
    }
    
    @Override
    public /* bridge */ n.a b(final Object o, final int n, final int n2, final e e) {
        return this.c((g)o, n, n2, e);
    }
    
    public n.a<InputStream> c(final g g, final int n, final int n2, final e e) {
        final m<g, g> a = this.a;
        g g2 = g;
        if (a != null) {
            g2 = a.a(g, 0, 0);
            if (g2 == null) {
                this.a.b(g, 0, 0, g);
                g2 = g;
            }
        }
        return (n.a<InputStream>)new n.a(g2, (com.bumptech.glide.load.data.d<Object>)new j(g2, e.c(i2.a.b)));
    }
    
    public boolean d(final g g) {
        return true;
    }
    
    public static class a implements o<g, InputStream>
    {
        private final m<g, g> a;
        
        public a() {
            this.a = new m<g, g>(500L);
        }
        
        @Override
        public n<g, InputStream> b(final r r) {
            return new i2.a(this.a);
        }
    }
}
