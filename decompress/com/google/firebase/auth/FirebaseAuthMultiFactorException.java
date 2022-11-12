// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

public class FirebaseAuthMultiFactorException extends FirebaseAuthException
{
    private MultiFactorResolver zza;
    
    public FirebaseAuthMultiFactorException(final String s, final String s2, final MultiFactorResolver zza) {
        super(s, s2);
        this.zza = zza;
    }
    
    public MultiFactorResolver getResolver() {
        return this.zza;
    }
}
