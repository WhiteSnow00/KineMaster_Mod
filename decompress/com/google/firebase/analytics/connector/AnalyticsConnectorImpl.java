// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.connector;

import java.util.Set;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.analytics.connector.internal.zze;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.events.Event;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.measurement.zzee;
import com.google.firebase.events.EventHandler;
import java.util.concurrent.Executor;
import com.google.firebase.DataCollectionDefaultChange;
import android.os.Bundle;
import com.google.firebase.events.Subscriber;
import android.content.Context;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.ConcurrentHashMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public class AnalyticsConnectorImpl implements AnalyticsConnector
{
    private static volatile AnalyticsConnector c;
    @VisibleForTesting
    final AppMeasurementSdk a;
    @VisibleForTesting
    final Map b;
    
    AnalyticsConnectorImpl(final AppMeasurementSdk a) {
        Preconditions.k(a);
        this.a = a;
        this.b = new ConcurrentHashMap();
    }
    
    @KeepForSdk
    public static AnalyticsConnector h(final FirebaseApp firebaseApp, final Context context, final Subscriber subscriber) {
        Preconditions.k(firebaseApp);
        Preconditions.k(context);
        Preconditions.k(subscriber);
        Preconditions.k(context.getApplicationContext());
        if (AnalyticsConnectorImpl.c == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (AnalyticsConnectorImpl.c == null) {
                    final Bundle bundle = new Bundle(1);
                    if (firebaseApp.w()) {
                        subscriber.b((Class)DataCollectionDefaultChange.class, (Executor)zza.a, (EventHandler)zzb.a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.v());
                    }
                    AnalyticsConnectorImpl.c = new AnalyticsConnectorImpl(zzee.zzg(context, (String)null, (String)null, (String)null, bundle).zzd());
                }
            }
        }
        return AnalyticsConnectorImpl.c;
    }
    
    static void i(final Event event) {
        final boolean a = ((DataCollectionDefaultChange)event.a()).a;
        synchronized (AnalyticsConnectorImpl.class) {
            Preconditions.k(AnalyticsConnectorImpl.c).a.v(a);
        }
    }
    
    static /* bridge */ boolean j(final AnalyticsConnectorImpl analyticsConnectorImpl, final String s) {
        return analyticsConnectorImpl.k(s);
    }
    
    private final boolean k(final String s) {
        return !s.isEmpty() && this.b.containsKey(s) && this.b.get(s) != null;
    }
    
    @KeepForSdk
    @Override
    public void a(final ConditionalUserProperty conditionalUserProperty) {
        if (!zzc.i(conditionalUserProperty)) {
            return;
        }
        this.a.r(zzc.a(conditionalUserProperty));
    }
    
    @KeepForSdk
    @Override
    public void b(final String s, final String s2, final Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        if (!zzc.l(s)) {
            return;
        }
        if (!zzc.j(s2, bundle2)) {
            return;
        }
        if (!zzc.h(s, s2, bundle2)) {
            return;
        }
        zzc.e(s, s2, bundle2);
        this.a.n(s, s2, bundle2);
    }
    
    @KeepForSdk
    @Override
    public void c(final String s, final String s2, final Object o) {
        if (!zzc.l(s)) {
            return;
        }
        if (!zzc.m(s, s2)) {
            return;
        }
        this.a.u(s, s2, o);
    }
    
    @KeepForSdk
    @Override
    public void clearConditionalUserProperty(final String s, final String s2, final Bundle bundle) {
        if (s2 != null && !zzc.j(s2, bundle)) {
            return;
        }
        this.a.b(s, s2, bundle);
    }
    
    @KeepForSdk
    @Override
    public Map<String, Object> d(final boolean b) {
        return this.a.m((String)null, (String)null, b);
    }
    
    @KeepForSdk
    @Override
    public int e(final String s) {
        return this.a.l(s);
    }
    
    @KeepForSdk
    @Override
    public List<ConditionalUserProperty> f(final String s, final String s2) {
        final ArrayList list = new ArrayList();
        final Iterator iterator = this.a.g(s, s2).iterator();
        while (iterator.hasNext()) {
            list.add(zzc.b((Bundle)iterator.next()));
        }
        return list;
    }
    
    @KeepForSdk
    @Override
    public AnalyticsConnectorHandle g(final String s, final AnalyticsConnectorListener analyticsConnectorListener) {
        Preconditions.k(analyticsConnectorListener);
        if (!zzc.l(s)) {
            return null;
        }
        if (this.k(s)) {
            return null;
        }
        final AppMeasurementSdk a = this.a;
        com.google.firebase.analytics.connector.internal.zza zza;
        if ("fiam".equals(s)) {
            zza = new zze(a, analyticsConnectorListener);
        }
        else if (!"crash".equals(s) && !"clx".equals(s)) {
            zza = null;
        }
        else {
            zza = new zzg(a, analyticsConnectorListener);
        }
        if (zza != null) {
            this.b.put(s, zza);
            return new AnalyticsConnectorHandle(this, s) {
                final String a;
                final AnalyticsConnectorImpl b;
                
                @KeepForSdk
                @Override
                public void a(final Set<String> set) {
                    if (AnalyticsConnectorImpl.j(this.b, this.a) && this.a.equals("fiam") && set != null) {
                        if (!set.isEmpty()) {
                            this.b.b.get(this.a).a(set);
                        }
                    }
                }
            };
        }
        return null;
    }
}
