// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

public final class LogEventDropped
{
    private static final LogEventDropped c;
    private final long a;
    private final Reason b;
    
    static {
        c = new Builder().a();
    }
    
    LogEventDropped(final long a, final Reason b) {
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
    
    @Protobuf(tag = 3)
    public Reason b() {
        return this.b;
    }
    
    public static final class Builder
    {
        private long a;
        private Reason b;
        
        Builder() {
            this.a = 0L;
            this.b = Reason.REASON_UNKNOWN;
        }
        
        public LogEventDropped a() {
            return new LogEventDropped(this.a, this.b);
        }
        
        public Builder b(final long a) {
            this.a = a;
            return this;
        }
        
        public Builder c(final Reason b) {
            this.b = b;
            return this;
        }
    }
    
    public enum Reason implements ProtoEnum
    {
        private static final Reason[] $VALUES;
        
        CACHE_FULL(2), 
        INVALID_PAYLOD(5), 
        MAX_RETRIES_REACHED(4), 
        MESSAGE_TOO_OLD(1), 
        PAYLOAD_TOO_BIG(3), 
        REASON_UNKNOWN(0), 
        SERVER_ERROR(6);
        
        private final int number_;
        
        private Reason(final int number_) {
            this.number_ = number_;
        }
        
        public int getNumber() {
            return this.number_;
        }
    }
}
