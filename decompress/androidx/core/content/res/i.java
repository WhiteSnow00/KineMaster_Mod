// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content.res;

import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.content.Context;

public class i
{
    public static int a(final Context context, final int n, final int n2) {
        final TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(n, typedValue, true);
        if (typedValue.resourceId != 0) {
            return n;
        }
        return n2;
    }
    
    public static boolean b(final TypedArray typedArray, final int n, final int n2, final boolean b) {
        return typedArray.getBoolean(n, typedArray.getBoolean(n2, b));
    }
    
    public static Drawable c(final TypedArray typedArray, final int n, final int n2) {
        Drawable drawable;
        if ((drawable = typedArray.getDrawable(n)) == null) {
            drawable = typedArray.getDrawable(n2);
        }
        return drawable;
    }
    
    public static int d(final TypedArray typedArray, final int n, final int n2, final int n3) {
        return typedArray.getInt(n, typedArray.getInt(n2, n3));
    }
    
    public static int e(final TypedArray typedArray, final int n, final int n2, final int n3) {
        return typedArray.getResourceId(n, typedArray.getResourceId(n2, n3));
    }
    
    public static String f(final TypedArray typedArray, final int n, final int n2) {
        String s;
        if ((s = typedArray.getString(n)) == null) {
            s = typedArray.getString(n2);
        }
        return s;
    }
    
    public static CharSequence g(final TypedArray typedArray, final int n, final int n2) {
        CharSequence charSequence;
        if ((charSequence = typedArray.getText(n)) == null) {
            charSequence = typedArray.getText(n2);
        }
        return charSequence;
    }
    
    public static CharSequence[] h(final TypedArray typedArray, final int n, final int n2) {
        CharSequence[] array;
        if ((array = typedArray.getTextArray(n)) == null) {
            array = typedArray.getTextArray(n2);
        }
        return array;
    }
}
