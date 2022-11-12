// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import android.os.LocaleList;
import android.content.res.Configuration;

public final class f
{
    public static i a(final Configuration configuration) {
        return i.d(a.a(configuration));
    }
    
    static class a
    {
        static LocaleList a(final Configuration configuration) {
            return configuration.getLocales();
        }
    }
}
