// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

public class StringNode extends LeafNode<StringNode>
{
    private final String c;
    
    public StringNode(final String c, final Node node) {
        super(node);
        this.c = c;
    }
    
    @Override
    public /* bridge */ Node L(final Node node) {
        return this.p(node);
    }
    
    @Override
    protected /* bridge */ int a(final LeafNode leafNode) {
        return this.o((StringNode)leafNode);
    }
    
    @Override
    public String a0(final HashVersion hashVersion) {
        final int n = StringNode$a.a[hashVersion.ordinal()];
        if (n == 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.m(hashVersion));
            sb.append("string:");
            sb.append(this.c);
            return sb.toString();
        }
        if (n == 2) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(this.m(hashVersion));
            sb2.append("string:");
            sb2.append(Utilities.j(this.c));
            return sb2.toString();
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("Invalid hash version for string node: ");
        sb3.append(hashVersion);
        throw new IllegalArgumentException(sb3.toString());
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof StringNode;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final StringNode stringNode = (StringNode)o;
        boolean b3 = b2;
        if (this.c.equals(stringNode.c)) {
            b3 = b2;
            if (super.a.equals(stringNode.a)) {
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
        return LeafType.String;
    }
    
    protected int o(final StringNode stringNode) {
        return this.c.compareTo(stringNode.c);
    }
    
    public StringNode p(final Node node) {
        return new StringNode(this.c, node);
    }
}
