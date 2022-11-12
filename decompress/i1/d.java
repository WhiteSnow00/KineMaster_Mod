// 
// Decompiled by Procyon v0.6.0
// 

package i1;

import m1.p;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import j1.e;
import j1.f;
import j1.g;
import j1.b;
import o1.a;
import android.content.Context;
import e1.h;
import j1.c;

public class d implements a
{
    private static final String d;
    private final i1.c a;
    private final c<?>[] b;
    private final Object c;
    
    static {
        d = h.f("WorkConstraintsTracker");
    }
    
    public d(Context applicationContext, final o1.a a, final i1.c a2) {
        applicationContext = applicationContext.getApplicationContext();
        this.a = a2;
        this.b = new c[] { new j1.a(applicationContext, a), new b(applicationContext, a), new j1.h(applicationContext, a), new j1.d(applicationContext, a), new g(applicationContext, a), new f(applicationContext, a), new e(applicationContext, a) };
        this.c = new Object();
    }
    
    @Override
    public void a(final List<String> list) {
        synchronized (this.c) {
            final ArrayList list2 = new ArrayList();
            for (final String s : list) {
                if (this.c(s)) {
                    h.c().a(i1.d.d, String.format("Constraints met for %s", s), new Throwable[0]);
                    list2.add(s);
                }
            }
            final i1.c a = this.a;
            if (a != null) {
                a.f(list2);
            }
        }
    }
    
    @Override
    public void b(final List<String> list) {
        synchronized (this.c) {
            final i1.c a = this.a;
            if (a != null) {
                a.b(list);
            }
        }
    }
    
    public boolean c(final String s) {
        synchronized (this.c) {
            for (final c<?> c : this.b) {
                if (c.d(s)) {
                    h.c().a(i1.d.d, String.format("Work %s constrained by %s", s, c.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }
    
    public void d(final Iterable<p> iterable) {
        synchronized (this.c) {
            final c<?>[] b = this.b;
            final int length = b.length;
            final int n = 0;
            for (int i = 0; i < length; ++i) {
                b[i].g(null);
            }
            final c<?>[] b2 = this.b;
            for (int length2 = b2.length, j = 0; j < length2; ++j) {
                b2[j].e(iterable);
            }
            final c<?>[] b3 = this.b;
            for (int length3 = b3.length, k = n; k < length3; ++k) {
                b3[k].g((c.a)this);
            }
        }
    }
    
    public void e() {
        synchronized (this.c) {
            final c<?>[] b = this.b;
            for (int length = b.length, i = 0; i < length; ++i) {
                b[i].f();
            }
        }
    }
}
