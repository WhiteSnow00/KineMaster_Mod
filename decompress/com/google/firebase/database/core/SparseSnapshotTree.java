// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import java.util.Iterator;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Map;
import com.google.firebase.database.snapshot.Node;

class SparseSnapshotTree
{
    private Node a;
    private Map<ChildKey, SparseSnapshotTree> b;
    
    public SparseSnapshotTree() {
        this.a = null;
        this.b = null;
    }
    
    public void a(final SparseSnapshotChildVisitor sparseSnapshotChildVisitor) {
        final Map<ChildKey, SparseSnapshotTree> b = this.b;
        if (b != null) {
            for (final Map.Entry entry : b.entrySet()) {
                sparseSnapshotChildVisitor.a((ChildKey)entry.getKey(), (SparseSnapshotTree)entry.getValue());
            }
        }
    }
    
    public void b(final Path path, final SparseSnapshotTreeVisitor sparseSnapshotTreeVisitor) {
        final Node a = this.a;
        if (a != null) {
            sparseSnapshotTreeVisitor.a(path, a);
        }
        else {
            this.a((SparseSnapshotChildVisitor)new SparseSnapshotChildVisitor(this, path, sparseSnapshotTreeVisitor) {
                final Path a;
                final SparseSnapshotTreeVisitor b;
                final SparseSnapshotTree c;
                
                @Override
                public void a(final ChildKey childKey, final SparseSnapshotTree sparseSnapshotTree) {
                    sparseSnapshotTree.b(this.a.n(childKey), this.b);
                }
            });
        }
    }
    
    public interface SparseSnapshotChildVisitor
    {
        void a(final ChildKey p0, final SparseSnapshotTree p1);
    }
    
    public interface SparseSnapshotTreeVisitor
    {
        void a(final Path p0, final Node p1);
    }
}
