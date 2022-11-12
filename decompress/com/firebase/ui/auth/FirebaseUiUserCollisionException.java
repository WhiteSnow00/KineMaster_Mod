// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth;

import com.google.firebase.auth.AuthCredential;

public class FirebaseUiUserCollisionException extends Exception
{
    private final AuthCredential mCredential;
    private final String mEmail;
    private final int mErrorCode;
    private final String mProviderId;
    
    public FirebaseUiUserCollisionException(final int mErrorCode, final String s, final String mProviderId, final String mEmail, final AuthCredential mCredential) {
        super(s);
        this.mErrorCode = mErrorCode;
        this.mProviderId = mProviderId;
        this.mEmail = mEmail;
        this.mCredential = mCredential;
    }
    
    public AuthCredential getCredential() {
        return this.mCredential;
    }
    
    public String getEmail() {
        return this.mEmail;
    }
    
    public final int getErrorCode() {
        return this.mErrorCode;
    }
    
    public String getProviderId() {
        return this.mProviderId;
    }
}
