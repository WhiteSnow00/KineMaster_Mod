// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.Feature;

public final class UnsupportedApiCallException extends UnsupportedOperationException
{
    private final Feature zza;
    
    @KeepForSdk
    public UnsupportedApiCallException(final Feature zza) {
        this.zza = zza;
    }
    
    @Override
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.zza));
    }
}
