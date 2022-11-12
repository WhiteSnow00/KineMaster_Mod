// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import android.os.Handler$Callback;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;

public final class h
{
    public static Handler a(final Looper looper) {
        if (Build$VERSION.SDK_INT >= 28) {
            return a.a(looper);
        }
        Handler handler = null;
        try {
            handler = Handler.class.getDeclaredConstructor(Looper.class, Handler$Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            return handler;
        }
        catch (final InvocationTargetException ex) {
            final Throwable cause = ex.getCause();
            if (cause instanceof RuntimeException) {
                throw (RuntimeException)cause;
            }
            if (cause instanceof Error) {
                throw (Error)cause;
            }
            throw new RuntimeException(cause);
        }
        catch (final NoSuchMethodException handler) {}
        catch (final InstantiationException handler) {}
        catch (final IllegalAccessException ex2) {}
        Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", (Throwable)handler);
        return new Handler(looper);
    }
    
    private static class a
    {
        public static Handler a(final Looper looper) {
            return Handler.createAsync(looper);
        }
    }
}
