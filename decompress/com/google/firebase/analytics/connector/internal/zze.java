// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.connector.internal;

import java.util.Iterator;
import java.util.Collection;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashSet;
import com.google.android.gms.measurement.api.AppMeasurementSdk$OnEventListener;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

public final class zze implements zza
{
    final Set a;
    private final AnalyticsConnector.AnalyticsConnectorListener b;
    private final AppMeasurementSdk c;
    private final a d;
    
    public zze(final AppMeasurementSdk c, final AnalyticsConnector.AnalyticsConnectorListener b) {
        this.b = b;
        (this.c = c).q((AppMeasurementSdk$OnEventListener)(this.d = new a(this)));
        this.a = new HashSet();
    }
    
    static /* bridge */ AnalyticsConnector.AnalyticsConnectorListener b(final zze zze) {
        return zze.b;
    }
    
    @Override
    public final void a(final Set set) {
        this.a.clear();
        final Set a = this.a;
        final HashSet set2 = new HashSet();
        for (final String s : set) {
            if (set2.size() >= 50) {
                break;
            }
            if (!zzc.f(s) || !zzc.g(s)) {
                continue;
            }
            final String d = zzc.d(s);
            Preconditions.k(d);
            set2.add(d);
        }
        a.addAll(set2);
    }
}
