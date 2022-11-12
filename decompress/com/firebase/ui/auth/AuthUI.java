// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import com.firebase.ui.auth.util.data.PhoneNumberUtils;
import java.util.Locale;
import com.google.android.gms.common.api.Scope;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.credentials.CredentialRequestResponse;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Continuation;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.firebase.ui.auth.util.GoogleApiUtils;
import com.facebook.login.LoginManager;
import com.google.android.gms.tasks.Task;
import com.firebase.ui.auth.util.Preconditions;
import com.firebase.ui.auth.util.data.ProviderAvailability;
import java.util.Iterator;
import com.firebase.ui.auth.util.CredentialUtils;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.google.firebase.auth.UserInfo;
import java.util.ArrayList;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.Credential;
import java.util.List;
import com.google.firebase.auth.FirebaseUser;
import android.content.Intent;
import android.util.Log;
import java.util.Collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import com.google.firebase.auth.FirebaseAuth;
import android.content.Context;
import java.util.Set;
import com.google.firebase.FirebaseApp;
import java.util.IdentityHashMap;

public final class AuthUI
{
    public static final String ANONYMOUS_PROVIDER = "anonymous";
    public static final String APPLE_PROVIDER = "apple.com";
    public static final String EMAIL_LINK_PROVIDER = "emailLink";
    private static final IdentityHashMap<FirebaseApp, AuthUI> INSTANCES;
    public static final String MICROSOFT_PROVIDER = "microsoft.com";
    public static final int NO_LOGO = -1;
    public static final Set<String> SOCIAL_PROVIDERS;
    public static final Set<String> SUPPORTED_OAUTH_PROVIDERS;
    public static final Set<String> SUPPORTED_PROVIDERS;
    public static final String TAG = "AuthUI";
    public static final String UNCONFIGURED_CONFIG_VALUE = "CHANGE-ME";
    public static final String YAHOO_PROVIDER = "yahoo.com";
    private static Context sApplicationContext;
    private final FirebaseApp mApp;
    private final FirebaseAuth mAuth;
    private String mEmulatorHost;
    private int mEmulatorPort;
    
    static {
        SUPPORTED_PROVIDERS = Collections.unmodifiableSet((Set<? extends String>)new HashSet<String>(Arrays.asList("google.com", "facebook.com", "twitter.com", "github.com", "password", "phone", "anonymous", "emailLink")));
        SUPPORTED_OAUTH_PROVIDERS = Collections.unmodifiableSet((Set<? extends String>)new HashSet<String>(Arrays.asList("microsoft.com", "yahoo.com", "apple.com", "twitter.com", "github.com")));
        SOCIAL_PROVIDERS = Collections.unmodifiableSet((Set<? extends String>)new HashSet<String>(Arrays.asList("google.com", "facebook.com")));
        INSTANCES = new IdentityHashMap<FirebaseApp, AuthUI>();
    }
    
    private AuthUI(final FirebaseApp mApp) {
        this.mEmulatorHost = null;
        this.mEmulatorPort = -1;
        this.mApp = mApp;
        final FirebaseAuth instance = FirebaseAuth.getInstance(mApp);
        this.mAuth = instance;
        try {
            instance.q("7.2.0");
        }
        catch (final Exception ex) {
            Log.e("AuthUI", "Couldn't set the FUI version.", (Throwable)ex);
        }
        this.mAuth.x();
    }
    
    static FirebaseAuth access$000(final AuthUI authUI) {
        return authUI.mAuth;
    }
    
    static FirebaseApp access$500(final AuthUI authUI) {
        return authUI.mApp;
    }
    
    public static boolean canHandleIntent(final Intent intent) {
        return intent != null && intent.getData() != null && FirebaseAuth.getInstance().m(intent.getData().toString());
    }
    
    public static Context getApplicationContext() {
        return AuthUI.sApplicationContext;
    }
    
    private static List<Credential> getCredentialsFromFirebaseUser(final FirebaseUser firebaseUser) {
        if (TextUtils.isEmpty((CharSequence)firebaseUser.M1()) && TextUtils.isEmpty((CharSequence)firebaseUser.O1())) {
            return Collections.emptyList();
        }
        final ArrayList list = new ArrayList();
        for (final UserInfo userInfo : firebaseUser.Q1()) {
            if ("firebase".equals(userInfo.e())) {
                continue;
            }
            final String providerIdToAccountType = ProviderUtils.providerIdToAccountType(userInfo.e());
            if (providerIdToAccountType == null) {
                list.add(CredentialUtils.buildCredentialOrThrow(firebaseUser, "pass", null));
            }
            else {
                list.add(CredentialUtils.buildCredentialOrThrow(firebaseUser, null, providerIdToAccountType));
            }
        }
        return list;
    }
    
    public static int getDefaultTheme() {
        return R.style.FirebaseUI;
    }
    
    public static AuthUI getInstance() {
        return getInstance(FirebaseApp.m());
    }
    
