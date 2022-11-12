// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import sa.p;
import kotlinx.coroutines.h;
import kotlinx.coroutines.z;
import kotlinx.coroutines.n2;
import kotlin.coroutines.CoroutineContext$b;
import kotlinx.coroutines.t1;
import ka.k;
import kotlin.coroutines.jvm.internal.f;
import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.n;
import sa.l;
import kotlinx.coroutines.o;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.d;
import kotlinx.coroutines.q1;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0086@\u00f8\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\b*\u00020\u0001H\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011" }, d2 = { "R", "Landroidx/room/RoomDatabase;", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "d", "(Landroidx/room/RoomDatabase;Lsa/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "c", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/q1;", "controlJob", "Lkotlin/coroutines/d;", "b", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/q1;Lkotlin/coroutines/c;)Ljava/lang/Object;", "room-ktx_release" }, k = 2, mv = { 1, 7, 1 })
public final class RoomDatabaseKt
{
    public static final Object a(final RoomDatabase roomDatabase, final c c) {
        return c(roomDatabase, (c<? super CoroutineContext>)c);
    }
    
    private static final Object b(final Executor executor, final q1 q1, final c<? super d> c) {
        final o o = new o(a.c((c)c), 1);
        o.z();
        ((n)o).p((l)new RoomDatabaseKt$acquireTransactionThread$2.RoomDatabaseKt$acquireTransactionThread$2$1(q1));
        try {
            executor.execute((Runnable)new RoomDatabaseKt$acquireTransactionThread$2.RoomDatabaseKt$acquireTransactionThread$2$2((n)o, q1));
        }
        catch (final RejectedExecutionException ex) {
            ((n)o).m((Throwable)new IllegalStateException("Unable to acquire a thread to perform the database transaction.", ex));
        }
        final Object v = o.v();
        if (v == a.d()) {
            f.c((c)c);
        }
        return v;
    }
    
