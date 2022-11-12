// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel.smartlock;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.google.firebase.auth.FirebaseUser;
import com.firebase.ui.auth.data.model.PendingIntentRequiredException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.google.android.gms.auth.api.credentials.Credential;
import com.firebase.ui.auth.FirebaseUiException;
import android.util.Log;
import com.firebase.ui.auth.util.CredentialUtils;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.util.GoogleApiUtils;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;

public class SmartLockHandler extends AuthViewModelBase<IdpResponse>
{
    private static final String TAG = "SmartLockViewModel";
    private IdpResponse mResponse;
    
    public SmartLockHandler(final Application application) {
        super(application);
    }
    
    static IdpResponse access$000(final SmartLockHandler smartLockHandler) {
        return smartLockHandler.mResponse;
    }
    
    static void access$100(final SmartLockHandler smartLockHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)smartLockHandler).setResult((Resource<T>)result);
    }
    
    static void access$200(final SmartLockHandler smartLockHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)smartLockHandler).setResult((Resource<T>)result);
    }
    
    static void access$300(final SmartLockHandler smartLockHandler, final Object result) {
        ((OperableViewModel<I, Resource<T>>)smartLockHandler).setResult((Resource<T>)result);
    }
    
    private void deleteUnusedCredentials() {
        if (this.mResponse.getProviderType().equals("google.com")) {
            GoogleApiUtils.getCredentialsClient(this.getApplication()).b(CredentialUtils.buildCredentialOrThrow(this.getCurrentUser(), "pass", ProviderUtils.providerIdToAccountType("google.com")));
        }
    }
    
    public void onActivityResult(final int n, final int n2) {
        if (n == 100) {
            if (n2 == -1) {
                ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forSuccess((T)this.mResponse));
            }
            else {
                Log.e("SmartLockViewModel", "SAVE: Canceled by user.");
                ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forFailure(new FirebaseUiException(0, "Save canceled by user.")));
            }
        }
    }
    
    public void saveCredentials(final Credential credential) {
        if (!((ViewModelBase<FlowParameters>)this).getArguments().enableCredentials) {
            ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forSuccess((T)this.mResponse));
            return;
        }
        ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forLoading());
        if (credential == null) {
            ((OperableViewModel<I, Resource<T>>)this).setResult(Resource.forFailure(new FirebaseUiException(0, "Failed to build credential.")));
            return;
        }
        this.deleteUnusedCredentials();
        this.getCredentialsClient().f(credential).c((OnCompleteListener)new OnCompleteListener<Void>(this) {
            final SmartLockHandler this$0;
            
            public void onComplete(final Task<Void> task) {
                if (task.t()) {
                    final SmartLockHandler this$0 = this.this$0;
                    SmartLockHandler.access$100(this$0, Resource.forSuccess(SmartLockHandler.access$000(this$0)));
                }
                else if (task.o() instanceof ResolvableApiException) {
                    SmartLockHandler.access$200(this.this$0, Resource.forFailure(new PendingIntentRequiredException(((ResolvableApiException)task.o()).getResolution(), 100)));
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Non-resolvable exception: ");
                    sb.append(task.o());
                    Log.w("SmartLockViewModel", sb.toString());
                    SmartLockHandler.access$300(this.this$0, Resource.forFailure(new FirebaseUiException(0, "Error when saving credential.", task.o())));
                }
            }
        });
    }
    
    public void saveCredentials(final FirebaseUser firebaseUser, final String s, final String s2) {
        this.saveCredentials(CredentialUtils.buildCredential(firebaseUser, s, s2));
    }
    
    public void setResponse(final IdpResponse mResponse) {
        this.mResponse = mResponse;
    }
}