    public static AuthUI getInstance(final FirebaseApp firebaseApp) {
        if (ProviderAvailability.IS_TWITTER_AVAILABLE) {
            Log.w("AuthUI", String.format("Beginning with FirebaseUI 6.2.0 you no longer need to include %s to sign in with %s. Go to %s for more information", "the TwitterKit SDK", "Twitter", "https://github.com/firebase/FirebaseUI-Android/releases/tag/6.2.0"));
        }
        if (ProviderAvailability.IS_GITHUB_AVAILABLE) {
            Log.w("AuthUI", String.format("Beginning with FirebaseUI 6.2.0 you no longer need to include %s to sign in with %s. Go to %s for more information", "com.firebaseui:firebase-ui-auth-github", "GitHub", "https://github.com/firebase/FirebaseUI-Android/releases/tag/6.2.0"));
        }
        final IdentityHashMap<FirebaseApp, AuthUI> instances = AuthUI.INSTANCES;
        synchronized (instances) {
            AuthUI authUI;
            if ((authUI = instances.get(firebaseApp)) == null) {
                authUI = new AuthUI(firebaseApp);
                instances.put(firebaseApp, authUI);
            }
            return authUI;
        }
    }
    
    public static AuthUI getInstance(final String s) {
        return getInstance(FirebaseApp.n(s));
    }
    
    public static void setApplicationContext(final Context context) {
        AuthUI.sApplicationContext = Preconditions.checkNotNull(context, "App context cannot be null.", new Object[0]).getApplicationContext();
    }
    
    private Task<Void> signOutIdps(final Context context) {
        if (ProviderAvailability.IS_FACEBOOK_AVAILABLE) {
            LoginManager.getInstance().logOut();
        }
        if (GoogleApiUtils.isPlayServicesAvailable(context)) {
            return GoogleSignIn.b(context, GoogleSignInOptions.w).signOut();
        }
        return (Task<Void>)Tasks.e((Object)null);
    }
    
    public SignInIntentBuilder createSignInIntentBuilder() {
        return new SignInIntentBuilder(null);
    }
    
    public Task<Void> delete(final Context context) {
        final FirebaseUser h = this.mAuth.h();
        if (h == null) {
            return (Task<Void>)Tasks.d((Exception)new FirebaseAuthInvalidUserException(String.valueOf(4), "No currently signed in user."));
        }
        return (Task<Void>)this.signOutIdps(context).m((Continuation)new Continuation<Void, Task<Void>>(this, context, getCredentialsFromFirebaseUser(h)) {
            final AuthUI this$0;
            final Context val$context;
            final List val$credentials;
            
            public Task<Void> then(final Task<Void> task) {
                task.p();
                if (!GoogleApiUtils.isPlayServicesAvailable(this.val$context)) {
                    Log.w("AuthUI", "Google Play services not available during delete");
                    return (Task<Void>)Tasks.e((Object)null);
                }
                final CredentialsClient credentialsClient = GoogleApiUtils.getCredentialsClient(this.val$context);
                final ArrayList list = new ArrayList();
                final Iterator iterator = this.val$credentials.iterator();
                while (iterator.hasNext()) {
                    list.add(credentialsClient.b((Credential)iterator.next()));
                }
                return (Task<Void>)Tasks.f((Collection)list).k((Continuation)new Continuation<Void, Void>(this) {
                    final AuthUI$5 this$1;
                    
                    public /* bridge */ Object then(final Task task) throws Exception {
                        return this.then((Task<Void>)task);
                    }
                    
                    public Void then(final Task<Void> task) {
                        final Exception o = task.o();
                        Throwable cause;
                        if (o == null) {
                            cause = null;
                        }
                        else {
                            cause = o.getCause();
                        }
                        if (cause instanceof ApiException && ((ApiException)cause).getStatusCode() == 16) {
                            return null;
                        }
                        return (Void)task.p();
                    }
                });
            }
            
            public /* bridge */ Object then(final Task task) throws Exception {
                return this.then((Task<Void>)task);
            }
        }).m((Continuation)new Continuation<Void, Task<Void>>(this, h) {
            final AuthUI this$0;
            final FirebaseUser val$currentUser;
            
            public Task<Void> then(final Task<Void> task) {
                task.p();
                return this.val$currentUser.K1();
            }
            
            public /* bridge */ Object then(final Task task) throws Exception {
                return this.then((Task<Void>)task);
            }
        });
    }
    
    public FirebaseApp getApp() {
        return this.mApp;
    }
    
    public FirebaseAuth getAuth() {
        return this.mAuth;
    }
    
    public String getEmulatorHost() {
        return this.mEmulatorHost;
    }
    
    public int getEmulatorPort() {
        return this.mEmulatorPort;
    }
    
    public boolean isUseEmulator() {
        return this.mEmulatorHost != null && this.mEmulatorPort >= 0;
    }
    
