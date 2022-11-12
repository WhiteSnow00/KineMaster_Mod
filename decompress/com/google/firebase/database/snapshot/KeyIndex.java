// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

public class KeyIndex extends Index
{
    private static final KeyIndex a;
    
    static {
        a = new KeyIndex();
    }
    
    private KeyIndex() {
    }
    
    public static KeyIndex j() {
        return KeyIndex.a;
    }
    
    @Override
    public String c() {
        return ".key";
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
        return o instanceof KeyIndex;
    }
    
    @Override
    public NamedNode f(final ChildKey childKey, final Node node) {
        Utilities.f(node instanceof StringNode);
        return new NamedNode(ChildKey.f((String)node.getValue()), EmptyNode.p());
    }
    
    @Override
    public NamedNode g() {
        return NamedNode.a();
    }
    
    @Override
    public int hashCode() {
        return 37;
    }
    
    public int i(final NamedNode namedNode, final NamedNode namedNode2) {
        return namedNode.c().d(namedNode2.c());
    }
    
    @Override
    public String toString() {
        return "KeyIndex";
    }
}
