// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import android.widget.LinearLayout;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Intent;
import androidx.fragment.app.h;
import android.text.TextUtils;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseNetworkException;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.R;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Button;
import com.google.android.material.textfield.TextInputLayout;
import com.firebase.ui.auth.util.ui.fieldvalidators.EmailFieldValidator;
import android.widget.EditText;
import com.firebase.ui.auth.util.ui.ImeHelper;
import android.view.View$OnClickListener;
import com.firebase.ui.auth.ui.FragmentBase;

public class CheckEmailFragment extends FragmentBase implements View$OnClickListener, DonePressedListener
{
    public static final String TAG = "CheckEmailFragment";
    private EditText mEmailEditText;
    private EmailFieldValidator mEmailFieldValidator;
    private TextInputLayout mEmailLayout;
    private CheckEmailHandler mHandler;
    private CheckEmailListener mListener;
    private Button mNextButton;
    private ProgressBar mProgressBar;
    
    static EditText access$000(final CheckEmailFragment checkEmailFragment) {
        return checkEmailFragment.mEmailEditText;
    }
    
    static CheckEmailListener access$100(final CheckEmailFragment checkEmailFragment) {
        return checkEmailFragment.mListener;
    }
    
    public static CheckEmailFragment newInstance(final String s) {
        final CheckEmailFragment checkEmailFragment = new CheckEmailFragment();
        final Bundle arguments = new Bundle();
        arguments.putString("extra_email", s);
        checkEmailFragment.setArguments(arguments);
        return checkEmailFragment;
    }
    
    private void validateAndProceed() {
        final String string = this.mEmailEditText.getText().toString();
        if (this.mEmailFieldValidator.validate(string)) {
            this.mHandler.fetchProvider(string);
        }
    }
    
    public void hideProgress() {
        this.mNextButton.setEnabled(true);
        this.mProgressBar.setVisibility(4);
    }
    
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        (this.mHandler = new o0(this).a(CheckEmailHandler.class)).init((I)this.getFlowParams());
        final h activity = this.getActivity();
        if (!(activity instanceof CheckEmailListener)) {
            throw new IllegalStateException("Activity must implement CheckEmailListener");
        }
        this.mListener = (CheckEmailListener)activity;
        ((OperableViewModel<I, Resource<T>>)this.mHandler).getOperation().observe(this.getViewLifecycleOwner(), (a0<? super Resource<T>>)new ResourceObserver<User>(this, this, R.string.fui_progress_dialog_checking_accounts) {
            final CheckEmailFragment this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
                if (ex instanceof FirebaseUiException && ((FirebaseUiException)ex).getErrorCode() == 3) {
                    CheckEmailFragment.access$100(this.this$0).onDeveloperFailure(ex);
                }
                if (ex instanceof FirebaseNetworkException) {
                    Snackbar.e(this.this$0.getView(), (CharSequence)this.this$0.getString(R.string.fui_no_internet), -1).show();
                }
            }
            
            @Override
            protected void onSuccess(final User user) {
                final String email = user.getEmail();
                final String providerId = user.getProviderId();
                CheckEmailFragment.access$000(this.this$0).setText((CharSequence)email);
                if (providerId == null) {
                    CheckEmailFragment.access$100(this.this$0).onNewUser(new User.Builder("password", email).setName(user.getName()).setPhotoUri(user.getPhotoUri()).build());
                }
                else if (!providerId.equals("password") && !providerId.equals("emailLink")) {
                    CheckEmailFragment.access$100(this.this$0).onExistingIdpUser(user);
                }
                else {
                    CheckEmailFragment.access$100(this.this$0).onExistingEmailUser(user);
                }
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((User)o);
            }
        });
        if (bundle != null) {
            return;
        }
        final String string = this.getArguments().getString("extra_email");
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.mEmailEditText.setText((CharSequence)string);
            this.validateAndProceed();
        }
        else if (this.getFlowParams().enableHints) {
            this.mHandler.fetchCredential();
        }
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        this.mHandler.onActivityResult(n, n2, intent);
    }
    
    public void onClick(final View view) {
        final int id = view.getId();
        if (id == R.id.button_next) {
            this.validateAndProceed();
        }
        else if (id == R.id.email_layout || id == R.id.email) {
            this.mEmailLayout.setError((CharSequence)null);
        }
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_check_email_layout, viewGroup, false);
    }
    
    public void onDonePressed() {
        this.validateAndProceed();
    }
    
    public void onViewCreated(final View view, final Bundle bundle) {
        this.mNextButton = (Button)view.findViewById(R.id.button_next);
        this.mProgressBar = (ProgressBar)view.findViewById(R.id.top_progress_bar);
        this.mEmailLayout = (TextInputLayout)view.findViewById(R.id.email_layout);
        this.mEmailEditText = (EditText)view.findViewById(R.id.email);
        this.mEmailFieldValidator = new EmailFieldValidator(this.mEmailLayout);
        ((LinearLayout)this.mEmailLayout).setOnClickListener((View$OnClickListener)this);
        this.mEmailEditText.setOnClickListener((View$OnClickListener)this);
        final TextView textView = (TextView)view.findViewById(R.id.header_text);
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImeHelper.setImeOnDoneListener(this.mEmailEditText, (ImeHelper.DonePressedListener)this);
        if (this.getFlowParams().enableHints) {
            this.mEmailEditText.setImportantForAutofill(2);
        }
        this.mNextButton.setOnClickListener((View$OnClickListener)this);
        final TextView textView2 = (TextView)view.findViewById(R.id.email_tos_and_pp_text);
        final TextView textView3 = (TextView)view.findViewById(R.id.email_footer_tos_and_pp_text);
        final FlowParameters flowParams = this.getFlowParams();
        if (!flowParams.shouldShowProviderChoice()) {
            PrivacyDisclosureUtils.setupTermsOfServiceAndPrivacyPolicyText(this.requireContext(), flowParams, textView2);
        }
        else {
            textView2.setVisibility(8);
            PrivacyDisclosureUtils.setupTermsOfServiceFooter(this.requireContext(), flowParams, textView3);
        }
    }
    
    public void showProgress(final int n) {
        this.mNextButton.setEnabled(false);
        this.mProgressBar.setVisibility(0);
    }
    
    interface CheckEmailListener
    {
        void onDeveloperFailure(final Exception p0);
        
        void onExistingEmailUser(final User p0);
        
        void onExistingIdpUser(final User p0);
        
        void onNewUser(final User p0);
    }
}