    public Task<Void> signOut(final Context context) {
        final boolean playServicesAvailable = GoogleApiUtils.isPlayServicesAvailable(context);
        if (!playServicesAvailable) {
            Log.w("AuthUI", "Google Play services not available during signOut");
        }
        Task task;
        if (playServicesAvailable) {
            task = GoogleApiUtils.getCredentialsClient(context).c();
        }
        else {
            task = Tasks.e((Object)null);
        }
        task.k((Continuation)new Continuation<Void, Void>(this) {
            final AuthUI this$0;
            
            public /* bridge */ Object then(final Task task) throws Exception {
                return this.then((Task<Void>)task);
            }
            
            public Void then(final Task<Void> task) {
                final Exception o = task.o();
                if (o instanceof ApiException && ((ApiException)o).getStatusCode() == 16) {
                    Log.w("AuthUI", "Could not disable auto-sign in, maybe there are no SmartLock accounts available?", (Throwable)o);
                    return null;
                }
                return (Void)task.p();
            }
        });
        return (Task<Void>)Tasks.g(new Task[] { this.signOutIdps(context), task }).k((Continuation)new Continuation<Void, Void>(this) {
            final AuthUI this$0;
            
            public /* bridge */ Object then(final Task task) throws Exception {
                return this.then((Task<Void>)task);
            }
            
            public Void then(final Task<Void> task) {
                task.p();
                AuthUI.access$000(this.this$0).v();
                return null;
            }
        });
    }
    
    public Task<AuthResult> silentSignIn(final Context context, final List<IdpConfig> list) {
        if (this.mAuth.h() != null) {
            throw new IllegalArgumentException("User already signed in!");
        }
        final Context applicationContext = context.getApplicationContext();
        final IdpConfig configFromIdps = ProviderUtils.getConfigFromIdps(list, "google.com");
        final IdpConfig configFromIdps2 = ProviderUtils.getConfigFromIdps(list, "password");
        if (configFromIdps == null && configFromIdps2 == null) {
            throw new IllegalArgumentException("No supported providers were supplied. Add either Google or email support.");
        }
        final String s = null;
        GoogleSignInOptions googleSignInOptions;
        if (configFromIdps == null) {
            googleSignInOptions = null;
        }
        else {
            final GoogleSignInAccount c = GoogleSignIn.c(applicationContext);
            if (c != null && c.P1() != null) {
                return this.mAuth.t(GoogleAuthProvider.a(c.P1(), null));
            }
            googleSignInOptions = (GoogleSignInOptions)configFromIdps.getParams().getParcelable("extra_google_sign_in_options");
        }
        if (!GoogleApiUtils.isPlayServicesAvailable(context)) {
            return (Task<AuthResult>)Tasks.d((Exception)new FirebaseUiException(2));
        }
        final CredentialsClient credentialsClient = GoogleApiUtils.getCredentialsClient(context);
        final CredentialRequest.Builder c2 = new CredentialRequest.Builder().c(configFromIdps2 != null);
        String providerIdToAccountType;
        if (configFromIdps == null) {
            providerIdToAccountType = s;
        }
        else {
            providerIdToAccountType = ProviderUtils.providerIdToAccountType("google.com");
        }
        return (Task<AuthResult>)credentialsClient.e(c2.b(providerIdToAccountType).a()).m((Continuation)new Continuation<CredentialRequestResponse, Task<AuthResult>>(this, applicationContext, googleSignInOptions) {
            final AuthUI this$0;
            final Context val$appContext;
            final GoogleSignInOptions val$googleOptions;
            
            public Task<AuthResult> then(final Task<CredentialRequestResponse> task) {
                final Credential k = ((CredentialRequestResponse)task.p()).k();
                final String n1 = k.N1();
                final String q1 = k.Q1();
                if (TextUtils.isEmpty((CharSequence)q1)) {
                    return (Task<AuthResult>)GoogleSignIn.b(this.val$appContext, new GoogleSignInOptions.Builder(this.val$googleOptions).g(n1).a()).d().m((Continuation)new Continuation<GoogleSignInAccount, Task<AuthResult>>(this) {
                        final AuthUI$1 this$1;
                        
                        public Task<AuthResult> then(final Task<GoogleSignInAccount> task) {
                            return AuthUI.access$000(this.this$1.this$0).t(GoogleAuthProvider.a(((GoogleSignInAccount)task.p()).P1(), null));
                        }
                        
                        public /* bridge */ Object then(final Task task) throws Exception {
                            return this.then((Task<GoogleSignInAccount>)task);
                        }
                    });
                }
                return AuthUI.access$000(this.this$0).u(n1, q1);
            }
            
            public /* bridge */ Object then(final Task task) throws Exception {
                return this.then((Task<CredentialRequestResponse>)task);
            }
        });
    }
    
    public void useEmulator(final String mEmulatorHost, final int mEmulatorPort) {
        final boolean b = true;
        Preconditions.checkArgument(mEmulatorPort >= 0, "Port must be >= 0");
        Preconditions.checkArgument(mEmulatorPort <= 65535 && b, "Port must be <= 65535");
        this.mEmulatorHost = mEmulatorHost;
        this.mEmulatorPort = mEmulatorPort;
        this.mAuth.y(mEmulatorHost, mEmulatorPort);
    }
    
    private abstract class AuthIntentBuilder<T extends AuthIntentBuilder>
    {
        boolean mAlwaysShowProviderChoice;
        AuthMethodPickerLayout mAuthMethodPickerLayout;
        IdpConfig mDefaultProvider;
        boolean mEnableCredentials;
        boolean mEnableHints;
        boolean mLockOrientation;
        int mLogo;
        ActionCodeSettings mPasswordSettings;
        String mPrivacyPolicyUrl;
        final List<IdpConfig> mProviders;
        int mTheme;
        String mTosUrl;
        final AuthUI this$0;
        
