// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ApiExceptionMapper implements StatusExceptionMapper
{
    @Override
    public final Exception a(final Status status) {
        return ApiExceptionUtil.a(status);
    }
}
