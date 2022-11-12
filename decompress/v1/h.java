// 
// Decompiled by Procyon v0.6.0
// 

package v1;

import q1.g;
import q1.c;
import com.airbnb.lottie.f;
import u1.d;
import u1.a;
import android.graphics.Path$FillType;

public class h implements b
{
    private final boolean a;
    private final Path$FillType b;
    private final String c;
    private final a d;
    private final d e;
    private final boolean f;
    
    public h(final String c, final boolean a, final Path$FillType b, final a d, final d e, final boolean f) {
        this.c = c;
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    @Override
    public c a(final f f, final com.airbnb.lottie.model.layer.a a) {
        return new g(f, a, this);
    }
    
    public a b() {
        return this.d;
    }
    
    public Path$FillType c() {
        return this.b;
    }
    
    public String d() {
        return this.c;
    }
    
    public d e() {
        return this.e;
    }
    
    public boolean f() {
        return this.f;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ShapeFill{color=, fillEnabled=");
        sb.append(this.a);
        sb.append('}');
        return sb.toString();
    }
}
