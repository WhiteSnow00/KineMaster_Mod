// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.c;
import ka.r;
import sa.a;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001H\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0019\u0012\u0006\u0010*\u001a\u00020'\u0012\b\b\u0002\u0010.\u001a\u00020+¢\u0006\u0004\b[\u0010\\J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\bJG\u0010\u0010\u001a\u0004\u0018\u00010\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH¦@\u00f8\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016J!\u0010\u0016\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0019\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u0018\u001a\u00020\fH\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001aJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0006J\u0014\u0010!\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u000eJ\u0014\u0010\"\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u000eJ\u001a\u0010%\u001a\u00020\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00060#J\u001a\u0010&\u001a\u00020\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00060#R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R \u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020$0L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00060R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0011\u0010X\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00060L8F¢\u0006\u0006\u001a\u0004\bY\u0010P\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006]" }, d2 = { "Landroidx/paging/PagingDataDiffer;", "", "T", "Landroidx/paging/n;", "source", "mediator", "Lka/r;", "r", "(Landroidx/paging/n;Landroidx/paging/n;)V", "Landroidx/paging/r;", "previousList", "newList", "", "lastAccessedIndex", "Lkotlin/Function0;", "onListPresentable", "y", "(Landroidx/paging/r;Landroidx/paging/r;ILsa/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "x", "Landroidx/paging/y;", "pagingData", "q", "(Landroidx/paging/y;Lkotlin/coroutines/c;)Ljava/lang/Object;", "index", "s", "(I)Ljava/lang/Object;", "w", "Landroidx/paging/k;", "D", "C", "z", "listener", "p", "B", "Lkotlin/Function1;", "Landroidx/paging/c;", "o", "A", "Landroidx/paging/e;", "a", "Landroidx/paging/e;", "differCallback", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "Landroidx/paging/w;", "c", "Landroidx/paging/w;", "presenter", "Landroidx/paging/f0;", "d", "Landroidx/paging/f0;", "receiver", "Landroidx/paging/o;", "e", "Landroidx/paging/o;", "combinedLoadStatesCollection", "Ljava/util/concurrent/CopyOnWriteArrayList;", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onPagesUpdatedListeners", "Landroidx/paging/SingleRunner;", "g", "Landroidx/paging/SingleRunner;", "collectFromRunner", "h", "Z", "lastAccessedIndexUnfulfilled", "i", "I", "androidx/paging/PagingDataDiffer$a", "j", "Landroidx/paging/PagingDataDiffer$a;", "processPageEventCallback", "Lkotlinx/coroutines/flow/c;", "k", "Lkotlinx/coroutines/flow/c;", "t", "()Lkotlinx/coroutines/flow/c;", "loadStateFlow", "Lkotlinx/coroutines/flow/h;", "l", "Lkotlinx/coroutines/flow/h;", "_onPagesUpdatedFlow", "v", "()I", "size", "u", "onPagesUpdatedFlow", "<init>", "(Landroidx/paging/e;Lkotlinx/coroutines/CoroutineDispatcher;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public abstract class PagingDataDiffer<T>
{
    private final e a;
    private final CoroutineDispatcher b;
    private w<T> c;
    private f0 d;
    private final o e;
    private final CopyOnWriteArrayList<a<r>> f;
    private final SingleRunner g;
    private volatile boolean h;
    private volatile int i;
    private final PagingDataDiffer$a j;
    private final c<androidx.paging.c> k;
    private final h<r> l;
    
    public PagingDataDiffer(final e a, final CoroutineDispatcher b) {
        kotlin.jvm.internal.o.g((Object)a, "differCallback");
        kotlin.jvm.internal.o.g((Object)b, "mainDispatcher");
        this.a = a;
        this.b = b;
        this.c = w.e.a();
        final o e = new o();
        this.e = e;
        this.f = new CopyOnWriteArrayList<a<r>>();
        this.g = new SingleRunner(false, 1, null);
        this.j = new w.b(this) {
            final PagingDataDiffer<T> a;
            
            @Override
            public void a(final int n, final int n2) {
                PagingDataDiffer.b(this.a).a(n, n2);
            }
            
            @Override
            public void b(final int n, final int n2) {
                PagingDataDiffer.b(this.a).b(n, n2);
            }
            
            @Override
            public void c(final int n, final int n2) {
                PagingDataDiffer.b(this.a).c(n, n2);
            }
            
            @Override
            public void d(final LoadType loadType, final boolean b, final l l) {
                kotlin.jvm.internal.o.g((Object)loadType, "loadType");
                kotlin.jvm.internal.o.g((Object)l, "loadState");
                if (kotlin.jvm.internal.o.b((Object)PagingDataDiffer.a(this.a).c(loadType, b), (Object)l)) {
                    return;
                }
                PagingDataDiffer.a(this.a).i(loadType, b, l);
            }
            
            @Override
            public void e(final n n, final n n2) {
                kotlin.jvm.internal.o.g((Object)n, "source");
                this.a.r(n, n2);
            }
        };
        this.k = e.d();
        this.l = (h<r>)kotlinx.coroutines.flow.n.a(0, 64, BufferOverflow.DROP_OLDEST);
        this.p((a<r>)new a<r>(this) {
            final PagingDataDiffer<T> this$0;
            
            public /* bridge */ Object invoke() {
                this.invoke();
                return r.a;
            }
            
            public final void invoke() {
                PagingDataDiffer.j(this.this$0).a((Object)r.a);
            }
        });
    }
    
    public static final o a(final PagingDataDiffer pagingDataDiffer) {
        return pagingDataDiffer.e;
    }
    
    public static final e b(final PagingDataDiffer pagingDataDiffer) {
        return pagingDataDiffer.a;
    }
    
    public static final int c(final PagingDataDiffer pagingDataDiffer) {
        return pagingDataDiffer.i;
    }
    
    public static final boolean d(final PagingDataDiffer pagingDataDiffer) {
        return pagingDataDiffer.h;
    }
    
    public static final CoroutineDispatcher e(final PagingDataDiffer pagingDataDiffer) {
        return pagingDataDiffer.b;
    }
    
    public static final CopyOnWriteArrayList f(final PagingDataDiffer pagingDataDiffer) {
        return pagingDataDiffer.f;
    }
    
    public static final w g(final PagingDataDiffer pagingDataDiffer) {
        return pagingDataDiffer.c;
    }
    
    public static final PagingDataDiffer$a h(final PagingDataDiffer pagingDataDiffer) {
        return pagingDataDiffer.j;
    }
    
    public static final f0 i(final PagingDataDiffer pagingDataDiffer) {
        return pagingDataDiffer.d;
    }
    
    public static final h j(final PagingDataDiffer pagingDataDiffer) {
        return pagingDataDiffer.l;
    }
    
    public static final void k(final PagingDataDiffer pagingDataDiffer, final int i) {
        pagingDataDiffer.i = i;
    }
    
    public static final void l(final PagingDataDiffer pagingDataDiffer, final boolean h) {
        pagingDataDiffer.h = h;
    }
    
    public static final void m(final PagingDataDiffer pagingDataDiffer, final w c) {
        pagingDataDiffer.c = c;
    }
    
    public static final void n(final PagingDataDiffer pagingDataDiffer, final f0 d) {
        pagingDataDiffer.d = d;
    }
    
    public final void A(final sa.l<? super androidx.paging.c, r> l) {
        kotlin.jvm.internal.o.g((Object)l, "listener");
        this.e.g(l);
    }
    
    public final void B(final a<r> a) {
        kotlin.jvm.internal.o.g((Object)a, "listener");
        this.f.remove(a);
    }
    
    public final void C() {
        final f0 d = this.d;
        if (d != null) {
            d.b();
        }
    }
    
    public final k<T> D() {
        return this.c.r();
    }
    
    public final void o(final sa.l<? super androidx.paging.c, r> l) {
        kotlin.jvm.internal.o.g((Object)l, "listener");
        this.e.a(l);
    }
    
    public final void p(final a<r> a) {
        kotlin.jvm.internal.o.g((Object)a, "listener");
        this.f.add(a);
    }
    
    public final Object q(final y<T> y, final kotlin.coroutines.c<? super r> c) {
        final Object c2 = SingleRunner.c(this.g, 0, (sa.l)new PagingDataDiffer$collectFrom.PagingDataDiffer$collectFrom$2(this, (y)y, (kotlin.coroutines.c)null), c, 1, null);
        if (c2 == kotlin.coroutines.intrinsics.a.d()) {
            return c2;
        }
        return r.a;
    }
    
    public final void r(final n n, final n n2) {
        kotlin.jvm.internal.o.g((Object)n, "source");
        if (kotlin.jvm.internal.o.b((Object)this.e.f(), (Object)n) && kotlin.jvm.internal.o.b((Object)this.e.e(), (Object)n2)) {
            return;
        }
        this.e.h(n, n2);
    }
    
    public final T s(final int i) {
        this.h = true;
        this.i = i;
        final f0 d = this.d;
        if (d != null) {
            d.a(this.c.g(i));
        }
        return this.c.l(i);
    }
    
    public final c<androidx.paging.c> t() {
        return this.k;
    }
    
    public final c<r> u() {
        return (c<r>)kotlinx.coroutines.flow.e.a((h)this.l);
    }
    
    public final int v() {
        return this.c.a();
    }
    
    public final T w(final int n) {
        return this.c.l(n);
    }
    
    public abstract boolean x();
    
    public abstract Object y(final androidx.paging.r<T> p0, final androidx.paging.r<T> p1, final int p2, final a<r> p3, final kotlin.coroutines.c<? super Integer> p4);
    
    public final void z() {
        final f0 d = this.d;
        if (d != null) {
            d.refresh();
        }
    }
}
