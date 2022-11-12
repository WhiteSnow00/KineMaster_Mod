// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import java.util.Iterator;
import androidx.constraintlayout.core.widgets.a;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.e;
import r.b;
import java.util.ArrayList;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class g
{
    public static m a(final ConstraintWidget constraintWidget, final int n, final ArrayList<m> list, m m) {
        int n2;
        if (n == 0) {
            n2 = constraintWidget.I0;
        }
        else {
            n2 = constraintWidget.J0;
        }
        final int n3 = 0;
        m i;
        if (n2 != -1 && (m == null || n2 != m.b)) {
            int n4 = 0;
            while (true) {
                i = m;
                if (n4 >= list.size()) {
                    break;
                }
                i = list.get(n4);
                if (i.c() == n2) {
                    if (m != null) {
                        m.g(n, i);
                        list.remove(m);
                    }
                    break;
                }
                ++n4;
            }
        }
        else {
            i = m;
            if (n2 != -1) {
                return m;
            }
        }
        if ((m = i) == null) {
            m = i;
            if (constraintWidget instanceof b) {
                final int p3 = ((b)constraintWidget).p1(n);
                m = i;
                if (p3 != -1) {
                    int n5 = 0;
                    while (true) {
                        m = i;
                        if (n5 >= list.size()) {
                            break;
                        }
                        m = (m)list.get(n5);
                        if (m.c() == p3) {
                            break;
                        }
                        ++n5;
                    }
                }
            }
            m j;
            if ((j = m) == null) {
                j = new m(n);
            }
            list.add(j);
            m = j;
        }
        if (m.a(constraintWidget)) {
            if (constraintWidget instanceof e) {
                final e e = (e)constraintWidget;
                final ConstraintAnchor o1 = e.o1();
                int n6 = n3;
                if (e.p1() == 0) {
                    n6 = 1;
                }
                o1.b(n6, list, m);
            }
            if (n == 0) {
                constraintWidget.I0 = m.c();
                constraintWidget.O.b(n, list, m);
                constraintWidget.Q.b(n, list, m);
            }
            else {
                constraintWidget.J0 = m.c();
                constraintWidget.P.b(n, list, m);
                constraintWidget.S.b(n, list, m);
                constraintWidget.R.b(n, list, m);
            }
            constraintWidget.V.b(n, list, m);
        }
        return m;
    }
    
    private static m b(final ArrayList<m> list, final int n) {
        for (int size = list.size(), i = 0; i < size; ++i) {
            final m m = list.get(i);
            if (n == m.b) {
                return m;
            }
        }
        return null;
    }
    
    public static boolean c(final d d, final androidx.constraintlayout.core.widgets.analyzer.b.b b) {
        final ArrayList<ConstraintWidget> o1 = d.o1();
        final int size = o1.size();
        for (int i = 0; i < size; ++i) {
            final ConstraintWidget constraintWidget = o1.get(i);
            if (!d(d.y(), d.R(), constraintWidget.y(), constraintWidget.R())) {
                return false;
            }
        }
        int j = 0;
        ArrayList list = null;
        ArrayList list2 = null;
        ArrayList list3 = null;
        ArrayList list4 = null;
        ArrayList<a> list5 = null;
        ArrayList<a> list6 = null;
        while (j < size) {
            final ConstraintWidget constraintWidget2 = o1.get(j);
            if (!d(d.y(), d.R(), constraintWidget2.y(), constraintWidget2.R())) {
                d.P1(0, constraintWidget2, b, d.p1, androidx.constraintlayout.core.widgets.analyzer.b.a.k);
            }
            final boolean b2 = constraintWidget2 instanceof e;
            ArrayList list7 = list;
            ArrayList list8 = list3;
            if (b2) {
                final e e = (e)constraintWidget2;
                ArrayList list9 = list3;
                if (e.p1() == 0) {
                    if ((list9 = list3) == null) {
                        list9 = new ArrayList();
                    }
                    list9.add(e);
                }
                list7 = list;
                list8 = list9;
                if (e.p1() == 1) {
                    ArrayList list10;
                    if ((list10 = list) == null) {
                        list10 = new ArrayList();
                    }
                    list10.add(e);
                    list8 = list9;
                    list7 = list10;
                }
            }
            ArrayList list11 = list2;
            ArrayList list12 = list4;
            if (constraintWidget2 instanceof b) {
                if (constraintWidget2 instanceof a) {
                    final a a = (a)constraintWidget2;
                    ArrayList list13 = list2;
                    if (a.u1() == 0) {
                        if ((list13 = list2) == null) {
                            list13 = new ArrayList();
                        }
                        list13.add(a);
                    }
                    list11 = list13;
                    list12 = list4;
                    if (a.u1() == 1) {
                        if ((list12 = list4) == null) {
                            list12 = new ArrayList();
                        }
                        list12.add(a);
                        list11 = list13;
                    }
                }
                else {
                    final b b3 = (b)constraintWidget2;
                    if ((list11 = list2) == null) {
                        list11 = new ArrayList();
                    }
                    list11.add(b3);
                    if ((list12 = list4) == null) {
                        list12 = new ArrayList();
                    }
                    list12.add(b3);
                }
            }
            ArrayList<a> list14 = list5;
            if (constraintWidget2.O.f == null) {
                list14 = list5;
                if (constraintWidget2.Q.f == null) {
                    list14 = list5;
                    if (!b2) {
                        list14 = list5;
                        if (!(constraintWidget2 instanceof a)) {
                            ArrayList<a> list15;
                            if ((list15 = list5) == null) {
                                list15 = new ArrayList<a>();
                            }
                            list15.add((a)constraintWidget2);
                            list14 = list15;
                        }
                    }
                }
            }
            ArrayList<a> list16 = list6;
            if (constraintWidget2.P.f == null) {
                list16 = list6;
                if (constraintWidget2.R.f == null) {
                    list16 = list6;
                    if (constraintWidget2.S.f == null) {
                        list16 = list6;
                        if (!b2) {
                            list16 = list6;
                            if (!(constraintWidget2 instanceof a)) {
                                ArrayList<a> list17;
                                if ((list17 = list6) == null) {
                                    list17 = new ArrayList<a>();
                                }
                                list17.add((a)constraintWidget2);
                                list16 = list17;
                            }
                        }
                    }
                }
            }
            ++j;
            list = list7;
            list2 = list11;
            list3 = list8;
            list4 = list12;
            list5 = list14;
            list6 = list16;
        }
        final ArrayList<m> list18 = new ArrayList<m>();
        if (list != null) {
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                a((ConstraintWidget)iterator.next(), 0, list18, null);
            }
        }
        if (list2 != null) {
            for (final b b4 : list2) {
                final m a2 = a(b4, 0, list18, null);
                b4.o1(list18, 0, a2);
                a2.b(list18);
            }
        }
        final ConstraintAnchor m = d.m(ConstraintAnchor.Type.LEFT);
        if (m.c() != null) {
            final Iterator<ConstraintAnchor> iterator3 = m.c().iterator();
            while (iterator3.hasNext()) {
                a(iterator3.next().d, 0, list18, null);
            }
        }
        final ConstraintAnchor k = d.m(ConstraintAnchor.Type.RIGHT);
        if (k.c() != null) {
            final Iterator<ConstraintAnchor> iterator4 = k.c().iterator();
            while (iterator4.hasNext()) {
                a(iterator4.next().d, 0, list18, null);
            }
        }
        final ConstraintAnchor l = d.m(ConstraintAnchor.Type.CENTER);
        if (l.c() != null) {
            final Iterator<ConstraintAnchor> iterator5 = l.c().iterator();
            while (iterator5.hasNext()) {
                a(iterator5.next().d, 0, list18, null);
            }
        }
        if (list5 != null) {
            final Iterator<a> iterator6 = list5.iterator();
            while (iterator6.hasNext()) {
                a(iterator6.next(), 0, list18, null);
            }
        }
        if (list3 != null) {
            final Iterator iterator7 = list3.iterator();
            while (iterator7.hasNext()) {
                a((ConstraintWidget)iterator7.next(), 1, list18, null);
            }
        }
        if (list4 != null) {
            for (final b b5 : list4) {
                final m a3 = a(b5, 1, list18, null);
                b5.o1(list18, 1, a3);
                a3.b(list18);
            }
        }
        final ConstraintAnchor m2 = d.m(ConstraintAnchor.Type.TOP);
        if (m2.c() != null) {
            final Iterator<ConstraintAnchor> iterator9 = m2.c().iterator();
            while (iterator9.hasNext()) {
                a(iterator9.next().d, 1, list18, null);
            }
        }
        final ConstraintAnchor m3 = d.m(ConstraintAnchor.Type.BASELINE);
        if (m3.c() != null) {
            final Iterator<ConstraintAnchor> iterator10 = m3.c().iterator();
            while (iterator10.hasNext()) {
                a(iterator10.next().d, 1, list18, null);
            }
        }
        final ConstraintAnchor m4 = d.m(ConstraintAnchor.Type.BOTTOM);
        if (m4.c() != null) {
            final Iterator<ConstraintAnchor> iterator11 = m4.c().iterator();
            while (iterator11.hasNext()) {
                a(iterator11.next().d, 1, list18, null);
            }
        }
        final ConstraintAnchor m5 = d.m(ConstraintAnchor.Type.CENTER);
        if (m5.c() != null) {
            final Iterator<ConstraintAnchor> iterator12 = m5.c().iterator();
            while (iterator12.hasNext()) {
                a(iterator12.next().d, 1, list18, null);
            }
        }
        if (list6 != null) {
            final Iterator<a> iterator13 = list6.iterator();
            while (iterator13.hasNext()) {
                a(iterator13.next(), 1, list18, null);
            }
        }
        for (int n = 0; n < size; ++n) {
            final ConstraintWidget constraintWidget3 = o1.get(n);
            if (constraintWidget3.q0()) {
                final m b6 = b(list18, constraintWidget3.I0);
                final m b7 = b(list18, constraintWidget3.J0);
                if (b6 != null && b7 != null) {
                    b6.g(0, b7);
                    b7.i(2);
                    list18.remove(b6);
                }
            }
        }
        if (list18.size() <= 1) {
            return false;
        }
        m m8 = null;
        Label_1529: {
            if (d.y() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                final Iterator<m> iterator14 = list18.iterator();
                m m6 = null;
                int n2 = 0;
                while (iterator14.hasNext()) {
                    final m m7 = iterator14.next();
                    if (m7.d() == 1) {
                        continue;
                    }
                    m7.h(false);
                    final int f = m7.f(d.I1(), 0);
                    if (f <= n2) {
                        continue;
                    }
                    m6 = m7;
                    n2 = f;
                }
                if (m6 != null) {
                    d.M0(ConstraintWidget.DimensionBehaviour.FIXED);
                    d.h1(n2);
                    m6.h(true);
                    m8 = m6;
                    break Label_1529;
                }
            }
            m8 = null;
        }
        if (d.R() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            final Iterator<m> iterator15 = list18.iterator();
            m m9 = null;
            int n3 = 0;
            while (iterator15.hasNext()) {
                final m m10 = iterator15.next();
                if (m10.d() == 0) {
                    continue;
                }
                m10.h(false);
                final int f2 = m10.f(d.I1(), 1);
                if (f2 <= n3) {
                    continue;
                }
                m9 = m10;
                n3 = f2;
            }
            if (m9 != null) {
                d.d1(ConstraintWidget.DimensionBehaviour.FIXED);
                d.I0(n3);
                m9.h(true);
                return m8 != null || m9 != null;
            }
        }
        m m9 = null;
        return m8 != null || m9 != null;
    }
    
    public static boolean d(ConstraintWidget.DimensionBehaviour wrap_CONTENT, final ConstraintWidget.DimensionBehaviour dimensionBehaviour, final ConstraintWidget.DimensionBehaviour dimensionBehaviour2, final ConstraintWidget.DimensionBehaviour dimensionBehaviour3) {
        final ConstraintWidget.DimensionBehaviour fixed = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean b = false;
        Label_0047: {
            if (dimensionBehaviour2 != fixed) {
                final ConstraintWidget.DimensionBehaviour wrap_CONTENT2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour2 != wrap_CONTENT2) {
                    if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || wrap_CONTENT == wrap_CONTENT2) {
                        b = false;
                        break Label_0047;
                    }
                }
            }
            b = true;
        }
        if (dimensionBehaviour3 != fixed) {
            wrap_CONTENT = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour3 != wrap_CONTENT) {
                if (dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == wrap_CONTENT) {
                    final boolean b2 = false;
                    return b || b2;
                }
            }
        }
        final boolean b2 = true;
        return b || b2;
    }
}
