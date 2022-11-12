// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.workers;

import m1.q;
import androidx.work.impl.WorkDatabase;
import java.util.concurrent.TimeUnit;
import f1.i;
import androidx.work.ListenableWorker;
import m1.g;
import java.util.Iterator;
import android.text.TextUtils;
import java.util.List;
import m1.t;
import m1.k;
import m1.p;
import androidx.work.WorkerParameters;
import android.content.Context;
import e1.h;
import androidx.work.Worker;

public class DiagnosticsWorker extends Worker
{
    private static final String g;
    
    static {
        g = h.f("DiagnosticsWrkr");
    }
    
    public DiagnosticsWorker(final Context context, final WorkerParameters workerParameters) {
        super(context, workerParameters);
    }
    
    private static String a(final p p4, final String s, final Integer n, final String s2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", p4.a, p4.c, n, p4.b.name(), s, s2);
    }
    
    private static String c(final k k, final t t, final m1.h h, final List<p> list) {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", "Job Id"));
        for (final p p4 : list) {
            Integer value = null;
            final g a = h.a(p4.a);
            if (a != null) {
                value = a.b;
            }
            sb.append(a(p4, TextUtils.join((CharSequence)",", (Iterable)k.b(p4.a)), value, TextUtils.join((CharSequence)",", (Iterable)t.b(p4.a))));
        }
        return sb.toString();
    }
    
    @Override
    public a doWork() {
        final WorkDatabase o = i.k(this.getApplicationContext()).o();
        final q l = o.l();
        final k j = o.j();
        final t m = o.m();
        final m1.h i = o.i();
        final List<p> c = l.c(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        final List<p> q = l.q();
        final List<p> k = l.j(200);
        if (c != null && !c.isEmpty()) {
            final h c2 = h.c();
            final String g = DiagnosticsWorker.g;
            c2.d(g, "Recently completed work:\n\n", new Throwable[0]);
            h.c().d(g, c(j, m, i, c), new Throwable[0]);
        }
        if (q != null && !q.isEmpty()) {
            final h c3 = h.c();
            final String g2 = DiagnosticsWorker.g;
            c3.d(g2, "Running work:\n\n", new Throwable[0]);
            h.c().d(g2, c(j, m, i, q), new Throwable[0]);
        }
        if (k != null && !k.isEmpty()) {
            final h c4 = h.c();
            final String g3 = DiagnosticsWorker.g;
            c4.d(g3, "Enqueued work:\n\n", new Throwable[0]);
            h.c().d(g3, c(j, m, i, k), new Throwable[0]);
        }
        return ListenableWorker.a.c();
    }
}
