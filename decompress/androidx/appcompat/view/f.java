// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view;

import androidx.appcompat.view.menu.j;
import android.view.MenuItem;
import androidx.collection.g;
import java.util.ArrayList;
import android.view.ActionMode$Callback;
import android.view.MenuInflater;
import androidx.appcompat.view.menu.o;
import w.a;
import android.view.Menu;
import android.view.View;
import android.content.Context;
import android.view.ActionMode;

public class f extends ActionMode
{
    final Context a;
    final b b;
    
    public f(final Context a, final b b) {
        this.a = a;
        this.b = b;
    }
    
    public void finish() {
        this.b.c();
    }
    
    public View getCustomView() {
        return this.b.d();
    }
    
    public Menu getMenu() {
        return (Menu)new o(this.a, (w.a)this.b.e());
    }
    
    public MenuInflater getMenuInflater() {
        return this.b.f();
    }
    
    public CharSequence getSubtitle() {
        return this.b.g();
    }
    
    public Object getTag() {
        return this.b.h();
    }
    
    public CharSequence getTitle() {
        return this.b.i();
    }
    
    public boolean getTitleOptionalHint() {
        return this.b.j();
    }
    
    public void invalidate() {
        this.b.k();
    }
    
    public boolean isTitleOptional() {
        return this.b.l();
    }
    
    public void setCustomView(final View view) {
        this.b.m(view);
    }
    
    public void setSubtitle(final int n) {
        this.b.n(n);
    }
    
    public void setSubtitle(final CharSequence charSequence) {
        this.b.o(charSequence);
    }
    
    public void setTag(final Object o) {
        this.b.p(o);
    }
    
    public void setTitle(final int n) {
        this.b.q(n);
    }
    
    public void setTitle(final CharSequence charSequence) {
        this.b.r(charSequence);
    }
    
    public void setTitleOptionalHint(final boolean b) {
        this.b.s(b);
    }
    
    public static class a implements b.a
    {
        final ActionMode$Callback a;
        final Context b;
        final ArrayList<f> c;
        final g<Menu, Menu> d;
        
        public a(final Context b, final ActionMode$Callback a) {
            this.b = b;
            this.a = a;
            this.c = new ArrayList<f>();
            this.d = new g<Menu, Menu>();
        }
        
        private Menu f(final Menu menu) {
            Object o;
            if ((o = this.d.get(menu)) == null) {
                o = new o(this.b, (w.a)menu);
                this.d.put(menu, (Menu)o);
            }
            return (Menu)o;
        }
        
        @Override
        public void a(final b b) {
            this.a.onDestroyActionMode(this.e(b));
        }
        
        @Override
        public boolean b(final b b, final Menu menu) {
            return this.a.onCreateActionMode(this.e(b), this.f(menu));
        }
        
        @Override
        public boolean c(final b b, final MenuItem menuItem) {
            return this.a.onActionItemClicked(this.e(b), (MenuItem)new j(this.b, (w.b)menuItem));
        }
        
        @Override
        public boolean d(final b b, final Menu menu) {
            return this.a.onPrepareActionMode(this.e(b), this.f(menu));
        }
        
        public ActionMode e(final b b) {
            for (int size = this.c.size(), i = 0; i < size; ++i) {
                final f f = this.c.get(i);
                if (f != null && f.b == b) {
                    return f;
                }
            }
            final f f2 = new f(this.b, b);
            this.c.add(f2);
            return f2;
        }
    }
}
