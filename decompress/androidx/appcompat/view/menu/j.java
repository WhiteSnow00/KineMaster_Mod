// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.widget.FrameLayout;
import android.view.ActionProvider$VisibilityListener;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem$OnActionExpandListener;
import android.view.CollapsibleActionView;
import android.util.Log;
import android.view.SubMenu;
import android.view.ContextMenu$ContextMenuInfo;
import android.content.Intent;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ActionProvider;
import android.content.Context;
import java.lang.reflect.Method;
import w.b;
import android.view.MenuItem;

public class j extends androidx.appcompat.view.menu.c implements MenuItem
{
    private final w.b d;
    private Method e;
    
    public j(final Context context, final w.b d) {
        super(context);
        if (d != null) {
            this.d = d;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }
    
    public boolean collapseActionView() {
        return this.d.collapseActionView();
    }
    
    public boolean expandActionView() {
        return this.d.expandActionView();
    }
    
    public ActionProvider getActionProvider() {
        final androidx.core.view.b a = this.d.a();
        if (a instanceof a) {
            return ((a)a).d;
        }
        return null;
    }
    
    public View getActionView() {
        View view2;
        final View view = view2 = this.d.getActionView();
        if (view instanceof c) {
            view2 = ((c)view).a();
        }
        return view2;
    }
    
    public int getAlphabeticModifiers() {
        return this.d.getAlphabeticModifiers();
    }
    
    public char getAlphabeticShortcut() {
        return ((MenuItem)this.d).getAlphabeticShortcut();
    }
    
    public CharSequence getContentDescription() {
        return this.d.getContentDescription();
    }
    
    public int getGroupId() {
        return ((MenuItem)this.d).getGroupId();
    }
    
    public Drawable getIcon() {
        return ((MenuItem)this.d).getIcon();
    }
    
    public ColorStateList getIconTintList() {
        return this.d.getIconTintList();
    }
    
    public PorterDuff$Mode getIconTintMode() {
        return this.d.getIconTintMode();
    }
    
    public Intent getIntent() {
        return ((MenuItem)this.d).getIntent();
    }
    
    public int getItemId() {
        return ((MenuItem)this.d).getItemId();
    }
    
    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return ((MenuItem)this.d).getMenuInfo();
    }
    
    public int getNumericModifiers() {
        return this.d.getNumericModifiers();
    }
    
    public char getNumericShortcut() {
        return ((MenuItem)this.d).getNumericShortcut();
    }
    
    public int getOrder() {
        return ((MenuItem)this.d).getOrder();
    }
    
    public SubMenu getSubMenu() {
        return this.d(((MenuItem)this.d).getSubMenu());
    }
    
    public CharSequence getTitle() {
        return ((MenuItem)this.d).getTitle();
    }
    
    public CharSequence getTitleCondensed() {
        return ((MenuItem)this.d).getTitleCondensed();
    }
    
    public CharSequence getTooltipText() {
        return this.d.getTooltipText();
    }
    
    public void h(final boolean b) {
        try {
            if (this.e == null) {
                this.e = this.d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.e.invoke(this.d, b);
        }
        catch (final Exception ex) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", (Throwable)ex);
        }
    }
    
    public boolean hasSubMenu() {
        return ((MenuItem)this.d).hasSubMenu();
    }
    
    public boolean isActionViewExpanded() {
        return this.d.isActionViewExpanded();
    }
    
    public boolean isCheckable() {
        return ((MenuItem)this.d).isCheckable();
    }
    
    public boolean isChecked() {
        return ((MenuItem)this.d).isChecked();
    }
    
    public boolean isEnabled() {
        return ((MenuItem)this.d).isEnabled();
    }
    
    public boolean isVisible() {
        return ((MenuItem)this.d).isVisible();
    }
    
    public MenuItem setActionProvider(final ActionProvider actionProvider) {
        final b b = new b(super.a, actionProvider);
        final w.b d = this.d;
        b b2;
        if (actionProvider != null) {
            b2 = b;
        }
        else {
            b2 = null;
        }
        d.b(b2);
        return (MenuItem)this;
    }
    
