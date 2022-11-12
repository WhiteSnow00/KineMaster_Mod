// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import java.util.Iterator;
import com.google.firebase.database.core.Path;

public interface Node extends Comparable<Node>, Iterable<NamedNode>
{
    public static final ChildrenNode q = new ChildrenNode() {
        @Override
        public Node C0() {
            return this;
        }
        
        @Override
        public Node c0(final ChildKey childKey) {
            if (childKey.m()) {
                return this.C0();
            }
            return EmptyNode.p();
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.f((Node)o);
        }
        
        @Override
        public boolean equals(final Object o) {
            return o == this;
        }
        
        @Override
        public int f(final Node node) {
            return (node != this) ? 1 : 0;
        }
        
        @Override
        public boolean isEmpty() {
            return false;
        }
        
        @Override
        public boolean m0(final ChildKey childKey) {
            return false;
        }
        
        @Override
        public String toString() {
            return "<Max Node>";
        }
    };
    
    Node C0();
    
    Node F(final Path p0);
    
    Iterator<NamedNode> F1();
    
    Node L(final Node p0);
    
    ChildKey S0(final ChildKey p0);
    
    Node V(final Path p0, final Node p1);
    
    String a0(final HashVersion p0);
    
    Node c0(final ChildKey p0);
    
    String getHash();
    
    Object getValue();
    
    boolean isEmpty();
    
    int j();
    
    boolean m0(final ChildKey p0);
    
    boolean p1();
    
    Node r0(final ChildKey p0, final Node p1);
    
    Object t0(final boolean p0);
    
    public enum HashVersion
    {
        private static final HashVersion[] $VALUES;
        
        V1, 
        V2;
    }
}
