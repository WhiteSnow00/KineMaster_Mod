// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.scheduler;

import android.content.Intent;
import com.google.android.exoplayer2.util.Assertions;
import android.content.Context;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.app.job.JobInfo$Builder;
import com.google.android.exoplayer2.util.Log;
import android.app.job.JobInfo;
import com.google.android.exoplayer2.util.Util;
import android.app.job.JobScheduler;
import android.content.ComponentName;

public final class PlatformScheduler implements Scheduler
{
    private static final int d;
    private final int a;
    private final ComponentName b;
    private final JobScheduler c;
    
    static {
        int n;
        if (Util.a >= 26) {
            n = 16;
        }
        else {
            n = 0;
        }
        d = (n | 0xF);
    }
    
    private static JobInfo c(final int n, final ComponentName componentName, final Requirements requirements, final String s, final String s2) {
        final Requirements a = requirements.a(PlatformScheduler.d);
        if (!a.equals(requirements)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring unsupported requirements: ");
            sb.append(a.d() ^ requirements.d());
            Log.i("PlatformScheduler", sb.toString());
        }
        final JobInfo$Builder jobInfo$Builder = new JobInfo$Builder(n, componentName);
        if (requirements.m()) {
            jobInfo$Builder.setRequiredNetworkType(2);
        }
        else if (requirements.j()) {
            jobInfo$Builder.setRequiredNetworkType(1);
        }
        jobInfo$Builder.setRequiresDeviceIdle(requirements.h());
        jobInfo$Builder.setRequiresCharging(requirements.e());
        if (Util.a >= 26 && requirements.l()) {
            jobInfo$Builder.setRequiresStorageNotLow(true);
        }
        jobInfo$Builder.setPersisted(true);
        final PersistableBundle extras = new PersistableBundle();
        extras.putString("service_action", s);
        extras.putString("service_package", s2);
        extras.putInt("requirements", requirements.d());
        jobInfo$Builder.setExtras(extras);
        return jobInfo$Builder.build();
    }
    
    @Override
    public boolean a(final Requirements requirements, final String s, final String s2) {
        final int schedule = this.c.schedule(c(this.a, this.b, requirements, s2, s));
        boolean b = true;
        if (schedule != 1) {
            b = false;
        }
        return b;
    }
    
    @Override
    public Requirements b(final Requirements requirements) {
        return requirements.a(PlatformScheduler.d);
    }
    
    @Override
    public boolean cancel() {
        this.c.cancel(this.a);
        return true;
    }
    
    public static final class PlatformSchedulerService extends JobService
    {
        public boolean onStartJob(final JobParameters jobParameters) {
            final PersistableBundle extras = jobParameters.getExtras();
            final int c = new Requirements(extras.getInt("requirements")).c((Context)this);
            if (c == 0) {
                Util.W0((Context)this, new Intent((String)Assertions.e(extras.getString("service_action"))).setPackage((String)Assertions.e(extras.getString("service_package"))));
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append("Requirements not met: ");
                sb.append(c);
                Log.i("PlatformScheduler", sb.toString());
                this.jobFinished(jobParameters, true);
            }
            return false;
        }
        
        public boolean onStopJob(final JobParameters jobParameters) {
            return false;
        }
    }
}
