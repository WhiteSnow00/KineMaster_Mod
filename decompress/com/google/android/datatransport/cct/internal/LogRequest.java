// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

import com.google.auto.value.AutoValue$Builder;
import com.google.firebase.encoders.annotations.Encodable$Field;
import java.util.List;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LogRequest
{
    public static Builder a() {
        return (Builder)new e.b();
    }
    
    public abstract ClientInfo b();
    
    @Encodable$Field
    public abstract List<LogEvent> c();
    
    public abstract Integer d();
    
    public abstract String e();
    
    public abstract QosTier f();
    
    public abstract long g();
    
    public abstract long h();
    
    @AutoValue$Builder
    public abstract static class Builder
    {
        public abstract LogRequest a();
        
        public abstract Builder b(final ClientInfo p0);
        
        public abstract Builder c(final List<LogEvent> p0);
        
        abstract Builder d(final Integer p0);
        
        abstract Builder e(final String p0);
        
        public abstract Builder f(final QosTier p0);
        
        public abstract Builder g(final long p0);
        
        public abstract Builder h(final long p0);
        
        public Builder i(final int n) {
            return this.d(n);
        }
        
        public Builder j(final String s) {
            return this.e(s);
        }
    }
}
