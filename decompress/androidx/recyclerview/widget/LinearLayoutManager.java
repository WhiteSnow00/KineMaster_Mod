// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.PointF;
import java.util.List;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;

public class LinearLayoutManager extends o implements y.b
{
    int a;
    private c b;
    androidx.recyclerview.widget.s c;
    private boolean d;
    private boolean e;
    boolean f;
    private boolean g;
    private boolean h;
    int i;
    int j;
    private boolean k;
    SavedState l;
    final a m;
    private final b n;
    private int o;
    private int[] p;
    
    public LinearLayoutManager(final Context context) {
        this(context, 1, false);
    }
    
    public LinearLayoutManager(final Context context, final int orientation, final boolean reverseLayout) {
        this.a = 1;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = -1;
        this.j = Integer.MIN_VALUE;
        this.l = null;
        this.m = new a();
        this.n = new b();
        this.o = 2;
        this.p = new int[2];
        this.setOrientation(orientation);
        this.setReverseLayout(reverseLayout);
    }
    
    public LinearLayoutManager(final Context context, final AttributeSet set, final int n, final int n2) {
        this.a = 1;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = -1;
        this.j = Integer.MIN_VALUE;
        this.l = null;
        this.m = new a();
        this.n = new b();
        this.o = 2;
        this.p = new int[2];
        final d properties = RecyclerView.o.getProperties(context, set, n, n2);
        this.setOrientation(properties.a);
        this.setReverseLayout(properties.c);
        this.D(properties.d);
    }
    
    private void A(final v v, int i, int n) {
        final int childCount = ((RecyclerView.o)this).getChildCount();
        if (i < 0) {
            return;
        }
        final int n2 = this.c.h() - i + n;
        if (this.f) {
            View child;
            for (i = 0; i < childCount; ++i) {
                child = ((RecyclerView.o)this).getChildAt(i);
                if (this.c.g(child) < n2 || this.c.q(child) < n2) {
                    this.recycleChildren(v, 0, i);
                    return;
                }
            }
        }
        else {
            View child2;
            for (n = (i = childCount - 1); i >= 0; --i) {
                child2 = ((RecyclerView.o)this).getChildAt(i);
                if (this.c.g(child2) < n2 || this.c.q(child2) < n2) {
                    this.recycleChildren(v, n, i);
                    break;
                }
            }
        }
    }
    
    private void B(final v v, int i, int childCount) {
        if (i < 0) {
            return;
        }
        final int n = i - childCount;
        childCount = ((RecyclerView.o)this).getChildCount();
        if (this.f) {
            View child;
            for (i = --childCount; i >= 0; --i) {
                child = ((RecyclerView.o)this).getChildAt(i);
                if (this.c.d(child) > n || this.c.p(child) > n) {
                    this.recycleChildren(v, childCount, i);
                    return;
                }
            }
        }
        else {
            View child2;
            for (i = 0; i < childCount; ++i) {
                child2 = ((RecyclerView.o)this).getChildAt(i);
                if (this.c.d(child2) > n || this.c.p(child2) > n) {
                    this.recycleChildren(v, 0, i);
                    break;
                }
            }
        }
    }
    
    private boolean E(final v v, final z z, final a a) {
        final int childCount = ((RecyclerView.o)this).getChildCount();
        final int n = 0;
        if (childCount == 0) {
            return false;
        }
        final View focusedChild = ((RecyclerView.o)this).getFocusedChild();
        if (focusedChild != null && a.d(focusedChild, z)) {
            a.c(focusedChild, ((RecyclerView.o)this).getPosition(focusedChild));
            return true;
        }
        final boolean d = this.d;
        final boolean g = this.g;
        if (d != g) {
            return false;
        }
        final View q = this.q(v, z, a.d, g);
        if (q != null) {
            a.b(q, ((RecyclerView.o)this).getPosition(q));
            if (!z.e() && this.supportsPredictiveItemAnimations()) {
                final int g2 = this.c.g(q);
                final int d2 = this.c.d(q);
                final int m = this.c.m();
                final int i = this.c.i();
                final boolean b = d2 <= m && g2 < m;
                int n2 = n;
                if (g2 >= i) {
                    n2 = n;
                    if (d2 > i) {
                        n2 = 1;
                    }
                }
                if (b || n2 != 0) {
                    int c = m;
                    if (a.d) {
                        c = i;
                    }
                    a.c = c;
                }
            }
            return true;
        }
        return false;
    }
    
    private boolean F(final z z, final a a) {
        final boolean e = z.e();
        boolean d = false;
        if (!e) {
            final int i = this.i;
            if (i != -1) {
                if (i >= 0 && i < z.b()) {
                    a.b = this.i;
                    final SavedState l = this.l;
                    if (l != null && l.a()) {
                        final boolean c = this.l.c;
                        a.d = c;
                        if (c) {
                            a.c = this.c.i() - this.l.b;
                        }
                        else {
                            a.c = this.c.m() + this.l.b;
                        }
                        return true;
                    }
                    if (this.j == Integer.MIN_VALUE) {
                        final View viewByPosition = this.findViewByPosition(this.i);
                        if (viewByPosition != null) {
                            if (this.c.e(viewByPosition) > this.c.n()) {
                                a.a();
                                return true;
                            }
                            if (this.c.g(viewByPosition) - this.c.m() < 0) {
                                a.c = this.c.m();
                                a.d = false;
                                return true;
                            }
                            if (this.c.i() - this.c.d(viewByPosition) < 0) {
                                a.c = this.c.i();
                                return a.d = true;
                            }
                            int g;
                            if (a.d) {
                                g = this.c.d(viewByPosition) + this.c.o();
                            }
                            else {
                                g = this.c.g(viewByPosition);
                            }
                            a.c = g;
                        }
                        else {
                            if (((RecyclerView.o)this).getChildCount() > 0) {
                                if (this.i < ((RecyclerView.o)this).getPosition(((RecyclerView.o)this).getChildAt(0)) == this.f) {
                                    d = true;
                                }
                                a.d = d;
                            }
                            a.a();
                        }
                        return true;
                    }
                    final boolean f = this.f;
                    a.d = f;
                    if (f) {
                        a.c = this.c.i() - this.j;
                    }
                    else {
                        a.c = this.c.m() + this.j;
                    }
                    return true;
                }
                else {
                    this.i = -1;
                    this.j = Integer.MIN_VALUE;
                }
            }
        }
        return false;
    }
    
