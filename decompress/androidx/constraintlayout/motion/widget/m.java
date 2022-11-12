// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import java.util.HashSet;
import android.view.ViewGroup$LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.View$MeasureSpec;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.Arrays;
import o.e;
import o.j;
import java.util.Collection;
import android.util.Log;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import android.view.View;
import t.b;
import t.c;
import java.util.HashMap;
import java.util.ArrayList;

public class m
{
    private ArrayList<d> A;
    private HashMap<String, t.d> B;
    private HashMap<String, c> C;
    private HashMap<String, b> D;
    private k[] E;
    private int F;
    private int G;
    private View H;
    private int I;
    private float J;
    private Interpolator K;
    private boolean L;
    Rect a;
    View b;
    int c;
    boolean d;
    String e;
    private int f;
    private p g;
    private p h;
    private l i;
    private l j;
    private o.b[] k;
    private o.b l;
    float m;
    float n;
    float o;
    float p;
    float q;
    private int[] r;
    private double[] s;
    private double[] t;
    private String[] u;
    private int[] v;
    private int w;
    private float[] x;
    private ArrayList<p> y;
    private float[] z;
    
    m(final View view) {
        this.a = new Rect();
        this.d = false;
        this.f = -1;
        this.g = new p();
        this.h = new p();
        this.i = new l();
        this.j = new l();
        this.m = Float.NaN;
        this.n = 0.0f;
        this.o = 1.0f;
        this.w = 4;
        this.x = new float[4];
        this.y = new ArrayList<p>();
        this.z = new float[1];
        this.A = new ArrayList<d>();
        final int f = androidx.constraintlayout.motion.widget.d.f;
        this.F = f;
        this.G = f;
        this.H = null;
        this.I = f;
        this.J = Float.NaN;
        this.K = null;
        this.L = false;
        this.t(view);
    }
    
    private float f(float c, final float[] array) {
        final float n = 0.0f;
        final float n2 = 1.0f;
        float min;
        if (array != null) {
            array[0] = 1.0f;
            min = c;
        }
        else {
            final float o = this.o;
            min = c;
            if (o != 1.0) {
                final float n3 = this.n;
                float n4 = c;
                if (c < n3) {
                    n4 = 0.0f;
                }
                min = n4;
                if (n4 > n3) {
                    min = n4;
                    if (n4 < 1.0) {
                        min = Math.min((n4 - n3) * o, 1.0f);
                    }
                }
            }
        }
        o.c a = this.g.a;
        c = Float.NaN;
        final Iterator<p> iterator = this.y.iterator();
        float n5 = n;
        while (iterator.hasNext()) {
            final p p2 = iterator.next();
            final o.c a2 = p2.a;
            if (a2 != null) {
                final float c2 = p2.c;
                if (c2 < min) {
                    a = a2;
                    n5 = c2;
                }
                else {
                    if (!Float.isNaN(c)) {
                        continue;
                    }
                    c = p2.c;
                }
            }
        }
        float n6 = min;
        if (a != null) {
            if (Float.isNaN(c)) {
                c = n2;
            }
            c -= n5;
            final double n7 = (min - n5) / c;
            c = (n6 = (float)a.a(n7) * c + n5);
            if (array != null) {
                array[0] = (float)a.b(n7);
                n6 = c;
            }
        }
        return n6;
    }
    
