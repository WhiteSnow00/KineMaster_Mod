// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class RootTelemetryConfigManager
{
    private static RootTelemetryConfigManager b;
    private static final RootTelemetryConfiguration c;
    private RootTelemetryConfiguration a;
    
    static {
        c = new RootTelemetryConfiguration(0, false, false, 0, 0);
    }
    
    private RootTelemetryConfigManager() {
    }
    
    @KeepForSdk
    public static RootTelemetryConfigManager b() {
        synchronized (RootTelemetryConfigManager.class) {
            if (RootTelemetryConfigManager.b == null) {
                RootTelemetryConfigManager.b = new RootTelemetryConfigManager();
            }
            return RootTelemetryConfigManager.b;
        }
    }
    
    @KeepForSdk
    public RootTelemetryConfiguration a() {
        return this.a;
    }
    
    @VisibleForTesting
    public final void c(final RootTelemetryConfiguration a) {
        monitorenter(this);
        Label_0016: {
            if (a != null) {
                break Label_0016;
            }
            try {
                this.a = RootTelemetryConfigManager.c;
                return;
                final RootTelemetryConfiguration a2 = this.a;
                iftrue(Label_0049:)(a2 == null || a2.O1() < a.O1());
                return;
                Label_0049: {
                    this.a = a;
                }
            }
            finally {
                monitorexit(this);
            }
        }
    }
}
