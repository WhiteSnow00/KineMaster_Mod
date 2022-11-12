// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

public final class d
{
    public static Drawable a(final CompoundButton compoundButton) {
        return b.a(compoundButton);
    }
    
    public static ColorStateList b(final CompoundButton compoundButton) {
        return a.a(compoundButton);
    }
    
    public static void c(final CompoundButton compoundButton, final ColorStateList list) {
        a.c(compoundButton, list);
    }
    
    public static void d(final CompoundButton compoundButton, final PorterDuff$Mode porterDuff$Mode) {
        a.d(compoundButton, porterDuff$Mode);
    }
    
    static class a
    {
        static ColorStateList a(final CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }
        
        static PorterDuff$Mode b(final CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }
        
        static void c(final CompoundButton compoundButton, final ColorStateList buttonTintList) {
            compoundButton.setButtonTintList(buttonTintList);
        }
        
        static void d(final CompoundButton compoundButton, final PorterDuff$Mode buttonTintMode) {
            compoundButton.setButtonTintMode(buttonTintMode);
        }
    }
    
    static class b
    {
        static Drawable a(final CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }
}
