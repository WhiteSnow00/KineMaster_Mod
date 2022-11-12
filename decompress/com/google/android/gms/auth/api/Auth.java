// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api;

import com.google.android.gms.common.internal.Objects;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.internal.zbd;
import com.google.android.gms.internal.auth_api.zbl;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

public final class Auth
{
    @Deprecated
    @KeepForSdk
    @ShowFirstParty
    public static final Api<AuthProxyOptions> a;
    public static final Api<AuthCredentialsOptions> b;
    public static final Api<GoogleSignInOptions> c;
    @Deprecated
    @KeepForSdk
    @ShowFirstParty
    public static final ProxyApi d;
    public static final CredentialsApi e;
    public static final GoogleSignInApi f;
    public static final Api.ClientKey g;
    public static final Api.ClientKey h;
    private static final Api.AbstractClientBuilder i;
    private static final Api.AbstractClientBuilder j;
    
    static {
        final Api.ClientKey clientKey = g = new Api.ClientKey();
        final Api.ClientKey clientKey2 = h = new Api.ClientKey();
        final Api.AbstractClientBuilder abstractClientBuilder = i = new a();
        final Api.AbstractClientBuilder abstractClientBuilder2 = j = new b();
        a = AuthProxy.a;
        b = new Api<AuthCredentialsOptions>("Auth.CREDENTIALS_API", abstractClientBuilder, clientKey);
        c = new Api<GoogleSignInOptions>("Auth.GOOGLE_SIGN_IN_API", abstractClientBuilder2, clientKey2);
        d = AuthProxy.b;
        e = (CredentialsApi)new zbl();
        f = new zbd();
    }
    
    private Auth() {
    }
    
    @Deprecated
    public static class AuthCredentialsOptions implements Optional
    {
        public static final AuthCredentialsOptions d;
        private final String a;
        private final boolean b;
        private final String c;
        
        static {
            d = new AuthCredentialsOptions(new Builder());
        }
        
        public AuthCredentialsOptions(final Builder builder) {
            this.a = null;
            this.b = builder.a;
            this.c = builder.b;
        }
        
        static /* bridge */ String b(final AuthCredentialsOptions authCredentialsOptions) {
            final String a = authCredentialsOptions.a;
            return null;
        }
        
        static /* bridge */ String c(final AuthCredentialsOptions authCredentialsOptions) {
            return authCredentialsOptions.c;
        }
        
        static /* bridge */ boolean e(final AuthCredentialsOptions authCredentialsOptions) {
            return authCredentialsOptions.b;
        }
        
        public final Bundle a() {
            final Bundle bundle = new Bundle();
            bundle.putString("consumer_package", (String)null);
            bundle.putBoolean("force_save_dialog", this.b);
            bundle.putString("log_session_id", this.c);
            return bundle;
        }
        
        public final String d() {
            return this.c;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof AuthCredentialsOptions)) {
                return false;
            }
            final AuthCredentialsOptions authCredentialsOptions = (AuthCredentialsOptions)o;
            final String a = authCredentialsOptions.a;
            return Objects.b(null, null) && this.b == authCredentialsOptions.b && Objects.b(this.c, authCredentialsOptions.c);
        }
        
        @Override
        public int hashCode() {
            return Objects.c(null, this.b, this.c);
        }
        
        @Deprecated
        public static class Builder
        {
            protected Boolean a;
            protected String b;
            
            public Builder() {
                this.a = Boolean.FALSE;
            }
            
            @ShowFirstParty
            public Builder(final AuthCredentialsOptions authCredentialsOptions) {
                this.a = Boolean.FALSE;
                AuthCredentialsOptions.b(authCredentialsOptions);
                this.a = AuthCredentialsOptions.e(authCredentialsOptions);
                this.b = AuthCredentialsOptions.c(authCredentialsOptions);
            }
            
            @ShowFirstParty
            public final Builder a(final String b) {
                this.b = b;
                return this;
            }
        }
    }
}
