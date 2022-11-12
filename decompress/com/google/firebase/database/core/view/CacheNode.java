// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.IndexedNode;

public class CacheNode
{
    private final IndexedNode a;
    private final boolean b;
    private final boolean c;
    
    public CacheNode(final IndexedNode a, final boolean b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public IndexedNode a() {
        return this.a;
    }
    
    public Node b() {
        return this.a.k();
    }
    
    public boolean c(final ChildKey childKey) {
        return (this.f() && !this.c) || this.a.k().m0(childKey);
    }
    
    public boolean d(final Path path) {
        if (path.isEmpty()) {
            return this.f() && !this.c;
        }
        return this.c(path.t());
    }
    
    public boolean e() {
        return this.c;
    }
    
    public boolean f() {
        return this.b;
    }
}
