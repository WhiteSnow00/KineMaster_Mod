// 
// Decompiled by Procyon v0.6.0
// 

package h1;

import java.util.Iterator;
import androidx.work.BackoffPolicy;
import android.os.PersistableBundle;
import android.app.job.JobInfo;
import m1.p;
import android.net.NetworkRequest$Builder;
import android.os.Build$VERSION;
import android.app.job.JobInfo$Builder;
import androidx.work.NetworkType;
import android.app.job.JobInfo$TriggerContentUri;
import e1.b;
import androidx.work.impl.background.systemjob.SystemJobService;
import android.content.Context;
import e1.h;
import android.content.ComponentName;

class a
{
    private static final String b;
    private final ComponentName a;
    
    static {
        b = h.f("SystemJobInfoConverter");
    }
    
    a(final Context context) {
        this.a = new ComponentName(context.getApplicationContext(), (Class)SystemJobService.class);
    }
    
    private static JobInfo$TriggerContentUri b(final b.a a) {
        return new JobInfo$TriggerContentUri(a.a(), (int)(a.b() ? 1 : 0));
    }
    
    static int c(final NetworkType networkType) {
        final int n = a$a.a[networkType.ordinal()];
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 3;
        }
        if (n != 5) {
            h.c().a(a.b, String.format("API version too low. Cannot convert network type value %s", networkType), new Throwable[0]);
            return 1;
        }
        return 4;
    }
    
    static void d(final JobInfo$Builder jobInfo$Builder, final NetworkType networkType) {
        if (Build$VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            jobInfo$Builder.setRequiredNetwork(new NetworkRequest$Builder().addCapability(25).build());
        }
        else {
            jobInfo$Builder.setRequiredNetworkType(c(networkType));
        }
    }
    
    JobInfo a(final p p2, int n) {
        final e1.a j = p2.j;
        final PersistableBundle extras = new PersistableBundle();
        extras.putString("EXTRA_WORK_SPEC_ID", p2.a);
        extras.putBoolean("EXTRA_IS_PERIODIC", p2.d());
        final JobInfo$Builder setExtras = new JobInfo$Builder(n, this.a).setRequiresCharging(j.g()).setRequiresDeviceIdle(j.h()).setExtras(extras);
        d(setExtras, j.b());
        final boolean h = j.h();
        final int n2 = 0;
        if (!h) {
            if (p2.l == BackoffPolicy.LINEAR) {
                n = 0;
            }
            else {
                n = 1;
            }
            setExtras.setBackoffCriteria(p2.m, n);
        }
        final long max = Math.max(p2.a() - System.currentTimeMillis(), 0L);
        if (Build$VERSION.SDK_INT <= 28) {
            setExtras.setMinimumLatency(max);
        }
        else if (max > 0L) {
            setExtras.setMinimumLatency(max);
        }
        else if (!p2.q) {
            setExtras.setImportantWhileForeground(true);
        }
        if (j.e()) {
            final Iterator<b.a> iterator = j.a().b().iterator();
            while (iterator.hasNext()) {
                setExtras.addTriggerContentUri(b(iterator.next()));
            }
            setExtras.setTriggerContentUpdateDelay(j.c());
            setExtras.setTriggerContentMaxDelay(j.d());
        }
        setExtras.setPersisted(false);
        setExtras.setRequiresBatteryNotLow(j.f());
        setExtras.setRequiresStorageNotLow(j.i());
        n = n2;
        if (p2.k > 0) {
            n = 1;
        }
        if (androidx.core.os.a.c() && p2.q && n == 0) {
            setExtras.setExpedited(true);
        }
        return setExtras.build();
    }
}
