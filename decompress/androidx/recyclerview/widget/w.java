// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.View;

public abstract class w extends l
{
    boolean g;
    
    public w() {
        this.g = true;
    }
    
    public final void A(final c0 c0) {
        this.I(c0);
        ((RecyclerView.l)this).h(c0);
    }
    
    public final void B(final c0 c0) {
        this.J(c0);
    }
    
    public final void C(final c0 c0, final boolean b) {
        this.K(c0, b);
        ((RecyclerView.l)this).h(c0);
    }
    
    public final void D(final c0 c0, final boolean b) {
        this.L(c0, b);
    }
    
    public final void E(final c0 c0) {
        this.M(c0);
        ((RecyclerView.l)this).h(c0);
    }
    
    public final void F(final c0 c0) {
        this.N(c0);
    }
    
    public final void G(final c0 c0) {
        this.O(c0);
        ((RecyclerView.l)this).h(c0);
    }
    
    public final void H(final c0 c0) {
        this.P(c0);
    }
    
    public void I(final c0 c0) {
    }
    
    public void J(final c0 c0) {
    }
    
    public void K(final c0 c0, final boolean b) {
    }
    
    public void L(final c0 c0, final boolean b) {
    }
    
    public void M(final c0 c0) {
    }
    
    public void N(final c0 c0) {
    }
    
    public void O(final c0 c0) {
    }
    
    public void P(final c0 c0) {
    }
    
    public void Q(final boolean g) {
        this.g = g;
    }
    
    @Override
    public boolean a(final c0 c0, final c c2, final c c3) {
        if (c2 != null) {
            final int a = c2.a;
            final int a2 = c3.a;
            if (a != a2 || c2.b != c3.b) {
                return this.y(c0, a, c2.b, a2, c3.b);
            }
        }
        return this.w(c0);
    }
    
    @Override
    public boolean b(final c0 c0, final c0 c2, final c c3, final c c4) {
        final int a = c3.a;
        final int b = c3.b;
        int n;
        int n2;
        if (c2.shouldIgnore()) {
            n = c3.a;
            n2 = c3.b;
        }
        else {
            n = c4.a;
            n2 = c4.b;
        }
        return this.x(c0, c2, a, b, n, n2);
    }
    
    @Override
    public boolean c(final c0 c0, final c c2, final c c3) {
        final int a = c2.a;
        final int b = c2.b;
        final View itemView = c0.itemView;
        int n;
        if (c3 == null) {
            n = itemView.getLeft();
        }
        else {
            n = c3.a;
        }
        int n2;
        if (c3 == null) {
            n2 = itemView.getTop();
        }
        else {
            n2 = c3.b;
        }
        if (!c0.isRemoved() && (a != n || b != n2)) {
            itemView.layout(n, n2, itemView.getWidth() + n, itemView.getHeight() + n2);
            return this.y(c0, a, b, n, n2);
        }
        return this.z(c0);
    }
    
    @Override
    public boolean d(final c0 c0, final c c2, final c c3) {
        final int a = c2.a;
        final int a2 = c3.a;
        if (a == a2 && c2.b == c3.b) {
            this.E(c0);
            return false;
        }
        return this.y(c0, a, c2.b, a2, c3.b);
    }
    
    @Override
    public boolean f(final c0 c0) {
        return !this.g || c0.isInvalid();
    }
    
    public abstract boolean w(final c0 p0);
    
    public abstract boolean x(final c0 p0, final c0 p1, final int p2, final int p3, final int p4, final int p5);
    
    public abstract boolean y(final c0 p0, final int p1, final int p2, final int p3, final int p4);
    
    public abstract boolean z(final c0 p0);
}
