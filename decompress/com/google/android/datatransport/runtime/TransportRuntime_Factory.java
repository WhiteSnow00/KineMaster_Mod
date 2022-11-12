// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class TransportRuntime_Factory implements Factory<TransportRuntime>
{
    private final Provider<Clock> a;
    private final Provider<Clock> b;
    private final Provider<Scheduler> c;
    private final Provider<Uploader> d;
    private final Provider<WorkInitializer> e;
    
    public TransportRuntime_Factory(final Provider<Clock> a, final Provider<Clock> b, final Provider<Scheduler> c, final Provider<Uploader> d, final Provider<WorkInitializer> e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public static TransportRuntime_Factory a(final Provider<Clock> provider, final Provider<Clock> provider2, final Provider<Scheduler> provider3, final Provider<Uploader> provider4, final Provider<WorkInitializer> provider5) {
        return new TransportRuntime_Factory(provider, provider2, provider3, provider4, provider5);
    }
    
    public static TransportRuntime c(final Clock clock, final Clock clock2, final Scheduler scheduler, final Uploader uploader, final WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }
    
    public TransportRuntime b() {
        return c((Clock)this.a.get(), (Clock)this.b.get(), (Scheduler)this.c.get(), (Uploader)this.d.get(), (WorkInitializer)this.e.get());
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
}
