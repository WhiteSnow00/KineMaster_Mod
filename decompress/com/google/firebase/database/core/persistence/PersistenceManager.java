// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.view.CacheNode;
import java.util.concurrent.Callable;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Set;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.core.UserWriteRecord;
import java.util.List;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;

public interface PersistenceManager
{
    void a(final Path p0, final CompoundWrite p1, final long p2);
    
    List<UserWriteRecord> b();
    
    void c(final long p0);
    
    void d(final Path p0, final Node p1, final long p2);
    
    void e(final QuerySpec p0, final Set<ChildKey> p1);
    
     <T> T f(final Callable<T> p0);
    
    void g(final QuerySpec p0, final Node p1);
    
    void h(final Path p0, final CompoundWrite p1);
    
    CacheNode i(final QuerySpec p0);
    
    void j(final QuerySpec p0, final Set<ChildKey> p1, final Set<ChildKey> p2);
    
    void k(final QuerySpec p0);
    
    void l(final QuerySpec p0);
    
    void m(final QuerySpec p0);
    
    void n(final Path p0, final Node p1);
    
    void o(final Path p0, final CompoundWrite p1);
}
