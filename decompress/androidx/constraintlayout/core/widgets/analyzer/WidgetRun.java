// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import s.a;

public abstract class WidgetRun implements a
{
    public int a;
    ConstraintWidget b;
    k c;
    protected ConstraintWidget.DimensionBehaviour d;
    e e;
    public int f;
    boolean g;
    public DependencyNode h;
    public DependencyNode i;
    protected RunType j;
    
    public WidgetRun(final ConstraintWidget b) {
        this.e = new e(this);
        this.f = 0;
        this.g = false;
        this.h = new DependencyNode(this);
        this.i = new DependencyNode(this);
        this.j = RunType.NONE;
        this.b = b;
    }
    
    private void l(int g, int n) {
        final int a = this.a;
        if (a != 0) {
            if (a != 1) {
                if (a != 2) {
                    if (a == 3) {
                        final ConstraintWidget b = this.b;
                        WidgetRun widgetRun = b.e;
                        final ConstraintWidget.DimensionBehaviour d = widgetRun.d;
                        final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (d == match_CONSTRAINT && widgetRun.a == 3) {
                            final l f = b.f;
                            if (f.d == match_CONSTRAINT && f.a == 3) {
                                return;
                            }
                        }
                        if (g == 0) {
                            widgetRun = b.f;
                        }
                        if (widgetRun.e.j) {
                            final float t = b.t();
                            if (g == 1) {
                                g = (int)(widgetRun.e.g / t + 0.5f);
                            }
                            else {
                                g = (int)(t * widgetRun.e.g + 0.5f);
                            }
                            this.e.d(g);
                        }
                    }
                }
                else {
                    final ConstraintWidget i = this.b.I();
                    if (i != null) {
                        WidgetRun widgetRun2;
                        if (g == 0) {
                            widgetRun2 = i.e;
                        }
                        else {
                            widgetRun2 = i.f;
                        }
                        final e e = widgetRun2.e;
                        if (e.j) {
                            final ConstraintWidget b2 = this.b;
                            float n2;
                            if (g == 0) {
                                n2 = b2.B;
                            }
                            else {
                                n2 = b2.E;
                            }
                            n = (int)(e.g * n2 + 0.5f);
                            this.e.d(this.g(n, g));
                        }
                    }
                }
            }
            else {
                g = this.g(this.e.m, g);
                this.e.d(Math.min(g, n));
            }
        }
        else {
            this.e.d(this.g(n, g));
        }
    }
    
    @Override
    public void a(final a a) {
    }
    
    protected final void b(final DependencyNode dependencyNode, final DependencyNode dependencyNode2, final int f) {
        dependencyNode.l.add(dependencyNode2);
        dependencyNode.f = f;
        dependencyNode2.k.add(dependencyNode);
    }
    
    protected final void c(final DependencyNode dependencyNode, final DependencyNode dependencyNode2, final int h, final e i) {
        dependencyNode.l.add(dependencyNode2);
        dependencyNode.l.add(this.e);
        dependencyNode.h = h;
        dependencyNode.i = i;
        dependencyNode2.k.add(dependencyNode);
        i.k.add(dependencyNode);
    }
    
    abstract void d();
    
    abstract void e();
    
    abstract void f();
    
    protected final int g(final int n, int n2) {
        if (n2 == 0) {
            final ConstraintWidget b = this.b;
            final int a = b.A;
            n2 = Math.max(b.z, n);
            if (a > 0) {
                n2 = Math.min(a, n);
            }
            final int n3;
            if (n2 == (n3 = n)) {
                return n3;
            }
        }
        else {
            final ConstraintWidget b2 = this.b;
            final int d = b2.D;
            n2 = Math.max(b2.C, n);
            if (d > 0) {
                n2 = Math.min(d, n);
            }
            final int n3;
            if (n2 == (n3 = n)) {
                return n3;
            }
        }
        return n2;
    }
    
    protected final DependencyNode h(final ConstraintAnchor constraintAnchor) {
        final ConstraintAnchor f = constraintAnchor.f;
        DependencyNode dependencyNode = null;
        if (f == null) {
            return null;
        }
        final ConstraintWidget d = f.d;
        final int n = WidgetRun$a.a[f.e.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n == 5) {
                            dependencyNode = d.f.i;
                        }
                    }
                    else {
                        dependencyNode = d.f.k;
                    }
                }
                else {
                    dependencyNode = d.f.h;
                }
            }
            else {
                dependencyNode = d.e.i;
            }
        }
        else {
            dependencyNode = d.e.h;
        }
        return dependencyNode;
    }
    
    protected final DependencyNode i(final ConstraintAnchor constraintAnchor, int n) {
        final ConstraintAnchor f = constraintAnchor.f;
        final DependencyNode dependencyNode = null;
        if (f == null) {
            return null;
        }
        final ConstraintWidget d = f.d;
        WidgetRun widgetRun;
        if (n == 0) {
            widgetRun = d.e;
        }
        else {
            widgetRun = d.f;
        }
        n = WidgetRun$a.a[f.e.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n == 3) {
                    return widgetRun.h;
                }
                if (n != 5) {
                    return dependencyNode;
                }
            }
            return widgetRun.i;
        }
        return widgetRun.h;
    }
    
    public long j() {
        final e e = this.e;
        if (e.j) {
            return e.g;
        }
        return 0L;
    }
    
    public boolean k() {
        return this.g;
    }
    
    abstract boolean m();
    
    protected void n(final a a, final ConstraintAnchor constraintAnchor, final ConstraintAnchor constraintAnchor2, int g) {
        final DependencyNode h = this.h(constraintAnchor);
        final DependencyNode h2 = this.h(constraintAnchor2);
        if (h.j) {
            if (h2.j) {
                final int n = h.g + constraintAnchor.e();
                int g2 = h2.g - constraintAnchor2.e();
                final int n2 = g2 - n;
                if (!this.e.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.l(g, n2);
                }
                final e e = this.e;
                if (!e.j) {
                    return;
                }
                if (e.g == n2) {
                    this.h.d(n);
                    this.i.d(g2);
                    return;
                }
                final ConstraintWidget b = this.b;
                float n3;
                if (g == 0) {
                    n3 = b.w();
                }
                else {
                    n3 = b.P();
                }
                g = n;
                if (h == h2) {
                    g = h.g;
                    g2 = h2.g;
                    n3 = 0.5f;
                }
                this.h.d((int)(g + 0.5f + (g2 - g - this.e.g) * n3));
                this.i.d(this.h.g + this.e.g);
            }
        }
    }
    
    protected void o(final a a) {
    }
    
    protected void p(final a a) {
    }
    
    enum RunType
    {
        private static final RunType[] $VALUES;
        
        CENTER, 
        END, 
        NONE, 
        START;
    }
}
