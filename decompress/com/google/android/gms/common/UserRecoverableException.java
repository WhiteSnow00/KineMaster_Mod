// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException extends Exception
{
    private final Intent zza;
    
    public UserRecoverableException(final String s, final Intent zza) {
        super(s);
        this.zza = zza;
    }
    
    public Intent getIntent() {
        return new Intent(this.zza);
    }
}
