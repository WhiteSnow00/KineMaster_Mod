// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import java.util.Collection;
import java.util.HashSet;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Iterator;
import s.a;
import java.util.ArrayList;

public class d
{
    private androidx.constraintlayout.core.widgets.d a;
    private boolean b;
    private boolean c;
    private androidx.constraintlayout.core.widgets.d d;
    private ArrayList<WidgetRun> e;
    private ArrayList<k> f;
    private b.b g;
    private b.a h;
    ArrayList<k> i;
    
    public d(final androidx.constraintlayout.core.widgets.d d) {
        this.b = true;
        this.c = true;
        this.e = new ArrayList<WidgetRun>();
        this.f = new ArrayList<k>();
        this.g = null;
        this.h = new b.a();
        this.i = new ArrayList<k>();
        this.a = d;
        this.d = d;
    }
    
    private void a(final DependencyNode dependencyNode, final int n, final int n2, final DependencyNode dependencyNode2, final ArrayList<k> list, final k k) {
        final WidgetRun d = dependencyNode.d;
        if (d.c == null) {
            final androidx.constraintlayout.core.widgets.d a = this.a;
            if (d != a.e) {
                if (d != a.f) {
                    k c;
                    if ((c = k) == null) {
                        c = new k(d, n2);
                        list.add(c);
                    }
                    (d.c = c).a(d);
                    for (final a a2 : d.h.k) {
                        if (a2 instanceof DependencyNode) {
                            this.a((DependencyNode)a2, n, 0, dependencyNode2, list, c);
                        }
                    }
                    for (final a a3 : d.i.k) {
                        if (a3 instanceof DependencyNode) {
                            this.a((DependencyNode)a3, n, 1, dependencyNode2, list, c);
                        }
                    }
                    if (n == 1 && d instanceof l) {
                        for (final a a4 : ((l)d).k.k) {
                            if (a4 instanceof DependencyNode) {
                                this.a((DependencyNode)a4, n, 2, dependencyNode2, list, c);
                            }
                        }
                    }
                    for (final DependencyNode dependencyNode3 : d.h.l) {
                        if (dependencyNode3 == dependencyNode2) {
                            c.b = true;
                        }
                        this.a(dependencyNode3, n, 0, dependencyNode2, list, c);
                    }
                    for (final DependencyNode dependencyNode4 : d.i.l) {
                        if (dependencyNode4 == dependencyNode2) {
                            c.b = true;
                        }
                        this.a(dependencyNode4, n, 1, dependencyNode2, list, c);
                    }
                    if (n == 1 && d instanceof l) {
                        final Iterator<DependencyNode> iterator6 = ((l)d).k.l.iterator();
                        while (iterator6.hasNext()) {
                            this.a(iterator6.next(), n, 2, dependencyNode2, list, c);
                        }
                    }
                }
            }
        }
    }
    
