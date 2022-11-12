// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import androidx.appcompat.view.menu.r;
import android.view.ViewParent;
import androidx.appcompat.view.c;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import androidx.customview.view.AbsSavedState;
import java.util.Iterator;
import android.text.TextUtils$TruncateAt;
import android.view.ContextThemeWrapper;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View$OnClickListener;
import androidx.core.view.o;
import androidx.core.view.i;
import android.view.MenuInflater;
import android.view.ViewGroup$LayoutParams;
import androidx.core.view.f;
import java.util.List;
import android.view.Menu;
import java.util.Collection;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$MarginLayoutParams;
import android.text.TextUtils;
import androidx.core.view.b0;
import d.a;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageButton;
import androidx.appcompat.view.menu.g;
import android.widget.TextView;
import android.view.MenuItem;
import androidx.core.view.m;
import android.view.View;
import java.util.ArrayList;
import android.content.res.ColorStateList;
import androidx.core.view.j;
import android.view.ViewGroup;

public class Toolbar extends ViewGroup implements j
{
    private int A;
    private int B;
    private int C;
    private int D;
    private j0 E;
    private int F;
    private int G;
    private int H;
    private CharSequence I;
    private CharSequence J;
    private ColorStateList K;
    private ColorStateList L;
    private boolean M;
    private boolean N;
    private final ArrayList<View> O;
    private final ArrayList<View> P;
    private final int[] Q;
    final m R;
    private ArrayList<MenuItem> S;
    f T;
    private final ActionMenuView.e U;
    private t0 V;
    private ActionMenuPresenter W;
    private ActionMenuView a;
    private d a0;
    private TextView b;
    private androidx.appcompat.view.menu.m.a b0;
    private TextView c;
    private g.a c0;
    private ImageButton d;
    private boolean d0;
    private ImageView e;
    private final Runnable e0;
    private Drawable f;
    private CharSequence g;
    ImageButton h;
    View i;
    private Context j;
    private int p;
    private int w;
    private int x;
    int y;
    private int z;
    
    public Toolbar(final Context context, final AttributeSet set) {
        this(context, set, d.a.P);
    }
    
    public Toolbar(final Context context, final AttributeSet set, int n) {
        super(context, set, n);
        this.H = 8388627;
        this.O = new ArrayList<View>();
        this.P = new ArrayList<View>();
        this.Q = new int[2];
        this.R = new m(new s0(this));
        this.S = new ArrayList<MenuItem>();
        this.U = new ActionMenuView.e() {
            final Toolbar a;
            
            @Override
            public boolean onMenuItemClick(final MenuItem menuItem) {
                if (this.a.R.j(menuItem)) {
                    return true;
                }
                final f t = this.a.T;
                return t != null && t.onMenuItemClick(menuItem);
            }
        };
        this.e0 = new Runnable() {
            final Toolbar a;
            
            @Override
            public void run() {
                this.a.Q();
            }
        };
        final Context context2 = this.getContext();
        final int[] d3 = d.j.d3;
        final r0 v = r0.v(context2, set, d3, n, 0);
        androidx.core.view.b0.n0((View)this, context, d3, set, v.r(), n, 0);
        this.w = v.n(d.j.F3, 0);
        this.x = v.n(d.j.w3, 0);
        this.H = v.l(d.j.e3, this.H);
        this.y = v.l(d.j.f3, 48);
        final int e = v.e(d.j.z3, 0);
        final int e2 = d.j.E3;
        n = e;
        if (v.s(e2)) {
            n = v.e(e2, e);
        }
        this.D = n;
        this.C = n;
        this.B = n;
        this.A = n;
        n = v.e(d.j.C3, -1);
        if (n >= 0) {
            this.A = n;
        }
        n = v.e(d.j.B3, -1);
        if (n >= 0) {
            this.B = n;
        }
        n = v.e(d.j.D3, -1);
        if (n >= 0) {
            this.C = n;
        }
        n = v.e(d.j.A3, -1);
        if (n >= 0) {
            this.D = n;
        }
        this.z = v.f(d.j.q3, -1);
        n = v.e(d.j.m3, Integer.MIN_VALUE);
        final int e3 = v.e(d.j.i3, Integer.MIN_VALUE);
        final int f = v.f(d.j.k3, 0);
        final int f2 = v.f(d.j.l3, 0);
        this.h();
        this.E.e(f, f2);
        if (n != Integer.MIN_VALUE || e3 != Integer.MIN_VALUE) {
            this.E.g(n, e3);
        }
        this.F = v.e(d.j.n3, Integer.MIN_VALUE);
        this.G = v.e(d.j.j3, Integer.MIN_VALUE);
        this.f = v.g(d.j.h3);
        this.g = v.p(d.j.g3);
        final CharSequence p3 = v.p(d.j.y3);
        if (!TextUtils.isEmpty(p3)) {
            this.setTitle(p3);
        }
        final CharSequence p4 = v.p(d.j.v3);
        if (!TextUtils.isEmpty(p4)) {
            this.setSubtitle(p4);
        }
        this.j = this.getContext();
        this.setPopupTheme(v.n(d.j.u3, 0));
        final Drawable g = v.g(d.j.t3);
        if (g != null) {
            this.setNavigationIcon(g);
        }
        final CharSequence p5 = v.p(d.j.s3);
        if (!TextUtils.isEmpty(p5)) {
            this.setNavigationContentDescription(p5);
        }
        final Drawable g2 = v.g(d.j.o3);
        if (g2 != null) {
            this.setLogo(g2);
        }
        final CharSequence p6 = v.p(d.j.p3);
        if (!TextUtils.isEmpty(p6)) {
            this.setLogoDescription(p6);
        }
        n = d.j.G3;
        if (v.s(n)) {
            this.setTitleTextColor(v.c(n));
        }
        n = d.j.x3;
        if (v.s(n)) {
            this.setSubtitleTextColor(v.c(n));
        }
        n = d.j.r3;
        if (v.s(n)) {
            this.x(v.n(n, 0));
        }
        v.w();
    }
    
    private int C(final View view, int n, final int[] array, int measuredWidth) {
        final e e = (e)view.getLayoutParams();
        final int n2 = e.leftMargin - array[0];
        n += Math.max(0, n2);
        array[0] = Math.max(0, -n2);
        final int q = this.q(view, measuredWidth);
        measuredWidth = view.getMeasuredWidth();
        view.layout(n, q, n + measuredWidth, view.getMeasuredHeight() + q);
        return n + (measuredWidth + e.rightMargin);
    }
    