    private void G(final v v, final z z, final a a) {
        if (this.F(z, a)) {
            return;
        }
        if (this.E(v, z, a)) {
            return;
        }
        a.a();
        int b;
        if (this.g) {
            b = z.b() - 1;
        }
        else {
            b = 0;
        }
        a.b = b;
    }
    
    private void H(int g, final int c, final boolean b, final z z) {
        this.b.m = this.C();
        this.b.f = g;
        final int[] p4 = this.p;
        boolean b2 = false;
        p4[0] = 0;
        final int n = 1;
        final int n2 = 1;
        p4[1] = 0;
        this.a(z, p4);
        int max = Math.max(0, this.p[0]);
        final int max2 = Math.max(0, this.p[1]);
        if (g == 1) {
            b2 = true;
        }
        final c b3 = this.b;
        if (b2) {
            g = max2;
        }
        else {
            g = max;
        }
        b3.h = g;
        if (!b2) {
            max = max2;
        }
        b3.i = max;
        if (b2) {
            b3.h = g + this.c.j();
            final View t = this.t();
            final c b4 = this.b;
            g = n2;
            if (this.f) {
                g = -1;
            }
            b4.e = g;
            g = ((RecyclerView.o)this).getPosition(t);
            final c b5 = this.b;
            b4.d = g + b5.e;
            b5.b = this.c.d(t);
            g = this.c.d(t) - this.c.i();
        }
        else {
            final View u = this.u();
            final c b6 = this.b;
            b6.h += this.c.m();
            final c b7 = this.b;
            if (this.f) {
                g = n;
            }
            else {
                g = -1;
            }
            b7.e = g;
            g = ((RecyclerView.o)this).getPosition(u);
            final c b8 = this.b;
            b7.d = g + b8.e;
            b8.b = this.c.g(u);
            g = -this.c.g(u) + this.c.m();
        }
        final c b9 = this.b;
        b9.c = c;
        if (b) {
            b9.c = c - g;
        }
        b9.g = g;
    }
    
    private void I(final int d, final int b) {
        this.b.c = this.c.i() - b;
        final c b2 = this.b;
        int e;
        if (this.f) {
            e = -1;
        }
        else {
            e = 1;
        }
        b2.e = e;
        b2.d = d;
        b2.f = 1;
        b2.b = b;
        b2.g = Integer.MIN_VALUE;
    }
    
    private void J(final a a) {
        this.I(a.b, a.c);
    }
    
    private void K(int n, final int b) {
        this.b.c = b - this.c.m();
        final c b2 = this.b;
        b2.d = n;
        if (this.f) {
            n = 1;
        }
        else {
            n = -1;
        }
        b2.e = n;
        b2.f = -1;
        b2.b = b;
        b2.g = Integer.MIN_VALUE;
    }
    
    private void L(final a a) {
        this.K(a.b, a.c);
    }
    
    private int computeScrollExtent(final z z) {
        if (((RecyclerView.o)this).getChildCount() == 0) {
            return 0;
        }
        this.d();
        return androidx.recyclerview.widget.v.a(z, this.c, this.h(this.h ^ true, true), this.g(this.h ^ true, true), this, this.h);
    }
    
    private int computeScrollOffset(final z z) {
        if (((RecyclerView.o)this).getChildCount() == 0) {
            return 0;
        }
        this.d();
        return androidx.recyclerview.widget.v.b(z, this.c, this.h(this.h ^ true, true), this.g(this.h ^ true, true), this, this.h, this.f);
    }
    
    private int computeScrollRange(final z z) {
        if (((RecyclerView.o)this).getChildCount() == 0) {
            return 0;
        }
        this.d();
        return androidx.recyclerview.widget.v.c(z, this.c, this.h(this.h ^ true, true), this.g(this.h ^ true, true), this, this.h);
    }
    
    private View f() {
        return this.m(0, ((RecyclerView.o)this).getChildCount());
    }
    
    private View k() {
        return this.m(((RecyclerView.o)this).getChildCount() - 1, -1);
    }
    
    private void layoutForPredictiveAnimations(final v v, final z z, final int n, final int n2) {
        if (z.g() && ((RecyclerView.o)this).getChildCount() != 0 && !z.e()) {
            if (this.supportsPredictiveItemAnimations()) {
                final List<c0> k = v.k();
                final int size = k.size();
                final int position = ((RecyclerView.o)this).getPosition(((RecyclerView.o)this).getChildAt(0));
                int i = 0;
                int h2;
                int h = h2 = 0;
                while (i < size) {
                    final c0 c0 = k.get(i);
                    if (!c0.isRemoved()) {
                        final int layoutPosition = c0.getLayoutPosition();
                        int n3 = 1;
                        if (layoutPosition < position != this.f) {
                            n3 = -1;
                        }
                        if (n3 == -1) {
                            h += this.c.e(c0.itemView);
                        }
                        else {
                            h2 += this.c.e(c0.itemView);
                        }
                    }
                    ++i;
                }
                this.b.l = k;
                if (h > 0) {
                    this.K(((RecyclerView.o)this).getPosition(this.u()), n);
                    final c b = this.b;
                    b.h = h;
                    b.c = 0;
                    b.a();
                    this.e(v, this.b, z, false);
                }
                if (h2 > 0) {
                    this.I(((RecyclerView.o)this).getPosition(this.t()), n2);
                    final c b2 = this.b;
                    b2.h = h2;
                    b2.c = 0;
                    b2.a();
                    this.e(v, this.b, z, false);
                }
                this.b.l = null;
            }
        }
    }
    
