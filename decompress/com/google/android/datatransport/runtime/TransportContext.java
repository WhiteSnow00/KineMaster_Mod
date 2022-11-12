// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.auto.value.AutoValue$Builder;
import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TransportContext
{
    public static Builder a() {
        return new c.b().d(Priority.DEFAULT);
    }
    
    public abstract String b();
    
    public abstract byte[] c();
    
    public abstract Priority d();
    
    public boolean e() {
        return this.c() != null;
    }
    
    public TransportContext f(final Priority priority) {
        return a().b(this.b()).d(priority).c(this.c()).a();
    }
    
    @Override
    public final String toString() {
        final String b = this.b();
        final Priority d = this.d();
        String encodeToString;
        if (this.c() == null) {
            encodeToString = "";
        }
        else {
            encodeToString = Base64.encodeToString(this.c(), 2);
        }
        return String.format("TransportContext(%s, %s, %s)", b, d, encodeToString);
    }
    
    @AutoValue$Builder
    public abstract static class Builder
    {
        public abstract TransportContext a();
        
        public abstract Builder b(final String p0);
        
        public abstract Builder c(final byte[] p0);
        
        public abstract Builder d(final Priority p0);
    }
}
