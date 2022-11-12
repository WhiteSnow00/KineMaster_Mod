// 
// Decompiled by Procyon v0.6.0
// 

package androidx.viewpager2.widget;

import android.view.MotionEvent;
import androidx.core.view.accessibility.g;
import android.view.accessibility.AccessibilityEvent;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.os.Bundle;
import android.view.Gravity;
import android.view.accessibility.AccessibilityNodeInfo;
import android.util.SparseArray;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import d1.a;
import android.view.ViewGroup$LayoutParams;
import androidx.core.view.b0;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import androidx.recyclerview.widget.t;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;

public final class ViewPager2 extends ViewGroup
{
    static boolean F = true;
    private RecyclerView.l A;
    private boolean B;
    private boolean C;
    private int D;
    e E;
    private final Rect a;
    private final Rect b;
    private b c;
    int d;
    boolean e;
    private RecyclerView.i f;
    private LinearLayoutManager g;
    private int h;
    private Parcelable i;
    RecyclerView j;
    private t p;
    androidx.viewpager2.widget.e w;
    private b x;
    private c y;
    private d z;
    
    public ViewPager2(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new b(3);
        this.e = false;
        this.f = new g() {
            final ViewPager2 a;
            
            @Override
            public void onChanged() {
                final ViewPager2 a = this.a;
                a.e = true;
                a.w.j();
            }
        };
        this.h = -1;
        this.A = null;
        this.B = false;
        this.C = true;
        this.D = -1;
        this.b(context, set);
    }
    
