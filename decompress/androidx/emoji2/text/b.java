// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import android.os.Looper;
import android.os.Build$VERSION;
import android.os.Handler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;

class b
{
    public static Thread a(final String s, final Runnable runnable) {
        return c(s, runnable);
    }
    
    static ThreadPoolExecutor b(final String s) {
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), new androidx.emoji2.text.a(s));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
    
    private static Thread c(final String s, final Runnable runnable) {
        final Thread thread = new Thread(runnable, s);
        thread.setPriority(10);
        return thread;
    }
    
    static Handler d() {
        if (Build$VERSION.SDK_INT >= 28) {
            return a.a(Looper.getMainLooper());
        }
        return new Handler(Looper.getMainLooper());
    }
    
    static class a
    {
        public static Handler a(final Looper looper) {
            return Handler.createAsync(looper);
        }
    }
}
