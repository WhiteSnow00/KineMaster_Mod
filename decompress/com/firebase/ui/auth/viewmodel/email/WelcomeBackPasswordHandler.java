// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel.email;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.util.data.TaskFailureLogger;
import com.firebase.ui.auth.data.remote.ProfileMerger;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.EmailAuthProvider;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.data.model.User;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.AuthCredential;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;

public class WelcomeBackPasswordHandler extends SignInViewModelBase
{
    private static final String TAG = "WBPasswordHandler";
    private String mPendingPassword;
    
    public WelcomeBackPasswordHandler(final Application application) {
        super(application);
    }
    
    static void access$000(final WelcomeBackPasswordHandler welcomeBackPasswordHandler, final Resource result) {
        welcomeBackPasswordHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$100(final WelcomeBackPasswordHandler welcomeBackPasswordHandler, final AuthCredential authCredential) {
        welcomeBackPasswordHandler.handleMergeFailure(authCredential);
    }
    
    static void access$200(final WelcomeBackPasswordHandler welcomeBackPasswordHandler, final AuthCredential authCredential) {
        welcomeBackPasswordHandler.handleMergeFailure(authCredential);
    }
    
    static void access$300(final WelcomeBackPasswordHandler welcomeBackPasswordHandler, final Resource result) {
        welcomeBackPasswordHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$400(final WelcomeBackPasswordHandler welcomeBackPasswordHandler, final Resource result) {
        welcomeBackPasswordHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$500(final WelcomeBackPasswordHandler welcomeBackPasswordHandler, final IdpResponse idpResponse, final AuthResult authResult) {
        welcomeBackPasswordHandler.handleSuccess(idpResponse, authResult);
    }
    
    public String getPendingPassword() {
        return this.mPendingPassword;
    }
    
    public void startSignIn(final String s, final String mPendingPassword, final IdpResponse idpResponse, final AuthCredential authCredential) {
        this.setResult(Resource.forLoading());
        this.mPendingPassword = mPendingPassword;
        IdpResponse idpResponse2;
        if (authCredential == null) {
            idpResponse2 = new IdpResponse.Builder(new User.Builder("password", s).build()).build();
        }
        else {
            idpResponse2 = new IdpResponse.Builder(idpResponse.getUser()).setPendingCredential(idpResponse.getCredentialForLinking()).setToken(idpResponse.getIdpToken()).setSecret(idpResponse.getIdpSecret()).build();
        }
        final AuthOperationManager instance = AuthOperationManager.getInstance();
        if (instance.canUpgradeAnonymous(this.getAuth(), ((ViewModelBase<FlowParameters>)this).getArguments())) {
            final AuthCredential a = EmailAuthProvider.a(s, mPendingPassword);
            if (AuthUI.SOCIAL_PROVIDERS.contains(idpResponse.getProviderType())) {
                instance.safeLink(a, authCredential, ((ViewModelBase<FlowParameters>)this).getArguments()).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, a) {
                    final WelcomeBackPasswordHandler this$0;
                    final AuthCredential val$credToValidate;
                    
                    public void onSuccess(final AuthResult authResult) {
                        WelcomeBackPasswordHandler.access$100(this.this$0, this.val$credToValidate);
                    }
                    
                    public /* bridge */ void onSuccess(final Object o) {
                        this.onSuccess((AuthResult)o);
                    }
                }).f((OnFailureListener)new OnFailureListener(this) {
                    final WelcomeBackPasswordHandler this$0;
                    
                    public void onFailure(final Exception ex) {
                        WelcomeBackPasswordHandler.access$000(this.this$0, Resource.forFailure(ex));
                    }
                });
            }
            else {
                instance.validateCredential(a, ((ViewModelBase<FlowParameters>)this).getArguments()).c((OnCompleteListener)new OnCompleteListener<AuthResult>(this, a) {
                    final WelcomeBackPasswordHandler this$0;
                    final AuthCredential val$credToValidate;
                    
                    public void onComplete(final Task<AuthResult> task) {
                        if (task.t()) {
                            WelcomeBackPasswordHandler.access$200(this.this$0, this.val$credToValidate);
                        }
                        else {
                            WelcomeBackPasswordHandler.access$300(this.this$0, Resource.forFailure(task.o()));
                        }
                    }
                });
            }
        }
        else {
            this.getAuth().u(s, mPendingPassword).m((Continuation)new Continuation<AuthResult, Task<AuthResult>>(this, authCredential, idpResponse2) {
                final WelcomeBackPasswordHandler this$0;
                final AuthCredential val$credential;
                final IdpResponse val$outputResponse;
                
                public Task<AuthResult> then(final Task<AuthResult> task) throws Exception {
                    final AuthResult authResult = (AuthResult)task.q((Class)Exception.class);
                    if (this.val$credential == null) {
                        return (Task<AuthResult>)Tasks.e((Object)authResult);
                    }
                    return (Task<AuthResult>)authResult.l0().U1(this.val$credential).m((Continuation)new ProfileMerger(this.val$outputResponse)).f((OnFailureListener)new TaskFailureLogger("WBPasswordHandler", "linkWithCredential+merge failed."));
                }
                
                public /* bridge */ Object then(final Task task) throws Exception {
                    return this.then((Task<AuthResult>)task);
                }
            }).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, idpResponse2) {
                final WelcomeBackPasswordHandler this$0;
                final IdpResponse val$outputResponse;
                
                public void onSuccess(final AuthResult authResult) {
                    WelcomeBackPasswordHandler.access$500(this.this$0, this.val$outputResponse, authResult);
                }
                
                public /* bridge */ void onSuccess(final Object o) {
                    this.onSuccess((AuthResult)o);
                }
            }).f((OnFailureListener)new OnFailureListener(this) {
                final WelcomeBackPasswordHandler this$0;
                
                public void onFailure(final Exception ex) {
                    WelcomeBackPasswordHandler.access$400(this.this$0, Resource.forFailure(ex));
                }
            }).f((OnFailureListener)new TaskFailureLogger("WBPasswordHandler", "signInWithEmailAndPassword failed."));
        }
    }
}
