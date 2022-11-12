// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import sa.p;
import kotlinx.coroutines.flow.e;
import ka.r;
import kotlinx.coroutines.flow.d;
import sa.q;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.flow.c;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u001aB\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¨\u0006\n" }, d2 = { "", "T", "Lkotlinx/coroutines/flow/c;", "Landroidx/paging/y;", "Lkotlinx/coroutines/j0;", "scope", "a", "Landroidx/paging/ActiveFlowTracker;", "tracker", "b", "paging-common" }, k = 2, mv = { 1, 5, 1 })
public final class CachedPagingDataKt
{
    public static final <T> c<y<T>> a(final c<y<T>> c, final j0 j0) {
        o.g((Object)c, "<this>");
        o.g((Object)j0, "scope");
        return b(c, j0, null);
    }
    
    public static final <T> c<y<T>> b(final c<y<T>> c, final j0 j0, final ActiveFlowTracker activeFlowTracker) {
        o.g((Object)c, "<this>");
        o.g((Object)j0, "scope");
        return (c<y<T>>)e.E(e.z(e.A((c)new CachedPagingDataKt$cachedIn$$inlined$map.CachedPagingDataKt$cachedIn$$inlined$map$1((c)FlowExtKt.b(FlowExtKt.d((kotlinx.coroutines.flow.c<?>)c, (sa.q<? super kotlinx.coroutines.flow.d<?>, ? super Object, ? super kotlin.coroutines.c<? super r>, ?>)new CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest.CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1((kotlin.coroutines.c)null, j0)), (sa.q<? super Object, ? super Object, ? super kotlin.coroutines.c<? super Object>, ?>)new CachedPagingDataKt$cachedIn.CachedPagingDataKt$cachedIn$2((kotlin.coroutines.c)null))), (p)new CachedPagingDataKt$cachedIn.CachedPagingDataKt$cachedIn$4(activeFlowTracker, (kotlin.coroutines.c)null)), (q)new CachedPagingDataKt$cachedIn.CachedPagingDataKt$cachedIn$5(activeFlowTracker, (kotlin.coroutines.c)null)), j0, kotlinx.coroutines.flow.q.a.b(), 1);
    }
}
