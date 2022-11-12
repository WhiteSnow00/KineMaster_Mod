// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

@KeepForSdk
public final class ApiKey<O extends Api.ApiOptions>
{
    private final int a;
    private final Api b;
    private final Api.ApiOptions c;
    private final String d;
    
    private ApiKey(final Api b, final Api.ApiOptions c, final String d) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.a = Objects.c(b, c, d);
    }
    
    @KeepForSdk
    public static <O extends Api.ApiOptions> ApiKey<O> a(final Api<O> api, final O o, final String s) {
        return new ApiKey<O>(api, o, s);
    }
    
    public final String b() {
        return this.b.d();
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof ApiKey)) {
            return false;
        }
        final ApiKey apiKey = (ApiKey)o;
        return Objects.b(this.b, apiKey.b) && Objects.b(this.c, apiKey.c) && Objects.b(this.d, apiKey.d);
    }
    
    @Override
    public final int hashCode() {
        return this.a;
    }
}
