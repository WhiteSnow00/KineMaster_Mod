// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import java.util.Collections;
import android.content.pm.ServiceInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.ComponentName;
import android.os.Bundle;
import java.util.Iterator;
import java.util.ArrayList;
import com.google.firebase.inject.Provider;
import java.util.List;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import android.app.Service;
import android.content.Context;

public final class ComponentDiscovery<T>
{
    private final T a;
    private final c<T> b;
    
    ComponentDiscovery(final T a, final c<T> b) {
        this.a = a;
        this.b = b;
    }
    
    public static ComponentRegistrar a(final String s) {
        return e(s);
    }
    
    public static ComponentDiscovery<Context> c(final Context context, final Class<? extends Service> clazz) {
        return new ComponentDiscovery<Context>(context, (c<Context>)new b(clazz, null));
    }
    
    private static ComponentRegistrar d(final String s) {
        try {
            final Class<?> forName = Class.forName(s);
            if (ComponentRegistrar.class.isAssignableFrom(forName)) {
                return (ComponentRegistrar)forName.getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", s, "com.google.firebase.components.ComponentRegistrar"));
        }
        catch (final InvocationTargetException ex) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", s), ex);
        }
        catch (final NoSuchMethodException ex2) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", s), ex2);
        }
        catch (final InstantiationException ex3) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", s), ex3);
        }
        catch (final IllegalAccessException ex4) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", s), ex4);
        }
        catch (final ClassNotFoundException ex5) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", s));
            return null;
        }
    }
    
    private static ComponentRegistrar e(final String s) {
        return d(s);
    }
    
    public List<Provider<ComponentRegistrar>> b() {
        final ArrayList list = new ArrayList();
        final Iterator<String> iterator = this.b.a(this.a).iterator();
        while (iterator.hasNext()) {
            list.add(new d(iterator.next()));
        }
        return list;
    }
    
    private static class b implements c<Context>
    {
        private final Class<? extends Service> a;
        
        private b(final Class<? extends Service> a) {
            this.a = a;
        }
        
        b(final Class clazz, final ComponentDiscovery$a object) {
            this(clazz);
        }
        
        private Bundle b(final Context context) {
            try {
                final PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                final ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class)this.a), 128);
                if (serviceInfo == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(this.a);
                    sb.append(" has no service info.");
                    Log.w("ComponentDiscovery", sb.toString());
                    return null;
                }
                return serviceInfo.metaData;
            }
            catch (final PackageManager$NameNotFoundException ex) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }
        
        @Override
        public /* bridge */ List a(final Object o) {
            return this.c((Context)o);
        }
        
        public List<String> c(final Context context) {
            final Bundle b = this.b(context);
            if (b == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            final ArrayList list = new ArrayList();
            for (final String s : b.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b.get(s)) && s.startsWith("com.google.firebase.components:")) {
                    list.add(s.substring(31));
                }
            }
            return list;
        }
    }
    
    interface c<T>
    {
        List<String> a(final T p0);
    }
}
