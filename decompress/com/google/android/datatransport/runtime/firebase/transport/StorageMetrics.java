// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

public final class StorageMetrics
{
    private static final StorageMetrics c;
    private final long a;
    private final long b;
    
    static {
        c = new Builder().a();
    }
    
    StorageMetrics(final long a, final long b) {
        this.a = a;
        this.b = b;
    }
    
    public static Builder c() {
        return new Builder();
    }
    
    @Protobuf(tag = 1)
    public long a() {
        return this.a;
    }
    
    @Protobuf(tag = 2)
    public long b() {
        return this.b;
    }
    
    public static final class Builder
    {
        private long a;
        private long b;
        
        Builder() {
            this.a = 0L;
            this.b = 0L;
        }
        
        public StorageMetrics a() {
            return new StorageMetrics(this.a, this.b);
        }
        
        public Builder b(final long a) {
            this.a = a;
            return this;
        }
        
        public Builder c(final long b) {
            this.b = b;
            return this;
        }
    }
}
