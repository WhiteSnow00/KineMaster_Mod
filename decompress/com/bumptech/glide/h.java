// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide;

import java.util.Collection;
import java.util.ArrayList;
import com.bumptech.glide.request.f;
import com.bumptech.glide.request.d;
import java.io.File;
import android.net.Uri;
import android.graphics.Bitmap;
import android.widget.ImageView;
import v2.l;
import com.bumptech.glide.request.b;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.RequestCoordinator;
import v2.k;
import java.util.concurrent.Executor;
import java.util.Iterator;
import com.bumptech.glide.request.g;
import java.util.List;
import android.content.Context;
import com.bumptech.glide.request.a;

public class h<TranscodeType> extends a<h<TranscodeType>>
{
    protected static final com.bumptech.glide.request.h Z;
    private final Context L;
    private final i M;
    private final Class<TranscodeType> N;
    private final c O;
    private final e P;
    private j<?, ? super TranscodeType> Q;
    private Object R;
    private List<g<TranscodeType>> S;
    private h<TranscodeType> T;
    private h<TranscodeType> U;
    private Float V;
    private boolean W;
    private boolean X;
    private boolean Y;
    
    static {
        Z = new com.bumptech.glide.request.h().h(com.bumptech.glide.load.engine.h.c).d0(Priority.LOW).m0(true);
    }
    
    protected h(final c o, final i m, final Class<TranscodeType> n, final Context l) {
        this.W = true;
        this.O = o;
        this.M = m;
        this.N = n;
        this.L = l;
        this.Q = m.j(n);
        this.P = o.i();
        this.A0(m.h());
        this.u0(m.i());
    }
    
