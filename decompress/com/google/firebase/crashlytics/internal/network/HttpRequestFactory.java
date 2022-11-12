// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.network;

import java.util.Map;

public class HttpRequestFactory
{
    public HttpGetRequest a(final String s, final Map<String, String> map) {
        return new HttpGetRequest(s, map);
    }
}