        private AuthIntentBuilder(final AuthUI this$0) {
            this.this$0 = this$0;
            this.mProviders = new ArrayList<IdpConfig>();
            this.mDefaultProvider = null;
            this.mLogo = -1;
            this.mTheme = AuthUI.getDefaultTheme();
            this.mAlwaysShowProviderChoice = false;
            this.mLockOrientation = false;
            this.mEnableCredentials = true;
            this.mEnableHints = true;
            this.mAuthMethodPickerLayout = null;
            this.mPasswordSettings = null;
        }
        
        AuthIntentBuilder(final AuthUI authUI, final AuthUI$1 continuation) {
            this(authUI);
        }
        
        public Intent build() {
            if (this.mProviders.isEmpty()) {
                this.mProviders.add(new IdpConfig.EmailBuilder().build());
            }
            return KickoffActivity.createIntent(AuthUI.access$500(this.this$0).l(), this.getFlowParams());
        }
        
        protected abstract FlowParameters getFlowParams();
        
        public T setAlwaysShowSignInMethodScreen(final boolean mAlwaysShowProviderChoice) {
            if (mAlwaysShowProviderChoice && this.mDefaultProvider != null) {
                throw new IllegalStateException("Can't show provider choice with a default provider.");
            }
            this.mAlwaysShowProviderChoice = mAlwaysShowProviderChoice;
            return (T)this;
        }
        
        public T setAuthMethodPickerLayout(final AuthMethodPickerLayout mAuthMethodPickerLayout) {
            this.mAuthMethodPickerLayout = mAuthMethodPickerLayout;
            return (T)this;
        }
        
        public T setAvailableProviders(final List<IdpConfig> list) {
            Preconditions.checkNotNull(list, "idpConfigs cannot be null", new Object[0]);
            if (list.size() == 1 && ((IdpConfig)list.get(0)).getProviderId().equals("anonymous")) {
                throw new IllegalStateException("Sign in as guest cannot be the only sign in method. In this case, sign the user in anonymously your self; no UI is needed.");
            }
            this.mProviders.clear();
            for (final IdpConfig idpConfig : list) {
                if (this.mProviders.contains(idpConfig)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Each provider can only be set once. ");
                    sb.append(idpConfig.getProviderId());
                    sb.append(" was set twice.");
                    throw new IllegalArgumentException(sb.toString());
                }
                this.mProviders.add(idpConfig);
            }
            return (T)this;
        }
        
        public T setDefaultProvider(final IdpConfig mDefaultProvider) {
            if (mDefaultProvider != null) {
                if (!this.mProviders.contains(mDefaultProvider)) {
                    throw new IllegalStateException("Default provider not in available providers list.");
                }
                if (this.mAlwaysShowProviderChoice) {
                    throw new IllegalStateException("Can't set default provider and always show provider choice.");
                }
            }
            this.mDefaultProvider = mDefaultProvider;
            return (T)this;
        }
        
        public T setIsSmartLockEnabled(final boolean b) {
            return this.setIsSmartLockEnabled(b, b);
        }
        
        public T setIsSmartLockEnabled(final boolean mEnableCredentials, final boolean mEnableHints) {
            this.mEnableCredentials = mEnableCredentials;
            this.mEnableHints = mEnableHints;
            return (T)this;
        }
        
        public T setLockOrientation(final boolean mLockOrientation) {
            this.mLockOrientation = mLockOrientation;
            return (T)this;
        }
        
        public T setLogo(final int mLogo) {
            this.mLogo = mLogo;
            return (T)this;
        }
        
        @Deprecated
        public T setPrivacyPolicyUrl(final String mPrivacyPolicyUrl) {
            this.mPrivacyPolicyUrl = mPrivacyPolicyUrl;
            return (T)this;
        }
        
        public T setResetPasswordSettings(final ActionCodeSettings mPasswordSettings) {
            this.mPasswordSettings = mPasswordSettings;
            return (T)this;
        }
        
        public T setTheme(final int n) {
            this.mTheme = Preconditions.checkValidStyle(AuthUI.access$500(this.this$0).l(), n, "theme identifier is unknown or not a style definition", new Object[0]);
            return (T)this;
        }
        
        public T setTosAndPrivacyPolicyUrls(final String mTosUrl, final String mPrivacyPolicyUrl) {
            Preconditions.checkNotNull(mTosUrl, "tosUrl cannot be null", new Object[0]);
            Preconditions.checkNotNull(mPrivacyPolicyUrl, "privacyPolicyUrl cannot be null", new Object[0]);
            this.mTosUrl = mTosUrl;
            this.mPrivacyPolicyUrl = mPrivacyPolicyUrl;
            return (T)this;
        }
        
        @Deprecated
        public T setTosUrl(final String mTosUrl) {
            this.mTosUrl = mTosUrl;
            return (T)this;
        }
    }
    
