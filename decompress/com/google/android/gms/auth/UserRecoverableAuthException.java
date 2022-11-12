// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import android.content.Intent;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class UserRecoverableAuthException extends GoogleAuthException
{
    private final Intent zza;
    
    public UserRecoverableAuthException(final String s, final Intent zza) {
        super(s);
        this.zza = zza;
    }
    
    public Intent getIntent() {
        final Intent zza = this.zza;
        if (zza == null) {
            return null;
        }
        return new Intent(zza);
    }
}
