// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.GoogleApiClient;

@Deprecated
public interface CredentialsApi
{
    PendingResult<Status> delete(final GoogleApiClient p0, final Credential p1);
    
    PendingResult<Status> disableAutoSignIn(final GoogleApiClient p0);
    
    PendingResult<CredentialRequestResult> request(final GoogleApiClient p0, final CredentialRequest p1);
    
    PendingResult<Status> save(final GoogleApiClient p0, final Credential p1);
}