    public static final class IdpConfig implements Parcelable
    {
        public static final Parcelable$Creator<IdpConfig> CREATOR;
        private final Bundle mParams;
        private final String mProviderId;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<IdpConfig>() {
                public IdpConfig createFromParcel(final Parcel parcel) {
                    return new IdpConfig(parcel, null);
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.createFromParcel(parcel);
                }
                
                public IdpConfig[] newArray(final int n) {
                    return new IdpConfig[n];
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.newArray(n);
                }
            };
        }
        
        private IdpConfig(final Parcel parcel) {
            this.mProviderId = parcel.readString();
            this.mParams = parcel.readBundle(IdpConfig.class.getClassLoader());
        }
        
        IdpConfig(final Parcel parcel, final AuthUI$1 continuation) {
            this(parcel);
        }
        
        private IdpConfig(final String mProviderId, final Bundle bundle) {
            this.mProviderId = mProviderId;
            this.mParams = new Bundle(bundle);
        }
        
        IdpConfig(final String s, final Bundle bundle, final AuthUI$1 continuation) {
            this(s, bundle);
        }
        
        public int describeContents() {
            return 0;
        }
        
        @Override
        public final boolean equals(final Object o) {
            return this == o || (o != null && IdpConfig.class == o.getClass() && this.mProviderId.equals(((IdpConfig)o).mProviderId));
        }
        
        public Bundle getParams() {
            return new Bundle(this.mParams);
        }
        
        public String getProviderId() {
            return this.mProviderId;
        }
        
        @Override
        public final int hashCode() {
            return this.mProviderId.hashCode();
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("IdpConfig{mProviderId='");
            sb.append(this.mProviderId);
            sb.append('\'');
            sb.append(", mParams=");
            sb.append(this.mParams);
            sb.append('}');
            return sb.toString();
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeString(this.mProviderId);
            parcel.writeBundle(this.mParams);
        }
        
        public static final class AnonymousBuilder extends Builder
        {
            public AnonymousBuilder() {
                super("anonymous");
            }
        }
        
        public static final class AppleBuilder extends GenericOAuthProviderBuilder
        {
            private static final String PROVIDER_NAME = "Apple";
            
            public AppleBuilder() {
                super("apple.com", "Apple", R.layout.fui_idp_button_apple);
            }
        }
        
        public static class Builder
        {
            private final Bundle mParams;
            private String mProviderId;
            
            protected Builder(final String mProviderId) {
                this.mParams = new Bundle();
                if (!AuthUI.SUPPORTED_PROVIDERS.contains(mProviderId) && !AuthUI.SUPPORTED_OAUTH_PROVIDERS.contains(mProviderId)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown provider: ");
                    sb.append(mProviderId);
                    throw new IllegalArgumentException(sb.toString());
                }
                this.mProviderId = mProviderId;
            }
            
            static String access$400(final Builder builder) {
                return builder.mProviderId;
            }
            
            public IdpConfig build() {
                return new IdpConfig(this.mProviderId, this.mParams, null);
            }
            
            protected final Bundle getParams() {
                return this.mParams;
            }
            
            protected void setProviderId(final String mProviderId) {
                this.mProviderId = mProviderId;
            }
        }
        
        public static final class EmailBuilder extends Builder
        {
            public EmailBuilder() {
                super("password");
            }
            
            @Override
            public IdpConfig build() {
                if (Builder.access$400((Builder)this).equals("emailLink")) {
                    final ActionCodeSettings actionCodeSettings = (ActionCodeSettings)((Builder)this).getParams().getParcelable("action_code_settings");
                    Preconditions.checkNotNull(actionCodeSettings, "ActionCodeSettings cannot be null when using email link sign in.", new Object[0]);
                    if (!actionCodeSettings.K1()) {
                        throw new IllegalStateException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
                    }
                }
                return super.build();
            }
            
            public EmailBuilder enableEmailLinkSignIn() {
                ((Builder)this).setProviderId("emailLink");
                return this;
            }
            
            public EmailBuilder setActionCodeSettings(final ActionCodeSettings actionCodeSettings) {
                ((Builder)this).getParams().putParcelable("action_code_settings", (Parcelable)actionCodeSettings);
                return this;
            }
            
            public EmailBuilder setAllowNewAccounts(final boolean b) {
                ((Builder)this).getParams().putBoolean("extra_allow_new_emails", b);
                return this;
            }
            
            public EmailBuilder setDefaultEmail(final String s) {
                ((Builder)this).getParams().putString("extra_default_email", s);
                return this;
            }
            
            public EmailBuilder setForceSameDevice() {
                ((Builder)this).getParams().putBoolean("force_same_device", true);
                return this;
            }
            
            public EmailBuilder setRequireName(final boolean b) {
                ((Builder)this).getParams().putBoolean("extra_require_name", b);
                return this;
            }
        }
        
        public static final class FacebookBuilder extends Builder
        {
            private static final String TAG = "FacebookBuilder";
            