    private float n() {
        final float[] array = new float[2];
        final float n = 1.0f / 99;
        double n2 = 0.0;
        double n3 = 0.0;
        float n4 = 0.0f;
        for (int i = 0; i < 100; ++i) {
            final float n5 = i * n;
            double n6 = n5;
            o.c a = this.g.a;
            final Iterator<p> iterator = this.y.iterator();
            float n7 = Float.NaN;
            float n8 = 0.0f;
            while (iterator.hasNext()) {
                final p p = iterator.next();
                final o.c a2 = p.a;
                o.c c = a;
                float c2 = n7;
                float c3 = n8;
                if (a2 != null) {
                    c3 = p.c;
                    if (c3 < n5) {
                        c = a2;
                        c2 = n7;
                    }
                    else {
                        c = a;
                        c2 = n7;
                        c3 = n8;
                        if (Float.isNaN(n7)) {
                            c2 = p.c;
                            c3 = n8;
                            c = a;
                        }
                    }
                }
                a = c;
                n7 = c2;
                n8 = c3;
            }
            if (a != null) {
                float n9 = n7;
                if (Float.isNaN(n7)) {
                    n9 = 1.0f;
                }
                final float n10 = n9 - n8;
                n6 = (float)a.a((n5 - n8) / n10) * n10 + n8;
            }
            this.k[0].d(n6, this.s);
            this.g.g(n6, this.r, this.s, array, 0);
            if (i > 0) {
                n4 += (float)Math.hypot(n3 - array[1], n2 - array[0]);
            }
            n2 = array[0];
            n3 = array[1];
        }
        return n4;
    }
    
    private void p(final p p) {
        final int binarySearch = Collections.binarySearch(this.y, p);
        if (binarySearch == 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append(" KeyPath position \"");
            sb.append(p.d);
            sb.append("\" outside of range");
            Log.e("MotionController", sb.toString());
        }
        this.y.add(-binarySearch - 1, p);
    }
    
    void a(final ArrayList<d> list) {
        this.A.addAll(list);
    }
    
    int b(final float[] array, final int[] array2) {
        if (array != null) {
            final double[] g = this.k[0].g();
            if (array2 != null) {
                final Iterator<p> iterator = this.y.iterator();
                int n = 0;
                while (iterator.hasNext()) {
                    array2[n] = iterator.next().A;
                    ++n;
                }
            }
            int i = 0;
            int n2 = 0;
            while (i < g.length) {
                this.k[0].d(g[i], this.s);
                this.g.g(g[i], this.r, this.s, array, n2);
                n2 += 2;
                ++i;
            }
            return n2 / 2;
        }
        return 0;
    }
    
    void c(final float[] array, final int n) {
        final float n2 = 1.0f / (n - 1);
        final HashMap<String, c> c = this.C;
        e e = null;
        j j;
        if (c == null) {
            j = null;
        }
        else {
            j = c.get("translationX");
        }
        final HashMap<String, c> c2 = this.C;
        j i;
        if (c2 == null) {
            i = null;
        }
        else {
            i = c2.get("translationY");
        }
        final HashMap<String, b> d = this.D;
        e e2;
        if (d == null) {
            e2 = null;
        }
        else {
            e2 = d.get("translationX");
        }
        final HashMap<String, b> d2 = this.D;
        if (d2 != null) {
            e = d2.get("translationY");
        }
        for (int k = 0; k < n; ++k) {
            final float n3 = k * n2;
            final float o = this.o;
            float min = n3;
            if (o != 1.0f) {
                final float n4 = this.n;
                float n5 = n3;
                if (n3 < n4) {
                    n5 = 0.0f;
                }
                min = n5;
                if (n5 > n4) {
                    min = n5;
                    if (n5 < 1.0) {
                        min = Math.min((n5 - n4) * o, 1.0f);
                    }
                }
            }
            double n6 = min;
            o.c a = this.g.a;
            float n7 = Float.NaN;
            final Iterator<p> iterator = this.y.iterator();
            float n8 = 0.0f;
            while (iterator.hasNext()) {
                final p p2 = iterator.next();
                final o.c a2 = p2.a;
                o.c c3 = a;
                float c4 = n7;
                float c5 = n8;
                if (a2 != null) {
                    c5 = p2.c;
                    if (c5 < min) {
                        c3 = a2;
                        c4 = n7;
                    }
                    else {
                        c3 = a;
                        c4 = n7;
                        c5 = n8;
                        if (Float.isNaN(n7)) {
                            c4 = p2.c;
                            c5 = n8;
                            c3 = a;
                        }
                    }
                }
                a = c3;
                n7 = c4;
                n8 = c5;
            }
            if (a != null) {
                float n9 = n7;
                if (Float.isNaN(n7)) {
                    n9 = 1.0f;
                }
                final float n10 = n9 - n8;
                n6 = (float)a.a((min - n8) / n10) * n10 + n8;
            }
            this.k[0].d(n6, this.s);
            final o.b l = this.l;
            if (l != null) {
                final double[] s = this.s;
                if (s.length > 0) {
                    l.d(n6, s);
                }
            }
            final p g = this.g;
            final int[] r = this.r;
            final double[] s2 = this.s;
            int n11 = k * 2;
            g.g(n6, r, s2, array, n11);
            if (e2 != null) {
                array[n11] += e2.a(min);
            }
            else if (j != null) {
                array[n11] += j.a(min);
            }
            if (e != null) {
                ++n11;
                array[n11] += e.a(min);
            }
            else if (i != null) {
                ++n11;
                array[n11] += i.a(min);
            }
        }
    }
    