    private static final Object c(final RoomDatabase l$0, final c<? super CoroutineContext> c) {
        RoomDatabaseKt$createTransactionContext.RoomDatabaseKt$createTransactionContext$1 roomDatabaseKt$createTransactionContext$2 = null;
        Label_0046: {
            if (c instanceof RoomDatabaseKt$createTransactionContext.RoomDatabaseKt$createTransactionContext$1) {
                final RoomDatabaseKt$createTransactionContext.RoomDatabaseKt$createTransactionContext$1 roomDatabaseKt$createTransactionContext$1 = (RoomDatabaseKt$createTransactionContext.RoomDatabaseKt$createTransactionContext$1)c;
                final int label = roomDatabaseKt$createTransactionContext$1.label;
                if ((label & Integer.MIN_VALUE) != 0x0) {
                    roomDatabaseKt$createTransactionContext$1.label = label + Integer.MIN_VALUE;
                    roomDatabaseKt$createTransactionContext$2 = roomDatabaseKt$createTransactionContext$1;
                    break Label_0046;
                }
            }
            roomDatabaseKt$createTransactionContext$2 = new RoomDatabaseKt$createTransactionContext.RoomDatabaseKt$createTransactionContext$1((c)c);
        }
        Object result = roomDatabaseKt$createTransactionContext$2.result;
        final Object d = a.d();
        final int label2 = roomDatabaseKt$createTransactionContext$2.label;
        Object o;
        RoomDatabase roomDatabase;
        if (label2 != 0) {
            if (label2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o = roomDatabaseKt$createTransactionContext$2.L$1;
            roomDatabase = (RoomDatabase)roomDatabaseKt$createTransactionContext$2.L$0;
            k.b(result);
        }
        else {
            k.b(result);
            final z b = t1.b((q1)null, 1, (Object)null);
            final q1 q1 = (q1)((c)roomDatabaseKt$createTransactionContext$2).getContext().get((CoroutineContext$b)kotlinx.coroutines.q1.u);
            if (q1 != null) {
                q1.i((l)new RoomDatabaseKt$createTransactionContext.RoomDatabaseKt$createTransactionContext$2(b));
            }
            final Executor transactionExecutor = l$0.getTransactionExecutor();
            kotlin.jvm.internal.o.f((Object)transactionExecutor, "transactionExecutor");
            roomDatabaseKt$createTransactionContext$2.L$0 = l$0;
            roomDatabaseKt$createTransactionContext$2.L$1 = b;
            roomDatabaseKt$createTransactionContext$2.label = 1;
            final Object b2 = b(transactionExecutor, (q1)b, (c<? super d>)roomDatabaseKt$createTransactionContext$2);
            if (b2 == d) {
                return d;
            }
            roomDatabase = l$0;
            o = b;
            result = b2;
        }
        final d d2 = (d)result;
        final y0 y0 = new y0((q1)o, d2);
        final ThreadLocal<Integer> suspendingTransactionId = roomDatabase.getSuspendingTransactionId();
        kotlin.jvm.internal.o.f((Object)suspendingTransactionId, "suspendingTransactionId");
        return ((CoroutineContext)d2).plus((CoroutineContext)y0).plus((CoroutineContext)n2.a((ThreadLocal)suspendingTransactionId, (Object)kotlin.coroutines.jvm.internal.a.b(System.identityHashCode(o))));
    }
    
    public static final <R> Object d(RoomDatabase l$0, l<? super c<? super R>, ?> l$2, final c<? super R> c) {
        RoomDatabaseKt$withTransaction.RoomDatabaseKt$withTransaction$1 roomDatabaseKt$withTransaction$2 = null;
        Label_0050: {
            if (c instanceof RoomDatabaseKt$withTransaction.RoomDatabaseKt$withTransaction$1) {
                final RoomDatabaseKt$withTransaction.RoomDatabaseKt$withTransaction$1 roomDatabaseKt$withTransaction$1 = (RoomDatabaseKt$withTransaction.RoomDatabaseKt$withTransaction$1)c;
                final int label = roomDatabaseKt$withTransaction$1.label;
                if ((label & Integer.MIN_VALUE) != 0x0) {
                    roomDatabaseKt$withTransaction$1.label = label + Integer.MIN_VALUE;
                    roomDatabaseKt$withTransaction$2 = roomDatabaseKt$withTransaction$1;
                    break Label_0050;
                }
            }
            roomDatabaseKt$withTransaction$2 = new RoomDatabaseKt$withTransaction.RoomDatabaseKt$withTransaction$1((c)c);
        }
        Object o = roomDatabaseKt$withTransaction$2.result;
        final Object d = a.d();
        final int label2 = roomDatabaseKt$withTransaction$2.label;
        Object f = null;
        Label_0209: {
            if (label2 != 0) {
                if (label2 != 1) {
                    if (label2 == 2) {
                        k.b(o);
                        return o;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                else {
                    l$2 = (l)roomDatabaseKt$withTransaction$2.L$1;
                    l$0 = (RoomDatabase)roomDatabaseKt$withTransaction$2.L$0;
                    k.b(o);
                }
            }
            else {
                k.b(o);
                final y0 y0 = (y0)((c)roomDatabaseKt$withTransaction$2).getContext().get((CoroutineContext$b)androidx.room.y0.d);
                if (y0 != null) {
                    f = y0.f();
                    if (f != null) {
                        break Label_0209;
                    }
                }
                roomDatabaseKt$withTransaction$2.L$0 = l$0;
                roomDatabaseKt$withTransaction$2.L$1 = l$2;
                roomDatabaseKt$withTransaction$2.label = 1;
                if ((o = c(l$0, (c<? super CoroutineContext>)roomDatabaseKt$withTransaction$2)) == d) {
                    return d;
                }
            }
            f = o;
        }
        final RoomDatabaseKt$withTransaction.RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$3 = new RoomDatabaseKt$withTransaction.RoomDatabaseKt$withTransaction$2(l$0, l$2, (c)null);
        roomDatabaseKt$withTransaction$2.L$0 = null;
        roomDatabaseKt$withTransaction$2.L$1 = null;
        roomDatabaseKt$withTransaction$2.label = 2;
        if ((o = h.e((CoroutineContext)f, (p)roomDatabaseKt$withTransaction$3, (c)roomDatabaseKt$withTransaction$2)) == d) {
            return d;
        }
        return o;
    }
}
