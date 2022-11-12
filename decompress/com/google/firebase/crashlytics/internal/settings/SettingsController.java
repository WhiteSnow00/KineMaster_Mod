// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import com.google.android.gms.tasks.Task;
import android.content.SharedPreferences$Editor;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.Locale;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.common.IdManager;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicReference;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import android.content.Context;

public class SettingsController implements SettingsProvider
{
    private final Context a;
    private final d b;
    private final SettingsJsonParser c;
    private final CurrentTimeProvider d;
    private final CachedSettingsIo e;
    private final e f;
    private final DataCollectionArbiter g;
    private final AtomicReference<Settings> h;
    private final AtomicReference<TaskCompletionSource<Settings>> i;
    
    SettingsController(final Context a, final d b, final CurrentTimeProvider d, final SettingsJsonParser c, final CachedSettingsIo e, final e f, final DataCollectionArbiter g) {
        final AtomicReference h = new AtomicReference();
        this.h = h;
        this.i = new AtomicReference<TaskCompletionSource<Settings>>((TaskCompletionSource<Settings>)new TaskCompletionSource());
        this.a = a;
        this.b = b;
        this.d = d;
        this.c = c;
        this.e = e;
        this.f = f;
        this.g = g;
        h.set(com.google.firebase.crashlytics.internal.settings.a.b(d));
    }
    
    static d c(final SettingsController settingsController) {
        return settingsController.b;
    }
    
    static e d(final SettingsController settingsController) {
        return settingsController.f;
    }
    
    static SettingsJsonParser e(final SettingsController settingsController) {
        return settingsController.c;
    }
    
    static CachedSettingsIo f(final SettingsController settingsController) {
        return settingsController.e;
    }
    
    static void g(final SettingsController settingsController, final JSONObject jsonObject, final String s) throws JSONException {
        settingsController.q(jsonObject, s);
    }
    
    static boolean h(final SettingsController settingsController, final String s) {
        return settingsController.r(s);
    }
    
    static AtomicReference i(final SettingsController settingsController) {
        return settingsController.h;
    }
    
    static AtomicReference j(final SettingsController settingsController) {
        return settingsController.i;
    }
    
    public static SettingsController l(final Context context, final String s, final IdManager idManager, final HttpRequestFactory httpRequestFactory, final String s2, final String s3, final FileStore fileStore, final DataCollectionArbiter dataCollectionArbiter) {
        final String g = idManager.g();
        final SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        return new SettingsController(context, new d(s, idManager.h(), idManager.i(), idManager.j(), idManager, CommonUtils.h(CommonUtils.n(context), s, s3, s2), s3, s2, DeliveryMechanism.determineFrom(g).getId()), systemCurrentTimeProvider, new SettingsJsonParser(systemCurrentTimeProvider), new CachedSettingsIo(fileStore), new b(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", s), httpRequestFactory), dataCollectionArbiter);
    }
    
    private Settings m(final SettingsCacheBehavior settingsCacheBehavior) {
        final Settings settings = null;
        final Settings settings2 = null;
        Settings b = settings;
        Label_0156: {
            try {
                if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                    return b;
                }
                final JSONObject b2 = this.e.b();
                if (b2 != null) {
                    b = this.c.b(b2);
                    if (b != null) {
                        this.q(b2, "Loaded cached settings: ");
                        final long a = this.d.a();
                        if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior)) {
                            if (b.a(a)) {
                                Logger.f().i("Cached settings have expired.");
                                b = settings;
                                return b;
                            }
                        }
                        try {
                            Logger.f().i("Returning cached settings.");
                            return b;
                        }
                        catch (final Exception ex) {
                            break Label_0156;
                        }
                    }
                    Logger.f().e("Failed to parse cached settings data.", null);
                    b = settings;
                    return b;
                }
                Logger.f().b("No cached settings data found.");
                b = settings;
                return b;
            }
            catch (final Exception ex) {
                b = settings2;
            }
        }
        final Exception ex;
        Logger.f().e("Failed to get cached settings", ex);
        return b;
    }
    
    private String n() {
        return CommonUtils.r(this.a).getString("existing_instance_identifier", "");
    }
    
    private void q(final JSONObject jsonObject, final String s) throws JSONException {
        final Logger f = Logger.f();
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(jsonObject.toString());
        f.b(sb.toString());
    }
    
    private boolean r(final String s) {
        final SharedPreferences$Editor edit = CommonUtils.r(this.a).edit();
        edit.putString("existing_instance_identifier", s);
        edit.apply();
        return true;
    }
    
    @Override
    public Task<Settings> a() {
        return (Task<Settings>)this.i.get().a();
    }
    
    @Override
    public Settings b() {
        return this.h.get();
    }
    
    boolean k() {
        return this.n().equals(this.b.f) ^ true;
    }
    
    public Task<Void> o(final SettingsCacheBehavior settingsCacheBehavior, final Executor executor) {
        if (!this.k()) {
            final Settings m = this.m(settingsCacheBehavior);
            if (m != null) {
                this.h.set(m);
                this.i.get().e((Object)m);
                return (Task<Void>)Tasks.e((Object)null);
            }
        }
        final Settings i = this.m(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (i != null) {
            this.h.set(i);
            this.i.get().e((Object)i);
        }
        return (Task<Void>)this.g.j(executor).v(executor, (SuccessContinuation)new SuccessContinuation<Void, Void>(this) {
            final SettingsController a;
            
            public /* bridge */ Task a(final Object o) throws Exception {
                return this.b((Void)o);
            }
            
            public Task<Void> b(final Void void1) throws Exception {
                final JSONObject a = SettingsController.d(this.a).a(SettingsController.c(this.a), true);
                if (a != null) {
                    final Settings b = SettingsController.e(this.a).b(a);
                    SettingsController.f(this.a).c(b.c, a);
                    SettingsController.g(this.a, a, "Loaded settings: ");
                    final SettingsController a2 = this.a;
                    SettingsController.h(a2, SettingsController.c(a2).f);
                    SettingsController.i(this.a).set(b);
                    SettingsController.j(this.a).get().e((Object)b);
                }
                return (Task<Void>)Tasks.e((Object)null);
            }
        });
    }
    
    public Task<Void> p(final Executor executor) {
        return this.o(SettingsCacheBehavior.USE_CACHE, executor);
    }
}
