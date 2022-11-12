// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import androidx.core.view.b0;
import java.util.Iterator;
import java.util.Collection;
import android.animation.ValueAnimator;
import java.util.List;
import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
import android.animation.TimeInterpolator;

public class h extends w
{
    private static TimeInterpolator s;
    private ArrayList<c0> h;
    private ArrayList<c0> i;
    private ArrayList<j> j;
    private ArrayList<i> k;
    ArrayList<ArrayList<c0>> l;
    ArrayList<ArrayList<j>> m;
    ArrayList<ArrayList<i>> n;
    ArrayList<c0> o;
    ArrayList<c0> p;
    ArrayList<c0> q;
    ArrayList<c0> r;
    
    public h() {
        this.h = new ArrayList<c0>();
        this.i = new ArrayList<c0>();
        this.j = new ArrayList<j>();
        this.k = new ArrayList<i>();
        this.l = new ArrayList<ArrayList<c0>>();
        this.m = new ArrayList<ArrayList<j>>();
        this.n = new ArrayList<ArrayList<i>>();
        this.o = new ArrayList<c0>();
        this.p = new ArrayList<c0>();
        this.q = new ArrayList<c0>();
        this.r = new ArrayList<c0>();
    }
    
    private void U(final c0 c0) {
        final View itemView = c0.itemView;
        final ViewPropertyAnimator animate = itemView.animate();
        this.q.add(c0);
        animate.setDuration(((RecyclerView.l)this).o()).alpha(0.0f).setListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, c0, animate, itemView) {
            final c0 a;
            final ViewPropertyAnimator b;
            final View c;
            final h d;
            
            public void onAnimationEnd(final Animator animator) {
                this.b.setListener((Animator$AnimatorListener)null);
                this.c.setAlpha(1.0f);
                this.d.G(this.a);
                this.d.q.remove(this.a);
                this.d.W();
            }
            
            public void onAnimationStart(final Animator animator) {
                this.d.H(this.a);
            }
        }).start();
    }
    
    private void X(final List<i> list, final c0 c0) {
        for (int i = list.size() - 1; i >= 0; --i) {
            final i j = list.get(i);
            if (this.Z(j, c0) && j.a == null && j.b == null) {
                list.remove(j);
            }
        }
    }
    
    private void Y(final i i) {
        final c0 a = i.a;
        if (a != null) {
            this.Z(i, a);
        }
        final c0 b = i.b;
        if (b != null) {
            this.Z(i, b);
        }
    }
    
    private boolean Z(final i i, final c0 c0) {
        final c0 b = i.b;
        boolean b2 = false;
        if (b == c0) {
            i.b = null;
        }
        else {
            if (i.a != c0) {
                return false;
            }
            i.a = null;
            b2 = true;
        }
        c0.itemView.setAlpha(1.0f);
        c0.itemView.setTranslationX(0.0f);
        c0.itemView.setTranslationY(0.0f);
        this.C(c0, b2);
        return true;
    }
    
    private void a0(final c0 c0) {
        if (androidx.recyclerview.widget.h.s == null) {
            androidx.recyclerview.widget.h.s = new ValueAnimator().getInterpolator();
        }
        c0.itemView.animate().setInterpolator(androidx.recyclerview.widget.h.s);
        this.j(c0);
    }
    
    void R(final c0 c0) {
        final View itemView = c0.itemView;
        final ViewPropertyAnimator animate = itemView.animate();
        this.o.add(c0);
        animate.alpha(1.0f).setDuration(((RecyclerView.l)this).l()).setListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, c0, itemView, animate) {
            final c0 a;
            final View b;
            final ViewPropertyAnimator c;
            final h d;
            
            public void onAnimationCancel(final Animator animator) {
                this.b.setAlpha(1.0f);
            }
            
            public void onAnimationEnd(final Animator animator) {
                this.c.setListener((Animator$AnimatorListener)null);
                this.d.A(this.a);
                this.d.o.remove(this.a);
                this.d.W();
            }
            
            public void onAnimationStart(final Animator animator) {
                this.d.B(this.a);
            }
        }).start();
    }
    
    void S(final i i) {
        final c0 a = i.a;
        View itemView = null;
        View itemView2;
        if (a == null) {
            itemView2 = null;
        }
        else {
            itemView2 = a.itemView;
        }
        final c0 b = i.b;
        if (b != null) {
            itemView = b.itemView;
        }
        if (itemView2 != null) {
            final ViewPropertyAnimator setDuration = itemView2.animate().setDuration(((RecyclerView.l)this).m());
            this.r.add(i.a);
            setDuration.translationX((float)(i.e - i.c));
            setDuration.translationY((float)(i.f - i.d));
            setDuration.alpha(0.0f).setListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, i, setDuration, itemView2) {
                final i a;
                final ViewPropertyAnimator b;
                final View c;
                final h d;
                
                public void onAnimationEnd(final Animator animator) {
                    this.b.setListener((Animator$AnimatorListener)null);
                    this.c.setAlpha(1.0f);
                    this.c.setTranslationX(0.0f);
                    this.c.setTranslationY(0.0f);
                    this.d.C(this.a.a, true);
                    this.d.r.remove(this.a.a);
                    this.d.W();
                }
                
                public void onAnimationStart(final Animator animator) {
                    this.d.D(this.a.a, true);
                }
            }).start();
        }
        if (itemView != null) {
            final ViewPropertyAnimator animate = itemView.animate();
            this.r.add(i.b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(((RecyclerView.l)this).m()).alpha(1.0f).setListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, i, animate, itemView) {
                final i a;
                final ViewPropertyAnimator b;
                final View c;
                final h d;
                
                public void onAnimationEnd(final Animator animator) {
                    this.b.setListener((Animator$AnimatorListener)null);
                    this.c.setAlpha(1.0f);
                    this.c.setTranslationX(0.0f);
                    this.c.setTranslationY(0.0f);
                    this.d.C(this.a.b, false);
                    this.d.r.remove(this.a.b);
                    this.d.W();
                }
                
                public void onAnimationStart(final Animator animator) {
                    this.d.D(this.a.b, false);
                }
            }).start();
        }
    }
    
    void T(final c0 c0, int n, int n2, final int n3, final int n4) {
        final View itemView = c0.itemView;
        n = n3 - n;
        n2 = n4 - n2;
        if (n != 0) {
            itemView.animate().translationX(0.0f);
        }
        if (n2 != 0) {
            itemView.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = itemView.animate();
        this.p.add(c0);
        animate.setDuration(((RecyclerView.l)this).n()).setListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, c0, n, itemView, n2, animate) {
            final c0 a;
            final int b;
            final View c;
            final int d;
            final ViewPropertyAnimator e;
            final h f;
            
            public void onAnimationCancel(final Animator animator) {
                if (this.b != 0) {
                    this.c.setTranslationX(0.0f);
                }
                if (this.d != 0) {
                    this.c.setTranslationY(0.0f);
                }
            }
            
            public void onAnimationEnd(final Animator animator) {
                this.e.setListener((Animator$AnimatorListener)null);
                this.f.E(this.a);
                this.f.p.remove(this.a);
                this.f.W();
            }
            
            public void onAnimationStart(final Animator animator) {
                this.f.F(this.a);
            }
        }).start();
    }
    
    void V(final List<c0> list) {
        for (int i = list.size() - 1; i >= 0; --i) {
            ((c0)list.get(i)).itemView.animate().cancel();
        }
    }
    
    void W() {
        if (!this.p()) {
            ((RecyclerView.l)this).i();
        }
    }
    
    @Override
    public boolean g(final c0 c0, final List<Object> list) {
        return !list.isEmpty() || super.g(c0, list);
    }
    
    @Override
    public void j(final c0 c0) {
        final View itemView = c0.itemView;
        itemView.animate().cancel();
        for (int i = this.j.size() - 1; i >= 0; --i) {
            if (this.j.get(i).a == c0) {
                itemView.setTranslationY(0.0f);
                itemView.setTranslationX(0.0f);
                this.E(c0);
                this.j.remove(i);
            }
        }
        this.X(this.k, c0);
        if (this.h.remove(c0)) {
            itemView.setAlpha(1.0f);
            this.G(c0);
        }
        if (this.i.remove(c0)) {
            itemView.setAlpha(1.0f);
            this.A(c0);
        }
        for (int j = this.n.size() - 1; j >= 0; --j) {
            final ArrayList list = this.n.get(j);
            this.X(list, c0);
            if (list.isEmpty()) {
                this.n.remove(j);
            }
        }
        for (int k = this.m.size() - 1; k >= 0; --k) {
            final ArrayList list2 = this.m.get(k);
            int l = list2.size() - 1;
            while (l >= 0) {
                if (((j)list2.get(l)).a == c0) {
                    itemView.setTranslationY(0.0f);
                    itemView.setTranslationX(0.0f);
                    this.E(c0);
                    list2.remove(l);
                    if (list2.isEmpty()) {
                        this.m.remove(k);
                        break;
                    }
                    break;
                }
                else {
                    --l;
                }
            }
        }
        for (int n = this.l.size() - 1; n >= 0; --n) {
            final ArrayList list3 = this.l.get(n);
            if (list3.remove(c0)) {
                itemView.setAlpha(1.0f);
                this.A(c0);
                if (list3.isEmpty()) {
                    this.l.remove(n);
                }
            }
        }
        this.q.remove(c0);
        this.o.remove(c0);
        this.r.remove(c0);
        this.p.remove(c0);
        this.W();
    }
    
    @Override
    public void k() {
        for (int i = this.j.size() - 1; i >= 0; --i) {
            final j j = this.j.get(i);
            final View itemView = j.a.itemView;
            itemView.setTranslationY(0.0f);
            itemView.setTranslationX(0.0f);
            this.E(j.a);
            this.j.remove(i);
        }
        for (int k = this.h.size() - 1; k >= 0; --k) {
            this.G(this.h.get(k));
            this.h.remove(k);
        }
        for (int l = this.i.size() - 1; l >= 0; --l) {
            final c0 c0 = this.i.get(l);
            c0.itemView.setAlpha(1.0f);
            this.A(c0);
            this.i.remove(l);
        }
        for (int n = this.k.size() - 1; n >= 0; --n) {
            this.Y(this.k.get(n));
        }
        this.k.clear();
        if (!this.p()) {
            return;
        }
        for (int n2 = this.m.size() - 1; n2 >= 0; --n2) {
            final ArrayList list = this.m.get(n2);
            for (int n3 = list.size() - 1; n3 >= 0; --n3) {
                final j m = (j)list.get(n3);
                final View itemView2 = m.a.itemView;
                itemView2.setTranslationY(0.0f);
                itemView2.setTranslationX(0.0f);
                this.E(m.a);
                list.remove(n3);
                if (list.isEmpty()) {
                    this.m.remove(list);
                }
            }
        }
        for (int n4 = this.l.size() - 1; n4 >= 0; --n4) {
            final ArrayList list2 = this.l.get(n4);
            for (int n5 = list2.size() - 1; n5 >= 0; --n5) {
                final c0 c2 = (c0)list2.get(n5);
                c2.itemView.setAlpha(1.0f);
                this.A(c2);
                list2.remove(n5);
                if (list2.isEmpty()) {
                    this.l.remove(list2);
                }
            }
        }
        for (int n6 = this.n.size() - 1; n6 >= 0; --n6) {
            final ArrayList list3 = this.n.get(n6);
            for (int n7 = list3.size() - 1; n7 >= 0; --n7) {
                this.Y((i)list3.get(n7));
                if (list3.isEmpty()) {
                    this.n.remove(list3);
                }
            }
        }
        this.V(this.q);
        this.V(this.p);
        this.V(this.o);
        this.V(this.r);
        ((RecyclerView.l)this).i();
    }
    
    @Override
    public boolean p() {
        return !this.i.isEmpty() || !this.k.isEmpty() || !this.j.isEmpty() || !this.h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.n.isEmpty();
    }
    
    @Override
    public void u() {
        final boolean b = this.h.isEmpty() ^ true;
        final boolean b2 = this.j.isEmpty() ^ true;
        final boolean b3 = this.k.isEmpty() ^ true;
        final boolean b4 = this.i.isEmpty() ^ true;
        if (!b && !b2 && !b4 && !b3) {
            return;
        }
        final Iterator<c0> iterator = this.h.iterator();
        while (iterator.hasNext()) {
            this.U(iterator.next());
        }
        this.h.clear();
        if (b2) {
            final ArrayList list = new ArrayList();
            list.addAll(this.j);
            this.m.add(list);
            this.j.clear();
            final Runnable runnable = new Runnable(this, list) {
                final ArrayList a;
                final h b;
                
                @Override
                public void run() {
                    for (final j j : this.a) {
                        this.b.T(j.a, j.b, j.c, j.d, j.e);
                    }
                    this.a.clear();
                    this.b.m.remove(this.a);
                }
            };
            if (b) {
                androidx.core.view.b0.i0(list.get(0).a.itemView, runnable, ((RecyclerView.l)this).o());
            }
            else {
                runnable.run();
            }
        }
        if (b3) {
            final ArrayList list2 = new ArrayList();
            list2.addAll(this.k);
            this.n.add(list2);
            this.k.clear();
            final Runnable runnable2 = new Runnable(this, list2) {
                final ArrayList a;
                final h b;
                
                @Override
                public void run() {
                    final Iterator iterator = this.a.iterator();
                    while (iterator.hasNext()) {
                        this.b.S((i)iterator.next());
                    }
                    this.a.clear();
                    this.b.n.remove(this.a);
                }
            };
            if (b) {
                androidx.core.view.b0.i0(((i)list2.get(0)).a.itemView, runnable2, ((RecyclerView.l)this).o());
            }
            else {
                runnable2.run();
            }
        }
        if (b4) {
            final ArrayList list3 = new ArrayList();
            list3.addAll(this.i);
            this.l.add(list3);
            this.i.clear();
            final Runnable runnable3 = new Runnable(this, list3) {
                final ArrayList a;
                final h b;
                
                @Override
                public void run() {
                    final Iterator iterator = this.a.iterator();
                    while (iterator.hasNext()) {
                        this.b.R((c0)iterator.next());
                    }
                    this.a.clear();
                    this.b.l.remove(this.a);
                }
            };
            if (!b && !b2 && !b3) {
                runnable3.run();
            }
            else {
                long m = 0L;
                long o;
                if (b) {
                    o = ((RecyclerView.l)this).o();
                }
                else {
                    o = 0L;
                }
                long n;
                if (b2) {
                    n = ((RecyclerView.l)this).n();
                }
                else {
                    n = 0L;
                }
                if (b3) {
                    m = ((RecyclerView.l)this).m();
                }
                androidx.core.view.b0.i0(((c0)list3.get(0)).itemView, runnable3, o + Math.max(n, m));
            }
        }
    }
    
    @Override
    public boolean w(final c0 c0) {
        this.a0(c0);
        c0.itemView.setAlpha(0.0f);
        this.i.add(c0);
        return true;
    }
    
    @Override
    public boolean x(final c0 c0, final c0 c2, final int n, final int n2, final int n3, final int n4) {
        if (c0 == c2) {
            return this.y(c0, n, n2, n3, n4);
        }
        final float translationX = c0.itemView.getTranslationX();
        final float translationY = c0.itemView.getTranslationY();
        final float alpha = c0.itemView.getAlpha();
        this.a0(c0);
        final int n5 = (int)(n3 - n - translationX);
        final int n6 = (int)(n4 - n2 - translationY);
        c0.itemView.setTranslationX(translationX);
        c0.itemView.setTranslationY(translationY);
        c0.itemView.setAlpha(alpha);
        if (c2 != null) {
            this.a0(c2);
            c2.itemView.setTranslationX((float)(-n5));
            c2.itemView.setTranslationY((float)(-n6));
            c2.itemView.setAlpha(0.0f);
        }
        this.k.add(new i(c0, c2, n, n2, n3, n4));
        return true;
    }
    
    @Override
    public boolean y(final c0 c0, int n, int n2, final int n3, final int n4) {
        final View itemView = c0.itemView;
        n += (int)itemView.getTranslationX();
        final int n5 = n2 + (int)c0.itemView.getTranslationY();
        this.a0(c0);
        n2 = n3 - n;
        final int n6 = n4 - n5;
        if (n2 == 0 && n6 == 0) {
            this.E(c0);
            return false;
        }
        if (n2 != 0) {
            itemView.setTranslationX((float)(-n2));
        }
        if (n6 != 0) {
            itemView.setTranslationY((float)(-n6));
        }
        this.j.add(new j(c0, n, n5, n3, n4));
        return true;
    }
    
    @Override
    public boolean z(final c0 c0) {
        this.a0(c0);
        this.h.add(c0);
        return true;
    }
    
    private static class i
    {
        public c0 a;
        public c0 b;
        public int c;
        public int d;
        public int e;
        public int f;
        
        private i(final c0 a, final c0 b) {
            this.a = a;
            this.b = b;
        }
        
        i(final c0 c0, final c0 c2, final int c3, final int d, final int e, final int f) {
            this(c0, c2);
            this.c = c3;
            this.d = d;
            this.e = e;
            this.f = f;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("ChangeInfo{oldHolder=");
            sb.append(this.a);
            sb.append(", newHolder=");
            sb.append(this.b);
            sb.append(", fromX=");
            sb.append(this.c);
            sb.append(", fromY=");
            sb.append(this.d);
            sb.append(", toX=");
            sb.append(this.e);
            sb.append(", toY=");
            sb.append(this.f);
            sb.append('}');
            return sb.toString();
        }
    }
    
    private static class j
    {
        public c0 a;
        public int b;
        public int c;
        public int d;
        public int e;
        
        j(final c0 a, final int b, final int c, final int d, final int e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
    }
}
