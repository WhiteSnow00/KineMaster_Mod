// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.network.HttpResponse;
import java.io.IOException;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;

class b implements e
{
    private final String a;
    private final HttpRequestFactory b;
    private final Logger c;
    
    public b(final String s, final HttpRequestFactory httpRequestFactory) {
        this(s, httpRequestFactory, Logger.f());
    }
    
    b(final String a, final HttpRequestFactory b, final Logger c) {
        if (a != null) {
            this.c = c;
            this.b = b;
            this.a = a;
            return;
        }
        throw new IllegalArgumentException("url must not be null.");
    }
    
    private HttpGetRequest b(final HttpGetRequest httpGetRequest, final d d) {
        this.c(httpGetRequest, "X-CRASHLYTICS-GOOGLE-APP-ID", d.a);
        this.c(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        this.c(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.i());
        this.c(httpGetRequest, "Accept", "application/json");
        this.c(httpGetRequest, "X-CRASHLYTICS-DEVICE-MODEL", d.b);
        this.c(httpGetRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", d.c);
        this.c(httpGetRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", d.d);
        this.c(httpGetRequest, "X-CRASHLYTICS-INSTALLATION-ID", d.e.a());
        return httpGetRequest;
    }
    
    private void c(final HttpGetRequest httpGetRequest, final String s, final String s2) {
        if (s2 != null) {
            httpGetRequest.d(s, s2);
        }
    }
    
    private JSONObject e(final String s) {
        try {
            return new JSONObject(s);
        }
        catch (final Exception ex) {
            final Logger c = this.c;
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to parse settings JSON from ");
            sb.append(this.a);
            c.l(sb.toString(), ex);
            final Logger c2 = this.c;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Settings response ");
            sb2.append(s);
            c2.k(sb2.toString());
            return null;
        }
    }
    
    private Map<String, String> f(final d d) {
        final HashMap hashMap = new HashMap();
        hashMap.put("build_version", d.h);
        hashMap.put("display_version", d.g);
        hashMap.put("source", Integer.toString(d.i));
        final String f = d.f;
        if (!TextUtils.isEmpty((CharSequence)f)) {
            hashMap.put("instance", f);
        }
        return hashMap;
    }
    
    @Override
    public JSONObject a(final d d, final boolean b) {
        if (b) {
            JSONObject g;
            try {
                final Map<String, String> f = this.f(d);
                final HttpGetRequest b2 = this.b(this.d(f), d);
                final Logger c = this.c;
                final StringBuilder sb = new StringBuilder();
                sb.append("Requesting settings from ");
                sb.append(this.a);
                c.b(sb.toString());
                final Logger c2 = this.c;
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Settings query params were: ");
                sb2.append(f);
                c2.i(sb2.toString());
                g = this.g(b2.c());
            }
            catch (final IOException ex) {
                this.c.e("Settings request failed.", ex);
                g = null;
            }
            return g;
        }
        throw new RuntimeException("An invalid data collection token was used.");
    }
    
    protected HttpGetRequest d(final Map<String, String> map) {
        final HttpGetRequest a = this.b.a(this.a, map);
        final StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics Android SDK/");
        sb.append(CrashlyticsCore.i());
        return a.d("User-Agent", sb.toString()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }
    
    JSONObject g(final HttpResponse httpResponse) {
        final int b = httpResponse.b();
        final Logger c = this.c;
        final StringBuilder sb = new StringBuilder();
        sb.append("Settings response code was: ");
        sb.append(b);
        c.i(sb.toString());
        JSONObject e;
        if (this.h(b)) {
            e = this.e(httpResponse.a());
        }
        else {
            final Logger c2 = this.c;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Settings request failed; (status: ");
            sb2.append(b);
            sb2.append(") from ");
            sb2.append(this.a);
            c2.d(sb2.toString());
            e = null;
        }
        return e;
    }
    
    boolean h(final int n) {
        return n == 200 || n == 201 || n == 202 || n == 203;
    }
}
