// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.util;

import java.io.IOException;
import java.util.Map;

public class GAuthToken
{
    private final String a;
    private final Map<String, Object> b;
    
    public GAuthToken(final String a, final Map<String, Object> b) {
        this.a = a;
        this.b = b;
    }
    
    public static GAuthToken c(String substring) {
        if (!substring.startsWith("gauth|")) {
            return null;
        }
        substring = substring.substring(6);
        try {
            final Map<String, Object> a = JsonMapper.a(substring);
            return new GAuthToken((String)a.get("token"), (Map<String, Object>)a.get("auth"));
        }
        catch (final IOException ex) {
            throw new RuntimeException("Failed to parse gauth token", ex);
        }
    }
    
    public Map<String, Object> a() {
        return this.b;
    }
    
    public String b() {
        return this.a;
    }
}
