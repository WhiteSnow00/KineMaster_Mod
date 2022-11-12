// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.fragment.app.h;
import android.content.Context;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import android.view.View$OnClickListener;
import com.firebase.ui.auth.util.ui.TextHelper;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import android.view.View;
import android.os.Parcelable;
import android.os.Bundle;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.ActionCodeSettings;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import android.util.Log;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import com.firebase.ui.auth.R;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import android.widget.ScrollView;
import com.firebase.ui.auth.viewmodel.email.EmailLinkSendEmailHandler;
import com.firebase.ui.auth.ui.InvisibleFragmentBase;

public class EmailLinkFragment extends InvisibleFragmentBase
{
    private static final String EMAIL_SENT = "emailSent";
    public static final String TAG = "EmailLinkFragment";
    private EmailLinkSendEmailHandler mEmailLinkSendEmailHandler;
    private boolean mEmailSent;
    private TroubleSigningInListener mListener;
    private ScrollView mTopLevelView;
    
    static ScrollView access$000(final EmailLinkFragment emailLinkFragment) {
        return emailLinkFragment.mTopLevelView;
    }
    
    static void access$100(final EmailLinkFragment emailLinkFragment, final Runnable runnable) {
        emailLinkFragment.doAfterTimeout(runnable);
    }
    
    static boolean access$202(final EmailLinkFragment emailLinkFragment, final boolean mEmailSent) {
        return emailLinkFragment.mEmailSent = mEmailSent;
    }
    
    static TroubleSigningInListener access$300(final EmailLinkFragment emailLinkFragment) {
        return emailLinkFragment.mListener;
    }
    
    private void initHandler() {
        (this.mEmailLinkSendEmailHandler = new o0(this).a(EmailLinkSendEmailHandler.class)).init((I)this.getFlowParams());
        ((OperableViewModel<I, Resource<T>>)this.mEmailLinkSendEmailHandler).getOperation().observe(this.getViewLifecycleOwner(), (a0<? super Resource<T>>)new ResourceObserver<String>(this, this, R.string.fui_progress_dialog_sending) {
            final EmailLinkFragment this$0;
            
            @Override
            protected void onFailure(final Exception ex) {
                EmailLinkFragment.access$300(this.this$0).onSendEmailFailure(ex);
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((String)o);
            }
            
            @Override
            protected void onSuccess(final String s) {
                Log.w("EmailLinkFragment", "Email for email link sign in sent successfully.");
                EmailLinkFragment.access$100(this.this$0, new Runnable(this) {
                    final EmailLinkFragment$1 this$1;
                    
                    @Override
                    public void run() {
                        EmailLinkFragment.access$000(this.this$1.this$0).setVisibility(0);
                    }
                });
                EmailLinkFragment.access$202(this.this$0, true);
            }
        });
    }
    
    public static EmailLinkFragment newInstance(final String s, final ActionCodeSettings actionCodeSettings) {
        return newInstance(s, actionCodeSettings, null, false);
    }
    
    public static EmailLinkFragment newInstance(final String s, final ActionCodeSettings actionCodeSettings, final IdpResponse idpResponse, final boolean b) {
        final EmailLinkFragment emailLinkFragment = new EmailLinkFragment();
        final Bundle arguments = new Bundle();
        arguments.putString("extra_email", s);
        arguments.putParcelable("action_code_settings", (Parcelable)actionCodeSettings);
        arguments.putParcelable("extra_idp_response", (Parcelable)idpResponse);
        arguments.putBoolean("force_same_device", b);
        emailLinkFragment.setArguments(arguments);
        return emailLinkFragment;
    }
    
    private void setBodyText(final View view, final String s) {
        final TextView textView = (TextView)view.findViewById(R.id.sign_in_email_sent_text);
        final String string = this.getString(R.string.fui_email_link_email_sent, s);
        final SpannableStringBuilder text = new SpannableStringBuilder((CharSequence)string);
        TextHelper.boldAllOccurencesOfText(text, string, s);
        textView.setText((CharSequence)text);
    }
    
    private void setOnClickListeners(final View view, final String s) {
        view.findViewById(R.id.trouble_signing_in).setOnClickListener((View$OnClickListener)new View$OnClickListener(this, s) {
            final EmailLinkFragment this$0;
            final String val$email;
            
            public void onClick(final View view) {
                EmailLinkFragment.access$300(this.this$0).onTroubleSigningIn(this.val$email);
            }
        });
    }
    
    private void setPrivacyFooter(final View view) {
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(this.requireContext(), this.getFlowParams(), (TextView)view.findViewById(R.id.email_footer_tos_and_pp_text));
    }
    
    @Override
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        this.initHandler();
        final String string = this.getArguments().getString("extra_email");
        final ActionCodeSettings actionCodeSettings = (ActionCodeSettings)this.getArguments().getParcelable("action_code_settings");
        final IdpResponse idpResponse = (IdpResponse)this.getArguments().getParcelable("extra_idp_response");
        final boolean boolean1 = this.getArguments().getBoolean("force_same_device");
        if (!this.mEmailSent) {
            this.mEmailLinkSendEmailHandler.sendSignInLinkToEmail(string, actionCodeSettings, idpResponse, boolean1);
        }
    }
    
    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        final h activity = this.getActivity();
        if (activity instanceof TroubleSigningInListener) {
            this.mListener = (TroubleSigningInListener)activity;
            return;
        }
        throw new IllegalStateException("Activity must implement TroubleSigningInListener");
    }
    
    @Override
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_email_link_sign_in_layout, viewGroup, false);
    }
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("emailSent", this.mEmailSent);
    }
    
    @Override
    public void onViewCreated(final View privacyFooter, final Bundle bundle) {
        super.onViewCreated(privacyFooter, bundle);
        if (bundle != null) {
            this.mEmailSent = bundle.getBoolean("emailSent");
        }
        final ScrollView mTopLevelView = (ScrollView)privacyFooter.findViewById(R.id.top_level_view);
        this.mTopLevelView = mTopLevelView;
        if (!this.mEmailSent) {
            mTopLevelView.setVisibility(8);
        }
        final String string = this.getArguments().getString("extra_email");
        this.setBodyText(privacyFooter, string);
        this.setOnClickListeners(privacyFooter, string);
        this.setPrivacyFooter(privacyFooter);
    }
    
    interface TroubleSigningInListener
    {
        void onSendEmailFailure(final Exception p0);
        
        void onTroubleSigningIn(final String p0);
    }
}
