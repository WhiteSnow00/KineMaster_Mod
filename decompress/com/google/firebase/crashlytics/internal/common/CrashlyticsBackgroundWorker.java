// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.Callable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

public class CrashlyticsBackgroundWorker
{
    private final Executor a;
    private Task<Void> b;
    private final Object c;
    private final ThreadLocal<Boolean> d;
    
    public CrashlyticsBackgroundWorker(final Executor a) {
        this.b = (Task<Void>)Tasks.e((Object)null);
        this.c = new Object();
        this.d = new ThreadLocal<Boolean>();
        (this.a = a).execute(new Runnable(this) {
            final CrashlyticsBackgroundWorker a;
            
            @Override
            public void run() {
                CrashlyticsBackgroundWorker.a(this.a).set(Boolean.TRUE);
            }
        });
    }
    
    static ThreadLocal a(final CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        return crashlyticsBackgroundWorker.d;
    }
    
    private <T> Task<Void> d(final Task<T> task) {
        return (Task<Void>)task.l(this.a, (Continuation)new Continuation<T, Void>(this) {
            final CrashlyticsBackgroundWorker a;
            
            public Void a(final Task<T> task) throws Exception {
                return null;
            }
            
            public /* bridge */ Object then(final Task task) throws Exception {
                return this.a((Task<T>)task);
            }
        });
    }
    
    private boolean e() {
        return Boolean.TRUE.equals(this.d.get());
    }
    
    private <T> Continuation<Void, T> f(final Callable<T> callable) {
        return (Continuation<Void, T>)new Continuation<Void, T>(this, callable) {
            final Callable a;
            final CrashlyticsBackgroundWorker b;
            
            public T then(final Task<Void> task) throws Exception {
                return this.a.call();
            }
        };
    }
    
    public void b() {
        if (this.e()) {
            return;
        }
        throw new IllegalStateException("Not running on background worker thread as intended.");
    }
    
    public Executor c() {
        return this.a;
    }
    
    Task<Void> g(final Runnable runnable) {
        return this.h((Callable<Void>)new Callable<Void>(this, runnable) {
            final Runnable a;
            final CrashlyticsBackgroundWorker b;
            
            public Void a() throws Exception {
                this.a.run();
                return null;
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public <T> Task<T> h(final Callable<T> callable) {
        synchronized (this.c) {
            final Task l = this.b.l(this.a, (Continuation)this.f(callable));
            this.b = this.d((com.google.android.gms.tasks.Task<Object>)l);
            return (Task<T>)l;
        }
    }
    
    public <T> Task<T> i(final Callable<Task<T>> callable) {
        synchronized (this.c) {
            final Task n = this.b.n(this.a, (Continuation)this.f((Callable<Object>)callable));
            this.b = this.d((com.google.android.gms.tasks.Task<Object>)n);
            return (Task<T>)n;
        }
    }
}
