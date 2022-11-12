// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

import com.google.auto.value.AutoValue$Builder;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ClientInfo
{
    public static Builder a() {
        return (Builder)new c.b();
    }
    
    public abstract AndroidClientInfo b();
    
    public abstract ClientType c();
    
    @AutoValue$Builder
    public abstract static class Builder
    {
        public abstract ClientInfo a();
        
        public abstract Builder b(final AndroidClientInfo p0);
        
        public abstract Builder c(final ClientType p0);
    }
    
    public enum ClientType
    {
        private static final ClientType[] $VALUES;
        
        ANDROID_FIREBASE(23), 
        UNKNOWN(0);
        
        private final int value;
        
        private ClientType(final int value) {
            this.value = value;
        }
    }
}
