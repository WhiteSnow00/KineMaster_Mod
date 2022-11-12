// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.Registry;
import com.bumptech.glide.load.EncodeStrategy;
import android.content.Context;
import java.util.Map;
import java.util.Collection;
import android.util.Log;
import v2.g;
import java.util.ArrayList;
import com.bumptech.glide.Priority;
import w2.c;
import java.util.List;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.DataSource;
import c2.b;
import w2.a;

class DecodeJob<R> implements com.bumptech.glide.load.engine.e.a, Runnable, Comparable<DecodeJob<?>>, w2.a.f
{
    private b<R> A;
    private int B;
    private Stage C;
    private RunReason D;
    private long E;
    private boolean F;
    private Object G;
    private Thread H;
    private c2.b I;
    private c2.b J;
    private Object K;
    private DataSource L;
    private com.bumptech.glide.load.data.d<?> M;
    private volatile com.bumptech.glide.load.engine.e N;
    private volatile boolean O;
    private volatile boolean P;
    private boolean Q;
    private final com.bumptech.glide.load.engine.f<R> a;
    private final List<Throwable> b;
    private final w2.c c;
    private final e d;
    private final androidx.core.util.e<DecodeJob<?>> e;
    private final d<?> f;
    private final f g;
    private com.bumptech.glide.e h;
    private c2.b i;
    private Priority j;
    private l p;
    private int w;
    private int x;
    private h y;
    private c2.e z;
    
    DecodeJob(final e d, final androidx.core.util.e<DecodeJob<?>> e) {
        this.a = new com.bumptech.glide.load.engine.f<R>();
        this.b = new ArrayList<Throwable>();
        this.c = w2.c.a();
        this.f = new d<Object>();
        this.g = new f();
        this.d = d;
        this.e = e;
    }
    
    private void B() {
        this.g.e();
        this.f.a();
        this.a.a();
        this.O = false;
        this.h = null;
        this.i = null;
        this.z = null;
        this.j = null;
        this.p = null;
        this.A = null;
        this.C = null;
        this.N = null;
        this.H = null;
        this.I = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.E = 0L;
        this.P = false;
        this.G = null;
        this.b.clear();
        this.e.b(this);
    }
    
    private void C() {
        this.H = Thread.currentThread();
        this.E = v2.g.b();
        boolean b = false;
        do {
            boolean b2 = b;
            if (!this.P) {
                b2 = b;
                if (this.N != null) {
                    b = this.N.b();
                    if (!(b2 = b)) {
                        this.C = this.n(this.C);
                        this.N = this.m();
                        continue;
                    }
                }
            }
            if ((this.C == Stage.FINISHED || this.P) && !b2) {
                this.w();
            }
            return;
        } while (this.C != Stage.SOURCE);
        this.f();
    }
    
    private <Data, ResourceType> s<R> E(Data l, final DataSource dataSource, final q<Data, ResourceType, R> q) throws GlideException {
        final c2.e o = this.o(dataSource);
        l = (Data)this.h.i().l(l);
        try {
            return q.a((com.bumptech.glide.load.data.e<Data>)l, o, this.w, this.x, new c<ResourceType>(dataSource));
        }
        finally {
            ((com.bumptech.glide.load.data.e)l).b();
        }
    }
    
