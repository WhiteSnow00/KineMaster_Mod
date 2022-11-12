// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import android.widget.LinearLayout;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import android.text.TextUtils;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import android.widget.TextView;
import com.firebase.ui.auth.util.ui.fieldvalidators.NoOpValidator;
import com.firebase.ui.auth.util.ui.fieldvalidators.RequiredFieldValidator;
import com.firebase.ui.auth.util.data.ProviderUtils;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import androidx.fragment.app.h;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.IdpResponse;
import android.view.View;
import android.os.Parcelable;
import android.os.Bundle;
import com.firebase.ui.auth.data.model.User;
import android.widget.ProgressBar;
import com.firebase.ui.auth.util.ui.fieldvalidators.PasswordFieldValidator;
import android.widget.Button;
import com.firebase.ui.auth.util.ui.fieldvalidators.BaseValidator;
import com.firebase.ui.auth.viewmodel.email.EmailProviderResponseHandler;
import com.google.android.material.textfield.TextInputLayout;
import com.firebase.ui.auth.util.ui.fieldvalidators.EmailFieldValidator;
import android.widget.EditText;
import com.firebase.ui.auth.util.ui.ImeHelper;
import android.view.View$OnFocusChangeListener;
import android.view.View$OnClickListener;
import com.firebase.ui.auth.ui.FragmentBase;

public class RegisterEmailFragment extends FragmentBase implements View$OnClickListener, View$OnFocusChangeListener, DonePressedListener
{
    public static final String TAG = "RegisterEmailFragment";
    private EditText mEmailEditText;
    private EmailFieldValidator mEmailFieldValidator;
    private TextInputLayout mEmailInput;
    private EmailProviderResponseHandler mHandler;
    private AnonymousUpgradeListener mListener;
    private EditText mNameEditText;
    private BaseValidator mNameValidator;
    private Button mNextButton;
    private EditText mPasswordEditText;
    private PasswordFieldValidator mPasswordFieldValidator;
    private TextInputLayout mPasswordInput;
    private ProgressBar mProgressBar;
    private User mUser;
    
    static EmailProviderResponseHandler access$000(final RegisterEmailFragment registerEmailFragment) {
        return registerEmailFragment.mHandler;
    }
    
    static EditText access$100(final RegisterEmailFragment registerEmailFragment) {
        return registerEmailFragment.mPasswordEditText;
    }
    
    static TextInputLayout access$200(final RegisterEmailFragment registerEmailFragment) {
        return registerEmailFragment.mPasswordInput;
    }
    
    static TextInputLayout access$300(final RegisterEmailFragment registerEmailFragment) {
        return registerEmailFragment.mEmailInput;
    }
    
    static AnonymousUpgradeListener access$400(final RegisterEmailFragment registerEmailFragment) {
        return registerEmailFragment.mListener;
    }
    
    public static RegisterEmailFragment newInstance(final User user) {
        final RegisterEmailFragment registerEmailFragment = new RegisterEmailFragment();
        final Bundle arguments = new Bundle();
        arguments.putParcelable("extra_user", (Parcelable)user);
        registerEmailFragment.setArguments(arguments);
        return registerEmailFragment;
    }
    
    private void safeRequestFocus(final View view) {
        view.post((Runnable)new Runnable(this, view) {
            final RegisterEmailFragment this$0;
            final View val$v;
            
            @Override
            public void run() {
                this.val$v.requestFocus();
            }
        });
    }
    
    private void validateAndRegisterUser() {
        final String string = this.mEmailEditText.getText().toString();
        final String string2 = this.mPasswordEditText.getText().toString();
        final String string3 = this.mNameEditText.getText().toString();
        final boolean validate = this.mEmailFieldValidator.validate(string);
        final boolean validate2 = this.mPasswordFieldValidator.validate(string2);
        final boolean validate3 = this.mNameValidator.validate(string3);
        if (validate && validate2 && validate3) {
            this.mHandler.startSignIn(new IdpResponse.Builder(new User.Builder("password", string).setName(string3).setPhotoUri(this.mUser.getPhotoUri()).build()).build(), string2);
        }
    }
    
