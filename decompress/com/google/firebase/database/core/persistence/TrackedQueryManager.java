// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.persistence;

import java.util.Collections;
import java.util.Comparator;
import java.util.Collection;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import com.google.firebase.database.core.Path;
import java.util.HashMap;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.Iterator;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.view.QueryParams;
import java.util.Map;
import com.google.firebase.database.core.utilities.Predicate;

public class TrackedQueryManager
{
    private static final Predicate<Map<QueryParams, TrackedQuery>> f;
    private static final Predicate<Map<QueryParams, TrackedQuery>> g;
    private static final Predicate<TrackedQuery> h;
    private static final Predicate<TrackedQuery> i;
    private ImmutableTree<Map<QueryParams, TrackedQuery>> a;
    private final PersistenceStorageEngine b;
    private final LogWrapper c;
    private final Clock d;
    private long e;
    
    static {
        f = new Predicate<Map<QueryParams, TrackedQuery>>() {
            @Override
            public /* bridge */ boolean a(final Object o) {
                return this.b((Map<QueryParams, TrackedQuery>)o);
            }
            
            public boolean b(final Map<QueryParams, TrackedQuery> map) {
                final TrackedQuery trackedQuery = map.get(QueryParams.i);
                return trackedQuery != null && trackedQuery.d;
            }
        };
        g = new Predicate<Map<QueryParams, TrackedQuery>>() {
            @Override
            public /* bridge */ boolean a(final Object o) {
                return this.b((Map<QueryParams, TrackedQuery>)o);
            }
            
            public boolean b(final Map<QueryParams, TrackedQuery> map) {
                final TrackedQuery trackedQuery = map.get(QueryParams.i);
                return trackedQuery != null && trackedQuery.e;
            }
        };
        h = new Predicate<TrackedQuery>() {
            @Override
            public /* bridge */ boolean a(final Object o) {
                return this.b((TrackedQuery)o);
            }
            
            public boolean b(final TrackedQuery trackedQuery) {
                return trackedQuery.e ^ true;
            }
        };
        i = new Predicate<TrackedQuery>() {
            @Override
            public /* bridge */ boolean a(final Object o) {
                return this.b((TrackedQuery)o);
            }
            
            public boolean b(final TrackedQuery trackedQuery) {
                return TrackedQueryManager.a().a(trackedQuery) ^ true;
            }
        };
    }
    
    public TrackedQueryManager(final PersistenceStorageEngine b, final LogWrapper c, final Clock d) {
        this.e = 0L;
        this.b = b;
        this.c = c;
        this.d = d;
        this.a = new ImmutableTree<Map<QueryParams, TrackedQuery>>(null);
        this.r();
        for (final TrackedQuery trackedQuery : b.D()) {
            this.e = Math.max(trackedQuery.a + 1L, this.e);
            this.d(trackedQuery);
        }
    }
    
    static Predicate a() {
        return TrackedQueryManager.h;
    }
    
    static void b(final TrackedQueryManager trackedQueryManager, final TrackedQuery trackedQuery) {
        trackedQueryManager.s(trackedQuery);
    }
    
    private static void c(final QuerySpec querySpec) {
        Utilities.g(!querySpec.g() || querySpec.f(), "Can't have tracked non-default query that loads all data");
    }
    
    private void d(final TrackedQuery trackedQuery) {
        c(trackedQuery.b);
        Map map;
        if ((map = this.a.n(trackedQuery.b.e())) == null) {
            map = new HashMap();
            this.a = (ImmutableTree<Map<QueryParams, TrackedQuery>>)this.a.w(trackedQuery.b.e(), map);
        }
        final TrackedQuery trackedQuery2 = (TrackedQuery)map.get(trackedQuery.b.d());
        Utilities.f(trackedQuery2 == null || trackedQuery2.a == trackedQuery.a);
        map.put(trackedQuery.b.d(), trackedQuery);
    }
    
