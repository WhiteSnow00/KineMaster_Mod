// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlin.coroutines.jvm.internal.f;
import sa.l;
import sa.p;
import kotlinx.coroutines.CoroutineStart;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.o;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.CoroutineContext$b;
import kotlin.coroutines.c;
import java.util.concurrent.Callable;
import android.os.CancellationSignal;
import kotlin.jvm.internal.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004" }, d2 = { "Landroidx/room/CoroutinesRoom;", "", "a", "Companion", "room-ktx_release" }, k = 1, mv = { 1, 7, 1 })
public final class CoroutinesRoom
{
    public static final Companion a;
    
    static {
        a = new Companion(null);
    }
    
    public static final <R> Object a(final RoomDatabase roomDatabase, final boolean b, final CancellationSignal cancellationSignal, final Callable<R> callable, final c<? super R> c) {
        return CoroutinesRoom.a.a(roomDatabase, b, cancellationSignal, callable, c);
    }
    
    public static final <R> Object b(final RoomDatabase roomDatabase, final boolean b, final Callable<R> callable, final c<? super R> c) {
        return CoroutinesRoom.a.b(roomDatabase, b, callable, c);
    }
    
    @Metadata(bv = {}, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087@\u00f8\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ?\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087@\u00f8\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011" }, d2 = { "Landroidx/room/CoroutinesRoom$Companion;", "", "R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "Ljava/util/concurrent/Callable;", "callable", "b", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroid/os/CancellationSignal;", "cancellationSignal", "a", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "room-ktx_release" }, k = 1, mv = { 1, 7, 1 })
    public static final class Companion
    {
        private Companion() {
        }
        
        public Companion(final i i) {
            this();
        }
        
        public final <R> Object a(final RoomDatabase roomDatabase, final boolean b, final CancellationSignal cancellationSignal, final Callable<R> callable, final c<? super R> c) {
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            final y0 y0 = (y0)c.getContext().get((CoroutineContext$b)androidx.room.y0.d);
            Object f;
            if (y0 == null || (f = y0.f()) == null) {
                CoroutineDispatcher coroutineDispatcher;
                if (b) {
                    coroutineDispatcher = n.b(roomDatabase);
                }
                else {
                    coroutineDispatcher = n.a(roomDatabase);
                }
                f = coroutineDispatcher;
            }
            final o o = new o(kotlin.coroutines.intrinsics.a.c((c)c), 1);
            o.z();
            ((kotlinx.coroutines.n)o).p((l)new CoroutinesRoom$Companion$execute$4.CoroutinesRoom$Companion$execute$4$1(cancellationSignal, h.b((j0)j1.a, (CoroutineContext)f, (CoroutineStart)null, (p)new CoroutinesRoom$Companion$execute$4$job.CoroutinesRoom$Companion$execute$4$job$1((Callable)callable, (kotlinx.coroutines.n)o, (c)null), 2, (Object)null)));
            final Object v = o.v();
            if (v == kotlin.coroutines.intrinsics.a.d()) {
                kotlin.coroutines.jvm.internal.f.c((c)c);
            }
            return v;
        }
        
        public final <R> Object b(final RoomDatabase roomDatabase, final boolean b, final Callable<R> callable, final c<? super R> c) {
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            final y0 y0 = (y0)c.getContext().get((CoroutineContext$b)androidx.room.y0.d);
            Object f;
            if (y0 == null || (f = y0.f()) == null) {
                CoroutineDispatcher coroutineDispatcher;
                if (b) {
                    coroutineDispatcher = n.b(roomDatabase);
                }
                else {
                    coroutineDispatcher = n.a(roomDatabase);
                }
                f = coroutineDispatcher;
            }
            return h.e((CoroutineContext)f, (p)new CoroutinesRoom$Companion$execute.CoroutinesRoom$Companion$execute$2((Callable)callable, (c)null), (c)c);
        }
    }
}
