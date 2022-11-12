// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import i3.b;
import android.util.Base64;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import android.app.job.JobParameters;
import android.app.job.JobService;

public class JobInfoSchedulerService extends JobService
{
    public static void a(final JobInfoSchedulerService jobInfoSchedulerService, final JobParameters jobParameters) {
        jobInfoSchedulerService.b(jobParameters);
    }
    
    private void b(final JobParameters jobParameters) {
        this.jobFinished(jobParameters, false);
    }
    
    public boolean onStartJob(final JobParameters jobParameters) {
        final String string = jobParameters.getExtras().getString("backendName");
        final String string2 = jobParameters.getExtras().getString("extras");
        final int int1 = jobParameters.getExtras().getInt("priority");
        final int int2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.f(this.getApplicationContext());
        final TransportContext.Builder d = TransportContext.a().b(string).d(PriorityMapping.b(int1));
        if (string2 != null) {
            d.c(Base64.decode(string2, 0));
        }
        TransportRuntime.c().e().v(d.a(), int2, (Runnable)new b(this, jobParameters));
        return true;
    }
    
    public boolean onStopJob(final JobParameters jobParameters) {
        return true;
    }
}
