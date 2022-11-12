// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.connection.CompoundHash;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.ListenComplete;
import com.google.firebase.database.core.operation.OperationSource;
import java.util.Collections;
import com.google.firebase.database.snapshot.RangeMerge;
import com.google.firebase.database.collection.LLRBNode;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.connection.ListenHashProvider;
import java.util.concurrent.Callable;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import java.util.List;
import com.google.firebase.database.core.operation.Operation;
import java.util.HashSet;
import java.util.HashMap;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.core.persistence.PersistenceManager;
import java.util.Set;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.Map;
import com.google.firebase.database.core.utilities.ImmutableTree;

public class SyncTree
{
    private ImmutableTree<SyncPoint> a;
    private final WriteTree b;
    private final Map<Tag, QuerySpec> c;
    private final Map<QuerySpec, Tag> d;
    private final Set<QuerySpec> e;
    private final ListenProvider f;
    private final PersistenceManager g;
    private final LogWrapper h;
    private long i;
    
    public SyncTree(final Context context, final PersistenceManager g, final ListenProvider f) {
        this.i = 1L;
        this.a = ImmutableTree.b();
        this.b = new WriteTree();
        this.c = new HashMap<Tag, QuerySpec>();
        this.d = new HashMap<QuerySpec, Tag>();
        this.e = new HashSet<QuerySpec>();
        this.f = f;
        this.g = g;
        this.h = context.q("SyncTree");
    }
    
    private List<? extends Event> C(final QuerySpec querySpec, final Operation operation) {
        final Path e = querySpec.e();
        final SyncPoint syncPoint = this.a.n(e);
        Utilities.g(syncPoint != null, "Missing sync point for query tag that we're tracking");
        return syncPoint.b(operation, this.b.h(e), null);
    }
    
    private List<View> J(final ImmutableTree<SyncPoint> immutableTree) {
        final ArrayList list = new ArrayList();
        this.K(immutableTree, list);
        return list;
    }
    
    private void K(final ImmutableTree<SyncPoint> immutableTree, final List<View> list) {
        final SyncPoint syncPoint = immutableTree.getValue();
        if (syncPoint != null && syncPoint.h()) {
            list.add(syncPoint.e());
        }
        else {
            if (syncPoint != null) {
                list.addAll(syncPoint.f());
            }
            final Iterator<Map.Entry<ChildKey, ImmutableTree<SyncPoint>>> iterator = immutableTree.p().iterator();
            while (iterator.hasNext()) {
                this.K(((Map.Entry<K, ImmutableTree>)iterator.next()).getValue(), list);
            }
        }
    }
    
    private Tag L() {
        final long i = this.i;
        this.i = 1L + i;
        return new Tag(i);
    }
    
    private QuerySpec M(final QuerySpec querySpec) {
        QuerySpec a = querySpec;
        if (querySpec.g()) {
            a = querySpec;
            if (!querySpec.f()) {
                a = QuerySpec.a(querySpec.e());
            }
        }
        return a;
    }
    
    private QuerySpec N(final Tag tag) {
        return this.c.get(tag);
    }
    
