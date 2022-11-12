// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import java.util.ArrayList;
import com.google.firebase.database.snapshot.NamedNode;
import java.util.List;
import java.util.HashMap;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.Iterator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.snapshot.Node;
import java.util.Map;

public final class CompoundWrite implements Iterable<Map.Entry<Path, Node>>
{
    private static final CompoundWrite b;
    private final ImmutableTree<Node> a;
    
    static {
        b = new CompoundWrite(new ImmutableTree<Node>(null));
    }
    
    private CompoundWrite(final ImmutableTree<Node> a) {
        this.a = a;
    }
    
    private Node g(final Path path, final ImmutableTree<Node> immutableTree, Node g) {
        if (immutableTree.getValue() != null) {
            return g.V(path, immutableTree.getValue());
        }
        final Node node = null;
        final Iterator<Map.Entry<ChildKey, ImmutableTree<Node>>> iterator = immutableTree.p().iterator();
        Node node2 = node;
        while (iterator.hasNext()) {
            final Map.Entry<K, ImmutableTree> entry = (Map.Entry<K, ImmutableTree>)iterator.next();
            final ImmutableTree immutableTree2 = entry.getValue();
            final ChildKey childKey = (ChildKey)entry.getKey();
            if (childKey.m()) {
                Utilities.g(immutableTree2.getValue() != null, "Priority writes must always be leaf nodes");
                node2 = (Node)immutableTree2.getValue();
            }
            else {
                g = this.g(path.n(childKey), immutableTree2, g);
            }
        }
        Node v = g;
        if (!g.F(path).isEmpty()) {
            v = g;
            if (node2 != null) {
                v = g.V(path.n(ChildKey.i()), node2);
            }
        }
        return v;
    }
    
    public static CompoundWrite n() {
        return CompoundWrite.b;
    }
    
    public static CompoundWrite o(final Map<Path, Node> map) {
        final ImmutableTree<Object> b = (ImmutableTree<Object>)ImmutableTree.b();
        final Iterator<Map.Entry<Path, Node>> iterator = map.entrySet().iterator();
        Iterable<Map.Entry<Path, T>> x = (Iterable<Map.Entry<Path, T>>)b;
        while (iterator.hasNext()) {
            final Map.Entry<Path, V> entry = (Map.Entry<Path, V>)iterator.next();
            x = (Iterable<Map.Entry<Path, T>>)((ImmutableTree<Node>)x).x(entry.getKey(), new ImmutableTree<Node>(entry.getValue()));
        }
        return new CompoundWrite((ImmutableTree<Node>)x);
    }
    
    public static CompoundWrite p(final Map<String, Object> map) {
        final ImmutableTree<Object> b = (ImmutableTree<Object>)ImmutableTree.b();
        final Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        Iterable<Map.Entry<Path, T>> x = (Iterable<Map.Entry<Path, T>>)b;
        while (iterator.hasNext()) {
            final Map.Entry entry = iterator.next();
            x = (Iterable<Map.Entry<Path, T>>)((ImmutableTree<Node>)x).x(new Path((String)entry.getKey()), new ImmutableTree<Node>(NodeUtilities.a(entry.getValue())));
        }
        return new CompoundWrite((ImmutableTree<Node>)x);
    }
    
    public CompoundWrite a(final Path path, final Node node) {
        if (path.isEmpty()) {
            return new CompoundWrite(new ImmutableTree<Node>(node));
        }
        final Path f = this.a.f(path);
        if (f == null) {
            return new CompoundWrite(this.a.x(path, new ImmutableTree<Node>(node)));
        }
        final Path x = Path.x(f, path);
        final Node node2 = this.a.n(f);
        final ChildKey q = x.q();
        if (q != null && q.m() && node2.F(x.w()).isEmpty()) {
            return this;
        }
        return new CompoundWrite(this.a.w(f, node2.V(x, node)));
    }
    
