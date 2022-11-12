// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.ImageView;

public class j
{
    public static ColorStateList a(final ImageView imageView) {
        return a.a(imageView);
    }
    
    public static PorterDuff$Mode b(final ImageView imageView) {
        return a.b(imageView);
    }
    
    public static void c(final ImageView imageView, final ColorStateList list) {
        a.c(imageView, list);
    }
    
    public static void d(final ImageView imageView, final PorterDuff$Mode porterDuff$Mode) {
        a.d(imageView, porterDuff$Mode);
    }
    
    static class a
    {
        static ColorStateList a(final ImageView imageView) {
            return imageView.getImageTintList();
        }
        
        static PorterDuff$Mode b(final ImageView imageView) {
            return imageView.getImageTintMode();
        }
        
        static void c(final ImageView imageView, final ColorStateList imageTintList) {
            imageView.setImageTintList(imageTintList);
        }
        
        static void d(final ImageView imageView, final PorterDuff$Mode imageTintMode) {
            imageView.setImageTintMode(imageTintMode);
        }
    }
}