    private View o() {
        View view;
        if (this.f) {
            view = this.f();
        }
        else {
            view = this.k();
        }
        return view;
    }
    
    private View p() {
        View view;
        if (this.f) {
            view = this.k();
        }
        else {
            view = this.f();
        }
        return view;
    }
    
    private int r(int n, final v v, final z z, final boolean b) {
        final int n2 = this.c.i() - n;
        if (n2 > 0) {
            final int n3 = -this.scrollBy(-n2, v, z);
            if (b) {
                n = this.c.i() - (n + n3);
                if (n > 0) {
                    this.c.r(n);
                    return n + n3;
                }
            }
            return n3;
        }
        return 0;
    }
    
    private void recycleChildren(final v v, final int n, int i) {
        if (n == i) {
            return;
        }
        int j;
        if (i > (j = n)) {
            --i;
            while (i >= n) {
                ((RecyclerView.o)this).removeAndRecycleViewAt(i, v);
                --i;
            }
        }
        else {
            while (j > i) {
                ((RecyclerView.o)this).removeAndRecycleViewAt(j, v);
                --j;
            }
        }
    }
    
    private void resolveShouldLayoutReverse() {
        if (this.a != 1 && this.isLayoutRTL()) {
            this.f = (this.e ^ true);
        }
        else {
            this.f = this.e;
        }
    }
    
    private int s(int n, final v v, final z z, final boolean b) {
        final int n2 = n - this.c.m();
        if (n2 > 0) {
            int n4;
            final int n3 = n4 = -this.scrollBy(n2, v, z);
            if (b) {
                n = n + n3 - this.c.m();
                n4 = n3;
                if (n > 0) {
                    this.c.r(-n);
                    n4 = n3 - n;
                }
            }
            return n4;
        }
        return 0;
    }
    
    private View t() {
        int n;
        if (this.f) {
            n = 0;
        }
        else {
            n = ((RecyclerView.o)this).getChildCount() - 1;
        }
        return ((RecyclerView.o)this).getChildAt(n);
    }
    
    private View u() {
        int n;
        if (this.f) {
            n = ((RecyclerView.o)this).getChildCount() - 1;
        }
        else {
            n = 0;
        }
        return ((RecyclerView.o)this).getChildAt(n);
    }
    
    private void z(final v v, final c c) {
        if (c.a) {
            if (!c.m) {
                final int g = c.g;
                final int i = c.i;
                if (c.f == -1) {
                    this.A(v, g, i);
                }
                else {
                    this.B(v, g, i);
                }
            }
        }
    }
    
    boolean C() {
        return this.c.k() == 0 && this.c.h() == 0;
    }
    
    public void D(final boolean g) {
        this.assertNotInLayoutOrScroll(null);
        if (this.g == g) {
            return;
        }
        this.g = g;
        ((RecyclerView.o)this).requestLayout();
    }
    
    protected void a(final z z, final int[] array) {
        final int v = this.v(z);
        int n;
        int n2;
        if (this.b.f == -1) {
            n = 0;
            n2 = v;
        }
        else {
            n2 = 0;
            n = v;
        }
        array[0] = n2;
        array[1] = n;
    }
    
    @Override
    public void assertNotInLayoutOrScroll(final String s) {
        if (this.l == null) {
            super.assertNotInLayoutOrScroll(s);
        }
    }
    
    void b(final z z, final c c, final o.c c2) {
        final int d = c.d;
        if (d >= 0 && d < z.b()) {
            c2.a(d, Math.max(0, c.g));
        }
    }
    
    c c() {
        return new c();
    }
    
    @Override
    public boolean canScrollHorizontally() {
        return this.a == 0;
    }
    
    @Override
    public boolean canScrollVertically() {
        final int a = this.a;
        boolean b = true;
        if (a != 1) {
            b = false;
        }
        return b;
    }
    
    @Override
    public void collectAdjacentPrefetchPositions(int n, int n2, final z z, final o.c c) {
        if (this.a != 0) {
            n = n2;
        }
        if (((RecyclerView.o)this).getChildCount() != 0) {
            if (n != 0) {
                this.d();
                if (n > 0) {
                    n2 = 1;
                }
                else {
                    n2 = -1;
                }
                this.H(n2, Math.abs(n), true, z);
                this.b(z, this.b, c);
            }
        }
    }
    
    @Override
    public void collectInitialPrefetchPositions(final int n, final o.c c) {
        final SavedState l = this.l;
        int n2 = -1;
        boolean c2;
        int n3;
        if (l != null && l.a()) {
            final SavedState i = this.l;
            c2 = i.c;
            n3 = i.a;
        }
        else {
            this.resolveShouldLayoutReverse();
            final boolean f = this.f;
            final int n4 = n3 = this.i;
            c2 = f;
            if (n4 == -1) {
                if (f) {
                    n3 = n - 1;
                    c2 = f;
                }
                else {
                    n3 = 0;
                    c2 = f;
                }
            }
        }
        if (!c2) {
            n2 = 1;
        }
        for (int n5 = 0; n5 < this.o && n3 >= 0 && n3 < n; n3 += n2, ++n5) {
            c.a(n3, 0);
        }
    }
    
