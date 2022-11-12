// 
// Decompiled by Procyon v0.6.0
// 

package r;

import androidx.constraintlayout.core.widgets.analyzer.g;
import androidx.constraintlayout.core.widgets.analyzer.m;
import java.util.ArrayList;
import androidx.constraintlayout.core.widgets.d;
import java.util.Arrays;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class b extends ConstraintWidget implements a
{
    public ConstraintWidget[] L0;
    public int M0;
    
    public b() {
        this.L0 = new ConstraintWidget[4];
        this.M0 = 0;
    }
    
    @Override
    public void a(final ConstraintWidget constraintWidget) {
        if (constraintWidget != this) {
            if (constraintWidget != null) {
                final int m0 = this.M0;
                final ConstraintWidget[] l0 = this.L0;
                if (m0 + 1 > l0.length) {
                    this.L0 = Arrays.copyOf(l0, l0.length * 2);
                }
                final ConstraintWidget[] l2 = this.L0;
                final int m2 = this.M0;
                l2[m2] = constraintWidget;
                this.M0 = m2 + 1;
            }
        }
    }
    
    @Override
    public void b() {
        this.M0 = 0;
        Arrays.fill(this.L0, null);
    }
    
    @Override
    public void c(final d d) {
    }
    
    public void o1(final ArrayList<m> list, final int n, final m m) {
        final int n2 = 0;
        int n3 = 0;
        int i;
        while (true) {
            i = n2;
            if (n3 >= this.M0) {
                break;
            }
            m.a(this.L0[n3]);
            ++n3;
        }
        while (i < this.M0) {
            androidx.constraintlayout.core.widgets.analyzer.g.a(this.L0[i], n, list, m);
            ++i;
        }
    }
    
    public int p1(final int n) {
        for (int i = 0; i < this.M0; ++i) {
            final ConstraintWidget constraintWidget = this.L0[i];
            if (n == 0) {
                final int i2 = constraintWidget.I0;
                if (i2 != -1) {
                    return i2;
                }
            }
            if (n == 1) {
                final int j0 = constraintWidget.J0;
                if (j0 != -1) {
                    return j0;
                }
            }
        }
        return -1;
    }
}
