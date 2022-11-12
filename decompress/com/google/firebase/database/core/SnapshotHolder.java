// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Node;

public class SnapshotHolder
{
    private Node a;
    
    SnapshotHolder() {
        this.a = EmptyNode.p();
    }
    
    public SnapshotHolder(final Node a) {
        this.a = a;
    }
    
    public Node a(final Path path) {
        return this.a.F(path);
    }
    
    public Node b() {
        return this.a;
    }
    
    public void c(final Path path, final Node node) {
        this.a = this.a.V(path, node);
    }
}
