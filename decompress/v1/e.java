// 
// Decompiled by Procyon v0.6.0
// 

package v1;

import q1.o;
import q1.c;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.f;
import android.graphics.PointF;
import u1.m;

public class e implements b
{
    private final String a;
    private final m<PointF, PointF> b;
    private final m<PointF, PointF> c;
    private final u1.b d;
    private final boolean e;
    
    public e(final String a, final m<PointF, PointF> b, final m<PointF, PointF> c, final u1.b d, final boolean e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public c a(final f f, final a a) {
        return new o(f, a, this);
    }
    
    public u1.b b() {
        return this.d;
    }
    
    public String c() {
        return this.a;
    }
    
    public m<PointF, PointF> d() {
        return this.b;
    }
    
    public m<PointF, PointF> e() {
        return this.c;
    }
    
    public boolean f() {
        return this.e;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("RectangleShape{position=");
        sb.append(this.b);
        sb.append(", size=");
        sb.append(this.c);
        sb.append('}');
        return sb.toString();
    }
}
