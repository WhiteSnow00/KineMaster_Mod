// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics.drawable;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.content.res.Resources$Theme;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.DrawableContainer$DrawableContainerState;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

public final class a
{
    public static void a(final Drawable drawable) {
        drawable.clearColorFilter();
    }
    
    public static int b(final Drawable drawable) {
        return c.a(drawable);
    }
    
    public static boolean c(final Drawable drawable) {
        return a.d(drawable);
    }
    
    public static void d(final Drawable drawable, final boolean b) {
        a.e(drawable, b);
    }
    
    public static void e(final Drawable drawable, final float n, final float n2) {
        b.e(drawable, n, n2);
    }
    
    public static void f(final Drawable drawable, final int n, final int n2, final int n3, final int n4) {
        b.f(drawable, n, n2, n3, n4);
    }
    
    public static boolean g(final Drawable drawable, final int n) {
        return c.b(drawable, n);
    }
    
    public static void h(final Drawable drawable, final int n) {
        b.g(drawable, n);
    }
    
    public static void i(final Drawable drawable, final ColorStateList list) {
        b.h(drawable, list);
    }
    
    public static void j(final Drawable drawable, final PorterDuff$Mode porterDuff$Mode) {
        b.i(drawable, porterDuff$Mode);
    }
    
    public static <T extends Drawable> T k(final Drawable drawable) {
        Drawable a = drawable;
        if (drawable instanceof f) {
            a = ((f)drawable).a();
        }
        return (T)a;
    }
    
    public static Drawable l(final Drawable drawable) {
        return drawable;
    }
    
    static class a
    {
        static int a(final Drawable drawable) {
            return drawable.getAlpha();
        }
        
        static Drawable b(final DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState, final int n) {
            return drawableContainer$DrawableContainerState.getChild(n);
        }
        
        static Drawable c(final InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }
        
        static boolean d(final Drawable drawable) {
            return drawable.isAutoMirrored();
        }
        
        static void e(final Drawable drawable, final boolean autoMirrored) {
            drawable.setAutoMirrored(autoMirrored);
        }
    }
    
    static class b
    {
        static void a(final Drawable drawable, final Resources$Theme resources$Theme) {
            drawable.applyTheme(resources$Theme);
        }
        
        static boolean b(final Drawable drawable) {
            return drawable.canApplyTheme();
        }
        
        static ColorFilter c(final Drawable drawable) {
            return drawable.getColorFilter();
        }
        
        static void d(final Drawable drawable, final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, set, resources$Theme);
        }
        
        static void e(final Drawable drawable, final float n, final float n2) {
            drawable.setHotspot(n, n2);
        }
        
        static void f(final Drawable drawable, final int n, final int n2, final int n3, final int n4) {
            drawable.setHotspotBounds(n, n2, n3, n4);
        }
        
        static void g(final Drawable drawable, final int tint) {
            drawable.setTint(tint);
        }
        
        static void h(final Drawable drawable, final ColorStateList tintList) {
            drawable.setTintList(tintList);
        }
        
        static void i(final Drawable drawable, final PorterDuff$Mode tintMode) {
            drawable.setTintMode(tintMode);
        }
    }
    
    static class c
    {
        static int a(final Drawable drawable) {
            return drawable.getLayoutDirection();
        }
        
        static boolean b(final Drawable drawable, final int layoutDirection) {
            return drawable.setLayoutDirection(layoutDirection);
        }
    }
}
