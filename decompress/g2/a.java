// 
// Decompiled by Procyon v0.6.0
// 

package g2;

import android.util.Log;
import android.os.StrictMode;
import android.os.StrictMode$ThreadPolicy$Builder;
import java.util.concurrent.atomic.AtomicInteger;
import android.os.Process;
import java.util.concurrent.PriorityBlockingQueue;
import android.text.TextUtils;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public final class a implements ExecutorService
{
    private static final long b;
    private static volatile int c;
    private final ExecutorService a;
    
    static {
        b = TimeUnit.SECONDS.toMillis(10L);
    }
    
    a(final ExecutorService a) {
        this.a = a;
    }
    
    public static int a() {
        if (a.c == 0) {
            a.c = Math.min(4, g2.b.a());
        }
        return a.c;
    }
    
    public static b b() {
        int n;
        if (a() >= 4) {
            n = 2;
        }
        else {
            n = 1;
        }
        return new b(true).c(n).b("animation");
    }
    
    public static a c() {
        return b().a();
    }
    
    public static b d() {
        return new b(true).c(1).b("disk-cache");
    }
    
    public static a e() {
        return d().a();
    }
    
    public static b f() {
        return new b(false).c(a()).b("source");
    }
    
    public static a g() {
        return f().a();
    }
    
    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, a.b, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), new d(new c(null), "source-unlimited", e.d, false)));
    }
    
    @Override
    public boolean awaitTermination(final long n, final TimeUnit timeUnit) throws InterruptedException {
        return this.a.awaitTermination(n, timeUnit);
    }
    
    @Override
    public void execute(final Runnable runnable) {
        this.a.execute(runnable);
    }
    
    @Override
    public <T> List<Future<T>> invokeAll(final Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.a.invokeAll(collection);
    }
    
    @Override
    public <T> List<Future<T>> invokeAll(final Collection<? extends Callable<T>> collection, final long n, final TimeUnit timeUnit) throws InterruptedException {
        return this.a.invokeAll(collection, n, timeUnit);
    }
    
    @Override
    public <T> T invokeAny(final Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.a.invokeAny(collection);
    }
    
    @Override
    public <T> T invokeAny(final Collection<? extends Callable<T>> collection, final long n, final TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.a.invokeAny(collection, n, timeUnit);
    }
    
    @Override
    public boolean isShutdown() {
        return this.a.isShutdown();
    }
    
    @Override
    public boolean isTerminated() {
        return this.a.isTerminated();
    }
    
    @Override
    public void shutdown() {
        this.a.shutdown();
    }
    
    @Override
    public List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }
    
    @Override
    public Future<?> submit(final Runnable runnable) {
        return this.a.submit(runnable);
    }
    
    @Override
    public <T> Future<T> submit(final Runnable runnable, final T t) {
        return this.a.submit(runnable, t);
    }
    
    @Override
    public <T> Future<T> submit(final Callable<T> callable) {
        return this.a.submit(callable);
    }
    
    @Override
    public String toString() {
        return this.a.toString();
    }
    
    public static final class b
    {
        private final boolean a;
        private int b;
        private int c;
        private final ThreadFactory d;
        private e e;
        private String f;
        private long g;
        
        b(final boolean a) {
            this.d = new c(null);
            this.e = e.d;
            this.a = a;
        }
        
        public a a() {
            if (!TextUtils.isEmpty((CharSequence)this.f)) {
                final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.c, this.g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(), new d(this.d, this.f, this.e, this.a));
                if (this.g != 0L) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Name must be non-null and non-empty, but given: ");
            sb.append(this.f);
            throw new IllegalArgumentException(sb.toString());
        }
        
        public b b(final String f) {
            this.f = f;
            return this;
        }
        
        public b c(final int n) {
            this.b = n;
            this.c = n;
            return this;
        }
    }
    
    private static final class c implements ThreadFactory
    {
        private c() {
        }
        
        c(final a$a object) {
            this();
        }
        
        @Override
        public Thread newThread(final Runnable runnable) {
            return new Thread(this, runnable) {
                final c a;
                
                @Override
                public void run() {
                    Process.setThreadPriority(9);
                    super.run();
                }
            };
        }
    }
    
    private static final class d implements ThreadFactory
    {
        private final ThreadFactory a;
        private final String b;
        final e c;
        final boolean d;
        private final AtomicInteger e;
        
        d(final ThreadFactory a, final String b, final e c, final boolean d) {
            this.e = new AtomicInteger();
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        @Override
        public Thread newThread(final Runnable runnable) {
            final Thread thread = this.a.newThread(new Runnable(this, runnable) {
                final Runnable a;
                final d b;
                
                @Override
                public void run() {
                    if (this.b.d) {
                        StrictMode.setThreadPolicy(new StrictMode$ThreadPolicy$Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        this.a.run();
                    }
                    finally {
                        final Throwable t;
                        this.b.c.a(t);
                    }
                }
            });
            final StringBuilder sb = new StringBuilder();
            sb.append("glide-");
            sb.append(this.b);
            sb.append("-thread-");
            sb.append(this.e.getAndIncrement());
            thread.setName(sb.toString());
            return thread;
        }
    }
    
    public interface e
    {
        public static final e a = new e() {
            @Override
            public void a(final Throwable t) {
            }
        };
        public static final e b;
        public static final e c = new e() {
            @Override
            public void a(final Throwable t) {
                if (t == null) {
                    return;
                }
                throw new RuntimeException("Request threw uncaught throwable", t);
            }
        };
        public static final e d = d2;
        
        default static {
            final e d2 = b = new e() {
                @Override
                public void a(final Throwable t) {
                    if (t != null && Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", t);
                    }
                }
            };
        }
        
        void a(final Throwable p0);
    }
}
