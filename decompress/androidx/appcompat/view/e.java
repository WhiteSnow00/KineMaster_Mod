// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view;

import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
import androidx.appcompat.widget.ActionBarContextView;
import android.content.Context;
import androidx.appcompat.view.menu.g;

public class e extends b implements g.a
{
    private Context c;
    private ActionBarContextView d;
    private a e;
    private WeakReference<View> f;
    private boolean g;
    private boolean h;
    private g i;
    
    public e(final Context c, final ActionBarContextView d, final a e, final boolean h) {
        this.c = c;
        this.d = d;
        this.e = e;
        (this.i = new g(d.getContext()).W(1)).V((g.a)this);
        this.h = h;
    }
    
    @Override
    public boolean a(final g g, final MenuItem menuItem) {
        return this.e.c(this, menuItem);
    }
    
    @Override
    public void b(final g g) {
        this.k();
        this.d.l();
    }
    
    @Override
    public void c() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.e.a(this);
    }
    
    @Override
    public View d() {
        final WeakReference<View> f = this.f;
        View view;
        if (f != null) {
            view = f.get();
        }
        else {
            view = null;
        }
        return view;
    }
    
    @Override
    public Menu e() {
        return (Menu)this.i;
    }
    
    @Override
    public MenuInflater f() {
        return new androidx.appcompat.view.g(this.d.getContext());
    }
    
    @Override
    public CharSequence g() {
        return this.d.getSubtitle();
    }
    
    @Override
    public CharSequence i() {
        return this.d.getTitle();
    }
    
    @Override
    public void k() {
        this.e.d(this, (Menu)this.i);
    }
    
    @Override
    public boolean l() {
        return this.d.j();
    }
    
    @Override
    public void m(final View customView) {
        this.d.setCustomView(customView);
        WeakReference f;
        if (customView != null) {
            f = new WeakReference((T)customView);
        }
        else {
            f = null;
        }
        this.f = f;
    }
    
    @Override
    public void n(final int n) {
        this.o(this.c.getString(n));
    }
    
    @Override
    public void o(final CharSequence subtitle) {
        this.d.setSubtitle(subtitle);
    }
    
    @Override
    public void q(final int n) {
        this.r(this.c.getString(n));
    }
    
    @Override
    public void r(final CharSequence title) {
        this.d.setTitle(title);
    }
    
    @Override
    public void s(final boolean titleOptional) {
        super.s(titleOptional);
        this.d.setTitleOptional(titleOptional);
    }
}
