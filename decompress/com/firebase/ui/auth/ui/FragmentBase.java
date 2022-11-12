// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui;

import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseUser;
import androidx.fragment.app.h;
import android.os.Bundle;
import com.firebase.ui.auth.data.model.FlowParameters;
import androidx.fragment.app.Fragment;

public abstract class FragmentBase extends Fragment implements ProgressView
{
    private HelperActivityBase mActivity;
    
    public FlowParameters getFlowParams() {
        return this.mActivity.getFlowParams();
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final h activity = this.getActivity();
        if (activity instanceof HelperActivityBase) {
            this.mActivity = (HelperActivityBase)activity;
            return;
        }
        throw new IllegalStateException("Cannot use this fragment without the helper activity");
    }
    
    public void startSaveCredentials(final FirebaseUser firebaseUser, final IdpResponse idpResponse, final String s) {
        this.mActivity.startSaveCredentials(firebaseUser, idpResponse, s);
    }
}
