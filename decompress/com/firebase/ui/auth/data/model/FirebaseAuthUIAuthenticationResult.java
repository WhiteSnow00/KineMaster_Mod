// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.model;

import com.firebase.ui.auth.IdpResponse;

public class FirebaseAuthUIAuthenticationResult
{
    private final IdpResponse idpResponse;
    private final Integer resultCode;
    
    public FirebaseAuthUIAuthenticationResult(final Integer resultCode, final IdpResponse idpResponse) {
        this.idpResponse = idpResponse;
        this.resultCode = resultCode;
    }
    
    public IdpResponse getIdpResponse() {
        return this.idpResponse;
    }
    
    public Integer getResultCode() {
        return this.resultCode;
    }
    
    @Override
    public int hashCode() {
        final IdpResponse idpResponse = this.idpResponse;
        int hashCode;
        if (idpResponse == null) {
            hashCode = 0;
        }
        else {
            hashCode = idpResponse.hashCode();
        }
        return hashCode * 31 + this.resultCode.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FirebaseAuthUIAuthenticationResult{idpResponse=");
        sb.append(this.idpResponse);
        sb.append(", resultCode='");
        sb.append(this.resultCode);
        sb.append('}');
        return sb.toString();
    }
}
