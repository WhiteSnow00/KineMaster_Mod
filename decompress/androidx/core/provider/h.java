// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutorService;
import androidx.core.util.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;

class h
{
    static ThreadPoolExecutor a(final String s, final int n, final int n2) {
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, n2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), new a(s, n));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
    
    static <T> void b(final Executor executor, final Callable<T> callable, final androidx.core.util.a<T> a) {
        executor.execute(new b<Object>(androidx.core.provider.b.a(), callable, a));
    }
    
    static <T> T c(final ExecutorService executorService, final Callable<T> callable, final int n) throws InterruptedException {
        final Future<T> submit = executorService.submit(callable);
        final long n2 = n;
        try {
            return submit.get(n2, TimeUnit.MILLISECONDS);
        }
        catch (final TimeoutException ex) {
            throw new InterruptedException("timeout");
        }
        catch (final InterruptedException ex2) {
            throw ex2;
        }
        catch (final ExecutionException ex3) {
            throw new RuntimeException(ex3);
        }
    }
    
    private static class a implements ThreadFactory
    {
        private String a;
        private int b;
        
        a(final String a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public Thread newThread(final Runnable runnable) {
            return new h.a.a(runnable, this.a, this.b);
        }
        
        private static class a extends Thread
        {
            private final int a;
            
            a(final Runnable runnable, final String s, final int a) {
                super(runnable, s);
                this.a = a;
            }
            
            @Override
            public void run() {
                Process.setThreadPriority(this.a);
                super.run();
            }
        }
    }
    
    private static class b<T> implements Runnable
    {
        private Callable<T> a;
        private androidx.core.util.a<T> b;
        private Handler c;
        
        b(final Handler c, final Callable<T> a, final androidx.core.util.a<T> b) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public void run() {
            Object call;
            try {
                call = this.a.call();
            }
            catch (final Exception ex) {
                call = null;
            }
            this.c.post((Runnable)new Runnable(this, this.b, call) {
                final androidx.core.util.a a;
                final Object b;
                final b c;
                
                @Override
                public void run() {
                    this.a.accept(this.b);
                }
            });
        }
    }
}
