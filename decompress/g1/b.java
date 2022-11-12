// 
// Decompiled by Procyon v0.6.0
// 

package g1;

import java.util.Collection;
import android.text.TextUtils;
import androidx.work.WorkInfo;
import java.util.List;
import java.util.Iterator;
import n1.f;
import java.util.HashSet;
import e1.h;
import m1.p;
import java.util.Set;
import i1.d;
import f1.i;
import android.content.Context;
import i1.c;
import f1.e;

public class b implements e, c, f1.b
{
    private static final String i;
    private final Context a;
    private final i b;
    private final d c;
    private final Set<p> d;
    private a e;
    private boolean f;
    private final Object g;
    Boolean h;
    
    static {
        i = h.f("GreedyScheduler");
    }
    
    public b(final Context a, final androidx.work.a a2, final o1.a a3, final i b) {
        this.d = new HashSet<p>();
        this.a = a;
        this.b = b;
        this.c = new d(a, a3, this);
        this.e = new a(this, a2.k());
        this.g = new Object();
    }
    
    private void g() {
        this.h = n1.f.b(this.a, this.b.i());
    }
    
    private void h() {
        if (!this.f) {
            this.b.m().c(this);
            this.f = true;
        }
    }
    
    private void i(final String s) {
        synchronized (this.g) {
            for (final p p : this.d) {
                if (p.a.equals(s)) {
                    e1.h.c().a(g1.b.i, String.format("Stopping tracking for %s", s), new Throwable[0]);
                    this.d.remove(p);
                    this.c.d(this.d);
                    break;
                }
            }
        }
    }
    
    @Override
    public void a(final String s) {
        if (this.h == null) {
            this.g();
        }
        if (!this.h) {
            e1.h.c().d(g1.b.i, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        this.h();
        e1.h.c().a(g1.b.i, String.format("Cancelling work ID %s", s), new Throwable[0]);
        final a e = this.e;
        if (e != null) {
            e.b(s);
        }
        this.b.x(s);
    }
    
    @Override
    public void b(final List<String> list) {
        for (final String s : list) {
            e1.h.c().a(g1.b.i, String.format("Constraints not met: Cancelling work ID %s", s), new Throwable[0]);
            this.b.x(s);
        }
    }
    
    @Override
    public void c(final p... array) {
        if (this.h == null) {
            this.g();
        }
        if (!this.h) {
            e1.h.c().d(g1.b.i, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        this.h();
        final HashSet set = new HashSet();
        final HashSet set2 = new HashSet();
        for (final p p : array) {
            final long a = p.a();
            final long currentTimeMillis = System.currentTimeMillis();
            if (p.b == WorkInfo.State.ENQUEUED) {
                if (currentTimeMillis < a) {
                    final a e = this.e;
                    if (e != null) {
                        e.a(p);
                    }
                }
                else if (p.b()) {
                    if (p.j.h()) {
                        e1.h.c().a(g1.b.i, String.format("Ignoring WorkSpec %s, Requires device idle.", p), new Throwable[0]);
                    }
                    else if (p.j.e()) {
                        e1.h.c().a(g1.b.i, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", p), new Throwable[0]);
                    }
                    else {
                        set.add(p);
                        set2.add(p.a);
                    }
                }
                else {
                    e1.h.c().a(g1.b.i, String.format("Starting work for %s", p.a), new Throwable[0]);
                    this.b.u(p.a);
                }
            }
        }
        synchronized (this.g) {
            if (!set.isEmpty()) {
                e1.h.c().a(g1.b.i, String.format("Starting tracking for [%s]", TextUtils.join((CharSequence)",", (Iterable)set2)), new Throwable[0]);
                this.d.addAll(set);
                this.c.d(this.d);
            }
        }
    }
    
    @Override
    public boolean d() {
        return false;
    }
    
    @Override
    public void e(final String s, final boolean b) {
        this.i(s);
    }
    
    @Override
    public void f(final List<String> list) {
        for (final String s : list) {
            e1.h.c().a(g1.b.i, String.format("Constraints met: Scheduling work ID %s", s), new Throwable[0]);
            this.b.u(s);
        }
    }
}
