// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import v2.k;
import java.util.Collections;
import com.bumptech.glide.load.data.d;
import java.util.List;
import c2.b;
import c2.e;

public interface n<Model, Data>
{
    boolean a(final Model p0);
    
    a<Data> b(final Model p0, final int p1, final int p2, final e p3);
    
    public static class a<Data>
    {
        public final b a;
        public final List<b> b;
        public final d<Data> c;
        
        public a(final b b, final d<Data> d) {
            this(b, Collections.emptyList(), d);
        }
        
        public a(final b b, final List<b> list, final d<Data> d) {
            this.a = k.d(b);
            this.b = k.d(list);
            this.c = k.d(d);
        }
    }
}
