// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.MenuItem$OnActionExpandListener;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ActionProvider;
import android.view.View;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.view.MenuItem$OnMenuItemClickListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.content.Intent;
import w.b;

public class a implements b
{
    private final int a;
    private final int b;
    private final int c;
    private CharSequence d;
    private CharSequence e;
    private Intent f;
    private char g;
    private int h;
    private char i;
    private int j;
    private Drawable k;
    private Context l;
    private MenuItem$OnMenuItemClickListener m;
    private CharSequence n;
    private CharSequence o;
    private ColorStateList p;
    private PorterDuff$Mode q;
    private boolean r;
    private boolean s;
    private int t;
    
    public a(final Context l, final int b, final int a, final int n, final int c, final CharSequence d) {
        this.h = 4096;
        this.j = 4096;
        this.p = null;
        this.q = null;
        this.r = false;
        this.s = false;
        this.t = 16;
        this.l = l;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    private void c() {
        final Drawable k = this.k;
        if (k != null && (this.r || this.s)) {
            final Drawable l = androidx.core.graphics.drawable.a.l(k);
            this.k = l;
            final Drawable mutate = l.mutate();
            this.k = mutate;
            if (this.r) {
                androidx.core.graphics.drawable.a.i(mutate, this.p);
            }
            if (this.s) {
                androidx.core.graphics.drawable.a.j(this.k, this.q);
            }
        }
    }
    
    @Override
    public androidx.core.view.b a() {
        return null;
    }
    
    @Override
    public b b(final androidx.core.view.b b) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean collapseActionView() {
        return false;
    }
    
    public b d(final int n) {
        throw new UnsupportedOperationException();
    }
    
    public b e(final View view) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean expandActionView() {
        return false;
    }
    
    public b f(final int showAsAction) {
        this.setShowAsAction(showAsAction);
        return this;
    }
    
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public View getActionView() {
        return null;
    }
    
    @Override
    public int getAlphabeticModifiers() {
        return this.j;
    }
    
    public char getAlphabeticShortcut() {
        return this.i;
    }
    
    @Override
    public CharSequence getContentDescription() {
        return this.n;
    }
    
    public int getGroupId() {
        return this.b;
    }
    
    public Drawable getIcon() {
        return this.k;
    }
    
    @Override
    public ColorStateList getIconTintList() {
        return this.p;
    }
    
    @Override
    public PorterDuff$Mode getIconTintMode() {
        return this.q;
    }
    
    public Intent getIntent() {
        return this.f;
    }
    
    public int getItemId() {
        return this.a;
    }
    
    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return null;
    }
    
    @Override
    public int getNumericModifiers() {
        return this.h;
    }
    
    public char getNumericShortcut() {
        return this.g;
    }
    
    public int getOrder() {
        return this.c;
    }
    
    public SubMenu getSubMenu() {
        return null;
    }
    
