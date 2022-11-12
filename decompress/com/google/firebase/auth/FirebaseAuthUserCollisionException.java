// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

public final class FirebaseAuthUserCollisionException extends FirebaseAuthException
{
    private AuthCredential zza;
    private String zzb;
    private String zzc;
    
    public FirebaseAuthUserCollisionException(final String s, final String s2) {
        super(s, s2);
    }
    
    public String getEmail() {
        return this.zzb;
    }
    
    public AuthCredential getUpdatedCredential() {
        return this.zza;
    }
    
    public final FirebaseAuthUserCollisionException zza(final AuthCredential zza) {
        this.zza = zza;
        return this;
    }
    
    public final FirebaseAuthUserCollisionException zzb(final String zzb) {
        this.zzb = zzb;
        return this;
    }
    
    public final FirebaseAuthUserCollisionException zzc(final String zzc) {
        this.zzc = zzc;
        return this;
    }
}
