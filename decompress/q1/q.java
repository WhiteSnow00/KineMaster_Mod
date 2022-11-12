// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import android.graphics.Path$FillType;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import v1.g;
import v1.j;
import com.airbnb.lottie.f;
import android.graphics.Path;
import r1.a;

public class q implements m, b
{
    private final Path a;
    private final String b;
    private final boolean c;
    private final com.airbnb.lottie.f d;
    private final a<?, Path> e;
    private boolean f;
    private q1.b g;
    
    public q(final com.airbnb.lottie.f d, final com.airbnb.lottie.model.layer.a a, final j j) {
        this.a = new Path();
        this.g = new q1.b();
        this.b = j.b();
        this.c = j.d();
        this.d = d;
        final a<g, Path> a2 = j.c().a();
        a.i(this.e = a2);
        a2.a((a.b)this);
    }
    
    private void c() {
        this.f = false;
        this.d.invalidateSelf();
    }
    
    @Override
    public void a() {
        this.c();
    }
    
    @Override
    public void b(final List<c> list, final List<c> list2) {
        for (int i = 0; i < list.size(); ++i) {
            final c c = list.get(i);
            if (c instanceof s) {
                final s s = (s)c;
                if (s.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.g.a(s);
                    s.c(this);
                }
            }
        }
    }
    
    @Override
    public Path getPath() {
        if (this.f) {
            return this.a;
        }
        this.a.reset();
        if (this.c) {
            this.f = true;
            return this.a;
        }
        this.a.set((Path)this.e.h());
        this.a.setFillType(Path$FillType.EVEN_ODD);
        this.g.b(this.a);
        this.f = true;
        return this.a;
    }
}
