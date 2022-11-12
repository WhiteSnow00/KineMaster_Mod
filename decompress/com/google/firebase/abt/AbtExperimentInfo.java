// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.abt;

import java.util.HashMap;
import android.text.TextUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import java.text.DateFormat;

public class AbtExperimentInfo
{
    private static final String[] g;
    static final DateFormat h;
    private final String a;
    private final String b;
    private final String c;
    private final Date d;
    private final long e;
    private final long f;
    
    static {
        g = new String[] { "experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId" };
        h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
    }
    
    public AbtExperimentInfo(final String a, final String b, final String c, final Date d, final long e, final long f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    static AbtExperimentInfo a(final Map<String, String> map) throws AbtException {
        g(map);
        try {
            final Date parse = AbtExperimentInfo.h.parse(map.get("experimentStartTime"));
            final long long1 = Long.parseLong(map.get("triggerTimeoutMillis"));
            final long long2 = Long.parseLong(map.get("timeToLiveMillis"));
            final String s = map.get("experimentId");
            final String s2 = map.get("variantId");
            String s3;
            if (map.containsKey("triggerEvent")) {
                s3 = map.get("triggerEvent");
            }
            else {
                s3 = "";
            }
            return new AbtExperimentInfo(s, s2, s3, parse, long1, long2);
        }
        catch (final NumberFormatException ex) {
            throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", ex);
        }
        catch (final ParseException ex2) {
            throw new AbtException("Could not process experiment: parsing experiment start time failed.", ex2);
        }
    }
    
    static void f(final AbtExperimentInfo abtExperimentInfo) throws AbtException {
        g(abtExperimentInfo.e());
    }
    
    private static void g(final Map<String, String> map) throws AbtException {
        final ArrayList list = new ArrayList();
        for (final String s : AbtExperimentInfo.g) {
            if (!map.containsKey(s)) {
                list.add(s);
            }
        }
        if (list.isEmpty()) {
            return;
        }
        throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", list));
    }
    
    String b() {
        return this.a;
    }
    
    long c() {
        return this.d.getTime();
    }
    
    AnalyticsConnector.ConditionalUserProperty d(String c) {
        final AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.a = c;
        conditionalUserProperty.m = this.c();
        conditionalUserProperty.b = this.a;
        conditionalUserProperty.c = this.b;
        if (TextUtils.isEmpty((CharSequence)this.c)) {
            c = null;
        }
        else {
            c = this.c;
        }
        conditionalUserProperty.d = c;
        conditionalUserProperty.e = this.e;
        conditionalUserProperty.j = this.f;
        return conditionalUserProperty;
    }
    
    Map<String, String> e() {
        final HashMap hashMap = new HashMap();
        hashMap.put("experimentId", this.a);
        hashMap.put("variantId", this.b);
        hashMap.put("triggerEvent", this.c);
        hashMap.put("experimentStartTime", AbtExperimentInfo.h.format(this.d));
        hashMap.put("triggerTimeoutMillis", Long.toString(this.e));
        hashMap.put("timeToLiveMillis", Long.toString(this.f));
        return hashMap;
    }
}
