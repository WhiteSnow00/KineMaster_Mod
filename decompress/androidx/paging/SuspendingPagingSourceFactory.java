// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import sa.p;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlin.Metadata;
import sa.a;

@Metadata(bv = {}, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004J\u001f\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0096\u0002R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r" }, d2 = { "Landroidx/paging/SuspendingPagingSourceFactory;", "", "Key", "Value", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "c", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class SuspendingPagingSourceFactory<Key, Value> implements a<PagingSource<Key, Value>>
{
    private final CoroutineDispatcher a;
    private final a<PagingSource<Key, Value>> b;
    
    public static final a a(final SuspendingPagingSourceFactory suspendingPagingSourceFactory) {
        return suspendingPagingSourceFactory.b;
    }
    
    public final Object b(final c<? super PagingSource<Key, Value>> c) {
        return h.e((CoroutineContext)this.a, (p)new SuspendingPagingSourceFactory$create.SuspendingPagingSourceFactory$create$2(this, (c)null), (c)c);
    }
    
    public PagingSource<Key, Value> c() {
        return (PagingSource)this.b.invoke();
    }
    
    public /* bridge */ Object invoke() {
        return this.c();
    }
}
