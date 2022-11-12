// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.animation.Interpolator;
import android.util.DisplayMetrics;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;

public class t extends x
{
    private androidx.recyclerview.widget.s a;
    private androidx.recyclerview.widget.s b;
    
    private int a(final View view, final androidx.recyclerview.widget.s s) {
        return s.g(view) + s.e(view) / 2 - (s.m() + s.n() / 2);
    }
    
    private View b(final o o, final androidx.recyclerview.widget.s s) {
        final int childCount = o.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        final int m = s.m();
        final int n = s.n() / 2;
        int n2 = Integer.MAX_VALUE;
        int n3;
        for (int i = 0; i < childCount; ++i, n2 = n3) {
            final View child = o.getChildAt(i);
            final int abs = Math.abs(s.g(child) + s.e(child) / 2 - (m + n));
            if (abs < (n3 = n2)) {
                view = child;
                n3 = abs;
            }
        }
        return view;
    }
    
    private androidx.recyclerview.widget.s c(final o o) {
        final androidx.recyclerview.widget.s b = this.b;
        if (b == null || b.a != o) {
            this.b = androidx.recyclerview.widget.s.a(o);
        }
        return this.b;
    }
    
    private androidx.recyclerview.widget.s d(final o o) {
        if (o.canScrollVertically()) {
            return this.e(o);
        }
        if (o.canScrollHorizontally()) {
            return this.c(o);
        }
        return null;
    }
    
    private androidx.recyclerview.widget.s e(final o o) {
        final androidx.recyclerview.widget.s a = this.a;
        if (a == null || a.a != o) {
            this.a = androidx.recyclerview.widget.s.c(o);
        }
        return this.a;
    }
    
    private boolean f(final o o) {
        final int itemCount = o.getItemCount();
        final boolean b = o instanceof y.b;
        boolean b3;
        final boolean b2 = b3 = false;
        if (b) {
            final PointF computeScrollVectorForPosition = ((y.b)o).computeScrollVectorForPosition(itemCount - 1);
            b3 = b2;
            if (computeScrollVectorForPosition != null) {
                if (computeScrollVectorForPosition.x >= 0.0f) {
                    b3 = b2;
                    if (computeScrollVectorForPosition.y >= 0.0f) {
                        return b3;
                    }
                }
                b3 = true;
            }
        }
        return b3;
    }
    
    private boolean isForwardFling(final o o, final int n, final int n2) {
        final boolean canScrollHorizontally = o.canScrollHorizontally();
        final boolean b = true;
        boolean b2 = true;
        if (canScrollHorizontally) {
            if (n <= 0) {
                b2 = false;
            }
            return b2;
        }
        return n2 > 0 && b;
    }
    
    @Override
    public int[] calculateDistanceToFinalSnap(final o o, final View view) {
        final int[] array = new int[2];
        if (o.canScrollHorizontally()) {
            array[0] = this.a(view, this.c(o));
        }
        else {
            array[0] = 0;
        }
        if (o.canScrollVertically()) {
            array[1] = this.a(view, this.e(o));
        }
        else {
            array[1] = 0;
        }
        return array;
    }
    
    @Override
    protected y createScroller(final o o) {
        if (!(o instanceof y.b)) {
            return null;
        }
        return new androidx.recyclerview.widget.n(this, super.mRecyclerView.getContext()) {
            final t a;
            
            @Override
            protected float calculateSpeedPerPixel(final DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }
            
            @Override
            protected int calculateTimeForScrolling(final int n) {
                return Math.min(100, super.calculateTimeForScrolling(n));
            }
            
            @Override
            protected void onTargetFound(final View view, final z z, final a a) {
                final t a2 = this.a;
                final int[] calculateDistanceToFinalSnap = a2.calculateDistanceToFinalSnap(a2.mRecyclerView.getLayoutManager(), view);
                final int n = calculateDistanceToFinalSnap[0];
                final int n2 = calculateDistanceToFinalSnap[1];
                final int calculateTimeForDeceleration = this.calculateTimeForDeceleration(Math.max(Math.abs(n), Math.abs(n2)));
                if (calculateTimeForDeceleration > 0) {
                    a.d(n, n2, calculateTimeForDeceleration, (Interpolator)super.mDecelerateInterpolator);
                }
            }
        };
    }
    
    @Override
    public View findSnapView(final o o) {
        if (o.canScrollVertically()) {
            return this.b(o, this.e(o));
        }
        if (o.canScrollHorizontally()) {
            return this.b(o, this.c(o));
        }
        return null;
    }
    
    @Override
    public int findTargetSnapPosition(final o o, int n, int position) {
        final int itemCount = o.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        final androidx.recyclerview.widget.s d = this.d(o);
        if (d == null) {
            return -1;
        }
        int n2 = Integer.MIN_VALUE;
        int n3 = Integer.MAX_VALUE;
        final int childCount = o.getChildCount();
        int i = 0;
        View view = null;
        View view2 = null;
        while (i < childCount) {
            final View child = o.getChildAt(i);
            int n4;
            View view3;
            if (child == null) {
                n4 = n3;
                view3 = view;
            }
            else {
                final int a = this.a(child, d);
                int n5 = n2;
                View view4 = view2;
                if (a <= 0) {
                    n5 = n2;
                    view4 = view2;
                    if (a > n2) {
                        view4 = child;
                        n5 = a;
                    }
                }
                n2 = n5;
                n4 = n3;
                view3 = view;
                view2 = view4;
                if (a >= 0) {
                    n2 = n5;
                    n4 = n3;
                    view3 = view;
                    view2 = view4;
                    if (a < n3) {
                        view2 = view4;
                        view3 = child;
                        n4 = a;
                        n2 = n5;
                    }
                }
            }
            ++i;
            n3 = n4;
            view = view3;
        }
        final boolean forwardFling = this.isForwardFling(o, n, position);
        if (forwardFling && view != null) {
            return o.getPosition(view);
        }
        if (!forwardFling && view2 != null) {
            return o.getPosition(view2);
        }
        if (forwardFling) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        position = o.getPosition(view);
        if (this.f(o) == forwardFling) {
            n = -1;
        }
        else {
            n = 1;
        }
        n += position;
        if (n >= 0 && n < itemCount) {
            return n;
        }
        return -1;
    }
}
