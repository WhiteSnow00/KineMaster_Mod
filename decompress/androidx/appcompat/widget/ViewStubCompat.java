// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewParent;
import android.view.ViewGroup;
import android.content.res.TypedArray;
import d.j;
import android.util.AttributeSet;
import android.content.Context;
import android.view.LayoutInflater;
import java.lang.ref.WeakReference;
import android.view.View;

public final class ViewStubCompat extends View
{
    private int a;
    private int b;
    private WeakReference<View> c;
    private LayoutInflater d;
    private a e;
    
    public ViewStubCompat(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ViewStubCompat(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.a = 0;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, j.O3, n, 0);
        this.b = obtainStyledAttributes.getResourceId(j.R3, -1);
        this.a = obtainStyledAttributes.getResourceId(j.Q3, 0);
        this.setId(obtainStyledAttributes.getResourceId(j.P3, -1));
        obtainStyledAttributes.recycle();
        this.setVisibility(8);
        this.setWillNotDraw(true);
    }
    
    public View a() {
        final ViewParent parent = this.getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.a != 0) {
            final ViewGroup viewGroup = (ViewGroup)parent;
            LayoutInflater layoutInflater = this.d;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(this.getContext());
            }
            final View inflate = layoutInflater.inflate(this.a, viewGroup, false);
            final int b = this.b;
            if (b != -1) {
                inflate.setId(b);
            }
            final int indexOfChild = viewGroup.indexOfChild((View)this);
            viewGroup.removeViewInLayout((View)this);
            final ViewGroup$LayoutParams layoutParams = this.getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            }
            else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.c = new WeakReference<View>(inflate);
            final a e = this.e;
            if (e != null) {
                e.a(this, inflate);
            }
            return inflate;
        }
        throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    }
    
    protected void dispatchDraw(final Canvas canvas) {
    }
    
    public void draw(final Canvas canvas) {
    }
    
    public int getInflatedId() {
        return this.b;
    }
    
    public LayoutInflater getLayoutInflater() {
        return this.d;
    }
    
    public int getLayoutResource() {
        return this.a;
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.setMeasuredDimension(0, 0);
    }
    
    public void setInflatedId(final int b) {
        this.b = b;
    }
    
    public void setLayoutInflater(final LayoutInflater d) {
        this.d = d;
    }
    
    public void setLayoutResource(final int a) {
        this.a = a;
    }
    
    public void setOnInflateListener(final a e) {
        this.e = e;
    }
    
    public void setVisibility(final int n) {
        final WeakReference<View> c = this.c;
        if (c != null) {
            final View view = c.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(n);
        }
        else {
            super.setVisibility(n);
            if (n == 0 || n == 4) {
                this.a();
            }
        }
    }
    
    public interface a
    {
        void a(final ViewStubCompat p0, final View p1);
    }
}
