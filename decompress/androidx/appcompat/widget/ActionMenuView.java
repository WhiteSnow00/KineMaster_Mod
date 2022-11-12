// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.ViewDebug$ExportedProperty;
import android.view.ContextThemeWrapper;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.accessibility.AccessibilityEvent;
import android.view.MenuItem;
import androidx.appcompat.view.menu.i;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import android.view.View$MeasureSpec;
import android.view.View;
import android.util.AttributeSet;
import androidx.appcompat.view.menu.m;
import android.content.Context;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.g;

public class ActionMenuView extends LinearLayoutCompat implements g.b, n
{
    private g A;
    private Context B;
    private int C;
    private boolean D;
    private ActionMenuPresenter E;
    private m.a F;
    g.a G;
    private boolean H;
    private int I;
    private int J;
    private int K;
    e L;
    
    public ActionMenuView(final Context context) {
        this(context, null);
    }
    
    public ActionMenuView(final Context b, final AttributeSet set) {
        super(b, set);
        this.setBaselineAligned(false);
        final float density = b.getResources().getDisplayMetrics().density;
        this.J = (int)(56.0f * density);
        this.K = (int)(density * 4.0f);
        this.B = b;
        this.C = 0;
    }
    
    static int L(final View view, final int n, int b, int n2, int n3) {
        final c c = (c)view.getLayoutParams();
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(View$MeasureSpec.getSize(n2) - n3, View$MeasureSpec.getMode(n2));
        ActionMenuItemView actionMenuItemView;
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView)view;
        }
        else {
            actionMenuItemView = null;
        }
        boolean d = true;
        if (actionMenuItemView != null && actionMenuItemView.f()) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        n3 = 2;
        if (b > 0 && (n2 == 0 || b >= 2)) {
            view.measure(View$MeasureSpec.makeMeasureSpec(b * n, Integer.MIN_VALUE), measureSpec);
            final int measuredWidth = view.getMeasuredWidth();
            final int n4 = b = measuredWidth / n;
            if (measuredWidth % n != 0) {
                b = n4 + 1;
            }
            if (n2 != 0 && b < 2) {
                b = n3;
            }
        }
        else {
            b = 0;
        }
        if (c.a || n2 == 0) {
            d = false;
        }
        c.d = d;
        c.b = b;
        view.measure(View$MeasureSpec.makeMeasureSpec(n * b, 1073741824), measureSpec);
        return b;
    }
    
    private void M(int i, int k) {
        final int mode = View$MeasureSpec.getMode(k);
        final int size = View$MeasureSpec.getSize(i);
        final int size2 = View$MeasureSpec.getSize(k);
        final int paddingLeft = this.getPaddingLeft();
        i = this.getPaddingRight();
        final int n = this.getPaddingTop() + this.getPaddingBottom();
        final int childMeasureSpec = ViewGroup.getChildMeasureSpec(k, n, -2);
        final int n2 = size - (paddingLeft + i);
        i = this.J;
        final int n3 = n2 / i;
        if (n3 == 0) {
            this.setMeasuredDimension(n2, 0);
            return;
        }
        final int n4 = i + n2 % i / n3;
        final int childCount = this.getChildCount();
        int max = 0;
        int j = 0;
        int n5 = i = j;
        int n6;
        k = (n6 = i);
        long n7 = 0L;
        int max2 = k;
        int n8 = i;
        i = n3;
        while (j < childCount) {
            final View child = this.getChildAt(j);
            if (child.getVisibility() == 8) {
                k = n6;
            }
            else {
                final boolean b = child instanceof ActionMenuItemView;
                ++n8;
                if (b) {
                    k = this.K;
                    child.setPadding(k, 0, k, 0);
                }
                final c c = (c)child.getLayoutParams();
                c.f = false;
                c.c = 0;
                c.b = 0;
                c.d = false;
                c.leftMargin = 0;
                c.rightMargin = 0;
                c.e = (b && ((ActionMenuItemView)child).f());
                if (c.a) {
                    k = 1;
                }
                else {
                    k = i;
                }
                final int l = L(child, n4, k, childMeasureSpec, n);
                max2 = Math.max(max2, l);
                k = n6;
                if (c.d) {
                    k = n6 + 1;
                }
                if (c.a) {
                    n5 = 1;
                }
                i -= l;
                max = Math.max(max, child.getMeasuredHeight());
                if (l == 1) {
                    n7 |= 1 << j;
                }
            }
            ++j;
            n6 = k;
        }
        final boolean b2 = n5 != 0 && n8 == 2;
        k = 0;
        int n9 = i;
        final boolean b3 = b2;
        final int n10 = n2;
        while (true) {
            while (n6 > 0 && n9 > 0) {
                int n11 = Integer.MAX_VALUE;
                int n12 = 0;
                int n13 = 0;
                long n14 = 0L;
                while (n13 < childCount) {
                    final c c2 = (c)this.getChildAt(n13).getLayoutParams();
                    int n15;
                    long n16;
                    if (!c2.d) {
                        i = n12;
                        n15 = n11;
                        n16 = n14;
                    }
                    else {
                        final int b4 = c2.b;
                        if (b4 < n11) {
                            n16 = 1L << n13;
                            n15 = b4;
                            i = 1;
                        }
                        else {
                            i = n12;
                            n15 = n11;
                            n16 = n14;
                            if (b4 == n11) {
                                i = n12 + 1;
                                n16 = (n14 | 1L << n13);
                                n15 = n11;
                            }
                        }
                    }
                    ++n13;
                    n12 = i;
                    n11 = n15;
                    n14 = n16;
                }
                i = k;
                k = max;
                n7 |= n14;
                if (n12 > n9) {
                    final boolean b5 = n5 == 0 && n8 == 1;
                    int n22;
                    if (n9 > 0 && n7 != 0L && (n9 < n8 - 1 || b5 || max2 > 1)) {
                        float n17 = (float)Long.bitCount(n7);
                        if (!b5) {
                            float n18 = n17;
                            if ((n7 & 0x1L) != 0x0L) {
                                n18 = n17;
                                if (!((c)this.getChildAt(0).getLayoutParams()).e) {
                                    n18 = n17 - 0.5f;
                                }
                            }
                            final int n19 = childCount - 1;
                            n17 = n18;
                            if ((n7 & (long)(1 << n19)) != 0x0L) {
                                n17 = n18;
                                if (!((c)this.getChildAt(n19).getLayoutParams()).e) {
                                    n17 = n18 - 0.5f;
                                }
                            }
                        }
                        int n20;
                        if (n17 > 0.0f) {
                            n20 = (int)(n9 * n4 / n17);
                        }
                        else {
                            n20 = 0;
                        }
                        int n21 = 0;
                        while (true) {
                            n22 = i;
                            if (n21 >= childCount) {
                                break;
                            }
                            int n23;
                            if ((n7 & (long)(1 << n21)) == 0x0L) {
                                n23 = i;
                            }
                            else {
                                final View child2 = this.getChildAt(n21);
                                final c c3 = (c)child2.getLayoutParams();
                                if (child2 instanceof ActionMenuItemView) {
                                    c3.c = n20;
                                    c3.f = true;
                                    if (n21 == 0 && !c3.e) {
                                        c3.leftMargin = -n20 / 2;
                                    }
                                    n23 = 1;
                                }
                                else if (c3.a) {
                                    c3.c = n20;
                                    c3.f = true;
                                    c3.rightMargin = -n20 / 2;
                                    n23 = 1;
                                }
                                else {
                                    if (n21 != 0) {
                                        c3.leftMargin = n20 / 2;
                                    }
                                    n23 = i;
                                    if (n21 != childCount - 1) {
                                        c3.rightMargin = n20 / 2;
                                        n23 = i;
                                    }
                                }
                            }
                            ++n21;
                            i = n23;
                        }
                    }
                    else {
                        n22 = i;
                    }
                    if (n22 != 0) {
                        View child3;
                        c c4;
                        for (i = 0; i < childCount; ++i) {
                            child3 = this.getChildAt(i);
                            c4 = (c)child3.getLayoutParams();
                            if (c4.f) {
                                child3.measure(View$MeasureSpec.makeMeasureSpec(c4.b * n4 + c4.c, 1073741824), childMeasureSpec);
                            }
                        }
                    }
                    if (mode == 1073741824) {
                        k = size2;
                    }
                    this.setMeasuredDimension(n10, k);
                    return;
                }
                View child4;
                c c5;
                long n24;
                long n25;
                int m;
                for (i = 0; i < childCount; ++i) {
                    child4 = this.getChildAt(i);
                    c5 = (c)child4.getLayoutParams();
                    n24 = 1 << i;
                    if ((n14 & n24) == 0x0L) {
                        n25 = n7;
                        if (c5.b == n11 + 1) {
                            n25 = (n7 | n24);
                        }
                        n7 = n25;
                    }
                    else {
                        if (b3 && c5.e && n9 == 1) {
                            m = this.K;
                            child4.setPadding(m + n4, 0, m, 0);
                        }
                        ++c5.b;
                        c5.f = true;
                        --n9;
                    }
                }
                max = k;
                k = 1;
            }
            i = k;
            k = max;
            continue;
        }
    }
    
    public void B() {
        final ActionMenuPresenter e = this.E;
        if (e != null) {
            e.A();
        }
    }
    
    protected c C() {
        final c c = new c(-2, -2);
        c.gravity = 16;
        return c;
    }
    
    public c D(final AttributeSet set) {
        return new c(this.getContext(), set);
    }
    
    protected c E(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams != null) {
            c c;
            if (viewGroup$LayoutParams instanceof c) {
                c = new c((c)viewGroup$LayoutParams);
            }
            else {
                c = new c(viewGroup$LayoutParams);
            }
            if (c.gravity <= 0) {
                c.gravity = 16;
            }
            return c;
        }
        return this.C();
    }
    
    public c F() {
        final c c = this.C();
        c.a = true;
        return c;
    }
    
    protected boolean G(final int n) {
        final boolean b = false;
        if (n == 0) {
            return false;
        }
        final View child = this.getChildAt(n - 1);
        final View child2 = this.getChildAt(n);
        boolean b2 = b;
        if (n < this.getChildCount()) {
            b2 = b;
            if (child instanceof a) {
                b2 = (false | ((a)child).a());
            }
        }
        boolean b3 = b2;
        if (n > 0) {
            b3 = b2;
            if (child2 instanceof a) {
                b3 = (b2 | ((a)child2).b());
            }
        }
        return b3;
    }
    
    public boolean H() {
        final ActionMenuPresenter e = this.E;
        return e != null && e.D();
    }
    
    public boolean I() {
        final ActionMenuPresenter e = this.E;
        return e != null && e.F();
    }
    
    public boolean J() {
        final ActionMenuPresenter e = this.E;
        return e != null && e.G();
    }
    
    public boolean K() {
        return this.D;
    }
    
    public g N() {
        return this.A;
    }
    
    public void O(final m.a f, final g.a g) {
        this.F = f;
        this.G = g;
    }
    
    public boolean P() {
        final ActionMenuPresenter e = this.E;
        return e != null && e.M();
    }
    
    @Override
    public void a(final g a) {
        this.A = a;
    }
    
    @Override
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof c;
    }
    
    @Override
    public boolean d(final i i) {
        return this.A.N((MenuItem)i, 0);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        return false;
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.C();
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.D(set);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)this.E(viewGroup$LayoutParams);
    }
    
    public Menu getMenu() {
        if (this.A == null) {
            final Context context = this.getContext();
            (this.A = new g(context)).V((g.a)new d());
            (this.E = new ActionMenuPresenter(context)).L(true);
            final ActionMenuPresenter e = this.E;
            m.a f = this.F;
            if (f == null) {
                f = new b();
            }
            e.d(f);
            this.A.c(this.E, this.B);
            this.E.J(this);
        }
        return (Menu)this.A;
    }
    
    public Drawable getOverflowIcon() {
        this.getMenu();
        return this.E.C();
    }
    
    public int getPopupTheme() {
        return this.C;
    }
    
    public int getWindowAnimations() {
        return 0;
    }
    
    @Override
    protected /* bridge */ LinearLayoutCompat.a m() {
        return this.C();
    }
    
    @Override
    public /* bridge */ LinearLayoutCompat.a n(final AttributeSet set) {
        return this.D(set);
    }
    
    @Override
    protected /* bridge */ LinearLayoutCompat.a o(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return this.E(viewGroup$LayoutParams);
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final ActionMenuPresenter e = this.E;
        if (e != null) {
            e.h(false);
            if (this.E.G()) {
                this.E.D();
                this.E.M();
            }
        }
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.B();
    }
    
    @Override
    protected void onLayout(final boolean b, int i, int j, int n, int n2) {
        if (!this.H) {
            super.onLayout(b, i, j, n, n2);
            return;
        }
        final int childCount = this.getChildCount();
        final int n3 = (n2 - j) / 2;
        final int dividerWidth = this.getDividerWidth();
        final int n4 = n - i;
        i = n4 - this.getPaddingRight() - this.getPaddingLeft();
        final boolean b2 = w0.b((View)this);
        j = 0;
        n2 = 0;
        n = 0;
        while (j < childCount) {
            final View child = this.getChildAt(j);
            if (child.getVisibility() != 8) {
                final c c = (c)child.getLayoutParams();
                if (c.a) {
                    final int n5 = n2 = child.getMeasuredWidth();
                    if (this.G(j)) {
                        n2 = n5 + dividerWidth;
                    }
                    final int measuredHeight = child.getMeasuredHeight();
                    int n6;
                    int n7;
                    if (b2) {
                        n6 = this.getPaddingLeft() + c.leftMargin;
                        n7 = n6 + n2;
                    }
                    else {
                        n7 = this.getWidth() - this.getPaddingRight() - c.rightMargin;
                        n6 = n7 - n2;
                    }
                    final int n8 = n3 - measuredHeight / 2;
                    child.layout(n6, n8, n7, measuredHeight + n8);
                    i -= n2;
                    n2 = 1;
                }
                else {
                    i -= child.getMeasuredWidth() + c.leftMargin + c.rightMargin;
                    this.G(j);
                    ++n;
                }
            }
            ++j;
        }
        if (childCount == 1 && n2 == 0) {
            final View child2 = this.getChildAt(0);
            i = child2.getMeasuredWidth();
            j = child2.getMeasuredHeight();
            n = n4 / 2 - i / 2;
            n2 = n3 - j / 2;
            child2.layout(n, n2, i + n, j + n2);
            return;
        }
        j = n - (n2 ^ 0x1);
        if (j > 0) {
            i /= j;
        }
        else {
            i = 0;
        }
        n2 = Math.max(0, i);
        if (b2) {
            n = this.getWidth() - this.getPaddingRight();
            View child3;
            c c2;
            int n9;
            int measuredHeight2;
            for (i = 0; i < childCount; ++i, n = j) {
                child3 = this.getChildAt(i);
                c2 = (c)child3.getLayoutParams();
                j = n;
                if (child3.getVisibility() != 8) {
                    if (c2.a) {
                        j = n;
                    }
                    else {
                        n9 = n - c2.rightMargin;
                        n = child3.getMeasuredWidth();
                        measuredHeight2 = child3.getMeasuredHeight();
                        j = n3 - measuredHeight2 / 2;
                        child3.layout(n9 - n, j, n9, measuredHeight2 + j);
                        j = n9 - (n + c2.leftMargin + n2);
                    }
                }
            }
        }
        else {
            n = this.getPaddingLeft();
            View child4;
            c c3;
            int n10;
            int measuredHeight3;
            for (i = 0; i < childCount; ++i, n = j) {
                child4 = this.getChildAt(i);
                c3 = (c)child4.getLayoutParams();
                j = n;
                if (child4.getVisibility() != 8) {
                    if (c3.a) {
                        j = n;
                    }
                    else {
                        n10 = n + c3.leftMargin;
                        j = child4.getMeasuredWidth();
                        measuredHeight3 = child4.getMeasuredHeight();
                        n = n3 - measuredHeight3 / 2;
                        child4.layout(n10, n, n10 + j, measuredHeight3 + n);
                        j = n10 + (j + c3.rightMargin + n2);
                    }
                }
            }
        }
    }
    
    @Override
    protected void onMeasure(final int n, final int n2) {
        final boolean h = this.H;
        int h2;
        if (View$MeasureSpec.getMode(n) == 1073741824) {
            h2 = 1;
        }
        else {
            h2 = 0;
        }
        this.H = (h2 != 0);
        if ((h ? 1 : 0) != h2) {
            this.I = 0;
        }
        final int size = View$MeasureSpec.getSize(n);
        if (this.H) {
            final g a = this.A;
            if (a != null && size != this.I) {
                this.I = size;
                a.M(true);
            }
        }
        final int childCount = this.getChildCount();
        if (this.H && childCount > 0) {
            this.M(n, n2);
        }
        else {
            for (int i = 0; i < childCount; ++i) {
                final c c = (c)this.getChildAt(i).getLayoutParams();
                c.rightMargin = 0;
                c.leftMargin = 0;
            }
            super.onMeasure(n, n2);
        }
    }
    
    public void setExpandedActionViewsExclusive(final boolean b) {
        this.E.I(b);
    }
    
    public void setOnMenuItemClickListener(final e l) {
        this.L = l;
    }
    
    public void setOverflowIcon(final Drawable drawable) {
        this.getMenu();
        this.E.K(drawable);
    }
    
    public void setOverflowReserved(final boolean d) {
        this.D = d;
    }
    
    public void setPopupTheme(final int c) {
        if (this.C != c) {
            if ((this.C = c) == 0) {
                this.B = this.getContext();
            }
            else {
                this.B = (Context)new ContextThemeWrapper(this.getContext(), c);
            }
        }
    }
    
    public void setPresenter(final ActionMenuPresenter e) {
        (this.E = e).J(this);
    }
    
    public interface a
    {
        boolean a();
        
        boolean b();
    }
    
    private static class b implements m.a
    {
        b() {
        }
        
        @Override
        public void b(final g g, final boolean b) {
        }
        
        @Override
        public boolean c(final g g) {
            return false;
        }
    }
    
    public static class c extends LinearLayoutCompat.a
    {
        @ViewDebug$ExportedProperty
        public boolean a;
        @ViewDebug$ExportedProperty
        public int b;
        @ViewDebug$ExportedProperty
        public int c;
        @ViewDebug$ExportedProperty
        public boolean d;
        @ViewDebug$ExportedProperty
        public boolean e;
        boolean f;
        
        public c(final int n, final int n2) {
            super(n, n2);
            this.a = false;
        }
        
        public c(final Context context, final AttributeSet set) {
            super(context, set);
        }
        
        public c(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
        }
        
        public c(final c c) {
            super((ViewGroup$LayoutParams)c);
            this.a = c.a;
        }
    }
    
    private class d implements g.a
    {
        final ActionMenuView a;
        
        d(final ActionMenuView a) {
            this.a = a;
        }
        
        @Override
        public boolean a(final g g, final MenuItem menuItem) {
            final e l = this.a.L;
            return l != null && l.onMenuItemClick(menuItem);
        }
        
        @Override
        public void b(final g g) {
            final g.a g2 = this.a.G;
            if (g2 != null) {
                g2.b(g);
            }
        }
    }
    
    public interface e
    {
        boolean onMenuItemClick(final MenuItem p0);
    }
}
