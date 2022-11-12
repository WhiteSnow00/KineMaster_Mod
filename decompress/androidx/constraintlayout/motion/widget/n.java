// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.res.TypedArray;
import androidx.constraintlayout.widget.h;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.widget.a;

public class n extends a implements i
{
    private boolean a;
    private boolean b;
    private float c;
    protected View[] d;
    
    @Override
    public void a(final MotionLayout motionLayout, final int n, final int n2, final float n3) {
    }
    
    @Override
    public void b(final MotionLayout motionLayout, final int n) {
    }
    
    @Override
    public void c(final MotionLayout motionLayout, final int n, final int n2) {
    }
    
    @Override
    public void d(final MotionLayout motionLayout, final int n, final boolean b, final float n2) {
    }
    
    public boolean e() {
        return false;
    }
    
    public boolean f() {
        return this.b;
    }
    
    public boolean g() {
        return this.a;
    }
    
    public float getProgress() {
        return this.c;
    }
    
    public void h(final MotionLayout motionLayout) {
    }
    
    public void i(final Canvas canvas) {
    }
    
    @Override
    protected void init(final AttributeSet set) {
        super.init(set);
        if (set != null) {
            final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, androidx.constraintlayout.widget.h.g8);
            for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                if (index == androidx.constraintlayout.widget.h.i8) {
                    this.a = obtainStyledAttributes.getBoolean(index, this.a);
                }
                else if (index == androidx.constraintlayout.widget.h.h8) {
                    this.b = obtainStyledAttributes.getBoolean(index, this.b);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
    
    public void j(final Canvas canvas) {
    }
    
    public void k(final View view, final float n) {
    }
    
    public void setProgress(final float c) {
        this.c = c;
        final int mCount = super.mCount;
        int i = 0;
        final int n = 0;
        if (mCount > 0) {
            this.d = this.getViews((ConstraintLayout)this.getParent());
            for (int j = n; j < super.mCount; ++j) {
                this.k(this.d[j], c);
            }
        }
        else {
            for (ViewGroup viewGroup = (ViewGroup)this.getParent(); i < viewGroup.getChildCount(); ++i) {
                final View child = viewGroup.getChildAt(i);
                if (!(child instanceof n)) {
                    this.k(child, c);
                }
            }
        }
    }
}
