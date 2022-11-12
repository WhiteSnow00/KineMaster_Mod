// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import android.util.Log;
import java.util.TreeMap;
import java.util.HashSet;
import java.io.InputStream;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import android.content.Context;
import v0.c;
import android.app.ActivityManager;
import t0.e;
import java.util.concurrent.Callable;
import android.os.CancellationSignal;
import v0.j;
import android.database.Cursor;
import android.content.Intent;
import java.util.Iterator;
import java.util.BitSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import s0.b;
import v0.k;
import android.os.Looper;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.Executor;
import v0.h;
import v0.g;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.List;
import java.util.Map;

public abstract class RoomDatabase
{
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    private androidx.room.a mAutoCloser;
    protected Map<Class<? extends s0.a>, s0.a> mAutoMigrationSpecs;
    private final Map<String, Object> mBackingFieldMap;
    @Deprecated
    protected List<b> mCallbacks;
    private final ReentrantReadWriteLock mCloseLock;
    @Deprecated
    protected volatile g mDatabase;
    private final w mInvalidationTracker;
    private h mOpenHelper;
    private Executor mQueryExecutor;
    private final ThreadLocal<Integer> mSuspendingTransactionId;
    private Executor mTransactionExecutor;
    private final Map<Class<?>, Object> mTypeConverters;
    boolean mWriteAheadLoggingEnabled;
    
    public RoomDatabase() {
        this.mCloseLock = new ReentrantReadWriteLock();
        this.mSuspendingTransactionId = new ThreadLocal<Integer>();
        this.mBackingFieldMap = Collections.synchronizedMap(new HashMap<String, Object>());
        this.mInvalidationTracker = this.createInvalidationTracker();
        this.mTypeConverters = new HashMap<Class<?>, Object>();
        this.mAutoMigrationSpecs = new HashMap<Class<? extends s0.a>, s0.a>();
    }
    
    public static Object a(final RoomDatabase roomDatabase, final g g) {
        return roomDatabase.lambda$beginTransaction$0(g);
    }
    
    public static Object b(final RoomDatabase roomDatabase, final g g) {
        return roomDatabase.lambda$endTransaction$1(g);
    }
    
    private void internalBeginTransaction() {
        this.assertNotMainThread();
        final g writableDatabase = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.t(writableDatabase);
        if (writableDatabase.z1()) {
            writableDatabase.U();
        }
        else {
            writableDatabase.m();
        }
    }
    
    private void internalEndTransaction() {
        this.mOpenHelper.getWritableDatabase().q();
        if (!this.inTransaction()) {
            this.mInvalidationTracker.j();
        }
    }
    
    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
    
    private Object lambda$beginTransaction$0(final g g) {
        this.internalBeginTransaction();
        return null;
    }
    
    private Object lambda$endTransaction$1(final g g) {
        this.internalEndTransaction();
        return null;
    }
    
    private <T> T unwrapOpenHelper(final Class<T> clazz, final h h) {
        if (clazz.isInstance(h)) {
            return (T)h;
        }
        if (h instanceof p) {
            return (T)this.unwrapOpenHelper((Class<Object>)clazz, ((p)h).getDelegate());
        }
        return null;
    }
    
    public void assertNotMainThread() {
        if (this.mAllowMainThreadQueries) {
            return;
        }
        if (!isMainThread()) {
            return;
        }
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
    }
    