    private static long e(final CachePolicy cachePolicy, final long n) {
        return n - Math.min((long)Math.floor(n * (1.0f - cachePolicy.b())), cachePolicy.c());
    }
    
    private Set<Long> h(final Path path) {
        final HashSet set = new HashSet();
        final Map map = this.a.n(path);
        if (map != null) {
            for (final TrackedQuery trackedQuery : map.values()) {
                if (!trackedQuery.b.g()) {
                    set.add(trackedQuery.a);
                }
            }
        }
        return set;
    }
    
    private List<TrackedQuery> k(final Predicate<TrackedQuery> predicate) {
        final ArrayList list = new ArrayList();
        final Iterator<Map.Entry<Path, Map<QueryParams, TrackedQuery>>> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            for (final TrackedQuery trackedQuery : ((Map.Entry<K, Map>)iterator.next()).getValue().values()) {
                if (predicate.a(trackedQuery)) {
                    list.add(trackedQuery);
                }
            }
        }
        return list;
    }
    
    private boolean m(final Path path) {
        return this.a.e(path, TrackedQueryManager.f) != null;
    }
    
    private static QuerySpec o(final QuerySpec querySpec) {
        QuerySpec a = querySpec;
        if (querySpec.g()) {
            a = QuerySpec.a(querySpec.e());
        }
        return a;
    }
    
    private void r() {
        try {
            this.b.m();
            this.b.u(this.d.a());
            this.b.p();
        }
        finally {
            this.b.q();
        }
    }
    
    private void s(final TrackedQuery trackedQuery) {
        this.d(trackedQuery);
        this.b.w(trackedQuery);
    }
    
    private void v(QuerySpec o, final boolean b) {
        o = o(o);
        final TrackedQuery i = this.i(o);
        final long a = this.d.a();
        TrackedQuery a2;
        if (i != null) {
            a2 = i.c(a).a(b);
        }
        else {
            Utilities.g(b, "If we're setting the query to inactive, we should already be tracking it!");
            final long e = this.e;
            this.e = 1L + e;
            a2 = new TrackedQuery(e, o, a, false, b);
        }
        this.s(a2);
    }
    
    public long f() {
        return this.k(TrackedQueryManager.h).size();
    }
    
    public void g(final Path path) {
        if (!this.m(path)) {
            final QuerySpec a = QuerySpec.a(path);
            final TrackedQuery i = this.i(a);
            TrackedQuery b;
            if (i == null) {
                final long e = this.e;
                this.e = 1L + e;
                b = new TrackedQuery(e, a, this.d.a(), true, false);
            }
            else {
                Utilities.g(i.d ^ true, "This should have been handled above!");
                b = i.b();
            }
            this.s(b);
        }
    }
    
    public TrackedQuery i(QuerySpec o) {
        o = o(o);
        final Map map = this.a.n(o.e());
        TrackedQuery trackedQuery;
        if (map != null) {
            trackedQuery = (TrackedQuery)map.get(o.d());
        }
        else {
            trackedQuery = null;
        }
        return trackedQuery;
    }
    
    public Set<ChildKey> j(final Path path) {
        Utilities.g(this.n(QuerySpec.a(path)) ^ true, "Path is fully complete.");
        final HashSet set = new HashSet();
        final Set<Long> h = this.h(path);
        if (!h.isEmpty()) {
            set.addAll(this.b.t(h));
        }
        for (final Map.Entry<ChildKey, V> entry : this.a.y(path).p()) {
            final ChildKey childKey = entry.getKey();
            final ImmutableTree immutableTree = (ImmutableTree)entry.getValue();
            if (immutableTree.getValue() != null && TrackedQueryManager.f.a((Map<QueryParams, TrackedQuery>)immutableTree.getValue())) {
                set.add(childKey);
            }
        }
        return set;
    }
    
    public boolean l(final Path path) {
        return this.a.v(path, TrackedQueryManager.g) != null;
    }
    
    public boolean n(final QuerySpec querySpec) {
        final boolean m = this.m(querySpec.e());
        boolean b = true;
        if (m) {
            return true;
        }
        if (querySpec.g()) {
            return false;
        }
        final Map map = this.a.n(querySpec.e());
        if (map == null || !map.containsKey(querySpec.d()) || !((TrackedQuery)map.get(querySpec.d())).d) {
            b = false;
        }
        return b;
    }
    
    public PruneForest p(final CachePolicy cachePolicy) {
        final List<TrackedQuery> k = this.k(TrackedQueryManager.h);
        final long e = e(cachePolicy, k.size());
        PruneForest pruneForest = new PruneForest();
        if (this.c.f()) {
            final LogWrapper c = this.c;
            final StringBuilder sb = new StringBuilder();
            sb.append("Pruning old queries.  Prunable: ");
            sb.append(k.size());
            sb.append(" Count to prune: ");
            sb.append(e);
            c.b(sb.toString(), new Object[0]);
        }
        Collections.sort((List<Object>)k, (Comparator<? super Object>)new Comparator<TrackedQuery>(this) {
            final TrackedQueryManager a;
            
            public int a(final TrackedQuery trackedQuery, final TrackedQuery trackedQuery2) {
                return Utilities.b(trackedQuery.c, trackedQuery2.c);
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.a((TrackedQuery)o, (TrackedQuery)o2);
            }
        });
        for (int n = 0; n < e; ++n) {
            final TrackedQuery trackedQuery = k.get(n);
            pruneForest = pruneForest.d(trackedQuery.b.e());
            this.q(trackedQuery.b);
        }
        for (int i = (int)e; i < k.size(); ++i) {
            pruneForest = pruneForest.c(((TrackedQuery)k.get(i)).b.e());
        }
        final List<TrackedQuery> j = this.k(TrackedQueryManager.i);
        if (this.c.f()) {
            final LogWrapper c2 = this.c;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Unprunable queries: ");
            sb2.append(j.size());
            c2.b(sb2.toString(), new Object[0]);
        }
        final Iterator iterator = j.iterator();
        while (iterator.hasNext()) {
            pruneForest = pruneForest.c(((TrackedQuery)iterator.next()).b.e());
        }
        return pruneForest;
    }
    
    public void q(QuerySpec o) {
        o = o(o);
        final TrackedQuery i = this.i(o);
        Utilities.g(i != null, "Query must exist to be removed.");
        this.b.r(i.a);
        final Map map = this.a.n(o.e());
        map.remove(o.d());
        if (map.isEmpty()) {
            this.a = this.a.t(o.e());
        }
    }
    
    public void t(final Path path) {
        this.a.y(path).m((ImmutableTree.TreeVisitor<Map<QueryParams, TrackedQuery>, Void>)new ImmutableTree.TreeVisitor<Map<QueryParams, TrackedQuery>, Void>(this) {
            final TrackedQueryManager a;
            
            @Override
            public /* bridge */ Object a(final Path path, final Object o, final Object o2) {
                return this.b(path, (Map<QueryParams, TrackedQuery>)o, (Void)o2);
            }
            
            public Void b(final Path path, final Map<QueryParams, TrackedQuery> map, final Void void1) {
                final Iterator<Map.Entry<QueryParams, TrackedQuery>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    final TrackedQuery trackedQuery = ((Map.Entry<K, TrackedQuery>)iterator.next()).getValue();
                    if (!trackedQuery.d) {
                        TrackedQueryManager.b(this.a, trackedQuery.b());
                    }
                }
                return null;
            }
        });
    }
    
    public void u(final QuerySpec querySpec) {
        this.v(querySpec, true);
    }
    
    public void w(final QuerySpec querySpec) {
        final TrackedQuery i = this.i(o(querySpec));
        if (i != null && !i.d) {
            this.s(i.b());
        }
    }
    
    public void x(final QuerySpec querySpec) {
        this.v(querySpec, false);
    }
}
