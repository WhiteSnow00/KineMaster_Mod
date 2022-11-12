// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.e;
import kotlin.jvm.internal.o;
import ka.r;
import kotlin.coroutines.c;
import sa.p;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002(\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0000\u00f8\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n" }, d2 = { "T", "Lkotlin/Function2;", "Landroidx/paging/d0;", "Lkotlin/coroutines/c;", "Lka/r;", "", "block", "Lkotlinx/coroutines/flow/c;", "a", "(Lsa/p;)Lkotlinx/coroutines/flow/c;", "paging-common" }, k = 2, mv = { 1, 5, 1 })
public final class SimpleChannelFlowKt
{
    public static final <T> kotlinx.coroutines.flow.c<T> a(final p<? super d0<T>, ? super c<? super r>, ?> p) {
        o.g((Object)p, "block");
        return (kotlinx.coroutines.flow.c<T>)e.d(e.t((p)new SimpleChannelFlowKt$simpleChannelFlow.SimpleChannelFlowKt$simpleChannelFlow$1((p)p, (c)null)), -2, (BufferOverflow)null, 2, (Object)null);
    }
}
