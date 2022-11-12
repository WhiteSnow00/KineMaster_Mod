// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth;

public class FirebaseUiException extends Exception
{
    private final int mErrorCode;
    
    public FirebaseUiException(final int n) {
        this(n, ErrorCodes.toFriendlyMessage(n));
    }
    
    public FirebaseUiException(final int mErrorCode, final String s) {
        super(s);
        this.mErrorCode = mErrorCode;
    }
    
    public FirebaseUiException(final int mErrorCode, final String s, final Throwable t) {
        super(s, t);
        this.mErrorCode = mErrorCode;
    }
    
    public FirebaseUiException(final int n, final Throwable t) {
        this(n, ErrorCodes.toFriendlyMessage(n), t);
    }
    
    public final int getErrorCode() {
        return this.mErrorCode;
    }
}
