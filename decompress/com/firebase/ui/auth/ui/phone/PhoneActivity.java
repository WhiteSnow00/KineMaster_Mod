// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.phone;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import androidx.fragment.app.FragmentManager;
import com.firebase.ui.auth.data.model.User;
import android.widget.Toast;
import com.firebase.ui.auth.data.model.PhoneNumberVerificationRequiredException;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import com.firebase.ui.auth.viewmodel.phone.PhoneProviderResponseHandler;
import androidx.fragment.app.Fragment;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.FirebaseUiException;
import com.google.firebase.auth.FirebaseAuthException;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.google.android.material.textfield.TextInputLayout;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.util.FirebaseAuthError;
import com.firebase.ui.auth.ui.FragmentBase;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import android.os.Bundle;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import com.firebase.ui.auth.ui.AppCompatBase;

public class PhoneActivity extends AppCompatBase
{
    private PhoneNumberVerificationHandler mPhoneVerifier;
    
    static void access$000(final PhoneActivity phoneActivity, final Exception ex) {
        phoneActivity.handleError(ex);
    }
    
    static void access$100(final PhoneActivity phoneActivity, final String s) {
        phoneActivity.showSubmitCodeFragment(s);
    }
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters, final Bundle bundle) {
        return HelperActivityBase.createBaseIntent(context, PhoneActivity.class, flowParameters).putExtra("extra_params", bundle);
    }
    
    private FragmentBase getActiveFragment() {
        final CheckPhoneNumberFragment checkPhoneNumberFragment = (CheckPhoneNumberFragment)this.getSupportFragmentManager().k0("VerifyPhoneFragment");
        FragmentBase fragmentBase = null;
        Label_0039: {
            if (checkPhoneNumberFragment != null) {
                fragmentBase = checkPhoneNumberFragment;
                if (checkPhoneNumberFragment.getView() != null) {
                    break Label_0039;
                }
            }
            fragmentBase = (SubmitConfirmationCodeFragment)this.getSupportFragmentManager().k0("SubmitConfirmationCodeFragment");
        }
        if (fragmentBase != null && fragmentBase.getView() != null) {
            return fragmentBase;
        }
        throw new IllegalStateException("No fragments added");
    }
    
    private String getErrorMessage(final FirebaseAuthError firebaseAuthError) {
        final int n = PhoneActivity$3.$SwitchMap$com$firebase$ui$auth$util$FirebaseAuthError[firebaseAuthError.ordinal()];
        if (n == 1) {
            return this.getString(R.string.fui_invalid_phone_number);
        }
        if (n == 2) {
            return this.getString(R.string.fui_error_too_many_attempts);
        }
        if (n == 3) {
            return this.getString(R.string.fui_error_quota_exceeded);
        }
        if (n == 4) {
            return this.getString(R.string.fui_incorrect_code_dialog_body);
        }
        if (n != 5) {
            return firebaseAuthError.getDescription();
        }
        return this.getString(R.string.fui_error_session_expired);
    }
    
    private TextInputLayout getErrorView() {
        final CheckPhoneNumberFragment checkPhoneNumberFragment = (CheckPhoneNumberFragment)this.getSupportFragmentManager().k0("VerifyPhoneFragment");
        final SubmitConfirmationCodeFragment submitConfirmationCodeFragment = (SubmitConfirmationCodeFragment)this.getSupportFragmentManager().k0("SubmitConfirmationCodeFragment");
        if (checkPhoneNumberFragment != null && checkPhoneNumberFragment.getView() != null) {
            return (TextInputLayout)checkPhoneNumberFragment.getView().findViewById(R.id.phone_layout);
        }
        if (submitConfirmationCodeFragment != null && submitConfirmationCodeFragment.getView() != null) {
            return (TextInputLayout)submitConfirmationCodeFragment.getView().findViewById(R.id.confirmation_code_layout);
        }
        return null;
    }
    
    private void handleError(final Exception ex) {
        final TextInputLayout errorView = this.getErrorView();
        if (errorView == null) {
            return;
        }
        if (ex instanceof FirebaseAuthAnonymousUpgradeException) {
            this.finish(5, ((FirebaseAuthAnonymousUpgradeException)ex).getResponse().toIntent());
        }
        else if (ex instanceof FirebaseAuthException) {
            final FirebaseAuthError fromException = FirebaseAuthError.fromException((FirebaseAuthException)ex);
            if (fromException == FirebaseAuthError.ERROR_USER_DISABLED) {
                this.finish(0, IdpResponse.from(new FirebaseUiException(12)).toIntent());
                return;
            }
            errorView.setError((CharSequence)this.getErrorMessage(fromException));
        }
        else if (ex != null) {
            errorView.setError((CharSequence)this.getErrorMessage(FirebaseAuthError.ERROR_UNKNOWN));
        }
        else {
            errorView.setError((CharSequence)null);
        }
    }
    
    private void showSubmitCodeFragment(final String s) {
        this.getSupportFragmentManager().q().r(R.id.fragment_phone, SubmitConfirmationCodeFragment.newInstance(s), "SubmitConfirmationCodeFragment").h(null).i();
    }
    
    @Override
    public void hideProgress() {
        this.getActiveFragment().hideProgress();
    }
    
    @Override
    public void onBackPressed() {
        if (this.getSupportFragmentManager().s0() > 0) {
            this.getSupportFragmentManager().g1();
        }
        else {
            super.onBackPressed();
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.fui_activity_register_phone);
        final PhoneProviderResponseHandler phoneProviderResponseHandler = new o0(this).a(PhoneProviderResponseHandler.class);
        phoneProviderResponseHandler.init((I)this.getFlowParams());
        ((OperableViewModel<I, Resource<T>>)phoneProviderResponseHandler).getOperation().observe(this, (a0<? super Resource<T>>)new ResourceObserver<IdpResponse>(this, this, R.string.fui_progress_dialog_signing_in, phoneProviderResponseHandler) {
            final PhoneActivity this$0;
            final PhoneProviderResponseHandler val$handler;
            
            @Override
            protected void onFailure(final Exception ex) {
                PhoneActivity.access$000(this.this$0, ex);
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                this.this$0.startSaveCredentials(this.val$handler.getCurrentUser(), idpResponse, null);
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
        (this.mPhoneVerifier = new o0(this).a(PhoneNumberVerificationHandler.class)).init((I)this.getFlowParams());
        this.mPhoneVerifier.onRestoreInstanceState(bundle);
        ((OperableViewModel<I, Resource<T>>)this.mPhoneVerifier).getOperation().observe(this, (a0<? super Resource<T>>)new ResourceObserver<PhoneVerification>(this, this, R.string.fui_verifying, phoneProviderResponseHandler) {
            final PhoneActivity this$0;
            final PhoneProviderResponseHandler val$handler;
            
            @Override
            protected void onFailure(final Exception ex) {
                if (ex instanceof PhoneNumberVerificationRequiredException) {
                    if (this.this$0.getSupportFragmentManager().k0("SubmitConfirmationCodeFragment") == null) {
                        PhoneActivity.access$100(this.this$0, ((PhoneNumberVerificationRequiredException)ex).getPhoneNumber());
                    }
                    PhoneActivity.access$000(this.this$0, null);
                }
                else {
                    PhoneActivity.access$000(this.this$0, ex);
                }
            }
            
            @Override
            protected void onSuccess(final PhoneVerification phoneVerification) {
                if (phoneVerification.isAutoVerified()) {
                    Toast.makeText((Context)this.this$0, R.string.fui_auto_verified, 1).show();
                    final FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
                    if (supportFragmentManager.k0("SubmitConfirmationCodeFragment") != null) {
                        supportFragmentManager.g1();
                    }
                }
                this.val$handler.startSignIn(phoneVerification.getCredential(), new IdpResponse.Builder(new User.Builder("phone", null).setPhoneNumber(phoneVerification.getNumber()).build()).build());
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((PhoneVerification)o);
            }
        });
        if (bundle != null) {
            return;
        }
        this.getSupportFragmentManager().q().r(R.id.fragment_phone, CheckPhoneNumberFragment.newInstance(this.getIntent().getExtras().getBundle("extra_params")), "VerifyPhoneFragment").m().i();
    }
    
    @Override
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mPhoneVerifier.onSaveInstanceState(bundle);
    }
    
    @Override
    public void showProgress(final int n) {
        this.getActiveFragment().showProgress(n);
    }
}
