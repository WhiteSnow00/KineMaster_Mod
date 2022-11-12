// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view.filter;

import java.util.Iterator;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.snapshot.Index;

public class LimitedFilter implements NodeFilter
{
    private final RangedFilter a;
    private final Index b;
    private final int c;
    private final boolean d;
    
    public LimitedFilter(final QueryParams queryParams) {
        this.a = new RangedFilter(queryParams);
        this.b = queryParams.b();
        this.c = queryParams.g();
        this.d = (queryParams.n() ^ true);
    }
    
    private IndexedNode a(IndexedNode o, final ChildKey childKey, final Node node, final CompleteChildSource completeChildSource, final ChildChangeAccumulator childChangeAccumulator) {
        final int j = o.k().j();
        final int c = this.c;
        final boolean b = false;
        Utilities.f(j == c);
        final NamedNode namedNode = new NamedNode(childKey, node);
        NamedNode namedNode2;
        if (this.d) {
            namedNode2 = o.f();
        }
        else {
            namedNode2 = o.g();
        }
        final boolean e = this.a.e(namedNode);
        if (o.k().m0(childKey)) {
            final Node c2 = o.k().c0(childKey);
            NamedNode namedNode3;
            for (namedNode3 = completeChildSource.b(this.b, namedNode2, this.d); namedNode3 != null && (namedNode3.c().equals(childKey) || o.k().m0(namedNode3.c())); namedNode3 = completeChildSource.b(this.b, namedNode3, this.d)) {}
            int a;
            if (namedNode3 == null) {
                a = 1;
            }
            else {
                a = this.b.a(namedNode3, namedNode, this.d);
            }
            if (e && !node.isEmpty() && a >= 0) {
                if (childChangeAccumulator != null) {
                    childChangeAccumulator.b(Change.e(childKey, node, c2));
                }
                return o.o(childKey, node);
            }
            if (childChangeAccumulator != null) {
                childChangeAccumulator.b(Change.h(childKey, c2));
            }
            final IndexedNode o2 = o.o(childKey, EmptyNode.p());
            int n = b ? 1 : 0;
            if (namedNode3 != null) {
                n = (b ? 1 : 0);
                if (this.a.e(namedNode3)) {
                    n = 1;
                }
            }
            o = o2;
            if (n != 0) {
                if (childChangeAccumulator != null) {
                    childChangeAccumulator.b(Change.c(namedNode3.c(), namedNode3.d()));
                }
                o = o2.o(namedNode3.c(), namedNode3.d());
            }
            return o;
        }
        else {
            if (node.isEmpty()) {
                return o;
            }
            IndexedNode o3 = o;
            if (e) {
                o3 = o;
                if (this.b.a(namedNode2, namedNode, this.d) >= 0) {
                    if (childChangeAccumulator != null) {
                        childChangeAccumulator.b(Change.h(namedNode2.c(), namedNode2.d()));
                        childChangeAccumulator.b(Change.c(childKey, node));
                    }
                    o3 = o.o(childKey, node).o(namedNode2.c(), EmptyNode.p());
                }
            }
            return o3;
        }
    }
    
    @Override
    public Index h() {
        return this.b;
    }
    
    @Override
    public NodeFilter i() {
        return this.a.i();
    }
    
    @Override
    public IndexedNode j(final IndexedNode indexedNode, final Node node) {
        return indexedNode;
    }
    
    @Override
    public IndexedNode k(final IndexedNode indexedNode, final ChildKey childKey, final Node node, final Path path, final CompleteChildSource completeChildSource, final ChildChangeAccumulator childChangeAccumulator) {
        Node p6 = node;
        if (!this.a.e(new NamedNode(childKey, node))) {
            p6 = EmptyNode.p();
        }
        if (indexedNode.k().c0(childKey).equals(p6)) {
            return indexedNode;
        }
        if (indexedNode.k().j() < this.c) {
            return this.a.i().k(indexedNode, childKey, p6, path, completeChildSource, childChangeAccumulator);
        }
        return this.a(indexedNode, childKey, p6, completeChildSource, childChangeAccumulator);
    }
    
    @Override
    public boolean l() {
        return true;
    }
    
    @Override
    public IndexedNode m(final IndexedNode indexedNode, IndexedNode o, final ChildChangeAccumulator childChangeAccumulator) {
        IndexedNode e;
        if (!o.k().p1() && !o.k().isEmpty()) {
            final IndexedNode p3 = o.p(PriorityUtilities.a());
            Iterator<NamedNode> iterator;
            NamedNode namedNode;
            NamedNode namedNode2;
            int n;
            if (this.d) {
                iterator = o.F1();
                namedNode = this.a.a();
                namedNode2 = this.a.c();
                n = -1;
            }
            else {
                iterator = o.iterator();
                namedNode = this.a.c();
                namedNode2 = this.a.a();
                n = 1;
            }
            int n2 = 0;
            int n3 = 0;
            o = p3;
            while (true) {
                e = o;
                if (!iterator.hasNext()) {
                    break;
                }
                final NamedNode namedNode3 = iterator.next();
                int n4;
                if ((n4 = n2) == 0) {
                    n4 = n2;
                    if (this.b.compare(namedNode, namedNode3) * n <= 0) {
                        n4 = 1;
                    }
                }
                if (n4 != 0 && n3 < this.c && this.b.compare(namedNode3, namedNode2) * n <= 0) {
                    ++n3;
                    n2 = n4;
                }
                else {
                    o = o.o(namedNode3.c(), EmptyNode.p());
                    n2 = n4;
                }
            }
        }
        else {
            e = IndexedNode.e(EmptyNode.p(), this.b);
        }
        return this.a.i().m(indexedNode, e, childChangeAccumulator);
    }
}
