// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import com.google.android.gms.common.internal.Objects;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import com.google.firebase.database.collection.ImmutableSortedSet;

public class IndexedNode implements Iterable<NamedNode>
{
    private static final ImmutableSortedSet<NamedNode> d;
    private final Node a;
    private ImmutableSortedSet<NamedNode> b;
    private final Index c;
    
    static {
        d = new ImmutableSortedSet<NamedNode>(Collections.emptyList(), null);
    }
    
    private IndexedNode(final Node a, final Index c) {
        this.c = c;
        this.a = a;
        this.b = null;
    }
    
    private IndexedNode(final Node a, final Index c, final ImmutableSortedSet<NamedNode> b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    private void a() {
        if (this.b == null) {
            if (this.c.equals(KeyIndex.j())) {
                this.b = IndexedNode.d;
            }
            else {
                final ArrayList list = new ArrayList();
                final Iterator<NamedNode> iterator = this.a.iterator();
                int n = 0;
                while (iterator.hasNext()) {
                    final NamedNode namedNode = iterator.next();
                    if (n == 0 && !this.c.e(namedNode.d())) {
                        n = 0;
                    }
                    else {
                        n = 1;
                    }
                    list.add(new NamedNode(namedNode.c(), namedNode.d()));
                }
                if (n != 0) {
                    this.b = new ImmutableSortedSet<NamedNode>(list, (Comparator<Object>)this.c);
                }
                else {
                    this.b = IndexedNode.d;
                }
            }
        }
    }
    
    public static IndexedNode b(final Node node) {
        return new IndexedNode(node, PriorityIndex.j());
    }
    
    public static IndexedNode e(final Node node, final Index index) {
        return new IndexedNode(node, index);
    }
    
    public Iterator<NamedNode> F1() {
        this.a();
        if (Objects.b(this.b, IndexedNode.d)) {
            return this.a.F1();
        }
        return this.b.F1();
    }
    
    public NamedNode f() {
        if (!(this.a instanceof ChildrenNode)) {
            return null;
        }
        this.a();
        if (Objects.b(this.b, IndexedNode.d)) {
            final ChildKey m = ((ChildrenNode)this.a).m();
            return new NamedNode(m, this.a.c0(m));
        }
        return this.b.b();
    }
    
    public NamedNode g() {
        if (!(this.a instanceof ChildrenNode)) {
            return null;
        }
        this.a();
        if (Objects.b(this.b, IndexedNode.d)) {
            final ChildKey n = ((ChildrenNode)this.a).n();
            return new NamedNode(n, this.a.c0(n));
        }
        return this.b.a();
    }
    
    @Override
    public Iterator<NamedNode> iterator() {
        this.a();
        if (Objects.b(this.b, IndexedNode.d)) {
            return this.a.iterator();
        }
        return this.b.iterator();
    }
    
    public Node k() {
        return this.a;
    }
    
    public ChildKey m(ChildKey c, final Node node, final Index index) {
        if (!this.c.equals(KeyIndex.j()) && !this.c.equals(index)) {
            throw new IllegalArgumentException("Index not available in IndexedNode!");
        }
        this.a();
        if (Objects.b(this.b, IndexedNode.d)) {
            return this.a.S0(c);
        }
        final NamedNode namedNode = this.b.e(new NamedNode(c, node));
        if (namedNode != null) {
            c = namedNode.c();
        }
        else {
            c = null;
        }
        return c;
    }
    
    public boolean n(final Index index) {
        return this.c == index;
    }
    
    public IndexedNode o(final ChildKey childKey, final Node node) {
        final Node r0 = this.a.r0(childKey, node);
        final ImmutableSortedSet<NamedNode> b = this.b;
        final ImmutableSortedSet<NamedNode> d = IndexedNode.d;
        if (Objects.b(b, d) && !this.c.e(node)) {
            return new IndexedNode(r0, this.c, d);
        }
        final ImmutableSortedSet<NamedNode> b2 = this.b;
        if (b2 != null && !Objects.b(b2, d)) {
            ImmutableSortedSet<NamedNode> set = this.b.g(new NamedNode(childKey, this.a.c0(childKey)));
            if (!node.isEmpty()) {
                set = set.f(new NamedNode(childKey, node));
            }
            return new IndexedNode(r0, this.c, set);
        }
        return new IndexedNode(r0, this.c, null);
    }
    
    public IndexedNode p(final Node node) {
        return new IndexedNode(this.a.L(node), this.c, this.b);
    }
}
