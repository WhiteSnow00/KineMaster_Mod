// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import android.content.res.TypedArray;
import androidx.constraintlayout.widget.h;
import android.util.Xml;
import android.view.View;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import androidx.constraintlayout.widget.ConstraintAttribute;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import android.content.Context;
import androidx.constraintlayout.widget.c;

public class t
{
    private static String w = "ViewTransition";
    private int a;
    private int b;
    private boolean c;
    private int d;
    int e;
    g f;
    c.a g;
    private int h;
    private int i;
    private int j;
    private String k;
    private int l;
    private String m;
    private int n;
    Context o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    
    t(final Context o, final XmlPullParser xmlPullParser) {
        this.b = -1;
        this.c = false;
        this.d = 0;
        this.h = -1;
        this.i = -1;
        this.l = 0;
        this.m = null;
        this.n = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.o = o;
        try {
            for (int i = xmlPullParser.getEventType(); i != 1; i = xmlPullParser.next()) {
                if (i != 2) {
                    if (i == 3) {
                        if ("ViewTransition".equals(xmlPullParser.getName())) {
                            return;
                        }
                    }
                }
                else {
                    final String name = xmlPullParser.getName();
                    int n = 0;
                    Label_0268: {
                        switch (name.hashCode()) {
                            case 1791837707: {
                                if (name.equals("CustomAttribute")) {
                                    n = 3;
                                    break Label_0268;
                                }
                                break;
                            }
                            case 366511058: {
                                if (name.equals("CustomMethod")) {
                                    n = 4;
                                    break Label_0268;
                                }
                                break;
                            }
                            case 61998586: {
                                if (name.equals("ViewTransition")) {
                                    n = 0;
                                    break Label_0268;
                                }
                                break;
                            }
                            case -1239391468: {
                                if (name.equals("KeyFrameSet")) {
                                    n = 1;
                                    break Label_0268;
                                }
                                break;
                            }
                            case -1962203927: {
                                if (name.equals("ConstraintOverride")) {
                                    n = 2;
                                    break Label_0268;
                                }
                                break;
                            }
                        }
                        n = -1;
                    }
                    if (n != 0) {
                        if (n != 1) {
                            if (n != 2) {
                                if (n != 3 && n != 4) {
                                    final String w = androidx.constraintlayout.motion.widget.t.w;
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append(androidx.constraintlayout.motion.widget.a.a());
                                    sb.append(" unknown tag ");
                                    sb.append(name);
                                    Log.e(w, sb.toString());
                                    final String w2 = androidx.constraintlayout.motion.widget.t.w;
                                    final StringBuilder sb2 = new StringBuilder();
                                    sb2.append(".xml:");
                                    sb2.append(xmlPullParser.getLineNumber());
                                    Log.e(w2, sb2.toString());
                                }
                                else {
                                    ConstraintAttribute.h(o, xmlPullParser, this.g.g);
                                }
                            }
                            else {
                                this.g = androidx.constraintlayout.widget.c.k(o, xmlPullParser);
                            }
                        }
                        else {
                            this.f = new g(o, xmlPullParser);
                        }
                    }
                    else {
                        this.l(o, xmlPullParser);
                    }
                }
            }
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        catch (final XmlPullParserException ex2) {
            ex2.printStackTrace();
        }
    }
    
    public static void a(final t t, final View[] array) {
        t.j(array);
    }
    
    private void j(final View[] array) {
        final int p = this.p;
        final int n = 0;
        if (p != -1) {
            for (int length = array.length, i = 0; i < length; ++i) {
                array[i].setTag(this.p, (Object)System.nanoTime());
            }
        }
        if (this.q != -1) {
            for (int length2 = array.length, j = n; j < length2; ++j) {
                array[j].setTag(this.q, (Object)null);
            }
        }
    }
    
    private void l(final Context context, final XmlPullParser xmlPullParser) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), androidx.constraintlayout.widget.h.P9);
        for (int indexCount = obtainStyledAttributes.getIndexCount(), i = 0; i < indexCount; ++i) {
            final int index = obtainStyledAttributes.getIndex(i);
            if (index == androidx.constraintlayout.widget.h.Q9) {
                this.a = obtainStyledAttributes.getResourceId(index, this.a);
            }
            else if (index == androidx.constraintlayout.widget.h.Y9) {
                if (MotionLayout.E0) {
                    if ((this.j = obtainStyledAttributes.getResourceId(index, this.j)) == -1) {
                        this.k = obtainStyledAttributes.getString(index);
                    }
                }
                else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.k = obtainStyledAttributes.getString(index);
                }
                else {
                    this.j = obtainStyledAttributes.getResourceId(index, this.j);
                }
            }
            else if (index == androidx.constraintlayout.widget.h.Z9) {
                this.b = obtainStyledAttributes.getInt(index, this.b);
            }
            else if (index == androidx.constraintlayout.widget.h.ca) {
                this.c = obtainStyledAttributes.getBoolean(index, this.c);
            }
            else if (index == androidx.constraintlayout.widget.h.aa) {
                this.d = obtainStyledAttributes.getInt(index, this.d);
            }
            else if (index == androidx.constraintlayout.widget.h.U9) {
                this.h = obtainStyledAttributes.getInt(index, this.h);
            }
            else if (index == androidx.constraintlayout.widget.h.da) {
                this.i = obtainStyledAttributes.getInt(index, this.i);
            }
            else if (index == androidx.constraintlayout.widget.h.ea) {
                this.e = obtainStyledAttributes.getInt(index, this.e);
            }
            else if (index == androidx.constraintlayout.widget.h.X9) {
                final int type = obtainStyledAttributes.peekValue(index).type;
                if (type == 1) {
                    if ((this.n = obtainStyledAttributes.getResourceId(index, -1)) != -1) {
                        this.l = -2;
                    }
                }
                else if (type == 3) {
                    final String string = obtainStyledAttributes.getString(index);
                    this.m = string;
                    if (string != null && string.indexOf("/") > 0) {
                        this.n = obtainStyledAttributes.getResourceId(index, -1);
                        this.l = -2;
                    }
                    else {
                        this.l = -1;
                    }
                }
                else {
                    this.l = obtainStyledAttributes.getInteger(index, this.l);
                }
            }
            else if (index == androidx.constraintlayout.widget.h.ba) {
                this.p = obtainStyledAttributes.getResourceId(index, this.p);
            }
            else if (index == androidx.constraintlayout.widget.h.T9) {
                this.q = obtainStyledAttributes.getResourceId(index, this.q);
            }
            else if (index == androidx.constraintlayout.widget.h.W9) {
                this.r = obtainStyledAttributes.getResourceId(index, this.r);
            }
            else if (index == androidx.constraintlayout.widget.h.V9) {
                this.s = obtainStyledAttributes.getResourceId(index, this.s);
            }
            else if (index == androidx.constraintlayout.widget.h.S9) {
                this.u = obtainStyledAttributes.getResourceId(index, this.u);
            }
            else if (index == androidx.constraintlayout.widget.h.R9) {
                this.t = obtainStyledAttributes.getInteger(index, this.t);
            }
        }
        obtainStyledAttributes.recycle();
    }
    
    private void n(final q.b b, final View view) {
        final int h = this.h;
        if (h != -1) {
            b.C(h);
        }
        b.E(this.d);
        b.D(this.l, this.m, this.n);
        final int id = view.getId();
        final g f = this.f;
        if (f != null) {
            final ArrayList<d> c = f.c(-1);
            final g g = new g();
            final Iterator<d> iterator = c.iterator();
            while (iterator.hasNext()) {
                g.b(iterator.next().b().g(id));
            }
            b.r(g);
        }
    }
    
    void b(final u u, final MotionLayout motionLayout, final View view) {
        final m m = new m(view);
        m.s(view);
        this.f.a(m);
        m.u(motionLayout.getWidth(), motionLayout.getHeight(), (float)this.h, System.nanoTime());
        new b(u, m, this.h, this.i, this.b, this.f(motionLayout.getContext()), this.p, this.q);
    }
    
    void c(final u u, final MotionLayout motionLayout, int i, final c c, final View... array) {
        if (this.c) {
            return;
        }
        final int e = this.e;
        final int n = 0;
        if (e == 2) {
            this.b(u, motionLayout, array[0]);
            return;
        }
        if (e == 1) {
            final int[] constraintSetIds = motionLayout.getConstraintSetIds();
            for (int j = 0; j < constraintSetIds.length; ++j) {
                final int n2 = constraintSetIds[j];
                if (n2 != i) {
                    final c t = motionLayout.t(n2);
                    for (int length = array.length, k = 0; k < length; ++k) {
                        final c.a w = t.w(array[k].getId());
                        final c.a g = this.g;
                        if (g != null) {
                            g.d(w);
                            w.g.putAll(this.g.g);
                        }
                    }
                }
            }
        }
        final c c2 = new c();
        c2.o(c);
        for (int length2 = array.length, l = 0; l < length2; ++l) {
            final c.a w2 = c2.w(array[l].getId());
            final c.a g2 = this.g;
            if (g2 != null) {
                g2.d(w2);
                w2.g.putAll(this.g.g);
            }
        }
        motionLayout.M(i, c2);
        final int b = androidx.constraintlayout.widget.g.b;
        motionLayout.M(b, c);
        motionLayout.setState(b, -1, -1);
        final q.b transition = new q.b(-1, motionLayout.a, b, i);
        int length3;
        for (length3 = array.length, i = n; i < length3; ++i) {
            this.n(transition, array[i]);
        }
        motionLayout.setTransition(transition);
        motionLayout.G(new s(this, array));
    }
    
    boolean d(final View view) {
        final int r = this.r;
        final boolean b = false;
        final boolean b2 = r == -1 || view.getTag(r) != null;
        final int s = this.s;
        final boolean b3 = s == -1 || view.getTag(s) == null;
        boolean b4 = b;
        if (b2) {
            b4 = b;
            if (b3) {
                b4 = true;
            }
        }
        return b4;
    }
    
    int e() {
        return this.a;
    }
    
    Interpolator f(final Context context) {
        final int l = this.l;
        if (l == -2) {
            return AnimationUtils.loadInterpolator(context, this.n);
        }
        if (l == -1) {
            return (Interpolator)new Interpolator(this, o.c.c(this.m)) {
                final o.c a;
                
                public float getInterpolation(final float n) {
                    return (float)this.a.a(n);
                }
            };
        }
        if (l == 0) {
            return (Interpolator)new AccelerateDecelerateInterpolator();
        }
        if (l == 1) {
            return (Interpolator)new AccelerateInterpolator();
        }
        if (l == 2) {
            return (Interpolator)new DecelerateInterpolator();
        }
        if (l == 4) {
            return (Interpolator)new BounceInterpolator();
        }
        if (l == 5) {
            return (Interpolator)new OvershootInterpolator();
        }
        if (l != 6) {
            return null;
        }
        return (Interpolator)new AnticipateInterpolator();
    }
    
    public int g() {
        return this.t;
    }
    
    public int h() {
        return this.u;
    }
    
    public int i() {
        return this.b;
    }
    
    boolean k(final View view) {
        if (view == null) {
            return false;
        }
        if (this.j == -1 && this.k == null) {
            return false;
        }
        if (!this.d(view)) {
            return false;
        }
        if (view.getId() == this.j) {
            return true;
        }
        if (this.k == null) {
            return false;
        }
        if (view.getLayoutParams() instanceof ConstraintLayout.b) {
            final String c0 = ((ConstraintLayout.b)view.getLayoutParams()).c0;
            if (c0 != null && c0.matches(this.k)) {
                return true;
            }
        }
        return false;
    }
    
    boolean m(final int n) {
        final int b = this.b;
        final boolean b2 = false;
        final boolean b3 = false;
        boolean b4 = false;
        if (b == 1) {
            if (n == 0) {
                b4 = true;
            }
            return b4;
        }
        if (b == 2) {
            boolean b5 = b2;
            if (n == 1) {
                b5 = true;
            }
            return b5;
        }
        boolean b6 = b3;
        if (b == 3) {
            b6 = b3;
            if (n == 0) {
                b6 = true;
            }
        }
        return b6;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ViewTransition(");
        sb.append(androidx.constraintlayout.motion.widget.a.b(this.o, this.a));
        sb.append(")");
        return sb.toString();
    }
    
    static class b
    {
        private final int a;
        private final int b;
        long c;
        m d;
        int e;
        int f;
        o.d g;
        u h;
        Interpolator i;
        boolean j;
        float k;
        float l;
        long m;
        Rect n;
        boolean o;
        
        b(final u h, final m d, final int e, final int f, final int n, final Interpolator i, final int a, final int b) {
            this.g = new o.d();
            this.j = false;
            this.n = new Rect();
            this.o = false;
            this.h = h;
            this.d = d;
            this.e = e;
            this.f = f;
            final long nanoTime = System.nanoTime();
            this.c = nanoTime;
            this.m = nanoTime;
            this.h.b(this);
            this.i = i;
            this.a = a;
            this.b = b;
            if (n == 3) {
                this.o = true;
            }
            float l;
            if (e == 0) {
                l = Float.MAX_VALUE;
            }
            else {
                l = 1.0f / e;
            }
            this.l = l;
            this.a();
        }
        
        void a() {
            if (this.j) {
                this.c();
            }
            else {
                this.b();
            }
        }
        
        void b() {
            final long nanoTime = System.nanoTime();
            final long m = this.m;
            this.m = nanoTime;
            final float k = this.k + (float)((nanoTime - m) * 1.0E-6) * this.l;
            this.k = k;
            if (k >= 1.0f) {
                this.k = 1.0f;
            }
            final Interpolator i = this.i;
            float n;
            if (i == null) {
                n = this.k;
            }
            else {
                n = i.getInterpolation(this.k);
            }
            final m d = this.d;
            final boolean q = d.q(d.b, n, nanoTime, this.g);
            if (this.k >= 1.0f) {
                if (this.a != -1) {
                    this.d.o().setTag(this.a, (Object)System.nanoTime());
                }
                if (this.b != -1) {
                    this.d.o().setTag(this.b, (Object)null);
                }
                if (!this.o) {
                    this.h.f(this);
                }
            }
            if (this.k < 1.0f || q) {
                this.h.d();
            }
        }
        
        void c() {
            final long nanoTime = System.nanoTime();
            final long m = this.m;
            this.m = nanoTime;
            final float k = this.k - (float)((nanoTime - m) * 1.0E-6) * this.l;
            this.k = k;
            if (k < 0.0f) {
                this.k = 0.0f;
            }
            final Interpolator i = this.i;
            float n;
            if (i == null) {
                n = this.k;
            }
            else {
                n = i.getInterpolation(this.k);
            }
            final m d = this.d;
            final boolean q = d.q(d.b, n, nanoTime, this.g);
            if (this.k <= 0.0f) {
                if (this.a != -1) {
                    this.d.o().setTag(this.a, (Object)System.nanoTime());
                }
                if (this.b != -1) {
                    this.d.o().setTag(this.b, (Object)null);
                }
                this.h.f(this);
            }
            if (this.k > 0.0f || q) {
                this.h.d();
            }
        }
        
        public void d(final int n, final float n2, final float n3) {
            if (n != 1) {
                if (n == 2) {
                    this.d.o().getHitRect(this.n);
                    if (!this.n.contains((int)n2, (int)n3) && !this.j) {
                        this.e(true);
                    }
                }
                return;
            }
            if (!this.j) {
                this.e(true);
            }
        }
        
        void e(final boolean j) {
            this.j = j;
            if (j) {
                final int f = this.f;
                if (f != -1) {
                    float l;
                    if (f == 0) {
                        l = Float.MAX_VALUE;
                    }
                    else {
                        l = 1.0f / f;
                    }
                    this.l = l;
                }
            }
            this.h.d();
            this.m = System.nanoTime();
        }
    }
}
