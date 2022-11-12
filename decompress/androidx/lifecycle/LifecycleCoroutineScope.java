// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlinx.coroutines.CoroutineStart;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.q1;
import ka.r;
import kotlin.coroutines.c;
import sa.p;
import kotlin.Metadata;
import kotlinx.coroutines.j0;

@Metadata(bv = {}, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0010\u0010\u0011J4\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ4\u0010\n\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\n\u0010\tJ4\u0010\u000b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\u000b\u0010\tR\u0014\u0010\u000f\u001a\u00020\f8 X \u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012" }, d2 = { "Landroidx/lifecycle/LifecycleCoroutineScope;", "Lkotlinx/coroutines/j0;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "Lka/r;", "", "block", "Lkotlinx/coroutines/q1;", "j", "(Lsa/p;)Lkotlinx/coroutines/q1;", "l", "k", "Landroidx/lifecycle/Lifecycle;", "g", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "<init>", "()V", "lifecycle-runtime-ktx_release" }, k = 1, mv = { 1, 6, 0 })
public abstract class LifecycleCoroutineScope implements j0
{
    public abstract Lifecycle g();
    
    public final q1 j(final p<? super j0, ? super c<? super r>, ?> p) {
        o.g((Object)p, "block");
        return h.b((j0)this, (CoroutineContext)null, (CoroutineStart)null, (p)new LifecycleCoroutineScope$launchWhenCreated.LifecycleCoroutineScope$launchWhenCreated$1(this, (p)p, (c)null), 3, (Object)null);
    }
    
    public final q1 k(final p<? super j0, ? super c<? super r>, ?> p) {
        o.g((Object)p, "block");
        return h.b((j0)this, (CoroutineContext)null, (CoroutineStart)null, (p)new LifecycleCoroutineScope$launchWhenResumed.LifecycleCoroutineScope$launchWhenResumed$1(this, (p)p, (c)null), 3, (Object)null);
    }
    
    public final q1 l(final p<? super j0, ? super c<? super r>, ?> p) {
        o.g((Object)p, "block");
        return h.b((j0)this, (CoroutineContext)null, (CoroutineStart)null, (p)new LifecycleCoroutineScope$launchWhenStarted.LifecycleCoroutineScope$launchWhenStarted$1(this, (p)p, (c)null), 3, (Object)null);
    }
}
