// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api;

import com.google.android.gms.internal.auth.zzbt;
import com.google.android.gms.internal.auth.zzbe;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@ShowFirstParty
public final class AuthProxy
{
    @KeepForSdk
    @ShowFirstParty
    public static final Api<AuthProxyOptions> a;
    @KeepForSdk
    @ShowFirstParty
    public static final ProxyApi b;
    public static final Api.ClientKey<zzbe> c;
    private static final Api.AbstractClientBuilder<zzbe, AuthProxyOptions> d;
    
    static {
        a = new Api<AuthProxyOptions>("Auth.PROXY_API", d = new c(), c = new Api.ClientKey());
        b = (ProxyApi)new zzbt();
    }
}
