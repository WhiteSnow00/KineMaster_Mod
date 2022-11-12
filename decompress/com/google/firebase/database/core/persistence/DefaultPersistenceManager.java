// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.persistence;

import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.core.view.CacheNode;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Set;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.core.UserWriteRecord;
import java.util.List;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.Context;
import com.google.firebase.database.logging.LogWrapper;

public class DefaultPersistenceManager implements PersistenceManager
{
    private final PersistenceStorageEngine a;
    private final TrackedQueryManager b;
    private final LogWrapper c;
    private final CachePolicy d;
    private long e;
    
    public DefaultPersistenceManager(final Context context, final PersistenceStorageEngine persistenceStorageEngine, final CachePolicy cachePolicy) {
        this(context, persistenceStorageEngine, cachePolicy, new DefaultClock());
    }
    
    public DefaultPersistenceManager(final Context context, final PersistenceStorageEngine a, final CachePolicy d, final Clock clock) {
        this.e = 0L;
        this.a = a;
        final LogWrapper q = context.q("Persistence");
        this.c = q;
        this.b = new TrackedQueryManager(a, q, clock);
        this.d = d;
    }
    
    private void p() {
        final long e = this.e + 1L;
        this.e = e;
        if (this.d.d(e)) {
            if (this.c.f()) {
                this.c.b("Reached prune check threshold.", new Object[0]);
            }
            this.e = 0L;
            final int n = 1;
            final long x = this.a.x();
            int n2 = n;
            long n3 = x;
            if (this.c.f()) {
                final LogWrapper c = this.c;
                final StringBuilder sb = new StringBuilder();
                sb.append("Cache size: ");
                sb.append(x);
                c.b(sb.toString(), new Object[0]);
                n3 = x;
                n2 = n;
            }
            while (n2 != 0 && this.d.a(n3, this.b.f())) {
                final PruneForest p = this.b.p(this.d);
                int n4;
                if (p.e()) {
                    this.a.y(Path.s(), p);
                    n4 = n2;
                }
                else {
                    n4 = 0;
                }
                final long x2 = this.a.x();
                n2 = n4;
                n3 = x2;
                if (this.c.f()) {
                    final LogWrapper c2 = this.c;
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Cache size after prune: ");
                    sb2.append(x2);
                    c2.b(sb2.toString(), new Object[0]);
                    n2 = n4;
                    n3 = x2;
                }
            }
        }
    }
    
    @Override
    public void a(final Path path, final CompoundWrite compoundWrite, final long n) {
        this.a.a(path, compoundWrite, n);
    }
    
    @Override
    public List<UserWriteRecord> b() {
        return this.a.b();
    }
    
    @Override
    public void c(final long n) {
        this.a.c(n);
    }
    
    @Override
    public void d(final Path path, final Node node, final long n) {
        this.a.d(path, node, n);
    }
    
    @Override
    public void e(final QuerySpec querySpec, final Set<ChildKey> set) {
        final boolean g = querySpec.g();
        boolean b = true;
        Utilities.g(g ^ true, "We should only track keys for filtered queries.");
        final TrackedQuery i = this.b.i(querySpec);
        if (i == null || !i.e) {
            b = false;
        }
        Utilities.g(b, "We only expect tracked keys for currently-active queries.");
        this.a.B(i.a, set);
    }
    
    @Override
    public <T> T f(final Callable<T> callable) {
        this.a.m();
        try {
            final T call = callable.call();
            this.a.p();
            this.a.q();
            return call;
        }
        finally {
            try {
                final Throwable t;
                this.c.c("Caught Throwable.", t);
                throw new RuntimeException(t);
            }
            finally {
                this.a.q();
            }
        }
    }
    
    @Override
    public void g(final QuerySpec querySpec, final Node node) {
        if (querySpec.g()) {
            this.a.C(querySpec.e(), node);
        }
        else {
            this.a.v(querySpec.e(), node);
        }
        this.m(querySpec);
        this.p();
    }
    
    @Override
    public void h(final Path path, final CompoundWrite compoundWrite) {
        for (final Map.Entry entry : compoundWrite) {
            this.n(path.m((Path)entry.getKey()), (Node)entry.getValue());
        }
    }
    
    @Override
    public CacheNode i(final QuerySpec querySpec) {
        Set<ChildKey> set;
        boolean b;
        if (this.b.n(querySpec)) {
            final TrackedQuery i = this.b.i(querySpec);
            if (!querySpec.g() && i != null && i.d) {
                set = this.a.z(i.a);
            }
            else {
                set = null;
            }
            b = true;
        }
        else {
            set = this.b.j(querySpec.e());
            b = false;
        }
        final Node a = this.a.A(querySpec.e());
        if (set != null) {
            final EmptyNode p = EmptyNode.p();
            final Iterator<ChildKey> iterator = set.iterator();
            Node r0 = p;
            while (iterator.hasNext()) {
                final ChildKey childKey = iterator.next();
                r0 = r0.r0(childKey, a.c0(childKey));
            }
            return new CacheNode(IndexedNode.e(r0, querySpec.c()), b, true);
        }
        return new CacheNode(IndexedNode.e(a, querySpec.c()), b, false);
    }
    
    @Override
    public void j(final QuerySpec querySpec, final Set<ChildKey> set, final Set<ChildKey> set2) {
        final boolean g = querySpec.g();
        boolean b = true;
        Utilities.g(g ^ true, "We should only track keys for filtered queries.");
        final TrackedQuery i = this.b.i(querySpec);
        if (i == null || !i.e) {
            b = false;
        }
        Utilities.g(b, "We only expect tracked keys for currently-active queries.");
        this.a.E(i.a, set, set2);
    }
    
    @Override
    public void k(final QuerySpec querySpec) {
        this.b.u(querySpec);
    }
    
    @Override
    public void l(final QuerySpec querySpec) {
        this.b.x(querySpec);
    }
    
    @Override
    public void m(final QuerySpec querySpec) {
        if (querySpec.g()) {
            this.b.t(querySpec.e());
        }
        else {
            this.b.w(querySpec);
        }
    }
    
    @Override
    public void n(final Path path, final Node node) {
        if (!this.b.l(path)) {
            this.a.C(path, node);
            this.b.g(path);
        }
    }
    
    @Override
    public void o(final Path path, final CompoundWrite compoundWrite) {
        this.a.s(path, compoundWrite);
        this.p();
    }
}
