// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.content.res.TypedArray;
import androidx.core.graphics.d;
import android.graphics.Color;
import android.util.AttributeSet;
import android.content.res.ColorStateList;
import android.util.Log;
import d.j;
import android.content.Context;
import android.view.View;
import android.util.TypedValue;

public class m0
{
    private static final ThreadLocal<TypedValue> a;
    static final int[] b;
    static final int[] c;
    static final int[] d;
    static final int[] e;
    static final int[] f;
    static final int[] g;
    static final int[] h;
    static final int[] i;
    private static final int[] j;
    
    static {
        a = new ThreadLocal<TypedValue>();
        b = new int[] { -16842910 };
        c = new int[] { 16842908 };
        d = new int[] { 16843518 };
        e = new int[] { 16842919 };
        f = new int[] { 16842912 };
        g = new int[] { 16842913 };
        h = new int[] { -16842919, -16842908 };
        i = new int[0];
        j = new int[1];
    }
    
    public static void a(final View view, Context obtainStyledAttributes) {
        obtainStyledAttributes = (Context)obtainStyledAttributes.obtainStyledAttributes(d.j.y0);
        try {
            if (!((TypedArray)obtainStyledAttributes).hasValue(d.j.D0)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("View ");
                sb.append(view.getClass());
                sb.append(" is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
                Log.e("ThemeUtils", sb.toString());
            }
        }
        finally {
            ((TypedArray)obtainStyledAttributes).recycle();
        }
    }
    
    public static int b(final Context context, final int n) {
        final ColorStateList e = e(context, n);
        if (e != null && e.isStateful()) {
            return e.getColorForState(m0.b, e.getDefaultColor());
        }
        final TypedValue f = f();
        context.getTheme().resolveAttribute(16842803, f, true);
        return d(context, n, f.getFloat());
    }
    
    public static int c(final Context context, int b) {
        final int[] j = m0.j;
        j[0] = b;
        final r0 u = r0.u(context, null, j);
        try {
            b = u.b(0, 0);
            return b;
        }
        finally {
            u.w();
        }
    }
    
    static int d(final Context context, int c, final float n) {
        c = c(context, c);
        return androidx.core.graphics.d.j(c, Math.round(Color.alpha(c) * n));
    }
    
    public static ColorStateList e(Context u, final int n) {
        final int[] j = m0.j;
        j[0] = n;
        u = (Context)r0.u(u, null, j);
        try {
            return ((r0)u).c(0);
        }
        finally {
            ((r0)u).w();
        }
    }
    
    private static TypedValue f() {
        final ThreadLocal<TypedValue> a = m0.a;
        TypedValue typedValue;
        if ((typedValue = a.get()) == null) {
            typedValue = new TypedValue();
            a.set(typedValue);
        }
        return typedValue;
    }
}
