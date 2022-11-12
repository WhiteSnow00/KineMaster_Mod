// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

public final class c
{
    public static Drawable a(final CheckedTextView checkedTextView) {
        return a.a(checkedTextView);
    }
    
    public static void b(final CheckedTextView checkedTextView, final ColorStateList list) {
        b.a(checkedTextView, list);
    }
    
    public static void c(final CheckedTextView checkedTextView, final PorterDuff$Mode porterDuff$Mode) {
        b.b(checkedTextView, porterDuff$Mode);
    }
    
    private static class a
    {
        static Drawable a(final CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }
    
    private static class b
    {
        static void a(final CheckedTextView checkedTextView, final ColorStateList checkMarkTintList) {
            checkedTextView.setCheckMarkTintList(checkMarkTintList);
        }
        
        static void b(final CheckedTextView checkedTextView, final PorterDuff$Mode checkMarkTintMode) {
            checkedTextView.setCheckMarkTintMode(checkMarkTintMode);
        }
    }
}
