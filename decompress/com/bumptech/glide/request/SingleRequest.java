// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.request;

import v2.l;
import java.io.Serializable;
import com.bumptech.glide.load.engine.GlideException;
import android.content.res.Resources$Theme;
import java.util.Iterator;
import w2.b;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.d;
import android.util.Log;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.s;
import java.util.concurrent.Executor;
import java.util.List;
import com.bumptech.glide.Priority;
import android.content.Context;
import w2.c;
import s2.h;

public final class SingleRequest<R> implements e, h, i
{
    private static final boolean E;
    private int A;
    private int B;
    private boolean C;
    private RuntimeException D;
    private int a;
    private final String b;
    private final c c;
    private final Object d;
    private final g<R> e;
    private final RequestCoordinator f;
    private final Context g;
    private final com.bumptech.glide.e h;
    private final Object i;
    private final Class<R> j;
    private final a<?> k;
    private final int l;
    private final int m;
    private final Priority n;
    private final s2.i<R> o;
    private final List<g<R>> p;
    private final t2.e<? super R> q;
    private final Executor r;
    private s<R> s;
    private com.bumptech.glide.load.engine.i.d t;
    private long u;
    private volatile com.bumptech.glide.load.engine.i v;
    private Status w;
    private Drawable x;
    private Drawable y;
    private Drawable z;
    
    static {
        E = Log.isLoggable("GlideRequest", 2);
    }
    
