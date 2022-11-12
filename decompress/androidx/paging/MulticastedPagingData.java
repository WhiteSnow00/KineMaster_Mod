// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import ka.r;
import kotlin.jvm.internal.i;
import sa.q;
import sa.p;
import kotlinx.coroutines.flow.e;
import kotlin.coroutines.c;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.j0;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0013\u0010\u0006\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c" }, d2 = { "Landroidx/paging/MulticastedPagingData;", "", "T", "Landroidx/paging/y;", "a", "Lka/r;", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/j0;", "Lkotlinx/coroutines/j0;", "getScope", "()Lkotlinx/coroutines/j0;", "scope", "Landroidx/paging/y;", "getParent", "()Landroidx/paging/y;", "parent", "Landroidx/paging/ActiveFlowTracker;", "c", "Landroidx/paging/ActiveFlowTracker;", "()Landroidx/paging/ActiveFlowTracker;", "tracker", "Landroidx/paging/CachedPageEventFlow;", "d", "Landroidx/paging/CachedPageEventFlow;", "accumulated", "<init>", "(Lkotlinx/coroutines/j0;Landroidx/paging/y;Landroidx/paging/ActiveFlowTracker;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
final class MulticastedPagingData<T>
{
    private final j0 a;
    private final y<T> b;
    private final ActiveFlowTracker c;
    private final CachedPageEventFlow<T> d;
    
    public MulticastedPagingData(final j0 a, final y<T> b, final ActiveFlowTracker c) {
        o.g((Object)a, "scope");
        o.g((Object)b, "parent");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = new CachedPageEventFlow<T>((kotlinx.coroutines.flow.c<? extends u<T>>)e.z(e.A((kotlinx.coroutines.flow.c)b.b(), (p)new MulticastedPagingData$accumulated.MulticastedPagingData$accumulated$1(this, (c)null)), (q)new MulticastedPagingData$accumulated.MulticastedPagingData$accumulated$2(this, (c)null)), a);
    }
    
    public MulticastedPagingData(final j0 j0, final y y, ActiveFlowTracker activeFlowTracker, final int n, final i i) {
        if ((n & 0x4) != 0x0) {
            activeFlowTracker = null;
        }
        this(j0, y, activeFlowTracker);
    }
    
    public final y<T> a() {
        return new y<T>(this.d.f(), this.b.c());
    }
    
    public final Object b(final c<? super r> c) {
        this.d.e();
        return r.a;
    }
    
    public final ActiveFlowTracker c() {
        return this.c;
    }
}
