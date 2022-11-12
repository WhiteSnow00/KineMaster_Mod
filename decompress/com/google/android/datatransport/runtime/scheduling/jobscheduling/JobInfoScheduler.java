// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
import android.util.Base64;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import android.os.PersistableBundle;
import android.app.job.JobInfo$Builder;
import com.google.android.datatransport.runtime.logging.Logging;
import android.content.ComponentName;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Iterator;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import android.content.Context;

public class JobInfoScheduler implements WorkScheduler
{
    private final Context a;
    private final EventStore b;
    private final SchedulerConfig c;
    
    public JobInfoScheduler(final Context a, final EventStore b, final SchedulerConfig c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private boolean d(final JobScheduler jobScheduler, final int n, final int n2) {
        final Iterator iterator = jobScheduler.getAllPendingJobs().iterator();
        JobInfo jobInfo;
        boolean b;
        int int1;
        do {
            final boolean hasNext = iterator.hasNext();
            b = false;
            if (!hasNext) {
                return b;
            }
            jobInfo = (JobInfo)iterator.next();
            int1 = jobInfo.getExtras().getInt("attemptNumber");
        } while (jobInfo.getId() != n);
        b = b;
        if (int1 >= n2) {
            b = true;
            return b;
        }
        return b;
    }
    
    @Override
    public void a(final TransportContext transportContext, final int n) {
        this.b(transportContext, n, false);
    }
    
    @Override
    public void b(final TransportContext transportContext, final int n, final boolean b) {
        final ComponentName componentName = new ComponentName(this.a, (Class)JobInfoSchedulerService.class);
        final JobScheduler jobScheduler = (JobScheduler)this.a.getSystemService("jobscheduler");
        final int c = this.c(transportContext);
        if (!b && this.d(jobScheduler, c, n)) {
            Logging.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        final long n2 = this.b.n0(transportContext);
        final JobInfo$Builder c2 = this.c.c(new JobInfo$Builder(c, componentName), transportContext.d(), n2, n);
        final PersistableBundle extras = new PersistableBundle();
        extras.putInt("attemptNumber", n);
        extras.putString("backendName", transportContext.b());
        extras.putInt("priority", PriorityMapping.a(transportContext.d()));
        if (transportContext.c() != null) {
            extras.putString("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        c2.setExtras(extras);
        Logging.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext, c, this.c.g(transportContext.d(), n2, n), n2, n);
        jobScheduler.schedule(c2.build());
    }
    
    int c(final TransportContext transportContext) {
        final Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(transportContext.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.a(transportContext.d())).array());
        if (transportContext.c() != null) {
            adler32.update(transportContext.c());
        }
        return (int)adler32.getValue();
    }
}
