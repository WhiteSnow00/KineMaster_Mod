// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.AuthCredential;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import android.app.Application;
import com.firebase.ui.auth.IdpResponse;

public abstract class SignInViewModelBase extends AuthViewModelBase<IdpResponse>
{
    protected SignInViewModelBase(final Application application) {
        super(application);
    }
    
    protected void handleMergeFailure(final IdpResponse idpResponse) {
        this.setResult(Resource.forFailure(new FirebaseAuthAnonymousUpgradeException(5, idpResponse)));
    }
    
    protected void handleMergeFailure(final AuthCredential pendingCredential) {
        this.handleMergeFailure(new IdpResponse.Builder().setPendingCredential(pendingCredential).build());
    }
    
    protected void handleSuccess(final IdpResponse idpResponse, final AuthResult authResult) {
        this.setResult(Resource.forSuccess(idpResponse.withResult(authResult)));
    }
    
    @Override
    protected void setResult(final Resource<IdpResponse> result) {
        super.setResult((Resource<T>)result);
    }
    
    @Override
    protected /* bridge */ void setResult(final Object o) {
        this.setResult((Resource<IdpResponse>)o);
    }
}
