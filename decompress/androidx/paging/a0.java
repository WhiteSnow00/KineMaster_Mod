// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlinx.coroutines.flow.s;
import kotlin.coroutines.c;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004J\u0013\u0010\u0006\u001a\u00020\u0005H¦@\u00f8\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r" }, d2 = { "Landroidx/paging/a0;", "", "Key", "Value", "Landroidx/paging/c0;", "Landroidx/paging/RemoteMediator$InitializeAction;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/s;", "Landroidx/paging/n;", "getState", "()Lkotlinx/coroutines/flow/s;", "state", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public interface a0<Key, Value> extends c0<Key, Value>
{
    Object a(final c<? super RemoteMediator.InitializeAction> p0);
    
    s<n> getState();
}
