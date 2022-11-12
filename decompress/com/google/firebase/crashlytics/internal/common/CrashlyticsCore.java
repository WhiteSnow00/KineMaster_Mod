// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import android.util.Log;
import android.text.TextUtils;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import java.util.concurrent.Callable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.util.concurrent.Executor;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import java.util.concurrent.ExecutorService;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.FirebaseApp;
import android.content.Context;

public class CrashlyticsCore
{
    private final Context a;
    private final FirebaseApp b;
    private final DataCollectionArbiter c;
    private final OnDemandCounter d;
    private final long e;
    private h f;
    private h g;
    private boolean h;
    private f i;
    private final IdManager j;
    private final FileStore k;
    public final BreadcrumbSource l;
    private final AnalyticsEventLogger m;
    private final ExecutorService n;
    private final CrashlyticsBackgroundWorker o;
    private final CrashlyticsNativeComponent p;
    
    public CrashlyticsCore(final FirebaseApp b, final IdManager j, final CrashlyticsNativeComponent p8, final DataCollectionArbiter c, final BreadcrumbSource l, final AnalyticsEventLogger m, final FileStore k, final ExecutorService n) {
        this.b = b;
        this.c = c;
        this.a = b.l();
        this.j = j;
        this.p = p8;
        this.l = l;
        this.m = m;
        this.n = n;
        this.k = k;
        this.o = new CrashlyticsBackgroundWorker(n);
        this.e = System.currentTimeMillis();
        this.d = new OnDemandCounter();
    }
    
    static Task a(final CrashlyticsCore crashlyticsCore, final SettingsProvider settingsProvider) {
        return crashlyticsCore.f(settingsProvider);
    }
    
    static h b(final CrashlyticsCore crashlyticsCore) {
        return crashlyticsCore.f;
    }
    
    static f c(final CrashlyticsCore crashlyticsCore) {
        return crashlyticsCore.i;
    }
    
    private void d() {
        final com.google.android.gms.tasks.Task<T> h = this.o.h((Callable<T>)new Callable<Boolean>(this) {
            final CrashlyticsCore a;
            
            public Boolean a() throws Exception {
                return CrashlyticsCore.c(this.a).s();
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
        try {
            this.h = Boolean.TRUE.equals(Utils.d((com.google.android.gms.tasks.Task<Boolean>)h));
        }
        catch (final Exception ex) {
            this.h = false;
        }
    }
    
    private Task<Void> f(final SettingsProvider settingsProvider) {
        this.n();
        try {
            try {
                this.l.a(new g(this));
                if (!settingsProvider.b().b.a) {
                    Logger.f().b("Collection of crash reports disabled in Crashlytics settings.");
                    final Task d = Tasks.d((Exception)new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
                    this.m();
                    return (Task<Void>)d;
                }
                if (!this.i.z(settingsProvider)) {
                    Logger.f().k("Previous sessions could not be finalized.");
                }
                final Task<Void> n = this.i.N(settingsProvider.a());
                this.m();
                return n;
            }
            finally {}
        }
        catch (final Exception ex) {
            Logger.f().e("Crashlytics encountered a problem during asynchronous initialization.", ex);
            final Task d2 = Tasks.d(ex);
            this.m();
            return (Task<Void>)d2;
        }
        this.m();
    }
    
    private void h(final SettingsProvider settingsProvider) {
        final Future<?> submit = this.n.submit(new Runnable(this, settingsProvider) {
            final SettingsProvider a;
            final CrashlyticsCore b;
            
            @Override
            public void run() {
                CrashlyticsCore.a(this.b, this.a);
            }
        });
        Logger.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4L, TimeUnit.SECONDS);
        }
        catch (final TimeoutException ex) {
            Logger.f().e("Crashlytics timed out during initialization.", ex);
        }
        catch (final ExecutionException ex2) {
            Logger.f().e("Crashlytics encountered a problem during initialization.", ex2);
        }
        catch (final InterruptedException ex3) {
            Logger.f().e("Crashlytics was interrupted during initialization.", ex3);
        }
    }
    
    public static String i() {
        return "18.2.12";
    }
    
    static boolean j(final String s, final boolean b) {
        if (!b) {
            Logger.f().i("Configured not to require a build ID.");
            return true;
        }
        if (!TextUtils.isEmpty((CharSequence)s)) {
            return true;
        }
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".     |  | ");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".   \\ |  | /");
        Log.e("FirebaseCrashlytics", ".    \\    /");
        Log.e("FirebaseCrashlytics", ".     \\  /");
        Log.e("FirebaseCrashlytics", ".      \\/");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".      /\\");
        Log.e("FirebaseCrashlytics", ".     /  \\");
        Log.e("FirebaseCrashlytics", ".    /    \\");
        Log.e("FirebaseCrashlytics", ".   / |  | \\");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".");
        return false;
    }
    
    boolean e() {
        return this.f.c();
    }
    
    public Task<Void> g(final SettingsProvider settingsProvider) {
        return Utils.e(this.n, (Callable<com.google.android.gms.tasks.Task<Void>>)new Callable<Task<Void>>(this, settingsProvider) {
            final SettingsProvider a;
            final CrashlyticsCore b;
            
            public Task<Void> a() throws Exception {
                return (Task<Void>)CrashlyticsCore.a(this.b, this.a);
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public void k(final String s) {
        this.i.R(System.currentTimeMillis() - this.e, s);
    }
    
    public void l(final Throwable t) {
        this.i.Q(Thread.currentThread(), t);
    }
    
    void m() {
        this.o.h((Callable<Object>)new Callable<Boolean>(this) {
            final CrashlyticsCore a;
            
            public Boolean a() throws Exception {
                try {
                    final boolean d = CrashlyticsCore.b(this.a).d();
                    if (!d) {
                        Logger.f().k("Initialization marker file was not properly removed.");
                    }
                    return d;
                }
                catch (final Exception ex) {
                    Logger.f().e("Problem encountered deleting Crashlytics initialization marker.", ex);
                    return Boolean.FALSE;
                }
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    void n() {
        this.o.b();
        this.f.a();
        Logger.f().i("Initialization marker file was created.");
    }
    
    public boolean o(final AppData appData, final SettingsProvider settingsProvider) {
        if (j(appData.b, CommonUtils.k(this.a, "com.crashlytics.RequireBuildId", true))) {
            final String string = new d(this.j).toString();
            try {
                this.g = new h("crash_marker", this.k);
                this.f = new h("initialization_marker", this.k);
                final UserMetadata userMetadata = new UserMetadata(string, this.k, this.o);
                final LogFileManager logFileManager = new LogFileManager(this.k);
                this.i = new f(this.a, this.o, this.j, this.c, this.k, this.g, appData, userMetadata, logFileManager, SessionReportingCoordinator.g(this.a, this.j, this.k, appData, logFileManager, userMetadata, new MiddleOutFallbackStrategy(1024, new StackTraceTrimmingStrategy[] { new RemoveRepeatsStrategy(10) }), settingsProvider, this.d), this.p, this.m);
                final boolean e = this.e();
                this.d();
                this.i.x(string, Thread.getDefaultUncaughtExceptionHandler(), settingsProvider);
                if (e && CommonUtils.c(this.a)) {
                    Logger.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    this.h(settingsProvider);
                    return false;
                }
                Logger.f().b("Successfully configured exception handler.");
                return true;
            }
            catch (final Exception ex) {
                Logger.f().e("Crashlytics was not started due to an exception during initialization", ex);
                this.i = null;
                return false;
            }
        }
        throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
    }
    
    public void p(final Boolean b) {
        this.c.g(b);
    }
}