    private List<Event> Q(@NotNull final QuerySpec querySpec, @Nullable final EventRegistration eventRegistration, @Nullable final DatabaseError databaseError) {
        return this.g.f((Callable<List<Event>>)new Callable<List<Event>>(this, querySpec, eventRegistration, databaseError) {
            final QuerySpec a;
            final EventRegistration b;
            final DatabaseError c;
            final SyncTree d;
            
            public List<Event> a() {
                final Path e = this.a.e();
                final SyncPoint syncPoint = SyncTree.o(this.d).n(e);
                ArrayList list2;
                final ArrayList list = list2 = new ArrayList();
                if (syncPoint != null) {
                    if (!this.a.f()) {
                        list2 = list;
                        if (!syncPoint.k(this.a)) {
                            return list2;
                        }
                    }
                    final Pair<List<QuerySpec>, List<Event>> j = syncPoint.j(this.a, this.b, this.c);
                    if (syncPoint.i()) {
                        final SyncTree d = this.d;
                        SyncTree.p(d, SyncTree.o(d).t(e));
                    }
                    final List list3 = j.a();
                    final List list4 = j.b();
                    final Iterator iterator = list3.iterator();
                    int n = 0;
                Label_0148:
                    while (true) {
                        n = 0;
                        while (iterator.hasNext()) {
                            final QuerySpec querySpec = (QuerySpec)iterator.next();
                            SyncTree.j(this.d).l(this.a);
                            if (n == 0 && !querySpec.g()) {
                                continue Label_0148;
                            }
                            n = 1;
                        }
                        break;
                    }
                    ImmutableTree o = SyncTree.o(this.d);
                    int n2;
                    if (o.getValue() != null && ((SyncPoint)o.getValue()).h()) {
                        n2 = 1;
                    }
                    else {
                        n2 = 0;
                    }
                    final Iterator<ChildKey> iterator2 = e.iterator();
                    while (true) {
                        ImmutableTree o2;
                        int n4;
                        do {
                            int n3 = n2;
                            if (iterator2.hasNext()) {
                                o2 = o.o(iterator2.next());
                                if (n2 == 0 && (o2.getValue() == null || !((SyncPoint)o2.getValue()).h())) {
                                    n4 = 0;
                                }
                                else {
                                    n4 = 1;
                                }
                                n3 = n4;
                                if (n4 == 0) {
                                    o = o2;
                                    n2 = n4;
                                    continue;
                                }
                            }
                            if (n != 0 && n3 == 0) {
                                final ImmutableTree y = SyncTree.o(this.d).y(e);
                                if (!y.isEmpty()) {
                                    for (final View view : SyncTree.e(this.d, y)) {
                                        final n n5 = this.d.new n(view);
                                        SyncTree.g(this.d).b(SyncTree.f(this.d, view.g()), SyncTree.n.e(n5), n5, n5);
                                    }
                                }
                            }
                            if (n3 == 0 && !list3.isEmpty() && this.c == null) {
                                if (n != 0) {
                                    SyncTree.g(this.d).a(SyncTree.f(this.d, this.a), null);
                                }
                                else {
                                    for (final QuerySpec querySpec2 : list3) {
                                        final Tag a = SyncTree.a(this.d, querySpec2);
                                        Utilities.f(a != null);
                                        SyncTree.g(this.d).a(SyncTree.f(this.d, querySpec2), a);
                                    }
                                }
                            }
                            SyncTree.h(this.d, list3);
                            list2 = (ArrayList)list4;
                            return list2;
                        } while (!o2.isEmpty());
                        int n3 = n4;
                        continue;
                    }
                }
                return list2;
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    private void R(final List<QuerySpec> list) {
        for (final QuerySpec querySpec : list) {
            if (!querySpec.g()) {
                final Tag t = this.T(querySpec);
                Utilities.f(t != null);
                this.d.remove(querySpec);
                this.c.remove(t);
            }
        }
    }
    
    private void S(final QuerySpec querySpec, final View view) {
        final Path e = querySpec.e();
        final Tag t = this.T(querySpec);
        final n n = new n(view);
        this.f.b(this.M(querySpec), t, n, n);
        final ImmutableTree<SyncPoint> y = this.a.y(e);
        if (t != null) {
            Utilities.g(y.getValue().h() ^ true, "If we're adding a query, it shouldn't be shadowed");
        }
        else {
            y.m((ImmutableTree.TreeVisitor<SyncPoint, Void>)new ImmutableTree.TreeVisitor<SyncPoint, Void>(this) {
                final SyncTree a;
                
                @Override
                public /* bridge */ Object a(final Path path, final Object o, final Object o2) {
                    return this.b(path, (SyncPoint)o, (Void)o2);
                }
                
                public Void b(final Path path, final SyncPoint syncPoint, final Void void1) {
                    if (!path.isEmpty() && syncPoint.h()) {
                        final QuerySpec g = syncPoint.e().g();
                        SyncTree.g(this.a).a(SyncTree.f(this.a, g), SyncTree.a(this.a, g));
                    }
                    else {
                        final Iterator<View> iterator = syncPoint.f().iterator();
                        while (iterator.hasNext()) {
                            final QuerySpec g2 = iterator.next().g();
                            SyncTree.g(this.a).a(SyncTree.f(this.a, g2), SyncTree.a(this.a, g2));
                        }
                    }
                    return null;
                }
            });
        }
    }
    
    private Tag T(final QuerySpec querySpec) {
        return this.d.get(querySpec);
    }
    
    static Tag a(final SyncTree syncTree, final QuerySpec querySpec) {
        return syncTree.T(querySpec);
    }
    
    static LogWrapper b(final SyncTree syncTree) {
        return syncTree.h;
    }
    
    static Map c(final SyncTree syncTree) {
        return syncTree.c;
    }
    
    static void d(final SyncTree syncTree, final QuerySpec querySpec, final View view) {
        syncTree.S(querySpec, view);
    }
    
    static List e(final SyncTree syncTree, final ImmutableTree immutableTree) {
        return syncTree.J(immutableTree);
    }
    
    static QuerySpec f(final SyncTree syncTree, final QuerySpec querySpec) {
        return syncTree.M(querySpec);
    }
    
    static ListenProvider g(final SyncTree syncTree) {
        return syncTree.f;
    }
    
    static void h(final SyncTree syncTree, final List list) {
        syncTree.R(list);
    }
    
    static List i(final SyncTree syncTree, final Operation operation, final ImmutableTree immutableTree, final Node node, final WriteTreeRef writeTreeRef) {
        return syncTree.v(operation, immutableTree, node, writeTreeRef);
    }
    
    static PersistenceManager j(final SyncTree syncTree) {
        return syncTree.g;
    }
    
    static WriteTree k(final SyncTree syncTree) {
        return syncTree.b;
    }
    
    static List l(final SyncTree syncTree, final Operation operation) {
        return syncTree.x(operation);
    }
    
    static QuerySpec m(final SyncTree syncTree, final Tag tag) {
        return syncTree.N(tag);
    }
    
    static List n(final SyncTree syncTree, final QuerySpec querySpec, final Operation operation) {
        return syncTree.C(querySpec, operation);
    }
    
    static ImmutableTree o(final SyncTree syncTree) {
        return syncTree.a;
    }
    
    static ImmutableTree p(final SyncTree syncTree, final ImmutableTree a) {
        return syncTree.a = a;
    }
    
    static Map q(final SyncTree syncTree) {
        return syncTree.d;
    }
    
    static Tag r(final SyncTree syncTree) {
        return syncTree.L();
    }
    
    private List<Event> v(final Operation operation, final ImmutableTree<SyncPoint> immutableTree, final Node node, final WriteTreeRef writeTreeRef) {
        final SyncPoint syncPoint = immutableTree.getValue();
        Node d = node;
        if (node == null) {
            d = node;
            if (syncPoint != null) {
                d = syncPoint.d(Path.s());
            }
        }
        final ArrayList list = new ArrayList();
        immutableTree.p().m(new LLRBNode.NodeVisitor<ChildKey, ImmutableTree<SyncPoint>>(this, d, writeTreeRef, operation, list) {
            final Node a;
            final WriteTreeRef b;
            final Operation c;
            final List d;
            final SyncTree e;
            
            @Override
            public /* bridge */ void a(final Object o, final Object o2) {
                this.b((ChildKey)o, (ImmutableTree<SyncPoint>)o2);
            }
            
            public void b(final ChildKey childKey, final ImmutableTree<SyncPoint> immutableTree) {
                final Node a = this.a;
                Node c0;
                if (a != null) {
                    c0 = a.c0(childKey);
                }
                else {
                    c0 = null;
                }
                final WriteTreeRef h = this.b.h(childKey);
                final Operation d = this.c.d(childKey);
                if (d != null) {
                    this.d.addAll(SyncTree.i(this.e, d, immutableTree, c0, h));
                }
            }
        });
        if (syncPoint != null) {
            list.addAll(syncPoint.b(operation, writeTreeRef, d));
        }
        return list;
    }
    
    private List<Event> w(final Operation operation, final ImmutableTree<SyncPoint> immutableTree, final Node node, final WriteTreeRef writeTreeRef) {
        if (operation.a().isEmpty()) {
            return this.v(operation, immutableTree, node, writeTreeRef);
        }
        final SyncPoint syncPoint = immutableTree.getValue();
        Node d;
        if ((d = node) == null) {
            d = node;
            if (syncPoint != null) {
                d = syncPoint.d(Path.s());
            }
        }
        final ArrayList list = new ArrayList();
        final ChildKey t = operation.a().t();
        final Operation d2 = operation.d(t);
        final ImmutableTree immutableTree2 = immutableTree.p().b(t);
        if (immutableTree2 != null && d2 != null) {
            Node c0;
            if (d != null) {
                c0 = d.c0(t);
            }
            else {
                c0 = null;
            }
            list.addAll(this.w(d2, immutableTree2, c0, writeTreeRef.h(t)));
        }
        if (syncPoint != null) {
            list.addAll(syncPoint.b(operation, writeTreeRef, d));
        }
        return list;
    }
    
    private List<Event> x(final Operation operation) {
        return this.w(operation, this.a, null, this.b.h(Path.s()));
    }
    
    public List<? extends Event> A(final Path path, final List<RangeMerge> list) {
        final SyncPoint syncPoint = this.a.n(path);
        if (syncPoint == null) {
            return Collections.emptyList();
        }
        final View e = syncPoint.e();
        if (e != null) {
            final Node h = e.h();
            final Iterator<RangeMerge> iterator = list.iterator();
            Node a = h;
            while (iterator.hasNext()) {
                a = iterator.next().a(a);
            }
            return this.z(path, a);
        }
        return Collections.emptyList();
    }
    
    public List<? extends Event> B(final Tag tag) {
        return this.g.f((Callable<List<? extends Event>>)new Callable<List<? extends Event>>(this, tag) {
            final Tag a;
            final SyncTree b;
            
            public List<? extends Event> a() {
                final QuerySpec m = SyncTree.m(this.b, this.a);
                if (m != null) {
                    SyncTree.j(this.b).m(m);
                    return SyncTree.n(this.b, m, new ListenComplete(OperationSource.a(m.d()), Path.s()));
                }
                return Collections.emptyList();
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public List<? extends Event> D(final Path path, final Map<Path, Node> map, final Tag tag) {
        return this.g.f((Callable<List<? extends Event>>)new Callable<List<? extends Event>>(this, tag, path, map) {
            final Tag a;
            final Path b;
            final Map c;
            final SyncTree d;
            
            public List<? extends Event> a() {
                final QuerySpec m = SyncTree.m(this.d, this.a);
                if (m != null) {
                    final Path x = Path.x(m.e(), this.b);
                    final CompoundWrite o = CompoundWrite.o(this.c);
                    SyncTree.j(this.d).o(this.b, o);
                    return SyncTree.n(this.d, m, new Merge(OperationSource.a(m.d()), x, o));
                }
                return Collections.emptyList();
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public List<? extends Event> E(final Path path, final Node node, final Tag tag) {
        return this.g.f((Callable<List<? extends Event>>)new Callable<List<? extends Event>>(this, tag, path, node) {
            final Tag a;
            final Path b;
            final Node c;
            final SyncTree d;
            
            public List<? extends Event> a() {
                final QuerySpec m = SyncTree.m(this.d, this.a);
                if (m != null) {
                    final Path x = Path.x(m.e(), this.b);
                    QuerySpec a;
                    if (x.isEmpty()) {
                        a = m;
                    }
                    else {
                        a = QuerySpec.a(this.b);
                    }
                    SyncTree.j(this.d).g(a, this.c);
                    return SyncTree.n(this.d, m, new Overwrite(OperationSource.a(m.d()), x, this.c));
                }
                return Collections.emptyList();
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public List<? extends Event> F(final Path path, final List<RangeMerge> list, final Tag tag) {
        final QuerySpec n = this.N(tag);
        if (n != null) {
            Utilities.f(path.equals(n.e()));
            final SyncPoint syncPoint = this.a.n(n.e());
            final boolean b = true;
            Utilities.g(syncPoint != null, "Missing sync point for query tag that we're tracking");
            final View l = syncPoint.l(n);
            Utilities.g(l != null && b, "Missing view for query tag that we're tracking");
            final Node h = l.h();
            final Iterator<RangeMerge> iterator = list.iterator();
            Node a = h;
            while (iterator.hasNext()) {
                a = iterator.next().a(a);
            }
            return this.E(path, a, tag);
        }
        return Collections.emptyList();
    }
    
    public List<? extends Event> G(final Path path, final CompoundWrite compoundWrite, final CompoundWrite compoundWrite2, final long n, final boolean b) {
        return this.g.f((Callable<List<? extends Event>>)new Callable<List<? extends Event>>(this, b, path, compoundWrite, n, compoundWrite2) {
            final boolean a;
            final Path b;
            final CompoundWrite c;
            final long d;
            final CompoundWrite e;
            final SyncTree f;
            
            public List<? extends Event> a() throws Exception {
                if (this.a) {
                    SyncTree.j(this.f).a(this.b, this.c, this.d);
                }
                SyncTree.k(this.f).a(this.b, this.e, this.d);
                return SyncTree.l(this.f, new Merge(OperationSource.d, this.b, this.e));
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public List<? extends Event> H(final Path path, final Node node, final Node node2, final long n, final boolean b, final boolean b2) {
        Utilities.g(b || !b2, "We shouldn't be persisting non-visible writes.");
        return this.g.f((Callable<List<? extends Event>>)new Callable<List<? extends Event>>(this, b2, path, node, n, node2, b) {
            final boolean a;
            final Path b;
            final Node c;
            final long d;
            final Node e;
            final boolean f;
            final SyncTree g;
            
            public List<? extends Event> a() {
                if (this.a) {
                    SyncTree.j(this.g).d(this.b, this.c, this.d);
                }
                SyncTree.k(this.g).b(this.b, this.e, this.d, this.f);
                if (!this.f) {
                    return Collections.emptyList();
                }
                return SyncTree.l(this.g, new Overwrite(OperationSource.d, this.b, this.e));
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public Node I(final Path path, final List<Long> list) {
        ImmutableTree<SyncPoint> a = this.a;
        final SyncPoint syncPoint = a.getValue();
        Path path2 = Path.s();
        Node node = null;
        Path path3 = path;
        Node d;
        do {
            final ChildKey t = path3.t();
            final Path y = path3.y();
            path2 = path2.n(t);
            final Path x = Path.x(path2, path);
            Iterable<Map.Entry<Path, T>> iterable;
            if (t != null) {
                iterable = (Iterable<Map.Entry<Path, T>>)a.o(t);
            }
            else {
                iterable = (Iterable<Map.Entry<Path, T>>)ImmutableTree.b();
            }
            final SyncPoint syncPoint2 = ((ImmutableTree<SyncPoint>)iterable).getValue();
            d = node;
            if (syncPoint2 != null) {
                d = syncPoint2.d(x);
            }
            if (y.isEmpty()) {
                break;
            }
            a = (ImmutableTree<SyncPoint>)iterable;
            node = d;
            path3 = y;
        } while (d == null);
        return this.b.d(path, d, list, true);
    }
    
    public List<Event> O(@NotNull final QuerySpec querySpec, @NotNull final DatabaseError databaseError) {
        return this.Q(querySpec, null, databaseError);
    }
    
    public List<Event> P(@NotNull final EventRegistration eventRegistration) {
        return this.Q(eventRegistration.e(), eventRegistration, null);
    }
    
    public List<? extends Event> s(final long n, final boolean b, final boolean b2, final Clock clock) {
        return this.g.f((Callable<List<? extends Event>>)new Callable<List<? extends Event>>(this, b2, n, b, clock) {
            final boolean a;
            final long b;
            final boolean c;
            final Clock d;
            final SyncTree e;
            
            public List<? extends Event> a() {
                if (this.a) {
                    SyncTree.j(this.e).c(this.b);
                }
                final UserWriteRecord i = SyncTree.k(this.e).i(this.b);
                final boolean l = SyncTree.k(this.e).l(this.b);
                if (i.f() && !this.c) {
                    final Map<String, Object> c = ServerValues.c(this.d);
                    if (i.e()) {
                        SyncTree.j(this.e).n(i.c(), ServerValues.g(i.b(), this.e, i.c(), c));
                    }
                    else {
                        SyncTree.j(this.e).h(i.c(), ServerValues.f(i.a(), this.e, i.c(), c));
                    }
                }
                if (!l) {
                    return Collections.emptyList();
                }
                Iterable<Map.Entry<Path, T>> iterable = (Iterable<Map.Entry<Path, T>>)ImmutableTree.b();
                Object w;
                if (i.e()) {
                    w = ((ImmutableTree<Boolean>)iterable).w(Path.s(), Boolean.TRUE);
                }
                else {
                    final Iterator<Map.Entry<Path, Node>> iterator = i.a().iterator();
                    while (true) {
                        w = iterable;
                        if (!iterator.hasNext()) {
                            break;
                        }
                        iterable = (Iterable<Map.Entry<Path, T>>)((ImmutableTree<Boolean>)iterable).w(iterator.next().getKey(), Boolean.TRUE);
                    }
                }
                return SyncTree.l(this.e, new AckUserWrite(i.c(), (ImmutableTree<Boolean>)w, this.c));
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public List<? extends Event> t(@NotNull final EventRegistration eventRegistration) {
        return this.g.f((Callable<List<? extends Event>>)new Callable<List<? extends Event>>(this, eventRegistration) {
            final EventRegistration a;
            final SyncTree b;
            
            public List<? extends Event> a() {
                final QuerySpec e = this.a.e();
                final Path e2 = e.e();
                ImmutableTree immutableTree = SyncTree.o(this.b);
                Node node = null;
                Path y = e2;
                int n = 0;
                while (!immutableTree.isEmpty()) {
                    final SyncPoint syncPoint = immutableTree.getValue();
                    Node node2 = node;
                    int n2 = n;
                    if (syncPoint != null) {
                        if (node == null) {
                            node = syncPoint.d(y);
                        }
                        if (n == 0 && !syncPoint.h()) {
                            n2 = 0;
                            node2 = node;
                        }
                        else {
                            n2 = 1;
                            node2 = node;
                        }
                    }
                    ChildKey childKey;
                    if (y.isEmpty()) {
                        childKey = ChildKey.f("");
                    }
                    else {
                        childKey = y.t();
                    }
                    immutableTree = immutableTree.o(childKey);
                    y = y.y();
                    node = node2;
                    n = n2;
                }
                SyncPoint syncPoint2 = SyncTree.o(this.b).n(e2);
                int n3;
                if (syncPoint2 == null) {
                    syncPoint2 = new SyncPoint(SyncTree.j(this.b));
                    final SyncTree b = this.b;
                    SyncTree.p(b, SyncTree.o(b).w(e2, syncPoint2));
                    n3 = n;
                }
                else {
                    if (n == 0 && !syncPoint2.h()) {
                        n3 = 0;
                    }
                    else {
                        n3 = 1;
                    }
                    if (node == null) {
                        node = syncPoint2.d(Path.s());
                    }
                }
                SyncTree.j(this.b).k(e);
                CacheNode cacheNode;
                if (node != null) {
                    cacheNode = new CacheNode(IndexedNode.e(node, e.c()), true, false);
                }
                else {
                    final CacheNode i = SyncTree.j(this.b).i(e);
                    if (i.f()) {
                        cacheNode = i;
                    }
                    else {
                        Node node3 = EmptyNode.p();
                        for (final Map.Entry<K, ImmutableTree> entry : SyncTree.o(this.b).y(e2).p()) {
                            final SyncPoint syncPoint3 = entry.getValue().getValue();
                            if (syncPoint3 != null) {
                                final Node d = syncPoint3.d(Path.s());
                                if (d == null) {
                                    continue;
                                }
                                node3 = node3.r0((ChildKey)entry.getKey(), d);
                            }
                        }
                        for (final NamedNode namedNode : i.b()) {
                            if (!node3.m0(namedNode.c())) {
                                node3 = node3.r0(namedNode.c(), namedNode.d());
                            }
                        }
                        cacheNode = new CacheNode(IndexedNode.e(node3, e.c()), false, false);
                    }
                }
                final boolean k = syncPoint2.k(e);
                if (!k && !e.g()) {
                    Utilities.g(SyncTree.q(this.b).containsKey(e) ^ true, "View does not exist but we have a tag");
                    final Tag r = SyncTree.r(this.b);
                    SyncTree.q(this.b).put(e, r);
                    SyncTree.c(this.b).put(r, e);
                }
                final List<DataEvent> a = syncPoint2.a(this.a, SyncTree.k(this.b).h(e2), cacheNode);
                if (!k && n3 == 0) {
                    SyncTree.d(this.b, e, syncPoint2.l(e));
                }
                return a;
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public List<? extends Event> u(final Path path) {
        return this.g.f((Callable<List<? extends Event>>)new Callable<List<? extends Event>>(this, path) {
            final Path a;
            final SyncTree b;
            
            public List<? extends Event> a() {
                SyncTree.j(this.b).m(QuerySpec.a(this.a));
                return SyncTree.l(this.b, new ListenComplete(OperationSource.e, this.a));
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public List<? extends Event> y(final Path path, final Map<Path, Node> map) {
        return this.g.f((Callable<List<? extends Event>>)new Callable<List<? extends Event>>(this, map, path) {
            final Map a;
            final Path b;
            final SyncTree c;
            
            public List<? extends Event> a() {
                final CompoundWrite o = CompoundWrite.o(this.a);
                SyncTree.j(this.c).o(this.b, o);
                return SyncTree.l(this.c, new Merge(OperationSource.e, this.b, o));
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public List<? extends Event> z(final Path path, final Node node) {
        return this.g.f((Callable<List<? extends Event>>)new Callable<List<? extends Event>>(this, path, node) {
            final Path a;
            final Node b;
            final SyncTree c;
            
            public List<? extends Event> a() {
                SyncTree.j(this.c).g(QuerySpec.a(this.a), this.b);
                return SyncTree.l(this.c, new Overwrite(OperationSource.e, this.a, this.b));
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public interface CompletionListener
    {
        List<? extends Event> b(final DatabaseError p0);
    }
    
    public interface ListenProvider
    {
        void a(final QuerySpec p0, final Tag p1);
        
        void b(final QuerySpec p0, final Tag p1, final ListenHashProvider p2, final CompletionListener p3);
    }
    
    private class n implements ListenHashProvider, CompletionListener
    {
        private final View a;
        private final Tag b;
        final SyncTree c;
        
        public n(final SyncTree c, final View a) {
            this.c = c;
            this.a = a;
            this.b = SyncTree.a(c, a.g());
        }
        
        static Tag e(final n n) {
            return n.b;
        }
        
        @Override
        public String a() {
            return this.a.h().getHash();
        }
        
        @Override
        public List<? extends Event> b(final DatabaseError databaseError) {
            if (databaseError != null) {
                final LogWrapper b = SyncTree.b(this.c);
                final StringBuilder sb = new StringBuilder();
                sb.append("Listen at ");
                sb.append(this.a.g().e());
                sb.append(" failed: ");
                sb.append(databaseError.toString());
                b.i(sb.toString());
                return this.c.O(this.a.g(), databaseError);
            }
            final QuerySpec g = this.a.g();
            final Tag b2 = this.b;
            if (b2 != null) {
                return this.c.B(b2);
            }
            return this.c.u(g.e());
        }
        
        @Override
        public CompoundHash c() {
            final com.google.firebase.database.snapshot.CompoundHash b = com.google.firebase.database.snapshot.CompoundHash.b(this.a.h());
            final List<Path> e = b.e();
            final ArrayList list = new ArrayList(e.size());
            final Iterator iterator = e.iterator();
            while (iterator.hasNext()) {
                list.add((Object)((Path)iterator.next()).k());
            }
            return new CompoundHash((List<List<String>>)list, b.d());
        }
        
        @Override
        public boolean d() {
            return NodeSizeEstimator.b(this.a.h()) > 1024L;
        }
    }
}
