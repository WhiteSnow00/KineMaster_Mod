// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import android.util.Log;
import android.os.Trace;
import android.os.Build$VERSION;
import java.lang.reflect.Method;

@Deprecated
public final class l
{
    private static long a;
    private static Method b;
    private static Method c;
    private static Method d;
    private static Method e;
    
    static {
        if (Build$VERSION.SDK_INT < 29) {
            try {
                l.a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                final Class<Long> type = Long.TYPE;
                l.b = Trace.class.getMethod("isTagEnabled", type);
                final Class<Integer> type2 = Integer.TYPE;
                l.c = Trace.class.getMethod("asyncTraceBegin", type, String.class, type2);
                l.d = Trace.class.getMethod("asyncTraceEnd", type, String.class, type2);
                l.e = Trace.class.getMethod("traceCounter", type, String.class, type2);
            }
            catch (final Exception ex) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", (Throwable)ex);
            }
        }
    }
    
    public static void a(final String s) {
        l.a.a(s);
    }
    
    public static void b() {
        l.a.b();
    }
    
    static class a
    {
        static void a(final String s) {
            Trace.beginSection(s);
        }
        
        static void b() {
            Trace.endSection();
        }
    }
}
