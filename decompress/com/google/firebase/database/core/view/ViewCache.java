// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

public class ViewCache
{
    private final CacheNode a;
    private final CacheNode b;
    
    public ViewCache(final CacheNode a, final CacheNode b) {
        this.a = a;
        this.b = b;
    }
    
    public Node a() {
        Node b;
        if (this.a.f()) {
            b = this.a.b();
        }
        else {
            b = null;
        }
        return b;
    }
    
    public Node b() {
        Node b;
        if (this.b.f()) {
            b = this.b.b();
        }
        else {
            b = null;
        }
        return b;
    }
    
    public CacheNode c() {
        return this.a;
    }
    
    public CacheNode d() {
        return this.b;
    }
    
    public ViewCache e(final IndexedNode indexedNode, final boolean b, final boolean b2) {
        return new ViewCache(new CacheNode(indexedNode, b, b2), this.b);
    }
    
    public ViewCache f(final IndexedNode indexedNode, final boolean b, final boolean b2) {
        return new ViewCache(this.a, new CacheNode(indexedNode, b, b2));
    }
}
