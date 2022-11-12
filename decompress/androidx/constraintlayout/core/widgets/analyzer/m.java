// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import androidx.constraintlayout.core.widgets.b;
import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

public class m
{
    static int g;
    ArrayList<ConstraintWidget> a;
    int b;
    boolean c;
    int d;
    ArrayList<a> e;
    private int f;
    
    public m(final int d) {
        this.a = new ArrayList<ConstraintWidget>();
        this.c = false;
        this.e = null;
        this.f = -1;
        final int g = m.g;
        m.g = g + 1;
        this.b = g;
        this.d = d;
    }
    
    private String e() {
        final int d = this.d;
        if (d == 0) {
            return "Horizontal";
        }
        if (d == 1) {
            return "Vertical";
        }
        if (d == 2) {
            return "Both";
        }
        return "Unknown";
    }
    
    private int j(final d d, final ArrayList<ConstraintWidget> list, int n) {
        final int n2 = 0;
        final androidx.constraintlayout.core.widgets.d d2 = (androidx.constraintlayout.core.widgets.d)list.get(0).I();
        d.E();
        d2.g(d, false);
        for (int i = 0; i < list.size(); ++i) {
            ((ConstraintWidget)list.get(i)).g(d, false);
        }
        if (n == 0 && d2.W0 > 0) {
            androidx.constraintlayout.core.widgets.b.b(d2, d, list, 0);
        }
        if (n == 1 && d2.X0 > 0) {
            androidx.constraintlayout.core.widgets.b.b(d2, d, list, 1);
        }
        try {
            d.A();
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
        this.e = new ArrayList<a>();
        for (int j = n2; j < list.size(); ++j) {
            this.e.add(new a((ConstraintWidget)list.get(j), d, n));
        }
        int n3;
        if (n == 0) {
            n3 = d.y(d2.O);
            n = d.y(d2.Q);
            d.E();
        }
        else {
            n3 = d.y(d2.P);
            n = d.y(d2.R);
            d.E();
        }
        return n - n3;
    }
    
    public boolean a(final ConstraintWidget constraintWidget) {
        if (this.a.contains(constraintWidget)) {
            return false;
        }
        this.a.add(constraintWidget);
        return true;
    }
    
    public void b(final ArrayList<m> list) {
        final int size = this.a.size();
        if (this.f != -1 && size > 0) {
            for (int i = 0; i < list.size(); ++i) {
                final m m = list.get(i);
                if (this.f == m.b) {
                    this.g(this.d, m);
                }
            }
        }
        if (size == 0) {
            list.remove(this);
        }
    }
    
    public int c() {
        return this.b;
    }
    
    public int d() {
        return this.d;
    }
    
    public int f(final d d, final int n) {
        if (this.a.size() == 0) {
            return 0;
        }
        return this.j(d, this.a, n);
    }
    
    public void g(final int n, final m m) {
        for (final ConstraintWidget constraintWidget : this.a) {
            m.a(constraintWidget);
            if (n == 0) {
                constraintWidget.I0 = m.c();
            }
            else {
                constraintWidget.J0 = m.c();
            }
        }
        this.f = m.b;
    }
    
    public void h(final boolean c) {
        this.c = c;
    }
    
    public void i(final int d) {
        this.d = d;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.e());
        sb.append(" [");
        sb.append(this.b);
        sb.append("] <");
        String s = sb.toString();
        for (final ConstraintWidget constraintWidget : this.a) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(" ");
            sb2.append(constraintWidget.r());
            s = sb2.toString();
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(s);
        sb3.append(" >");
        return sb3.toString();
    }
    
    class a
    {
        WeakReference<ConstraintWidget> a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        final m h;
        
        public a(final m h, final ConstraintWidget constraintWidget, final d d, final int g) {
            this.h = h;
            this.a = new WeakReference<ConstraintWidget>(constraintWidget);
            this.b = d.y(constraintWidget.O);
            this.c = d.y(constraintWidget.P);
            this.d = d.y(constraintWidget.Q);
            this.e = d.y(constraintWidget.R);
            this.f = d.y(constraintWidget.S);
            this.g = g;
        }
    }
}
