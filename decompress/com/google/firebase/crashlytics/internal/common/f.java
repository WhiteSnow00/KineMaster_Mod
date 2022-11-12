// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.TimeoutException;
import com.google.firebase.crashlytics.internal.settings.Settings;
import java.io.IOException;
import java.util.Locale;
import android.os.Build;
import android.os.StatFs;
import android.os.Environment;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import android.app.ApplicationExitInfo;
import android.app.ActivityManager;
import android.os.Build$VERSION;
import com.google.android.gms.tasks.SuccessContinuation;
import java.util.Iterator;
import java.util.Collection;
import java.util.concurrent.Executor;
import android.os.Bundle;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import android.content.Context;
import java.io.FilenameFilter;

class f
{
    static final FilenameFilter s;
    private final Context a;
    private final DataCollectionArbiter b;
    private final h c;
    private final UserMetadata d;
    private final CrashlyticsBackgroundWorker e;
    private final IdManager f;
    private final FileStore g;
    private final AppData h;
    private final LogFileManager i;
    private final CrashlyticsNativeComponent j;
    private final AnalyticsEventLogger k;
    private final SessionReportingCoordinator l;
    private i m;
    private SettingsProvider n;
    final TaskCompletionSource<Boolean> o;
    final TaskCompletionSource<Boolean> p;
    final TaskCompletionSource<Void> q;
    final AtomicBoolean r;
    
    static {
        s = e.a;
    }
    
    f(final Context a, final CrashlyticsBackgroundWorker e, final IdManager f, final DataCollectionArbiter b, final FileStore g, final h c, final AppData h, final UserMetadata d, final LogFileManager i, final SessionReportingCoordinator l, final CrashlyticsNativeComponent j, final AnalyticsEventLogger k) {
        this.n = null;
        this.o = (TaskCompletionSource<Boolean>)new TaskCompletionSource();
        this.p = (TaskCompletionSource<Boolean>)new TaskCompletionSource();
        this.q = (TaskCompletionSource<Void>)new TaskCompletionSource();
        this.r = new AtomicBoolean(false);
        this.a = a;
        this.e = e;
        this.f = f;
        this.b = b;
        this.g = g;
        this.c = c;
        this.h = h;
        this.d = d;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
    }
    
