// 
// Decompiled by Procyon v0.6.0
// 

package androidx.loader.content;

import android.os.Message;
import android.os.Looper;
import android.os.Handler;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Callable;
import android.os.Binder;
import android.os.Process;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Executor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

abstract class ModernAsyncTask<Params, Progress, Result>
{
    private static final ThreadFactory f;
    private static final BlockingQueue<Runnable> g;
    public static final Executor h;
    private static f i;
    private static volatile Executor j;
    private final g<Params, Result> a;
    private final FutureTask<Result> b;
    private volatile Status c;
    final AtomicBoolean d;
    final AtomicBoolean e;
    
    static {
        ModernAsyncTask.j = (h = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, g = new LinkedBlockingQueue<Runnable>(10), f = new ThreadFactory() {
            private final AtomicInteger a = new AtomicInteger(1);
            
            @Override
            public Thread newThread(final Runnable runnable) {
                final StringBuilder sb = new StringBuilder();
                sb.append("ModernAsyncTask #");
                sb.append(this.a.getAndIncrement());
                return new Thread(runnable, sb.toString());
            }
        }));
    }
    
    ModernAsyncTask() {
        this.c = Status.PENDING;
        this.d = new AtomicBoolean();
        this.e = new AtomicBoolean();
        final g<Params, Result> a = new g<Params, Result>(this) {
            final ModernAsyncTask b;
            
            @Override
            public Result call() throws Exception {
                this.b.e.set(true);
                Result b = null;
                try {
                    Process.setThreadPriority(10);
                    b = b;
                    final Result result = b = this.b.b((Params[])super.a);
                    Binder.flushPendingCommands();
                    this.b.l(result);
                    return result;
                }
                finally {
                    try {
                        this.b.d.set(true);
                    }
                    finally {
                        this.b.l(b);
                    }
                }
            }
        };
        this.a = (g<Params, Result>)a;
        this.b = new FutureTask<Result>(this, a) {
            final ModernAsyncTask a;
            
            @Override
            protected void done() {
                try {
                    this.a.m(this.get());
                }
                catch (final CancellationException ex) {
                    this.a.m(null);
                }
                catch (final ExecutionException ex2) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", ex2.getCause());
                }
                catch (final InterruptedException ex3) {
                    Log.w("AsyncTask", (Throwable)ex3);
                }
                finally {
                    final Throwable t;
                    throw new RuntimeException("An error occurred while executing doInBackground()", t);
                }
            }
        };
    }
    
    private static Handler e() {
        synchronized (ModernAsyncTask.class) {
            if (ModernAsyncTask.i == null) {
                ModernAsyncTask.i = new f();
            }
            return ModernAsyncTask.i;
        }
    }
    
    public final boolean a(final boolean b) {
        this.d.set(true);
        return this.b.cancel(b);
    }
    
    protected abstract Result b(final Params... p0);
    
    public final ModernAsyncTask<Params, Progress, Result> c(final Executor executor, final Params... a) {
        if (this.c == Status.PENDING) {
            this.c = Status.RUNNING;
            this.j();
            this.a.a = a;
            executor.execute(this.b);
            return this;
        }
        final int n = ModernAsyncTask$d.a[this.c.ordinal()];
        if (n == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (n != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }
    
    void d(final Result result) {
        if (this.f()) {
            this.h(result);
        }
        else {
            this.i(result);
        }
        this.c = Status.FINISHED;
    }
    
    public final boolean f() {
        return this.d.get();
    }
    
    protected void g() {
    }
    
    protected void h(final Result result) {
        this.g();
    }
    
    protected void i(final Result result) {
    }
    
    protected void j() {
    }
    
    protected void k(final Progress... array) {
    }
    
    Result l(final Result result) {
        e().obtainMessage(1, (Object)new e(this, new Object[] { result })).sendToTarget();
        return result;
    }
    
    void m(final Result result) {
        if (!this.e.get()) {
            this.l(result);
        }
    }
    
    public enum Status
    {
        private static final Status[] $VALUES;
        
        FINISHED, 
        PENDING, 
        RUNNING;
    }
    
    private static class e<Data>
    {
        final ModernAsyncTask a;
        final Data[] b;
        
        e(final ModernAsyncTask a, final Data... b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private static class f extends Handler
    {
        f() {
            super(Looper.getMainLooper());
        }
        
        public void handleMessage(final Message message) {
            final e e = (e)message.obj;
            final int what = message.what;
            if (what != 1) {
                if (what == 2) {
                    e.a.k(e.b);
                }
            }
            else {
                e.a.d(e.b[0]);
            }
        }
    }
    
    private abstract static class g<Params, Result> implements Callable<Result>
    {
        Params[] a;
        
        g() {
        }
    }
}