            public FacebookBuilder() {
                super("facebook.com");
                if (ProviderAvailability.IS_FACEBOOK_AVAILABLE) {
                    Preconditions.checkConfigured(AuthUI.getApplicationContext(), "Facebook provider unconfigured. Make sure to add a `facebook_application_id` string. See the docs for more info: https://github.com/firebase/FirebaseUI-Android/blob/master/auth/README.md#facebook", R.string.facebook_application_id);
                    if (AuthUI.getApplicationContext().getString(R.string.facebook_login_protocol_scheme).equals("fbYOUR_APP_ID")) {
                        Log.w("FacebookBuilder", "Facebook provider unconfigured for Chrome Custom Tabs.");
                    }
                    return;
                }
                throw new RuntimeException("Facebook provider cannot be configured without dependency. Did you forget to add 'com.facebook.android:facebook-login:VERSION' dependency?");
            }
            
            public FacebookBuilder setPermissions(final List<String> list) {
                ((Builder)this).getParams().putStringArrayList("extra_facebook_permissions", new ArrayList((Collection<? extends E>)list));
                return this;
            }
        }
        
        public static class GenericOAuthProviderBuilder extends Builder
        {
            public GenericOAuthProviderBuilder(final String s, final String s2, final int n) {
                super(s);
                Preconditions.checkNotNull(s, "The provider ID cannot be null.", new Object[0]);
                Preconditions.checkNotNull(s2, "The provider name cannot be null.", new Object[0]);
                ((Builder)this).getParams().putString("generic_oauth_provider_id", s);
                ((Builder)this).getParams().putString("generic_oauth_provider_name", s2);
                ((Builder)this).getParams().putInt("generic_oauth_button_id", n);
            }
            
            public GenericOAuthProviderBuilder setCustomParameters(final Map<String, String> map) {
                ((Builder)this).getParams().putSerializable("generic_oauth_custom_parameters", (Serializable)new HashMap<Object, Object>(map));
                return this;
            }
            
            public GenericOAuthProviderBuilder setScopes(final List<String> list) {
                ((Builder)this).getParams().putStringArrayList("generic_oauth_scopes", new ArrayList((Collection<? extends E>)list));
                return this;
            }
        }
        
        public static final class GitHubBuilder extends GenericOAuthProviderBuilder
        {
            private static final String PROVIDER_NAME = "Github";
            
            public GitHubBuilder() {
                super("github.com", "Github", R.layout.fui_idp_button_github);
            }
            
            @Deprecated
            public GitHubBuilder setPermissions(final List<String> scopes) {
                ((GenericOAuthProviderBuilder)this).setScopes(scopes);
                return this;
            }
        }
        
        public static final class GoogleBuilder extends Builder
        {
            public GoogleBuilder() {
                super("google.com");
            }
            
            private void validateWebClientId() {
                Preconditions.checkConfigured(AuthUI.getApplicationContext(), "Check your google-services plugin configuration, the default_web_client_id string wasn't populated.", R.string.default_web_client_id);
            }
            
            @Override
            public IdpConfig build() {
                if (!((Builder)this).getParams().containsKey("extra_google_sign_in_options")) {
                    this.validateWebClientId();
                    this.setScopes(Collections.emptyList());
                }
                return super.build();
            }
            
            public GoogleBuilder setScopes(final List<String> list) {
                final GoogleSignInOptions.Builder b = new GoogleSignInOptions.Builder(GoogleSignInOptions.w).b();
                final Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()) {
                    b.f(new Scope(iterator.next()), new Scope[0]);
                }
                return this.setSignInOptions(b.a());
            }
            
