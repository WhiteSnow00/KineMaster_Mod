// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics;

import java.util.concurrent.ExecutorService;
import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Continuation;
import java.util.concurrent.Executor;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.inject.Deferred;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Objects;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;

public class FirebaseCrashlytics
{
    final CrashlyticsCore a;
    
    private FirebaseCrashlytics(final CrashlyticsCore a) {
        this.a = a;
    }
    
    public static FirebaseCrashlytics a() {
        final FirebaseCrashlytics firebaseCrashlytics = FirebaseApp.m().j(FirebaseCrashlytics.class);
        Objects.requireNonNull(firebaseCrashlytics, "FirebaseCrashlytics component is not present.");
        return firebaseCrashlytics;
    }
    
    static FirebaseCrashlytics b(final FirebaseApp firebaseApp, final FirebaseInstallationsApi firebaseInstallationsApi, final Deferred<CrashlyticsNativeComponent> deferred, final Deferred<AnalyticsConnector> deferred2) {
        final Context l = firebaseApp.l();
        final String packageName = l.getPackageName();
        final Logger f = Logger.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("Initializing Firebase Crashlytics ");
        sb.append(CrashlyticsCore.i());
        sb.append(" for ");
        sb.append(packageName);
        f.g(sb.toString());
        final FileStore fileStore = new FileStore(l);
        final DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        final IdManager idManager = new IdManager(l, packageName, firebaseInstallationsApi, dataCollectionArbiter);
        final CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy = new CrashlyticsNativeComponentDeferredProxy(deferred);
        final AnalyticsDeferredProxy analyticsDeferredProxy = new AnalyticsDeferredProxy(deferred2);
        final CrashlyticsCore crashlyticsCore = new CrashlyticsCore(firebaseApp, idManager, crashlyticsNativeComponentDeferredProxy, dataCollectionArbiter, analyticsDeferredProxy.e(), analyticsDeferredProxy.d(), fileStore, ExecutorUtils.c("Crashlytics Exception Handler"));
        final String c = firebaseApp.p().c();
        final String n = CommonUtils.n(l);
        final Logger f2 = Logger.f();
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Mapping file ID is: ");
        sb2.append(n);
        f2.b(sb2.toString());
        final DevelopmentPlatformProvider developmentPlatformProvider = new DevelopmentPlatformProvider(l);
        try {
            final AppData a = AppData.a(l, idManager, c, n, developmentPlatformProvider);
            final Logger f3 = Logger.f();
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Installer package name is: ");
            sb3.append(a.c);
            f3.i(sb3.toString());
            final ExecutorService c2 = ExecutorUtils.c("com.google.firebase.crashlytics.startup");
            final SettingsController i = SettingsController.l(l, c, idManager, new HttpRequestFactory(), a.e, a.f, fileStore, dataCollectionArbiter);
            i.p(c2).l((Executor)c2, (Continuation)new Continuation<Void, Object>() {
                public Object then(final Task<Void> task) throws Exception {
                    if (!task.t()) {
                        Logger.f().e("Error fetching settings.", task.o());
                    }
                    return null;
                }
            });
            Tasks.c((Executor)c2, (Callable)new Callable<Void>(crashlyticsCore.o(a, i), crashlyticsCore, i) {
                final boolean a;
                final CrashlyticsCore b;
                final SettingsController c;
                
                public Void a() throws Exception {
                    if (this.a) {
                        this.b.g(this.c);
                    }
                    return null;
                }
                
                @Override
                public /* bridge */ Object call() throws Exception {
                    return this.a();
                }
            });
            return new FirebaseCrashlytics(crashlyticsCore);
        }
        catch (final PackageManager$NameNotFoundException ex) {
            Logger.f().e("Error retrieving app package info.", (Throwable)ex);
            return null;
        }
    }
    
    public void c(final String s) {
        this.a.k(s);
    }
    
    public void d(final Throwable t) {
        if (t == null) {
            Logger.f().k("A null value was passed to recordException. Ignoring.");
            return;
        }
        this.a.l(t);
    }
    
    public void e(final boolean b) {
        this.a.p(b);
    }
}
