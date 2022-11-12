// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.util;

import java.util.Objects;

public class c
{
    public static boolean a(final Object o, final Object o2) {
        return a.a(o, o2);
    }
    
    public static int b(final Object... array) {
        return a.b(array);
    }
    
    public static <T> T c(final T t) {
        Objects.requireNonNull(t);
        return t;
    }
    
    public static <T> T d(final T t, final String s) {
        Objects.requireNonNull(t, s);
        return t;
    }
    
    public static String e(final Object o, String string) {
        if (o != null) {
            string = o.toString();
        }
        return string;
    }
    
    static class a
    {
        static boolean a(final Object o, final Object o2) {
            return Objects.equals(o, o2);
        }
        
        static int b(final Object... array) {
            return Objects.hash(array);
        }
    }
}
