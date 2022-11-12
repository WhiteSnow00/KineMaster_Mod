// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class BackendResponse
{
    public static BackendResponse a() {
        return new b(Status.FATAL_ERROR, -1L);
    }
    
    public static BackendResponse d() {
        return new b(Status.INVALID_PAYLOAD, -1L);
    }
    
    public static BackendResponse e(final long n) {
        return new b(Status.OK, n);
    }
    
    public static BackendResponse f() {
        return new b(Status.TRANSIENT_ERROR, -1L);
    }
    
    public abstract long b();
    
    public abstract Status c();
    
    public enum Status
    {
        private static final Status[] $VALUES;
        
        FATAL_ERROR, 
        INVALID_PAYLOAD, 
        OK, 
        TRANSIENT_ERROR;
    }
}
