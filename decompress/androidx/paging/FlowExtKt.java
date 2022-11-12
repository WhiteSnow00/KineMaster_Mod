// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import ka.r;
import kotlinx.coroutines.flow.d;
import sa.p;
import kotlinx.coroutines.flow.e;
import kotlin.jvm.internal.o;
import sa.q;
import kotlinx.coroutines.flow.c;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a`\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u00012(\u0010\u0007\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0000\u00f8\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aR\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022(\u0010\u0007\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0000\u00f8\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a^\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022.\u0010\u000e\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0000\u00f8\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000b\"\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013" }, d2 = { "T", "R", "Lkotlinx/coroutines/flow/c;", "initial", "Lkotlin/Function3;", "Lkotlin/coroutines/c;", "", "operation", "c", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Object;Lsa/q;)Lkotlinx/coroutines/flow/c;", "b", "(Lkotlinx/coroutines/flow/c;Lsa/q;)Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/d;", "Lka/r;", "transform", "d", "a", "Ljava/lang/Object;", "NULL", "paging-common" }, k = 2, mv = { 1, 5, 1 })
public final class FlowExtKt
{
    private static final Object a;
    
    static {
        a = new Object();
    }
    
    public static final Object a() {
        return FlowExtKt.a;
    }
    
    public static final <T> c<T> b(final c<? extends T> c, final q<? super T, ? super T, ? super kotlin.coroutines.c<? super T>, ?> q) {
        o.g((Object)c, "<this>");
        o.g((Object)q, "operation");
        return (c<T>)e.t((p)new FlowExtKt$simpleRunningReduce.FlowExtKt$simpleRunningReduce$1((c)c, (q)q, (kotlin.coroutines.c)null));
    }
    
    public static final <T, R> c<R> c(final c<? extends T> c, final R r, final q<? super R, ? super T, ? super kotlin.coroutines.c<? super R>, ?> q) {
        o.g((Object)c, "<this>");
        o.g((Object)q, "operation");
        return (c<R>)e.t((p)new FlowExtKt$simpleScan.FlowExtKt$simpleScan$1((Object)r, (c)c, (q)q, (kotlin.coroutines.c)null));
    }
    
    public static final <T, R> c<R> d(final c<? extends T> c, final q<? super d<? super R>, ? super T, ? super kotlin.coroutines.c<? super r>, ?> q) {
        o.g((Object)c, "<this>");
        o.g((Object)q, "transform");
        return SimpleChannelFlowKt.a((sa.p<? super d0<R>, ? super kotlin.coroutines.c<? super r>, ?>)new FlowExtKt$simpleTransformLatest.FlowExtKt$simpleTransformLatest$1((c)c, (q)q, (kotlin.coroutines.c)null));
    }
}
