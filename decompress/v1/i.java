// 
// Decompiled by Procyon v0.6.0
// 

package v1;

import java.util.Arrays;
import q1.d;
import q1.c;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.f;
import java.util.List;

public class i implements b
{
    private final String a;
    private final List<b> b;
    private final boolean c;
    
    public i(final String a, final List<b> b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public c a(final f f, final a a) {
        return new d(f, a, this);
    }
    
    public List<b> b() {
        return this.b;
    }
    
    public String c() {
        return this.a;
    }
    
    public boolean d() {
        return this.c;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ShapeGroup{name='");
        sb.append(this.a);
        sb.append("' Shapes: ");
        sb.append(Arrays.toString(this.b.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
