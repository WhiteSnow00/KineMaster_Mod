// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.idp;

import android.widget.Toast;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Bundle;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.firebase.ui.auth.R;
import android.view.View$OnClickListener;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import android.os.Parcelable;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.data.remote.AnonymousSignInHandler;
import com.firebase.ui.auth.data.remote.GoogleSignInHandler;
import com.firebase.ui.auth.data.remote.FacebookSignInHandler;
import com.firebase.ui.auth.data.remote.PhoneSignInHandler;
import com.firebase.ui.auth.data.remote.EmailSignInHandler;
import com.firebase.ui.auth.data.remote.GenericIdpSignInHandler;
import android.text.TextUtils;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import android.view.View;
import com.firebase.ui.auth.AuthUI;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import com.firebase.ui.auth.viewmodel.ProviderSignInBase;
import java.util.List;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.firebase.ui.auth.viewmodel.idp.SocialProviderResponseHandler;
import com.firebase.ui.auth.AuthMethodPickerLayout;
import com.firebase.ui.auth.ui.AppCompatBase;

public class AuthMethodPickerActivity extends AppCompatBase
{
    private AuthMethodPickerLayout customLayout;
    private SocialProviderResponseHandler mHandler;
    private ProgressBar mProgressBar;
    private ViewGroup mProviderHolder;
    private List<ProviderSignInBase<?>> mProviders;
    
    static SocialProviderResponseHandler access$000(final AuthMethodPickerActivity authMethodPickerActivity) {
        return authMethodPickerActivity.mHandler;
    }
    
