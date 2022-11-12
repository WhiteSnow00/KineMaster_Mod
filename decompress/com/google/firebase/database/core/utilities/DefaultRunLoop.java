// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.ThreadInitializer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import com.google.firebase.database.core.RunLoop;

public abstract class DefaultRunLoop implements RunLoop
{
    private ScheduledThreadPoolExecutor a;
    
    public DefaultRunLoop() {
        (this.a = new ScheduledThreadPoolExecutor(this, 1, new b(null)) {
            final DefaultRunLoop a;
            
            @Override
            protected void afterExecute(final Runnable runnable, final Throwable t) {
                super.afterExecute(runnable, t);
                if (t != null || !(runnable instanceof Future)) {
                    goto Label_0067;
                }
                final Future future = (Future)runnable;
                try {
                    if (future.isDone()) {
                        future.get();
                        goto Label_0067;
                    }
                    goto Label_0067;
                }
                catch (final InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    goto Label_0067;
                }
                catch (final ExecutionException ex2) {
                    ex2.getCause();
                }
                catch (final CancellationException ex3) {
                    goto Label_0067;
                }
            }
        }).setKeepAliveTime(3L, TimeUnit.SECONDS);
    }
    
    public static String g(final Throwable t) {
        if (t instanceof OutOfMemoryError) {
            return "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        }
        if (t instanceof NoClassDefFoundError) {
            return "A symbol that the Firebase Database SDK depends on failed to load. This usually indicates that your project includes an incompatible version of another Firebase dependency. If updating your dependencies to the latest version does not resolve this issue, please file a report at https://github.com/firebase/firebase-android-sdk";
        }
        if (t instanceof DatabaseException) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Uncaught exception in Firebase Database runloop (");
        sb.append(FirebaseDatabase.g());
        sb.append("). If you are not already on the latest version of the Firebase SDKs, try updating your dependencies. Should this problem persist, please file a report at https://github.com/firebase/firebase-android-sdk");
        return sb.toString();
    }
    
    @Override
    public void a() {
        this.a.setCorePoolSize(1);
    }
    
    @Override
    public void b(final Runnable runnable) {
        this.a.execute(runnable);
    }
    
    public ScheduledExecutorService c() {
        return this.a;
    }
    
    protected ThreadFactory d() {
        return Executors.defaultThreadFactory();
    }
    
    protected ThreadInitializer e() {
        return ThreadInitializer.a;
    }
    
    public abstract void f(final Throwable p0);
    
    private class b implements ThreadFactory
    {
        final DefaultRunLoop a;
        
        private b(final DefaultRunLoop a) {
            this.a = a;
        }
        
        b(final DefaultRunLoop defaultRunLoop, final DefaultRunLoop$a scheduledThreadPoolExecutor) {
            this(defaultRunLoop);
        }
        
        @Override
        public Thread newThread(final Runnable runnable) {
            final Thread thread = this.a.d().newThread(runnable);
            final ThreadInitializer e = this.a.e();
            e.a(thread, "FirebaseDatabaseWorker");
            e.b(thread, true);
            e.c(thread, new Thread.UncaughtExceptionHandler(this) {
                final b a;
                
                @Override
                public void uncaughtException(final Thread thread, final Throwable t) {
                    this.a.a.f(t);
                }
            });
            return thread;
        }
    }
}
