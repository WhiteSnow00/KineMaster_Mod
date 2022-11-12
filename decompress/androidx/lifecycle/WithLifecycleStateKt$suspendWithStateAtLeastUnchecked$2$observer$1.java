// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlin.coroutines.c;
import kotlin.Result$a;
import ka.k;
import kotlin.Result;
import sa.a;
import kotlinx.coroutines.n;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b" }, d2 = { "androidx/lifecycle/WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1", "Landroidx/lifecycle/o;", "Landroidx/lifecycle/r;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "Lka/r;", "f", "lifecycle-runtime-ktx_release" }, k = 1, mv = { 1, 6, 0 })
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements o
{
    final Lifecycle.State a;
    final Lifecycle b;
    final n<Object> c;
    final a<Object> d;
    
    @Override
    public void f(final r r, Lifecycle.Event c) {
        kotlin.jvm.internal.o.g((Object)r, "source");
        kotlin.jvm.internal.o.g((Object)c, "event");
        if (c == Lifecycle.Event.upTo(this.a)) {
            this.b.c(this);
            c = (Lifecycle.Event)this.c;
            final a<Object> d = this.d;
            Object constructor-impl = null;
            try {
                final Result$a companion = Result.Companion;
                Result.constructor-impl(d.invoke());
            }
            finally {
                final Result$a companion2 = Result.Companion;
                final Throwable t;
                constructor-impl = Result.constructor-impl(k.a(t));
            }
            ((c)c).resumeWith(constructor-impl);
        }
        else if (c == Lifecycle.Event.ON_DESTROY) {
            this.b.c(this);
            final n<Object> c2 = this.c;
            final Result$a companion3 = Result.Companion;
            ((c)c2).resumeWith(Result.constructor-impl(k.a((Throwable)new LifecycleDestroyedException())));
        }
    }
}
