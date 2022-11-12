// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class g implements Executor
{
    private final ArrayDeque<a> a;
    private final Executor b;
    private final Object c;
    private volatile Runnable d;
    
    public g(final Executor b) {
        this.b = b;
        this.a = new ArrayDeque<a>();
        this.c = new Object();
    }
    
    public boolean a() {
        synchronized (this.c) {
            return !this.a.isEmpty();
        }
    }
    
    void b() {
        synchronized (this.c) {
            final Runnable d = this.a.poll();
            this.d = d;
            if (d != null) {
                this.b.execute(this.d);
            }
        }
    }
    
    @Override
    public void execute(final Runnable runnable) {
        synchronized (this.c) {
            this.a.add(new a(this, runnable));
            if (this.d == null) {
                this.b();
            }
        }
    }
    
    static class a implements Runnable
    {
        final g a;
        final Runnable b;
        
        a(final g a, final Runnable b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void run() {
            try {
                this.b.run();
            }
            finally {
                this.a.b();
            }
        }
    }
}