    private SingleRequest(final Context g, final com.bumptech.glide.e h, final Object d, final Object i, final Class<R> j, final a<?> k, final int l, final int m, final Priority n, final s2.i<R> o, final g<R> e, final List<g<R>> p16, final RequestCoordinator f, final com.bumptech.glide.load.engine.i v, final t2.e<? super R> q, final Executor r) {
        String value;
        if (SingleRequest.E) {
            value = String.valueOf(super.hashCode());
        }
        else {
            value = null;
        }
        this.b = value;
        this.c = w2.c.a();
        this.d = d;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = o;
        this.e = e;
        this.p = p16;
        this.f = f;
        this.v = v;
        this.q = q;
        this.r = r;
        this.w = Status.PENDING;
        if (this.D == null && h.g().a((Class<Object>)d.d.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }
    
    private void A(final s<R> s, final R r, final DataSource dataSource, final boolean b) {
        final boolean s2 = this.s();
        this.w = Status.COMPLETE;
        this.s = s;
        if (this.h.h() <= 3) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Finished loading ");
            sb.append(r.getClass().getSimpleName());
            sb.append(" from ");
            sb.append(dataSource);
            sb.append(" for ");
            sb.append(this.i);
            sb.append(" with size [");
            sb.append(this.A);
            sb.append("x");
            sb.append(this.B);
            sb.append("] in ");
            sb.append(v2.g.a(this.u));
            sb.append(" ms");
            Log.d("Glide", sb.toString());
        }
        final int n = 1;
        this.C = true;
        try {
            final List<g<R>> p4 = this.p;
            int n3;
            if (p4 != null) {
                final Iterator<g<R>> iterator = p4.iterator();
                int n2 = 0;
                while (true) {
                    n3 = n2;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    n2 |= (iterator.next().onResourceReady(r, this.i, this.o, dataSource, s2) ? 1 : 0);
                }
            }
            else {
                n3 = 0;
            }
            final g<R> e = this.e;
            int n4;
            if (e != null && e.onResourceReady(r, this.i, this.o, dataSource, s2)) {
                n4 = n;
            }
            else {
                n4 = 0;
            }
            if ((n4 | n3) == 0x0) {
                this.o.onResourceReady(r, this.q.a(dataSource, s2));
            }
            this.C = false;
            this.x();
            b.f("GlideRequest", this.a);
        }
        finally {
            this.C = false;
        }
    }
    
    private void B() {
        if (!this.l()) {
            return;
        }
        Drawable q = null;
        if (this.i == null) {
            q = this.q();
        }
        Drawable p;
        if ((p = q) == null) {
            p = this.p();
        }
        Drawable r;
        if ((r = p) == null) {
            r = this.r();
        }
        this.o.onLoadFailed(r);
    }
    
    private void j() {
        if (!this.C) {
            return;
        }
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }
    
    private boolean k() {
        final RequestCoordinator f = this.f;
        return f == null || f.j(this);
    }
    
    private boolean l() {
        final RequestCoordinator f = this.f;
        return f == null || f.b(this);
    }
    
    private boolean m() {
        final RequestCoordinator f = this.f;
        return f == null || f.c(this);
    }
    
    private void n() {
        this.j();
        this.c.c();
        this.o.removeCallback(this);
        final com.bumptech.glide.load.engine.i.d t = this.t;
        if (t != null) {
            t.a();
            this.t = null;
        }
    }
    
    private void o(final Object o) {
        final List<g<R>> p = this.p;
        if (p == null) {
            return;
        }
        for (final g g : p) {
            if (g instanceof com.bumptech.glide.request.c) {
                ((com.bumptech.glide.request.c)g).a(o);
            }
        }
    }
    
    private Drawable p() {
        if (this.x == null && (this.x = this.k.p()) == null && this.k.o() > 0) {
            this.x = this.t(this.k.o());
        }
        return this.x;
    }
    
    private Drawable q() {
        if (this.z == null && (this.z = this.k.q()) == null && this.k.r() > 0) {
            this.z = this.t(this.k.r());
        }
        return this.z;
    }
    
    private Drawable r() {
        if (this.y == null && (this.y = this.k.y()) == null && this.k.z() > 0) {
            this.y = this.t(this.k.z());
        }
        return this.y;
    }
    
    private boolean s() {
        final RequestCoordinator f = this.f;
        return f == null || !f.getRoot().a();
    }
    
    private Drawable t(final int n) {
        Resources$Theme resources$Theme;
        if (this.k.E() != null) {
            resources$Theme = this.k.E();
        }
        else {
            resources$Theme = this.g.getTheme();
        }
        return l2.b.a((Context)this.h, n, resources$Theme);
    }
    
    private void u(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(" this: ");
        sb.append(this.b);
        Log.v("GlideRequest", sb.toString());
    }
    
    private static int v(int round, final float n) {
        if (round != Integer.MIN_VALUE) {
            round = Math.round(n * round);
        }
        return round;
    }
    
    private void w() {
        final RequestCoordinator f = this.f;
        if (f != null) {
            f.d(this);
        }
    }
    
    private void x() {
        final RequestCoordinator f = this.f;
        if (f != null) {
            f.f(this);
        }
    }
    
    public static <R> SingleRequest<R> y(final Context context, final com.bumptech.glide.e e, final Object o, final Object o2, final Class<R> clazz, final a<?> a, final int n, final int n2, final Priority priority, final s2.i<R> i, final g<R> g, final List<g<R>> list, final RequestCoordinator requestCoordinator, final com.bumptech.glide.load.engine.i j, final t2.e<? super R> e2, final Executor executor) {
        return new SingleRequest<R>(context, e, o, o2, clazz, a, n, n2, priority, i, g, list, requestCoordinator, j, e2, executor);
    }
    
    private void z(final GlideException ex, int n) {
        this.c.c();
        synchronized (this.d) {
            ex.setOrigin(this.D);
            final int h = this.h.h();
            if (h <= n) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Load failed for ");
                sb.append(this.i);
                sb.append(" with size [");
                sb.append(this.A);
                sb.append("x");
                sb.append(this.B);
                sb.append("]");
                Log.w("Glide", sb.toString(), (Throwable)ex);
                if (h <= 4) {
                    ex.logRootCauses("Glide");
                }
            }
            this.t = null;
            this.w = Status.FAILED;
            final int n2 = 1;
            this.C = true;
            try {
                final List<g<R>> p2 = this.p;
                int n3;
                if (p2 != null) {
                    final Iterator<g<R>> iterator = p2.iterator();
                    n = 0;
                    while (true) {
                        n3 = n;
                        if (!iterator.hasNext()) {
                            break;
                        }
                        n |= (iterator.next().onLoadFailed(ex, this.i, this.o, this.s()) ? 1 : 0);
                    }
                }
                else {
                    n3 = 0;
                }
                final g<R> e = this.e;
                if (e != null && e.onLoadFailed(ex, this.i, this.o, this.s())) {
                    n = n2;
                }
                else {
                    n = 0;
                }
                if ((n3 | n) == 0x0) {
                    this.B();
                }
                this.C = false;
                this.w();
                w2.b.f("GlideRequest", this.a);
            }
            finally {
                this.C = false;
            }
        }
    }
    
