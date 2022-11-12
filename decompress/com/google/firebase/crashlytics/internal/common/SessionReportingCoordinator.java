// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.util.Collection;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.Continuation;
import java.util.concurrent.Executor;
import java.util.SortedSet;
import java.io.File;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import android.content.Context;
import java.nio.charset.StandardCharsets;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import android.app.ApplicationExitInfo;
import java.util.List;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;

public class SessionReportingCoordinator
{
    private final CrashlyticsReportDataCapture a;
    private final CrashlyticsReportPersistence b;
    private final DataTransportCrashlyticsReportSender c;
    private final LogFileManager d;
    private final UserMetadata e;
    
    SessionReportingCoordinator(final CrashlyticsReportDataCapture a, final CrashlyticsReportPersistence b, final DataTransportCrashlyticsReportSender c, final LogFileManager d, final UserMetadata e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public static boolean a(final SessionReportingCoordinator sessionReportingCoordinator, final Task task) {
        return sessionReportingCoordinator.p((Task<CrashlyticsReportWithSessionId>)task);
    }
    
    public static int b(final CrashlyticsReport.CustomAttribute customAttribute, final CrashlyticsReport.CustomAttribute customAttribute2) {
        return m(customAttribute, customAttribute2);
    }
    
    private CrashlyticsReport.Session.Event c(final CrashlyticsReport.Session.Event event) {
        return this.d(event, this.d, this.e);
    }
    
    private CrashlyticsReport.Session.Event d(final CrashlyticsReport.Session.Event event, final LogFileManager logFileManager, final UserMetadata userMetadata) {
        final CrashlyticsReport.Session.Event.Builder g = event.g();
        final String c = logFileManager.c();
        if (c != null) {
            g.d(CrashlyticsReport.Session.Event.Log.a().b(c).a());
        }
        else {
            Logger.f().i("No log data to include with this event.");
        }
        final List<CrashlyticsReport.CustomAttribute> k = k(userMetadata.a());
        final List<CrashlyticsReport.CustomAttribute> i = k(userMetadata.b());
        if (!k.isEmpty() || !i.isEmpty()) {
            g.b(event.b().g().c(ImmutableList.a(k)).e(ImmutableList.a(i)).a());
        }
        return g.a();
    }
    
    private static CrashlyticsReport.ApplicationExitInfo e(final ApplicationExitInfo applicationExitInfo) {
        final String s = null;
        String f;
        try {
            final InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            f = s;
            if (traceInputStream != null) {
                f = f(traceInputStream);
            }
        }
        catch (final IOException ex) {
            final Logger f2 = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not get input trace in application exit info: ");
            sb.append(applicationExitInfo.toString());
            sb.append(" Error: ");
            sb.append(ex);
            f2.k(sb.toString());
            f = s;
        }
        return CrashlyticsReport.ApplicationExitInfo.a().b(applicationExitInfo.getImportance()).d(applicationExitInfo.getProcessName()).f(applicationExitInfo.getReason()).h(applicationExitInfo.getTimestamp()).c(applicationExitInfo.getPid()).e(applicationExitInfo.getPss()).g(applicationExitInfo.getRss()).i(f).a();
    }
    
    public static String f(final InputStream inputStream) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final byte[] array = new byte[8192];
        while (true) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(array, 0, read);
        }
        return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
    }
    
    public static SessionReportingCoordinator g(final Context context, final IdManager idManager, final FileStore fileStore, final AppData appData, final LogFileManager logFileManager, final UserMetadata userMetadata, final StackTraceTrimmingStrategy stackTraceTrimmingStrategy, final SettingsProvider settingsProvider, final OnDemandCounter onDemandCounter) {
        return new SessionReportingCoordinator(new CrashlyticsReportDataCapture(context, idManager, appData, stackTraceTrimmingStrategy), new CrashlyticsReportPersistence(fileStore, settingsProvider), DataTransportCrashlyticsReportSender.b(context, settingsProvider, onDemandCounter), logFileManager, userMetadata);
    }
    
    private ApplicationExitInfo j(final String s, final List<ApplicationExitInfo> list) {
        final long q = this.b.q(s);
        for (final ApplicationExitInfo applicationExitInfo : list) {
            if (applicationExitInfo.getTimestamp() < q) {
                return null;
            }
            if (applicationExitInfo.getReason() != 6) {
                continue;
            }
            return applicationExitInfo;
        }
        return null;
    }
    
    private static List<CrashlyticsReport.CustomAttribute> k(final Map<String, String> map) {
        final ArrayList list = new ArrayList();
        list.ensureCapacity(map.size());
        for (final Map.Entry entry : map.entrySet()) {
            list.add(CrashlyticsReport.CustomAttribute.a().b((String)entry.getKey()).c((String)entry.getValue()).a());
        }
        Collections.sort((List<Object>)list, o.a);
        return list;
    }
    
    private static int m(final CrashlyticsReport.CustomAttribute customAttribute, final CrashlyticsReport.CustomAttribute customAttribute2) {
        return customAttribute.b().compareTo(customAttribute2.b());
    }
    
    private boolean p(final Task<CrashlyticsReportWithSessionId> task) {
        if (task.t()) {
            final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId)task.p();
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Crashlytics report successfully enqueued to DataTransport: ");
            sb.append(crashlyticsReportWithSessionId.d());
            f.b(sb.toString());
            final File c = crashlyticsReportWithSessionId.c();
            if (c.delete()) {
                final Logger f2 = Logger.f();
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Deleted report file: ");
                sb2.append(c.getPath());
                f2.b(sb2.toString());
            }
            else {
                final Logger f3 = Logger.f();
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Crashlytics could not delete report file: ");
                sb3.append(c.getPath());
                f3.k(sb3.toString());
            }
            return true;
        }
        Logger.f().l("Crashlytics report could not be enqueued to DataTransport", task.o());
        return false;
    }
    
    private void q(final Throwable t, final Thread thread, final String s, final String s2, final long n, final boolean b) {
        this.b.y(this.c(this.a.c(t, thread, s2, n, 4, 8, b)), s, s2.equals("crash"));
    }
    
    public void h(final String s, final List<l> list) {
        Logger.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        final ArrayList list2 = new ArrayList();
        final Iterator<l> iterator = list.iterator();
        while (iterator.hasNext()) {
            final CrashlyticsReport.FilesPayload.File a = iterator.next().a();
            if (a != null) {
                list2.add(a);
            }
        }
        this.b.l(s, CrashlyticsReport.FilesPayload.a().b(ImmutableList.a((List<CrashlyticsReport.FilesPayload.File>)list2)).a());
    }
    
    public void i(final long n, final String s) {
        this.b.k(s, n);
    }
    
    public boolean l() {
        return this.b.r();
    }
    
    public SortedSet<String> n() {
        return this.b.p();
    }
    
    public void o(final String s, final long n) {
        this.b.z(this.a.d(s, n));
    }
    
    public void r(final Throwable t, final Thread thread, final String s, final long n) {
        final Logger f = Logger.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("Persisting fatal event for session ");
        sb.append(s);
        f.i(sb.toString());
        this.q(t, thread, s, "crash", n, true);
    }
    
    public void s(final Throwable t, final Thread thread, final String s, final long n) {
        final Logger f = Logger.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("Persisting non-fatal event for session ");
        sb.append(s);
        f.i(sb.toString());
        this.q(t, thread, s, "error", n, false);
    }
    
    public void t(final String s, final List<ApplicationExitInfo> list, final LogFileManager logFileManager, final UserMetadata userMetadata) {
        final ApplicationExitInfo j = this.j(s, list);
        if (j == null) {
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("No relevant ApplicationExitInfo occurred during session: ");
            sb.append(s);
            f.i(sb.toString());
            return;
        }
        final CrashlyticsReport.Session.Event b = this.a.b(e(j));
        final Logger f2 = Logger.f();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Persisting anr for session ");
        sb2.append(s);
        f2.b(sb2.toString());
        this.b.y(this.d(b, logFileManager, userMetadata), s, true);
    }
    
    public void u() {
        this.b.i();
    }
    
    public Task<Void> v(final Executor executor) {
        return this.w(executor, null);
    }
    
    public Task<Void> w(final Executor executor, final String s) {
        final List<CrashlyticsReportWithSessionId> w = this.b.w();
        final ArrayList list = new ArrayList();
        for (final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId : w) {
            if (s == null || s.equals(crashlyticsReportWithSessionId.d())) {
                list.add(this.c.c(crashlyticsReportWithSessionId, s != null).l(executor, (Continuation)new n(this)));
            }
        }
        return (Task<Void>)Tasks.f((Collection)list);
    }
}
