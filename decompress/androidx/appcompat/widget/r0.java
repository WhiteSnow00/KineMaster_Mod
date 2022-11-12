// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.Typeface;
import androidx.core.content.res.f;
import android.graphics.drawable.Drawable;
import e.a;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.content.res.TypedArray;
import android.content.Context;

public class r0
{
    private final Context a;
    private final TypedArray b;
    private TypedValue c;
    
    private r0(final Context a, final TypedArray b) {
        this.a = a;
        this.b = b;
    }
    
    public static r0 t(final Context context, final int n, final int[] array) {
        return new r0(context, context.obtainStyledAttributes(n, array));
    }
    
    public static r0 u(final Context context, final AttributeSet set, final int[] array) {
        return new r0(context, context.obtainStyledAttributes(set, array));
    }
    
    public static r0 v(final Context context, final AttributeSet set, final int[] array, final int n, final int n2) {
        return new r0(context, context.obtainStyledAttributes(set, array, n, n2));
    }
    
    public boolean a(final int n, final boolean b) {
        return this.b.getBoolean(n, b);
    }
    
    public int b(final int n, final int n2) {
        return this.b.getColor(n, n2);
    }
    
    public ColorStateList c(final int n) {
        if (this.b.hasValue(n)) {
            final int resourceId = this.b.getResourceId(n, 0);
            if (resourceId != 0) {
                final ColorStateList a = e.a.a(this.a, resourceId);
                if (a != null) {
                    return a;
                }
            }
        }
        return this.b.getColorStateList(n);
    }
    
    public float d(final int n, final float n2) {
        return this.b.getDimension(n, n2);
    }
    
    public int e(final int n, final int n2) {
        return this.b.getDimensionPixelOffset(n, n2);
    }
    
    public int f(final int n, final int n2) {
        return this.b.getDimensionPixelSize(n, n2);
    }
    
    public Drawable g(final int n) {
        if (this.b.hasValue(n)) {
            final int resourceId = this.b.getResourceId(n, 0);
            if (resourceId != 0) {
                return e.a.b(this.a, resourceId);
            }
        }
        return this.b.getDrawable(n);
    }
    
    public Drawable h(int resourceId) {
        if (this.b.hasValue(resourceId)) {
            resourceId = this.b.getResourceId(resourceId, 0);
            if (resourceId != 0) {
                return h.b().d(this.a, resourceId, true);
            }
        }
        return null;
    }
    
    public float i(final int n, final float n2) {
        return this.b.getFloat(n, n2);
    }
    
    public Typeface j(int resourceId, final int n, final f.e e) {
        resourceId = this.b.getResourceId(resourceId, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return f.i(this.a, resourceId, this.c, n, e);
    }
    
    public int k(final int n, final int n2) {
        return this.b.getInt(n, n2);
    }
    
    public int l(final int n, final int n2) {
        return this.b.getInteger(n, n2);
    }
    
    public int m(final int n, final int n2) {
        return this.b.getLayoutDimension(n, n2);
    }
    
    public int n(final int n, final int n2) {
        return this.b.getResourceId(n, n2);
    }
    
    public String o(final int n) {
        return this.b.getString(n);
    }
    
    public CharSequence p(final int n) {
        return this.b.getText(n);
    }
    
    public CharSequence[] q(final int n) {
        return this.b.getTextArray(n);
    }
    
    public TypedArray r() {
        return this.b;
    }
    
    public boolean s(final int n) {
        return this.b.hasValue(n);
    }
    
    public void w() {
        this.b.recycle();
    }
}
