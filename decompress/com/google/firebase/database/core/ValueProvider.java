// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import java.util.List;
import java.util.ArrayList;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.ChildKey;

abstract class ValueProvider
{
    public abstract ValueProvider a(final ChildKey p0);
    
    public abstract Node b();
    
    public static class DeferredValueProvider extends ValueProvider
    {
        private final SyncTree a;
        private final Path b;
        
        DeferredValueProvider(final SyncTree a, final Path b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public ValueProvider a(final ChildKey childKey) {
            return new DeferredValueProvider(this.a, this.b.n(childKey));
        }
        
        @Override
        public Node b() {
            return this.a.I(this.b, new ArrayList<Long>());
        }
    }
    
    public static class ExistingValueProvider extends ValueProvider
    {
        private final Node a;
        
        ExistingValueProvider(final Node a) {
            this.a = a;
        }
        
        @Override
        public ValueProvider a(final ChildKey childKey) {
            return new ExistingValueProvider(this.a.c0(childKey));
        }
        
        @Override
        public Node b() {
            return this.a;
        }
    }
}
