// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.background.systemjob;

import java.util.Arrays;
import androidx.work.WorkerParameters;
import android.os.Build$VERSION;
import android.text.TextUtils;
import android.app.Application;
import android.os.PersistableBundle;
import java.util.HashMap;
import e1.h;
import android.app.job.JobParameters;
import java.util.Map;
import f1.i;
import f1.b;
import android.app.job.JobService;

public class SystemJobService extends JobService implements b
{
    private static final String c;
    private i a;
    private final Map<String, JobParameters> b;
    
    static {
        c = h.f("SystemJobService");
    }
    
    public SystemJobService() {
        this.b = new HashMap<String, JobParameters>();
    }
    
    private static String a(final JobParameters jobParameters) {
        try {
            final PersistableBundle extras = jobParameters.getExtras();
            if (extras != null && extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        }
        catch (final NullPointerException ex) {
            return null;
        }
    }
    
    public void e(final String s, final boolean b) {
        h.c().a(SystemJobService.c, String.format("%s executed on JobScheduler", s), new Throwable[0]);
        synchronized (this.b) {
            final JobParameters jobParameters = this.b.remove(s);
            monitorexit(this.b);
            if (jobParameters != null) {
                this.jobFinished(jobParameters, b);
            }
        }
    }
    
    public void onCreate() {
        super.onCreate();
        try {
            final i k = i.k(this.getApplicationContext());
            this.a = k;
            k.m().c(this);
        }
        catch (final IllegalStateException ex) {
            if (!Application.class.equals(this.getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            h.c().h(SystemJobService.c, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }
    
    public void onDestroy() {
        super.onDestroy();
        final i a = this.a;
        if (a != null) {
            a.m().i(this);
        }
    }
    
    public boolean onStartJob(final JobParameters jobParameters) {
        if (this.a == null) {
            h.c().a(SystemJobService.c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            this.jobFinished(jobParameters, true);
            return false;
        }
        final String a = a(jobParameters);
        if (TextUtils.isEmpty((CharSequence)a)) {
            h.c().b(SystemJobService.c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        Object b = this.b;
        synchronized (b) {
            if (this.b.containsKey(a)) {
                h.c().a(SystemJobService.c, String.format("Job is already being executed by SystemJobService: %s", a), new Throwable[0]);
                return false;
            }
            h.c().a(SystemJobService.c, String.format("onStartJob for %s", a), new Throwable[0]);
            this.b.put(a, jobParameters);
            monitorexit(b);
            final int sdk_INT = Build$VERSION.SDK_INT;
            b = new WorkerParameters.a();
            if (jobParameters.getTriggeredContentUris() != null) {
                ((WorkerParameters.a)b).b = Arrays.asList(jobParameters.getTriggeredContentUris());
            }
            if (jobParameters.getTriggeredContentAuthorities() != null) {
                ((WorkerParameters.a)b).a = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
            }
            if (sdk_INT >= 28) {
                ((WorkerParameters.a)b).c = jobParameters.getNetwork();
            }
            this.a.v(a, (WorkerParameters.a)b);
            return true;
        }
    }
    
    public boolean onStopJob(final JobParameters jobParameters) {
        if (this.a == null) {
            h.c().a(SystemJobService.c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        final String a = a(jobParameters);
        if (TextUtils.isEmpty((CharSequence)a)) {
            h.c().b(SystemJobService.c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        h.c().a(SystemJobService.c, String.format("onStopJob for %s", a), new Throwable[0]);
        synchronized (this.b) {
            this.b.remove(a);
            monitorexit(this.b);
            this.a.x(a);
            return this.a.m().f(a) ^ true;
        }
    }
}
