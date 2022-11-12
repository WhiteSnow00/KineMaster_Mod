// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.remote;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.firebase.ui.auth.viewmodel.OperableViewModel;
import com.facebook.FacebookRequestError;
import org.json.JSONException;
import com.facebook.GraphResponse;
import org.json.JSONObject;
import android.os.Bundle;
import com.facebook.GraphRequest$GraphJSONObjectCallback;
import com.facebook.GraphRequest;
import com.firebase.ui.auth.FirebaseUiException;
import com.facebook.FacebookException;
import com.firebase.ui.auth.data.model.UserCancellationException;
import android.app.Activity;
import com.facebook.WebDialog;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import com.facebook.login.LoginManager;
import android.content.Intent;
import com.firebase.ui.auth.data.model.User;
import android.net.Uri;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import com.facebook.CallbackManager$Factory;
import android.app.Application;
import java.util.List;
import com.facebook.CallbackManager;
import com.facebook.login.LoginResult;
import com.facebook.FacebookCallback;
import com.firebase.ui.auth.AuthUI;

public class FacebookSignInHandler extends SingleProviderSignInHandler<AuthUI.IdpConfig>
{
    private static final String EMAIL = "email";
    private static final String PUBLIC_PROFILE = "public_profile";
    private final FacebookCallback<LoginResult> mCallback;
    private final CallbackManager mCallbackManager;
    private List<String> mPermissions;
    
    public FacebookSignInHandler(final Application application) {
        super(application, "facebook.com");
        this.mCallback = (FacebookCallback<LoginResult>)new Callback(null);
        this.mCallbackManager = CallbackManager$Factory.create();
    }
    
    static void access$100(final FacebookSignInHandler facebookSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)facebookSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static void access$200(final FacebookSignInHandler facebookSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)facebookSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static void access$300(final FacebookSignInHandler facebookSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)facebookSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static void access$400(final FacebookSignInHandler facebookSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)facebookSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static void access$500(final FacebookSignInHandler facebookSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)facebookSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    static IdpResponse access$600(final LoginResult loginResult, final String s, final String s2, final Uri uri) {
        return createIdpResponse(loginResult, s, s2, uri);
    }
    
    static void access$700(final FacebookSignInHandler facebookSignInHandler, final Object result) {
        ((OperableViewModel<I, Resource<IdpResponse>>)facebookSignInHandler).setResult((Resource<IdpResponse>)result);
    }
    
    private static IdpResponse createIdpResponse(final LoginResult loginResult, final String s, final String name, final Uri photoUri) {
        return new IdpResponse.Builder(new User.Builder("facebook.com", s).setName(name).setPhotoUri(photoUri).build()).setToken(loginResult.getAccessToken().getToken()).build();
    }
    
    @Override
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        this.mCallbackManager.onActivityResult(n, n2, intent);
    }
    
    @Override
    protected void onCleared() {
        super.onCleared();
        LoginManager.getInstance().unregisterCallback(this.mCallbackManager);
    }
    
    @Override
    protected void onCreate() {
        List<Object> list;
        if ((list = ((AuthUI.IdpConfig)((ViewModelBase<AuthUI.IdpConfig>)this).getArguments()).getParams().getStringArrayList("extra_facebook_permissions")) == null) {
            list = Collections.emptyList();
        }
        final ArrayList mPermissions = new ArrayList(list);
        if (!mPermissions.contains("email")) {
            mPermissions.add((Object)"email");
        }
        if (!mPermissions.contains("public_profile")) {
            mPermissions.add((Object)"public_profile");
        }
        this.mPermissions = (List<String>)mPermissions;
        LoginManager.getInstance().registerCallback(this.mCallbackManager, (FacebookCallback)this.mCallback);
    }
    
    @Override
    public void startSignIn(final FirebaseAuth firebaseAuth, final HelperActivityBase helperActivityBase, final String s) {
        WebDialog.setWebDialogTheme(helperActivityBase.getFlowParams().themeId);
        LoginManager.getInstance().logInWithReadPermissions((Activity)helperActivityBase, (Collection)this.mPermissions);
    }
    
    private class Callback implements FacebookCallback<LoginResult>
    {
        final FacebookSignInHandler this$0;
        
        private Callback(final FacebookSignInHandler this$0) {
            this.this$0 = this$0;
        }
        
        Callback(final FacebookSignInHandler facebookSignInHandler, final FacebookSignInHandler$1 object) {
            this(facebookSignInHandler);
        }
        
        public void onCancel() {
            FacebookSignInHandler.access$200(this.this$0, Resource.forFailure(new UserCancellationException()));
        }
        
        public void onError(final FacebookException ex) {
            FacebookSignInHandler.access$300(this.this$0, Resource.forFailure(new FirebaseUiException(4, (Throwable)ex)));
        }
        
        public void onSuccess(final LoginResult loginResult) {
            FacebookSignInHandler.access$100(this.this$0, Resource.forLoading());
            final GraphRequest meRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), (GraphRequest$GraphJSONObjectCallback)this.this$0.new ProfileRequest(loginResult));
            final Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,picture");
            meRequest.setParameters(parameters);
            meRequest.executeAsync();
        }
        
        public /* bridge */ void onSuccess(final Object o) {
            this.onSuccess((LoginResult)o);
        }
    }
    
    private class ProfileRequest implements GraphRequest$GraphJSONObjectCallback
    {
        private final LoginResult mResult;
        final FacebookSignInHandler this$0;
        
        public ProfileRequest(final FacebookSignInHandler this$0, final LoginResult mResult) {
            this.this$0 = this$0;
            this.mResult = mResult;
        }
        
        public void onCompleted(final JSONObject jsonObject, GraphResponse string) {
            final FacebookRequestError error = string.getError();
            if (error != null) {
                FacebookSignInHandler.access$400(this.this$0, Resource.forFailure(new FirebaseUiException(4, (Throwable)error.getException())));
                return;
            }
            if (jsonObject == null) {
                FacebookSignInHandler.access$500(this.this$0, Resource.forFailure(new FirebaseUiException(4, "Facebook graph request failed")));
                return;
            }
            final Uri uri = null;
            try {
                string = (GraphResponse)jsonObject.getString("email");
            }
            catch (final JSONException ex) {
                string = null;
            }
            String string2;
            try {
                string2 = jsonObject.getString("name");
            }
            catch (final JSONException ex2) {
                string2 = null;
            }
            while (true) {
                try {
                    final Uri parse = Uri.parse(jsonObject.getJSONObject("picture").getJSONObject("data").getString("url"));
                    FacebookSignInHandler.access$700(this.this$0, Resource.forSuccess(FacebookSignInHandler.access$600(this.mResult, (String)string, string2, parse)));
                }
                catch (final JSONException ex3) {
                    final Uri parse = uri;
                    continue;
                }
                break;
            }
        }
    }
}
