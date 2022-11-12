// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.fragment.app.h;
import android.content.Context;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import android.widget.TextView;
import com.firebase.ui.auth.R;
import android.view.View;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.view.View$OnClickListener;
import com.firebase.ui.auth.ui.FragmentBase;

public class TroubleSigningInFragment extends FragmentBase implements View$OnClickListener
{
    public static final String TAG = "TroubleSigningInFragment";
    private String mEmail;
    private ResendEmailListener mListener;
    private ProgressBar mProgressBar;
    
    public static TroubleSigningInFragment newInstance(final String s) {
        final TroubleSigningInFragment troubleSigningInFragment = new TroubleSigningInFragment();
        final Bundle arguments = new Bundle();
        arguments.putString("extra_email", s);
        troubleSigningInFragment.setArguments(arguments);
        return troubleSigningInFragment;
    }
    
    private void setOnClickListeners(final View view) {
        view.findViewById(R.id.button_resend_email).setOnClickListener((View$OnClickListener)this);
    }
    
    private void setPrivacyFooter(final View view) {
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(this.requireContext(), this.getFlowParams(), (TextView)view.findViewById(R.id.email_footer_tos_and_pp_text));
    }
    
    public void hideProgress() {
        this.mProgressBar.setVisibility(4);
    }
    
    public void onAttach(final Context context) {
        super.onAttach(context);
        final h activity = this.getActivity();
        if (activity instanceof ResendEmailListener) {
            this.mListener = (ResendEmailListener)activity;
            return;
        }
        throw new IllegalStateException("Activity must implement ResendEmailListener");
    }
    
    public void onClick(final View view) {
        if (view.getId() == R.id.button_resend_email) {
            this.mListener.onClickResendEmail(this.mEmail);
        }
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_email_link_trouble_signing_in_layout, viewGroup, false);
    }
    
    public void onViewCreated(final View view, final Bundle bundle) {
        this.mProgressBar = (ProgressBar)view.findViewById(R.id.top_progress_bar);
        this.mEmail = this.getArguments().getString("extra_email");
        this.setOnClickListeners(view);
        this.setPrivacyFooter(view);
    }
    
    public void showProgress(final int n) {
        this.mProgressBar.setVisibility(0);
    }
    
    interface ResendEmailListener
    {
        void onClickResendEmail(final String p0);
    }
}
