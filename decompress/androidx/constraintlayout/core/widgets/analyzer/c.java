// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import s.a;
import java.util.Iterator;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

public class c extends WidgetRun
{
    ArrayList<WidgetRun> k;
    private int l;
    
    public c(final ConstraintWidget constraintWidget, final int f) {
        super(constraintWidget);
        this.k = new ArrayList<WidgetRun>();
        super.f = f;
        this.q();
    }
    
    private void q() {
        ConstraintWidget b = super.b;
        ConstraintWidget i;
        for (ConstraintWidget j = b.J(super.f); j != null; j = i) {
            i = j.J(super.f);
            b = j;
        }
        super.b = b;
        this.k.add(b.L(super.f));
        for (ConstraintWidget constraintWidget = b.H(super.f); constraintWidget != null; constraintWidget = constraintWidget.H(super.f)) {
            this.k.add(constraintWidget.L(super.f));
        }
        for (final WidgetRun widgetRun : this.k) {
            final int f = super.f;
            if (f == 0) {
                widgetRun.b.c = this;
            }
            else {
                if (f != 1) {
                    continue;
                }
                widgetRun.b.d = this;
            }
        }
        if (super.f == 0 && ((d)super.b.I()).M1() && this.k.size() > 1) {
            final ArrayList<WidgetRun> k = this.k;
            super.b = ((WidgetRun)k.get(k.size() - 1)).b;
        }
        int l;
        if (super.f == 0) {
            l = super.b.x();
        }
        else {
            l = super.b.Q();
        }
        this.l = l;
    }
    
    private ConstraintWidget r() {
        for (int i = 0; i < this.k.size(); ++i) {
            final WidgetRun widgetRun = this.k.get(i);
            if (widgetRun.b.T() != 8) {
                return widgetRun.b;
            }
        }
        return null;
    }
    
    private ConstraintWidget s() {
        for (int i = this.k.size() - 1; i >= 0; --i) {
            final WidgetRun widgetRun = this.k.get(i);
            if (widgetRun.b.T() != 8) {
                return widgetRun.b;
            }
        }
        return null;
    }
    
