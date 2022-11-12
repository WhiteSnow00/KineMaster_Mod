// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.i;
import sa.l;
import kotlin.jvm.internal.o;
import sa.a;
import kotlinx.coroutines.flow.c;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001BM\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00018\u0000\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015B7\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00018\u0000\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0016R)\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u00048\u0006¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0006\u0010\b¨\u0006\u0017" }, d2 = { "Landroidx/paging/Pager;", "", "Key", "Value", "Lkotlinx/coroutines/flow/c;", "Landroidx/paging/y;", "a", "Lkotlinx/coroutines/flow/c;", "()Lkotlinx/coroutines/flow/c;", "getFlow$annotations", "()V", "flow", "Landroidx/paging/x;", "config", "initialKey", "Landroidx/paging/RemoteMediator;", "remoteMediator", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "pagingSourceFactory", "<init>", "(Landroidx/paging/x;Ljava/lang/Object;Landroidx/paging/RemoteMediator;Lsa/a;)V", "(Landroidx/paging/x;Ljava/lang/Object;Lsa/a;)V", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public final class Pager<Key, Value>
{
    private final c<y<Value>> a;
    
    public Pager(final x x, final Key key, final RemoteMediator<Key, Value> remoteMediator, final a<? extends PagingSource<Key, Value>> a) {
        o.g((Object)x, "config");
        o.g((Object)a, "pagingSourceFactory");
        Object o;
        if (a instanceof SuspendingPagingSourceFactory) {
            o = new Pager$flow.Pager$flow$1((Object)a);
        }
        else {
            o = new Pager$flow.Pager$flow$2((a)a, (kotlin.coroutines.c)null);
        }
        this.a = new PageFetcher<Object, Value>((sa.l<? super kotlin.coroutines.c<? super PagingSource<Object, Object>>, ?>)o, key, x, (RemoteMediator<Object, Object>)remoteMediator).i();
    }
    
    public Pager(final x x, Object o, final RemoteMediator remoteMediator, final a a, final int n, final i i) {
        if ((n & 0x2) != 0x0) {
            o = null;
        }
        this(x, o, remoteMediator, (sa.a<? extends PagingSource<Object, Value>>)a);
    }
    
    public Pager(final x x, final Key key, final a<? extends PagingSource<Key, Value>> a) {
        o.g((Object)x, "config");
        o.g((Object)a, "pagingSourceFactory");
        this(x, key, null, (sa.a<? extends PagingSource<Object, Value>>)a);
    }
    
    public Pager(final x x, Object o, final a a, final int n, final i i) {
        if ((n & 0x2) != 0x0) {
            o = null;
        }
        this(x, o, (sa.a<? extends PagingSource<Object, Value>>)a);
    }
    
    public final c<y<Value>> a() {
        return this.a;
    }
}
