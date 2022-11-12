// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import android.content.Context;
import java.util.Collections;
import com.google.android.datatransport.Encoding;
import java.util.Set;
import javax.inject.Inject;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Singleton;

@Singleton
public class TransportRuntime implements j
{
    private static volatile k e;
    private final Clock a;
    private final Clock b;
    private final Scheduler c;
    private final Uploader d;
    
    @Inject
    TransportRuntime(@WallTime final Clock a, @Monotonic final Clock b, final Scheduler c, final Uploader d, final WorkInitializer workInitializer) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        workInitializer.c();
    }
    
    private EventInternal b(final SendRequest sendRequest) {
        return EventInternal.a().i(this.a.a()).k(this.b.a()).j(sendRequest.g()).h(new EncodedPayload(sendRequest.b(), sendRequest.d())).g(sendRequest.c().a()).d();
    }
    
    public static TransportRuntime c() {
        final k e = TransportRuntime.e;
        if (e != null) {
            return e.c();
        }
        throw new IllegalStateException("Not initialized!");
    }
    
    private static Set<Encoding> d(final Destination destination) {
        if (destination instanceof EncodedDestination) {
            return Collections.unmodifiableSet((Set<? extends Encoding>)((EncodedDestination)destination).a());
        }
        return Collections.singleton(Encoding.b("proto"));
    }
    
    public static void f(final Context context) {
        if (TransportRuntime.e == null) {
            synchronized (TransportRuntime.class) {
                if (TransportRuntime.e == null) {
                    TransportRuntime.e = d.d().a(context).build();
                }
            }
        }
    }
    
    @Override
    public void a(final SendRequest sendRequest, final TransportScheduleCallback transportScheduleCallback) {
        this.c.a(sendRequest.f().f(sendRequest.c().c()), this.b(sendRequest), transportScheduleCallback);
    }
    
    public Uploader e() {
        return this.d;
    }
    
    public TransportFactory g(final Destination destination) {
        return new g(d(destination), TransportContext.a().b(destination.getName()).c(destination.getExtras()).a(), this);
    }
}
