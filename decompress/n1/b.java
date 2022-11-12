// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import f1.f;
import m1.q;
import java.util.Iterator;
import androidx.work.impl.WorkDatabase;
import m1.j;
import m1.s;
import java.util.Collections;
import java.util.ArrayList;
import m1.p;
import android.text.TextUtils;
import androidx.work.WorkInfo;
import androidx.work.ExistingWorkPolicy;
import androidx.work.d;
import java.util.List;
import f1.i;
import e1.h;
import f1.c;
import f1.g;

public class b implements Runnable
{
    private static final String c;
    private final g a;
    private final c b;
    
    static {
        c = h.f("EnqueueRunnable");
    }
    
    public b(final g a) {
        this.a = a;
        this.b = new c();
    }
    
    private static boolean b(final g g) {
        final boolean c = c(g.g(), g.f(), g.l(g).toArray(new String[0]), g.d(), g.b());
        g.k();
        return c;
    }
    
    private static boolean c(final i i, final List<? extends d> list, final String[] array, final String s, final ExistingWorkPolicy existingWorkPolicy) {
        final long currentTimeMillis = System.currentTimeMillis();
        final WorkDatabase o = i.o();
        final boolean b = true;
        final boolean b2 = array != null && array.length > 0;
        int n5;
        int n6;
        int n7;
        if (b2) {
            final int length = array.length;
            int n = 1;
            int n2 = 0;
            int n4;
            int n3 = n4 = 0;
            while (true) {
                n5 = n;
                n6 = n3;
                n7 = n4;
                if (n2 >= length) {
                    break;
                }
                final String s2 = array[n2];
                final p g = o.l().g(s2);
                if (g == null) {
                    h.c().b(n1.b.c, String.format("Prerequisite %s doesn't exist; not enqueuing", s2), new Throwable[0]);
                    return false;
                }
                final WorkInfo.State b3 = g.b;
                n &= ((b3 == WorkInfo.State.SUCCEEDED) ? 1 : 0);
                int n8;
                if (b3 == WorkInfo.State.FAILED) {
                    n8 = 1;
                }
                else {
                    n8 = n4;
                    if (b3 == WorkInfo.State.CANCELLED) {
                        n3 = 1;
                        n8 = n4;
                    }
                }
                ++n2;
                n4 = n8;
            }
        }
        else {
            n5 = 1;
            n6 = 0;
            n7 = 0;
        }
        final boolean b4 = TextUtils.isEmpty((CharSequence)s) ^ true;
        final boolean b5 = b4 && !b2;
        String[] array2 = array;
        boolean b6 = b2;
        int n9 = n5;
        int n10 = n6;
        int n11 = n7;
        String[] array3 = null;
        boolean b8 = false;
        Label_0773: {
            if (b5) {
                final List<p.b> n12 = o.l().n(s);
                array2 = array;
                b6 = b2;
                n9 = n5;
                n10 = n6;
                n11 = n7;
                if (!n12.isEmpty()) {
                    if (existingWorkPolicy != ExistingWorkPolicy.APPEND && existingWorkPolicy != ExistingWorkPolicy.APPEND_OR_REPLACE) {
                        if (existingWorkPolicy == ExistingWorkPolicy.KEEP) {
                            final Iterator iterator = n12.iterator();
                            while (iterator.hasNext()) {
                                final WorkInfo.State b7 = ((p.b)iterator.next()).b;
                                if (b7 == WorkInfo.State.ENQUEUED || b7 == WorkInfo.State.RUNNING) {
                                    return false;
                                }
                            }
                        }
                        a.c(s, i, false).run();
                        final q l = o.l();
                        final Iterator iterator2 = n12.iterator();
                        while (true) {
                            array3 = array;
                            b8 = b;
                            b6 = b2;
                            n9 = n5;
                            n10 = n6;
                            n11 = n7;
                            if (!iterator2.hasNext()) {
                                break Label_0773;
                            }
                            l.a(((p.b)iterator2.next()).a);
                        }
                    }
                    else {
                        final m1.b d = o.d();
                        final ArrayList list2 = new ArrayList();
                        for (final p.b b9 : n12) {
                            boolean b10 = n5 != 0;
                            int n13 = n6;
                            int n14 = n7;
                            if (!d.d(b9.a)) {
                                final WorkInfo.State b11 = b9.b;
                                final boolean b12 = b11 == WorkInfo.State.SUCCEEDED;
                                if (b11 == WorkInfo.State.FAILED) {
                                    n14 = 1;
                                }
                                else {
                                    n14 = n7;
                                    if (b11 == WorkInfo.State.CANCELLED) {
                                        n6 = 1;
                                        n14 = n7;
                                    }
                                }
                                list2.add(b9.a);
                                b10 = (((b12 ? 1 : 0) & n5) != 0x0);
                                n13 = n6;
                            }
                            n5 = (b10 ? 1 : 0);
                            n6 = n13;
                            n7 = n14;
                        }
                        n10 = n6;
                        n11 = n7;
                        List<Object> emptyList = list2;
                        Label_0732: {
                            if (existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE) {
                                if (n6 == 0) {
                                    n10 = n6;
                                    n11 = n7;
                                    emptyList = list2;
                                    if (n7 == 0) {
                                        break Label_0732;
                                    }
                                }
                                final q j = o.l();
                                final Iterator<p.b> iterator4 = j.n(s).iterator();
                                while (iterator4.hasNext()) {
                                    j.a(iterator4.next().a);
                                }
                                emptyList = Collections.emptyList();
                                n10 = 0;
                                n11 = 0;
                            }
                        }
                        array2 = emptyList.toArray(array);
                        if (array2.length > 0) {
                            b6 = true;
                            n9 = n5;
                        }
                        else {
                            b6 = false;
                            n9 = n5;
                        }
                    }
                }
            }
            b8 = false;
            array3 = array2;
        }
        Iterator<? extends d> iterator6;
        for (Iterator<? extends d> iterator5 = list.iterator(); iterator5.hasNext(); iterator5 = iterator6) {
            final d d2 = (d)iterator5.next();
            final p c = d2.c();
            if (b6 && n9 == 0) {
                if (n11 != 0) {
                    c.b = WorkInfo.State.FAILED;
                }
                else if (n10 != 0) {
                    c.b = WorkInfo.State.CANCELLED;
                }
                else {
                    c.b = WorkInfo.State.BLOCKED;
                }
            }
            else if (!c.d()) {
                c.n = currentTimeMillis;
            }
            else {
                c.n = 0L;
            }
            if (c.b == WorkInfo.State.ENQUEUED) {
                b8 = true;
            }
            o.l().m(c);
            String[] array4 = array3;
            iterator6 = iterator5;
            if (b6) {
                final int length2 = array3.length;
                int n15 = 0;
                while (true) {
                    array4 = array3;
                    iterator6 = iterator5;
                    if (n15 >= length2) {
                        break;
                    }
                    o.d().c(new m1.a(d2.a(), array3[n15]));
                    ++n15;
                }
            }
            final Iterator<String> iterator7 = d2.b().iterator();
            while (iterator7.hasNext()) {
                o.m().a(new s(iterator7.next(), d2.a()));
            }
            if (b4) {
                o.j().a(new j(s, d2.a()));
            }
            array3 = array4;
        }
        return b8;
    }
    