    @Override
    public boolean a() {
        synchronized (this.d) {
            return this.w == Status.COMPLETE;
        }
    }
    
    @Override
    public void b(final s<?> s, final DataSource dataSource, final boolean b) {
        this.c.c();
        final s<?> s2 = null;
        final s<?> s3 = null;
        Object o = s2;
        try {
            final Object d = this.d;
            o = s2;
            monitorenter(d);
            o = s3;
            GlideException ex2 = null;
            try {
                this.t = null;
                if (s == null) {
                    o = s3;
                    o = s3;
                    o = s3;
                    final StringBuilder sb = new StringBuilder();
                    o = s3;
                    sb.append("Expected to receive a Resource<R> with an object of ");
                    o = s3;
                    sb.append(this.j);
                    o = s3;
                    sb.append(" inside, but instead got null.");
                    o = s3;
                    final GlideException ex = new GlideException(sb.toString());
                    o = s3;
                    this.c(ex);
                    o = s3;
                    monitorexit(d);
                    return;
                }
                o = s3;
                final R value = s.get();
                Label_0241: {
                    if (value == null) {
                        break Label_0241;
                    }
                    o = s3;
                    if (!this.j.isAssignableFrom(value.getClass())) {
                        break Label_0241;
                    }
                    o = s3;
                    Label_0220: {
                        if (this.m()) {
                            break Label_0220;
                        }
                        try {
                            this.s = null;
                            this.w = Status.COMPLETE;
                            b.f("GlideRequest", this.a);
                            monitorexit(d);
                            this.v.k(s);
                            return;
                            String s4 = null;
                            StringBuilder sb2 = null;
                        Label_0372:
                            while (true) {
                                Serializable class1 = null;
                            Label_0307:
                                while (true) {
                                    class1 = value.getClass();
                                    break Label_0307;
                                    Label_0303: {
                                        class1 = "";
                                    }
                                    break Label_0307;
                                    s4 = "";
                                    break Label_0372;
                                    this.s = null;
                                    o = new(com.bumptech.glide.load.engine.GlideException.class)();
                                    sb2 = new StringBuilder();
                                    sb2.append("Expected to receive an object of ");
                                    sb2.append(this.j);
                                    sb2.append(" but instead got ");
                                    iftrue(Label_0303:)(value == null);
                                    continue;
                                }
                                sb2.append(class1);
                                sb2.append("{");
                                sb2.append(value);
                                sb2.append("} inside Resource{");
                                sb2.append(s);
                                sb2.append("}.");
                                iftrue(Label_0368:)(value == null);
                                continue;
                            }
                            sb2.append(s4);
                            new GlideException(sb2.toString());
                            this.c((GlideException)o);
                            monitorexit(d);
                            this.v.k(s);
                            return;
                            o = s3;
                            this.A((s<R>)s, value, dataSource, b);
                            o = s3;
                            monitorexit(d);
                            return;
                            Label_0368: {
                                s4 = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                            }
                        }
                        finally {}
                    }
                }
            }
            finally {
                ex2 = (GlideException)o;
            }
            o = ex2;
            monitorexit(d);
            o = ex2;
        }
        finally {
            if (o != null) {
                this.v.k((s<?>)o);
            }
        }
    }
    
