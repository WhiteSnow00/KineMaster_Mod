// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.d;
import s.a;
import java.util.ArrayList;

class k
{
    public static int h;
    public int a;
    public boolean b;
    WidgetRun c;
    WidgetRun d;
    ArrayList<WidgetRun> e;
    int f;
    int g;
    
    public k(final WidgetRun widgetRun, final int g) {
        this.a = 0;
        this.b = false;
        this.c = null;
        this.d = null;
        this.e = new ArrayList<WidgetRun>();
        final int h = k.h;
        this.f = h;
        k.h = h + 1;
        this.c = widgetRun;
        this.d = widgetRun;
        this.g = g;
    }
    
    private long c(DependencyNode h, long n) {
        final WidgetRun d = h.d;
        if (d instanceof i) {
            return n;
        }
        final int size = h.k.size();
        int i = 0;
        long n2 = n;
        while (i < size) {
            final a a = h.k.get(i);
            long min = n2;
            if (a instanceof DependencyNode) {
                final DependencyNode dependencyNode = (DependencyNode)a;
                if (dependencyNode.d == d) {
                    min = n2;
                }
                else {
                    min = Math.min(n2, this.c(dependencyNode, dependencyNode.f + n));
                }
            }
            ++i;
            n2 = min;
        }
        long min2 = n2;
        if (h == d.i) {
            final long j = d.j();
            h = d.h;
            n -= j;
            min2 = Math.min(Math.min(n2, this.c(h, n)), n - d.h.f);
        }
        return min2;
    }
    
    private long d(DependencyNode i, long n) {
        final WidgetRun d = i.d;
        if (d instanceof i) {
            return n;
        }
        final int size = i.k.size();
        int j = 0;
        long n2 = n;
        while (j < size) {
            final a a = i.k.get(j);
            long max = n2;
            if (a instanceof DependencyNode) {
                final DependencyNode dependencyNode = (DependencyNode)a;
                if (dependencyNode.d == d) {
                    max = n2;
                }
                else {
                    max = Math.max(n2, this.d(dependencyNode, dependencyNode.f + n));
                }
            }
            ++j;
            n2 = max;
        }
        long max2 = n2;
        if (i == d.h) {
            final long k = d.j();
            i = d.i;
            n += k;
            max2 = Math.max(Math.max(n2, this.d(i, n)), n - d.i.f);
        }
        return max2;
    }
    
    public void a(final WidgetRun d) {
        this.e.add(d);
        this.d = d;
    }
    
    public long b(final d d, int n) {
        final WidgetRun c = this.c;
        final boolean b = c instanceof c;
        long n2 = 0L;
        if (b) {
            if (((c)c).f != n) {
                return 0L;
            }
        }
        else if (n == 0) {
            if (!(c instanceof j)) {
                return 0L;
            }
        }
        else if (!(c instanceof l)) {
            return 0L;
        }
        WidgetRun widgetRun;
        if (n == 0) {
            widgetRun = d.e;
        }
        else {
            widgetRun = d.f;
        }
        final DependencyNode h = widgetRun.h;
        WidgetRun widgetRun2;
        if (n == 0) {
            widgetRun2 = d.e;
        }
        else {
            widgetRun2 = d.f;
        }
        final DependencyNode i = widgetRun2.i;
        final boolean contains = c.h.l.contains(h);
        final boolean contains2 = this.c.i.l.contains(i);
        final long j = this.c.j();
        long n11;
        if (contains && contains2) {
            final long d2 = this.d(this.c.h, 0L);
            final long c2 = this.c(this.c.i, 0L);
            final long n3 = d2 - j;
            final WidgetRun c3 = this.c;
            final int f = c3.i.f;
            long n4 = n3;
            if (n3 >= -f) {
                n4 = n3 + f;
            }
            final long n5 = -c2;
            final int f2 = c3.h.f;
            long n7;
            final long n6 = n7 = n5 - j - f2;
            if (n6 >= f2) {
                n7 = n6 - f2;
            }
            final float o = c3.b.o(n);
            if (o > 0.0f) {
                n2 = (long)(n7 / o + n4 / (1.0f - o));
            }
            final float n8 = (float)n2;
            final long n9 = (long)(n8 * o + 0.5f);
            final long n10 = (long)(n8 * (1.0f - o) + 0.5f);
            final WidgetRun c4 = this.c;
            n11 = c4.h.f + (n9 + j + n10);
            n = c4.i.f;
        }
        else {
            if (contains) {
                final DependencyNode h2 = this.c.h;
                return Math.max(this.d(h2, h2.f), this.c.h.f + j);
            }
            if (contains2) {
                final DependencyNode k = this.c.i;
                return Math.max(-this.c(k, k.f), -this.c.i.f + j);
            }
            final WidgetRun c5 = this.c;
            n11 = c5.h.f + c5.j();
            n = this.c.i.f;
        }
        return n11 - n;
    }
}
