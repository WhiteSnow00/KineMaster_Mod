// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import z1.a;
import java.util.List;
import com.airbnb.lottie.model.DocumentData;

public class n extends f<DocumentData>
{
    public n(final List<z1.a<DocumentData>> list) {
        super(list);
    }
    
    @Override
    /* bridge */ Object i(final z1.a a, final float n) {
        return this.p(a, n);
    }
    
    DocumentData p(final z1.a<DocumentData> a, final float n) {
        if (n == 1.0f) {
            final DocumentData c = a.c;
            if (c != null) {
                return c;
            }
        }
        return a.b;
    }
}
