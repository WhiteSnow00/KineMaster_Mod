// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

public final class BatchResult implements Result
{
    private final Status a;
    private final PendingResult[] b;
    
    BatchResult(final Status a, final PendingResult[] b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public Status getStatus() {
        return this.a;
    }
}
