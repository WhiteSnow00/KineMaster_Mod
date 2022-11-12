// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;

public class AckUserWrite extends Operation
{
    private final boolean d;
    private final ImmutableTree<Boolean> e;
    
    public AckUserWrite(final Path path, final ImmutableTree<Boolean> e, final boolean d) {
        super(OperationType.AckUserWrite, OperationSource.d, path);
        this.e = e;
        this.d = d;
    }
    
    @Override
    public Operation d(final ChildKey childKey) {
        if (!super.c.isEmpty()) {
            Utilities.g(super.c.t().equals(childKey), "operationForChild called for unrelated child.");
            return new AckUserWrite(super.c.y(), this.e, this.d);
        }
        if (this.e.getValue() != null) {
            Utilities.g(this.e.p().isEmpty(), "affectedTree should not have overlapping affected paths.");
            return this;
        }
        return new AckUserWrite(Path.s(), this.e.y(new Path(new ChildKey[] { childKey })), this.d);
    }
    
    public ImmutableTree<Boolean> e() {
        return this.e;
    }
    
    public boolean f() {
        return this.d;
    }
    
    @Override
    public String toString() {
        return String.format("AckUserWrite { path=%s, revert=%s, affectedTree=%s }", this.a(), this.d, this.e);
    }
}
