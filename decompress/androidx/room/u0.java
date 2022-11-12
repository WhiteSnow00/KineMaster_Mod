// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.concurrent.Executor;
import i.a;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.Callable;
import androidx.lifecycle.LiveData;

class u0<T> extends LiveData<T>
{
    final RoomDatabase a;
    final boolean b;
    final Callable<T> c;
    private final u d;
    final w.c e;
    final AtomicBoolean f;
    final AtomicBoolean g;
    final AtomicBoolean h;
    final Runnable i;
    final Runnable j;
    
    u0(final RoomDatabase a, final u d, final boolean b, final Callable<T> c, final String[] array) {
        this.f = new AtomicBoolean(true);
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = new Runnable() {
            final u0 a;
            
            @Override
            public void run() {
                if (this.a.h.compareAndSet(false, true)) {
                    this.a.a.getInvalidationTracker().b(this.a.e);
                }
                int n;
                do {
                    if (this.a.g.compareAndSet(false, true)) {
                        Object call = null;
                        n = 0;
                        try {
                            while (this.a.f.compareAndSet(true, false)) {
                                try {
                                    call = this.a.c.call();
                                    n = 1;
                                    continue;
                                }
                                catch (final Exception ex) {
                                    throw new RuntimeException("Exception while computing database live data.", ex);
                                }
                                break;
                            }
                            if (n == 0) {
                                continue;
                            }
                            u0.b(this.a, call);
                            continue;
                        }
                        finally {
                            this.a.g.set(false);
                        }
                    }
                    n = 0;
                } while (n != 0 && this.a.f.get());
            }
        };
        this.j = new Runnable() {
            final u0 a;
            
            @Override
            public void run() {
                final boolean hasActiveObservers = this.a.hasActiveObservers();
                if (this.a.f.compareAndSet(false, true) && hasActiveObservers) {
                    this.a.c().execute(this.a.i);
                }
            }
        };
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = new w.c(this, array) {
            final u0 a;
            
            @Override
            public void onInvalidated(final Set<String> set) {
                i.a.f().b(this.a.j);
            }
        };
    }
    
    static void b(final u0 u0, final Object o) {
        u0.postValue(o);
    }
    
    Executor c() {
        if (this.b) {
            return this.a.getTransactionExecutor();
        }
        return this.a.getQueryExecutor();
    }
    
    @Override
    protected void onActive() {
        super.onActive();
        this.d.b(this);
        this.c().execute(this.i);
    }
    
    @Override
    protected void onInactive() {
        super.onInactive();
        this.d.c(this);
    }
}
