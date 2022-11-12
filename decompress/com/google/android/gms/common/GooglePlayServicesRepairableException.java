// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException
{
    private final int zza;
    
    public GooglePlayServicesRepairableException(final int zza, final String s, final Intent intent) {
        super(s, intent);
        this.zza = zza;
    }
    
    public int getConnectionStatusCode() {
        return this.zza;
    }
}
