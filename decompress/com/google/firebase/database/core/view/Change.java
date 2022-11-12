// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;

public class Change
{
    private final Event.EventType a;
    private final IndexedNode b;
    private final IndexedNode c;
    private final ChildKey d;
    private final ChildKey e;
    
    private Change(final Event.EventType a, final IndexedNode b, final ChildKey d, final ChildKey e, final IndexedNode c) {
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
        this.c = c;
    }
    
    public static Change b(final ChildKey childKey, final IndexedNode indexedNode) {
        return new Change(Event.EventType.CHILD_ADDED, indexedNode, childKey, null, null);
    }
    
    public static Change c(final ChildKey childKey, final Node node) {
        return b(childKey, IndexedNode.b(node));
    }
    
    public static Change d(final ChildKey childKey, final IndexedNode indexedNode, final IndexedNode indexedNode2) {
        return new Change(Event.EventType.CHILD_CHANGED, indexedNode, childKey, null, indexedNode2);
    }
    
    public static Change e(final ChildKey childKey, final Node node, final Node node2) {
        return d(childKey, IndexedNode.b(node), IndexedNode.b(node2));
    }
    
    public static Change f(final ChildKey childKey, final IndexedNode indexedNode) {
        return new Change(Event.EventType.CHILD_MOVED, indexedNode, childKey, null, null);
    }
    
    public static Change g(final ChildKey childKey, final IndexedNode indexedNode) {
        return new Change(Event.EventType.CHILD_REMOVED, indexedNode, childKey, null, null);
    }
    
    public static Change h(final ChildKey childKey, final Node node) {
        return g(childKey, IndexedNode.b(node));
    }
    
    public static Change n(final IndexedNode indexedNode) {
        return new Change(Event.EventType.VALUE, indexedNode, null, null, null);
    }
    
    public Change a(final ChildKey childKey) {
        return new Change(this.a, this.b, this.d, childKey, this.c);
    }
    
    public ChildKey i() {
        return this.d;
    }
    
    public Event.EventType j() {
        return this.a;
    }
    
    public IndexedNode k() {
        return this.b;
    }
    
    public IndexedNode l() {
        return this.c;
    }
    
    public ChildKey m() {
        return this.e;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Change: ");
        sb.append(this.a);
        sb.append(" ");
        sb.append(this.d);
        return sb.toString();
    }
}
