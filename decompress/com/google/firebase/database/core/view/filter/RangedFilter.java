// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view.filter;

import java.util.Iterator;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Index;

public class RangedFilter implements NodeFilter
{
    private final IndexedFilter a;
    private final Index b;
    private final NamedNode c;
    private final NamedNode d;
    
    public RangedFilter(final QueryParams queryParams) {
        this.a = new IndexedFilter(queryParams.b());
        this.b = queryParams.b();
        this.c = d(queryParams);
        this.d = b(queryParams);
    }
    
    private static NamedNode b(final QueryParams queryParams) {
        if (queryParams.j()) {
            return queryParams.b().f(queryParams.c(), queryParams.d());
        }
        return queryParams.b().g();
    }
    
    private static NamedNode d(final QueryParams queryParams) {
        if (queryParams.l()) {
            return queryParams.b().f(queryParams.e(), queryParams.f());
        }
        return queryParams.b().h();
    }
    
    public NamedNode a() {
        return this.d;
    }
    
    public NamedNode c() {
        return this.c;
    }
    
    public boolean e(final NamedNode namedNode) {
        return this.b.compare(this.c(), namedNode) <= 0 && this.b.compare(namedNode, this.a()) <= 0;
    }
    
    @Override
    public Index h() {
        return this.b;
    }
    
    @Override
    public NodeFilter i() {
        return this.a;
    }
    
    @Override
    public IndexedNode j(final IndexedNode indexedNode, final Node node) {
        return indexedNode;
    }
    
    @Override
    public IndexedNode k(final IndexedNode indexedNode, final ChildKey childKey, final Node node, final Path path, final CompleteChildSource completeChildSource, final ChildChangeAccumulator childChangeAccumulator) {
        Node p6 = node;
        if (!this.e(new NamedNode(childKey, node))) {
            p6 = EmptyNode.p();
        }
        return this.a.k(indexedNode, childKey, p6, path, completeChildSource, childChangeAccumulator);
    }
    
    @Override
    public boolean l() {
        return true;
    }
    
    @Override
    public IndexedNode m(final IndexedNode indexedNode, IndexedNode indexedNode2, final ChildChangeAccumulator childChangeAccumulator) {
        if (indexedNode2.k().p1()) {
            indexedNode2 = IndexedNode.e(EmptyNode.p(), this.b);
        }
        else {
            final IndexedNode p3 = indexedNode2.p(PriorityUtilities.a());
            final Iterator<NamedNode> iterator = indexedNode2.iterator();
            indexedNode2 = p3;
            while (iterator.hasNext()) {
                final NamedNode namedNode = iterator.next();
                if (!this.e(namedNode)) {
                    indexedNode2 = indexedNode2.o(namedNode.c(), EmptyNode.p());
                }
            }
        }
        return this.a.m(indexedNode, indexedNode2, childChangeAccumulator);
    }
}
