// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.CompoundWrite;
import java.util.List;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Set;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.core.Path;

public interface PersistenceStorageEngine
{
    Node A(final Path p0);
    
    void B(final long p0, final Set<ChildKey> p1);
    
    void C(final Path p0, final Node p1);
    
    List<TrackedQuery> D();
    
    void E(final long p0, final Set<ChildKey> p1, final Set<ChildKey> p2);
    
    void a(final Path p0, final CompoundWrite p1, final long p2);
    
    List<UserWriteRecord> b();
    
    void c(final long p0);
    
    void d(final Path p0, final Node p1, final long p2);
    
    void m();
    
    void p();
    
    void q();
    
    void r(final long p0);
    
    void s(final Path p0, final CompoundWrite p1);
    
    Set<ChildKey> t(final Set<Long> p0);
    
    void u(final long p0);
    
    void v(final Path p0, final Node p1);
    
    void w(final TrackedQuery p0);
    
    long x();
    
    void y(final Path p0, final PruneForest p1);
    
    Set<ChildKey> z(final long p0);
}
