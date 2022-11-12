// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.util.AndroidRuntimeException;
import android.view.ViewGroup;
import android.animation.TimeInterpolator;
import android.view.View;
import java.util.Iterator;
import java.util.ArrayList;

public class q extends m
{
    private ArrayList<m> T;
    private boolean U;
    int V;
    boolean W;
    private int X;
    
    public q() {
        this.T = new ArrayList<m>();
        this.U = true;
        this.W = false;
        this.X = 0;
    }
    
    private void l0(final m m) {
        this.T.add(m);
        m.C = this;
    }
    
    private void u0() {
        final b b = new b(this);
        final Iterator<m> iterator = this.T.iterator();
        while (iterator.hasNext()) {
            iterator.next().b((f)b);
        }
        this.V = this.T.size();
    }
    
    @Override
    public void R(final View view) {
        super.R(view);
        for (int size = this.T.size(), i = 0; i < size; ++i) {
            this.T.get(i).R(view);
        }
    }
    
    @Override
    public /* bridge */ m T(final f f) {
        return this.o0(f);
    }
    
    @Override
    public /* bridge */ m U(final View view) {
        return this.p0(view);
    }
    
    @Override
    public void V(final View view) {
        super.V(view);
        for (int size = this.T.size(), i = 0; i < size; ++i) {
            this.T.get(i).V(view);
        }
    }
    
    @Override
    protected void Y() {
        if (this.T.isEmpty()) {
            this.g0();
            this.q();
            return;
        }
        this.u0();
        if (!this.U) {
            for (int i = 1; i < this.T.size(); ++i) {
                this.T.get(i - 1).b((f)new n(this, this.T.get(i)) {
                    final m a;
                    final q b;
                    
                    @Override
                    public void c(final m m) {
                        this.a.Y();
                        m.T((f)this);
                    }
                });
            }
            final m m = this.T.get(0);
            if (m != null) {
                m.Y();
            }
        }
        else {
            final Iterator<m> iterator = this.T.iterator();
            while (iterator.hasNext()) {
                iterator.next().Y();
            }
        }
    }
    
    @Override
    public /* bridge */ m Z(final long n) {
        return this.q0(n);
    }
    
    @Override
    public void a0(final e e) {
        super.a0(e);
        this.X |= 0x8;
        for (int size = this.T.size(), i = 0; i < size; ++i) {
            this.T.get(i).a0(e);
        }
    }
    
    @Override
    public /* bridge */ m b(final f f) {
        return this.i0(f);
    }
    
    @Override
    public /* bridge */ m b0(final TimeInterpolator timeInterpolator) {
        return this.r0(timeInterpolator);
    }
    
    @Override
    public /* bridge */ m c(final View view) {
        return this.j0(view);
    }
    
    @Override
    public void c0(final g g) {
        super.c0(g);
        this.X |= 0x4;
        if (this.T != null) {
            for (int i = 0; i < this.T.size(); ++i) {
                this.T.get(i).c0(g);
            }
        }
    }
    
    @Override
    protected void cancel() {
        super.cancel();
        for (int size = this.T.size(), i = 0; i < size; ++i) {
            this.T.get(i).cancel();
        }
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.n();
    }
    
    @Override
    public void d0(final p p) {
        super.d0(p);
        this.X |= 0x2;
        for (int size = this.T.size(), i = 0; i < size; ++i) {
            this.T.get(i).d0(p);
        }
    }
    
    @Override
    public /* bridge */ m f0(final long n) {
        return this.t0(n);
    }
    
    @Override
    public void g(final s s) {
        if (this.J(s.b)) {
            for (final m m : this.T) {
                if (m.J(s.b)) {
                    m.g(s);
                    s.c.add(m);
                }
            }
        }
    }
    
