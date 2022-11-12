// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.l2;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.j0;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005" }, d2 = { "Landroidx/lifecycle/l0;", "Lkotlinx/coroutines/j0;", "a", "(Landroidx/lifecycle/l0;)Lkotlinx/coroutines/j0;", "viewModelScope", "lifecycle-viewmodel-ktx_release" }, k = 2, mv = { 1, 6, 0 })
public final class m0
{
    public static final j0 a(final l0 l0) {
        o.g((Object)l0, "<this>");
        final j0 j0 = l0.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (j0 != null) {
            return j0;
        }
        final d setTagIfAbsent = l0.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new d(((CoroutineContext)l2.b((q1)null, 1, (Object)null)).plus((CoroutineContext)v0.c().f0())));
        o.f((Object)setTagIfAbsent, "setTagIfAbsent(\n        \u2026Main.immediate)\n        )");
        return (j0)setTagIfAbsent;
    }
}
