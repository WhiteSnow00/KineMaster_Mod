// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.operation;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.Path;

public class ListenComplete extends Operation
{
    public ListenComplete(final OperationSource operationSource, final Path path) {
        super(OperationType.ListenComplete, operationSource, path);
        Utilities.g(operationSource.d() ^ true, "Can't have a listen complete from a user source");
    }
    
    @Override
    public Operation d(final ChildKey childKey) {
        if (super.c.isEmpty()) {
            return new ListenComplete(super.b, Path.s());
        }
        return new ListenComplete(super.b, super.c.y());
    }
    
    @Override
    public String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", this.a(), this.b());
    }
}
