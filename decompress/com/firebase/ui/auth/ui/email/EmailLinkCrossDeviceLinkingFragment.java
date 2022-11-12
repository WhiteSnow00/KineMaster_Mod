// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.ui.TextHelper;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.util.data.EmailLinkParser;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import com.firebase.ui.auth.R;
import android.view.View;
import androidx.fragment.app.h;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Button;
import android.view.View$OnClickListener;
import com.firebase.ui.auth.ui.FragmentBase;

public class EmailLinkCrossDeviceLinkingFragment extends FragmentBase implements View$OnClickListener
{
    public static final String TAG = "CrossDeviceFragment";
    private Button mContinueButton;
    private FinishEmailLinkSignInListener mListener;
    private ProgressBar mProgressBar;
    
    public static EmailLinkCrossDeviceLinkingFragment newInstance() {
        return new EmailLinkCrossDeviceLinkingFragment();
    }
    
    public void hideProgress() {
        this.mProgressBar.setVisibility(4);
    }
    
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        final h activity = this.getActivity();
        if (activity instanceof FinishEmailLinkSignInListener) {
            this.mListener = (FinishEmailLinkSignInListener)activity;
            return;
        }
        throw new IllegalStateException("Activity must implement EmailLinkPromptEmailListener");
    }
    
    public void onClick(final View view) {
        if (view.getId() == R.id.button_continue) {
            this.mListener.completeCrossDeviceEmailLinkFlow();
        }
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return layoutInflater.inflate(R.layout.fui_email_link_cross_device_linking, viewGroup, false);
    }
    
    public void onViewCreated(final View view, final Bundle bundle) {
        this.mProgressBar = (ProgressBar)view.findViewById(R.id.top_progress_bar);
        (this.mContinueButton = (Button)view.findViewById(R.id.button_continue)).setOnClickListener((View$OnClickListener)this);
        final String providerIdToProviderName = ProviderUtils.providerIdToProviderName(new EmailLinkParser(this.getFlowParams().emailLink).getProviderId());
        final TextView textView = (TextView)view.findViewById(R.id.cross_device_linking_body);
        final String string = this.getString(R.string.fui_email_link_cross_device_linking_text, new Object[] { providerIdToProviderName });
        final SpannableStringBuilder text = new SpannableStringBuilder((CharSequence)string);
        TextHelper.boldAllOccurencesOfText(text, string, providerIdToProviderName);
        textView.setText((CharSequence)text);
        textView.setJustificationMode(1);
        PrivacyDisclosureUtils.setupTermsOfServiceFooter(this.requireContext(), this.getFlowParams(), (TextView)view.findViewById(R.id.email_footer_tos_and_pp_text));
    }
    
    public void showProgress(final int n) {
        this.mProgressBar.setVisibility(0);
    }
    
    interface FinishEmailLinkSignInListener
    {
        void completeCrossDeviceEmailLinkFlow();
    }
}
