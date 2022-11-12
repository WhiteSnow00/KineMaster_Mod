// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import androidx.constraintlayout.core.widgets.d;
import android.util.SparseArray;
import r.b;
import android.content.res.TypedArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import android.util.AttributeSet;
import android.content.Context;

public class Barrier extends a
{
    private int a;
    private int b;
    private androidx.constraintlayout.core.widgets.a c;
    
    public Barrier(final Context context) {
        super(context);
        super.setVisibility(8);
    }
    
    public Barrier(final Context context, final AttributeSet set) {
        super(context, set);
        super.setVisibility(8);
    }
    
    private void e(final ConstraintWidget constraintWidget, int b, final boolean b2) {
        this.b = b;
        if (b2) {
            b = this.a;
            if (b == 5) {
                this.b = 1;
            }
            else if (b == 6) {
                this.b = 0;
            }
        }
        else {
            b = this.a;
            if (b == 5) {
                this.b = 0;
            }
            else if (b == 6) {
                this.b = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            ((androidx.constraintlayout.core.widgets.a)constraintWidget).x1(this.b);
        }
    }
    
    public boolean getAllowsGoneWidget() {
        return this.c.r1();
    }
    
    public int getMargin() {
        return this.c.t1();
    }
    
    public int getType() {
        return this.a;
    }
    
    @Override
    protected void init(final AttributeSet set) {
        super.init(set);
        this.c = new androidx.constraintlayout.core.widgets.a();
        if (set != null) {
            final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, h.n1);
            for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
                final int index = obtainStyledAttributes.getIndex(i);
                if (index == h.w1) {
                    this.setType(obtainStyledAttributes.getInt(index, 0));
                }
                else if (index == h.v1) {
                    this.c.w1(obtainStyledAttributes.getBoolean(index, true));
                }
                else if (index == h.x1) {
                    this.c.y1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        super.mHelperWidget = this.c;
        this.validateParams();
    }
    
    @Override
    public void loadParameters(final c.a a, final b b, final ConstraintLayout.b b2, final SparseArray<ConstraintWidget> sparseArray) {
        super.loadParameters(a, b, b2, sparseArray);
        if (b instanceof androidx.constraintlayout.core.widgets.a) {
            final androidx.constraintlayout.core.widgets.a a2 = (androidx.constraintlayout.core.widgets.a)b;
            this.e(a2, a.e.h0, ((d)b.I()).M1());
            a2.w1(a.e.p0);
            a2.y1(a.e.i0);
        }
    }
    
    @Override
    public void resolveRtl(final ConstraintWidget constraintWidget, final boolean b) {
        this.e(constraintWidget, this.a, b);
    }
    
    public void setAllowsGoneWidget(final boolean b) {
        this.c.w1(b);
    }
    
    public void setDpMargin(int n) {
        n = (int)(n * this.getResources().getDisplayMetrics().density + 0.5f);
        this.c.y1(n);
    }
    
    public void setMargin(final int n) {
        this.c.y1(n);
    }
    
    public void setType(final int a) {
        this.a = a;
    }
}
