// 
// Decompiled by Procyon v0.6.0
// 

package o1;

import android.os.Looper;
import java.util.concurrent.Executor;
import android.os.Handler;
import n1.g;

public class b implements a
{
    private final g a;
    private final Handler b;
    private final Executor c;
    
    public b(final Executor executor) {
        this.b = new Handler(Looper.getMainLooper());
        this.c = new Executor() {
            final b a;
            
            @Override
            public void execute(final Runnable runnable) {
                this.a.d(runnable);
            }
        };
        this.a = new g(executor);
    }
    
    @Override
    public Executor a() {
        return this.c;
    }
    
    @Override
    public void b(final Runnable runnable) {
        this.a.execute(runnable);
    }
    
    @Override
    public g c() {
        return this.a;
    }
    
    public void d(final Runnable runnable) {
        this.b.post(runnable);
    }
}
