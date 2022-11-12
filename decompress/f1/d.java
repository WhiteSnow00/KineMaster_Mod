// 
// Decompiled by Procyon v0.6.0
// 

package f1;

import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import com.google.common.util.concurrent.ListenableFuture;
import androidx.work.WorkerParameters;
import java.util.Iterator;
import e1.c;
import android.content.Intent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import e1.h;
import java.util.Set;
import java.util.List;
import java.util.Map;
import androidx.work.impl.WorkDatabase;
import android.content.Context;
import android.os.PowerManager$WakeLock;
import l1.a;

public class d implements b, l1.a
{
    private static final String w;
    private PowerManager$WakeLock a;
    private Context b;
    private androidx.work.a c;
    private o1.a d;
    private WorkDatabase e;
    private Map<String, j> f;
    private Map<String, j> g;
    private List<e> h;
    private Set<String> i;
    private final List<b> j;
    private final Object p;
    
    static {
        w = h.f("Processor");
    }
    
    public d(final Context b, final androidx.work.a c, final o1.a d, final WorkDatabase e, final List<e> h) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.g = new HashMap<String, j>();
        this.f = new HashMap<String, j>();
        this.h = h;
        this.i = new HashSet<String>();
        this.j = new ArrayList<b>();
        this.a = null;
        this.p = new Object();
    }
    
    private static boolean d(final String s, final j j) {
        if (j != null) {
            j.d();
            h.c().a(d.w, String.format("WorkerWrapper interrupted for %s", s), new Throwable[0]);
            return true;
        }
        h.c().a(d.w, String.format("WorkerWrapper could not be found for %s", s), new Throwable[0]);
        return false;
    }
    
    private void m() {
        synchronized (this.p) {
            if (!(this.f.isEmpty() ^ true)) {
                final Intent d = androidx.work.impl.foreground.a.d(this.b);
                try {
                    this.b.startService(d);
                }
                finally {
                    final Throwable t;
                    e1.h.c().b(f1.d.w, "Unable to stop foreground service", t);
                }
                final PowerManager$WakeLock a = this.a;
                if (a != null) {
                    a.release();
                    this.a = null;
                }
            }
        }
    }
    
    @Override
    public void a(final String s) {
        synchronized (this.p) {
            this.f.remove(s);
            this.m();
        }
    }
    
    @Override
    public void b(final String s, final c c) {
        synchronized (this.p) {
            e1.h.c().d(f1.d.w, String.format("Moving WorkSpec (%s) to the foreground", s), new Throwable[0]);
            final j j = this.g.remove(s);
            if (j != null) {
                if (this.a == null) {
                    (this.a = n1.j.b(this.b, "ProcessorForegroundLck")).acquire();
                }
                this.f.put(s, j);
                androidx.core.content.a.startForegroundService(this.b, androidx.work.impl.foreground.a.c(this.b, s, c));
            }
        }
    }
    
    public void c(final b b) {
        synchronized (this.p) {
            this.j.add(b);
        }
    }
    
    @Override
    public void e(final String s, final boolean b) {
        synchronized (this.p) {
            this.g.remove(s);
            e1.h.c().a(f1.d.w, String.format("%s %s executed; reschedule = %s", this.getClass().getSimpleName(), s, b), new Throwable[0]);
            final Iterator<b> iterator = this.j.iterator();
            while (iterator.hasNext()) {
                iterator.next().e(s, b);
            }
        }
    }
    
    public boolean f(final String s) {
        synchronized (this.p) {
            return this.i.contains(s);
        }
    }
    
    public boolean g(final String s) {
        synchronized (this.p) {
            return this.g.containsKey(s) || this.f.containsKey(s);
        }
    }
    
    public boolean h(final String s) {
        synchronized (this.p) {
            return this.f.containsKey(s);
        }
    }
    
    public void i(final b b) {
        synchronized (this.p) {
            this.j.remove(b);
        }
    }
    
    public boolean j(final String s) {
        return this.k(s, null);
    }
    
    public boolean k(final String s, final WorkerParameters.a a) {
        synchronized (this.p) {
            if (this.g(s)) {
                e1.h.c().a(f1.d.w, String.format("Work %s is already enqueued for processing", s), new Throwable[0]);
                return false;
            }
            final j a2 = new j.c(this.b, this.c, this.d, this, this.e, s).c(this.h).b(a).a();
            final ListenableFuture<Boolean> b = a2.b();
            b.f((Runnable)new a(this, s, b), this.d.a());
            this.g.put(s, a2);
            monitorexit(this.p);
            this.d.c().execute(a2);
            e1.h.c().a(f1.d.w, String.format("%s: processing %s", this.getClass().getSimpleName(), s), new Throwable[0]);
            return true;
        }
    }
    
    public boolean l(final String s) {
        synchronized (this.p) {
            final h c = e1.h.c();
            final String w = f1.d.w;
            boolean b = true;
            c.a(w, String.format("Processor cancelling %s", s), new Throwable[0]);
            this.i.add(s);
            final j j = this.f.remove(s);
            if (j == null) {
                b = false;
            }
            j i = j;
            if (j == null) {
                i = this.g.remove(s);
            }
            final boolean d = d(s, i);
            if (b) {
                this.m();
            }
            return d;
        }
    }
    
    public boolean n(final String s) {
        synchronized (this.p) {
            e1.h.c().a(f1.d.w, String.format("Processor stopping foreground work %s", s), new Throwable[0]);
            return d(s, this.f.remove(s));
        }
    }
    
    public boolean o(final String s) {
        synchronized (this.p) {
            e1.h.c().a(f1.d.w, String.format("Processor stopping background work %s", s), new Throwable[0]);
            return d(s, this.g.remove(s));
        }
    }
    
    private static class a implements Runnable
    {
        private b a;
        private String b;
        private ListenableFuture<Boolean> c;
        
        a(final b a, final String b, final ListenableFuture<Boolean> c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public void run() {
            boolean booleanValue;
            try {
                booleanValue = ((Future<Boolean>)this.c).get();
            }
            catch (final InterruptedException | ExecutionException ex) {
                booleanValue = true;
            }
            this.a.e(this.b, booleanValue);
        }
    }
}
