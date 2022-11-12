// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.remote;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import android.content.Intent;
import com.firebase.ui.auth.data.model.User;
import com.google.firebase.auth.FirebaseUser;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.firebase.ui.auth.util.FirebaseAuthError;
import com.google.firebase.auth.FirebaseAuthException;
import com.firebase.ui.auth.FirebaseAuthAnonymousUpgradeException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.firebase.ui.auth.FirebaseUiUserCollisionException;
import com.firebase.ui.auth.FirebaseUiException;
import com.google.firebase.auth.AuthCredential;
import java.util.List;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.OAuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FederatedAuthProvider;
import android.app.Activity;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.google.firebase.auth.OAuthProvider;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.google.firebase.auth.FirebaseAuth;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.viewmodel.ProviderSignInBase;

public class GenericIdpSignInHandler extends ProviderSignInBase<AuthUI.IdpConfig>
{
    public GenericIdpSignInHandler(final Application application) {
        super(application);
    }
    
    static void access$000(final GenericIdpSignInHandler genericIdpSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)genericIdpSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static void access$100(final GenericIdpSignInHandler genericIdpSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)genericIdpSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static void access$200(final GenericIdpSignInHandler genericIdpSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)genericIdpSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static void access$300(final GenericIdpSignInHandler genericIdpSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)genericIdpSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static void access$400(final GenericIdpSignInHandler genericIdpSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)genericIdpSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static void access$500(final GenericIdpSignInHandler genericIdpSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)genericIdpSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static void access$600(final GenericIdpSignInHandler genericIdpSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)genericIdpSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    public static AuthUI.IdpConfig getGenericFacebookConfig() {
        return ((AuthUI.IdpConfig.Builder)new AuthUI.IdpConfig.GenericOAuthProviderBuilder("facebook.com", "Facebook", R.layout.fui_idp_button_facebook)).build();
    }
    
    public static AuthUI.IdpConfig getGenericGoogleConfig() {
        return ((AuthUI.IdpConfig.Builder)new AuthUI.IdpConfig.GenericOAuthProviderBuilder("google.com", "Google", R.layout.fui_idp_button_google)).build();
    }
    
