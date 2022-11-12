// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling;

import h3.b;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import h3.a;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.TransportContext;
import javax.inject.Inject;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import java.util.concurrent.Executor;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import java.util.logging.Logger;

public class DefaultScheduler implements Scheduler
{
    private static final Logger f;
    private final WorkScheduler a;
    private final Executor b;
    private final BackendRegistry c;
    private final EventStore d;
    private final SynchronizationGuard e;
    
    static {
        f = Logger.getLogger(TransportRuntime.class.getName());
    }
    
    @Inject
    public DefaultScheduler(final Executor b, final BackendRegistry c, final WorkScheduler a, final EventStore d, final SynchronizationGuard e) {
        this.b = b;
        this.c = c;
        this.a = a;
        this.d = d;
        this.e = e;
    }
    
    public static void b(final DefaultScheduler defaultScheduler, final TransportContext transportContext, final TransportScheduleCallback transportScheduleCallback, final EventInternal eventInternal) {
        defaultScheduler.e(transportContext, transportScheduleCallback, eventInternal);
    }
    
    public static Object c(final DefaultScheduler defaultScheduler, final TransportContext transportContext, final EventInternal eventInternal) {
        return defaultScheduler.d(transportContext, eventInternal);
    }
    
    private Object d(final TransportContext transportContext, final EventInternal eventInternal) {
        this.d.t1(transportContext, eventInternal);
        this.a.a(transportContext, 1);
        return null;
    }
    
    private void e(final TransportContext transportContext, final TransportScheduleCallback transportScheduleCallback, EventInternal a) {
        try {
            final TransportBackend a2 = this.c.a(transportContext.b());
            if (a2 == null) {
                final String format = String.format("Transport backend '%s' is not registered", transportContext.b());
                DefaultScheduler.f.warning(format);
                transportScheduleCallback.a(new IllegalArgumentException(format));
                return;
            }
            a = a2.a(a);
            this.e.c((SynchronizationGuard.CriticalSection<Object>)new a(this, transportContext, a));
            transportScheduleCallback.a(null);
        }
        catch (final Exception ex) {
            final Logger f = DefaultScheduler.f;
            final StringBuilder sb = new StringBuilder();
            sb.append("Error scheduling event ");
            sb.append(ex.getMessage());
            f.warning(sb.toString());
            transportScheduleCallback.a(ex);
        }
    }
    
    @Override
    public void a(final TransportContext transportContext, final EventInternal eventInternal, final TransportScheduleCallback transportScheduleCallback) {
        this.b.execute((Runnable)new b(this, transportContext, transportScheduleCallback, eventInternal));
    }
}
