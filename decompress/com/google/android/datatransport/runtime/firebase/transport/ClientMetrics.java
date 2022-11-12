// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.firebase.transport;

import java.util.Collections;
import java.util.ArrayList;
import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.firebase.encoders.annotations.Encodable$Field;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.List;

public final class ClientMetrics
{
    private static final ClientMetrics e;
    private final TimeWindow a;
    private final List<LogSourceMetrics> b;
    private final GlobalMetrics c;
    private final String d;
    
    static {
        e = new Builder().b();
    }
    
    ClientMetrics(final TimeWindow a, final List<LogSourceMetrics> b, final GlobalMetrics c, final String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static Builder e() {
        return new Builder();
    }
    
    @Protobuf(tag = 4)
    public String a() {
        return this.d;
    }
    
    @Encodable$Field
    @Protobuf(tag = 3)
    public GlobalMetrics b() {
        return this.c;
    }
    
    @Encodable$Field
    @Protobuf(tag = 2)
    public List<LogSourceMetrics> c() {
        return this.b;
    }
    
    @Encodable$Field
    @Protobuf(tag = 1)
    public TimeWindow d() {
        return this.a;
    }
    
    public byte[] f() {
        return ProtoEncoderDoNotUse.a(this);
    }
    
    public static final class Builder
    {
        private TimeWindow a;
        private List<LogSourceMetrics> b;
        private GlobalMetrics c;
        private String d;
        
        Builder() {
            this.a = null;
            this.b = new ArrayList<LogSourceMetrics>();
            this.c = null;
            this.d = "";
        }
        
        public Builder a(final LogSourceMetrics logSourceMetrics) {
            this.b.add(logSourceMetrics);
            return this;
        }
        
        public ClientMetrics b() {
            return new ClientMetrics(this.a, Collections.unmodifiableList((List<? extends LogSourceMetrics>)this.b), this.c, this.d);
        }
        
        public Builder c(final String d) {
            this.d = d;
            return this;
        }
        
        public Builder d(final GlobalMetrics c) {
            this.c = c;
            return this;
        }
        
        public Builder e(final TimeWindow a) {
            this.a = a;
            return this;
        }
    }
}
