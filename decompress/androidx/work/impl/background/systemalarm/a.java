// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.background.systemalarm;

import androidx.work.impl.WorkDatabase;
import n1.c;
import android.app.PendingIntent;
import android.app.AlarmManager;
import m1.g;
import f1.i;
import android.content.Context;
import e1.h;

class a
{
    private static final String a;
    
    static {
        a = h.f("Alarms");
    }
    
    public static void a(final Context context, final i i, final String s) {
        final m1.h j = i.o().i();
        final g a = j.a(s);
        if (a != null) {
            b(context, s, a.b);
            h.c().a(androidx.work.impl.background.systemalarm.a.a, String.format("Removing SystemIdInfo for workSpecId (%s)", s), new Throwable[0]);
            j.c(s);
        }
    }
    
    private static void b(final Context context, final String s, final int n) {
        final AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        final PendingIntent service = PendingIntent.getService(context, n, b.b(context, s), 603979776);
        if (service != null && alarmManager != null) {
            h.c().a(androidx.work.impl.background.systemalarm.a.a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", s, n), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }
    
    public static void c(final Context context, final i i, final String s, final long n) {
        final WorkDatabase o = i.o();
        final m1.h j = o.i();
        final g a = j.a(s);
        if (a != null) {
            b(context, s, a.b);
            d(context, s, a.b, n);
        }
        else {
            final int b = new c(o).b();
            j.d(new g(s, b));
            d(context, s, b, n);
        }
    }
    
    private static void d(final Context context, final String s, final int n, final long n2) {
        final AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        final PendingIntent service = PendingIntent.getService(context, n, b.b(context, s), 201326592);
        if (alarmManager != null) {
            alarmManager.setExact(0, n2, service);
        }
    }
}
