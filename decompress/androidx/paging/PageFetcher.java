// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import ka.k;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.q1;
import sa.p;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.o;
import ka.r;
import kotlin.coroutines.c;
import sa.l;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002.\u0013B^\u0012(\u0010)\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0(\u0012\u0006\u0012\u0004\u0018\u00010\u00010'\u0012\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010*\u00f8\u0001\u0000¢\u0006\u0004\b,\u0010-J\b\u0010\u0005\u001a\u00020\u0004H\u0002JB\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u000b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tH\u0002J5\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000eH\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0004R\u0016\u0010\u0015\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR#\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010!0\u000b8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006/" }, d2 = { "Landroidx/paging/PageFetcher;", "", "Key", "Value", "Lka/r;", "k", "Landroidx/paging/PageFetcherSnapshot;", "Lkotlinx/coroutines/q1;", "job", "Landroidx/paging/a0;", "accessor", "Lkotlinx/coroutines/flow/c;", "Landroidx/paging/u;", "j", "Landroidx/paging/PagingSource;", "previousPagingSource", "h", "(Landroidx/paging/PagingSource;Lkotlin/coroutines/c;)Ljava/lang/Object;", "l", "b", "Ljava/lang/Object;", "initialKey", "Landroidx/paging/x;", "c", "Landroidx/paging/x;", "config", "Landroidx/paging/ConflatedEventBus;", "", "d", "Landroidx/paging/ConflatedEventBus;", "refreshEvents", "e", "retryEvents", "Landroidx/paging/y;", "f", "Lkotlinx/coroutines/flow/c;", "i", "()Lkotlinx/coroutines/flow/c;", "flow", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "pagingSourceFactory", "Landroidx/paging/RemoteMediator;", "remoteMediator", "<init>", "(Lsa/l;Ljava/lang/Object;Landroidx/paging/x;Landroidx/paging/RemoteMediator;)V", "a", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class PageFetcher<Key, Value>
{
    private final l<c<? super PagingSource<Key, Value>>, Object> a;
    private final Key b;
    private final x c;
    private final ConflatedEventBus<Boolean> d;
    private final ConflatedEventBus<r> e;
    private final kotlinx.coroutines.flow.c<y<Value>> f;
    
    public PageFetcher(final l<? super c<? super PagingSource<Key, Value>>, ?> a, final Key b, final x c, final RemoteMediator<Key, Value> remoteMediator) {
        o.g((Object)a, "pagingSourceFactory");
        o.g((Object)c, "config");
        this.a = (l<c<? super PagingSource<Key, Value>>, Object>)a;
        this.b = b;
        this.c = c;
        this.d = new ConflatedEventBus<Boolean>(null, 1, null);
        this.e = new ConflatedEventBus<r>(null, 1, null);
        this.f = SimpleChannelFlowKt.a((sa.p<? super d0<y<Value>>, ? super c<? super r>, ?>)new PageFetcher$flow.PageFetcher$flow$1((RemoteMediator)remoteMediator, this, (c)null));
    }
    
    public static final Object a(final PageFetcher pageFetcher, final PagingSource pagingSource, final c c) {
        return pageFetcher.h(pagingSource, c);
    }
    
    public static final x b(final PageFetcher pageFetcher) {
        return pageFetcher.c;
    }
    
    public static final Object c(final PageFetcher pageFetcher) {
        return pageFetcher.b;
    }
    
    public static final ConflatedEventBus d(final PageFetcher pageFetcher) {
        return pageFetcher.d;
    }
    
    public static final ConflatedEventBus e(final PageFetcher pageFetcher) {
        return pageFetcher.e;
    }
    
    public static final kotlinx.coroutines.flow.c f(final PageFetcher pageFetcher, final PageFetcherSnapshot pageFetcherSnapshot, final q1 q1, final a0 a0) {
        return pageFetcher.j(pageFetcherSnapshot, q1, a0);
    }
    
    public static final void g(final PageFetcher pageFetcher) {
        pageFetcher.k();
    }
    
    private final Object h(PagingSource<Key, Value> l$1, final c<? super PagingSource<Key, Value>> c) {
        PageFetcher$generateNewPagingSource.PageFetcher$generateNewPagingSource$1 pageFetcher$generateNewPagingSource$2 = null;
        Label_0051: {
            if (c instanceof PageFetcher$generateNewPagingSource.PageFetcher$generateNewPagingSource$1) {
                final PageFetcher$generateNewPagingSource.PageFetcher$generateNewPagingSource$1 pageFetcher$generateNewPagingSource$1 = (PageFetcher$generateNewPagingSource.PageFetcher$generateNewPagingSource$1)c;
                final int label = pageFetcher$generateNewPagingSource$1.label;
                if ((label & Integer.MIN_VALUE) != 0x0) {
                    pageFetcher$generateNewPagingSource$1.label = label + Integer.MIN_VALUE;
                    pageFetcher$generateNewPagingSource$2 = pageFetcher$generateNewPagingSource$1;
                    break Label_0051;
                }
            }
            pageFetcher$generateNewPagingSource$2 = new PageFetcher$generateNewPagingSource.PageFetcher$generateNewPagingSource$1(this, (c)c);
        }
        Object o = pageFetcher$generateNewPagingSource$2.result;
        final Object d = kotlin.coroutines.intrinsics.a.d();
        final int label2 = pageFetcher$generateNewPagingSource$2.label;
        boolean b = true;
        PageFetcher pageFetcher;
        if (label2 != 0) {
            if (label2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l$1 = (PagingSource)pageFetcher$generateNewPagingSource$2.L$1;
            pageFetcher = (PageFetcher)pageFetcher$generateNewPagingSource$2.L$0;
            k.b(o);
        }
        else {
            k.b(o);
            final l<c<? super PagingSource<Key, Value>>, Object> a = this.a;
            pageFetcher$generateNewPagingSource$2.L$0 = this;
            pageFetcher$generateNewPagingSource$2.L$1 = l$1;
            pageFetcher$generateNewPagingSource$2.label = 1;
            o = a.invoke((Object)pageFetcher$generateNewPagingSource$2);
            if (o == d) {
                return d;
            }
            pageFetcher = this;
        }
        final PagingSource pagingSource = (PagingSource)o;
        if (pagingSource instanceof LegacyPagingSource) {
            ((LegacyPagingSource)pagingSource).c(pageFetcher.c.a);
        }
        if (pagingSource == l$1) {
            b = false;
        }
        if (b) {
            pagingSource.registerInvalidatedCallback((sa.a)new PageFetcher$generateNewPagingSource.PageFetcher$generateNewPagingSource$3((Object)pageFetcher));
            if (l$1 != null) {
                l$1.unregisterInvalidatedCallback((sa.a)new PageFetcher$generateNewPagingSource.PageFetcher$generateNewPagingSource$4((Object)pageFetcher));
            }
            if (l$1 != null) {
                l$1.invalidate();
            }
            return pagingSource;
        }
        throw new IllegalStateException("An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource.".toString());
    }
    
    private final kotlinx.coroutines.flow.c<u<Value>> j(final PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, final q1 q1, final a0<Key, Value> a0) {
        if (a0 == null) {
            return pageFetcherSnapshot.w();
        }
        return CancelableChannelFlowKt.a(q1, (sa.p<? super d0<u<Value>>, ? super c<? super r>, ?>)new PageFetcher$injectRemoteEvents.PageFetcher$injectRemoteEvents$1((a0)a0, (PageFetcherSnapshot)pageFetcherSnapshot, new androidx.paging.p(), (c)null));
    }
    
    private final void k() {
        this.d.b(Boolean.FALSE);
    }
    
    public final kotlinx.coroutines.flow.c<y<Value>> i() {
        return this.f;
    }
    
    public final void l() {
        this.d.b(Boolean.TRUE);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B9\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\n\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR%\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0005\u0010\u0011¨\u0006\u0015" }, d2 = { "Landroidx/paging/PageFetcher$a;", "", "Key", "Value", "Landroidx/paging/PageFetcherSnapshot;", "a", "Landroidx/paging/PageFetcherSnapshot;", "b", "()Landroidx/paging/PageFetcherSnapshot;", "snapshot", "Landroidx/paging/z;", "Landroidx/paging/z;", "c", "()Landroidx/paging/z;", "state", "Lkotlinx/coroutines/q1;", "Lkotlinx/coroutines/q1;", "()Lkotlinx/coroutines/q1;", "job", "<init>", "(Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/z;Lkotlinx/coroutines/q1;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    private static final class a<Key, Value>
    {
        private final PageFetcherSnapshot<Key, Value> a;
        private final z<Key, Value> b;
        private final q1 c;
        
        public a(final PageFetcherSnapshot<Key, Value> a, final z<Key, Value> b, final q1 c) {
            o.g((Object)a, "snapshot");
            o.g((Object)c, "job");
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public final q1 a() {
            return this.c;
        }
        
        public final PageFetcherSnapshot<Key, Value> b() {
            return this.a;
        }
        
        public final z<Key, Value> c() {
            return this.b;
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0004B+\u0012\u0014\b\u0001\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016R&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011¨\u0006\u0015" }, d2 = { "Landroidx/paging/PageFetcher$b;", "", "Key", "Value", "Landroidx/paging/f0;", "Landroidx/paging/g0;", "viewportHint", "Lka/r;", "a", "b", "refresh", "Landroidx/paging/PageFetcherSnapshot;", "Landroidx/paging/PageFetcherSnapshot;", "getPageFetcherSnapshot$paging_common", "()Landroidx/paging/PageFetcherSnapshot;", "pageFetcherSnapshot", "Landroidx/paging/ConflatedEventBus;", "Landroidx/paging/ConflatedEventBus;", "retryEventBus", "<init>", "(Landroidx/paging/PageFetcher;Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/ConflatedEventBus;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    public final class b<Key, Value> implements f0
    {
        private final PageFetcherSnapshot<Key, Value> a;
        private final ConflatedEventBus<r> b;
        final PageFetcher<Key, Value> c;
        
        public b(final PageFetcher c, final PageFetcherSnapshot<Key, Value> a, final ConflatedEventBus<r> b) {
            o.g((Object)c, "this$0");
            o.g((Object)a, "pageFetcherSnapshot");
            o.g((Object)b, "retryEventBus");
            this.c = c;
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void a(final g0 g0) {
            o.g((Object)g0, "viewportHint");
            this.a.p(g0);
        }
        
        @Override
        public void b() {
            this.b.b(r.a);
        }
        
        @Override
        public void refresh() {
            this.c.l();
        }
    }
}
