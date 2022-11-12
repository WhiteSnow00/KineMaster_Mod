// 
// Decompiled by Procyon v0.6.0
// 

package v1;

import q1.h;
import com.airbnb.lottie.model.layer.a;
import u1.f;
import u1.c;
import android.graphics.Path$FillType;
import com.airbnb.lottie.model.content.GradientType;

public class d implements b
{
    private final GradientType a;
    private final Path$FillType b;
    private final c c;
    private final u1.d d;
    private final f e;
    private final f f;
    private final String g;
    private final u1.b h;
    private final u1.b i;
    private final boolean j;
    
    public d(final String g, final GradientType a, final Path$FillType b, final c c, final u1.d d, final f e, final f f, final u1.b h, final u1.b i, final boolean j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    @Override
    public q1.c a(final com.airbnb.lottie.f f, final a a) {
        return new h(f, a, this);
    }
    
    public f b() {
        return this.f;
    }
    
    public Path$FillType c() {
        return this.b;
    }
    
    public c d() {
        return this.c;
    }
    
    public GradientType e() {
        return this.a;
    }
    
    public String f() {
        return this.g;
    }
    
    public u1.d g() {
        return this.d;
    }
    
    public f h() {
        return this.e;
    }
    
    public boolean i() {
        return this.j;
    }
}
