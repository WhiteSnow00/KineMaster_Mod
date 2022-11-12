// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import android.os.Build$VERSION;
import java.util.Locale;

public class a
{
    protected static boolean a(final String s, final String s2) {
        final boolean equals = "REL".equals(s2);
        boolean b = false;
        if (equals) {
            return false;
        }
        final Locale root = Locale.ROOT;
        if (s2.toUpperCase(root).compareTo(s.toUpperCase(root)) >= 0) {
            b = true;
        }
        return b;
    }
    
    @Deprecated
    public static boolean b() {
        return Build$VERSION.SDK_INT >= 30;
    }
    
    @Deprecated
    public static boolean c() {
        final int sdk_INT = Build$VERSION.SDK_INT;
        return sdk_INT >= 31 || (sdk_INT >= 30 && a("S", Build$VERSION.CODENAME));
    }
}
