// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.viewmodel;

import com.google.firebase.auth.FirebaseAuth;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import android.app.Application;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;

public abstract class ProviderSignInBase<T> extends OperableViewModel<T, Resource<IdpResponse>>
{
    protected ProviderSignInBase(final Application application) {
        super(application);
    }
    
    public ProviderSignInBase<T> initWith(final T t) {
        super.init((I)t);
        return this;
    }
    
    public abstract void onActivityResult(final int p0, final int p1, final Intent p2);
    
    public abstract void startSignIn(final HelperActivityBase p0);
    
    public abstract void startSignIn(final FirebaseAuth p0, final HelperActivityBase p1, final String p2);
}
