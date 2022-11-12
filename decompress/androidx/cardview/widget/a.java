// 
// Decompiled by Procyon v0.6.0
// 

package androidx.cardview.widget;

import android.view.View;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.content.res.ColorStateList;

class a implements c
{
    private d o(final b b) {
        return (d)b.d();
    }
    
    @Override
    public void a(final b b, final float n) {
        this.o(b).h(n);
    }
    
    @Override
    public float b(final b b) {
        return this.o(b).d();
    }
    
    @Override
    public void c(final b b, final float elevation) {
        b.f().setElevation(elevation);
    }
    
    @Override
    public float d(final b b) {
        return this.o(b).c();
    }
    
    @Override
    public ColorStateList e(final b b) {
        return this.o(b).b();
    }
    
    @Override
    public float f(final b b) {
        return this.b(b) * 2.0f;
    }
    
    @Override
    public void g(final b b) {
        this.n(b, this.d(b));
    }
    
    @Override
    public void h(final b b, final Context context, final ColorStateList list, final float n, final float elevation, final float n2) {
        b.b(new d(list, n));
        final View f = b.f();
        f.setClipToOutline(true);
        f.setElevation(elevation);
        this.n(b, n2);
    }
    
    @Override
    public float i(final b b) {
        return b.f().getElevation();
    }
    
    @Override
    public void j(final b b) {
        this.n(b, this.d(b));
    }
    
    @Override
    public void k() {
    }
    
    @Override
    public float l(final b b) {
        return this.b(b) * 2.0f;
    }
    
    @Override
    public void m(final b b, final ColorStateList list) {
        this.o(b).f(list);
    }
    
    @Override
    public void n(final b b, final float n) {
        this.o(b).g(n, b.c(), b.e());
        this.p(b);
    }
    
    public void p(final b b) {
        if (!b.c()) {
            b.a(0, 0, 0, 0);
            return;
        }
        final float d = this.d(b);
        final float b2 = this.b(b);
        final int n = (int)Math.ceil(e.a(d, b2, b.e()));
        final int n2 = (int)Math.ceil(e.b(d, b2, b.e()));
        b.a(n, n2, n, n2);
    }
}
