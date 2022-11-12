// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import android.view.MenuItem;
import androidx.core.util.h;

public class k
{
    private final m<?> a;
    
    private k(final m<?> a) {
        this.a = a;
    }
    
    public static k b(final m<?> m) {
        return new k(h.h(m, "callbacks == null"));
    }
    
    public void a(final Fragment fragment) {
        final m<?> a = this.a;
        a.e.o(a, a, fragment);
    }
    
    public void c() {
        this.a.e.A();
    }
    
    public boolean d(final MenuItem menuItem) {
        return this.a.e.D(menuItem);
    }
    
    public void e() {
        this.a.e.E();
    }
    
    public void f() {
        this.a.e.G();
    }
    
    public void g() {
        this.a.e.P();
    }
    
    public void h() {
        this.a.e.T();
    }
    
    public void i() {
        this.a.e.U();
    }
    
    public void j() {
        this.a.e.W();
    }
    
    public boolean k() {
        return this.a.e.d0(true);
    }
    
    public FragmentManager l() {
        return this.a.e;
    }
    
    public void m() {
        this.a.e.d1();
    }
    
    public View n(final View view, final String s, final Context context, final AttributeSet set) {
        return this.a.e.B0().onCreateView(view, s, context, set);
    }
}
