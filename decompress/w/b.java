// 
// Decompiled by Procyon v0.6.0
// 

package w;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.MenuItem;

public interface b extends MenuItem
{
    androidx.core.view.b a();
    
    b b(final androidx.core.view.b p0);
    
    boolean collapseActionView();
    
    boolean expandActionView();
    
    View getActionView();
    
    int getAlphabeticModifiers();
    
    CharSequence getContentDescription();
    
    ColorStateList getIconTintList();
    
    PorterDuff$Mode getIconTintMode();
    
    int getNumericModifiers();
    
    CharSequence getTooltipText();
    
    boolean isActionViewExpanded();
    
    MenuItem setActionView(final int p0);
    
    MenuItem setActionView(final View p0);
    
    MenuItem setAlphabeticShortcut(final char p0, final int p1);
    
    b setContentDescription(final CharSequence p0);
    
    MenuItem setIconTintList(final ColorStateList p0);
    
    MenuItem setIconTintMode(final PorterDuff$Mode p0);
    
    MenuItem setNumericShortcut(final char p0, final int p1);
    
    MenuItem setShortcut(final char p0, final char p1, final int p2, final int p3);
    
    void setShowAsAction(final int p0);
    
    MenuItem setShowAsActionFlags(final int p0);
    
    b setTooltipText(final CharSequence p0);
}