    private void handleAnonymousUpgradeFlow(final FirebaseAuth firebaseAuth, final HelperActivityBase helperActivityBase, final OAuthProvider oAuthProvider, final FlowParameters flowParameters) {
        firebaseAuth.h().W1(helperActivityBase, oAuthProvider).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, helperActivityBase.getAuthUI().isUseEmulator(), oAuthProvider) {
            final GenericIdpSignInHandler this$0;
            final OAuthProvider val$provider;
            final boolean val$useEmulator;
            
            public void onSuccess(final AuthResult authResult) {
                this.this$0.handleSuccess(this.val$useEmulator, this.val$provider.c(), authResult.l0(), (OAuthCredential)authResult.getCredential(), authResult.d1().isNewUser());
            }
            
            public /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((AuthResult)o);
            }
        }).f((OnFailureListener)new OnFailureListener(this, firebaseAuth, flowParameters, oAuthProvider) {
            final GenericIdpSignInHandler this$0;
            final FirebaseAuth val$auth;
            final FlowParameters val$flowParameters;
            final OAuthProvider val$provider;
            
            public void onFailure(final Exception ex) {
                if (!(ex instanceof FirebaseAuthUserCollisionException)) {
                    GenericIdpSignInHandler.access$400(this.this$0, Resource.forFailure(ex));
                    return;
                }
                final FirebaseAuthUserCollisionException ex2 = (FirebaseAuthUserCollisionException)ex;
                final AuthCredential updatedCredential = ex2.getUpdatedCredential();
                final String email = ex2.getEmail();
                ProviderUtils.fetchSortedProviders(this.val$auth, this.val$flowParameters, email).i((OnSuccessListener)new OnSuccessListener<List<String>>(this, updatedCredential, email) {
                    final GenericIdpSignInHandler$3 this$1;
                    final AuthCredential val$credential;
                    final String val$email;
                    
                    public /* bridge */ void onSuccess(final Object o) {
                        this.onSuccess((List<String>)o);
                    }
                    
                    public void onSuccess(final List<String> list) {
                        if (list.isEmpty()) {
                            GenericIdpSignInHandler.access$500(this.this$1.this$0, Resource.forFailure(new FirebaseUiException(3, "Unable to complete the linkingflow - the user is using unsupported providers.")));
                            return;
                        }
                        if (list.contains(this.this$1.val$provider.c())) {
                            this.this$1.this$0.handleMergeFailure(this.val$credential);
                        }
                        else {
                            GenericIdpSignInHandler.access$600(this.this$1.this$0, Resource.forFailure(new FirebaseUiUserCollisionException(13, "Recoverable error.", this.this$1.val$provider.c(), this.val$email, this.val$credential)));
                        }
                    }
                });
            }
        });
    }
    
    public OAuthProvider buildOAuthProvider(final String s, final FirebaseAuth firebaseAuth) {
        final OAuthProvider.Builder e = OAuthProvider.e(s, firebaseAuth);
        final ArrayList stringArrayList = ((AuthUI.IdpConfig)((ViewModelBase<AuthUI.IdpConfig>)this).getArguments()).getParams().getStringArrayList("generic_oauth_scopes");
        final HashMap hashMap = (HashMap)((AuthUI.IdpConfig)((ViewModelBase<AuthUI.IdpConfig>)this).getArguments()).getParams().getSerializable("generic_oauth_custom_parameters");
        if (stringArrayList != null) {
            e.c(stringArrayList);
        }
        if (hashMap != null) {
            e.a(hashMap);
        }
        return e.b();
    }
    
    protected void handleMergeFailure(final AuthCredential pendingCredential) {
        ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forFailure(new FirebaseAuthAnonymousUpgradeException(5, new IdpResponse.Builder().setPendingCredential(pendingCredential).build())));
    }
    
    protected void handleNormalSignInFlow(final FirebaseAuth firebaseAuth, final HelperActivityBase helperActivityBase, final OAuthProvider oAuthProvider) {
        firebaseAuth.w(helperActivityBase, oAuthProvider).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, helperActivityBase.getAuthUI().isUseEmulator(), oAuthProvider) {
            final GenericIdpSignInHandler this$0;
            final OAuthProvider val$provider;
            final boolean val$useEmulator;
            
            public void onSuccess(final AuthResult authResult) {
                this.this$0.handleSuccess(this.val$useEmulator, this.val$provider.c(), authResult.l0(), (OAuthCredential)authResult.getCredential(), authResult.d1().isNewUser());
            }
            
            public /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((AuthResult)o);
            }
        }).f((OnFailureListener)new OnFailureListener(this, oAuthProvider) {
            final GenericIdpSignInHandler this$0;
            final OAuthProvider val$provider;
            
            public void onFailure(final Exception ex) {
                if (ex instanceof FirebaseAuthException) {
                    final FirebaseAuthError fromException = FirebaseAuthError.fromException((FirebaseAuthException)ex);
                    if (ex instanceof FirebaseAuthUserCollisionException) {
                        final FirebaseAuthUserCollisionException ex2 = (FirebaseAuthUserCollisionException)ex;
                        GenericIdpSignInHandler.access$000(this.this$0, Resource.forFailure(new FirebaseUiUserCollisionException(13, "Recoverable error.", this.val$provider.c(), ex2.getEmail(), ex2.getUpdatedCredential())));
                    }
                    else if (fromException == FirebaseAuthError.ERROR_WEB_CONTEXT_CANCELED) {
                        GenericIdpSignInHandler.access$100(this.this$0, Resource.forFailure(new UserCancellationException()));
                    }
                    else {
                        GenericIdpSignInHandler.access$200(this.this$0, Resource.forFailure(ex));
                    }
                }
                else {
                    GenericIdpSignInHandler.access$300(this.this$0, Resource.forFailure(ex));
                }
            }
        });
    }
    
    protected void handleSuccess(final boolean b, final String s, final FirebaseUser firebaseUser, final OAuthCredential oAuthCredential, final boolean b2) {
        this.handleSuccess(b, s, firebaseUser, oAuthCredential, b2, true);
    }
    
    protected void handleSuccess(final boolean b, final String s, final FirebaseUser firebaseUser, final OAuthCredential pendingCredential, final boolean newUser, final boolean b2) {
        String m1;
        final String s2 = m1 = pendingCredential.M1();
        if (s2 == null) {
            m1 = s2;
            if (b) {
                m1 = "fake_access_token";
            }
        }
        final String o1 = pendingCredential.O1();
        String secret;
        if ((secret = o1) == null) {
            secret = o1;
            if (b) {
                secret = "fake_secret";
            }
        }
        final IdpResponse.Builder setSecret = new IdpResponse.Builder(new User.Builder(s, firebaseUser.M1()).setName(firebaseUser.L1()).setPhotoUri(firebaseUser.P1()).build()).setToken(m1).setSecret(secret);
        if (b2) {
            setSecret.setPendingCredential(pendingCredential);
        }
        setSecret.setNewUser(newUser);
        ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forSuccess(setSecret.build()));
    }
    
    public void initializeForTesting(final AuthUI.IdpConfig arguments) {
        this.setArguments((I)arguments);
    }
    
    @Override
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n == 117) {
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
    public final void startSignIn(final HelperActivityBase helperActivityBase) {
        ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forLoading());
        this.startSignIn(helperActivityBase.getAuth(), helperActivityBase, ((AuthUI.IdpConfig)((ViewModelBase<AuthUI.IdpConfig>)this).getArguments()).getProviderId());
    }
    
    @Override
    public void startSignIn(final FirebaseAuth firebaseAuth, final HelperActivityBase helperActivityBase, final String s) {
        ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forLoading());
        final FlowParameters flowParams = helperActivityBase.getFlowParams();
        final OAuthProvider buildOAuthProvider = this.buildOAuthProvider(s, firebaseAuth);
        if (flowParams != null && AuthOperationManager.getInstance().canUpgradeAnonymous(firebaseAuth, flowParams)) {
            this.handleAnonymousUpgradeFlow(firebaseAuth, helperActivityBase, buildOAuthProvider, flowParams);
            return;
        }
        this.handleNormalSignInFlow(firebaseAuth, helperActivityBase, buildOAuthProvider);
    }
}