    void d(float f, final float[] array, final int n) {
        f = this.f(f, null);
        this.k[0].d(f, this.s);
        this.g.l(this.r, this.s, array, n);
    }
    
    void e(final boolean b) {
        if ("button".equals(androidx.constraintlayout.motion.widget.a.c(this.b)) && this.E != null) {
            int n = 0;
            while (true) {
                final k[] e = this.E;
                if (n >= e.length) {
                    break;
                }
                final k k = e[n];
                float n2;
                if (b) {
                    n2 = -100.0f;
                }
                else {
                    n2 = 100.0f;
                }
                k.t(n2, this.b);
                ++n;
            }
        }
    }
    
    public int g() {
        return this.g.w;
    }
    
    public void h(final double n, final float[] array, final float[] array2) {
        final double[] array3 = new double[4];
        final double[] array4 = new double[4];
        this.k[0].d(n, array3);
        this.k[0].f(n, array4);
        Arrays.fill(array2, 0.0f);
        this.g.h(n, this.r, array3, array, array4, array2);
    }
    
    public float i() {
        return this.p;
    }
    
    public float j() {
        return this.q;
    }
    
    void k(float n, final float n2, final float n3, final float[] array) {
        n = this.f(n, this.z);
        final o.b[] k = this.k;
        int n4 = 0;
        if (k == null) {
            final p h = this.h;
            n = h.e;
            final p g = this.g;
            final float n5 = n - g.e;
            final float n6 = h.f - g.f;
            final float g2 = h.g;
            final float g3 = g.g;
            final float h2 = h.h;
            n = g.h;
            array[0] = n5 * (1.0f - n2) + (g2 - g3 + n5) * n2;
            array[1] = n6 * (1.0f - n3) + (h2 - n + n6) * n3;
            return;
        }
        final o.b b = k[0];
        final double n7 = n;
        b.f(n7, this.t);
        this.k[0].d(n7, this.s);
        n = this.z[0];
        double[] t;
        while (true) {
            t = this.t;
            if (n4 >= t.length) {
                break;
            }
            t[n4] *= n;
            ++n4;
        }
        final o.b l = this.l;
        if (l != null) {
            final double[] s = this.s;
            if (s.length > 0) {
                l.d(n7, s);
                this.l.f(n7, this.t);
                this.g.s(n2, n3, array, this.r, this.t, this.s);
            }
            return;
        }
        this.g.s(n2, n3, array, this.r, t, this.s);
    }
    
    public int l() {
        int n = this.g.b;
        final Iterator<p> iterator = this.y.iterator();
        while (iterator.hasNext()) {
            n = Math.max(n, iterator.next().b);
        }
        return Math.max(n, this.h.b);
    }
    
    p m(final int n) {
        return this.y.get(n);
    }
    
    public View o() {
        return this.b;
    }
    
