// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.email;

import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ui.FragmentBase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.firebase.ui.auth.R;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import com.firebase.ui.auth.ui.AppCompatBase;

public class EmailLinkErrorRecoveryActivity extends AppCompatBase implements EmailLinkPromptEmailListener, FinishEmailLinkSignInListener
{
    private static final String RECOVERY_TYPE_KEY = "com.firebase.ui.auth.ui.email.recoveryTypeKey";
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters, final int n) {
        return HelperActivityBase.createBaseIntent(context, EmailLinkErrorRecoveryActivity.class, flowParameters).putExtra("com.firebase.ui.auth.ui.email.recoveryTypeKey", n);
    }
    
    @Override
    public void completeCrossDeviceEmailLinkFlow() {
        this.switchFragment(EmailLinkPromptEmailFragment.newInstance(), R.id.fragment_register_email, "CrossDeviceFragment", true, true);
    }
    
    @Override
    public void hideProgress() {
        throw new UnsupportedOperationException("Fragments must handle progress updates.");
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.fui_activity_register_email);
        if (bundle != null) {
            return;
        }
        FragmentBase fragmentBase;
        if (this.getIntent().getIntExtra("com.firebase.ui.auth.ui.email.recoveryTypeKey", -1) == 116) {
            fragmentBase = EmailLinkCrossDeviceLinkingFragment.newInstance();
        }
        else {
            fragmentBase = EmailLinkPromptEmailFragment.newInstance();
        }
        this.switchFragment(fragmentBase, R.id.fragment_register_email, "EmailLinkPromptEmailFragment");
    }
    
    @Override
    public void onEmailPromptSuccess(final IdpResponse idpResponse) {
        this.finish(-1, idpResponse.toIntent());
    }
    
    @Override
    public void showProgress(final int n) {
        throw new UnsupportedOperationException("Fragments must handle progress updates.");
    }
}
