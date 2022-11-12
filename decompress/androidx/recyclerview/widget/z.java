// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.View;

class z
{
    final b a;
    a b;
    
    z(final b a) {
        this.a = a;
        this.b = new a();
    }
    
    View a(int i, final int n, final int n2, final int n3) {
        final int b = this.a.b();
        final int c = this.a.c();
        int n4;
        if (n > i) {
            n4 = 1;
        }
        else {
            n4 = -1;
        }
        View view = null;
        while (i != n) {
            final View k = this.a.k(i);
            this.b.e(b, c, this.a.a(k), this.a.d(k));
            if (n2 != 0) {
                this.b.d();
                this.b.a(n2);
                if (this.b.b()) {
                    return k;
                }
            }
            View view2 = view;
            if (n3 != 0) {
                this.b.d();
                this.b.a(n3);
                view2 = view;
                if (this.b.b()) {
                    view2 = k;
                }
            }
            i += n4;
            view = view2;
        }
        return view;
    }
    
    boolean b(final View view, final int n) {
        this.b.e(this.a.b(), this.a.c(), this.a.a(view), this.a.d(view));
        if (n != 0) {
            this.b.d();
            this.b.a(n);
            return this.b.b();
        }
        return false;
    }
    
    static class a
    {
        int a;
        int b;
        int c;
        int d;
        int e;
        
        a() {
            this.a = 0;
        }
        
        void a(final int n) {
            this.a |= n;
        }
        
        boolean b() {
            final int a = this.a;
            if ((a & 0x7) != 0x0 && (a & this.c(this.d, this.b) << 0) == 0x0) {
                return false;
            }
            final int a2 = this.a;
            if ((a2 & 0x70) != 0x0 && (a2 & this.c(this.d, this.c) << 4) == 0x0) {
                return false;
            }
            final int a3 = this.a;
            if ((a3 & 0x700) != 0x0 && (a3 & this.c(this.e, this.b) << 8) == 0x0) {
                return false;
            }
            final int a4 = this.a;
            return (a4 & 0x7000) == 0x0 || (a4 & this.c(this.e, this.c) << 12) != 0x0;
        }
        
        int c(final int n, final int n2) {
            if (n > n2) {
                return 1;
            }
            if (n == n2) {
                return 2;
            }
            return 4;
        }
        
        void d() {
            this.a = 0;
        }
        
        void e(final int b, final int c, final int d, final int e) {
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
    }
    
    interface b
    {
        int a(final View p0);
        
        int b();
        
        int c();
        
        int d(final View p0);
        
        View k(final int p0);
    }
}
