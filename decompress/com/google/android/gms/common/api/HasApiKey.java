// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ApiKey;

public interface HasApiKey<O extends Api.ApiOptions>
{
    @KeepForSdk
    ApiKey<O> getApiKey();
}