    @Override
    public void c(final GlideException ex) {
        this.z(ex, 5);
    }
    
    @Override
    public void clear() {
        synchronized (this.d) {
            this.j();
            this.c.c();
            final Status w = this.w;
            final Status cleared = Status.CLEARED;
            if (w == cleared) {
                return;
            }
            this.n();
            s<R> s = this.s;
            if (s != null) {
                this.s = null;
            }
            else {
                s = null;
            }
            if (this.k()) {
                this.o.onLoadCleared(this.r());
            }
            w2.b.f("GlideRequest", this.a);
            this.w = cleared;
            monitorexit(this.d);
            if (s != null) {
                this.v.k(s);
            }
        }
    }
    
    @Override
    public void d(final int p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/bumptech/glide/request/SingleRequest.c:Lw2/c;
        //     4: invokevirtual   w2/c.c:()V
        //     7: aload_0        
        //     8: getfield        com/bumptech/glide/request/SingleRequest.d:Ljava/lang/Object;
        //    11: astore          11
        //    13: aload           11
        //    15: monitorenter   
        //    16: getstatic       com/bumptech/glide/request/SingleRequest.E:Z
        //    19: istore          6
        //    21: iload           6
        //    23: ifeq            67
        //    26: new             Ljava/lang/StringBuilder;
        //    29: astore          12
        //    31: aload           12
        //    33: invokespecial   java/lang/StringBuilder.<init>:()V
        //    36: aload           12
        //    38: ldc_w           "Got onSizeReady in "
        //    41: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    44: pop            
        //    45: aload           12
        //    47: aload_0        
        //    48: getfield        com/bumptech/glide/request/SingleRequest.u:J
        //    51: invokestatic    v2/g.a:(J)D
        //    54: invokevirtual   java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        //    57: pop            
        //    58: aload_0        
        //    59: aload           12
        //    61: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    64: invokespecial   com/bumptech/glide/request/SingleRequest.u:(Ljava/lang/String;)V
        //    67: aload_0        
        //    68: getfield        com/bumptech/glide/request/SingleRequest.w:Lcom/bumptech/glide/request/SingleRequest$Status;
        //    71: getstatic       com/bumptech/glide/request/SingleRequest$Status.WAITING_FOR_SIZE:Lcom/bumptech/glide/request/SingleRequest$Status;
        //    74: if_acmpeq       81
        //    77: aload           11
        //    79: monitorexit    
        //    80: return         
        //    81: getstatic       com/bumptech/glide/request/SingleRequest$Status.RUNNING:Lcom/bumptech/glide/request/SingleRequest$Status;
        //    84: astore          12
        //    86: aload_0        
        //    87: aload           12
        //    89: putfield        com/bumptech/glide/request/SingleRequest.w:Lcom/bumptech/glide/request/SingleRequest$Status;
        //    92: aload_0        
        //    93: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //    96: invokevirtual   com/bumptech/glide/request/a.D:()F
        //    99: fstore_3       
        //   100: aload_0        
        //   101: iload_1        
        //   102: fload_3        
        //   103: invokestatic    com/bumptech/glide/request/SingleRequest.v:(IF)I
        //   106: putfield        com/bumptech/glide/request/SingleRequest.A:I
        //   109: aload_0        
        //   110: iload_2        
        //   111: fload_3        
        //   112: invokestatic    com/bumptech/glide/request/SingleRequest.v:(IF)I
        //   115: putfield        com/bumptech/glide/request/SingleRequest.B:I
        //   118: iload           6
        //   120: ifeq            164
        //   123: new             Ljava/lang/StringBuilder;
        //   126: astore          13
        //   128: aload           13
        //   130: invokespecial   java/lang/StringBuilder.<init>:()V
        //   133: aload           13
        //   135: ldc_w           "finished setup for calling load in "
        //   138: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   141: pop            
        //   142: aload           13
        //   144: aload_0        
        //   145: getfield        com/bumptech/glide/request/SingleRequest.u:J
        //   148: invokestatic    v2/g.a:(J)D
        //   151: invokevirtual   java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        //   154: pop            
        //   155: aload_0        
        //   156: aload           13
        //   158: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   161: invokespecial   com/bumptech/glide/request/SingleRequest.u:(Ljava/lang/String;)V
        //   164: aload_0        
        //   165: getfield        com/bumptech/glide/request/SingleRequest.v:Lcom/bumptech/glide/load/engine/i;
        //   168: astore          19
        //   170: aload_0        
        //   171: getfield        com/bumptech/glide/request/SingleRequest.h:Lcom/bumptech/glide/e;
        //   174: astore          13
        //   176: aload_0        
        //   177: getfield        com/bumptech/glide/request/SingleRequest.i:Ljava/lang/Object;
        //   180: astore          22
        //   182: aload_0        
        //   183: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //   186: invokevirtual   com/bumptech/glide/request/a.C:()Lc2/b;
        //   189: astore          16
        //   191: aload_0        
        //   192: getfield        com/bumptech/glide/request/SingleRequest.A:I
        //   195: istore_2       
        //   196: aload_0        
        //   197: getfield        com/bumptech/glide/request/SingleRequest.B:I
        //   200: istore_1       
        //   201: aload_0        
        //   202: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //   205: invokevirtual   com/bumptech/glide/request/a.B:()Ljava/lang/Class;
        //   208: astore          14
        //   210: aload_0        
        //   211: getfield        com/bumptech/glide/request/SingleRequest.j:Ljava/lang/Class;
        //   214: astore          20
        //   216: aload_0        
        //   217: getfield        com/bumptech/glide/request/SingleRequest.n:Lcom/bumptech/glide/Priority;
        //   220: astore          18
        //   222: aload_0        
        //   223: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //   226: invokevirtual   com/bumptech/glide/request/a.n:()Lcom/bumptech/glide/load/engine/h;
        //   229: astore          21
        //   231: aload_0        
        //   232: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //   235: invokevirtual   com/bumptech/glide/request/a.F:()Ljava/util/Map;
        //   238: astore          23
        //   240: aload_0        
        //   241: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //   244: invokevirtual   com/bumptech/glide/request/a.Q:()Z
        //   247: istore          8
        //   249: aload_0        
        //   250: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //   253: invokevirtual   com/bumptech/glide/request/a.L:()Z
        //   256: istore          10
        //   258: aload_0        
        //   259: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //   262: invokevirtual   com/bumptech/glide/request/a.v:()Lc2/e;
        //   265: astore          17
        //   267: aload_0        
        //   268: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //   271: invokevirtual   com/bumptech/glide/request/a.J:()Z
        //   274: istore          7
        //   276: aload_0        
        //   277: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //   280: invokevirtual   com/bumptech/glide/request/a.H:()Z
        //   283: istore          9
        //   285: aload_0        
        //   286: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //   289: invokevirtual   com/bumptech/glide/request/a.G:()Z
        //   292: istore          4
        //   294: aload_0        
        //   295: getfield        com/bumptech/glide/request/SingleRequest.k:Lcom/bumptech/glide/request/a;
        //   298: invokevirtual   com/bumptech/glide/request/a.u:()Z
        //   301: istore          5
        //   303: aload_0        
        //   304: getfield        com/bumptech/glide/request/SingleRequest.r:Ljava/util/concurrent/Executor;
        //   307: astore          15
        //   309: aload           19
        //   311: aload           13
        //   313: aload           22
        //   315: aload           16
        //   317: iload_2        
        //   318: iload_1        
        //   319: aload           14
        //   321: aload           20
        //   323: aload           18
        //   325: aload           21
        //   327: aload           23
        //   329: iload           8
        //   331: iload           10
        //   333: aload           17
        //   335: iload           7
        //   337: iload           9
        //   339: iload           4
        //   341: iload           5
        //   343: aload_0        
        //   344: aload           15
        //   346: invokevirtual   com/bumptech/glide/load/engine/i.f:(Lcom/bumptech/glide/e;Ljava/lang/Object;Lc2/b;IILjava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/Priority;Lcom/bumptech/glide/load/engine/h;Ljava/util/Map;ZZLc2/e;ZZZZLcom/bumptech/glide/request/i;Ljava/util/concurrent/Executor;)Lcom/bumptech/glide/load/engine/i$d;
        //   349: astore          14
        //   351: aload           11
        //   353: astore          13
        //   355: aload_0        
        //   356: aload           14
        //   358: putfield        com/bumptech/glide/request/SingleRequest.t:Lcom/bumptech/glide/load/engine/i$d;
        //   361: aload           11
        //   363: astore          13
        //   365: aload_0        
        //   366: getfield        com/bumptech/glide/request/SingleRequest.w:Lcom/bumptech/glide/request/SingleRequest$Status;
        //   369: aload           12
        //   371: if_acmpeq       383
        //   374: aload           11
        //   376: astore          13
        //   378: aload_0        
        //   379: aconst_null    
        //   380: putfield        com/bumptech/glide/request/SingleRequest.t:Lcom/bumptech/glide/load/engine/i$d;
        //   383: iload           6
        //   385: ifeq            449
        //   388: aload           11
        //   390: astore          13
        //   392: new             Ljava/lang/StringBuilder;
        //   395: astore          12
        //   397: aload           11
        //   399: astore          13
        //   401: aload           12
        //   403: invokespecial   java/lang/StringBuilder.<init>:()V
        //   406: aload           11
        //   408: astore          13
        //   410: aload           12
        //   412: ldc_w           "finished onSizeReady in "
        //   415: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   418: pop            
        //   419: aload           11
        //   421: astore          13
        //   423: aload           12
        //   425: aload_0        
        //   426: getfield        com/bumptech/glide/request/SingleRequest.u:J
        //   429: invokestatic    v2/g.a:(J)D
        //   432: invokevirtual   java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        //   435: pop            
        //   436: aload           11
        //   438: astore          13
        //   440: aload_0        
        //   441: aload           12
        //   443: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   446: invokespecial   com/bumptech/glide/request/SingleRequest.u:(Ljava/lang/String;)V
        //   449: aload           11
        //   451: astore          13
        //   453: aload           11
        //   455: monitorexit    
        //   456: return         
        //   457: astore          12
        //   459: goto            464
        //   462: astore          12
        //   464: aload           11
        //   466: astore          13
        //   468: aload           11
        //   470: monitorexit    
        //   471: aload           12
        //   473: athrow         
        //   474: astore          12
        //   476: aload           13
        //   478: astore          11
        //   480: goto            464
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  16     21     462    464    Any
        //  26     67     462    464    Any
        //  67     80     462    464    Any
        //  81     118    462    464    Any
        //  123    164    462    464    Any
        //  164    309    462    464    Any
        //  309    351    457    462    Any
        //  355    361    474    483    Any
        //  365    374    474    483    Any
        //  378    383    474    483    Any
        //  392    397    474    483    Any
        //  401    406    474    483    Any
        //  410    419    474    483    Any
        //  423    436    474    483    Any
        //  440    449    474    483    Any
        //  453    456    474    483    Any
        //  468    471    474    483    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0383:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public boolean e() {
        synchronized (this.d) {
            return this.w == Status.CLEARED;
        }
    }
    
