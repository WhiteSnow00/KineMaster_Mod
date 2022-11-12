// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import java.util.Arrays;
import android.view.View$MeasureSpec;
import androidx.core.view.accessibility.d;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.util.Log;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.util.SparseIntArray;
import android.view.View;

public class GridLayoutManager extends LinearLayoutManager
{
    boolean q;
    int r;
    int[] s;
    View[] t;
    final SparseIntArray u;
    final SparseIntArray v;
    c w;
    final Rect x;
    private boolean y;
    
    public GridLayoutManager(final Context context, final int spanCount) {
        super(context);
        this.q = false;
        this.r = -1;
        this.u = new SparseIntArray();
        this.v = new SparseIntArray();
        this.w = (c)new a();
        this.x = new Rect();
        this.setSpanCount(spanCount);
    }
    
    public GridLayoutManager(final Context context, final int spanCount, final int n, final boolean b) {
        super(context, n, b);
        this.q = false;
        this.r = -1;
        this.u = new SparseIntArray();
        this.v = new SparseIntArray();
        this.w = (c)new a();
        this.x = new Rect();
        this.setSpanCount(spanCount);
    }
    
    public GridLayoutManager(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.q = false;
        this.r = -1;
        this.u = new SparseIntArray();
        this.v = new SparseIntArray();
        this.w = (c)new a();
        this.x = new Rect();
        this.setSpanCount(RecyclerView.o.getProperties(context, set, n, n2).b);
    }
    
    private void M(final v v, final z z, int i, final boolean b) {
        int e = 0;
        int n = -1;
        int n2;
        if (b) {
            n2 = 1;
            final int n3 = 0;
            n = i;
            i = n3;
        }
        else {
            --i;
            n2 = -1;
        }
        while (i != n) {
            final View view = this.t[i];
            final b b2 = (b)view.getLayoutParams();
            final int y = this.Y(v, z, ((RecyclerView.o)this).getPosition(view));
            b2.f = y;
            b2.e = e;
            e += y;
            i += n2;
        }
    }
    
    private void N() {
        for (int childCount = ((RecyclerView.o)this).getChildCount(), i = 0; i < childCount; ++i) {
            final b b = (b)((RecyclerView.o)this).getChildAt(i).getLayoutParams();
            final int a = ((RecyclerView.p)b).a();
            this.u.put(a, b.f());
            this.v.put(a, b.e());
        }
    }
    
    private void O(final int n) {
        this.s = P(this.s, this.r, n);
    }
    
    static int[] P(final int[] array, final int n, int n2) {
        int i = 1;
        int[] array2 = null;
        Label_0035: {
            if (array != null && array.length == n + 1) {
                array2 = array;
                if (array[array.length - 1] == n2) {
                    break Label_0035;
                }
            }
            array2 = new int[n + 1];
        }
        final int n3 = 0;
        array2[0] = 0;
        final int n4 = n2 / n;
        final int n5 = n2 % n;
        int n6 = 0;
        n2 = n3;
        while (i <= n) {
            n2 += n5;
            int n7;
            if (n2 > 0 && n - n2 < n5) {
                n7 = n4 + 1;
                n2 -= n;
            }
            else {
                n7 = n4;
            }
            n6 += n7;
            array2[i] = n6;
            ++i;
        }
        return array2;
    }
    
    private void Q() {
        this.u.clear();
        this.v.clear();
    }
    
