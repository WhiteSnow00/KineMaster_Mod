// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.utils;

import android.content.BroadcastReceiver;
import e1.e;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteAccessPermException;
import android.text.TextUtils;
import android.app.ApplicationExitInfo;
import android.app.ActivityManager;
import android.os.Build$VERSION;
import f1.f;
import java.util.Iterator;
import java.util.List;
import m1.n;
import m1.q;
import androidx.work.impl.WorkDatabase;
import androidx.work.WorkInfo;
import m1.p;
import h1.b;
import androidx.core.os.a;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import java.util.concurrent.TimeUnit;
import e1.h;
import f1.i;
import android.content.Context;

public class ForceStopRunnable implements Runnable
{
    private static final String d;
    private static final long e;
    private final Context a;
    private final i b;
    private int c;
    
    static {
        d = h.f("ForceStopRunnable");
        e = TimeUnit.DAYS.toMillis(3650L);
    }
    
    public ForceStopRunnable(final Context context, final i b) {
        this.a = context.getApplicationContext();
        this.b = b;
        this.c = 0;
    }
    
    static Intent c(final Context context) {
        final Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class)BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }
    
    private static PendingIntent d(final Context context, final int n) {
        return PendingIntent.getBroadcast(context, -1, c(context), n);
    }
    
    static void g(final Context context) {
        final AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        int n;
        if (a.c()) {
            n = 167772160;
        }
        else {
            n = 134217728;
        }
        final PendingIntent d = d(context, n);
        final long currentTimeMillis = System.currentTimeMillis();
        final long e = ForceStopRunnable.e;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis + e, d);
        }
    }
    
    public boolean a() {
        final boolean i = h1.b.i(this.a, this.b);
        final WorkDatabase o = this.b.o();
        final q l = o.l();
        final n k = o.k();
        o.beginTransaction();
        try {
            final List<p> q = l.q();
            final boolean b = true;
            final boolean b2 = q != null && !q.isEmpty();
            if (b2) {
                for (final p p : q) {
                    l.b(WorkInfo.State.ENQUEUED, p.a);
                    l.l(p.a, -1L);
                }
            }
            k.deleteAll();
            o.setTransactionSuccessful();
            o.endTransaction();
            boolean b3 = b;
            if (!b2) {
                b3 = (i && b);
            }
            return b3;
        }
        finally {
            o.endTransaction();
        }
    }
    
    public void b() {
        final boolean a = this.a();
        if (this.h()) {
            h.c().a(ForceStopRunnable.d, "Rescheduling Workers.", new Throwable[0]);
            this.b.s();
            this.b.l().c(false);
        }
        else if (this.e()) {
            h.c().a(ForceStopRunnable.d, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.b.s();
        }
        else if (a) {
            h.c().a(ForceStopRunnable.d, "Found unfinished work, scheduling it.", new Throwable[0]);
            f.b(this.b.i(), this.b.o(), this.b.n());
        }
    }
    
    public boolean e() {
        int n = 536870912;
        Object o = null;
        try {
            if (androidx.core.os.a.c()) {
                n = 570425344;
            }
            o = d(this.a, n);
            if (Build$VERSION.SDK_INT >= 30) {
                if (o != null) {
                    ((PendingIntent)o).cancel();
                }
                o = ((ActivityManager)this.a.getSystemService("activity")).getHistoricalProcessExitReasons((String)null, 0, 0);
                if (o != null && !((List)o).isEmpty()) {
                    for (int i = 0; i < ((List)o).size(); ++i) {
                        if (((ApplicationExitInfo)((List)o).get(i)).getReason() == 10) {
                            return true;
                        }
                    }
                }
            }
            else if (o == null) {
                g(this.a);
                return true;
            }
            return false;
        }
        catch (final IllegalArgumentException o) {}
        catch (final SecurityException ex) {}
        h.c().h(ForceStopRunnable.d, "Ignoring exception", (Throwable)o);
        return true;
    }
    
    public boolean f() {
        final androidx.work.a i = this.b.i();
        if (TextUtils.isEmpty((CharSequence)i.c())) {
            h.c().a(ForceStopRunnable.d, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        final boolean b = n1.f.b(this.a, i);
        h.c().a(ForceStopRunnable.d, String.format("Is default app process = %s", b), new Throwable[0]);
        return b;
    }
    
    boolean h() {
        return this.b.l().a();
    }
    
    public void i(final long n) {
        try {
            Thread.sleep(n);
        }
        catch (final InterruptedException ex) {}
    }
    
    @Override
    public void run() {
        try {
            if (!this.f()) {
                return;
            }
            while (true) {
                f1.h.e(this.a);
                h.c().a(ForceStopRunnable.d, "Performing cleanup operations.", new Throwable[0]);
                try {
                    this.b();
                    break;
                }
                catch (final SQLiteAccessPermException ex) {}
                catch (final SQLiteConstraintException ex) {}
                catch (final SQLiteTableLockedException ex) {}
                catch (final SQLiteDatabaseLockedException ex) {}
                catch (final SQLiteDatabaseCorruptException ex) {}
                catch (final SQLiteCantOpenDatabaseException ex2) {}
                final int c = this.c + 1;
                this.c = c;
                if (c >= 3) {
                    final h c2 = h.c();
                    final String d = ForceStopRunnable.d;
                    final SQLiteAccessPermException ex;
                    c2.b(d, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", (Throwable)ex);
                    final IllegalStateException ex3 = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", (Throwable)ex);
                    final e d2 = this.b.i().d();
                    if (d2 != null) {
                        h.c().a(d, "Routing exception to the specified exception handler", ex3);
                        d2.a(ex3);
                        break;
                    }
                    throw ex3;
                }
                else {
                    final SQLiteAccessPermException ex;
                    h.c().a(ForceStopRunnable.d, String.format("Retrying after %s", c * 300L), (Throwable)ex);
                    this.i(this.c * 300L);
                }
            }
        }
        finally {
            this.b.r();
        }
    }
    
    public static class BroadcastReceiver extends android.content.BroadcastReceiver
    {
        private static final String a;
        
        static {
            a = h.f("ForceStopRunnable$Rcvr");
        }
        
        public void onReceive(final Context context, final Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                h.c().g(BroadcastReceiver.a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.g(context);
            }
        }
    }
}