    private RecyclerView.q a() {
        return new RecyclerView.q(this) {
            final ViewPager2 a;
            
            @Override
            public void a(final View view) {
            }
            
            @Override
            public void b(final View view) {
                final p p = (p)view.getLayoutParams();
                if (p.width == -1 && p.height == -1) {
                    return;
                }
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        };
    }
    
    private void b(final Context context, final AttributeSet set) {
        e e;
        if (ViewPager2.F) {
            e = new j();
        }
        else {
            e = new f();
        }
        this.E = e;
        (this.j = new m(context)).setId(b0.k());
        this.j.setDescendantFocusability(131072);
        final h h = new h(context);
        this.g = h;
        this.j.setLayoutManager((RecyclerView.o)h);
        this.j.setScrollingTouchSlop(1);
        this.l(context, set);
        this.j.setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
        this.j.addOnChildAttachStateChangeListener(this.a());
        final androidx.viewpager2.widget.e w = new androidx.viewpager2.widget.e(this);
        this.w = w;
        this.y = new c(this, w, this.j);
        (this.p = new l()).attachToRecyclerView(this.j);
        this.j.addOnScrollListener((RecyclerView.t)this.w);
        final b x = new b(3);
        this.x = x;
        this.w.m(x);
        final i i = new i(this) {
            final ViewPager2 a;
            
            @Override
            public void onPageScrollStateChanged(final int n) {
                if (n == 0) {
                    this.a.o();
                }
            }
            
            @Override
            public void onPageSelected(final int d) {
                final ViewPager2 a = this.a;
                if (a.d != d) {
                    a.d = d;
                    a.E.q();
                }
            }
        };
        final i j = new i(this) {
            final ViewPager2 a;
            
            @Override
            public void onPageSelected(final int n) {
                this.a.clearFocus();
                if (this.a.hasFocus()) {
                    this.a.j.requestFocus(2);
                }
            }
        };
        this.x.a(i);
        this.x.a(j);
        this.E.h(this.x, this.j);
        this.x.a(this.c);
        final d z = new d(this.g);
        this.z = z;
        this.x.a(z);
        final RecyclerView k = this.j;
        this.attachViewToParent((View)k, 0, k.getLayoutParams());
    }
    
    private void f(final RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f);
        }
    }
    
    private void i() {
        if (this.h == -1) {
            return;
        }
        final RecyclerView.Adapter adapter = this.getAdapter();
        if (adapter == null) {
            return;
        }
        final Parcelable i = this.i;
        if (i != null) {
            if (adapter instanceof androidx.viewpager2.adapter.b) {
                ((androidx.viewpager2.adapter.b)adapter).restoreState(i);
            }
            this.i = null;
        }
        final int max = Math.max(0, Math.min(this.h, adapter.getItemCount() - 1));
        this.d = max;
        this.h = -1;
        this.j.scrollToPosition(max);
        this.E.m();
    }
    
    private void l(final Context context, final AttributeSet set) {
        final int[] g = d1.a.g;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, g);
        if (Build$VERSION.SDK_INT >= 29) {
            this.saveAttributeDataForStyleable(context, g, set, obtainStyledAttributes, 0, 0);
        }
        try {
            this.setOrientation(obtainStyledAttributes.getInt(d1.a.h, 0));
        }
        finally {
            obtainStyledAttributes.recycle();
        }
    }
    
    private void m(final RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f);
        }
    }
    
    public boolean c() {
        return this.y.a();
    }
    
    public boolean canScrollHorizontally(final int n) {
        return this.j.canScrollHorizontally(n);
    }
    
    public boolean canScrollVertically(final int n) {
        return this.j.canScrollVertically(n);
    }
    
    boolean d() {
        final int layoutDirection = ((RecyclerView.o)this.g).getLayoutDirection();
        boolean b = true;
        if (layoutDirection != 1) {
            b = false;
        }
        return b;
    }
    
    protected void dispatchRestoreInstanceState(final SparseArray<Parcelable> sparseArray) {
        final Parcelable parcelable = (Parcelable)sparseArray.get(this.getId());
        if (parcelable instanceof SavedState) {
            final int a = ((SavedState)parcelable).a;
            sparseArray.put(this.j.getId(), sparseArray.get(a));
            sparseArray.remove(a);
        }
        super.dispatchRestoreInstanceState((SparseArray)sparseArray);
        this.i();
    }
    
    public boolean e() {
        return this.C;
    }
    
    public void g(final i i) {
        this.c.a(i);
    }
    
    public CharSequence getAccessibilityClassName() {
        if (this.E.a()) {
            return this.E.g();
        }
        return super.getAccessibilityClassName();
    }
    
    public RecyclerView.Adapter getAdapter() {
        return this.j.getAdapter();
    }
    
    public int getCurrentItem() {
        return this.d;
    }
    
    public int getItemDecorationCount() {
        return this.j.getItemDecorationCount();
    }
    
    public int getOffscreenPageLimit() {
        return this.D;
    }
    
    public int getOrientation() {
        return this.g.getOrientation();
    }
    
    int getPageSize() {
        final RecyclerView j = this.j;
        int n;
        int n2;
        if (this.getOrientation() == 0) {
            n = j.getWidth() - j.getPaddingLeft();
            n2 = j.getPaddingRight();
        }
        else {
            n = j.getHeight() - j.getPaddingTop();
            n2 = j.getPaddingBottom();
        }
        return n - n2;
    }
    
    public int getScrollState() {
        return this.w.f();
    }
    
    public void h() {
        if (this.z.a() == null) {
            return;
        }
        final double e = this.w.e();
        final int n = (int)e;
        final float n2 = (float)(e - n);
        this.z.onPageScrolled(n, n2, Math.round(this.getPageSize() * n2));
    }
    
    public void j(final int n, final boolean b) {
        if (!this.c()) {
            this.k(n, b);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }
    
    void k(int d, final boolean b) {
        final RecyclerView.Adapter adapter = this.getAdapter();
        if (adapter == null) {
            if (this.h != -1) {
                this.h = Math.max(d, 0);
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        final int min = Math.min(Math.max(d, 0), adapter.getItemCount() - 1);
        if (min == this.d && this.w.h()) {
            return;
        }
        d = this.d;
        if (min == d && b) {
            return;
        }
        double e = d;
        this.d = min;
        this.E.q();
        if (!this.w.h()) {
            e = this.w.e();
        }
        this.w.k(min, b);
        if (!b) {
            this.j.scrollToPosition(min);
            return;
        }
        final double n = min;
        if (Math.abs(n - e) > 3.0) {
            final RecyclerView j = this.j;
            if (n > e) {
                d = min - 3;
            }
            else {
                d = min + 3;
            }
            j.scrollToPosition(d);
            final RecyclerView i = this.j;
            i.post((Runnable)new n(min, i));
        }
        else {
            this.j.smoothScrollToPosition(min);
        }
    }
    
    public void n(final i i) {
        this.c.b(i);
    }
    
    void o() {
        final t p = this.p;
        if (p == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        final View snapView = p.findSnapView(this.g);
        if (snapView == null) {
            return;
        }
        final int position = ((RecyclerView.o)this.g).getPosition(snapView);
        if (position != this.d && this.getScrollState() == 0) {
            this.x.onPageSelected(position);
        }
        this.e = false;
    }
    
    public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.E.i(accessibilityNodeInfo);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int measuredWidth = this.j.getMeasuredWidth();
        final int measuredHeight = this.j.getMeasuredHeight();
        this.a.left = this.getPaddingLeft();
        this.a.right = n3 - n - this.getPaddingRight();
        this.a.top = this.getPaddingTop();
        this.a.bottom = n4 - n2 - this.getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.a, this.b);
        final RecyclerView j = this.j;
        final Rect b2 = this.b;
        j.layout(b2.left, b2.top, b2.right, b2.bottom);
        if (this.e) {
            this.o();
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.measureChild((View)this.j, n, n2);
        final int measuredWidth = this.j.getMeasuredWidth();
        final int measuredHeight = this.j.getMeasuredHeight();
        final int measuredState = this.j.getMeasuredState();
        this.setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(measuredWidth + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), n, measuredState), ViewGroup.resolveSizeAndState(Math.max(measuredHeight + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), n2, measuredState << 16));
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.h = savedState.b;
        this.i = savedState.c;
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.j.getId();
        int b;
        if ((b = this.h) == -1) {
            b = this.d;
        }
        savedState.b = b;
        final Parcelable i = this.i;
        if (i != null) {
            savedState.c = i;
        }
        else {
            final RecyclerView.Adapter adapter = this.j.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.b) {
                savedState.c = ((androidx.viewpager2.adapter.b)adapter).saveState();
            }
        }
        return (Parcelable)savedState;
    }
    
    public void onViewAdded(final View view) {
        final StringBuilder sb = new StringBuilder();
        sb.append(ViewPager2.class.getSimpleName());
        sb.append(" does not support direct child views");
        throw new IllegalStateException(sb.toString());
    }
    
    public boolean performAccessibilityAction(final int n, final Bundle bundle) {
        if (this.E.c(n, bundle)) {
            return this.E.l(n, bundle);
        }
        return super.performAccessibilityAction(n, bundle);
    }
    
    public void setAdapter(final RecyclerView.Adapter adapter) {
        final RecyclerView.Adapter adapter2 = this.j.getAdapter();
        this.E.f(adapter2);
        this.m(adapter2);
        this.j.setAdapter(adapter);
        this.d = 0;
        this.i();
        this.E.e(adapter);
        this.f(adapter);
    }
    
    public void setCurrentItem(final int n) {
        this.j(n, true);
    }
    
    public void setLayoutDirection(final int layoutDirection) {
        super.setLayoutDirection(layoutDirection);
        this.E.p();
    }
    
    public void setOffscreenPageLimit(final int d) {
        if (d < 1 && d != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.D = d;
        this.j.requestLayout();
    }
    
    public void setOrientation(final int orientation) {
        this.g.setOrientation(orientation);
        this.E.r();
    }
    
    public void setPageTransformer(final k k) {
        if (k != null) {
            if (!this.B) {
                this.A = this.j.getItemAnimator();
                this.B = true;
            }
            this.j.setItemAnimator(null);
        }
        else if (this.B) {
            this.j.setItemAnimator(this.A);
            this.A = null;
            this.B = false;
        }
        if (k == this.z.a()) {
            return;
        }
        this.z.b(k);
        this.h();
    }
    
    public void setUserInputEnabled(final boolean c) {
        this.C = c;
        this.E.s();
    }
    
    static class SavedState extends View$BaseSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        int a;
        int b;
        Parcelable c;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$ClassLoaderCreator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return this.b(parcel, null);
                }
                
                public SavedState b(final Parcel parcel, final ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }
                
                public SavedState[] c(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                    return this.b(parcel, classLoader);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.c(n);
                }
            };
        }
        
        SavedState(final Parcel parcel, final ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a(parcel, classLoader);
        }
        
        SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        private void a(final Parcel parcel, final ClassLoader classLoader) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readParcelable(classLoader);
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.c, n);
        }
    }
    
    private abstract class e
    {
        final ViewPager2 a;
        
        private e(final ViewPager2 a) {
            this.a = a;
        }
        
        e(final ViewPager2 viewPager2, final ViewPager2$a g) {
            this(viewPager2);
        }
        
        boolean a() {
            return false;
        }
        
        boolean b(final int n) {
            return false;
        }
        
        boolean c(final int n, final Bundle bundle) {
            return false;
        }
        
        boolean d() {
            return false;
        }
        
        void e(final RecyclerView.Adapter<?> adapter) {
        }
        
        void f(final RecyclerView.Adapter<?> adapter) {
        }
        
        String g() {
            throw new IllegalStateException("Not implemented.");
        }
        
        void h(final b b, final RecyclerView recyclerView) {
        }
        
        void i(final AccessibilityNodeInfo accessibilityNodeInfo) {
        }
        
        void j(final androidx.core.view.accessibility.d d) {
        }
        
        boolean k(final int n) {
            throw new IllegalStateException("Not implemented.");
        }
        
        boolean l(final int n, final Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }
        
        void m() {
        }
        
        CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }
        
        void o(final AccessibilityEvent accessibilityEvent) {
        }
        
        void p() {
        }
        
        void q() {
        }
        
        void r() {
        }
        
        void s() {
        }
    }
    
    class f extends e
    {
        final ViewPager2 b;
        
        f(final ViewPager2 b) {
            this.b = b.super(null);
        }
        
        public boolean b(final int n) {
            return (n == 8192 || n == 4096) && !this.b.e();
        }
        
        public boolean d() {
            return true;
        }
        
        public void j(final androidx.core.view.accessibility.d d) {
            if (!this.b.e()) {
                d.J(d.a.r);
                d.J(d.a.q);
                d.l0(false);
            }
        }
        
        public boolean k(final int n) {
            if (this.b(n)) {
                return false;
            }
            throw new IllegalStateException();
        }
        
        public CharSequence n() {
            if (this.d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }
    
    private abstract static class g extends RecyclerView.i
    {
        private g() {
        }
        
        g(final ViewPager2$a g) {
            this();
        }
        
        @Override
        public abstract void onChanged();
        
        @Override
        public final void onItemRangeChanged(final int n, final int n2) {
            this.onChanged();
        }
        
        @Override
        public final void onItemRangeChanged(final int n, final int n2, final Object o) {
            this.onChanged();
        }
        
        @Override
        public final void onItemRangeInserted(final int n, final int n2) {
            this.onChanged();
        }
        
        @Override
        public final void onItemRangeMoved(final int n, final int n2, final int n3) {
            this.onChanged();
        }
        
        @Override
        public final void onItemRangeRemoved(final int n, final int n2) {
            this.onChanged();
        }
    }
    
    private class h extends LinearLayoutManager
    {
        final ViewPager2 q;
        
        h(final ViewPager2 q, final Context context) {
            this.q = q;
            super(context);
        }
        
        @Override
        protected void a(final z z, final int[] array) {
            final int offscreenPageLimit = this.q.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.a(z, array);
                return;
            }
            array[1] = (array[0] = this.q.getPageSize() * offscreenPageLimit);
        }
        
        @Override
        public void onInitializeAccessibilityNodeInfo(final v v, final z z, final androidx.core.view.accessibility.d d) {
            super.onInitializeAccessibilityNodeInfo(v, z, d);
            this.q.E.j(d);
        }
        
        @Override
        public boolean performAccessibilityAction(final v v, final z z, final int n, final Bundle bundle) {
            if (this.q.E.b(n)) {
                return this.q.E.k(n);
            }
            return super.performAccessibilityAction(v, z, n, bundle);
        }
        
        @Override
        public boolean requestChildRectangleOnScreen(final RecyclerView recyclerView, final View view, final Rect rect, final boolean b, final boolean b2) {
            return false;
        }
    }
    
    public abstract static class i
    {
        public void onPageScrollStateChanged(final int n) {
        }
        
        public void onPageScrolled(final int n, final float n2, final int n3) {
        }
        
        public void onPageSelected(final int n) {
        }
    }
    
    class j extends e
    {
        private final androidx.core.view.accessibility.g b;
        private final androidx.core.view.accessibility.g c;
        private RecyclerView.i d;
        final ViewPager2 e;
        
        j(final ViewPager2 e) {
            this.e = e.super(null);
            this.b = new androidx.core.view.accessibility.g() {
                final j a;
                
                @Override
                public boolean a(final View view, final a a) {
                    this.a.v(((ViewPager2)view).getCurrentItem() + 1);
                    return true;
                }
            };
            this.c = new androidx.core.view.accessibility.g() {
                final j a;
                
                @Override
                public boolean a(final View view, final a a) {
                    this.a.v(((ViewPager2)view).getCurrentItem() - 1);
                    return true;
                }
            };
        }
        
        private void t(final AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            int itemCount2;
            if (this.e.getAdapter() != null) {
                if (this.e.getOrientation() == 1) {
                    itemCount = this.e.getAdapter().getItemCount();
                    itemCount2 = 0;
                }
                else {
                    itemCount2 = this.e.getAdapter().getItemCount();
                    itemCount = 0;
                }
            }
            else {
                itemCount = 0;
                itemCount2 = 0;
            }
            androidx.core.view.accessibility.d.t0(accessibilityNodeInfo).S(androidx.core.view.accessibility.d.b.a(itemCount, itemCount2, false, 0));
        }
        
        private void u(final AccessibilityNodeInfo accessibilityNodeInfo) {
            final RecyclerView.Adapter adapter = this.e.getAdapter();
            if (adapter == null) {
                return;
            }
            final int itemCount = adapter.getItemCount();
            if (itemCount != 0) {
                if (this.e.e()) {
                    if (this.e.d > 0) {
                        accessibilityNodeInfo.addAction(8192);
                    }
                    if (this.e.d < itemCount - 1) {
                        accessibilityNodeInfo.addAction(4096);
                    }
                    accessibilityNodeInfo.setScrollable(true);
                }
            }
        }
        
        public boolean a() {
            return true;
        }
        
        public boolean c(final int n, final Bundle bundle) {
            return n == 8192 || n == 4096;
        }
        
        public void e(final RecyclerView.Adapter<?> adapter) {
            this.w();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.d);
            }
        }
        
        public void f(final RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.d);
            }
        }
        
        public String g() {
            if (this.a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
        
        public void h(final b b, final RecyclerView recyclerView) {
            b0.A0((View)recyclerView, 2);
            this.d = new g(this) {
                final ViewPager2.j a;
                
                @Override
                public void onChanged() {
                    this.a.w();
                }
            };
            if (b0.z((View)this.e) == 0) {
                b0.A0((View)this.e, 1);
            }
        }
        
        public void i(final AccessibilityNodeInfo accessibilityNodeInfo) {
            this.t(accessibilityNodeInfo);
            this.u(accessibilityNodeInfo);
        }
        
        public boolean l(int n, final Bundle bundle) {
            if (this.c(n, bundle)) {
                if (n == 8192) {
                    n = this.e.getCurrentItem() - 1;
                }
                else {
                    n = this.e.getCurrentItem() + 1;
                }
                this.v(n);
                return true;
            }
            throw new IllegalStateException();
        }
        
        public void m() {
            this.w();
        }
        
        public void o(final AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource((View)this.e);
            accessibilityEvent.setClassName((CharSequence)this.g());
        }
        
        public void p() {
            this.w();
        }
        
        public void q() {
            this.w();
        }
        
        public void r() {
            this.w();
        }
        
        public void s() {
            this.w();
        }
        
        void v(final int n) {
            if (this.e.e()) {
                this.e.k(n, true);
            }
        }
        
        void w() {
            final ViewPager2 e = this.e;
            int n = 16908360;
            b0.j0((View)e, 16908360);
            b0.j0((View)e, 16908361);
            b0.j0((View)e, 16908358);
            b0.j0((View)e, 16908359);
            if (this.e.getAdapter() == null) {
                return;
            }
            final int itemCount = this.e.getAdapter().getItemCount();
            if (itemCount == 0) {
                return;
            }
            if (!this.e.e()) {
                return;
            }
            if (this.e.getOrientation() == 0) {
                final boolean d = this.e.d();
                int n2;
                if (d) {
                    n2 = 16908360;
                }
                else {
                    n2 = 16908361;
                }
                if (d) {
                    n = 16908361;
                }
                if (this.e.d < itemCount - 1) {
                    b0.l0((View)e, new androidx.core.view.accessibility.d.a(n2, null), null, this.b);
                }
                if (this.e.d > 0) {
                    b0.l0((View)e, new androidx.core.view.accessibility.d.a(n, null), null, this.c);
                }
            }
            else {
                if (this.e.d < itemCount - 1) {
                    b0.l0((View)e, new androidx.core.view.accessibility.d.a(16908359, null), null, this.b);
                }
                if (this.e.d > 0) {
                    b0.l0((View)e, new androidx.core.view.accessibility.d.a(16908358, null), null, this.c);
                }
            }
        }
    }
    
    public interface k
    {
        void a(final View p0, final float p1);
    }
    
    private class l extends t
    {
        final ViewPager2 c;
        
        l(final ViewPager2 c) {
            this.c = c;
        }
        
        @Override
        public View findSnapView(final o o) {
            View snapView;
            if (this.c.c()) {
                snapView = null;
            }
            else {
                snapView = super.findSnapView(o);
            }
            return snapView;
        }
    }
    
    private class m extends RecyclerView
    {
        final ViewPager2 a;
        
        m(final ViewPager2 a, final Context context) {
            this.a = a;
            super(context);
        }
        
        @Override
        public CharSequence getAccessibilityClassName() {
            if (this.a.E.d()) {
                return this.a.E.n();
            }
            return super.getAccessibilityClassName();
        }
        
        public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(this.a.d);
            accessibilityEvent.setToIndex(this.a.d);
            this.a.E.o(accessibilityEvent);
        }
        
        @Override
        public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
            return this.a.e() && super.onInterceptTouchEvent(motionEvent);
        }
        
        @Override
        public boolean onTouchEvent(final MotionEvent motionEvent) {
            return this.a.e() && super.onTouchEvent(motionEvent);
        }
    }
    
    private static class n implements Runnable
    {
        private final int a;
        private final RecyclerView b;
        
        n(final int a, final RecyclerView b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void run() {
            this.b.smoothScrollToPosition(this.a);
        }
    }
}
