// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.background.systemalarm;

import androidx.work.impl.WorkDatabase;
import androidx.room.RoomDatabase;
import m1.p;
import android.os.Bundle;
import android.content.Intent;
import java.util.HashMap;
import e1.h;
import java.util.Map;
import android.content.Context;

public class b implements f1.b
{
    private static final String d;
    private final Context a;
    private final Map<String, f1.b> b;
    private final Object c;
    
    static {
        d = h.f("CommandHandler");
    }
    
    b(final Context a) {
        this.a = a;
        this.b = new HashMap<String, f1.b>();
        this.c = new Object();
    }
    
    static Intent a(final Context context) {
        final Intent intent = new Intent(context, (Class)SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }
    
    static Intent b(final Context context, final String s) {
        final Intent intent = new Intent(context, (Class)SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", s);
        return intent;
    }
    
    static Intent c(final Context context, final String s, final boolean b) {
        final Intent intent = new Intent(context, (Class)SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", s);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", b);
        return intent;
    }
    
    static Intent d(final Context context, final String s) {
        final Intent intent = new Intent(context, (Class)SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", s);
        return intent;
    }
    
    static Intent f(final Context context, final String s) {
        final Intent intent = new Intent(context, (Class)SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", s);
        return intent;
    }
    
    private void g(final Intent intent, final int n, final e e) {
        h.c().a(androidx.work.impl.background.systemalarm.b.d, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new c(this.a, n, e).a();
    }
    
    private void h(final Intent intent, final int n, final e e) {
        final Bundle extras = intent.getExtras();
        synchronized (this.c) {
            final String string = extras.getString("KEY_WORKSPEC_ID");
            final h c = h.c();
            final String d = androidx.work.impl.background.systemalarm.b.d;
            c.a(d, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (!this.b.containsKey(string)) {
                final d d2 = new d(this.a, n, string, e);
                this.b.put(string, d2);
                d2.d();
            }
            else {
                h.c().a(d, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            }
        }
    }
    
    private void i(final Intent intent, final int n) {
        final Bundle extras = intent.getExtras();
        final String string = extras.getString("KEY_WORKSPEC_ID");
        final boolean boolean1 = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        h.c().a(androidx.work.impl.background.systemalarm.b.d, String.format("Handling onExecutionCompleted %s, %s", intent, n), new Throwable[0]);
        this.e(string, boolean1);
    }
    
    private void j(final Intent intent, final int n, final e e) {
        h.c().a(androidx.work.impl.background.systemalarm.b.d, String.format("Handling reschedule %s, %s", intent, n), new Throwable[0]);
        e.g().s();
    }
    
    private void k(Intent o, final int n, final e e) {
        final String string = o.getExtras().getString("KEY_WORKSPEC_ID");
        final h c = h.c();
        final String d = androidx.work.impl.background.systemalarm.b.d;
        c.a(d, String.format("Handling schedule work for %s", string), new Throwable[0]);
        o = (Intent)e.g().o();
        ((RoomDatabase)o).beginTransaction();
        try {
            final p g = ((WorkDatabase)o).l().g(string);
            if (g == null) {
                final h c2 = h.c();
                final StringBuilder sb = new StringBuilder();
                sb.append("Skipping scheduling ");
                sb.append(string);
                sb.append(" because it's no longer in the DB");
                c2.h(d, sb.toString(), new Throwable[0]);
                return;
            }
            if (g.b.isFinished()) {
                final h c3 = h.c();
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Skipping scheduling ");
                sb2.append(string);
                sb2.append("because it is finished.");
                c3.h(d, sb2.toString(), new Throwable[0]);
                return;
            }
            final long a = g.a();
            if (!g.b()) {
                h.c().a(d, String.format("Setting up Alarms for %s at %s", string, a), new Throwable[0]);
                androidx.work.impl.background.systemalarm.a.c(this.a, e.g(), string, a);
            }
            else {
                h.c().a(d, String.format("Opportunistically setting an alarm for %s at %s", string, a), new Throwable[0]);
                androidx.work.impl.background.systemalarm.a.c(this.a, e.g(), string, a);
                e.k(new e.b(e, a(this.a), n));
            }
            ((RoomDatabase)o).setTransactionSuccessful();
        }
        finally {
            ((RoomDatabase)o).endTransaction();
        }
    }
    
    private void l(final Intent intent, final e e) {
        final String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        h.c().a(androidx.work.impl.background.systemalarm.b.d, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        e.g().x(string);
        androidx.work.impl.background.systemalarm.a.a(this.a, e.g(), string);
        e.e(string, false);
    }
    
    private static boolean m(final Bundle bundle, final String... array) {
        if (bundle != null && !bundle.isEmpty()) {
            for (int length = array.length, i = 0; i < length; ++i) {
                if (bundle.get(array[i]) == null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void e(final String s, final boolean b) {
        synchronized (this.c) {
            final f1.b b2 = this.b.remove(s);
            if (b2 != null) {
                b2.e(s, b);
            }
        }
    }
    
    boolean n() {
        synchronized (this.c) {
            return !this.b.isEmpty();
        }
    }
    
    void o(final Intent intent, final int n, final e e) {
        final String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            this.g(intent, n, e);
        }
        else if ("ACTION_RESCHEDULE".equals(action)) {
            this.j(intent, n, e);
        }
        else if (!m(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            h.c().b(androidx.work.impl.background.systemalarm.b.d, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
        }
        else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            this.k(intent, n, e);
        }
        else if ("ACTION_DELAY_MET".equals(action)) {
            this.h(intent, n, e);
        }
        else if ("ACTION_STOP_WORK".equals(action)) {
            this.l(intent, e);
        }
        else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            this.i(intent, n);
        }
        else {
            h.c().h(androidx.work.impl.background.systemalarm.b.d, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }
}
