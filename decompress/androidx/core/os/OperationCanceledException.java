// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import androidx.core.util.c;

public class OperationCanceledException extends RuntimeException
{
    public OperationCanceledException() {
        this((String)null);
    }
    
    public OperationCanceledException(final String s) {
        super(c.e(s, "The operation has been canceled."));
    }
}
