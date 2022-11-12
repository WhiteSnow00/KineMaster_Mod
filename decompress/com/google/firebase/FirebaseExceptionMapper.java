// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;

@KeepForSdk
public class FirebaseExceptionMapper implements StatusExceptionMapper
{
    @Override
    public final Exception a(final Status status) {
        if (status.M1() == 8) {
            return new FirebaseException(status.zza());
        }
        return new FirebaseApiNotAvailableException(status.zza());
    }
}