    @Override
    public int computeHorizontalScrollExtent(final z z) {
        return this.computeScrollExtent(z);
    }
    
    @Override
    public int computeHorizontalScrollOffset(final z z) {
        return this.computeScrollOffset(z);
    }
    
    @Override
    public int computeHorizontalScrollRange(final z z) {
        return this.computeScrollRange(z);
    }
    
    @Override
    public PointF computeScrollVectorForPosition(int n) {
        if (((RecyclerView.o)this).getChildCount() == 0) {
            return null;
        }
        boolean b = false;
        final int position = ((RecyclerView.o)this).getPosition(((RecyclerView.o)this).getChildAt(0));
        final int n2 = 1;
        if (n < position) {
            b = true;
        }
        n = n2;
        if (b != this.f) {
            n = -1;
        }
        if (this.a == 0) {
            return new PointF((float)n, 0.0f);
        }
        return new PointF(0.0f, (float)n);
    }
    
    @Override
    public int computeVerticalScrollExtent(final z z) {
        return this.computeScrollExtent(z);
    }
    
    @Override
    public int computeVerticalScrollOffset(final z z) {
        return this.computeScrollOffset(z);
    }
    
    @Override
    public int computeVerticalScrollRange(final z z) {
        return this.computeScrollRange(z);
    }
    
    int convertFocusDirectionToLayoutDirection(int n) {
        int n2 = -1;
        final int n3 = 1;
        final int n4 = 1;
        if (n != 1) {
            if (n != 2) {
                if (n == 17) {
                    if (this.a != 0) {
                        n2 = Integer.MIN_VALUE;
                    }
                    return n2;
                }
                if (n == 33) {
                    if (this.a != 1) {
                        n2 = Integer.MIN_VALUE;
                    }
                    return n2;
                }
                if (n == 66) {
                    if (this.a == 0) {
                        n = n3;
                    }
                    else {
                        n = Integer.MIN_VALUE;
                    }
                    return n;
                }
                if (n != 130) {
                    return Integer.MIN_VALUE;
                }
                if (this.a == 1) {
                    n = n4;
                }
                else {
                    n = Integer.MIN_VALUE;
                }
                return n;
            }
            else {
                if (this.a == 1) {
                    return 1;
                }
                if (this.isLayoutRTL()) {
                    return -1;
                }
                return 1;
            }
        }
        else {
            if (this.a == 1) {
                return -1;
            }
            if (this.isLayoutRTL()) {
                return 1;
            }
            return -1;
        }
    }
    
    void d() {
        if (this.b == null) {
            this.b = this.c();
        }
    }
    
    int e(final v v, final c c, final z z, final boolean b) {
        final int c2 = c.c;
        final int g = c.g;
        if (g != Integer.MIN_VALUE) {
            if (c2 < 0) {
                c.g = g + c2;
            }
            this.z(v, c);
        }
        int n = c.c + c.h;
        final b n2 = this.n;
        while ((c.m || n > 0) && c.c(z)) {
            n2.a();
            this.x(v, z, c, n2);
            if (n2.b) {
                break;
            }
            c.b += n2.a * c.f;
            int n3 = 0;
            Label_0175: {
                if (n2.c && c.l == null) {
                    n3 = n;
                    if (z.e()) {
                        break Label_0175;
                    }
                }
                final int c3 = c.c;
                final int a = n2.a;
                c.c = c3 - a;
                n3 = n - a;
            }
            final int g2 = c.g;
            if (g2 != Integer.MIN_VALUE) {
                final int g3 = g2 + n2.a;
                c.g = g3;
                final int c4 = c.c;
                if (c4 < 0) {
                    c.g = g3 + c4;
                }
                this.z(v, c);
            }
            n = n3;
            if (!b) {
                continue;
            }
            n = n3;
            if (n2.d) {
                break;
            }
        }
        return c2 - c.c;
    }
    
    @Override
    public View findViewByPosition(final int n) {
        final int childCount = ((RecyclerView.o)this).getChildCount();
        if (childCount == 0) {
            return null;
        }
        final int n2 = n - ((RecyclerView.o)this).getPosition(((RecyclerView.o)this).getChildAt(0));
        if (n2 >= 0 && n2 < childCount) {
            final View child = ((RecyclerView.o)this).getChildAt(n2);
            if (((RecyclerView.o)this).getPosition(child) == n) {
                return child;
            }
        }
        return super.findViewByPosition(n);
    }
    
    View g(final boolean b, final boolean b2) {
        if (this.f) {
            return this.n(0, ((RecyclerView.o)this).getChildCount(), b, b2);
        }
        return this.n(((RecyclerView.o)this).getChildCount() - 1, -1, b, b2);
    }
    
    @Override
    public p generateDefaultLayoutParams() {
        return new RecyclerView.p(-2, -2);
    }
    
    public int getOrientation() {
        return this.a;
    }
    
    View h(final boolean b, final boolean b2) {
        if (this.f) {
            return this.n(((RecyclerView.o)this).getChildCount() - 1, -1, b, b2);
        }
        return this.n(0, ((RecyclerView.o)this).getChildCount(), b, b2);
    }
    
    public int i() {
        final View n = this.n(0, ((RecyclerView.o)this).getChildCount(), false, true);
        int position;
        if (n == null) {
            position = -1;
        }
        else {
            position = ((RecyclerView.o)this).getPosition(n);
        }
        return position;
    }
    
    @Override
    public boolean isAutoMeasureEnabled() {
        return true;
    }
    
    protected boolean isLayoutRTL() {
        final int layoutDirection = ((RecyclerView.o)this).getLayoutDirection();
        boolean b = true;
        if (layoutDirection != 1) {
            b = false;
        }
        return b;
    }
    
