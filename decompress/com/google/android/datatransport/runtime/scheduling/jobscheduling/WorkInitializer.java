// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import i3.o;
import i3.n;
import java.util.Iterator;
import com.google.android.datatransport.runtime.TransportContext;
import javax.inject.Inject;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.util.concurrent.Executor;

public class WorkInitializer
{
    private final Executor a;
    private final EventStore b;
    private final WorkScheduler c;
    private final SynchronizationGuard d;
    
    @Inject
    WorkInitializer(final Executor a, final EventStore b, final WorkScheduler c, final SynchronizationGuard d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static Object a(final WorkInitializer workInitializer) {
        return workInitializer.d();
    }
    
    public static void b(final WorkInitializer workInitializer) {
        workInitializer.e();
    }
    
    private Object d() {
        final Iterator<TransportContext> iterator = this.b.N().iterator();
        while (iterator.hasNext()) {
            this.c.a(iterator.next(), 1);
        }
        return null;
    }
    
    private void e() {
        this.d.c((SynchronizationGuard.CriticalSection<Object>)new n(this));
    }
    
    public void c() {
        this.a.execute((Runnable)new o(this));
    }
}
