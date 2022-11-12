// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.IndexedNode;

public class InternalHelpers
{
    public static DataSnapshot a(final DatabaseReference databaseReference, final IndexedNode indexedNode) {
        return new DataSnapshot(databaseReference, indexedNode);
    }
    
    public static MutableData b(final Node node) {
        return new MutableData(node);
    }
    
    public static DatabaseReference c(final Repo repo, final Path path) {
        return new DatabaseReference(repo, path);
    }
}
