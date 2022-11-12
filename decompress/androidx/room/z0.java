// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

class z0 implements Executor
{
    private final Executor a;
    private final ArrayDeque<Runnable> b;
    private Runnable c;
    
    z0(final Executor a) {
        this.b = new ArrayDeque<Runnable>();
        this.a = a;
    }
    
    void a() {
        synchronized (this) {
            final Runnable c = this.b.poll();
            this.c = c;
            if (c != null) {
                this.a.execute(c);
            }
        }
    }
    
    @Override
    public void execute(final Runnable runnable) {
        synchronized (this) {
            this.b.offer(new Runnable(this, runnable) {
                final Runnable a;
                final z0 b;
                
                @Override
                public void run() {
                    try {
                        this.a.run();
                    }
                    finally {
                        this.b.a();
                    }
                }
            });
            if (this.c == null) {
                this.a();
            }
        }
    }
}
