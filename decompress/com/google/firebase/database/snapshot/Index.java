// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import java.util.Comparator;

public abstract class Index implements Comparator<NamedNode>
{
    public static Index b(final String s) {
        if (s.equals(".value")) {
            return ValueIndex.j();
        }
        if (s.equals(".key")) {
            return KeyIndex.j();
        }
        if (!s.equals(".priority")) {
            return new PathIndex(new Path(s));
        }
        throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
    }
    
    public int a(final NamedNode namedNode, final NamedNode namedNode2, final boolean b) {
        if (b) {
            return this.compare(namedNode2, namedNode);
        }
        return this.compare(namedNode, namedNode2);
    }
    
    public abstract String c();
    
    public boolean d(final Node node, final Node node2) {
        return this.compare(new NamedNode(ChildKey.h(), node), new NamedNode(ChildKey.h(), node2)) != 0;
    }
    
    public abstract boolean e(final Node p0);
    
    public abstract NamedNode f(final ChildKey p0, final Node p1);
    
    public abstract NamedNode g();
    
    public NamedNode h() {
        return NamedNode.b();
    }
}
