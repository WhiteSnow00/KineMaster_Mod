// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.auto.value.AutoValue$Builder;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Encoding;
import com.google.auto.value.AutoValue;

@AutoValue
abstract class SendRequest
{
    public static Builder a() {
        return (Builder)new b.b();
    }
    
    public abstract Encoding b();
    
    abstract Event<?> c();
    
    public byte[] d() {
        return this.e().apply(this.c().b());
    }
    
    abstract Transformer<?, byte[]> e();
    
    public abstract TransportContext f();
    
    public abstract String g();
    
    @AutoValue$Builder
    public abstract static class Builder
    {
        public abstract SendRequest a();
        
        abstract Builder b(final Encoding p0);
        
        abstract Builder c(final Event<?> p0);
        
        abstract Builder d(final Transformer<?, byte[]> p0);
        
        public abstract Builder e(final TransportContext p0);
        
        public abstract Builder f(final String p0);
    }
}