    public void assertNotSuspendingTransaction() {
        if (!this.inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }
    
    @Deprecated
    public void beginTransaction() {
        this.assertNotMainThread();
        final androidx.room.a mAutoCloser = this.mAutoCloser;
        if (mAutoCloser == null) {
            this.internalBeginTransaction();
        }
        else {
            mAutoCloser.c((k.a<g, Object>)new p0(this));
        }
    }
    
    public abstract void clearAllTables();
    
    public void close() {
        if (this.isOpen()) {
            final ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            writeLock.lock();
            try {
                this.mInvalidationTracker.q();
                this.mOpenHelper.close();
            }
            finally {
                writeLock.unlock();
            }
        }
    }
    
    public k compileStatement(final String s) {
        this.assertNotMainThread();
        this.assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().H0(s);
    }
    
    protected abstract w createInvalidationTracker();
    
    protected abstract h createOpenHelper(final o p0);
    
    @Deprecated
    public void endTransaction() {
        final androidx.room.a mAutoCloser = this.mAutoCloser;
        if (mAutoCloser == null) {
            this.internalEndTransaction();
        }
        else {
            mAutoCloser.c((k.a<g, Object>)new q0(this));
        }
    }
    
    public List<s0.b> getAutoMigrations(final Map<Class<? extends s0.a>, s0.a> map) {
        return Collections.emptyList();
    }
    
    Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }
    
    Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }
    
    public w getInvalidationTracker() {
        return this.mInvalidationTracker;
    }
    
    public h getOpenHelper() {
        return this.mOpenHelper;
    }
    
    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }
    
    public Set<Class<? extends s0.a>> getRequiredAutoMigrationSpecs() {
        return Collections.emptySet();
    }
    
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return Collections.emptyMap();
    }
    
    ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }
    
    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }
    
    public <T> T getTypeConverter(final Class<T> clazz) {
        return (T)this.mTypeConverters.get(clazz);
    }
    
    public boolean inTransaction() {
        return this.mOpenHelper.getWritableDatabase().q1();
    }
    
    public void init(final o o) {
        this.mOpenHelper = this.createOpenHelper(o);
        final Set<Class<? extends s0.a>> requiredAutoMigrationSpecs = this.getRequiredAutoMigrationSpecs();
        final BitSet set = new BitSet();
        final Iterator<Class<? extends s0.a>> iterator = requiredAutoMigrationSpecs.iterator();
        while (true) {
            final boolean hasNext = iterator.hasNext();
            final int n = -1;
            if (!hasNext) {
                for (int i = o.g.size() - 1; i >= 0; --i) {
                    if (!set.get(i)) {
                        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                    }
                }
                final Iterator<s0.b> iterator2 = this.getAutoMigrations(this.mAutoMigrationSpecs).iterator();
                boolean b;
                while (true) {
                    final boolean hasNext2 = iterator2.hasNext();
                    b = false;
                    if (!hasNext2) {
                        break;
                    }
                    final s0.b b2 = iterator2.next();
                    if (o.d.e().containsKey(b2.a)) {
                        continue;
                    }
                    o.d.b(b2);
                }
                final v0 v0 = this.unwrapOpenHelper(v0.class, this.mOpenHelper);
                if (v0 != null) {
                    v0.d(o);
                }
                final i j = this.unwrapOpenHelper(i.class, this.mOpenHelper);
                if (j != null) {
                    final androidx.room.a a = j.a();
                    this.mAutoCloser = a;
                    this.mInvalidationTracker.n(a);
                }
                if (o.i == JournalMode.WRITE_AHEAD_LOGGING) {
                    b = true;
                }
                this.mOpenHelper.setWriteAheadLoggingEnabled(b);
                this.mCallbacks = o.e;
                this.mQueryExecutor = o.j;
                this.mTransactionExecutor = new z0(o.k);
                this.mAllowMainThreadQueries = o.h;
                this.mWriteAheadLoggingEnabled = b;
                final Intent m = o.m;
                if (m != null) {
                    this.mInvalidationTracker.o(o.b, o.c, m);
                }
                final Map<Class<?>, List<Class<?>>> requiredTypeConverters = this.getRequiredTypeConverters();
                final BitSet set2 = new BitSet();
                for (final Map.Entry<Class, V> entry : requiredTypeConverters.entrySet()) {
                    final Class clazz = entry.getKey();
                Label_0572:
                    for (final Class clazz2 : (List)entry.getValue()) {
                        int k = o.f.size() - 1;
                        while (true) {
                            while (k >= 0) {
                                if (clazz2.isAssignableFrom(o.f.get(k).getClass())) {
                                    set2.set(k);
                                    if (k >= 0) {
                                        this.mTypeConverters.put(clazz2, o.f.get(k));
                                        continue Label_0572;
                                    }
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("A required type converter (");
                                    sb.append(clazz2);
                                    sb.append(") for ");
                                    sb.append(clazz.getCanonicalName());
                                    sb.append(" is missing in the database configuration.");
                                    throw new IllegalArgumentException(sb.toString());
                                }
                                else {
                                    --k;
                                }
                            }
                            k = -1;
                            continue;
                        }
                    }
                }
                for (int l = o.f.size() - 1; l >= 0; --l) {
                    if (!set2.get(l)) {
                        final Object value = o.f.get(l);
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unexpected type converter ");
                        sb2.append(value);
                        sb2.append(". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
                return;
            }
            final Class clazz3 = iterator.next();
            int n2 = o.g.size() - 1;
            int n3;
            while (true) {
                n3 = n;
                if (n2 < 0) {
                    break;
                }
                if (clazz3.isAssignableFrom(o.g.get(n2).getClass())) {
                    set.set(n2);
                    n3 = n2;
                    break;
                }
                --n2;
            }
            if (n3 < 0) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("A required auto migration spec (");
                sb3.append(clazz3.getCanonicalName());
                sb3.append(") is missing in the database configuration.");
                throw new IllegalArgumentException(sb3.toString());
            }
            this.mAutoMigrationSpecs.put(clazz3, o.g.get(n3));
        }
    }
    
    protected void internalInitInvalidationTracker(final g g) {
        this.mInvalidationTracker.g(g);
    }
    
    public boolean isOpen() {
        final androidx.room.a mAutoCloser = this.mAutoCloser;
        if (mAutoCloser != null) {
            return mAutoCloser.g();
        }
        final g mDatabase = this.mDatabase;
        return mDatabase != null && mDatabase.isOpen();
    }
    
    public Cursor query(final String s, final Object[] array) {
        return this.mOpenHelper.getWritableDatabase().J(new v0.a(s, array));
    }
    
    public Cursor query(final j j) {
        return this.query(j, null);
    }
    
    public Cursor query(final j j, final CancellationSignal cancellationSignal) {
        this.assertNotMainThread();
        this.assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return this.mOpenHelper.getWritableDatabase().u0(j, cancellationSignal);
        }
        return this.mOpenHelper.getWritableDatabase().J(j);
    }
    
    public <V> V runInTransaction(final Callable<V> callable) {
        this.beginTransaction();
        try {
            try {
                final V call = callable.call();
                this.setTransactionSuccessful();
                this.endTransaction();
                return call;
            }
            finally {}
        }
        catch (final Exception ex) {
            t0.e.a(ex);
            this.endTransaction();
            return null;
        }
        catch (final RuntimeException ex2) {
            throw ex2;
        }
        this.endTransaction();
    }
    
    public void runInTransaction(final Runnable runnable) {
        this.beginTransaction();
        try {
            runnable.run();
            this.setTransactionSuccessful();
        }
        finally {
            this.endTransaction();
        }
    }
    
    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().p();
    }
    
    public enum JournalMode
    {
        private static final JournalMode[] $VALUES;
        
        AUTOMATIC, 
        TRUNCATE, 
        WRITE_AHEAD_LOGGING;
        
        private static boolean a(final ActivityManager activityManager) {
            return v0.c.b(activityManager);
        }
        
        JournalMode resolve(final Context context) {
            if (this != JournalMode.AUTOMATIC) {
                return this;
            }
            final ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
            if (activityManager != null && !a(activityManager)) {
                return JournalMode.WRITE_AHEAD_LOGGING;
            }
            return JournalMode.TRUNCATE;
        }
    }
    
    public static class a<T extends RoomDatabase>
    {
        private final Class<T> a;
        private final String b;
        private final Context c;
        private ArrayList<b> d;
        private e e;
        private Executor f;
        private List<Object> g;
        private List<s0.a> h;
        private Executor i;
        private Executor j;
        private h.c k;
        private boolean l;
        private JournalMode m;
        private Intent n;
        private boolean o;
        private boolean p;
        private long q;
        private TimeUnit r;
        private final c s;
        private Set<Integer> t;
        private Set<Integer> u;
        private String v;
        private File w;
        private Callable<InputStream> x;
        
        a(final Context c, final Class<T> a, final String b) {
            this.q = -1L;
            this.c = c;
            this.a = a;
            this.b = b;
            this.m = JournalMode.AUTOMATIC;
            this.o = true;
            this.s = new c();
        }
        
        public a<T> a(final b b) {
            if (this.d == null) {
                this.d = new ArrayList<b>();
            }
            this.d.add(b);
            return this;
        }
        
        public a<T> b(final s0.b... array) {
            if (this.u == null) {
                this.u = new HashSet<Integer>();
            }
            for (final s0.b b : array) {
                this.u.add(b.a);
                this.u.add(b.b);
            }
            this.s.b(array);
            return this;
        }
        
        public a<T> c() {
            this.l = true;
            return this;
        }
        
        public T d() {
            if (this.c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.a != null) {
                final Executor i = this.i;
                if (i == null && this.j == null) {
                    final Executor e = i.a.e();
                    this.j = e;
                    this.i = e;
                }
                else if (i != null && this.j == null) {
                    this.j = i;
                }
                else if (i == null) {
                    final Executor j = this.j;
                    if (j != null) {
                        this.i = j;
                    }
                }
                final Set<Integer> u = this.u;
                if (u != null && this.t != null) {
                    for (final Integer n : u) {
                        if (!this.t.contains(n)) {
                            continue;
                        }
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ");
                        sb.append(n);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                h.c k;
                if ((k = this.k) == null) {
                    k = new w0.c();
                }
                final long q = this.q;
                h.c c = k;
                if (q > 0L) {
                    if (this.b == null) {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                    c = new m(k, new androidx.room.a(q, this.r, this.j));
                }
                final String v = this.v;
                h.c c2 = null;
                Label_0398: {
                    if (v == null && this.w == null) {
                        c2 = c;
                        if (this.x == null) {
                            break Label_0398;
                        }
                    }
                    if (this.b == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                    int n2 = 0;
                    int n3;
                    if (v == null) {
                        n3 = 0;
                    }
                    else {
                        n3 = 1;
                    }
                    final File w = this.w;
                    int n4;
                    if (w == null) {
                        n4 = 0;
                    }
                    else {
                        n4 = 1;
                    }
                    final Callable<InputStream> x = this.x;
                    if (x != null) {
                        n2 = 1;
                    }
                    if (n3 + n4 + n2 != 1) {
                        throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                    }
                    c2 = new w0(v, w, x, c);
                }
                final e e2 = this.e;
                h.c c3;
                if (e2 != null) {
                    c3 = new j0(c2, e2, this.f);
                }
                else {
                    c3 = c2;
                }
                final Context c4 = this.c;
                final o o = new o(c4, this.b, c3, this.s, this.d, this.l, this.m.resolve(c4), this.i, this.j, this.n, this.o, this.p, this.t, this.v, this.w, this.x, null, this.g, this.h);
                final RoomDatabase roomDatabase = o0.b(this.a, "_Impl");
                roomDatabase.init(o);
                return (T)roomDatabase;
            }
            throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
        }
        
        public a<T> e() {
            this.o = false;
            this.p = true;
            return this;
        }
        
        public a<T> f(final int... array) {
            if (this.t == null) {
                this.t = new HashSet<Integer>(array.length);
            }
            for (int length = array.length, i = 0; i < length; ++i) {
                this.t.add(array[i]);
            }
            return this;
        }
        
        public a<T> g(final h.c k) {
            this.k = k;
            return this;
        }
        
        public a<T> h(final Executor i) {
            this.i = i;
            return this;
        }
    }
    
    public abstract static class b
    {
        public void a(final g g) {
        }
        
        public void b(final g g) {
        }
        
        public void c(final g g) {
        }
    }
    
    public static class c
    {
        private HashMap<Integer, TreeMap<Integer, s0.b>> a;
        
        public c() {
            this.a = new HashMap<Integer, TreeMap<Integer, s0.b>>();
        }
        
        private void a(final s0.b b) {
            final int a = b.a;
            final int b2 = b.b;
            TreeMap treeMap;
            if ((treeMap = this.a.get(a)) == null) {
                treeMap = new TreeMap();
                this.a.put(a, treeMap);
            }
            final s0.b b3 = (s0.b)treeMap.get(b2);
            if (b3 != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Overriding migration ");
                sb.append(b3);
                sb.append(" with ");
                sb.append(b);
                Log.w("ROOM", sb.toString());
            }
            treeMap.put(b2, b);
        }
        
        private List<s0.b> d(final List<s0.b> list, final boolean b, int n, final int n2) {
            int i;
        Label_0200:
            do {
                if (b) {
                    if (n >= n2) {
                        return list;
                    }
                }
                else if (n <= n2) {
                    return list;
                }
                final TreeMap treeMap = this.a.get(n);
                if (treeMap == null) {
                    return null;
                }
                Set set;
                if (b) {
                    set = treeMap.descendingKeySet();
                }
                else {
                    set = treeMap.keySet();
                }
                final Iterator iterator = set.iterator();
                int j;
                int n3;
                int intValue;
                do {
                    final boolean hasNext = iterator.hasNext();
                    n3 = 1;
                    final int n4 = 0;
                    if (!hasNext) {
                        i = 0;
                        continue Label_0200;
                    }
                    intValue = (int)iterator.next();
                    if (b) {
                        j = n4;
                        if (intValue > n2) {
                            continue;
                        }
                        j = n4;
                        if (intValue <= n) {
                            continue;
                        }
                    }
                    else {
                        j = n4;
                        if (intValue < n2) {
                            continue;
                        }
                        j = n4;
                        if (intValue >= n) {
                            continue;
                        }
                    }
                    j = 1;
                } while (j == 0);
                list.add((s0.b)treeMap.get(intValue));
                n = intValue;
                i = n3;
            } while (i != 0);
            return null;
        }
        
        public void b(final s0.b... array) {
            for (int length = array.length, i = 0; i < length; ++i) {
                this.a(array[i]);
            }
        }
        
        public List<s0.b> c(final int n, final int n2) {
            if (n == n2) {
                return Collections.emptyList();
            }
            return this.d(new ArrayList<s0.b>(), n2 > n, n, n2);
        }
        
        public Map<Integer, Map<Integer, s0.b>> e() {
            return Collections.unmodifiableMap((Map<? extends Integer, ? extends Map<Integer, s0.b>>)this.a);
        }
    }
    
    public abstract static class d
    {
    }
    
    public interface e
    {
        void a(final String p0, final List<Object> p1);
    }
}
