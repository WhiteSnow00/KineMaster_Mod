// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import java.util.Objects;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import java.util.HashMap;
import java.util.ListIterator;
import android.util.Base64;
import java.util.Collection;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.util.Iterator;
import java.util.Arrays;
import android.content.ContentValues;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import java.util.HashSet;
import java.util.Set;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import java.util.ArrayList;
import android.database.Cursor;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import java.util.Map;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import javax.inject.Inject;
import javax.inject.Named;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.Encoding;
import javax.inject.Singleton;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

@Singleton
public class SQLiteEventStore implements EventStore, SynchronizationGuard, ClientHealthMetricsStore
{
    private static final Encoding f;
    private final SchemaManager a;
    private final Clock b;
    private final Clock c;
    private final com.google.android.datatransport.runtime.scheduling.persistence.c d;
    private final Lazy<String> e;
    
    static {
        f = Encoding.b("proto");
    }
    
    @Inject
    SQLiteEventStore(@WallTime final Clock b, @Monotonic final Clock c, final com.google.android.datatransport.runtime.scheduling.persistence.c d, final SchemaManager a, @Named final Lazy<String> e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    private List A1(final TransportContext transportContext, final SQLiteDatabase sqLiteDatabase) {
        final List<PersistedEvent> s1 = this.S1(sqLiteDatabase, transportContext);
        return this.S0(s1, this.T1(sqLiteDatabase, s1));
    }
    
    private ClientMetrics B1(final Map map, final ClientMetrics.Builder builder, final Cursor cursor) {
        while (cursor.moveToNext()) {
            final String string = cursor.getString(0);
            final LogEventDropped.Reason r0 = this.r0(cursor.getInt(1));
            final long long1 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            map.get(string).add(LogEventDropped.c().c(r0).b(long1).a());
        }
        this.V1(builder, map);
        builder.e(this.K0());
        builder.d(this.F0());
        builder.c(this.e.get());
        return builder.b();
    }
    
    private ClientMetrics C1(final String s, final Map map, final ClientMetrics.Builder builder, final SQLiteDatabase sqLiteDatabase) {
        return a2(sqLiteDatabase.rawQuery(s, new String[0]), (b<Cursor, ClientMetrics>)new h(this, map, builder));
    }
    
    public static Object E(final SQLiteEventStore sqLiteEventStore, final Cursor cursor) {
        return sqLiteEventStore.Y0(cursor);
    }
    
    private Object E1(final List list, final TransportContext transportContext, final Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean b = false;
            final long long1 = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                b = true;
            }
            final EventInternal.Builder k = EventInternal.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (b) {
                k.h(new EncodedPayload(Y1(cursor.getString(4)), cursor.getBlob(5)));
            }
            else {
                k.h(new EncodedPayload(Y1(cursor.getString(4)), this.W1(long1)));
            }
            if (!cursor.isNull(6)) {
                k.g(cursor.getInt(6));
            }
            list.add(PersistedEvent.a(long1, transportContext, k.d()));
        }
        return null;
    }
    
    public static Boolean F(final SQLiteEventStore sqLiteEventStore, final TransportContext transportContext, final SQLiteDatabase sqLiteDatabase) {
        return sqLiteEventStore.s1(transportContext, sqLiteDatabase);
    }
    
    private GlobalMetrics F0() {
        return GlobalMetrics.b().b(StorageMetrics.c().b(this.B0()).c(com.google.android.datatransport.runtime.scheduling.persistence.c.a.f()).a()).a();
    }
    
    private static Object F1(final Map map, final Cursor cursor) {
        while (cursor.moveToNext()) {
            final long long1 = cursor.getLong(0);
            Set set;
            if ((set = map.get(long1)) == null) {
                set = new HashSet();
                map.put(long1, set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2), null));
        }
        return null;
    }
    
    private long G0() {
        return this.C0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }
    
    private long J0() {
        return this.C0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }
    
    private TimeWindow K0() {
        return this.N0((b<SQLiteDatabase, TimeWindow>)new o(this.b.a()));
    }
    
    private Long K1(final EventInternal eventInternal, final TransportContext transportContext, final SQLiteDatabase sqLiteDatabase) {
        if (this.R0()) {
            this.e(1L, LogEventDropped.Reason.CACHE_FULL, eventInternal.j());
            return -1L;
        }
        final long y0 = this.y0(sqLiteDatabase, transportContext);
        final int e = this.d.e();
        final byte[] a = eventInternal.e().a();
        final int length = a.length;
        int i = 1;
        final boolean b = length <= e;
        final ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(y0));
        contentValues.put("transport_name", eventInternal.j());
        contentValues.put("timestamp_ms", Long.valueOf(eventInternal.f()));
        contentValues.put("uptime_ms", Long.valueOf(eventInternal.k()));
        contentValues.put("payload_encoding", eventInternal.e().b().a());
        contentValues.put("code", eventInternal.d());
        contentValues.put("num_attempts", Integer.valueOf(0));
        contentValues.put("inline", Boolean.valueOf(b));
        byte[] array;
        if (b) {
            array = a;
        }
        else {
            array = new byte[0];
        }
        contentValues.put("payload", array);
        final long insert = sqLiteDatabase.insert("events", (String)null, contentValues);
        if (!b) {
            while (i <= (int)Math.ceil(a.length / (double)e)) {
                final byte[] copyOfRange = Arrays.copyOfRange(a, (i - 1) * e, Math.min(i * e, a.length));
                final ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", copyOfRange);
                sqLiteDatabase.insert("event_payloads", (String)null, contentValues2);
                ++i;
            }
        }
        for (final Map.Entry<String, V> entry : eventInternal.i().entrySet()) {
            final ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String)entry.getKey());
            contentValues3.put("value", (String)entry.getValue());
            sqLiteDatabase.insert("event_metadata", (String)null, contentValues3);
        }
        return insert;
    }
    
    public static TimeWindow L(final long n, final SQLiteDatabase sqLiteDatabase) {
        return p1(n, sqLiteDatabase);
    }
    
    private Long L0(final SQLiteDatabase sqLiteDatabase, final TransportContext transportContext) {
        final StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        final ArrayList list = new ArrayList((Collection<? extends E>)Arrays.asList(transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))));
        if (transportContext.c() != null) {
            sb.append(" and extras = ?");
            list.add(Base64.encodeToString(transportContext.c(), 0));
        }
        else {
            sb.append(" and extras is null");
        }
        return a2(sqLiteDatabase.query("transport_contexts", new String[] { "_id" }, sb.toString(), (String[])list.toArray(new String[0]), (String)null, (String)null, (String)null), (b<Cursor, Long>)n.a);
    }
    
    private static byte[] L1(final Cursor cursor) {
        final ArrayList list = new ArrayList();
        int n = 0;
        while (cursor.moveToNext()) {
            final byte[] blob = cursor.getBlob(0);
            list.add(blob);
            n += blob.length;
        }
        final byte[] array = new byte[n];
        int i = 0;
        int n2 = 0;
        while (i < list.size()) {
            final byte[] array2 = (byte[])list.get(i);
            System.arraycopy(array2, 0, array, n2, array2.length);
            n2 += array2.length;
            ++i;
        }
        return array;
    }
    
    public static Long M(final Cursor cursor) {
        return k1(cursor);
    }
    
    private Object M1(final Cursor cursor) {
        while (cursor.moveToNext()) {
            this.e(cursor.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }
    
    private Object N1(final String s, final String s2, final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.compileStatement(s).execute();
        a2(sqLiteDatabase.rawQuery(s2, (String[])null), (b<Cursor, Object>)new y(this));
        sqLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }
    
    public static ClientMetrics O(final SQLiteEventStore sqLiteEventStore, final String s, final Map map, final ClientMetrics.Builder builder, final SQLiteDatabase sqLiteDatabase) {
        return sqLiteEventStore.C1(s, map, builder, sqLiteDatabase);
    }
    
    private static Boolean O1(final Cursor cursor) {
        return cursor.getCount() > 0;
    }
    
    private static Object P1(final String s, final LogEventDropped.Reason reason, final long n, final SQLiteDatabase sqLiteDatabase) {
        if (!a2(sqLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[] { s, Integer.toString(reason.getNumber()) }), (b<Cursor, Boolean>)p.a)) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", s);
            contentValues.put("reason", Integer.valueOf(reason.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(n));
            sqLiteDatabase.insert("log_event_dropped", (String)null, contentValues);
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + ");
            sb.append(n);
            sb.append(" WHERE log_source = ? AND reason = ?");
            sqLiteDatabase.execSQL(sb.toString(), (Object[])new String[] { s, Integer.toString(reason.getNumber()) });
        }
        return null;
    }
    
    private static Object Q1(final long n, final TransportContext transportContext, final SQLiteDatabase sqLiteDatabase) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(n));
        if (sqLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[] { transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d())) }) < 1) {
            contentValues.put("backend_name", transportContext.b());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
            sqLiteDatabase.insert("transport_contexts", (String)null, contentValues);
        }
        return null;
    }
    
    private boolean R0() {
        return this.G0() * this.J0() >= this.d.f();
    }
    
    private Object R1(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        final StringBuilder sb = new StringBuilder();
        sb.append("UPDATE global_log_event_state SET last_metrics_upload_ms=");
        sb.append(this.b.a());
        sqLiteDatabase.compileStatement(sb.toString()).execute();
        return null;
    }
    
    private List<PersistedEvent> S0(final List<PersistedEvent> list, final Map<Long, Set<c>> map) {
        final ListIterator<PersistedEvent> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            final PersistedEvent persistedEvent = listIterator.next();
            if (!map.containsKey(persistedEvent.c())) {
                continue;
            }
            final EventInternal.Builder l = persistedEvent.b().l();
            for (final c c : map.get(persistedEvent.c())) {
                l.c(c.a, c.b);
            }
            listIterator.set(PersistedEvent.a(persistedEvent.c(), persistedEvent.d(), l.d()));
        }
        return list;
    }
    
    private List<PersistedEvent> S1(final SQLiteDatabase sqLiteDatabase, final TransportContext transportContext) {
        final ArrayList list = new ArrayList();
        final Long l0 = this.L0(sqLiteDatabase, transportContext);
        if (l0 == null) {
            return list;
        }
        a2(sqLiteDatabase.query("events", new String[] { "_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline" }, "context_id = ?", new String[] { l0.toString() }, (String)null, (String)null, (String)null, String.valueOf(this.d.d())), (b<Cursor, Object>)new g(this, list, transportContext));
        return list;
    }
    
    private Map<Long, Set<c>> T1(final SQLiteDatabase sqLiteDatabase, final List<PersistedEvent> list) {
        final HashMap hashMap = new HashMap();
        final StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); ++i) {
            sb.append(((PersistedEvent)list.get(i)).c());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        a2(sqLiteDatabase.query("event_metadata", new String[] { "event_id", "name", "value" }, sb.toString(), (String[])null, (String)null, (String)null, (String)null), (b<Cursor, Object>)new j(hashMap));
        return hashMap;
    }
    
    private static byte[] U1(final String s) {
        if (s == null) {
            return null;
        }
        return Base64.decode(s, 0);
    }
    
    public static Object V(final SQLiteEventStore sqLiteEventStore, final List list, final TransportContext transportContext, final Cursor cursor) {
        return sqLiteEventStore.E1(list, transportContext, cursor);
    }
    
    private void V1(final ClientMetrics.Builder builder, final Map<String, List<LogEventDropped>> map) {
        for (final Map.Entry entry : map.entrySet()) {
            builder.a(LogSourceMetrics.c().c((String)entry.getKey()).b((List<LogEventDropped>)entry.getValue()).a());
        }
    }
    
    public static Object W(final SQLiteEventStore sqLiteEventStore, final SQLiteDatabase sqLiteDatabase) {
        return sqLiteEventStore.R1(sqLiteDatabase);
    }
    
    private byte[] W1(final long n) {
        return a2(this.C0().query("event_payloads", new String[] { "bytes" }, "event_id = ?", new String[] { String.valueOf(n) }, (String)null, (String)null, "sequence_num"), (b<Cursor, byte[]>)k.a);
    }
    
    private <T> T X1(final d<T> d, final b<Throwable, T> b) {
        final long a = this.c.a();
        try {
            return d.a();
        }
        catch (final SQLiteDatabaseLockedException ex) {
            if (this.c.a() >= this.d.b() + a) {
                return b.apply((Throwable)ex);
            }
            SystemClock.sleep(50L);
            return d.a();
        }
    }
    
    private Object Y0(final Cursor cursor) {
        while (cursor.moveToNext()) {
            this.e(cursor.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }
    
    private static Encoding Y1(final String s) {
        if (s == null) {
            return SQLiteEventStore.f;
        }
        return Encoding.b(s);
    }
    
    public static Long Z(final Cursor cursor) {
        return r1(cursor);
    }
    
    private static String Z1(final Iterable<PersistedEvent> iterable) {
        final StringBuilder sb = new StringBuilder("(");
        final Iterator<PersistedEvent> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().c());
            if (iterator.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }
    
    public static Object a0(final SQLiteEventStore sqLiteEventStore, final String s, final String s2, final SQLiteDatabase sqLiteDatabase) {
        return sqLiteEventStore.N1(s, s2, sqLiteDatabase);
    }
    
    private Integer a1(final long n, final SQLiteDatabase sqLiteDatabase) {
        final String[] array = { String.valueOf(n) };
        a2(sqLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", array), (b<Cursor, Object>)new x(this));
        return sqLiteDatabase.delete("events", "timestamp_ms < ?", array);
    }
    
    static <T> T a2(final Cursor cursor, final b<Cursor, T> b) {
        try {
            return b.apply(cursor);
        }
        finally {
            cursor.close();
        }
    }
    
    public static Long c0(final SQLiteEventStore sqLiteEventStore, final EventInternal eventInternal, final TransportContext transportContext, final SQLiteDatabase sqLiteDatabase) {
        return sqLiteEventStore.K1(eventInternal, transportContext, sqLiteDatabase);
    }
    
    private static Object d1(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.beginTransaction();
        return null;
    }
    
    public static Object e0(final Map map, final Cursor cursor) {
        return F1(map, cursor);
    }
    
    public static ClientMetrics f0(final SQLiteEventStore sqLiteEventStore, final Map map, final ClientMetrics.Builder builder, final Cursor cursor) {
        return sqLiteEventStore.B1(map, builder, cursor);
    }
    
    public static Object g0(final SQLiteEventStore sqLiteEventStore, final Cursor cursor) {
        return sqLiteEventStore.M1(cursor);
    }
    
    private static Object g1(final Throwable t) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", t);
    }
    
    public static SQLiteDatabase h(final Throwable t) {
        return h1(t);
    }
    
    private static SQLiteDatabase h1(final Throwable t) {
        throw new SynchronizationException("Timed out while trying to open db.", t);
    }
    
    public static Object i(final Throwable t) {
        return g1(t);
    }
    
    public static Integer i0(final SQLiteEventStore sqLiteEventStore, final long n, final SQLiteDatabase sqLiteDatabase) {
        return sqLiteEventStore.a1(n, sqLiteDatabase);
    }
    
    public static TimeWindow j(final long n, final Cursor cursor) {
        return n1(n, cursor);
    }
    
    public static List k(final SQLiteEventStore sqLiteEventStore, final TransportContext transportContext, final SQLiteDatabase sqLiteDatabase) {
        return sqLiteEventStore.A1(transportContext, sqLiteDatabase);
    }
    
    private static Long k1(final Cursor cursor) {
        if (cursor.moveToNext()) {
            return cursor.getLong(0);
        }
        return 0L;
    }
    
    public static Object l(final SQLiteDatabase sqLiteDatabase) {
        return d1(sqLiteDatabase);
    }
    
    public static List l0(final SQLiteDatabase sqLiteDatabase) {
        return w1(sqLiteDatabase);
    }
    
    public static Boolean m0(final Cursor cursor) {
        return O1(cursor);
    }
    
    private static TimeWindow n1(final long n, final Cursor cursor) {
        cursor.moveToNext();
        return TimeWindow.c().c(cursor.getLong(0)).b(n).a();
    }
    
    private static TimeWindow p1(final long n, final SQLiteDatabase sqLiteDatabase) {
        return a2(sqLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), (b<Cursor, TimeWindow>)new com.google.android.datatransport.runtime.scheduling.persistence.d(n));
    }
    
    public static Object r(final long n, final TransportContext transportContext, final SQLiteDatabase sqLiteDatabase) {
        return Q1(n, transportContext, sqLiteDatabase);
    }
    
    private LogEventDropped.Reason r0(final int n) {
        final LogEventDropped.Reason reason_UNKNOWN = LogEventDropped.Reason.REASON_UNKNOWN;
        if (n == reason_UNKNOWN.getNumber()) {
            return reason_UNKNOWN;
        }
        final LogEventDropped.Reason message_TOO_OLD = LogEventDropped.Reason.MESSAGE_TOO_OLD;
        if (n == message_TOO_OLD.getNumber()) {
            return message_TOO_OLD;
        }
        final LogEventDropped.Reason cache_FULL = LogEventDropped.Reason.CACHE_FULL;
        if (n == cache_FULL.getNumber()) {
            return cache_FULL;
        }
        final LogEventDropped.Reason payload_TOO_BIG = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
        if (n == payload_TOO_BIG.getNumber()) {
            return payload_TOO_BIG;
        }
        final LogEventDropped.Reason max_RETRIES_REACHED = LogEventDropped.Reason.MAX_RETRIES_REACHED;
        if (n == max_RETRIES_REACHED.getNumber()) {
            return max_RETRIES_REACHED;
        }
        final LogEventDropped.Reason invalid_PAYLOD = LogEventDropped.Reason.INVALID_PAYLOD;
        if (n == invalid_PAYLOD.getNumber()) {
            return invalid_PAYLOD;
        }
        final LogEventDropped.Reason server_ERROR = LogEventDropped.Reason.SERVER_ERROR;
        if (n == server_ERROR.getNumber()) {
            return server_ERROR;
        }
        Logging.a("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", n);
        return reason_UNKNOWN;
    }
    
    private static Long r1(final Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return cursor.getLong(0);
    }
    
    public static byte[] s(final Cursor cursor) {
        return L1(cursor);
    }
    
    private Boolean s1(final TransportContext transportContext, final SQLiteDatabase sqLiteDatabase) {
        final Long l0 = this.L0(sqLiteDatabase, transportContext);
        if (l0 == null) {
            return Boolean.FALSE;
        }
        return a2(this.C0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[] { l0.toString() }), (b<Cursor, Boolean>)q.a);
    }
    
    public static List t(final Cursor cursor) {
        return y1(cursor);
    }
    
    private void t0(final SQLiteDatabase sqLiteDatabase) {
        this.X1(new u(sqLiteDatabase), (b<Throwable, Object>)t.a);
    }
    
    public static Object u(final String s, final LogEventDropped.Reason reason, final long n, final SQLiteDatabase sqLiteDatabase) {
        return P1(s, reason, n, sqLiteDatabase);
    }
    
    private static List w1(final SQLiteDatabase sqLiteDatabase) {
        return a2(sqLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), (b<Cursor, List>)l.a);
    }
    
    private long y0(final SQLiteDatabase sqLiteDatabase, final TransportContext transportContext) {
        final Long l0 = this.L0(sqLiteDatabase, transportContext);
        if (l0 != null) {
            return l0;
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", transportContext.b());
        contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
        contentValues.put("next_request_ms", Integer.valueOf(0));
        if (transportContext.c() != null) {
            contentValues.put("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        return sqLiteDatabase.insert("transport_contexts", (String)null, contentValues);
    }
    
    private static List y1(final Cursor cursor) {
        final ArrayList list = new ArrayList();
        while (cursor.moveToNext()) {
            list.add(TransportContext.a().b(cursor.getString(1)).d(PriorityMapping.b(cursor.getInt(2))).c(U1(cursor.getString(3))).a());
        }
        return list;
    }
    
    long B0() {
        return this.G0() * this.J0();
    }
    
    SQLiteDatabase C0() {
        final SchemaManager a = this.a;
        Objects.requireNonNull(a);
        return this.X1(new v(a), (b<Throwable, SQLiteDatabase>)s.a);
    }
    
    @Override
    public void H(final TransportContext transportContext, final long n) {
        this.N0((b<SQLiteDatabase, Object>)new w(n, transportContext));
    }
    
    @Override
    public Iterable<PersistedEvent> I0(final TransportContext transportContext) {
        return this.N0((b<SQLiteDatabase, Iterable<PersistedEvent>>)new c0(this, transportContext));
    }
    
    @Override
    public Iterable<TransportContext> N() {
        return this.N0((b<SQLiteDatabase, Iterable<TransportContext>>)r.a);
    }
    
     <T> T N0(final b<SQLiteDatabase, T> b) {
        final SQLiteDatabase c0 = this.C0();
        c0.beginTransaction();
        try {
            final T apply = b.apply(c0);
            c0.setTransactionSuccessful();
            return apply;
        }
        finally {
            c0.endTransaction();
        }
    }
    
    @Override
    public void a() {
        this.N0((b<SQLiteDatabase, Object>)new z(this));
    }
    
    @Override
    public <T> T c(final CriticalSection<T> criticalSection) {
        final SQLiteDatabase c0 = this.C0();
        this.t0(c0);
        try {
            final T execute = criticalSection.execute();
            c0.setTransactionSuccessful();
            return execute;
        }
        finally {
            c0.endTransaction();
        }
    }
    
    @Override
    public int cleanUp() {
        return this.N0((b<SQLiteDatabase, Integer>)new a0(this, this.b.a() - this.d.c()));
    }
    
    @Override
    public void close() {
        this.a.close();
    }
    
    @Override
    public ClientMetrics d() {
        return this.N0((b<SQLiteDatabase, ClientMetrics>)new f(this, "SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new HashMap(), ClientMetrics.e()));
    }
    
    @Override
    public void e(final long n, final LogEventDropped.Reason reason, final String s) {
        this.N0((b<SQLiteDatabase, Object>)new i(s, reason, n));
    }
    
    @Override
    public long n0(final TransportContext transportContext) {
        return a2(this.C0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[] { transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d())) }), (b<Cursor, Long>)m.a);
    }
    
    @Override
    public boolean q0(final TransportContext transportContext) {
        return this.N0((b<SQLiteDatabase, Boolean>)new d0(this, transportContext));
    }
    
    @Override
    public void s0(final Iterable<PersistedEvent> iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
        sb.append(Z1(iterable));
        this.N0((b<SQLiteDatabase, Object>)new e(this, sb.toString(), "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name"));
    }
    
    @Override
    public PersistedEvent t1(final TransportContext transportContext, final EventInternal eventInternal) {
        Logging.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.d(), eventInternal.j(), transportContext.b());
        final long longValue = this.N0((b<SQLiteDatabase, Long>)new b0(this, eventInternal, transportContext));
        if (longValue < 1L) {
            return null;
        }
        return PersistedEvent.a(longValue, transportContext, eventInternal);
    }
    
    @Override
    public void w(final Iterable<PersistedEvent> iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM events WHERE _id in ");
        sb.append(Z1(iterable));
        this.C0().compileStatement(sb.toString()).execute();
    }
    
    interface b<T, U>
    {
        U apply(final T p0);
    }
    
    private static class c
    {
        final String a;
        final String b;
        
        private c(final String a, final String b) {
            this.a = a;
            this.b = b;
        }
        
        c(final String s, final String s2, final SQLiteEventStore$a object) {
            this(s, s2);
        }
    }
    
    interface d<T>
    {
        T a();
    }
}
