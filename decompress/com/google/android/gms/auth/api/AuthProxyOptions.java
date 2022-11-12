// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api;

import com.google.android.gms.common.internal.Objects;
import android.os.Bundle;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

@KeepForSdk
@ShowFirstParty
public final class AuthProxyOptions implements Optional
{
    public static final AuthProxyOptions b;
    private final Bundle a;
    
    static {
        b = new AuthProxyOptions(new Bundle(), null);
    }
    
    AuthProxyOptions(final Bundle a, final d d) {
        this.a = a;
    }
    
    public final Bundle a() {
        return new Bundle(this.a);
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o == this || (o instanceof AuthProxyOptions && Objects.a(this.a, ((AuthProxyOptions)o).a));
    }
    
    @Override
    public final int hashCode() {
        return Objects.c(this.a);
    }
}
