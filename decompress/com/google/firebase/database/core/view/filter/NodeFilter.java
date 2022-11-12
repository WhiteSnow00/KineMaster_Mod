// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Index;

public interface NodeFilter
{
    Index h();
    
    NodeFilter i();
    
    IndexedNode j(final IndexedNode p0, final Node p1);
    
    IndexedNode k(final IndexedNode p0, final ChildKey p1, final Node p2, final Path p3, final CompleteChildSource p4, final ChildChangeAccumulator p5);
    
    boolean l();
    
    IndexedNode m(final IndexedNode p0, final IndexedNode p1, final ChildChangeAccumulator p2);
    
    public interface CompleteChildSource
    {
        Node a(final ChildKey p0);
        
        NamedNode b(final Index p0, final NamedNode p1, final boolean p2);
    }
}
