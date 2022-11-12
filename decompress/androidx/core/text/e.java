// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;

public final class e
{
    private static final Locale a;
    
    static {
        a = new Locale("", "");
    }
    
    public static int a(final Locale locale) {
        return e.a.a(locale);
    }
    
    static class a
    {
        static int a(final Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }
}
