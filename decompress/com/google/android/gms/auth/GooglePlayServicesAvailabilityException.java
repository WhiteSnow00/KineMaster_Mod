// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException
{
    private final int zza;
    
    GooglePlayServicesAvailabilityException(final int zza, final String s, final Intent intent) {
        super(s, intent);
        this.zza = zza;
    }
    
    public int getConnectionStatusCode() {
        return this.zza;
    }
}