    public MenuItem setActionView(final int actionView) {
        this.d.setActionView(actionView);
        final View actionView2 = this.d.getActionView();
        if (actionView2 instanceof CollapsibleActionView) {
            this.d.setActionView((View)new c(actionView2));
        }
        return (MenuItem)this;
    }
    
    public MenuItem setActionView(final View view) {
        Object actionView = view;
        if (view instanceof CollapsibleActionView) {
            actionView = new c(view);
        }
        this.d.setActionView((View)actionView);
        return (MenuItem)this;
    }
    
    public MenuItem setAlphabeticShortcut(final char alphabeticShortcut) {
        ((MenuItem)this.d).setAlphabeticShortcut(alphabeticShortcut);
        return (MenuItem)this;
    }
    
    public MenuItem setAlphabeticShortcut(final char c, final int n) {
        this.d.setAlphabeticShortcut(c, n);
        return (MenuItem)this;
    }
    
    public MenuItem setCheckable(final boolean checkable) {
        ((MenuItem)this.d).setCheckable(checkable);
        return (MenuItem)this;
    }
    
    public MenuItem setChecked(final boolean checked) {
        ((MenuItem)this.d).setChecked(checked);
        return (MenuItem)this;
    }
    
    public MenuItem setContentDescription(final CharSequence contentDescription) {
        this.d.setContentDescription(contentDescription);
        return (MenuItem)this;
    }
    
    public MenuItem setEnabled(final boolean enabled) {
        ((MenuItem)this.d).setEnabled(enabled);
        return (MenuItem)this;
    }
    
    public MenuItem setIcon(final int icon) {
        ((MenuItem)this.d).setIcon(icon);
        return (MenuItem)this;
    }
    
    public MenuItem setIcon(final Drawable icon) {
        ((MenuItem)this.d).setIcon(icon);
        return (MenuItem)this;
    }
    
    public MenuItem setIconTintList(final ColorStateList iconTintList) {
        this.d.setIconTintList(iconTintList);
        return (MenuItem)this;
    }
    
    public MenuItem setIconTintMode(final PorterDuff$Mode iconTintMode) {
        this.d.setIconTintMode(iconTintMode);
        return (MenuItem)this;
    }
    
    public MenuItem setIntent(final Intent intent) {
        ((MenuItem)this.d).setIntent(intent);
        return (MenuItem)this;
    }
    
    public MenuItem setNumericShortcut(final char numericShortcut) {
        ((MenuItem)this.d).setNumericShortcut(numericShortcut);
        return (MenuItem)this;
    }
    
    public MenuItem setNumericShortcut(final char c, final int n) {
        this.d.setNumericShortcut(c, n);
        return (MenuItem)this;
    }
    
    public MenuItem setOnActionExpandListener(final MenuItem$OnActionExpandListener menuItem$OnActionExpandListener) {
        final w.b d = this.d;
        Object onActionExpandListener;
        if (menuItem$OnActionExpandListener != null) {
            onActionExpandListener = new d(menuItem$OnActionExpandListener);
        }
        else {
            onActionExpandListener = null;
        }
        ((MenuItem)d).setOnActionExpandListener((MenuItem$OnActionExpandListener)onActionExpandListener);
        return (MenuItem)this;
    }
    
