// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.metadata;

import java.util.Iterator;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class b
{
    private final Map<String, String> a;
    private final int b;
    private final int c;
    
    public b(final int b, final int c) {
        this.a = new HashMap<String, String>();
        this.b = b;
        this.c = c;
    }
    
    private String b(final String s) {
        if (s != null) {
            return c(s, this.c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }
    
    public static String c(String s, final int n) {
        String s2 = s;
        if (s != null) {
            s = (s2 = s.trim());
            if (s.length() > n) {
                s2 = s.substring(0, n);
            }
        }
        return s2;
    }
    
    public Map<String, String> a() {
        synchronized (this) {
            return Collections.unmodifiableMap((Map<? extends String, ? extends String>)new HashMap<String, String>(this.a));
        }
    }
    
    public void d(final Map<String, String> map) {
        monitorenter(this);
        int n = 0;
        try {
            for (final Map.Entry<String, V> entry : map.entrySet()) {
                final String b = this.b(entry.getKey());
                if (this.a.size() >= this.b && !this.a.containsKey(b)) {
                    ++n;
                }
                else {
                    final String s = (String)entry.getValue();
                    final Map<String, String> a = this.a;
                    String c;
                    if (s == null) {
                        c = "";
                    }
                    else {
                        c = c(s, this.c);
                    }
                    a.put(b, c);
                }
            }
            if (n > 0) {
                final Logger f = Logger.f();
                final StringBuilder sb = new StringBuilder();
                sb.append("Ignored ");
                sb.append(n);
                sb.append(" entries when adding custom keys. Maximum allowable: ");
                sb.append(this.b);
                f.k(sb.toString());
            }
        }
        finally {
            monitorexit(this);
        }
    }
}
