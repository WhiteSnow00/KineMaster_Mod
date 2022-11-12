// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import m1.p;
import androidx.work.WorkInfo;
import com.google.common.util.concurrent.ListenableFuture;
import androidx.work.b;
import java.util.UUID;
import android.content.Context;
import e1.h;
import o1.a;
import androidx.work.impl.WorkDatabase;
import e1.j;

public class m implements j
{
    static final String c;
    final WorkDatabase a;
    final a b;
    
    static {
        c = h.f("WorkProgressUpdater");
    }
    
    public m(final WorkDatabase a, final a b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public ListenableFuture<Void> a(final Context context, final UUID uuid, final b b) {
        final androidx.work.impl.utils.futures.b<Object> t = androidx.work.impl.utils.futures.b.t();
        this.b.b(new Runnable(this, uuid, b, t) {
            final UUID a;
            final b b;
            final androidx.work.impl.utils.futures.b c;
            final m d;
            
            @Override
            public void run() {
                final String string = this.a.toString();
                final h c = h.c();
                final String c2 = m.c;
                c.a(c2, String.format("Updating progress for %s (%s)", this.a, this.b), new Throwable[0]);
                this.d.a.beginTransaction();
                final Throwable t2;
                try {
                    final p g = this.d.a.l().g(string);
                    if (g != null) {
                        if (g.b == WorkInfo.State.RUNNING) {
                            this.d.a.k().b(new m1.m(string, this.b));
                        }
                        else {
                            h.c().h(c2, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", string), new Throwable[0]);
                        }
                        this.c.p(null);
                        this.d.a.setTransactionSuccessful();
                        return;
                    }
                    throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                finally {
                    final h h = e1.h.c();
                    final String s = m.c;
                    final String s2 = "Error updating Worker progress";
                    final int n = 1;
                    final Throwable[] array = new Throwable[n];
                    final int n2 = 0;
                    final Throwable t = t2;
                    array[n2] = t;
                    h.b(s, s2, array);
                    final Runnable runnable = this;
                    final androidx.work.impl.utils.futures.b b = runnable.c;
                    final Throwable t3 = t2;
                    b.q(t3);
                }
                try {
                    final h h = e1.h.c();
                    final String s = m.c;
                    final String s2 = "Error updating Worker progress";
                    final int n = 1;
                    final Throwable[] array = new Throwable[n];
                    final int n2 = 0;
                    final Throwable t = t2;
                    array[n2] = t;
                    h.b(s, s2, array);
                    final Runnable runnable = this;
                    final androidx.work.impl.utils.futures.b b = runnable.c;
                    final Throwable t3 = t2;
                    b.q(t3);
                }
                finally {
                    this.d.a.endTransaction();
                }
            }
        });
        return (ListenableFuture<Void>)t;
    }
}
