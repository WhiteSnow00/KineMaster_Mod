// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h;
import kotlinx.coroutines.v0;
import kotlin.coroutines.c;
import kotlinx.coroutines.j0;
import sa.p;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aA\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\t\u0010\b\u001aA\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\n\u0010\b\u001aI\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f" }, d2 = { "T", "Landroidx/lifecycle/Lifecycle;", "Lkotlin/Function2;", "Lkotlinx/coroutines/j0;", "Lkotlin/coroutines/c;", "", "block", "a", "(Landroidx/lifecycle/Lifecycle;Lsa/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "c", "b", "Landroidx/lifecycle/Lifecycle$State;", "minState", "d", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lsa/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release" }, k = 2, mv = { 1, 6, 0 })
public final class PausingDispatcherKt
{
    public static final <T> Object a(final Lifecycle lifecycle, final p<? super j0, ? super c<? super T>, ?> p3, final c<? super T> c) {
        return d(lifecycle, Lifecycle.State.CREATED, (sa.p<? super j0, ? super kotlin.coroutines.c<? super Object>, ?>)p3, (kotlin.coroutines.c<? super Object>)c);
    }
    
    public static final <T> Object b(final Lifecycle lifecycle, final p<? super j0, ? super c<? super T>, ?> p3, final c<? super T> c) {
        return d(lifecycle, Lifecycle.State.RESUMED, (sa.p<? super j0, ? super kotlin.coroutines.c<? super Object>, ?>)p3, (kotlin.coroutines.c<? super Object>)c);
    }
    
    public static final <T> Object c(final Lifecycle lifecycle, final p<? super j0, ? super c<? super T>, ?> p3, final c<? super T> c) {
        return d(lifecycle, Lifecycle.State.STARTED, (sa.p<? super j0, ? super kotlin.coroutines.c<? super Object>, ?>)p3, (kotlin.coroutines.c<? super Object>)c);
    }
    
    public static final <T> Object d(final Lifecycle lifecycle, final Lifecycle.State state, final p<? super j0, ? super c<? super T>, ?> p4, final c<? super T> c) {
        return h.e((CoroutineContext)v0.c().f0(), (p)new PausingDispatcherKt$whenStateAtLeast.PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, (p)p4, (c)null), (c)c);
    }
}
