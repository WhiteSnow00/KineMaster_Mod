// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import sa.p;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.h;
import kotlin.coroutines.c;
import kotlinx.coroutines.v0;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.t1;
import kotlin.coroutines.CoroutineContext;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018" }, d2 = { "Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/o;", "Lka/r;", "m", "Landroidx/lifecycle/r;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "f", "Landroidx/lifecycle/Lifecycle;", "a", "Landroidx/lifecycle/Lifecycle;", "g", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "lifecycle-runtime-ktx_release" }, k = 1, mv = { 1, 6, 0 })
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements o
{
    private final Lifecycle a;
    private final CoroutineContext b;
    
    public LifecycleCoroutineScopeImpl(final Lifecycle a, final CoroutineContext b) {
        kotlin.jvm.internal.o.g((Object)a, "lifecycle");
        kotlin.jvm.internal.o.g((Object)b, "coroutineContext");
        this.a = a;
        this.b = b;
        if (this.g().b() == Lifecycle.State.DESTROYED) {
            t1.d(this.getCoroutineContext(), (CancellationException)null, 1, (Object)null);
        }
    }
    
    @Override
    public void f(final r r, final Lifecycle.Event event) {
        kotlin.jvm.internal.o.g((Object)r, "source");
        kotlin.jvm.internal.o.g((Object)event, "event");
        if (this.g().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            this.g().c(this);
            t1.d(this.getCoroutineContext(), (CancellationException)null, 1, (Object)null);
        }
    }
    
    @Override
    public Lifecycle g() {
        return this.a;
    }
    
    public CoroutineContext getCoroutineContext() {
        return this.b;
    }
    
    public final void m() {
        h.b((j0)this, (CoroutineContext)v0.c().f0(), (CoroutineStart)null, (p)new LifecycleCoroutineScopeImpl$register.LifecycleCoroutineScopeImpl$register$1(this, (c)null), 2, (Object)null);
    }
}
