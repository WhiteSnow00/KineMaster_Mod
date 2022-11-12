// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.z1;
import kotlinx.coroutines.v0;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.o;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a" }, d2 = { "Landroidx/lifecycle/g;", "", "Ljava/lang/Runnable;", "runnable", "Lka/r;", "f", "h", "i", "g", "e", "", "b", "Lkotlin/coroutines/CoroutineContext;", "context", "c", "a", "Z", "paused", "finished", "isDraining", "Ljava/util/Queue;", "d", "Ljava/util/Queue;", "queue", "<init>", "()V", "lifecycle-runtime-ktx_release" }, k = 1, mv = { 1, 6, 0 })
public final class g
{
    private boolean a;
    private boolean b;
    private boolean c;
    private final Queue<Runnable> d;
    
    public g() {
        this.a = true;
        this.d = new ArrayDeque<Runnable>();
    }
    
    public static void a(final g g, final Runnable runnable) {
        d(g, runnable);
    }
    
    private static final void d(final g g, final Runnable runnable) {
        o.g((Object)g, "this$0");
        o.g((Object)runnable, "$runnable");
        g.f(runnable);
    }
    
    private final void f(final Runnable runnable) {
        if (this.d.offer(runnable)) {
            this.e();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }
    
    public final boolean b() {
        return this.b || !this.a;
    }
    
    public final void c(final CoroutineContext coroutineContext, final Runnable runnable) {
        o.g((Object)coroutineContext, "context");
        o.g((Object)runnable, "runnable");
        final z1 f0 = v0.c().f0();
        if (!((CoroutineDispatcher)f0).c0(coroutineContext) && !this.b()) {
            this.f(runnable);
        }
        else {
            ((CoroutineDispatcher)f0).Z(coroutineContext, (Runnable)new f(this, runnable));
        }
    }
    
    public final void e() {
        if (this.c) {
            return;
        }
        try {
            this.c = true;
            while ((this.d.isEmpty() ^ true) && this.b()) {
                final Runnable runnable = this.d.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
        finally {
            this.c = false;
        }
    }
    
    public final void g() {
        this.b = true;
        this.e();
    }
    
    public final void h() {
        this.a = true;
    }
    
    public final void i() {
        if (!this.a) {
            return;
        }
        if (this.b ^ true) {
            this.a = false;
            this.e();
            return;
        }
        throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
    }
}
