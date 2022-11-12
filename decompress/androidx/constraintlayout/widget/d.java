// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import android.content.res.TypedArray;
import android.content.Context;
import android.view.ViewGroup$LayoutParams;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class d extends ViewGroup
{
    c a;
    
    protected a a() {
        return new a(-2, -2);
    }
    
    public a b(final AttributeSet set) {
        return new a(this.getContext(), set);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.a();
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.b(set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)new ConstraintLayout.b(viewGroup$LayoutParams);
    }
    
    public c getConstraintSet() {
        if (this.a == null) {
            this.a = new c();
        }
        this.a.p(this);
        return this.a;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
    }
    
    public static class a extends b
    {
        public float A0;
        public float B0;
        public float C0;
        public float D0;
        public float E0;
        public float F0;
        public float G0;
        public float H0;
        public float I0;
        public float J0;
        public float x0;
        public boolean y0;
        public float z0;
        
        public a(final int n, final int n2) {
            super(n, n2);
            this.x0 = 1.0f;
            this.y0 = false;
            this.z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 1.0f;
            this.E0 = 1.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
            this.J0 = 0.0f;
        }
        
        public a(final Context context, final AttributeSet set) {
            super(context, set);
            this.x0 = 1.0f;
            int i = 0;
            this.y0 = false;
            this.z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 1.0f;
            this.E0 = 1.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
            this.J0 = 0.0f;
            TypedArray obtainStyledAttributes;
            for (obtainStyledAttributes = context.obtainStyledAttributes(set, h.l4); i < obtainStyledAttributes.getIndexCount(); ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                if (index == h.m4) {
                    this.x0 = obtainStyledAttributes.getFloat(index, this.x0);
                }
                else if (index == h.x4) {
                    this.z0 = obtainStyledAttributes.getFloat(index, this.z0);
                    this.y0 = true;
                }
                else if (index == h.u4) {
                    this.B0 = obtainStyledAttributes.getFloat(index, this.B0);
                }
                else if (index == h.v4) {
                    this.C0 = obtainStyledAttributes.getFloat(index, this.C0);
                }
                else if (index == h.t4) {
                    this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
                }
                else if (index == h.r4) {
                    this.D0 = obtainStyledAttributes.getFloat(index, this.D0);
                }
                else if (index == h.s4) {
                    this.E0 = obtainStyledAttributes.getFloat(index, this.E0);
                }
                else if (index == h.n4) {
                    this.F0 = obtainStyledAttributes.getFloat(index, this.F0);
                }
                else if (index == h.o4) {
                    this.G0 = obtainStyledAttributes.getFloat(index, this.G0);
                }
                else if (index == h.p4) {
                    this.H0 = obtainStyledAttributes.getFloat(index, this.H0);
                }
                else if (index == h.q4) {
                    this.I0 = obtainStyledAttributes.getFloat(index, this.I0);
                }
                else if (index == h.w4) {
                    this.J0 = obtainStyledAttributes.getFloat(index, this.J0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
