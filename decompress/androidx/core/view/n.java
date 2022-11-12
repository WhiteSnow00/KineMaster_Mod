// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.MenuItem;

public final class n
{
    public static MenuItem a(final MenuItem menuItem, final b b) {
        if (menuItem instanceof w.b) {
            return (MenuItem)((w.b)menuItem).b(b);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }
    
    public static void b(final MenuItem menuItem, final char c, final int n) {
        if (menuItem instanceof w.b) {
            ((w.b)menuItem).setAlphabeticShortcut(c, n);
        }
        else {
            a.g(menuItem, c, n);
        }
    }
    
    public static void c(final MenuItem menuItem, final CharSequence contentDescription) {
        if (menuItem instanceof w.b) {
            ((w.b)menuItem).setContentDescription(contentDescription);
        }
        else {
            a.h(menuItem, contentDescription);
        }
    }
    
    public static void d(final MenuItem menuItem, final ColorStateList iconTintList) {
        if (menuItem instanceof w.b) {
            ((w.b)menuItem).setIconTintList(iconTintList);
        }
        else {
            a.i(menuItem, iconTintList);
        }
    }
    
    public static void e(final MenuItem menuItem, final PorterDuff$Mode iconTintMode) {
        if (menuItem instanceof w.b) {
            ((w.b)menuItem).setIconTintMode(iconTintMode);
        }
        else {
            a.j(menuItem, iconTintMode);
        }
    }
    
    public static void f(final MenuItem menuItem, final char c, final int n) {
        if (menuItem instanceof w.b) {
            ((w.b)menuItem).setNumericShortcut(c, n);
        }
        else {
            a.k(menuItem, c, n);
        }
    }
    
    public static void g(final MenuItem menuItem, final CharSequence tooltipText) {
        if (menuItem instanceof w.b) {
            ((w.b)menuItem).setTooltipText(tooltipText);
        }
        else {
            a.m(menuItem, tooltipText);
        }
    }
    
    static class a
    {
        static int a(final MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }
        
        static CharSequence b(final MenuItem menuItem) {
            return menuItem.getContentDescription();
        }
        
        static ColorStateList c(final MenuItem menuItem) {
            return menuItem.getIconTintList();
        }
        
        static PorterDuff$Mode d(final MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }
        
        static int e(final MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }
        
        static CharSequence f(final MenuItem menuItem) {
            return menuItem.getTooltipText();
        }
        
        static MenuItem g(final MenuItem menuItem, final char c, final int n) {
            return menuItem.setAlphabeticShortcut(c, n);
        }
        
        static MenuItem h(final MenuItem menuItem, final CharSequence contentDescription) {
            return menuItem.setContentDescription(contentDescription);
        }
        
        static MenuItem i(final MenuItem menuItem, final ColorStateList iconTintList) {
            return menuItem.setIconTintList(iconTintList);
        }
        
        static MenuItem j(final MenuItem menuItem, final PorterDuff$Mode iconTintMode) {
            return menuItem.setIconTintMode(iconTintMode);
        }
        
        static MenuItem k(final MenuItem menuItem, final char c, final int n) {
            return menuItem.setNumericShortcut(c, n);
        }
        
        static MenuItem l(final MenuItem menuItem, final char c, final char c2, final int n, final int n2) {
            return menuItem.setShortcut(c, c2, n, n2);
        }
        
        static MenuItem m(final MenuItem menuItem, final CharSequence tooltipText) {
            return menuItem.setTooltipText(tooltipText);
        }
    }
}