            public GoogleBuilder setSignInOptions(final GoogleSignInOptions googleSignInOptions) {
                Preconditions.checkUnset(((Builder)this).getParams(), "Cannot overwrite previously set sign-in options.", "extra_google_sign_in_options");
                final GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(googleSignInOptions);
                String s;
                if ((s = googleSignInOptions.N1()) == null) {
                    this.validateWebClientId();
                    s = AuthUI.getApplicationContext().getString(R.string.default_web_client_id);
                }
                final int n = 0;
                final Iterator<Scope> iterator = googleSignInOptions.M1().iterator();
                while (true) {
                    do {
                        final int n2 = n;
                        if (iterator.hasNext()) {
                            continue;
                        }
                        if (n2 == 0) {
                            Log.w("AuthUI", "The GoogleSignInOptions passed to setSignInOptions does not request the 'email' scope. In most cases this is a mistake! Call requestEmail() on the GoogleSignInOptions object.");
                        }
                        builder.d(s);
                        ((Builder)this).getParams().putParcelable("extra_google_sign_in_options", (Parcelable)builder.a());
                        return this;
                    } while (!"email".equals(iterator.next().K1()));
                    final int n2 = 1;
                    continue;
                }
            }
        }
        
        public static final class MicrosoftBuilder extends GenericOAuthProviderBuilder
        {
            private static final String PROVIDER_NAME = "Microsoft";
            
            public MicrosoftBuilder() {
                super("microsoft.com", "Microsoft", R.layout.fui_idp_button_microsoft);
            }
        }
        
        public static final class PhoneBuilder extends Builder
        {
            public PhoneBuilder() {
                super("phone");
            }
            
            private void addCountriesToBundle(final List<String> list, final String s) {
                final ArrayList list2 = new ArrayList();
                final Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()) {
                    list2.add(iterator.next().toUpperCase(Locale.getDefault()));
                }
                ((Builder)this).getParams().putStringArrayList(s, list2);
            }
            
            private boolean containsCountryIso(final List<String> list, String upperCase) {
                upperCase = upperCase.toUpperCase(Locale.getDefault());
                for (final String s : list) {
                    if (PhoneNumberUtils.isValidIso(s)) {
                        if (s.equals(upperCase)) {
                            return true;
                        }
                        continue;
                    }
                    else {
                        if (PhoneNumberUtils.getCountryIsosFromCountryCode(s).contains(upperCase)) {
                            return true;
                        }
                        continue;
                    }
                }
                return false;
            }
            
            private String getDefaultIso() {
                String string;
                if (((Builder)this).getParams().containsKey("extra_country_iso")) {
                    string = ((Builder)this).getParams().getString("extra_country_iso");
                }
                else {
                    string = null;
                }
                return string;
            }
            
            private List<String> getPhoneIsosFromCode() {
                final ArrayList list = new ArrayList();
                final String string = ((Builder)this).getParams().getString("extra_phone_number");
                if (string != null && string.startsWith("+")) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("+");
                    sb.append(PhoneNumberUtils.getPhoneNumber(string).getCountryCode());
                    final List<String> countryIsosFromCountryCode = PhoneNumberUtils.getCountryIsosFromCountryCode(sb.toString());
                    if (countryIsosFromCountryCode != null) {
                        list.addAll(countryIsosFromCountryCode);
                    }
                }
                return list;
            }
            
            private boolean isValidDefaultIso(final List<String> list, final String s, final boolean b) {
                final boolean b2 = true;
                if (s == null) {
                    return true;
                }
                final boolean containsCountryIso = this.containsCountryIso(list, s);
                if (containsCountryIso) {
                    final boolean b3 = b2;
                    if (b) {
                        return b3;
                    }
                }
                return !containsCountryIso && !b && b2;
            }
            
            private void validateCountryInput(final List<String> list) {
                for (final String s : list) {
                    if (!PhoneNumberUtils.isValidIso(s)) {
                        if (PhoneNumberUtils.isValid(s)) {
                            continue;
                        }
                        throw new IllegalArgumentException("Invalid input: You must provide a valid country iso (alpha-2) or code (e-164). e.g. 'us' or '+1'.");
                    }
                }
            }
            
            private void validateDefaultCountryInput(final List<String> list, final boolean b) {
                if ((!((Builder)this).getParams().containsKey("extra_country_iso") && !((Builder)this).getParams().containsKey("extra_phone_number")) || (this.validateDefaultCountryIso(list, b) && this.validateDefaultPhoneIsos(list, b))) {
                    return;
                }
                throw new IllegalArgumentException("Invalid default country iso. Make sure it is either part of the allowed list or that you haven't blocked it.");
            }
            
            private boolean validateDefaultCountryIso(final List<String> list, final boolean b) {
                return this.isValidDefaultIso(list, this.getDefaultIso(), b);
            }
            
            private boolean validateDefaultPhoneIsos(final List<String> list, final boolean b) {
                final List<String> phoneIsosFromCode = this.getPhoneIsosFromCode();
                final Iterator iterator = phoneIsosFromCode.iterator();
                while (iterator.hasNext()) {
                    if (this.isValidDefaultIso(list, (String)iterator.next(), b)) {
                        return true;
                    }
                }
                return phoneIsosFromCode.isEmpty();
            }
            
            private void validateInputs() {
                final ArrayList stringArrayList = ((Builder)this).getParams().getStringArrayList("allowlisted_countries");
                final ArrayList stringArrayList2 = ((Builder)this).getParams().getStringArrayList("blocklisted_countries");
                if (stringArrayList != null && stringArrayList2 != null) {
                    throw new IllegalStateException("You can either allowlist or blocked country codes for phone authentication.");
                }
                if (stringArrayList != null) {
                    this.validateInputs(stringArrayList, true);
                }
                else if (stringArrayList2 != null) {
                    this.validateInputs(stringArrayList2, false);
                }
            }
            
            private void validateInputs(final List<String> list, final boolean b) {
                this.validateCountryInput(list);
                this.validateDefaultCountryInput(list, b);
            }
            
            @Override
            public IdpConfig build() {
                this.validateInputs();
                return super.build();
            }
            
            public PhoneBuilder setBlacklistedCountries(final List<String> list) {
                if (!((Builder)this).getParams().containsKey("allowlisted_countries")) {
                    Preconditions.checkNotNull(list, String.format("Invalid argument: Only non-%s blocklists are valid. To specify no blacklist, do not call this method.", "null"), new Object[0]);
                    Preconditions.checkArgument(list.isEmpty() ^ true, String.format("Invalid argument: Only non-%s blocklists are valid. To specify no blacklist, do not call this method.", "empty"));
                    this.addCountriesToBundle(list, "blocklisted_countries");
                    return this;
                }
                throw new IllegalStateException("You can either allowlist or blocklist country codes for phone authentication.");
            }
            
            public PhoneBuilder setDefaultCountryIso(final String s) {
                Preconditions.checkUnset(((Builder)this).getParams(), "Cannot overwrite previously set phone number", "extra_phone_number", "extra_country_iso", "extra_national_number");
                if (PhoneNumberUtils.isValidIso(s)) {
                    ((Builder)this).getParams().putString("extra_country_iso", s.toUpperCase(Locale.getDefault()));
                    return this;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid country iso: ");
                sb.append(s);
                throw new IllegalStateException(sb.toString());
            }
            
            public PhoneBuilder setDefaultNumber(final String s) {
                Preconditions.checkUnset(((Builder)this).getParams(), "Cannot overwrite previously set phone number", "extra_phone_number", "extra_country_iso", "extra_national_number");
                if (PhoneNumberUtils.isValid(s)) {
                    ((Builder)this).getParams().putString("extra_phone_number", s);
                    return this;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid phone number: ");
                sb.append(s);
                throw new IllegalStateException(sb.toString());
            }
            
            public PhoneBuilder setDefaultNumber(final String s, final String s2) {
                Preconditions.checkUnset(((Builder)this).getParams(), "Cannot overwrite previously set phone number", "extra_phone_number", "extra_country_iso", "extra_national_number");
                if (PhoneNumberUtils.isValidIso(s)) {
                    ((Builder)this).getParams().putString("extra_country_iso", s);
                    ((Builder)this).getParams().putString("extra_national_number", s2);
                    return this;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid country iso: ");
                sb.append(s);
                throw new IllegalStateException(sb.toString());
            }
            
            public PhoneBuilder setWhitelistedCountries(final List<String> list) {
                if (!((Builder)this).getParams().containsKey("blocklisted_countries")) {
                    Preconditions.checkNotNull(list, String.format("Invalid argument: Only non-%s allowlists are valid. To specify no allowlist, do not call this method.", "null"), new Object[0]);
                    Preconditions.checkArgument(list.isEmpty() ^ true, String.format("Invalid argument: Only non-%s allowlists are valid. To specify no allowlist, do not call this method.", "empty"));
                    this.addCountriesToBundle(list, "allowlisted_countries");
                    return this;
                }
                throw new IllegalStateException("You can either allowlist or blocklist country codes for phone authentication.");
            }
        }
        
        public static final class TwitterBuilder extends GenericOAuthProviderBuilder
        {
            private static final String PROVIDER_NAME = "Twitter";
            
            public TwitterBuilder() {
                super("twitter.com", "Twitter", R.layout.fui_idp_button_twitter);
            }
        }
        
        public static final class YahooBuilder extends GenericOAuthProviderBuilder
        {
            private static final String PROVIDER_NAME = "Yahoo";
            
            public YahooBuilder() {
                super("yahoo.com", "Yahoo", R.layout.fui_idp_button_yahoo);
            }
        }
    }
    
    public final class SignInIntentBuilder extends AuthIntentBuilder<SignInIntentBuilder>
    {
        private String mEmailLink;
        private boolean mEnableAnonymousUpgrade;
        final AuthUI this$0;
        
        private SignInIntentBuilder(final AuthUI this$0) {
            this.this$0 = this$0.super(null);
        }
        
        SignInIntentBuilder(final AuthUI authUI, final AuthUI$1 continuation) {
            this(authUI);
        }
        
        private void validateEmailBuilderConfig() {
            for (int i = 0; i < super.mProviders.size(); ++i) {
                final IdpConfig idpConfig = super.mProviders.get(i);
                if (idpConfig.getProviderId().equals("emailLink") && !idpConfig.getParams().getBoolean("force_same_device", true)) {
                    throw new IllegalStateException("You must force the same device flow when using email link sign in with anonymous user upgrade");
                }
            }
        }
        
        @Override
        public /* bridge */ Intent build() {
            return super.build();
        }
        
        public SignInIntentBuilder enableAnonymousUsersAutoUpgrade() {
            this.mEnableAnonymousUpgrade = true;
            this.validateEmailBuilderConfig();
            return this;
        }
        
        @Override
        protected FlowParameters getFlowParams() {
            return new FlowParameters(AuthUI.access$500(this.this$0).o(), super.mProviders, super.mDefaultProvider, super.mTheme, super.mLogo, super.mTosUrl, super.mPrivacyPolicyUrl, super.mEnableCredentials, super.mEnableHints, this.mEnableAnonymousUpgrade, super.mAlwaysShowProviderChoice, super.mLockOrientation, this.mEmailLink, super.mPasswordSettings, super.mAuthMethodPickerLayout);
        }
        
        @Override
        public /* bridge */ AuthIntentBuilder setAvailableProviders(final List availableProviders) {
            return super.setAvailableProviders(availableProviders);
        }
        
        public SignInIntentBuilder setEmailLink(final String mEmailLink) {
            this.mEmailLink = mEmailLink;
            return this;
        }
        
        @Override
        public /* bridge */ AuthIntentBuilder setIsSmartLockEnabled(final boolean isSmartLockEnabled) {
            return super.setIsSmartLockEnabled(isSmartLockEnabled);
        }
        
        @Override
        public /* bridge */ AuthIntentBuilder setTosAndPrivacyPolicyUrls(final String s, final String s2) {
            return super.setTosAndPrivacyPolicyUrls(s, s2);
        }
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedProvider {
    }
}