    private int R(final z z) {
        if (((RecyclerView.o)this).getChildCount() != 0) {
            if (z.b() != 0) {
                this.d();
                final boolean w = this.w();
                final View h = this.h(w ^ true, true);
                final View g = this.g(w ^ true, true);
                if (h != null) {
                    if (g != null) {
                        final int b = this.w.b(((RecyclerView.o)this).getPosition(h), this.r);
                        final int b2 = this.w.b(((RecyclerView.o)this).getPosition(g), this.r);
                        final int min = Math.min(b, b2);
                        final int max = Math.max(b, b2);
                        final int b3 = this.w.b(z.b() - 1, this.r);
                        int n;
                        if (super.f) {
                            n = Math.max(0, b3 + 1 - max - 1);
                        }
                        else {
                            n = Math.max(0, min);
                        }
                        if (!w) {
                            return n;
                        }
                        return Math.round(n * (Math.abs(super.c.d(g) - super.c.g(h)) / (float)(this.w.b(((RecyclerView.o)this).getPosition(g), this.r) - this.w.b(((RecyclerView.o)this).getPosition(h), this.r) + 1)) + (super.c.m() - super.c.g(h)));
                    }
                }
            }
        }
        return 0;
    }
    
    private int S(final z z) {
        if (((RecyclerView.o)this).getChildCount() != 0) {
            if (z.b() != 0) {
                this.d();
                final View h = this.h(this.w() ^ true, true);
                final View g = this.g(this.w() ^ true, true);
                if (h != null) {
                    if (g != null) {
                        if (!this.w()) {
                            return this.w.b(z.b() - 1, this.r) + 1;
                        }
                        return (int)((super.c.d(g) - super.c.g(h)) / (float)(this.w.b(((RecyclerView.o)this).getPosition(g), this.r) - this.w.b(((RecyclerView.o)this).getPosition(h), this.r) + 1) * (this.w.b(z.b() - 1, this.r) + 1));
                    }
                }
            }
        }
        return 0;
    }
    
    private void T(final v v, final z z, final LinearLayoutManager.a a, int i) {
        if (i == 1) {
            i = 1;
        }
        else {
            i = 0;
        }
        int j = this.X(v, z, a.b);
        if (i != 0) {
            while (j > 0) {
                i = a.b;
                if (i <= 0) {
                    break;
                }
                --i;
                a.b = i;
                j = this.X(v, z, i);
            }
        }
        else {
            int b;
            int n;
            int x;
            for (b = z.b(), i = a.b; i < b - 1; i = n, j = x) {
                n = i + 1;
                x = this.X(v, z, n);
                if (x <= j) {
                    break;
                }
            }
            a.b = i;
        }
    }
    
    private void U() {
        final View[] t = this.t;
        if (t == null || t.length != this.r) {
            this.t = new View[this.r];
        }
    }
    
    private int W(final v v, final z z, final int n) {
        if (!z.e()) {
            return this.w.b(n, this.r);
        }
        final int f = v.f(n);
        if (f == -1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot find span size for pre layout position. ");
            sb.append(n);
            Log.w("GridLayoutManager", sb.toString());
            return 0;
        }
        return this.w.b(f, this.r);
    }
    
    private int X(final v v, final z z, final int n) {
        if (!z.e()) {
            return this.w.c(n, this.r);
        }
        final int value = this.v.get(n, -1);
        if (value != -1) {
            return value;
        }
        final int f = v.f(n);
        if (f == -1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
            sb.append(n);
            Log.w("GridLayoutManager", sb.toString());
            return 0;
        }
        return this.w.c(f, this.r);
    }
    
    private int Y(final v v, final z z, final int n) {
        if (!z.e()) {
            return this.w.f(n);
        }
        final int value = this.u.get(n, -1);
        if (value != -1) {
            return value;
        }
        final int f = v.f(n);
        if (f == -1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
            sb.append(n);
            Log.w("GridLayoutManager", sb.toString());
            return 1;
        }
        return this.w.f(f);
    }
    
    private void Z(final float n, final int n2) {
        this.O(Math.max(Math.round(n * this.r), n2));
    }
    
