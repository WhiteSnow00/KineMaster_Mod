// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;

public final class PathIndex extends Index
{
    private final Path a;
    
    public PathIndex(final Path a) {
        if (a.size() == 1 && a.t().m()) {
            throw new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
        }
        this.a = a;
    }
    
    @Override
    public String c() {
        return this.a.z();
    }
    
    @Override
    public /* bridge */ int compare(final Object o, final Object o2) {
        return this.i((NamedNode)o, (NamedNode)o2);
    }
    
    @Override
    public boolean e(final Node node) {
        return node.F(this.a).isEmpty() ^ true;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && PathIndex.class == o.getClass() && this.a.equals(((PathIndex)o).a));
    }
    
    @Override
    public NamedNode f(final ChildKey childKey, final Node node) {
        return new NamedNode(childKey, EmptyNode.p().V(this.a, node));
    }
    
    @Override
    public NamedNode g() {
        return new NamedNode(ChildKey.g(), EmptyNode.p().V(this.a, Node.q));
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    public int i(final NamedNode namedNode, final NamedNode namedNode2) {
        final int compareTo = namedNode.d().F(this.a).compareTo(namedNode2.d().F(this.a));
        if (compareTo == 0) {
            return namedNode.c().d(namedNode2.c());
        }
        return compareTo;
    }
}
