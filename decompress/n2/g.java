// 
// Decompiled by Procyon v0.6.0
// 

package n2;

import android.os.Message;
import android.graphics.drawable.Drawable;
import v2.l;
import java.nio.ByteBuffer;
import android.os.SystemClock;
import v2.k;
import c2.b;
import android.os.Handler$Callback;
import android.os.Looper;
import java.util.ArrayList;
import com.bumptech.glide.c;
import android.graphics.Bitmap;
import com.bumptech.glide.h;
import e2.d;
import com.bumptech.glide.i;
import java.util.List;
import android.os.Handler;
import b2.a;

class g
{
    private final b2.a a;
    private final Handler b;
    private final List<b> c;
    final i d;
    private final e2.d e;
    private boolean f;
    private boolean g;
    private boolean h;
    private h<Bitmap> i;
    private a j;
    private boolean k;
    private a l;
    private Bitmap m;
    private c2.h<Bitmap> n;
    private a o;
    private d p;
    private int q;
    private int r;
    private int s;
    
    g(final com.bumptech.glide.c c, final b2.a a, final int n, final int n2, final c2.h<Bitmap> h, final Bitmap bitmap) {
        this(c.f(), com.bumptech.glide.c.t(c.h()), a, null, j(com.bumptech.glide.c.t(c.h()), n, n2), h, bitmap);
    }
    
    g(final e2.d e, final i d, final b2.a a, final Handler handler, final h<Bitmap> i, final c2.h<Bitmap> h, final Bitmap bitmap) {
        this.c = new ArrayList<b>();
        this.d = d;
        Handler b = handler;
        if (handler == null) {
            b = new Handler(Looper.getMainLooper(), (Handler$Callback)new c());
        }
        this.e = e;
        this.b = b;
        this.i = i;
        this.a = a;
        this.p(h, bitmap);
    }
    
    private static c2.b g() {
        return new u2.d(Math.random());
    }
    
    private static h<Bitmap> j(final i i, final int n, final int n2) {
        return i.c().u0(((com.bumptech.glide.request.a<com.bumptech.glide.request.a<?>>)com.bumptech.glide.request.h.u0(com.bumptech.glide.load.engine.h.b).s0(true).m0(true)).a0(n, n2));
    }
    
    private void m() {
        if (this.f) {
            if (!this.g) {
                if (this.h) {
                    v2.k.a(this.o == null, "Pending target must be null when starting from the first frame");
                    this.a.h();
                    this.h = false;
                }
                final a o = this.o;
                if (o != null) {
                    this.o = null;
                    this.n(o);
                    return;
                }
                this.g = true;
                final int g = this.a.g();
                final long uptimeMillis = SystemClock.uptimeMillis();
                final long n = g;
                this.a.c();
                this.l = new a(this.b, this.a.i(), uptimeMillis + n);
                this.i.u0(com.bumptech.glide.request.h.v0(g())).M0(this.a).B0(this.l);
            }
        }
    }
    
    private void o() {
        final Bitmap m = this.m;
        if (m != null) {
            this.e.c(m);
            this.m = null;
        }
    }
    
    private void q() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        this.m();
    }
    
    private void r() {
        this.f = false;
    }
    
    void a() {
        this.c.clear();
        this.o();
        this.r();
        final a j = this.j;
        if (j != null) {
            this.d.g(j);
            this.j = null;
        }
        final a l = this.l;
        if (l != null) {
            this.d.g(l);
            this.l = null;
        }
        final a o = this.o;
        if (o != null) {
            this.d.g(o);
            this.o = null;
        }
        this.a.clear();
        this.k = true;
    }
    
    ByteBuffer b() {
        return this.a.a().asReadOnlyBuffer();
    }
    
    Bitmap c() {
        final a j = this.j;
        Bitmap bitmap;
        if (j != null) {
            bitmap = j.a();
        }
        else {
            bitmap = this.m;
        }
        return bitmap;
    }
    
    int d() {
        final a j = this.j;
        int b;
        if (j != null) {
            b = j.b;
        }
        else {
            b = -1;
        }
        return b;
    }
    
    Bitmap e() {
        return this.m;
    }
    
    int f() {
        return this.a.d();
    }
    
    int h() {
        return this.s;
    }
    
    int i() {
        return this.a.f();
    }
    
    int k() {
        return this.a.j() + this.q;
    }
    
    int l() {
        return this.r;
    }
    
    void n(final a a) {
        final d p = this.p;
        if (p != null) {
            p.a();
        }
        this.g = false;
        if (this.k) {
            this.b.obtainMessage(2, (Object)a).sendToTarget();
            return;
        }
        if (!this.f) {
            if (this.h) {
                this.b.obtainMessage(2, (Object)a).sendToTarget();
            }
            else {
                this.o = a;
            }
            return;
        }
        if (a.a() != null) {
            this.o();
            final a j = this.j;
            this.j = a;
            for (int i = this.c.size() - 1; i >= 0; --i) {
                this.c.get(i).a();
            }
            if (j != null) {
                this.b.obtainMessage(2, (Object)j).sendToTarget();
            }
        }
        this.m();
    }
    
    void p(final c2.h<Bitmap> h, final Bitmap bitmap) {
        this.n = v2.k.d(h);
        this.m = v2.k.d(bitmap);
        this.i = this.i.u0(((com.bumptech.glide.request.a<com.bumptech.glide.request.a<?>>)new com.bumptech.glide.request.h()).n0(h));
        this.q = v2.l.h(bitmap);
        this.r = bitmap.getWidth();
        this.s = bitmap.getHeight();
    }
    
    void s(final b b) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (!this.c.contains(b)) {
            final boolean empty = this.c.isEmpty();
            this.c.add(b);
            if (empty) {
                this.q();
            }
            return;
        }
        throw new IllegalStateException("Cannot subscribe twice in a row");
    }
    
    void t(final b b) {
        this.c.remove(b);
        if (this.c.isEmpty()) {
            this.r();
        }
    }
    
    static class a extends s2.c<Bitmap>
    {
        private final Handler a;
        final int b;
        private final long c;
        private Bitmap d;
        
        a(final Handler a, final int b, final long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        Bitmap a() {
            return this.d;
        }
        
        @Override
        public void onLoadCleared(final Drawable drawable) {
            this.d = null;
        }
        
        @Override
        public void onResourceReady(final Bitmap d, final t2.d<? super Bitmap> d2) {
            this.d = d;
            this.a.sendMessageAtTime(this.a.obtainMessage(1, (Object)this), this.c);
        }
        
        @Override
        public /* bridge */ void onResourceReady(final Object o, final t2.d d) {
            this.onResourceReady((Bitmap)o, d);
        }
    }
    
    public interface b
    {
        void a();
    }
    
    private class c implements Handler$Callback
    {
        final g a;
        
        c(final g a) {
            this.a = a;
        }
        
        public boolean handleMessage(final Message message) {
            final int what = message.what;
            if (what == 1) {
                this.a.n((a)message.obj);
                return true;
            }
            if (what == 2) {
                this.a.d.g((s2.i<?>)message.obj);
            }
            return false;
        }
    }
    
    interface d
    {
        void a();
    }
}
