// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import android.os.Bundle;
import android.view.View;
import com.firebase.ui.auth.util.data.PrivacyDisclosureUtils;
import com.firebase.ui.auth.util.ui.TextHelper;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.firebase.ui.auth.R;
import android.os.Parcelable;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import android.widget.Button;
import android.widget.ProgressBar;
import com.firebase.ui.auth.IdpResponse;
import android.view.View$OnClickListener;
import com.firebase.ui.auth.ui.AppCompatBase;

public class WelcomeBackEmailLinkPrompt extends AppCompatBase implements View$OnClickListener
{
    private IdpResponse mIdpResponseForLinking;
    private ProgressBar mProgressBar;
    private Button mSignInButton;
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters, final IdpResponse idpResponse) {
        return HelperActivityBase.createBaseIntent(context, WelcomeBackEmailLinkPrompt.class, flowParameters).putExtra("extra_idp_response", (Parcelable)idpResponse);
    }
    
    private void initializeViewObjects() {
        this.mSignInButton = this.findViewById(R.id.button_sign_in);
        this.mProgressBar = this.findViewById(R.id.top_progress_bar);
    }
    
    private void setBodyText() {
        final TextView textView = this.findViewById(R.id.welcome_back_email_link_body);
        final String string = this.getString(R.string.fui_welcome_back_email_link_prompt_body, new Object[] { this.mIdpResponseForLinking.getEmail(), this.mIdpResponseForLinking.getProviderType() });
        final SpannableStringBuilder text = new SpannableStringBuilder((CharSequence)string);
        TextHelper.boldAllOccurencesOfText(text, string, this.mIdpResponseForLinking.getEmail());
        TextHelper.boldAllOccurencesOfText(text, string, this.mIdpResponseForLinking.getProviderType());
        textView.setText((CharSequence)text);
        textView.setJustificationMode(1);
    }
    
    private void setOnClickListeners() {
        this.mSignInButton.setOnClickListener((View$OnClickListener)this);
    }
    
    private void setPrivacyFooter() {
        PrivacyDisclosureUtils.setupTermsOfServiceFooter((Context)this, this.getFlowParams(), this.findViewById(R.id.email_footer_tos_and_pp_text));
    }
    
    private void startEmailLinkFlow() {
        this.startActivityForResult(EmailActivity.createIntentForLinking((Context)this, this.getFlowParams(), this.mIdpResponseForLinking), 112);
    }
    
    public void hideProgress() {
        this.mProgressBar.setEnabled(true);
        this.mProgressBar.setVisibility(4);
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        this.finish(n2, intent);
    }
    
    public void onClick(final View view) {
        if (view.getId() == R.id.button_sign_in) {
            this.startEmailLinkFlow();
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.fui_welcome_back_email_link_prompt_layout);
        this.mIdpResponseForLinking = IdpResponse.fromResultIntent(this.getIntent());
        this.initializeViewObjects();
        this.setBodyText();
        this.setOnClickListeners();
        this.setPrivacyFooter();
    }
    
    public void showProgress(final int n) {
        this.mSignInButton.setEnabled(false);
        this.mProgressBar.setVisibility(0);
    }
}