    private static boolean A() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        }
        catch (final ClassNotFoundException ex) {
            return false;
        }
    }
    
    private String B() {
        final SortedSet<String> n = this.l.n();
        String s;
        if (!n.isEmpty()) {
            s = n.first();
        }
        else {
            s = null;
        }
        return s;
    }
    
    private static long C() {
        return E(System.currentTimeMillis());
    }
    
    static List<l> D(final NativeSessionFileProvider nativeSessionFileProvider, final String s, final FileStore fileStore, final byte[] array) {
        final File o = fileStore.o(s, "user-data");
        final File o2 = fileStore.o(s, "keys");
        final ArrayList list = new ArrayList();
        list.add(new c("logs_file", "logs", array));
        list.add(new j("crash_meta_file", "metadata", nativeSessionFileProvider.c()));
        list.add(new j("session_meta_file", "session", nativeSessionFileProvider.f()));
        list.add(new j("app_meta_file", "app", nativeSessionFileProvider.d()));
        list.add(new j("device_meta_file", "device", nativeSessionFileProvider.a()));
        list.add(new j("os_meta_file", "os", nativeSessionFileProvider.e()));
        list.add(new j("minidump_file", "minidump", nativeSessionFileProvider.b()));
        list.add(new j("user_meta_file", "user", o));
        list.add(new j("keys_file", "keys", o2));
        return list;
    }
    
    private static long E(final long n) {
        return n / 1000L;
    }
    
    private static boolean I(final File file, final String s) {
        return s.startsWith(".ae");
    }
    
    private Task<Void> K(final long n) {
        if (A()) {
            Logger.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return (Task<Void>)Tasks.e((Object)null);
        }
        Logger.f().b("Logging app exception event to Firebase Analytics");
        return (Task<Void>)Tasks.c((Executor)new ScheduledThreadPoolExecutor(1), (Callable)new Callable<Void>(this, n) {
            final long a;
            final f b;
            
            public Void a() throws Exception {
                final Bundle bundle = new Bundle();
                bundle.putInt("fatal", 1);
                bundle.putLong("timestamp", this.a);
                com.google.firebase.crashlytics.internal.common.f.f(this.b).a("_ae", bundle);
                return null;
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    private Task<Void> L() {
        final ArrayList list = new ArrayList();
        for (final File file : this.J()) {
            try {
                list.add(this.K(Long.parseLong(file.getName().substring(3))));
            }
            catch (final NumberFormatException ex) {
                final Logger f = Logger.f();
                final StringBuilder sb = new StringBuilder();
                sb.append("Could not parse app exception timestamp from file ");
                sb.append(file.getName());
                f.k(sb.toString());
            }
            file.delete();
        }
        return (Task<Void>)Tasks.f((Collection)list);
    }
    
    private Task<Boolean> O() {
        if (this.b.d()) {
            Logger.f().b("Automatic data collection is enabled. Allowing upload.");
            this.o.e((Object)Boolean.FALSE);
            return (Task<Boolean>)Tasks.e((Object)Boolean.TRUE);
        }
        Logger.f().b("Automatic data collection is disabled.");
        Logger.f().i("Notifying that unsent reports are available.");
        this.o.e((Object)Boolean.TRUE);
        final Task u = this.b.i().u((SuccessContinuation)new SuccessContinuation<Void, Boolean>(this) {
            final f a;
            
            public /* bridge */ Task a(final Object o) throws Exception {
                return this.b((Void)o);
            }
            
            public Task<Boolean> b(final Void void1) throws Exception {
                return (Task<Boolean>)Tasks.e((Object)Boolean.TRUE);
            }
        });
        Logger.f().b("Waiting for send/deleteUnsentReports to be called.");
        return Utils.i((com.google.android.gms.tasks.Task<Boolean>)u, (com.google.android.gms.tasks.Task<Boolean>)this.p.a());
    }
    
    private void P(final String s) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 30) {
            final List historicalProcessExitReasons = ((ActivityManager)this.a.getSystemService("activity")).getHistoricalProcessExitReasons((String)null, 0, 0);
            if (historicalProcessExitReasons.size() != 0) {
                this.l.t(s, historicalProcessExitReasons, new LogFileManager(this.g, s), UserMetadata.c(s, this.g, this.e));
            }
            else {
                final Logger f = Logger.f();
                final StringBuilder sb = new StringBuilder();
                sb.append("No ApplicationExitInfo available. Session: ");
                sb.append(s);
                f.i(sb.toString());
            }
        }
        else {
            final Logger f2 = Logger.f();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("ANR feature enabled, but device is API ");
            sb2.append(sdk_INT);
            f2.i(sb2.toString());
        }
    }
    
    public static boolean a(final File file, final String s) {
        return I(file, s);
    }
    
    static long b(final long n) {
        return E(n);
    }
    
    static String c(final f f) {
        return f.B();
    }
    
    static void d(final List list) {
        r(list);
    }
    
    static LogFileManager e(final f f) {
        return f.i;
    }
    
    static AnalyticsEventLogger f(final f f) {
        return f.k;
    }
    
    static h g(final f f) {
        return f.c;
    }
    
    static SessionReportingCoordinator h(final f f) {
        return f.l;
    }
    
    static void i(final f f, final long n) {
        f.w(n);
    }
    
    static IdManager j(final f f) {
        return f.f;
    }
    
    static void k(final f f, final String s) {
        f.v(s);
    }
    
    static DataCollectionArbiter l(final f f) {
        return f.b;
    }
    
    static CrashlyticsBackgroundWorker m(final f f) {
        return f.e;
    }
    
    static Task n(final f f) {
        return f.L();
    }
    
    private static StaticSessionData.AppData o(final IdManager idManager, final AppData appData) {
        return StaticSessionData.AppData.b(idManager.f(), appData.e, appData.f, idManager.a(), DeliveryMechanism.determineFrom(appData.c).getId(), appData.g);
    }
    
    private static StaticSessionData.DeviceData p() {
        final StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return StaticSessionData.DeviceData.c(CommonUtils.l(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.s(), statFs.getBlockCount() * (long)statFs.getBlockSize(), CommonUtils.x(), CommonUtils.m(), Build.MANUFACTURER, Build.PRODUCT);
    }
    
    private static StaticSessionData.OsData q() {
        return StaticSessionData.OsData.a(Build$VERSION.RELEASE, Build$VERSION.CODENAME, CommonUtils.y());
    }
    
    private static void r(final List<File> list) {
        final Iterator<File> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().delete();
        }
    }
    
    private void u(final boolean b, final SettingsProvider settingsProvider) {
        final ArrayList list = new ArrayList((Collection<? extends E>)this.l.n());
        if (list.size() <= (b ? 1 : 0)) {
            Logger.f().i("No open sessions to be closed.");
            return;
        }
        final String s = (String)list.get(b ? 1 : 0);
        if (settingsProvider.b().b.b) {
            this.P(s);
        }
        else {
            Logger.f().i("ANR feature disabled.");
        }
        if (this.j.d(s)) {
            this.y(s);
        }
        String s2 = null;
        if ((b ? 1 : 0) != 0) {
            s2 = (String)list.get(0);
        }
        this.l.i(C(), s2);
    }
    
    private void v(final String s) {
        final long c = C();
        final Logger f = Logger.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("Opening a new session with ID ");
        sb.append(s);
        f.b(sb.toString());
        this.j.c(s, String.format(Locale.US, "Crashlytics Android SDK/%s", CrashlyticsCore.i()), c, StaticSessionData.b(o(this.f, this.h), q(), p()));
        this.i.e(s);
        this.l.o(s, c);
    }
    
    private void w(final long n) {
        try {
            final FileStore g = this.g;
            final StringBuilder sb = new StringBuilder();
            sb.append(".ae");
            sb.append(n);
            if (!g.e(sb.toString()).createNewFile()) {
                throw new IOException("Create new file failed.");
            }
        }
        catch (final IOException ex) {
            Logger.f().l("Could not create app exception marker file.", ex);
        }
    }
    
    private void y(final String s) {
        final Logger f = Logger.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("Finalizing native report for session ");
        sb.append(s);
        f.i(sb.toString());
        final NativeSessionFileProvider a = this.j.a(s);
        final File b = a.b();
        if (b == null || !b.exists()) {
            final Logger f2 = Logger.f();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("No minidump data found for session ");
            sb2.append(s);
            f2.k(sb2.toString());
            return;
        }
        final long lastModified = b.lastModified();
        final LogFileManager logFileManager = new LogFileManager(this.g, s);
        final File i = this.g.i(s);
        if (!i.isDirectory()) {
            Logger.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        this.w(lastModified);
        final List<l> d = D(a, s, this.g, logFileManager.b());
        com.google.firebase.crashlytics.internal.common.m.b(i, d);
        Logger.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.l.h(s, d);
        logFileManager.a();
    }
    
    void F(final SettingsProvider settingsProvider, final Thread thread, final Throwable t) {
        this.G(settingsProvider, thread, t, false);
    }
    
    void G(final SettingsProvider settingsProvider, final Thread thread, final Throwable t, final boolean b) {
        synchronized (this) {
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Handling uncaught exception \"");
            sb.append(t);
            sb.append("\" from thread ");
            sb.append(thread.getName());
            f.b(sb.toString());
            final com.google.android.gms.tasks.Task<T> i = this.e.i((Callable<com.google.android.gms.tasks.Task<T>>)new Callable<Task<Void>>(this, System.currentTimeMillis(), t, thread, settingsProvider, b) {
                final long a;
                final Throwable b;
                final Thread c;
                final SettingsProvider d;
                final boolean e;
                final f f;
                
                public Task<Void> a() throws Exception {
                    final long b = com.google.firebase.crashlytics.internal.common.f.b(this.a);
                    final String c = com.google.firebase.crashlytics.internal.common.f.c(this.f);
                    if (c == null) {
                        Logger.f().d("Tried to write a fatal exception while no session was open.");
                        return (Task<Void>)Tasks.e((Object)null);
                    }
                    com.google.firebase.crashlytics.internal.common.f.g(this.f).a();
                    com.google.firebase.crashlytics.internal.common.f.h(this.f).r(this.b, this.c, c, b);
                    com.google.firebase.crashlytics.internal.common.f.i(this.f, this.a);
                    this.f.t(this.d);
                    com.google.firebase.crashlytics.internal.common.f.k(this.f, new d(com.google.firebase.crashlytics.internal.common.f.j(this.f)).toString());
                    if (!com.google.firebase.crashlytics.internal.common.f.l(this.f).d()) {
                        return (Task<Void>)Tasks.e((Object)null);
                    }
                    final Executor c2 = com.google.firebase.crashlytics.internal.common.f.m(this.f).c();
                    return (Task<Void>)this.d.a().v(c2, (SuccessContinuation)new SuccessContinuation<Settings, Void>(this, c2, c) {
                        final Executor a;
                        final String b;
                        final f$b c;
                        
                        public /* bridge */ Task a(final Object o) throws Exception {
                            return this.b((Settings)o);
                        }
                        
                        public Task<Void> b(final Settings settings) throws Exception {
                            final String s = null;
                            if (settings == null) {
                                Logger.f().k("Received null app settings, cannot send reports at crash time.");
                                return (Task<Void>)Tasks.e((Object)null);
                            }
                            final Task n = com.google.firebase.crashlytics.internal.common.f.n(this.c.f);
                            final SessionReportingCoordinator h = com.google.firebase.crashlytics.internal.common.f.h(this.c.f);
                            final Executor a = this.a;
                            String b = s;
                            if (this.c.e) {
                                b = this.b;
                            }
                            return (Task<Void>)Tasks.g(new Task[] { n, h.w(a, b) });
                        }
                    });
                }
                
                @Override
                public /* bridge */ Object call() throws Exception {
                    return this.a();
                }
            });
            try {
                Utils.d((com.google.android.gms.tasks.Task<Object>)i);
            }
            catch (final Exception ex) {
                Logger.f().e("Error handling uncaught exception", ex);
            }
            catch (final TimeoutException ex2) {
                Logger.f().d("Cannot send reports. Timed out while fetching settings.");
            }
        }
    }
    
    boolean H() {
        final i m = this.m;
        return m != null && m.a();
    }
    
    List<File> J() {
        return this.g.f(com.google.firebase.crashlytics.internal.common.f.s);
    }
    
    void M(final String s) {
        this.e.h((Callable<Object>)new Callable<Void>(this, s) {
            final String a;
            final f b;
            
            public Void a() throws Exception {
                com.google.firebase.crashlytics.internal.common.f.k(this.b, this.a);
                return null;
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    Task<Void> N(final Task<Settings> task) {
        if (!this.l.l()) {
            Logger.f().i("No crash reports are available to be sent.");
            this.o.e((Object)Boolean.FALSE);
            return (Task<Void>)Tasks.e((Object)null);
        }
        Logger.f().i("Crash reports are available to be sent.");
        return (Task<Void>)this.O().u((SuccessContinuation)new SuccessContinuation<Boolean, Void>(this, task) {
            final Task a;
            final f b;
            
            public /* bridge */ Task a(final Object o) throws Exception {
                return this.b((Boolean)o);
            }
            
            public Task<Void> b(final Boolean b) throws Exception {
                return com.google.firebase.crashlytics.internal.common.f.m(this.b).i((Callable<com.google.android.gms.tasks.Task<Void>>)new Callable<Task<Void>>(this, b) {
                    final Boolean a;
                    final f$d b;
                    
                    public Task<Void> a() throws Exception {
                        if (!this.a) {
                            Logger.f().i("Deleting cached crash reports...");
                            com.google.firebase.crashlytics.internal.common.f.d(this.b.b.J());
                            com.google.firebase.crashlytics.internal.common.f.h(this.b.b).u();
                            this.b.b.q.e((Object)null);
                            return (Task<Void>)Tasks.e((Object)null);
                        }
                        Logger.f().b("Sending cached crash reports...");
                        com.google.firebase.crashlytics.internal.common.f.l(this.b.b).c(this.a);
                        final Executor c = com.google.firebase.crashlytics.internal.common.f.m(this.b.b).c();
                        return (Task<Void>)this.b.a.v(c, (SuccessContinuation)new SuccessContinuation<Settings, Void>(this, c) {
                            final Executor a;
                            final f$d$a b;
                            
                            public /* bridge */ Task a(final Object o) throws Exception {
                                return this.b((Settings)o);
                            }
                            
                            public Task<Void> b(final Settings settings) throws Exception {
                                if (settings == null) {
                                    Logger.f().k("Received null app settings at app startup. Cannot send cached reports");
                                    return (Task<Void>)Tasks.e((Object)null);
                                }
                                com.google.firebase.crashlytics.internal.common.f.n(this.b.b.b);
                                com.google.firebase.crashlytics.internal.common.f.h(this.b.b.b).v(this.a);
                                this.b.b.b.q.e((Object)null);
                                return (Task<Void>)Tasks.e((Object)null);
                            }
                        });
                    }
                    
                    @Override
                    public /* bridge */ Object call() throws Exception {
                        return this.a();
                    }
                });
            }
        });
    }
    
    void Q(final Thread thread, final Throwable t) {
        this.e.g(new Runnable(this, System.currentTimeMillis(), t, thread) {
            final long a;
            final Throwable b;
            final Thread c;
            final f d;
            
            @Override
            public void run() {
                if (!this.d.H()) {
                    final long b = com.google.firebase.crashlytics.internal.common.f.b(this.a);
                    final String c = com.google.firebase.crashlytics.internal.common.f.c(this.d);
                    if (c == null) {
                        Logger.f().k("Tried to write a non-fatal exception while no session was open.");
                        return;
                    }
                    com.google.firebase.crashlytics.internal.common.f.h(this.d).s(this.b, this.c, c, b);
                }
            }
        });
    }
    
    void R(final long n, final String s) {
        this.e.h((Callable<Object>)new Callable<Void>(this, n, s) {
            final long a;
            final String b;
            final f c;
            
            public Void a() throws Exception {
                if (!this.c.H()) {
                    com.google.firebase.crashlytics.internal.common.f.e(this.c).g(this.a, this.b);
                }
                return null;
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    boolean s() {
        final boolean c = this.c.c();
        boolean b = true;
        if (!c) {
            final String b2 = this.B();
            if (b2 == null || !this.j.d(b2)) {
                b = false;
            }
            return b;
        }
        Logger.f().i("Found previous crash marker.");
        this.c.d();
        return true;
    }
    
    void t(final SettingsProvider settingsProvider) {
        this.u(false, settingsProvider);
    }
    
    void x(final String s, final Thread.UncaughtExceptionHandler uncaughtExceptionHandler, final SettingsProvider n) {
        this.n = n;
        this.M(s);
        Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)(this.m = new i((i.a)new i.a(this) {
            final f a;
            
            @Override
            public void a(final SettingsProvider settingsProvider, final Thread thread, final Throwable t) {
                this.a.F(settingsProvider, thread, t);
            }
        }, n, uncaughtExceptionHandler, this.j)));
    }
    
    boolean z(final SettingsProvider settingsProvider) {
        this.e.b();
        if (this.H()) {
            Logger.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger.f().i("Finalizing previously open sessions.");
        try {
            this.u(true, settingsProvider);
            Logger.f().i("Closed all previously open sessions.");
            return true;
        }
        catch (final Exception ex) {
            Logger.f().e("Unable to finalize previously open sessions.", ex);
            return false;
        }
    }
}
