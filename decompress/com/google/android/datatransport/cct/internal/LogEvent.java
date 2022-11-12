// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

import com.google.auto.value.AutoValue$Builder;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LogEvent
{
    private static Builder a() {
        return (Builder)new d.b();
    }
    
    public static Builder i(final String s) {
        return a().g(s);
    }
    
    public static Builder j(final byte[] array) {
        return a().f(array);
    }
    
    public abstract Integer b();
    
    public abstract long c();
    
    public abstract long d();
    
    public abstract NetworkConnectionInfo e();
    
    public abstract byte[] f();
    
    public abstract String g();
    
    public abstract long h();
    
    @AutoValue$Builder
    public abstract static class Builder
    {
        public abstract LogEvent a();
        
        public abstract Builder b(final Integer p0);
        
        public abstract Builder c(final long p0);
        
        public abstract Builder d(final long p0);
        
        public abstract Builder e(final NetworkConnectionInfo p0);
        
        abstract Builder f(final byte[] p0);
        
        abstract Builder g(final String p0);
        
        public abstract Builder h(final long p0);
    }
}
