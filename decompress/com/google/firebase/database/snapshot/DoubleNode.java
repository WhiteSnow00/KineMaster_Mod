// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

public class DoubleNode extends LeafNode<DoubleNode>
{
    private final Double c;
    
    public DoubleNode(final Double c, final Node node) {
        super(node);
        this.c = c;
    }
    
    @Override
    public /* bridge */ Node L(final Node node) {
        return this.p(node);
    }
    
    @Override
    protected /* bridge */ int a(final LeafNode leafNode) {
        return this.o((DoubleNode)leafNode);
    }
    
    @Override
    public String a0(final HashVersion hashVersion) {
        final String m = this.m(hashVersion);
        final StringBuilder sb = new StringBuilder();
        sb.append(m);
        sb.append("number:");
        final String string = sb.toString();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append(Utilities.c(this.c));
        return sb2.toString();
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof DoubleNode;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final DoubleNode doubleNode = (DoubleNode)o;
        boolean b3 = b2;
        if (this.c.equals(doubleNode.c)) {
            b3 = b2;
            if (super.a.equals(doubleNode.a)) {
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
        return this.c.hashCode() + super.a.hashCode();
    }
    
    @Override
    protected LeafType k() {
        return LeafType.Number;
    }
    
    protected int o(final DoubleNode doubleNode) {
        return this.c.compareTo(doubleNode.c);
    }
    
    public DoubleNode p(final Node node) {
        Utilities.f(PriorityUtilities.b(node));
        return new DoubleNode(this.c, node);
    }
}
