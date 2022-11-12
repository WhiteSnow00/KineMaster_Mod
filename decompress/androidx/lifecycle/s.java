// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlin.jvm.internal.o;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005" }, d2 = { "Landroidx/lifecycle/r;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "a", "(Landroidx/lifecycle/r;)Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "lifecycle-runtime-ktx_release" }, k = 2, mv = { 1, 6, 0 })
public final class s
{
    public static final LifecycleCoroutineScope a(final r r) {
        o.g((Object)r, "<this>");
        final Lifecycle lifecycle = r.getLifecycle();
        o.f((Object)lifecycle, "lifecycle");
        return p.a(lifecycle);
    }
}
