// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import androidx.work.WorkInfo;
import androidx.work.impl.utils.futures.b;
import com.google.common.util.concurrent.ListenableFuture;
import e1.c;
import java.util.UUID;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import e1.h;
import m1.q;
import o1.a;
import e1.d;

public class l implements d
{
    private static final String d;
    private final a a;
    final l1.a b;
    final q c;
    
    static {
        d = h.f("WMFgUpdater");
    }
    
    public l(final WorkDatabase workDatabase, final l1.a b, final a a) {
        this.b = b;
        this.a = a;
        this.c = workDatabase.l();
    }
    
    @Override
    public ListenableFuture<Void> a(final Context context, final UUID uuid, final c c) {
        final b<Object> t = androidx.work.impl.utils.futures.b.t();
        this.a.b(new Runnable(this, t, uuid, c, context) {
            final b a;
            final UUID b;
            final c c;
            final Context d;
            final l e;
            
            @Override
            public void run() {
                try {
                    if (!this.a.isCancelled()) {
                        final String string = this.b.toString();
                        final WorkInfo.State f = this.e.c.f(string);
                        if (f == null || f.isFinished()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        this.e.b.b(string, this.c);
                        this.d.startService(androidx.work.impl.foreground.a.a(this.d, string, this.c));
                    }
                    this.a.p(null);
                }
                finally {
                    final Throwable t;
                    this.a.q(t);
                }
            }
        });
        return (ListenableFuture<Void>)t;
    }
}
