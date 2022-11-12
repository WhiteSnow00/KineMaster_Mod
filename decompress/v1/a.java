// 
// Decompiled by Procyon v0.6.0
// 

package v1;

import q1.c;
import u1.f;
import android.graphics.PointF;
import u1.m;

public class a implements b
{
    private final String a;
    private final m<PointF, PointF> b;
    private final f c;
    private final boolean d;
    private final boolean e;
    
    public a(final String a, final m<PointF, PointF> b, final f c, final boolean d, final boolean e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public c a(final com.airbnb.lottie.f f, final com.airbnb.lottie.model.layer.a a) {
        return new q1.f(f, a, this);
    }
    
    public String b() {
        return this.a;
    }
    
    public m<PointF, PointF> c() {
        return this.b;
    }
    
    public f d() {
        return this.c;
    }
    
    public boolean e() {
        return this.e;
    }
    
    public boolean f() {
        return this.d;
    }
}
