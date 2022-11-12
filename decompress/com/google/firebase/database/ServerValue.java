// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ServerValue
{
    public static final Map<String, String> a;
    
    static {
        a = a("timestamp");
    }
    
    private static Map<String, String> a(final String s) {
        final HashMap hashMap = new HashMap();
        hashMap.put(".sv", s);
        return (Map<String, String>)Collections.unmodifiableMap((Map<?, ?>)hashMap);
    }
}
