// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.operation;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.core.Path;

public abstract class Operation
{
    protected final OperationType a;
    protected final OperationSource b;
    protected final Path c;
    
    protected Operation(final OperationType a, final OperationSource b, final Path c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public Path a() {
        return this.c;
    }
    
    public OperationSource b() {
        return this.b;
    }
    
    public OperationType c() {
        return this.a;
    }
    
    public abstract Operation d(final ChildKey p0);
    
    public enum OperationType
    {
        private static final OperationType[] $VALUES;
        
        AckUserWrite, 
        ListenComplete, 
        Merge, 
        Overwrite;
    }
}
