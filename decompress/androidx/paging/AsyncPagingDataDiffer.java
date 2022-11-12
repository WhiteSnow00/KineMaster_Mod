// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlinx.coroutines.CoroutineStart;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.h;
import androidx.lifecycle.Lifecycle;
import sa.a;
import sa.l;
import kotlin.jvm.internal.o;
import ka.r;
import kotlinx.coroutines.flow.c;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.CoroutineDispatcher;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0001:\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B3\b\u0007\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\b\b\u0002\u0010'\u001a\u00020$\u0012\b\b\u0002\u0010)\u001a\u00020$¢\u0006\u0004\bJ\u0010KJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0019\u0010\u000f\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0010J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0014\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\u0014\u0010\u0017\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\u001a\u0010\u001a\u001a\u00020\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0018J\u001a\u0010\u001b\u001a\u00020\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0018R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010&R \u00101\u001a\u00020*8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b+\u0010,\u0012\u0004\b/\u00100\u001a\u0004\b-\u0010.R(\u00109\u001a\u0002028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0004\b\u001a\u00103\u0012\u0004\b8\u00100\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010>R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00190@8\u0006¢\u0006\f\n\u0004\b4\u0010A\u001a\u0004\bB\u0010CR\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050@8\u0006¢\u0006\f\n\u0004\b\u000f\u0010A\u001a\u0004\bE\u0010CR\u0011\u0010I\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bG\u0010H\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006L" }, d2 = { "Landroidx/paging/AsyncPagingDataDiffer;", "", "T", "Landroidx/paging/y;", "pagingData", "Lka/r;", "t", "(Landroidx/paging/y;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "u", "r", "o", "", "index", "j", "(I)Ljava/lang/Object;", "n", "Landroidx/paging/k;", "s", "Lkotlin/Function0;", "listener", "g", "q", "Lkotlin/Function1;", "Landroidx/paging/c;", "f", "p", "Landroidx/recyclerview/widget/i$f;", "a", "Landroidx/recyclerview/widget/i$f;", "diffCallback", "Landroidx/recyclerview/widget/p;", "b", "Landroidx/recyclerview/widget/p;", "updateCallback", "Lkotlinx/coroutines/CoroutineDispatcher;", "c", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "d", "workerDispatcher", "Landroidx/paging/e;", "e", "Landroidx/paging/e;", "h", "()Landroidx/paging/e;", "getDifferCallback$paging_runtime_release$annotations", "()V", "differCallback", "", "Z", "i", "()Z", "setInGetItem$paging_runtime_release", "(Z)V", "getInGetItem$paging_runtime_release$annotations", "inGetItem", "androidx/paging/AsyncPagingDataDiffer$differBase$1", "Landroidx/paging/AsyncPagingDataDiffer$differBase$1;", "differBase", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "submitDataId", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/c;", "l", "()Lkotlinx/coroutines/flow/c;", "loadStateFlow", "m", "onPagesUpdatedFlow", "k", "()I", "itemCount", "<init>", "(Landroidx/recyclerview/widget/i$f;Landroidx/recyclerview/widget/p;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "paging-runtime_release" }, k = 1, mv = { 1, 5, 1 })
public final class AsyncPagingDataDiffer<T>
{
    private final i.f<T> a;
    private final p b;
    private final CoroutineDispatcher c;
    private final CoroutineDispatcher d;
    private final e e;
    private boolean f;
    private final AsyncPagingDataDiffer$differBase.AsyncPagingDataDiffer$differBase$1 g;
    private final AtomicInteger h;
    private final c<androidx.paging.c> i;
    private final c<r> j;
    
