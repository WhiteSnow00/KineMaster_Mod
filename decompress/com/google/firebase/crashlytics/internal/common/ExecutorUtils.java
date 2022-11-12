// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.Locale;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public final class ExecutorUtils
{
    private ExecutorUtils() {
    }
    
    private static void a(final String s, final ExecutorService executorService) {
        b(s, executorService, 2L, TimeUnit.SECONDS);
    }
    
    private static void b(final String s, final ExecutorService executorService, final long n, final TimeUnit timeUnit) {
        final Runtime runtime = Runtime.getRuntime();
        final BackgroundPriorityRunnable backgroundPriorityRunnable = new BackgroundPriorityRunnable(s, executorService, n, timeUnit) {
            final String a;
            final ExecutorService b;
            final long c;
            final TimeUnit d;
            
            public void a() {
                try {
                    final Logger f = Logger.f();
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Executing shutdown hook for ");
                    sb.append(this.a);
                    f.b(sb.toString());
                    this.b.shutdown();
                    if (!this.b.awaitTermination(this.c, this.d)) {
                        final Logger f2 = Logger.f();
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.a);
                        sb2.append(" did not shut down in the allocated time. Requesting immediate shutdown.");
                        f2.b(sb2.toString());
                        this.b.shutdownNow();
                    }
                }
                catch (final InterruptedException ex) {
                    Logger.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.a));
                    this.b.shutdownNow();
                }
            }
        };
        final StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics Shutdown Hook for ");
        sb.append(s);
        runtime.addShutdownHook(new Thread(backgroundPriorityRunnable, sb.toString()));
    }
    
    public static ExecutorService c(final String s) {
        final ExecutorService e = e(d(s), new ThreadPoolExecutor.DiscardPolicy());
        a(s, e);
        return e;
    }
    
    public static ThreadFactory d(final String s) {
        return new ThreadFactory(s, new AtomicLong(1L)) {
            final String a;
            final AtomicLong b;
            
            @Override
            public Thread newThread(final Runnable runnable) {
                final Thread thread = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable(this, runnable) {
                    final Runnable a;
                    final ExecutorUtils$a b;
                    
                    public void a() {
                        this.a.run();
                    }
                });
                final StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append(this.b.getAndIncrement());
                thread.setName(sb.toString());
                return thread;
            }
        };
    }
    
    private static ExecutorService e(final ThreadFactory threadFactory, final RejectedExecutionHandler rejectedExecutionHandler) {
        return Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory, rejectedExecutionHandler));
    }
}
