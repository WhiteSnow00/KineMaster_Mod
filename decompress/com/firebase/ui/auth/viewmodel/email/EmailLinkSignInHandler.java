// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel.email;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.util.data.EmailLinkParser;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.firebase.ui.auth.util.data.TaskFailureLogger;
import com.firebase.ui.auth.data.remote.ProfileMerger;
import com.google.android.gms.tasks.Continuation;
import com.google.firebase.auth.EmailAuthProvider;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.util.data.EmailLinkPersistenceManager;
import com.firebase.ui.auth.FirebaseUiException;
import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.AuthCredential;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;

public class EmailLinkSignInHandler extends SignInViewModelBase
{
    private static final String TAG = "EmailLinkSignInHandler";
    
    public EmailLinkSignInHandler(final Application application) {
        super(application);
    }
    
    static void access$000(final EmailLinkSignInHandler emailLinkSignInHandler, final Resource result) {
        emailLinkSignInHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$100(final EmailLinkSignInHandler emailLinkSignInHandler, final Resource result) {
        emailLinkSignInHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$200(final EmailLinkSignInHandler emailLinkSignInHandler, final Resource result) {
        emailLinkSignInHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$300(final EmailLinkSignInHandler emailLinkSignInHandler, final AuthCredential authCredential) {
        emailLinkSignInHandler.handleMergeFailure(authCredential);
    }
    
    static void access$400(final EmailLinkSignInHandler emailLinkSignInHandler, final Resource result) {
        emailLinkSignInHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$500(final EmailLinkSignInHandler emailLinkSignInHandler, final Resource result) {
        emailLinkSignInHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$600(final EmailLinkSignInHandler emailLinkSignInHandler, final IdpResponse idpResponse, final AuthResult authResult) {
        emailLinkSignInHandler.handleSuccess(idpResponse, authResult);
    }
    
    static void access$700(final EmailLinkSignInHandler emailLinkSignInHandler, final AuthCredential authCredential) {
        emailLinkSignInHandler.handleMergeFailure(authCredential);
    }
    
    static void access$800(final EmailLinkSignInHandler emailLinkSignInHandler, final Resource result) {
        emailLinkSignInHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$900(final EmailLinkSignInHandler emailLinkSignInHandler, final IdpResponse idpResponse, final AuthResult authResult) {
        emailLinkSignInHandler.handleSuccess(idpResponse, authResult);
    }
    
    private void determineDifferentDeviceErrorFlowAndFinish(final String s, final String s2) {
        this.getAuth().d(s).c((OnCompleteListener)new OnCompleteListener<ActionCodeResult>(this, s2) {
            final EmailLinkSignInHandler this$0;
            final String val$providerId;
            
            public void onComplete(final Task<ActionCodeResult> task) {
                if (task.t()) {
                    if (!TextUtils.isEmpty((CharSequence)this.val$providerId)) {
                        EmailLinkSignInHandler.access$000(this.this$0, Resource.forFailure(new FirebaseUiException(10)));
                        return;
                    }
                    EmailLinkSignInHandler.access$100(this.this$0, Resource.forFailure(new FirebaseUiException(9)));
                }
                else {
                    EmailLinkSignInHandler.access$200(this.this$0, Resource.forFailure(new FirebaseUiException(7)));
                }
            }
        });
    }
    
    private void finishSignIn(final EmailLinkPersistenceManager.SessionRecord sessionRecord) {
        this.finishSignIn(sessionRecord.getEmail(), sessionRecord.getIdpResponseForLinking());
    }
    
    private void finishSignIn(final String s, final IdpResponse idpResponse) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            this.setResult(Resource.forFailure(new FirebaseUiException(6)));
            return;
        }
        final AuthOperationManager instance = AuthOperationManager.getInstance();
        final EmailLinkPersistenceManager instance2 = EmailLinkPersistenceManager.getInstance();
        final String emailLink = ((ViewModelBase<FlowParameters>)this).getArguments().emailLink;
        if (idpResponse == null) {
            this.handleNormalFlow(instance, instance2, s, emailLink);
        }
        else {
            this.handleLinkingFlow(instance, instance2, idpResponse, emailLink);
        }
    }
    
    private void handleLinkingFlow(final AuthOperationManager authOperationManager, final EmailLinkPersistenceManager emailLinkPersistenceManager, final IdpResponse idpResponse, final String s) {
        final AuthCredential authCredential = ProviderUtils.getAuthCredential(idpResponse);
        final AuthCredential b = EmailAuthProvider.b(idpResponse.getEmail(), s);
        if (authOperationManager.canUpgradeAnonymous(this.getAuth(), ((ViewModelBase<FlowParameters>)this).getArguments())) {
            authOperationManager.safeLink(b, authCredential, ((ViewModelBase<FlowParameters>)this).getArguments()).c((OnCompleteListener)new OnCompleteListener<AuthResult>(this, emailLinkPersistenceManager, authCredential) {
                final EmailLinkSignInHandler this$0;
                final EmailLinkPersistenceManager val$persistenceManager;
                final AuthCredential val$storedCredentialForLink;
                
                public void onComplete(final Task<AuthResult> task) {
                    this.val$persistenceManager.clearAllData(this.this$0.getApplication());
                    if (task.t()) {
                        EmailLinkSignInHandler.access$300(this.this$0, this.val$storedCredentialForLink);
                    }
                    else {
                        EmailLinkSignInHandler.access$400(this.this$0, Resource.forFailure(task.o()));
                    }
                }
            });
        }
        else {
            this.getAuth().t(b).m((Continuation)new Continuation<AuthResult, Task<AuthResult>>(this, emailLinkPersistenceManager, authCredential, idpResponse) {
                final EmailLinkSignInHandler this$0;
                final EmailLinkPersistenceManager val$persistenceManager;
                final IdpResponse val$response;
                final AuthCredential val$storedCredentialForLink;
                
                public Task<AuthResult> then(final Task<AuthResult> task) {
                    this.val$persistenceManager.clearAllData(this.this$0.getApplication());
                    if (!task.t()) {
                        return task;
                    }
                    return (Task<AuthResult>)((AuthResult)task.p()).l0().U1(this.val$storedCredentialForLink).m((Continuation)new ProfileMerger(this.val$response)).f((OnFailureListener)new TaskFailureLogger("EmailLinkSignInHandler", "linkWithCredential+merge failed."));
                }
                
                public /* bridge */ Object then(final Task task) throws Exception {
                    return this.then((Task<AuthResult>)task);
                }
            }).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this) {
                final EmailLinkSignInHandler this$0;
                
                public void onSuccess(final AuthResult authResult) {
                    final FirebaseUser l0 = authResult.l0();
                    EmailLinkSignInHandler.access$600(this.this$0, new IdpResponse.Builder(new User.Builder("emailLink", l0.M1()).setName(l0.L1()).setPhotoUri(l0.P1()).build()).build(), authResult);
                }
                
                public /* bridge */ void onSuccess(final Object o) {
                    this.onSuccess((AuthResult)o);
                }
            }).f((OnFailureListener)new OnFailureListener(this) {
                final EmailLinkSignInHandler this$0;
                
                public void onFailure(final Exception ex) {
                    EmailLinkSignInHandler.access$500(this.this$0, Resource.forFailure(ex));
                }
            });
        }
    }
    
    private void handleNormalFlow(final AuthOperationManager authOperationManager, final EmailLinkPersistenceManager emailLinkPersistenceManager, final String s, final String s2) {
        authOperationManager.signInAndLinkWithCredential(this.getAuth(), ((ViewModelBase<FlowParameters>)this).getArguments(), EmailAuthProvider.b(s, s2)).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, emailLinkPersistenceManager) {
            final EmailLinkSignInHandler this$0;
            final EmailLinkPersistenceManager val$persistenceManager;
            
            public void onSuccess(final AuthResult authResult) {
                this.val$persistenceManager.clearAllData(this.this$0.getApplication());
                final FirebaseUser l0 = authResult.l0();
                EmailLinkSignInHandler.access$900(this.this$0, new IdpResponse.Builder(new User.Builder("emailLink", l0.M1()).setName(l0.L1()).setPhotoUri(l0.P1()).build()).build(), authResult);
            }
            
            public /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((AuthResult)o);
            }
        }).f((OnFailureListener)new OnFailureListener(this, emailLinkPersistenceManager, EmailAuthProvider.b(s, s2)) {
            final EmailLinkSignInHandler this$0;
            final AuthCredential val$emailLinkCredentialForLinking;
            final EmailLinkPersistenceManager val$persistenceManager;
            
            public void onFailure(final Exception ex) {
                this.val$persistenceManager.clearAllData(this.this$0.getApplication());
                if (ex instanceof FirebaseAuthUserCollisionException) {
                    EmailLinkSignInHandler.access$700(this.this$0, this.val$emailLinkCredentialForLinking);
                }
                else {
                    EmailLinkSignInHandler.access$800(this.this$0, Resource.forFailure(ex));
                }
            }
        });
    }
    
    private boolean isDifferentDeviceFlow(final EmailLinkPersistenceManager.SessionRecord sessionRecord, final String s) {
        return sessionRecord == null || TextUtils.isEmpty((CharSequence)sessionRecord.getSessionId()) || TextUtils.isEmpty((CharSequence)s) || !s.equals(sessionRecord.getSessionId());
    }
    
    public void finishSignIn(final String s) {
        this.setResult(Resource.forLoading());
        this.finishSignIn(s, null);
    }
    
    public void startSignIn() {
        this.setResult(Resource.forLoading());
        final String emailLink = ((ViewModelBase<FlowParameters>)this).getArguments().emailLink;
        if (!this.getAuth().m(emailLink)) {
            this.setResult(Resource.forFailure(new FirebaseUiException(7)));
            return;
        }
        final EmailLinkPersistenceManager.SessionRecord retrieveSessionRecord = EmailLinkPersistenceManager.getInstance().retrieveSessionRecord(this.getApplication());
        final EmailLinkParser emailLinkParser = new EmailLinkParser(emailLink);
        final String sessionId = emailLinkParser.getSessionId();
        final String anonymousUserId = emailLinkParser.getAnonymousUserId();
        final String oobCode = emailLinkParser.getOobCode();
        final String providerId = emailLinkParser.getProviderId();
        final boolean forceSameDeviceBit = emailLinkParser.getForceSameDeviceBit();
        if (this.isDifferentDeviceFlow(retrieveSessionRecord, sessionId)) {
            if (TextUtils.isEmpty((CharSequence)sessionId)) {
                this.setResult(Resource.forFailure(new FirebaseUiException(7)));
                return;
            }
            if (!forceSameDeviceBit && TextUtils.isEmpty((CharSequence)anonymousUserId)) {
                this.determineDifferentDeviceErrorFlowAndFinish(oobCode, providerId);
                return;
            }
            this.setResult(Resource.forFailure(new FirebaseUiException(8)));
        }
        else {
            if (anonymousUserId != null && (this.getAuth().h() == null || (this.getAuth().h().T1() && !anonymousUserId.equals(this.getAuth().h().S1())))) {
                this.setResult(Resource.forFailure(new FirebaseUiException(11)));
                return;
            }
            this.finishSignIn(retrieveSessionRecord);
        }
    }
}
