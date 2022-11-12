// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel.email;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.ui.idp.WelcomeBackIdpPrompt;
import com.firebase.ui.auth.ui.email.WelcomeBackEmailLinkPrompt;
import com.firebase.ui.auth.data.model.IntentRequiredException;
import com.firebase.ui.auth.ui.email.WelcomeBackPasswordPrompt;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.util.data.ProviderUtils;
import android.util.Log;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.firebase.ui.auth.util.data.TaskFailureLogger;
import com.google.android.gms.tasks.Continuation;
import com.firebase.ui.auth.data.remote.ProfileMerger;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.AuthCredential;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import com.google.firebase.auth.FirebaseAuth;
import android.app.Application;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;

public class EmailProviderResponseHandler extends SignInViewModelBase
{
    private static final String TAG = "EmailProviderResponseHa";
    
    public EmailProviderResponseHandler(final Application application) {
        super(application);
    }
    
    static FirebaseAuth access$000(final EmailProviderResponseHandler emailProviderResponseHandler) {
        return emailProviderResponseHandler.getAuth();
    }
    
    static Object access$100(final EmailProviderResponseHandler emailProviderResponseHandler) {
        return ((ViewModelBase<Object>)emailProviderResponseHandler).getArguments();
    }
    
    static void access$1000(final EmailProviderResponseHandler emailProviderResponseHandler, final Resource result) {
        emailProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static Object access$1100(final EmailProviderResponseHandler emailProviderResponseHandler) {
        return ((ViewModelBase<Object>)emailProviderResponseHandler).getArguments();
    }
    
    static void access$1200(final EmailProviderResponseHandler emailProviderResponseHandler, final Resource result) {
        emailProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static Object access$1300(final EmailProviderResponseHandler emailProviderResponseHandler) {
        return ((ViewModelBase<Object>)emailProviderResponseHandler).getArguments();
    }
    
    static void access$1400(final EmailProviderResponseHandler emailProviderResponseHandler, final Resource result) {
        emailProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$200(final EmailProviderResponseHandler emailProviderResponseHandler, final AuthCredential authCredential) {
        emailProviderResponseHandler.handleMergeFailure(authCredential);
    }
    
    static void access$300(final EmailProviderResponseHandler emailProviderResponseHandler, final Resource result) {
        emailProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static FirebaseAuth access$400(final EmailProviderResponseHandler emailProviderResponseHandler) {
        return emailProviderResponseHandler.getAuth();
    }
    
    static Object access$500(final EmailProviderResponseHandler emailProviderResponseHandler) {
        return ((ViewModelBase<Object>)emailProviderResponseHandler).getArguments();
    }
    
    static void access$600(final EmailProviderResponseHandler emailProviderResponseHandler, final Resource result) {
        emailProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$700(final EmailProviderResponseHandler emailProviderResponseHandler, final IdpResponse idpResponse, final AuthResult authResult) {
        emailProviderResponseHandler.handleSuccess(idpResponse, authResult);
    }
    
    static void access$800(final EmailProviderResponseHandler emailProviderResponseHandler, final Resource result) {
        emailProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static Object access$900(final EmailProviderResponseHandler emailProviderResponseHandler) {
        return ((ViewModelBase<Object>)emailProviderResponseHandler).getArguments();
    }
    
    public void startSignIn(final IdpResponse idpResponse, final String s) {
        if (!idpResponse.isSuccessful()) {
            this.setResult(Resource.forFailure(idpResponse.getError()));
            return;
        }
        if (idpResponse.getProviderType().equals("password")) {
            this.setResult(Resource.forLoading());
            final AuthOperationManager instance = AuthOperationManager.getInstance();
            final String email = idpResponse.getEmail();
            instance.createOrLinkUserWithEmailAndPassword(this.getAuth(), ((ViewModelBase<FlowParameters>)this).getArguments(), email, s).m((Continuation)new ProfileMerger(idpResponse)).f((OnFailureListener)new TaskFailureLogger("EmailProviderResponseHa", "Error creating user")).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, idpResponse) {
                final EmailProviderResponseHandler this$0;
                final IdpResponse val$response;
                
                public void onSuccess(final AuthResult authResult) {
                    EmailProviderResponseHandler.access$700(this.this$0, this.val$response, authResult);
                }
                
                public /* bridge */ void onSuccess(final Object o) {
                    this.onSuccess((AuthResult)o);
                }
            }).f((OnFailureListener)new OnFailureListener(this, instance, email, s) {
                final EmailProviderResponseHandler this$0;
                final AuthOperationManager val$authOperationManager;
                final String val$email;
                final String val$password;
                
                public void onFailure(final Exception ex) {
                    if (ex instanceof FirebaseAuthUserCollisionException) {
                        if (this.val$authOperationManager.canUpgradeAnonymous(EmailProviderResponseHandler.access$000(this.this$0), (FlowParameters)EmailProviderResponseHandler.access$100(this.this$0))) {
                            EmailProviderResponseHandler.access$200(this.this$0, EmailAuthProvider.a(this.val$email, this.val$password));
                        }
                        else {
                            Log.w("EmailProviderResponseHa", "Got a collision error during a non-upgrade flow", (Throwable)ex);
                            ProviderUtils.fetchTopProvider(EmailProviderResponseHandler.access$400(this.this$0), (FlowParameters)EmailProviderResponseHandler.access$500(this.this$0), this.val$email).i((OnSuccessListener)this.this$0.new StartWelcomeBackFlow(this.val$email)).f((OnFailureListener)new OnFailureListener(this) {
                                final EmailProviderResponseHandler$1 this$1;
                                
                                public void onFailure(final Exception ex) {
                                    EmailProviderResponseHandler.access$300(this.this$1.this$0, Resource.forFailure(ex));
                                }
                            });
                        }
                    }
                    else {
                        EmailProviderResponseHandler.access$600(this.this$0, Resource.forFailure(ex));
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("This handler can only be used with the email provider");
    }
    
    private class StartWelcomeBackFlow implements OnSuccessListener<String>
    {
        private final String mEmail;
        final EmailProviderResponseHandler this$0;
        
        public StartWelcomeBackFlow(final EmailProviderResponseHandler this$0, final String mEmail) {
            this.this$0 = this$0;
            this.mEmail = mEmail;
        }
        
        public /* bridge */ void onSuccess(final Object o) {
            this.onSuccess((String)o);
        }
        
        public void onSuccess(final String s) {
            if (s == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("No providers known for user (");
                sb.append(this.mEmail);
                sb.append(") this email address may be reserved.");
                Log.w("EmailProviderResponseHa", sb.toString());
                EmailProviderResponseHandler.access$800(this.this$0, Resource.forFailure(new FirebaseUiException(0)));
                return;
            }
            if ("password".equalsIgnoreCase(s)) {
                EmailProviderResponseHandler.access$1000(this.this$0, Resource.forFailure(new IntentRequiredException(WelcomeBackPasswordPrompt.createIntent(this.this$0.getApplication(), (FlowParameters)EmailProviderResponseHandler.access$900(this.this$0), new IdpResponse.Builder(new User.Builder("password", this.mEmail).build()).build()), 104)));
            }
            else if ("emailLink".equalsIgnoreCase(s)) {
                EmailProviderResponseHandler.access$1200(this.this$0, Resource.forFailure(new IntentRequiredException(WelcomeBackEmailLinkPrompt.createIntent(this.this$0.getApplication(), (FlowParameters)EmailProviderResponseHandler.access$1100(this.this$0), new IdpResponse.Builder(new User.Builder("emailLink", this.mEmail).build()).build()), 112)));
            }
            else {
                EmailProviderResponseHandler.access$1400(this.this$0, Resource.forFailure(new IntentRequiredException(WelcomeBackIdpPrompt.createIntent(this.this$0.getApplication(), (FlowParameters)EmailProviderResponseHandler.access$1300(this.this$0), new User.Builder(s, this.mEmail).build()), 103)));
            }
        }
    }
}
