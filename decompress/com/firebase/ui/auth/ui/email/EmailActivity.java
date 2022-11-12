// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import androidx.fragment.app.c0;
import android.view.View;
import androidx.core.view.b0;
import com.google.android.material.textfield.TextInputLayout;
import com.firebase.ui.auth.ui.idp.WelcomeBackIdpPrompt;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.util.data.EmailLinkPersistenceManager;
import android.os.Bundle;
import com.firebase.ui.auth.util.data.ProviderUtils;
import androidx.fragment.app.Fragment;
import com.google.firebase.auth.ActionCodeSettings;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.FirebaseUiException;
import android.os.Parcelable;
import com.firebase.ui.auth.IdpResponse;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import com.firebase.ui.auth.ui.AppCompatBase;

public class EmailActivity extends AppCompatBase implements CheckEmailListener, AnonymousUpgradeListener, TroubleSigningInListener, ResendEmailListener
{
    public static Intent createIntent(final Context context, final FlowParameters flowParameters) {
        return HelperActivityBase.createBaseIntent(context, EmailActivity.class, flowParameters);
    }
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters, final String s) {
        return HelperActivityBase.createBaseIntent(context, EmailActivity.class, flowParameters).putExtra("extra_email", s);
    }
    
    public static Intent createIntentForLinking(final Context context, final FlowParameters flowParameters, final IdpResponse idpResponse) {
        return createIntent(context, flowParameters, idpResponse.getEmail()).putExtra("extra_idp_response", (Parcelable)idpResponse);
    }
    
    private void finishOnDeveloperError(final Exception ex) {
        this.finish(0, IdpResponse.getErrorIntent(new FirebaseUiException(3, ex.getMessage())));
    }
    
    private void setSlideAnimation() {
        this.overridePendingTransition(R.anim.fui_slide_in_right, R.anim.fui_slide_out_left);
    }
    
    private void showRegisterEmailLinkFragment(final AuthUI.IdpConfig idpConfig, final String s) {
        this.switchFragment(EmailLinkFragment.newInstance(s, (ActionCodeSettings)idpConfig.getParams().getParcelable("action_code_settings")), R.id.fragment_register_email, "EmailLinkFragment");
    }
    
    @Override
    public void hideProgress() {
        throw new UnsupportedOperationException("Email fragments must handle progress updates.");
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 104 || n == 103) {
            this.finish(n2, intent);
        }
    }
    
    @Override
    public void onClickResendEmail(final String s) {
        if (this.getSupportFragmentManager().s0() > 0) {
            this.getSupportFragmentManager().g1();
        }
        this.showRegisterEmailLinkFragment(ProviderUtils.getConfigFromIdpsOrThrow(this.getFlowParams().providers, "emailLink"), s);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.fui_activity_register_email);
        if (bundle != null) {
            return;
        }
        String s = this.getIntent().getExtras().getString("extra_email");
        final IdpResponse idpResponse = (IdpResponse)this.getIntent().getExtras().getParcelable("extra_idp_response");
        if (s != null && idpResponse != null) {
            final AuthUI.IdpConfig configFromIdpsOrThrow = ProviderUtils.getConfigFromIdpsOrThrow(this.getFlowParams().providers, "emailLink");
            final ActionCodeSettings actionCodeSettings = (ActionCodeSettings)configFromIdpsOrThrow.getParams().getParcelable("action_code_settings");
            EmailLinkPersistenceManager.getInstance().saveIdpResponseForLinking((Context)this.getApplication(), idpResponse);
            this.switchFragment(EmailLinkFragment.newInstance(s, actionCodeSettings, idpResponse, configFromIdpsOrThrow.getParams().getBoolean("force_same_device")), R.id.fragment_register_email, "EmailLinkFragment");
        }
        else {
            final AuthUI.IdpConfig configFromIdps = ProviderUtils.getConfigFromIdps(this.getFlowParams().providers, "password");
            if (configFromIdps != null) {
                s = configFromIdps.getParams().getString("extra_default_email");
            }
            this.switchFragment(CheckEmailFragment.newInstance(s), R.id.fragment_register_email, "CheckEmailFragment");
        }
    }
    
    @Override
    public void onDeveloperFailure(final Exception ex) {
        this.finishOnDeveloperError(ex);
    }
    
    @Override
    public void onExistingEmailUser(final User user) {
        if (user.getProviderId().equals("emailLink")) {
            this.showRegisterEmailLinkFragment(ProviderUtils.getConfigFromIdpsOrThrow(this.getFlowParams().providers, "emailLink"), user.getEmail());
        }
        else {
            this.startActivityForResult(WelcomeBackPasswordPrompt.createIntent((Context)this, this.getFlowParams(), new IdpResponse.Builder(user).build()), 104);
            this.setSlideAnimation();
        }
    }
    
    @Override
    public void onExistingIdpUser(final User user) {
        this.startActivityForResult(WelcomeBackIdpPrompt.createIntent((Context)this, this.getFlowParams(), user), 103);
        this.setSlideAnimation();
    }
    
    @Override
    public void onMergeFailure(final IdpResponse idpResponse) {
        this.finish(5, idpResponse.toIntent());
    }
    
    @Override
    public void onNewUser(final User user) {
        final TextInputLayout textInputLayout = this.findViewById(R.id.email_layout);
        AuthUI.IdpConfig idpConfig;
        if ((idpConfig = ProviderUtils.getConfigFromIdps(this.getFlowParams().providers, "password")) == null) {
            idpConfig = ProviderUtils.getConfigFromIdps(this.getFlowParams().providers, "emailLink");
        }
        if (idpConfig.getParams().getBoolean("extra_allow_new_emails", true)) {
            final c0 q = this.getSupportFragmentManager().q();
            if (idpConfig.getProviderId().equals("emailLink")) {
                this.showRegisterEmailLinkFragment(idpConfig, user.getEmail());
            }
            else {
                q.r(R.id.fragment_register_email, RegisterEmailFragment.newInstance(user), "RegisterEmailFragment");
                if (textInputLayout != null) {
                    final String string = this.getString(R.string.fui_email_field_name);
                    b0.J0((View)textInputLayout, string);
                    q.g((View)textInputLayout, string);
                }
                q.m().i();
            }
        }
        else {
            textInputLayout.setError((CharSequence)this.getString(R.string.fui_error_email_does_not_exist));
        }
    }
    
    @Override
    public void onSendEmailFailure(final Exception ex) {
        this.finishOnDeveloperError(ex);
    }
    
    @Override
    public void onTroubleSigningIn(final String s) {
        this.switchFragment(TroubleSigningInFragment.newInstance(s), R.id.fragment_register_email, "TroubleSigningInFragment", true, true);
    }
    
    @Override
    public void showProgress(final int n) {
        throw new UnsupportedOperationException("Email fragments must handle progress updates.");
    }
}
