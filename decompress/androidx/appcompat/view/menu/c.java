// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.SubMenu;
import android.view.MenuItem;
import w.b;
import androidx.collection.g;
import android.content.Context;

abstract class c
{
    final Context a;
    private g<b, MenuItem> b;
    private g<w.c, SubMenu> c;
    
    c(final Context a) {
        this.a = a;
    }
    
    final MenuItem c(MenuItem o) {
        if (o instanceof b) {
            final b b = (b)o;
            if (this.b == null) {
                this.b = new g<b, MenuItem>();
            }
            if ((o = this.b.get(b)) == null) {
                o = new j(this.a, b);
                this.b.put(b, (MenuItem)o);
            }
            return (MenuItem)o;
        }
        return (MenuItem)o;
    }
    
    final SubMenu d(SubMenu o) {
        if (o instanceof w.c) {
            final w.c c = (w.c)o;
            if (this.c == null) {
                this.c = new g<w.c, SubMenu>();
            }
            if ((o = this.c.get(c)) == null) {
                o = new s(this.a, c);
                this.c.put(c, (SubMenu)o);
            }
            return (SubMenu)o;
        }
        return (SubMenu)o;
    }
    
    final void e() {
        final g<b, MenuItem> b = this.b;
        if (b != null) {
            b.clear();
        }
        final g<w.c, SubMenu> c = this.c;
        if (c != null) {
            c.clear();
        }
    }
    
    final void f(final int n) {
        if (this.b == null) {
            return;
        }
        int n2;
        for (int i = 0; i < this.b.size(); i = n2 + 1) {
            n2 = i;
            if (((MenuItem)this.b.i(i)).getGroupId() == n) {
                this.b.k(i);
                n2 = i - 1;
            }
        }
    }
    
    final void g(final int n) {
        if (this.b == null) {
            return;
        }
        for (int i = 0; i < this.b.size(); ++i) {
            if (((MenuItem)this.b.i(i)).getItemId() == n) {
                this.b.k(i);
                break;
            }
        }
    }
}
