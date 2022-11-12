// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import w.a;
import android.content.Context;
import w.c;
import android.view.SubMenu;

class s extends o implements SubMenu
{
    private final w.c e;
    
    s(final Context context, final w.c e) {
        super(context, e);
        this.e = e;
    }
    
    public void clearHeader() {
        ((SubMenu)this.e).clearHeader();
    }
    
    public MenuItem getItem() {
        return this.c(((SubMenu)this.e).getItem());
    }
    
    public SubMenu setHeaderIcon(final int headerIcon) {
        ((SubMenu)this.e).setHeaderIcon(headerIcon);
        return (SubMenu)this;
    }
    
    public SubMenu setHeaderIcon(final Drawable headerIcon) {
        ((SubMenu)this.e).setHeaderIcon(headerIcon);
        return (SubMenu)this;
    }
    
    public SubMenu setHeaderTitle(final int headerTitle) {
        ((SubMenu)this.e).setHeaderTitle(headerTitle);
        return (SubMenu)this;
    }
    
    public SubMenu setHeaderTitle(final CharSequence headerTitle) {
        ((SubMenu)this.e).setHeaderTitle(headerTitle);
        return (SubMenu)this;
    }
    
    public SubMenu setHeaderView(final View headerView) {
        ((SubMenu)this.e).setHeaderView(headerView);
        return (SubMenu)this;
    }
    
    public SubMenu setIcon(final int icon) {
        ((SubMenu)this.e).setIcon(icon);
        return (SubMenu)this;
    }
    
    public SubMenu setIcon(final Drawable icon) {
        ((SubMenu)this.e).setIcon(icon);
        return (SubMenu)this;
    }
}
