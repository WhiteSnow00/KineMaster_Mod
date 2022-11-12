// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui;

import com.firebase.ui.auth.ui.credentials.CredentialSaveActivity;
import com.firebase.ui.auth.util.CredentialUtils;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseUser;
import android.net.ConnectivityManager;
import com.google.firebase.auth.FirebaseAuth;
import com.firebase.ui.auth.AuthUI;
import android.os.Parcelable;
import com.firebase.ui.auth.util.Preconditions;
import android.content.Intent;
import android.app.Activity;
import android.content.Context;
import com.firebase.ui.auth.data.model.FlowParameters;
import androidx.appcompat.app.d;

public abstract class HelperActivityBase extends d implements ProgressView
{
    private FlowParameters mParams;
    
    protected static Intent createBaseIntent(final Context context, final Class<? extends Activity> clazz, final FlowParameters flowParameters) {
        final Intent putExtra = new Intent((Context)Preconditions.checkNotNull(context, "context cannot be null", new Object[0]), (Class)Preconditions.checkNotNull(clazz, "target activity cannot be null", new Object[0])).putExtra("extra_flow_params", (Parcelable)Preconditions.checkNotNull((Parcelable)flowParameters, "flowParams cannot be null", new Object[0]));
        putExtra.setExtrasClassLoader(AuthUI.class.getClassLoader());
        return putExtra;
    }
    
    public void finish(final int n, final Intent intent) {
        this.setResult(n, intent);
        this.finish();
    }
    
    public FirebaseAuth getAuth() {
        return this.getAuthUI().getAuth();
    }
    
    public AuthUI getAuthUI() {
        return AuthUI.getInstance(this.getFlowParams().appName);
    }
    
    public FlowParameters getFlowParams() {
        if (this.mParams == null) {
            this.mParams = FlowParameters.fromIntent(this.getIntent());
        }
        return this.mParams;
    }
    
    protected boolean isOffline() {
        final ConnectivityManager connectivityManager = (ConnectivityManager)this.getApplicationContext().getSystemService("connectivity");
        return connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 102 || n2 == 5) {
            this.finish(n2, intent);
        }
    }
    
    public void startSaveCredentials(final FirebaseUser firebaseUser, final IdpResponse idpResponse, final String s) {
        this.startActivityForResult(CredentialSaveActivity.createIntent((Context)this, this.getFlowParams(), CredentialUtils.buildCredential(firebaseUser, s, ProviderUtils.idpResponseToAccountType(idpResponse)), idpResponse), 102);
    }
}
