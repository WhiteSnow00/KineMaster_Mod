// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface StatusExceptionMapper
{
    @KeepForSdk
    Exception a(final Status p0);
}
