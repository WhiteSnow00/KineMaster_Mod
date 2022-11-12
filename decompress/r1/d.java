// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import z1.a;
import java.util.List;
import v1.c;

public class d extends f<v1.c>
{
    private final v1.c i;
    
    public d(final List<z1.a<v1.c>> list) {
        super(list);
        int c = 0;
        final v1.c c2 = (v1.c)list.get(0).b;
        if (c2 != null) {
            c = c2.c();
        }
        this.i = new v1.c(new float[c], new int[c]);
    }
    
    @Override
    /* bridge */ Object i(final z1.a a, final float n) {
        return this.p(a, n);
    }
    
    v1.c p(final z1.a<v1.c> a, final float n) {
        this.i.d(a.b, a.c, n);
        return this.i;
    }
}
