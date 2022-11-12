// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.idp;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.data.remote.GoogleSignInHandler;
import com.firebase.ui.auth.data.remote.FacebookSignInHandler;
import com.firebase.ui.auth.data.remote.GenericIdpSignInHandler;
import com.firebase.ui.auth.data.remote.GenericIdpAnonymousUpgradeLinkingHandler;
import android.text.TextUtils;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.viewmodel.idp.LinkingSocialProviderResponseHandler;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import com.firebase.ui.auth.R;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.IdpResponse;
import android.content.Intent;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import com.firebase.ui.auth.viewmodel.ProviderSignInBase;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.Button;
import com.firebase.ui.auth.ui.AppCompatBase;

public class WelcomeBackIdpPrompt extends AppCompatBase
{
    private Button mDoneButton;
    private ProgressBar mProgressBar;
    private TextView mPromptText;
    private ProviderSignInBase<?> mProvider;
    
    static ProviderSignInBase access$000(final WelcomeBackIdpPrompt welcomeBackIdpPrompt) {
        return welcomeBackIdpPrompt.mProvider;
    }
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters, final User user) {
        return createIntent(context, flowParameters, user, null);
    }
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters, final User user, final IdpResponse idpResponse) {
        return HelperActivityBase.createBaseIntent(context, WelcomeBackIdpPrompt.class, flowParameters).putExtra("extra_idp_response", (Parcelable)idpResponse).putExtra("extra_user", (Parcelable)user);
    }
    
    @Override
    public void hideProgress() {
        this.mDoneButton.setEnabled(true);
        this.mProgressBar.setVisibility(4);
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        this.mProvider.onActivityResult(n, n2, intent);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.fui_welcome_back_idp_prompt_layout);
        this.mDoneButton = this.findViewById(R.id.welcome_back_idp_button);
        this.mProgressBar = this.findViewById(R.id.top_progress_bar);
        this.mPromptText = this.findViewById(R.id.welcome_back_idp_prompt);
        final User user = User.getUser(this.getIntent());
        final IdpResponse fromResultIntent = IdpResponse.fromResultIntent(this.getIntent());
        final o0 o0 = new o0(this);
        final LinkingSocialProviderResponseHandler linkingSocialProviderResponseHandler = o0.a(LinkingSocialProviderResponseHandler.class);
        linkingSocialProviderResponseHandler.init((I)this.getFlowParams());
        if (fromResultIntent != null) {
            linkingSocialProviderResponseHandler.setRequestedSignInCredentialForEmail(ProviderUtils.getAuthCredential(fromResultIntent), user.getEmail());
        }
        final String providerId = user.getProviderId();
        final AuthUI.IdpConfig configFromIdps = ProviderUtils.getConfigFromIdps(this.getFlowParams().providers, providerId);
        if (configFromIdps == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Firebase login unsuccessful. Account linking failed due to provider not enabled by application: ");
            sb.append(providerId);
            this.finish(0, IdpResponse.getErrorIntent(new FirebaseUiException(3, sb.toString())));
            return;
        }
        final String string = configFromIdps.getParams().getString("generic_oauth_provider_id");
        final boolean useEmulator = this.getAuthUI().isUseEmulator();
        providerId.hashCode();
        String s;
        if (!providerId.equals("google.com")) {
            if (!providerId.equals("facebook.com")) {
                if (!TextUtils.equals((CharSequence)providerId, (CharSequence)string)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid provider id: ");
                    sb2.append(providerId);
                    throw new IllegalStateException(sb2.toString());
                }
                this.mProvider = o0.a(GenericIdpAnonymousUpgradeLinkingHandler.class).initWith((Object)configFromIdps);
                s = configFromIdps.getParams().getString("generic_oauth_provider_name");
            }
            else {
                if (useEmulator) {
                    this.mProvider = o0.a(GenericIdpAnonymousUpgradeLinkingHandler.class).initWith((Object)GenericIdpSignInHandler.getGenericFacebookConfig());
                }
                else {
                    this.mProvider = o0.a(FacebookSignInHandler.class).initWith((Object)configFromIdps);
                }
                s = this.getString(R.string.fui_idp_name_facebook);
            }
        }
        else {
            if (useEmulator) {
                this.mProvider = o0.a(GenericIdpAnonymousUpgradeLinkingHandler.class).initWith((Object)GenericIdpSignInHandler.getGenericGoogleConfig());
            }
            else {
                this.mProvider = o0.a(GoogleSignInHandler.class).initWith((Object)new GoogleSignInHandler.Params(configFromIdps, user.getEmail()));
            }
            s = this.getString(R.string.fui_idp_name_google);
        }
        this.mProvider.getOperation().observe(this, (a0<? super Object>)new ResourceObserver<IdpResponse>(this, this, linkingSocialProviderResponseHandler) {
            final WelcomeBackIdpPrompt this$0;
            final LinkingSocialProviderResponseHandler val$handler;
            
            @Override
            protected void onFailure(final Exception ex) {
                this.val$handler.startSignIn(IdpResponse.from(ex));
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                if ((this.this$0.getAuthUI().isUseEmulator() || !AuthUI.SOCIAL_PROVIDERS.contains(idpResponse.getProviderType())) && !idpResponse.hasCredentialForLinking() && !this.val$handler.hasCredentialForLinking()) {
                    this.this$0.finish(-1, idpResponse.toIntent());
                    return;
                }
                this.val$handler.startSignIn(idpResponse);
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
        this.mPromptText.setText((CharSequence)this.getString(R.string.fui_welcome_back_idp_prompt, new Object[] { user.getEmail(), s }));
        this.mDoneButton.setOnClickListener((View$OnClickListener)new View$OnClickListener(this, providerId) {
            final WelcomeBackIdpPrompt this$0;
            final String val$providerId;
            
            public void onClick(final View view) {
                WelcomeBackIdpPrompt.access$000(this.this$0).startSignIn(this.this$0.getAuth(), this.this$0, this.val$providerId);
            }
        });
        ((OperableViewModel<I, Resource<T>>)linkingSocialProviderResponseHandler).getOperation().observe(this, (a0<? super Resource<T>>)new ResourceObserver<IdpResponse>(this, this) {
            final WelcomeBackIdpPrompt this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
                if (ex instanceof FirebaseAuthAnonymousUpgradeException) {
                    this.this$0.finish(5, ((FirebaseAuthAnonymousUpgradeException)ex).getResponse().toIntent());
                }
                else {
                    this.this$0.finish(0, IdpResponse.getErrorIntent(ex));
                }
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                this.this$0.finish(-1, idpResponse.toIntent());
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
        PrivacyDisclosureUtils.setupTermsOfServiceFooter((Context)this, this.getFlowParams(), this.findViewById(R.id.email_footer_tos_and_pp_text));
    }
    
    @Override
    public void showProgress(final int n) {
        this.mDoneButton.setEnabled(false);
        this.mProgressBar.setVisibility(0);
    }
}
