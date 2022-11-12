// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import android.content.Context;
import java.util.concurrent.Executor;
import javax.inject.Provider;

final class d extends k
{
    private Provider<Executor> a;
    private Provider<Context> b;
    private Provider c;
    private Provider d;
    private Provider e;
    private Provider<String> f;
    private Provider<SQLiteEventStore> g;
    private Provider<SchedulerConfig> h;
    private Provider<WorkScheduler> i;
    private Provider<DefaultScheduler> j;
    private Provider<Uploader> p;
    private Provider<WorkInitializer> w;
    private Provider<TransportRuntime> x;
    
    private d(final Context context) {
        this.e(context);
    }
    
    d(final Context context, final d$a object) {
        this(context);
    }
    
    public static a d() {
        return new b(null);
    }
    
    private void e(final Context context) {
        this.a = DoubleCheck.b(ExecutionModule_ExecutorFactory.a());
        final Factory<Context> a = InstanceFactory.a(context);
        this.b = (Provider<Context>)a;
        final CreationContextFactory_Factory a2 = CreationContextFactory_Factory.a((Provider<Context>)a, (Provider<Clock>)TimeModule_EventClockFactory.a(), (Provider<Clock>)TimeModule_UptimeClockFactory.a());
        this.c = (Provider)a2;
        this.d = DoubleCheck.b(MetadataBackendRegistry_Factory.a(this.b, (Provider<com.google.android.datatransport.runtime.backends.d>)a2));
        this.e = (Provider)SchemaManager_Factory.a(this.b, (Provider<String>)EventStoreModule_DbNameFactory.a(), (Provider<Integer>)EventStoreModule_SchemaVersionFactory.a());
        this.f = (Provider<String>)EventStoreModule_PackageNameFactory.a(this.b);
        this.g = DoubleCheck.b(SQLiteEventStore_Factory.a((Provider<Clock>)TimeModule_EventClockFactory.a(), (Provider<Clock>)TimeModule_UptimeClockFactory.a(), (Provider<c>)EventStoreModule_StoreConfigFactory.a(), (Provider<SchemaManager>)this.e, this.f));
        final SchedulingConfigModule_ConfigFactory b = SchedulingConfigModule_ConfigFactory.b((Provider<Clock>)TimeModule_EventClockFactory.a());
        this.h = (Provider<SchedulerConfig>)b;
        final SchedulingModule_WorkSchedulerFactory a3 = SchedulingModule_WorkSchedulerFactory.a(this.b, (Provider<EventStore>)this.g, (Provider<SchedulerConfig>)b, (Provider<Clock>)TimeModule_UptimeClockFactory.a());
        this.i = (Provider<WorkScheduler>)a3;
        final Provider<Executor> a4 = this.a;
        final Provider d = this.d;
        final Provider<SQLiteEventStore> g = this.g;
        this.j = (Provider<DefaultScheduler>)DefaultScheduler_Factory.a(a4, (Provider<BackendRegistry>)d, (Provider<WorkScheduler>)a3, (Provider<EventStore>)g, (Provider<SynchronizationGuard>)g);
        final Provider<Context> b2 = this.b;
        final Provider d2 = this.d;
        final Provider<SQLiteEventStore> g2 = this.g;
        this.p = (Provider<Uploader>)Uploader_Factory.a(b2, (Provider<BackendRegistry>)d2, (Provider<EventStore>)g2, this.i, this.a, (Provider<SynchronizationGuard>)g2, (Provider<Clock>)TimeModule_EventClockFactory.a(), (Provider<Clock>)TimeModule_UptimeClockFactory.a(), (Provider<ClientHealthMetricsStore>)this.g);
        final Provider<Executor> a5 = this.a;
        final Provider<SQLiteEventStore> g3 = this.g;
        this.w = (Provider<WorkInitializer>)WorkInitializer_Factory.a(a5, (Provider<EventStore>)g3, this.i, (Provider<SynchronizationGuard>)g3);
        this.x = DoubleCheck.b(TransportRuntime_Factory.a((Provider<Clock>)TimeModule_EventClockFactory.a(), (Provider<Clock>)TimeModule_UptimeClockFactory.a(), (Provider<Scheduler>)this.j, this.p, this.w));
    }
    
    @Override
    EventStore a() {
        return (EventStore)this.g.get();
    }
    
    @Override
    TransportRuntime c() {
        return (TransportRuntime)this.x.get();
    }
    
    private static final class b implements a
    {
        private Context a;
        
        private b() {
        }
        
        b(final d$a object) {
            this();
        }
        
        @Override
        public /* bridge */ a a(final Context context) {
            return this.b(context);
        }
        
        public b b(final Context context) {
            this.a = Preconditions.b(context);
            return this;
        }
        
        @Override
        public k build() {
            Preconditions.a(this.a, Context.class);
            return new d(this.a, null);
        }
    }
}
