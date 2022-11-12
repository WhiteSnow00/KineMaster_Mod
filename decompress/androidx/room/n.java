// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.concurrent.Executor;
import java.util.Map;
import kotlinx.coroutines.i1;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006" }, d2 = { "Landroidx/room/RoomDatabase;", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "b", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/CoroutineDispatcher;", "transactionDispatcher", "room-ktx_release" }, k = 2, mv = { 1, 7, 1 })
public final class n
{
    public static final CoroutineDispatcher a(final RoomDatabase roomDatabase) {
        o.g((Object)roomDatabase, "<this>");
        final Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        o.f((Object)backingFieldMap, "backingFieldMap");
        Object o;
        if ((o = backingFieldMap.get("QueryDispatcher")) == null) {
            final Executor queryExecutor = roomDatabase.getQueryExecutor();
            kotlin.jvm.internal.o.f((Object)queryExecutor, "queryExecutor");
            o = i1.a(queryExecutor);
            backingFieldMap.put("QueryDispatcher", o);
        }
        kotlin.jvm.internal.o.e(o, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher)o;
    }
    
    public static final CoroutineDispatcher b(final RoomDatabase roomDatabase) {
        o.g((Object)roomDatabase, "<this>");
        final Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        o.f((Object)backingFieldMap, "backingFieldMap");
        Object o;
        if ((o = backingFieldMap.get("TransactionDispatcher")) == null) {
            final Executor transactionExecutor = roomDatabase.getTransactionExecutor();
            kotlin.jvm.internal.o.f((Object)transactionExecutor, "transactionExecutor");
            o = i1.a(transactionExecutor);
            backingFieldMap.put("TransactionDispatcher", o);
        }
        kotlin.jvm.internal.o.e(o, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher)o;
    }
}
