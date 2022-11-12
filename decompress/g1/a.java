// 
// Decompiled by Procyon v0.6.0
// 

package g1;

import m1.p;
import java.util.HashMap;
import e1.h;
import java.util.Map;
import e1.l;

public class a
{
    static final String d;
    final b a;
    private final l b;
    private final Map<String, Runnable> c;
    
    static {
        d = h.f("DelayedWorkTracker");
    }
    
    public a(final b a, final l b) {
        this.a = a;
        this.b = b;
        this.c = new HashMap<String, Runnable>();
    }
    
    public void a(final p p) {
        final Runnable runnable = this.c.remove(p.a);
        if (runnable != null) {
            this.b.a(runnable);
        }
        final Runnable runnable2 = new Runnable(this, p) {
            final p a;
            final a b;
            
            @Override
            public void run() {
                h.c().a(g1.a.d, String.format("Scheduling work %s", this.a.a), new Throwable[0]);
                this.b.a.c(this.a);
            }
        };
        this.c.put(p.a, runnable2);
        this.b.b(p.a() - System.currentTimeMillis(), runnable2);
    }
    
    public void b(final String s) {
        final Runnable runnable = this.c.remove(s);
        if (runnable != null) {
            this.b.a(runnable);
        }
    }
}
