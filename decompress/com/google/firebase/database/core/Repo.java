// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.connection.RangeMerge;
import java.util.HashMap;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.MutableData;
import java.util.Iterator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Map;
import com.google.firebase.database.connection.RequestResultCallback;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import java.util.concurrent.ExecutorService;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.connection.HostInfo;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.core.view.EventRaiser;
import java.util.List;
import com.google.firebase.database.core.utilities.Tree;
import com.google.firebase.database.core.utilities.OffsetClock;
import com.google.firebase.database.connection.PersistentConnection;

public class Repo implements Delegate
{
    private final RepoInfo a;
    private final OffsetClock b;
    private PersistentConnection c;
    private SnapshotHolder d;
    private SparseSnapshotTree e;
    private Tree<List<s>> f;
    private boolean g;
    private final EventRaiser h;
    private final Context i;
    private final LogWrapper j;
    private final LogWrapper k;
    private final LogWrapper l;
    public long m;
    private long n;
    private SyncTree o;
    private SyncTree p;
    private FirebaseDatabase q;
    private boolean r;
    private long s;
    
    Repo(final RepoInfo a, final Context i, final FirebaseDatabase q) {
        this.b = new OffsetClock(new DefaultClock(), 0L);
        this.g = false;
        this.m = 0L;
        this.n = 1L;
        this.r = false;
        this.s = 0L;
        this.a = a;
        this.i = i;
        this.q = q;
        this.j = i.q("RepoOperation");
        this.k = i.q("Transaction");
        this.l = i.q("DataOperation");
        this.h = new EventRaiser(i);
        this.U(new Runnable(this) {
            final Repo a;
            
            @Override
            public void run() {
                Repo.i(this.a);
            }
        });
    }
    
    static SyncTree A(final Repo repo) {
        return repo.p;
    }
    
    private void B(final long n, final Path path, final DatabaseError databaseError) {
        if (databaseError == null || databaseError.f() != -25) {
            final List<? extends Event> s = this.p.s(n, databaseError == null ^ true, true, this.b);
            if (s.size() > 0) {
                this.R(path);
            }
            this.N(s);
        }
    }
    
    private void D(final List<s> list, final Tree<List<s>> tree) {
        final List list2 = tree.g();
        if (list2 != null) {
            list.addAll(list2);
        }
        tree.c((Tree.TreeVisitor<List>)new Tree.TreeVisitor<List<s>>(this, list) {
            final List a;
            final Repo b;
            
            @Override
            public void a(final Tree<List<s>> tree) {
                Repo.t(this.b, this.a, tree);
            }
        });
    }
    
    private List<s> E(final Tree<List<s>> tree) {
        final ArrayList list = new ArrayList();
        this.D(list, tree);
        Collections.sort((List<Comparable>)list);
        return list;
    }
    
