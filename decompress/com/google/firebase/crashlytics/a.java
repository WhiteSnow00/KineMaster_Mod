// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics;

import java.util.Locale;
import com.google.firebase.crashlytics.internal.Logger;
import android.os.Bundle;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import com.google.firebase.analytics.connector.AnalyticsConnector;

class a implements AnalyticsConnectorListener
{
    private AnalyticsEventReceiver a;
    private AnalyticsEventReceiver b;
    
    private static void b(final AnalyticsEventReceiver analyticsEventReceiver, final String s, final Bundle bundle) {
        if (analyticsEventReceiver == null) {
            return;
        }
        analyticsEventReceiver.onEvent(s, bundle);
    }
    
    private void c(final String s, final Bundle bundle) {
        AnalyticsEventReceiver analyticsEventReceiver;
        if ("clx".equals(bundle.getString("_o"))) {
            analyticsEventReceiver = this.a;
        }
        else {
            analyticsEventReceiver = this.b;
        }
        b(analyticsEventReceiver, s, bundle);
    }
    
    @Override
    public void a(final int n, Bundle bundle) {
        Logger.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", n, bundle));
        if (bundle == null) {
            return;
        }
        final String string = bundle.getString("name");
        if (string != null) {
            if ((bundle = bundle.getBundle("params")) == null) {
                bundle = new Bundle();
            }
            this.c(string, bundle);
        }
    }
    
    public void d(final AnalyticsEventReceiver b) {
        this.b = b;
    }
    
    public void e(final AnalyticsEventReceiver a) {
        this.a = a;
    }
}
