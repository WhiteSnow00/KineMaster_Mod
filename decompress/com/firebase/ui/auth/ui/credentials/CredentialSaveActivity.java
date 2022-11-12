// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.credentials;

import com.firebase.ui.auth.viewmodel.OperableViewModel;
import android.util.Log;
import com.firebase.ui.auth.data.model.Resource;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import com.firebase.ui.auth.viewmodel.ResourceObserver;
import androidx.lifecycle.r0;
import androidx.lifecycle.o0;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import com.firebase.ui.auth.ui.HelperActivityBase;
import android.content.Intent;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.auth.api.credentials.Credential;
import com.firebase.ui.auth.data.model.FlowParameters;
import android.content.Context;
import com.firebase.ui.auth.viewmodel.smartlock.SmartLockHandler;
import com.firebase.ui.auth.ui.InvisibleActivityBase;

public class CredentialSaveActivity extends InvisibleActivityBase
{
    private static final String TAG = "CredentialSaveActivity";
    private SmartLockHandler mHandler;
    
    public static Intent createIntent(final Context context, final FlowParameters flowParameters, final Credential credential, final IdpResponse idpResponse) {
        return HelperActivityBase.createBaseIntent(context, CredentialSaveActivity.class, flowParameters).putExtra("extra_credential", (Parcelable)credential).putExtra("extra_idp_response", (Parcelable)idpResponse);
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        this.mHandler.onActivityResult(n, n2);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final IdpResponse response = (IdpResponse)this.getIntent().getParcelableExtra("extra_idp_response");
        final Credential credential = (Credential)this.getIntent().getParcelableExtra("extra_credential");
        (this.mHandler = new o0(this).a(SmartLockHandler.class)).init((I)this.getFlowParams());
        this.mHandler.setResponse(response);
        ((OperableViewModel<I, Resource<T>>)this.mHandler).getOperation().observe(this, (a0<? super Resource<T>>)new ResourceObserver<IdpResponse>(this, this, response) {
            final CredentialSaveActivity this$0;
            final IdpResponse val$response;
            
            @Override
            protected void onFailure(final Exception ex) {
                this.this$0.finish(-1, this.val$response.toIntent());
            }
            
            @Override
            protected void onSuccess(final IdpResponse idpResponse) {
                this.this$0.finish(-1, idpResponse.toIntent());
            }
            
            @Override
            protected /* bridge */ void onSuccess(final Object o) {
                this.onSuccess((IdpResponse)o);
            }
        });
        if (((OperableViewModel<I, Resource>)this.mHandler).getOperation().getValue() == null) {
            Log.d("CredentialSaveActivity", "Launching save operation.");
            this.mHandler.saveCredentials(credential);
        }
        else {
            Log.d("CredentialSaveActivity", "Save operation in progress, doing nothing.");
        }
    }
}
