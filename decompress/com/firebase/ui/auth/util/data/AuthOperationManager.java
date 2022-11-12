// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.data;

import com.google.android.gms.tasks.Continuation;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FederatedAuthProvider;
import android.app.Activity;
import com.google.firebase.auth.OAuthProvider;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class AuthOperationManager
{
    private static String firebaseAppName = "FUIScratchApp";
    private static AuthOperationManager mAuthManager;
    public FirebaseAuth mScratchAuth;
    
    private AuthOperationManager() {
    }
    
    public static AuthOperationManager getInstance() {
        synchronized (AuthOperationManager.class) {
            if (AuthOperationManager.mAuthManager == null) {
                AuthOperationManager.mAuthManager = new AuthOperationManager();
            }
            return AuthOperationManager.mAuthManager;
        }
    }
    
    private FirebaseApp getScratchApp(final FirebaseApp firebaseApp) {
        try {
            return FirebaseApp.n(AuthOperationManager.firebaseAppName);
        }
        catch (final IllegalStateException ex) {
            return FirebaseApp.u(firebaseApp.l(), firebaseApp.p(), AuthOperationManager.firebaseAppName);
        }
    }
    
    private FirebaseAuth getScratchAuth(final FlowParameters flowParameters) {
        if (this.mScratchAuth == null) {
            final AuthUI instance = AuthUI.getInstance(flowParameters.appName);
            this.mScratchAuth = FirebaseAuth.getInstance(this.getScratchApp(instance.getApp()));
            if (instance.isUseEmulator()) {
                this.mScratchAuth.y(instance.getEmulatorHost(), instance.getEmulatorPort());
            }
        }
        return this.mScratchAuth;
    }
    
    public boolean canUpgradeAnonymous(final FirebaseAuth firebaseAuth, final FlowParameters flowParameters) {
        return flowParameters.isAnonymousUpgradeEnabled() && firebaseAuth.h() != null && firebaseAuth.h().T1();
    }
    
    public Task<AuthResult> createOrLinkUserWithEmailAndPassword(final FirebaseAuth firebaseAuth, final FlowParameters flowParameters, final String s, final String s2) {
        if (this.canUpgradeAnonymous(firebaseAuth, flowParameters)) {
            return firebaseAuth.h().U1(EmailAuthProvider.a(s, s2));
        }
        return firebaseAuth.e(s, s2);
    }
    
    public Task<AuthResult> safeGenericIdpSignIn(final HelperActivityBase helperActivityBase, final OAuthProvider oAuthProvider, final FlowParameters flowParameters) {
        return this.getScratchAuth(flowParameters).w(helperActivityBase, oAuthProvider);
    }
    
    public Task<AuthResult> safeLink(final AuthCredential authCredential, final AuthCredential authCredential2, final FlowParameters flowParameters) {
        return (Task<AuthResult>)this.getScratchAuth(flowParameters).t(authCredential).m((Continuation)new Continuation<AuthResult, Task<AuthResult>>(this, authCredential2) {
            final AuthOperationManager this$0;
            final AuthCredential val$credentialToLink;
            
            public Task<AuthResult> then(final Task<AuthResult> task) throws Exception {
                Task<AuthResult> u1 = task;
                if (task.t()) {
                    u1 = ((AuthResult)task.p()).l0().U1(this.val$credentialToLink);
                }
                return u1;
            }
            
            public /* bridge */ Object then(final Task task) throws Exception {
                return this.then((Task<AuthResult>)task);
            }
        });
    }
    
    public Task<AuthResult> signInAndLinkWithCredential(final FirebaseAuth firebaseAuth, final FlowParameters flowParameters, final AuthCredential authCredential) {
        if (this.canUpgradeAnonymous(firebaseAuth, flowParameters)) {
            return firebaseAuth.h().U1(authCredential);
        }
        return firebaseAuth.t(authCredential);
    }
    
    public Task<AuthResult> validateCredential(final AuthCredential authCredential, final FlowParameters flowParameters) {
        return this.getScratchAuth(flowParameters).t(authCredential);
    }
}
