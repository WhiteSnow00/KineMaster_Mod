// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import java.util.HashMap;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.Collections;
import java.util.Iterator;
import com.google.firebase.database.core.Path;

public abstract class LeafNode<T extends LeafNode> implements Node
{
    protected final Node a;
    private String b;
    
    LeafNode(final Node a) {
        this.a = a;
    }
    
    private static int f(final LongNode longNode, final DoubleNode doubleNode) {
        return Double.valueOf((double)(long)longNode.getValue()).compareTo((Double)doubleNode.getValue());
    }
    
    @Override
    public Node C0() {
        return this.a;
    }
    
    @Override
    public Node F(final Path path) {
        if (path.isEmpty()) {
            return this;
        }
        if (path.t().m()) {
            return this.a;
        }
        return EmptyNode.p();
    }
    
    @Override
    public Iterator<NamedNode> F1() {
        return Collections.emptyList().iterator();
    }
    
    @Override
    public ChildKey S0(final ChildKey childKey) {
        return null;
    }
    
    @Override
    public Node V(final Path path, final Node node) {
        final ChildKey t = path.t();
        if (t == null) {
            return node;
        }
        if (node.isEmpty() && !t.m()) {
            return this;
        }
        final boolean m = path.t().m();
        boolean b = true;
        if (m) {
            b = (path.size() == 1 && b);
        }
        Utilities.f(b);
        return this.r0(t, EmptyNode.p().V(path.y(), node));
    }
    
    protected abstract int a(final T p0);
    
    @Override
    public Node c0(final ChildKey childKey) {
        if (childKey.m()) {
            return this.a;
        }
        return EmptyNode.p();
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.g((Node)o);
    }
    
    public int g(final Node node) {
        if (node.isEmpty()) {
            return 1;
        }
        if (node instanceof ChildrenNode) {
            return -1;
        }
        Utilities.g(node.p1(), "Node is not leaf node!");
        if (this instanceof LongNode && node instanceof DoubleNode) {
            return f((LongNode)this, (DoubleNode)node);
        }
        if (this instanceof DoubleNode && node instanceof LongNode) {
            return f((LongNode)node, (DoubleNode)this) * -1;
        }
        return this.n((LeafNode<?>)node);
    }
    
    @Override
    public String getHash() {
        if (this.b == null) {
            this.b = Utilities.i(this.a0(HashVersion.V1));
        }
        return this.b;
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public Iterator<NamedNode> iterator() {
        return Collections.emptyList().iterator();
    }
    
    @Override
    public int j() {
        return 0;
    }
    
    protected abstract LeafType k();
    
    protected String m(final HashVersion hashVersion) {
        final int n = LeafNode$a.a[hashVersion.ordinal()];
        if (n != 1 && n != 2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unknown hash version: ");
            sb.append(hashVersion);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.a.isEmpty()) {
            return "";
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("priority:");
        sb2.append(this.a.a0(hashVersion));
        sb2.append(":");
        return sb2.toString();
    }
    
    @Override
    public boolean m0(final ChildKey childKey) {
        return false;
    }
    
    protected int n(final LeafNode<?> leafNode) {
        final LeafType k = this.k();
        final LeafType i = leafNode.k();
        if (k.equals(i)) {
            return this.a((T)leafNode);
        }
        return k.compareTo(i);
    }
    
    @Override
    public boolean p1() {
        return true;
    }
    
    @Override
    public Node r0(final ChildKey childKey, final Node node) {
        if (childKey.m()) {
            return this.L(node);
        }
        if (node.isEmpty()) {
            return this;
        }
        return EmptyNode.p().r0(childKey, node).L(this.a);
    }
    
    @Override
    public Object t0(final boolean b) {
        if (b && !this.a.isEmpty()) {
            final HashMap hashMap = new HashMap();
            hashMap.put(".value", this.getValue());
            hashMap.put(".priority", this.a.getValue());
            return hashMap;
        }
        return this.getValue();
    }
    
    @Override
    public String toString() {
        String s = this.t0(true).toString();
        if (s.length() > 100) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, 100));
            sb.append("...");
            s = sb.toString();
        }
        return s;
    }
    
    protected enum LeafType
    {
        private static final LeafType[] $VALUES;
        
        Boolean, 
        DeferredValue, 
        Number, 
        String;
    }
}
