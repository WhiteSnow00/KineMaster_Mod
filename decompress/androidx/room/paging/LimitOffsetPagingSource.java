// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room.paging;

import androidx.paging.z;
import java.util.List;
import kotlin.coroutines.jvm.internal.a;
import android.database.Cursor;
import sa.p;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h;
import androidx.room.n;
import sa.l;
import androidx.room.RoomDatabaseKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.c;
import java.util.Arrays;
import v0.j;
import java.util.Set;
import androidx.room.w;
import kotlin.jvm.internal.o;
import androidx.room.t0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import androidx.paging.PagingSource;

@Metadata(bv = {}, d1 = { "\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001*\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003B+\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010$\u001a\u00020#\u0012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020504\"\u000205¢\u0006\u0004\b7\u00108B-\b\u0016\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010$\u001a\u00020#\u0012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020504\"\u000205¢\u0006\u0004\b7\u0010;J-\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ5\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u0006\u0010\n\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u000e\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u0006\u0010\r\u001a\u00020\u0004H\u0002J&\u0010\u000f\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J7\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J-\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0096@\u00f8\u0001\u0000¢\u0006\u0004\b\u0017\u0010\tJ\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H%J%\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010\n\u001a\u00020&8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006<" }, d2 = { "Landroidx/room/paging/LimitOffsetPagingSource;", "", "Value", "Landroidx/paging/PagingSource;", "", "Landroidx/paging/PagingSource$a;", "params", "Landroidx/paging/PagingSource$b;", "initialLoad", "(Landroidx/paging/PagingSource$a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "itemCount", "loadFromDb", "(Landroidx/paging/PagingSource$a;ILkotlin/coroutines/c;)Ljava/lang/Object;", "key", "getLimit", "getOffset", "offset", "limit", "queryDatabase", "(IIILkotlin/coroutines/c;)Ljava/lang/Object;", "queryItemCount", "Lka/r;", "registerObserverIfNecessary", "load", "Landroid/database/Cursor;", "cursor", "", "convertRows", "Landroidx/paging/z;", "state", "getRefreshKey", "(Landroidx/paging/z;)Ljava/lang/Integer;", "Landroidx/room/t0;", "sourceQuery", "Landroidx/room/t0;", "Landroidx/room/RoomDatabase;", "db", "Landroidx/room/RoomDatabase;", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "getItemCount$room_paging_release", "()Ljava/util/concurrent/atomic/AtomicInteger;", "androidx/room/paging/LimitOffsetPagingSource$a", "observer", "Landroidx/room/paging/LimitOffsetPagingSource$a;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "registeredObserver", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "getJumpingSupported", "()Z", "jumpingSupported", "", "", "tables", "<init>", "(Landroidx/room/t0;Landroidx/room/RoomDatabase;[Ljava/lang/String;)V", "Lv0/j;", "supportSQLiteQuery", "(Lv0/j;Landroidx/room/RoomDatabase;[Ljava/lang/String;)V", "room-paging_release" }, k = 1, mv = { 1, 7, 1 })
public abstract class LimitOffsetPagingSource<Value> extends PagingSource<Integer, Value>
{
    private final RoomDatabase db;
    private final AtomicInteger itemCount;
    private final LimitOffsetPagingSource$a observer;
    private final AtomicBoolean registeredObserver;
    private final t0 sourceQuery;
    
    public LimitOffsetPagingSource(final t0 sourceQuery, final RoomDatabase db, final String... array) {
        o.g((Object)sourceQuery, "sourceQuery");
        o.g((Object)db, "db");
        o.g((Object)array, "tables");
        this.sourceQuery = sourceQuery;
        this.db = db;
        this.itemCount = new AtomicInteger(-1);
        this.observer = new w.c(array, this) {
            final LimitOffsetPagingSource<Value> a;
            
            @Override
            public void onInvalidated(final Set<String> set) {
                kotlin.jvm.internal.o.g((Object)set, "tables");
                this.a.invalidate();
            }
        };
        this.registeredObserver = new AtomicBoolean(false);
    }
    
    public LimitOffsetPagingSource(final j j, final RoomDatabase roomDatabase, final String... array) {
        o.g((Object)j, "supportSQLiteQuery");
        o.g((Object)roomDatabase, "db");
        o.g((Object)array, "tables");
        final t0 i = t0.i(j);
        o.f((Object)i, "copyFrom(supportSQLiteQuery)");
        this(i, roomDatabase, (String[])Arrays.copyOf(array, array.length));
    }
    
    public static final RoomDatabase access$getDb$p(final LimitOffsetPagingSource limitOffsetPagingSource) {
        return limitOffsetPagingSource.db;
    }
    
    public static final Object access$initialLoad(final LimitOffsetPagingSource limitOffsetPagingSource, final a a, final c c) {
        return limitOffsetPagingSource.initialLoad(a, c);
    }
    
    public static final Object access$loadFromDb(final LimitOffsetPagingSource limitOffsetPagingSource, final a a, final int n, final c c) {
        return limitOffsetPagingSource.loadFromDb(a, n, c);
    }
    
    public static final Object access$queryDatabase(final LimitOffsetPagingSource limitOffsetPagingSource, final int n, final int n2, final int n3, final c c) {
        return limitOffsetPagingSource.queryDatabase(n, n2, n3, c);
    }
    
