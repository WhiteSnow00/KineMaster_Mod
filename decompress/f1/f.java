// 
// Decompiled by Procyon v0.6.0
// 

package f1;

import java.util.Iterator;
import m1.q;
import m1.p;
import java.util.List;
import androidx.work.impl.WorkDatabase;
import androidx.work.a;
import n1.d;
import androidx.work.impl.background.systemjob.SystemJobService;
import h1.b;
import android.content.Context;
import e1.h;

public class f
{
    private static final String a;
    
    static {
        a = h.f("Schedulers");
    }
    
    static e a(final Context context, final i i) {
        final b b = new b(context, i);
        d.a(context, SystemJobService.class, true);
        h.c().a(f.a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
        return b;
    }
    
    public static void b(final a a, WorkDatabase iterator, final List<e> list) {
        if (list != null) {
            if (list.size() != 0) {
                final q l = iterator.l();
                iterator.beginTransaction();
                try {
                    final List<p> o = l.o(a.h());
                    final List<p> j = l.j(200);
                    if (o != null && o.size() > 0) {
                        final long currentTimeMillis = System.currentTimeMillis();
                        final Iterator iterator2 = o.iterator();
                        while (iterator2.hasNext()) {
                            l.l(((p)iterator2.next()).a, currentTimeMillis);
                        }
                    }
                    iterator.setTransactionSuccessful();
                    iterator.endTransaction();
                    if (o != null && o.size() > 0) {
                        iterator = (WorkDatabase)(Object)o.toArray(new p[o.size()]);
                        for (final e e : list) {
                            if (e.d()) {
                                e.c((p[])(Object)iterator);
                            }
                        }
                    }
                    if (j != null && j.size() > 0) {
                        final p[] array = j.toArray(new p[j.size()]);
                        iterator = (WorkDatabase)list.iterator();
                        while (((Iterator)iterator).hasNext()) {
                            final e e2 = ((Iterator<e>)iterator).next();
                            if (!e2.d()) {
                                e2.c(array);
                            }
                        }
                    }
                }
                finally {
                    iterator.endTransaction();
                }
            }
        }
    }
}
