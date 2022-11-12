// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.view.SubMenu;

public class r extends g implements SubMenu
{
    private g B;
    private i C;
    
    public r(final Context context, final g b, final i c) {
        super(context);
        this.B = b;
        this.C = c;
    }
    
    @Override
    public g F() {
        return this.B.F();
    }
    
    @Override
    public boolean H() {
        return this.B.H();
    }
    
    public boolean I() {
        return this.B.I();
    }
    
    @Override
    public boolean J() {
        return this.B.J();
    }
    
    @Override
    public void V(final a a) {
        this.B.V(a);
    }
    
    @Override
    public boolean f(final i i) {
        return this.B.f(i);
    }
    
    public MenuItem getItem() {
        return (MenuItem)this.C;
    }
    
    @Override
    boolean h(final g g, final MenuItem menuItem) {
        return super.h(g, menuItem) || this.B.h(g, menuItem);
    }
    
    public Menu i0() {
        return (Menu)this.B;
    }
    
    @Override
    public boolean m(final i i) {
        return this.B.m(i);
    }
    
    @Override
    public void setGroupDividerEnabled(final boolean groupDividerEnabled) {
        this.B.setGroupDividerEnabled(groupDividerEnabled);
    }
    
    public SubMenu setHeaderIcon(final int n) {
        return (SubMenu)super.Y(n);
    }
    
    public SubMenu setHeaderIcon(final Drawable drawable) {
        return (SubMenu)super.Z(drawable);
    }
    
    public SubMenu setHeaderTitle(final int n) {
        return (SubMenu)super.b0(n);
    }
    
    public SubMenu setHeaderTitle(final CharSequence charSequence) {
        return (SubMenu)super.c0(charSequence);
    }
    
    public SubMenu setHeaderView(final View view) {
        return (SubMenu)super.d0(view);
    }
    
    public SubMenu setIcon(final int icon) {
        this.C.setIcon(icon);
        return (SubMenu)this;
    }
    
    public SubMenu setIcon(final Drawable icon) {
        this.C.setIcon(icon);
        return (SubMenu)this;
    }
    
    @Override
    public void setQwertyMode(final boolean qwertyMode) {
        this.B.setQwertyMode(qwertyMode);
    }
    
    public String v() {
        final i c = this.C;
        int itemId;
        if (c != null) {
            itemId = c.getItemId();
        }
        else {
            itemId = 0;
        }
        if (itemId == 0) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(super.v());
        sb.append(":");
        sb.append(itemId);
        return sb.toString();
    }
}