    @Override
    public void a(final a a) {
        if (super.h.j) {
            if (super.i.j) {
                final ConstraintWidget i = super.b.I();
                final boolean b = i instanceof d && ((d)i).M1();
                final int n = super.i.g - super.h.g;
                final int size = this.k.size();
                int n2 = 0;
                int n3;
                int n4;
                while (true) {
                    n3 = -1;
                    if (n2 >= size) {
                        n4 = -1;
                        break;
                    }
                    n4 = n2;
                    if (this.k.get(n2).b.T() != 8) {
                        break;
                    }
                    ++n2;
                }
                int n6;
                final int n5 = n6 = size - 1;
                int n7;
                while (true) {
                    n7 = n3;
                    if (n6 < 0) {
                        break;
                    }
                    if (this.k.get(n6).b.T() != 8) {
                        n7 = n6;
                        break;
                    }
                    --n6;
                }
                int j = 0;
                while (true) {
                    while (j < 2) {
                        int k = 0;
                        int n8 = 0;
                        int n9 = 0;
                        int n10 = 0;
                        float n11 = 0.0f;
                        while (k < size) {
                            final WidgetRun widgetRun = this.k.get(k);
                            int n12;
                            if (widgetRun.b.T() == 8) {
                                n12 = n9;
                            }
                            else {
                                final int n13 = n10 + 1;
                                int n14 = n8;
                                if (k > 0) {
                                    n14 = n8;
                                    if (k >= n4) {
                                        n14 = n8 + widgetRun.h.f;
                                    }
                                }
                                final e e = widgetRun.e;
                                final int g = e.g;
                                final boolean b2 = widgetRun.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                                int m = 0;
                                boolean b3 = false;
                                Label_0427: {
                                    Label_0415: {
                                        if (!b2) {
                                            if (widgetRun.a == 1 && j == 0) {
                                                m = e.m;
                                                ++n9;
                                            }
                                            else {
                                                if (!e.j) {
                                                    break Label_0415;
                                                }
                                                m = g;
                                            }
                                            b3 = true;
                                            break Label_0427;
                                        }
                                        final int f = super.f;
                                        if (f == 0 && !widgetRun.b.e.e.j) {
                                            return;
                                        }
                                        if (f == 1 && !widgetRun.b.f.e.j) {
                                            return;
                                        }
                                    }
                                    final int n15 = g;
                                    b3 = b2;
                                    m = n15;
                                }
                                int n18;
                                float n19;
                                if (!b3) {
                                    final int n16 = n9 + 1;
                                    final float n17 = widgetRun.b.D0[super.f];
                                    n18 = n14;
                                    n9 = n16;
                                    n19 = n11;
                                    if (n17 >= 0.0f) {
                                        n19 = n11 + n17;
                                        n18 = n14;
                                        n9 = n16;
                                    }
                                }
                                else {
                                    n18 = n14 + m;
                                    n19 = n11;
                                }
                                n8 = n18;
                                n12 = n9;
                                n10 = n13;
                                n11 = n19;
                                if (k < n5) {
                                    n8 = n18;
                                    n12 = n9;
                                    n10 = n13;
                                    n11 = n19;
                                    if (k < n7) {
                                        n8 = n18 + -widgetRun.i.f;
                                        n11 = n19;
                                        n10 = n13;
                                        n12 = n9;
                                    }
                                }
                            }
                            ++k;
                            n9 = n12;
                        }
                        if (n8 >= n && n9 != 0) {
                            ++j;
                        }
                        else {
                            final int n20 = n10;
                            int n21 = n9;
                            int n22 = super.h.g;
                            if (b) {
                                n22 = super.i.g;
                            }
                            int n23 = n22;
                            if (n8 > n) {
                                if (b) {
                                    n23 = n22 + (int)((n8 - n) / 2.0f + 0.5f);
                                }
                                else {
                                    n23 = n22 - (int)((n8 - n) / 2.0f + 0.5f);
                                }
                            }
                            int n42;
                            if (n21 > 0) {
                                final float n24 = (float)(n - n8);
                                final int n25 = (int)(n24 / n21 + 0.5f);
                                int l = 0;
                                final int n26 = 0;
                                final int n27 = n8;
                                int n28 = n26;
                                final int n29 = n23;
                                while (l < size) {
                                    final WidgetRun widgetRun2 = this.k.get(l);
                                    if (widgetRun2.b.T() != 8) {
                                        if (widgetRun2.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                            final e e2 = widgetRun2.e;
                                            if (!e2.j) {
                                                int n30;
                                                if (n11 > 0.0f) {
                                                    n30 = (int)(widgetRun2.b.D0[super.f] * n24 / n11 + 0.5f);
                                                }
                                                else {
                                                    n30 = n25;
                                                }
                                                int n31;
                                                int n32;
                                                if (super.f == 0) {
                                                    final ConstraintWidget b4 = widgetRun2.b;
                                                    n31 = b4.A;
                                                    n32 = b4.z;
                                                }
                                                else {
                                                    final ConstraintWidget b5 = widgetRun2.b;
                                                    n31 = b5.D;
                                                    n32 = b5.C;
                                                }
                                                int min;
                                                if (widgetRun2.a == 1) {
                                                    min = Math.min(n30, e2.m);
                                                }
                                                else {
                                                    min = n30;
                                                }
                                                int n34;
                                                final int n33 = n34 = Math.max(n32, min);
                                                if (n31 > 0) {
                                                    n34 = Math.min(n31, n33);
                                                }
                                                int n35 = n30;
                                                int n36 = n28;
                                                if (n34 != n30) {
                                                    n36 = n28 + 1;
                                                    n35 = n34;
                                                }
                                                widgetRun2.e.d(n35);
                                                n28 = n36;
                                            }
                                        }
                                    }
                                    ++l;
                                }
                                int n39;
                                if (n28 > 0) {
                                    final int n37 = n21 - n28;
                                    int n38 = 0;
                                    n39 = 0;
                                    while (n38 < size) {
                                        final WidgetRun widgetRun3 = this.k.get(n38);
                                        if (widgetRun3.b.T() != 8) {
                                            int n40 = n39;
                                            if (n38 > 0) {
                                                n40 = n39;
                                                if (n38 >= n4) {
                                                    n40 = n39 + widgetRun3.h.f;
                                                }
                                            }
                                            final int n41 = n39 = n40 + widgetRun3.e.g;
                                            if (n38 < n5) {
                                                n39 = n41;
                                                if (n38 < n7) {
                                                    n39 = n41 + -widgetRun3.i.f;
                                                }
                                            }
                                        }
                                        ++n38;
                                    }
                                    n21 = n37;
                                }
                                else {
                                    n39 = n27;
                                }
                                if (this.l == 2 && n28 == 0) {
                                    this.l = 0;
                                    n8 = n39;
                                    n42 = n21;
                                    n23 = n29;
                                }
                                else {
                                    n8 = n39;
                                    n42 = n21;
                                    n23 = n29;
                                }
                            }
                            else {
                                n42 = n21;
                            }
                            if (n8 > n) {
                                this.l = 2;
                            }
                            if (n20 > 0 && n42 == 0 && n4 == n7) {
                                this.l = 2;
                            }
                            final int l2 = this.l;
                            if (l2 == 1) {
                                int n43;
                                if (n20 > 1) {
                                    n43 = (n - n8) / (n20 - 1);
                                }
                                else if (n20 == 1) {
                                    n43 = (n - n8) / 2;
                                }
                                else {
                                    n43 = 0;
                                }
                                int n44 = n43;
                                if (n42 > 0) {
                                    n44 = 0;
                                }
                                int n45 = 0;
                                int n46 = n23;
                                while (n45 < size) {
                                    int n47;
                                    if (b) {
                                        n47 = size - (n45 + 1);
                                    }
                                    else {
                                        n47 = n45;
                                    }
                                    final WidgetRun widgetRun4 = this.k.get(n47);
                                    int n48;
                                    if (widgetRun4.b.T() == 8) {
                                        widgetRun4.h.d(n46);
                                        widgetRun4.i.d(n46);
                                        n48 = n46;
                                    }
                                    else {
                                        int n49 = n46;
                                        if (n45 > 0) {
                                            if (b) {
                                                n49 = n46 - n44;
                                            }
                                            else {
                                                n49 = n46 + n44;
                                            }
                                        }
                                        int n50 = n49;
                                        if (n45 > 0) {
                                            n50 = n49;
                                            if (n45 >= n4) {
                                                if (b) {
                                                    n50 = n49 - widgetRun4.h.f;
                                                }
                                                else {
                                                    n50 = n49 + widgetRun4.h.f;
                                                }
                                            }
                                        }
                                        if (b) {
                                            widgetRun4.i.d(n50);
                                        }
                                        else {
                                            widgetRun4.h.d(n50);
                                        }
                                        final e e3 = widgetRun4.e;
                                        int n52;
                                        final int n51 = n52 = e3.g;
                                        if (widgetRun4.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                            n52 = n51;
                                            if (widgetRun4.a == 1) {
                                                n52 = e3.m;
                                            }
                                        }
                                        int n53;
                                        if (b) {
                                            n53 = n50 - n52;
                                        }
                                        else {
                                            n53 = n50 + n52;
                                        }
                                        if (b) {
                                            widgetRun4.h.d(n53);
                                        }
                                        else {
                                            widgetRun4.i.d(n53);
                                        }
                                        widgetRun4.g = true;
                                        n48 = n53;
                                        if (n45 < n5) {
                                            n48 = n53;
                                            if (n45 < n7) {
                                                if (b) {
                                                    n48 = n53 - -widgetRun4.i.f;
                                                }
                                                else {
                                                    n48 = n53 + -widgetRun4.i.f;
                                                }
                                            }
                                        }
                                    }
                                    ++n45;
                                    n46 = n48;
                                }
                                return;
                            }
                            if (l2 == 0) {
                                int n54 = (n - n8) / (n20 + 1);
                                if (n42 > 0) {
                                    n54 = 0;
                                }
                                for (int n55 = 0; n55 < size; ++n55) {
                                    int n56;
                                    if (b) {
                                        n56 = size - (n55 + 1);
                                    }
                                    else {
                                        n56 = n55;
                                    }
                                    final WidgetRun widgetRun5 = this.k.get(n56);
                                    if (widgetRun5.b.T() == 8) {
                                        widgetRun5.h.d(n23);
                                        widgetRun5.i.d(n23);
                                    }
                                    else {
                                        int n57;
                                        if (b) {
                                            n57 = n23 - n54;
                                        }
                                        else {
                                            n57 = n23 + n54;
                                        }
                                        int n58 = n57;
                                        if (n55 > 0) {
                                            n58 = n57;
                                            if (n55 >= n4) {
                                                if (b) {
                                                    n58 = n57 - widgetRun5.h.f;
                                                }
                                                else {
                                                    n58 = n57 + widgetRun5.h.f;
                                                }
                                            }
                                        }
                                        if (b) {
                                            widgetRun5.i.d(n58);
                                        }
                                        else {
                                            widgetRun5.h.d(n58);
                                        }
                                        final e e4 = widgetRun5.e;
                                        int n60;
                                        final int n59 = n60 = e4.g;
                                        if (widgetRun5.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                            n60 = n59;
                                            if (widgetRun5.a == 1) {
                                                n60 = Math.min(n59, e4.m);
                                            }
                                        }
                                        int n61;
                                        if (b) {
                                            n61 = n58 - n60;
                                        }
                                        else {
                                            n61 = n58 + n60;
                                        }
                                        if (b) {
                                            widgetRun5.h.d(n61);
                                        }
                                        else {
                                            widgetRun5.i.d(n61);
                                        }
                                        n23 = n61;
                                        if (n55 < n5) {
                                            n23 = n61;
                                            if (n55 < n7) {
                                                if (b) {
                                                    n23 = n61 - -widgetRun5.i.f;
                                                }
                                                else {
                                                    n23 = n61 + -widgetRun5.i.f;
                                                }
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                            if (l2 == 2) {
                                float n62;
                                if (super.f == 0) {
                                    n62 = super.b.w();
                                }
                                else {
                                    n62 = super.b.P();
                                }
                                float n63 = n62;
                                if (b) {
                                    n63 = 1.0f - n62;
                                }
                                int n64 = (int)((n - n8) * n63 + 0.5f);
                                if (n64 < 0 || n42 > 0) {
                                    n64 = 0;
                                }
                                int n65;
                                if (b) {
                                    n65 = n23 - n64;
                                }
                                else {
                                    n65 = n23 + n64;
                                }
                                for (int n66 = 0; n66 < size; ++n66) {
                                    int n67;
                                    if (b) {
                                        n67 = size - (n66 + 1);
                                    }
                                    else {
                                        n67 = n66;
                                    }
                                    final WidgetRun widgetRun6 = this.k.get(n67);
                                    if (widgetRun6.b.T() == 8) {
                                        widgetRun6.h.d(n65);
                                        widgetRun6.i.d(n65);
                                    }
                                    else {
                                        int n68 = n65;
                                        if (n66 > 0) {
                                            n68 = n65;
                                            if (n66 >= n4) {
                                                if (b) {
                                                    n68 = n65 - widgetRun6.h.f;
                                                }
                                                else {
                                                    n68 = n65 + widgetRun6.h.f;
                                                }
                                            }
                                        }
                                        if (b) {
                                            widgetRun6.i.d(n68);
                                        }
                                        else {
                                            widgetRun6.h.d(n68);
                                        }
                                        final e e5 = widgetRun6.e;
                                        int n69 = e5.g;
                                        if (widgetRun6.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.a == 1) {
                                            n69 = e5.m;
                                        }
                                        int n70;
                                        if (b) {
                                            n70 = n68 - n69;
                                        }
                                        else {
                                            n70 = n68 + n69;
                                        }
                                        if (b) {
                                            widgetRun6.h.d(n70);
                                        }
                                        else {
                                            widgetRun6.i.d(n70);
                                        }
                                        n65 = n70;
                                        if (n66 < n5) {
                                            n65 = n70;
                                            if (n66 < n7) {
                                                if (b) {
                                                    n65 = n70 - -widgetRun6.i.f;
                                                }
                                                else {
                                                    n65 = n70 + -widgetRun6.i.f;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return;
                        }
                    }
                    final int n20 = 0;
                    int n8 = 0;
                    int n21 = 0;
                    float n11 = 0.0f;
                    continue;
                }
            }
        }
    }
    
    @Override
    void d() {
        final Iterator<WidgetRun> iterator = this.k.iterator();
        while (iterator.hasNext()) {
            iterator.next().d();
        }
        final int size = this.k.size();
        if (size < 1) {
            return;
        }
        final ConstraintWidget b = this.k.get(0).b;
        final ConstraintWidget b2 = this.k.get(size - 1).b;
        if (super.f == 0) {
            final ConstraintAnchor o = b.O;
            final ConstraintAnchor q = b2.Q;
            final DependencyNode i = this.i(o, 0);
            int n = o.e();
            final ConstraintWidget r = this.r();
            if (r != null) {
                n = r.O.e();
            }
            if (i != null) {
                this.b(super.h, i, n);
            }
            final DependencyNode j = this.i(q, 0);
            int n2 = q.e();
            final ConstraintWidget s = this.s();
            if (s != null) {
                n2 = s.Q.e();
            }
            if (j != null) {
                this.b(super.i, j, -n2);
            }
        }
        else {
            final ConstraintAnchor p = b.P;
            final ConstraintAnchor r2 = b2.R;
            final DependencyNode k = this.i(p, 1);
            int n3 = p.e();
            final ConstraintWidget r3 = this.r();
            if (r3 != null) {
                n3 = r3.P.e();
            }
            if (k != null) {
                this.b(super.h, k, n3);
            }
            final DependencyNode l = this.i(r2, 1);
            int n4 = r2.e();
            final ConstraintWidget s2 = this.s();
            if (s2 != null) {
                n4 = s2.R.e();
            }
            if (l != null) {
                this.b(super.i, l, -n4);
            }
        }
        super.h.a = this;
        super.i.a = this;
    }
    
    public void e() {
        for (int i = 0; i < this.k.size(); ++i) {
            this.k.get(i).e();
        }
    }
    
    @Override
    void f() {
        super.c = null;
        final Iterator<WidgetRun> iterator = this.k.iterator();
        while (iterator.hasNext()) {
            iterator.next().f();
        }
    }
    
    @Override
    public long j() {
        final int size = this.k.size();
        long n = 0L;
        for (int i = 0; i < size; ++i) {
            final WidgetRun widgetRun = this.k.get(i);
            n = n + widgetRun.h.f + widgetRun.j() + widgetRun.i.f;
        }
        return n;
    }
    
    @Override
    boolean m() {
        for (int size = this.k.size(), i = 0; i < size; ++i) {
            if (!this.k.get(i).m()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChainRun ");
        String s;
        if (super.f == 0) {
            s = "horizontal : ";
        }
        else {
            s = "vertical : ";
        }
        sb.append(s);
        for (final WidgetRun widgetRun : this.k) {
            sb.append("<");
            sb.append(widgetRun);
            sb.append("> ");
        }
        return sb.toString();
    }
}
