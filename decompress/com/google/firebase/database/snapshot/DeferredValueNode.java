// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import java.util.Map;

public class DeferredValueNode extends LeafNode<DeferredValueNode>
{
    private Map<Object, Object> c;
    
    public DeferredValueNode(final Map<Object, Object> c, final Node node) {
        super(node);
        this.c = c;
    }
    
    @Override
    public /* bridge */ Node L(final Node node) {
        return this.p(node);
    }
    
    @Override
    protected /* bridge */ int a(final LeafNode leafNode) {
        return this.o((DeferredValueNode)leafNode);
    }
    
    @Override
    public String a0(final HashVersion hashVersion) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.m(hashVersion));
        sb.append("deferredValue:");
        sb.append(this.c);
        return sb.toString();
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof DeferredValueNode;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final DeferredValueNode deferredValueNode = (DeferredValueNode)o;
        boolean b3 = b2;
        if (this.c.equals(deferredValueNode.c)) {
            b3 = b2;
            if (super.a.equals(deferredValueNode.a)) {
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
        return LeafType.DeferredValue;
    }
    
    protected int o(final DeferredValueNode deferredValueNode) {
        return 0;
    }
    
    public DeferredValueNode p(final Node node) {
        Utilities.f(PriorityUtilities.b(node));
        return new DeferredValueNode(this.c, node);
    }
}