    private void A0(final List<g<Object>> list) {
        final Iterator<g<Object>> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.t0((g<TranscodeType>)iterator.next());
        }
    }
    
    private <Y extends s2.i<TranscodeType>> Y C0(final Y y, final g<TranscodeType> g, final a<?> a, final Executor executor) {
        k.d(y);
        if (!this.X) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        final com.bumptech.glide.request.e v0 = this.v0(y, g, a, executor);
        final com.bumptech.glide.request.e request = y.getRequest();
        if (v0.h(request) && !this.F0(a, request)) {
            if (!k.d(request).isRunning()) {
                request.i();
            }
            return y;
        }
        this.M.g(y);
        y.setRequest(v0);
        this.M.w(y, v0);
        return y;
    }
    
    private boolean F0(final a<?> a, final com.bumptech.glide.request.e e) {
        return !a.J() && e.g();
    }
    
    private h<TranscodeType> O0(final Object r) {
        if (this.I()) {
            return this.y0().O0(r);
        }
        this.R = r;
        this.X = true;
        return this.i0();
    }
    
    private com.bumptech.glide.request.e P0(final Object o, final s2.i<TranscodeType> i, final g<TranscodeType> g, final a<?> a, final RequestCoordinator requestCoordinator, final j<?, ? super TranscodeType> j, final Priority priority, final int n, final int n2, final Executor executor) {
        final Context l = this.L;
        final e p10 = this.P;
        return SingleRequest.y(l, p10, o, this.R, this.N, a, n, n2, priority, i, g, this.S, requestCoordinator, p10.f(), j.c(), executor);
    }
    
    private com.bumptech.glide.request.e v0(final s2.i<TranscodeType> i, final g<TranscodeType> g, final a<?> a, final Executor executor) {
        return this.w0(new Object(), i, g, null, this.Q, a.A(), a.x(), a.w(), a, executor);
    }
    
    private com.bumptech.glide.request.e w0(final Object o, final s2.i<TranscodeType> i, final g<TranscodeType> g, final RequestCoordinator requestCoordinator, final j<?, ? super TranscodeType> j, final Priority priority, final int n, final int n2, final a<?> a, final Executor executor) {
        b b;
        RequestCoordinator requestCoordinator2;
        if (this.U != null) {
            requestCoordinator2 = (b = new b(o, requestCoordinator));
        }
        else {
            final b b2 = null;
            requestCoordinator2 = requestCoordinator;
            b = b2;
        }
        final com.bumptech.glide.request.e x0 = this.x0(o, i, g, requestCoordinator2, j, priority, n, n2, a, executor);
        if (b == null) {
            return x0;
        }
        final int x2 = this.U.x();
        final int w = this.U.w();
        int x3 = x2;
        int w2 = w;
        if (l.u(n, n2)) {
            x3 = x2;
            w2 = w;
            if (!this.U.S()) {
                x3 = a.x();
                w2 = a.w();
            }
        }
        final h<TranscodeType> u = this.U;
        b.o(x0, u.w0(o, i, g, b, u.Q, u.A(), x3, w2, this.U, executor));
        return b;
    }
    
    private com.bumptech.glide.request.e x0(final Object o, final s2.i<TranscodeType> i, final g<TranscodeType> g, final RequestCoordinator requestCoordinator, final j<?, ? super TranscodeType> j, final Priority priority, final int n, final int n2, final a<?> a, final Executor executor) {
        final h<TranscodeType> t = this.T;
        if (t != null) {
            if (!this.Y) {
                j<?, ? super TranscodeType> q = t.Q;
                if (t.W) {
                    q = j;
                }
                Priority priority2;
                if (t.K()) {
                    priority2 = this.T.A();
                }
                else {
                    priority2 = this.z0(priority);
                }
                final int x = this.T.x();
                final int w = this.T.w();
                int x2 = x;
                int w2 = w;
                if (l.u(n, n2)) {
                    x2 = x;
                    w2 = w;
                    if (!this.T.S()) {
                        x2 = a.x();
                        w2 = a.w();
                    }
                }
                final com.bumptech.glide.request.j k = new com.bumptech.glide.request.j(o, requestCoordinator);
                final com.bumptech.glide.request.e p10 = this.P0(o, i, g, a, k, j, priority, n, n2, executor);
                this.Y = true;
                final h<TranscodeType> t2 = this.T;
                final com.bumptech.glide.request.e w3 = t2.w0(o, i, g, k, q, priority2, x2, w2, t2, executor);
                this.Y = false;
                k.n(p10, w3);
                return k;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        else {
            if (this.V != null) {
                final com.bumptech.glide.request.j l = new com.bumptech.glide.request.j(o, requestCoordinator);
                l.n(this.P0(o, i, g, a, l, j, priority, n, n2, executor), this.P0(o, i, g, a.f().l0(this.V), l, j, this.z0(priority), n, n2, executor));
                return l;
            }
            return this.P0(o, i, g, a, requestCoordinator, j, priority, n, n2, executor);
        }
    }
    
    private Priority z0(final Priority priority) {
        final int n = h$a.b[priority.ordinal()];
        if (n == 1) {
            return Priority.NORMAL;
        }
        if (n == 2) {
            return Priority.HIGH;
        }
        if (n != 3 && n != 4) {
            final StringBuilder sb = new StringBuilder();
            sb.append("unknown priority: ");
            sb.append(this.A());
            throw new IllegalArgumentException(sb.toString());
        }
        return Priority.IMMEDIATE;
    }
    
    public <Y extends s2.i<TranscodeType>> Y B0(final Y y) {
        return this.D0(y, null, v2.e.b());
    }
    
     <Y extends s2.i<TranscodeType>> Y D0(final Y y, final g<TranscodeType> g, final Executor executor) {
        return this.C0(y, g, this, executor);
    }
    
    public s2.j<ImageView, TranscodeType> E0(final ImageView imageView) {
        l.b();
        k.d(imageView);
        if (!this.R() && this.P() && imageView.getScaleType() != null) {
            switch (h$a.a[imageView.getScaleType().ordinal()]) {
                case 6: {
                    final a<TranscodeType> a = this.f().V();
                    return this.C0(this.P.a(imageView, this.N), null, a, v2.e.b());
                }
                case 3:
                case 4:
                case 5: {
                    final a<TranscodeType> a = this.f().X();
                    return this.C0(this.P.a(imageView, this.N), null, a, v2.e.b());
                }
                case 2: {
                    final a<TranscodeType> a = this.f().V();
                    return this.C0(this.P.a(imageView, this.N), null, a, v2.e.b());
                }
                case 1: {
                    final a<TranscodeType> a = this.f().U();
                    return this.C0(this.P.a(imageView, this.N), null, a, v2.e.b());
                }
            }
        }
        final a<TranscodeType> a = (a<TranscodeType>)this;
        return this.C0(this.P.a(imageView, this.N), null, a, v2.e.b());
    }
    
    public h<TranscodeType> G0(final g<TranscodeType> g) {
        if (this.I()) {
            return this.y0().G0(g);
        }
        this.S = null;
        return this.t0(g);
    }
    
    public h<TranscodeType> H0(final Bitmap bitmap) {
        return this.O0(bitmap).u0(com.bumptech.glide.request.h.u0(com.bumptech.glide.load.engine.h.b));
    }
    
    public h<TranscodeType> I0(final Uri uri) {
        return this.O0(uri);
    }
    
    public h<TranscodeType> J0(final File file) {
        return this.O0(file);
    }
    
    public h<TranscodeType> K0(final Integer n) {
        return this.O0(n).u0(com.bumptech.glide.request.h.v0(u2.a.c(this.L)));
    }
    
    public h<TranscodeType> M0(final Object o) {
        return this.O0(o);
    }
    
    public h<TranscodeType> N0(final String s) {
        return this.O0(s);
    }
    
    public d<TranscodeType> Q0() {
        return this.R0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    
    public d<TranscodeType> R0(final int n, final int n2) {
        final f f = new f(n, n2);
        return this.D0(f, f, v2.e.a());
    }
    
    public h<TranscodeType> S0(final j<?, ? super TranscodeType> j) {
        if (this.I()) {
            return this.y0().S0(j);
        }
        this.Q = k.d(j);
        this.W = false;
        return this.i0();
    }
    
    @Override
    public /* bridge */ a b(final a a) {
        return this.u0(a);
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.y0();
    }
    
    @Override
    public /* bridge */ a f() {
        return this.y0();
    }
    
    public h<TranscodeType> t0(final g<TranscodeType> g) {
        if (this.I()) {
            return this.y0().t0(g);
        }
        if (g != null) {
            if (this.S == null) {
                this.S = new ArrayList<g<TranscodeType>>();
            }
            this.S.add(g);
        }
        return this.i0();
    }
    
    public h<TranscodeType> u0(final a<?> a) {
        k.d(a);
        return super.b(a);
    }
    
    public h<TranscodeType> y0() {
        final h h = super.f();
        h.Q = (j<?, ? super TranscodeType>)h.Q.b();
        if (h.S != null) {
            h.S = new ArrayList<g<TranscodeType>>(h.S);
        }
        final h<TranscodeType> t = h.T;
        if (t != null) {
            h.T = t.y0();
        }
        final h<TranscodeType> u = h.U;
        if (u != null) {
            h.U = u.y0();
        }
        return h;
    }
}
