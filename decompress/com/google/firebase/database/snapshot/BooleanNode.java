// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

public class BooleanNode extends LeafNode<BooleanNode>
{
    private final boolean c;
    
    public BooleanNode(final Boolean b, final Node node) {
        super(node);
        this.c = b;
    }
    
    @Override
    public /* bridge */ Node L(final Node node) {
        return this.p(node);
    }
    
    @Override
    protected /* bridge */ int a(final LeafNode leafNode) {
        return this.o((BooleanNode)leafNode);
    }
    
    @Override
    public String a0(final HashVersion hashVersion) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.m(hashVersion));
        sb.append("boolean:");
        sb.append(this.c);
        return sb.toString();
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof BooleanNode;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final BooleanNode booleanNode = (BooleanNode)o;
        boolean b3 = b2;
        if (this.c == booleanNode.c) {
            b3 = b2;
            if (super.a.equals(booleanNode.a)) {
                b3 = true;
            }
        }
        return b3;
    }
    
    @Override
    public Object getValue() {
        return this.c;
    }
    
    @Override
    public int hashCode() {
        return (this.c ? 1 : 0) + super.a.hashCode();
    }
    
    @Override
    protected LeafType k() {
        return LeafType.Boolean;
    }
    
    protected int o(final BooleanNode booleanNode) {
        final boolean c = this.c;
        int n;
        if (c == booleanNode.c) {
            n = 0;
        }
        else if (c) {
            n = 1;
        }
        else {
            n = -1;
        }
        return n;
    }
    
    public BooleanNode p(final Node node) {
        return new BooleanNode(this.c, node);
    }
}
