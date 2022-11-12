// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.operation;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.Node;

public class Overwrite extends Operation
{
    private final Node d;
    
    public Overwrite(final OperationSource operationSource, final Path path, final Node d) {
        super(OperationType.Overwrite, operationSource, path);
        this.d = d;
    }
    
    @Override
    public Operation d(final ChildKey childKey) {
        if (super.c.isEmpty()) {
            return new Overwrite(super.b, Path.s(), this.d.c0(childKey));
        }
        return new Overwrite(super.b, super.c.y(), this.d);
    }
    
    public Node e() {
        return this.d;
    }
    
    @Override
    public String toString() {
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", this.a(), this.b(), this.d);
    }
}
