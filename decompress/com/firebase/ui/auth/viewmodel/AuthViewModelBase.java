// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel;

import com.firebase.ui.auth.util.GoogleApiUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import android.app.Application;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.firebase.auth.FirebaseAuth;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.FlowParameters;

public abstract class AuthViewModelBase<T> extends OperableViewModel<FlowParameters, Resource<T>>
{
    private FirebaseAuth mAuth;
    private CredentialsClient mCredentialsClient;
    
    protected AuthViewModelBase(final Application application) {
        super(application);
    }
    
    protected FirebaseAuth getAuth() {
        return this.mAuth;
    }
    
    protected CredentialsClient getCredentialsClient() {
        return this.mCredentialsClient;
    }
    
    public FirebaseUser getCurrentUser() {
        return this.mAuth.h();
    }
    
    public void initializeForTesting(final FlowParameters arguments, final FirebaseAuth mAuth, final CredentialsClient mCredentialsClient) {
        this.setArguments((I)arguments);
        this.mAuth = mAuth;
        this.mCredentialsClient = mCredentialsClient;
    }
    
    @Override
    protected void onCreate() {
        this.mAuth = FirebaseAuth.getInstance(FirebaseApp.n(this.getArguments().appName));
        this.mCredentialsClient = GoogleApiUtils.getCredentialsClient(this.getApplication());
    }
}
