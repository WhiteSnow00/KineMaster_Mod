// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

public final class NamedNode
{
    private static final NamedNode c;
    private static final NamedNode d;
    private final ChildKey a;
    private final Node b;
    
    static {
        c = new NamedNode(ChildKey.h(), EmptyNode.p());
        d = new NamedNode(ChildKey.g(), Node.q);
    }
    
    public NamedNode(final ChildKey a, final Node b) {
        this.a = a;
        this.b = b;
    }
    
    public static NamedNode a() {
        return NamedNode.d;
    }
    
    public static NamedNode b() {
        return NamedNode.c;
    }
    
    public ChildKey c() {
        return this.a;
    }
    
    public Node d() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && NamedNode.class == o.getClass()) {
            final NamedNode namedNode = (NamedNode)o;
            return this.a.equals(namedNode.a) && this.b.equals(namedNode.b);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode() * 31 + this.b.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("NamedNode{name=");
        sb.append(this.a);
        sb.append(", node=");
        sb.append(this.b);
        sb.append('}');
        return sb.toString();
    }
}
