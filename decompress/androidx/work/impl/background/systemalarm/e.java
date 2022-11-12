// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.background.systemalarm;

import n1.g;
import android.text.TextUtils;
import android.os.PowerManager$WakeLock;
import n1.j;
import java.util.Iterator;
import android.os.Looper;
import java.util.ArrayList;
import e1.h;
import android.content.Intent;
import java.util.List;
import android.os.Handler;
import f1.i;
import f1.d;
import n1.n;
import o1.a;
import android.content.Context;
import f1.b;

public class e implements f1.b
{
    static final String p;
    final Context a;
    private final a b;
    private final n c;
    private final f1.d d;
    private final i e;
    final androidx.work.impl.background.systemalarm.b f;
    private final Handler g;
    final List<Intent> h;
    Intent i;
    private c j;
    
    static {
        p = h.f("SystemAlarmDispatcher");
    }
    
    e(final Context context) {
        this(context, null, null);
    }
    
    e(final Context context, f1.d m, i k) {
        final Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f = new androidx.work.impl.background.systemalarm.b(applicationContext);
        this.c = new n();
        if (k == null) {
            k = f1.i.k(context);
        }
        this.e = k;
        if (m == null) {
            m = k.m();
        }
        this.d = m;
        this.b = k.p();
        m.c(this);
        this.h = new ArrayList<Intent>();
        this.i = null;
        this.g = new Handler(Looper.getMainLooper());
    }
    
    private void b() {
        if (this.g.getLooper().getThread() == Thread.currentThread()) {
            return;
        }
        throw new IllegalStateException("Needs to be invoked on the main thread.");
    }
    
    private boolean i(final String s) {
        this.b();
        synchronized (this.h) {
            final Iterator<Intent> iterator = this.h.iterator();
            while (iterator.hasNext()) {
                if (s.equals(iterator.next().getAction())) {
                    return true;
                }
            }
            return false;
        }
    }
    
    private void l() {
        this.b();
        final PowerManager$WakeLock b = n1.j.b(this.a, "ProcessCommand");
        try {
            b.acquire();
            this.e.p().b(new Runnable(this) {
                final e a;
                
                @Override
                public void run() {
                    Object o = this.a.h;
                    synchronized (o) {
                        final e a = this.a;
                        a.i = a.h.get(0);
                        monitorexit(o);
                        o = this.a.i;
                        if (o != null) {
                            o = ((Intent)o).getAction();
                            final int intExtra = this.a.i.getIntExtra("KEY_START_ID", 0);
                            final h c = e1.h.c();
                            final String p = androidx.work.impl.background.systemalarm.e.p;
                            c.a(p, String.format("Processing command %s, %s", this.a.i, intExtra), new Throwable[0]);
                            Object b = n1.j.b(this.a.a, String.format("%s (%s)", o, intExtra));
                            Label_0323: {
                                final Throwable t2;
                                try {
                                    e1.h.c().a(p, String.format("Acquiring operation wake lock (%s) %s", o, b), new Throwable[0]);
                                    ((PowerManager$WakeLock)b).acquire();
                                    final e a2 = this.a;
                                    a2.f.o(a2.i, intExtra, a2);
                                    e1.h.c().a(p, String.format("Releasing operation wake lock (%s) %s", o, b), new Throwable[0]);
                                    ((PowerManager$WakeLock)b).release();
                                    o = this.a;
                                    b = new d((e)o);
                                    break Label_0323;
                                }
                                finally {
                                    final h h = e1.h.c();
                                    final String s = androidx.work.impl.background.systemalarm.e.p;
                                    final h h2 = h;
                                    final String s2 = s;
                                    final String s3 = "Unexpected error in onHandleIntent";
                                    final int n = 1;
                                    final Throwable[] array = new Throwable[n];
                                    final int n2 = 0;
                                    final Throwable t = t2;
                                    array[n2] = t;
                                    h2.b(s2, s3, array);
                                    final h h3 = e1.h.c();
                                    final String s4 = s;
                                    final String s5 = "Releasing operation wake lock (%s) %s";
                                    final int n3 = 2;
                                    final Object[] array2 = new Object[n3];
                                    final int n4 = 0;
                                    array2[n4] = o;
                                    final int n5 = 1;
                                    final PowerManager$WakeLock powerManager$WakeLock = (PowerManager$WakeLock)b;
                                    array2[n5] = powerManager$WakeLock;
                                    final String s6 = String.format(s5, array2);
                                    final int n6 = 0;
                                    final Throwable[] array3 = new Throwable[n6];
                                    h3.a(s4, s6, array3);
                                    final PowerManager$WakeLock powerManager$WakeLock2 = (PowerManager$WakeLock)b;
                                    powerManager$WakeLock2.release();
                                    final Runnable runnable = this;
                                    o = runnable.a;
                                    final d d = (d)(b = new d((e)o));
                                }
                                try {
                                    final h h = e1.h.c();
                                    final String s = androidx.work.impl.background.systemalarm.e.p;
                                    final h h2 = h;
                                    final String s2 = s;
                                    final String s3 = "Unexpected error in onHandleIntent";
                                    final int n = 1;
                                    final Throwable[] array = new Throwable[n];
                                    final int n2 = 0;
                                    final Throwable t = t2;
                                    array[n2] = t;
                                    h2.b(s2, s3, array);
                                    final h h3 = e1.h.c();
                                    final String s4 = s;
                                    final String s5 = "Releasing operation wake lock (%s) %s";
                                    final int n3 = 2;
                                    final Object[] array2 = new Object[n3];
                                    final int n4 = 0;
                                    array2[n4] = o;
                                    final int n5 = 1;
                                    final PowerManager$WakeLock powerManager$WakeLock = (PowerManager$WakeLock)b;
                                    array2[n5] = powerManager$WakeLock;
                                    final String s6 = String.format(s5, array2);
                                    final int n6 = 0;
                                    final Throwable[] array3 = new Throwable[n6];
                                    h3.a(s4, s6, array3);
                                    final PowerManager$WakeLock powerManager$WakeLock2 = (PowerManager$WakeLock)b;
                                    powerManager$WakeLock2.release();
                                    final Runnable runnable = this;
                                    o = runnable.a;
                                    b = new d((e)o);
                                    ((e)o).k((Runnable)b);
                                }
                                finally {
                                    e1.h.c().a(androidx.work.impl.background.systemalarm.e.p, String.format("Releasing operation wake lock (%s) %s", o, b), new Throwable[0]);
                                    ((PowerManager$WakeLock)b).release();
                                    o = this.a;
                                    ((e)o).k(new d((e)o));
                                }
                            }
                        }
                    }
                }
            });
        }
        finally {
            b.release();
        }
    }
    
