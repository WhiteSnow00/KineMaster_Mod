// 
// Decompiled by Procyon v0.6.0
// 

package q2;

import java.util.Iterator;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.ArrayList;
import android.util.Log;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import android.content.Context;

@Deprecated
public final class d
{
    private final Context a;
    
    public d(final Context a) {
        this.a = a;
    }
    
    private static b b(String instance) {
        try {
            final Class<?> forName = Class.forName(instance);
            instance = null;
            try {
                instance = (String)forName.getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            }
            catch (final InvocationTargetException ex) {
                c(forName, ex);
            }
            catch (final NoSuchMethodException ex2) {
                c(forName, ex2);
            }
            catch (final IllegalAccessException ex3) {
                c(forName, ex3);
            }
            catch (final InstantiationException ex4) {
                c(forName, ex4);
            }
            if (instance instanceof b) {
                return (b)instance;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected instanceof GlideModule, but found: ");
            sb.append((Object)instance);
            throw new RuntimeException(sb.toString());
        }
        catch (final ClassNotFoundException ex5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", ex5);
        }
    }
    
    private static void c(final Class<?> clazz, final Exception ex) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Unable to instantiate GlideModule implementation for ");
        sb.append(clazz);
        throw new RuntimeException(sb.toString(), ex);
    }
    
    public List<b> a() {
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        final ArrayList list = new ArrayList();
        try {
            final ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Got null app info metadata");
                }
                return list;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Got app info metadata: ");
                sb.append(applicationInfo.metaData);
                Log.v("ManifestParser", sb.toString());
            }
            for (final String s : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(s))) {
                    list.add(b(s));
                    if (!Log.isLoggable("ManifestParser", 3)) {
                        continue;
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Loaded Glide module: ");
                    sb2.append(s);
                    Log.d("ManifestParser", sb2.toString());
                }
            }
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Finished loading Glide modules");
            }
            return list;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", (Throwable)ex);
        }
    }
}
