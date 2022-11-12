// 
// Decompiled by Procyon v0.6.0
// 

package y0;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a
{
    private static long a;
    private static Method b;
    
    public static void a(final String s) {
        y0.b.a(s);
    }
    
    public static void b() {
        y0.b.b();
    }
    
    private static void c(final String s, final Exception ex) {
        if (!(ex instanceof InvocationTargetException)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unable to call ");
            sb.append(s);
            sb.append(" via reflection");
            Log.v("Trace", sb.toString(), (Throwable)ex);
            return;
        }
        final Throwable cause = ex.getCause();
        if (cause instanceof RuntimeException) {
            throw (RuntimeException)cause;
        }
        throw new RuntimeException(cause);
    }
    
    public static boolean d() {
        try {
            if (y0.a.b == null) {
                return Trace.isEnabled();
            }
            return e();
        }
        catch (final NoSuchMethodError | NoClassDefFoundError noSuchMethodError | NoClassDefFoundError) {
            return e();
        }
    }
    
    private static boolean e() {
        try {
            if (y0.a.b == null) {
                y0.a.a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                y0.a.b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return (boolean)y0.a.b.invoke(null, y0.a.a);
        }
        catch (final Exception ex) {
            c("isTagEnabled", ex);
            return false;
        }
    }
}