    private void G() {
        final RepoInfo a = this.a;
        this.c = this.i.E(new HostInfo(a.a, a.c, a.b), this);
        this.i.m().b(((DefaultRunLoop)this.i.v()).c(), (TokenProvider.TokenChangeListener)new TokenProvider.TokenChangeListener(this) {
            final Repo a;
            
            @Override
            public void a(final String s) {
                Repo.j(this.a).b("Auth token changed, triggering auth token refresh", new Object[0]);
                Repo.m(this.a).l(s);
            }
        });
        this.i.l().b(((DefaultRunLoop)this.i.v()).c(), (TokenProvider.TokenChangeListener)new TokenProvider.TokenChangeListener(this) {
            final Repo a;
            
            @Override
            public void a(final String s) {
                Repo.j(this.a).b("App check token changed, triggering app check token refresh", new Object[0]);
                Repo.m(this.a).m(s);
            }
        });
        this.c.initialize();
        final PersistenceManager t = this.i.t(this.a.a);
        this.d = new SnapshotHolder();
        this.e = new SparseSnapshotTree();
        this.f = new Tree<List<s>>();
        this.o = new SyncTree(this.i, new NoopPersistenceManager(), (SyncTree.ListenProvider)new SyncTree.ListenProvider(this) {
            final Repo a;
            
            @Override
            public void a(final QuerySpec querySpec, final Tag tag) {
            }
            
            @Override
            public void b(final QuerySpec querySpec, final Tag tag, final ListenHashProvider listenHashProvider, final CompletionListener completionListener) {
                this.a.U(new Runnable(this, querySpec, completionListener) {
                    final QuerySpec a;
                    final CompletionListener b;
                    final Repo$o c;
                    
                    @Override
                    public void run() {
                        final Node a = Repo.s(this.c.a).a(this.a.e());
                        if (!a.isEmpty()) {
                            Repo.w(this.c.a, Repo.v(this.c.a).z(this.a.e(), a));
                            this.b.b(null);
                        }
                    }
                });
            }
        });
        this.p = new SyncTree(this.i, t, (SyncTree.ListenProvider)new SyncTree.ListenProvider(this) {
            final Repo a;
            
            @Override
            public void a(final QuerySpec querySpec, final Tag tag) {
                Repo.m(this.a).f(querySpec.e().k(), querySpec.d().i());
            }
            
            @Override
            public void b(final QuerySpec querySpec, final Tag tag, final ListenHashProvider listenHashProvider, final CompletionListener completionListener) {
                final PersistentConnection m = Repo.m(this.a);
                final List<String> k = querySpec.e().k();
                final Map<String, Object> i = querySpec.d().i();
                Long value;
                if (tag != null) {
                    value = tag.a();
                }
                else {
                    value = null;
                }
                m.d(k, i, listenHashProvider, value, new RequestResultCallback(this, completionListener) {
                    final CompletionListener a;
                    final Repo$p b;
                    
                    @Override
                    public void a(final String s, final String s2) {
                        Repo.w(this.b.a, this.a.b(Repo.x(s, s2)));
                    }
                });
            }
        });
        this.S(t);
        final ChildKey c = Constants.c;
        final Boolean false = Boolean.FALSE;
        this.Z(c, false);
        this.Z(Constants.d, false);
    }
    
    private static DatabaseError H(final String s, final String s2) {
        if (s != null) {
            return DatabaseError.d(s, s2);
        }
        return null;
    }
    
    private Tree<List<s>> I(Path y) {
        Tree<List<s>> tree;
        for (tree = this.f; !y.isEmpty() && tree.g() == null; tree = tree.k(new Path(new ChildKey[] { y.t() })), y = y.y()) {}
        return tree;
    }
    
    private Node J(final Path path, final List<Long> list) {
        Node node;
        if ((node = this.p.I(path, list)) == null) {
            node = EmptyNode.p();
        }
        return node;
    }
    
    private long K() {
        final long n = this.n;
        this.n = 1L + n;
        return n;
    }
    
    private void N(final List<? extends Event> list) {
        if (!list.isEmpty()) {
            this.h.b(list);
        }
    }
    
