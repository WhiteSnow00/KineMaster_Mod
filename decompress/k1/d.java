// 
// Decompiled by Procyon v0.6.0
// 

package k1;

import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import e1.h;
import java.util.Set;
import android.content.Context;
import o1.a;

public abstract class d<T>
{
    private static final String f;
    protected final a a;
    protected final Context b;
    private final Object c;
    private final Set<i1.a<T>> d;
    T e;
    
    static {
        f = h.f("ConstraintTracker");
    }
    
    d(final Context context, final a a) {
        this.c = new Object();
        this.d = new LinkedHashSet<i1.a<T>>();
        this.b = context.getApplicationContext();
        this.a = a;
    }
    
    public void a(final i1.a<T> a) {
        synchronized (this.c) {
            if (this.d.add(a)) {
                if (this.d.size() == 1) {
                    this.e = this.b();
                    h.c().a(k1.d.f, String.format("%s: initial state = %s", this.getClass().getSimpleName(), this.e), new Throwable[0]);
                    this.e();
                }
                a.a(this.e);
            }
        }
    }
    
    public abstract T b();
    
    public void c(final i1.a<T> a) {
        synchronized (this.c) {
            if (this.d.remove(a) && this.d.isEmpty()) {
                this.f();
            }
        }
    }
    
    public void d(final T e) {
        synchronized (this.c) {
            final T e2 = this.e;
            if (e2 != e && (e2 == null || !e2.equals(e))) {
                this.e = e;
                this.a.a().execute(new Runnable(this, new ArrayList(this.d)) {
                    final List a;
                    final d b;
                    
                    @Override
                    public void run() {
                        final Iterator iterator = this.a.iterator();
                        while (iterator.hasNext()) {
                            ((i1.a<T>)iterator.next()).a(this.b.e);
                        }
                    }
                });
            }
        }
    }
    
    public abstract void e();
    
    public abstract void f();
}
