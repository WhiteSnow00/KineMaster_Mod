// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.NamedNode;
import java.util.List;
import java.util.Collections;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.snapshot.ChildKey;

public class WriteTreeRef
{
    private final Path a;
    private final WriteTree b;
    
    public WriteTreeRef(final Path a, final WriteTree b) {
        this.a = a;
        this.b = b;
    }
    
    public Node a(final ChildKey childKey, final CacheNode cacheNode) {
        return this.b.c(this.a, childKey, cacheNode);
    }
    
    public Node b(final Node node) {
        return this.c(node, Collections.emptyList());
    }
    
    public Node c(final Node node, final List<Long> list) {
        return this.d(node, list, false);
    }
    
    public Node d(final Node node, final List<Long> list, final boolean b) {
        return this.b.d(this.a, node, list, b);
    }
    
    public Node e(final Node node) {
        return this.b.e(this.a, node);
    }
    
    public Node f(final Path path, final Node node, final Node node2) {
        return this.b.f(this.a, path, node, node2);
    }
    
    public NamedNode g(final Node node, final NamedNode namedNode, final boolean b, final Index index) {
        return this.b.g(this.a, node, namedNode, b, index);
    }
    
    public WriteTreeRef h(final ChildKey childKey) {
        return new WriteTreeRef(this.a.n(childKey), this.b);
    }
    
    public Node i(final Path path) {
        return this.b.n(this.a.m(path));
    }
}
