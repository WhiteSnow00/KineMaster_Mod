// 
// Decompiled by Procyon v0.6.0
// 

package u2;

import java.util.UUID;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.content.pm.PackageInfo;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b
{
    private static final ConcurrentMap<String, c2.b> a;
    
    static {
        a = new ConcurrentHashMap<String, c2.b>();
    }
    
    private static PackageInfo a(final Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        catch (final PackageManager$NameNotFoundException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot resolve info for");
            sb.append(context.getPackageName());
            Log.e("AppVersionSignature", sb.toString(), (Throwable)ex);
            return null;
        }
    }
    
    private static String b(final PackageInfo packageInfo) {
        String s;
        if (packageInfo != null) {
            s = String.valueOf(packageInfo.versionCode);
        }
        else {
            s = UUID.randomUUID().toString();
        }
        return s;
    }
    
    public static c2.b c(final Context context) {
        final String packageName = context.getPackageName();
        final ConcurrentMap<String, c2.b> a = b.a;
        c2.b d;
        if ((d = a.get(packageName)) == null) {
            d = d(context);
            final c2.b b = a.putIfAbsent(packageName, d);
            if (b != null) {
                d = b;
            }
        }
        return d;
    }
    
    private static c2.b d(final Context context) {
        return new d(b(a(context)));
    }
}
