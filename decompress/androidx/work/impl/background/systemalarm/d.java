// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.background.systemalarm;

import m1.p;
import java.util.Collections;
import n1.j;
import java.util.List;
import android.content.Intent;
import e1.h;
import android.os.PowerManager$WakeLock;
import android.content.Context;
import n1.n;
import f1.b;
import i1.c;

public class d implements c, b, n.b
{
    private static final String j;
    private final Context a;
    private final int b;
    private final String c;
    private final e d;
    private final i1.d e;
    private final Object f;
    private int g;
    private PowerManager$WakeLock h;
    private boolean i;
    
    static {
        j = h.f("DelayMetCommandHandler");
    }
    
    d(final Context a, final int b, final String c, final e d) {
        this.a = a;
        this.b = b;
        this.d = d;
        this.c = c;
        this.e = new i1.d(a, d.f(), this);
        this.i = false;
        this.g = 0;
        this.f = new Object();
    }
    
    private void c() {
        synchronized (this.f) {
            this.e.e();
            this.d.h().c(this.c);
            final PowerManager$WakeLock h = this.h;
            if (h != null && h.isHeld()) {
                e1.h.c().a(androidx.work.impl.background.systemalarm.d.j, String.format("Releasing wakelock %s for WorkSpec %s", this.h, this.c), new Throwable[0]);
                this.h.release();
            }
        }
    }
    
    private void g() {
        synchronized (this.f) {
            if (this.g < 2) {
                this.g = 2;
                final h c = e1.h.c();
                final String j = androidx.work.impl.background.systemalarm.d.j;
                c.a(j, String.format("Stopping work for WorkSpec %s", this.c), new Throwable[0]);
                final Intent f = androidx.work.impl.background.systemalarm.b.f(this.a, this.c);
                final e d = this.d;
                d.k(new e.b(d, f, this.b));
                if (this.d.d().g(this.c)) {
                    e1.h.c().a(j, String.format("WorkSpec %s needs to be rescheduled", this.c), new Throwable[0]);
                    final Intent d2 = androidx.work.impl.background.systemalarm.b.d(this.a, this.c);
                    final e d3 = this.d;
                    d3.k(new e.b(d3, d2, this.b));
                }
                else {
                    e1.h.c().a(j, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.c), new Throwable[0]);
                }
            }
            else {
                e1.h.c().a(androidx.work.impl.background.systemalarm.d.j, String.format("Already stopped work for %s", this.c), new Throwable[0]);
            }
        }
    }
    
    @Override
    public void a(final String s) {
        e1.h.c().a(androidx.work.impl.background.systemalarm.d.j, String.format("Exceeded time limits on execution for %s", s), new Throwable[0]);
        this.g();
    }
    
    @Override
    public void b(final List<String> list) {
        this.g();
    }
    
    void d() {
        this.h = n1.j.b(this.a, String.format("%s (%s)", this.c, this.b));
        final h c = e1.h.c();
        final String j = androidx.work.impl.background.systemalarm.d.j;
        c.a(j, String.format("Acquiring wakelock %s for WorkSpec %s", this.h, this.c), new Throwable[0]);
        this.h.acquire();
        final p g = this.d.g().o().l().g(this.c);
        if (g == null) {
            this.g();
            return;
        }
        if (!(this.i = g.b())) {
            e1.h.c().a(j, String.format("No constraints for %s", this.c), new Throwable[0]);
            this.f(Collections.singletonList(this.c));
        }
        else {
            this.e.d(Collections.singletonList(g));
        }
    }
    
    @Override
    public void e(final String s, final boolean b) {
        e1.h.c().a(androidx.work.impl.background.systemalarm.d.j, String.format("onExecuted %s, %s", s, b), new Throwable[0]);
        this.c();
        if (b) {
            final Intent d = b.d(this.a, this.c);
            final e d2 = this.d;
            d2.k(new e.b(d2, d, this.b));
        }
        if (this.i) {
            final Intent a = b.a(this.a);
            final e d3 = this.d;
            d3.k(new e.b(d3, a, this.b));
        }
    }
    
    @Override
    public void f(final List<String> list) {
        if (!list.contains(this.c)) {
            return;
        }
        synchronized (this.f) {
            if (this.g == 0) {
                this.g = 1;
                e1.h.c().a(androidx.work.impl.background.systemalarm.d.j, String.format("onAllConstraintsMet for %s", this.c), new Throwable[0]);
                if (this.d.d().j(this.c)) {
                    this.d.h().b(this.c, 600000L, (n.b)this);
                }
                else {
                    this.c();
                }
            }
            else {
                e1.h.c().a(androidx.work.impl.background.systemalarm.d.j, String.format("Already started work for %s", this.c), new Throwable[0]);
            }
        }
    }
}
