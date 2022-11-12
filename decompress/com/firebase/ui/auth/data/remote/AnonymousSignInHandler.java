// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.remote;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnSuccessListener;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;
import com.google.firebase.auth.FirebaseAuth;
import com.firebase.ui.auth.data.model.FlowParameters;

public class AnonymousSignInHandler extends SingleProviderSignInHandler<FlowParameters>
{
    public FirebaseAuth mAuth;
    
    public AnonymousSignInHandler(final Application application) {
        super(application, "anonymous");
    }
    
    static void access$000(final AnonymousSignInHandler anonymousSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)anonymousSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static IdpResponse access$100(final AnonymousSignInHandler anonymousSignInHandler, final boolean b) {
        return anonymousSignInHandler.initResponse(b);
    }
    
    static void access$200(final AnonymousSignInHandler anonymousSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)anonymousSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    private FirebaseAuth getAuth() {
        return AuthUI.getInstance(((ViewModelBase<FlowParameters>)this).getArguments().appName).getAuth();
    }
    
    private IdpResponse initResponse(final boolean newUser) {
        return new IdpResponse.Builder(new User.Builder("anonymous", null).build()).setNewUser(newUser).build();
    }
    
    @Override
    public void onActivityResult(final int n, final int n2, final Intent intent) {
    }
    
    @Override
    protected void onCreate() {
        this.mAuth = this.getAuth();
    }
    
    @Override
    public void startSignIn(final FirebaseAuth firebaseAuth, final HelperActivityBase helperActivityBase, final String s) {
        ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forLoading());
        this.mAuth.s().i((OnSuccessListener)new OnSuccessListener<AuthResult>(this) {
            final AnonymousSignInHandler this$0;
            
            public void onSuccess(final AuthResult authResult) {
                final AnonymousSignInHandler this$0 = this.this$0;
                AnonymousSignInHandler.access$200(this$0, Resource.forSuccess(AnonymousSignInHandler.access$100(this$0, authResult.d1().isNewUser())));
            }
            
            public /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((AuthResult)o);
            }
        }).f((OnFailureListener)new OnFailureListener(this) {
            final AnonymousSignInHandler this$0;
            
            public void onFailure(final Exception ex) {
                AnonymousSignInHandler.access$000(this.this$0, Resource.forFailure(ex));
            }
        });
    }
}