    @Override
    public Object f() {
        this.c.c();
        return this.d;
    }
    
    @Override
    public boolean g() {
        synchronized (this.d) {
            return this.w == Status.COMPLETE;
        }
    }
    
    @Override
    public boolean h(final e e) {
        if (!(e instanceof SingleRequest)) {
            return false;
        }
        Object o = this.d;
        synchronized (o) {
            final int l = this.l;
            final int m = this.m;
            final Object i = this.i;
            final Class<R> j = this.j;
            final a<?> k = this.k;
            final Priority n = this.n;
            final List<g<R>> p = this.p;
            int size;
            if (p != null) {
                size = p.size();
            }
            else {
                size = 0;
            }
            monitorexit(o);
            final SingleRequest singleRequest = (SingleRequest)e;
            synchronized (singleRequest.d) {
                final int l2 = singleRequest.l;
                final int m2 = singleRequest.m;
                final Object i2 = singleRequest.i;
                final Class<R> j2 = singleRequest.j;
                o = singleRequest.k;
                final Priority n2 = singleRequest.n;
                final List<g<R>> p2 = singleRequest.p;
                int size2;
                if (p2 != null) {
                    size2 = p2.size();
                }
                else {
                    size2 = 0;
                }
                monitorexit(singleRequest.d);
                return l == l2 && m == m2 && v2.l.c(i, i2) && j.equals(j2) && k.equals(o) && n == n2 && size == size2;
            }
        }
    }
    
