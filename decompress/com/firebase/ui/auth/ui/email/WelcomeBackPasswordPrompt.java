// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.util.FirebaseAuthError;
import com.google.firebase.auth.FirebaseAuthException;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import android.widget.TextView;
import com.firebase.ui.auth.util.ui.TextHelper;
import android.text.SpannableStringBuilder;
import android.os.Bundle;
import android.view.View;
import com.firebase.ui.auth.util.data.ProviderUtils;
import android.text.TextUtils;
import com.firebase.ui.auth.R;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import android.os.Parcelable;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import android.widget.ProgressBar;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.EditText;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.viewmodel.email.WelcomeBackPasswordHandler;
import android.widget.Button;
import com.firebase.ui.auth.util.ui.ImeHelper;
import android.view.View$OnClickListener;
import com.firebase.ui.auth.ui.AppCompatBase;

public class WelcomeBackPasswordPrompt extends AppCompatBase implements View$OnClickListener, DonePressedListener
{
    private Button mDoneButton;
    private WelcomeBackPasswordHandler mHandler;
    private IdpResponse mIdpResponse;
    private EditText mPasswordField;
    private TextInputLayout mPasswordLayout;
    private ProgressBar mProgressBar;
    
    static WelcomeBackPasswordHandler access$000(final WelcomeBackPasswordPrompt welcomeBackPasswordPrompt) {
        return welcomeBackPasswordPrompt.mHandler;
    }
    
    static int access$100(final WelcomeBackPasswordPrompt welcomeBackPasswordPrompt, final Exception ex) {
        return welcomeBackPasswordPrompt.getErrorMessage(ex);
    }
    
    static TextInputLayout access$200(final WelcomeBackPasswordPrompt welcomeBackPasswordPrompt) {
        return welcomeBackPasswordPrompt.mPasswordLayout;
    }
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters, final IdpResponse idpResponse) {
        return HelperActivityBase.createBaseIntent(context, WelcomeBackPasswordPrompt.class, flowParameters).putExtra("extra_idp_response", (Parcelable)idpResponse);
    }
    
    private int getErrorMessage(final Exception ex) {
        if (ex instanceof FirebaseAuthInvalidCredentialsException) {
            return R.string.fui_error_invalid_password;
        }
        return R.string.fui_error_unknown;
    }
    
    private void onForgotPasswordClicked() {
        this.startActivity(RecoverPasswordActivity.createIntent((Context)this, this.getFlowParams(), this.mIdpResponse.getEmail()));
    }
    
    private void validateAndSignIn() {
        this.validateAndSignIn(this.mPasswordField.getText().toString());
    }
    
    private void validateAndSignIn(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            this.mPasswordLayout.setError((CharSequence)this.getString(R.string.fui_error_invalid_password));
            return;
        }
        this.mPasswordLayout.setError((CharSequence)null);
        this.mHandler.startSignIn(this.mIdpResponse.getEmail(), s, this.mIdpResponse, ProviderUtils.getAuthCredential(this.mIdpResponse));
    }
    
    public void hideProgress() {
        this.mDoneButton.setEnabled(true);
        this.mProgressBar.setVisibility(4);
    }
    
    public void onClick(final View view) {
        final int id = view.getId();
        if (id == R.id.button_done) {
            this.validateAndSignIn();
        }
        else if (id == R.id.trouble_signing_in) {
            this.onForgotPasswordClicked();
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.fui_welcome_back_password_prompt_layout);
        this.getWindow().setSoftInputMode(4);
        final IdpResponse fromResultIntent = IdpResponse.fromResultIntent(this.getIntent());
        this.mIdpResponse = fromResultIntent;
        final String email = fromResultIntent.getEmail();
        this.mDoneButton = this.findViewById(R.id.button_done);
        this.mProgressBar = this.findViewById(R.id.top_progress_bar);
        this.mPasswordLayout = this.findViewById(R.id.password_layout);
        ImeHelper.setImeOnDoneListener(this.mPasswordField = this.findViewById(R.id.password), (ImeHelper.DonePressedListener)this);
        final String string = this.getString(R.string.fui_welcome_back_password_prompt_body, new Object[] { email });
        final SpannableStringBuilder text = new SpannableStringBuilder((CharSequence)string);
        TextHelper.boldAllOccurencesOfText(text, string, email);
        this.findViewById(R.id.welcome_back_password_body).setText((CharSequence)text);
        this.mDoneButton.setOnClickListener((View$OnClickListener)this);
        this.findViewById(R.id.trouble_signing_in).setOnClickListener((View$OnClickListener)this);
        (this.mHandler = new o0(this).a(WelcomeBackPasswordHandler.class)).init((I)this.getFlowParams());
        ((OperableViewModel<I, Resource<T>>)this.mHandler).getOperation().observe(this, (a0<? super Resource<T>>)new ResourceObserver<IdpResponse>(this, this, R.string.fui_progress_dialog_signing_in) {
            final WelcomeBackPasswordPrompt this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
                if (ex instanceof FirebaseAuthAnonymousUpgradeException) {
                    this.this$0.finish(5, ((FirebaseAuthAnonymousUpgradeException)ex).getResponse().toIntent());
                    return;
                }
                if (ex instanceof FirebaseAuthException && FirebaseAuthError.fromException((FirebaseAuthException)ex) == FirebaseAuthError.ERROR_USER_DISABLED) {
                    this.this$0.finish(0, IdpResponse.from(new FirebaseUiException(12)).toIntent());
                    return;
                }
                final TextInputLayout access$200 = WelcomeBackPasswordPrompt.access$200(this.this$0);
                final WelcomeBackPasswordPrompt this$0 = this.this$0;
                access$200.setError((CharSequence)this$0.getString(WelcomeBackPasswordPrompt.access$100(this$0, ex)));
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                final WelcomeBackPasswordPrompt this$0 = this.this$0;
                this$0.startSaveCredentials(WelcomeBackPasswordPrompt.access$000(this$0).getCurrentUser(), idpResponse, WelcomeBackPasswordPrompt.access$000(this.this$0).getPendingPassword());
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
        PrivacyDisclosureUtils.setupTermsOfServiceFooter((Context)this, this.getFlowParams(), this.findViewById(R.id.email_footer_tos_and_pp_text));
    }
    
    public void onDonePressed() {
        this.validateAndSignIn();
    }
    
    public void showProgress(final int n) {
        this.mDoneButton.setEnabled(false);
        this.mProgressBar.setVisibility(0);
    }
}
