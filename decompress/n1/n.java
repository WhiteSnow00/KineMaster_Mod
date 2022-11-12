// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.concurrent.Executors;
import e1.h;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class n
{
    private static final String f;
    private final ThreadFactory a;
    private final ScheduledExecutorService b;
    final Map<String, c> c;
    final Map<String, b> d;
    final Object e;
    
    static {
        f = h.f("WorkTimer");
    }
    
    public n() {
        final ThreadFactory a = new ThreadFactory() {
            private int a = 0;
            final n b;
            
            @Override
            public Thread newThread(final Runnable runnable) {
                final Thread thread = Executors.defaultThreadFactory().newThread(runnable);
                final StringBuilder sb = new StringBuilder();
                sb.append("WorkManager-WorkTimer-thread-");
                sb.append(this.a);
                thread.setName(sb.toString());
                ++this.a;
                return thread;
            }
        };
        this.a = a;
        this.c = new HashMap<String, c>();
        this.d = new HashMap<String, b>();
        this.e = new Object();
        this.b = Executors.newSingleThreadScheduledExecutor(a);
    }
    
    public void a() {
        if (!this.b.isShutdown()) {
            this.b.shutdownNow();
        }
    }
    
    public void b(final String s, final long n, final b b) {
        synchronized (this.e) {
            h.c().a(n.f, String.format("Starting timer for %s", s), new Throwable[0]);
            this.c(s);
            final c c = new c(this, s);
            this.c.put(s, c);
            this.d.put(s, b);
            this.b.schedule(c, n, TimeUnit.MILLISECONDS);
        }
    }
    
    public void c(final String s) {
        synchronized (this.e) {
            if (this.c.remove(s) != null) {
                h.c().a(n.f, String.format("Stopping timer for %s", s), new Throwable[0]);
                this.d.remove(s);
            }
        }
    }
    
    public interface b
    {
        void a(final String p0);
    }
    
    public static class c implements Runnable
    {
        private final n a;
        private final String b;
        
        c(final n a, final String b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void run() {
            synchronized (this.a.e) {
                if (this.a.c.remove(this.b) != null) {
                    final b b = this.a.d.remove(this.b);
                    if (b != null) {
                        b.a(this.b);
                    }
                }
                else {
                    h.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.b), new Throwable[0]);
                }
            }
        }
    }
}
