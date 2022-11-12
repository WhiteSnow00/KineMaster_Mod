// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.View;
import android.graphics.Rect;

public abstract class s
{
    protected final RecyclerView.o a;
    private int b;
    final Rect c;
    
    private s(final RecyclerView.o a) {
        this.b = Integer.MIN_VALUE;
        this.c = new Rect();
        this.a = a;
    }
    
    s(final RecyclerView.o o, final s$a s) {
        this(o);
    }
    
    public static s a(final RecyclerView.o o) {
        return new s(o) {
            @Override
            public int d(final View view) {
                return super.a.getDecoratedRight(view) + ((RecyclerView.p)view.getLayoutParams()).rightMargin;
            }
            
            @Override
            public int e(final View view) {
                final RecyclerView.p p = (RecyclerView.p)view.getLayoutParams();
                return super.a.getDecoratedMeasuredWidth(view) + p.leftMargin + p.rightMargin;
            }
            
            @Override
            public int f(final View view) {
                final RecyclerView.p p = (RecyclerView.p)view.getLayoutParams();
                return super.a.getDecoratedMeasuredHeight(view) + p.topMargin + p.bottomMargin;
            }
            
            @Override
            public int g(final View view) {
                return super.a.getDecoratedLeft(view) - ((RecyclerView.p)view.getLayoutParams()).leftMargin;
            }
            
            @Override
            public int h() {
                return super.a.getWidth();
            }
            
            @Override
            public int i() {
                return super.a.getWidth() - super.a.getPaddingRight();
            }
            
            @Override
            public int j() {
                return super.a.getPaddingRight();
            }
            
            @Override
            public int k() {
                return super.a.getWidthMode();
            }
            
            @Override
            public int l() {
                return super.a.getHeightMode();
            }
            
            @Override
            public int m() {
                return super.a.getPaddingLeft();
            }
            
            @Override
            public int n() {
                return super.a.getWidth() - super.a.getPaddingLeft() - super.a.getPaddingRight();
            }
            
            @Override
            public int p(final View view) {
                super.a.getTransformedBoundingBox(view, true, super.c);
                return super.c.right;
            }
            
            @Override
            public int q(final View view) {
                super.a.getTransformedBoundingBox(view, true, super.c);
                return super.c.left;
            }
            
            @Override
            public void r(final int n) {
                super.a.offsetChildrenHorizontal(n);
            }
        };
    }
    
    public static s b(final RecyclerView.o o, final int n) {
        if (n == 0) {
            return a(o);
        }
        if (n == 1) {
            return c(o);
        }
        throw new IllegalArgumentException("invalid orientation");
    }
    
    public static s c(final RecyclerView.o o) {
        return new s(o) {
            @Override
            public int d(final View view) {
                return super.a.getDecoratedBottom(view) + ((RecyclerView.p)view.getLayoutParams()).bottomMargin;
            }
            
            @Override
            public int e(final View view) {
                final RecyclerView.p p = (RecyclerView.p)view.getLayoutParams();
                return super.a.getDecoratedMeasuredHeight(view) + p.topMargin + p.bottomMargin;
            }
            
            @Override
            public int f(final View view) {
                final RecyclerView.p p = (RecyclerView.p)view.getLayoutParams();
                return super.a.getDecoratedMeasuredWidth(view) + p.leftMargin + p.rightMargin;
            }
            
            @Override
            public int g(final View view) {
                return super.a.getDecoratedTop(view) - ((RecyclerView.p)view.getLayoutParams()).topMargin;
            }
            
            @Override
            public int h() {
                return super.a.getHeight();
            }
            
            @Override
            public int i() {
                return super.a.getHeight() - super.a.getPaddingBottom();
            }
            
            @Override
            public int j() {
                return super.a.getPaddingBottom();
            }
            
            @Override
            public int k() {
                return super.a.getHeightMode();
            }
            
            @Override
            public int l() {
                return super.a.getWidthMode();
            }
            
            @Override
            public int m() {
                return super.a.getPaddingTop();
            }
            
            @Override
            public int n() {
                return super.a.getHeight() - super.a.getPaddingTop() - super.a.getPaddingBottom();
            }
            
            @Override
            public int p(final View view) {
                super.a.getTransformedBoundingBox(view, true, super.c);
                return super.c.bottom;
            }
            
            @Override
            public int q(final View view) {
                super.a.getTransformedBoundingBox(view, true, super.c);
                return super.c.top;
            }
            
            @Override
            public void r(final int n) {
                super.a.offsetChildrenVertical(n);
            }
        };
    }
    
    public abstract int d(final View p0);
    
    public abstract int e(final View p0);
    
    public abstract int f(final View p0);
    
    public abstract int g(final View p0);
    
    public abstract int h();
    
    public abstract int i();
    
    public abstract int j();
    
    public abstract int k();
    
    public abstract int l();
    
    public abstract int m();
    
    public abstract int n();
    
    public int o() {
        int n;
        if (Integer.MIN_VALUE == this.b) {
            n = 0;
        }
        else {
            n = this.n() - this.b;
        }
        return n;
    }
    
    public abstract int p(final View p0);
    
    public abstract int q(final View p0);
    
    public abstract void r(final int p0);
    
    public void s() {
        this.b = this.n();
    }
}
