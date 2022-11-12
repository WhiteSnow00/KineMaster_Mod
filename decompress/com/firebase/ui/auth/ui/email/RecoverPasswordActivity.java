// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import android.widget.TextView;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import android.os.Bundle;
import android.view.View;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface;
import android.content.DialogInterface$OnDismissListener;
import com.firebase.ui.auth.R;
import androidx.appcompat.app.c;
import com.google.firebase.auth.ActionCodeSettings;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import android.widget.Button;
import android.widget.ProgressBar;
import com.firebase.ui.auth.viewmodel.email.RecoverPasswordHandler;
import com.google.android.material.textfield.TextInputLayout;
import com.firebase.ui.auth.util.ui.fieldvalidators.EmailFieldValidator;
import android.widget.EditText;
import com.firebase.ui.auth.util.ui.ImeHelper;
import android.view.View$OnClickListener;
import com.firebase.ui.auth.ui.AppCompatBase;

public class RecoverPasswordActivity extends AppCompatBase implements View$OnClickListener, DonePressedListener
{
    private EditText mEmailEditText;
    private EmailFieldValidator mEmailFieldValidator;
    private TextInputLayout mEmailInputLayout;
    private RecoverPasswordHandler mHandler;
    private ProgressBar mProgressBar;
    private Button mSubmitButton;
    
    static TextInputLayout access$000(final RecoverPasswordActivity recoverPasswordActivity) {
        return recoverPasswordActivity.mEmailInputLayout;
    }
    
    static void access$100(final RecoverPasswordActivity recoverPasswordActivity, final String s) {
        recoverPasswordActivity.showEmailSentDialog(s);
    }
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters, final String s) {
        return HelperActivityBase.createBaseIntent(context, RecoverPasswordActivity.class, flowParameters).putExtra("extra_email", s);
    }
    
    private void resetPassword(final String s, final ActionCodeSettings actionCodeSettings) {
        this.mHandler.startReset(s, actionCodeSettings);
    }
    
    private void showEmailSentDialog(final String s) {
        new c.a((Context)this).l(R.string.fui_title_confirm_recover_password).d(this.getString(R.string.fui_confirm_recovery_body, new Object[] { s })).g((DialogInterface$OnDismissListener)new DialogInterface$OnDismissListener(this) {
            final RecoverPasswordActivity this$0;
            
            public void onDismiss(final DialogInterface dialogInterface) {
                this.this$0.finish(-1, new Intent());
            }
        }).setPositiveButton(17039370, null).m();
    }
    
    public void hideProgress() {
        this.mSubmitButton.setEnabled(true);
        this.mProgressBar.setVisibility(4);
    }
    
    public void onClick(final View view) {
        if (view.getId() == R.id.button_done) {
            this.onDonePressed();
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.fui_forgot_password_layout);
        (this.mHandler = new o0(this).a(RecoverPasswordHandler.class)).init((I)this.getFlowParams());
        ((OperableViewModel<I, Resource<T>>)this.mHandler).getOperation().observe(this, (a0<? super Resource<T>>)new ResourceObserver<String>(this, this, R.string.fui_progress_dialog_sending) {
            final RecoverPasswordActivity this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
                if (!(ex instanceof FirebaseAuthInvalidUserException) && !(ex instanceof FirebaseAuthInvalidCredentialsException)) {
                    RecoverPasswordActivity.access$000(this.this$0).setError((CharSequence)this.this$0.getString(R.string.fui_error_unknown));
                }
                else {
                    RecoverPasswordActivity.access$000(this.this$0).setError((CharSequence)this.this$0.getString(R.string.fui_error_email_does_not_exist));
                }
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((String)o);
            }
            
            @Override
            protected void onSuccess(final String s) {
                RecoverPasswordActivity.access$000(this.this$0).setError((CharSequence)null);
                RecoverPasswordActivity.access$100(this.this$0, s);
            }
        });
        this.mProgressBar = this.findViewById(R.id.top_progress_bar);
        this.mSubmitButton = this.findViewById(R.id.button_done);
        this.mEmailInputLayout = this.findViewById(R.id.email_layout);
        this.mEmailEditText = this.findViewById(R.id.email);
        this.mEmailFieldValidator = new EmailFieldValidator(this.mEmailInputLayout);
        final String stringExtra = this.getIntent().getStringExtra("extra_email");
        if (stringExtra != null) {
            this.mEmailEditText.setText((CharSequence)stringExtra);
        }
        ImeHelper.setImeOnDoneListener(this.mEmailEditText, (ImeHelper.DonePressedListener)this);
        this.mSubmitButton.setOnClickListener((View$OnClickListener)this);
        PrivacyDisclosureUtils.setupTermsOfServiceFooter((Context)this, this.getFlowParams(), this.findViewById(R.id.email_footer_tos_and_pp_text));
    }
    
    public void onDonePressed() {
        if (this.mEmailFieldValidator.validate((CharSequence)this.mEmailEditText.getText())) {
            if (this.getFlowParams().passwordResetSettings != null) {
                this.resetPassword(this.mEmailEditText.getText().toString(), this.getFlowParams().passwordResetSettings);
            }
            else {
                this.resetPassword(this.mEmailEditText.getText().toString(), null);
            }
        }
    }
    
    public void showProgress(final int n) {
        this.mSubmitButton.setEnabled(false);
        this.mProgressBar.setVisibility(0);
    }
}
