// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.remote;

import com.firebase.ui.auth.ui.HelperActivityBase;
import android.app.Application;
import com.firebase.ui.auth.viewmodel.ProviderSignInBase;

public abstract class SingleProviderSignInHandler<T> extends ProviderSignInBase<T>
{
    private final String mProviderId;
    
    protected SingleProviderSignInHandler(final Application application, final String mProviderId) {
        super(application);
        this.mProviderId = mProviderId;
    }
    
    @Override
    public final void startSignIn(final HelperActivityBase helperActivityBase) {
        this.startSignIn(helperActivityBase.getAuth(), helperActivityBase, this.mProviderId);
    }
}
