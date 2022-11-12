// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

public class ValueIndex extends Index
{
    private static final ValueIndex a;
    
    static {
        a = new ValueIndex();
    }
    
    private ValueIndex() {
    }
    
    public static ValueIndex j() {
        return ValueIndex.a;
    }
    
    @Override
    public String c() {
        return ".value";
    }
    
    @Override
    public /* bridge */ int compare(final Object o, final Object o2) {
        return this.i((NamedNode)o, (NamedNode)o2);
    }
    
    @Override
    public boolean e(final Node node) {
        return true;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof ValueIndex;
    }
    
    @Override
    public NamedNode f(final ChildKey childKey, final Node node) {
        return new NamedNode(childKey, node);
    }
    
    @Override
    public NamedNode g() {
        return new NamedNode(ChildKey.g(), Node.q);
    }
    
    @Override
    public int hashCode() {
        return 4;
    }
    
    public int i(final NamedNode namedNode, final NamedNode namedNode2) {
        final int compareTo = namedNode.d().compareTo(namedNode2.d());
        if (compareTo == 0) {
            return namedNode.c().d(namedNode2.c());
        }
        return compareTo;
    }
    
    @Override
    public String toString() {
        return "ValueIndex";
    }
}
