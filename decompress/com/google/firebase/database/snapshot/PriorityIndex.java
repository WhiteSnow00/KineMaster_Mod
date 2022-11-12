// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

public class PriorityIndex extends Index
{
    private static final PriorityIndex a;
    
    static {
        a = new PriorityIndex();
    }
    
    private PriorityIndex() {
    }
    
    public static PriorityIndex j() {
        return PriorityIndex.a;
    }
    
    @Override
    public String c() {
        throw new IllegalArgumentException("Can't get query definition on priority index!");
    }
    
    @Override
    public /* bridge */ int compare(final Object o, final Object o2) {
        return this.i((NamedNode)o, (NamedNode)o2);
    }
    
    @Override
    public boolean e(final Node node) {
        return node.C0().isEmpty() ^ true;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof PriorityIndex;
    }
    
    @Override
    public NamedNode f(final ChildKey childKey, final Node node) {
        return new NamedNode(childKey, new StringNode("[PRIORITY-POST]", node));
    }
    
    @Override
    public NamedNode g() {
        return this.f(ChildKey.g(), Node.q);
    }
    
    @Override
    public int hashCode() {
        return 3155577;
    }
    
    public int i(final NamedNode namedNode, final NamedNode namedNode2) {
        return NodeUtilities.c(namedNode.c(), namedNode.d().C0(), namedNode2.c(), namedNode2.d().C0());
    }
    
    @Override
    public String toString() {
        return "PriorityIndex";
    }
}
