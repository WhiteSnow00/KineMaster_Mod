// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.remote;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.google.firebase.auth.FirebaseAuth;
import com.firebase.ui.auth.FirebaseUiException;
import android.util.Log;
import com.firebase.ui.auth.data.model.UserCancellationException;
import com.google.android.gms.common.api.ApiException;
import android.content.Intent;
import com.firebase.ui.auth.data.model.IntentRequiredException;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.firebase.ui.auth.data.model.Resource;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import android.app.Application;
import com.firebase.ui.auth.AuthUI;

public class GoogleSignInHandler extends SingleProviderSignInHandler<Params>
{
    private static final String TAG = "GoogleSignInHandler";
    private AuthUI.IdpConfig mConfig;
    private String mEmail;
    
    public GoogleSignInHandler(final Application application) {
        super(application, "google.com");
    }
    
    private static IdpResponse createIdpResponse(final GoogleSignInAccount googleSignInAccount) {
        return new IdpResponse.Builder(new User.Builder("google.com", googleSignInAccount.L1()).setName(googleSignInAccount.K1()).setPhotoUri(googleSignInAccount.Q1()).build()).setToken(googleSignInAccount.P1()).build();
    }
    
    private GoogleSignInOptions getSignInOptions() {
        final GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder((GoogleSignInOptions)this.mConfig.getParams().getParcelable("extra_google_sign_in_options"));
        if (!TextUtils.isEmpty((CharSequence)this.mEmail)) {
            builder.g(this.mEmail);
        }
        return builder.a();
    }
    
    private void start() {
        ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forLoading());
        ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forFailure(new IntentRequiredException(GoogleSignIn.b(this.getApplication(), this.getSignInOptions()).b(), 110)));
    }
    
    @Override
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n != 110) {
            return;
        }
        try {
            ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forSuccess(createIdpResponse((GoogleSignInAccount)GoogleSignIn.d(intent).q((Class)ApiException.class))));
        }
        catch (final ApiException ex) {
            if (ex.getStatusCode() == 5) {
                this.mEmail = null;
                this.start();
            }
            else if (ex.getStatusCode() == 12502) {
                this.start();
            }
            else if (ex.getStatusCode() == 12501) {
                ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult(Resource.forFailure(new UserCancellationException()));
            }
            else {
                if (ex.getStatusCode() == 10) {
                    Log.w("GoogleSignInHandler", "Developer error: this application is misconfigured. Check your SHA1 and package name in the Firebase console.");
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Code: ");
                sb.append(ex.getStatusCode());
                sb.append(", message: ");
                sb.append(ex.getMessage());
                ((OperableViewModel<I, Resource<IdpResponse>>)this).setResult((Resource<IdpResponse>)Resource.forFailure(new FirebaseUiException(4, sb.toString())));
            }
        }
    }
    
    @Override
    protected void onCreate() {
        final Params params = ((ViewModelBase<Params>)this).getArguments();
        this.mConfig = Params.access$000(params);
        this.mEmail = Params.access$100(params);
    }
    
    @Override
    public void startSignIn(final FirebaseAuth firebaseAuth, final HelperActivityBase helperActivityBase, final String s) {
        this.start();
    }
    
    public static final class Params
    {
        private final AuthUI.IdpConfig config;
        private final String email;
        
        public Params(final AuthUI.IdpConfig idpConfig) {
            this(idpConfig, null);
        }
        
        public Params(final AuthUI.IdpConfig config, final String email) {
            this.config = config;
            this.email = email;
        }
        
        static AuthUI.IdpConfig access$000(final Params params) {
            return params.config;
        }
        
        static String access$100(final Params params) {
            return params.email;
        }
    }
}