    static boolean access$100(final AuthMethodPickerActivity authMethodPickerActivity) {
        return authMethodPickerActivity.isOffline();
    }
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters) {
        return HelperActivityBase.createBaseIntent(context, AuthMethodPickerActivity.class, flowParameters);
    }
    
    private void handleSignInOperation(final AuthUI.IdpConfig idpConfig, final View view) {
        final o0 o0 = new o0(this);
        final String providerId = idpConfig.getProviderId();
        final AuthUI authUI = this.getAuthUI();
        providerId.hashCode();
        final int hashCode = providerId.hashCode();
        int n = -1;
        switch (hashCode) {
            case 2120171958: {
                if (!providerId.equals("emailLink")) {
                    break;
                }
                n = 5;
                break;
            }
            case 1216985755: {
                if (!providerId.equals("password")) {
                    break;
                }
                n = 4;
                break;
            }
            case 106642798: {
                if (!providerId.equals("phone")) {
                    break;
                }
                n = 3;
                break;
            }
            case -364826023: {
                if (!providerId.equals("facebook.com")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1536293812: {
                if (!providerId.equals("google.com")) {
                    break;
                }
                n = 1;
                break;
            }
            case -2095811475: {
                if (!providerId.equals("anonymous")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        OperableViewModel<T, Resource<IdpResponse>> operableViewModel = null;
        switch (n) {
            default: {
                if (!TextUtils.isEmpty((CharSequence)idpConfig.getParams().getString("generic_oauth_provider_id"))) {
                    operableViewModel = o0.a(GenericIdpSignInHandler.class).initWith(idpConfig);
                    break;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown provider: ");
                sb.append(providerId);
                throw new IllegalStateException(sb.toString());
            }
            case 4:
            case 5: {
                operableViewModel = o0.a(EmailSignInHandler.class).initWith(null);
                break;
            }
            case 3: {
                operableViewModel = o0.a(PhoneSignInHandler.class).initWith(idpConfig);
                break;
            }
            case 2: {
                if (authUI.isUseEmulator()) {
                    operableViewModel = o0.a(GenericIdpSignInHandler.class).initWith(GenericIdpSignInHandler.getGenericFacebookConfig());
                    break;
                }
                operableViewModel = o0.a(FacebookSignInHandler.class).initWith(idpConfig);
                break;
            }
            case 1: {
                if (authUI.isUseEmulator()) {
                    operableViewModel = o0.a(GenericIdpSignInHandler.class).initWith(GenericIdpSignInHandler.getGenericGoogleConfig());
                    break;
                }
                operableViewModel = o0.a(GoogleSignInHandler.class).initWith(new GoogleSignInHandler.Params(idpConfig));
                break;
            }
            case 0: {
                operableViewModel = o0.a(AnonymousSignInHandler.class).initWith(this.getFlowParams());
                break;
            }
        }
        this.mProviders.add((ProviderSignInBase<?>)operableViewModel);
        operableViewModel.getOperation().observe(this, new ResourceObserver<IdpResponse>(this, this, providerId) {
            final AuthMethodPickerActivity this$0;
            final String val$providerId;
            
            private void handleResponse(final IdpResponse idpResponse) {
                final boolean contains = AuthUI.SOCIAL_PROVIDERS.contains(this.val$providerId);
                final int n = 0;
                final boolean b = contains && !this.this$0.getAuthUI().isUseEmulator();
                if (!idpResponse.isSuccessful()) {
                    AuthMethodPickerActivity.access$000(this.this$0).startSignIn(idpResponse);
                }
                else if (b) {
                    AuthMethodPickerActivity.access$000(this.this$0).startSignIn(idpResponse);
                }
                else {
                    final AuthMethodPickerActivity this$0 = this.this$0;
                    int n2 = n;
                    if (idpResponse.isSuccessful()) {
                        n2 = -1;
                    }
                    this$0.finish(n2, idpResponse.toIntent());
                }
            }
            
            @Override
            protected void onFailure(final Exception ex) {
                if (ex instanceof FirebaseAuthAnonymousUpgradeException) {
                    this.this$0.finish(0, new Intent().putExtra("extra_idp_response", (Parcelable)IdpResponse.from(ex)));
                    return;
                }
                this.handleResponse(IdpResponse.from(ex));
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                this.handleResponse(idpResponse);
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
        view.setOnClickListener((View$OnClickListener)new View$OnClickListener(this, operableViewModel, idpConfig) {
            final AuthMethodPickerActivity this$0;
            final AuthUI.IdpConfig val$idpConfig;
            final ProviderSignInBase val$provider;
            
            public void onClick(final View view) {
                if (AuthMethodPickerActivity.access$100(this.this$0)) {
                    Snackbar.e(this.this$0.findViewById(16908290), (CharSequence)this.this$0.getString(R.string.fui_no_internet), -1).show();
                    return;
                }
                this.val$provider.startSignIn(this.this$0.getAuth(), this.this$0, this.val$idpConfig.getProviderId());
            }
        });
    }
    
    private void populateIdpList(final List<AuthUI.IdpConfig> list) {
        new o0(this);
        this.mProviders = new ArrayList<ProviderSignInBase<?>>();
        for (final AuthUI.IdpConfig idpConfig : list) {
            final String providerId = idpConfig.getProviderId();
            providerId.hashCode();
            int n = -1;
            switch (providerId) {
                case "emailLink": {
                    n = 5;
                    break;
                }
                case "password": {
                    n = 4;
                    break;
                }
                case "phone": {
                    n = 3;
                    break;
                }
                case "facebook.com": {
                    n = 2;
                    break;
                }
                case "google.com": {
                    n = 1;
                    break;
                }
                case "anonymous": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            int n2 = 0;
            switch (n) {
                default: {
                    if (!TextUtils.isEmpty((CharSequence)idpConfig.getParams().getString("generic_oauth_provider_id"))) {
                        n2 = idpConfig.getParams().getInt("generic_oauth_button_id");
                        break;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown provider: ");
                    sb.append(providerId);
                    throw new IllegalStateException(sb.toString());
                }
                case 4:
                case 5: {
                    n2 = R.layout.fui_provider_button_email;
                    break;
                }
                case 3: {
                    n2 = R.layout.fui_provider_button_phone;
                    break;
                }
                case 2: {
                    n2 = R.layout.fui_idp_button_facebook;
                    break;
                }
                case 1: {
                    n2 = R.layout.fui_idp_button_google;
                    break;
                }
                case 0: {
                    n2 = R.layout.fui_provider_button_anonymous;
                    break;
                }
            }
            final View inflate = this.getLayoutInflater().inflate(n2, this.mProviderHolder, false);
            this.handleSignInOperation(idpConfig, inflate);
            this.mProviderHolder.addView(inflate);
        }
    }
    
    private void populateIdpListCustomLayout(final List<AuthUI.IdpConfig> list) {
        final Map<String, Integer> providersButton = this.customLayout.getProvidersButton();
        for (final AuthUI.IdpConfig idpConfig : list) {
            final Integer n = providersButton.get(this.providerOrEmailLinkProvider(idpConfig.getProviderId()));
            if (n == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("No button found for auth provider: ");
                sb.append(idpConfig.getProviderId());
                throw new IllegalStateException(sb.toString());
            }
            this.handleSignInOperation(idpConfig, this.findViewById(n));
        }
    Label_0214_Outer:
        for (final String s : providersButton.keySet()) {
            if (s == null) {
                continue Label_0214_Outer;
            }
            final int n2 = 0;
            final Iterator<AuthUI.IdpConfig> iterator3 = list.iterator();
            while (true) {
                do {
                    final int n3 = n2;
                    if (iterator3.hasNext()) {
                        continue Label_0214_Outer;
                    }
                    if (n3 != 0) {
                        continue Label_0214_Outer;
                    }
                    final Integer n4 = providersButton.get(s);
                    if (n4 == null) {
                        continue Label_0214_Outer;
                    }
                    this.findViewById(n4).setVisibility(8);
                    continue Label_0214_Outer;
                } while (!s.equals(this.providerOrEmailLinkProvider(iterator3.next().getProviderId())));
                final int n3 = 1;
                continue;
            }
        }
    }
    
    private String providerOrEmailLinkProvider(final String s) {
        String s2 = s;
        if (s.equals("emailLink")) {
            s2 = "password";
        }
        return s2;
    }
    
    @Override
    public void hideProgress() {
        if (this.customLayout == null) {
            this.mProgressBar.setVisibility(4);
            for (int i = 0; i < this.mProviderHolder.getChildCount(); ++i) {
                final View child = this.mProviderHolder.getChildAt(i);
                child.setEnabled(true);
                child.setAlpha(1.0f);
            }
        }
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        this.mHandler.onActivityResult(n, n2, intent);
        final Iterator<ProviderSignInBase<?>> iterator = this.mProviders.iterator();
        while (iterator.hasNext()) {
            iterator.next().onActivityResult(n, n2, intent);
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final FlowParameters flowParams = this.getFlowParams();
        this.customLayout = flowParams.authMethodPickerLayout;
        (this.mHandler = new o0(this).a(SocialProviderResponseHandler.class)).init((I)flowParams);
        this.mProviders = new ArrayList<ProviderSignInBase<?>>();
        final AuthMethodPickerLayout customLayout = this.customLayout;
        if (customLayout != null) {
            this.setContentView(customLayout.getMainLayout());
            this.populateIdpListCustomLayout(flowParams.providers);
        }
        else {
            this.setContentView(R.layout.fui_auth_method_picker_layout);
            this.mProgressBar = this.findViewById(R.id.top_progress_bar);
            this.mProviderHolder = this.findViewById(R.id.btn_holder);
            this.populateIdpList(flowParams.providers);
            final int logoId = flowParams.logoId;
            if (logoId == -1) {
                this.findViewById(R.id.logo).setVisibility(8);
                final ConstraintLayout constraintLayout = this.findViewById(R.id.root);
                final c c = new c();
                c.n(constraintLayout);
                final int container = R.id.container;
                c.N(container, 0.5f);
                c.Q(container, 0.5f);
                c.i(constraintLayout);
            }
            else {
                this.findViewById(R.id.logo).setImageResource(logoId);
            }
        }
        final boolean b = this.getFlowParams().isPrivacyPolicyUrlProvided() && this.getFlowParams().isTermsOfServiceUrlProvided();
        final AuthMethodPickerLayout customLayout2 = this.customLayout;
        int n;
        if (customLayout2 == null) {
            n = R.id.main_tos_and_pp;
        }
        else {
            n = customLayout2.getTosPpView();
        }
        if (n >= 0) {
            final TextView textView = this.findViewById(n);
            if (!b) {
                textView.setVisibility(8);
            }
            else {
                PrivacyDisclosureUtils.setupTermsOfServiceAndPrivacyPolicyText((Context)this, this.getFlowParams(), textView);
            }
        }
        ((OperableViewModel<I, Resource<T>>)this.mHandler).getOperation().observe(this, (a0<? super Resource<T>>)new ResourceObserver<IdpResponse>(this, this, R.string.fui_progress_dialog_signing_in) {
            final AuthMethodPickerActivity this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
                if (ex instanceof UserCancellationException) {
                    return;
                }
                if (ex instanceof FirebaseAuthAnonymousUpgradeException) {
                    this.this$0.finish(5, ((FirebaseAuthAnonymousUpgradeException)ex).getResponse().toIntent());
                }
                else if (ex instanceof FirebaseUiException) {
                    this.this$0.finish(0, IdpResponse.from(ex).toIntent());
                }
                else {
                    Toast.makeText((Context)this.this$0, (CharSequence)this.this$0.getString(R.string.fui_error_unknown), 0).show();
                }
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                final AuthMethodPickerActivity this$0 = this.this$0;
                this$0.startSaveCredentials(AuthMethodPickerActivity.access$000(this$0).getCurrentUser(), idpResponse, null);
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
    }
    
    @Override
    public void showProgress(int i) {
        if (this.customLayout == null) {
            this.mProgressBar.setVisibility(0);
            View child;
            for (i = 0; i < this.mProviderHolder.getChildCount(); ++i) {
                child = this.mProviderHolder.getChildAt(i);
                child.setEnabled(false);
                child.setAlpha(0.75f);
            }
        }
    }
}
