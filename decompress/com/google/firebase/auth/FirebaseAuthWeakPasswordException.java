// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

public final class FirebaseAuthWeakPasswordException extends FirebaseAuthInvalidCredentialsException
{
    private final String zza;
    
    public FirebaseAuthWeakPasswordException(final String s, final String s2, final String zza) {
        super(s, s2);
        this.zza = zza;
    }
    
    public String getReason() {
        return this.zza;
    }
}
