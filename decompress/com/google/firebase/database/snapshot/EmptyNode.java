// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import java.util.Collections;
import java.util.Iterator;
import com.google.firebase.database.core.Path;

public class EmptyNode extends ChildrenNode
{
    private static final EmptyNode e;
    
    static {
        e = new EmptyNode();
    }
    
    private EmptyNode() {
    }
    
    public static EmptyNode p() {
        return EmptyNode.e;
    }
    
    @Override
    public Node C0() {
        return this;
    }
    
    @Override
    public Node F(final Path path) {
        return this;
    }
    
    @Override
    public Iterator<NamedNode> F1() {
        return Collections.emptyList().iterator();
    }
    
    @Override
    public /* bridge */ Node L(final Node node) {
        return this.q(node);
    }
    
    @Override
    public ChildKey S0(final ChildKey childKey) {
        return null;
    }
    
    @Override
    public Node V(final Path path, final Node node) {
        if (path.isEmpty()) {
            return node;
        }
        final ChildKey t = path.t();
        return this.r0(t, this.c0(t).V(path.y(), node));
    }
    
    @Override
    public String a0(final HashVersion hashVersion) {
        return "";
    }
    
    @Override
    public Node c0(final ChildKey childKey) {
        return this;
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.f((Node)o);
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof EmptyNode;
        boolean b2 = true;
        if (b) {
            return true;
        }
        if (o instanceof Node) {
            final Node node = (Node)o;
            if (node.isEmpty() && this.C0().equals(node.C0())) {
                return b2;
            }
        }
        b2 = false;
        return b2;
    }
    
    @Override
    public int f(final Node node) {
        int n;
        if (node.isEmpty()) {
            n = 0;
        }
        else {
            n = -1;
        }
        return n;
    }
    
    @Override
    public String getHash() {
        return "";
    }
    
    @Override
    public Object getValue() {
        return null;
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    public Iterator<NamedNode> iterator() {
        return Collections.emptyList().iterator();
    }
    
    @Override
    public int j() {
        return 0;
    }
    
    @Override
    public boolean m0(final ChildKey childKey) {
        return false;
    }
    
    @Override
    public boolean p1() {
        return false;
    }
    
    public EmptyNode q(final Node node) {
        return this;
    }
    
    @Override
    public Node r0(final ChildKey childKey, final Node node) {
        if (node.isEmpty()) {
            return this;
        }
        if (childKey.m()) {
            return this;
        }
        return new ChildrenNode().r0(childKey, node);
    }
    
    @Override
    public Object t0(final boolean b) {
        return null;
    }
    
    @Override
    public String toString() {
        return "<Empty Node>";
    }
}
