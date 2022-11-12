// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.operation;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.CompoundWrite;

public class Merge extends Operation
{
    private final CompoundWrite d;
    
    public Merge(final OperationSource operationSource, final Path path, final CompoundWrite d) {
        super(OperationType.Merge, operationSource, path);
        this.d = d;
    }
    
    @Override
    public Operation d(final ChildKey childKey) {
        if (super.c.isEmpty()) {
            final CompoundWrite k = this.d.k(new Path(new ChildKey[] { childKey }));
            if (k.isEmpty()) {
                return null;
            }
            if (k.x() != null) {
                return new Overwrite(super.b, Path.s(), k.x());
            }
            return new Merge(super.b, Path.s(), k);
        }
        else {
            if (super.c.t().equals(childKey)) {
                return new Merge(super.b, super.c.y(), this.d);
            }
            return null;
        }
    }
    
    public CompoundWrite e() {
        return this.d;
    }
    
    @Override
    public String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", this.a(), this.b(), this.d);
    }
}
