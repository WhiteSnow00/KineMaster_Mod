// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel.idp;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Continuation;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.firebase.ui.auth.FirebaseUiException;
import android.text.TextUtils;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.data.model.Resource;
import com.google.firebase.auth.AuthResult;
import com.firebase.ui.auth.IdpResponse;
import android.app.Application;
import com.google.firebase.auth.AuthCredential;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;

public class LinkingSocialProviderResponseHandler extends SignInViewModelBase
{
    private String mEmail;
    private AuthCredential mRequestedSignInCredential;
    
    public LinkingSocialProviderResponseHandler(final Application application) {
        super(application);
    }
    
    static void access$000(final LinkingSocialProviderResponseHandler linkingSocialProviderResponseHandler, final IdpResponse idpResponse, final AuthResult authResult) {
        linkingSocialProviderResponseHandler.handleSuccess(idpResponse, authResult);
    }
    
    static void access$100(final LinkingSocialProviderResponseHandler linkingSocialProviderResponseHandler, final Resource result) {
        linkingSocialProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$200(final LinkingSocialProviderResponseHandler linkingSocialProviderResponseHandler, final AuthCredential authCredential) {
        linkingSocialProviderResponseHandler.handleMergeFailure(authCredential);
    }
    
    static void access$300(final LinkingSocialProviderResponseHandler linkingSocialProviderResponseHandler, final IdpResponse idpResponse, final AuthResult authResult) {
        linkingSocialProviderResponseHandler.handleSuccess(idpResponse, authResult);
    }
    
    static void access$400(final LinkingSocialProviderResponseHandler linkingSocialProviderResponseHandler, final Resource result) {
        linkingSocialProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static AuthCredential access$500(final LinkingSocialProviderResponseHandler linkingSocialProviderResponseHandler) {
        return linkingSocialProviderResponseHandler.mRequestedSignInCredential;
    }
    
    private boolean isGenericIdpLinkingFlow(final String s) {
        return AuthUI.SUPPORTED_OAUTH_PROVIDERS.contains(s) && this.mRequestedSignInCredential != null && this.getAuth().h() != null && !this.getAuth().h().T1();
    }
    
    private boolean isInvalidProvider(final String s) {
        return TextUtils.equals((CharSequence)s, (CharSequence)"password") || TextUtils.equals((CharSequence)s, (CharSequence)"phone");
    }
    
    public boolean hasCredentialForLinking() {
        return this.mRequestedSignInCredential != null;
    }
    
    public void setRequestedSignInCredentialForEmail(final AuthCredential mRequestedSignInCredential, final String mEmail) {
        this.mRequestedSignInCredential = mRequestedSignInCredential;
        this.mEmail = mEmail;
    }
    
    public void startSignIn(final IdpResponse idpResponse) {
        if (!idpResponse.isSuccessful()) {
            this.setResult(Resource.forFailure(idpResponse.getError()));
            return;
        }
        if (this.isInvalidProvider(idpResponse.getProviderType())) {
            throw new IllegalStateException("This handler cannot be used to link email or phone providers.");
        }
        final String mEmail = this.mEmail;
        if (mEmail != null && !mEmail.equals(idpResponse.getEmail())) {
            this.setResult(Resource.forFailure(new FirebaseUiException(6)));
            return;
        }
        this.setResult(Resource.forLoading());
        if (this.isGenericIdpLinkingFlow(idpResponse.getProviderType())) {
            this.getAuth().h().U1(this.mRequestedSignInCredential).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, idpResponse) {
                final LinkingSocialProviderResponseHandler this$0;
                final IdpResponse val$response;
                
                public void onSuccess(final AuthResult authResult) {
                    LinkingSocialProviderResponseHandler.access$000(this.this$0, this.val$response, authResult);
                }
                
                public /* bridge */ void onSuccess(final Object o) {
                    this.onSuccess((AuthResult)o);
                }
            }).f((OnFailureListener)new OnFailureListener(this) {
                final LinkingSocialProviderResponseHandler this$0;
                
                public void onFailure(final Exception ex) {
                    Resource.forFailure(ex);
                }
            });
            return;
        }
        final AuthOperationManager instance = AuthOperationManager.getInstance();
        final AuthCredential authCredential = ProviderUtils.getAuthCredential(idpResponse);
        if (instance.canUpgradeAnonymous(this.getAuth(), ((ViewModelBase<FlowParameters>)this).getArguments())) {
            final AuthCredential mRequestedSignInCredential = this.mRequestedSignInCredential;
            if (mRequestedSignInCredential == null) {
                this.handleMergeFailure(authCredential);
            }
            else {
                instance.safeLink(authCredential, mRequestedSignInCredential, ((ViewModelBase<FlowParameters>)this).getArguments()).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, authCredential) {
                    final LinkingSocialProviderResponseHandler this$0;
                    final AuthCredential val$credential;
                    
                    public void onSuccess(final AuthResult authResult) {
                        LinkingSocialProviderResponseHandler.access$200(this.this$0, this.val$credential);
                    }
                    
                    public /* bridge */ void onSuccess(final Object o) {
                        this.onSuccess((AuthResult)o);
                    }
                }).f((OnFailureListener)new OnFailureListener(this) {
                    final LinkingSocialProviderResponseHandler this$0;
                    
                    public void onFailure(final Exception ex) {
                        LinkingSocialProviderResponseHandler.access$100(this.this$0, Resource.forFailure(ex));
                    }
                });
            }
        }
        else {
            this.getAuth().t(authCredential).m((Continuation)new Continuation<AuthResult, Task<AuthResult>>(this) {
                final LinkingSocialProviderResponseHandler this$0;
                
                public Task<AuthResult> then(final Task<AuthResult> task) {
                    final AuthResult authResult = (AuthResult)task.p();
                    if (LinkingSocialProviderResponseHandler.access$500(this.this$0) == null) {
                        return (Task<AuthResult>)Tasks.e((Object)authResult);
                    }
                    return (Task<AuthResult>)authResult.l0().U1(LinkingSocialProviderResponseHandler.access$500(this.this$0)).k((Continuation)new Continuation<AuthResult, AuthResult>(this, authResult) {
                        final LinkingSocialProviderResponseHandler$6 this$1;
                        final AuthResult val$result;
                        
                        public AuthResult then(final Task<AuthResult> task) {
                            if (task.t()) {
                                return (AuthResult)task.p();
                            }
                            return this.val$result;
                        }
                        
                        public /* bridge */ Object then(final Task task) throws Exception {
                            return this.then((Task<AuthResult>)task);
                        }
                    });
                }
                
                public /* bridge */ Object then(final Task task) throws Exception {
                    return this.then((Task<AuthResult>)task);
                }
            }).c((OnCompleteListener)new OnCompleteListener<AuthResult>(this, idpResponse) {
                final LinkingSocialProviderResponseHandler this$0;
                final IdpResponse val$response;
                
                public void onComplete(final Task<AuthResult> task) {
                    if (task.t()) {
                        LinkingSocialProviderResponseHandler.access$300(this.this$0, this.val$response, (AuthResult)task.p());
                    }
                    else {
                        LinkingSocialProviderResponseHandler.access$400(this.this$0, Resource.forFailure(task.o()));
                    }
                }
            });
        }
    }
}
