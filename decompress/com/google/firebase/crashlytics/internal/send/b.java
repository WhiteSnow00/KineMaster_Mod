// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.send;

import java.util.Locale;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.Event;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.settings.Settings;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.android.datatransport.Transport;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;

final class b
{
    private final double a;
    private final double b;
    private final long c;
    private final int d;
    private final BlockingQueue<Runnable> e;
    private final ThreadPoolExecutor f;
    private final Transport<CrashlyticsReport> g;
    private final OnDemandCounter h;
    private int i;
    private long j;
    
    b(final double a, final double b, final long c, final Transport<CrashlyticsReport> g, final OnDemandCounter h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.g = g;
        this.h = h;
        final int d = (int)a;
        this.d = d;
        final ArrayBlockingQueue e = new ArrayBlockingQueue<Runnable>(d);
        this.e = (BlockingQueue<Runnable>)e;
        this.f = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>)e);
        this.i = 0;
        this.j = 0L;
    }
    
    b(final Transport<CrashlyticsReport> transport, final Settings settings, final OnDemandCounter onDemandCounter) {
        this(settings.f, settings.g, settings.h * 1000L, transport, onDemandCounter);
    }
    
    public static void a(final TaskCompletionSource taskCompletionSource, final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final Exception ex) {
        k(taskCompletionSource, crashlyticsReportWithSessionId, ex);
    }
    
    static void b(final b b, final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final TaskCompletionSource taskCompletionSource) {
        b.m(crashlyticsReportWithSessionId, (TaskCompletionSource<CrashlyticsReportWithSessionId>)taskCompletionSource);
    }
    
    static OnDemandCounter c(final b b) {
        return b.h;
    }
    
    static double d(final b b) {
        return b.f();
    }
    
    static void e(final double n) {
        n(n);
    }
    
    private double f() {
        return Math.min(3600000.0, 60000.0 / this.a * Math.pow(this.b, this.g()));
    }
    
    private int g() {
        if (this.j == 0L) {
            this.j = this.l();
        }
        final int n = (int)((this.l() - this.j) / this.c);
        int i;
        if (this.j()) {
            i = Math.min(100, this.i + n);
        }
        else {
            i = Math.max(0, this.i - n);
        }
        if (this.i != i) {
            this.i = i;
            this.j = this.l();
        }
        return i;
    }
    
    private boolean i() {
        return this.e.size() < this.d;
    }
    
    private boolean j() {
        return this.e.size() == this.d;
    }
    
    private static void k(final TaskCompletionSource taskCompletionSource, final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final Exception ex) {
        if (ex != null) {
            taskCompletionSource.d(ex);
            return;
        }
        taskCompletionSource.e((Object)crashlyticsReportWithSessionId);
    }
    
    private long l() {
        return System.currentTimeMillis();
    }
    
    private void m(final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
        final Logger f = Logger.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("Sending report through Google DataTransport: ");
        sb.append(crashlyticsReportWithSessionId.d());
        f.b(sb.toString());
        this.g.a(Event.e(crashlyticsReportWithSessionId.b()), new a(taskCompletionSource, crashlyticsReportWithSessionId));
    }
    
    private static void n(final double n) {
        final long n2 = (long)n;
        try {
            Thread.sleep(n2);
        }
        catch (final InterruptedException ex) {}
    }
    
    TaskCompletionSource<CrashlyticsReportWithSessionId> h(final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final boolean b) {
        synchronized (this.e) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            if (!b) {
                this.m(crashlyticsReportWithSessionId, (TaskCompletionSource<CrashlyticsReportWithSessionId>)taskCompletionSource);
                return (TaskCompletionSource<CrashlyticsReportWithSessionId>)taskCompletionSource;
            }
            this.h.b();
            if (this.i()) {
                final Logger f = Logger.f();
                final StringBuilder sb = new StringBuilder();
                sb.append("Enqueueing report: ");
                sb.append(crashlyticsReportWithSessionId.d());
                f.b(sb.toString());
                final Logger f2 = Logger.f();
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Queue size: ");
                sb2.append(this.e.size());
                f2.b(sb2.toString());
                this.f.execute(new b(crashlyticsReportWithSessionId, taskCompletionSource, null));
                final Logger f3 = Logger.f();
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Closing task for report: ");
                sb3.append(crashlyticsReportWithSessionId.d());
                f3.b(sb3.toString());
                taskCompletionSource.e((Object)crashlyticsReportWithSessionId);
                return (TaskCompletionSource<CrashlyticsReportWithSessionId>)taskCompletionSource;
            }
            this.g();
            final Logger f4 = Logger.f();
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("Dropping report due to queue being full: ");
            sb4.append(crashlyticsReportWithSessionId.d());
            f4.b(sb4.toString());
            this.h.a();
            taskCompletionSource.e((Object)crashlyticsReportWithSessionId);
            return (TaskCompletionSource<CrashlyticsReportWithSessionId>)taskCompletionSource;
        }
    }
    
    private final class b implements Runnable
    {
        private final CrashlyticsReportWithSessionId a;
        private final TaskCompletionSource<CrashlyticsReportWithSessionId> b;
        final com.google.firebase.crashlytics.internal.send.b c;
        
        private b(final com.google.firebase.crashlytics.internal.send.b c, final CrashlyticsReportWithSessionId a, final TaskCompletionSource<CrashlyticsReportWithSessionId> b) {
            this.c = c;
            this.a = a;
            this.b = b;
        }
        
        b(final com.google.firebase.crashlytics.internal.send.b b, final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final TaskCompletionSource taskCompletionSource, final b$a object) {
            this(crashlyticsReportWithSessionId, (TaskCompletionSource<CrashlyticsReportWithSessionId>)taskCompletionSource);
        }
        
        @Override
        public void run() {
            com.google.firebase.crashlytics.internal.send.b.b(this.c, this.a, this.b);
            com.google.firebase.crashlytics.internal.send.b.c(this.c).c();
            final double d = com.google.firebase.crashlytics.internal.send.b.d(this.c);
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Delay for: ");
            sb.append(String.format(Locale.US, "%.2f", d / 1000.0));
            sb.append(" s for report: ");
            sb.append(this.a.d());
            f.b(sb.toString());
            com.google.firebase.crashlytics.internal.send.b.e(d);
        }
    }
}
