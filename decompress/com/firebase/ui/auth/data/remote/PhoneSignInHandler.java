// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.remote;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import android.content.Context;
import com.firebase.ui.auth.ui.phone.PhoneActivity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.google.firebase.auth.FirebaseAuth;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.IdpResponse;
import android.content.Intent;
import android.app.Application;
import com.firebase.ui.auth.AuthUI;

public class PhoneSignInHandler extends SingleProviderSignInHandler<AuthUI.IdpConfig>
{
    public PhoneSignInHandler(final Application application) {
        super(application, "phone");
    }
    
    @Override
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n == 107) {
            final IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
            if (fromResultIntent == null) {
                ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forFailure(new UserCancellationException()));
            }
            else {
                ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forSuccess(fromResultIntent));
            }
        }
    }
    
    @Override
    public void startSignIn(final FirebaseAuth firebaseAuth, final HelperActivityBase helperActivityBase, final String s) {
        helperActivityBase.startActivityForResult(PhoneActivity.createIntent((Context)helperActivityBase, helperActivityBase.getFlowParams(), ((AuthUI.IdpConfig)((ViewModelBase<AuthUI.IdpConfig>)this).getArguments()).getParams()), 107);
    }
}