    public CompoundWrite b(final ChildKey childKey, final Node node) {
        return this.a(new Path(new ChildKey[] { childKey }), node);
    }
    
    public CompoundWrite e(final Path path, final CompoundWrite compoundWrite) {
        return compoundWrite.a.k(this, (ImmutableTree.TreeVisitor<? super Node, CompoundWrite>)new ImmutableTree.TreeVisitor<Node, CompoundWrite>(this, path) {
            final Path a;
            final CompoundWrite b;
            
            @Override
            public /* bridge */ Object a(final Path path, final Object o, final Object o2) {
                return this.b(path, (Node)o, (CompoundWrite)o2);
            }
            
            public CompoundWrite b(final Path path, final Node node, final CompoundWrite compoundWrite) {
                return compoundWrite.a(this.a.m(path), node);
            }
        });
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this || (o != null && o.getClass() == CompoundWrite.class && ((CompoundWrite)o).t(true).equals(this.t(true)));
    }
    
    public Node f(final Node node) {
        return this.g(Path.s(), this.a, node);
    }
    
    @Override
    public int hashCode() {
        return this.t(true).hashCode();
    }
    
    public boolean isEmpty() {
        return this.a.isEmpty();
    }
    
    @Override
    public Iterator<Map.Entry<Path, Node>> iterator() {
        return this.a.iterator();
    }
    
    public CompoundWrite k(final Path path) {
        if (path.isEmpty()) {
            return this;
        }
        final Node s = this.s(path);
        if (s != null) {
            return new CompoundWrite(new ImmutableTree<Node>(s));
        }
        return new CompoundWrite(this.a.y(path));
    }
    
    public Map<ChildKey, CompoundWrite> m() {
        final HashMap hashMap = new HashMap();
        for (final Map.Entry<ChildKey, V> entry : this.a.p()) {
            hashMap.put(entry.getKey(), new CompoundWrite((ImmutableTree<Node>)entry.getValue()));
        }
        return hashMap;
    }
    
    public List<NamedNode> q() {
        final ArrayList list = new ArrayList();
        if (this.a.getValue() != null) {
            for (final NamedNode namedNode : this.a.getValue()) {
                list.add(new NamedNode(namedNode.c(), namedNode.d()));
            }
        }
        else {
            for (final Map.Entry<K, ImmutableTree> entry : this.a.p()) {
                final ImmutableTree immutableTree = entry.getValue();
                if (immutableTree.getValue() != null) {
                    list.add(new NamedNode((ChildKey)entry.getKey(), (Node)immutableTree.getValue()));
                }
            }
        }
        return list;
    }
    
    public Node s(final Path path) {
        final Path f = this.a.f(path);
        if (f != null) {
            return this.a.n(f).F(Path.x(f, path));
        }
        return null;
    }
    
    public Map<String, Object> t(final boolean b) {
        final HashMap hashMap = new HashMap();
        this.a.m((ImmutableTree.TreeVisitor<Node, Void>)new ImmutableTree.TreeVisitor<Node, Void>(this, hashMap, b) {
            final Map a;
            final boolean b;
            final CompoundWrite c;
            
            @Override
            public /* bridge */ Object a(final Path path, final Object o, final Object o2) {
                return this.b(path, (Node)o, (Void)o2);
            }
            
            public Void b(final Path path, final Node node, final Void void1) {
                this.a.put(path.z(), node.t0(this.b));
                return null;
            }
        });
        return hashMap;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CompoundWrite{");
        sb.append(this.t(true).toString());
        sb.append("}");
        return sb.toString();
    }
    
    public boolean v(final Path path) {
        return this.s(path) != null;
    }
    
    public CompoundWrite w(final Path path) {
        if (path.isEmpty()) {
            return CompoundWrite.b;
        }
        return new CompoundWrite(this.a.x(path, ImmutableTree.b()));
    }
    
    public Node x() {
        return this.a.getValue();
    }
}
