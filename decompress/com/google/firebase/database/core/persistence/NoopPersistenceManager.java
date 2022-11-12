// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.persistence;

import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.core.view.CacheNode;
import android.util.Log;
import java.util.concurrent.Callable;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Set;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import com.google.firebase.database.core.UserWriteRecord;
import java.util.List;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;

public class NoopPersistenceManager implements PersistenceManager
{
    private boolean a;
    
    public NoopPersistenceManager() {
        this.a = false;
    }
    
    private void p() {
        Utilities.g(this.a, "Transaction expected to already be in progress.");
    }
    
    @Override
    public void a(final Path path, final CompoundWrite compoundWrite, final long n) {
        this.p();
    }
    
    @Override
    public List<UserWriteRecord> b() {
        return Collections.emptyList();
    }
    
    @Override
    public void c(final long n) {
        this.p();
    }
    
    @Override
    public void d(final Path path, final Node node, final long n) {
        this.p();
    }
    
    @Override
    public void e(final QuerySpec querySpec, final Set<ChildKey> set) {
        this.p();
    }
    
    @Override
    public <T> T f(final Callable<T> callable) {
        Utilities.g(this.a ^ true, "runInTransaction called when an existing transaction is already in progress.");
        this.a = true;
        try {
            final T call = callable.call();
            this.a = false;
            return call;
        }
        finally {
            try {
                final Throwable t;
                Log.e("NoopPersistenceManager", "Caught Throwable.", t);
                throw new RuntimeException(t);
            }
            finally {
                this.a = false;
            }
        }
    }
    
    @Override
    public void g(final QuerySpec querySpec, final Node node) {
        this.p();
    }
    
    @Override
    public void h(final Path path, final CompoundWrite compoundWrite) {
        this.p();
    }
    
    @Override
    public CacheNode i(final QuerySpec querySpec) {
        return new CacheNode(IndexedNode.e(EmptyNode.p(), querySpec.c()), false, false);
    }
    
    @Override
    public void j(final QuerySpec querySpec, final Set<ChildKey> set, final Set<ChildKey> set2) {
        this.p();
    }
    
    @Override
    public void k(final QuerySpec querySpec) {
        this.p();
    }
    
    @Override
    public void l(final QuerySpec querySpec) {
        this.p();
    }
    
    @Override
    public void m(final QuerySpec querySpec) {
        this.p();
    }
    
    @Override
    public void n(final Path path, final Node node) {
        this.p();
    }
    
    @Override
    public void o(final Path path, final CompoundWrite compoundWrite) {
        this.p();
    }
}