    public int j() {
        final int childCount = ((RecyclerView.o)this).getChildCount();
        int position = -1;
        final View n = this.n(childCount - 1, -1, true, false);
        if (n != null) {
            position = ((RecyclerView.o)this).getPosition(n);
        }
        return position;
    }
    
    public int l() {
        final int childCount = ((RecyclerView.o)this).getChildCount();
        int position = -1;
        final View n = this.n(childCount - 1, -1, false, true);
        if (n != null) {
            position = ((RecyclerView.o)this).getPosition(n);
        }
        return position;
    }
    
    View m(final int n, final int n2) {
        this.d();
        int n3;
        if (n2 > n) {
            n3 = 1;
        }
        else if (n2 < n) {
            n3 = -1;
        }
        else {
            n3 = 0;
        }
        if (n3 == 0) {
            return ((RecyclerView.o)this).getChildAt(n);
        }
        int n4;
        int n5;
        if (this.c.g(((RecyclerView.o)this).getChildAt(n)) < this.c.m()) {
            n4 = 16644;
            n5 = 16388;
        }
        else {
            n4 = 4161;
            n5 = 4097;
        }
        View view;
        if (this.a == 0) {
            view = super.mHorizontalBoundCheck.a(n, n2, n4, n5);
        }
        else {
            view = super.mVerticalBoundCheck.a(n, n2, n4, n5);
        }
        return view;
    }
    
    View n(final int n, final int n2, final boolean b, final boolean b2) {
        this.d();
        int n3 = 320;
        int n4;
        if (b) {
            n4 = 24579;
        }
        else {
            n4 = 320;
        }
        if (!b2) {
            n3 = 0;
        }
        View view;
        if (this.a == 0) {
            view = super.mHorizontalBoundCheck.a(n, n2, n4, n3);
        }
        else {
            view = super.mVerticalBoundCheck.a(n, n2, n4, n3);
        }
        return view;
    }
    
    @Override
    public void onDetachedFromWindow(final RecyclerView recyclerView, final v v) {
        super.onDetachedFromWindow(recyclerView, v);
        if (this.k) {
            ((RecyclerView.o)this).removeAndRecycleAllViews(v);
            v.c();
        }
    }
    
    @Override
    public View onFocusSearchFailed(View view, int convertFocusDirectionToLayoutDirection, final v v, final z z) {
        this.resolveShouldLayoutReverse();
        if (((RecyclerView.o)this).getChildCount() == 0) {
            return null;
        }
        convertFocusDirectionToLayoutDirection = this.convertFocusDirectionToLayoutDirection(convertFocusDirectionToLayoutDirection);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        this.d();
        this.H(convertFocusDirectionToLayoutDirection, (int)(this.c.n() * 0.33333334f), false, z);
        final c b = this.b;
        b.g = Integer.MIN_VALUE;
        b.a = false;
        this.e(v, b, z, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            view = this.p();
        }
        else {
            view = this.o();
        }
        View view2;
        if (convertFocusDirectionToLayoutDirection == -1) {
            view2 = this.u();
        }
        else {
            view2 = this.t();
        }
        if (!view2.hasFocusable()) {
            return view;
        }
        if (view == null) {
            return null;
        }
        return view2;
    }
    
