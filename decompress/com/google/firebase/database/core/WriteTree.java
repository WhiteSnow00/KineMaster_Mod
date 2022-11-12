// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.Map;
import com.google.firebase.database.snapshot.Node;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.core.utilities.Predicate;

public class WriteTree
{
    private static final Predicate<UserWriteRecord> d;
    private CompoundWrite a;
    private List<UserWriteRecord> b;
    private Long c;
    
    static {
        d = new Predicate<UserWriteRecord>() {
            @Override
            public /* bridge */ boolean a(final Object o) {
                return this.b((UserWriteRecord)o);
            }
            
            public boolean b(final UserWriteRecord userWriteRecord) {
                return userWriteRecord.f();
            }
        };
    }
    
    public WriteTree() {
        this.a = CompoundWrite.n();
        this.b = new ArrayList<UserWriteRecord>();
        this.c = -1L;
    }
    
    private static CompoundWrite j(final List<UserWriteRecord> list, final Predicate<UserWriteRecord> predicate, final Path path) {
        final CompoundWrite n = CompoundWrite.n();
        final Iterator<UserWriteRecord> iterator = list.iterator();
        CompoundWrite compoundWrite = n;
        while (iterator.hasNext()) {
            final UserWriteRecord userWriteRecord = iterator.next();
            if (predicate.a(userWriteRecord)) {
                final Path c = userWriteRecord.c();
                if (userWriteRecord.e()) {
                    if (path.p(c)) {
                        compoundWrite = compoundWrite.a(Path.x(path, c), userWriteRecord.b());
                    }
                    else {
                        if (!c.p(path)) {
                            continue;
                        }
                        compoundWrite = compoundWrite.a(Path.s(), userWriteRecord.b().F(Path.x(c, path)));
                    }
                }
                else if (path.p(c)) {
                    compoundWrite = compoundWrite.e(Path.x(path, c), userWriteRecord.a());
                }
                else {
                    if (!c.p(path)) {
                        continue;
                    }
                    final Path x = Path.x(c, path);
                    if (x.isEmpty()) {
                        compoundWrite = compoundWrite.e(Path.s(), userWriteRecord.a());
                    }
                    else {
                        final Node s = userWriteRecord.a().s(x);
                        if (s == null) {
                            continue;
                        }
                        compoundWrite = compoundWrite.a(Path.s(), s);
                    }
                }
            }
        }
        return compoundWrite;
    }
    
    private boolean k(final UserWriteRecord userWriteRecord, final Path path) {
        if (userWriteRecord.e()) {
            return userWriteRecord.c().p(path);
        }
        final Iterator<Map.Entry<Path, Node>> iterator = userWriteRecord.a().iterator();
        while (iterator.hasNext()) {
            if (userWriteRecord.c().m(((Map.Entry<Path, V>)iterator.next()).getKey()).p(path)) {
                return true;
            }
        }
        return false;
    }
    
    private void m() {
        this.a = j(this.b, WriteTree.d, Path.s());
        if (this.b.size() > 0) {
            final List<UserWriteRecord> b = this.b;
            this.c = ((UserWriteRecord)b.get(b.size() - 1)).d();
        }
        else {
            this.c = -1L;
        }
    }
    
    public void a(final Path path, final CompoundWrite compoundWrite, final Long c) {
        Utilities.f(c > this.c);
        this.b.add(new UserWriteRecord(c, path, compoundWrite));
        this.a = this.a.e(path, compoundWrite);
        this.c = c;
    }
    
    public void b(final Path path, final Node node, final Long c, final boolean b) {
        Utilities.f(c > this.c);
        this.b.add(new UserWriteRecord(c, path, node, b));
        if (b) {
            this.a = this.a.a(path, node);
        }
        this.c = c;
    }
    
    public Node c(Path n, final ChildKey childKey, final CacheNode cacheNode) {
        n = n.n(childKey);
        final Node s = this.a.s(n);
        if (s != null) {
            return s;
        }
        if (cacheNode.c(childKey)) {
            return this.a.k(n).f(cacheNode.b().c0(childKey));
        }
        return null;
    }
    
    public Node d(final Path path, Node node, final List<Long> list, final boolean b) {
        if (list.isEmpty() && !b) {
            final Node s = this.a.s(path);
            if (s != null) {
                return s;
            }
            final CompoundWrite k = this.a.k(path);
            if (k.isEmpty()) {
                return node;
            }
            if (node == null && !k.v(Path.s())) {
                return null;
            }
            if (node == null) {
                node = EmptyNode.p();
            }
            return k.f(node);
        }
        else {
            final CompoundWrite i = this.a.k(path);
            if (!b && i.isEmpty()) {
                return node;
            }
            if (!b && node == null && !i.v(Path.s())) {
                return null;
            }
            final CompoundWrite j = j(this.b, new Predicate<UserWriteRecord>(this, b, list, path) {
                final boolean b;
                final List c;
                final Path d;
                final WriteTree e;
                
                @Override
                public /* bridge */ boolean a(final Object o) {
                    return this.b((UserWriteRecord)o);
                }
                
                public boolean b(final UserWriteRecord userWriteRecord) {
                    return (userWriteRecord.f() || this.b) && !this.c.contains(userWriteRecord.d()) && (userWriteRecord.c().p(this.d) || this.d.p(userWriteRecord.c()));
                }
            }, path);
            if (node == null) {
                node = EmptyNode.p();
            }
            return j.f(node);
        }
    }
    
