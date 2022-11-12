// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;
import com.google.firebase.encoders.annotations.Encodable$Field;

public final class GlobalMetrics
{
    private static final GlobalMetrics b;
    private final StorageMetrics a;
    
    static {
        b = new Builder().a();
    }
    
    GlobalMetrics(final StorageMetrics a) {
        this.a = a;
    }
    
    public static Builder b() {
        return new Builder();
    }
    
    @Encodable$Field
    @Protobuf(tag = 1)
    public StorageMetrics a() {
        return this.a;
    }
    
    public static final class Builder
    {
        private StorageMetrics a;
        
        Builder() {
            this.a = null;
        }
        
        public GlobalMetrics a() {
            return new GlobalMetrics(this.a);
        }
        
        public Builder b(final StorageMetrics a) {
            this.a = a;
            return this;
        }
    }
}
