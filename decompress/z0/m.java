// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.util.SparseIntArray;
import java.util.Iterator;
import java.util.List;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.b0;
import android.animation.Animator$AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import androidx.collection.d;
import android.util.SparseArray;
import android.graphics.Path;
import android.view.View;
import android.animation.TimeInterpolator;
import java.util.ArrayList;
import android.animation.Animator;
import androidx.collection.a;

public abstract class m implements Cloneable
{
    private static final int[] Q;
    private static final g R;
    private static ThreadLocal<a<Animator, d>> S;
    private t A;
    private t B;
    q C;
    private int[] D;
    private ArrayList<s> E;
    private ArrayList<s> F;
    boolean G;
    ArrayList<Animator> H;
    private int I;
    private boolean J;
    private boolean K;
    private ArrayList<f> L;
    private ArrayList<Animator> M;
    private e N;
    private a<String, String> O;
    private g P;
    private String a;
    private long b;
    long c;
    private TimeInterpolator d;
    ArrayList<Integer> e;
    ArrayList<View> f;
    private ArrayList<String> g;
    private ArrayList<Class<?>> h;
    private ArrayList<Integer> i;
    private ArrayList<View> j;
    private ArrayList<Class<?>> p;
    private ArrayList<String> w;
    private ArrayList<Integer> x;
    private ArrayList<View> y;
    private ArrayList<Class<?>> z;
    
    static {
        Q = new int[] { 2, 1, 3, 4 };
        R = new g() {
            @Override
            public Path a(final float n, final float n2, final float n3, final float n4) {
                final Path path = new Path();
                path.moveTo(n, n2);
                path.lineTo(n3, n4);
                return path;
            }
        };
        m.S = new ThreadLocal<a<Animator, d>>();
    }
    
    public m() {
        this.a = this.getClass().getName();
        this.b = -1L;
        this.c = -1L;
        this.d = null;
        this.e = new ArrayList<Integer>();
        this.f = new ArrayList<View>();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.p = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = new t();
        this.B = new t();
        this.C = null;
        this.D = m.Q;
        this.G = false;
        this.H = new ArrayList<Animator>();
        this.I = 0;
        this.J = false;
        this.K = false;
        this.L = null;
        this.M = new ArrayList<Animator>();
        this.P = m.R;
    }
    
    private static a<Animator, d> A() {
        a a;
        if ((a = m.S.get()) == null) {
            a = new a();
            m.S.set(a);
        }
        return a;
    }
    
    private static boolean K(final s s, final s s2, final String s3) {
        final Object value = s.a.get(s3);
        final Object value2 = s2.a.get(s3);
        final boolean b = true;
        boolean b2;
        if (value == null && value2 == null) {
            b2 = false;
        }
        else {
            b2 = b;
            if (value != null) {
                if (value2 == null) {
                    b2 = b;
                }
                else {
                    b2 = (true ^ value.equals(value2));
                }
            }
        }
        return b2;
    }
    
    private void L(final a<View, s> a, final a<View, s> a2, final SparseArray<View> sparseArray, final SparseArray<View> sparseArray2) {
        for (int size = sparseArray.size(), i = 0; i < size; ++i) {
            final View view = (View)sparseArray.valueAt(i);
            if (view != null && this.J(view)) {
                final View view2 = (View)sparseArray2.get(sparseArray.keyAt(i));
                if (view2 != null && this.J(view2)) {
                    final s s = a.get(view);
                    final s s2 = a2.get(view2);
                    if (s != null && s2 != null) {
                        this.E.add(s);
                        this.F.add(s2);
                        a.remove(view);
                        a2.remove(view2);
                    }
                }
            }
        }
    }
    
    private void M(final a<View, s> a, final a<View, s> a2) {
        for (int i = a.size() - 1; i >= 0; --i) {
            final View view = (View)a.i(i);
            if (view != null && this.J(view)) {
                final s s = a2.remove(view);
                if (s != null && this.J(s.b)) {
                    this.E.add((s)a.k(i));
                    this.F.add(s);
                }
            }
        }
    }
    
