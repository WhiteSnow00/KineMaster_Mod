// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$b;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.q1$a;
import kotlin.coroutines.CoroutineContext$a$a;
import sa.p;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.i;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.d;
import kotlinx.coroutines.q1;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$a;

@Metadata(bv = {}, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\r\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019" }, d2 = { "Landroidx/room/y0;", "Lkotlin/coroutines/CoroutineContext$a;", "Lka/r;", "b", "g", "Lkotlinx/coroutines/q1;", "a", "Lkotlinx/coroutines/q1;", "transactionThreadControlJob", "Lkotlin/coroutines/d;", "Lkotlin/coroutines/d;", "f", "()Lkotlin/coroutines/d;", "transactionDispatcher", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "referenceCount", "Lkotlin/coroutines/CoroutineContext$b;", "getKey", "()Lkotlin/coroutines/CoroutineContext$b;", "key", "<init>", "(Lkotlinx/coroutines/q1;Lkotlin/coroutines/d;)V", "d", "room-ktx_release" }, k = 1, mv = { 1, 7, 1 })
public final class y0 implements CoroutineContext$a
{
    public static final a d;
    private final q1 a;
    private final d b;
    private final AtomicInteger c;
    
    static {
        d = new a(null);
    }
    
    public y0(final q1 a, final d b) {
        o.g((Object)a, "transactionThreadControlJob");
        o.g((Object)b, "transactionDispatcher");
        this.a = a;
        this.b = b;
        this.c = new AtomicInteger(0);
    }
    
    public final void b() {
        this.c.incrementAndGet();
    }
    
    public final d f() {
        return this.b;
    }
    
    public <R> R fold(final R r, final p<? super R, ? super CoroutineContext$a, ? extends R> p2) {
        return (R)CoroutineContext$a$a.a((CoroutineContext$a)this, (Object)r, (p)p2);
    }
    
    public final void g() {
        final int decrementAndGet = this.c.decrementAndGet();
        if (decrementAndGet >= 0) {
            if (decrementAndGet == 0) {
                q1$a.a(this.a, (CancellationException)null, 1, (Object)null);
            }
            return;
        }
        throw new IllegalStateException("Transaction was never started or was already released.");
    }
    
    public <E extends CoroutineContext$a> E get(final CoroutineContext$b<E> coroutineContext$b) {
        return (E)CoroutineContext$a$a.b((CoroutineContext$a)this, (CoroutineContext$b)coroutineContext$b);
    }
    
    public CoroutineContext$b<y0> getKey() {
        return (CoroutineContext$b<y0>)y0.d;
    }
    
    public CoroutineContext minusKey(final CoroutineContext$b<?> coroutineContext$b) {
        return CoroutineContext$a$a.c((CoroutineContext$a)this, (CoroutineContext$b)coroutineContext$b);
    }
    
    public CoroutineContext plus(final CoroutineContext coroutineContext) {
        return CoroutineContext$a$a.d((CoroutineContext$a)this, coroutineContext);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005" }, d2 = { "Landroidx/room/y0$a;", "Lkotlin/coroutines/CoroutineContext$b;", "Landroidx/room/y0;", "<init>", "()V", "room-ktx_release" }, k = 1, mv = { 1, 7, 1 })
    public static final class a implements CoroutineContext$b<y0>
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
    }
}
