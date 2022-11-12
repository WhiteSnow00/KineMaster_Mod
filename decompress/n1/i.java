// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import m1.q;
import f1.d;
import androidx.work.impl.WorkDatabase;
import androidx.work.WorkInfo;
import e1.h;

public class i implements Runnable
{
    private static final String d;
    private final f1.i a;
    private final String b;
    private final boolean c;
    
    static {
        d = h.f("StopWorkRunnable");
    }
    
    public i(final f1.i a, final String b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void run() {
        final WorkDatabase o = this.a.o();
        final d m = this.a.m();
        final q l = o.l();
        o.beginTransaction();
        try {
            final boolean h = m.h(this.b);
            boolean b;
            if (this.c) {
                b = this.a.m().n(this.b);
            }
            else {
                if (!h && l.f(this.b) == WorkInfo.State.RUNNING) {
                    l.b(WorkInfo.State.ENQUEUED, this.b);
                }
                b = this.a.m().o(this.b);
            }
            e1.h.c().a(i.d, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.b, b), new Throwable[0]);
            o.setTransactionSuccessful();
        }
        finally {
            o.endTransaction();
        }
    }
}
