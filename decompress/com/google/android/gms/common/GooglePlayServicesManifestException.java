// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class GooglePlayServicesManifestException extends IllegalStateException
{
    private final int zza;
    
    public GooglePlayServicesManifestException(final int zza, final String s) {
        super(s);
        this.zza = zza;
    }
    
    public int getActualVersion() {
        return this.zza;
    }
    
    public int getExpectedVersion() {
        return GoogleApiAvailabilityLight.a;
    }
}
