// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.foreground;

import java.util.List;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import android.os.Build$VERSION;
import android.app.Notification;
import java.util.UUID;
import android.text.TextUtils;
import android.os.Parcelable;
import android.content.Intent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import e1.h;
import i1.d;
import java.util.Set;
import m1.p;
import java.util.Map;
import f1.i;
import android.content.Context;
import f1.b;
import i1.c;

public class a implements c, f1.b
{
    static final String p;
    private Context a;
    private i b;
    private final o1.a c;
    final Object d;
    String e;
    final Map<String, e1.c> f;
    final Map<String, p> g;
    final Set<p> h;
    final d i;
    private b j;
    
    static {
        p = h.f("SystemFgDispatcher");
    }
    
    a(final Context a) {
        this.a = a;
        this.d = new Object();
        final i k = f1.i.k(a);
        this.b = k;
        final o1.a p = k.p();
        this.c = p;
        this.e = null;
        this.f = new LinkedHashMap<String, e1.c>();
        this.h = new HashSet<p>();
        this.g = new HashMap<String, p>();
        this.i = new d(this.a, p, this);
        this.b.m().c(this);
    }
    
    public static Intent a(final Context context, final String s, final e1.c c) {
        final Intent intent = new Intent(context, (Class)SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", c.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", c.a());
        intent.putExtra("KEY_NOTIFICATION", (Parcelable)c.b());
        intent.putExtra("KEY_WORKSPEC_ID", s);
        return intent;
    }
    
    public static Intent c(final Context context, final String s, final e1.c c) {
        final Intent intent = new Intent(context, (Class)SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", s);
        intent.putExtra("KEY_NOTIFICATION_ID", c.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", c.a());
        intent.putExtra("KEY_NOTIFICATION", (Parcelable)c.b());
        intent.putExtra("KEY_WORKSPEC_ID", s);
        return intent;
    }
    
    public static Intent d(final Context context) {
        final Intent intent = new Intent(context, (Class)SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }
    
    private void g(final Intent intent) {
        e1.h.c().d(androidx.work.impl.foreground.a.p, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
        final String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra != null && !TextUtils.isEmpty((CharSequence)stringExtra)) {
            this.b.f(UUID.fromString(stringExtra));
        }
    }
    
    private void h(final Intent intent) {
        int n = 0;
        final int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        final int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        final String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        final Notification notification = (Notification)intent.getParcelableExtra("KEY_NOTIFICATION");
        e1.h.c().a(androidx.work.impl.foreground.a.p, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", intExtra, stringExtra, intExtra2), new Throwable[0]);
        if (notification != null && this.j != null) {
            this.f.put(stringExtra, new e1.c(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty((CharSequence)this.e)) {
                this.e = stringExtra;
                this.j.c(intExtra, intExtra2, notification);
            }
            else {
                this.j.a(intExtra, notification);
                if (intExtra2 != 0 && Build$VERSION.SDK_INT >= 29) {
                    final Iterator<Map.Entry<String, e1.c>> iterator = this.f.entrySet().iterator();
                    while (iterator.hasNext()) {
                        n |= ((Map.Entry<K, e1.c>)iterator.next()).getValue().a();
                    }
                    final e1.c c = this.f.get(this.e);
                    if (c != null) {
                        this.j.c(c.c(), n, c.b());
                    }
                }
            }
        }
    }
    
    private void i(final Intent intent) {
        e1.h.c().d(androidx.work.impl.foreground.a.p, String.format("Started foreground service %s", intent), new Throwable[0]);
        this.c.b(new Runnable(this, this.b.o(), intent.getStringExtra("KEY_WORKSPEC_ID")) {
            final WorkDatabase a;
            final String b;
            final a c;
            
            @Override
            public void run() {
                final p g = this.a.l().g(this.b);
                if (g != null && g.b()) {
                    synchronized (this.c.d) {
                        this.c.g.put(this.b, g);
                        this.c.h.add(g);
                        final a c = this.c;
                        c.i.d(c.h);
                    }
                }
            }
        });
    }
    
    @Override
    public void b(final List<String> list) {
        if (!list.isEmpty()) {
            for (final String s : list) {
                e1.h.c().a(androidx.work.impl.foreground.a.p, String.format("Constraints unmet for WorkSpec %s", s), new Throwable[0]);
                this.b.w(s);
            }
        }
    }
    
    @Override
    public void e(final String s, final boolean b) {
        Object o = this.d;
        synchronized (o) {
            final p p2 = this.g.remove(s);
            if (p2 != null && this.h.remove(p2)) {
                this.i.d(this.h);
            }
            monitorexit(o);
            final e1.c c = this.f.remove(s);
            if (s.equals(this.e) && this.f.size() > 0) {
                final Iterator<Map.Entry<String, e1.c>> iterator = this.f.entrySet().iterator();
                o = iterator.next();
                while (iterator.hasNext()) {
                    o = iterator.next();
                }
                this.e = ((Map.Entry<String, e1.c>)o).getKey();
                if (this.j != null) {
                    o = ((Map.Entry<String, e1.c>)o).getValue();
                    this.j.c(((e1.c)o).c(), ((e1.c)o).a(), ((e1.c)o).b());
                    this.j.d(((e1.c)o).c());
                }
            }
            o = this.j;
            if (c != null && o != null) {
                e1.h.c().a(androidx.work.impl.foreground.a.p, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", c.c(), s, c.a()), new Throwable[0]);
                ((b)o).d(c.c());
            }
        }
    }
    
    @Override
    public void f(final List<String> list) {
    }
    
    void j(final Intent intent) {
        e1.h.c().d(androidx.work.impl.foreground.a.p, "Stopping foreground service", new Throwable[0]);
        final b j = this.j;
        if (j != null) {
            j.stop();
        }
    }
    
    void k() {
        this.j = null;
        synchronized (this.d) {
            this.i.e();
            monitorexit(this.d);
            this.b.m().i(this);
        }
    }
    
    void l(final Intent intent) {
        final String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            this.i(intent);
            this.h(intent);
        }
        else if ("ACTION_NOTIFY".equals(action)) {
            this.h(intent);
        }
        else if ("ACTION_CANCEL_WORK".equals(action)) {
            this.g(intent);
        }
        else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            this.j(intent);
        }
    }
    
    void m(final b j) {
        if (this.j != null) {
            e1.h.c().b(androidx.work.impl.foreground.a.p, "A callback already exists.", new Throwable[0]);
            return;
        }
        this.j = j;
    }
    
    interface b
    {
        void a(final int p0, final Notification p1);
        
        void c(final int p0, final int p1, final Notification p2);
        
        void d(final int p0);
        
        void stop();
    }
}
