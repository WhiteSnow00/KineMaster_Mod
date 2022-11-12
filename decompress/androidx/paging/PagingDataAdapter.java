// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.lifecycle.Lifecycle;
import sa.a;
import kotlinx.coroutines.v0;
import sa.l;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.b;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlin.jvm.internal.o;
import androidx.recyclerview.widget.i;
import ka.r;
import kotlinx.coroutines.flow.c;
import kotlin.Metadata;
import androidx.recyclerview.widget.RecyclerView;

@Metadata(bv = {}, d1 = { "\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005B+\b\u0007\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000;\u0012\b\b\u0002\u0010>\u001a\u00020=\u0012\b\b\u0002\u0010?\u001a\u00020=¢\u0006\u0004\b@\u0010AJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eJ!\u0010\u0013\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u001b\u0010\u0019\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001aJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dJ\b\u0010\u001f\u001a\u00020\nH\u0016J\u001a\u0010#\u001a\u00020\b2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b0 J\u001a\u0010$\u001a\u00020\b2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b0 J\u0014\u0010&\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0%J\u0014\u0010'\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0%J\u0012\u0010+\u001a\u00020*2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030(J\u0012\u0010-\u001a\u00020*2\n\u0010,\u001a\u0006\u0012\u0002\b\u00030(J\u001e\u0010.\u001a\u00020*2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030(2\n\u0010,\u001a\u0006\u0012\u0002\b\u00030(R\u0016\u0010/\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00028\u0000018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020!048\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\b048\u0006¢\u0006\f\n\u0004\b9\u00106\u001a\u0004\b:\u00108\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B" }, d2 = { "Landroidx/paging/PagingDataAdapter;", "", "T", "Landroidx/recyclerview/widget/RecyclerView$c0;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;", "strategy", "Lka/r;", "setStateRestorationPolicy", "", "position", "", "getItemId", "", "hasStableIds", "setHasStableIds", "Landroidx/paging/y;", "pagingData", "submitData", "(Landroidx/paging/y;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "retry", "refresh", "getItem", "(I)Ljava/lang/Object;", "index", "peek", "Landroidx/paging/k;", "snapshot", "getItemCount", "Lkotlin/Function1;", "Landroidx/paging/c;", "listener", "addLoadStateListener", "removeLoadStateListener", "Lkotlin/Function0;", "addOnPagesUpdatedListener", "removeOnPagesUpdatedListener", "Landroidx/paging/m;", "header", "Landroidx/recyclerview/widget/ConcatAdapter;", "withLoadStateHeader", "footer", "withLoadStateFooter", "withLoadStateHeaderAndFooter", "userSetRestorationPolicy", "Z", "Landroidx/paging/AsyncPagingDataDiffer;", "differ", "Landroidx/paging/AsyncPagingDataDiffer;", "Lkotlinx/coroutines/flow/c;", "loadStateFlow", "Lkotlinx/coroutines/flow/c;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/c;", "onPagesUpdatedFlow", "getOnPagesUpdatedFlow", "Landroidx/recyclerview/widget/i$f;", "diffCallback", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "workerDispatcher", "<init>", "(Landroidx/recyclerview/widget/i$f;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "paging-runtime_release" }, k = 1, mv = { 1, 5, 1 })
public abstract class PagingDataAdapter<T, VH extends c0> extends Adapter<VH>
{
    private final AsyncPagingDataDiffer<T> differ;
    private final c<androidx.paging.c> loadStateFlow;
    private final c<ka.r> onPagesUpdatedFlow;
    private boolean userSetRestorationPolicy;
    
    public PagingDataAdapter(final androidx.recyclerview.widget.i.f<T> f) {
        kotlin.jvm.internal.o.g((Object)f, "diffCallback");
        this((androidx.recyclerview.widget.i.f)f, (CoroutineDispatcher)null, (CoroutineDispatcher)null, 6, (kotlin.jvm.internal.i)null);
    }
    
    public PagingDataAdapter(final androidx.recyclerview.widget.i.f<T> f, final CoroutineDispatcher coroutineDispatcher) {
        kotlin.jvm.internal.o.g((Object)f, "diffCallback");
        kotlin.jvm.internal.o.g((Object)coroutineDispatcher, "mainDispatcher");
        this((androidx.recyclerview.widget.i.f)f, coroutineDispatcher, (CoroutineDispatcher)null, 4, (kotlin.jvm.internal.i)null);
    }
    
    public PagingDataAdapter(final androidx.recyclerview.widget.i.f<T> f, final CoroutineDispatcher coroutineDispatcher, final CoroutineDispatcher coroutineDispatcher2) {
        kotlin.jvm.internal.o.g((Object)f, "diffCallback");
        kotlin.jvm.internal.o.g((Object)coroutineDispatcher, "mainDispatcher");
        kotlin.jvm.internal.o.g((Object)coroutineDispatcher2, "workerDispatcher");
        final AsyncPagingDataDiffer differ = new AsyncPagingDataDiffer((androidx.recyclerview.widget.i.f<T>)f, new b(this), coroutineDispatcher, coroutineDispatcher2);
        this.differ = differ;
        super.setStateRestorationPolicy(StateRestorationPolicy.PREVENT);
        this.registerAdapterDataObserver(new i(this) {
            final PagingDataAdapter<T, VH> a;
            
            @Override
            public void onItemRangeInserted(final int n, final int n2) {
                PagingDataAdapter.access$_init_$considerAllowingStateRestoration(this.a);
                this.a.unregisterAdapterDataObserver(this);
                super.onItemRangeInserted(n, n2);
            }
        });
        this.addLoadStateListener((sa.l<? super androidx.paging.c, ka.r>)new sa.l<androidx.paging.c, ka.r>(this) {
            private boolean a = true;
            final PagingDataAdapter<T, VH> b;
            
            public void a(final androidx.paging.c c) {
                kotlin.jvm.internal.o.g((Object)c, "loadStates");
                if (this.a) {
                    this.a = false;
                }
                else if (c.e().g() instanceof androidx.paging.l.c) {
                    PagingDataAdapter.access$_init_$considerAllowingStateRestoration(this.b);
                    this.b.removeLoadStateListener((sa.l<? super androidx.paging.c, ka.r>)this);
                }
            }
            
            public /* bridge */ Object invoke(final Object o) {
                this.a((androidx.paging.c)o);
                return ka.r.a;
            }
        });
        this.loadStateFlow = differ.l();
        this.onPagesUpdatedFlow = differ.m();
    }
    
    public PagingDataAdapter(final androidx.recyclerview.widget.i.f f, CoroutineDispatcher c, CoroutineDispatcher a, final int n, final kotlin.jvm.internal.i i) {
        if ((n & 0x2) != 0x0) {
            c = (CoroutineDispatcher)v0.c();
        }
        if ((n & 0x4) != 0x0) {
            a = v0.a();
        }
        this(f, c, a);
    }
    
    private static final <T, VH extends c0> void _init_$considerAllowingStateRestoration(final PagingDataAdapter<T, VH> pagingDataAdapter) {
        if (pagingDataAdapter.getStateRestorationPolicy() == StateRestorationPolicy.PREVENT && !pagingDataAdapter.userSetRestorationPolicy) {
            pagingDataAdapter.setStateRestorationPolicy(StateRestorationPolicy.ALLOW);
        }
    }
    
    public static final void access$_init_$considerAllowingStateRestoration(final PagingDataAdapter pagingDataAdapter) {
        _init_$considerAllowingStateRestoration((PagingDataAdapter<Object, c0>)pagingDataAdapter);
    }
    
    public final void addLoadStateListener(final sa.l<? super androidx.paging.c, ka.r> l) {
        kotlin.jvm.internal.o.g((Object)l, "listener");
        this.differ.f(l);
    }
    
    public final void addOnPagesUpdatedListener(final a<ka.r> a) {
        kotlin.jvm.internal.o.g((Object)a, "listener");
        this.differ.g(a);
    }
    
    protected final T getItem(final int n) {
        return this.differ.j(n);
    }
    
    @Override
    public int getItemCount() {
        return this.differ.k();
    }
    
    @Override
    public final long getItemId(final int n) {
        return super.getItemId(n);
    }
    
    public final c<androidx.paging.c> getLoadStateFlow() {
        return this.loadStateFlow;
    }
    
    public final c<ka.r> getOnPagesUpdatedFlow() {
        return this.onPagesUpdatedFlow;
    }
    
    public final T peek(final int n) {
        return this.differ.n(n);
    }
    
    public final void refresh() {
        this.differ.o();
    }
    
    public final void removeLoadStateListener(final sa.l<? super androidx.paging.c, ka.r> l) {
        kotlin.jvm.internal.o.g((Object)l, "listener");
        this.differ.p(l);
    }
    
    public final void removeOnPagesUpdatedListener(final a<ka.r> a) {
        kotlin.jvm.internal.o.g((Object)a, "listener");
        this.differ.q(a);
    }
    
    public final void retry() {
        this.differ.r();
    }
    
    @Override
    public final void setHasStableIds(final boolean b) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }
    
    @Override
    public void setStateRestorationPolicy(final StateRestorationPolicy stateRestorationPolicy) {
        kotlin.jvm.internal.o.g((Object)stateRestorationPolicy, "strategy");
        this.userSetRestorationPolicy = true;
        super.setStateRestorationPolicy(stateRestorationPolicy);
    }
    
    public final androidx.paging.k<T> snapshot() {
        return this.differ.s();
    }
    
    public final Object submitData(final androidx.paging.y<T> y, final kotlin.coroutines.c<? super ka.r> c) {
        final Object t = this.differ.t(y, c);
        if (t == kotlin.coroutines.intrinsics.a.d()) {
            return t;
        }
        return ka.r.a;
    }
    
    public final void submitData(final Lifecycle lifecycle, final androidx.paging.y<T> y) {
        kotlin.jvm.internal.o.g((Object)lifecycle, "lifecycle");
        kotlin.jvm.internal.o.g((Object)y, "pagingData");
        this.differ.u(lifecycle, y);
    }
    
    public final ConcatAdapter withLoadStateFooter(final androidx.paging.m<?> m) {
        kotlin.jvm.internal.o.g((Object)m, "footer");
        this.addLoadStateListener((sa.l<? super androidx.paging.c, ka.r>)new PagingDataAdapter$withLoadStateFooter.PagingDataAdapter$withLoadStateFooter$1((androidx.paging.m)m));
        return new ConcatAdapter((Adapter<? extends c0>[])new Adapter[] { this, m });
    }
    
    public final ConcatAdapter withLoadStateHeader(final androidx.paging.m<?> m) {
        kotlin.jvm.internal.o.g((Object)m, "header");
        this.addLoadStateListener((sa.l<? super androidx.paging.c, ka.r>)new PagingDataAdapter$withLoadStateHeader.PagingDataAdapter$withLoadStateHeader$1((androidx.paging.m)m));
        return new ConcatAdapter((Adapter<? extends c0>[])new Adapter[] { m, this });
    }
    
    public final ConcatAdapter withLoadStateHeaderAndFooter(final androidx.paging.m<?> m, final androidx.paging.m<?> i) {
        kotlin.jvm.internal.o.g((Object)m, "header");
        kotlin.jvm.internal.o.g((Object)i, "footer");
        this.addLoadStateListener((sa.l<? super androidx.paging.c, ka.r>)new PagingDataAdapter$withLoadStateHeaderAndFooter.PagingDataAdapter$withLoadStateHeaderAndFooter$1((androidx.paging.m)m, (androidx.paging.m)i));
        return new ConcatAdapter((Adapter<? extends c0>[])new Adapter[] { m, this, i });
    }
}