    public MenuItem setOnMenuItemClickListener(final MenuItem$OnMenuItemClickListener menuItem$OnMenuItemClickListener) {
        final w.b d = this.d;
        Object onMenuItemClickListener;
        if (menuItem$OnMenuItemClickListener != null) {
            onMenuItemClickListener = new e(menuItem$OnMenuItemClickListener);
        }
        else {
            onMenuItemClickListener = null;
        }
        ((MenuItem)d).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)onMenuItemClickListener);
        return (MenuItem)this;
    }
    
    public MenuItem setShortcut(final char c, final char c2) {
        ((MenuItem)this.d).setShortcut(c, c2);
        return (MenuItem)this;
    }
    
    public MenuItem setShortcut(final char c, final char c2, final int n, final int n2) {
        this.d.setShortcut(c, c2, n, n2);
        return (MenuItem)this;
    }
    
    public void setShowAsAction(final int showAsAction) {
        this.d.setShowAsAction(showAsAction);
    }
    
    public MenuItem setShowAsActionFlags(final int showAsActionFlags) {
        this.d.setShowAsActionFlags(showAsActionFlags);
        return (MenuItem)this;
    }
    
    public MenuItem setTitle(final int title) {
        ((MenuItem)this.d).setTitle(title);
        return (MenuItem)this;
    }
    
    public MenuItem setTitle(final CharSequence title) {
        ((MenuItem)this.d).setTitle(title);
        return (MenuItem)this;
    }
    
    public MenuItem setTitleCondensed(final CharSequence titleCondensed) {
        ((MenuItem)this.d).setTitleCondensed(titleCondensed);
        return (MenuItem)this;
    }
    
    public MenuItem setTooltipText(final CharSequence tooltipText) {
        this.d.setTooltipText(tooltipText);
        return (MenuItem)this;
    }
    
    public MenuItem setVisible(final boolean visible) {
        return ((MenuItem)this.d).setVisible(visible);
    }
    
    private class a extends androidx.core.view.b
    {
        final ActionProvider d;
        final j e;
        
        a(final j e, final Context context, final ActionProvider d) {
            this.e = e;
            super(context);
            this.d = d;
        }
        
        @Override
        public boolean a() {
            return this.d.hasSubMenu();
        }
        
        @Override
        public View c() {
            return this.d.onCreateActionView();
        }
        
        @Override
        public boolean e() {
            return this.d.onPerformDefaultAction();
        }
        
        @Override
        public void f(final SubMenu subMenu) {
            this.d.onPrepareSubMenu(this.e.d(subMenu));
        }
    }
    
    private class b extends a implements ActionProvider$VisibilityListener
    {
        private androidx.core.view.b.b f;
        final j g;
        
        b(final j g, final Context context, final ActionProvider actionProvider) {
            this.g = g.super(context, actionProvider);
        }
        
        public boolean b() {
            return super.d.isVisible();
        }
        
        public View d(final MenuItem menuItem) {
            return super.d.onCreateActionView(menuItem);
        }
        
        public boolean g() {
            return super.d.overridesItemVisibility();
        }
        
        public void j(final androidx.core.view.b.b f) {
            this.f = f;
            final ActionProvider d = super.d;
            Object visibilityListener;
            if (f != null) {
                visibilityListener = this;
            }
            else {
                visibilityListener = null;
            }
            d.setVisibilityListener((ActionProvider$VisibilityListener)visibilityListener);
        }
        
        public void onActionProviderVisibilityChanged(final boolean b) {
            final androidx.core.view.b.b f = this.f;
            if (f != null) {
                f.onActionProviderVisibilityChanged(b);
            }
        }
    }
    
    static class c extends FrameLayout implements androidx.appcompat.view.c
    {
        final CollapsibleActionView a;
        
        c(final View view) {
            super(view.getContext());
            this.a = (CollapsibleActionView)view;
            this.addView(view);
        }
        
        View a() {
            return (View)this.a;
        }
        
        public void b() {
            this.a.onActionViewExpanded();
        }
        
        public void f() {
            this.a.onActionViewCollapsed();
        }
    }
    
    private class d implements MenuItem$OnActionExpandListener
    {
        private final MenuItem$OnActionExpandListener a;
        final j b;
        
        d(final j b, final MenuItem$OnActionExpandListener a) {
            this.b = b;
            this.a = a;
        }
        
        public boolean onMenuItemActionCollapse(final MenuItem menuItem) {
            return this.a.onMenuItemActionCollapse(this.b.c(menuItem));
        }
        
        public boolean onMenuItemActionExpand(final MenuItem menuItem) {
            return this.a.onMenuItemActionExpand(this.b.c(menuItem));
        }
    }
    
    private class e implements MenuItem$OnMenuItemClickListener
    {
        private final MenuItem$OnMenuItemClickListener a;
        final j b;
        
        e(final j b, final MenuItem$OnMenuItemClickListener a) {
            this.b = b;
            this.a = a;
        }
        
        public boolean onMenuItemClick(final MenuItem menuItem) {
            return this.a.onMenuItemClick(this.b.c(menuItem));
        }
    }
}
