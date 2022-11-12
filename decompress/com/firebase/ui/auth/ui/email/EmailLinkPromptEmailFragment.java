// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import android.widget.LinearLayout;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import com.firebase.ui.auth.R;
import android.view.View;
import androidx.fragment.app.h;
import android.os.Bundle;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import android.widget.ProgressBar;
import android.widget.Button;
import com.firebase.ui.auth.viewmodel.email.EmailLinkSignInHandler;
import com.google.android.material.textfield.TextInputLayout;
import com.firebase.ui.auth.util.ui.fieldvalidators.EmailFieldValidator;
import android.widget.EditText;
import android.view.View$OnClickListener;
import com.firebase.ui.auth.ui.FragmentBase;

public class EmailLinkPromptEmailFragment extends FragmentBase implements View$OnClickListener
{
    public static final String TAG = "EmailLinkPromptEmailFragment";
    private EditText mEmailEditText;
    private EmailFieldValidator mEmailFieldValidator;
    private TextInputLayout mEmailLayout;
    private EmailLinkSignInHandler mHandler;
    private EmailLinkPromptEmailListener mListener;
    private Button mNextButton;
    private ProgressBar mProgressBar;
    
    static EmailLinkPromptEmailListener access$000(final EmailLinkPromptEmailFragment emailLinkPromptEmailFragment) {
        return emailLinkPromptEmailFragment.mListener;
    }
    
    static TextInputLayout access$100(final EmailLinkPromptEmailFragment emailLinkPromptEmailFragment) {
        return emailLinkPromptEmailFragment.mEmailLayout;
    }
    
    private void initHandler() {
        (this.mHandler = new o0(this).a(EmailLinkSignInHandler.class)).init((I)this.getFlowParams());
        ((OperableViewModel<I, Resource<T>>)this.mHandler).getOperation().observe(this.getViewLifecycleOwner(), (a0<? super Resource<T>>)new ResourceObserver<IdpResponse>(this, this) {
            final EmailLinkPromptEmailFragment this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
                EmailLinkPromptEmailFragment.access$100(this.this$0).setError((CharSequence)ex.getMessage());
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                EmailLinkPromptEmailFragment.access$000(this.this$0).onEmailPromptSuccess(idpResponse);
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
    }
    
    public static EmailLinkPromptEmailFragment newInstance() {
        return new EmailLinkPromptEmailFragment();
    }
    
    private void validateEmailAndFinishSignIn() {
        final String string = this.mEmailEditText.getText().toString();
        if (this.mEmailFieldValidator.validate(string)) {
            this.mHandler.finishSignIn(string);
        }
    }
    
    public void hideProgress() {
        this.mNextButton.setEnabled(true);
        this.mProgressBar.setVisibility(4);
    }
    
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        final h activity = this.getActivity();
        if (activity instanceof EmailLinkPromptEmailListener) {
            this.mListener = (EmailLinkPromptEmailListener)activity;
            this.initHandler();
            return;
        }
        throw new IllegalStateException("Activity must implement EmailLinkPromptEmailListener");
    }
    
    public void onClick(final View view) {
        final int id = view.getId();
        if (id == R.id.button_next) {
            this.validateEmailAndFinishSignIn();
        }
        else if (id == R.id.email_layout || id == R.id.email) {
            this.mEmailLayout.setError((CharSequence)null);
        }
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_check_email_layout, viewGroup, false);
    }
    
    public void onViewCreated(final View view, final Bundle bundle) {
        this.mNextButton = (Button)view.findViewById(R.id.button_next);
        this.mProgressBar = (ProgressBar)view.findViewById(R.id.top_progress_bar);
        this.mNextButton.setOnClickListener((View$OnClickListener)this);
        this.mEmailLayout = (TextInputLayout)view.findViewById(R.id.email_layout);
        this.mEmailEditText = (EditText)view.findViewById(R.id.email);
        this.mEmailFieldValidator = new EmailFieldValidator(this.mEmailLayout);
        ((LinearLayout)this.mEmailLayout).setOnClickListener((View$OnClickListener)this);
        this.mEmailEditText.setOnClickListener((View$OnClickListener)this);
        this.getActivity().setTitle(R.string.fui_email_link_confirm_email_header);
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(this.requireContext(), this.getFlowParams(), (TextView)view.findViewById(R.id.email_footer_tos_and_pp_text));
    }
    
    public void showProgress(final int n) {
        this.mNextButton.setEnabled(false);
        this.mProgressBar.setVisibility(0);
    }
    
    interface EmailLinkPromptEmailListener
    {
        void onEmailPromptSuccess(final IdpResponse p0);
    }
}
