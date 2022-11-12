// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.remote;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.OAuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnSuccessListener;
import com.firebase.ui.auth.util.data.AuthOperationManager;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.google.firebase.auth.OAuthProvider;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;

public class GenericIdpAnonymousUpgradeLinkingHandler extends GenericIdpSignInHandler
{
    public GenericIdpAnonymousUpgradeLinkingHandler(final Application application) {
        super(application);
    }
    
    static void access$000(final GenericIdpAnonymousUpgradeLinkingHandler genericIdpAnonymousUpgradeLinkingHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)genericIdpAnonymousUpgradeLinkingHandler).setResult((Resource<IdpResponse>)result);
    }
    
    private void handleAnonymousUpgradeLinkingFlow(final HelperActivityBase helperActivityBase, final OAuthProvider oAuthProvider, final FlowParameters flowParameters) {
        AuthOperationManager.getInstance().safeGenericIdpSignIn(helperActivityBase, oAuthProvider, flowParameters).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, helperActivityBase.getAuthUI().isUseEmulator(), oAuthProvider) {
            final GenericIdpAnonymousUpgradeLinkingHandler this$0;
            final OAuthProvider val$provider;
            final boolean val$useEmulator;
            
            public void onSuccess(final AuthResult authResult) {
                this.this$0.handleSuccess(this.val$useEmulator, this.val$provider.c(), authResult.l0(), (OAuthCredential)authResult.getCredential(), true);
            }
            
            public /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((AuthResult)o);
            }
        }).f((OnFailureListener)new OnFailureListener(this) {
            final GenericIdpAnonymousUpgradeLinkingHandler this$0;
            
            public void onFailure(final Exception ex) {
                GenericIdpAnonymousUpgradeLinkingHandler.access$000(this.this$0, Resource.forFailure(ex));
            }
        });
    }
    
    @Override
    public void startSignIn(final FirebaseAuth firebaseAuth, final HelperActivityBase helperActivityBase, final String s) {
        ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forLoading());
        final FlowParameters flowParams = helperActivityBase.getFlowParams();
        final OAuthProvider buildOAuthProvider = this.buildOAuthProvider(s, firebaseAuth);
        if (flowParams != null && AuthOperationManager.getInstance().canUpgradeAnonymous(firebaseAuth, flowParams)) {
            this.handleAnonymousUpgradeLinkingFlow(helperActivityBase, buildOAuthProvider, flowParams);
            return;
        }
        this.handleNormalSignInFlow(firebaseAuth, helperActivityBase, buildOAuthProvider);
    }
}