    private void a0(final View view, int n, final boolean b) {
        final b b2 = (b)view.getLayoutParams();
        final Rect b3 = b2.b;
        final int n2 = b3.top + b3.bottom + b2.topMargin + b2.bottomMargin;
        final int n3 = b3.left + b3.right + b2.leftMargin + b2.rightMargin;
        final int v = this.V(b2.e, b2.f);
        int n4;
        if (super.a == 1) {
            n4 = RecyclerView.o.getChildMeasureSpec(v, n, n3, b2.width, false);
            n = RecyclerView.o.getChildMeasureSpec(super.c.n(), ((RecyclerView.o)this).getHeightMode(), n2, b2.height, true);
        }
        else {
            n = RecyclerView.o.getChildMeasureSpec(v, n, n2, b2.height, false);
            n4 = RecyclerView.o.getChildMeasureSpec(super.c.n(), ((RecyclerView.o)this).getWidthMode(), n3, b2.width, true);
        }
        this.measureChildWithDecorationsAndMargin(view, n4, n, b);
    }
    
    private void c0() {
        int n;
        int n2;
        if (this.getOrientation() == 1) {
            n = ((RecyclerView.o)this).getWidth() - ((RecyclerView.o)this).getPaddingRight();
            n2 = ((RecyclerView.o)this).getPaddingLeft();
        }
        else {
            n = ((RecyclerView.o)this).getHeight() - ((RecyclerView.o)this).getPaddingBottom();
            n2 = ((RecyclerView.o)this).getPaddingTop();
        }
        this.O(n - n2);
    }
    
    private void measureChildWithDecorationsAndMargin(final View view, final int n, final int n2, final boolean b) {
        final p p4 = (p)view.getLayoutParams();
        boolean b2;
        if (b) {
            b2 = ((RecyclerView.o)this).shouldReMeasureChild(view, n, n2, p4);
        }
        else {
            b2 = ((RecyclerView.o)this).shouldMeasureChild(view, n, n2, p4);
        }
        if (b2) {
            view.measure(n, n2);
        }
    }
    