    @Override
    public void i() {
        synchronized (this.d) {
            this.j();
            this.c.c();
            this.u = v2.g.b();
            final Object i = this.i;
            if (i == null) {
                if (v2.l.u(this.l, this.m)) {
                    this.A = this.l;
                    this.B = this.m;
                }
                int n;
                if (this.q() == null) {
                    n = 5;
                }
                else {
                    n = 3;
                }
                this.z(new GlideException("Received null model"), n);
                return;
            }
            final Status w = this.w;
            final Status running = Status.RUNNING;
            if (w == running) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (w == Status.COMPLETE) {
                this.b(this.s, DataSource.MEMORY_CACHE, false);
                return;
            }
            this.o(i);
            this.a = w2.b.b("GlideRequest");
            final Status waiting_FOR_SIZE = Status.WAITING_FOR_SIZE;
            this.w = waiting_FOR_SIZE;
            if (v2.l.u(this.l, this.m)) {
                this.d(this.l, this.m);
            }
            else {
                this.o.getSize(this);
            }
            final Status w2 = this.w;
            if ((w2 == running || w2 == waiting_FOR_SIZE) && this.l()) {
                this.o.onLoadStarted(this.r());
            }
            if (SingleRequest.E) {
                final StringBuilder sb = new StringBuilder();
                sb.append("finished run method in ");
                sb.append(v2.g.a(this.u));
                this.u(sb.toString());
            }
        }
    }
    
    @Override
    public boolean isRunning() {
        synchronized (this.d) {
            final Status w = this.w;
            return w == Status.RUNNING || w == Status.WAITING_FOR_SIZE;
        }
    }
    
    @Override
    public void pause() {
        synchronized (this.d) {
            if (this.isRunning()) {
                this.clear();
            }
        }
    }
    
    @Override
    public String toString() {
        Object d = this.d;
        synchronized (d) {
            final Object i = this.i;
            final Class<R> j = this.j;
            monitorexit(d);
            d = new StringBuilder();
            ((StringBuilder)d).append(super.toString());
            ((StringBuilder)d).append("[model=");
            ((StringBuilder)d).append(i);
            ((StringBuilder)d).append(", transcodeClass=");
            ((StringBuilder)d).append(j);
            ((StringBuilder)d).append("]");
            return ((StringBuilder)d).toString();
        }
    }
    
    private enum Status
    {
        private static final Status[] $VALUES;
        
        CLEARED, 
        COMPLETE, 
        FAILED, 
        PENDING, 
        RUNNING, 
        WAITING_FOR_SIZE;
    }
}
