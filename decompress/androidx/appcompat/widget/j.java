// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.text.InputFilter;
import e0.f;
import android.widget.TextView;

class j
{
    private final TextView a;
    private final f b;
    
    j(final TextView a) {
        this.a = a;
        this.b = new f(a, false);
    }
    
    InputFilter[] a(final InputFilter[] array) {
        return this.b.a(array);
    }
    
    public boolean b() {
        return this.b.b();
    }
    
    void c(AttributeSet obtainStyledAttributes, int u0) {
        obtainStyledAttributes = (AttributeSet)this.a.getContext().obtainStyledAttributes(obtainStyledAttributes, d.j.g0, u0, 0);
        try {
            u0 = d.j.u0;
            final boolean hasValue = ((TypedArray)obtainStyledAttributes).hasValue(u0);
            boolean boolean1 = true;
            if (hasValue) {
                boolean1 = ((TypedArray)obtainStyledAttributes).getBoolean(u0, true);
            }
            ((TypedArray)obtainStyledAttributes).recycle();
            this.e(boolean1);
        }
        finally {
            ((TypedArray)obtainStyledAttributes).recycle();
        }
    }
    
    void d(final boolean b) {
        this.b.c(b);
    }
    
    void e(final boolean b) {
        this.b.d(b);
    }
    
    public TransformationMethod f(final TransformationMethod transformationMethod) {
        return this.b.e(transformationMethod);
    }
}
