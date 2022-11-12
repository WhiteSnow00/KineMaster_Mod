// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import sa.l;
import kotlinx.coroutines.flow.s;
import kotlinx.coroutines.flow.t;
import kotlinx.coroutines.flow.i;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\b\u001a\u00028\u0002\"\u0004\b\u0002\u0010\u00042\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00158F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0016¨\u0006\u001a" }, d2 = { "Landroidx/paging/a;", "", "Key", "Value", "R", "Lkotlin/Function1;", "Landroidx/paging/AccessorState;", "block", "b", "(Lsa/l;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantLock;", "a", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Lkotlinx/coroutines/flow/i;", "Landroidx/paging/n;", "Lkotlinx/coroutines/flow/i;", "_loadStates", "c", "Landroidx/paging/AccessorState;", "internalState", "Lkotlinx/coroutines/flow/s;", "()Lkotlinx/coroutines/flow/s;", "loadStates", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
final class a<Key, Value>
{
    private final ReentrantLock a;
    private final i<n> b;
    private final AccessorState<Key, Value> c;
    
    public a() {
        this.a = new ReentrantLock();
        this.b = (i<n>)t.a((Object)n.d.a());
        this.c = new AccessorState<Key, Value>();
    }
    
    public final s<n> a() {
        return (s<n>)this.b;
    }
    
    public final <R> R b(final l<? super AccessorState<Key, Value>, ? extends R> l) {
        o.g((Object)l, "block");
        final ReentrantLock a = this.a;
        a.lock();
        try {
            final Object invoke = l.invoke((Object)this.c);
            this.b.setValue((Object)this.c.e());
            return (R)invoke;
        }
        finally {
            a.unlock();
        }
    }
}
