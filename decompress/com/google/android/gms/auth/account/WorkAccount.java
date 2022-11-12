// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.account;

import com.google.android.gms.internal.auth.zzal;
import com.google.android.gms.internal.auth.zzam;
import com.google.android.gms.common.api.Api;

public class WorkAccount
{
    public static final Api<Api.ApiOptions.NoOptions> a;
    @Deprecated
    public static final WorkAccountApi b;
    private static final Api.ClientKey<zzam> c;
    private static final Api.AbstractClientBuilder<zzam, Api.ApiOptions.NoOptions> d;
    
    static {
        a = new Api<Api.ApiOptions.NoOptions>("WorkAccount.API", d = new a(), c = new Api.ClientKey());
        b = (WorkAccountApi)new zzal();
    }
    
    private WorkAccount() {
    }
}
