// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

public final class Common
{
    @KeepForSdk
    public static final Api.ClientKey<zah> a;
    @KeepForSdk
    public static final Api<Api.ApiOptions.NoOptions> b;
    private static final Api.AbstractClientBuilder c;
    public static final zae d;
    
    static {
        b = new Api<Api.ApiOptions.NoOptions>("Common.API", c = new a(), a = new Api.ClientKey());
        d = new zae();
    }
}
