// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.q1$a;
import ka.k;
import sa.q;
import java.util.Iterator;
import kotlinx.coroutines.CoroutineStart;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h;
import kotlinx.coroutines.j0;
import java.util.List;
import kotlinx.coroutines.flow.e;
import sa.p;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.t1;
import sa.l;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.g;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.channels.d;
import java.util.concurrent.atomic.AtomicBoolean;
import sa.a;
import ka.r;
import kotlinx.coroutines.flow.c;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0085\u0001\u0012\b\u0010/\u001a\u0004\u0018\u00018\u0000\u0012\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100\u0012\u0006\u00109\u001a\u000206\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\b0\r\u0012\b\b\u0002\u0010@\u001a\u00020=\u0012\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010A\u0012\u0016\b\u0002\u0010I\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010)\u0012\u000e\b\u0002\u0010d\u001a\b\u0012\u0004\u0012\u00020\b0c¢\u0006\u0004\be\u0010fJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\f\u0010\f\u001a\u00020\b*\u00020\u000bH\u0002J%\u0010\u000f\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\bH\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001c\u001a\u00020\b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010 \u001a\u00020\b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b \u0010!J9\u0010$\u001a\u0004\u0018\u00018\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010%J\b\u0010&\u001a\u00020\bH\u0002J\u000e\u0010'\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020\bJ\u001f\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010)H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b*\u0010\u0016R\u001c\u0010/\u001a\u0004\u0018\u00018\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R&\u00105\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\b0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R%\u0010F\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010A8\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\"\u0010I\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR \u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010S0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR \u0010Z\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R#\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010S0\r8\u0006¢\u0006\f\n\u0004\b_\u0010;\u001a\u0004\b`\u0010a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006g" }, d2 = { "Landroidx/paging/PageFetcherSnapshot;", "", "Key", "Value", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/g0;", "viewportHint", "Lka/r;", "C", "(Landroidx/paging/LoadType;Landroidx/paging/g0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/j0;", "F", "Lkotlinx/coroutines/flow/c;", "", "r", "(Lkotlinx/coroutines/flow/c;Landroidx/paging/LoadType;Lkotlin/coroutines/c;)Ljava/lang/Object;", "key", "Landroidx/paging/PagingSource$a;", "z", "(Landroidx/paging/LoadType;Ljava/lang/Object;)Landroidx/paging/PagingSource$a;", "t", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/paging/h;", "generationalHint", "u", "(Landroidx/paging/LoadType;Landroidx/paging/h;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/paging/PageFetcherSnapshotState;", "E", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/paging/l$a;", "error", "D", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Landroidx/paging/l$a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "generationId", "presentedItemsBeyondAnchor", "A", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;II)Ljava/lang/Object;", "B", "p", "q", "Landroidx/paging/z;", "s", "a", "Ljava/lang/Object;", "v", "()Ljava/lang/Object;", "initialKey", "Landroidx/paging/PagingSource;", "b", "Landroidx/paging/PagingSource;", "x", "()Landroidx/paging/PagingSource;", "pagingSource", "Landroidx/paging/x;", "c", "Landroidx/paging/x;", "config", "d", "Lkotlinx/coroutines/flow/c;", "retryFlow", "", "e", "Z", "triggerRemoteRefresh", "Landroidx/paging/c0;", "f", "Landroidx/paging/c0;", "y", "()Landroidx/paging/c0;", "remoteMediatorConnection", "g", "Landroidx/paging/z;", "previousPagingState", "Landroidx/paging/HintHandler;", "i", "Landroidx/paging/HintHandler;", "hintHandler", "Ljava/util/concurrent/atomic/AtomicBoolean;", "j", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pageEventChCollected", "Lkotlinx/coroutines/channels/d;", "Landroidx/paging/u;", "k", "Lkotlinx/coroutines/channels/d;", "pageEventCh", "Landroidx/paging/PageFetcherSnapshotState$a;", "l", "Landroidx/paging/PageFetcherSnapshotState$a;", "stateHolder", "Lkotlinx/coroutines/z;", "m", "Lkotlinx/coroutines/z;", "pageEventChannelFlowJob", "n", "w", "()Lkotlinx/coroutines/flow/c;", "pageEventFlow", "Lkotlin/Function0;", "invalidate", "<init>", "(Ljava/lang/Object;Landroidx/paging/PagingSource;Landroidx/paging/x;Lkotlinx/coroutines/flow/c;ZLandroidx/paging/c0;Landroidx/paging/z;Lsa/a;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class PageFetcherSnapshot<Key, Value>
{
    private final Key a;
    private final PagingSource<Key, Value> b;
    private final x c;
    private final c<r> d;
    private final boolean e;
    private final c0<Key, Value> f;
    private final z<Key, Value> g;
    private final sa.a<r> h;
    private final HintHandler i;
    private final AtomicBoolean j;
    private final d<u<Value>> k;
    private final PageFetcherSnapshotState.a<Key, Value> l;
    private final kotlinx.coroutines.z m;
    private final c<u<Value>> n;
    
    public PageFetcherSnapshot(final Key a, final PagingSource<Key, Value> b, final x c, final c<r> d, final boolean e, final c0<Key, Value> f, final z<Key, Value> g, final sa.a<r> h) {
        o.g((Object)b, "pagingSource");
        o.g((Object)c, "config");
        o.g((Object)d, "retryFlow");
        o.g((Object)h, "invalidate");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        if (c.f == Integer.MIN_VALUE || b.getJumpingSupported()) {
            this.i = new HintHandler();
            this.j = new AtomicBoolean(false);
            this.k = (d<u<Value>>)kotlinx.coroutines.channels.g.b(-2, (BufferOverflow)null, (l)null, 6, (Object)null);
            this.l = (PageFetcherSnapshotState.a<Key, Value>)new PageFetcherSnapshotState.a(c);
            final kotlinx.coroutines.z b2 = t1.b((q1)null, 1, (Object)null);
            this.m = b2;
            this.n = (c<u<Value>>)kotlinx.coroutines.flow.e.A((c)CancelableChannelFlowKt.a((q1)b2, (sa.p<? super d0<Object>, ? super kotlin.coroutines.c<? super r>, ?>)new PageFetcherSnapshot$pageEventFlow.PageFetcherSnapshot$pageEventFlow$1(this, (kotlin.coroutines.c)null)), (p)new PageFetcherSnapshot$pageEventFlow.PageFetcherSnapshot$pageEventFlow$2(this, (kotlin.coroutines.c)null));
            return;
        }
        throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.".toString());
    }
    
    private final Key A(final PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, final LoadType loadType, final int n, final int n2) {
        if (n != pageFetcherSnapshotState.j(loadType)) {
            return null;
        }
        if (pageFetcherSnapshotState.p().a(loadType) instanceof androidx.paging.l.a) {
            return null;
        }
        if (n2 >= this.c.b) {
            return null;
        }
        Key key;
        if (loadType == LoadType.PREPEND) {
            key = ((PagingSource.b.c)kotlin.collections.o.b0((List)pageFetcherSnapshotState.m())).e();
        }
        else {
            key = ((PagingSource.b.c)kotlin.collections.o.n0((List)pageFetcherSnapshotState.m())).d();
        }
        return key;
    }
    
    private final void B() {
        this.q();
        this.b.invalidate();
    }
    
    private final Object C(final LoadType loadType, final g0 g0, final kotlin.coroutines.c<? super r> c) {
        final int n = PageFetcherSnapshot.a.a[loadType.ordinal()];
        boolean b = true;
        if (n == 1) {
            final Object t = this.t(c);
            if (t == kotlin.coroutines.intrinsics.a.d()) {
                return t;
            }
            return r.a;
        }
        else {
            if (g0 == null) {
                b = false;
            }
            if (b) {
                this.i.a(loadType, g0);
                return r.a;
            }
            throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint".toString());
        }
    }
    
    private final Object D(final PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, final LoadType loadType, final androidx.paging.l.a a, final kotlin.coroutines.c<? super r> c) {
        if (o.b((Object)pageFetcherSnapshotState.p().a(loadType), (Object)a)) {
            return r.a;
        }
        pageFetcherSnapshotState.p().c(loadType, a);
        final Object z = ((kotlinx.coroutines.channels.u)this.k).z((Object)new u.c(pageFetcherSnapshotState.p().d(), null), (kotlin.coroutines.c)c);
        if (z == kotlin.coroutines.intrinsics.a.d()) {
            return z;
        }
        return r.a;
    }
    
    private final Object E(final PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, final LoadType loadType, final kotlin.coroutines.c<? super r> c) {
        final androidx.paging.l a = pageFetcherSnapshotState.p().a(loadType);
        final androidx.paging.l.b b = androidx.paging.l.b.b;
        if (o.b((Object)a, (Object)b)) {
            return r.a;
        }
        pageFetcherSnapshotState.p().c(loadType, b);
        final Object z = ((kotlinx.coroutines.channels.u)this.k).z((Object)new u.c(pageFetcherSnapshotState.p().d(), null), (kotlin.coroutines.c)c);
        if (z == kotlin.coroutines.intrinsics.a.d()) {
            return z;
        }
        return r.a;
    }
    
    private final void F(final j0 j0) {
        if (this.c.f != Integer.MIN_VALUE) {
            final Iterator iterator = kotlin.collections.o.m((Object[])new LoadType[] { LoadType.APPEND, LoadType.PREPEND }).iterator();
            while (iterator.hasNext()) {
                kotlinx.coroutines.h.b(j0, (CoroutineContext)null, (CoroutineStart)null, (p)new PageFetcherSnapshot$startConsumingHints$1.PageFetcherSnapshot$startConsumingHints$1$1(this, (LoadType)iterator.next(), (kotlin.coroutines.c)null), 3, (Object)null);
            }
        }
        kotlinx.coroutines.h.b(j0, (CoroutineContext)null, (CoroutineStart)null, (p)new PageFetcherSnapshot$startConsumingHints.PageFetcherSnapshot$startConsumingHints$2(this, (kotlin.coroutines.c)null), 3, (Object)null);
        kotlinx.coroutines.h.b(j0, (CoroutineContext)null, (CoroutineStart)null, (p)new PageFetcherSnapshot$startConsumingHints.PageFetcherSnapshot$startConsumingHints$3(this, (kotlin.coroutines.c)null), 3, (Object)null);
    }
    
    public static final Object a(final PageFetcherSnapshot pageFetcherSnapshot, final c c, final LoadType loadType, final kotlin.coroutines.c c2) {
        return pageFetcherSnapshot.r(c, loadType, c2);
    }
    
    public static final Object b(final PageFetcherSnapshot pageFetcherSnapshot, final kotlin.coroutines.c c) {
        return pageFetcherSnapshot.t(c);
    }
    
    public static final Object c(final PageFetcherSnapshot pageFetcherSnapshot, final LoadType loadType, final androidx.paging.h h, final kotlin.coroutines.c c) {
        return pageFetcherSnapshot.u(loadType, h, c);
    }
    
    public static final x d(final PageFetcherSnapshot pageFetcherSnapshot) {
        return pageFetcherSnapshot.c;
    }
    
    public static final HintHandler e(final PageFetcherSnapshot pageFetcherSnapshot) {
        return pageFetcherSnapshot.i;
    }
    
    public static final sa.a f(final PageFetcherSnapshot pageFetcherSnapshot) {
        return pageFetcherSnapshot.h;
    }
    
    public static final d g(final PageFetcherSnapshot pageFetcherSnapshot) {
        return pageFetcherSnapshot.k;
    }
    
    public static final AtomicBoolean h(final PageFetcherSnapshot pageFetcherSnapshot) {
        return pageFetcherSnapshot.j;
    }
    
    public static final z i(final PageFetcherSnapshot pageFetcherSnapshot) {
        return pageFetcherSnapshot.g;
    }
    
    public static final c j(final PageFetcherSnapshot pageFetcherSnapshot) {
        return pageFetcherSnapshot.d;
    }
    
    public static final PageFetcherSnapshotState.a k(final PageFetcherSnapshot pageFetcherSnapshot) {
        return pageFetcherSnapshot.l;
    }
    
    public static final boolean l(final PageFetcherSnapshot pageFetcherSnapshot) {
        return pageFetcherSnapshot.e;
    }
    
    public static final Object m(final PageFetcherSnapshot pageFetcherSnapshot, final LoadType loadType, final g0 g0, final kotlin.coroutines.c c) {
        return pageFetcherSnapshot.C(loadType, g0, c);
    }
    
    public static final Object n(final PageFetcherSnapshot pageFetcherSnapshot, final PageFetcherSnapshotState pageFetcherSnapshotState, final LoadType loadType, final kotlin.coroutines.c c) {
        return pageFetcherSnapshot.E(pageFetcherSnapshotState, loadType, c);
    }
    
    public static final void o(final PageFetcherSnapshot pageFetcherSnapshot, final j0 j0) {
        pageFetcherSnapshot.F(j0);
    }
    
    private final Object r(final c<Integer> c, final LoadType loadType, final kotlin.coroutines.c<? super r> c2) {
        final Object collect = kotlinx.coroutines.flow.e.j((c)FlowExtKt.b(FlowExtKt.d((kotlinx.coroutines.flow.c<?>)c, (sa.q<? super kotlinx.coroutines.flow.d<?>, ? super Object, ? super kotlin.coroutines.c<? super r>, ?>)new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1((kotlin.coroutines.c)null, this, loadType)), (sa.q<? super Object, ? super Object, ? super kotlin.coroutines.c<? super Object>, ?>)new PageFetcherSnapshot$collectAsGenerationalViewportHints.PageFetcherSnapshot$collectAsGenerationalViewportHints$3(loadType, (kotlin.coroutines.c)null))).collect((kotlinx.coroutines.flow.d)new kotlinx.coroutines.flow.d<androidx.paging.h>(this, loadType) {
            final PageFetcherSnapshot a;
            final LoadType b;
            
            public Object emit(androidx.paging.h h, final kotlin.coroutines.c<? super r> c) {
                h = h;
                final Object c2 = PageFetcherSnapshot.c(this.a, this.b, h, c);
                if (c2 == kotlin.coroutines.intrinsics.a.d()) {
                    return c2;
                }
                return r.a;
            }
        }, (kotlin.coroutines.c)c2);
        if (collect == kotlin.coroutines.intrinsics.a.d()) {
            return collect;
        }
        return r.a;
    }
    
    private final Object t(kotlin.coroutines.c<? super r> l$0) {
        PageFetcherSnapshot$doInitialLoad.PageFetcherSnapshot$doInitialLoad$1 pageFetcherSnapshot$doInitialLoad$1 = null;
        Label_0049: {
            if (l$0 instanceof PageFetcherSnapshot$doInitialLoad.PageFetcherSnapshot$doInitialLoad$1) {
                pageFetcherSnapshot$doInitialLoad$1 = (PageFetcherSnapshot$doInitialLoad.PageFetcherSnapshot$doInitialLoad$1)l$0;
                final int label = pageFetcherSnapshot$doInitialLoad$1.label;
                if ((label & Integer.MIN_VALUE) != 0x0) {
                    pageFetcherSnapshot$doInitialLoad$1.label = label + Integer.MIN_VALUE;
                    break Label_0049;
                }
            }
            pageFetcherSnapshot$doInitialLoad$1 = new PageFetcherSnapshot$doInitialLoad.PageFetcherSnapshot$doInitialLoad$1(this, (kotlin.coroutines.c)l$0);
        }
        Object result = pageFetcherSnapshot$doInitialLoad$1.result;
        final Object d = kotlin.coroutines.intrinsics.a.d();
        kotlin.coroutines.c c7 = null;
        Label_1423: {
            Object l$2 = null;
            Object o3 = null;
            Label_0806: {
                Object load = null;
                Label_0725: {
                    Object a3 = null;
                    Label_0648: {
                        PageFetcherSnapshotState.a<Key, Value> m = null;
                        switch (pageFetcherSnapshot$doInitialLoad$1.label) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 9: {
                                l$0 = pageFetcherSnapshot$doInitialLoad$1.L$0;
                                try {
                                    ka.k.b(result);
                                    break Label_1423;
                                }
                                finally {
                                    break Label_1423;
                                }
                            }
                            case 8: {
                                l$0 = pageFetcherSnapshot$doInitialLoad$1.L$3;
                                final PageFetcherSnapshotState.a a = (PageFetcherSnapshotState.a)pageFetcherSnapshot$doInitialLoad$1.L$2;
                                final Object o = pageFetcherSnapshot$doInitialLoad$1.L$1;
                                l$2 = pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ka.k.b(result);
                                final PageFetcherSnapshotState.a<Key, Value> l = (PageFetcherSnapshotState.a<Key, Value>)a;
                                break Label_1423;
                            }
                            case 7: {
                                final Object a2 = pageFetcherSnapshot$doInitialLoad$1.L$3;
                                final PageFetcherSnapshotState.a<Key, Value> i = (PageFetcherSnapshotState.a<Key, Value>)pageFetcherSnapshot$doInitialLoad$1.L$2;
                                final PagingSource.b b = (PagingSource.b)pageFetcherSnapshot$doInitialLoad$1.L$1;
                                final Object o2 = pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ka.k.b(result);
                                result = b;
                                break Label_0806;
                            }
                            case 6: {
                                final kotlinx.coroutines.sync.c c = (kotlinx.coroutines.sync.c)pageFetcherSnapshot$doInitialLoad$1.L$2;
                                final Object l$3 = pageFetcherSnapshot$doInitialLoad$1.L$1;
                                final PageFetcherSnapshot pageFetcherSnapshot = (PageFetcherSnapshot)pageFetcherSnapshot$doInitialLoad$1.L$0;
                                final kotlinx.coroutines.sync.c c2 = c;
                                try {
                                    ka.k.b(result);
                                    result = pageFetcherSnapshot;
                                    break Label_0806;
                                }
                                finally {
                                    break Label_0806;
                                }
                            }
                            case 5: {
                                final Object l$4 = pageFetcherSnapshot$doInitialLoad$1.L$3;
                                final PageFetcherSnapshotState.a<Key, Value> j = (PageFetcherSnapshotState.a<Key, Value>)pageFetcherSnapshot$doInitialLoad$1.L$2;
                                final Object l$3 = pageFetcherSnapshot$doInitialLoad$1.L$1;
                                final PageFetcherSnapshot pageFetcherSnapshot2 = (PageFetcherSnapshot)pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ka.k.b(result);
                                result = pageFetcherSnapshot2;
                                break Label_0806;
                            }
                            case 4: {
                                final kotlinx.coroutines.sync.c c3 = (kotlinx.coroutines.sync.c)pageFetcherSnapshot$doInitialLoad$1.L$3;
                                final PageFetcherSnapshotState.a<Key, Value> k = (PageFetcherSnapshotState.a<Key, Value>)pageFetcherSnapshot$doInitialLoad$1.L$2;
                                o3 = pageFetcherSnapshot$doInitialLoad$1.L$1;
                                l$2 = pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ka.k.b(result);
                                result = c3;
                                break Label_0806;
                            }
                            case 3: {
                                l$2 = pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ka.k.b(result);
                                load = result;
                                break Label_0725;
                            }
                            case 2: {
                                final kotlinx.coroutines.sync.c c4 = (kotlinx.coroutines.sync.c)pageFetcherSnapshot$doInitialLoad$1.L$1;
                                final PageFetcherSnapshot pageFetcherSnapshot3 = (PageFetcherSnapshot)pageFetcherSnapshot$doInitialLoad$1.L$0;
                                final kotlinx.coroutines.sync.c c5 = c4;
                                Label_1559: {
                                    try {
                                        ka.k.b(result);
                                        result = pageFetcherSnapshot3;
                                        break Label_0648;
                                    }
                                    finally {
                                        break Label_1559;
                                    }
                                }
                                c5.b((Object)null);
                                break;
                            }
                            case 1: {
                                a3 = pageFetcherSnapshot$doInitialLoad$1.L$2;
                                m = (PageFetcherSnapshotState.a<Key, Value>)pageFetcherSnapshot$doInitialLoad$1.L$1;
                                final PageFetcherSnapshot pageFetcherSnapshot4 = (PageFetcherSnapshot)pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ka.k.b(result);
                                result = pageFetcherSnapshot4;
                                break;
                            }
                            case 0: {
                                ka.k.b(result);
                                m = this.l;
                                a3 = PageFetcherSnapshotState.a.a((PageFetcherSnapshotState.a<Object, Object>)m);
                                pageFetcherSnapshot$doInitialLoad$1.L$0 = this;
                                pageFetcherSnapshot$doInitialLoad$1.L$1 = m;
                                pageFetcherSnapshot$doInitialLoad$1.L$2 = a3;
                                pageFetcherSnapshot$doInitialLoad$1.label = 1;
                                if (((kotlinx.coroutines.sync.c)a3).a((Object)null, (kotlin.coroutines.c)pageFetcherSnapshot$doInitialLoad$1) == d) {
                                    return d;
                                }
                                result = this;
                                break;
                            }
                        }
                        final PageFetcherSnapshotState b2 = PageFetcherSnapshotState.a.b((PageFetcherSnapshotState.a<Object, Object>)m);
                        final LoadType refresh = LoadType.REFRESH;
                        pageFetcherSnapshot$doInitialLoad$1.L$0 = result;
                        pageFetcherSnapshot$doInitialLoad$1.L$1 = a3;
                        pageFetcherSnapshot$doInitialLoad$1.L$2 = null;
                        pageFetcherSnapshot$doInitialLoad$1.label = 2;
                        if (((PageFetcherSnapshot<?, ?>)result).E(b2, refresh, (kotlin.coroutines.c<? super r>)pageFetcherSnapshot$doInitialLoad$1) == d) {
                            return d;
                        }
                    }
                    final r a4 = r.a;
                    ((kotlinx.coroutines.sync.c)a3).b((Object)null);
                    final PagingSource.a<?> z = ((PageFetcherSnapshot<?, Value>)result).z(LoadType.REFRESH, ((PageFetcherSnapshot<?, Value>)result).v());
                    final PagingSource<?, ?> x = ((PageFetcherSnapshot<?, ?>)result).x();
                    pageFetcherSnapshot$doInitialLoad$1.L$0 = result;
                    pageFetcherSnapshot$doInitialLoad$1.L$1 = null;
                    pageFetcherSnapshot$doInitialLoad$1.label = 3;
                    load = x.load(z, (kotlin.coroutines.c<? super PagingSource.b<?, ?>>)pageFetcherSnapshot$doInitialLoad$1);
                    if (load == d) {
                        return d;
                    }
                    l$2 = result;
                }
                o3 = load;
                if (!(o3 instanceof PagingSource.b.c)) {
                    break Label_0806;
                }
                final PageFetcherSnapshotState.a<Key, Value> k = ((PageFetcherSnapshot)l$2).l;
                final kotlinx.coroutines.sync.c a5 = PageFetcherSnapshotState.a.a((PageFetcherSnapshotState.a<Object, Object>)k);
                pageFetcherSnapshot$doInitialLoad$1.L$0 = l$2;
                pageFetcherSnapshot$doInitialLoad$1.L$1 = o3;
                pageFetcherSnapshot$doInitialLoad$1.L$2 = k;
                pageFetcherSnapshot$doInitialLoad$1.L$3 = a5;
                pageFetcherSnapshot$doInitialLoad$1.label = 4;
                result = a5;
                if (a5.a((Object)null, (kotlin.coroutines.c)pageFetcherSnapshot$doInitialLoad$1) == d) {
                    return d;
                }
                try {
                    final PageFetcherSnapshotState b3 = PageFetcherSnapshotState.a.b((PageFetcherSnapshotState.a<Object, Object>)k);
                    final LoadType refresh2 = LoadType.REFRESH;
                    final boolean r = b3.r(0, refresh2, (PagingSource.b.c)o3);
                    final androidx.paging.p p = b3.p();
                    final androidx.paging.l.c.a b4 = androidx.paging.l.c.b;
                    p.c(refresh2, b4.b());
                    if (((PagingSource.b.c<?, ?>)o3).e() == null) {
                        b3.p().c(LoadType.PREPEND, b4.a());
                    }
                    if (((PagingSource.b.c<?, ?>)o3).d() == null) {
                        b3.p().c(LoadType.APPEND, b4.a());
                    }
                    ((kotlinx.coroutines.sync.c)result).b((Object)null);
                    if (r) {
                        final PageFetcherSnapshotState.a<Key, Value> j = ((PageFetcherSnapshot)l$2).l;
                        final kotlinx.coroutines.sync.c a6 = PageFetcherSnapshotState.a.a((PageFetcherSnapshotState.a<Object, Object>)j);
                        pageFetcherSnapshot$doInitialLoad$1.L$0 = l$2;
                        pageFetcherSnapshot$doInitialLoad$1.L$1 = o3;
                        pageFetcherSnapshot$doInitialLoad$1.L$2 = j;
                        pageFetcherSnapshot$doInitialLoad$1.L$3 = a6;
                        pageFetcherSnapshot$doInitialLoad$1.label = 5;
                        if (a6.a((Object)null, (kotlin.coroutines.c)pageFetcherSnapshot$doInitialLoad$1) == d) {
                            return d;
                        }
                        result = l$2;
                        final Object l$3 = o3;
                        final Object l$4 = a6;
                        final PageFetcherSnapshotState b5 = PageFetcherSnapshotState.a.b((PageFetcherSnapshotState.a<Object, Object>)j);
                        final d<u<Value>> k2 = ((PageFetcherSnapshot)result).k;
                        final u u = b5.u((PagingSource.b.c)l$3, LoadType.REFRESH);
                        pageFetcherSnapshot$doInitialLoad$1.L$0 = result;
                        pageFetcherSnapshot$doInitialLoad$1.L$1 = l$3;
                        pageFetcherSnapshot$doInitialLoad$1.L$2 = l$4;
                        pageFetcherSnapshot$doInitialLoad$1.L$3 = null;
                        pageFetcherSnapshot$doInitialLoad$1.label = 6;
                        if (((kotlinx.coroutines.channels.u)k2).z((Object)u, (kotlin.coroutines.c)pageFetcherSnapshot$doInitialLoad$1) == d) {
                            return d;
                        }
                        final r a7 = ka.r.a;
                        ((kotlinx.coroutines.sync.c)l$4).b((Object)null);
                        o3 = l$3;
                    }
                    else {
                        result = l$2;
                    }
                    if (((PageFetcherSnapshot)result).y() == null) {
                        return ka.r.a;
                    }
                    final PagingSource.b.c<?, ?> c6 = (PagingSource.b.c<?, ?>)o3;
                    if (c6.e() != null && c6.d() != null) {
                        return ka.r.a;
                    }
                    final PageFetcherSnapshotState.a<Key, Value> i = ((PageFetcherSnapshot)result).l;
                    Object a2 = PageFetcherSnapshotState.a.a((PageFetcherSnapshotState.a<Object, Object>)i);
                    pageFetcherSnapshot$doInitialLoad$1.L$0 = result;
                    pageFetcherSnapshot$doInitialLoad$1.L$1 = o3;
                    pageFetcherSnapshot$doInitialLoad$1.L$2 = i;
                    pageFetcherSnapshot$doInitialLoad$1.L$3 = a2;
                    pageFetcherSnapshot$doInitialLoad$1.label = 7;
                    if (((kotlinx.coroutines.sync.c)a2).a((Object)null, (kotlin.coroutines.c)pageFetcherSnapshot$doInitialLoad$1) == d) {
                        return d;
                    }
                    final PageFetcherSnapshot pageFetcherSnapshot5 = (PageFetcherSnapshot)result;
                    result = o3;
                    final Object o2 = pageFetcherSnapshot5;
                    try {
                        final z g = PageFetcherSnapshotState.a.b((PageFetcherSnapshotState.a<Object, Object>)i).g(((PageFetcherSnapshot)o2).i.b());
                        ((kotlinx.coroutines.sync.c)a2).b((Object)null);
                        a2 = result;
                        if (((PagingSource.b.c)a2).e() == null) {
                            ((PageFetcherSnapshot)o2).y().c(LoadType.PREPEND, g);
                        }
                        if (((PagingSource.b.c)a2).d() == null) {
                            ((PageFetcherSnapshot)o2).y().c(LoadType.APPEND, g);
                            return ka.r.a;
                        }
                        return ka.r.a;
                    }
                    finally {
                        ((kotlinx.coroutines.sync.c)a2).b((Object)null);
                    }
                    final kotlinx.coroutines.sync.c c2;
                    c2.b((Object)null);
                }
                finally {
                    ((kotlinx.coroutines.sync.c)result).b((Object)null);
                }
            }
            Object o;
            PageFetcherSnapshotState.a<Key, Value> l;
            if (o3 instanceof PagingSource.b.a) {
                l = ((PageFetcherSnapshot)l$2).l;
                final kotlinx.coroutines.sync.c a8 = PageFetcherSnapshotState.a.a((PageFetcherSnapshotState.a<Object, Object>)l);
                pageFetcherSnapshot$doInitialLoad$1.L$0 = l$2;
                pageFetcherSnapshot$doInitialLoad$1.L$1 = o3;
                pageFetcherSnapshot$doInitialLoad$1.L$2 = l;
                pageFetcherSnapshot$doInitialLoad$1.L$3 = a8;
                pageFetcherSnapshot$doInitialLoad$1.label = 8;
                o = o3;
                l$0 = a8;
                if (a8.a((Object)null, (kotlin.coroutines.c)pageFetcherSnapshot$doInitialLoad$1) == d) {
                    return d;
                }
            }
            else {
                if (o3 instanceof PagingSource.b.b) {
                    ((PageFetcherSnapshot)l$2).B();
                    return r.a;
                }
                return r.a;
            }
            try {
                final PageFetcherSnapshotState b6 = PageFetcherSnapshotState.a.b((PageFetcherSnapshotState.a<Object, Object>)l);
                final androidx.paging.l.a a9 = new androidx.paging.l.a(((PagingSource.b.a)o).a());
                final LoadType refresh3 = LoadType.REFRESH;
                pageFetcherSnapshot$doInitialLoad$1.L$0 = l$0;
                pageFetcherSnapshot$doInitialLoad$1.L$1 = null;
                pageFetcherSnapshot$doInitialLoad$1.L$2 = null;
                pageFetcherSnapshot$doInitialLoad$1.L$3 = null;
                pageFetcherSnapshot$doInitialLoad$1.label = 9;
                if (((PageFetcherSnapshot<Object, ?>)l$2).D(b6, refresh3, a9, (kotlin.coroutines.c<? super r>)pageFetcherSnapshot$doInitialLoad$1) == d) {
                    return d;
                }
                c7 = (kotlin.coroutines.c)l$0;
                l$0 = c7;
                final r a10 = r.a;
                ((kotlinx.coroutines.sync.c)c7).b((Object)null);
                return a10;
            }
            finally {}
        }
        ((kotlinx.coroutines.sync.c)l$0).b((Object)null);
        throw c7;
    }
    
    private final Object u(final LoadType p0, final androidx.paging.h p1, final kotlin.coroutines.c<? super r> p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          9
        //     3: aload_3        
        //     4: instanceof      Landroidx/paging/PageFetcherSnapshot$doLoad$1;
        //     7: ifeq            41
        //    10: aload_3        
        //    11: checkcast       Landroidx/paging/PageFetcherSnapshot$doLoad$1;
        //    14: astore_1       
        //    15: aload_1        
        //    16: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //    19: istore          4
        //    21: iload           4
        //    23: ldc             -2147483648
        //    25: iand           
        //    26: ifeq            41
        //    29: aload_1        
        //    30: iload           4
        //    32: ldc             -2147483648
        //    34: iadd           
        //    35: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //    38: goto            51
        //    41: new             Landroidx/paging/PageFetcherSnapshot$doLoad$1;
        //    44: dup            
        //    45: aload_0        
        //    46: aload_3        
        //    47: invokespecial   androidx/paging/PageFetcherSnapshot$doLoad$1.<init>:(Landroidx/paging/PageFetcherSnapshot;Lkotlin/coroutines/c;)V
        //    50: astore_1       
        //    51: aload_1        
        //    52: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.result:Ljava/lang/Object;
        //    55: astore          7
        //    57: invokestatic    kotlin/coroutines/intrinsics/a.d:()Ljava/lang/Object;
        //    60: astore          20
        //    62: aload_1        
        //    63: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //    66: tableswitch {
        //                0: 1082
        //                1: 1018
        //                2: 936
        //                3: 853
        //                4: 774
        //                5: 675
        //                6: 606
        //                7: 551
        //                8: 442
        //                9: 328
        //               10: 233
        //               11: 139
        //          default: 128
        //        }
        //   128: new             Ljava/lang/IllegalStateException;
        //   131: dup            
        //   132: ldc_w           "call to 'resume' before 'invoke' with coroutine"
        //   135: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   138: athrow         
        //   139: aload_1        
        //   140: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.I$1:I
        //   143: istore          5
        //   145: aload_1        
        //   146: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.I$0:I
        //   149: istore          4
        //   151: aload_1        
        //   152: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //   155: checkcast       Lkotlinx/coroutines/sync/c;
        //   158: astore          10
        //   160: aload_1        
        //   161: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //   164: checkcast       Landroidx/paging/PageFetcherSnapshotState$a;
        //   167: astore          11
        //   169: aload_1        
        //   170: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //   173: checkcast       Lkotlin/jvm/internal/Ref$BooleanRef;
        //   176: astore          9
        //   178: aload_1        
        //   179: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //   182: checkcast       Lkotlin/jvm/internal/Ref$ObjectRef;
        //   185: astore_2       
        //   186: aload_1        
        //   187: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //   190: checkcast       Lkotlin/jvm/internal/Ref$IntRef;
        //   193: astore          8
        //   195: aload_1        
        //   196: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //   199: checkcast       Landroidx/paging/h;
        //   202: astore          13
        //   204: aload_1        
        //   205: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //   208: checkcast       Landroidx/paging/LoadType;
        //   211: astore_3       
        //   212: aload_1        
        //   213: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //   216: checkcast       Landroidx/paging/PageFetcherSnapshot;
        //   219: astore          12
        //   221: aload           7
        //   223: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //   226: aload           13
        //   228: astore          7
        //   230: goto            3608
        //   233: aload_1        
        //   234: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$8:Ljava/lang/Object;
        //   237: checkcast       Lkotlinx/coroutines/sync/c;
        //   240: astore          13
        //   242: aload_1        
        //   243: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //   246: checkcast       Landroidx/paging/PagingSource$b;
        //   249: astore          18
        //   251: aload_1        
        //   252: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //   255: checkcast       Landroidx/paging/PagingSource$a;
        //   258: astore          17
        //   260: aload_1        
        //   261: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //   264: checkcast       Lkotlin/jvm/internal/Ref$BooleanRef;
        //   267: astore          11
        //   269: aload_1        
        //   270: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //   273: checkcast       Lkotlin/jvm/internal/Ref$ObjectRef;
        //   276: astore          10
        //   278: aload_1        
        //   279: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //   282: checkcast       Lkotlin/jvm/internal/Ref$IntRef;
        //   285: astore          8
        //   287: aload_1        
        //   288: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //   291: checkcast       Landroidx/paging/h;
        //   294: astore          12
        //   296: aload_1        
        //   297: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //   300: checkcast       Landroidx/paging/LoadType;
        //   303: astore_3       
        //   304: aload_1        
        //   305: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //   308: checkcast       Landroidx/paging/PageFetcherSnapshot;
        //   311: astore          9
        //   313: aload           13
        //   315: astore_2       
        //   316: aload           7
        //   318: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //   321: aload           12
        //   323: astore          7
        //   325: goto            3398
        //   328: aload_1        
        //   329: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$9:Ljava/lang/Object;
        //   332: checkcast       Landroidx/paging/PageFetcherSnapshotState;
        //   335: astore          12
        //   337: aload_1        
        //   338: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$8:Ljava/lang/Object;
        //   341: checkcast       Lkotlinx/coroutines/sync/c;
        //   344: astore_3       
        //   345: aload_1        
        //   346: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //   349: checkcast       Landroidx/paging/PagingSource$b;
        //   352: astore          8
        //   354: aload_1        
        //   355: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //   358: checkcast       Landroidx/paging/PagingSource$a;
        //   361: astore          11
        //   363: aload_1        
        //   364: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //   367: checkcast       Lkotlin/jvm/internal/Ref$BooleanRef;
        //   370: astore          9
        //   372: aload_1        
        //   373: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //   376: checkcast       Lkotlin/jvm/internal/Ref$ObjectRef;
        //   379: astore          10
        //   381: aload_1        
        //   382: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //   385: checkcast       Lkotlin/jvm/internal/Ref$IntRef;
        //   388: astore          13
        //   390: aload_1        
        //   391: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //   394: checkcast       Landroidx/paging/h;
        //   397: astore          14
        //   399: aload_1        
        //   400: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //   403: checkcast       Landroidx/paging/LoadType;
        //   406: astore          15
        //   408: aload_1        
        //   409: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //   412: checkcast       Landroidx/paging/PageFetcherSnapshot;
        //   415: astore          16
        //   417: aload_3        
        //   418: astore_2       
        //   419: aload           7
        //   421: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //   424: aload           12
        //   426: astore          7
        //   428: aload_1        
        //   429: astore          12
        //   431: goto            3071
        //   434: astore_3       
        //   435: aload_2        
        //   436: astore_1       
        //   437: aload_3        
        //   438: astore_2       
        //   439: goto            3746
        //   442: aload_1        
        //   443: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$10:Ljava/lang/Object;
        //   446: checkcast       Lkotlinx/coroutines/sync/c;
        //   449: astore_2       
        //   450: aload_1        
        //   451: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$9:Ljava/lang/Object;
        //   454: checkcast       Landroidx/paging/PageFetcherSnapshotState$a;
        //   457: astore          16
        //   459: aload_1        
        //   460: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$8:Ljava/lang/Object;
        //   463: checkcast       Landroidx/paging/LoadType;
        //   466: astore          18
        //   468: aload_1        
        //   469: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //   472: checkcast       Landroidx/paging/PagingSource$b;
        //   475: astore          13
        //   477: aload_1        
        //   478: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //   481: checkcast       Landroidx/paging/PagingSource$a;
        //   484: astore          12
        //   486: aload_1        
        //   487: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //   490: checkcast       Lkotlin/jvm/internal/Ref$BooleanRef;
        //   493: astore          11
        //   495: aload_1        
        //   496: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //   499: checkcast       Lkotlin/jvm/internal/Ref$ObjectRef;
        //   502: astore          10
        //   504: aload_1        
        //   505: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //   508: checkcast       Lkotlin/jvm/internal/Ref$IntRef;
        //   511: astore          9
        //   513: aload_1        
        //   514: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //   517: checkcast       Landroidx/paging/h;
        //   520: astore          14
        //   522: aload_1        
        //   523: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //   526: checkcast       Landroidx/paging/LoadType;
        //   529: astore_3       
        //   530: aload_1        
        //   531: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //   534: checkcast       Landroidx/paging/PageFetcherSnapshot;
        //   537: astore          8
        //   539: aload           7
        //   541: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //   544: aload           14
        //   546: astore          7
        //   548: goto            2857
        //   551: aload_1        
        //   552: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //   555: checkcast       Landroidx/paging/PageFetcherSnapshotState;
        //   558: astore          8
        //   560: aload_1        
        //   561: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //   564: checkcast       Lkotlinx/coroutines/sync/c;
        //   567: astore_3       
        //   568: aload_1        
        //   569: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //   572: checkcast       Landroidx/paging/h;
        //   575: astore          9
        //   577: aload_1        
        //   578: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //   581: checkcast       Landroidx/paging/LoadType;
        //   584: astore_1       
        //   585: aload_3        
        //   586: astore_2       
        //   587: aload           7
        //   589: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //   592: aload_1        
        //   593: astore          7
        //   595: aload_3        
        //   596: astore_1       
        //   597: goto            2604
        //   600: astore_3       
        //   601: aload_2        
        //   602: astore_1       
        //   603: goto            2640
        //   606: aload_1        
        //   607: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //   610: checkcast       Lkotlinx/coroutines/sync/c;
        //   613: astore_2       
        //   614: aload_1        
        //   615: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //   618: checkcast       Landroidx/paging/PageFetcherSnapshotState$a;
        //   621: astore          11
        //   623: aload_1        
        //   624: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //   627: checkcast       Landroidx/paging/PagingSource$b;
        //   630: astore          9
        //   632: aload_1        
        //   633: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //   636: checkcast       Landroidx/paging/h;
        //   639: astore          8
        //   641: aload_1        
        //   642: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //   645: checkcast       Landroidx/paging/LoadType;
        //   648: astore_3       
        //   649: aload_1        
        //   650: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //   653: checkcast       Landroidx/paging/PageFetcherSnapshot;
        //   656: astore          10
        //   658: aload           7
        //   660: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //   663: aload           8
        //   665: astore          7
        //   667: aload_1        
        //   668: astore          8
        //   670: aload_2        
        //   671: astore_1       
        //   672: goto            2485
        //   675: aload_1        
        //   676: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$9:Ljava/lang/Object;
        //   679: checkcast       Lkotlinx/coroutines/sync/c;
        //   682: astore          14
        //   684: aload_1        
        //   685: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$8:Ljava/lang/Object;
        //   688: checkcast       Landroidx/paging/PageFetcherSnapshotState$a;
        //   691: astore          15
        //   693: aload_1        
        //   694: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //   697: checkcast       Landroidx/paging/PagingSource$b;
        //   700: astore          13
        //   702: aload_1        
        //   703: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //   706: checkcast       Landroidx/paging/PagingSource$a;
        //   709: astore          12
        //   711: aload_1        
        //   712: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //   715: checkcast       Lkotlin/jvm/internal/Ref$BooleanRef;
        //   718: astore          10
        //   720: aload_1        
        //   721: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //   724: checkcast       Lkotlin/jvm/internal/Ref$ObjectRef;
        //   727: astore          8
        //   729: aload_1        
        //   730: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //   733: checkcast       Lkotlin/jvm/internal/Ref$IntRef;
        //   736: astore          9
        //   738: aload_1        
        //   739: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //   742: checkcast       Landroidx/paging/h;
        //   745: astore_3       
        //   746: aload_1        
        //   747: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //   750: checkcast       Landroidx/paging/LoadType;
        //   753: astore_2       
        //   754: aload_1        
        //   755: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //   758: checkcast       Landroidx/paging/PageFetcherSnapshot;
        //   761: astore          11
        //   763: aload           7
        //   765: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //   768: aload_1        
        //   769: astore          7
        //   771: goto            2228
        //   774: aload_1        
        //   775: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //   778: checkcast       Landroidx/paging/PagingSource$a;
        //   781: astore          12
        //   783: aload_1        
        //   784: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //   787: checkcast       Lkotlin/jvm/internal/Ref$BooleanRef;
        //   790: astore          10
        //   792: aload_1        
        //   793: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //   796: checkcast       Lkotlin/jvm/internal/Ref$ObjectRef;
        //   799: astore          8
        //   801: aload_1        
        //   802: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //   805: checkcast       Lkotlin/jvm/internal/Ref$IntRef;
        //   808: astore          9
        //   810: aload_1        
        //   811: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //   814: checkcast       Landroidx/paging/h;
        //   817: astore_2       
        //   818: aload_1        
        //   819: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //   822: checkcast       Landroidx/paging/LoadType;
        //   825: astore          11
        //   827: aload_1        
        //   828: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //   831: checkcast       Landroidx/paging/PageFetcherSnapshot;
        //   834: astore_3       
        //   835: aload           7
        //   837: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //   840: aload           7
        //   842: astore          13
        //   844: aload_1        
        //   845: astore          7
        //   847: aload           11
        //   849: astore_1       
        //   850: goto            1916
        //   853: aload_1        
        //   854: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //   857: checkcast       Lkotlin/jvm/internal/Ref$ObjectRef;
        //   860: astore_3       
        //   861: aload_1        
        //   862: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //   865: astore          12
        //   867: aload_1        
        //   868: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //   871: checkcast       Lkotlinx/coroutines/sync/c;
        //   874: astore_2       
        //   875: aload_1        
        //   876: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //   879: checkcast       Lkotlin/jvm/internal/Ref$ObjectRef;
        //   882: astore          11
        //   884: aload_1        
        //   885: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //   888: checkcast       Lkotlin/jvm/internal/Ref$IntRef;
        //   891: astore          8
        //   893: aload_1        
        //   894: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //   897: checkcast       Landroidx/paging/h;
        //   900: astore          10
        //   902: aload_1        
        //   903: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //   906: checkcast       Landroidx/paging/LoadType;
        //   909: astore          9
        //   911: aload_1        
        //   912: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //   915: checkcast       Landroidx/paging/PageFetcherSnapshot;
        //   918: astore          13
        //   920: aload           7
        //   922: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //   925: aload           13
        //   927: astore          7
        //   929: goto            1736
        //   932: astore_1       
        //   933: goto            3763
        //   936: aload_1        
        //   937: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //   940: checkcast       Lkotlin/jvm/internal/Ref$ObjectRef;
        //   943: astore_3       
        //   944: aload_1        
        //   945: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //   948: checkcast       Lkotlinx/coroutines/sync/c;
        //   951: astore_2       
        //   952: aload_1        
        //   953: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //   956: checkcast       Landroidx/paging/PageFetcherSnapshotState$a;
        //   959: astore          12
        //   961: aload_1        
        //   962: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //   965: checkcast       Lkotlin/jvm/internal/Ref$ObjectRef;
        //   968: astore          11
        //   970: aload_1        
        //   971: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //   974: checkcast       Lkotlin/jvm/internal/Ref$IntRef;
        //   977: astore          8
        //   979: aload_1        
        //   980: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //   983: checkcast       Landroidx/paging/h;
        //   986: astore          10
        //   988: aload_1        
        //   989: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //   992: checkcast       Landroidx/paging/LoadType;
        //   995: astore          9
        //   997: aload_1        
        //   998: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  1001: checkcast       Landroidx/paging/PageFetcherSnapshot;
        //  1004: astore          13
        //  1006: aload           7
        //  1008: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //  1011: aload           13
        //  1013: astore          7
        //  1015: goto            1607
        //  1018: aload_1        
        //  1019: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  1022: checkcast       Lkotlinx/coroutines/sync/c;
        //  1025: astore          10
        //  1027: aload_1        
        //  1028: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  1031: checkcast       Landroidx/paging/PageFetcherSnapshotState$a;
        //  1034: astore          11
        //  1036: aload_1        
        //  1037: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  1040: checkcast       Lkotlin/jvm/internal/Ref$IntRef;
        //  1043: astore_2       
        //  1044: aload_1        
        //  1045: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  1048: checkcast       Landroidx/paging/h;
        //  1051: astore          9
        //  1053: aload_1        
        //  1054: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  1057: checkcast       Landroidx/paging/LoadType;
        //  1060: astore_3       
        //  1061: aload_1        
        //  1062: getfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  1065: checkcast       Landroidx/paging/PageFetcherSnapshot;
        //  1068: astore          8
        //  1070: aload           7
        //  1072: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //  1075: aload           9
        //  1077: astore          7
        //  1079: goto            1196
        //  1082: aload           7
        //  1084: invokestatic    ka/k.b:(Ljava/lang/Object;)V
        //  1087: aload           9
        //  1089: getstatic       androidx/paging/LoadType.REFRESH:Landroidx/paging/LoadType;
        //  1092: if_acmpeq       1101
        //  1095: iconst_1       
        //  1096: istore          4
        //  1098: goto            1104
        //  1101: iconst_0       
        //  1102: istore          4
        //  1104: iload           4
        //  1106: ifeq            3796
        //  1109: new             Lkotlin/jvm/internal/Ref$IntRef;
        //  1112: dup            
        //  1113: invokespecial   kotlin/jvm/internal/Ref$IntRef.<init>:()V
        //  1116: astore_3       
        //  1117: aload_0        
        //  1118: getfield        androidx/paging/PageFetcherSnapshot.l:Landroidx/paging/PageFetcherSnapshotState$a;
        //  1121: astore          11
        //  1123: aload           11
        //  1125: invokestatic    androidx/paging/PageFetcherSnapshotState$a.a:(Landroidx/paging/PageFetcherSnapshotState$a;)Lkotlinx/coroutines/sync/c;
        //  1128: astore          10
        //  1130: aload_1        
        //  1131: aload_0        
        //  1132: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  1135: aload_1        
        //  1136: aload           9
        //  1138: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  1141: aload_1        
        //  1142: aload_2        
        //  1143: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  1146: aload_1        
        //  1147: aload_3        
        //  1148: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  1151: aload_1        
        //  1152: aload           11
        //  1154: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  1157: aload_1        
        //  1158: aload           10
        //  1160: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  1163: aload_1        
        //  1164: iconst_1       
        //  1165: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //  1168: aload           10
        //  1170: aconst_null    
        //  1171: aload_1        
        //  1172: invokeinterface kotlinx/coroutines/sync/c.a:(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //  1177: aload           20
        //  1179: if_acmpne       1185
        //  1182: aload           20
        //  1184: areturn        
        //  1185: aload_0        
        //  1186: astore          8
        //  1188: aload_2        
        //  1189: astore          7
        //  1191: aload_3        
        //  1192: astore_2       
        //  1193: aload           9
        //  1195: astore_3       
        //  1196: aload           11
        //  1198: invokestatic    androidx/paging/PageFetcherSnapshotState$a.b:(Landroidx/paging/PageFetcherSnapshotState$a;)Landroidx/paging/PageFetcherSnapshotState;
        //  1201: astore          9
        //  1203: getstatic       androidx/paging/PageFetcherSnapshot$a.a:[I
        //  1206: aload_3        
        //  1207: invokevirtual   java/lang/Enum.ordinal:()I
        //  1210: iaload         
        //  1211: istore          4
        //  1213: iload           4
        //  1215: iconst_1       
        //  1216: if_icmpeq       3772
        //  1219: iload           4
        //  1221: iconst_2       
        //  1222: if_icmpeq       1350
        //  1225: iload           4
        //  1227: iconst_3       
        //  1228: if_icmpeq       1234
        //  1231: goto            1480
        //  1234: aload           9
        //  1236: invokevirtual   androidx/paging/PageFetcherSnapshotState.l:()I
        //  1239: aload           7
        //  1241: invokevirtual   androidx/paging/h.b:()Landroidx/paging/g0;
        //  1244: invokevirtual   androidx/paging/g0.b:()I
        //  1247: iadd           
        //  1248: iconst_1       
        //  1249: iadd           
        //  1250: istore          5
        //  1252: iload           5
        //  1254: istore          4
        //  1256: iload           5
        //  1258: ifge            1285
        //  1261: aload_2        
        //  1262: aload_2        
        //  1263: getfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  1266: aload           8
        //  1268: getfield        androidx/paging/PageFetcherSnapshot.c:Landroidx/paging/x;
        //  1271: getfield        androidx/paging/x.a:I
        //  1274: iload           5
        //  1276: ineg           
        //  1277: imul           
        //  1278: iadd           
        //  1279: putfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  1282: iconst_0       
        //  1283: istore          4
        //  1285: aload           9
        //  1287: invokevirtual   androidx/paging/PageFetcherSnapshotState.m:()Ljava/util/List;
        //  1290: invokestatic    kotlin/collections/o.l:(Ljava/util/List;)I
        //  1293: istore          5
        //  1295: iload           4
        //  1297: iload           5
        //  1299: if_icmpgt       1480
        //  1302: aload_2        
        //  1303: aload_2        
        //  1304: getfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  1307: aload           9
        //  1309: invokevirtual   androidx/paging/PageFetcherSnapshotState.m:()Ljava/util/List;
        //  1312: iload           4
        //  1314: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1319: checkcast       Landroidx/paging/PagingSource$b$c;
        //  1322: invokevirtual   androidx/paging/PagingSource$b$c.a:()Ljava/util/List;
        //  1325: invokeinterface java/util/List.size:()I
        //  1330: iadd           
        //  1331: putfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  1334: iload           4
        //  1336: iload           5
        //  1338: if_icmpne       1344
        //  1341: goto            1480
        //  1344: iinc            4, 1
        //  1347: goto            1302
        //  1350: aload           9
        //  1352: invokevirtual   androidx/paging/PageFetcherSnapshotState.l:()I
        //  1355: aload           7
        //  1357: invokevirtual   androidx/paging/h.b:()Landroidx/paging/g0;
        //  1360: invokevirtual   androidx/paging/g0.a:()I
        //  1363: iadd           
        //  1364: iconst_1       
        //  1365: isub           
        //  1366: istore          5
        //  1368: iload           5
        //  1370: istore          4
        //  1372: iload           5
        //  1374: aload           9
        //  1376: invokevirtual   androidx/paging/PageFetcherSnapshotState.m:()Ljava/util/List;
        //  1379: invokestatic    kotlin/collections/o.l:(Ljava/util/List;)I
        //  1382: if_icmple       1424
        //  1385: aload_2        
        //  1386: aload_2        
        //  1387: getfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  1390: aload           8
        //  1392: getfield        androidx/paging/PageFetcherSnapshot.c:Landroidx/paging/x;
        //  1395: getfield        androidx/paging/x.a:I
        //  1398: iload           5
        //  1400: aload           9
        //  1402: invokevirtual   androidx/paging/PageFetcherSnapshotState.m:()Ljava/util/List;
        //  1405: invokestatic    kotlin/collections/o.l:(Ljava/util/List;)I
        //  1408: isub           
        //  1409: imul           
        //  1410: iadd           
        //  1411: putfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  1414: aload           9
        //  1416: invokevirtual   androidx/paging/PageFetcherSnapshotState.m:()Ljava/util/List;
        //  1419: invokestatic    kotlin/collections/o.l:(Ljava/util/List;)I
        //  1422: istore          4
        //  1424: iload           4
        //  1426: iflt            1480
        //  1429: iconst_0       
        //  1430: istore          5
        //  1432: aload_2        
        //  1433: aload_2        
        //  1434: getfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  1437: aload           9
        //  1439: invokevirtual   androidx/paging/PageFetcherSnapshotState.m:()Ljava/util/List;
        //  1442: iload           5
        //  1444: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1449: checkcast       Landroidx/paging/PagingSource$b$c;
        //  1452: invokevirtual   androidx/paging/PagingSource$b$c.a:()Ljava/util/List;
        //  1455: invokeinterface java/util/List.size:()I
        //  1460: iadd           
        //  1461: putfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  1464: iload           5
        //  1466: iload           4
        //  1468: if_icmpne       1474
        //  1471: goto            1480
        //  1474: iinc            5, 1
        //  1477: goto            1432
        //  1480: getstatic       ka/r.a:Lka/r;
        //  1483: astore          9
        //  1485: aload           10
        //  1487: aconst_null    
        //  1488: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  1493: new             Lkotlin/jvm/internal/Ref$ObjectRef;
        //  1496: dup            
        //  1497: invokespecial   kotlin/jvm/internal/Ref$ObjectRef.<init>:()V
        //  1500: astore          10
        //  1502: aload           8
        //  1504: getfield        androidx/paging/PageFetcherSnapshot.l:Landroidx/paging/PageFetcherSnapshotState$a;
        //  1507: astore          12
        //  1509: aload           12
        //  1511: invokestatic    androidx/paging/PageFetcherSnapshotState$a.a:(Landroidx/paging/PageFetcherSnapshotState$a;)Lkotlinx/coroutines/sync/c;
        //  1514: astore          13
        //  1516: aload_1        
        //  1517: aload           8
        //  1519: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  1522: aload_1        
        //  1523: aload_3        
        //  1524: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  1527: aload_1        
        //  1528: aload           7
        //  1530: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  1533: aload_1        
        //  1534: aload_2        
        //  1535: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  1538: aload_1        
        //  1539: aload           10
        //  1541: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  1544: aload_1        
        //  1545: aload           12
        //  1547: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  1550: aload_1        
        //  1551: aload           13
        //  1553: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //  1556: aload_1        
        //  1557: aload           10
        //  1559: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //  1562: aload_1        
        //  1563: iconst_2       
        //  1564: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //  1567: aload           13
        //  1569: aconst_null    
        //  1570: aload_1        
        //  1571: invokeinterface kotlinx/coroutines/sync/c.a:(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //  1576: aload           20
        //  1578: if_acmpne       1584
        //  1581: aload           20
        //  1583: areturn        
        //  1584: aload_3        
        //  1585: astore          9
        //  1587: aload           10
        //  1589: astore_3       
        //  1590: aload           7
        //  1592: astore          10
        //  1594: aload_3        
        //  1595: astore          11
        //  1597: aload           8
        //  1599: astore          7
        //  1601: aload_2        
        //  1602: astore          8
        //  1604: aload           13
        //  1606: astore_2       
        //  1607: aload           12
        //  1609: invokestatic    androidx/paging/PageFetcherSnapshotState$a.b:(Landroidx/paging/PageFetcherSnapshotState$a;)Landroidx/paging/PageFetcherSnapshotState;
        //  1612: astore          13
        //  1614: aload           7
        //  1616: aload           13
        //  1618: aload           9
        //  1620: aload           10
        //  1622: invokevirtual   androidx/paging/h.a:()I
        //  1625: aload           10
        //  1627: invokevirtual   androidx/paging/h.b:()Landroidx/paging/g0;
        //  1630: aload           9
        //  1632: invokevirtual   androidx/paging/g0.e:(Landroidx/paging/LoadType;)I
        //  1635: aload           8
        //  1637: getfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  1640: iadd           
        //  1641: invokespecial   androidx/paging/PageFetcherSnapshot.A:(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;II)Ljava/lang/Object;
        //  1644: astore          12
        //  1646: aload           12
        //  1648: ifnonnull       1663
        //  1651: aconst_null    
        //  1652: astore          13
        //  1654: aload_2        
        //  1655: astore          12
        //  1657: aload           11
        //  1659: astore_2       
        //  1660: goto            1746
        //  1663: aload_1        
        //  1664: aload           7
        //  1666: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  1669: aload_1        
        //  1670: aload           9
        //  1672: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  1675: aload_1        
        //  1676: aload           10
        //  1678: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  1681: aload_1        
        //  1682: aload           8
        //  1684: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  1687: aload_1        
        //  1688: aload           11
        //  1690: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  1693: aload_1        
        //  1694: aload_2        
        //  1695: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  1698: aload_1        
        //  1699: aload           12
        //  1701: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //  1704: aload_1        
        //  1705: aload_3        
        //  1706: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //  1709: aload_1        
        //  1710: iconst_3       
        //  1711: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //  1714: aload           7
        //  1716: aload           13
        //  1718: aload           9
        //  1720: aload_1        
        //  1721: invokespecial   androidx/paging/PageFetcherSnapshot.E:(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //  1724: astore          13
        //  1726: aload           13
        //  1728: aload           20
        //  1730: if_acmpne       1736
        //  1733: aload           20
        //  1735: areturn        
        //  1736: aload           12
        //  1738: astore          13
        //  1740: aload_2        
        //  1741: astore          12
        //  1743: aload           11
        //  1745: astore_2       
        //  1746: aload           12
        //  1748: aconst_null    
        //  1749: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  1754: aload_3        
        //  1755: aload           13
        //  1757: putfield        kotlin/jvm/internal/Ref$ObjectRef.element:Ljava/lang/Object;
        //  1760: new             Lkotlin/jvm/internal/Ref$BooleanRef;
        //  1763: dup            
        //  1764: invokespecial   kotlin/jvm/internal/Ref$BooleanRef.<init>:()V
        //  1767: astore          12
        //  1769: aload           7
        //  1771: astore_3       
        //  1772: aload           10
        //  1774: astore          7
        //  1776: aload_1        
        //  1777: astore          11
        //  1779: aload           12
        //  1781: astore          10
        //  1783: aload_2        
        //  1784: getfield        kotlin/jvm/internal/Ref$ObjectRef.element:Ljava/lang/Object;
        //  1787: astore_1       
        //  1788: aload_1        
        //  1789: ifnull          3755
        //  1792: aload_3        
        //  1793: aload           9
        //  1795: aload_1        
        //  1796: invokespecial   androidx/paging/PageFetcherSnapshot.z:(Landroidx/paging/LoadType;Ljava/lang/Object;)Landroidx/paging/PagingSource$a;
        //  1799: astore          12
        //  1801: aload_3        
        //  1802: invokevirtual   androidx/paging/PageFetcherSnapshot.x:()Landroidx/paging/PagingSource;
        //  1805: astore_1       
        //  1806: aload           11
        //  1808: aload_3        
        //  1809: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  1812: aload           11
        //  1814: aload           9
        //  1816: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  1819: aload           11
        //  1821: aload           7
        //  1823: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  1826: aload           11
        //  1828: aload           8
        //  1830: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  1833: aload           11
        //  1835: aload_2        
        //  1836: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  1839: aload           11
        //  1841: aload           10
        //  1843: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  1846: aload           11
        //  1848: aload           12
        //  1850: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //  1853: aload           11
        //  1855: aconst_null    
        //  1856: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //  1859: aload           11
        //  1861: aconst_null    
        //  1862: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$8:Ljava/lang/Object;
        //  1865: aload           11
        //  1867: iconst_4       
        //  1868: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //  1871: aload_1        
        //  1872: aload           12
        //  1874: aload           11
        //  1876: invokevirtual   androidx/paging/PagingSource.load:(Landroidx/paging/PagingSource$a;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //  1879: astore          13
        //  1881: aload           13
        //  1883: aload           20
        //  1885: if_acmpne       1891
        //  1888: aload           20
        //  1890: areturn        
        //  1891: aload           9
        //  1893: astore_1       
        //  1894: aload           7
        //  1896: astore          9
        //  1898: aload_2        
        //  1899: astore          7
        //  1901: aload           9
        //  1903: astore_2       
        //  1904: aload           8
        //  1906: astore          9
        //  1908: aload           7
        //  1910: astore          8
        //  1912: aload           11
        //  1914: astore          7
        //  1916: aload           13
        //  1918: checkcast       Landroidx/paging/PagingSource$b;
        //  1921: astore          13
        //  1923: aload           13
        //  1925: instanceof      Landroidx/paging/PagingSource$b$c;
        //  1928: ifeq            2371
        //  1931: getstatic       androidx/paging/PageFetcherSnapshot$a.a:[I
        //  1934: aload_1        
        //  1935: invokevirtual   java/lang/Enum.ordinal:()I
        //  1938: iaload         
        //  1939: istore          4
        //  1941: iload           4
        //  1943: iconst_2       
        //  1944: if_icmpeq       1977
        //  1947: iload           4
        //  1949: iconst_3       
        //  1950: if_icmpne       1966
        //  1953: aload           13
        //  1955: checkcast       Landroidx/paging/PagingSource$b$c;
        //  1958: invokevirtual   androidx/paging/PagingSource$b$c.d:()Ljava/lang/Object;
        //  1961: astore          11
        //  1963: goto            1987
        //  1966: new             Ljava/lang/IllegalArgumentException;
        //  1969: dup            
        //  1970: ldc_w           "Use doInitialLoad for LoadType == REFRESH"
        //  1973: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //  1976: athrow         
        //  1977: aload           13
        //  1979: checkcast       Landroidx/paging/PagingSource$b$c;
        //  1982: invokevirtual   androidx/paging/PagingSource$b$c.e:()Ljava/lang/Object;
        //  1985: astore          11
        //  1987: aload_3        
        //  1988: invokevirtual   androidx/paging/PageFetcherSnapshot.x:()Landroidx/paging/PagingSource;
        //  1991: invokevirtual   androidx/paging/PagingSource.getKeyReuseSupported:()Z
        //  1994: ifne            2019
        //  1997: aload           11
        //  1999: aload           8
        //  2001: getfield        kotlin/jvm/internal/Ref$ObjectRef.element:Ljava/lang/Object;
        //  2004: invokestatic    kotlin/jvm/internal/o.b:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2007: ifne            2013
        //  2010: goto            2019
        //  2013: iconst_0       
        //  2014: istore          4
        //  2016: goto            2022
        //  2019: iconst_1       
        //  2020: istore          4
        //  2022: iload           4
        //  2024: ifne            2114
        //  2027: aload_1        
        //  2028: getstatic       androidx/paging/LoadType.PREPEND:Landroidx/paging/LoadType;
        //  2031: if_acmpne       2041
        //  2034: ldc_w           "prevKey"
        //  2037: astore_1       
        //  2038: goto            2045
        //  2041: ldc_w           "nextKey"
        //  2044: astore_1       
        //  2045: new             Ljava/lang/StringBuilder;
        //  2048: dup            
        //  2049: invokespecial   java/lang/StringBuilder.<init>:()V
        //  2052: astore_2       
        //  2053: aload_2        
        //  2054: ldc_w           "The same value, "
        //  2057: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2060: pop            
        //  2061: aload_2        
        //  2062: aload           8
        //  2064: getfield        kotlin/jvm/internal/Ref$ObjectRef.element:Ljava/lang/Object;
        //  2067: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //  2070: pop            
        //  2071: aload_2        
        //  2072: ldc_w           ", was passed as the "
        //  2075: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2078: pop            
        //  2079: aload_2        
        //  2080: aload_1        
        //  2081: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2084: pop            
        //  2085: aload_2        
        //  2086: ldc_w           " in two\n                            | sequential Pages loaded from a PagingSource. Re-using load keys in\n                            | PagingSource is often an error, and must be explicitly enabled by\n                            | overriding PagingSource.keyReuseSupported.\n                            "
        //  2089: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2092: pop            
        //  2093: new             Ljava/lang/IllegalStateException;
        //  2096: dup            
        //  2097: aload_2        
        //  2098: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  2101: aconst_null    
        //  2102: iconst_1       
        //  2103: aconst_null    
        //  2104: invokestatic    kotlin/text/l.i:(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/String;
        //  2107: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //  2110: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //  2113: athrow         
        //  2114: aload_3        
        //  2115: getfield        androidx/paging/PageFetcherSnapshot.l:Landroidx/paging/PageFetcherSnapshotState$a;
        //  2118: astore          15
        //  2120: aload           15
        //  2122: invokestatic    androidx/paging/PageFetcherSnapshotState$a.a:(Landroidx/paging/PageFetcherSnapshotState$a;)Lkotlinx/coroutines/sync/c;
        //  2125: astore          14
        //  2127: aload           7
        //  2129: aload_3        
        //  2130: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  2133: aload           7
        //  2135: aload_1        
        //  2136: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  2139: aload           7
        //  2141: aload_2        
        //  2142: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  2145: aload           7
        //  2147: aload           9
        //  2149: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  2152: aload           7
        //  2154: aload           8
        //  2156: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  2159: aload           7
        //  2161: aload           10
        //  2163: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  2166: aload           7
        //  2168: aload           12
        //  2170: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //  2173: aload           7
        //  2175: aload           13
        //  2177: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //  2180: aload           7
        //  2182: aload           15
        //  2184: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$8:Ljava/lang/Object;
        //  2187: aload           7
        //  2189: aload           14
        //  2191: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$9:Ljava/lang/Object;
        //  2194: aload           7
        //  2196: iconst_5       
        //  2197: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //  2200: aload           14
        //  2202: aconst_null    
        //  2203: aload           7
        //  2205: invokeinterface kotlinx/coroutines/sync/c.a:(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //  2210: aload           20
        //  2212: if_acmpne       2218
        //  2215: aload           20
        //  2217: areturn        
        //  2218: aload_3        
        //  2219: astore          11
        //  2221: aload_2        
        //  2222: astore_3       
        //  2223: aload_1        
        //  2224: astore_2       
        //  2225: goto            771
        //  2228: aload           15
        //  2230: invokestatic    androidx/paging/PageFetcherSnapshotState$a.b:(Landroidx/paging/PageFetcherSnapshotState$a;)Landroidx/paging/PageFetcherSnapshotState;
        //  2233: aload_3        
        //  2234: invokevirtual   androidx/paging/h.a:()I
        //  2237: aload_2        
        //  2238: aload           13
        //  2240: checkcast       Landroidx/paging/PagingSource$b$c;
        //  2243: invokevirtual   androidx/paging/PageFetcherSnapshotState.r:(ILandroidx/paging/LoadType;Landroidx/paging/PagingSource$b$c;)Z
        //  2246: istore          6
        //  2248: aload           14
        //  2250: aconst_null    
        //  2251: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  2256: iload           6
        //  2258: ifne            2264
        //  2261: goto            3755
        //  2264: aload           9
        //  2266: getfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  2269: istore          4
        //  2271: aload           13
        //  2273: checkcast       Landroidx/paging/PagingSource$b$c;
        //  2276: astore_1       
        //  2277: aload           9
        //  2279: iload           4
        //  2281: aload_1        
        //  2282: invokevirtual   androidx/paging/PagingSource$b$c.a:()Ljava/util/List;
        //  2285: invokeinterface java/util/List.size:()I
        //  2290: iadd           
        //  2291: putfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  2294: aload_2        
        //  2295: getstatic       androidx/paging/LoadType.PREPEND:Landroidx/paging/LoadType;
        //  2298: if_acmpne       2314
        //  2301: aload_1        
        //  2302: invokevirtual   androidx/paging/PagingSource$b$c.e:()Ljava/lang/Object;
        //  2305: ifnull          2311
        //  2308: goto            2314
        //  2311: goto            2331
        //  2314: aload_2        
        //  2315: getstatic       androidx/paging/LoadType.APPEND:Landroidx/paging/LoadType;
        //  2318: if_acmpne       2340
        //  2321: aload_1        
        //  2322: invokevirtual   androidx/paging/PagingSource$b$c.d:()Ljava/lang/Object;
        //  2325: ifnonnull       2340
        //  2328: goto            2311
        //  2331: aload           10
        //  2333: iconst_1       
        //  2334: putfield        kotlin/jvm/internal/Ref$BooleanRef.element:Z
        //  2337: goto            2340
        //  2340: aload           11
        //  2342: astore_1       
        //  2343: aload           13
        //  2345: astore          11
        //  2347: aload           7
        //  2349: astore          14
        //  2351: aload_1        
        //  2352: astore          7
        //  2354: aload_3        
        //  2355: astore          15
        //  2357: goto            2681
        //  2360: astore_1       
        //  2361: aload           14
        //  2363: aconst_null    
        //  2364: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  2369: aload_1        
        //  2370: athrow         
        //  2371: aload           13
        //  2373: instanceof      Landroidx/paging/PagingSource$b$a;
        //  2376: ifeq            2649
        //  2379: aload_3        
        //  2380: getfield        androidx/paging/PageFetcherSnapshot.l:Landroidx/paging/PageFetcherSnapshotState$a;
        //  2383: astore          11
        //  2385: aload           11
        //  2387: invokestatic    androidx/paging/PageFetcherSnapshotState$a.a:(Landroidx/paging/PageFetcherSnapshotState$a;)Lkotlinx/coroutines/sync/c;
        //  2390: astore          12
        //  2392: aload           7
        //  2394: aload_3        
        //  2395: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  2398: aload           7
        //  2400: aload_1        
        //  2401: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  2404: aload           7
        //  2406: aload_2        
        //  2407: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  2410: aload           7
        //  2412: aload           13
        //  2414: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  2417: aload           7
        //  2419: aload           11
        //  2421: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  2424: aload           7
        //  2426: aload           12
        //  2428: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  2431: aload           7
        //  2433: aconst_null    
        //  2434: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //  2437: aload           7
        //  2439: bipush          6
        //  2441: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //  2444: aload           12
        //  2446: aconst_null    
        //  2447: aload           7
        //  2449: invokeinterface kotlinx/coroutines/sync/c.a:(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //  2454: aload           20
        //  2456: if_acmpne       2462
        //  2459: aload           20
        //  2461: areturn        
        //  2462: aload           13
        //  2464: astore          9
        //  2466: aload           7
        //  2468: astore          8
        //  2470: aload_1        
        //  2471: astore          13
        //  2473: aload_2        
        //  2474: astore          7
        //  2476: aload_3        
        //  2477: astore          10
        //  2479: aload           12
        //  2481: astore_1       
        //  2482: aload           13
        //  2484: astore_3       
        //  2485: aload_1        
        //  2486: astore_2       
        //  2487: aload           11
        //  2489: invokestatic    androidx/paging/PageFetcherSnapshotState$a.b:(Landroidx/paging/PageFetcherSnapshotState$a;)Landroidx/paging/PageFetcherSnapshotState;
        //  2492: astore          11
        //  2494: aload_1        
        //  2495: astore_2       
        //  2496: new             Landroidx/paging/l$a;
        //  2499: astore          12
        //  2501: aload_1        
        //  2502: astore_2       
        //  2503: aload           12
        //  2505: aload           9
        //  2507: checkcast       Landroidx/paging/PagingSource$b$a;
        //  2510: invokevirtual   androidx/paging/PagingSource$b$a.a:()Ljava/lang/Throwable;
        //  2513: invokespecial   androidx/paging/l$a.<init>:(Ljava/lang/Throwable;)V
        //  2516: aload_1        
        //  2517: astore_2       
        //  2518: aload           8
        //  2520: aload_3        
        //  2521: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  2524: aload_1        
        //  2525: astore_2       
        //  2526: aload           8
        //  2528: aload           7
        //  2530: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  2533: aload_1        
        //  2534: astore_2       
        //  2535: aload           8
        //  2537: aload_1        
        //  2538: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  2541: aload_1        
        //  2542: astore_2       
        //  2543: aload           8
        //  2545: aload           11
        //  2547: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  2550: aload           8
        //  2552: aconst_null    
        //  2553: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  2556: aload           8
        //  2558: aconst_null    
        //  2559: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  2562: aload_1        
        //  2563: astore_2       
        //  2564: aload           8
        //  2566: bipush          7
        //  2568: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //  2571: aload_1        
        //  2572: astore_2       
        //  2573: aload           10
        //  2575: aload           11
        //  2577: aload_3        
        //  2578: aload           12
        //  2580: aload           8
        //  2582: invokespecial   androidx/paging/PageFetcherSnapshot.D:(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Landroidx/paging/l$a;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //  2585: aload           20
        //  2587: if_acmpne       2593
        //  2590: aload           20
        //  2592: areturn        
        //  2593: aload           11
        //  2595: astore          8
        //  2597: aload           7
        //  2599: astore          9
        //  2601: aload_3        
        //  2602: astore          7
        //  2604: aload_1        
        //  2605: astore_2       
        //  2606: aload           8
        //  2608: invokevirtual   androidx/paging/PageFetcherSnapshotState.k:()Ljava/util/Map;
        //  2611: aload           7
        //  2613: aload           9
        //  2615: invokevirtual   androidx/paging/h.b:()Landroidx/paging/g0;
        //  2618: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2623: pop            
        //  2624: aload_1        
        //  2625: astore_2       
        //  2626: getstatic       ka/r.a:Lka/r;
        //  2629: astore_3       
        //  2630: aload_1        
        //  2631: aconst_null    
        //  2632: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  2637: aload_3        
        //  2638: areturn        
        //  2639: astore_3       
        //  2640: aload_1        
        //  2641: aconst_null    
        //  2642: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  2647: aload_3        
        //  2648: athrow         
        //  2649: aload           13
        //  2651: astore          11
        //  2653: aload           7
        //  2655: astore          14
        //  2657: aload_3        
        //  2658: astore          7
        //  2660: aload_2        
        //  2661: astore          15
        //  2663: aload_1        
        //  2664: astore_2       
        //  2665: aload           13
        //  2667: instanceof      Landroidx/paging/PagingSource$b$b;
        //  2670: ifeq            2681
        //  2673: aload_3        
        //  2674: invokespecial   androidx/paging/PageFetcherSnapshot.B:()V
        //  2677: getstatic       ka/r.a:Lka/r;
        //  2680: areturn        
        //  2681: getstatic       androidx/paging/PageFetcherSnapshot$a.a:[I
        //  2684: aload_2        
        //  2685: invokevirtual   java/lang/Enum.ordinal:()I
        //  2688: iaload         
        //  2689: iconst_2       
        //  2690: if_icmpne       2700
        //  2693: getstatic       androidx/paging/LoadType.APPEND:Landroidx/paging/LoadType;
        //  2696: astore_1       
        //  2697: goto            2704
        //  2700: getstatic       androidx/paging/LoadType.PREPEND:Landroidx/paging/LoadType;
        //  2703: astore_1       
        //  2704: aload           7
        //  2706: getfield        androidx/paging/PageFetcherSnapshot.l:Landroidx/paging/PageFetcherSnapshotState$a;
        //  2709: astore          16
        //  2711: aload           16
        //  2713: invokestatic    androidx/paging/PageFetcherSnapshotState$a.a:(Landroidx/paging/PageFetcherSnapshotState$a;)Lkotlinx/coroutines/sync/c;
        //  2716: astore_3       
        //  2717: aload           14
        //  2719: aload           7
        //  2721: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  2724: aload           14
        //  2726: aload_2        
        //  2727: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  2730: aload           14
        //  2732: aload           15
        //  2734: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  2737: aload           14
        //  2739: aload           9
        //  2741: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  2744: aload           14
        //  2746: aload           8
        //  2748: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  2751: aload           14
        //  2753: aload           10
        //  2755: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  2758: aload           14
        //  2760: aload           12
        //  2762: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //  2765: aload           14
        //  2767: aload           11
        //  2769: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //  2772: aload           14
        //  2774: aload_1        
        //  2775: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$8:Ljava/lang/Object;
        //  2778: aload           14
        //  2780: aload           16
        //  2782: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$9:Ljava/lang/Object;
        //  2785: aload           14
        //  2787: aload_3        
        //  2788: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$10:Ljava/lang/Object;
        //  2791: aload           14
        //  2793: bipush          8
        //  2795: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //  2798: aload_3        
        //  2799: aconst_null    
        //  2800: aload           14
        //  2802: invokeinterface kotlinx/coroutines/sync/c.a:(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //  2807: aload           20
        //  2809: if_acmpne       2815
        //  2812: aload           20
        //  2814: areturn        
        //  2815: aload           15
        //  2817: astore          18
        //  2819: aload           8
        //  2821: astore          17
        //  2823: aload           7
        //  2825: astore          8
        //  2827: aload           11
        //  2829: astore          13
        //  2831: aload_3        
        //  2832: astore          15
        //  2834: aload           10
        //  2836: astore          11
        //  2838: aload_2        
        //  2839: astore_3       
        //  2840: aload           18
        //  2842: astore          7
        //  2844: aload           17
        //  2846: astore          10
        //  2848: aload_1        
        //  2849: astore          18
        //  2851: aload           14
        //  2853: astore_1       
        //  2854: aload           15
        //  2856: astore_2       
        //  2857: aload           16
        //  2859: invokestatic    androidx/paging/PageFetcherSnapshotState$a.b:(Landroidx/paging/PageFetcherSnapshotState$a;)Landroidx/paging/PageFetcherSnapshotState;
        //  2862: astore          17
        //  2864: aload           17
        //  2866: aload           18
        //  2868: aload           7
        //  2870: invokevirtual   androidx/paging/h.b:()Landroidx/paging/g0;
        //  2873: invokevirtual   androidx/paging/PageFetcherSnapshotState.i:(Landroidx/paging/LoadType;Landroidx/paging/g0;)Landroidx/paging/u$a;
        //  2876: astore          14
        //  2878: aload           14
        //  2880: ifnonnull       2926
        //  2883: aload           12
        //  2885: astore          14
        //  2887: aload           17
        //  2889: astore          19
        //  2891: aload_1        
        //  2892: astore          12
        //  2894: aload_2        
        //  2895: astore_1       
        //  2896: aload           13
        //  2898: astore          18
        //  2900: aload           14
        //  2902: astore          17
        //  2904: aload           8
        //  2906: astore          13
        //  2908: aload           11
        //  2910: astore          16
        //  2912: aload           9
        //  2914: astore          15
        //  2916: aload           7
        //  2918: astore          9
        //  2920: aload_3        
        //  2921: astore          14
        //  2923: goto            3115
        //  2926: aload           17
        //  2928: aload           14
        //  2930: invokevirtual   androidx/paging/PageFetcherSnapshotState.h:(Landroidx/paging/u$a;)V
        //  2933: aload           8
        //  2935: getfield        androidx/paging/PageFetcherSnapshot.k:Lkotlinx/coroutines/channels/d;
        //  2938: astore          15
        //  2940: aload_1        
        //  2941: aload           8
        //  2943: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  2946: aload_1        
        //  2947: aload_3        
        //  2948: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  2951: aload_1        
        //  2952: aload           7
        //  2954: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  2957: aload_1        
        //  2958: aload           9
        //  2960: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  2963: aload_1        
        //  2964: aload           10
        //  2966: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  2969: aload_1        
        //  2970: aload           11
        //  2972: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  2975: aload_1        
        //  2976: aload           12
        //  2978: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //  2981: aload_1        
        //  2982: aload           13
        //  2984: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //  2987: aload_1        
        //  2988: aload_2        
        //  2989: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$8:Ljava/lang/Object;
        //  2992: aload_1        
        //  2993: aload           17
        //  2995: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$9:Ljava/lang/Object;
        //  2998: aload_1        
        //  2999: aconst_null    
        //  3000: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$10:Ljava/lang/Object;
        //  3003: aload_1        
        //  3004: bipush          9
        //  3006: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //  3009: aload           15
        //  3011: aload           14
        //  3013: aload_1        
        //  3014: invokeinterface kotlinx/coroutines/channels/u.z:(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //  3019: astore          14
        //  3021: aload           14
        //  3023: aload           20
        //  3025: if_acmpne       3031
        //  3028: aload           20
        //  3030: areturn        
        //  3031: aload           13
        //  3033: astore          18
        //  3035: aload           8
        //  3037: astore          16
        //  3039: aload_3        
        //  3040: astore          15
        //  3042: aload           7
        //  3044: astore          14
        //  3046: aload           9
        //  3048: astore          13
        //  3050: aload           11
        //  3052: astore          9
        //  3054: aload           12
        //  3056: astore          11
        //  3058: aload           18
        //  3060: astore          8
        //  3062: aload_2        
        //  3063: astore_3       
        //  3064: aload_1        
        //  3065: astore          12
        //  3067: aload           17
        //  3069: astore          7
        //  3071: aload_3        
        //  3072: astore_2       
        //  3073: getstatic       ka/r.a:Lka/r;
        //  3076: astore_1       
        //  3077: aload           16
        //  3079: astore_1       
        //  3080: aload           14
        //  3082: astore_2       
        //  3083: aload           9
        //  3085: astore          16
        //  3087: aload           15
        //  3089: astore          14
        //  3091: aload_2        
        //  3092: astore          9
        //  3094: aload           13
        //  3096: astore          15
        //  3098: aload_1        
        //  3099: astore          13
        //  3101: aload           11
        //  3103: astore          17
        //  3105: aload           8
        //  3107: astore          18
        //  3109: aload_3        
        //  3110: astore_1       
        //  3111: aload           7
        //  3113: astore          19
        //  3115: aload_1        
        //  3116: astore_2       
        //  3117: aload           13
        //  3119: aload           19
        //  3121: aload           14
        //  3123: aload           9
        //  3125: invokevirtual   androidx/paging/h.a:()I
        //  3128: aload           9
        //  3130: invokevirtual   androidx/paging/h.b:()Landroidx/paging/g0;
        //  3133: aload           14
        //  3135: invokevirtual   androidx/paging/g0.e:(Landroidx/paging/LoadType;)I
        //  3138: aload           15
        //  3140: getfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //  3143: iadd           
        //  3144: invokespecial   androidx/paging/PageFetcherSnapshot.A:(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;II)Ljava/lang/Object;
        //  3147: astore_3       
        //  3148: aload_1        
        //  3149: astore_2       
        //  3150: aload           10
        //  3152: aload_3        
        //  3153: putfield        kotlin/jvm/internal/Ref$ObjectRef.element:Ljava/lang/Object;
        //  3156: aload_3        
        //  3157: ifnonnull       3228
        //  3160: aload_1        
        //  3161: astore_2       
        //  3162: aload           19
        //  3164: invokevirtual   androidx/paging/PageFetcherSnapshotState.p:()Landroidx/paging/p;
        //  3167: aload           14
        //  3169: invokevirtual   androidx/paging/p.a:(Landroidx/paging/LoadType;)Landroidx/paging/l;
        //  3172: instanceof      Landroidx/paging/l$a;
        //  3175: ifne            3228
        //  3178: aload_1        
        //  3179: astore_2       
        //  3180: aload           19
        //  3182: invokevirtual   androidx/paging/PageFetcherSnapshotState.p:()Landroidx/paging/p;
        //  3185: astore          7
        //  3187: aload_1        
        //  3188: astore_2       
        //  3189: aload           16
        //  3191: getfield        kotlin/jvm/internal/Ref$BooleanRef.element:Z
        //  3194: ifeq            3209
        //  3197: aload_1        
        //  3198: astore_2       
        //  3199: getstatic       androidx/paging/l$c.b:Landroidx/paging/l$c$a;
        //  3202: invokevirtual   androidx/paging/l$c$a.a:()Landroidx/paging/l$c;
        //  3205: astore_3       
        //  3206: goto            3218
        //  3209: aload_1        
        //  3210: astore_2       
        //  3211: getstatic       androidx/paging/l$c.b:Landroidx/paging/l$c$a;
        //  3214: invokevirtual   androidx/paging/l$c$a.b:()Landroidx/paging/l$c;
        //  3217: astore_3       
        //  3218: aload_1        
        //  3219: astore_2       
        //  3220: aload           7
        //  3222: aload           14
        //  3224: aload_3        
        //  3225: invokevirtual   androidx/paging/p.c:(Landroidx/paging/LoadType;Landroidx/paging/l;)V
        //  3228: aload_1        
        //  3229: astore_2       
        //  3230: aload           19
        //  3232: aload           18
        //  3234: checkcast       Landroidx/paging/PagingSource$b$c;
        //  3237: aload           14
        //  3239: invokevirtual   androidx/paging/PageFetcherSnapshotState.u:(Landroidx/paging/PagingSource$b$c;Landroidx/paging/LoadType;)Landroidx/paging/u;
        //  3242: astore          7
        //  3244: aload_1        
        //  3245: astore_2       
        //  3246: aload           13
        //  3248: getfield        androidx/paging/PageFetcherSnapshot.k:Lkotlinx/coroutines/channels/d;
        //  3251: astore_3       
        //  3252: aload_1        
        //  3253: astore_2       
        //  3254: aload           12
        //  3256: aload           13
        //  3258: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  3261: aload_1        
        //  3262: astore_2       
        //  3263: aload           12
        //  3265: aload           14
        //  3267: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  3270: aload_1        
        //  3271: astore_2       
        //  3272: aload           12
        //  3274: aload           9
        //  3276: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  3279: aload_1        
        //  3280: astore_2       
        //  3281: aload           12
        //  3283: aload           15
        //  3285: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  3288: aload_1        
        //  3289: astore_2       
        //  3290: aload           12
        //  3292: aload           10
        //  3294: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  3297: aload_1        
        //  3298: astore_2       
        //  3299: aload           12
        //  3301: aload           16
        //  3303: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  3306: aload_1        
        //  3307: astore_2       
        //  3308: aload           12
        //  3310: aload           17
        //  3312: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //  3315: aload_1        
        //  3316: astore_2       
        //  3317: aload           12
        //  3319: aload           18
        //  3321: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //  3324: aload_1        
        //  3325: astore_2       
        //  3326: aload           12
        //  3328: aload_1        
        //  3329: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$8:Ljava/lang/Object;
        //  3332: aload           12
        //  3334: aconst_null    
        //  3335: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$9:Ljava/lang/Object;
        //  3338: aload           12
        //  3340: aconst_null    
        //  3341: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$10:Ljava/lang/Object;
        //  3344: aload_1        
        //  3345: astore_2       
        //  3346: aload           12
        //  3348: bipush          10
        //  3350: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //  3353: aload_1        
        //  3354: astore_2       
        //  3355: aload_3        
        //  3356: aload           7
        //  3358: aload           12
        //  3360: invokeinterface kotlinx/coroutines/channels/u.z:(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //  3365: aload           20
        //  3367: if_acmpne       3373
        //  3370: aload           20
        //  3372: areturn        
        //  3373: aload           16
        //  3375: astore          11
        //  3377: aload           15
        //  3379: astore          8
        //  3381: aload           14
        //  3383: astore_3       
        //  3384: aload           9
        //  3386: astore          7
        //  3388: aload           13
        //  3390: astore          9
        //  3392: aload_1        
        //  3393: astore          13
        //  3395: aload           12
        //  3397: astore_1       
        //  3398: aload           13
        //  3400: astore_2       
        //  3401: getstatic       ka/r.a:Lka/r;
        //  3404: astore          12
        //  3406: aload           13
        //  3408: aconst_null    
        //  3409: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  3414: aload           17
        //  3416: instanceof      Landroidx/paging/PagingSource$a$c;
        //  3419: ifeq            3439
        //  3422: aload           18
        //  3424: checkcast       Landroidx/paging/PagingSource$b$c;
        //  3427: invokevirtual   androidx/paging/PagingSource$b$c.e:()Ljava/lang/Object;
        //  3430: ifnonnull       3439
        //  3433: iconst_1       
        //  3434: istore          4
        //  3436: goto            3442
        //  3439: iconst_0       
        //  3440: istore          4
        //  3442: aload           17
        //  3444: instanceof      Landroidx/paging/PagingSource$a$a;
        //  3447: ifeq            3467
        //  3450: aload           18
        //  3452: checkcast       Landroidx/paging/PagingSource$b$c;
        //  3455: invokevirtual   androidx/paging/PagingSource$b$c.d:()Ljava/lang/Object;
        //  3458: ifnonnull       3467
        //  3461: iconst_1       
        //  3462: istore          5
        //  3464: goto            3470
        //  3467: iconst_0       
        //  3468: istore          5
        //  3470: aload           9
        //  3472: invokevirtual   androidx/paging/PageFetcherSnapshot.y:()Landroidx/paging/c0;
        //  3475: ifnull          3701
        //  3478: iload           4
        //  3480: ifne            3488
        //  3483: iload           5
        //  3485: ifeq            3701
        //  3488: aload           9
        //  3490: getfield        androidx/paging/PageFetcherSnapshot.l:Landroidx/paging/PageFetcherSnapshotState$a;
        //  3493: astore          14
        //  3495: aload           14
        //  3497: invokestatic    androidx/paging/PageFetcherSnapshotState$a.a:(Landroidx/paging/PageFetcherSnapshotState$a;)Lkotlinx/coroutines/sync/c;
        //  3500: astore          13
        //  3502: aload_1        
        //  3503: aload           9
        //  3505: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$0:Ljava/lang/Object;
        //  3508: aload_1        
        //  3509: aload_3        
        //  3510: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$1:Ljava/lang/Object;
        //  3513: aload_1        
        //  3514: aload           7
        //  3516: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$2:Ljava/lang/Object;
        //  3519: aload_1        
        //  3520: aload           8
        //  3522: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$3:Ljava/lang/Object;
        //  3525: aload_1        
        //  3526: aload           10
        //  3528: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$4:Ljava/lang/Object;
        //  3531: aload_1        
        //  3532: aload           11
        //  3534: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$5:Ljava/lang/Object;
        //  3537: aload_1        
        //  3538: aload           14
        //  3540: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$6:Ljava/lang/Object;
        //  3543: aload_1        
        //  3544: aload           13
        //  3546: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$7:Ljava/lang/Object;
        //  3549: aload_1        
        //  3550: aconst_null    
        //  3551: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.L$8:Ljava/lang/Object;
        //  3554: aload_1        
        //  3555: iload           4
        //  3557: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.I$0:I
        //  3560: aload_1        
        //  3561: iload           5
        //  3563: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.I$1:I
        //  3566: aload_1        
        //  3567: bipush          11
        //  3569: putfield        androidx/paging/PageFetcherSnapshot$doLoad$1.label:I
        //  3572: aload           13
        //  3574: aconst_null    
        //  3575: aload_1        
        //  3576: invokeinterface kotlinx/coroutines/sync/c.a:(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;
        //  3581: aload           20
        //  3583: if_acmpne       3589
        //  3586: aload           20
        //  3588: areturn        
        //  3589: aload           10
        //  3591: astore_2       
        //  3592: aload           9
        //  3594: astore          12
        //  3596: aload           11
        //  3598: astore          9
        //  3600: aload           14
        //  3602: astore          11
        //  3604: aload           13
        //  3606: astore          10
        //  3608: aload           11
        //  3610: invokestatic    androidx/paging/PageFetcherSnapshotState$a.b:(Landroidx/paging/PageFetcherSnapshotState$a;)Landroidx/paging/PageFetcherSnapshotState;
        //  3613: aload           12
        //  3615: getfield        androidx/paging/PageFetcherSnapshot.i:Landroidx/paging/HintHandler;
        //  3618: invokevirtual   androidx/paging/HintHandler.b:()Landroidx/paging/g0$a;
        //  3621: invokevirtual   androidx/paging/PageFetcherSnapshotState.g:(Landroidx/paging/g0$a;)Landroidx/paging/z;
        //  3624: astore          11
        //  3626: aload           10
        //  3628: aconst_null    
        //  3629: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  3634: iload           4
        //  3636: ifeq            3654
        //  3639: aload           12
        //  3641: invokevirtual   androidx/paging/PageFetcherSnapshot.y:()Landroidx/paging/c0;
        //  3644: getstatic       androidx/paging/LoadType.PREPEND:Landroidx/paging/LoadType;
        //  3647: aload           11
        //  3649: invokeinterface androidx/paging/c0.c:(Landroidx/paging/LoadType;Landroidx/paging/z;)V
        //  3654: iload           5
        //  3656: ifeq            3674
        //  3659: aload           12
        //  3661: invokevirtual   androidx/paging/PageFetcherSnapshot.y:()Landroidx/paging/c0;
        //  3664: getstatic       androidx/paging/LoadType.APPEND:Landroidx/paging/LoadType;
        //  3667: aload           11
        //  3669: invokeinterface androidx/paging/c0.c:(Landroidx/paging/LoadType;Landroidx/paging/z;)V
        //  3674: aload           9
        //  3676: astore          10
        //  3678: aload_1        
        //  3679: astore          11
        //  3681: aload_3        
        //  3682: astore          9
        //  3684: aload           12
        //  3686: astore_3       
        //  3687: goto            1783
        //  3690: astore_1       
        //  3691: aload           10
        //  3693: aconst_null    
        //  3694: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  3699: aload_1        
        //  3700: athrow         
        //  3701: aload           10
        //  3703: astore_2       
        //  3704: aload           9
        //  3706: astore          12
        //  3708: aload           11
        //  3710: astore          10
        //  3712: aload_1        
        //  3713: astore          11
        //  3715: aload_3        
        //  3716: astore          9
        //  3718: aload           12
        //  3720: astore_3       
        //  3721: goto            1783
        //  3724: astore_2       
        //  3725: goto            3746
        //  3728: astore_1       
        //  3729: aload_2        
        //  3730: astore_3       
        //  3731: aload_1        
        //  3732: astore_2       
        //  3733: aload_3        
        //  3734: astore_1       
        //  3735: goto            3746
        //  3738: astore_3       
        //  3739: aload_2        
        //  3740: astore_1       
        //  3741: aload_3        
        //  3742: astore_2       
        //  3743: goto            439
        //  3746: aload_1        
        //  3747: aconst_null    
        //  3748: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  3753: aload_2        
        //  3754: athrow         
        //  3755: getstatic       ka/r.a:Lka/r;
        //  3758: areturn        
        //  3759: astore_1       
        //  3760: goto            933
        //  3763: aload_2        
        //  3764: aconst_null    
        //  3765: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  3770: aload_1        
        //  3771: athrow         
        //  3772: new             Ljava/lang/IllegalStateException;
        //  3775: astore_1       
        //  3776: aload_1        
        //  3777: ldc_w           "Use doInitialLoad for LoadType == REFRESH"
        //  3780: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //  3783: aload_1        
        //  3784: athrow         
        //  3785: astore_1       
        //  3786: aload           10
        //  3788: aconst_null    
        //  3789: invokeinterface kotlinx/coroutines/sync/c.b:(Ljava/lang/Object;)V
        //  3794: aload_1        
        //  3795: athrow         
        //  3796: new             Ljava/lang/IllegalArgumentException;
        //  3799: dup            
        //  3800: ldc_w           "Use doInitialLoad for LoadType == REFRESH"
        //  3803: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //  3806: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //  3809: athrow         
        //    Signature:
        //  (Landroidx/paging/LoadType;Landroidx/paging/h;Lkotlin/coroutines/c<-Lka/r;>;)Ljava/lang/Object;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  316    321    434    439    Any
        //  419    424    434    439    Any
        //  587    592    600    606    Any
        //  920    925    932    933    Any
        //  1196   1213   3785   3796   Any
        //  1234   1252   3785   3796   Any
        //  1261   1282   3785   3796   Any
        //  1285   1295   3785   3796   Any
        //  1302   1334   3785   3796   Any
        //  1350   1368   3785   3796   Any
        //  1372   1424   3785   3796   Any
        //  1432   1464   3785   3796   Any
        //  1480   1485   3785   3796   Any
        //  1607   1646   3759   3763   Any
        //  1663   1726   3759   3763   Any
        //  2228   2248   2360   2371   Any
        //  2487   2494   600    606    Any
        //  2496   2501   600    606    Any
        //  2503   2516   600    606    Any
        //  2518   2524   600    606    Any
        //  2526   2533   600    606    Any
        //  2535   2541   600    606    Any
        //  2543   2550   600    606    Any
        //  2550   2562   2639   2640   Any
        //  2564   2571   600    606    Any
        //  2573   2590   600    606    Any
        //  2606   2624   600    606    Any
        //  2626   2630   600    606    Any
        //  2857   2878   3738   3746   Any
        //  2926   2998   3738   3746   Any
        //  2998   3003   3728   3738   Any
        //  3003   3021   3738   3746   Any
        //  3073   3077   434    439    Any
        //  3117   3148   434    439    Any
        //  3150   3156   434    439    Any
        //  3162   3178   434    439    Any
        //  3180   3187   434    439    Any
        //  3189   3197   434    439    Any
        //  3199   3206   434    439    Any
        //  3211   3218   434    439    Any
        //  3220   3228   434    439    Any
        //  3230   3244   434    439    Any
        //  3246   3252   434    439    Any
        //  3254   3261   434    439    Any
        //  3263   3270   434    439    Any
        //  3272   3279   434    439    Any
        //  3281   3288   434    439    Any
        //  3290   3297   434    439    Any
        //  3299   3306   434    439    Any
        //  3308   3315   434    439    Any
        //  3317   3324   434    439    Any
        //  3326   3332   434    439    Any
        //  3332   3344   3724   3728   Any
        //  3346   3353   434    439    Any
        //  3355   3370   434    439    Any
        //  3401   3406   434    439    Any
        //  3608   3626   3690   3701   Any
        //  3772   3785   3785   3796   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.StackOverflowError
        //     at com.strobel.assembler.metadata.DefaultTypeVisitor.visit(DefaultTypeVisitor.java:25)
        //     at com.strobel.assembler.metadata.MetadataHelper.asSuper(MetadataHelper.java:833)
        //     at com.strobel.assembler.metadata.MetadataHelper$6.visitClassType(MetadataHelper.java:1973)
        //     at com.strobel.assembler.metadata.MetadataHelper$6.visitClassType(MetadataHelper.java:1935)
        //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedType.accept(CoreMetadataFactory.java:577)
        //     at com.strobel.assembler.metadata.DefaultTypeVisitor.visit(DefaultTypeVisitor.java:25)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1408)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:648)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:933)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1049)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1510)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1067)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2483)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferBinaryExpression(TypeAnalysis.java:2124)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1545)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1565)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1067)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2483)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferBinaryExpression(TypeAnalysis.java:2124)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1545)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1565)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferBinaryExpression(TypeAnalysis.java:2213)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1545)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1565)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2535)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1067)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2535)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1067)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2483)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2483)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferBinaryExpression(TypeAnalysis.java:2124)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1130)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2483)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1341)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1049)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2535)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2483)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2483)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferBinaryExpression(TypeAnalysis.java:2124)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1545)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1565)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1049)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2535)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2483)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2483)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferBinaryExpression(TypeAnalysis.java:2125)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1130)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferBinaryExpression(TypeAnalysis.java:2124)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1130)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferBinaryArguments(TypeAnalysis.java:2854)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferBinaryExpression(TypeAnalysis.java:2215)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1545)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1565)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2535)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2483)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferBinaryExpression(TypeAnalysis.java:2124)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1545)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:790)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1565)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1049)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1510)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2715)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.invalidateDependentExpressions(TypeAnalysis.java:771)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1022)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:778)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1510)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
        //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
        //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:667)
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:373)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
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
    
    private final PagingSource.a<Key> z(final LoadType loadType, final Key key) {
        final PagingSource.a.b c = PagingSource.a.c;
        int n;
        if (loadType == LoadType.REFRESH) {
            n = this.c.d;
        }
        else {
            n = this.c.a;
        }
        return c.a(loadType, key, n, this.c.c);
    }
    
    public final void p(final g0 g0) {
        o.g((Object)g0, "viewportHint");
        this.i.d(g0);
    }
    
    public final void q() {
        q1$a.a((q1)this.m, (CancellationException)null, 1, (Object)null);
    }
    
    public final Object s(kotlin.coroutines.c<? super z<Key, Value>> c) {
        PageFetcherSnapshot$currentPagingState.PageFetcherSnapshot$currentPagingState$1 pageFetcherSnapshot$currentPagingState$2 = null;
        Label_0047: {
            if (c instanceof PageFetcherSnapshot$currentPagingState.PageFetcherSnapshot$currentPagingState$1) {
                final PageFetcherSnapshot$currentPagingState.PageFetcherSnapshot$currentPagingState$1 pageFetcherSnapshot$currentPagingState$1 = (PageFetcherSnapshot$currentPagingState.PageFetcherSnapshot$currentPagingState$1)c;
                final int label = pageFetcherSnapshot$currentPagingState$1.label;
                if ((label & Integer.MIN_VALUE) != 0x0) {
                    pageFetcherSnapshot$currentPagingState$1.label = label + Integer.MIN_VALUE;
                    pageFetcherSnapshot$currentPagingState$2 = pageFetcherSnapshot$currentPagingState$1;
                    break Label_0047;
                }
            }
            pageFetcherSnapshot$currentPagingState$2 = new PageFetcherSnapshot$currentPagingState.PageFetcherSnapshot$currentPagingState$1(this, c);
        }
        final Object result = pageFetcherSnapshot$currentPagingState$2.result;
        final Object d = kotlin.coroutines.intrinsics.a.d();
        final int label2 = pageFetcherSnapshot$currentPagingState$2.label;
        PageFetcherSnapshotState.a<Key, Value> l;
        PageFetcherSnapshot pageFetcherSnapshot;
        if (label2 != 0) {
            if (label2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final kotlinx.coroutines.sync.c c2 = (kotlinx.coroutines.sync.c)pageFetcherSnapshot$currentPagingState$2.L$2;
            l = (PageFetcherSnapshotState.a<Key, Value>)pageFetcherSnapshot$currentPagingState$2.L$1;
            pageFetcherSnapshot = (PageFetcherSnapshot)pageFetcherSnapshot$currentPagingState$2.L$0;
            ka.k.b(result);
            c = (kotlin.coroutines.c)c2;
        }
        else {
            ka.k.b(result);
            l = this.l;
            final kotlinx.coroutines.sync.c a = PageFetcherSnapshotState.a.a((PageFetcherSnapshotState.a<Object, Object>)l);
            pageFetcherSnapshot$currentPagingState$2.L$0 = this;
            pageFetcherSnapshot$currentPagingState$2.L$1 = l;
            pageFetcherSnapshot$currentPagingState$2.L$2 = a;
            pageFetcherSnapshot$currentPagingState$2.label = 1;
            if (a.a((Object)null, (kotlin.coroutines.c)pageFetcherSnapshot$currentPagingState$2) == d) {
                return d;
            }
            pageFetcherSnapshot = this;
            c = (kotlin.coroutines.c)a;
        }
        try {
            return PageFetcherSnapshotState.a.b((PageFetcherSnapshotState.a<Object, Object>)l).g(pageFetcherSnapshot.i.b());
        }
        finally {
            ((kotlinx.coroutines.sync.c)c).b((Object)null);
        }
    }
    
    public final Key v() {
        return this.a;
    }
    
    public final c<u<Value>> w() {
        return this.n;
    }
    
    public final PagingSource<Key, Value> x() {
        return this.b;
    }
    
    public final c0<Key, Value> y() {
        return this.f;
    }
    
    @Metadata(k = 3, mv = { 1, 5, 1 }, xi = 48)
    public final class a
    {
        public static final int[] a;
        
        static {
            final int[] a2 = new int[LoadType.values().length];
            a2[LoadType.REFRESH.ordinal()] = 1;
            a2[LoadType.PREPEND.ordinal()] = 2;
            a2[LoadType.APPEND.ordinal()] = 3;
            a = a2;
        }
    }
}