    private void N(final a<View, s> a, final a<View, s> a2, final androidx.collection.d<View> d, final androidx.collection.d<View> d2) {
        for (int o = d.o(), i = 0; i < o; ++i) {
            final View view = d.p(i);
            if (view != null && this.J(view)) {
                final View view2 = d2.f(d.j(i));
                if (view2 != null && this.J(view2)) {
                    final s s = a.get(view);
                    final s s2 = a2.get(view2);
                    if (s != null && s2 != null) {
                        this.E.add(s);
                        this.F.add(s2);
                        a.remove(view);
                        a2.remove(view2);
                    }
                }
            }
        }
    }
    
    private void P(final a<View, s> a, final a<View, s> a2, final a<String, View> a3, final a<String, View> a4) {
        for (int size = a3.size(), i = 0; i < size; ++i) {
            final View view = (View)a3.m(i);
            if (view != null && this.J(view)) {
                final View view2 = a4.get(a3.i(i));
                if (view2 != null && this.J(view2)) {
                    final s s = a.get(view);
                    final s s2 = a2.get(view2);
                    if (s != null && s2 != null) {
                        this.E.add(s);
                        this.F.add(s2);
                        a.remove(view);
                        a2.remove(view2);
                    }
                }
            }
        }
    }
    
    private void Q(final t t, final t t2) {
        final a a = new a(t.a);
        final a a2 = new a(t2.a);
        int n = 0;
        while (true) {
            final int[] d = this.D;
            if (n >= d.length) {
                break;
            }
            final int n2 = d[n];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 == 4) {
                            this.N(a, a2, t.c, t2.c);
                        }
                    }
                    else {
                        this.L(a, a2, t.b, t2.b);
                    }
                }
                else {
                    this.P(a, a2, t.d, t2.d);
                }
            }
            else {
                this.M(a, a2);
            }
            ++n;
        }
        this.d(a, a2);
    }
    
    private void X(final Animator animator, final a<Animator, d> a) {
        if (animator != null) {
            animator.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, a) {
                final a a;
                final m b;
                
                public void onAnimationEnd(final Animator animator) {
                    this.a.remove(animator);
                    this.b.H.remove(animator);
                }
                
                public void onAnimationStart(final Animator animator) {
                    this.b.H.add(animator);
                }
            });
            this.f(animator);
        }
    }
    
    private void d(final a<View, s> a, final a<View, s> a2) {
        final int n = 0;
        int n2 = 0;
        int i;
        while (true) {
            i = n;
            if (n2 >= a.size()) {
                break;
            }
            final s s = (s)a.m(n2);
            if (this.J(s.b)) {
                this.E.add(s);
                this.F.add(null);
            }
            ++n2;
        }
        while (i < a2.size()) {
            final s s2 = (s)a2.m(i);
            if (this.J(s2.b)) {
                this.F.add(s2);
                this.E.add(null);
            }
            ++i;
        }
    }
    
    private static void e(final t t, View view, final s s) {
        t.a.put(view, s);
        final int id = view.getId();
        if (id >= 0) {
            if (t.b.indexOfKey(id) >= 0) {
                t.b.put(id, (Object)null);
            }
            else {
                t.b.put(id, (Object)view);
            }
        }
        final String j = b0.J(view);
        if (j != null) {
            if (t.d.containsKey(j)) {
                t.d.put(j, null);
            }
            else {
                t.d.put(j, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            final ListView listView = (ListView)view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                final long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (t.c.h(itemIdAtPosition) >= 0) {
                    view = t.c.f(itemIdAtPosition);
                    if (view != null) {
                        b0.z0(view, false);
                        t.c.l(itemIdAtPosition, null);
                    }
                }
                else {
                    b0.z0(view, true);
                    t.c.l(itemIdAtPosition, view);
                }
            }
        }
    }
    
    private void h(final View view, final boolean b) {
        if (view == null) {
            return;
        }
        final int id = view.getId();
        final ArrayList<Integer> i = this.i;
        if (i != null && i.contains(id)) {
            return;
        }
        final ArrayList<View> j = this.j;
        if (j != null && j.contains(view)) {
            return;
        }
        final ArrayList<Class<?>> p2 = this.p;
        final int n = 0;
        if (p2 != null) {
            for (int size = p2.size(), k = 0; k < size; ++k) {
                if (this.p.get(k).isInstance(view)) {
                    return;
                }
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            final s s = new s(view);
            if (b) {
                this.j(s);
            }
            else {
                this.g(s);
            }
            s.c.add(this);
            this.i(s);
            if (b) {
                e(this.A, view, s);
            }
            else {
                e(this.B, view, s);
            }
        }
        if (view instanceof ViewGroup) {
            final ArrayList<Integer> x = this.x;
            if (x != null && x.contains(id)) {
                return;
            }
            final ArrayList<View> y = this.y;
            if (y != null && y.contains(view)) {
                return;
            }
            final ArrayList<Class<?>> z = this.z;
            if (z != null) {
                for (int size2 = z.size(), l = 0; l < size2; ++l) {
                    if (this.z.get(l).isInstance(view)) {
                        return;
                    }
                }
            }
            final ViewGroup viewGroup = (ViewGroup)view;
            for (int n2 = n; n2 < viewGroup.getChildCount(); ++n2) {
                this.h(viewGroup.getChildAt(n2), b);
            }
        }
    }
    
    public long B() {
        return this.b;
    }
    
    public List<Integer> C() {
        return this.e;
    }
    
    public List<String> D() {
        return this.g;
    }
    
    public List<Class<?>> E() {
        return this.h;
    }
    
    public List<View> F() {
        return this.f;
    }
    
    public String[] G() {
        return null;
    }
    
    public s H(final View view, final boolean b) {
        final q c = this.C;
        if (c != null) {
            return c.H(view, b);
        }
        t t;
        if (b) {
            t = this.A;
        }
        else {
            t = this.B;
        }
        return (s)t.a.get(view);
    }
    
    public boolean I(final s s, final s s2) {
        boolean b2;
        final boolean b = b2 = false;
        if (s != null) {
            b2 = b;
            if (s2 != null) {
                final String[] g = this.G();
                if (g != null) {
                    final int length = g.length;
                    int n = 0;
                    while (true) {
                        b2 = b;
                        if (n >= length) {
                            return b2;
                        }
                        if (K(s, s2, g[n])) {
                            break;
                        }
                        ++n;
                    }
                }
                else {
                    final Iterator<String> iterator = s.a.keySet().iterator();
                    do {
                        b2 = b;
                        if (iterator.hasNext()) {
                            continue;
                        }
                        return b2;
                    } while (!K(s, s2, iterator.next()));
                }
                b2 = true;
            }
        }
        return b2;
    }
    
    boolean J(final View view) {
        final int id = view.getId();
        final ArrayList<Integer> i = this.i;
        if (i != null && i.contains(id)) {
            return false;
        }
        final ArrayList<View> j = this.j;
        if (j != null && j.contains(view)) {
            return false;
        }
        final ArrayList<Class<?>> p = this.p;
        if (p != null) {
            for (int size = p.size(), k = 0; k < size; ++k) {
                if (this.p.get(k).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.w != null && b0.J(view) != null && this.w.contains(b0.J(view))) {
            return false;
        }
        if (this.e.size() == 0 && this.f.size() == 0) {
            final ArrayList<Class<?>> h = this.h;
            if (h == null || h.isEmpty()) {
                final ArrayList<String> g = this.g;
                if (g == null || g.isEmpty()) {
                    return true;
                }
            }
        }
        if (this.e.contains(id) || this.f.contains(view)) {
            return true;
        }
        final ArrayList<String> g2 = this.g;
        if (g2 != null && g2.contains(b0.J(view))) {
            return true;
        }
        if (this.h != null) {
            for (int l = 0; l < this.h.size(); ++l) {
                if (this.h.get(l).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void R(final View view) {
        if (!this.K) {
            for (int i = this.H.size() - 1; i >= 0; --i) {
                z0.a.b(this.H.get(i));
            }
            final ArrayList<f> l = this.L;
            if (l != null && l.size() > 0) {
                final ArrayList list = (ArrayList)this.L.clone();
                for (int size = list.size(), j = 0; j < size; ++j) {
                    ((f)list.get(j)).d(this);
                }
            }
            this.J = true;
        }
    }
    
    void S(final ViewGroup viewGroup) {
        this.E = new ArrayList<s>();
        this.F = new ArrayList<s>();
        this.Q(this.A, this.B);
        final a<Animator, d> a = A();
        int i = a.size();
        final i0 d = z0.z.d((View)viewGroup);
        --i;
        while (i >= 0) {
            final Animator animator = (Animator)a.i(i);
            if (animator != null) {
                final d d2 = (d)a.get(animator);
                if (d2 != null && d2.a != null && d.equals(d2.d)) {
                    final s c = d2.c;
                    final View a2 = d2.a;
                    final s h = this.H(a2, true);
                    s w;
                    final s s = w = this.w(a2, (boolean)(1 != 0));
                    if (h == null && (w = s) == null) {
                        w = this.B.a.get(a2);
                    }
                    if ((h != null || w != null) && d2.e.I(c, w)) {
                        if (!animator.isRunning() && !animator.isStarted()) {
                            a.remove(animator);
                        }
                        else {
                            animator.cancel();
                        }
                    }
                }
            }
            --i;
        }
        this.p(viewGroup, this.A, this.B, this.E, this.F);
        this.Y();
    }
    
    public m T(final f f) {
        final ArrayList<f> l = this.L;
        if (l == null) {
            return this;
        }
        l.remove(f);
        if (this.L.size() == 0) {
            this.L = null;
        }
        return this;
    }
    
    public m U(final View view) {
        this.f.remove(view);
        return this;
    }
    
    public void V(final View view) {
        if (this.J) {
            if (!this.K) {
                for (int i = this.H.size() - 1; i >= 0; --i) {
                    z0.a.c(this.H.get(i));
                }
                final ArrayList<f> l = this.L;
                if (l != null && l.size() > 0) {
                    final ArrayList list = (ArrayList)this.L.clone();
                    for (int size = list.size(), j = 0; j < size; ++j) {
                        ((f)list.get(j)).e(this);
                    }
                }
            }
            this.J = false;
        }
    }
    
    protected void Y() {
        this.g0();
        final a<Animator, d> a = A();
        for (final Animator animator : this.M) {
            if (a.containsKey(animator)) {
                this.g0();
                this.X(animator, a);
            }
        }
        this.M.clear();
        this.q();
    }
    
    public m Z(final long c) {
        this.c = c;
        return this;
    }
    
    public void a0(final e n) {
        this.N = n;
    }
    
    public m b(final f f) {
        if (this.L == null) {
            this.L = new ArrayList<f>();
        }
        this.L.add(f);
        return this;
    }
    
    public m b0(final TimeInterpolator d) {
        this.d = d;
        return this;
    }
    
    public m c(final View view) {
        this.f.add(view);
        return this;
    }
    
    public void c0(final g p) {
        if (p == null) {
            this.P = m.R;
        }
        else {
            this.P = p;
        }
    }
    
    protected void cancel() {
        for (int i = this.H.size() - 1; i >= 0; --i) {
            this.H.get(i).cancel();
        }
        final ArrayList<f> l = this.L;
        if (l != null && l.size() > 0) {
            final ArrayList list = (ArrayList)this.L.clone();
            for (int size = list.size(), j = 0; j < size; ++j) {
                ((f)list.get(j)).a(this);
            }
        }
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.n();
    }
    
    public void d0(final p p) {
    }
    
    protected void f(final Animator animator) {
        if (animator == null) {
            this.q();
        }
        else {
            if (this.r() >= 0L) {
                animator.setDuration(this.r());
            }
            if (this.B() >= 0L) {
                animator.setStartDelay(this.B() + animator.getStartDelay());
            }
            if (this.v() != null) {
                animator.setInterpolator(this.v());
            }
            animator.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this) {
                final m a;
                
                public void onAnimationEnd(final Animator animator) {
                    this.a.q();
                    animator.removeListener((Animator$AnimatorListener)this);
                }
            });
            animator.start();
        }
    }
    
    public m f0(final long b) {
        this.b = b;
        return this;
    }
    
    public abstract void g(final s p0);
    
    protected void g0() {
        if (this.I == 0) {
            final ArrayList<f> l = this.L;
            if (l != null && l.size() > 0) {
                final ArrayList list = (ArrayList)this.L.clone();
                for (int size = list.size(), i = 0; i < size; ++i) {
                    ((f)list.get(i)).b(this);
                }
            }
            this.K = false;
        }
        ++this.I;
    }
    
    String h0(String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(this.getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(this.hashCode()));
        sb.append(": ");
        final String s2 = s = sb.toString();
        if (this.c != -1L) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s2);
            sb2.append("dur(");
            sb2.append(this.c);
            sb2.append(") ");
            s = sb2.toString();
        }
        String string = s;
        if (this.b != -1L) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(s);
            sb3.append("dly(");
            sb3.append(this.b);
            sb3.append(") ");
            string = sb3.toString();
        }
        s = string;
        if (this.d != null) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(string);
            sb4.append("interp(");
            sb4.append(this.d);
            sb4.append(") ");
            s = sb4.toString();
        }
        if (this.e.size() <= 0) {
            final String string2 = s;
            if (this.f.size() <= 0) {
                return string2;
            }
        }
        final StringBuilder sb5 = new StringBuilder();
        sb5.append(s);
        sb5.append("tgts(");
        s = sb5.toString();
        final int size = this.e.size();
        final int n = 0;
        String string3 = s;
        if (size > 0) {
            int n2 = 0;
            while (true) {
                string3 = s;
                if (n2 >= this.e.size()) {
                    break;
                }
                String string4 = s;
                if (n2 > 0) {
                    final StringBuilder sb6 = new StringBuilder();
                    sb6.append(s);
                    sb6.append(", ");
                    string4 = sb6.toString();
                }
                final StringBuilder sb7 = new StringBuilder();
                sb7.append(string4);
                sb7.append(this.e.get(n2));
                s = sb7.toString();
                ++n2;
            }
        }
        s = string3;
        if (this.f.size() > 0) {
            int n3 = n;
            while (true) {
                s = string3;
                if (n3 >= this.f.size()) {
                    break;
                }
                s = string3;
                if (n3 > 0) {
                    final StringBuilder sb8 = new StringBuilder();
                    sb8.append(string3);
                    sb8.append(", ");
                    s = sb8.toString();
                }
                final StringBuilder sb9 = new StringBuilder();
                sb9.append(s);
                sb9.append(this.f.get(n3));
                string3 = sb9.toString();
                ++n3;
            }
        }
        final StringBuilder sb10 = new StringBuilder();
        sb10.append(s);
        sb10.append(")");
        return sb10.toString();
    }
    
    void i(final s s) {
    }
    
    public abstract void j(final s p0);
    
    void l(final ViewGroup viewGroup, final boolean b) {
        this.m(b);
        final int size = this.e.size();
        final int n = 0;
        Label_0302: {
            if (size > 0 || this.f.size() > 0) {
                final ArrayList<String> g = this.g;
                if (g == null || g.isEmpty()) {
                    final ArrayList<Class<?>> h = this.h;
                    if (h == null || h.isEmpty()) {
                        for (int i = 0; i < this.e.size(); ++i) {
                            final View viewById = viewGroup.findViewById((int)this.e.get(i));
                            if (viewById != null) {
                                final s s = new s(viewById);
                                if (b) {
                                    this.j(s);
                                }
                                else {
                                    this.g(s);
                                }
                                s.c.add(this);
                                this.i(s);
                                if (b) {
                                    e(this.A, viewById, s);
                                }
                                else {
                                    e(this.B, viewById, s);
                                }
                            }
                        }
                        for (int j = 0; j < this.f.size(); ++j) {
                            final View view = this.f.get(j);
                            final s s2 = new s(view);
                            if (b) {
                                this.j(s2);
                            }
                            else {
                                this.g(s2);
                            }
                            s2.c.add(this);
                            this.i(s2);
                            if (b) {
                                e(this.A, view, s2);
                            }
                            else {
                                e(this.B, view, s2);
                            }
                        }
                        break Label_0302;
                    }
                }
            }
            this.h((View)viewGroup, b);
        }
        if (!b) {
            final a<String, String> o = this.O;
            if (o != null) {
                final int size2 = o.size();
                final ArrayList list = new ArrayList<View>(size2);
                int n2 = 0;
                int k;
                while (true) {
                    k = n;
                    if (n2 >= size2) {
                        break;
                    }
                    list.add(this.A.d.remove(this.O.i(n2)));
                    ++n2;
                }
                while (k < size2) {
                    final View view2 = list.get(k);
                    if (view2 != null) {
                        this.A.d.put(this.O.m(k), view2);
                    }
                    ++k;
                }
            }
        }
    }
    
    void m(final boolean b) {
        if (b) {
            this.A.a.clear();
            this.A.b.clear();
            this.A.c.b();
        }
        else {
            this.B.a.clear();
            this.B.b.clear();
            this.B.c.b();
        }
    }
    
    public m n() {
        try {
            final m m = (m)super.clone();
            m.M = new ArrayList<Animator>();
            m.A = new t();
            m.B = new t();
            m.E = null;
            m.F = null;
            return m;
        }
        catch (final CloneNotSupportedException ex) {
            return null;
        }
    }
    
    public Animator o(final ViewGroup viewGroup, final s s, final s s2) {
        return null;
    }
    
    protected void p(final ViewGroup viewGroup, final t t, final t t2, final ArrayList<s> list, final ArrayList<s> list2) {
        final a<Animator, d> a = A();
        final SparseIntArray sparseIntArray = new SparseIntArray();
        for (int size = list.size(), i = 0; i < size; ++i) {
            final s s = list.get(i);
            final s s2 = list2.get(i);
            s s3;
            if ((s3 = s) != null) {
                s3 = s;
                if (!s.c.contains(this)) {
                    s3 = null;
                }
            }
            s s4;
            if ((s4 = s2) != null) {
                s4 = s2;
                if (!s2.c.contains(this)) {
                    s4 = null;
                }
            }
            if ((s3 != null || s4 != null) && (s3 == null || s4 == null || this.I(s3, s4))) {
                Animator o = this.o(viewGroup, s3, s4);
                if (o != null) {
                    int n = 0;
                    s s7 = null;
                    View b2;
                    if (s4 != null) {
                        final View b = s4.b;
                        final String[] g = this.G();
                        Label_0402: {
                            if (g != null && g.length > 0) {
                                final s s5 = new s(b);
                                final s s6 = t2.a.get(b);
                                Animator animator = o;
                                n = size;
                                if (s6 != null) {
                                    int n2 = 0;
                                    while (true) {
                                        animator = o;
                                        n = size;
                                        if (n2 >= g.length) {
                                            break;
                                        }
                                        s5.a.put(g[n2], s6.a.get(g[n2]));
                                        ++n2;
                                    }
                                }
                                for (int size2 = a.size(), j = 0; j < size2; ++j) {
                                    final d d = (d)a.get(a.i(j));
                                    if (d.c != null && d.a == b && d.b.equals(this.x()) && d.c.equals(s5)) {
                                        o = null;
                                        s7 = s5;
                                        break Label_0402;
                                    }
                                }
                                o = animator;
                                s7 = s5;
                            }
                            else {
                                s7 = null;
                                n = size;
                            }
                        }
                        b2 = b;
                    }
                    else {
                        b2 = s3.b;
                        s7 = null;
                        n = size;
                    }
                    size = n;
                    if (o != null) {
                        a.put((Object)o, (Object)new d(b2, this.x(), this, z0.z.d((View)viewGroup), s7));
                        this.M.add(o);
                        size = n;
                    }
                }
            }
        }
        if (sparseIntArray.size() != 0) {
            for (int k = 0; k < sparseIntArray.size(); ++k) {
                final Animator animator2 = this.M.get(sparseIntArray.keyAt(k));
                animator2.setStartDelay(sparseIntArray.valueAt(k) - Long.MAX_VALUE + animator2.getStartDelay());
            }
        }
    }
    
    protected void q() {
        final int i = this.I - 1;
        this.I = i;
        if (i == 0) {
            final ArrayList<f> l = this.L;
            if (l != null && l.size() > 0) {
                final ArrayList list = (ArrayList)this.L.clone();
                for (int size = list.size(), j = 0; j < size; ++j) {
                    ((f)list.get(j)).c(this);
                }
            }
            for (int k = 0; k < this.A.c.o(); ++k) {
                final View view = this.A.c.p(k);
                if (view != null) {
                    b0.z0(view, false);
                }
            }
            for (int n = 0; n < this.B.c.o(); ++n) {
                final View view2 = this.B.c.p(n);
                if (view2 != null) {
                    b0.z0(view2, false);
                }
            }
            this.K = true;
        }
    }
    
    public long r() {
        return this.c;
    }
    
    @Override
    public String toString() {
        return this.h0("");
    }
    
    public e u() {
        return this.N;
    }
    
    public TimeInterpolator v() {
        return this.d;
    }
    
    s w(final View view, final boolean b) {
        final q c = this.C;
        if (c != null) {
            return c.w(view, b);
        }
        ArrayList<s> list;
        if (b) {
            list = this.E;
        }
        else {
            list = this.F;
        }
        final s s = null;
        if (list == null) {
            return null;
        }
        final int size = list.size();
        final int n = -1;
        int n2 = 0;
        int n3;
        while (true) {
            n3 = n;
            if (n2 >= size) {
                break;
            }
            final s s2 = list.get(n2);
            if (s2 == null) {
                return null;
            }
            if (s2.b == view) {
                n3 = n2;
                break;
            }
            ++n2;
        }
        s s3 = s;
        if (n3 >= 0) {
            ArrayList<s> list2;
            if (b) {
                list2 = this.F;
            }
            else {
                list2 = this.E;
            }
            s3 = list2.get(n3);
        }
        return s3;
    }
    
    public String x() {
        return this.a;
    }
    
    public g y() {
        return this.P;
    }
    
    public p z() {
        return null;
    }
    
    private static class d
    {
        View a;
        String b;
        s c;
        i0 d;
        m e;
        
        d(final View a, final String b, final m e, final i0 d, final s c) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
    }
    
    public abstract static class e
    {
    }
    
    public interface f
    {
        void a(final m p0);
        
        void b(final m p0);
        
        void c(final m p0);
        
        void d(final m p0);
        
        void e(final m p0);
    }
}
