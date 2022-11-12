// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import java.util.ArrayList;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.content.Context;

public abstract class b implements m
{
    protected Context a;
    protected Context b;
    protected g c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    private a f;
    private int g;
    private int h;
    protected n i;
    private int j;
    
    public b(final Context a, final int g, final int h) {
        this.a = a;
        this.d = LayoutInflater.from(a);
        this.g = g;
        this.h = h;
    }
    
    protected void a(final View view, final int n) {
        final ViewGroup viewGroup = (ViewGroup)view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup)this.i).addView(view, n);
    }
    
    @Override
    public void b(final g g, final boolean b) {
        final a f = this.f;
        if (f != null) {
            f.b(g, b);
        }
    }
    
    @Override
    public boolean c(final g g, final i i) {
        return false;
    }
    
    @Override
    public void d(final a f) {
        this.f = f;
    }
    
    @Override
    public boolean f(r c) {
        final a f = this.f;
        if (f != null) {
            if (c == null) {
                c = (r)this.c;
            }
            return f.c(c);
        }
        return false;
    }
    
    @Override
    public int getId() {
        return this.j;
    }
    
    @Override
    public void h(final boolean b) {
        final ViewGroup viewGroup = (ViewGroup)this.i;
        if (viewGroup == null) {
            return;
        }
        final g c = this.c;
        int i = 0;
        if (c != null) {
            c.t();
            final ArrayList<i> g = this.c.G();
            final int size = g.size();
            int j = 0;
            i = 0;
            while (j < size) {
                final i k = g.get(j);
                int n = i;
                if (this.s(i, k)) {
                    final View child = viewGroup.getChildAt(i);
                    i itemData;
                    if (child instanceof n.a) {
                        itemData = ((n.a)child).getItemData();
                    }
                    else {
                        itemData = null;
                    }
                    final View p = this.p(k, child, viewGroup);
                    if (k != itemData) {
                        p.setPressed(false);
                        p.jumpDrawablesToCurrentState();
                    }
                    if (p != child) {
                        this.a(p, i);
                    }
                    n = i + 1;
                }
                ++j;
                i = n;
            }
        }
        while (i < viewGroup.getChildCount()) {
            if (!this.n(viewGroup, i)) {
                ++i;
            }
        }
    }
    
    @Override
    public boolean j(final g g, final i i) {
        return false;
    }
    
    @Override
    public void k(final Context b, final g c) {
        this.b = b;
        this.e = LayoutInflater.from(b);
        this.c = c;
    }
    
    public abstract void l(final i p0, final n.a p1);
    
    public n.a m(final ViewGroup viewGroup) {
        return (n.a)this.d.inflate(this.h, viewGroup, false);
    }
    
    protected boolean n(final ViewGroup viewGroup, final int n) {
        viewGroup.removeViewAt(n);
        return true;
    }
    
    public a o() {
        return this.f;
    }
    
    public View p(final i i, final View view, final ViewGroup viewGroup) {
        n.a m;
        if (view instanceof n.a) {
            m = (n.a)view;
        }
        else {
            m = this.m(viewGroup);
        }
        this.l(i, m);
        return (View)m;
    }
    
    public n q(final ViewGroup viewGroup) {
        if (this.i == null) {
            (this.i = (n)this.d.inflate(this.g, viewGroup, false)).a(this.c);
            this.h(true);
        }
        return this.i;
    }
    
    public void r(final int j) {
        this.j = j;
    }
    
    public abstract boolean s(final int p0, final i p1);
}