    @Override
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (((RecyclerView.o)this).getChildCount() > 0) {
            accessibilityEvent.setFromIndex(this.i());
            accessibilityEvent.setToIndex(this.l());
        }
    }
    
    @Override
    public void onLayoutChildren(final v v, final z z) {
        final SavedState l = this.l;
        int n = -1;
        if ((l != null || this.i != -1) && z.b() == 0) {
            ((RecyclerView.o)this).removeAndRecycleAllViews(v);
            return;
        }
        final SavedState i = this.l;
        if (i != null && i.a()) {
            this.i = this.l.a;
        }
        this.d();
        this.b.a = false;
        this.resolveShouldLayoutReverse();
        final View focusedChild = ((RecyclerView.o)this).getFocusedChild();
        final a m = this.m;
        if (m.e && this.i == -1 && this.l == null) {
            if (focusedChild != null && (this.c.g(focusedChild) >= this.c.i() || this.c.d(focusedChild) <= this.c.m())) {
                this.m.c(focusedChild, ((RecyclerView.o)this).getPosition(focusedChild));
            }
        }
        else {
            m.e();
            final a j = this.m;
            j.d = (this.f ^ this.g);
            this.G(v, z, j);
            this.m.e = true;
        }
        final c b = this.b;
        int f;
        if (b.k >= 0) {
            f = 1;
        }
        else {
            f = -1;
        }
        b.f = f;
        final int[] p2 = this.p;
        p2[1] = (p2[0] = 0);
        this.a(z, p2);
        final int n2 = Math.max(0, this.p[0]) + this.c.m();
        final int n3 = Math.max(0, this.p[1]) + this.c.j();
        int h = n2;
        int h2 = n3;
        if (z.e()) {
            final int k = this.i;
            h = n2;
            h2 = n3;
            if (k != -1) {
                h = n2;
                h2 = n3;
                if (this.j != Integer.MIN_VALUE) {
                    final View viewByPosition = this.findViewByPosition(k);
                    h = n2;
                    h2 = n3;
                    if (viewByPosition != null) {
                        int j2;
                        int j3;
                        if (this.f) {
                            j2 = this.c.i() - this.c.d(viewByPosition);
                            j3 = this.j;
                        }
                        else {
                            j3 = this.c.g(viewByPosition) - this.c.m();
                            j2 = this.j;
                        }
                        final int n4 = j2 - j3;
                        if (n4 > 0) {
                            h = n2 + n4;
                            h2 = n3;
                        }
                        else {
                            h2 = n3 - n4;
                            h = n2;
                        }
                    }
                }
            }
        }
        final a m2 = this.m;
        Label_0502: {
            if (m2.d) {
                if (!this.f) {
                    break Label_0502;
                }
            }
            else if (this.f) {
                break Label_0502;
            }
            n = 1;
        }
        this.y(v, z, m2, n);
        ((RecyclerView.o)this).detachAndScrapAttachedViews(v);
        this.b.m = this.C();
        this.b.j = z.e();
        this.b.i = 0;
        final a m3 = this.m;
        int b8;
        int b9;
        if (m3.d) {
            this.L(m3);
            final c b2 = this.b;
            b2.h = h;
            this.e(v, b2, z, false);
            final c b3 = this.b;
            final int b4 = b3.b;
            final int d = b3.d;
            final int c = b3.c;
            int h3 = h2;
            if (c > 0) {
                h3 = h2 + c;
            }
            this.J(this.m);
            final c b5 = this.b;
            b5.h = h3;
            b5.d += b5.e;
            this.e(v, b5, z, false);
            final c b6 = this.b;
            final int b7 = b6.b;
            final int c2 = b6.c;
            b8 = b4;
            b9 = b7;
            if (c2 > 0) {
                this.K(d, b4);
                final c b10 = this.b;
                b10.h = c2;
                this.e(v, b10, z, false);
                b8 = this.b.b;
                b9 = b7;
            }
        }
        else {
            this.J(m3);
            final c b11 = this.b;
            b11.h = h2;
            this.e(v, b11, z, false);
            final c b12 = this.b;
            final int b13 = b12.b;
            final int d2 = b12.d;
            final int c3 = b12.c;
            int h4 = h;
            if (c3 > 0) {
                h4 = h + c3;
            }
            this.L(this.m);
            final c b14 = this.b;
            b14.h = h4;
            b14.d += b14.e;
            this.e(v, b14, z, false);
            final c b15 = this.b;
            final int b16 = b15.b;
            final int c4 = b15.c;
            b8 = b16;
            b9 = b13;
            if (c4 > 0) {
                this.I(d2, b13);
                final c b17 = this.b;
                b17.h = c4;
                this.e(v, b17, z, false);
                b9 = this.b.b;
                b8 = b16;
            }
        }
        int n5 = b8;
        int n6 = b9;
        if (((RecyclerView.o)this).getChildCount() > 0) {
            int n7;
            int n8;
            int n9;
            if (this.f ^ this.g) {
                final int r = this.r(b9, v, z, true);
                n7 = b8 + r;
                n8 = b9 + r;
                n9 = this.s(n7, v, z, false);
            }
            else {
                final int s = this.s(b8, v, z, true);
                n7 = b8 + s;
                n8 = b9 + s;
                n9 = this.r(n8, v, z, false);
            }
            n5 = n7 + n9;
            n6 = n8 + n9;
        }
        this.layoutForPredictiveAnimations(v, z, n5, n6);
        if (!z.e()) {
            this.c.s();
        }
        else {
            this.m.e();
        }
        this.d = this.g;
    }
    
    @Override
    public void onLayoutCompleted(final z z) {
        super.onLayoutCompleted(z);
        this.l = null;
        this.i = -1;
        this.j = Integer.MIN_VALUE;
        this.m.e();
    }
    
    @Override
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            final SavedState l = (SavedState)parcelable;
            this.l = l;
            if (this.i != -1) {
                l.b();
            }
            ((RecyclerView.o)this).requestLayout();
        }
    }
    
    @Override
    public Parcelable onSaveInstanceState() {
        if (this.l != null) {
            return (Parcelable)new SavedState(this.l);
        }
        final SavedState savedState = new SavedState();
        if (((RecyclerView.o)this).getChildCount() > 0) {
            this.d();
            final boolean c = this.d ^ this.f;
            savedState.c = c;
            if (c) {
                final View t = this.t();
                savedState.b = this.c.i() - this.c.d(t);
                savedState.a = ((RecyclerView.o)this).getPosition(t);
            }
            else {
                final View u = this.u();
                savedState.a = ((RecyclerView.o)this).getPosition(u);
                savedState.b = this.c.g(u) - this.c.m();
            }
        }
        else {
            savedState.b();
        }
        return (Parcelable)savedState;
    }
    
    View q(final v v, final z z, final boolean b, final boolean b2) {
        this.d();
        final int childCount = ((RecyclerView.o)this).getChildCount();
        int n = -1;
        int i;
        int n2;
        if (b2) {
            i = ((RecyclerView.o)this).getChildCount() - 1;
            n2 = -1;
        }
        else {
            n = childCount;
            i = 0;
            n2 = 1;
        }
        final int b3 = z.b();
        final int m = this.c.m();
        final int j = this.c.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i != n) {
            final View child = ((RecyclerView.o)this).getChildAt(i);
            final int position = ((RecyclerView.o)this).getPosition(child);
            final int g = this.c.g(child);
            final int d = this.c.d(child);
            View view4 = view;
            View view5 = view2;
            View view6 = view3;
            Label_0328: {
                if (position >= 0) {
                    view4 = view;
                    view5 = view2;
                    view6 = view3;
                    if (position < b3) {
                        if (((p)child.getLayoutParams()).c()) {
                            view4 = view;
                            view5 = view2;
                            if ((view6 = view3) == null) {
                                view4 = view;
                                view5 = view2;
                                view6 = child;
                            }
                        }
                        else {
                            final boolean b4 = d <= m && g < m;
                            final boolean b5 = g >= j && d > j;
                            if (!b4 && !b5) {
                                return child;
                            }
                            Label_0318: {
                                if (b) {
                                    if (!b5) {
                                        view4 = view;
                                        view5 = view2;
                                        view6 = view3;
                                        if (view == null) {
                                            break Label_0318;
                                        }
                                        break Label_0328;
                                    }
                                }
                                else if (!b4) {
                                    view4 = view;
                                    view5 = view2;
                                    view6 = view3;
                                    if (view == null) {
                                        break Label_0318;
                                    }
                                    break Label_0328;
                                }
                                view4 = view;
                                view5 = child;
                                view6 = view3;
                                break Label_0328;
                            }
                            view6 = view3;
                            view5 = view2;
                            view4 = child;
                        }
                    }
                }
            }
            i += n2;
            view = view4;
            view2 = view5;
            view3 = view6;
        }
        if (view == null) {
            if (view2 != null) {
                view = view2;
            }
            else {
                view = view3;
            }
        }
        return view;
    }
    
    int scrollBy(int k, final v v, final z z) {
        if (((RecyclerView.o)this).getChildCount() == 0 || k == 0) {
            return 0;
        }
        this.d();
        this.b.a = true;
        int n;
        if (k > 0) {
            n = 1;
        }
        else {
            n = -1;
        }
        final int abs = Math.abs(k);
        this.H(n, abs, true, z);
        final c b = this.b;
        final int n2 = b.g + this.e(v, b, z, false);
        if (n2 < 0) {
            return 0;
        }
        if (abs > n2) {
            k = n * n2;
        }
        this.c.r(-k);
        return this.b.k = k;
    }
    
    @Override
    public int scrollHorizontallyBy(final int n, final v v, final z z) {
        if (this.a == 1) {
            return 0;
        }
        return this.scrollBy(n, v, z);
    }
    
    @Override
    public void scrollToPosition(final int i) {
        this.i = i;
        this.j = Integer.MIN_VALUE;
        final SavedState l = this.l;
        if (l != null) {
            l.b();
        }
        ((RecyclerView.o)this).requestLayout();
    }
    
    public void scrollToPositionWithOffset(final int i, final int j) {
        this.i = i;
        this.j = j;
        final SavedState l = this.l;
        if (l != null) {
            l.b();
        }
        ((RecyclerView.o)this).requestLayout();
    }
    
    @Override
    public int scrollVerticallyBy(final int n, final v v, final z z) {
        if (this.a == 0) {
            return 0;
        }
        return this.scrollBy(n, v, z);
    }
    
    public void setOrientation(final int a) {
        if (a != 0 && a != 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("invalid orientation:");
            sb.append(a);
            throw new IllegalArgumentException(sb.toString());
        }
        this.assertNotInLayoutOrScroll(null);
        if (a != this.a || this.c == null) {
            final androidx.recyclerview.widget.s b = androidx.recyclerview.widget.s.b(this, a);
            this.c = b;
            this.m.a = b;
            this.a = a;
            ((RecyclerView.o)this).requestLayout();
        }
    }
    
    public void setReverseLayout(final boolean e) {
        this.assertNotInLayoutOrScroll(null);
        if (e == this.e) {
            return;
        }
        this.e = e;
        ((RecyclerView.o)this).requestLayout();
    }
    
    @Override
    boolean shouldMeasureTwice() {
        return ((RecyclerView.o)this).getHeightMode() != 1073741824 && ((RecyclerView.o)this).getWidthMode() != 1073741824 && ((RecyclerView.o)this).hasFlexibleChildInBothOrientations();
    }
    
    @Override
    public void smoothScrollToPosition(final RecyclerView recyclerView, final z z, final int targetPosition) {
        final androidx.recyclerview.widget.n n = new androidx.recyclerview.widget.n(recyclerView.getContext());
        ((RecyclerView.y)n).setTargetPosition(targetPosition);
        ((RecyclerView.o)this).startSmoothScroll(n);
    }
    
    @Override
    public boolean supportsPredictiveItemAnimations() {
        return this.l == null && this.d == this.g;
    }
    
    @Deprecated
    protected int v(final z z) {
        if (z.d()) {
            return this.c.n();
        }
        return 0;
    }
    
    public boolean w() {
        return this.h;
    }
    
    void x(final v v, final z z, final c c, final b b) {
        final View d = c.d(v);
        if (d == null) {
            b.b = true;
            return;
        }
        final p p4 = (p)d.getLayoutParams();
        if (c.l == null) {
            if (this.f == (c.f == -1)) {
                ((RecyclerView.o)this).addView(d);
            }
            else {
                ((RecyclerView.o)this).addView(d, 0);
            }
        }
        else if (this.f == (c.f == -1)) {
            ((RecyclerView.o)this).addDisappearingView(d);
        }
        else {
            ((RecyclerView.o)this).addDisappearingView(d, 0);
        }
        ((RecyclerView.o)this).measureChildWithMargins(d, 0, 0);
        b.a = this.c.e(d);
        int paddingLeft;
        int n2;
        int n3;
        int n4;
        if (this.a == 1) {
            int n;
            if (this.isLayoutRTL()) {
                n = ((RecyclerView.o)this).getWidth() - ((RecyclerView.o)this).getPaddingRight();
                paddingLeft = n - this.c.f(d);
            }
            else {
                paddingLeft = ((RecyclerView.o)this).getPaddingLeft();
                n = this.c.f(d) + paddingLeft;
            }
            if (c.f == -1) {
                final int b2 = c.b;
                final int a = b.a;
                n2 = b2;
                n3 = n;
                n4 = b2 - a;
            }
            else {
                final int b3 = c.b;
                final int a2 = b.a;
                final int n5 = b3;
                n3 = n;
                final int n6 = a2 + b3;
                n4 = n5;
                n2 = n6;
            }
        }
        else {
            final int paddingTop = ((RecyclerView.o)this).getPaddingTop();
            final int n7 = this.c.f(d) + paddingTop;
            if (c.f == -1) {
                final int b4 = c.b;
                final int a3 = b.a;
                n3 = b4;
                final int n8 = paddingTop;
                n2 = n7;
                paddingLeft = b4 - a3;
                n4 = n8;
            }
            else {
                final int b5 = c.b;
                n3 = b.a + b5;
                n2 = n7;
                n4 = paddingTop;
                paddingLeft = b5;
            }
        }
        ((RecyclerView.o)this).layoutDecoratedWithMargins(d, paddingLeft, n4, n3, n2);
        if (p4.c() || p4.b()) {
            b.c = true;
        }
        b.d = d.hasFocusable();
    }
    
    void y(final v v, final z z, final a a, final int n) {
    }
    
    public static class SavedState implements Parcelable
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        int a;
        int b;
        boolean c;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel);
                }
                
                public SavedState[] b(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        public SavedState() {
        }
        
        SavedState(final Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            final int int1 = parcel.readInt();
            boolean c = true;
            if (int1 != 1) {
                c = false;
            }
            this.c = c;
        }
        
        public SavedState(final SavedState savedState) {
            this.a = savedState.a;
            this.b = savedState.b;
            this.c = savedState.c;
        }
        
        boolean a() {
            return this.a >= 0;
        }
        
        void b() {
            this.a = -1;
        }
        
        public int describeContents() {
            return 0;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt((int)(this.c ? 1 : 0));
        }
    }
    
    static class a
    {
        androidx.recyclerview.widget.s a;
        int b;
        int c;
        boolean d;
        boolean e;
        
        a() {
            this.e();
        }
        
        void a() {
            int c;
            if (this.d) {
                c = this.a.i();
            }
            else {
                c = this.a.m();
            }
            this.c = c;
        }
        
        public void b(final View view, final int b) {
            if (this.d) {
                this.c = this.a.d(view) + this.a.o();
            }
            else {
                this.c = this.a.g(view);
            }
            this.b = b;
        }
        
        public void c(final View view, int b) {
            final int o = this.a.o();
            if (o >= 0) {
                this.b(view, b);
                return;
            }
            this.b = b;
            if (this.d) {
                b = this.a.i() - o - this.a.d(view);
                this.c = this.a.i() - b;
                if (b > 0) {
                    final int e = this.a.e(view);
                    final int c = this.c;
                    final int m = this.a.m();
                    final int n = c - e - (m + Math.min(this.a.g(view) - m, 0));
                    if (n < 0) {
                        this.c += Math.min(b, -n);
                    }
                }
            }
            else {
                final int g = this.a.g(view);
                b = g - this.a.m();
                this.c = g;
                if (b > 0) {
                    final int n2 = this.a.i() - Math.min(0, this.a.i() - o - this.a.d(view)) - (g + this.a.e(view));
                    if (n2 < 0) {
                        this.c -= Math.min(b, -n2);
                    }
                }
            }
        }
        
        boolean d(final View view, final z z) {
            final p p2 = (p)view.getLayoutParams();
            return !p2.c() && p2.a() >= 0 && p2.a() < z.b();
        }
        
        void e() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("AnchorInfo{mPosition=");
            sb.append(this.b);
            sb.append(", mCoordinate=");
            sb.append(this.c);
            sb.append(", mLayoutFromEnd=");
            sb.append(this.d);
            sb.append(", mValid=");
            sb.append(this.e);
            sb.append('}');
            return sb.toString();
        }
    }
    
    protected static class b
    {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;
        
        void a() {
            this.a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }
    
    static class c
    {
        boolean a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;
        boolean j;
        int k;
        List<c0> l;
        boolean m;
        
        c() {
            this.a = true;
            this.h = 0;
            this.i = 0;
            this.j = false;
            this.l = null;
        }
        
        private View e() {
            for (int size = this.l.size(), i = 0; i < size; ++i) {
                final View itemView = this.l.get(i).itemView;
                final p p = (p)itemView.getLayoutParams();
                if (!p.c()) {
                    if (this.d == p.a()) {
                        this.b(itemView);
                        return itemView;
                    }
                }
            }
            return null;
        }
        
        public void a() {
            this.b(null);
        }
        
        public void b(View f) {
            f = this.f(f);
            if (f == null) {
                this.d = -1;
            }
            else {
                this.d = ((p)f.getLayoutParams()).a();
            }
        }
        
        boolean c(final z z) {
            final int d = this.d;
            return d >= 0 && d < z.b();
        }
        
        View d(final v v) {
            if (this.l != null) {
                return this.e();
            }
            final View o = v.o(this.d);
            this.d += this.e;
            return o;
        }
        
        public View f(final View view) {
            final int size = this.l.size();
            View view2 = null;
            int n = Integer.MAX_VALUE;
            int n2 = 0;
            View view3;
            while (true) {
                view3 = view2;
                if (n2 >= size) {
                    break;
                }
                final View itemView = this.l.get(n2).itemView;
                final p p = (p)itemView.getLayoutParams();
                View view4 = view2;
                int n3 = n;
                if (itemView != view) {
                    if (p.c()) {
                        view4 = view2;
                        n3 = n;
                    }
                    else {
                        final int n4 = (p.a() - this.d) * this.e;
                        if (n4 < 0) {
                            view4 = view2;
                            n3 = n;
                        }
                        else {
                            view4 = view2;
                            if (n4 < (n3 = n)) {
                                final View view5 = itemView;
                                if (n4 == 0) {
                                    view3 = view5;
                                    break;
                                }
                                n3 = n4;
                                view4 = view5;
                            }
                        }
                    }
                }
                ++n2;
                view2 = view4;
                n = n3;
            }
            return view3;
        }
    }
}
