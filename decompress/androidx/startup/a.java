// 
// Decompiled by Procyon v0.6.0
// 

package androidx.startup;

import x0.b;
import android.os.Bundle;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.ComponentName;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import android.content.Context;
import java.util.Set;
import java.util.Map;

public final class a
{
    private static volatile a d;
    private static final Object e;
    final Map<Class<?>, Object> a;
    final Set<Class<? extends x0.a<?>>> b;
    final Context c;
    
    static {
        e = new Object();
    }
    
    a(final Context context) {
        this.c = context.getApplicationContext();
        this.b = new HashSet<Class<? extends x0.a<?>>>();
        this.a = new HashMap<Class<?>, Object>();
    }
    
    private <T> T d(final Class<? extends x0.a<?>> clazz, final Set<Class<?>> set) {
        Label_0013: {
            if (!y0.a.d()) {
                break Label_0013;
            }
            try {
                y0.a.a(clazz.getSimpleName());
                if (!set.contains(clazz)) {
                    if (!this.a.containsKey(clazz)) {
                        set.add(clazz);
                        try {
                            final x0.a a = (x0.a)clazz.getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
                            final List a2 = a.a();
                            if (!a2.isEmpty()) {
                                for (final Class clazz2 : a2) {
                                    if (!this.a.containsKey(clazz2)) {
                                        this.d(clazz2, set);
                                    }
                                }
                            }
                            final Object b = a.b(this.c);
                            set.remove(clazz);
                            this.a.put(clazz, b);
                            final Throwable value;
                            return (T)value;
                        }
                        finally {
                            final Throwable value;
                            throw new StartupException(value);
                        }
                    }
                    final Throwable value = this.a.get(clazz);
                    return (T)value;
                }
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", clazz.getName()));
            }
            finally {
                y0.a.b();
            }
        }
    }
    
    public static a e(final Context context) {
        if (a.d == null) {
            synchronized (a.e) {
                if (a.d == null) {
                    a.d = new a(context);
                }
            }
        }
        return a.d;
    }
    
    void a() {
        try {
            try {
                y0.a.a("Startup");
                this.b(this.c.getPackageManager().getProviderInfo(new ComponentName(this.c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
                y0.a.b();
                return;
            }
            finally {}
        }
        catch (final PackageManager$NameNotFoundException ex) {
            throw new StartupException((Throwable)ex);
        }
        y0.a.b();
    }
    
    void b(final Bundle bundle) {
        final String string = this.c.getString(x0.b.a);
        if (bundle != null) {
            try {
                final HashSet<Class<?>> set = new HashSet<Class<?>>();
                for (final String s : bundle.keySet()) {
                    if (string.equals(bundle.getString(s, (String)null))) {
                        final Class<?> forName = Class.forName(s);
                        if (!x0.a.class.isAssignableFrom(forName)) {
                            continue;
                        }
                        this.b.add((Class<? extends x0.a<?>>)forName);
                    }
                }
                final Iterator<Class<? extends x0.a<?>>> iterator2 = this.b.iterator();
                while (iterator2.hasNext()) {
                    this.d(iterator2.next(), set);
                }
            }
            catch (final ClassNotFoundException ex) {
                throw new StartupException(ex);
            }
        }
    }
    
     <T> T c(final Class<? extends x0.a<?>> clazz) {
        synchronized (androidx.startup.a.e) {
            Object o;
            if ((o = this.a.get(clazz)) == null) {
                o = this.d(clazz, new HashSet<Class<?>>());
            }
            return (T)o;
        }
    }
    
    public <T> T f(final Class<? extends x0.a<T>> clazz) {
        return (T)this.c(clazz);
    }
    
    public boolean g(final Class<? extends x0.a<?>> clazz) {
        return this.b.contains(clazz);
    }
}
