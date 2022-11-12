// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.q1$a;
import ka.r;
import sa.l;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import sa.p;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.n;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.flow.m;
import kotlin.collections.z;
import kotlinx.coroutines.flow.h;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B#\u0012\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0004\u001a\u00020\u0003R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R(\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0018\u00010\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR(\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0018\u00010\n0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u00178\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006!" }, d2 = { "Landroidx/paging/CachedPageEventFlow;", "", "T", "Lka/r;", "e", "Landroidx/paging/FlattenedPageController;", "a", "Landroidx/paging/FlattenedPageController;", "pageController", "Lkotlinx/coroutines/flow/h;", "Lkotlin/collections/z;", "Landroidx/paging/u;", "b", "Lkotlinx/coroutines/flow/h;", "mutableSharedSrc", "Lkotlinx/coroutines/flow/m;", "c", "Lkotlinx/coroutines/flow/m;", "sharedForDownstream", "Lkotlinx/coroutines/q1;", "d", "Lkotlinx/coroutines/q1;", "job", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/c;", "f", "()Lkotlinx/coroutines/flow/c;", "downstreamFlow", "src", "Lkotlinx/coroutines/j0;", "scope", "<init>", "(Lkotlinx/coroutines/flow/c;Lkotlinx/coroutines/j0;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class CachedPageEventFlow<T>
{
    private final FlattenedPageController<T> a;
    private final h<z<u<T>>> b;
    private final m<z<u<T>>> c;
    private final q1 d;
    private final c<u<T>> e;
    
    public CachedPageEventFlow(final c<? extends u<T>> c, final j0 j0) {
        o.g((Object)c, "src");
        o.g((Object)j0, "scope");
        this.a = new FlattenedPageController<T>();
        final h a = n.a(1, Integer.MAX_VALUE, BufferOverflow.SUSPEND);
        this.b = (h<z<u<T>>>)a;
        this.c = (m<z<u<T>>>)kotlinx.coroutines.flow.e.B((m)a, (p)new CachedPageEventFlow$sharedForDownstream.CachedPageEventFlow$sharedForDownstream$1(this, (kotlin.coroutines.c)null));
        final q1 b = kotlinx.coroutines.h.b(j0, (CoroutineContext)null, CoroutineStart.LAZY, (p)new CachedPageEventFlow$job.CachedPageEventFlow$job$1((c)c, this, (kotlin.coroutines.c)null), 1, (Object)null);
        b.i((l)new CachedPageEventFlow$job$2.CachedPageEventFlow$job$2$1(this));
        final r a2 = r.a;
        this.d = b;
        this.e = (c<u<T>>)kotlinx.coroutines.flow.e.t((p)new CachedPageEventFlow$downstreamFlow.CachedPageEventFlow$downstreamFlow$1(this, (kotlin.coroutines.c)null));
    }
    
    public static final q1 a(final CachedPageEventFlow cachedPageEventFlow) {
        return cachedPageEventFlow.d;
    }
    
    public static final h b(final CachedPageEventFlow cachedPageEventFlow) {
        return cachedPageEventFlow.b;
    }
    
    public static final FlattenedPageController c(final CachedPageEventFlow cachedPageEventFlow) {
        return cachedPageEventFlow.a;
    }
    
    public static final m d(final CachedPageEventFlow cachedPageEventFlow) {
        return cachedPageEventFlow.c;
    }
    
    public final void e() {
        q1$a.a(this.d, (CancellationException)null, 1, (Object)null);
    }
    
    public final c<u<T>> f() {
        return this.e;
    }
}
