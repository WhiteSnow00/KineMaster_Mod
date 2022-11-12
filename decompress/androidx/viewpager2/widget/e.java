// 
// Decompiled by Procyon v0.6.0
// 

package androidx.viewpager2.widget;

import android.view.ViewGroup$LayoutParams;
import android.view.View;
import java.util.Locale;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

final class e extends t
{
    private ViewPager2.i a;
    private final ViewPager2 b;
    private final RecyclerView c;
    private final LinearLayoutManager d;
    private int e;
    private int f;
    private a g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    
    e(final ViewPager2 b) {
        this.b = b;
        final RecyclerView j = b.j;
        this.c = j;
        this.d = (LinearLayoutManager)j.getLayoutManager();
        this.g = new a();
        this.l();
    }
    
    private void a(final int n, final float n2, final int n3) {
        final ViewPager2.i a = this.a;
        if (a != null) {
            a.onPageScrolled(n, n2, n3);
        }
    }
    
    private void b(final int n) {
        final ViewPager2.i a = this.a;
        if (a != null) {
            a.onPageSelected(n);
        }
    }
    
    private void c(final int f) {
        if (this.e == 3 && this.f == 0) {
            return;
        }
        if (this.f == f) {
            return;
        }
        this.f = f;
        final ViewPager2.i a = this.a;
        if (a != null) {
            a.onPageScrollStateChanged(f);
        }
    }
    
    private int d() {
        return this.d.i();
    }
    
    private boolean i() {
        final int e = this.e;
        boolean b = true;
        if (e != 1) {
            b = (e == 4 && b);
        }
        return b;
    }
    
    private void l() {
        this.e = 0;
        this.f = 0;
        this.g.a();
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }
    
    private void n(final boolean m) {
        this.m = m;
        int e;
        if (m) {
            e = 4;
        }
        else {
            e = 1;
        }
        this.e = e;
        final int i = this.i;
        if (i != -1) {
            this.h = i;
            this.i = -1;
        }
        else if (this.h == -1) {
            this.h = this.d();
        }
        this.c(1);
    }
    
    private void o() {
        final a g = this.g;
        final int i = this.d.i();
        g.a = i;
        if (i == -1) {
            g.a();
            return;
        }
        final View viewByPosition = this.d.findViewByPosition(i);
        if (viewByPosition == null) {
            g.a();
            return;
        }
        final int leftDecorationWidth = ((RecyclerView.o)this.d).getLeftDecorationWidth(viewByPosition);
        final int rightDecorationWidth = ((RecyclerView.o)this.d).getRightDecorationWidth(viewByPosition);
        final int topDecorationHeight = ((RecyclerView.o)this.d).getTopDecorationHeight(viewByPosition);
        final int bottomDecorationHeight = ((RecyclerView.o)this.d).getBottomDecorationHeight(viewByPosition);
        final ViewGroup$LayoutParams layoutParams = viewByPosition.getLayoutParams();
        int n = leftDecorationWidth;
        int n2 = rightDecorationWidth;
        int n3 = topDecorationHeight;
        int n4 = bottomDecorationHeight;
        if (layoutParams instanceof ViewGroup$MarginLayoutParams) {
            final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)layoutParams;
            n = leftDecorationWidth + viewGroup$MarginLayoutParams.leftMargin;
            n2 = rightDecorationWidth + viewGroup$MarginLayoutParams.rightMargin;
            n3 = topDecorationHeight + viewGroup$MarginLayoutParams.topMargin;
            n4 = bottomDecorationHeight + viewGroup$MarginLayoutParams.bottomMargin;
        }
        final int n5 = viewByPosition.getHeight() + n3 + n4;
        final int width = viewByPosition.getWidth();
        int n8;
        int n9;
        if (this.d.getOrientation() == 0) {
            int n6 = viewByPosition.getLeft() - n - this.c.getPaddingLeft();
            if (this.b.d()) {
                n6 = -n6;
            }
            final int n7 = width + n + n2;
            n8 = n6;
            n9 = n7;
        }
        else {
            n8 = viewByPosition.getTop() - n3 - this.c.getPaddingTop();
            n9 = n5;
        }
        final int c = -n8;
        g.c = c;
        if (c >= 0) {
            float b;
            if (n9 == 0) {
                b = 0.0f;
            }
            else {
                b = c / (float)n9;
            }
            g.b = b;
            return;
        }
        if (new androidx.viewpager2.widget.a(this.d).d()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
        throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", g.c));
    }
    
