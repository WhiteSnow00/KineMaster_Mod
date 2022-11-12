// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.firebase.transport;

import java.util.Collections;
import java.util.ArrayList;
import com.google.firebase.encoders.proto.Protobuf;
import com.google.firebase.encoders.annotations.Encodable$Field;
import java.util.List;

public final class LogSourceMetrics
{
    private static final LogSourceMetrics c;
    private final String a;
    private final List<LogEventDropped> b;
    
    static {
        c = new Builder().a();
    }
    
    LogSourceMetrics(final String a, final List<LogEventDropped> b) {
        this.a = a;
        this.b = b;
    }
    
    public static Builder c() {
        return new Builder();
    }
    
    @Encodable$Field
    @Protobuf(tag = 2)
    public List<LogEventDropped> a() {
        return this.b;
    }
    
    @Protobuf(tag = 1)
    public String b() {
        return this.a;
    }
    
    public static final class Builder
    {
        private String a;
        private List<LogEventDropped> b;
        
        Builder() {
            this.a = "";
            this.b = new ArrayList<LogEventDropped>();
        }
        
        public LogSourceMetrics a() {
            return new LogSourceMetrics(this.a, Collections.unmodifiableList((List<? extends LogEventDropped>)this.b));
        }
        
        public Builder b(final List<LogEventDropped> b) {
            this.b = b;
            return this;
        }
        
        public Builder c(final String a) {
            this.a = a;
            return this;
        }
    }
}
