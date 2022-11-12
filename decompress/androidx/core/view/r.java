// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

public class r
{
    private ViewParent a;
    private ViewParent b;
    private final View c;
    private boolean d;
    private int[] e;
    
    public r(final View c) {
        this.c = c;
    }
    
    private boolean h(final int n, final int n2, final int n3, final int n4, final int[] array, final int n5, int[] j) {
        if (this.m()) {
            final ViewParent i = this.i(n5);
            if (i == null) {
                return false;
            }
            if (n != 0 || n2 != 0 || n3 != 0 || n4 != 0) {
                int n8;
                int n9;
                if (array != null) {
                    this.c.getLocationInWindow(array);
                    final int n6 = array[0];
                    final int n7 = array[1];
                    n8 = n6;
                    n9 = n7;
                }
                else {
                    n8 = 0;
                    n9 = 0;
                }
                if (j == null) {
                    j = this.j();
                    j[1] = (j[0] = 0);
                }
                g0.d(i, this.c, n, n2, n3, n4, n5, j);
                if (array != null) {
                    this.c.getLocationInWindow(array);
                    array[0] -= n8;
                    array[1] -= n9;
                }
                return true;
            }
            if (array != null) {
                array[1] = (array[0] = 0);
            }
        }
        return false;
    }
    
    private ViewParent i(final int n) {
        if (n == 0) {
            return this.a;
        }
        if (n != 1) {
            return null;
        }
        return this.b;
    }
    
    private int[] j() {
        if (this.e == null) {
            this.e = new int[2];
        }
        return this.e;
    }
    
    private void o(final int n, final ViewParent viewParent) {
        if (n != 0) {
            if (n == 1) {
                this.b = viewParent;
            }
        }
        else {
            this.a = viewParent;
        }
    }
    
    public boolean a(final float n, final float n2, final boolean b) {
        if (this.m()) {
            final ViewParent i = this.i(0);
            if (i != null) {
                return g0.a(i, this.c, n, n2, b);
            }
        }
        return false;
    }
    
    public boolean b(final float n, final float n2) {
        if (this.m()) {
            final ViewParent i = this.i(0);
            if (i != null) {
                return g0.b(i, this.c, n, n2);
            }
        }
        return false;
    }
    
    public boolean c(final int n, final int n2, final int[] array, final int[] array2) {
        return this.d(n, n2, array, array2, 0);
    }
    
    public boolean d(final int n, final int n2, final int[] array, final int[] array2, final int n3) {
        final boolean m = this.m();
        boolean b2;
        final boolean b = b2 = false;
        if (m) {
            final ViewParent i = this.i(n3);
            if (i == null) {
                return false;
            }
            if (n == 0 && n2 == 0) {
                b2 = b;
                if (array2 != null) {
                    array2[1] = (array2[0] = 0);
                    b2 = b;
                }
            }
            else {
                int n4;
                int n5;
                if (array2 != null) {
                    this.c.getLocationInWindow(array2);
                    n4 = array2[0];
                    n5 = array2[1];
                }
                else {
                    n4 = 0;
                    n5 = 0;
                }
                int[] j = array;
                if (array == null) {
                    j = this.j();
                }
                j[1] = (j[0] = 0);
                g0.c(i, this.c, n, n2, j, n3);
                if (array2 != null) {
                    this.c.getLocationInWindow(array2);
                    array2[0] -= n4;
                    array2[1] -= n5;
                }
                if (j[0] == 0) {
                    b2 = b;
                    if (j[1] == 0) {
                        return b2;
                    }
                }
                b2 = true;
            }
        }
        return b2;
    }
    
    public void e(final int n, final int n2, final int n3, final int n4, final int[] array, final int n5, final int[] array2) {
        this.h(n, n2, n3, n4, array, n5, array2);
    }
    
    public boolean f(final int n, final int n2, final int n3, final int n4, final int[] array) {
        return this.h(n, n2, n3, n4, array, 0, null);
    }
    
    public boolean g(final int n, final int n2, final int n3, final int n4, final int[] array, final int n5) {
        return this.h(n, n2, n3, n4, array, n5, null);
    }
    
    public boolean k() {
        return this.l(0);
    }
    
    public boolean l(final int n) {
        return this.i(n) != null;
    }
    
    public boolean m() {
        return this.d;
    }
    
    public void n(final boolean d) {
        if (this.d) {
            b0.M0(this.c);
        }
        this.d = d;
    }
    
    public boolean p(final int n) {
        return this.q(n, 0);
    }
    
    public boolean q(final int n, final int n2) {
        if (this.l(n2)) {
            return true;
        }
        if (this.m()) {
            ViewParent viewParent = this.c.getParent();
            View c = this.c;
            while (viewParent != null) {
                if (g0.f(viewParent, c, this.c, n, n2)) {
                    this.o(n2, viewParent);
                    g0.e(viewParent, c, this.c, n, n2);
                    return true;
                }
                if (viewParent instanceof View) {
                    c = (View)viewParent;
                }
                viewParent = viewParent.getParent();
            }
        }
        return false;
    }
    
    public void r() {
        this.s(0);
    }
    
    public void s(final int n) {
        final ViewParent i = this.i(n);
        if (i != null) {
            g0.g(i, this.c, n);
            this.o(n, null);
        }
    }
}