    public void hideProgress() {
        this.mNextButton.setEnabled(true);
        this.mProgressBar.setVisibility(4);
    }
    
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        final h requireActivity = this.requireActivity();
        requireActivity.setTitle(R.string.fui_title_register_email);
        if (requireActivity instanceof AnonymousUpgradeListener) {
            this.mListener = (AnonymousUpgradeListener)requireActivity;
            return;
        }
        throw new IllegalStateException("Activity must implement CheckEmailListener");
    }
    
    public void onClick(final View view) {
        if (view.getId() == R.id.button_create) {
            this.validateAndRegisterUser();
        }
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.mUser = User.getUser(this.getArguments());
        }
        else {
            this.mUser = User.getUser(bundle);
        }
        (this.mHandler = new o0(this).a(EmailProviderResponseHandler.class)).init((I)this.getFlowParams());
        ((OperableViewModel<I, Resource<T>>)this.mHandler).getOperation().observe(this, (a0<? super Resource<T>>)new ResourceObserver<IdpResponse>(this, this, R.string.fui_progress_dialog_signing_up) {
            final RegisterEmailFragment this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
                if (ex instanceof FirebaseAuthWeakPasswordException) {
                    RegisterEmailFragment.access$200(this.this$0).setError((CharSequence)this.this$0.getResources().getQuantityString(R.plurals.fui_error_weak_password, R.integer.fui_min_password_length));
                }
                else if (ex instanceof FirebaseAuthInvalidCredentialsException) {
                    RegisterEmailFragment.access$300(this.this$0).setError((CharSequence)this.this$0.getString(R.string.fui_invalid_email_address));
                }
                else if (ex instanceof FirebaseAuthAnonymousUpgradeException) {
                    RegisterEmailFragment.access$400(this.this$0).onMergeFailure(((FirebaseAuthAnonymousUpgradeException)ex).getResponse());
                }
                else {
                    RegisterEmailFragment.access$300(this.this$0).setError((CharSequence)this.this$0.getString(R.string.fui_email_account_creation_error));
                }
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                final RegisterEmailFragment this$0 = this.this$0;
                this$0.startSaveCredentials(RegisterEmailFragment.access$000(this$0).getCurrentUser(), idpResponse, RegisterEmailFragment.access$100(this.this$0).getText().toString());
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_register_email_layout, viewGroup, false);
    }
    
    public void onDonePressed() {
        this.validateAndRegisterUser();
    }
    
    public void onFocusChange(final View view, final boolean b) {
        if (b) {
            return;
        }
        final int id = view.getId();
        if (id == R.id.email) {
            this.mEmailFieldValidator.validate((CharSequence)this.mEmailEditText.getText());
        }
        else if (id == R.id.name) {
            this.mNameValidator.validate((CharSequence)this.mNameEditText.getText());
        }
        else if (id == R.id.password) {
            this.mPasswordFieldValidator.validate((CharSequence)this.mPasswordEditText.getText());
        }
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        bundle.putParcelable("extra_user", (Parcelable)new User.Builder("password", this.mEmailEditText.getText().toString()).setName(this.mNameEditText.getText().toString()).setPhotoUri(this.mUser.getPhotoUri()).build());
    }
    
    public void onViewCreated(final View view, final Bundle bundle) {
        this.mNextButton = (Button)view.findViewById(R.id.button_create);
        this.mProgressBar = (ProgressBar)view.findViewById(R.id.top_progress_bar);
        this.mEmailEditText = (EditText)view.findViewById(R.id.email);
        this.mNameEditText = (EditText)view.findViewById(R.id.name);
        this.mPasswordEditText = (EditText)view.findViewById(R.id.password);
        this.mEmailInput = (TextInputLayout)view.findViewById(R.id.email_layout);
        this.mPasswordInput = (TextInputLayout)view.findViewById(R.id.password_layout);
        final TextInputLayout textInputLayout = (TextInputLayout)view.findViewById(R.id.name_layout);
        final boolean boolean1 = ProviderUtils.getConfigFromIdpsOrThrow(this.getFlowParams().providers, "password").getParams().getBoolean("extra_require_name", true);
        this.mPasswordFieldValidator = new PasswordFieldValidator(this.mPasswordInput, this.getResources().getInteger(R.integer.fui_min_password_length));
        BaseValidator mNameValidator;
        if (boolean1) {
            mNameValidator = new RequiredFieldValidator(textInputLayout, this.getResources().getString(R.string.fui_missing_first_and_last_name));
        }
        else {
            mNameValidator = new NoOpValidator(textInputLayout);
        }
        this.mNameValidator = mNameValidator;
        this.mEmailFieldValidator = new EmailFieldValidator(this.mEmailInput);
        ImeHelper.setImeOnDoneListener(this.mPasswordEditText, (ImeHelper.DonePressedListener)this);
        this.mEmailEditText.setOnFocusChangeListener((View$OnFocusChangeListener)this);
        this.mNameEditText.setOnFocusChangeListener((View$OnFocusChangeListener)this);
        this.mPasswordEditText.setOnFocusChangeListener((View$OnFocusChangeListener)this);
        this.mNextButton.setOnClickListener((View$OnClickListener)this);
        int visibility;
        if (boolean1) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        ((LinearLayout)textInputLayout).setVisibility(visibility);
        if (this.getFlowParams().enableCredentials) {
            this.mEmailEditText.setImportantForAutofill(2);
        }
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(this.requireContext(), this.getFlowParams(), (TextView)view.findViewById(R.id.email_footer_tos_and_pp_text));
        if (bundle != null) {
            return;
        }
        final String email = this.mUser.getEmail();
        if (!TextUtils.isEmpty((CharSequence)email)) {
            this.mEmailEditText.setText((CharSequence)email);
        }
        final String name = this.mUser.getName();
        if (!TextUtils.isEmpty((CharSequence)name)) {
            this.mNameEditText.setText((CharSequence)name);
        }
        if (boolean1 && TextUtils.isEmpty((CharSequence)this.mNameEditText.getText())) {
            if (!TextUtils.isEmpty((CharSequence)this.mEmailEditText.getText())) {
                this.safeRequestFocus((View)this.mNameEditText);
            }
            else {
                this.safeRequestFocus((View)this.mEmailEditText);
            }
        }
        else {
            this.safeRequestFocus((View)this.mPasswordEditText);
        }
    }
    
    public void showProgress(final int n) {
        this.mNextButton.setEnabled(false);
        this.mProgressBar.setVisibility(0);
    }
    
    interface AnonymousUpgradeListener
    {
        void onMergeFailure(final IdpResponse p0);
    }
}
