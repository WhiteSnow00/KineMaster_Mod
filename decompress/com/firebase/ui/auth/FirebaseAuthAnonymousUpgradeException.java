// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth;

public class FirebaseAuthAnonymousUpgradeException extends Exception
{
    private IdpResponse mResponse;
    
    public FirebaseAuthAnonymousUpgradeException(final int n, final IdpResponse mResponse) {
        super(ErrorCodes.toFriendlyMessage(n));
        this.mResponse = mResponse;
    }
    
    public IdpResponse getResponse() {
        return this.mResponse;
    }
}