    @Override
    public void D(final boolean b) {
        if (!b) {
            super.D(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }
    
    int V(final int n, final int n2) {
        if (super.a == 1 && this.isLayoutRTL()) {
            final int[] s = this.s;
            final int r = this.r;
            return s[r - n] - s[r - n - n2];
        }
        final int[] s2 = this.s;
        return s2[n2 + n] - s2[n];
    }
    
    @Override
    void b(final z z, final LinearLayoutManager.c c, final o.c c2) {
        int d;
        for (int r = this.r, n = 0; n < this.r && c.c(z) && r > 0; r -= this.w.f(d), c.d += c.e, ++n) {
            d = c.d;
            c2.a(d, Math.max(0, c.g));
        }
    }
    
    public void b0(final c w) {
        this.w = w;
    }
    
    @Override
    public boolean checkLayoutParams(final p p) {
        return p instanceof b;
    }
    
    @Override
    public int computeHorizontalScrollOffset(final z z) {
        if (this.y) {
            return this.R(z);
        }
        return super.computeHorizontalScrollOffset(z);
    }
    
    @Override
    public int computeHorizontalScrollRange(final z z) {
        if (this.y) {
            return this.S(z);
        }
        return super.computeHorizontalScrollRange(z);
    }
    
    @Override
    public int computeVerticalScrollOffset(final z z) {
        if (this.y) {
            return this.R(z);
        }
        return super.computeVerticalScrollOffset(z);
    }
    
    @Override
    public int computeVerticalScrollRange(final z z) {
        if (this.y) {
            return this.S(z);
        }
        return super.computeVerticalScrollRange(z);
    }
    
    @Override
    public p generateDefaultLayoutParams() {
        if (super.a == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }
    
    @Override
    public p generateLayoutParams(final Context context, final AttributeSet set) {
        return new b(context, set);
    }
    
    @Override
    public p generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return new b((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return new b(viewGroup$LayoutParams);
    }
    
    @Override
    public int getColumnCountForAccessibility(final v v, final z z) {
        if (super.a == 1) {
            return this.r;
        }
        if (z.b() < 1) {
            return 0;
        }
        return this.W(v, z, z.b() - 1) + 1;
    }
    
    @Override
    public int getRowCountForAccessibility(final v v, final z z) {
        if (super.a == 0) {
            return this.r;
        }
        if (z.b() < 1) {
            return 0;
        }
        return this.W(v, z, z.b() - 1) + 1;
    }
    
    public int getSpanCount() {
        return this.r;
    }
    
    @Override
    public View onFocusSearchFailed(View view, int n, final v v, final z z) {
        final View containingItemView = ((RecyclerView.o)this).findContainingItemView(view);
        View view2 = null;
        if (containingItemView == null) {
            return null;
        }
        final b b = (b)containingItemView.getLayoutParams();
        final int e = b.e;
        final int n2 = b.f + e;
        if (super.onFocusSearchFailed(view, n, v, z) == null) {
            return null;
        }
        if (this.convertFocusDirectionToLayoutDirection(n) == 1 != super.f) {
            n = 1;
        }
        else {
            n = 0;
        }
        int childCount;
        int n3;
        if (n != 0) {
            n = ((RecyclerView.o)this).getChildCount() - 1;
            childCount = -1;
            n3 = -1;
        }
        else {
            childCount = ((RecyclerView.o)this).getChildCount();
            n3 = 1;
            n = 0;
        }
        final boolean b2 = super.a == 1 && this.isLayoutRTL();
        final int w = this.W(v, z, n);
        int e2 = -1;
        int e3 = -1;
        final int n4 = 0;
        final int n5 = 0;
        int i = n;
        view = null;
        n = n5;
        final int n6 = childCount;
        int n7 = n4;
        while (i != n6) {
            final int w2 = this.W(v, z, i);
            final View child = ((RecyclerView.o)this).getChildAt(i);
            if (child == containingItemView) {
                break;
            }
            if (child.hasFocusable() && w2 != w) {
                if (view2 != null) {
                    break;
                }
            }
            else {
                final b b3 = (b)child.getLayoutParams();
                final int e4 = b3.e;
                final int n8 = b3.f + e4;
                if (child.hasFocusable() && e4 == e && n8 == n2) {
                    return child;
                }
                boolean b4 = false;
                Label_0472: {
                    Label_0324: {
                        if ((child.hasFocusable() || view2 != null) && (child.hasFocusable() || view != null)) {
                            final int n9 = Math.min(n8, n2) - Math.max(e4, e);
                            if (child.hasFocusable()) {
                                if (n9 > n7 || (n9 == n7 && b2 == e4 > e2)) {
                                    break Label_0324;
                                }
                            }
                            else if (view2 == null) {
                                b4 = true;
                                final boolean b5 = true;
                                if (((RecyclerView.o)this).isViewPartiallyVisible(child, false, true)) {
                                    if (n9 > n) {
                                        break Label_0472;
                                    }
                                    if (n9 == n) {
                                        if (b2 == (e4 > e3 && b5)) {
                                            break Label_0324;
                                        }
                                    }
                                }
                            }
                            b4 = false;
                            break Label_0472;
                        }
                    }
                    b4 = true;
                }
                if (b4) {
                    if (child.hasFocusable()) {
                        e2 = b3.e;
                        final int min = Math.min(n8, n2);
                        final int max = Math.max(e4, e);
                        view2 = child;
                        n7 = min - max;
                    }
                    else {
                        e3 = b3.e;
                        n = Math.min(n8, n2) - Math.max(e4, e);
                        view = child;
                    }
                }
            }
            i += n3;
        }
        if (view2 == null) {
            view2 = view;
        }
        return view2;
    }
    
    @Override
    public void onInitializeAccessibilityNodeInfoForItem(final v v, final z z, final View view, final androidx.core.view.accessibility.d d) {
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, d);
            return;
        }
        final b b = (b)layoutParams;
        final int w = this.W(v, z, ((RecyclerView.p)b).a());
        if (super.a == 0) {
            d.T(androidx.core.view.accessibility.d.c.a(b.e(), b.f(), w, 1, false, false));
        }
        else {
            d.T(androidx.core.view.accessibility.d.c.a(w, 1, b.e(), b.f(), false, false));
        }
    }
    
    @Override
    public void onItemsAdded(final RecyclerView recyclerView, final int n, final int n2) {
        this.w.h();
        this.w.g();
    }
    
    @Override
    public void onItemsChanged(final RecyclerView recyclerView) {
        this.w.h();
        this.w.g();
    }
    
    @Override
    public void onItemsMoved(final RecyclerView recyclerView, final int n, final int n2, final int n3) {
        this.w.h();
        this.w.g();
    }
    
    @Override
    public void onItemsRemoved(final RecyclerView recyclerView, final int n, final int n2) {
        this.w.h();
        this.w.g();
    }
    
    @Override
    public void onItemsUpdated(final RecyclerView recyclerView, final int n, final int n2, final Object o) {
        this.w.h();
        this.w.g();
    }
    
    @Override
    public void onLayoutChildren(final v v, final z z) {
        if (z.e()) {
            this.N();
        }
        super.onLayoutChildren(v, z);
        this.Q();
    }
    
    @Override
    public void onLayoutCompleted(final z z) {
        super.onLayoutCompleted(z);
        this.q = false;
    }
    
    @Override
    View q(final v v, final z z, final boolean b, final boolean b2) {
        final int childCount = ((RecyclerView.o)this).getChildCount();
        int n = -1;
        int n2 = 1;
        int i;
        if (b2) {
            i = ((RecyclerView.o)this).getChildCount() - 1;
            n2 = -1;
        }
        else {
            n = childCount;
            i = 0;
        }
        final int b3 = z.b();
        this.d();
        final int m = super.c.m();
        final int j = super.c.i();
        View view = null;
        View view2 = null;
        while (i != n) {
            final View child = ((RecyclerView.o)this).getChildAt(i);
            final int position = ((RecyclerView.o)this).getPosition(child);
            View view3 = view;
            View view4 = view2;
            if (position >= 0) {
                view3 = view;
                view4 = view2;
                if (position < b3) {
                    if (this.X(v, z, position) != 0) {
                        view3 = view;
                        view4 = view2;
                    }
                    else if (((p)child.getLayoutParams()).c()) {
                        view3 = view;
                        if ((view4 = view2) == null) {
                            view4 = child;
                            view3 = view;
                        }
                    }
                    else {
                        if (super.c.g(child) < j && super.c.d(child) >= m) {
                            return child;
                        }
                        view3 = view;
                        view4 = view2;
                        if (view == null) {
                            view3 = child;
                            view4 = view2;
                        }
                    }
                }
            }
            i += n2;
            view = view3;
            view2 = view4;
        }
        if (view != null) {
            view2 = view;
        }
        return view2;
    }
    
    @Override
    public int scrollHorizontallyBy(final int n, final v v, final z z) {
        this.c0();
        this.U();
        return super.scrollHorizontallyBy(n, v, z);
    }
    
    @Override
    public int scrollVerticallyBy(final int n, final v v, final z z) {
        this.c0();
        this.U();
        return super.scrollVerticallyBy(n, v, z);
    }
    
    @Override
    public void setMeasuredDimension(final Rect rect, int chooseSize, int chooseSize2) {
        if (this.s == null) {
            super.setMeasuredDimension(rect, chooseSize, chooseSize2);
        }
        final int n = ((RecyclerView.o)this).getPaddingLeft() + ((RecyclerView.o)this).getPaddingRight();
        final int n2 = ((RecyclerView.o)this).getPaddingTop() + ((RecyclerView.o)this).getPaddingBottom();
        if (super.a == 1) {
            chooseSize2 = RecyclerView.o.chooseSize(chooseSize2, rect.height() + n2, ((RecyclerView.o)this).getMinimumHeight());
            final int[] s = this.s;
            final int chooseSize3 = RecyclerView.o.chooseSize(chooseSize, s[s.length - 1] + n, ((RecyclerView.o)this).getMinimumWidth());
            chooseSize = chooseSize2;
            chooseSize2 = chooseSize3;
        }
        else {
            chooseSize = RecyclerView.o.chooseSize(chooseSize, rect.width() + n, ((RecyclerView.o)this).getMinimumWidth());
            final int[] s2 = this.s;
            final int chooseSize4 = RecyclerView.o.chooseSize(chooseSize2, s2[s2.length - 1] + n2, ((RecyclerView.o)this).getMinimumHeight());
            chooseSize2 = chooseSize;
            chooseSize = chooseSize4;
        }
        ((RecyclerView.o)this).setMeasuredDimension(chooseSize2, chooseSize);
    }
    
    public void setSpanCount(final int r) {
        if (r == this.r) {
            return;
        }
        this.q = true;
        if (r >= 1) {
            this.r = r;
            this.w.h();
            ((RecyclerView.o)this).requestLayout();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Span count should be at least 1. Provided ");
        sb.append(r);
        throw new IllegalArgumentException(sb.toString());
    }
    
    @Override
    public boolean supportsPredictiveItemAnimations() {
        return super.l == null && !this.q;
    }
    
    @Override
    void x(final v v, final z z, final LinearLayoutManager.c c, final LinearLayoutManager.b b) {
        final int l = super.c.l();
        final boolean b2 = l != 1073741824;
        int n;
        if (((RecyclerView.o)this).getChildCount() > 0) {
            n = this.s[this.r];
        }
        else {
            n = 0;
        }
        if (b2) {
            this.c0();
        }
        final boolean b3 = c.e == 1;
        int r = this.r;
        if (!b3) {
            r = this.X(v, z, c.d) + this.Y(v, z, c.d);
        }
        int n2;
        for (n2 = 0; n2 < this.r && c.c(z) && r > 0; ++n2) {
            final int d = c.d;
            final int y = this.Y(v, z, d);
            if (y > this.r) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Item at position ");
                sb.append(d);
                sb.append(" requires ");
                sb.append(y);
                sb.append(" spans but GridLayoutManager has only ");
                sb.append(this.r);
                sb.append(" spans.");
                throw new IllegalArgumentException(sb.toString());
            }
            r -= y;
            if (r < 0) {
                break;
            }
            final View d2 = c.d(v);
            if (d2 == null) {
                break;
            }
            this.t[n2] = d2;
        }
        if (n2 == 0) {
            b.b = true;
            return;
        }
        float n3 = 0.0f;
        this.M(v, z, n2, b3);
        int i = 0;
        int n4 = 0;
        while (i < n2) {
            final View view = this.t[i];
            if (c.l == null) {
                if (b3) {
                    ((RecyclerView.o)this).addView(view);
                }
                else {
                    ((RecyclerView.o)this).addView(view, 0);
                }
            }
            else if (b3) {
                ((RecyclerView.o)this).addDisappearingView(view);
            }
            else {
                ((RecyclerView.o)this).addDisappearingView(view, 0);
            }
            ((RecyclerView.o)this).calculateItemDecorationsForChild(view, this.x);
            this.a0(view, l, false);
            final int e = super.c.e(view);
            int n5 = n4;
            if (e > n4) {
                n5 = e;
            }
            final float n6 = super.c.f(view) * 1.0f / ((b)view.getLayoutParams()).f;
            float n7 = n3;
            if (n6 > n3) {
                n7 = n6;
            }
            ++i;
            n4 = n5;
            n3 = n7;
        }
        int a = n4;
        if (b2) {
            this.Z(n3, n);
            int n8 = 0;
            int n9 = 0;
            while (true) {
                a = n9;
                if (n8 >= n2) {
                    break;
                }
                final View view2 = this.t[n8];
                this.a0(view2, 1073741824, true);
                final int e2 = super.c.e(view2);
                int n10;
                if (e2 > (n10 = n9)) {
                    n10 = e2;
                }
                ++n8;
                n9 = n10;
            }
        }
        for (int j = 0; j < n2; ++j) {
            final View view3 = this.t[j];
            if (super.c.e(view3) != a) {
                final b b4 = (b)view3.getLayoutParams();
                final Rect b5 = b4.b;
                final int n11 = b5.top + b5.bottom + b4.topMargin + b4.bottomMargin;
                final int n12 = b5.left + b5.right + b4.leftMargin + b4.rightMargin;
                final int v2 = this.V(b4.e, b4.f);
                int n13;
                int n14;
                if (super.a == 1) {
                    n13 = RecyclerView.o.getChildMeasureSpec(v2, 1073741824, n12, b4.width, false);
                    n14 = View$MeasureSpec.makeMeasureSpec(a - n11, 1073741824);
                }
                else {
                    n13 = View$MeasureSpec.makeMeasureSpec(a - n12, 1073741824);
                    n14 = RecyclerView.o.getChildMeasureSpec(v2, 1073741824, n11, b4.height, false);
                }
                this.measureChildWithDecorationsAndMargin(view3, n13, n14, true);
            }
        }
        int k = 0;
        b.a = a;
        int b6;
        int n15;
        int b8;
        int b9;
        if (super.a == 1) {
            if (c.f == -1) {
                b6 = c.b;
                n15 = b6 - a;
            }
            else {
                final int b7;
                final int n16 = a + (b7 = c.b);
                n15 = b7;
                b6 = n16;
            }
            b8 = 0;
            b9 = 0;
        }
        else if (c.f == -1) {
            b8 = c.b;
            b9 = b8 - a;
            n15 = 0;
            b6 = 0;
        }
        else {
            b9 = c.b;
            b8 = a + b9;
            b6 = 0;
            n15 = 0;
        }
        while (k < n2) {
            final View view4 = this.t[k];
            final b b10 = (b)view4.getLayoutParams();
            int n18;
            int n21;
            int n22;
            int n23;
            if (super.a == 1) {
                int n19;
                if (this.isLayoutRTL()) {
                    final int n17 = ((RecyclerView.o)this).getPaddingLeft() + this.s[this.r - b10.e];
                    final int f = super.c.f(view4);
                    n18 = n17;
                    n19 = n17 - f;
                }
                else {
                    final int n20 = ((RecyclerView.o)this).getPaddingLeft() + this.s[b10.e];
                    final int f2 = super.c.f(view4);
                    n19 = n20;
                    n18 = f2 + n20;
                }
                n21 = b6;
                n22 = n15;
                n23 = n19;
            }
            else {
                final int n24 = ((RecyclerView.o)this).getPaddingTop() + this.s[b10.e];
                final int f3 = super.c.f(view4);
                n22 = n24;
                n23 = b9;
                n21 = f3 + n24;
                n18 = b8;
            }
            ((RecyclerView.o)this).layoutDecoratedWithMargins(view4, n23, n22, n18, n21);
            if (((RecyclerView.p)b10).c() || ((RecyclerView.p)b10).b()) {
                b.c = true;
            }
            b.d |= view4.hasFocusable();
            final int n25 = k + 1;
            final int n26 = n21;
            b8 = n18;
            final int n27 = n22;
            b6 = n26;
            b9 = n23;
            n15 = n27;
            k = n25;
        }
        Arrays.fill(this.t, null);
    }
    
    @Override
    void y(final v v, final z z, final LinearLayoutManager.a a, final int n) {
        super.y(v, z, a, n);
        this.c0();
        if (z.b() > 0 && !z.e()) {
            this.T(v, z, a, n);
        }
        this.U();
    }
    
    public static final class a extends c
    {
        @Override
        public int e(final int n, final int n2) {
            return n % n2;
        }
        
        @Override
        public int f(final int n) {
            return 1;
        }
    }
    
    public static class b extends p
    {
        int e;
        int f;
        
        public b(final int n, final int n2) {
            super(n, n2);
            this.e = -1;
            this.f = 0;
        }
        
        public b(final Context context, final AttributeSet set) {
            super(context, set);
            this.e = -1;
            this.f = 0;
        }
        
        public b(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
            this.e = -1;
            this.f = 0;
        }
        
        public b(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(viewGroup$MarginLayoutParams);
            this.e = -1;
            this.f = 0;
        }
        
        public int e() {
            return this.e;
        }
        
        public int f() {
            return this.f;
        }
    }
    
    public abstract static class c
    {
        final SparseIntArray a;
        final SparseIntArray b;
        private boolean c;
        private boolean d;
        
        public c() {
            this.a = new SparseIntArray();
            this.b = new SparseIntArray();
            this.c = false;
            this.d = false;
        }
        
        static int a(final SparseIntArray sparseIntArray, int n) {
            int n2 = sparseIntArray.size() - 1;
            int i = 0;
            while (i <= n2) {
                final int n3 = i + n2 >>> 1;
                if (sparseIntArray.keyAt(n3) < n) {
                    i = n3 + 1;
                }
                else {
                    n2 = n3 - 1;
                }
            }
            n = i - 1;
            if (n >= 0 && n < sparseIntArray.size()) {
                return sparseIntArray.keyAt(n);
            }
            return -1;
        }
        
        int b(final int n, int d) {
            if (!this.d) {
                return this.d(n, d);
            }
            final int value = this.b.get(n, -1);
            if (value != -1) {
                return value;
            }
            d = this.d(n, d);
            this.b.put(n, d);
            return d;
        }
        
        int c(final int n, int e) {
            if (!this.c) {
                return this.e(n, e);
            }
            final int value = this.a.get(n, -1);
            if (value != -1) {
                return value;
            }
            e = this.e(n, e);
            this.a.put(n, e);
            return e;
        }
        
        public int d(int n, final int n2) {
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            Label_0091: {
                if (this.d) {
                    final int a = a(this.b, n);
                    if (a != -1) {
                        final int value = this.b.get(a);
                        final int n3 = a + 1;
                        final int n4 = this.c(a, n2) + this.f(a);
                        n5 = value;
                        n6 = n3;
                        if ((n7 = n4) == n2) {
                            n5 = value + 1;
                            n7 = 0;
                            n6 = n3;
                        }
                        break Label_0091;
                    }
                }
                n5 = 0;
                n6 = (n7 = 0);
            }
            final int f = this.f(n);
            int n8 = n7;
            int i = n6;
            int n9 = n5;
            while (i < n) {
                final int f2 = this.f(i);
                final int n10 = n8 + f2;
                int n11;
                int n12;
                if (n10 == n2) {
                    n11 = n9 + 1;
                    n12 = 0;
                }
                else {
                    n11 = n9;
                    if ((n12 = n10) > n2) {
                        n11 = n9 + 1;
                        n12 = f2;
                    }
                }
                ++i;
                n9 = n11;
                n8 = n12;
            }
            n = n9;
            if (n8 + f > n2) {
                n = n9 + 1;
            }
            return n;
        }
        
        public int e(final int n, final int n2) {
            final int f = this.f(n);
            if (f == n2) {
                return 0;
            }
            while (true) {
                int a = 0;
                Label_0117: {
                    if (this.c) {
                        a = a(this.a, n);
                        if (a >= 0) {
                            final int n3 = this.a.get(a) + this.f(a);
                            break Label_0117;
                        }
                    }
                    final int n4 = 0;
                    int n3 = 0;
                    if (n4 < n) {
                        final int f2 = this.f(n4);
                        final int n5 = n3 + f2;
                        if (n5 == n2) {
                            n3 = 0;
                            a = n4;
                        }
                        else {
                            a = n4;
                            if ((n3 = n5) > n2) {
                                n3 = f2;
                                a = n4;
                            }
                        }
                    }
                    else {
                        if (f + n3 <= n2) {
                            return n3;
                        }
                        return 0;
                    }
                }
                final int n4 = a + 1;
                continue;
            }
        }
        
        public abstract int f(final int p0);
        
        public void g() {
            this.b.clear();
        }
        
        public void h() {
            this.a.clear();
        }
    }
}
