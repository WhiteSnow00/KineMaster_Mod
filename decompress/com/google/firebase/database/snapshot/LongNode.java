// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

public class LongNode extends LeafNode<LongNode>
{
    private final long c;
    
    public LongNode(final Long n, final Node node) {
        super(node);
        this.c = n;
    }
    
    @Override
    public /* bridge */ Node L(final Node node) {
        return this.p(node);
    }
    
    @Override
    protected /* bridge */ int a(final LeafNode leafNode) {
        return this.o((LongNode)leafNode);
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
        sb2.append(Utilities.c((double)this.c));
        return sb2.toString();
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof LongNode;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final LongNode longNode = (LongNode)o;
        boolean b3 = b2;
        if (this.c == longNode.c) {
            b3 = b2;
            if (super.a.equals(longNode.a)) {
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
        final long c = this.c;
        return (int)(c ^ c >>> 32) + super.a.hashCode();
    }
    
    @Override
    protected LeafType k() {
        return LeafType.Number;
    }
    
    protected int o(final LongNode longNode) {
        return Utilities.b(this.c, longNode.c);
    }
    
    public LongNode p(final Node node) {
        return new LongNode(this.c, node);
    }
}
