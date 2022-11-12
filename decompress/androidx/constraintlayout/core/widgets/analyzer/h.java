// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import s.a;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

class h extends WidgetRun
{
    public h(final ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.e.f();
        constraintWidget.f.f();
        super.f = ((e)constraintWidget).p1();
    }
    
    private void q(final DependencyNode dependencyNode) {
        super.h.k.add(dependencyNode);
        dependencyNode.l.add(super.h);
    }
    
    @Override
    public void a(final a a) {
        final DependencyNode h = super.h;
        if (!h.c) {
            return;
        }
        if (h.j) {
            return;
        }
        super.h.d((int)(h.l.get(0).g * ((e)super.b).s1() + 0.5f));
    }
    
    @Override
    void d() {
        final e e = (e)super.b;
        final int q1 = e.q1();
        final int r1 = e.r1();
        e.s1();
        if (e.p1() == 1) {
            if (q1 != -1) {
                super.h.l.add(super.b.a0.e.h);
                super.b.a0.e.h.k.add(super.h);
                super.h.f = q1;
            }
            else if (r1 != -1) {
                super.h.l.add(super.b.a0.e.i);
                super.b.a0.e.i.k.add(super.h);
                super.h.f = -r1;
            }
            else {
                final DependencyNode h = super.h;
                h.b = true;
                h.l.add(super.b.a0.e.i);
                super.b.a0.e.i.k.add(super.h);
            }
            this.q(super.b.e.h);
            this.q(super.b.e.i);
        }
        else {
            if (q1 != -1) {
                super.h.l.add(super.b.a0.f.h);
                super.b.a0.f.h.k.add(super.h);
                super.h.f = q1;
            }
            else if (r1 != -1) {
                super.h.l.add(super.b.a0.f.i);
                super.b.a0.f.i.k.add(super.h);
                super.h.f = -r1;
            }
            else {
                final DependencyNode h2 = super.h;
                h2.b = true;
                h2.l.add(super.b.a0.f.i);
                super.b.a0.f.i.k.add(super.h);
            }
            this.q(super.b.f.h);
            this.q(super.b.f.i);
        }
    }
    
    public void e() {
        if (((e)super.b).p1() == 1) {
            super.b.j1(super.h.g);
        }
        else {
            super.b.k1(super.h.g);
        }
    }
    
    @Override
    void f() {
        super.h.c();
    }
    
    @Override
    boolean m() {
        return false;
    }
}