    public static final int access$queryItemCount(final LimitOffsetPagingSource limitOffsetPagingSource) {
        return limitOffsetPagingSource.queryItemCount();
    }
    
    public static final void access$registerObserverIfNecessary(final LimitOffsetPagingSource limitOffsetPagingSource) {
        limitOffsetPagingSource.registerObserverIfNecessary();
    }
    
    private final int getLimit(final a<Integer> a, int n) {
        if (a instanceof a.c) {
            if (n >= a.b()) {
                n = a.b();
            }
        }
        else {
            n = a.b();
        }
        return n;
    }
    
    private final int getOffset(final a<Integer> a, final int n, final int n2) {
        int max;
        if (a instanceof a.c) {
            if (n < a.b()) {
                max = 0;
            }
            else {
                max = n - a.b();
            }
        }
        else if (a instanceof a.a) {
            max = n;
        }
        else {
            if (!(a instanceof a.d)) {
                throw new NoWhenBranchMatchedException();
            }
            if ((max = n) >= n2) {
                max = Math.max(0, n2 - a.b());
            }
        }
        return max;
    }
    
    private final Object initialLoad(final a<Integer> a, final c<? super b<Integer, Value>> c) {
        return RoomDatabaseKt.d(this.db, (sa.l<? super kotlin.coroutines.c<? super Object>, ?>)new LimitOffsetPagingSource$initialLoad.LimitOffsetPagingSource$initialLoad$2(this, (a)a, (c)null), (kotlin.coroutines.c<? super Object>)c);
    }
    
    static Object load$suspendImpl(final LimitOffsetPagingSource limitOffsetPagingSource, final a a, final c c) {
        return h.e((CoroutineContext)n.a(limitOffsetPagingSource.db), (p)new LimitOffsetPagingSource$load.LimitOffsetPagingSource$load$2(limitOffsetPagingSource, a, (c)null), c);
    }
    
    private final Object loadFromDb(final a<Integer> a, final int n, final c<? super b<Integer, Value>> c) {
        final Integer n2 = a.a();
        int intValue;
        if (n2 != null) {
            intValue = n2;
        }
        else {
            intValue = 0;
        }
        return this.queryDatabase(this.getOffset(a, intValue, n), this.getLimit(a, intValue), n, c);
    }
    
    private final Object queryDatabase(final int n, final int n2, final int n3, c<? super b<Integer, Value>> o) {
        final StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ( ");
        sb.append(this.sourceQuery.c());
        sb.append(" ) LIMIT ");
        sb.append(n2);
        sb.append(" OFFSET ");
        sb.append(n);
        Object o2 = t0.e(sb.toString(), this.sourceQuery.a());
        o.f(o2, "acquire(\n            lim\u2026eQuery.argCount\n        )");
        ((t0)o2).h(this.sourceQuery);
        o = this.db.query((j)o2);
        o.f(o, "db.query(sqLiteQuery)");
        try {
            final List<Value> convertRows = this.convertRows((Cursor)o);
            ((Cursor)o).close();
            ((t0)o2).l();
            final int n4 = convertRows.size() + n;
            if (!convertRows.isEmpty() && convertRows.size() >= n2 && n4 < n3) {
                o = kotlin.coroutines.jvm.internal.a.b(n4);
            }
            else {
                o = null;
            }
            if (n > 0 && !convertRows.isEmpty()) {
                o2 = kotlin.coroutines.jvm.internal.a.b(n);
            }
            else {
                o2 = null;
            }
            return new b.c(convertRows, o2, o, n, Math.max(0, n3 - n4));
        }
        finally {
            ((Cursor)o).close();
            ((t0)o2).l();
        }
    }
    
    private final int queryItemCount() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM ( ");
        sb.append(this.sourceQuery.c());
        sb.append(" )");
        final t0 e = t0.e(sb.toString(), this.sourceQuery.a());
        o.f((Object)e, "acquire(\n            cou\u2026eQuery.argCount\n        )");
        e.h(this.sourceQuery);
        final Cursor query = this.db.query(e);
        o.f((Object)query, "db.query(sqLiteQuery)");
        try {
            if (query.moveToFirst()) {
                return query.getInt(0);
            }
            return 0;
        }
        finally {
            query.close();
            e.l();
        }
    }
    
    private final void registerObserverIfNecessary() {
        if (this.registeredObserver.compareAndSet(false, true)) {
            this.db.getInvalidationTracker().b((w.c)this.observer);
        }
    }
    
    protected abstract List<Value> convertRows(final Cursor p0);
    
    public final AtomicInteger getItemCount$room_paging_release() {
        return this.itemCount;
    }
    
    @Override
    public boolean getJumpingSupported() {
        return true;
    }
    
    @Override
    public Integer getRefreshKey(final z<Integer, Value> z) {
        o.g((Object)z, "state");
        final int d = z.d().d;
        Integer value;
        if (z.c() == null) {
            value = null;
        }
        else {
            final Integer c = z.c();
            o.d((Object)c);
            value = Math.max(0, c - d / 2);
        }
        return value;
    }
    
    @Override
    public /* bridge */ Object getRefreshKey(final z z) {
        return this.getRefreshKey(z);
    }
    
    @Override
    public Object load(final a<Integer> a, final c<? super b<Integer, Value>> c) {
        return load$suspendImpl(this, a, c);
    }
}
