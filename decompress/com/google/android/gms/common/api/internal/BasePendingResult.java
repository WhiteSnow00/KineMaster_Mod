// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.TimeUnit;
import android.util.Log;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.api.GoogleApiClient;
import android.os.Looper;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.atomic.AtomicReference;
import com.google.android.gms.common.api.ResultCallback;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.lang.ref.WeakReference;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@KeepForSdk
@KeepName
public abstract class BasePendingResult<R extends Result> extends PendingResult<R>
{
    static final ThreadLocal p;
    public static final int q = 0;
    private final Object a;
    protected final CallbackHandler b;
    protected final WeakReference c;
    private final CountDownLatch d;
    private final ArrayList e;
    private ResultCallback f;
    private final AtomicReference g;
    private Result h;
    private Status i;
    private volatile boolean j;
    private boolean k;
    private boolean l;
    private ICancelToken m;
    @KeepName
    private r0 mResultGuardian;
    private volatile zada n;
    private boolean o;
    
    static {
        p = new q0();
    }
    
    @Deprecated
    BasePendingResult() {
        this.a = new Object();
        this.d = new CountDownLatch(1);
        this.e = new ArrayList();
        this.g = new AtomicReference();
        this.o = false;
        this.b = new CallbackHandler(Looper.getMainLooper());
        this.c = new WeakReference(null);
    }
    
    @KeepForSdk
    protected BasePendingResult(final GoogleApiClient googleApiClient) {
        this.a = new Object();
        this.d = new CountDownLatch(1);
        this.e = new ArrayList();
        this.g = new AtomicReference();
        this.o = false;
        Looper looper;
        if (googleApiClient != null) {
            looper = googleApiClient.m();
        }
        else {
            looper = Looper.getMainLooper();
        }
        this.b = new CallbackHandler(looper);
        this.c = new WeakReference((T)googleApiClient);
    }
    
    private final Result j() {
        Object a = this.a;
        synchronized (a) {
            Preconditions.p(this.j ^ true, "Result has already been consumed.");
            Preconditions.p(this.h(), "Result is not ready.");
            final Result h = this.h;
            this.h = null;
            this.f = null;
            this.j = true;
            monitorexit(a);
            a = this.g.getAndSet(null);
            if (a != null) {
                ((l0)a).a.a.remove(this);
            }
            return Preconditions.k(h);
        }
    }
    
    private final void k(final Result h) {
        this.h = h;
        this.i = h.getStatus();
        this.m = null;
        this.d.countDown();
        if (this.k) {
            this.f = null;
        }
        else {
            final ResultCallback f = this.f;
            if (f == null) {
                if (this.h instanceof Releasable) {
                    this.mResultGuardian = new r0(this, null);
                }
            }
            else {
                ((Handler)this.b).removeMessages(2);
                this.b.a(f, this.j());
            }
        }
        final ArrayList e = this.e;
        for (int size = e.size(), i = 0; i < size; ++i) {
            ((StatusListener)e.get(i)).a(this.i);
        }
        this.e.clear();
    }
    
    static /* bridge */ Result l(final BasePendingResult basePendingResult) {
        return basePendingResult.h;
    }
    