    public CharSequence getTitle() {
        return this.d;
    }
    
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.e;
        if (charSequence == null) {
            charSequence = this.d;
        }
        return charSequence;
    }
    
    @Override
    public CharSequence getTooltipText() {
        return this.o;
    }
    
    public boolean hasSubMenu() {
        return false;
    }
    
    @Override
    public boolean isActionViewExpanded() {
        return false;
    }
    
    public boolean isCheckable() {
        final int t = this.t;
        boolean b = true;
        if ((t & 0x1) == 0x0) {
            b = false;
        }
        return b;
    }
    
    public boolean isChecked() {
        return (this.t & 0x2) != 0x0;
    }
    
    public boolean isEnabled() {
        return (this.t & 0x10) != 0x0;
    }
    
    public boolean isVisible() {
        return (this.t & 0x8) == 0x0;
    }
    
    public MenuItem setActionProvider(final ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public /* bridge */ MenuItem setActionView(final int n) {
        return (MenuItem)this.d(n);
    }
    
    @Override
    public /* bridge */ MenuItem setActionView(final View view) {
        return (MenuItem)this.e(view);
    }
    
    public MenuItem setAlphabeticShortcut(final char c) {
        this.i = Character.toLowerCase(c);
        return (MenuItem)this;
    }
    
    @Override
    public MenuItem setAlphabeticShortcut(final char c, final int n) {
        this.i = Character.toLowerCase(c);
        this.j = KeyEvent.normalizeMetaState(n);
        return (MenuItem)this;
    }
    
    public MenuItem setCheckable(final boolean b) {
        this.t = ((b ? 1 : 0) | (this.t & 0xFFFFFFFE));
        return (MenuItem)this;
    }
    
    public MenuItem setChecked(final boolean b) {
        final int t = this.t;
        int n;
        if (b) {
            n = 2;
        }
        else {
            n = 0;
        }
        this.t = (n | (t & 0xFFFFFFFD));
        return (MenuItem)this;
    }
    
    public /* bridge */ MenuItem setContentDescription(final CharSequence contentDescription) {
        return (MenuItem)this.setContentDescription(contentDescription);
    }
    
    @Override
    public b setContentDescription(final CharSequence n) {
        this.n = n;
        return this;
    }
    
    public MenuItem setEnabled(final boolean b) {
        final int t = this.t;
        int n;
        if (b) {
            n = 16;
        }
        else {
            n = 0;
        }
        this.t = (n | (t & 0xFFFFFFEF));
        return (MenuItem)this;
    }
    
    public MenuItem setIcon(final int n) {
        this.k = androidx.core.content.a.getDrawable(this.l, n);
        this.c();
        return (MenuItem)this;
    }
    
    public MenuItem setIcon(final Drawable k) {
        this.k = k;
        this.c();
        return (MenuItem)this;
    }
    
    @Override
    public MenuItem setIconTintList(final ColorStateList p) {
        this.p = p;
        this.r = true;
        this.c();
        return (MenuItem)this;
    }
    
    @Override
    public MenuItem setIconTintMode(final PorterDuff$Mode q) {
        this.q = q;
        this.s = true;
        this.c();
        return (MenuItem)this;
    }
    
    public MenuItem setIntent(final Intent f) {
        this.f = f;
        return (MenuItem)this;
    }
    
    public MenuItem setNumericShortcut(final char g) {
        this.g = g;
        return (MenuItem)this;
    }
    
    @Override
    public MenuItem setNumericShortcut(final char g, final int n) {
        this.g = g;
        this.h = KeyEvent.normalizeMetaState(n);
        return (MenuItem)this;
    }
    
    public MenuItem setOnActionExpandListener(final MenuItem$OnActionExpandListener menuItem$OnActionExpandListener) {
        throw new UnsupportedOperationException();
    }
    
    public MenuItem setOnMenuItemClickListener(final MenuItem$OnMenuItemClickListener m) {
        this.m = m;
        return (MenuItem)this;
    }
    
    public MenuItem setShortcut(final char g, final char c) {
        this.g = g;
        this.i = Character.toLowerCase(c);
        return (MenuItem)this;
    }
    
    @Override
    public MenuItem setShortcut(final char g, final char c, final int n, final int n2) {
        this.g = g;
        this.h = KeyEvent.normalizeMetaState(n);
        this.i = Character.toLowerCase(c);
        this.j = KeyEvent.normalizeMetaState(n2);
        return (MenuItem)this;
    }
    
    @Override
    public void setShowAsAction(final int n) {
    }
    
    @Override
    public /* bridge */ MenuItem setShowAsActionFlags(final int n) {
        return (MenuItem)this.f(n);
    }
    
    public MenuItem setTitle(final int n) {
        this.d = this.l.getResources().getString(n);
        return (MenuItem)this;
    }
    
    public MenuItem setTitle(final CharSequence d) {
        this.d = d;
        return (MenuItem)this;
    }
    
    public MenuItem setTitleCondensed(final CharSequence e) {
        this.e = e;
        return (MenuItem)this;
    }
    
    public /* bridge */ MenuItem setTooltipText(final CharSequence tooltipText) {
        return (MenuItem)this.setTooltipText(tooltipText);
    }
    
    @Override
    public b setTooltipText(final CharSequence o) {
        this.o = o;
        return this;
    }
    
    public MenuItem setVisible(final boolean b) {
        final int t = this.t;
        int n = 8;
        if (b) {
            n = 0;
        }
        this.t = ((t & 0x8) | n);
        return (MenuItem)this;
    }
}
