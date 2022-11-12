// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.tasks.Continuation;
import java.util.concurrent.Executor;
import java.util.concurrent.CountDownLatch;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ExecutorService;

public final class Utils
{
    private static final ExecutorService a;
    
    static {
        a = ExecutorUtils.c("awaitEvenIfOnMainThread task continuation executor");
    }
    
    private Utils() {
    }
    
    public static Void a(final TaskCompletionSource taskCompletionSource, final Task task) {
        return h(taskCompletionSource, task);
    }
    
    public static Void b(final TaskCompletionSource taskCompletionSource, final Task task) {
        return g(taskCompletionSource, task);
    }
    
    public static Object c(final CountDownLatch countDownLatch, final Task task) {
        return f(countDownLatch, task);
    }
    
    public static <T> T d(final Task<T> task) throws InterruptedException, TimeoutException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.l((Executor)Utils.a, (Continuation)new r(countDownLatch));
        countDownLatch.await(4L, TimeUnit.SECONDS);
        if (task.t()) {
            return (T)task.p();
        }
        if (task.r()) {
            throw new CancellationException("Task is already canceled");
        }
        if (task.s()) {
            throw new IllegalStateException(task.o());
        }
        throw new TimeoutException();
    }
    
    public static <T> Task<T> e(final Executor executor, final Callable<Task<T>> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable(callable, taskCompletionSource) {
            final Callable a;
            final TaskCompletionSource b;
            
            @Override
            public void run() {
                try {
                    this.a.call().k((Continuation)new Continuation<T, Void>(this) {
                        final Utils$a a;
                        
                        public Void a(final Task<T> task) throws Exception {
                            if (task.t()) {
                                this.a.b.c(task.p());
                            }
                            else {
                                this.a.b.b(task.o());
                            }
                            return null;
                        }
                        
                        public /* bridge */ Object then(final Task task) throws Exception {
                            return this.a((Task<T>)task);
                        }
                    });
                }
                catch (final Exception ex) {
                    this.b.b(ex);
                }
            }
        });
        return (Task<T>)taskCompletionSource.a();
    }
    
    private static Object f(final CountDownLatch countDownLatch, final Task task) throws Exception {
        countDownLatch.countDown();
        return null;
    }
    
    private static Void g(final TaskCompletionSource taskCompletionSource, final Task task) throws Exception {
        if (task.t()) {
            taskCompletionSource.e(task.p());
        }
        else {
            final Exception o = task.o();
            Objects.requireNonNull(o);
            final Exception ex = o;
            taskCompletionSource.d(o);
        }
        return null;
    }
    
    private static Void h(final TaskCompletionSource taskCompletionSource, final Task task) throws Exception {
        if (task.t()) {
            taskCompletionSource.e(task.p());
        }
        else {
            final Exception o = task.o();
            Objects.requireNonNull(o);
            final Exception ex = o;
            taskCompletionSource.d(o);
        }
        return null;
    }
    
    public static <T> Task<T> i(final Task<T> task, final Task<T> task2) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final q q = new q(taskCompletionSource);
        task.k((Continuation)q);
        task2.k((Continuation)q);
        return (Task<T>)taskCompletionSource.a();
    }
    
    public static <T> Task<T> j(final Executor executor, final Task<T> task, final Task<T> task2) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final p p3 = new p(taskCompletionSource);
        task.l(executor, (Continuation)p3);
        task2.l(executor, (Continuation)p3);
        return (Task<T>)taskCompletionSource.a();
    }
}