    public static void n(final Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable)result).release();
            }
            catch (final RuntimeException ex) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(result)), (Throwable)ex);
            }
        }
    }
    
    @Override
    public final void b(final StatusListener statusListener) {
        Preconditions.b(statusListener != null, "Callback cannot be null.");
        synchronized (this.a) {
            if (this.h()) {
                statusListener.a(this.i);
            }
            else {
                this.e.add(statusListener);
            }
        }
    }
    
    @Override
    public final R c(final long n, final TimeUnit timeUnit) {
        if (n > 0L) {
            Preconditions.j("await must not be called on the UI thread when time is greater than zero.");
        }
        final boolean j = this.j;
        boolean b = true;
        Preconditions.p(j ^ true, "Result has already been consumed.");
        if (this.n != null) {
            b = false;
        }
        Preconditions.p(b, "Cannot await if then() has been called.");
        try {
            if (!this.d.await(n, timeUnit)) {
                this.f(Status.j);
            }
        }
        catch (final InterruptedException ex) {
            this.f(Status.h);
        }
        Preconditions.p(this.h(), "Result is not ready.");
        return (R)this.j();
    }
    
    @KeepForSdk
    @Override
    public void d() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/google/android/gms/common/api/internal/BasePendingResult.a:Ljava/lang/Object;
        //     4: astore_1       
        //     5: aload_1        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: getfield        com/google/android/gms/common/api/internal/BasePendingResult.k:Z
        //    11: ifne            65
        //    14: aload_0        
        //    15: getfield        com/google/android/gms/common/api/internal/BasePendingResult.j:Z
        //    18: ifeq            24
        //    21: goto            65
        //    24: aload_0        
        //    25: getfield        com/google/android/gms/common/api/internal/BasePendingResult.m:Lcom/google/android/gms/common/internal/ICancelToken;
        //    28: astore_2       
        //    29: aload_2        
        //    30: ifnull          39
        //    33: aload_2        
        //    34: invokeinterface com/google/android/gms/common/internal/ICancelToken.cancel:()V
        //    39: aload_0        
        //    40: getfield        com/google/android/gms/common/api/internal/BasePendingResult.h:Lcom/google/android/gms/common/api/Result;
        //    43: invokestatic    com/google/android/gms/common/api/internal/BasePendingResult.n:(Lcom/google/android/gms/common/api/Result;)V
        //    46: aload_0        
        //    47: iconst_1       
        //    48: putfield        com/google/android/gms/common/api/internal/BasePendingResult.k:Z
        //    51: aload_0        
        //    52: aload_0        
        //    53: getstatic       com/google/android/gms/common/api/Status.p:Lcom/google/android/gms/common/api/Status;
        //    56: invokevirtual   com/google/android/gms/common/api/internal/BasePendingResult.e:(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Result;
        //    59: invokespecial   com/google/android/gms/common/api/internal/BasePendingResult.k:(Lcom/google/android/gms/common/api/Result;)V
        //    62: aload_1        
        //    63: monitorexit    
        //    64: return         
        //    65: aload_1        
        //    66: monitorexit    
        //    67: return         
        //    68: astore_2       
        //    69: aload_1        
        //    70: monitorexit    
        //    71: aload_2        
        //    72: athrow         
        //    73: astore_2       
        //    74: goto            39
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  7      21     68     73     Any
        //  24     29     68     73     Any
        //  33     39     73     77     Landroid/os/RemoteException;
        //  33     39     68     73     Any
        //  39     64     68     73     Any
        //  65     67     68     73     Any
        //  69     71     68     73     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0039:
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
    
    @KeepForSdk
    protected abstract R e(final Status p0);
    
    @Deprecated
    @KeepForSdk
    public final void f(final Status status) {
        synchronized (this.a) {
            if (!this.h()) {
                this.i(this.e(status));
                this.l = true;
            }
        }
    }
    
    public final boolean g() {
        synchronized (this.a) {
            return this.k;
        }
    }
    
    @KeepForSdk
    public final boolean h() {
        return this.d.getCount() == 0L;
    }
    
    @KeepForSdk
    public final void i(final R r) {
        synchronized (this.a) {
            if (!this.l && !this.k) {
                this.h();
                Preconditions.p(this.h() ^ true, "Results have already been set");
                Preconditions.p(this.j ^ true, "Result has already been consumed");
                this.k(r);
                return;
            }
            n(r);
        }
    }
    
    public final void m() {
        final boolean o = this.o;
        boolean o2 = true;
        if (!o) {
            o2 = (BasePendingResult.p.get() && o2);
        }
        this.o = o2;
    }
    
    public final boolean o() {
        synchronized (this.a) {
            if (this.c.get() == null || !this.o) {
                this.d();
            }
            return this.g();
        }
    }
    
    public final void p(final l0 l0) {
        this.g.set(l0);
    }
    
    @VisibleForTesting
    public static class CallbackHandler<R extends Result> extends zau
    {
        public CallbackHandler() {
            super(Looper.getMainLooper());
        }
        
        public CallbackHandler(final Looper looper) {
            super(looper);
        }
        
        public final void a(final ResultCallback resultCallback, final Result result) {
            final int q = BasePendingResult.q;
            ((Handler)this).sendMessage(((Handler)this).obtainMessage(1, (Object)new Pair((Object)Preconditions.k(resultCallback), (Object)result)));
        }
        
        public final void handleMessage(final Message message) {
            final int what = message.what;
            if (what != 1) {
                if (what != 2) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Don't know how to handle message: ");
                    sb.append(what);
                    Log.wtf("BasePendingResult", sb.toString(), (Throwable)new Exception());
                    return;
                }
                ((BasePendingResult)message.obj).f(Status.j);
            }
            else {
                final Pair pair = (Pair)message.obj;
                final ResultCallback resultCallback = (ResultCallback)pair.first;
                final Result result = (Result)pair.second;
                try {
                    resultCallback.a(result);
                }
                catch (final RuntimeException ex) {
                    BasePendingResult.n(result);
                    throw ex;
                }
            }
        }
    }
}