    boolean q(final View view, float interpolation, final long n, final o.d d) {
        final float f = this.f(interpolation, null);
        final int i = this.I;
        interpolation = f;
        if (i != d.f) {
            final float n2 = 1.0f / i;
            final float n3 = (float)Math.floor(f / n2);
            final float n4 = interpolation = f % n2 / n2;
            if (!Float.isNaN(this.J)) {
                interpolation = (n4 + this.J) % 1.0f;
            }
            final Interpolator k = this.K;
            if (k != null) {
                interpolation = k.getInterpolation(interpolation);
            }
            else if (interpolation > 0.5) {
                interpolation = 1.0f;
            }
            else {
                interpolation = 0.0f;
            }
            interpolation = interpolation * n2 + n3 * n2;
        }
        final HashMap<String, c> c = this.C;
        if (c != null) {
            final Iterator<c> iterator = c.values().iterator();
            while (iterator.hasNext()) {
                iterator.next().g(view, interpolation);
            }
        }
        final HashMap<String, t.d> b = this.B;
        t.d d2;
        int n5;
        if (b != null) {
            final Iterator<t.d> iterator2 = b.values().iterator();
            d2 = null;
            n5 = 0;
            while (iterator2.hasNext()) {
                final t.d d3 = iterator2.next();
                if (d3 instanceof t.d.d) {
                    d2 = d3;
                }
                else {
                    n5 |= (d3.i(view, interpolation, n, d) ? 1 : 0);
                }
            }
        }
        else {
            d2 = null;
            n5 = (false ? 1 : 0);
        }
        final o.b[] j = this.k;
        boolean b3;
        if (j != null) {
            final o.b b2 = j[0];
            final double n6 = interpolation;
            b2.d(n6, this.s);
            this.k[0].f(n6, this.t);
            final o.b l = this.l;
            if (l != null) {
                final double[] s = this.s;
                if (s.length > 0) {
                    l.d(n6, s);
                    this.l.f(n6, this.t);
                }
            }
            if (!this.L) {
                this.g.t(interpolation, view, this.r, this.s, this.t, null, this.d);
                this.d = false;
            }
            if (this.G != d.f) {
                if (this.H == null) {
                    this.H = ((View)view.getParent()).findViewById(this.G);
                }
                final View h = this.H;
                if (h != null) {
                    final float n7 = (h.getTop() + this.H.getBottom()) / 2.0f;
                    final float n8 = (this.H.getLeft() + this.H.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        final float n9 = (float)view.getLeft();
                        final float n10 = (float)view.getTop();
                        view.setPivotX(n8 - n9);
                        view.setPivotY(n7 - n10);
                    }
                }
            }
            final HashMap<String, c> c2 = this.C;
            if (c2 != null) {
                for (final j m : c2.values()) {
                    if (m instanceof c.d) {
                        final double[] t = this.t;
                        if (t.length <= 1) {
                            continue;
                        }
                        ((c.d)m).h(view, interpolation, t[0], t[1]);
                    }
                }
            }
            if (d2 != null) {
                final double[] t2 = this.t;
                n5 |= (((t.d.d)d2).j(view, d, interpolation, n, t2[0], t2[1]) ? 1 : 0);
            }
            int n11 = 1;
            while (true) {
                final o.b[] k2 = this.k;
                if (n11 >= k2.length) {
                    break;
                }
                k2[n11].e(n6, this.x);
                t.a.b(this.g.z.get(this.u[n11 - 1]), view, this.x);
                ++n11;
            }
            final l i2 = this.i;
            if (i2.b == 0) {
                if (interpolation <= 0.0f) {
                    view.setVisibility(i2.c);
                }
                else if (interpolation >= 1.0f) {
                    view.setVisibility(this.j.c);
                }
                else if (this.j.c != i2.c) {
                    view.setVisibility(0);
                }
            }
            b3 = (n5 != 0);
            if (this.E != null) {
                int n12 = 0;
                while (true) {
                    final k[] e = this.E;
                    b3 = (n5 != 0);
                    if (n12 >= e.length) {
                        break;
                    }
                    e[n12].t(interpolation, view);
                    ++n12;
                }
            }
        }
        else {
            final p g = this.g;
            final float e2 = g.e;
            final p h2 = this.h;
            final float e3 = h2.e;
            final float f2 = g.f;
            final float f3 = h2.f;
            final float g2 = g.g;
            final float g3 = h2.g;
            final float h3 = g.h;
            final float h4 = h2.h;
            final float n13 = e2 + (e3 - e2) * interpolation + 0.5f;
            final int n14 = (int)n13;
            final float n15 = f2 + (f3 - f2) * interpolation + 0.5f;
            final int n16 = (int)n15;
            final int n17 = (int)(n13 + ((g3 - g2) * interpolation + g2));
            final int n18 = (int)(n15 + ((h4 - h3) * interpolation + h3));
            if (g3 != g2 || h4 != h3 || this.d) {
                view.measure(View$MeasureSpec.makeMeasureSpec(n17 - n14, 1073741824), View$MeasureSpec.makeMeasureSpec(n18 - n16, 1073741824));
                this.d = false;
            }
            view.layout(n14, n16, n17, n18);
            b3 = (n5 != 0);
        }
        final HashMap<String, b> d4 = this.D;
        if (d4 != null) {
            for (final b b4 : d4.values()) {
                if (b4 instanceof b.d) {
                    final b.d d5 = (b.d)b4;
                    final double[] t3 = this.t;
                    d5.j(view, interpolation, t3[0], t3[1]);
                }
                else {
                    b4.i(view, interpolation);
                }
            }
        }
        return b3;
    }
    