    @Override
    String h0(final String s) {
        String s2 = super.h0(s);
        for (int i = 0; i < this.T.size(); ++i) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s2);
            sb.append("\n");
            final m m = this.T.get(i);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append("  ");
            sb.append(m.h0(sb2.toString()));
            s2 = sb.toString();
        }
        return s2;
    }
    
    @Override
    void i(final s s) {
        super.i(s);
        for (int size = this.T.size(), i = 0; i < size; ++i) {
            this.T.get(i).i(s);
        }
    }
    
    public q i0(final f f) {
        return (q)super.b(f);
    }
    
    @Override
    public void j(final s s) {
        if (this.J(s.b)) {
            for (final m m : this.T) {
                if (m.J(s.b)) {
                    m.j(s);
                    s.c.add(m);
                }
            }
        }
    }
    
    public q j0(final View view) {
        for (int i = 0; i < this.T.size(); ++i) {
            this.T.get(i).c(view);
        }
        return (q)super.c(view);
    }
    
    public q k0(final m m) {
        this.l0(m);
        final long c = super.c;
        if (c >= 0L) {
            m.Z(c);
        }
        if ((this.X & 0x1) != 0x0) {
            m.b0(this.v());
        }
        if ((this.X & 0x2) != 0x0) {
            this.z();
            m.d0(null);
        }
        if ((this.X & 0x4) != 0x0) {
            m.c0(this.y());
        }
        if ((this.X & 0x8) != 0x0) {
            m.a0(this.u());
        }
        return this;
    }
    
    public m m0(final int n) {
        if (n >= 0 && n < this.T.size()) {
            return this.T.get(n);
        }
        return null;
    }
    
    @Override
    public m n() {
        final q q = (q)super.n();
        q.T = new ArrayList<m>();
        for (int size = this.T.size(), i = 0; i < size; ++i) {
            q.l0(this.T.get(i).n());
        }
        return q;
    }
    
    public int n0() {
        return this.T.size();
    }
    
    public q o0(final f f) {
        return (q)super.T(f);
    }
    
    @Override
    protected void p(final ViewGroup viewGroup, final t t, final t t2, final ArrayList<s> list, final ArrayList<s> list2) {
        final long b = this.B();
        for (int size = this.T.size(), i = 0; i < size; ++i) {
            final m m = this.T.get(i);
            if (b > 0L && (this.U || i == 0)) {
                final long b2 = m.B();
                if (b2 > 0L) {
                    m.f0(b2 + b);
                }
                else {
                    m.f0(b);
                }
            }
            m.p(viewGroup, t, t2, list, list2);
        }
    }
    
    public q p0(final View view) {
        for (int i = 0; i < this.T.size(); ++i) {
            this.T.get(i).U(view);
        }
        return (q)super.U(view);
    }
    
    public q q0(final long n) {
        super.Z(n);
        if (super.c >= 0L) {
            final ArrayList<m> t = this.T;
            if (t != null) {
                for (int size = t.size(), i = 0; i < size; ++i) {
                    this.T.get(i).Z(n);
                }
            }
        }
        return this;
    }
    
    public q r0(final TimeInterpolator timeInterpolator) {
        this.X |= 0x1;
        final ArrayList<m> t = this.T;
        if (t != null) {
            for (int size = t.size(), i = 0; i < size; ++i) {
                this.T.get(i).b0(timeInterpolator);
            }
        }
        return (q)super.b0(timeInterpolator);
    }
    
    public q s0(final int n) {
        if (n != 0) {
            if (n != 1) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid parameter for TransitionSet ordering: ");
                sb.append(n);
                throw new AndroidRuntimeException(sb.toString());
            }
            this.U = false;
        }
        else {
            this.U = true;
        }
        return this;
    }
    
    public q t0(final long n) {
        return (q)super.f0(n);
    }
    
    static class b extends n
    {
        q a;
        
        b(final q a) {
            this.a = a;
        }
        
        @Override
        public void b(final m m) {
            final q a = this.a;
            if (!a.W) {
                a.g0();
                this.a.W = true;
            }
        }
        
        @Override
        public void c(final m m) {
            final q a = this.a;
            final int v = a.V - 1;
            a.V = v;
            if (v == 0) {
                a.W = false;
                a.q();
            }
            m.T((f)this);
        }
    }
}
