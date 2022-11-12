// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.backends;

import java.lang.reflect.InvocationTargetException;
import android.content.pm.ServiceInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.ComponentName;
import java.util.Iterator;
import android.os.Bundle;
import java.util.Collections;
import android.util.Log;
import java.util.HashMap;
import javax.inject.Inject;
import android.content.Context;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
class e implements BackendRegistry
{
    private final a a;
    private final d b;
    private final Map<String, TransportBackend> c;
    
    @Inject
    e(final Context context, final d d) {
        this(new a(context), d);
    }
    
    e(final a a, final d b) {
        this.c = new HashMap<String, TransportBackend>();
        this.a = a;
        this.b = b;
    }
    
    @Override
    public TransportBackend a(final String s) {
        synchronized (this) {
            if (this.c.containsKey(s)) {
                return this.c.get(s);
            }
            final BackendFactory b = this.a.b(s);
            if (b == null) {
                return null;
            }
            final TransportBackend create = b.create(this.b.a(s));
            this.c.put(s, create);
            return create;
        }
    }
    
    static class a
    {
        private final Context a;
        private Map<String, String> b;
        
        a(final Context a) {
            this.b = null;
            this.a = a;
        }
        
        private Map<String, String> a(final Context context) {
            final Bundle d = d(context);
            if (d == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            final HashMap hashMap = new HashMap();
            for (final String s : d.keySet()) {
                final Object value = d.get(s);
                if (value instanceof String && s.startsWith("backend:")) {
                    final String[] split = ((String)value).split(",", -1);
                    for (int length = split.length, i = 0; i < length; ++i) {
                        final String trim = split[i].trim();
                        if (!trim.isEmpty()) {
                            hashMap.put(trim, s.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }
        
        private Map<String, String> c() {
            if (this.b == null) {
                this.b = this.a(this.a);
            }
            return this.b;
        }
        
        private static Bundle d(final Context context) {
            try {
                final PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                final ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class)TransportBackendDiscovery.class), 128);
                if (serviceInfo == null) {
                    Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                    return null;
                }
                return serviceInfo.metaData;
            }
            catch (final PackageManager$NameNotFoundException ex) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }
        
        BackendFactory b(String s) {
            s = this.c().get(s);
            if (s == null) {
                return null;
            }
            try {
                return (BackendFactory)Class.forName(s).asSubclass(BackendFactory.class).getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            }
            catch (final InvocationTargetException ex) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", s), (Throwable)ex);
            }
            catch (final NoSuchMethodException ex2) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", s), (Throwable)ex2);
            }
            catch (final InstantiationException ex3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", s), (Throwable)ex3);
            }
            catch (final IllegalAccessException ex4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", s), (Throwable)ex4);
            }
            catch (final ClassNotFoundException ex5) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", s), (Throwable)ex5);
            }
            return null;
        }
    }
}
