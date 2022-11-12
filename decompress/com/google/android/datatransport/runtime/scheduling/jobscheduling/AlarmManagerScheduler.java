// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.PendingIntent;
import com.google.android.datatransport.runtime.logging.Logging;
import android.content.Intent;
import android.util.Base64;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import android.net.Uri$Builder;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.time.Clock;
import android.app.AlarmManager;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import android.content.Context;

public class AlarmManagerScheduler implements WorkScheduler
{
    private final Context a;
    private final EventStore b;
    private AlarmManager c;
    private final SchedulerConfig d;
    private final Clock e;
    
    @Override
    public void a(final TransportContext transportContext, final int n) {
        this.b(transportContext, n, false);
    }
    
    @Override
    public void b(final TransportContext transportContext, final int n, final boolean b) {
        final Uri$Builder uri$Builder = new Uri$Builder();
        uri$Builder.appendQueryParameter("backendName", transportContext.b());
        uri$Builder.appendQueryParameter("priority", String.valueOf(PriorityMapping.a(transportContext.d())));
        if (transportContext.c() != null) {
            uri$Builder.appendQueryParameter("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        final Intent intent = new Intent(this.a, (Class)AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(uri$Builder.build());
        intent.putExtra("attemptNumber", n);
        if (!b && this.c(intent)) {
            Logging.a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        final long n2 = this.b.n0(transportContext);
        final long g = this.d.g(transportContext.d(), n2, n);
        Logging.b("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", transportContext, g, n2, n);
        this.c.set(3, this.e.a() + g, PendingIntent.getBroadcast(this.a, 0, intent, 67108864));
    }
    
    boolean c(final Intent intent) {
        final Context a = this.a;
        boolean b = false;
        if (PendingIntent.getBroadcast(a, 0, intent, 603979776) != null) {
            b = true;
        }
        return b;
    }
}
