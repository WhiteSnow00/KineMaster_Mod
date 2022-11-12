// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.flow.n;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.c;
import ka.r;
import sa.p;
import kotlin.jvm.internal.o;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0002\t\u000fB\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005R\u0018\u0010\r\u001a\u00060\u000bR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014" }, d2 = { "Landroidx/paging/HintHandler;", "", "Landroidx/paging/LoadType;", "loadType", "Lkotlinx/coroutines/flow/c;", "Landroidx/paging/g0;", "c", "viewportHint", "Lka/r;", "a", "d", "Landroidx/paging/HintHandler$b;", "Landroidx/paging/HintHandler$b;", "state", "Landroidx/paging/g0$a;", "b", "()Landroidx/paging/g0$a;", "lastAccessHint", "<init>", "()V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class HintHandler
{
    private final b a;
    
    public HintHandler() {
        this.a = new b();
    }
    
    public final void a(final LoadType loadType, final g0 g0) {
        o.g((Object)loadType, "loadType");
        o.g((Object)g0, "viewportHint");
        if (loadType == LoadType.PREPEND || loadType == LoadType.APPEND) {
            this.a.d(null, (p<? super a, ? super a, r>)new HintHandler$forceSetHint.HintHandler$forceSetHint$2(loadType, g0));
            return;
        }
        throw new IllegalArgumentException(o.n("invalid load type for reset: ", (Object)loadType).toString());
    }
    
    public final g0.a b() {
        return this.a.b();
    }
    
    public final kotlinx.coroutines.flow.c<g0> c(final LoadType loadType) {
        o.g((Object)loadType, "loadType");
        final int n = c.a[loadType.ordinal()];
        kotlinx.coroutines.flow.c<g0> c;
        if (n != 1) {
            if (n != 2) {
                throw new IllegalArgumentException("invalid load type for hints");
            }
            c = this.a.a();
        }
        else {
            c = this.a.c();
        }
        return c;
    }
    
    public final void d(final g0 g0) {
        o.g((Object)g0, "viewportHint");
        final b a = this.a;
        g0.a a2;
        if (g0 instanceof g0.a) {
            a2 = (g0.a)g0;
        }
        else {
            a2 = null;
        }
        a.d(a2, (p<? super a, ? super a, r>)new HintHandler$processHint.HintHandler$processHint$1(g0));
    }
    
    @Metadata(bv = {}, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R.\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u000e¨\u0006\u0012" }, d2 = { "Landroidx/paging/HintHandler$a;", "", "Landroidx/paging/g0;", "value", "a", "Landroidx/paging/g0;", "b", "()Landroidx/paging/g0;", "c", "(Landroidx/paging/g0;)V", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/h;", "_flow", "Lkotlinx/coroutines/flow/c;", "()Lkotlinx/coroutines/flow/c;", "flow", "<init>", "(Landroidx/paging/HintHandler;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    private final class a
    {
        private g0 a;
        private final h<g0> b;
        final HintHandler c;
        
        public a(final HintHandler c) {
            o.g((Object)c, "this$0");
            this.c = c;
            this.b = (h<g0>)n.b(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object)null);
        }
        
        public final kotlinx.coroutines.flow.c<g0> a() {
            return (kotlinx.coroutines.flow.c<g0>)this.b;
        }
        
        public final g0 b() {
            return this.a;
        }
        
        public final void c(final g0 a) {
            this.a = a;
            if (a != null) {
                this.b.a((Object)a);
            }
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ2\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022 \u0010\b\u001a\u001c\u0012\b\u0012\u00060\u0005R\u00020\u0006\u0012\b\u0012\u00060\u0005R\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004R\u0018\u0010\f\u001a\u00060\u0005R\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u00060\u0005R\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR(\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\r\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0019R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0019¨\u0006\u001e" }, d2 = { "Landroidx/paging/HintHandler$b;", "", "Landroidx/paging/g0$a;", "accessHint", "Lkotlin/Function2;", "Landroidx/paging/HintHandler$a;", "Landroidx/paging/HintHandler;", "Lka/r;", "block", "d", "a", "Landroidx/paging/HintHandler$a;", "prepend", "b", "append", "<set-?>", "c", "Landroidx/paging/g0$a;", "()Landroidx/paging/g0$a;", "lastAccessHint", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Lkotlinx/coroutines/flow/c;", "Landroidx/paging/g0;", "()Lkotlinx/coroutines/flow/c;", "prependFlow", "appendFlow", "<init>", "(Landroidx/paging/HintHandler;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
    private final class b
    {
        private final a a;
        private final a b;
        private g0.a c;
        private final ReentrantLock d;
        final HintHandler e;
        
        public b(final HintHandler e) {
            o.g((Object)e, "this$0");
            this.e = e;
            this.a = new a();
            this.b = new a();
            this.d = new ReentrantLock();
        }
        
        public final kotlinx.coroutines.flow.c<g0> a() {
            return this.b.a();
        }
        
        public final g0.a b() {
            return this.c;
        }
        
        public final kotlinx.coroutines.flow.c<g0> c() {
            return this.a.a();
        }
        
        public final void d(final g0.a c, final p<? super a, ? super a, r> p2) {
            o.g((Object)p2, "block");
            final ReentrantLock d = this.d;
            d.lock();
            Label_0026: {
                if (c == null) {
                    break Label_0026;
                }
                try {
                    this.c = c;
                    p2.invoke((Object)this.a, (Object)this.b);
                    final r a = r.a;
                }
                finally {
                    d.unlock();
                }
            }
        }
    }
    
    @Metadata(k = 3, mv = { 1, 5, 1 }, xi = 48)
    public final class c
    {
        public static final int[] a;
        
        static {
            final int[] a2 = new int[LoadType.values().length];
            a2[LoadType.PREPEND.ordinal()] = 1;
            a2[LoadType.APPEND.ordinal()] = 2;
            a = a2;
        }
    }
}
