// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.connector.internal;

import java.util.Set;
import com.google.android.gms.measurement.api.AppMeasurementSdk$OnEventListener;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;

public final class zzg implements zza
{
    private final AnalyticsConnector.AnalyticsConnectorListener a;
    private final AppMeasurementSdk b;
    private final b c;
    
    public zzg(final AppMeasurementSdk b, final AnalyticsConnector.AnalyticsConnectorListener a) {
        this.a = a;
        (this.b = b).q((AppMeasurementSdk$OnEventListener)(this.c = new b(this)));
    }
    
    static /* bridge */ AnalyticsConnector.AnalyticsConnectorListener b(final zzg zzg) {
        return zzg.a;
    }
    
    @Override
    public final void a(final Set set) {
    }
}
