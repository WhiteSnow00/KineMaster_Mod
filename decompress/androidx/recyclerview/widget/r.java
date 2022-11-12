// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import java.util.List;

class r
{
    final a a;
    
    r(final a a) {
        this.a = a;
    }
    
    private int a(final List<androidx.recyclerview.widget.a.b> list) {
        int i = list.size() - 1;
        int n = 0;
        while (i >= 0) {
            int n2;
            if (((androidx.recyclerview.widget.a.b)list.get(i)).a == 8) {
                if ((n2 = n) != 0) {
                    return i;
                }
            }
            else {
                n2 = 1;
            }
            --i;
            n = n2;
        }
        return -1;
    }
    
    private void c(final List<androidx.recyclerview.widget.a.b> list, final int n, final androidx.recyclerview.widget.a.b b, final int n2, final androidx.recyclerview.widget.a.b b2) {
        final int d = b.d;
        final int b3 = b2.b;
        int n3;
        if (d < b3) {
            n3 = -1;
        }
        else {
            n3 = 0;
        }
        final int b4 = b.b;
        int n4 = n3;
        if (b4 < b3) {
            n4 = n3 + 1;
        }
        if (b3 <= b4) {
            b.b = b4 + b2.d;
        }
        final int b5 = b2.b;
        if (b5 <= d) {
            b.d = d + b2.d;
        }
        b2.b = b5 + n4;
        list.set(n, b2);
        list.set(n2, b);
    }
    
    private void d(final List<androidx.recyclerview.widget.a.b> list, final int n, final int n2) {
        final androidx.recyclerview.widget.a.b b = list.get(n);
        final androidx.recyclerview.widget.a.b b2 = list.get(n2);
        final int a = b2.a;
        if (a != 1) {
            if (a != 2) {
                if (a == 4) {
                    this.f(list, n, b, n2, b2);
                }
            }
            else {
                this.e(list, n, b, n2, b2);
            }
        }
        else {
            this.c(list, n, b, n2, b2);
        }
    }
    
    void b(final List<androidx.recyclerview.widget.a.b> list) {
        while (true) {
            final int a = this.a(list);
            if (a == -1) {
                break;
            }
            this.d(list, a, a + 1);
        }
    }
    
    void e(final List<androidx.recyclerview.widget.a.b> list, final int n, final androidx.recyclerview.widget.a.b b, final int n2, final androidx.recyclerview.widget.a.b b2) {
        final int b3 = b.b;
        final int d = b.d;
        boolean b4 = false;
        boolean b5;
        if (b3 < d) {
            if (b2.b == b3 && b2.d == d - b3) {
                b5 = false;
                b4 = true;
            }
            else {
                b5 = false;
            }
        }
        else if (b2.b == d + 1 && b2.d == b3 - d) {
            b5 = true;
            b4 = true;
        }
        else {
            b5 = true;
        }
        final int b6 = b2.b;
        if (d < b6) {
            b2.b = b6 - 1;
        }
        else {
            final int d2 = b2.d;
            if (d < b6 + d2) {
                b2.d = d2 - 1;
                b.a = 2;
                b.d = 1;
                if (b2.d == 0) {
                    list.remove(n2);
                    this.a.b(b2);
                }
                return;
            }
        }
        final int b7 = b.b;
        final int b8 = b2.b;
        androidx.recyclerview.widget.a.b a = null;
        if (b7 <= b8) {
            b2.b = b8 + 1;
        }
        else {
            final int d3 = b2.d;
            if (b7 < b8 + d3) {
                a = this.a.a(2, b7 + 1, b8 + d3 - b7, null);
                b2.d = b.b - b2.b;
            }
        }
        if (b4) {
            list.set(n, b2);
            list.remove(n2);
            this.a.b(b);
            return;
        }
        if (b5) {
            if (a != null) {
                final int b9 = b.b;
                if (b9 > a.b) {
                    b.b = b9 - a.d;
                }
                final int d4 = b.d;
                if (d4 > a.b) {
                    b.d = d4 - a.d;
                }
            }
            final int b10 = b.b;
            if (b10 > b2.b) {
                b.b = b10 - b2.d;
            }
            final int d5 = b.d;
            if (d5 > b2.b) {
                b.d = d5 - b2.d;
            }
        }
        else {
            if (a != null) {
                final int b11 = b.b;
                if (b11 >= a.b) {
                    b.b = b11 - a.d;
                }
                final int d6 = b.d;
                if (d6 >= a.b) {
                    b.d = d6 - a.d;
                }
            }
            final int b12 = b.b;
            if (b12 >= b2.b) {
                b.b = b12 - b2.d;
            }
            final int d7 = b.d;
            if (d7 >= b2.b) {
                b.d = d7 - b2.d;
            }
        }
        list.set(n, b2);
        if (b.b != b.d) {
            list.set(n2, b);
        }
        else {
            list.remove(n2);
        }
        if (a != null) {
            list.add(n, a);
        }
    }
    
    void f(final List<androidx.recyclerview.widget.a.b> list, final int n, final androidx.recyclerview.widget.a.b b, final int n2, final androidx.recyclerview.widget.a.b b2) {
        final int d = b.d;
        final int b3 = b2.b;
        androidx.recyclerview.widget.a.b a = null;
        androidx.recyclerview.widget.a.b a2 = null;
        Label_0089: {
            if (d < b3) {
                b2.b = b3 - 1;
            }
            else {
                final int d2 = b2.d;
                if (d < b3 + d2) {
                    b2.d = d2 - 1;
                    a2 = this.a.a(4, b.b, 1, b2.c);
                    break Label_0089;
                }
            }
            a2 = null;
        }
        final int b4 = b.b;
        final int b5 = b2.b;
        if (b4 <= b5) {
            b2.b = b5 + 1;
        }
        else {
            final int d3 = b2.d;
            if (b4 < b5 + d3) {
                final int n3 = b5 + d3 - b4;
                a = this.a.a(4, b4 + 1, n3, b2.c);
                b2.d -= n3;
            }
        }
        list.set(n2, b);
        if (b2.d > 0) {
            list.set(n, b2);
        }
        else {
            list.remove(n);
            this.a.b(b2);
        }
        if (a2 != null) {
            list.add(n, a2);
        }
        if (a != null) {
            list.add(n, a);
        }
    }
    
    interface a
    {
        androidx.recyclerview.widget.a.b a(final int p0, final int p1, final int p2, final Object p3);
        
        void b(final androidx.recyclerview.widget.a.b p0);
    }
}
