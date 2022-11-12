// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

@KeepForSdk
public class TelemetryLoggingOptions implements Optional
{
    public static final TelemetryLoggingOptions b;
    private final String a;
    
    static {
        b = a().a();
    }
    
    TelemetryLoggingOptions(final String a, final zaad zaad) {
        this.a = a;
    }
    
    @KeepForSdk
    public static Builder a() {
        return new Builder(null);
    }
    
    public final Bundle b() {
        final Bundle bundle = new Bundle();
        final String a = this.a;
        if (a != null) {
            bundle.putString("api", a);
        }
        return bundle;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o == this || (o instanceof TelemetryLoggingOptions && Objects.b(this.a, ((TelemetryLoggingOptions)o).a));
    }
    
    @Override
    public final int hashCode() {
        return Objects.c(this.a);
    }
    
    @KeepForSdk
    public static class Builder
    {
        private String a;
        
        private Builder() {
        }
        
        Builder(final zaac zaac) {
        }
        
        @KeepForSdk
        public TelemetryLoggingOptions a() {
            return new TelemetryLoggingOptions(this.a, null);
        }
    }
}
