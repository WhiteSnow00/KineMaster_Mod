// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Arrays;
import android.content.Intent;
import android.content.Context;
import androidx.lifecycle.LiveData;
import java.util.concurrent.Callable;
import java.util.Collection;
import java.util.Locale;
import java.util.Iterator;
import v0.g;
import java.util.concurrent.locks.Lock;
import android.util.Log;
import android.database.sqlite.SQLiteException;
import android.database.Cursor;
import v0.j;
import java.util.HashSet;
import j.b;
import v0.k;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class w
{
    private static final String[] o;
    final HashMap<String, Integer> a;
    final String[] b;
    private Map<String, Set<String>> c;
    a d;
    final RoomDatabase e;
    AtomicBoolean f;
    private volatile boolean g;
    volatile k h;
    private final b i;
    private final u j;
    final j.b<c, d> k;
    private x l;
    private final Object m;
    Runnable n;
    
    static {
        o = new String[] { "UPDATE", "DELETE", "INSERT" };
    }
    
    public w(final RoomDatabase e, final Map<String, String> map, final Map<String, Set<String>> c, final String... array) {
        this.d = null;
        int i = 0;
        this.f = new AtomicBoolean(false);
        this.g = false;
        this.k = new j.b<c, d>();
        this.m = new Object();
        this.n = new Runnable() {
            final w a;
            
            private Set<Integer> a() {
                final HashSet set = new HashSet();
                final Cursor query = this.a.e.query(new v0.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
                try {
                    while (query.moveToNext()) {
                        set.add(query.getInt(0));
                    }
                    query.close();
                    if (!set.isEmpty()) {
                        this.a.h.C();
                    }
                    return set;
                }
                finally {
                    query.close();
                }
            }
            
            @Override
            public void run() {
                final Lock closeLock = this.a.e.getCloseLock();
                closeLock.lock();
                Object o = null;
                final Set<Integer> set = null;
                Set<Integer> a = null;
                Object o2 = o;
                Object o3 = set;
                g writableDatabase;
                Object o4;
                a d = null;
                Iterator<Map.Entry<c, d>> iterator;
                Block_17_Outer:Block_19_Outer:
                while (true) {
                    Label_0335: {
                        try {
                            if (!this.a.f()) {
                                closeLock.unlock();
                                o = this.a.d;
                                if (o != null) {
                                    ((a)o).b();
                                }
                                return;
                            }
                            o2 = o;
                            o3 = set;
                            if (!this.a.f.compareAndSet(true, false)) {
                                closeLock.unlock();
                                o = this.a.d;
                                if (o != null) {
                                    ((a)o).b();
                                }
                                return;
                            }
                            o2 = o;
                            o3 = set;
                            if (this.a.e.inTransaction()) {
                                closeLock.unlock();
                                o = this.a.d;
                                if (o != null) {
                                    ((a)o).b();
                                }
                                return;
                            }
                            o2 = o;
                            o3 = set;
                            writableDatabase = this.a.e.getOpenHelper().getWritableDatabase();
                            o2 = o;
                            o3 = set;
                            writableDatabase.U();
                            try {
                                o4 = (a = this.a());
                                writableDatabase.p();
                                o2 = o4;
                                o3 = o4;
                                writableDatabase.q();
                                closeLock.unlock();
                                o3 = this.a.d;
                                o2 = o4;
                                if (o3 != null) {
                                    o2 = o3;
                                    ((a)o2).b();
                                    o2 = o4;
                                }
                                break Label_0335;
                            }
                            finally {
                                o2 = a;
                                o3 = a;
                                writableDatabase.q();
                                o2 = a;
                                o3 = a;
                            }
                        }
                        catch (final SQLiteException ex) {}
                        catch (final IllegalStateException ex2) {}
                        finally {
                            closeLock.unlock();
                            o3 = this.a.d;
                            if (o3 != null) {
                                ((a)o3).b();
                            }
                            while (true) {
                                o2 = d;
                                o4 = o3;
                                continue Block_17_Outer;
                                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", (Throwable)o);
                                closeLock.unlock();
                                d = this.a.d;
                                o2 = o3;
                                iftrue(Label_0335:)(d == null);
                                continue Block_19_Outer;
                            }
                            while (true) {
                                synchronized (this.a.k) {
                                    iterator = this.a.k.iterator();
                                    while (iterator.hasNext()) {
                                        ((Map.Entry<K, d>)iterator.next()).getValue().a((Set<Integer>)o2);
                                    }
                                }
                                return;
                                iftrue(Label_0415:)(o2 == null || ((Set)o2).isEmpty());
                                continue;
                            }
                            Label_0415:;
                        }
                    }
                    break;
                }
            }
        };
        this.e = e;
        this.i = new b(array.length);
        this.a = new HashMap<String, Integer>();
        this.c = c;
        this.j = new u(e);
        final int length = array.length;
        this.b = new String[length];
        while (i < length) {
            final String s = array[i];
            final Locale us = Locale.US;
            final String lowerCase = s.toLowerCase(us);
            this.a.put(lowerCase, i);
            final String s2 = map.get(array[i]);
            if (s2 != null) {
                this.b[i] = s2.toLowerCase(us);
            }
            else {
                this.b[i] = lowerCase;
            }
            ++i;
        }
        for (final Map.Entry<K, String> entry : map.entrySet()) {
            final String s3 = entry.getValue();
            final Locale us2 = Locale.US;
            final String lowerCase2 = s3.toLowerCase(us2);
            if (this.a.containsKey(lowerCase2)) {
                final String lowerCase3 = ((String)entry.getKey()).toLowerCase(us2);
                final HashMap<String, Integer> a = this.a;
                a.put(lowerCase3, a.get(lowerCase2));
            }
        }
    }
    
    private static void c(final StringBuilder sb, final String s, final String s2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(s);
        sb.append("_");
        sb.append(s2);
        sb.append("`");
    }
    
    private static void d(final g g) {
        if (g.z1()) {
            g.U();
        }
        else {
            g.m();
        }
    }
    
    private String[] m(final String[] array) {
        final HashSet set = new HashSet();
        for (final String s : array) {
            final String lowerCase = s.toLowerCase(Locale.US);
            if (this.c.containsKey(lowerCase)) {
                set.addAll(this.c.get(lowerCase));
            }
            else {
                set.add(s);
            }
        }
        return (String[])set.toArray(new String[set.size()]);
    }
    
    private void p(final g g, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("INSERT OR IGNORE INTO room_table_modification_log VALUES(");
        sb.append(n);
        sb.append(", 0)");
        g.z(sb.toString());
        final String s = this.b[n];
        final StringBuilder sb2 = new StringBuilder();
        for (final String s2 : w.o) {
            sb2.setLength(0);
            sb2.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            c(sb2, s, s2);
            sb2.append(" AFTER ");
            sb2.append(s2);
            sb2.append(" ON `");
            sb2.append(s);
            sb2.append("` BEGIN UPDATE ");
            sb2.append("room_table_modification_log");
            sb2.append(" SET ");
            sb2.append("invalidated");
            sb2.append(" = 1");
            sb2.append(" WHERE ");
            sb2.append("table_id");
            sb2.append(" = ");
            sb2.append(n);
            sb2.append(" AND ");
            sb2.append("invalidated");
            sb2.append(" = 0");
            sb2.append("; END");
            g.z(sb2.toString());
        }
    }
    
    private void r(final g g, int i) {
        final String s = this.b[i];
        final StringBuilder sb = new StringBuilder();
        final String[] o = w.o;
        int length;
        String s2;
        for (length = o.length, i = 0; i < length; ++i) {
            s2 = o[i];
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            c(sb, s, s2);
            g.z(sb.toString());
        }
    }
    
    private String[] u(final String[] array) {
        final String[] m = this.m(array);
        for (final String s : m) {
            if (!this.a.containsKey(s.toLowerCase(Locale.US))) {
                final StringBuilder sb = new StringBuilder();
                sb.append("There is no table with name ");
                sb.append(s);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return m;
    }
    
    public void a(final c c) {
        final String[] m = this.m(c.mTables);
        final int[] array = new int[m.length];
        for (int length = m.length, i = 0; i < length; ++i) {
            final Integer n = this.a.get(m[i].toLowerCase(Locale.US));
            if (n == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("There is no table with name ");
                sb.append(m[i]);
                throw new IllegalArgumentException(sb.toString());
            }
            array[i] = n;
        }
        final d d = new d(c, array, m);
        synchronized (this.k) {
            final d d2 = this.k.k(c, d);
            monitorexit(this.k);
            if (d2 == null && this.i.b(array)) {
                this.s();
            }
        }
    }
    
    public void b(final c c) {
        this.a((c)new e(this, c));
    }
    
    public <T> LiveData<T> e(final String[] array, final boolean b, final Callable<T> callable) {
        return this.j.a(this.u(array), b, callable);
    }
    
    boolean f() {
        if (!this.e.isOpen()) {
            return false;
        }
        if (!this.g) {
            this.e.getOpenHelper().getWritableDatabase();
        }
        if (!this.g) {
            Log.e("ROOM", "database is not initialized even though it is open");
            return false;
        }
        return true;
    }
    
    void g(final g g) {
        synchronized (this) {
            if (this.g) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            g.z("PRAGMA temp_store = MEMORY;");
            g.z("PRAGMA recursive_triggers='ON';");
            g.z("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            this.t(g);
            this.h = g.H0("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.g = true;
        }
    }
    
    public void h(final String... array) {
        synchronized (this.k) {
            for (final Map.Entry<c, V> entry : this.k) {
                if (!entry.getKey().isRemote()) {
                    ((d)entry.getValue()).b(array);
                }
            }
        }
    }
    
    void i() {
        synchronized (this) {
            this.g = false;
            this.i.d();
        }
    }
    
    public void j() {
        if (this.f.compareAndSet(false, true)) {
            final a d = this.d;
            if (d != null) {
                d.e();
            }
            this.e.getQueryExecutor().execute(this.n);
        }
    }
    
    public void k() {
        final a d = this.d;
        if (d != null) {
            d.e();
        }
        this.s();
        this.n.run();
    }
    
    public void l(final c c) {
        synchronized (this.k) {
            final d d = this.k.m(c);
            monitorexit(this.k);
            if (d != null && this.i.c(d.a)) {
                this.s();
            }
        }
    }
    
    void n(final a d) {
        (this.d = d).h(new v(this));
    }
    
    void o(final Context context, final String s, final Intent intent) {
        this.l = new x(context, s, intent, this, this.e.getQueryExecutor());
    }
    
    void q() {
        final x l = this.l;
        if (l != null) {
            l.a();
            this.l = null;
        }
    }
    
    void s() {
        if (!this.e.isOpen()) {
            return;
        }
        this.t(this.e.getOpenHelper().getWritableDatabase());
    }
    
    void t(final g ex) {
        if (((g)ex).q1()) {
            return;
        }
        try {
            final Lock closeLock = this.e.getCloseLock();
            closeLock.lock();
            try {
                synchronized (this.m) {
                    final int[] a = this.i.a();
                    if (a == null) {
                        return;
                    }
                    final int length = a.length;
                    d((g)ex);
                    int n = 0;
                    while (true) {
                        Label_0117: {
                            if (n >= length) {
                                break Label_0117;
                            }
                            final int n2 = a[n];
                            Label_0105: {
                                if (n2 == 1) {
                                    break Label_0105;
                                }
                                Label_0111: {
                                    if (n2 != 2) {
                                        break Label_0111;
                                    }
                                    try {
                                        this.r((g)ex, n);
                                        ++n;
                                        continue;
                                        ((g)ex).p();
                                        return;
                                        this.p((g)ex, n);
                                    }
                                    finally {
                                        ((g)ex).q();
                                    }
                                }
                            }
                        }
                    }
                }
            }
            finally {
                closeLock.unlock();
            }
        }
        catch (final SQLiteException ex) {}
        catch (final IllegalStateException ex2) {}
        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", (Throwable)ex);
    }
    
    static class b
    {
        final long[] a;
        final boolean[] b;
        final int[] c;
        boolean d;
        
        b(final int n) {
            final long[] a = new long[n];
            this.a = a;
            final boolean[] b = new boolean[n];
            this.b = b;
            this.c = new int[n];
            Arrays.fill(a, 0L);
            Arrays.fill(b, false);
        }
        
        int[] a() {
            synchronized (this) {
                if (!this.d) {
                    return null;
                }
                for (int length = this.a.length, i = 0; i < length; ++i) {
                    final long n = this.a[i];
                    int n2 = 1;
                    final boolean b = n > 0L;
                    final boolean[] b2 = this.b;
                    if (b != b2[i]) {
                        final int[] c = this.c;
                        if (!b) {
                            n2 = 2;
                        }
                        c[i] = n2;
                    }
                    else {
                        this.c[i] = 0;
                    }
                    b2[i] = b;
                }
                this.d = false;
                return this.c.clone();
            }
        }
        
        boolean b(final int... array) {
            synchronized (this) {
                final int length = array.length;
                int i = 0;
                boolean b = false;
                while (i < length) {
                    final int n = array[i];
                    final long[] a = this.a;
                    final long n2 = a[n];
                    a[n] = 1L + n2;
                    if (n2 == 0L) {
                        this.d = true;
                        b = true;
                    }
                    ++i;
                }
                return b;
            }
        }
        
        boolean c(final int... array) {
            synchronized (this) {
                final int length = array.length;
                int i = 0;
                boolean b = false;
                while (i < length) {
                    if (this.a[array[i]]-- == 1L) {
                        this.d = true;
                        b = true;
                    }
                    ++i;
                }
                return b;
            }
        }
        
        void d() {
            synchronized (this) {
                Arrays.fill(this.b, false);
                this.d = true;
            }
        }
    }
    
    public abstract static class c
    {
        final String[] mTables;
        
        protected c(final String s, final String... array) {
            (this.mTables = Arrays.copyOf(array, array.length + 1))[array.length] = s;
        }
        
        public c(final String[] array) {
            this.mTables = Arrays.copyOf(array, array.length);
        }
        
        boolean isRemote() {
            return false;
        }
        
        public abstract void onInvalidated(final Set<String> p0);
    }
    
    static class d
    {
        final int[] a;
        private final String[] b;
        final c c;
        private final Set<String> d;
        
        d(final c c, final int[] a, final String[] b) {
            this.c = c;
            this.a = a;
            this.b = b;
            if (a.length == 1) {
                final HashSet set = new HashSet();
                set.add(b[0]);
                this.d = (Set<String>)Collections.unmodifiableSet((Set<?>)set);
            }
            else {
                this.d = null;
            }
        }
        
        void a(final Set<Integer> set) {
            final int length = this.a.length;
            Set<String> set2 = null;
            Set<String> d;
            for (int i = 0; i < length; ++i, set2 = d) {
                d = set2;
                if (set.contains(this.a[i])) {
                    if (length == 1) {
                        d = this.d;
                    }
                    else {
                        if ((d = set2) == null) {
                            d = new HashSet<String>(length);
                        }
                        d.add(this.b[i]);
                    }
                }
            }
            if (set2 != null) {
                this.c.onInvalidated(set2);
            }
        }
        
        void b(final String[] array) {
            final int length = this.b.length;
            final Set<String> set = null;
            Set<String> d;
            if (length == 1) {
                final int length2 = array.length;
                int n = 0;
                while (true) {
                    d = set;
                    if (n >= length2) {
                        break;
                    }
                    if (array[n].equalsIgnoreCase(this.b[0])) {
                        d = this.d;
                        break;
                    }
                    ++n;
                }
            }
            else {
                final HashSet set2 = new HashSet();
                for (final String s : array) {
                    for (final String s2 : this.b) {
                        if (s2.equalsIgnoreCase(s)) {
                            set2.add(s2);
                            break;
                        }
                    }
                }
                d = set;
                if (set2.size() > 0) {
                    d = set2;
                }
            }
            if (d != null) {
                this.c.onInvalidated(d);
            }
        }
    }
    
    static class e extends c
    {
        final w a;
        final WeakReference<c> b;
        
        e(final w a, final c c) {
            super(c.mTables);
            this.a = a;
            this.b = new WeakReference<c>(c);
        }
        
        @Override
        public void onInvalidated(final Set<String> set) {
            final c c = this.b.get();
            if (c == null) {
                this.a.l((c)this);
            }
            else {
                c.onInvalidated(set);
            }
        }
    }
}
