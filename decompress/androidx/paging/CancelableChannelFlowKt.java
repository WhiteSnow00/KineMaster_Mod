// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import ka.r;
import kotlin.coroutines.c;
import sa.p;
import kotlinx.coroutines.q1;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012(\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0000\u00f8\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f" }, d2 = { "T", "Lkotlinx/coroutines/q1;", "controller", "Lkotlin/Function2;", "Landroidx/paging/d0;", "Lkotlin/coroutines/c;", "Lka/r;", "", "block", "Lkotlinx/coroutines/flow/c;", "a", "(Lkotlinx/coroutines/q1;Lsa/p;)Lkotlinx/coroutines/flow/c;", "paging-common" }, k = 2, mv = { 1, 5, 1 })
public final class CancelableChannelFlowKt
{
    public static final <T> kotlinx.coroutines.flow.c<T> a(final q1 q1, final p<? super d0<T>, ? super c<? super r>, ?> p2) {
        o.g((Object)q1, "controller");
        o.g((Object)p2, "block");
        return SimpleChannelFlowKt.a((sa.p<? super d0<T>, ? super c<? super r>, ?>)new CancelableChannelFlowKt$cancelableChannelFlow.CancelableChannelFlowKt$cancelableChannelFlow$1(q1, (p)p2, (c)null));
    }
}
