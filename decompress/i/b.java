// 
// Decompiled by Procyon v0.6.0
// 

package i;

import java.lang.reflect.InvocationTargetException;
import android.os.Handler$Callback;
import android.os.Build$VERSION;
import android.os.Looper;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadFactory;
import android.os.Handler;
import java.util.concurrent.ExecutorService;

public class b extends c
{
    private final Object a;
    private final ExecutorService b;
    private volatile Handler c;
    
    public b() {
        this.a = new Object();
        this.b = Executors.newFixedThreadPool(4, new ThreadFactory() {
            private final AtomicInteger a = new AtomicInteger(0);
            final b b;
            
            @Override
            public Thread newThread(final Runnable runnable) {
                final Thread thread = new Thread(runnable);
                thread.setName(String.format("arch_disk_io_%d", this.a.getAndIncrement()));
                return thread;
            }
        });
    }
    
    private static Handler e(final Looper looper) {
        if (Build$VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        try {
            return Handler.class.getDeclaredConstructor(Looper.class, Handler$Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        }
        catch (final InvocationTargetException ex) {
            return new Handler(looper);
        }
        catch (final IllegalAccessException | InstantiationException | NoSuchMethodException ex2) {
            return new Handler(looper);
        }
    }
    
    @Override
    public void a(final Runnable runnable) {
        this.b.execute(runnable);
    }
    
    @Override
    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
    
    @Override
    public void d(final Runnable runnable) {
        if (this.c == null) {
            synchronized (this.a) {
                if (this.c == null) {
                    this.c = e(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }
}
