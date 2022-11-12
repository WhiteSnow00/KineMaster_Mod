// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view.filter;

import java.util.Iterator;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Index;

public class IndexedFilter implements NodeFilter
{
    private final Index a;
    
    public IndexedFilter(final Index a) {
        this.a = a;
    }
    
    @Override
    public Index h() {
        return this.a;
    }
    
    @Override
    public NodeFilter i() {
        return this;
    }
    
    @Override
    public IndexedNode j(final IndexedNode indexedNode, final Node node) {
        if (indexedNode.k().isEmpty()) {
            return indexedNode;
        }
        return indexedNode.p(node);
    }
    
    @Override
    public IndexedNode k(final IndexedNode indexedNode, final ChildKey childKey, final Node node, final Path path, final CompleteChildSource completeChildSource, final ChildChangeAccumulator childChangeAccumulator) {
        Utilities.g(indexedNode.n(this.a), "The index must match the filter");
        final Node k = indexedNode.k();
        final Node c0 = k.c0(childKey);
        if (c0.F(path).equals(node.F(path)) && c0.isEmpty() == node.isEmpty()) {
            return indexedNode;
        }
        if (childChangeAccumulator != null) {
            if (node.isEmpty()) {
                if (k.m0(childKey)) {
                    childChangeAccumulator.b(Change.h(childKey, c0));
                }
                else {
                    Utilities.g(k.p1(), "A child remove without an old child only makes sense on a leaf node");
                }
            }
            else if (c0.isEmpty()) {
                childChangeAccumulator.b(Change.c(childKey, node));
            }
            else {
                childChangeAccumulator.b(Change.e(childKey, node, c0));
            }
        }
        if (k.p1() && node.isEmpty()) {
            return indexedNode;
        }
        return indexedNode.o(childKey, node);
    }
    
    @Override
    public boolean l() {
        return false;
    }
    
    @Override
    public IndexedNode m(final IndexedNode indexedNode, final IndexedNode indexedNode2, final ChildChangeAccumulator childChangeAccumulator) {
        Utilities.g(indexedNode2.n(this.a), "Can't use IndexedNode that doesn't have filter's index");
        if (childChangeAccumulator != null) {
            for (final NamedNode namedNode : indexedNode.k()) {
                if (!indexedNode2.k().m0(namedNode.c())) {
                    childChangeAccumulator.b(Change.h(namedNode.c(), namedNode.d()));
                }
            }
            if (!indexedNode2.k().p1()) {
                for (final NamedNode namedNode2 : indexedNode2.k()) {
                    if (indexedNode.k().m0(namedNode2.c())) {
                        final Node c0 = indexedNode.k().c0(namedNode2.c());
                        if (c0.equals(namedNode2.d())) {
                            continue;
                        }
                        childChangeAccumulator.b(Change.e(namedNode2.c(), namedNode2.d(), c0));
                    }
                    else {
                        childChangeAccumulator.b(Change.c(namedNode2.c(), namedNode2.d()));
                    }
                }
            }
        }
        return indexedNode2;
    }
}
