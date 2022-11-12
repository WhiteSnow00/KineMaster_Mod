// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;

public class CrashlyticsOriginAnalyticsEventLogger implements AnalyticsEventLogger
{
    private final AnalyticsConnector a;
    
    public CrashlyticsOriginAnalyticsEventLogger(final AnalyticsConnector a) {
        this.a = a;
    }
    
    @Override
    public void a(final String s, final Bundle bundle) {
        this.a.b("clx", s, bundle);
    }
}
