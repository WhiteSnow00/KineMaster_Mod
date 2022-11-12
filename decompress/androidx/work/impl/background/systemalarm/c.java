// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import m1.p;
import e1.h;
import i1.d;
import android.content.Context;

class c
{
    private static final String e;
    private final Context a;
    private final int b;
    private final e c;
    private final d d;
    
    static {
        e = h.f("ConstraintsCmdHandler");
    }
    
    c(final Context a, final int b, final e c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = new d(a, c.f(), null);
    }
    
    void a() {
        final List<p> d = this.c.g().o().l().d();
        ConstraintProxy.a(this.a, d);
        this.d.d(d);
        final ArrayList list = new ArrayList(d.size());
        final long currentTimeMillis = System.currentTimeMillis();
        for (final p p : d) {
            final String a = p.a;
            if (currentTimeMillis >= p.a() && (!p.b() || this.d.c(a))) {
                list.add((Object)p);
            }
        }
        final Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            final String a2 = ((p)iterator2.next()).a;
            final Intent b = androidx.work.impl.background.systemalarm.b.b(this.a, a2);
            h.c().a(androidx.work.impl.background.systemalarm.c.e, String.format("Creating a delay_met command for workSpec with id (%s)", a2), new Throwable[0]);
            final e c = this.c;
            c.k(new e.b(c, b, this.b));
        }
        this.d.e();
    }
}
