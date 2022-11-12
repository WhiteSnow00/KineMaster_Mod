// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Response;

@Deprecated
public class CredentialRequestResponse extends Response<CredentialRequestResult>
{
    public Credential k() {
        return this.a().getCredential();
    }
}
