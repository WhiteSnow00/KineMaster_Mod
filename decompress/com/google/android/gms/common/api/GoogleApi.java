// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.zact;
import android.os.Handler;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.Collection;
import java.util.Collections;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.lang.reflect.InvocationTargetException;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.app.Activity;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import android.os.Looper;
import com.google.android.gms.common.api.internal.ApiKey;
import android.content.Context;
import com.google.android.gms.common.api.internal.GoogleApiManager;

public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O>
{
    protected final GoogleApiManager zaa;
    private final Context zab;
    private final String zac;
    private final Api zad;
    private final Api.ApiOptions zae;
    private final ApiKey zaf;
    private final Looper zag;
    private final int zah;
    private final GoogleApiClient zai;
    private final StatusExceptionMapper zaj;
    
    @KeepForSdk
    public GoogleApi(final Activity activity, final Api<O> api, final O o, final Settings settings) {
        this((Context)activity, activity, api, o, settings);
    }
    
    @Deprecated
    @KeepForSdk
    public GoogleApi(final Activity activity, final Api<O> api, final O o, final StatusExceptionMapper statusExceptionMapper) {
        final Settings.Builder builder = new Settings.Builder();
        builder.c(statusExceptionMapper);
        builder.b(activity.getMainLooper());
        this(activity, (Api<Api.ApiOptions>)api, o, builder.a());
    }
    
    private GoogleApi(final Context context, final Activity activity, Api a, final Api.ApiOptions zae, final Settings settings) {
        Preconditions.l(context, "Null context is not permitted.");
        Preconditions.l((Api<O>)a, "Api must not be null.");
        Preconditions.l(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zab = context.getApplicationContext();
        final boolean l = PlatformVersion.l();
        String zac;
        final String s = zac = null;
        while (true) {
            if (!l) {
                break Label_0075;
            }
            try {
                zac = (String)Context.class.getMethod("getAttributionTag", (Class<?>[])new Class[0]).invoke(context, new Object[0]);
                this.zac = zac;
                this.zad = (Api)a;
                this.zae = zae;
                this.zag = settings.b;
                a = ApiKey.a((Api<Api.ApiOptions>)a, zae, zac);
                this.zaf = a;
                this.zai = new zabv(this);
                final GoogleApiManager y = GoogleApiManager.y(this.zab);
                this.zaa = y;
                this.zah = y.n();
                this.zaj = settings.a;
                if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
                    zaae.u(activity, y, a);
                }
                y.c(this);
            }
            catch (final NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
                zac = s;
                continue;
            }
            break;
        }
    }
    
    @Deprecated
    @KeepForSdk
    public GoogleApi(final Context context, final Api<O> api, final O o, final Looper looper, final StatusExceptionMapper statusExceptionMapper) {
        final Settings.Builder builder = new Settings.Builder();
        builder.b(looper);
        builder.c(statusExceptionMapper);
        this(context, (Api<Api.ApiOptions>)api, o, builder.a());
    }
    
    @KeepForSdk
    public GoogleApi(final Context context, final Api<O> api, final O o, final Settings settings) {
        this(context, null, api, o, settings);
    }
    
    @Deprecated
    @KeepForSdk
    public GoogleApi(final Context context, final Api<O> api, final O o, final StatusExceptionMapper statusExceptionMapper) {
        final Settings.Builder builder = new Settings.Builder();
        builder.c(statusExceptionMapper);
        this(context, (Api<Api.ApiOptions>)api, o, builder.a());
    }
    
    private final BaseImplementation.ApiMethodImpl zad(final int n, final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.m();
        this.zaa.H(this, n, apiMethodImpl);
        return apiMethodImpl;
    }
    
    private final Task zae(final int n, final TaskApiCall taskApiCall) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.I(this, n, taskApiCall, taskCompletionSource, this.zaj);
        return taskCompletionSource.a();
    }
    
    @KeepForSdk
    public GoogleApiClient asGoogleApiClient() {
        return this.zai;
    }
    
    @KeepForSdk
    protected ClientSettings.Builder createClientSettingsBuilder() {
        final ClientSettings.Builder builder = new ClientSettings.Builder();
        final Api.ApiOptions zae = this.zae;
        Account account = null;
        Label_0069: {
            if (zae instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) {
                final GoogleSignInAccount a1 = ((Api.ApiOptions.HasGoogleSignInAccountOptions)zae).a1();
                if (a1 != null) {
                    account = a1.k1();
                    break Label_0069;
                }
            }
            final Api.ApiOptions zae2 = this.zae;
            if (zae2 instanceof Api.ApiOptions.HasAccountOptions) {
                account = ((Api.ApiOptions.HasAccountOptions)zae2).k1();
            }
            else {
                account = null;
            }
        }
        builder.d(account);
        final Api.ApiOptions zae3 = this.zae;
        Object o;
        if (zae3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) {
            final GoogleSignInAccount a2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions)zae3).a1();
            if (a2 == null) {
                o = Collections.emptySet();
            }
            else {
                o = a2.R1();
            }
        }
        else {
            o = Collections.emptySet();
        }
        builder.c((Collection)o);
        builder.e(this.zab.getClass().getName());
        builder.b(this.zab.getPackageName());
        return builder;
    }
    
    @KeepForSdk
    protected Task<Boolean> disconnectService() {
        return (Task<Boolean>)this.zaa.A(this);
    }
    
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(final T t) {
        this.zad(2, t);
        return t;
    }
    
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(final TaskApiCall<A, TResult> taskApiCall) {
        return (Task<TResult>)this.zae(2, taskApiCall);
    }
    
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(final T t) {
        this.zad(0, t);
        return t;
    }
    
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(final TaskApiCall<A, TResult> taskApiCall) {
        return (Task<TResult>)this.zae(0, taskApiCall);
    }
    
    @Deprecated
    @KeepForSdk
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(final T t, final U u) {
        Preconditions.k(t);
        Preconditions.k(u);
        Preconditions.l(((RegisterListenerMethod<A, ?>)t).b(), "Listener has already been released.");
        Preconditions.l(((UnregisterListenerMethod<A, ?>)u).a(), "Listener has already been released.");
        Preconditions.b(Objects.b(t.b(), u.a()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return (Task<Void>)this.zaa.B(this, t, u, com.google.android.gms.common.api.zad.a);
    }
    
    @KeepForSdk
    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(final RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.k(registrationMethods);
        Preconditions.l(registrationMethods.a.b(), "Listener has already been released.");
        Preconditions.l(registrationMethods.b.a(), "Listener has already been released.");
        return (Task<Void>)this.zaa.B(this, registrationMethods.a, registrationMethods.b, registrationMethods.c);
    }
    
    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(final ListenerHolder.ListenerKey<?> listenerKey) {
        return this.doUnregisterEventListener(listenerKey, 0);
    }
    
    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(final ListenerHolder.ListenerKey<?> listenerKey, final int n) {
        Preconditions.l(listenerKey, "Listener key cannot be null.");
        return (Task<Boolean>)this.zaa.C(this, listenerKey, n);
    }
    
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(final T t) {
        this.zad(1, t);
        return t;
    }
    
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(final TaskApiCall<A, TResult> taskApiCall) {
        return (Task<TResult>)this.zae(1, taskApiCall);
    }
    
    @Override
    public final ApiKey<O> getApiKey() {
        return this.zaf;
    }
    
    @KeepForSdk
    public O getApiOptions() {
        return (O)this.zae;
    }
    
    @KeepForSdk
    public Context getApplicationContext() {
        return this.zab;
    }
    
    @KeepForSdk
    protected String getContextAttributionTag() {
        return this.zac;
    }
    
    @Deprecated
    @KeepForSdk
    protected String getContextFeatureId() {
        return this.zac;
    }
    
    @KeepForSdk
    public Looper getLooper() {
        return this.zag;
    }
    
    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(final L l, final String s) {
        return ListenerHolders.a(l, this.zag, s);
    }
    
    public final int zaa() {
        return this.zah;
    }
    
    public final Api.Client zab(final Looper looper, final zabq zabq) {
        final Api.Client c = Preconditions.k(this.zad.a()).c(this.zab, looper, this.createClientSettingsBuilder().a(), this.zae, zabq, zabq);
        final String contextAttributionTag = this.getContextAttributionTag();
        if (contextAttributionTag != null && c instanceof BaseGmsClient) {
            ((BaseGmsClient)c).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && c instanceof NonGmsServiceBrokerClient) {
            ((NonGmsServiceBrokerClient)c).f(contextAttributionTag);
        }
        return c;
    }
    
    public final zact zac(final Context context, final Handler handler) {
        return new zact(context, handler, this.createClientSettingsBuilder().a());
    }
    
    @KeepForSdk
    public static class Settings
    {
        @KeepForSdk
        public static final Settings c;
        public final StatusExceptionMapper a;
        public final Looper b;
        
        static {
            c = new Builder().a();
        }
        
        @KeepForSdk
        private Settings(final StatusExceptionMapper a, final Account account, final Looper b) {
            this.a = a;
            this.b = b;
        }
        
        Settings(final StatusExceptionMapper statusExceptionMapper, final Account account, final Looper looper, final zae zae) {
            this(statusExceptionMapper, null, looper);
        }
        
        @KeepForSdk
        public static class Builder
        {
            private StatusExceptionMapper a;
            private Looper b;
            
            @KeepForSdk
            public Builder() {
            }
            
            @KeepForSdk
            public Settings a() {
                if (this.a == null) {
                    this.a = new ApiExceptionMapper();
                }
                if (this.b == null) {
                    this.b = Looper.getMainLooper();
                }
                return new Settings(this.a, null, this.b, null);
            }
            
            @KeepForSdk
            @CanIgnoreReturnValue
            public Builder b(final Looper b) {
                Preconditions.l(b, "Looper must not be null.");
                this.b = b;
                return this;
            }
            
            @KeepForSdk
            @CanIgnoreReturnValue
            public Builder c(final StatusExceptionMapper a) {
                Preconditions.l(a, "StatusExceptionMapper must not be null.");
                this.a = a;
                return this;
            }
        }
    }
}
