// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Result;

@Deprecated
public interface CredentialRequestResult extends Result
{
    Credential getCredential();
}
