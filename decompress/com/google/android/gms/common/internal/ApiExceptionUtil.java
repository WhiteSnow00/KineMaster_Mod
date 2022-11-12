// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ApiExceptionUtil
{
    @KeepForSdk
    public static ApiException a(final Status status) {
        if (status.O1()) {
            return new ResolvableApiException(status);
        }
        return new ApiException(status);
    }
}