    private int D(final View view, int n, final int[] array, int measuredWidth) {
        final e e = (e)view.getLayoutParams();
        final int n2 = e.rightMargin - array[1];
        n -= Math.max(0, n2);
        array[1] = Math.max(0, -n2);
        final int q = this.q(view, measuredWidth);
        measuredWidth = view.getMeasuredWidth();
        view.layout(n - measuredWidth, q, n, view.getMeasuredHeight() + q);
        return n - (measuredWidth + e.leftMargin);
    }
    
    private int E(final View view, final int n, final int n2, final int n3, final int n4, final int[] array) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        final int n5 = viewGroup$MarginLayoutParams.leftMargin - array[0];
        final int n6 = viewGroup$MarginLayoutParams.rightMargin - array[1];
        final int n7 = Math.max(0, n5) + Math.max(0, n6);
        array[0] = Math.max(0, -n5);
        array[1] = Math.max(0, -n6);
        view.measure(ViewGroup.getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight() + n7 + n2, viewGroup$MarginLayoutParams.width), ViewGroup.getChildMeasureSpec(n3, this.getPaddingTop() + this.getPaddingBottom() + viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin + n4, viewGroup$MarginLayoutParams.height));
        return view.getMeasuredWidth() + n7;
    }
    
    private void F(final View view, int n, int childMeasureSpec, int mode, final int n2, final int n3) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        final int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight() + viewGroup$MarginLayoutParams.leftMargin + viewGroup$MarginLayoutParams.rightMargin + childMeasureSpec, viewGroup$MarginLayoutParams.width);
        childMeasureSpec = ViewGroup.getChildMeasureSpec(mode, this.getPaddingTop() + this.getPaddingBottom() + viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin + n2, viewGroup$MarginLayoutParams.height);
        mode = View$MeasureSpec.getMode(childMeasureSpec);
        n = childMeasureSpec;
        if (mode != 1073741824) {
            n = childMeasureSpec;
            if (n3 >= 0) {
                n = n3;
                if (mode != 0) {
                    n = Math.min(View$MeasureSpec.getSize(childMeasureSpec), n3);
                }
                n = View$MeasureSpec.makeMeasureSpec(n, 1073741824);
            }
        }
        view.measure(childMeasureSpec2, n);
    }
    
    private void G() {
        final Menu menu = this.getMenu();
        final ArrayList<MenuItem> currentMenuItems = this.getCurrentMenuItems();
        this.R.h(menu, this.getMenuInflater());
        final ArrayList<MenuItem> currentMenuItems2 = this.getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.S = currentMenuItems2;
        this.R.k(menu);
    }
    
    private void H() {
        this.removeCallbacks(this.e0);
        this.post(this.e0);
    }
    
    private boolean O() {
        if (!this.d0) {
            return false;
        }
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (this.P(child) && child.getMeasuredWidth() > 0 && child.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }
    
    private boolean P(final View view) {
        return view != null && view.getParent() == this && view.getVisibility() != 8;
    }
    
    private void b(final List<View> list, int i) {
        final int b = androidx.core.view.b0.B((View)this);
        final int n = 0;
        final boolean b2 = b == 1;
        final int childCount = this.getChildCount();
        final int b3 = androidx.core.view.f.b(i, androidx.core.view.b0.B((View)this));
        list.clear();
        i = n;
        if (b2) {
            View child;
            e e;
            for (i = childCount - 1; i >= 0; --i) {
                child = this.getChildAt(i);
                e = (e)child.getLayoutParams();
                if (e.b == 0 && this.P(child) && this.p(e.a) == b3) {
                    list.add(child);
                }
            }
        }
        else {
            while (i < childCount) {
                final View child2 = this.getChildAt(i);
                final e e2 = (e)child2.getLayoutParams();
                if (e2.b == 0 && this.P(child2) && this.p(e2.a) == b3) {
                    list.add(child2);
                }
                ++i;
            }
        }
    }
    
    private void c(final View view, final boolean b) {
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        e layoutParams2;
        if (layoutParams == null) {
            layoutParams2 = this.m();
        }
        else if (!this.checkLayoutParams(layoutParams)) {
            layoutParams2 = this.o(layoutParams);
        }
        else {
            layoutParams2 = (e)layoutParams;
        }
        layoutParams2.b = 1;
        if (b && this.i != null) {
            view.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            this.P.add(view);
        }
        else {
            this.addView(view, (ViewGroup$LayoutParams)layoutParams2);
        }
    }
    
    private ArrayList<MenuItem> getCurrentMenuItems() {
        final ArrayList list = new ArrayList();
        final Menu menu = this.getMenu();
        for (int i = 0; i < menu.size(); ++i) {
            list.add(menu.getItem(i));
        }
        return list;
    }
    
    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(this.getContext());
    }
    
    private void h() {
        if (this.E == null) {
            this.E = new j0();
        }
    }
    
    private void i() {
        if (this.e == null) {
            this.e = new AppCompatImageView(this.getContext());
        }
    }
    
    private void j() {
        this.k();
        if (this.a.N() == null) {
            final g g = (g)this.a.getMenu();
            if (this.a0 == null) {
                this.a0 = new d();
            }
            this.a.setExpandedActionViewsExclusive(true);
            g.c(this.a0, this.j);
        }
    }
    
    private void k() {
        if (this.a == null) {
            (this.a = new ActionMenuView(this.getContext())).setPopupTheme(this.p);
            this.a.setOnMenuItemClickListener(this.U);
            this.a.O(this.b0, this.c0);
            final e m = this.m();
            m.a = (0x800005 | (this.y & 0x70));
            this.a.setLayoutParams((ViewGroup$LayoutParams)m);
            this.c((View)this.a, false);
        }
    }
    
    private void l() {
        if (this.d == null) {
            this.d = new l(this.getContext(), null, d.a.O);
            final e m = this.m();
            m.a = (0x800003 | (this.y & 0x70));
            this.d.setLayoutParams((ViewGroup$LayoutParams)m);
        }
    }
    
    private int p(int n) {
        final int b = androidx.core.view.b0.B((View)this);
        final int n2 = androidx.core.view.f.b(n, b) & 0x7;
        if (n2 != 1) {
            n = 3;
            if (n2 != 3 && n2 != 5) {
                if (b == 1) {
                    n = 5;
                }
                return n;
            }
        }
        return n2;
    }
    
    private int q(final View view, int n) {
        final e e = (e)view.getLayoutParams();
        final int measuredHeight = view.getMeasuredHeight();
        if (n > 0) {
            n = (measuredHeight - n) / 2;
        }
        else {
            n = 0;
        }
        final int r = this.r(e.a);
        if (r == 48) {
            return this.getPaddingTop() - n;
        }
        if (r != 80) {
            final int paddingTop = this.getPaddingTop();
            final int paddingBottom = this.getPaddingBottom();
            final int height = this.getHeight();
            final int n2 = (height - paddingTop - paddingBottom - measuredHeight) / 2;
            n = e.topMargin;
            if (n2 >= n) {
                final int n3 = height - paddingBottom - measuredHeight - n2 - paddingTop;
                final int bottomMargin = e.bottomMargin;
                n = n2;
                if (n3 < bottomMargin) {
                    n = Math.max(0, n2 - (bottomMargin - n3));
                }
            }
            return paddingTop + n;
        }
        return this.getHeight() - this.getPaddingBottom() - measuredHeight - e.bottomMargin - n;
    }
    
    private int r(int n) {
        final int n2 = n &= 0x70;
        if (n2 != 16 && (n = n2) != 48 && (n = n2) != 80) {
            n = (this.H & 0x70);
        }
        return n;
    }
    
    private int s(final View view) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        return androidx.core.view.i.b(viewGroup$MarginLayoutParams) + androidx.core.view.i.a(viewGroup$MarginLayoutParams);
    }
    
    private int t(final View view) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        return viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin;
    }
    
    private int u(final List<View> list, final int[] array) {
        int max = array[0];
        int max2 = array[1];
        final int size = list.size();
        int i = 0;
        int n = 0;
        while (i < size) {
            final View view = list.get(i);
            final e e = (e)view.getLayoutParams();
            final int n2 = e.leftMargin - max;
            final int n3 = e.rightMargin - max2;
            final int max3 = Math.max(0, n2);
            final int max4 = Math.max(0, n3);
            max = Math.max(0, -n2);
            max2 = Math.max(0, -n3);
            n += max3 + view.getMeasuredWidth() + max4;
            ++i;
        }
        return n;
    }
    
    private boolean z(final View view) {
        return view.getParent() == this || this.P.contains(view);
    }
    
    public boolean A() {
        final ActionMenuView a = this.a;
        return a != null && a.I();
    }
    
    public boolean B() {
        final ActionMenuView a = this.a;
        return a != null && a.J();
    }
    
    void I() {
        for (int i = this.getChildCount() - 1; i >= 0; --i) {
            final View child = this.getChildAt(i);
            if (((e)child.getLayoutParams()).b != 2 && child != this.a) {
                this.removeViewAt(i);
                this.P.add(child);
            }
        }
    }
    
    public void J(final int n, final int n2) {
        this.h();
        this.E.g(n, n2);
    }
    
    public void K(final g g, final ActionMenuPresenter actionMenuPresenter) {
        if (g == null && this.a == null) {
            return;
        }
        this.k();
        final g n = this.a.N();
        if (n == g) {
            return;
        }
        if (n != null) {
            n.Q(this.W);
            n.Q(this.a0);
        }
        if (this.a0 == null) {
            this.a0 = new d();
        }
        actionMenuPresenter.I(true);
        if (g != null) {
            g.c(actionMenuPresenter, this.j);
            g.c(this.a0, this.j);
        }
        else {
            actionMenuPresenter.k(this.j, null);
            this.a0.k(this.j, null);
            actionMenuPresenter.h(true);
            this.a0.h(true);
        }
        this.a.setPopupTheme(this.p);
        this.a.setPresenter(actionMenuPresenter);
        this.W = actionMenuPresenter;
    }
    
    public void L(final androidx.appcompat.view.menu.m.a b0, final g.a c0) {
        this.b0 = b0;
        this.c0 = c0;
        final ActionMenuView a = this.a;
        if (a != null) {
            a.O(b0, c0);
        }
    }
    
    public void M(final Context context, final int x) {
        this.x = x;
        final TextView c = this.c;
        if (c != null) {
            c.setTextAppearance(context, x);
        }
    }
    
    public void N(final Context context, final int w) {
        this.w = w;
        final TextView b = this.b;
        if (b != null) {
            b.setTextAppearance(context, w);
        }
    }
    
    public boolean Q() {
        final ActionMenuView a = this.a;
        return a != null && a.P();
    }
    
    void a() {
        for (int i = this.P.size() - 1; i >= 0; --i) {
            this.addView((View)this.P.get(i));
        }
        this.P.clear();
    }
    
    public void addMenuProvider(final o o) {
        this.R.c(o);
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return super.checkLayoutParams(viewGroup$LayoutParams) && viewGroup$LayoutParams instanceof e;
    }
    
    public boolean d() {
        if (this.getVisibility() == 0) {
            final ActionMenuView a = this.a;
            if (a != null && a.K()) {
                return true;
            }
        }
        return false;
    }
    
    public void e() {
        final d a0 = this.a0;
        androidx.appcompat.view.menu.i b;
        if (a0 == null) {
            b = null;
        }
        else {
            b = a0.b;
        }
        if (b != null) {
            b.collapseActionView();
        }
    }
    
    public void f() {
        final ActionMenuView a = this.a;
        if (a != null) {
            a.B();
        }
    }
    
    void g() {
        if (this.h == null) {
            (this.h = new l(this.getContext(), null, d.a.O)).setImageDrawable(this.f);
            this.h.setContentDescription(this.g);
            final e m = this.m();
            m.a = (0x800003 | (this.y & 0x70));
            m.b = 2;
            this.h.setLayoutParams((ViewGroup$LayoutParams)m);
            this.h.setOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
                final Toolbar a;
                
                public void onClick(final View view) {
                    this.a.e();
                }
            });
        }
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.m();
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.n(set);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)this.o(viewGroup$LayoutParams);
    }
    
    public CharSequence getCollapseContentDescription() {
        final ImageButton h = this.h;
        CharSequence contentDescription;
        if (h != null) {
            contentDescription = h.getContentDescription();
        }
        else {
            contentDescription = null;
        }
        return contentDescription;
    }
    
    public Drawable getCollapseIcon() {
        final ImageButton h = this.h;
        Drawable drawable;
        if (h != null) {
            drawable = h.getDrawable();
        }
        else {
            drawable = null;
        }
        return drawable;
    }
    
    public int getContentInsetEnd() {
        final j0 e = this.E;
        int a;
        if (e != null) {
            a = e.a();
        }
        else {
            a = 0;
        }
        return a;
    }
    
    public int getContentInsetEndWithActions() {
        int n = this.G;
        if (n == Integer.MIN_VALUE) {
            n = this.getContentInsetEnd();
        }
        return n;
    }
    
    public int getContentInsetLeft() {
        final j0 e = this.E;
        int b;
        if (e != null) {
            b = e.b();
        }
        else {
            b = 0;
        }
        return b;
    }
    
    public int getContentInsetRight() {
        final j0 e = this.E;
        int c;
        if (e != null) {
            c = e.c();
        }
        else {
            c = 0;
        }
        return c;
    }
    
    public int getContentInsetStart() {
        final j0 e = this.E;
        int d;
        if (e != null) {
            d = e.d();
        }
        else {
            d = 0;
        }
        return d;
    }
    
    public int getContentInsetStartWithNavigation() {
        int n = this.F;
        if (n == Integer.MIN_VALUE) {
            n = this.getContentInsetStart();
        }
        return n;
    }
    
    public int getCurrentContentInsetEnd() {
        final ActionMenuView a = this.a;
        boolean b = false;
        Label_0032: {
            if (a != null) {
                final g n = a.N();
                if (n != null && n.hasVisibleItems()) {
                    b = true;
                    break Label_0032;
                }
            }
            b = false;
        }
        int n2;
        if (b) {
            n2 = Math.max(this.getContentInsetEnd(), Math.max(this.G, 0));
        }
        else {
            n2 = this.getContentInsetEnd();
        }
        return n2;
    }
    
    public int getCurrentContentInsetLeft() {
        int n;
        if (androidx.core.view.b0.B((View)this) == 1) {
            n = this.getCurrentContentInsetEnd();
        }
        else {
            n = this.getCurrentContentInsetStart();
        }
        return n;
    }
    
    public int getCurrentContentInsetRight() {
        int n;
        if (androidx.core.view.b0.B((View)this) == 1) {
            n = this.getCurrentContentInsetStart();
        }
        else {
            n = this.getCurrentContentInsetEnd();
        }
        return n;
    }
    
    public int getCurrentContentInsetStart() {
        int n;
        if (this.getNavigationIcon() != null) {
            n = Math.max(this.getContentInsetStart(), Math.max(this.F, 0));
        }
        else {
            n = this.getContentInsetStart();
        }
        return n;
    }
    
    public Drawable getLogo() {
        final ImageView e = this.e;
        Drawable drawable;
        if (e != null) {
            drawable = e.getDrawable();
        }
        else {
            drawable = null;
        }
        return drawable;
    }
    
    public CharSequence getLogoDescription() {
        final ImageView e = this.e;
        CharSequence contentDescription;
        if (e != null) {
            contentDescription = e.getContentDescription();
        }
        else {
            contentDescription = null;
        }
        return contentDescription;
    }
    
    public Menu getMenu() {
        this.j();
        return this.a.getMenu();
    }
    
    View getNavButtonView() {
        return (View)this.d;
    }
    
    public CharSequence getNavigationContentDescription() {
        final ImageButton d = this.d;
        CharSequence contentDescription;
        if (d != null) {
            contentDescription = d.getContentDescription();
        }
        else {
            contentDescription = null;
        }
        return contentDescription;
    }
    
    public Drawable getNavigationIcon() {
        final ImageButton d = this.d;
        Drawable drawable;
        if (d != null) {
            drawable = d.getDrawable();
        }
        else {
            drawable = null;
        }
        return drawable;
    }
    
    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.W;
    }
    
    public Drawable getOverflowIcon() {
        this.j();
        return this.a.getOverflowIcon();
    }
    
    Context getPopupContext() {
        return this.j;
    }
    
    public int getPopupTheme() {
        return this.p;
    }
    
    public CharSequence getSubtitle() {
        return this.J;
    }
    
    final TextView getSubtitleTextView() {
        return this.c;
    }
    
    public CharSequence getTitle() {
        return this.I;
    }
    
    public int getTitleMarginBottom() {
        return this.D;
    }
    
    public int getTitleMarginEnd() {
        return this.B;
    }
    
    public int getTitleMarginStart() {
        return this.A;
    }
    
    public int getTitleMarginTop() {
        return this.C;
    }
    
    final TextView getTitleTextView() {
        return this.b;
    }
    
    public z getWrapper() {
        if (this.V == null) {
            this.V = new t0(this, true);
        }
        return this.V;
    }
    
    protected e m() {
        return new e(-2, -2);
    }
    
    public e n(final AttributeSet set) {
        return new e(this.getContext(), set);
    }
    
    protected e o(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof e) {
            return new e((e)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof androidx.appcompat.app.a.a) {
            return new e((androidx.appcompat.app.a.a)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return new e((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return new e(viewGroup$LayoutParams);
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.e0);
    }
    
    public boolean onHoverEvent(final MotionEvent motionEvent) {
        final int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.N = false;
        }
        if (!this.N) {
            final boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.N = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.N = false;
        }
        return true;
    }
    
    protected void onLayout(final boolean b, int i, int j, int n, int n2) {
        final boolean b2 = androidx.core.view.b0.B((View)this) == 1;
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int paddingLeft = this.getPaddingLeft();
        final int paddingRight = this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int paddingBottom = this.getPaddingBottom();
        final int n3 = width - paddingRight;
        final int[] q = this.Q;
        q[q[1] = 0] = 0;
        i = androidx.core.view.b0.C((View)this);
        int min;
        if (i >= 0) {
            min = Math.min(i, n2 - j);
        }
        else {
            min = 0;
        }
        Label_0167: {
            if (this.P((View)this.d)) {
                if (b2) {
                    n2 = this.D((View)this.d, n3, q, min);
                    n = paddingLeft;
                    break Label_0167;
                }
                n = this.C((View)this.d, paddingLeft, q, min);
            }
            else {
                n = paddingLeft;
            }
            n2 = n3;
        }
        i = n;
        j = n2;
        if (this.P((View)this.h)) {
            if (b2) {
                j = this.D((View)this.h, n2, q, min);
                i = n;
            }
            else {
                i = this.C((View)this.h, n, q, min);
                j = n2;
            }
        }
        n2 = i;
        n = j;
        if (this.P((View)this.a)) {
            if (b2) {
                n2 = this.C((View)this.a, i, q, min);
                n = j;
            }
            else {
                n = this.D((View)this.a, j, q, min);
                n2 = i;
            }
        }
        j = this.getCurrentContentInsetLeft();
        i = this.getCurrentContentInsetRight();
        q[0] = Math.max(0, j - n2);
        q[1] = Math.max(0, i - (n3 - n));
        j = Math.max(n2, j);
        n = Math.min(n, n3 - i);
        n2 = j;
        i = n;
        if (this.P(this.i)) {
            if (b2) {
                i = this.D(this.i, n, q, min);
                n2 = j;
            }
            else {
                n2 = this.C(this.i, j, q, min);
                i = n;
            }
        }
        n = n2;
        j = i;
        if (this.P((View)this.e)) {
            if (b2) {
                j = this.D((View)this.e, i, q, min);
                n = n2;
            }
            else {
                n = this.C((View)this.e, n2, q, min);
                j = i;
            }
        }
        final boolean p5 = this.P((View)this.b);
        final boolean p6 = this.P((View)this.c);
        if (p5) {
            final e e = (e)this.b.getLayoutParams();
            i = e.topMargin + this.b.getMeasuredHeight() + e.bottomMargin + 0;
        }
        else {
            i = 0;
        }
        if (p6) {
            final e e2 = (e)this.c.getLayoutParams();
            i += e2.topMargin + this.c.getMeasuredHeight() + e2.bottomMargin;
        }
        Label_1309: {
            if (!p5 && !p6) {
                i = n;
            }
            else {
                TextView textView;
                if (p5) {
                    textView = this.b;
                }
                else {
                    textView = this.c;
                }
                TextView textView2;
                if (p6) {
                    textView2 = this.c;
                }
                else {
                    textView2 = this.b;
                }
                final e e3 = (e)((View)textView).getLayoutParams();
                final e e4 = (e)((View)textView2).getLayoutParams();
                if ((p5 && this.b.getMeasuredWidth() > 0) || (p6 && this.c.getMeasuredWidth() > 0)) {
                    n2 = 1;
                }
                else {
                    n2 = 0;
                }
                final int n4 = this.H & 0x70;
                if (n4 != 48) {
                    if (n4 != 80) {
                        final int n5 = (height - paddingTop - paddingBottom - i) / 2;
                        final int topMargin = e3.topMargin;
                        final int c = this.C;
                        if (n5 < topMargin + c) {
                            i = topMargin + c;
                        }
                        else {
                            final int n6 = height - paddingBottom - i - n5 - paddingTop;
                            final int bottomMargin = e3.bottomMargin;
                            final int d = this.D;
                            i = n5;
                            if (n6 < bottomMargin + d) {
                                i = Math.max(0, n5 - (e4.bottomMargin + d - n6));
                            }
                        }
                        i += paddingTop;
                    }
                    else {
                        i = height - paddingBottom - e4.bottomMargin - this.D - i;
                    }
                }
                else {
                    i = this.getPaddingTop() + e3.topMargin + this.C;
                }
                if (b2) {
                    int a;
                    if (n2 != 0) {
                        a = this.A;
                    }
                    else {
                        a = 0;
                    }
                    final int n7 = a - q[1];
                    j -= Math.max(0, n7);
                    q[1] = Math.max(0, -n7);
                    int n10;
                    if (p5) {
                        final e e5 = (e)this.b.getLayoutParams();
                        final int n8 = j - this.b.getMeasuredWidth();
                        final int n9 = this.b.getMeasuredHeight() + i;
                        this.b.layout(n8, i, j, n9);
                        i = n8 - this.B;
                        n10 = n9 + e5.bottomMargin;
                    }
                    else {
                        final int n11 = j;
                        n10 = i;
                        i = n11;
                    }
                    int n13;
                    if (p6) {
                        final int n12 = n10 + ((e)this.c.getLayoutParams()).topMargin;
                        this.c.layout(j - this.c.getMeasuredWidth(), n12, j, this.c.getMeasuredHeight() + n12);
                        n13 = j - this.B;
                    }
                    else {
                        n13 = j;
                    }
                    if (n2 != 0) {
                        j = Math.min(i, n13);
                    }
                    i = n;
                }
                else {
                    int a2;
                    if (n2 != 0) {
                        a2 = this.A;
                    }
                    else {
                        a2 = 0;
                    }
                    final int n14 = a2 - q[0];
                    n += Math.max(0, n14);
                    q[0] = Math.max(0, -n14);
                    int n17;
                    if (p5) {
                        final e e6 = (e)this.b.getLayoutParams();
                        final int n15 = this.b.getMeasuredWidth() + n;
                        final int n16 = this.b.getMeasuredHeight() + i;
                        this.b.layout(n, i, n15, n16);
                        n17 = n15 + this.B;
                        i = n16 + e6.bottomMargin;
                    }
                    else {
                        n17 = n;
                    }
                    int n19;
                    if (p6) {
                        i += ((e)this.c.getLayoutParams()).topMargin;
                        final int n18 = this.c.getMeasuredWidth() + n;
                        this.c.layout(n, i, n18, this.c.getMeasuredHeight() + i);
                        n19 = n18 + this.B;
                    }
                    else {
                        n19 = n;
                    }
                    i = n;
                    n = j;
                    if (n2 != 0) {
                        i = Math.max(n17, n19);
                        n = j;
                    }
                    break Label_1309;
                }
            }
            n = j;
        }
        n2 = 0;
        this.b(this.O, 3);
        int size;
        for (size = this.O.size(), j = 0; j < size; ++j) {
            i = this.C(this.O.get(j), i, q, min);
        }
        this.b(this.O, 5);
        int size2;
        for (size2 = this.O.size(), j = 0; j < size2; ++j) {
            n = this.D(this.O.get(j), n, q, min);
        }
        this.b(this.O, 1);
        final int u = this.u(this.O, q);
        j = paddingLeft + (width - paddingLeft - paddingRight) / 2 - u / 2;
        final int n20 = u + j;
        if (j >= i) {
            if (n20 > n) {
                i = j - (n20 - n);
            }
            else {
                i = j;
            }
        }
        n = this.O.size();
        j = i;
        for (i = n2; i < n; ++i) {
            j = this.C(this.O.get(i), j, q, min);
        }
        this.O.clear();
    }
    
    protected void onMeasure(int resolveSizeAndState, final int n) {
        final int[] q = this.Q;
        final int b = w0.b((View)this) ? 1 : 0;
        final int n2 = 0;
        int n3;
        int max;
        int combineMeasuredStates;
        if (this.P((View)this.d)) {
            this.F((View)this.d, resolveSizeAndState, 0, n, 0, this.z);
            n3 = this.d.getMeasuredWidth() + this.s((View)this.d);
            max = Math.max(0, this.d.getMeasuredHeight() + this.t((View)this.d));
            combineMeasuredStates = View.combineMeasuredStates(0, this.d.getMeasuredState());
        }
        else {
            n3 = 0;
            max = (combineMeasuredStates = 0);
        }
        int n4 = n3;
        int n5 = max;
        int n6 = combineMeasuredStates;
        if (this.P((View)this.h)) {
            this.F((View)this.h, resolveSizeAndState, 0, n, 0, this.z);
            n4 = this.h.getMeasuredWidth() + this.s((View)this.h);
            n5 = Math.max(max, this.h.getMeasuredHeight() + this.t((View)this.h));
            n6 = View.combineMeasuredStates(combineMeasuredStates, this.h.getMeasuredState());
        }
        final int currentContentInsetStart = this.getCurrentContentInsetStart();
        final int n7 = 0 + Math.max(currentContentInsetStart, n4);
        q[b] = Math.max(0, currentContentInsetStart - n4);
        int n8;
        if (this.P((View)this.a)) {
            this.F((View)this.a, resolveSizeAndState, n7, n, 0, this.z);
            n8 = this.a.getMeasuredWidth() + this.s((View)this.a);
            n5 = Math.max(n5, this.a.getMeasuredHeight() + this.t((View)this.a));
            n6 = View.combineMeasuredStates(n6, this.a.getMeasuredState());
        }
        else {
            n8 = 0;
        }
        final int currentContentInsetEnd = this.getCurrentContentInsetEnd();
        final int n9 = n7 + Math.max(currentContentInsetEnd, n8);
        q[b ^ 0x1] = Math.max(0, currentContentInsetEnd - n8);
        int max2 = n5;
        int combineMeasuredStates2 = n6;
        int n10 = n9;
        if (this.P(this.i)) {
            n10 = n9 + this.E(this.i, resolveSizeAndState, n9, n, 0, q);
            max2 = Math.max(n5, this.i.getMeasuredHeight() + this.t(this.i));
            combineMeasuredStates2 = View.combineMeasuredStates(n6, this.i.getMeasuredState());
        }
        int max3 = max2;
        int n11 = combineMeasuredStates2;
        int n12 = n10;
        if (this.P((View)this.e)) {
            n12 = n10 + this.E((View)this.e, resolveSizeAndState, n10, n, 0, q);
            max3 = Math.max(max2, this.e.getMeasuredHeight() + this.t((View)this.e));
            n11 = View.combineMeasuredStates(combineMeasuredStates2, this.e.getMeasuredState());
        }
        final int childCount = this.getChildCount();
        final int n13 = 0;
        int n14 = max3;
        int max4;
        int combineMeasuredStates3;
        int n15;
        for (int i = n13; i < childCount; ++i, n14 = max4, n11 = combineMeasuredStates3, n12 = n15) {
            final View child = this.getChildAt(i);
            max4 = n14;
            combineMeasuredStates3 = n11;
            n15 = n12;
            if (((e)child.getLayoutParams()).b == 0) {
                if (!this.P(child)) {
                    max4 = n14;
                    combineMeasuredStates3 = n11;
                    n15 = n12;
                }
                else {
                    n15 = n12 + this.E(child, resolveSizeAndState, n12, n, 0, q);
                    max4 = Math.max(n14, child.getMeasuredHeight() + this.t(child));
                    combineMeasuredStates3 = View.combineMeasuredStates(n11, child.getMeasuredState());
                }
            }
        }
        final int n16 = this.C + this.D;
        final int n17 = this.A + this.B;
        int n18;
        int max5;
        if (this.P((View)this.b)) {
            this.E((View)this.b, resolveSizeAndState, n12 + n17, n, n16, q);
            final int measuredWidth = this.b.getMeasuredWidth();
            final int s = this.s((View)this.b);
            final int measuredHeight = this.b.getMeasuredHeight();
            final int t = this.t((View)this.b);
            n11 = View.combineMeasuredStates(n11, this.b.getMeasuredState());
            n18 = measuredHeight + t;
            max5 = measuredWidth + s;
        }
        else {
            n18 = 0;
            max5 = 0;
        }
        if (this.P((View)this.c)) {
            max5 = Math.max(max5, this.E((View)this.c, resolveSizeAndState, n12 + n17, n, n18 + n16, q));
            n18 += this.c.getMeasuredHeight() + this.t((View)this.c);
            n11 = View.combineMeasuredStates(n11, this.c.getMeasuredState());
        }
        final int max6 = Math.max(n14, n18);
        final int paddingLeft = this.getPaddingLeft();
        final int paddingRight = this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int paddingBottom = this.getPaddingBottom();
        final int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(n12 + max5 + (paddingLeft + paddingRight), this.getSuggestedMinimumWidth()), resolveSizeAndState, 0xFF000000 & n11);
        resolveSizeAndState = View.resolveSizeAndState(Math.max(max6 + (paddingTop + paddingBottom), this.getSuggestedMinimumHeight()), n, n11 << 16);
        if (this.O()) {
            resolveSizeAndState = n2;
        }
        this.setMeasuredDimension(resolveSizeAndState2, resolveSizeAndState);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.a());
        final ActionMenuView a = this.a;
        Object n;
        if (a != null) {
            n = a.N();
        }
        else {
            n = null;
        }
        final int c = savedState.c;
        if (c != 0 && this.a0 != null && n != null) {
            final MenuItem item = ((Menu)n).findItem(c);
            if (item != null) {
                item.expandActionView();
            }
        }
        if (savedState.d) {
            this.H();
        }
    }
    
    public void onRtlPropertiesChanged(final int n) {
        super.onRtlPropertiesChanged(n);
        this.h();
        final j0 e = this.E;
        boolean b = true;
        if (n != 1) {
            b = false;
        }
        e.f(b);
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        final d a0 = this.a0;
        if (a0 != null) {
            final androidx.appcompat.view.menu.i b = a0.b;
            if (b != null) {
                savedState.c = b.getItemId();
            }
        }
        savedState.d = this.B();
        return (Parcelable)savedState;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.M = false;
        }
        if (!this.M) {
            final boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.M = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.M = false;
        }
        return true;
    }
    
    public void removeMenuProvider(final o o) {
        this.R.l(o);
    }
    
    public void setCollapseContentDescription(final int n) {
        CharSequence text;
        if (n != 0) {
            text = this.getContext().getText(n);
        }
        else {
            text = null;
        }
        this.setCollapseContentDescription(text);
    }
    
    public void setCollapseContentDescription(final CharSequence contentDescription) {
        if (!TextUtils.isEmpty(contentDescription)) {
            this.g();
        }
        final ImageButton h = this.h;
        if (h != null) {
            h.setContentDescription(contentDescription);
        }
    }
    
    public void setCollapseIcon(final int n) {
        this.setCollapseIcon(e.a.b(this.getContext(), n));
    }
    
    public void setCollapseIcon(final Drawable imageDrawable) {
        if (imageDrawable != null) {
            this.g();
            this.h.setImageDrawable(imageDrawable);
        }
        else {
            final ImageButton h = this.h;
            if (h != null) {
                h.setImageDrawable(this.f);
            }
        }
    }
    
    public void setCollapsible(final boolean d0) {
        this.d0 = d0;
        this.requestLayout();
    }
    
    public void setContentInsetEndWithActions(final int n) {
        int g = n;
        if (n < 0) {
            g = Integer.MIN_VALUE;
        }
        if (g != this.G) {
            this.G = g;
            if (this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }
    
    public void setContentInsetStartWithNavigation(final int n) {
        int f = n;
        if (n < 0) {
            f = Integer.MIN_VALUE;
        }
        if (f != this.F) {
            this.F = f;
            if (this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }
    
    public void setLogo(final int n) {
        this.setLogo(e.a.b(this.getContext(), n));
    }
    
    public void setLogo(final Drawable imageDrawable) {
        if (imageDrawable != null) {
            this.i();
            if (!this.z((View)this.e)) {
                this.c((View)this.e, true);
            }
        }
        else {
            final ImageView e = this.e;
            if (e != null && this.z((View)e)) {
                this.removeView((View)this.e);
                this.P.remove(this.e);
            }
        }
        final ImageView e2 = this.e;
        if (e2 != null) {
            e2.setImageDrawable(imageDrawable);
        }
    }
    
    public void setLogoDescription(final int n) {
        this.setLogoDescription(this.getContext().getText(n));
    }
    
    public void setLogoDescription(final CharSequence contentDescription) {
        if (!TextUtils.isEmpty(contentDescription)) {
            this.i();
        }
        final ImageView e = this.e;
        if (e != null) {
            e.setContentDescription(contentDescription);
        }
    }
    
    public void setNavigationContentDescription(final int n) {
        CharSequence text;
        if (n != 0) {
            text = this.getContext().getText(n);
        }
        else {
            text = null;
        }
        this.setNavigationContentDescription(text);
    }
    
    public void setNavigationContentDescription(final CharSequence contentDescription) {
        if (!TextUtils.isEmpty(contentDescription)) {
            this.l();
        }
        final ImageButton d = this.d;
        if (d != null) {
            d.setContentDescription(contentDescription);
            u0.a((View)this.d, contentDescription);
        }
    }
    
    public void setNavigationIcon(final int n) {
        this.setNavigationIcon(e.a.b(this.getContext(), n));
    }
    
    public void setNavigationIcon(final Drawable imageDrawable) {
        if (imageDrawable != null) {
            this.l();
            if (!this.z((View)this.d)) {
                this.c((View)this.d, true);
            }
        }
        else {
            final ImageButton d = this.d;
            if (d != null && this.z((View)d)) {
                this.removeView((View)this.d);
                this.P.remove(this.d);
            }
        }
        final ImageButton d2 = this.d;
        if (d2 != null) {
            d2.setImageDrawable(imageDrawable);
        }
    }
    
    public void setNavigationOnClickListener(final View$OnClickListener onClickListener) {
        this.l();
        this.d.setOnClickListener(onClickListener);
    }
    
    public void setOnMenuItemClickListener(final f t) {
        this.T = t;
    }
    
    public void setOverflowIcon(final Drawable overflowIcon) {
        this.j();
        this.a.setOverflowIcon(overflowIcon);
    }
    
    public void setPopupTheme(final int p) {
        if (this.p != p) {
            if ((this.p = p) == 0) {
                this.j = this.getContext();
            }
            else {
                this.j = (Context)new ContextThemeWrapper(this.getContext(), p);
            }
        }
    }
    
    public void setSubtitle(final int n) {
        this.setSubtitle(this.getContext().getText(n));
    }
    
    public void setSubtitle(final CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.c == null) {
                final Context context = this.getContext();
                (this.c = new AppCompatTextView(context)).setSingleLine();
                this.c.setEllipsize(TextUtils$TruncateAt.END);
                final int x = this.x;
                if (x != 0) {
                    this.c.setTextAppearance(context, x);
                }
                final ColorStateList l = this.L;
                if (l != null) {
                    this.c.setTextColor(l);
                }
            }
            if (!this.z((View)this.c)) {
                this.c((View)this.c, true);
            }
        }
        else {
            final TextView c = this.c;
            if (c != null && this.z((View)c)) {
                this.removeView((View)this.c);
                this.P.remove(this.c);
            }
        }
        final TextView c2 = this.c;
        if (c2 != null) {
            c2.setText(charSequence);
        }
        this.J = charSequence;
    }
    
    public void setSubtitleTextColor(final int n) {
        this.setSubtitleTextColor(ColorStateList.valueOf(n));
    }
    
    public void setSubtitleTextColor(final ColorStateList list) {
        this.L = list;
        final TextView c = this.c;
        if (c != null) {
            c.setTextColor(list);
        }
    }
    
    public void setTitle(final int n) {
        this.setTitle(this.getContext().getText(n));
    }
    
    public void setTitle(final CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.b == null) {
                final Context context = this.getContext();
                (this.b = new AppCompatTextView(context)).setSingleLine();
                this.b.setEllipsize(TextUtils$TruncateAt.END);
                final int w = this.w;
                if (w != 0) {
                    this.b.setTextAppearance(context, w);
                }
                final ColorStateList k = this.K;
                if (k != null) {
                    this.b.setTextColor(k);
                }
            }
            if (!this.z((View)this.b)) {
                this.c((View)this.b, true);
            }
        }
        else {
            final TextView b = this.b;
            if (b != null && this.z((View)b)) {
                this.removeView((View)this.b);
                this.P.remove(this.b);
            }
        }
        final TextView b2 = this.b;
        if (b2 != null) {
            b2.setText(charSequence);
        }
        this.I = charSequence;
    }
    
    public void setTitleMarginBottom(final int d) {
        this.D = d;
        this.requestLayout();
    }
    
    public void setTitleMarginEnd(final int b) {
        this.B = b;
        this.requestLayout();
    }
    
    public void setTitleMarginStart(final int a) {
        this.A = a;
        this.requestLayout();
    }
    
    public void setTitleMarginTop(final int c) {
        this.C = c;
        this.requestLayout();
    }
    
    public void setTitleTextColor(final int n) {
        this.setTitleTextColor(ColorStateList.valueOf(n));
    }
    
    public void setTitleTextColor(final ColorStateList list) {
        this.K = list;
        final TextView b = this.b;
        if (b != null) {
            b.setTextColor(list);
        }
    }
    
    public boolean v() {
        final d a0 = this.a0;
        return a0 != null && a0.b != null;
    }
    
    public boolean w() {
        final ActionMenuView a = this.a;
        return a != null && a.H();
    }
    
    public void x(final int n) {
        this.getMenuInflater().inflate(n, this.getMenu());
    }
    
    public void y() {
        final Iterator<MenuItem> iterator = this.S.iterator();
        while (iterator.hasNext()) {
            this.getMenu().removeItem(iterator.next().getItemId());
        }
        this.G();
    }
    
    public static class SavedState extends AbsSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        int c;
        boolean d;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$ClassLoaderCreator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel, null);
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
        
        public SavedState(final Parcel parcel, final ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readInt();
            this.d = (parcel.readInt() != 0);
        }
        
        public SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        @Override
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.c);
            parcel.writeInt((int)(this.d ? 1 : 0));
        }
    }
    
    private class d implements m
    {
        g a;
        androidx.appcompat.view.menu.i b;
        final Toolbar c;
        
        d(final Toolbar c) {
            this.c = c;
        }
        
        @Override
        public void b(final g g, final boolean b) {
        }
        
        @Override
        public boolean c(final g g, final androidx.appcompat.view.menu.i b) {
            this.c.g();
            final ViewParent parent = this.c.h.getParent();
            final Toolbar c = this.c;
            if (parent != c) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup)parent).removeView((View)c.h);
                }
                final Toolbar c2 = this.c;
                c2.addView((View)c2.h);
            }
            this.c.i = b.getActionView();
            this.b = b;
            final ViewParent parent2 = this.c.i.getParent();
            final Toolbar c3 = this.c;
            if (parent2 != c3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup)parent2).removeView(c3.i);
                }
                final e m = this.c.m();
                final Toolbar c4 = this.c;
                m.a = (0x800003 | (c4.y & 0x70));
                m.b = 2;
                c4.i.setLayoutParams((ViewGroup$LayoutParams)m);
                final Toolbar c5 = this.c;
                c5.addView(c5.i);
            }
            this.c.I();
            this.c.requestLayout();
            b.r(true);
            final View i = this.c.i;
            if (i instanceof c) {
                ((c)i).b();
            }
            return true;
        }
        
        @Override
        public void e(final Parcelable parcelable) {
        }
        
        @Override
        public boolean f(final r r) {
            return false;
        }
        
        @Override
        public Parcelable g() {
            return null;
        }
        
        @Override
        public int getId() {
            return 0;
        }
        
        @Override
        public void h(final boolean b) {
            if (this.b != null) {
                final g a = this.a;
                int n = 0;
                if (a != null) {
                    final int size = a.size();
                    int n2 = 0;
                    while (true) {
                        n = n;
                        if (n2 >= size) {
                            break;
                        }
                        if (this.a.getItem(n2) == this.b) {
                            n = 1;
                            break;
                        }
                        ++n2;
                    }
                }
                if (n == 0) {
                    this.j(this.a, this.b);
                }
            }
        }
        
        @Override
        public boolean i() {
            return false;
        }
        
        @Override
        public boolean j(final g g, final androidx.appcompat.view.menu.i i) {
            final View j = this.c.i;
            if (j instanceof c) {
                ((c)j).f();
            }
            final Toolbar c = this.c;
            c.removeView(c.i);
            final Toolbar c2 = this.c;
            c2.removeView((View)c2.h);
            final Toolbar c3 = this.c;
            c3.i = null;
            c3.a();
            this.b = null;
            this.c.requestLayout();
            i.r(false);
            return true;
        }
        
        @Override
        public void k(final Context context, final g a) {
            final g a2 = this.a;
            if (a2 != null) {
                final androidx.appcompat.view.menu.i b = this.b;
                if (b != null) {
                    a2.f(b);
                }
            }
            this.a = a;
        }
    }
    
    public static class e extends a
    {
        int b;
        
        public e(final int n, final int n2) {
            super(n, n2);
            this.b = 0;
            super.a = 8388627;
        }
        
        public e(final Context context, final AttributeSet set) {
            super(context, set);
            this.b = 0;
        }
        
        public e(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
            this.b = 0;
        }
        
        public e(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            super((ViewGroup$LayoutParams)viewGroup$MarginLayoutParams);
            this.b = 0;
            this.a(viewGroup$MarginLayoutParams);
        }
        
        public e(final a a) {
            super(a);
            this.b = 0;
        }
        
        public e(final e e) {
            super((a)e);
            this.b = 0;
            this.b = e.b;
        }
        
        void a(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            super.leftMargin = viewGroup$MarginLayoutParams.leftMargin;
            super.topMargin = viewGroup$MarginLayoutParams.topMargin;
            super.rightMargin = viewGroup$MarginLayoutParams.rightMargin;
            super.bottomMargin = viewGroup$MarginLayoutParams.bottomMargin;
        }
    }
    
    public interface f
    {
        boolean onMenuItemClick(final MenuItem p0);
    }
}
