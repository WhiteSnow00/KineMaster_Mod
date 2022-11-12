// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import e1.c;
import com.google.common.util.concurrent.ListenableFuture;
import e1.h;
import o1.a;
import e1.d;
import androidx.work.ListenableWorker;
import m1.p;
import android.content.Context;
import androidx.work.impl.utils.futures.b;

public class k implements Runnable
{
    static final String g;
    final b<Void> a;
    final Context b;
    final p c;
    final ListenableWorker d;
    final d e;
    final a f;
    
    static {
        g = h.f("WorkForegroundRunnable");
    }
    
    public k(final Context b, final p c, final ListenableWorker d, final d e, final a f) {
        this.a = androidx.work.impl.utils.futures.b.t();
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public ListenableFuture<Void> a() {
        return (ListenableFuture<Void>)this.a;
    }
    
    @Override
    public void run() {
        if (this.c.q && !androidx.core.os.a.c()) {
            final b<Object> t = androidx.work.impl.utils.futures.b.t();
            this.f.a().execute(new Runnable(this, t) {
                final b a;
                final k b;
                
                @Override
                public void run() {
                    this.a.r(this.b.d.getForegroundInfoAsync());
                }
            });
            t.f(new Runnable(this, t) {
                final b a;
                final k b;
                
                @Override
                public void run() {
                    try {
                        final c c = (c)this.a.get();
                        if (c == null) {
                            throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", this.b.c.c));
                        }
                        h.c().a(k.g, String.format("Updating notification for %s", this.b.c.c), new Throwable[0]);
                        this.b.d.setRunInForeground(true);
                        final k b = this.b;
                        b.a.r(b.e.a(b.b, b.d.getId(), c));
                    }
                    finally {
                        final Throwable t;
                        this.b.a.q(t);
                    }
                }
            }, this.f.a());
            return;
        }
        this.a.p(null);
    }
}
