// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import java.util.ArrayList;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import r1.a;

public class s implements c, b
{
    private final String a;
    private final boolean b;
    private final List<b> c;
    private final ShapeTrimPath.Type d;
    private final a<?, Float> e;
    private final a<?, Float> f;
    private final a<?, Float> g;
    
    public s(final com.airbnb.lottie.model.layer.a a, final ShapeTrimPath shapeTrimPath) {
        this.c = new ArrayList<b>();
        this.a = shapeTrimPath.c();
        this.b = shapeTrimPath.g();
        this.d = shapeTrimPath.f();
        final a<Float, Float> a2 = shapeTrimPath.e().a();
        this.e = a2;
        final a<Float, Float> a3 = shapeTrimPath.b().a();
        this.f = a3;
        final a<Float, Float> a4 = shapeTrimPath.d().a();
        this.g = a4;
        a.i(a2);
        a.i(a3);
        a.i(a4);
        a2.a((a.b)this);
        a3.a((a.b)this);
        a4.a((a.b)this);
    }
    
    @Override
    public void a() {
        for (int i = 0; i < this.c.size(); ++i) {
            this.c.get(i).a();
        }
    }
    
    @Override
    public void b(final List<c> list, final List<c> list2) {
    }
    
    void c(final b b) {
        this.c.add(b);
    }
    
    public a<?, Float> d() {
        return this.f;
    }
    
    public a<?, Float> f() {
        return this.g;
    }
    
    public a<?, Float> h() {
        return this.e;
    }
    
    ShapeTrimPath.Type i() {
        return this.d;
    }
    
    public boolean j() {
        return this.b;
    }
}
