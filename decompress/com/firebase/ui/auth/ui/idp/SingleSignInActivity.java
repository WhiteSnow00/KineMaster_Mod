// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.idp;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.data.remote.GoogleSignInHandler;
import com.firebase.ui.auth.data.remote.FacebookSignInHandler;
import com.firebase.ui.auth.data.remote.GenericIdpSignInHandler;
import android.text.TextUtils;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.util.data.ProviderUtils;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import com.firebase.ui.auth.viewmodel.ProviderSignInBase;
import com.firebase.ui.auth.viewmodel.idp.SocialProviderResponseHandler;
import com.firebase.ui.auth.ui.InvisibleActivityBase;

public class SingleSignInActivity extends InvisibleActivityBase
{
    private SocialProviderResponseHandler mHandler;
    private ProviderSignInBase<?> mProvider;
    
    static SocialProviderResponseHandler access$000(final SingleSignInActivity singleSignInActivity) {
        return singleSignInActivity.mHandler;
    }
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters, final User user) {
        return HelperActivityBase.createBaseIntent(context, SingleSignInActivity.class, flowParameters).putExtra("extra_user", (Parcelable)user);
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        this.mHandler.onActivityResult(n, n2, intent);
        this.mProvider.onActivityResult(n, n2, intent);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final User user = User.getUser(this.getIntent());
        final String providerId = user.getProviderId();
        final AuthUI.IdpConfig configFromIdps = ProviderUtils.getConfigFromIdps(this.getFlowParams().providers, providerId);
        if (configFromIdps == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Provider not enabled: ");
            sb.append(providerId);
            this.finish(0, IdpResponse.getErrorIntent(new FirebaseUiException(3, sb.toString())));
            return;
        }
        final o0 o0 = new o0(this);
        (this.mHandler = o0.a(SocialProviderResponseHandler.class)).init((I)this.getFlowParams());
        final boolean useEmulator = this.getAuthUI().isUseEmulator();
        providerId.hashCode();
        if (!providerId.equals("google.com")) {
            if (!providerId.equals("facebook.com")) {
                if (TextUtils.isEmpty((CharSequence)configFromIdps.getParams().getString("generic_oauth_provider_id"))) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid provider id: ");
                    sb2.append(providerId);
                    throw new IllegalStateException(sb2.toString());
                }
                this.mProvider = o0.a(GenericIdpSignInHandler.class).initWith((Object)configFromIdps);
            }
            else if (useEmulator) {
                this.mProvider = o0.a(GenericIdpSignInHandler.class).initWith((Object)GenericIdpSignInHandler.getGenericFacebookConfig());
            }
            else {
                this.mProvider = o0.a(FacebookSignInHandler.class).initWith((Object)configFromIdps);
            }
        }
        else if (useEmulator) {
            this.mProvider = o0.a(GenericIdpSignInHandler.class).initWith((Object)GenericIdpSignInHandler.getGenericGoogleConfig());
        }
        else {
            this.mProvider = o0.a(GoogleSignInHandler.class).initWith((Object)new GoogleSignInHandler.Params(configFromIdps, user.getEmail()));
        }
        this.mProvider.getOperation().observe(this, (a0<? super Object>)new ResourceObserver<IdpResponse>(this, this, providerId) {
            final SingleSignInActivity this$0;
            final String val$provider;
            
            @Override
            protected void onFailure(final Exception ex) {
                if (ex instanceof FirebaseAuthAnonymousUpgradeException) {
                    this.this$0.finish(0, new Intent().putExtra("extra_idp_response", (Parcelable)IdpResponse.from(ex)));
                    return;
                }
                SingleSignInActivity.access$000(this.this$0).startSignIn(IdpResponse.from(ex));
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                final boolean contains = AuthUI.SOCIAL_PROVIDERS.contains(this.val$provider);
                final int n = 0;
                if ((!contains || this.this$0.getAuthUI().isUseEmulator()) && idpResponse.isSuccessful()) {
                    final SingleSignInActivity this$0 = this.this$0;
                    int n2 = n;
                    if (idpResponse.isSuccessful()) {
                        n2 = -1;
                    }
                    this$0.finish(n2, idpResponse.toIntent());
                    return;
                }
                SingleSignInActivity.access$000(this.this$0).startSignIn(idpResponse);
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
        ((OperableViewModel<I, Resource<T>>)this.mHandler).getOperation().observe(this, (a0<? super Resource<T>>)new ResourceObserver<IdpResponse>(this, this) {
            final SingleSignInActivity this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
                if (ex instanceof FirebaseAuthAnonymousUpgradeException) {
                    this.this$0.finish(0, new Intent().putExtra("extra_idp_response", (Parcelable)((FirebaseAuthAnonymousUpgradeException)ex).getResponse()));
                }
                else {
                    this.this$0.finish(0, IdpResponse.getErrorIntent(ex));
                }
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                final SingleSignInActivity this$0 = this.this$0;
                this$0.startSaveCredentials(SingleSignInActivity.access$000(this$0).getCurrentUser(), idpResponse, null);
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
        if (((OperableViewModel<I, Resource<T>>)this.mHandler).getOperation().getValue() == null) {
            this.mProvider.startSignIn(this.getAuth(), this, providerId);
        }
    }
}
