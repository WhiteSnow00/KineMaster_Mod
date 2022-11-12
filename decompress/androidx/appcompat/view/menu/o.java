// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.KeyEvent;
import android.view.SubMenu;
import android.content.Intent;
import android.content.ComponentName;
import android.view.MenuItem;
import android.content.Context;
import w.a;
import android.view.Menu;

public class o extends c implements Menu
{
    private final a d;
    
    public o(final Context context, final a d) {
        super(context);
        if (d != null) {
            this.d = d;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }
    
    public MenuItem add(final int n) {
        return this.c(((Menu)this.d).add(n));
    }
    
    public MenuItem add(final int n, final int n2, final int n3, final int n4) {
        return this.c(((Menu)this.d).add(n, n2, n3, n4));
    }
    
    public MenuItem add(final int n, final int n2, final int n3, final CharSequence charSequence) {
        return this.c(((Menu)this.d).add(n, n2, n3, charSequence));
    }
    
    public MenuItem add(final CharSequence charSequence) {
        return this.c(((Menu)this.d).add(charSequence));
    }
    
    public int addIntentOptions(int i, int length, int addIntentOptions, final ComponentName componentName, final Intent[] array, final Intent intent, final int n, final MenuItem[] array2) {
        MenuItem[] array3;
        if (array2 != null) {
            array3 = new MenuItem[array2.length];
        }
        else {
            array3 = null;
        }
        addIntentOptions = ((Menu)this.d).addIntentOptions(i, length, addIntentOptions, componentName, array, intent, n, array3);
        if (array3 != null) {
            for (i = 0, length = array3.length; i < length; ++i) {
                array2[i] = this.c(array3[i]);
            }
        }
        return addIntentOptions;
    }
    
    public SubMenu addSubMenu(final int n) {
        return this.d(((Menu)this.d).addSubMenu(n));
    }
    
    public SubMenu addSubMenu(final int n, final int n2, final int n3, final int n4) {
        return this.d(((Menu)this.d).addSubMenu(n, n2, n3, n4));
    }
    
    public SubMenu addSubMenu(final int n, final int n2, final int n3, final CharSequence charSequence) {
        return this.d(((Menu)this.d).addSubMenu(n, n2, n3, charSequence));
    }
    
    public SubMenu addSubMenu(final CharSequence charSequence) {
        return this.d(((Menu)this.d).addSubMenu(charSequence));
    }
    
    public void clear() {
        this.e();
        ((Menu)this.d).clear();
    }
    
    public void close() {
        ((Menu)this.d).close();
    }
    
    public MenuItem findItem(final int n) {
        return this.c(((Menu)this.d).findItem(n));
    }
    
    public MenuItem getItem(final int n) {
        return this.c(((Menu)this.d).getItem(n));
    }
    
    public boolean hasVisibleItems() {
        return ((Menu)this.d).hasVisibleItems();
    }
    
    public boolean isShortcutKey(final int n, final KeyEvent keyEvent) {
        return ((Menu)this.d).isShortcutKey(n, keyEvent);
    }
    
    public boolean performIdentifierAction(final int n, final int n2) {
        return ((Menu)this.d).performIdentifierAction(n, n2);
    }
    
    public boolean performShortcut(final int n, final KeyEvent keyEvent, final int n2) {
        return ((Menu)this.d).performShortcut(n, keyEvent, n2);
    }
    
    public void removeGroup(final int n) {
        this.f(n);
        ((Menu)this.d).removeGroup(n);
    }
    
    public void removeItem(final int n) {
        this.g(n);
        ((Menu)this.d).removeItem(n);
    }
    
    public void setGroupCheckable(final int n, final boolean b, final boolean b2) {
        ((Menu)this.d).setGroupCheckable(n, b, b2);
    }
    
    public void setGroupEnabled(final int n, final boolean b) {
        ((Menu)this.d).setGroupEnabled(n, b);
    }
    
    public void setGroupVisible(final int n, final boolean b) {
        ((Menu)this.d).setGroupVisible(n, b);
    }
    
    public void setQwertyMode(final boolean qwertyMode) {
        ((Menu)this.d).setQwertyMode(qwertyMode);
    }
    
    public int size() {
        return ((Menu)this.d).size();
    }
}