    public void r() {
        this.d = true;
    }
    
    void s(final View view) {
        final p g = this.g;
        g.c = 0.0f;
        g.d = 0.0f;
        this.L = true;
        g.r(view.getX(), view.getY(), (float)view.getWidth(), (float)view.getHeight());
        this.h.r(view.getX(), view.getY(), (float)view.getWidth(), (float)view.getHeight());
        this.i.i(view);
        this.j.i(view);
    }
    
    public void t(final View b) {
        this.b = b;
        this.c = b.getId();
        final ViewGroup$LayoutParams layoutParams = b.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            this.e = ((ConstraintLayout.b)layoutParams).a();
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" start: x: ");
        sb.append(this.g.e);
        sb.append(" y: ");
        sb.append(this.g.f);
        sb.append(" end: x: ");
        sb.append(this.h.e);
        sb.append(" y: ");
        sb.append(this.h.f);
        return sb.toString();
    }
    
    public void u(int i, int j, float n, final long n2) {
        new HashSet();
        final HashSet set = new HashSet();
        final HashSet set2 = new HashSet();
        final HashSet set3 = new HashSet();
        final HashMap hashMap = new HashMap();
        final int f = this.F;
        if (f != androidx.constraintlayout.motion.widget.d.f) {
            this.g.p = f;
        }
        this.i.g(this.j, set2);
        final ArrayList<d> a = this.A;
        ArrayList<k> list2;
        if (a != null) {
            final Iterator<d> iterator = a.iterator();
            ArrayList<k> list = null;
            while (true) {
                list2 = list;
                if (!iterator.hasNext()) {
                    break;
                }
                final d d = iterator.next();
                if (d instanceof h) {
                    final h h = (h)d;
                    this.p(new p(i, j, h, this.g, this.h));
                    final int g = h.g;
                    if (g == androidx.constraintlayout.motion.widget.d.f) {
                        continue;
                    }
                    this.f = g;
                }
                else if (d instanceof f) {
                    d.d(set3);
                }
                else if (d instanceof androidx.constraintlayout.motion.widget.j) {
                    d.d(set);
                }
                else if (d instanceof k) {
                    ArrayList<k> list3;
                    if ((list3 = list) == null) {
                        list3 = new ArrayList<k>();
                    }
                    list3.add((k)d);
                    list = list3;
                }
                else {
                    d.f(hashMap);
                    d.d(set2);
                }
            }
        }
        else {
            list2 = null;
        }
        if (list2 != null) {
            this.E = list2.toArray(new k[0]);
        }
        if (!set2.isEmpty()) {
            this.C = new HashMap<String, c>();
            for (final String s : set2) {
                c c;
                if (s.startsWith("CUSTOM,")) {
                    final SparseArray sparseArray = new SparseArray();
                    final String s2 = s.split(",")[1];
                    for (final d d2 : this.A) {
                        final HashMap<String, ConstraintAttribute> e = d2.e;
                        if (e == null) {
                            continue;
                        }
                        final ConstraintAttribute constraintAttribute = e.get(s2);
                        if (constraintAttribute == null) {
                            continue;
                        }
                        sparseArray.append(d2.a, (Object)constraintAttribute);
                    }
                    c = t.c.e(s, (SparseArray<ConstraintAttribute>)sparseArray);
                }
                else {
                    c = t.c.f(s);
                }
                if (c == null) {
                    continue;
                }
                c.c(s);
                this.C.put(s, c);
            }
            final ArrayList<d> a2 = this.A;
            if (a2 != null) {
                for (final d d3 : a2) {
                    if (d3 instanceof androidx.constraintlayout.motion.widget.e) {
                        d3.a(this.C);
                    }
                }
            }
            this.i.a(this.C, 0);
            this.j.a(this.C, 100);
            for (final String s3 : this.C.keySet()) {
                Label_0676: {
                    if (hashMap.containsKey(s3)) {
                        final Integer n3 = hashMap.get(s3);
                        if (n3 != null) {
                            i = n3;
                            break Label_0676;
                        }
                    }
                    i = 0;
                }
                final j k = this.C.get(s3);
                if (k != null) {
                    k.d(i);
                }
            }
        }
        if (!set.isEmpty()) {
            if (this.B == null) {
                this.B = new HashMap<String, t.d>();
            }
            for (final String s4 : set) {
                if (this.B.containsKey(s4)) {
                    continue;
                }
                t.d d5;
                if (s4.startsWith("CUSTOM,")) {
                    final SparseArray sparseArray2 = new SparseArray();
                    final String s5 = s4.split(",")[1];
                    for (final d d4 : this.A) {
                        final HashMap<String, ConstraintAttribute> e2 = d4.e;
                        if (e2 == null) {
                            continue;
                        }
                        final ConstraintAttribute constraintAttribute2 = e2.get(s5);
                        if (constraintAttribute2 == null) {
                            continue;
                        }
                        sparseArray2.append(d4.a, (Object)constraintAttribute2);
                    }
                    d5 = t.d.g(s4, (SparseArray<ConstraintAttribute>)sparseArray2);
                }
                else {
                    d5 = t.d.h(s4, n2);
                }
                if (d5 == null) {
                    continue;
                }
                d5.d(s4);
                this.B.put(s4, d5);
            }
            final ArrayList<d> a3 = this.A;
            if (a3 != null) {
                for (final d d6 : a3) {
                    if (d6 instanceof androidx.constraintlayout.motion.widget.j) {
                        ((androidx.constraintlayout.motion.widget.j)d6).P(this.B);
                    }
                }
            }
            for (final String s6 : this.B.keySet()) {
                if (hashMap.containsKey(s6)) {
                    i = (int)hashMap.get(s6);
                }
                else {
                    i = 0;
                }
                this.B.get(s6).e(i);
            }
        }
        final int n4 = this.y.size() + 2;
        final p[] array = new p[n4];
        array[0] = this.g;
        array[n4 - 1] = this.h;
        if (this.y.size() > 0 && this.f == -1) {
            this.f = 0;
        }
        final Iterator<p> iterator10 = this.y.iterator();
        i = 1;
        while (iterator10.hasNext()) {
            array[i] = iterator10.next();
            ++i;
        }
        final HashSet<String> set4 = new HashSet<String>();
        for (final String s7 : this.h.z.keySet()) {
            if (this.g.z.containsKey(s7)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("CUSTOM,");
                sb.append(s7);
                if (set2.contains(sb.toString())) {
                    continue;
                }
                set4.add(s7);
            }
        }
        final String[] u = set4.toArray(new String[0]);
        this.u = u;
        this.v = new int[u.length];
        i = 0;
        String[] u2;
        while (true) {
            u2 = this.u;
            if (i >= u2.length) {
                break;
            }
            final String s8 = u2[i];
            this.v[i] = 0;
            ConstraintAttribute constraintAttribute3;
            int[] v;
            for (j = 0; j < n4; ++j) {
                if (array[j].z.containsKey(s8)) {
                    constraintAttribute3 = array[j].z.get(s8);
                    if (constraintAttribute3 != null) {
                        v = this.v;
                        v[i] += constraintAttribute3.g();
                        break;
                    }
                }
            }
            ++i;
        }
        final boolean b = array[0].p != androidx.constraintlayout.motion.widget.d.f;
        final int n5 = 18 + u2.length;
        final boolean[] array2 = new boolean[n5];
        for (i = 1; i < n4; ++i) {
            array[i].d(array[i - 1], array2, this.u, b);
        }
        int n6 = 0;
        for (i = 1; i < n5; ++i, n6 = j) {
            j = n6;
            if (array2[i]) {
                j = n6 + 1;
            }
        }
        this.r = new int[n6];
        i = Math.max(2, n6);
        this.s = new double[i];
        this.t = new double[i];
        i = 0;
        for (int l = 1; l < n5; ++l, i = j) {
            j = i;
            if (array2[l]) {
                this.r[i] = l;
                j = i + 1;
            }
        }
        final double[][] array3 = new double[n4][this.r.length];
        final double[] array4 = new double[n4];
        for (i = 0; i < n4; ++i) {
            array[i].f(array3[i], this.r);
            array4[i] = array[i].c;
        }
        i = 0;
        while (true) {
            final int[] r = this.r;
            if (i >= r.length) {
                break;
            }
            if (r[i] < androidx.constraintlayout.motion.widget.p.D.length) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(androidx.constraintlayout.motion.widget.p.D[this.r[i]]);
                sb2.append(" [");
                String s9 = sb2.toString();
                StringBuilder sb3;
                for (j = 0; j < n4; ++j) {
                    sb3 = new StringBuilder();
                    sb3.append(s9);
                    sb3.append(array3[j][i]);
                    s9 = sb3.toString();
                }
            }
            ++i;
        }
        this.k = new o.b[this.u.length + 1];
        i = 0;
        while (true) {
            final String[] u3 = this.u;
            if (i >= u3.length) {
                break;
            }
            final String s10 = u3[i];
            j = 0;
            int n7 = 0;
            double[] array5 = null;
            double[][] array6 = null;
            while (j < n4) {
                double[] array7 = array5;
                int n8 = n7;
                double[][] array8 = array6;
                if (array[j].m(s10)) {
                    if ((array8 = array6) == null) {
                        array5 = new double[n4];
                        array8 = new double[n4][array[j].k(s10)];
                    }
                    array5[n7] = array[j].c;
                    array[j].i(s10, array8[n7], 0);
                    n8 = n7 + 1;
                    array7 = array5;
                }
                ++j;
                array5 = array7;
                n7 = n8;
                array6 = array8;
            }
            final double[] copy = Arrays.copyOf(array5, n7);
            final double[][] array9 = Arrays.copyOf(array6, n7);
            final o.b[] m = this.k;
            ++i;
            m[i] = o.b.a(this.f, copy, array9);
        }
        this.k[0] = o.b.a(this.f, array4, array3);
        if (array[0].p != androidx.constraintlayout.motion.widget.d.f) {
            final int[] array10 = new int[n4];
            final double[] array11 = new double[n4];
            final double[][] array12 = new double[n4][2];
            for (i = 0; i < n4; ++i) {
                array10[i] = array[i].p;
                array11[i] = array[i].c;
                array12[i][0] = array[i].e;
                array12[i][1] = array[i].f;
            }
            this.l = o.b.b(array10, array11, array12);
        }
        n = Float.NaN;
        this.D = new HashMap<String, b>();
        if (this.A != null) {
            for (final String s11 : set3) {
                final b h2 = t.b.h(s11);
                if (h2 == null) {
                    continue;
                }
                float n9 = n;
                if (h2.g()) {
                    n9 = n;
                    if (Float.isNaN(n)) {
                        n9 = this.n();
                    }
                }
                h2.e(s11);
                this.D.put(s11, h2);
                n = n9;
            }
            for (final d d7 : this.A) {
                if (d7 instanceof f) {
                    ((f)d7).T(this.D);
                }
            }
            final Iterator<b> iterator14 = this.D.values().iterator();
            while (iterator14.hasNext()) {
                iterator14.next().f(n);
            }
        }
    }
}
