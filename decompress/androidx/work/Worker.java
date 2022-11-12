// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import androidx.annotation.Keep;
import android.content.Context;
import androidx.work.impl.utils.futures.b;

public abstract class Worker extends ListenableWorker
{
    b<a> f;
    
    @Keep
    public Worker(final Context context, final WorkerParameters workerParameters) {
        super(context, workerParameters);
    }
    
    public abstract a doWork();
    
    @Override
    public final ListenableFuture<a> startWork() {
        this.f = androidx.work.impl.utils.futures.b.t();
        this.getBackgroundExecutor().execute(new Runnable(this) {
            final Worker a;
            
            @Override
            public void run() {
                try {
                    this.a.f.p(this.a.doWork());
                }
                finally {
                    final Throwable t;
                    this.a.f.q(t);
                }
            }
        });
        return (ListenableFuture<a>)this.f;
    }
}
