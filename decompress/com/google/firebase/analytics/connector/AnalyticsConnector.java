// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.connector;

import java.util.Set;
import com.google.firebase.annotations.DeferredApi;
import java.util.List;
import java.util.Map;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;

public interface AnalyticsConnector
{
    @KeepForSdk
    void a(final ConditionalUserProperty p0);
    
    @KeepForSdk
    void b(final String p0, final String p1, final Bundle p2);
    
    @KeepForSdk
    void c(final String p0, final String p1, final Object p2);
    
    @KeepForSdk
    void clearConditionalUserProperty(final String p0, final String p1, final Bundle p2);
    
    @KeepForSdk
    Map<String, Object> d(final boolean p0);
    
    @KeepForSdk
    int e(final String p0);
    
    @KeepForSdk
    List<ConditionalUserProperty> f(final String p0, final String p1);
    
    @KeepForSdk
    @DeferredApi
    AnalyticsConnectorHandle g(final String p0, final AnalyticsConnectorListener p1);
    
    @KeepForSdk
    public interface AnalyticsConnectorHandle
    {
        @KeepForSdk
        void a(final Set<String> p0);
    }
    
    @KeepForSdk
    public interface AnalyticsConnectorListener
    {
        @KeepForSdk
        void a(final int p0, final Bundle p1);
    }
    
    @KeepForSdk
    public static class ConditionalUserProperty
    {
        @KeepForSdk
        public String a;
        @KeepForSdk
        public String b;
        @KeepForSdk
        public Object c;
        @KeepForSdk
        public String d;
        @KeepForSdk
        public long e;
        @KeepForSdk
        public String f;
        @KeepForSdk
        public Bundle g;
        @KeepForSdk
        public String h;
        @KeepForSdk
        public Bundle i;
        @KeepForSdk
        public long j;
        @KeepForSdk
        public String k;
        @KeepForSdk
        public Bundle l;
        @KeepForSdk
        public long m;
        @KeepForSdk
        public boolean n;
        @KeepForSdk
        public long o;
    }
}
