// 
// Decompiled by Procyon v0.6.0
// 

package v2;

import java.util.Objects;
import java.util.Collection;
import android.text.TextUtils;

public final class k
{
    public static void a(final boolean b, final String s) {
        if (b) {
            return;
        }
        throw new IllegalArgumentException(s);
    }
    
    public static String b(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            return s;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
    
    public static <T extends Collection<Y>, Y> T c(final T t) {
        if (!t.isEmpty()) {
            return t;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }
    
    public static <T> T d(final T t) {
        return e(t, "Argument must not be null");
    }
    
    public static <T> T e(final T t, final String s) {
        Objects.requireNonNull(t, s);
        return t;
    }
}