    public AsyncPagingDataDiffer(final i.f<T> a, final p b, final CoroutineDispatcher c, final CoroutineDispatcher d) {
        o.g((Object)a, "diffCallback");
        o.g((Object)b, "updateCallback");
        o.g((Object)c, "mainDispatcher");
        o.g((Object)d, "workerDispatcher");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        final e e = new e(this) {
            final AsyncPagingDataDiffer<T> a;
            
            @Override
            public void a(final int n, final int n2) {
                if (n2 > 0) {
                    AsyncPagingDataDiffer.d(this.a).a(n, n2);
                }
            }
            
            @Override
            public void b(final int n, final int n2) {
                if (n2 > 0) {
                    AsyncPagingDataDiffer.d(this.a).b(n, n2);
                }
            }
            
            @Override
            public void c(final int n, final int n2) {
                if (n2 > 0) {
                    AsyncPagingDataDiffer.d(this.a).c(n, n2, null);
                }
            }
        };
        this.e = e;
        final AsyncPagingDataDiffer$differBase.AsyncPagingDataDiffer$differBase$1 g = new AsyncPagingDataDiffer$differBase.AsyncPagingDataDiffer$differBase$1(this, (e)e, c);
        this.g = g;
        this.h = new AtomicInteger(0);
        this.i = ((PagingDataDiffer)g).t();
        this.j = ((PagingDataDiffer)g).u();
    }
    
    public static final i.f a(final AsyncPagingDataDiffer asyncPagingDataDiffer) {
        return asyncPagingDataDiffer.a;
    }
    
    public static final AsyncPagingDataDiffer$differBase.AsyncPagingDataDiffer$differBase$1 b(final AsyncPagingDataDiffer asyncPagingDataDiffer) {
        return asyncPagingDataDiffer.g;
    }
    
    public static final AtomicInteger c(final AsyncPagingDataDiffer asyncPagingDataDiffer) {
        return asyncPagingDataDiffer.h;
    }
    
    public static final p d(final AsyncPagingDataDiffer asyncPagingDataDiffer) {
        return asyncPagingDataDiffer.b;
    }
    
    public static final CoroutineDispatcher e(final AsyncPagingDataDiffer asyncPagingDataDiffer) {
        return asyncPagingDataDiffer.d;
    }
    
    public final void f(final l<? super androidx.paging.c, r> l) {
        o.g((Object)l, "listener");
        ((PagingDataDiffer)this.g).o(l);
    }
    
    public final void g(final a<r> a) {
        o.g((Object)a, "listener");
        ((PagingDataDiffer)this.g).p(a);
    }
    
    public final e h() {
        return this.e;
    }
    
    public final boolean i() {
        return this.f;
    }
    
    public final T j(final int n) {
        try {
            this.f = true;
            return ((PagingDataDiffer<T>)this.g).s(n);
        }
        finally {
            this.f = false;
        }
    }
    
    public final int k() {
        return ((PagingDataDiffer)this.g).v();
    }
    
    public final c<androidx.paging.c> l() {
        return this.i;
    }
    
    public final c<r> m() {
        return this.j;
    }
    
    public final T n(final int n) {
        return ((PagingDataDiffer<T>)this.g).w(n);
    }
    
    public final void o() {
        ((PagingDataDiffer)this.g).z();
    }
    
    public final void p(final l<? super androidx.paging.c, r> l) {
        o.g((Object)l, "listener");
        ((PagingDataDiffer)this.g).A(l);
    }
    
    public final void q(final a<r> a) {
        o.g((Object)a, "listener");
        ((PagingDataDiffer)this.g).B(a);
    }
    
    public final void r() {
        ((PagingDataDiffer)this.g).C();
    }
    
    public final k<T> s() {
        return ((PagingDataDiffer<T>)this.g).D();
    }
    
    public final Object t(final y<T> y, final kotlin.coroutines.c<? super r> c) {
        this.h.incrementAndGet();
        final Object q = ((PagingDataDiffer<T>)this.g).q(y, c);
        if (q == kotlin.coroutines.intrinsics.a.d()) {
            return q;
        }
        return r.a;
    }
    
    public final void u(final Lifecycle lifecycle, final y<T> y) {
        o.g((Object)lifecycle, "lifecycle");
        o.g((Object)y, "pagingData");
        kotlinx.coroutines.h.b((j0)androidx.lifecycle.p.a(lifecycle), (CoroutineContext)null, (CoroutineStart)null, (sa.p)new AsyncPagingDataDiffer$submitData.AsyncPagingDataDiffer$submitData$2(this, this.h.incrementAndGet(), (y)y, (kotlin.coroutines.c)null), 3, (Object)null);
    }
}