    private void O(final Tree<List<s>> tree) {
        final List list = tree.g();
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                if (Repo.s.i((s)list.get(i)) == TransactionStatus.COMPLETED) {
                    list.remove(i);
                }
                else {
                    ++i;
                }
            }
            if (list.size() > 0) {
                tree.j(list);
            }
            else {
                tree.j(null);
            }
        }
        tree.c((Tree.TreeVisitor<List>)new Tree.TreeVisitor<List<s>>(this) {
            final Repo a;
            
            @Override
            public void a(final Tree<List<s>> tree) {
                Repo.q(this.a, tree);
            }
        });
    }
    
    private void Q(final List<s> list, final Path path) {
        if (list.isEmpty()) {
            return;
        }
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list3.add(Repo.s.l((s)iterator.next()));
        }
        final Iterator iterator2 = list.iterator();
        int i;
        while (true) {
            final boolean hasNext = iterator2.hasNext();
            i = 0;
            final boolean b = false;
            if (!hasNext) {
                break;
            }
            final s s = (s)iterator2.next();
            final Path x = Path.x(path, Repo.s.p(s));
            final ArrayList list4 = new ArrayList();
            Utilities.f(x != null);
            final TransactionStatus j = Repo.s.i(s);
            final TransactionStatus needs_ABORT = TransactionStatus.NEEDS_ABORT;
            final DatabaseError databaseError = null;
            DatabaseError databaseError3 = null;
            int n = 0;
            Label_0529: {
                if (j == needs_ABORT) {
                    final DatabaseError databaseError2 = databaseError3 = Repo.s.s(s);
                    if (databaseError2.f() != -25) {
                        list4.addAll(this.p.s(Repo.s.l(s), true, false, this.b));
                        databaseError3 = databaseError2;
                    }
                }
                else {
                    n = (b ? 1 : 0);
                    databaseError3 = databaseError;
                    if (Repo.s.i(s) != TransactionStatus.RUN) {
                        break Label_0529;
                    }
                    if (Repo.s.n(s) >= 25) {
                        databaseError3 = DatabaseError.c("maxretries");
                        list4.addAll(this.p.s(Repo.s.l(s), true, false, this.b));
                    }
                    else {
                        final Node k = this.J(Repo.s.p(s), list3);
                        Repo.s.c(s, k);
                        final MutableData b2 = InternalHelpers.b(k);
                        Transaction.Result a = null;
                        try {
                            Repo.s.q(s).a(b2);
                        }
                        finally {
                            final Throwable t;
                            this.j.c("Caught Throwable.", t);
                            databaseError3 = DatabaseError.b(t);
                            a = Transaction.a();
                        }
                        if (a.b()) {
                            final Long value = Repo.s.l(s);
                            final Map<String, Object> c = ServerValues.c(this.b);
                            final Node a2 = a.a();
                            final Node l = ServerValues.i(a2, k, c);
                            Repo.s.f(s, a2);
                            Repo.s.h(s, l);
                            Repo.s.m(s, this.K());
                            list3.remove(value);
                            list4.addAll(this.p.H(Repo.s.p(s), a2, l, Repo.s.l(s), Repo.s.u(s), false));
                            list4.addAll(this.p.s(value, true, false, this.b));
                            n = (b ? 1 : 0);
                            databaseError3 = databaseError;
                            break Label_0529;
                        }
                        list4.addAll(this.p.s(Repo.s.l(s), true, false, this.b));
                        n = 1;
                        break Label_0529;
                    }
                }
                n = 1;
            }
            this.N(list4);
            if (n == 0) {
                continue;
            }
            Repo.s.k(s, TransactionStatus.COMPLETED);
            final DataSnapshot a3 = InternalHelpers.a(InternalHelpers.c(this, Repo.s.p(s)), IndexedNode.b(Repo.s.a(s)));
            this.U(new Runnable(this, s) {
                final s a;
                final Repo b;
                
                @Override
                public void run() {
                    final Repo b = this.b;
                    b.P(new ValueEventRegistration(b, Repo.s.r(this.a), QuerySpec.a(Repo.s.p(this.a))));
                }
            });
            list2.add(new Runnable(this, s, databaseError3, a3) {
                final s a;
                final DatabaseError b;
                final DataSnapshot c;
                final Repo d;
                
                @Override
                public void run() {
                    Repo.s.q(this.a).b(this.b, false, this.c);
                }
            });
        }
        this.O(this.f);
        while (i < list2.size()) {
            this.M((Runnable)list2.get(i));
            ++i;
        }
        this.V();
    }
    
    private Path R(Path f) {
        final Tree<List<s>> i = this.I(f);
        f = i.f();
        this.Q(this.E(i), f);
        return f;
    }
    
    private void S(final PersistenceManager persistenceManager) {
        final List<UserWriteRecord> b = persistenceManager.b();
        final Map<String, Object> c = ServerValues.c(this.b);
        final Iterator<UserWriteRecord> iterator = b.iterator();
        long d = Long.MIN_VALUE;
        while (iterator.hasNext()) {
            final UserWriteRecord userWriteRecord = iterator.next();
            final RequestResultCallback requestResultCallback = new RequestResultCallback(this, userWriteRecord) {
                final UserWriteRecord a;
                final Repo b;
                
                @Override
                public void a(final String s, final String s2) {
                    final DatabaseError x = Repo.x(s, s2);
                    Repo.y(this.b, "Persisted write", this.a.c(), x);
                    Repo.z(this.b, this.a.d(), this.a.c(), x);
                }
            };
            if (d >= userWriteRecord.d()) {
                throw new IllegalStateException("Write ids were not in order.");
            }
            d = userWriteRecord.d();
            this.n = userWriteRecord.d() + 1L;
            if (userWriteRecord.e()) {
                if (this.j.f()) {
                    final LogWrapper j = this.j;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Restoring overwrite with id ");
                    sb.append(userWriteRecord.d());
                    j.b(sb.toString(), new Object[0]);
                }
                this.c.j(userWriteRecord.c().k(), userWriteRecord.b().t0(true), requestResultCallback);
                this.p.H(userWriteRecord.c(), userWriteRecord.b(), ServerValues.g(userWriteRecord.b(), this.p, userWriteRecord.c(), c), userWriteRecord.d(), true, false);
            }
            else {
                if (this.j.f()) {
                    final LogWrapper i = this.j;
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Restoring merge with id ");
                    sb2.append(userWriteRecord.d());
                    i.b(sb2.toString(), new Object[0]);
                }
                this.c.a(userWriteRecord.c().k(), userWriteRecord.a().t(true), requestResultCallback);
                this.p.G(userWriteRecord.c(), userWriteRecord.a(), ServerValues.f(userWriteRecord.a(), this.p, userWriteRecord.c(), c), userWriteRecord.d(), false);
            }
        }
    }
    
    private void T() {
        final Map<String, Object> c = ServerValues.c(this.b);
        final ArrayList list = new ArrayList();
        this.e.b(Path.s(), (SparseSnapshotTree.SparseSnapshotTreeVisitor)new SparseSnapshotTree.SparseSnapshotTreeVisitor(this, c, list) {
            final Map a;
            final List b;
            final Repo c;
            
            @Override
            public void a(Path k, Node i) {
                i = ServerValues.i(i, Repo.A(this.c).I(k, new ArrayList<Long>()), this.a);
                this.b.addAll(Repo.A(this.c).z(k, i));
                k = Repo.k(this.c, k, -9);
                Repo.l(this.c, k);
            }
        });
        this.e = new SparseSnapshotTree();
        this.N(list);
    }
    
    private void V() {
        final Tree<List<s>> f = this.f;
        this.O(f);
        this.W(f);
    }
    
    private void W(final Tree<List<s>> tree) {
        if (tree.g() != null) {
            final List<s> e = this.E(tree);
            Utilities.f(e.size() > 0);
            final Boolean true = Boolean.TRUE;
            final Iterator iterator = e.iterator();
            while (true) {
                do {
                    final Boolean false = true;
                    if (iterator.hasNext()) {
                        continue;
                    }
                    if (false) {
                        this.X(e, tree.f());
                    }
                    return;
                } while (Repo.s.i((s)iterator.next()) == TransactionStatus.RUN);
                final Boolean false = Boolean.FALSE;
                continue;
            }
        }
        if (tree.h()) {
            tree.c((Tree.TreeVisitor)new Tree.TreeVisitor<List<s>>(this) {
                final Repo a;
                
                @Override
                public void a(final Tree<List<s>> tree) {
                    Repo.n(this.a, tree);
                }
            });
        }
    }
    
    private void X(final List<s> list, final Path path) {
        final ArrayList list2 = new ArrayList();
        final Iterator<s> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(Repo.s.l(iterator.next()));
        }
        Node node = this.J(path, list2);
        String hash;
        if (!this.g) {
            hash = node.getHash();
        }
        else {
            hash = "badhash";
        }
        final Iterator<s> iterator2 = list.iterator();
        while (true) {
            final boolean hasNext = iterator2.hasNext();
            boolean b = true;
            if (!hasNext) {
                break;
            }
            final s s = iterator2.next();
            if (Repo.s.i(s) != TransactionStatus.RUN) {
                b = false;
            }
            Utilities.f(b);
            Repo.s.k(s, TransactionStatus.SENT);
            Repo.s.o(s);
            node = node.V(Path.x(path, Repo.s.p(s)), Repo.s.d(s));
        }
        this.c.c(path.k(), node.t0(true), hash, new RequestResultCallback(this, path, list, this) {
            final Path a;
            final List b;
            final Repo c;
            final Repo d;
            
            @Override
            public void a(final String s, final String s2) {
                final DatabaseError x = Repo.x(s, s2);
                Repo.y(this.d, "Transaction", this.a, x);
                final ArrayList list = new ArrayList();
                if (x == null) {
                    final ArrayList list2 = new ArrayList();
                    for (final s s3 : this.b) {
                        Repo.s.k(s3, TransactionStatus.COMPLETED);
                        list.addAll(Repo.A(this.d).s(Repo.s.l(s3), false, false, Repo.o(this.d)));
                        list2.add(new Runnable(this, s3, InternalHelpers.a(InternalHelpers.c(this.c, Repo.s.p(s3)), IndexedNode.b(Repo.s.g(s3)))) {
                            final s a;
                            final DataSnapshot b;
                            final Repo$d c;
                            
                            @Override
                            public void run() {
                                Repo.s.q(this.a).b(null, true, this.b);
                            }
                        });
                        final Repo d = this.d;
                        d.P(new ValueEventRegistration(d, Repo.s.r(s3), QuerySpec.a(Repo.s.p(s3))));
                    }
                    final Repo d2 = this.d;
                    Repo.q(d2, Repo.p(d2).k(this.a));
                    Repo.r(this.d);
                    Repo.w(this.c, list);
                    for (int i = 0; i < list2.size(); ++i) {
                        this.d.M((Runnable)list2.get(i));
                    }
                }
                else {
                    if (x.f() == -1) {
                        for (final s s4 : this.b) {
                            if (Repo.s.i(s4) == TransactionStatus.SENT_NEEDS_ABORT) {
                                Repo.s.k(s4, TransactionStatus.NEEDS_ABORT);
                            }
                            else {
                                Repo.s.k(s4, TransactionStatus.RUN);
                            }
                        }
                    }
                    else {
                        for (final s s5 : this.b) {
                            Repo.s.k(s5, TransactionStatus.NEEDS_ABORT);
                            Repo.s.t(s5, x);
                        }
                    }
                    Repo.l(this.d, this.a);
                }
            }
        });
    }
    
    private void Z(final ChildKey childKey, final Object o) {
        if (childKey.equals(Constants.b)) {
            this.b.b((long)o);
        }
        final Path path = new Path(new ChildKey[] { Constants.a, childKey });
        try {
            final Node a = NodeUtilities.a(o);
            this.d.c(path, a);
            this.N(this.o.z(path, a));
        }
        catch (final DatabaseException ex) {
            this.j.c("Failed to parse info update", ex);
        }
    }
    
    private void a0(final String s, final Path path, final DatabaseError databaseError) {
        if (databaseError != null && databaseError.f() != -1 && databaseError.f() != -25) {
            final LogWrapper j = this.j;
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(" at ");
            sb.append(path.toString());
            sb.append(" failed: ");
            sb.append(databaseError.toString());
            j.i(sb.toString());
        }
    }
    
    private Path g(final Path path, final int n) {
        final Path f = this.I(path).f();
        if (this.k.f()) {
            final LogWrapper j = this.j;
            final StringBuilder sb = new StringBuilder();
            sb.append("Aborting transactions for path: ");
            sb.append(path);
            sb.append(". Affected: ");
            sb.append(f);
            j.b(sb.toString(), new Object[0]);
        }
        final Tree<List<s>> k = this.f.k(path);
        k.a((Tree.TreeFilter<List<s>>)new Tree.TreeFilter<List<s>>(this, n) {
            final int a;
            final Repo b;
            
            @Override
            public boolean a(final Tree<List<s>> tree) {
                Repo.u(this.b, tree, this.a);
                return false;
            }
        });
        this.h(k, n);
        k.d((Tree.TreeVisitor<List<s>>)new Tree.TreeVisitor<List<s>>(this, n) {
            final int a;
            final Repo b;
            
            @Override
            public void a(final Tree<List<s>> tree) {
                Repo.u(this.b, tree, this.a);
            }
        });
        return f;
    }
    
    private void h(final Tree<List<s>> tree, final int n) {
        final List list = tree.g();
        final ArrayList list2 = new ArrayList();
        if (list != null) {
            final ArrayList list3 = new ArrayList();
            DatabaseError databaseError;
            if (n == -9) {
                databaseError = DatabaseError.c("overriddenBySet");
            }
            else {
                final boolean b = n == -25;
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown transaction abort reason: ");
                sb.append(n);
                Utilities.g(b, sb.toString());
                databaseError = DatabaseError.a(-25);
            }
            int i = 0;
            int n2 = -1;
            while (i < list.size()) {
                final s s = (s)list.get(i);
                final TransactionStatus j = Repo.s.i(s);
                final TransactionStatus sent_NEEDS_ABORT = TransactionStatus.SENT_NEEDS_ABORT;
                if (j != sent_NEEDS_ABORT) {
                    if (Repo.s.i(s) == TransactionStatus.SENT) {
                        Utilities.f(n2 == i - 1);
                        Repo.s.k(s, sent_NEEDS_ABORT);
                        Repo.s.t(s, databaseError);
                        n2 = i;
                    }
                    else {
                        Utilities.f(Repo.s.i(s) == TransactionStatus.RUN);
                        this.P(new ValueEventRegistration(this, Repo.s.r(s), QuerySpec.a(Repo.s.p(s))));
                        if (n == -9) {
                            list2.addAll(this.p.s(Repo.s.l(s), true, false, this.b));
                        }
                        else {
                            final boolean b2 = n == -25;
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unknown transaction abort reason: ");
                            sb2.append(n);
                            Utilities.g(b2, sb2.toString());
                        }
                        list3.add(new Runnable(this, s, databaseError) {
                            final s a;
                            final DatabaseError b;
                            final Repo c;
                            
                            @Override
                            public void run() {
                                Repo.s.q(this.a).b(this.b, false, null);
                            }
                        });
                    }
                }
                ++i;
            }
            if (n2 == -1) {
                tree.j(null);
            }
            else {
                tree.j(list.subList(0, n2 + 1));
            }
            this.N(list2);
            final Iterator iterator = list3.iterator();
            while (iterator.hasNext()) {
                this.M((Runnable)iterator.next());
            }
        }
    }
    
    static void i(final Repo repo) {
        repo.G();
    }
    
    static LogWrapper j(final Repo repo) {
        return repo.j;
    }
    
    static Path k(final Repo repo, final Path path, final int n) {
        return repo.g(path, n);
    }
    
    static Path l(final Repo repo, final Path path) {
        return repo.R(path);
    }
    
    static PersistentConnection m(final Repo repo) {
        return repo.c;
    }
    
    static void n(final Repo repo, final Tree tree) {
        repo.W(tree);
    }
    
    static OffsetClock o(final Repo repo) {
        return repo.b;
    }
    
    static Tree p(final Repo repo) {
        return repo.f;
    }
    
    static void q(final Repo repo, final Tree tree) {
        repo.O(tree);
    }
    
    static void r(final Repo repo) {
        repo.V();
    }
    
    static SnapshotHolder s(final Repo repo) {
        return repo.d;
    }
    
    static void t(final Repo repo, final List list, final Tree tree) {
        repo.D(list, tree);
    }
    
    static void u(final Repo repo, final Tree tree, final int n) {
        repo.h(tree, n);
    }
    
    static SyncTree v(final Repo repo) {
        return repo.o;
    }
    
    static void w(final Repo repo, final List list) {
        repo.N(list);
    }
    
    static DatabaseError x(final String s, final String s2) {
        return H(s, s2);
    }
    
    static void y(final Repo repo, final String s, final Path path, final DatabaseError databaseError) {
        repo.a0(s, path, databaseError);
    }
    
    static void z(final Repo repo, final long n, final Path path, final DatabaseError databaseError) {
        repo.B(n, path, databaseError);
    }
    
    public void C(@NotNull final EventRegistration eventRegistration) {
        final ChildKey t = eventRegistration.e().e().t();
        List<? extends Event> list;
        if (t != null && t.equals(Constants.a)) {
            list = this.o.t(eventRegistration);
        }
        else {
            list = this.p.t(eventRegistration);
        }
        this.N(list);
    }
    
    void F(final DatabaseReference.CompletionListener completionListener, final DatabaseError databaseError, final Path path) {
        if (completionListener != null) {
            final ChildKey q = path.q();
            DatabaseReference databaseReference;
            if (q != null && q.m()) {
                databaseReference = InternalHelpers.c(this, path.w());
            }
            else {
                databaseReference = InternalHelpers.c(this, path);
            }
            this.M(new Runnable(this, completionListener, databaseError, databaseReference) {
                final DatabaseReference.CompletionListener a;
                final DatabaseError b;
                final DatabaseReference c;
                final Repo d;
                
                @Override
                public void run() {
                    this.a.a(this.b, this.c);
                }
            });
        }
    }
    
    public void L(final ChildKey childKey, final Object o) {
        this.Z(childKey, o);
    }
    
    public void M(final Runnable runnable) {
        this.i.F();
        this.i.o().b(runnable);
    }
    
    public void P(@NotNull final EventRegistration eventRegistration) {
        List<Event> list;
        if (Constants.a.equals(eventRegistration.e().e().t())) {
            list = this.o.P(eventRegistration);
        }
        else {
            list = this.p.P(eventRegistration);
        }
        this.N(list);
    }
    
    public void U(final Runnable runnable) {
        this.i.F();
        this.i.v().b(runnable);
    }
    
    public void Y(final Path path, final CompoundWrite compoundWrite, final DatabaseReference.CompletionListener completionListener, final Map<String, Object> map) {
        if (this.j.f()) {
            final LogWrapper j = this.j;
            final StringBuilder sb = new StringBuilder();
            sb.append("update: ");
            sb.append(path);
            j.b(sb.toString(), new Object[0]);
        }
        if (this.l.f()) {
            final LogWrapper l = this.l;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("update: ");
            sb2.append(path);
            sb2.append(" ");
            sb2.append(map);
            l.b(sb2.toString(), new Object[0]);
        }
        if (compoundWrite.isEmpty()) {
            if (this.j.f()) {
                this.j.b("update called with no changes. No-op", new Object[0]);
            }
            this.F(completionListener, null, path);
            return;
        }
        final CompoundWrite f = ServerValues.f(compoundWrite, this.p, path, ServerValues.c(this.b));
        final long k = this.K();
        this.N(this.p.G(path, compoundWrite, f, k, true));
        this.c.a(path.k(), map, new RequestResultCallback(this, path, k, completionListener) {
            final Path a;
            final long b;
            final DatabaseReference.CompletionListener c;
            final Repo d;
            
            @Override
            public void a(final String s, final String s2) {
                final DatabaseError x = Repo.x(s, s2);
                Repo.y(this.d, "updateChildren", this.a, x);
                Repo.z(this.d, this.b, this.a, x);
                this.d.F(this.c, x, this.a);
            }
        });
        final Iterator<Map.Entry<Path, Node>> iterator = compoundWrite.iterator();
        while (iterator.hasNext()) {
            this.R(this.g(path.m(((Map.Entry<Path, V>)iterator.next()).getKey()), -9));
        }
    }
    
    @Override
    public void a() {
        this.L(Constants.d, Boolean.FALSE);
        this.T();
    }
    
    @Override
    public void b(final List<String> list, final Object o, final boolean b, final Long n) {
        final Path path = new Path(list);
        if (this.j.f()) {
            final LogWrapper j = this.j;
            final StringBuilder sb = new StringBuilder();
            sb.append("onDataUpdate: ");
            sb.append(path);
            j.b(sb.toString(), new Object[0]);
        }
        if (this.l.f()) {
            final LogWrapper i = this.j;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("onDataUpdate: ");
            sb2.append(path);
            sb2.append(" ");
            sb2.append(o);
            i.b(sb2.toString(), new Object[0]);
        }
        ++this.m;
        List<? extends Event> list2 = null;
        Label_0419: {
            Label_0296: {
                if (n != null) {
                    Label_0443: {
                        try {
                            final Tag tag = new Tag(n);
                            if (b) {
                                final HashMap hashMap = new HashMap();
                                for (final Map.Entry<K, Object> entry : ((Map)o).entrySet()) {
                                    hashMap.put(new Path((String)entry.getKey()), NodeUtilities.a(entry.getValue()));
                                }
                                list2 = this.p.D(path, hashMap, tag);
                                break Label_0419;
                            }
                            list2 = this.p.E(path, NodeUtilities.a(o), tag);
                            break Label_0419;
                        }
                        catch (final DatabaseException ex) {
                            break Label_0443;
                        }
                        break Label_0296;
                    }
                    final DatabaseException ex;
                    this.j.c("FIREBASE INTERNAL ERROR", ex);
                    return;
                }
            }
            if (b) {
                final HashMap hashMap2 = new HashMap();
                for (final Map.Entry<K, Object> entry2 : ((Map)o).entrySet()) {
                    hashMap2.put(new Path((String)entry2.getKey()), NodeUtilities.a(entry2.getValue()));
                }
                list2 = this.p.y(path, hashMap2);
            }
            else {
                list2 = this.p.z(path, NodeUtilities.a(o));
            }
        }
        if (list2.size() > 0) {
            this.R(path);
        }
        this.N(list2);
    }
    
    @Override
    public void c(final boolean b) {
        this.L(Constants.c, b);
    }
    
    @Override
    public void d() {
        this.L(Constants.d, Boolean.TRUE);
    }
    
    @Override
    public void e(final Map<String, Object> map) {
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            this.Z(ChildKey.f(entry.getKey()), entry.getValue());
        }
    }
    
    @Override
    public void f(final List<String> list, final List<RangeMerge> list2, final Long n) {
        final Path path = new Path(list);
        if (this.j.f()) {
            final LogWrapper j = this.j;
            final StringBuilder sb = new StringBuilder();
            sb.append("onRangeMergeUpdate: ");
            sb.append(path);
            j.b(sb.toString(), new Object[0]);
        }
        if (this.l.f()) {
            final LogWrapper i = this.j;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("onRangeMergeUpdate: ");
            sb2.append(path);
            sb2.append(" ");
            sb2.append(list2);
            i.b(sb2.toString(), new Object[0]);
        }
        ++this.m;
        final ArrayList list3 = new ArrayList(list2.size());
        final Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            list3.add(new com.google.firebase.database.snapshot.RangeMerge((RangeMerge)iterator.next()));
        }
        List<? extends Event> list4;
        if (n != null) {
            list4 = this.p.F(path, list3, new Tag(n));
        }
        else {
            list4 = this.p.A(path, list3);
        }
        if (list4.size() > 0) {
            this.R(path);
        }
        this.N(list4);
    }
    
    @Override
    public String toString() {
        return this.a.toString();
    }
    
    private enum TransactionStatus
    {
        private static final TransactionStatus[] $VALUES;
        
        COMPLETED, 
        INITIALIZING, 
        NEEDS_ABORT, 
        RUN, 
        SENT, 
        SENT_NEEDS_ABORT;
    }
    
    private static class s implements Comparable<s>
    {
        private Path a;
        private Transaction.Handler b;
        private ValueEventListener c;
        private TransactionStatus d;
        private long e;
        private boolean f;
        private int g;
        private DatabaseError h;
        private long i;
        private Node j;
        private Node p;
        private Node w;
        
        static Node a(final s s) {
            return s.j;
        }
        
        static Node c(final s s, final Node j) {
            return s.j = j;
        }
        
        static Node d(final s s) {
            return s.p;
        }
        
        static Node f(final s s, final Node p2) {
            return s.p = p2;
        }
        
        static Node g(final s s) {
            return s.w;
        }
        
        static Node h(final s s, final Node w) {
            return s.w = w;
        }
        
        static TransactionStatus i(final s s) {
            return s.d;
        }
        
        static TransactionStatus k(final s s, final TransactionStatus d) {
            return s.d = d;
        }
        
        static long l(final s s) {
            return s.i;
        }
        
        static long m(final s s, final long i) {
            return s.i = i;
        }
        
        static int n(final s s) {
            return s.g;
        }
        
        static int o(final s s) {
            return s.g++;
        }
        
        static Path p(final s s) {
            return s.a;
        }
        
        static Transaction.Handler q(final s s) {
            return s.b;
        }
        
        static ValueEventListener r(final s s) {
            return s.c;
        }
        
        static DatabaseError s(final s s) {
            return s.h;
        }
        
        static DatabaseError t(final s s, final DatabaseError h) {
            return s.h = h;
        }
        
        static boolean u(final s s) {
            return s.f;
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.w((s)o);
        }
        
        public int w(final s s) {
            final long e = this.e;
            final long e2 = s.e;
            if (e < e2) {
                return -1;
            }
            if (e == e2) {
                return 0;
            }
            return 1;
        }
    }
}