    public Node e(final Path path, final Node node) {
        Node node2 = EmptyNode.p();
        final Node s = this.a.s(path);
        if (s != null) {
            Node node3 = node2;
            if (!s.p1()) {
                final Iterator<NamedNode> iterator = s.iterator();
                while (true) {
                    node3 = node2;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    final NamedNode namedNode = iterator.next();
                    node2 = node2.r0(namedNode.c(), namedNode.d());
                }
            }
            return node3;
        }
        final CompoundWrite k = this.a.k(path);
        for (final NamedNode namedNode2 : node) {
            node2 = node2.r0(namedNode2.c(), k.k(new Path(new ChildKey[] { namedNode2.c() })).f(namedNode2.d()));
        }
        for (final NamedNode namedNode3 : k.q()) {
            node2 = node2.r0(namedNode3.c(), namedNode3.d());
        }
        return node2;
    }
    
    public Node f(Path m, final Path path, final Node node, final Node node2) {
        Utilities.g(node != null || node2 != null, "Either existingEventSnap or existingServerSnap must exist");
        m = m.m(path);
        if (this.a.v(m)) {
            return null;
        }
        final CompoundWrite k = this.a.k(m);
        if (k.isEmpty()) {
            return node2.F(path);
        }
        return k.f(node2.F(path));
    }
    
    public NamedNode g(final Path path, final Node node, final NamedNode namedNode, final boolean b, final Index index) {
        final CompoundWrite k = this.a.k(path);
        Node node2 = k.s(Path.s());
        NamedNode namedNode2 = null;
        final NamedNode namedNode3 = null;
        if (node2 == null) {
            if (node == null) {
                return namedNode2;
            }
            node2 = k.f(node);
        }
        final Iterator<NamedNode> iterator = node2.iterator();
        NamedNode namedNode4 = namedNode3;
        while (true) {
            namedNode2 = namedNode4;
            if (!iterator.hasNext()) {
                break;
            }
            final NamedNode namedNode5 = iterator.next();
            if (index.a(namedNode5, namedNode, b) <= 0 || (namedNode4 != null && index.a(namedNode5, namedNode4, b) >= 0)) {
                continue;
            }
            namedNode4 = namedNode5;
        }
        return namedNode2;
    }
    
    public WriteTreeRef h(final Path path) {
        return new WriteTreeRef(path, this);
    }
    
    public UserWriteRecord i(final long n) {
        for (final UserWriteRecord userWriteRecord : this.b) {
            if (userWriteRecord.d() == n) {
                return userWriteRecord;
            }
        }
        return null;
    }
    
    public boolean l(final long n) {
        final Iterator<UserWriteRecord> iterator = this.b.iterator();
        int n2 = 0;
        while (true) {
            while (iterator.hasNext()) {
                final UserWriteRecord userWriteRecord = iterator.next();
                if (userWriteRecord.d() == n) {
                    Utilities.g(userWriteRecord != null, "removeWrite called with nonexistent writeId");
                    this.b.remove(userWriteRecord);
                    int f = userWriteRecord.f() ? 1 : 0;
                    int n3 = this.b.size() - 1;
                    int n4 = 0;
                    while (f != 0 && n3 >= 0) {
                        final UserWriteRecord userWriteRecord2 = this.b.get(n3);
                        int n5 = n4;
                        int n6 = f;
                        if (userWriteRecord2.f()) {
                            if (n3 >= n2 && this.k(userWriteRecord2, userWriteRecord.c())) {
                                n6 = 0;
                                n5 = n4;
                            }
                            else {
                                n5 = n4;
                                n6 = f;
                                if (userWriteRecord.c().p(userWriteRecord2.c())) {
                                    n5 = 1;
                                    n6 = f;
                                }
                            }
                        }
                        --n3;
                        n4 = n5;
                        f = n6;
                    }
                    if (f == 0) {
                        return false;
                    }
                    if (n4 != 0) {
                        this.m();
                        return true;
                    }
                    if (userWriteRecord.e()) {
                        this.a = this.a.w(userWriteRecord.c());
                    }
                    else {
                        final Iterator<Map.Entry<Path, Node>> iterator2 = userWriteRecord.a().iterator();
                        while (iterator2.hasNext()) {
                            this.a = this.a.w(userWriteRecord.c().m(((Map.Entry<Path, V>)iterator2.next()).getKey()));
                        }
                    }
                    return true;
                }
                else {
                    ++n2;
                }
            }
            final UserWriteRecord userWriteRecord = null;
            continue;
        }
    }
    
    public Node n(final Path path) {
        return this.a.s(path);
    }
}
