// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel.idp;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.ui.idp.WelcomeBackIdpPrompt;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.ui.email.WelcomeBackEmailLinkPrompt;
import com.firebase.ui.auth.data.model.IntentRequiredException;
import com.firebase.ui.auth.ui.email.WelcomeBackPasswordPrompt;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.firebase.ui.auth.util.FirebaseAuthError;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.android.gms.tasks.Continuation;
import com.firebase.ui.auth.data.remote.ProfileMerger;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.firebase.ui.auth.FirebaseUiException;
import java.util.List;
import com.google.android.gms.tasks.OnSuccessListener;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthCredential;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;

public class SocialProviderResponseHandler extends SignInViewModelBase
{
    public SocialProviderResponseHandler(final Application application) {
        super(application);
    }
    
    static void access$000(final SocialProviderResponseHandler socialProviderResponseHandler, final Resource result) {
        socialProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$100(final SocialProviderResponseHandler socialProviderResponseHandler, final Resource result) {
        socialProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$200(final SocialProviderResponseHandler socialProviderResponseHandler, final Resource result) {
        socialProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$300(final SocialProviderResponseHandler socialProviderResponseHandler, final AuthCredential authCredential) {
        socialProviderResponseHandler.handleMergeFailure(authCredential);
    }
    
    static void access$400(final SocialProviderResponseHandler socialProviderResponseHandler, final Resource result) {
        socialProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static FirebaseAuth access$500(final SocialProviderResponseHandler socialProviderResponseHandler) {
        return socialProviderResponseHandler.getAuth();
    }
    
    static Object access$600(final SocialProviderResponseHandler socialProviderResponseHandler) {
        return ((ViewModelBase<Object>)socialProviderResponseHandler).getArguments();
    }
    
    static void access$700(final SocialProviderResponseHandler socialProviderResponseHandler, final IdpResponse idpResponse, final AuthResult authResult) {
        socialProviderResponseHandler.handleSuccess(idpResponse, authResult);
    }
    
    static void access$800(final SocialProviderResponseHandler socialProviderResponseHandler, final Resource result) {
        socialProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$900(final SocialProviderResponseHandler socialProviderResponseHandler, final Resource result) {
        socialProviderResponseHandler.setResult((Resource<IdpResponse>)result);
    }
    
    private void handleGenericIdpLinkingFlow(final IdpResponse idpResponse) {
        ProviderUtils.fetchSortedProviders(this.getAuth(), ((ViewModelBase<FlowParameters>)this).getArguments(), idpResponse.getEmail()).i((OnSuccessListener)new OnSuccessListener<List<String>>(this, idpResponse) {
            final SocialProviderResponseHandler this$0;
            final IdpResponse val$idpResponse;
            
            public /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((List<String>)o);
            }
            
            public void onSuccess(final List<String> list) {
                if (list.isEmpty()) {
                    SocialProviderResponseHandler.access$900(this.this$0, Resource.forFailure(new FirebaseUiException(3, "No supported providers.")));
                    return;
                }
                this.this$0.startWelcomeBackFlowForLinking(list.get(0), this.val$idpResponse);
            }
        }).f((OnFailureListener)new OnFailureListener(this) {
            final SocialProviderResponseHandler this$0;
            
            public void onFailure(final Exception ex) {
                SocialProviderResponseHandler.access$800(this.this$0, Resource.forFailure(ex));
            }
        });
    }
    
    private boolean isEmailOrPhoneProvider(final String s) {
        return TextUtils.equals((CharSequence)s, (CharSequence)"password") || TextUtils.equals((CharSequence)s, (CharSequence)"phone");
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n == 108) {
            final IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
            if (n2 == -1) {
                this.setResult(Resource.forSuccess(fromResultIntent));
            }
            else {
                FirebaseUiException error;
                if (fromResultIntent == null) {
                    error = new FirebaseUiException(0, "Link canceled by user.");
                }
                else {
                    error = fromResultIntent.getError();
                }
                this.setResult((Resource<IdpResponse>)Resource.forFailure(error));
            }
        }
    }
    
    public void startSignIn(final IdpResponse idpResponse) {
        if (!idpResponse.isSuccessful() && !idpResponse.isRecoverableErrorResponse()) {
            this.setResult(Resource.forFailure(idpResponse.getError()));
            return;
        }
        if (this.isEmailOrPhoneProvider(idpResponse.getProviderType())) {
            throw new IllegalStateException("This handler cannot be used with email or phone providers");
        }
        this.setResult(Resource.forLoading());
        if (idpResponse.hasCredentialForLinking()) {
            this.handleGenericIdpLinkingFlow(idpResponse);
            return;
        }
        final AuthCredential authCredential = ProviderUtils.getAuthCredential(idpResponse);
        AuthOperationManager.getInstance().signInAndLinkWithCredential(this.getAuth(), ((ViewModelBase<FlowParameters>)this).getArguments(), authCredential).m((Continuation)new ProfileMerger(idpResponse)).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, idpResponse) {
            final SocialProviderResponseHandler this$0;
            final IdpResponse val$response;
            
            public void onSuccess(final AuthResult authResult) {
                SocialProviderResponseHandler.access$700(this.this$0, this.val$response, authResult);
            }
            
            public /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((AuthResult)o);
            }
        }).f((OnFailureListener)new OnFailureListener(this, idpResponse, authCredential) {
            final SocialProviderResponseHandler this$0;
            final AuthCredential val$credential;
            final IdpResponse val$response;
            
            public void onFailure(final Exception ex) {
                boolean b = ex instanceof FirebaseAuthInvalidUserException;
                if (ex instanceof FirebaseAuthException) {
                    b = b;
                    if (FirebaseAuthError.fromException((FirebaseAuthException)ex) == FirebaseAuthError.ERROR_USER_DISABLED) {
                        b = true;
                    }
                }
                if (b) {
                    SocialProviderResponseHandler.access$000(this.this$0, Resource.forFailure(new FirebaseUiException(12)));
                }
                else if (ex instanceof FirebaseAuthUserCollisionException) {
                    final String email = this.val$response.getEmail();
                    if (email == null) {
                        SocialProviderResponseHandler.access$100(this.this$0, Resource.forFailure(ex));
                        return;
                    }
                    ProviderUtils.fetchSortedProviders(SocialProviderResponseHandler.access$500(this.this$0), (FlowParameters)SocialProviderResponseHandler.access$600(this.this$0), email).i((OnSuccessListener)new OnSuccessListener<List<String>>(this) {
                        final SocialProviderResponseHandler$1 this$1;
                        
                        public /* bridge */ void onSuccess(final Object o) {
                            this.onSuccess((List<String>)o);
                        }
                        
                        public void onSuccess(final List<String> list) {
                            if (list.contains(this.this$1.val$response.getProviderType())) {
                                final OnFailureListener this$1 = (OnFailureListener)this.this$1;
                                SocialProviderResponseHandler.access$300(this$1.this$0, this$1.val$credential);
                            }
                            else if (list.isEmpty()) {
                                SocialProviderResponseHandler.access$400(this.this$1.this$0, Resource.forFailure(new FirebaseUiException(3, "No supported providers.")));
                            }
                            else {
                                this.this$1.this$0.startWelcomeBackFlowForLinking(list.get(0), this.this$1.val$response);
                            }
                        }
                    }).f((OnFailureListener)new OnFailureListener(this) {
                        final SocialProviderResponseHandler$1 this$1;
                        
                        public void onFailure(final Exception ex) {
                            SocialProviderResponseHandler.access$200(this.this$1.this$0, Resource.forFailure(ex));
                        }
                    });
                }
            }
        });
    }
    
    public void startWelcomeBackFlowForLinking(final String s, final IdpResponse idpResponse) {
        if (s != null) {
            if (s.equals("password")) {
                this.setResult(Resource.forFailure(new IntentRequiredException(WelcomeBackPasswordPrompt.createIntent(this.getApplication(), ((ViewModelBase<FlowParameters>)this).getArguments(), idpResponse), 108)));
            }
            else if (s.equals("emailLink")) {
                this.setResult(Resource.forFailure(new IntentRequiredException(WelcomeBackEmailLinkPrompt.createIntent(this.getApplication(), ((ViewModelBase<FlowParameters>)this).getArguments(), idpResponse), 112)));
            }
            else {
                this.setResult(Resource.forFailure(new IntentRequiredException(WelcomeBackIdpPrompt.createIntent(this.getApplication(), ((ViewModelBase<FlowParameters>)this).getArguments(), new User.Builder(s, idpResponse.getEmail()).build(), idpResponse), 108)));
            }
            return;
        }
        throw new IllegalStateException("No provider even though we received a FirebaseAuthUserCollisionException");
    }
}
