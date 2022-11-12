// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics;

import k4.b;
import com.google.firebase.annotations.DeferredApi;
import java.util.Iterator;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import java.util.concurrent.TimeUnit;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.inject.Deferred$DeferredHandler;
import k4.c;
import android.os.Bundle;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import java.util.List;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Deferred;

public class AnalyticsDeferredProxy
{
    private final Deferred<AnalyticsConnector> a;
    private volatile AnalyticsEventLogger b;
    private volatile BreadcrumbSource c;
    private final List<BreadcrumbHandler> d;
    
    public AnalyticsDeferredProxy(final Deferred<AnalyticsConnector> deferred) {
        this(deferred, new DisabledBreadcrumbSource(), new UnavailableAnalyticsEventLogger());
    }
    
    public AnalyticsDeferredProxy(final Deferred<AnalyticsConnector> a, final BreadcrumbSource c, final AnalyticsEventLogger b) {
        this.a = a;
        this.c = c;
        this.d = new ArrayList<BreadcrumbHandler>();
        this.b = b;
        this.f();
    }
    
    public static void a(final AnalyticsDeferredProxy analyticsDeferredProxy, final Provider provider) {
        analyticsDeferredProxy.i(provider);
    }
    
    public static void b(final AnalyticsDeferredProxy analyticsDeferredProxy, final String s, final Bundle bundle) {
        analyticsDeferredProxy.g(s, bundle);
    }
    
    public static void c(final AnalyticsDeferredProxy analyticsDeferredProxy, final BreadcrumbHandler breadcrumbHandler) {
        analyticsDeferredProxy.h(breadcrumbHandler);
    }
    
    private void f() {
        this.a.a((Deferred$DeferredHandler)new c(this));
    }
    
    private void g(final String s, final Bundle bundle) {
        this.b.a(s, bundle);
    }
    
    private void h(final BreadcrumbHandler breadcrumbHandler) {
        synchronized (this) {
            if (this.c instanceof DisabledBreadcrumbSource) {
                this.d.add(breadcrumbHandler);
            }
            this.c.a(breadcrumbHandler);
        }
    }
    
    private void i(final Provider provider) {
        Logger.f().b("AnalyticsConnector now available.");
        final AnalyticsConnector analyticsConnector = (AnalyticsConnector)provider.get();
        final CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(analyticsConnector);
        final a a = new a();
        if (j(analyticsConnector, a) != null) {
            Logger.f().b("Registered Firebase Analytics listener.");
            final BreadcrumbAnalyticsEventReceiver c = new BreadcrumbAnalyticsEventReceiver();
            final BlockingAnalyticsEventLogger b = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, 500, TimeUnit.MILLISECONDS);
            synchronized (this) {
                final Iterator<BreadcrumbHandler> iterator = this.d.iterator();
                while (iterator.hasNext()) {
                    c.a(iterator.next());
                }
                a.d(c);
                a.e(b);
                this.c = c;
                this.b = b;
                return;
            }
        }
        Logger.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
    }
    
    @DeferredApi
    private static AnalyticsConnector.AnalyticsConnectorHandle j(final AnalyticsConnector analyticsConnector, final a a) {
        Object g;
        if ((g = analyticsConnector.g("clx", (AnalyticsConnector.AnalyticsConnectorListener)a)) == null) {
            Logger.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            final AnalyticsConnector.AnalyticsConnectorHandle g2 = analyticsConnector.g("crash", (AnalyticsConnector.AnalyticsConnectorListener)a);
            if ((g = g2) != null) {
                Logger.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
                g = g2;
            }
        }
        return (AnalyticsConnector.AnalyticsConnectorHandle)g;
    }
    
    public AnalyticsEventLogger d() {
        return (AnalyticsEventLogger)new k4.a(this);
    }
    
    public BreadcrumbSource e() {
        return (BreadcrumbSource)new b(this);
    }
}
