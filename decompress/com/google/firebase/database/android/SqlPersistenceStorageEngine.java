// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.android;

import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Collections;
import java.util.HashSet;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.persistence.TrackedQuery;
import java.util.Set;
import android.database.sqlite.SQLiteException;
import com.google.firebase.database.DatabaseException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.Cursor;
import java.util.HashMap;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.Collection;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.ArrayList;
import com.google.firebase.database.util.JsonMapper;
import android.content.ContentValues;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import java.util.Iterator;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Map;
import java.util.Locale;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.core.utilities.Pair;
import java.util.List;
import com.google.firebase.database.core.persistence.PruneForest;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.Path;
import java.io.IOException;
import java.net.URLEncoder;
import android.content.Context;
import com.google.firebase.database.logging.LogWrapper;
import android.database.sqlite.SQLiteDatabase;
import java.nio.charset.Charset;
import com.google.firebase.database.core.persistence.PersistenceStorageEngine;

public class SqlPersistenceStorageEngine implements PersistenceStorageEngine
{
    private static final Charset e;
    private final SQLiteDatabase a;
    private final LogWrapper b;
    private boolean c;
    private long d;
    
    static {
        e = Charset.forName("UTF-8");
    }
    
    public SqlPersistenceStorageEngine(final Context context, final com.google.firebase.database.core.Context context2, String encode) {
        this.d = 0L;
        try {
            encode = URLEncoder.encode(encode, "utf-8");
            this.b = context2.q("Persistence");
            this.a = this.k(context, encode);
        }
        catch (final IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private void F(Path m, final Path path, final ImmutableTree<Long> immutableTree, final ImmutableTree<Long> immutableTree2, final PruneForest pruneForest, final List<Pair<Path, Node>> list) {
        if (immutableTree.getValue() != null) {
            final int intValue = pruneForest.b(0, new ImmutableTree.TreeVisitor<Void, Integer>(this, immutableTree2) {
                final ImmutableTree a;
                final SqlPersistenceStorageEngine b;
                
                @Override
                public /* bridge */ Object a(final Path path, final Object o, final Object o2) {
                    return this.b(path, (Void)o, (Integer)o2);
                }
                
                public Integer b(final Path path, final Void void1, final Integer n) {
                    int intValue;
                    if (this.a.n(path) == null) {
                        intValue = n + 1;
                    }
                    else {
                        intValue = n;
                    }
                    return intValue;
                }
            });
            if (intValue > 0) {
                m = m.m(path);
                if (this.b.f()) {
                    this.b.b(String.format(Locale.US, "Need to rewrite %d nodes below path %s", intValue, m), new Object[0]);
                }
                pruneForest.b(null, (ImmutableTree.TreeVisitor<Void, Object>)new ImmutableTree.TreeVisitor<Void, Void>(this, immutableTree2, list, path, this.i(m)) {
                    final ImmutableTree a;
                    final List b;
                    final Path c;
                    final Node d;
                    final SqlPersistenceStorageEngine e;
                    
                    @Override
                    public /* bridge */ Object a(final Path path, final Object o, final Object o2) {
                        return this.b(path, (Void)o, (Void)o2);
                    }
                    
                    public Void b(final Path path, final Void void1, final Void void2) {
                        if (this.a.n(path) == null) {
                            this.b.add(new Pair(this.c.m(path), this.d.F(path)));
                        }
                        return null;
                    }
                });
            }
        }
        else {
            for (final Map.Entry<ChildKey, V> entry : immutableTree.p()) {
                final ChildKey childKey = entry.getKey();
                this.F(m, path.n(childKey), (ImmutableTree<Long>)entry.getValue(), immutableTree2.o(childKey), pruneForest.a(entry.getKey()), list);
            }
        }
    }
    
    private int G(final String s, final Path path) {
        final String o = o(path);
        return this.a.delete(s, "path >= ? AND path < ?", new String[] { o, n(o) });
    }
    
    private int H(final Path path, final Node node) {
        final long b = NodeSizeEstimator.b(node);
        if (node instanceof ChildrenNode && b > 16384L) {
            final boolean f = this.b.f();
            int n = 0;
            if (f) {
                this.b.b(String.format(Locale.US, "Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", path, b, 16384), new Object[0]);
            }
            for (final NamedNode namedNode : node) {
                n += this.H(path.n(namedNode.c()), namedNode.d());
            }
            int n2 = n;
            if (!node.C0().isEmpty()) {
                this.I(path.n(ChildKey.i()), node.C0());
                n2 = n + 1;
            }
            this.I(path, EmptyNode.p());
            return n2 + 1;
        }
        this.I(path, node);
        return 1;
    }
    
    private void I(final Path path, final Node node) {
        final byte[] k = this.K(node.t0(true));
        if (k.length >= 262144) {
            final List<byte[]> l = L(k, 262144);
            final boolean f = this.b.f();
            int i;
            final int n = i = 0;
            if (f) {
                final LogWrapper b = this.b;
                final StringBuilder sb = new StringBuilder();
                sb.append("Saving huge leaf node with ");
                sb.append(l.size());
                sb.append(" parts.");
                b.b(sb.toString(), new Object[0]);
                i = n;
            }
            while (i < l.size()) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put("path", this.l(path, i));
                contentValues.put("value", (byte[])l.get(i));
                this.a.insertWithOnConflict("serverCache", (String)null, contentValues, 5);
                ++i;
            }
        }
        else {
            final ContentValues contentValues2 = new ContentValues();
            contentValues2.put("path", o(path));
            contentValues2.put("value", k);
            this.a.insertWithOnConflict("serverCache", (String)null, contentValues2, 5);
        }
    }
    
    private void J(final Path path, final long n, final String s, final byte[] array) {
        this.O();
        final SQLiteDatabase a = this.a;
        int i = 0;
        a.delete("writes", "id = ?", new String[] { String.valueOf(n) });
        if (array.length >= 262144) {
            for (List<byte[]> l = L(array, 262144); i < l.size(); ++i) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(n));
                contentValues.put("path", o(path));
                contentValues.put("type", s);
                contentValues.put("part", Integer.valueOf(i));
                contentValues.put("node", (byte[])l.get(i));
                this.a.insertWithOnConflict("writes", (String)null, contentValues, 5);
            }
        }
        else {
            final ContentValues contentValues2 = new ContentValues();
            contentValues2.put("id", Long.valueOf(n));
            contentValues2.put("path", o(path));
            contentValues2.put("type", s);
            contentValues2.put("part", (Integer)null);
            contentValues2.put("node", array);
            this.a.insertWithOnConflict("writes", (String)null, contentValues2, 5);
        }
    }
    
    private byte[] K(final Object o) {
        try {
            return JsonMapper.d(o).getBytes(SqlPersistenceStorageEngine.e);
        }
        catch (final IOException ex) {
            throw new RuntimeException("Could not serialize leaf node", ex);
        }
    }
    
    private static List<byte[]> L(final byte[] array, final int n) {
        final int n2 = (array.length - 1) / n + 1;
        final ArrayList list = new ArrayList(n2);
        for (int i = 0; i < n2; ++i) {
            final int length = array.length;
            final int n3 = i * n;
            final int min = Math.min(n, length - n3);
            final byte[] array2 = new byte[min];
            System.arraycopy(array, n3, array2, 0, min);
            list.add((Object)array2);
        }
        return (List<byte[]>)list;
    }
    
    private int M(final Path path, final List<String> list, final int n) {
        int n2 = n + 1;
        final String o = o(path);
        if (list.get(n).startsWith(o)) {
            while (n2 < list.size() && ((String)list.get(n2)).equals(this.l(path, n2 - n))) {
                ++n2;
            }
            if (n2 < list.size()) {
                final String s = list.get(n2);
                final StringBuilder sb = new StringBuilder();
                sb.append(o);
                sb.append(".part-");
                if (s.startsWith(sb.toString())) {
                    throw new IllegalStateException("Run did not finish with all parts");
                }
            }
            return n2 - n;
        }
        throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
    }
    
    private void N(final Path path, final Node node, final boolean b) {
        final long currentTimeMillis = System.currentTimeMillis();
        int g;
        int h;
        if (!b) {
            g = this.G("serverCache", path);
            h = this.H(path, node);
        }
        else {
            final Iterator<NamedNode> iterator = node.iterator();
            h = 0;
            g = 0;
            while (iterator.hasNext()) {
                final NamedNode namedNode = iterator.next();
                g += this.G("serverCache", path.n(namedNode.c()));
                h += this.H(path.n(namedNode.c()), namedNode.d());
            }
        }
        final long currentTimeMillis2 = System.currentTimeMillis();
        if (this.b.f()) {
            this.b.b(String.format(Locale.US, "Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", h, g, path.toString(), currentTimeMillis2 - currentTimeMillis), new Object[0]);
        }
    }
    
    private void O() {
        Utilities.g(this.c, "Transaction expected to already be in progress.");
    }
    
    private static String e(Path w, final String[] array) {
        final int length = array.length;
        final int size = w.size();
        boolean b = true;
        int n = 0;
        if (length < size + 1) {
            b = false;
        }
        Utilities.f(b);
        final StringBuilder sb = new StringBuilder("(");
        while (!w.isEmpty()) {
            sb.append("path");
            sb.append(" = ? OR ");
            array[n] = o(w);
            w = w.w();
            ++n;
        }
        sb.append("path");
        sb.append(" = ?)");
        array[n] = o(Path.s());
        return sb.toString();
    }
    
    private String f(final Collection<Long> collection) {
        final StringBuilder sb = new StringBuilder();
        final Iterator<Long> iterator = collection.iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final long longValue = iterator.next();
            if (n == 0) {
                sb.append(",");
            }
            n = 0;
            sb.append(longValue);
        }
        return sb.toString();
    }
    
    private Node g(final byte[] array) {
        try {
            return NodeUtilities.a(JsonMapper.b(new String(array, SqlPersistenceStorageEngine.e)));
        }
        catch (final IOException ex) {
            final String s = new String(array, SqlPersistenceStorageEngine.e);
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not deserialize node: ");
            sb.append(s);
            throw new RuntimeException(sb.toString(), ex);
        }
    }
    
    private byte[] h(final List<byte[]> list) {
        final Iterator<byte[]> iterator = list.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            n += iterator.next().length;
        }
        final byte[] array = new byte[n];
        final Iterator<byte[]> iterator2 = list.iterator();
        int n2 = 0;
        while (iterator2.hasNext()) {
            final byte[] array2 = iterator2.next();
            System.arraycopy(array2, 0, array, n2, array2.length);
            n2 += array2.length;
        }
        return array;
    }
    
    private Node i(final Path path) {
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final long currentTimeMillis = System.currentTimeMillis();
        Object o = this.j(path, new String[] { "path", "value" });
        final long n = System.currentTimeMillis() - currentTimeMillis;
        final long currentTimeMillis2 = System.currentTimeMillis();
        try {
            while (((Cursor)o).moveToNext()) {
                list.add(((Cursor)o).getString(0));
                list2.add(((Cursor)o).getBlob(1));
            }
            ((Cursor)o).close();
            final long n2 = System.currentTimeMillis() - currentTimeMillis2;
            final long currentTimeMillis3 = System.currentTimeMillis();
            o = EmptyNode.p();
            final HashMap hashMap = new HashMap();
            int i = 0;
            int n3 = 0;
            while (i < list2.size()) {
                Path path2;
                Node node;
                if (((String)list.get(i)).endsWith(".part-0000")) {
                    final String s = (String)list.get(i);
                    path2 = new Path(s.substring(0, s.length() - 10));
                    final int m = this.M(path2, list, i);
                    if (this.b.f()) {
                        final LogWrapper b = this.b;
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Loading split node with ");
                        sb.append(m);
                        sb.append(" parts.");
                        b.b(sb.toString(), new Object[0]);
                    }
                    final int n4 = m + i;
                    node = this.g(this.h(list2.subList(i, n4)));
                    i = n4 - 1;
                }
                else {
                    node = this.g((byte[])list2.get(i));
                    path2 = new Path((String)list.get(i));
                }
                if (path2.q() != null && path2.q().m()) {
                    hashMap.put(path2, node);
                }
                else if (path2.p(path)) {
                    Utilities.g((boolean)((n3 ^ 0x1) != 0x0), "Descendants of path must come after ancestors.");
                    o = node.F(Path.x(path2, path));
                }
                else {
                    if (!path.p(path2)) {
                        throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", path2, path));
                    }
                    o = ((Node)o).V(Path.x(path, path2), node);
                    n3 = 1;
                }
                ++i;
            }
            for (final Map.Entry<Path, V> entry : hashMap.entrySet()) {
                o = ((Node)o).V(Path.x(path, entry.getKey()), (Node)entry.getValue());
            }
            final long currentTimeMillis4 = System.currentTimeMillis();
            final long currentTimeMillis5 = System.currentTimeMillis();
            if (this.b.f()) {
                this.b.b(String.format(Locale.US, "Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", list2.size(), NodeSizeEstimator.c((Node)o), path, currentTimeMillis5 - currentTimeMillis, n, n2, currentTimeMillis4 - currentTimeMillis3), new Object[0]);
            }
            return (Node)o;
        }
        finally {
            ((Cursor)o).close();
        }
    }
    
    private Cursor j(final Path path, final String[] array) {
        final String o = o(path);
        final String n = n(o);
        final String[] array2 = new String[path.size() + 3];
        final String e = e(path, array2);
        final StringBuilder sb = new StringBuilder();
        sb.append(e);
        sb.append(" OR (path > ? AND path < ?)");
        final String string = sb.toString();
        array2[path.size() + 1] = o;
        array2[path.size() + 2] = n;
        return this.a.query("serverCache", array, string, array2, (String)null, (String)null, "path");
    }
    
    private SQLiteDatabase k(final Context context, final String s) {
        final c c = new c(context, s);
        try {
            final SQLiteDatabase writableDatabase = c.getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", (String[])null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        }
        catch (final SQLiteException ex) {
            if (ex instanceof SQLiteDatabaseLockedException) {
                throw new DatabaseException("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", (Throwable)ex);
            }
            throw ex;
        }
    }
    
    private String l(final Path path, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(o(path));
        sb.append(String.format(Locale.US, ".part-%04d", n));
        return sb.toString();
    }
    
    private static String n(final String s) {
        Utilities.g(s.endsWith("/"), "Path keys must end with a '/'");
        final StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, s.length() - 1));
        sb.append('0');
        return sb.toString();
    }
    
    private static String o(final Path path) {
        if (path.isEmpty()) {
            return "/";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(path.toString());
        sb.append("/");
        return sb.toString();
    }
    
    @Override
    public Node A(final Path path) {
        return this.i(path);
    }
    
    @Override
    public void B(final long n, final Set<ChildKey> set) {
        this.O();
        final long currentTimeMillis = System.currentTimeMillis();
        this.a.delete("trackedKeys", "id = ?", new String[] { String.valueOf(n) });
        for (final ChildKey childKey : set) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(n));
            contentValues.put("key", childKey.c());
            this.a.insertWithOnConflict("trackedKeys", (String)null, contentValues, 5);
        }
        final long currentTimeMillis2 = System.currentTimeMillis();
        if (this.b.f()) {
            this.b.b(String.format(Locale.US, "Set %d tracked query keys for tracked query %d in %dms", set.size(), n, currentTimeMillis2 - currentTimeMillis), new Object[0]);
        }
    }
    
    @Override
    public void C(final Path path, final Node node) {
        this.O();
        this.N(path, node, false);
    }
    
    @Override
    public List<TrackedQuery> D() {
        final long currentTimeMillis = System.currentTimeMillis();
        final Cursor query = this.a.query("trackedQueries", new String[] { "id", "path", "queryParams", "lastUse", "complete", "active" }, (String)null, (String[])null, (String)null, (String)null, "id");
        final ArrayList list = new ArrayList();
        try {
            while (query.moveToNext()) {
                final long long1 = query.getLong(0);
                final Path path = new Path(query.getString(1));
                final String string = query.getString(2);
                try {
                    list.add(new TrackedQuery(long1, QuerySpec.b(path, JsonMapper.a(string)), query.getLong(3), query.getInt(4) != 0, query.getInt(5) != 0));
                    continue;
                }
                catch (final IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }
            final long currentTimeMillis2 = System.currentTimeMillis();
            if (this.b.f()) {
                this.b.b(String.format(Locale.US, "Loaded %d tracked queries in %dms", list.size(), currentTimeMillis2 - currentTimeMillis), new Object[0]);
            }
            return list;
        }
        finally {
            query.close();
        }
    }
    
    @Override
    public void E(final long n, final Set<ChildKey> set, final Set<ChildKey> set2) {
        this.O();
        final long currentTimeMillis = System.currentTimeMillis();
        final Iterator iterator = set2.iterator();
        while (iterator.hasNext()) {
            this.a.delete("trackedKeys", "id = ? AND key = ?", new String[] { String.valueOf(n), ((ChildKey)iterator.next()).c() });
        }
        for (final ChildKey childKey : set) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(n));
            contentValues.put("key", childKey.c());
            this.a.insertWithOnConflict("trackedKeys", (String)null, contentValues, 5);
        }
        final long currentTimeMillis2 = System.currentTimeMillis();
        if (this.b.f()) {
            this.b.b(String.format(Locale.US, "Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", set.size(), set2.size(), n, currentTimeMillis2 - currentTimeMillis), new Object[0]);
        }
    }
    
    @Override
    public void a(final Path path, final CompoundWrite compoundWrite, long currentTimeMillis) {
        this.O();
        final long currentTimeMillis2 = System.currentTimeMillis();
        this.J(path, currentTimeMillis, "m", this.K(compoundWrite.t(true)));
        currentTimeMillis = System.currentTimeMillis();
        if (this.b.f()) {
            this.b.b(String.format(Locale.US, "Persisted user merge in %dms", currentTimeMillis - currentTimeMillis2), new Object[0]);
        }
    }
    
    @Override
    public List<UserWriteRecord> b() {
        final long currentTimeMillis = System.currentTimeMillis();
        final Cursor query = this.a.query("writes", new String[] { "id", "path", "type", "part", "node" }, (String)null, (String[])null, (String)null, (String)null, "id, part");
        final ArrayList list = new ArrayList();
        try {
            try {
                while (query.moveToNext()) {
                    final long long1 = query.getLong(0);
                    final Path path = new Path(query.getString(1));
                    final String string = query.getString(2);
                    byte[] array;
                    if (query.isNull(3)) {
                        array = query.getBlob(4);
                    }
                    else {
                        final ArrayList list2 = new ArrayList();
                        do {
                            list2.add(query.getBlob(4));
                        } while (query.moveToNext() && query.getLong(0) == long1);
                        query.moveToPrevious();
                        array = this.h(list2);
                    }
                    final Object b = JsonMapper.b(new String(array, SqlPersistenceStorageEngine.e));
                    UserWriteRecord userWriteRecord;
                    if ("o".equals(string)) {
                        userWriteRecord = new UserWriteRecord(long1, path, NodeUtilities.a(b), true);
                    }
                    else {
                        if (!"m".equals(string)) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Got invalid write type: ");
                            sb.append(string);
                            throw new IllegalStateException(sb.toString());
                        }
                        userWriteRecord = new UserWriteRecord(long1, path, CompoundWrite.p((Map<String, Object>)b));
                    }
                    list.add(userWriteRecord);
                }
                final long currentTimeMillis2 = System.currentTimeMillis();
                if (this.b.f()) {
                    this.b.b(String.format(Locale.US, "Loaded %d writes in %dms", list.size(), currentTimeMillis2 - currentTimeMillis), new Object[0]);
                }
                query.close();
                return list;
            }
            finally {}
        }
        catch (final IOException ex) {
            throw new RuntimeException("Failed to load writes", ex);
        }
        query.close();
    }
    
    @Override
    public void c(final long n) {
        this.O();
        final long currentTimeMillis = System.currentTimeMillis();
        final int delete = this.a.delete("writes", "id = ?", new String[] { String.valueOf(n) });
        final long currentTimeMillis2 = System.currentTimeMillis();
        if (this.b.f()) {
            this.b.b(String.format(Locale.US, "Deleted %d write(s) with writeId %d in %dms", delete, n, currentTimeMillis2 - currentTimeMillis), new Object[0]);
        }
    }
    
    @Override
    public void d(final Path path, final Node node, long currentTimeMillis) {
        this.O();
        final long currentTimeMillis2 = System.currentTimeMillis();
        this.J(path, currentTimeMillis, "o", this.K(node.t0(true)));
        currentTimeMillis = System.currentTimeMillis();
        if (this.b.f()) {
            this.b.b(String.format(Locale.US, "Persisted user overwrite in %dms", currentTimeMillis - currentTimeMillis2), new Object[0]);
        }
    }
    
    @Override
    public void m() {
        Utilities.g(this.c ^ true, "runInTransaction called when an existing transaction is already in progress.");
        if (this.b.f()) {
            this.b.b("Starting transaction.", new Object[0]);
        }
        this.a.beginTransaction();
        this.c = true;
        this.d = System.currentTimeMillis();
    }
    
    @Override
    public void p() {
        this.a.setTransactionSuccessful();
    }
    
    @Override
    public void q() {
        this.a.endTransaction();
        this.c = false;
        final long currentTimeMillis = System.currentTimeMillis();
        final long d = this.d;
        if (this.b.f()) {
            this.b.b(String.format(Locale.US, "Transaction completed. Elapsed: %dms", currentTimeMillis - d), new Object[0]);
        }
    }
    
    @Override
    public void r(final long n) {
        this.O();
        final String value = String.valueOf(n);
        this.a.delete("trackedQueries", "id = ?", new String[] { value });
        this.a.delete("trackedKeys", "id = ?", new String[] { value });
    }
    
    @Override
    public void s(final Path path, final CompoundWrite compoundWrite) {
        this.O();
        final long currentTimeMillis = System.currentTimeMillis();
        final Iterator<Map.Entry<Path, Node>> iterator = compoundWrite.iterator();
        int n = 0;
        int n2 = 0;
        while (iterator.hasNext()) {
            final Map.Entry<Path, V> entry = (Map.Entry<Path, V>)iterator.next();
            n += this.G("serverCache", path.m(entry.getKey()));
            n2 += this.H(path.m(entry.getKey()), (Node)entry.getValue());
        }
        final long currentTimeMillis2 = System.currentTimeMillis();
        if (this.b.f()) {
            this.b.b(String.format(Locale.US, "Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", n2, n, path.toString(), currentTimeMillis2 - currentTimeMillis), new Object[0]);
        }
    }
    
    @Override
    public Set<ChildKey> t(final Set<Long> set) {
        final long currentTimeMillis = System.currentTimeMillis();
        final StringBuilder sb = new StringBuilder();
        sb.append("id IN (");
        sb.append(this.f(set));
        sb.append(")");
        final Cursor query = this.a.query(true, "trackedKeys", new String[] { "key" }, sb.toString(), (String[])null, (String)null, (String)null, (String)null, (String)null);
        final HashSet set2 = new HashSet();
        try {
            while (query.moveToNext()) {
                set2.add(ChildKey.f(query.getString(0)));
            }
            final long currentTimeMillis2 = System.currentTimeMillis();
            if (this.b.f()) {
                this.b.b(String.format(Locale.US, "Loaded %d tracked queries keys for tracked queries %s in %dms", set2.size(), set.toString(), currentTimeMillis2 - currentTimeMillis), new Object[0]);
            }
            return set2;
        }
        finally {
            query.close();
        }
    }
    
    @Override
    public void u(long currentTimeMillis) {
        this.O();
        final long currentTimeMillis2 = System.currentTimeMillis();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("active", Boolean.FALSE);
        contentValues.put("lastUse", Long.valueOf(currentTimeMillis));
        this.a.updateWithOnConflict("trackedQueries", contentValues, "active = 1", new String[0], 5);
        currentTimeMillis = System.currentTimeMillis();
        if (this.b.f()) {
            this.b.b(String.format(Locale.US, "Reset active tracked queries in %dms", currentTimeMillis - currentTimeMillis2), new Object[0]);
        }
    }
    
    @Override
    public void v(final Path path, final Node node) {
        this.O();
        this.N(path, node, true);
    }
    
    @Override
    public void w(final TrackedQuery trackedQuery) {
        this.O();
        final long currentTimeMillis = System.currentTimeMillis();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(trackedQuery.a));
        contentValues.put("path", o(trackedQuery.b.e()));
        contentValues.put("queryParams", trackedQuery.b.d().q());
        contentValues.put("lastUse", Long.valueOf(trackedQuery.c));
        contentValues.put("complete", Boolean.valueOf(trackedQuery.d));
        contentValues.put("active", Boolean.valueOf(trackedQuery.e));
        this.a.insertWithOnConflict("trackedQueries", (String)null, contentValues, 5);
        final long currentTimeMillis2 = System.currentTimeMillis();
        if (this.b.f()) {
            this.b.b(String.format(Locale.US, "Saved new tracked query in %dms", currentTimeMillis2 - currentTimeMillis), new Object[0]);
        }
    }
    
    @Override
    public long x() {
        final Cursor rawQuery = this.a.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", "value", "path", "serverCache"), (String[])null);
        try {
            if (rawQuery.moveToFirst()) {
                return rawQuery.getLong(0);
            }
            throw new IllegalStateException("Couldn't read database result!");
        }
        finally {
            rawQuery.close();
        }
    }
    
    @Override
    public void y(final Path path, final PruneForest pruneForest) {
        if (!pruneForest.e()) {
            return;
        }
        this.O();
        final long currentTimeMillis = System.currentTimeMillis();
        final Cursor j = this.j(path, new String[] { "rowid", "path" });
        ImmutableTree<Long> w = new ImmutableTree<Long>(null);
        ImmutableTree<Long> w2 = new ImmutableTree<Long>(null);
        while (j.moveToNext()) {
            final long long1 = j.getLong(0);
            final Path path2 = new Path(j.getString(1));
            if (!path.p(path2)) {
                final LogWrapper b = this.b;
                final StringBuilder sb = new StringBuilder();
                sb.append("We are pruning at ");
                sb.append(path);
                sb.append(" but we have data stored higher up at ");
                sb.append(path2);
                sb.append(". Ignoring.");
                b.i(sb.toString());
            }
            else {
                final Path x = Path.x(path, path2);
                if (pruneForest.g(x)) {
                    w = w.w(x, long1);
                }
                else if (pruneForest.f(x)) {
                    w2 = w2.w(x, long1);
                }
                else {
                    final LogWrapper b2 = this.b;
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("We are pruning at ");
                    sb2.append(path);
                    sb2.append(" and have data at ");
                    sb2.append(path2);
                    sb2.append(" that isn't marked for pruning or keeping. Ignoring.");
                    b2.i(sb2.toString());
                }
            }
        }
        int size;
        int size2;
        if (!w.isEmpty()) {
            final ArrayList list = new ArrayList<Pair<Path, Node>>();
            this.F(path, Path.s(), w, w2, pruneForest, list);
            final Collection<Long> z = w.z();
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("rowid IN (");
            sb3.append(this.f(z));
            sb3.append(")");
            this.a.delete("serverCache", sb3.toString(), (String[])null);
            for (final Pair pair : list) {
                this.H(path.m((Path)pair.a()), (Node)pair.b());
            }
            size = z.size();
            size2 = list.size();
        }
        else {
            size = 0;
            size2 = 0;
        }
        final long currentTimeMillis2 = System.currentTimeMillis();
        if (this.b.f()) {
            this.b.b(String.format(Locale.US, "Pruned %d rows with %d nodes resaved in %dms", size, size2, currentTimeMillis2 - currentTimeMillis), new Object[0]);
        }
    }
    
    @Override
    public Set<ChildKey> z(final long n) {
        return this.t(Collections.singleton(n));
    }
    
    private static class c extends SQLiteOpenHelper
    {
        public c(final Context context, final String s) {
            super(context, s, (SQLiteDatabase$CursorFactory)null, 2);
        }
        
        private void a(final SQLiteDatabase sqLiteDatabase, final String s) {
            final StringBuilder sb = new StringBuilder();
            sb.append("DROP TABLE IF EXISTS ");
            sb.append(s);
            sqLiteDatabase.execSQL(sb.toString());
        }
        
        public void onCreate(final SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
            sqLiteDatabase.execSQL("CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));");
            sqLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            sqLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
        }
        
        public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
            Utilities.g(n2 == 2, "Why is onUpgrade() called with a different version?");
            if (n <= 1) {
                this.a(sqLiteDatabase, "serverCache");
                sqLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
                this.a(sqLiteDatabase, "complete");
                sqLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
                sqLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("We don't handle upgrading to ");
            sb.append(n2);
            throw new AssertionError((Object)sb.toString());
        }
    }
}