    double e() {
        this.o();
        final a g = this.g;
        return g.a + (double)g.b;
    }
    
    int f() {
        return this.f;
    }
    
    boolean g() {
        return this.m;
    }
    
    boolean h() {
        return this.f == 0;
    }
    
    void j() {
        this.l = true;
    }
    
    void k(final int i, final boolean b) {
        int e;
        if (b) {
            e = 2;
        }
        else {
            e = 3;
        }
        this.e = e;
        boolean b2 = false;
        this.m = false;
        if (this.i != i) {
            b2 = true;
        }
        this.i = i;
        this.c(2);
        if (b2) {
            this.b(i);
        }
    }
    
    void m(final ViewPager2.i a) {
        this.a = a;
    }
    
    @Override
    public void onScrollStateChanged(final RecyclerView recyclerView, int i) {
        final int e = this.e;
        final boolean b = true;
        if ((e != 1 || this.f != 1) && i == 1) {
            this.n(false);
            return;
        }
        if (this.i() && i == 2) {
            if (this.k) {
                this.c(2);
                this.j = true;
            }
            return;
        }
        if (this.i() && i == 0) {
            this.o();
            int n;
            if (!this.k) {
                final int a = this.g.a;
                n = (b ? 1 : 0);
                if (a != -1) {
                    this.a(a, 0.0f, 0);
                    n = (b ? 1 : 0);
                }
            }
            else {
                final a g = this.g;
                if (g.c == 0) {
                    final int h = this.h;
                    final int a2 = g.a;
                    n = (b ? 1 : 0);
                    if (h != a2) {
                        this.b(a2);
                        n = (b ? 1 : 0);
                    }
                }
                else {
                    n = 0;
                }
            }
            if (n != 0) {
                this.c(0);
                this.l();
            }
        }
        if (this.e == 2 && i == 0 && this.l) {
            this.o();
            final a g2 = this.g;
            if (g2.c == 0) {
                i = this.i;
                final int a3 = g2.a;
                if (i != a3) {
                    if ((i = a3) == -1) {
                        i = 0;
                    }
                    this.b(i);
                }
                this.c(0);
                this.l();
            }
        }
    }
    
    @Override
    public void onScrolled(final RecyclerView recyclerView, int i, int n) {
        this.k = true;
        this.o();
        if (this.j) {
            this.j = false;
            if (n <= 0 && (n != 0 || i < 0 != this.b.d())) {
                i = 0;
            }
            else {
                i = 1;
            }
            Label_0098: {
                if (i != 0) {
                    final a g = this.g;
                    if (g.c != 0) {
                        i = g.a + 1;
                        break Label_0098;
                    }
                }
                i = this.g.a;
            }
            this.i = i;
            if (this.h != i) {
                this.b(i);
            }
        }
        else if (this.e == 0) {
            n = this.g.a;
            if ((i = n) == -1) {
                i = 0;
            }
            this.b(i);
        }
        final a g2 = this.g;
        n = g2.a;
        if ((i = n) == -1) {
            i = 0;
        }
        this.a(i, g2.b, g2.c);
        final a g3 = this.g;
        i = g3.a;
        n = this.i;
        if ((i == n || n == -1) && g3.c == 0 && this.f != 1) {
            this.c(0);
            this.l();
        }
    }
    
    private static final class a
    {
        int a;
        float b;
        int c;
        
        a() {
        }
        
        void a() {
            this.a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }
}
