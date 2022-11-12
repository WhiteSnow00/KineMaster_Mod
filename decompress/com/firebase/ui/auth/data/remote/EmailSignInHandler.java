// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.remote;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import android.content.Context;
import com.firebase.ui.auth.ui.email.EmailActivity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.google.firebase.auth.FirebaseAuth;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.IdpResponse;
import android.content.Intent;
import android.app.Application;

public class EmailSignInHandler extends SingleProviderSignInHandler<Void>
{
    public EmailSignInHandler(final Application application) {
        super(application, "password");
    }
    
    @Override
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n2 != 5) {
            if (n == 106) {
                final IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
                if (fromResultIntent == null) {
                    ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forFailure(new UserCancellationException()));
                }
                else {
                    ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forSuccess(fromResultIntent));
                }
            }
        }
    }
    
    @Override
    public void startSignIn(final FirebaseAuth firebaseAuth, final HelperActivityBase helperActivityBase, final String s) {
        helperActivityBase.startActivityForResult(EmailActivity.createIntent((Context)helperActivityBase, helperActivityBase.getFlowParams()), 106);
    }
}