    private boolean b(final androidx.constraintlayout.core.widgets.d d) {
        for (final ConstraintWidget constraintWidget : d.L0) {
            final ConstraintWidget.DimensionBehaviour[] z = constraintWidget.Z;
            final ConstraintWidget.DimensionBehaviour dimensionBehaviour = z[0];
            final ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = z[1];
            if (constraintWidget.T() == 8) {
                constraintWidget.a = true;
            }
            else {
                if (constraintWidget.B < 1.0f && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.w = 2;
                }
                if (constraintWidget.E < 1.0f && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.x = 2;
                }
                if (constraintWidget.t() > 0.0f) {
                    final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour == match_CONSTRAINT && (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.w = 3;
                    }
                    else if (dimensionBehaviour2 == match_CONSTRAINT && (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.x = 3;
                    }
                    else if (dimensionBehaviour == match_CONSTRAINT && dimensionBehaviour2 == match_CONSTRAINT) {
                        if (constraintWidget.w == 0) {
                            constraintWidget.w = 3;
                        }
                        if (constraintWidget.x == 0) {
                            constraintWidget.x = 3;
                        }
                    }
                }
                final ConstraintWidget.DimensionBehaviour match_CONSTRAINT2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                Enum<ConstraintWidget.DimensionBehaviour> d2 = null;
                Label_0298: {
                    if ((d2 = dimensionBehaviour) == match_CONSTRAINT2) {
                        d2 = dimensionBehaviour;
                        if (constraintWidget.w == 1) {
                            if (constraintWidget.O.f != null) {
                                d2 = dimensionBehaviour;
                                if (constraintWidget.Q.f != null) {
                                    break Label_0298;
                                }
                            }
                            d2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        }
                    }
                }
                Enum<ConstraintWidget.DimensionBehaviour> d3 = null;
                Label_0353: {
                    if ((d3 = dimensionBehaviour2) == match_CONSTRAINT2) {
                        d3 = dimensionBehaviour2;
                        if (constraintWidget.x == 1) {
                            if (constraintWidget.P.f != null) {
                                d3 = dimensionBehaviour2;
                                if (constraintWidget.R.f != null) {
                                    break Label_0353;
                                }
                            }
                            d3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        }
                    }
                }
                final j e = constraintWidget.e;
                e.d = (ConstraintWidget.DimensionBehaviour)d2;
                final int w = constraintWidget.w;
                e.a = w;
                final l f = constraintWidget.f;
                f.d = (ConstraintWidget.DimensionBehaviour)d3;
                final int x = constraintWidget.x;
                f.a = x;
                final ConstraintWidget.DimensionBehaviour match_PARENT = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((d2 == match_PARENT || d2 == ConstraintWidget.DimensionBehaviour.FIXED || d2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (d3 == match_PARENT || d3 == ConstraintWidget.DimensionBehaviour.FIXED || d3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    int u = constraintWidget.U();
                    if (d2 == match_PARENT) {
                        final int u2 = d.U();
                        final int g = constraintWidget.O.g;
                        final int g2 = constraintWidget.Q.g;
                        d2 = ConstraintWidget.DimensionBehaviour.FIXED;
                        u = u2 - g - g2;
                    }
                    int v = constraintWidget.v();
                    if (d3 == match_PARENT) {
                        final int v2 = d.v();
                        final int g3 = constraintWidget.P.g;
                        final int g4 = constraintWidget.R.g;
                        d3 = ConstraintWidget.DimensionBehaviour.FIXED;
                        v = v2 - g3 - g4;
                    }
                    this.l(constraintWidget, (ConstraintWidget.DimensionBehaviour)d2, u, (ConstraintWidget.DimensionBehaviour)d3, v);
                    constraintWidget.e.e.d(constraintWidget.U());
                    constraintWidget.f.e.d(constraintWidget.v());
                    constraintWidget.a = true;
                }
                else {
                    if (d2 == match_CONSTRAINT2) {
                        final ConstraintWidget.DimensionBehaviour wrap_CONTENT = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        if (d3 == wrap_CONTENT || d3 == ConstraintWidget.DimensionBehaviour.FIXED) {
                            if (w == 3) {
                                if (d3 == wrap_CONTENT) {
                                    this.l(constraintWidget, wrap_CONTENT, 0, wrap_CONTENT, 0);
                                }
                                final int v3 = constraintWidget.v();
                                final int n = (int)(v3 * constraintWidget.d0 + 0.5f);
                                final ConstraintWidget.DimensionBehaviour fixed = ConstraintWidget.DimensionBehaviour.FIXED;
                                this.l(constraintWidget, fixed, n, fixed, v3);
                                constraintWidget.e.e.d(constraintWidget.U());
                                constraintWidget.f.e.d(constraintWidget.v());
                                constraintWidget.a = true;
                                continue;
                            }
                            if (w == 1) {
                                this.l(constraintWidget, wrap_CONTENT, 0, (ConstraintWidget.DimensionBehaviour)d3, 0);
                                constraintWidget.e.e.m = constraintWidget.U();
                                continue;
                            }
                            if (w == 2) {
                                final ConstraintWidget.DimensionBehaviour[] z2 = d.Z;
                                final ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = z2[0];
                                final ConstraintWidget.DimensionBehaviour fixed2 = ConstraintWidget.DimensionBehaviour.FIXED;
                                if (dimensionBehaviour3 == fixed2 || z2[0] == match_PARENT) {
                                    this.l(constraintWidget, fixed2, (int)(constraintWidget.B * d.U() + 0.5f), (ConstraintWidget.DimensionBehaviour)d3, constraintWidget.v());
                                    constraintWidget.e.e.d(constraintWidget.U());
                                    constraintWidget.f.e.d(constraintWidget.v());
                                    constraintWidget.a = true;
                                    continue;
                                }
                            }
                            else {
                                final ConstraintAnchor[] w2 = constraintWidget.W;
                                if (w2[0].f == null || w2[1].f == null) {
                                    this.l(constraintWidget, wrap_CONTENT, 0, (ConstraintWidget.DimensionBehaviour)d3, 0);
                                    constraintWidget.e.e.d(constraintWidget.U());
                                    constraintWidget.f.e.d(constraintWidget.v());
                                    constraintWidget.a = true;
                                    continue;
                                }
                            }
                        }
                    }
                    if (d3 == match_CONSTRAINT2) {
                        final ConstraintWidget.DimensionBehaviour wrap_CONTENT2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        if (d2 == wrap_CONTENT2 || d2 == ConstraintWidget.DimensionBehaviour.FIXED) {
                            if (x == 3) {
                                if (d2 == wrap_CONTENT2) {
                                    this.l(constraintWidget, wrap_CONTENT2, 0, wrap_CONTENT2, 0);
                                }
                                final int u3 = constraintWidget.U();
                                float d4 = constraintWidget.d0;
                                if (constraintWidget.u() == -1) {
                                    d4 = 1.0f / d4;
                                }
                                final int n2 = (int)(u3 * d4 + 0.5f);
                                final ConstraintWidget.DimensionBehaviour fixed3 = ConstraintWidget.DimensionBehaviour.FIXED;
                                this.l(constraintWidget, fixed3, u3, fixed3, n2);
                                constraintWidget.e.e.d(constraintWidget.U());
                                constraintWidget.f.e.d(constraintWidget.v());
                                constraintWidget.a = true;
                                continue;
                            }
                            if (x == 1) {
                                this.l(constraintWidget, (ConstraintWidget.DimensionBehaviour)d2, 0, wrap_CONTENT2, 0);
                                constraintWidget.f.e.m = constraintWidget.v();
                                continue;
                            }
                            if (x == 2) {
                                final ConstraintWidget.DimensionBehaviour[] z3 = d.Z;
                                final ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = z3[1];
                                final ConstraintWidget.DimensionBehaviour fixed4 = ConstraintWidget.DimensionBehaviour.FIXED;
                                if (dimensionBehaviour4 == fixed4 || z3[1] == match_PARENT) {
                                    this.l(constraintWidget, (ConstraintWidget.DimensionBehaviour)d2, constraintWidget.U(), fixed4, (int)(constraintWidget.E * d.v() + 0.5f));
                                    constraintWidget.e.e.d(constraintWidget.U());
                                    constraintWidget.f.e.d(constraintWidget.v());
                                    constraintWidget.a = true;
                                    continue;
                                }
                            }
                            else {
                                final ConstraintAnchor[] w3 = constraintWidget.W;
                                if (w3[2].f == null || w3[3].f == null) {
                                    this.l(constraintWidget, wrap_CONTENT2, 0, (ConstraintWidget.DimensionBehaviour)d3, 0);
                                    constraintWidget.e.e.d(constraintWidget.U());
                                    constraintWidget.f.e.d(constraintWidget.v());
                                    constraintWidget.a = true;
                                    continue;
                                }
                            }
                        }
                    }
                    if (d2 != match_CONSTRAINT2 || d3 != match_CONSTRAINT2) {
                        continue;
                    }
                    if (w != 1 && x != 1) {
                        if (x != 2 || w != 2) {
                            continue;
                        }
                        final ConstraintWidget.DimensionBehaviour[] z4 = d.Z;
                        final ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = z4[0];
                        final ConstraintWidget.DimensionBehaviour fixed5 = ConstraintWidget.DimensionBehaviour.FIXED;
                        if (dimensionBehaviour5 != fixed5 || z4[1] != fixed5) {
                            continue;
                        }
                        this.l(constraintWidget, fixed5, (int)(constraintWidget.B * d.U() + 0.5f), fixed5, (int)(constraintWidget.E * d.v() + 0.5f));
                        constraintWidget.e.e.d(constraintWidget.U());
                        constraintWidget.f.e.d(constraintWidget.v());
                        constraintWidget.a = true;
                    }
                    else {
                        final ConstraintWidget.DimensionBehaviour wrap_CONTENT3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        this.l(constraintWidget, wrap_CONTENT3, 0, wrap_CONTENT3, 0);
                        constraintWidget.e.e.m = constraintWidget.U();
                        constraintWidget.f.e.m = constraintWidget.v();
                    }
                }
            }
        }
        return false;
    }
    
    private int e(final androidx.constraintlayout.core.widgets.d d, final int n) {
        final int size = this.i.size();
        long max = 0L;
        for (int i = 0; i < size; ++i) {
            max = Math.max(max, this.i.get(i).b(d, n));
        }
        return (int)max;
    }
    
    private void i(final WidgetRun widgetRun, final int n, final ArrayList<k> list) {
        for (final a a : widgetRun.h.k) {
            if (a instanceof DependencyNode) {
                this.a((DependencyNode)a, n, 0, widgetRun.i, list, null);
            }
            else {
                if (!(a instanceof WidgetRun)) {
                    continue;
                }
                this.a(((WidgetRun)a).h, n, 0, widgetRun.i, list, null);
            }
        }
        for (final a a2 : widgetRun.i.k) {
            if (a2 instanceof DependencyNode) {
                this.a((DependencyNode)a2, n, 1, widgetRun.h, list, null);
            }
            else {
                if (!(a2 instanceof WidgetRun)) {
                    continue;
                }
                this.a(((WidgetRun)a2).i, n, 1, widgetRun.h, list, null);
            }
        }
        if (n == 1) {
            for (final a a3 : ((l)widgetRun).k.k) {
                if (a3 instanceof DependencyNode) {
                    this.a((DependencyNode)a3, n, 2, null, list, null);
                }
            }
        }
    }
    
    private void l(final ConstraintWidget constraintWidget, final ConstraintWidget.DimensionBehaviour a, final int c, final ConstraintWidget.DimensionBehaviour b, final int d) {
        final b.a h = this.h;
        h.a = a;
        h.b = b;
        h.c = c;
        h.d = d;
        this.g.b(constraintWidget, h);
        constraintWidget.h1(this.h.e);
        constraintWidget.I0(this.h.f);
        constraintWidget.H0(this.h.h);
        constraintWidget.x0(this.h.g);
    }
    
    public void c() {
        this.d(this.e);
        this.i.clear();
        k.h = 0;
        this.i(this.a.e, 0, this.i);
        this.i(this.a.f, 1, this.i);
        this.b = false;
    }
    
    public void d(final ArrayList<WidgetRun> list) {
        list.clear();
        this.d.e.f();
        this.d.f.f();
        list.add(this.d.e);
        list.add(this.d.f);
        final Iterator<ConstraintWidget> iterator = this.d.L0.iterator();
        Collection<? extends j> collection = null;
        while (iterator.hasNext()) {
            final ConstraintWidget constraintWidget = iterator.next();
            if (constraintWidget instanceof e) {
                list.add(new h(constraintWidget));
            }
            else {
                if (constraintWidget.g0()) {
                    if (constraintWidget.c == null) {
                        constraintWidget.c = new c(constraintWidget, 0);
                    }
                    HashSet<? extends j> set;
                    if ((set = (HashSet<? extends j>)collection) == null) {
                        set = new HashSet<j>();
                    }
                    set.add((j)constraintWidget.c);
                    collection = set;
                }
                else {
                    list.add(constraintWidget.e);
                }
                HashSet<? extends j> set2;
                if (constraintWidget.i0()) {
                    if (constraintWidget.d == null) {
                        constraintWidget.d = new c(constraintWidget, 1);
                    }
                    if ((set2 = (HashSet<? extends j>)collection) == null) {
                        set2 = new HashSet<j>();
                    }
                    set2.add((j)constraintWidget.d);
                }
                else {
                    list.add(constraintWidget.f);
                    set2 = (HashSet<? extends j>)collection;
                }
                collection = set2;
                if (!(constraintWidget instanceof r.b)) {
                    continue;
                }
                list.add(new i(constraintWidget));
                collection = set2;
            }
        }
        if (collection != null) {
            list.addAll(collection);
        }
        final Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            ((WidgetRun)iterator2.next()).f();
        }
        for (final WidgetRun widgetRun : list) {
            if (widgetRun.b == this.d) {
                continue;
            }
            widgetRun.d();
        }
    }
    
    public boolean f(final boolean b) {
        final boolean b2 = true;
        final boolean b3 = b & true;
        if (this.b || this.c) {
            for (final ConstraintWidget constraintWidget : this.a.L0) {
                constraintWidget.l();
                constraintWidget.a = false;
                constraintWidget.e.r();
                constraintWidget.f.q();
            }
            this.a.l();
            final androidx.constraintlayout.core.widgets.d a = this.a;
            a.a = false;
            a.e.r();
            this.a.f.q();
            this.c = false;
        }
        if (this.b(this.d)) {
            return false;
        }
        this.a.j1(0);
        this.a.k1(0);
        final ConstraintWidget.DimensionBehaviour s = this.a.s(0);
        final ConstraintWidget.DimensionBehaviour s2 = this.a.s(1);
        if (this.b) {
            this.c();
        }
        final int v = this.a.V();
        final int w = this.a.W();
        this.a.e.h.d(v);
        this.a.f.h.d(w);
        this.m();
        final ConstraintWidget.DimensionBehaviour wrap_CONTENT = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (s == wrap_CONTENT || s2 == wrap_CONTENT) {
            boolean b4 = false;
            Label_0303: {
                if (b4 = b3) {
                    final Iterator<WidgetRun> iterator2 = this.e.iterator();
                    do {
                        b4 = b3;
                        if (iterator2.hasNext()) {
                            continue;
                        }
                        break Label_0303;
                    } while (iterator2.next().m());
                    b4 = false;
                }
            }
            if (b4 && s == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.a.M0(ConstraintWidget.DimensionBehaviour.FIXED);
                final androidx.constraintlayout.core.widgets.d a2 = this.a;
                a2.h1(this.e(a2, 0));
                final androidx.constraintlayout.core.widgets.d a3 = this.a;
                a3.e.e.d(a3.U());
            }
            if (b4 && s2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.a.d1(ConstraintWidget.DimensionBehaviour.FIXED);
                final androidx.constraintlayout.core.widgets.d a4 = this.a;
                a4.I0(this.e(a4, 1));
                final androidx.constraintlayout.core.widgets.d a5 = this.a;
                a5.f.e.d(a5.v());
            }
        }
        final androidx.constraintlayout.core.widgets.d a6 = this.a;
        final ConstraintWidget.DimensionBehaviour[] z = a6.Z;
        final ConstraintWidget.DimensionBehaviour dimensionBehaviour = z[0];
        final ConstraintWidget.DimensionBehaviour fixed = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean b5;
        if (dimensionBehaviour != fixed && z[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            b5 = false;
        }
        else {
            final int n = a6.U() + v;
            this.a.e.i.d(n);
            this.a.e.e.d(n - v);
            this.m();
            final androidx.constraintlayout.core.widgets.d a7 = this.a;
            final ConstraintWidget.DimensionBehaviour[] z2 = a7.Z;
            if (z2[1] == fixed || z2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                final int n2 = a7.v() + w;
                this.a.f.i.d(n2);
                this.a.f.e.d(n2 - w);
            }
            this.m();
            b5 = true;
        }
        for (final WidgetRun widgetRun : this.e) {
            if (widgetRun.b == this.a && !widgetRun.g) {
                continue;
            }
            widgetRun.e();
        }
        final Iterator<WidgetRun> iterator4 = this.e.iterator();
        boolean b6 = false;
        Label_0781: {
            while (true) {
                b6 = b2;
                if (!iterator4.hasNext()) {
                    break Label_0781;
                }
                final WidgetRun widgetRun2 = iterator4.next();
                if (!b5 && widgetRun2.b == this.a) {
                    continue;
                }
                if (!widgetRun2.h.j) {
                    break;
                }
                if (!widgetRun2.i.j && !(widgetRun2 instanceof h)) {
                    break;
                }
                if (!widgetRun2.e.j && !(widgetRun2 instanceof c) && !(widgetRun2 instanceof h)) {
                    break;
                }
            }
            b6 = false;
        }
        this.a.M0(s);
        this.a.d1(s2);
        return b6;
    }
    
    public boolean g(final boolean b) {
        if (this.b) {
            for (final ConstraintWidget constraintWidget : this.a.L0) {
                constraintWidget.l();
                constraintWidget.a = false;
                final j e = constraintWidget.e;
                e.e.j = false;
                e.g = false;
                e.r();
                final l f = constraintWidget.f;
                f.e.j = false;
                f.g = false;
                f.q();
            }
            this.a.l();
            final androidx.constraintlayout.core.widgets.d a = this.a;
            a.a = false;
            final j e2 = a.e;
            e2.e.j = false;
            e2.g = false;
            e2.r();
            final l f2 = this.a.f;
            f2.e.j = false;
            f2.g = false;
            f2.q();
            this.c();
        }
        if (this.b(this.d)) {
            return false;
        }
        this.a.j1(0);
        this.a.k1(0);
        this.a.e.h.d(0);
        this.a.f.h.d(0);
        return true;
    }
    
    public boolean h(final boolean b, final int n) {
        final boolean b2 = true;
        final boolean b3 = b & true;
        final ConstraintWidget.DimensionBehaviour s = this.a.s(0);
        final ConstraintWidget.DimensionBehaviour s2 = this.a.s(1);
        final int v = this.a.V();
        final int w = this.a.W();
        Label_0254: {
            if (b3) {
                final ConstraintWidget.DimensionBehaviour wrap_CONTENT = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (s == wrap_CONTENT || s2 == wrap_CONTENT) {
                    final Iterator<WidgetRun> iterator = this.e.iterator();
                    while (true) {
                        WidgetRun widgetRun;
                        do {
                            final boolean b4 = b3;
                            if (iterator.hasNext()) {
                                widgetRun = iterator.next();
                            }
                            else if (n == 0) {
                                if (b4 && s == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                                    this.a.M0(ConstraintWidget.DimensionBehaviour.FIXED);
                                    final androidx.constraintlayout.core.widgets.d a = this.a;
                                    a.h1(this.e(a, 0));
                                    final androidx.constraintlayout.core.widgets.d a2 = this.a;
                                    a2.e.e.d(a2.U());
                                }
                                break Label_0254;
                            }
                            else {
                                if (b4 && s2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                                    this.a.d1(ConstraintWidget.DimensionBehaviour.FIXED);
                                    final androidx.constraintlayout.core.widgets.d a3 = this.a;
                                    a3.I0(this.e(a3, 1));
                                    final androidx.constraintlayout.core.widgets.d a4 = this.a;
                                    a4.f.e.d(a4.v());
                                }
                                break Label_0254;
                            }
                        } while (widgetRun.f != n || widgetRun.m());
                        final boolean b4 = false;
                        continue;
                    }
                }
            }
        }
        boolean b5 = false;
        Label_0417: {
            Label_0415: {
                if (n == 0) {
                    final androidx.constraintlayout.core.widgets.d a5 = this.a;
                    final ConstraintWidget.DimensionBehaviour[] z = a5.Z;
                    if (z[0] == ConstraintWidget.DimensionBehaviour.FIXED || z[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        final int n2 = a5.U() + v;
                        this.a.e.i.d(n2);
                        this.a.e.e.d(n2 - v);
                        break Label_0415;
                    }
                }
                else {
                    final androidx.constraintlayout.core.widgets.d a6 = this.a;
                    final ConstraintWidget.DimensionBehaviour[] z2 = a6.Z;
                    if (z2[1] == ConstraintWidget.DimensionBehaviour.FIXED || z2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        final int n3 = a6.v() + w;
                        this.a.f.i.d(n3);
                        this.a.f.e.d(n3 - w);
                        break Label_0415;
                    }
                }
                b5 = false;
                break Label_0417;
            }
            b5 = true;
        }
        this.m();
        for (final WidgetRun widgetRun2 : this.e) {
            if (widgetRun2.f != n) {
                continue;
            }
            if (widgetRun2.b == this.a && !widgetRun2.g) {
                continue;
            }
            widgetRun2.e();
        }
        final Iterator<WidgetRun> iterator3 = this.e.iterator();
        boolean b6 = false;
        Label_0612: {
            while (true) {
                b6 = b2;
                if (!iterator3.hasNext()) {
                    break Label_0612;
                }
                final WidgetRun widgetRun3 = iterator3.next();
                if (widgetRun3.f != n) {
                    continue;
                }
                if (!b5 && widgetRun3.b == this.a) {
                    continue;
                }
                if (!widgetRun3.h.j) {
                    break;
                }
                if (!widgetRun3.i.j) {
                    break;
                }
                if (!(widgetRun3 instanceof c) && !widgetRun3.e.j) {
                    break;
                }
            }
            b6 = false;
        }
        this.a.M0(s);
        this.a.d1(s2);
        return b6;
    }
    
    public void j() {
        this.b = true;
    }
    
    public void k() {
        this.c = true;
    }
    
    public void m() {
        for (final ConstraintWidget constraintWidget : this.a.L0) {
            if (constraintWidget.a) {
                continue;
            }
            final ConstraintWidget.DimensionBehaviour[] z = constraintWidget.Z;
            final int n = 0;
            final ConstraintWidget.DimensionBehaviour dimensionBehaviour = z[0];
            final ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = z[1];
            final int w = constraintWidget.w;
            final int x = constraintWidget.x;
            final ConstraintWidget.DimensionBehaviour wrap_CONTENT = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            final boolean b = dimensionBehaviour == wrap_CONTENT || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && w == 1);
            int n2 = 0;
            Label_0141: {
                if (dimensionBehaviour2 != wrap_CONTENT) {
                    n2 = n;
                    if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        break Label_0141;
                    }
                    n2 = n;
                    if (x != 1) {
                        break Label_0141;
                    }
                }
                n2 = 1;
            }
            final androidx.constraintlayout.core.widgets.analyzer.e e = constraintWidget.e.e;
            final boolean j = e.j;
            final androidx.constraintlayout.core.widgets.analyzer.e e2 = constraintWidget.f.e;
            final boolean i = e2.j;
            if (j && i) {
                final ConstraintWidget.DimensionBehaviour fixed = ConstraintWidget.DimensionBehaviour.FIXED;
                this.l(constraintWidget, fixed, e.g, fixed, e2.g);
                constraintWidget.a = true;
            }
            else if (j && n2 != 0) {
                this.l(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, e.g, wrap_CONTENT, e2.g);
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.f.e.m = constraintWidget.v();
                }
                else {
                    constraintWidget.f.e.d(constraintWidget.v());
                    constraintWidget.a = true;
                }
            }
            else if (i && b) {
                this.l(constraintWidget, wrap_CONTENT, e.g, ConstraintWidget.DimensionBehaviour.FIXED, e2.g);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.e.e.m = constraintWidget.U();
                }
                else {
                    constraintWidget.e.e.d(constraintWidget.U());
                    constraintWidget.a = true;
                }
            }
            if (!constraintWidget.a) {
                continue;
            }
            final androidx.constraintlayout.core.widgets.analyzer.e l = constraintWidget.f.l;
            if (l == null) {
                continue;
            }
            l.d(constraintWidget.n());
        }
    }
    
    public void n(final b.b g) {
        this.g = g;
    }
}
