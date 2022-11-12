// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.l2;
import kotlin.jvm.internal.o;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005" }, d2 = { "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "a", "(Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LifecycleCoroutineScope;", "coroutineScope", "lifecycle-runtime-ktx_release" }, k = 2, mv = { 1, 6, 0 })
public final class p
{
    public static final LifecycleCoroutineScope a(final Lifecycle lifecycle) {
        o.g((Object)lifecycle, "<this>");
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        do {
            final LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = lifecycle.a.get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, ((CoroutineContext)l2.b((q1)null, 1, (Object)null)).plus((CoroutineContext)v0.c().f0()));
        } while (!lifecycle.a.compareAndSet(null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.m();
        return lifecycleCoroutineScopeImpl;
    }
}
