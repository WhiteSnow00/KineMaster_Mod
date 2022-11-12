// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.jvm.internal.o;
import kotlinx.coroutines.j0;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aD\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0000¨\u0006\t" }, d2 = { "", "Key", "Value", "Lkotlinx/coroutines/j0;", "scope", "Landroidx/paging/RemoteMediator;", "delegate", "Landroidx/paging/a0;", "a", "paging-common" }, k = 2, mv = { 1, 5, 1 })
public final class b0
{
    public static final <Key, Value> a0<Key, Value> a(final j0 j0, final RemoteMediator<Key, Value> remoteMediator) {
        o.g((Object)j0, "scope");
        o.g((Object)remoteMediator, "delegate");
        return new RemoteMediatorAccessImpl<Key, Value>(j0, remoteMediator);
    }
}
