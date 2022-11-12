// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import java.util.List;
import android.graphics.Path;
import v1.g;

public class l extends a<g, Path>
{
    private final g i;
    private final Path j;
    
    public l(final List<z1.a<g>> list) {
        super(list);
        this.i = new g();
        this.j = new Path();
    }
    
    public /* bridge */ Object i(final z1.a a, final float n) {
        return this.p(a, n);
    }
    
    public Path p(final z1.a<g> a, final float n) {
        this.i.c(a.b, a.c, n);
        y1.g.i(this.i, this.j);
        return this.j;
    }
}
