// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.backends;

import com.google.auto.value.AutoValue$Builder;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class BackendRequest
{
    public static Builder a() {
        return (Builder)new a.b();
    }
    
    public abstract Iterable<EventInternal> b();
    
    public abstract byte[] c();
    
    @AutoValue$Builder
    public abstract static class Builder
    {
        public abstract BackendRequest a();
        
        public abstract Builder b(final Iterable<EventInternal> p0);
        
        public abstract Builder c(final byte[] p0);
    }
}
