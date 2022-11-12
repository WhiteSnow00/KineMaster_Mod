// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel.phone;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.AuthResult;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import com.google.firebase.auth.AuthCredential;
import android.app.Application;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;

public class PhoneProviderResponseHandler extends SignInViewModelBase
{
    public PhoneProviderResponseHandler(final Application application) {
        super(application);
    }
    
    static void access$000(final PhoneProviderResponseHandler phoneProviderResponseHandler, final AuthCredential authCredential) {
        phoneProviderResponseHandler.handleMergeFailure(authCredential);
    }
    
    static void access$100(final PhoneProviderResponseHandler phoneProviderResponseHandler, final Resource result) {
        phoneProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$200(final PhoneProviderResponseHandler phoneProviderResponseHandler, final IdpResponse idpResponse, final AuthResult authResult) {
        phoneProviderResponseHandler.handleSuccess(idpResponse, authResult);
    }
    
    public void startSignIn(final PhoneAuthCredential phoneAuthCredential, final IdpResponse idpResponse) {
        if (!idpResponse.isSuccessful()) {
            this.setResult(Resource.forFailure(idpResponse.getError()));
            return;
        }
        if (idpResponse.getProviderType().equals("phone")) {
            this.setResult(Resource.forLoading());
            AuthOperationManager.getInstance().signInAndLinkWithCredential(this.getAuth(), ((ViewModelBase<FlowParameters>)this).getArguments(), phoneAuthCredential).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, idpResponse) {
                final PhoneProviderResponseHandler this$0;
                final IdpResponse val$response;
                
                public void onSuccess(final AuthResult authResult) {
                    PhoneProviderResponseHandler.access$200(this.this$0, this.val$response, authResult);
                }
                
                public /* bridge */ void onSuccess(final Object o) {
                    this.onSuccess((AuthResult)o);
                }
            }).f((OnFailureListener)new OnFailureListener(this) {
                final PhoneProviderResponseHandler this$0;
                
                public void onFailure(final Exception ex) {
                    if (ex instanceof FirebaseAuthUserCollisionException) {
                        PhoneProviderResponseHandler.access$000(this.this$0, ((FirebaseAuthUserCollisionException)ex).getUpdatedCredential());
                    }
                    else {
                        PhoneProviderResponseHandler.access$100(this.this$0, Resource.forFailure(ex));
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("This handler cannot be used without a phone response.");
    }
}
