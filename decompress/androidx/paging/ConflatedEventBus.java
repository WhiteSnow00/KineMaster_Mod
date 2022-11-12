// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import kotlinx.coroutines.flow.t;
import kotlinx.coroutines.flow.c;
import kotlin.Pair;
import kotlinx.coroutines.flow.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006R(\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\n\u0010\u000f¨\u0006\u0013" }, d2 = { "Landroidx/paging/ConflatedEventBus;", "", "T", "data", "Lka/r;", "b", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/i;", "Lkotlin/Pair;", "", "a", "Lkotlinx/coroutines/flow/i;", "state", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/c;", "()Lkotlinx/coroutines/flow/c;", "flow", "initialValue", "<init>", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class ConflatedEventBus<T>
{
    private final i<Pair<Integer, T>> a;
    private final c<T> b;
    
    public ConflatedEventBus(final T t) {
        final i a = t.a((Object)new Pair((Object)Integer.MIN_VALUE, (Object)t));
        this.a = (i<Pair<Integer, T>>)a;
        this.b = (c<T>)new ConflatedEventBus$special$$inlined$mapNotNull.ConflatedEventBus$special$$inlined$mapNotNull$1((c)a);
    }
    
    public ConflatedEventBus(Object o, final int n, final kotlin.jvm.internal.i i) {
        if ((n & 0x1) != 0x0) {
            o = null;
        }
        this(o);
    }
    
    public final c<T> a() {
        return this.b;
    }
    
    public final void b(final T t) {
        o.g((Object)t, "data");
        final i<Pair<Integer, T>> a = this.a;
        a.setValue((Object)new Pair((Object)(((Number)((Pair)a.getValue()).getFirst()).intValue() + 1), (Object)t));
    }
}