    public boolean a(final Intent intent, int n) {
        final h c = e1.h.c();
        final String p2 = androidx.work.impl.background.systemalarm.e.p;
        final int n2 = 0;
        c.a(p2, String.format("Adding command %s (%s)", intent, n), new Throwable[0]);
        this.b();
        final String action = intent.getAction();
        if (TextUtils.isEmpty((CharSequence)action)) {
            e1.h.c().h(p2, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && this.i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra("KEY_START_ID", n);
        final List<Intent> h = this.h;
        monitorenter(h);
        n = n2;
        try {
            if (!this.h.isEmpty()) {
                n = 1;
            }
            this.h.add(intent);
            if (n == 0) {
                this.l();
            }
            return true;
        }
        finally {
            monitorexit(h);
        }
    }
    
    void c() {
        final h c = e1.h.c();
        final String p = androidx.work.impl.background.systemalarm.e.p;
        c.a(p, "Checking if commands are complete.", new Throwable[0]);
        this.b();
        synchronized (this.h) {
            if (this.i != null) {
                e1.h.c().a(p, String.format("Removing command %s", this.i), new Throwable[0]);
                if (!this.h.remove(0).equals(this.i)) {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
                this.i = null;
            }
            final g c2 = this.b.c();
            if (!this.f.n() && this.h.isEmpty() && !c2.a()) {
                e1.h.c().a(p, "No more commands & intents.", new Throwable[0]);
                final c j = this.j;
                if (j != null) {
                    j.b();
                }
            }
            else if (!this.h.isEmpty()) {
                this.l();
            }
        }
    }
    
    f1.d d() {
        return this.d;
    }
    
    @Override
    public void e(final String s, final boolean b) {
        this.k(new b(this, b.c(this.a, s, b), 0));
    }
    
    a f() {
        return this.b;
    }
    
    i g() {
        return this.e;
    }
    
    n h() {
        return this.c;
    }
    
    void j() {
        e1.h.c().a(androidx.work.impl.background.systemalarm.e.p, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.d.i(this);
        this.c.a();
        this.j = null;
    }
    
    void k(final Runnable runnable) {
        this.g.post(runnable);
    }
    
    void m(final c j) {
        if (this.j != null) {
            e1.h.c().b(androidx.work.impl.background.systemalarm.e.p, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
            return;
        }
        this.j = j;
    }
    
    static class b implements Runnable
    {
        private final e a;
        private final Intent b;
        private final int c;
        
        b(final e a, final Intent b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public void run() {
            this.a.a(this.b, this.c);
        }
    }
    
    interface c
    {
        void b();
    }
    
    static class d implements Runnable
    {
        private final e a;
        
        d(final e a) {
            this.a = a;
        }
        
        @Override
        public void run() {
            this.a.c();
        }
    }
}
