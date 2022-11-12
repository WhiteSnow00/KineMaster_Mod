// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.abt.component;

import java.util.HashMap;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import android.content.Context;
import com.google.firebase.abt.FirebaseABTesting;
import java.util.Map;

public class AbtComponent
{
    private final Map<String, FirebaseABTesting> a;
    private final Context b;
    private final Provider<AnalyticsConnector> c;
    
    protected AbtComponent(final Context b, final Provider<AnalyticsConnector> c) {
        this.a = new HashMap<String, FirebaseABTesting>();
        this.b = b;
        this.c = c;
    }
    
    protected FirebaseABTesting a(final String s) {
        return new FirebaseABTesting(this.b, this.c, s);
    }
    
    public FirebaseABTesting b(final String s) {
        synchronized (this) {
            if (!this.a.containsKey(s)) {
                this.a.put(s, this.a(s));
            }
            return this.a.get(s);
        }
    }
}
