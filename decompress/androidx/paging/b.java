// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.coroutines.intrinsics.a;
import ka.r;
import kotlin.coroutines.c;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.channels.u;
import kotlin.Metadata;
import kotlinx.coroutines.flow.d;

@Metadata(bv = {}, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f" }, d2 = { "Landroidx/paging/b;", "T", "Lkotlinx/coroutines/flow/d;", "value", "Lka/r;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/u;", "a", "Lkotlinx/coroutines/channels/u;", "b", "()Lkotlinx/coroutines/channels/u;", "channel", "<init>", "(Lkotlinx/coroutines/channels/u;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class b<T> implements d<T>
{
    private final u<T> a;
    
    public b(final u<? super T> a) {
        o.g((Object)a, "channel");
        this.a = (u<T>)a;
    }
    
    public final u<T> b() {
        return this.a;
    }
    
    public Object emit(final T t, final c<? super r> c) {
        final Object z = this.b().z((Object)t, (c)c);
        if (z == kotlin.coroutines.intrinsics.a.d()) {
            return z;
        }
        return r.a;
    }
}