    private void G() {
        final int n = DecodeJob$a.a[this.D.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unrecognized run reason: ");
                    sb.append(this.D);
                    throw new IllegalStateException(sb.toString());
                }
                this.l();
            }
            else {
                this.C();
            }
        }
        else {
            this.C = this.n(Stage.INITIALIZE);
            this.N = this.m();
            this.C();
        }
    }
    
    private void H() {
        this.c.c();
        if (this.O) {
            Throwable t;
            if (this.b.isEmpty()) {
                t = null;
            }
            else {
                final List<Throwable> b = this.b;
                t = b.get(b.size() - 1);
            }
            throw new IllegalStateException("Already notified", t);
        }
        this.O = true;
    }
    
    private <Data> s<R> i(final com.bumptech.glide.load.data.d<?> d, final Data data, final DataSource dataSource) throws GlideException {
        if (data == null) {
            d.b();
            return null;
        }
        try {
            final long b = v2.g.b();
            final s<R> k = this.k(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Decoded result ");
                sb.append(k);
                this.r(sb.toString(), b);
            }
            return k;
        }
        finally {
            d.b();
        }
    }
    
    private <Data> s<R> k(final Data data, final DataSource dataSource) throws GlideException {
        return this.E(data, dataSource, (q<Data, ?, R>)this.a.h(data.getClass()));
    }
    
    private void l() {
        if (Log.isLoggable("DecodeJob", 2)) {
            final long e = this.E;
            final StringBuilder sb = new StringBuilder();
            sb.append("data: ");
            sb.append(this.K);
            sb.append(", cache key: ");
            sb.append(this.I);
            sb.append(", fetcher: ");
            sb.append(this.M);
            this.s("Retrieved data", e, sb.toString());
        }
        s<R> i = null;
        try {
            i = this.i(this.M, this.K, this.L);
        }
        catch (final GlideException ex) {
            ex.setLoggingDetails(this.J, this.L);
            this.b.add(ex);
        }
        if (i != null) {
            this.u(i, this.L, this.Q);
        }
        else {
            this.C();
        }
    }
    
    private com.bumptech.glide.load.engine.e m() {
        final int n = DecodeJob$a.b[this.C.ordinal()];
        if (n == 1) {
            return new t(this.a, this);
        }
        if (n == 2) {
            return new com.bumptech.glide.load.engine.b(this.a, this);
        }
        if (n == 3) {
            return new w(this.a, this);
        }
        if (n == 4) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized stage: ");
        sb.append(this.C);
        throw new IllegalStateException(sb.toString());
    }
    
    private Stage n(Stage stage) {
        final int n = DecodeJob$a.b[stage.ordinal()];
        if (n == 1) {
            if (this.y.a()) {
                stage = Stage.DATA_CACHE;
            }
            else {
                stage = this.n(Stage.DATA_CACHE);
            }
            return stage;
        }
        if (n == 2) {
            if (this.F) {
                stage = Stage.FINISHED;
            }
            else {
                stage = Stage.SOURCE;
            }
            return stage;
        }
        if (n == 3 || n == 4) {
            return Stage.FINISHED;
        }
        if (n == 5) {
            if (this.y.b()) {
                stage = Stage.RESOURCE_CACHE;
            }
            else {
                stage = this.n(Stage.RESOURCE_CACHE);
            }
            return stage;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized stage: ");
        sb.append(stage);
        throw new IllegalArgumentException(sb.toString());
    }
    
    private c2.e o(final DataSource dataSource) {
        final c2.e z = this.z;
        final boolean b = dataSource == DataSource.RESOURCE_DISK_CACHE || this.a.x();
        final c2.d<Boolean> j = com.bumptech.glide.load.resource.bitmap.l.j;
        final Boolean b2 = z.c(j);
        if (b2 != null && (!b2 || b)) {
            return z;
        }
        final c2.e e = new c2.e();
        e.d(this.z);
        e.e(j, b);
        return e;
    }
    
    private int p() {
        return this.j.ordinal();
    }
    
    private void r(final String s, final long n) {
        this.s(s, n, null);
    }
    
    private void s(String string, final long n, final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(" in ");
        sb.append(v2.g.a(n));
        sb.append(", load key: ");
        sb.append(this.p);
        if (s != null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(", ");
            sb2.append(s);
            string = sb2.toString();
        }
        else {
            string = "";
        }
        sb.append(string);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }
    
    private void t(final s<R> s, final DataSource dataSource, final boolean b) {
        this.H();
        this.A.b(s, dataSource, b);
    }
    
    private void u(final s<R> s, final DataSource dataSource, final boolean b) {
        w2.b.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (s instanceof o) {
                ((o)s).initialize();
            }
            r<R> f = null;
            s<R> s2 = s;
            if (this.f.c()) {
                s2 = (f = r.f(s));
            }
            this.t(s2, dataSource, b);
            this.C = Stage.ENCODE;
            try {
                if (this.f.c()) {
                    this.f.b(this.d, this.z);
                }
                if (f != null) {
                    f.h();
                }
                this.x();
            }
            finally {
                if (f != null) {
                    f.h();
                }
            }
        }
        finally {
            w2.b.e();
        }
    }
    
    private void w() {
        this.H();
        this.A.c(new GlideException("Failed to load resource", new ArrayList<Throwable>(this.b)));
        this.y();
    }
    
    private void x() {
        if (this.g.b()) {
            this.B();
        }
    }
    
    private void y() {
        if (this.g.c()) {
            this.B();
        }
    }
    
    void A(final boolean b) {
        if (this.g.d(b)) {
            this.B();
        }
    }
    
    boolean I() {
        final Stage n = this.n(Stage.INITIALIZE);
        return n == Stage.RESOURCE_CACHE || n == Stage.DATA_CACHE;
    }
    
    @Override
    public void a(final c2.b b, final Exception ex, final com.bumptech.glide.load.data.d<?> d, final DataSource dataSource) {
        d.b();
        final GlideException ex2 = new GlideException("Fetching data failed", ex);
        ex2.setLoggingDetails(b, dataSource, d.a());
        this.b.add(ex2);
        if (Thread.currentThread() != this.H) {
            this.D = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.A.e(this);
        }
        else {
            this.C();
        }
    }
    
    @Override
    public void c(final c2.b i, final Object k, final com.bumptech.glide.load.data.d<?> m, final DataSource l, final c2.b j) {
        this.I = i;
        this.K = k;
        this.M = m;
        this.L = l;
        this.J = j;
        final List<c2.b> c = this.a.c();
        boolean q = false;
        if (i != c.get(0)) {
            q = true;
        }
        this.Q = q;
        if (Thread.currentThread() != this.H) {
            this.D = RunReason.DECODE_DATA;
            this.A.e(this);
            return;
        }
        w2.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            this.l();
        }
        finally {
            w2.b.e();
        }
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.h((DecodeJob<?>)o);
    }
    
    @Override
    public w2.c d() {
        return this.c;
    }
    
    @Override
    public void f() {
        this.D = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.A.e(this);
    }
    
    public void g() {
        this.P = true;
        final com.bumptech.glide.load.engine.e n = this.N;
        if (n != null) {
            n.cancel();
        }
    }
    
    public int h(final DecodeJob<?> decodeJob) {
        int n;
        if ((n = this.p() - decodeJob.p()) == 0) {
            n = this.B - decodeJob.B;
        }
        return n;
    }
    
    DecodeJob<R> q(final com.bumptech.glide.e h, final Object g, final l p17, final c2.b i, final int w, final int x, final Class<?> clazz, final Class<R> clazz2, final Priority j, final h y, final Map<Class<?>, c2.h<?>> map, final boolean b, final boolean b2, final boolean f, final c2.e z, final b<R> a, final int b3) {
        this.a.v(h, g, i, w, x, y, clazz, clazz2, j, z, map, b, b2, this.d);
        this.h = h;
        this.i = i;
        this.j = j;
        this.p = p17;
        this.w = w;
        this.x = x;
        this.y = y;
        this.F = f;
        this.z = z;
        this.A = a;
        this.B = b3;
        this.D = RunReason.INITIALIZE;
        this.G = g;
        return this;
    }
    
    @Override
    public void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0        
        //     4: getfield        com/bumptech/glide/load/engine/DecodeJob.D:Lcom/bumptech/glide/load/engine/DecodeJob$RunReason;
        //     7: aload_0        
        //     8: getfield        com/bumptech/glide/load/engine/DecodeJob.G:Ljava/lang/Object;
        //    11: invokestatic    w2/b.c:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //    14: aload_0        
        //    15: getfield        com/bumptech/glide/load/engine/DecodeJob.M:Lcom/bumptech/glide/load/data/d;
        //    18: astore_1       
        //    19: aload_0        
        //    20: getfield        com/bumptech/glide/load/engine/DecodeJob.P:Z
        //    23: ifeq            44
        //    26: aload_0        
        //    27: invokespecial   com/bumptech/glide/load/engine/DecodeJob.w:()V
        //    30: aload_1        
        //    31: ifnull          40
        //    34: aload_1        
        //    35: invokeinterface com/bumptech/glide/load/data/d.b:()V
        //    40: invokestatic    w2/b.e:()V
        //    43: return         
        //    44: aload_0        
        //    45: invokespecial   com/bumptech/glide/load/engine/DecodeJob.G:()V
        //    48: aload_1        
        //    49: ifnull          58
        //    52: aload_1        
        //    53: invokeinterface com/bumptech/glide/load/data/d.b:()V
        //    58: invokestatic    w2/b.e:()V
        //    61: return         
        //    62: astore_3       
        //    63: ldc_w           "DecodeJob"
        //    66: iconst_3       
        //    67: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //    70: ifeq            127
        //    73: new             Ljava/lang/StringBuilder;
        //    76: astore_2       
        //    77: aload_2        
        //    78: invokespecial   java/lang/StringBuilder.<init>:()V
        //    81: aload_2        
        //    82: ldc_w           "DecodeJob threw unexpectedly, isCancelled: "
        //    85: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    88: pop            
        //    89: aload_2        
        //    90: aload_0        
        //    91: getfield        com/bumptech/glide/load/engine/DecodeJob.P:Z
        //    94: invokevirtual   java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
        //    97: pop            
        //    98: aload_2        
        //    99: ldc_w           ", stage: "
        //   102: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: pop            
        //   106: aload_2        
        //   107: aload_0        
        //   108: getfield        com/bumptech/glide/load/engine/DecodeJob.C:Lcom/bumptech/glide/load/engine/DecodeJob$Stage;
        //   111: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   114: pop            
        //   115: ldc_w           "DecodeJob"
        //   118: aload_2        
        //   119: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   122: aload_3        
        //   123: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   126: pop            
        //   127: aload_0        
        //   128: getfield        com/bumptech/glide/load/engine/DecodeJob.C:Lcom/bumptech/glide/load/engine/DecodeJob$Stage;
        //   131: getstatic       com/bumptech/glide/load/engine/DecodeJob$Stage.ENCODE:Lcom/bumptech/glide/load/engine/DecodeJob$Stage;
        //   134: if_acmpeq       152
        //   137: aload_0        
        //   138: getfield        com/bumptech/glide/load/engine/DecodeJob.b:Ljava/util/List;
        //   141: aload_3        
        //   142: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   147: pop            
        //   148: aload_0        
        //   149: invokespecial   com/bumptech/glide/load/engine/DecodeJob.w:()V
        //   152: aload_0        
        //   153: getfield        com/bumptech/glide/load/engine/DecodeJob.P:Z
        //   156: ifne            161
        //   159: aload_3        
        //   160: athrow         
        //   161: aload_3        
        //   162: athrow         
        //   163: astore_2       
        //   164: aload_2        
        //   165: athrow         
        //   166: astore_2       
        //   167: aload_1        
        //   168: ifnull          177
        //   171: aload_1        
        //   172: invokeinterface com/bumptech/glide/load/data/d.b:()V
        //   177: invokestatic    w2/b.e:()V
        //   180: aload_2        
        //   181: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                              
        //  -----  -----  -----  -----  --------------------------------------------------
        //  19     30     163    166    Lcom/bumptech/glide/load/engine/CallbackException;
        //  19     30     62     163    Any
        //  44     48     163    166    Lcom/bumptech/glide/load/engine/CallbackException;
        //  44     48     62     163    Any
        //  63     127    166    182    Any
        //  127    152    166    182    Any
        //  152    161    166    182    Any
        //  161    163    166    182    Any
        //  164    166    166    182    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0127:
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
    
     <Z> s<Z> z(final DataSource dataSource, final s<Z> s) {
        final Class<?> class1 = s.get().getClass();
        final DataSource resource_DISK_CACHE = DataSource.RESOURCE_DISK_CACHE;
        final c2.g g = null;
        c2.h<Z> s2;
        s<Z> a;
        if (dataSource != resource_DISK_CACHE) {
            s2 = this.a.s(class1);
            a = s2.a((Context)this.h, s, this.w, this.x);
        }
        else {
            a = s;
            s2 = null;
        }
        if (!s.equals(a)) {
            s.b();
        }
        c2.g<Z> n;
        EncodeStrategy encodeStrategy;
        if (this.a.w(a)) {
            n = this.a.n(a);
            encodeStrategy = n.a(this.z);
        }
        else {
            encodeStrategy = EncodeStrategy.NONE;
            n = g;
        }
        final boolean y = this.a.y(this.I);
        s<Z> f = (s<Z>)a;
        if (this.y.d(y ^ true, dataSource, encodeStrategy)) {
            if (n == null) {
                throw new Registry.NoResultEncoderAvailableException(a.get().getClass());
            }
            final int n2 = DecodeJob$a.c[encodeStrategy.ordinal()];
            c2.b b;
            if (n2 != 1) {
                if (n2 != 2) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown strategy: ");
                    sb.append(encodeStrategy);
                    throw new IllegalArgumentException(sb.toString());
                }
                b = new u(this.a.b(), this.I, this.i, this.w, this.x, s2, class1, this.z);
            }
            else {
                b = new com.bumptech.glide.load.engine.c(this.I, this.i);
            }
            f = (s<Z>)r.f(a);
            this.f.d(b, (c2.g<Object>)n, (r<Object>)f);
        }
        return (s<Z>)f;
    }
    
    private enum RunReason
    {
        private static final RunReason[] $VALUES;
        
        DECODE_DATA, 
        INITIALIZE, 
        SWITCH_TO_SOURCE_SERVICE;
    }
    
    private enum Stage
    {
        private static final Stage[] $VALUES;
        
        DATA_CACHE, 
        ENCODE, 
        FINISHED, 
        INITIALIZE, 
        RESOURCE_CACHE, 
        SOURCE;
    }
    
    interface b<R>
    {
        void b(final s<R> p0, final DataSource p1, final boolean p2);
        
        void c(final GlideException p0);
        
        void e(final DecodeJob<?> p0);
    }
    
    private final class c<Z> implements g.a<Z>
    {
        private final DataSource a;
        final DecodeJob b;
        
        c(final DecodeJob b, final DataSource a) {
            this.b = b;
            this.a = a;
        }
        
        @Override
        public s<Z> a(final s<Z> s) {
            return this.b.z(this.a, s);
        }
    }
    
    private static class d<Z>
    {
        private c2.b a;
        private c2.g<Z> b;
        private r<Z> c;
        
        d() {
        }
        
        void a() {
            this.a = null;
            this.b = null;
            this.c = null;
        }
        
        void b(final e e, final c2.e e2) {
            w2.b.a("DecodeJob.encode");
            try {
                e.a().b(this.a, (f2.a.b)new com.bumptech.glide.load.engine.d((c2.a<Object>)this.b, this.c, e2));
            }
            finally {
                this.c.h();
                w2.b.e();
            }
        }
        
        boolean c() {
            return this.c != null;
        }
        
         <X> void d(final c2.b a, final c2.g<X> b, final r<X> c) {
            this.a = a;
            this.b = (c2.g<Z>)b;
            this.c = (r<Z>)c;
        }
    }
    
    interface e
    {
        f2.a a();
    }
    
    private static class f
    {
        private boolean a;
        private boolean b;
        private boolean c;
        
        f() {
        }
        
        private boolean a(final boolean b) {
            return (this.c || b || this.b) && this.a;
        }
        
        boolean b() {
            synchronized (this) {
                this.b = true;
                return this.a(false);
            }
        }
        
        boolean c() {
            synchronized (this) {
                this.c = true;
                return this.a(false);
            }
        }
        
        boolean d(final boolean b) {
            synchronized (this) {
                this.a = true;
                return this.a(b);
            }
        }
        
        void e() {
            synchronized (this) {
                this.b = false;
                this.a = false;
                this.c = false;
            }
        }
    }
}
