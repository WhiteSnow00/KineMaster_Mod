// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.Auth;

@Deprecated
public final class CredentialsOptions extends AuthCredentialsOptions
{
    public static final CredentialsOptions e;
    
    static {
        e = new Builder().b();
    }
    
    CredentialsOptions(final Builder builder, final zbd zbd) {
        super((AuthCredentialsOptions.Builder)builder);
    }
    
    public static final class Builder extends AuthCredentialsOptions.Builder
    {
        public CredentialsOptions b() {
            return new CredentialsOptions(this, null);
        }
        
        public Builder c() {
            super.a = Boolean.TRUE;
            return this;
        }
    }
}
