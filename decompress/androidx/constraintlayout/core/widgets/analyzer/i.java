// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import java.util.Iterator;
import s.a;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

class i extends WidgetRun
{
    public i(final ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }
    
    private void q(final DependencyNode dependencyNode) {
        super.h.k.add(dependencyNode);
        dependencyNode.l.add(super.h);
    }
    
    @Override
    public void a(final a a) {
        final androidx.constraintlayout.core.widgets.a a2 = (androidx.constraintlayout.core.widgets.a)super.b;
        final int s1 = a2.s1();
        final Iterator<DependencyNode> iterator = super.h.l.iterator();
        int n = 0;
        int n2 = -1;
        while (iterator.hasNext()) {
            final int g = iterator.next().g;
            int n3;
            if (n2 == -1 || g < (n3 = n2)) {
                n3 = g;
            }
            n2 = n3;
            if (n < g) {
                n = g;
                n2 = n3;
            }
        }
        if (s1 != 0 && s1 != 2) {
            super.h.d(n + a2.t1());
        }
        else {
            super.h.d(n2 + a2.t1());
        }
    }
    
    @Override
    void d() {
        final ConstraintWidget b = super.b;
        if (b instanceof androidx.constraintlayout.core.widgets.a) {
            super.h.b = true;
            final androidx.constraintlayout.core.widgets.a a = (androidx.constraintlayout.core.widgets.a)b;
            final int s1 = a.s1();
            final boolean r1 = a.r1();
            final int n = 0;
            final int n2 = 0;
            int i = 0;
            final int n3 = 0;
            if (s1 != 0) {
                if (s1 != 1) {
                    if (s1 != 2) {
                        if (s1 == 3) {
                            super.h.e = DependencyNode.Type.BOTTOM;
                            for (int j = n3; j < a.M0; ++j) {
                                final ConstraintWidget constraintWidget = a.L0[j];
                                if (r1 || constraintWidget.T() != 8) {
                                    final DependencyNode k = constraintWidget.f.i;
                                    k.k.add(super.h);
                                    super.h.l.add(k);
                                }
                            }
                            this.q(super.b.f.h);
                            this.q(super.b.f.i);
                        }
                    }
                    else {
                        super.h.e = DependencyNode.Type.TOP;
                        for (int l = n; l < a.M0; ++l) {
                            final ConstraintWidget constraintWidget2 = a.L0[l];
                            if (r1 || constraintWidget2.T() != 8) {
                                final DependencyNode h = constraintWidget2.f.h;
                                h.k.add(super.h);
                                super.h.l.add(h);
                            }
                        }
                        this.q(super.b.f.h);
                        this.q(super.b.f.i);
                    }
                }
                else {
                    super.h.e = DependencyNode.Type.RIGHT;
                    for (int n4 = n2; n4 < a.M0; ++n4) {
                        final ConstraintWidget constraintWidget3 = a.L0[n4];
                        if (r1 || constraintWidget3.T() != 8) {
                            final DependencyNode m = constraintWidget3.e.i;
                            m.k.add(super.h);
                            super.h.l.add(m);
                        }
                    }
                    this.q(super.b.e.h);
                    this.q(super.b.e.i);
                }
            }
            else {
                super.h.e = DependencyNode.Type.LEFT;
                while (i < a.M0) {
                    final ConstraintWidget constraintWidget4 = a.L0[i];
                    if (r1 || constraintWidget4.T() != 8) {
                        final DependencyNode h2 = constraintWidget4.e.h;
                        h2.k.add(super.h);
                        super.h.l.add(h2);
                    }
                    ++i;
                }
                this.q(super.b.e.h);
                this.q(super.b.e.i);
            }
        }
    }
    
    public void e() {
        final ConstraintWidget b = super.b;
        if (b instanceof androidx.constraintlayout.core.widgets.a) {
            final int s1 = ((androidx.constraintlayout.core.widgets.a)b).s1();
            if (s1 != 0 && s1 != 1) {
                super.b.k1(super.h.g);
            }
            else {
                super.b.j1(super.h.g);
            }
        }
    }
    
    @Override
    void f() {
        super.c = null;
        super.h.c();
    }
    
    @Override
    boolean m() {
        return false;
    }
}
