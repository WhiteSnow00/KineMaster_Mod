// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.service.zao;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class TelemetryLogging
{
    private TelemetryLogging() {
    }
    
    @KeepForSdk
    public static TelemetryLoggingClient a(final Context context) {
        return b(context, TelemetryLoggingOptions.b);
    }
    
    @KeepForSdk
    public static TelemetryLoggingClient b(final Context context, final TelemetryLoggingOptions telemetryLoggingOptions) {
        return new zao(context, telemetryLoggingOptions);
    }
}