    private static boolean e(final g g) {
        final List<g> e = g.e();
        boolean b = false;
        if (e != null) {
            final Iterator<g> iterator = e.iterator();
            b = false;
            while (iterator.hasNext()) {
                final g g2 = iterator.next();
                if (!g2.j()) {
                    b |= e(g2);
                }
                else {
                    h.c().h(n1.b.c, String.format("Already enqueued work ids (%s).", TextUtils.join((CharSequence)", ", (Iterable)g2.c())), new Throwable[0]);
                }
            }
        }
        return b(g) | b;
    }
    
    public boolean a() {
        final WorkDatabase o = this.a.g().o();
        o.beginTransaction();
        try {
            final boolean e = e(this.a);
            o.setTransactionSuccessful();
            return e;
        }
        finally {
            o.endTransaction();
        }
    }
    
    public e1.i d() {
        return this.b;
    }
    
    public void f() {
        final i g = this.a.g();
        f.b(g.i(), g.o(), g.n());
    }
    
    @Override
    public void run() {
        try {
            if (this.a.h()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.a));
            }
            if (this.a()) {
                n1.d.a(this.a.g().h(), RescheduleReceiver.class, true);
                this.f();
            }
            this.b.a((e1.i.b)e1.i.a);
        }
        finally {
            final Throwable t;
            this.b.a((e1.i.b)new e1.i.b.a(t));
        }
    }
}
