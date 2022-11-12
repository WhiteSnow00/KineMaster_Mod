// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.remote;

import com.firebase.ui.auth.viewmodel.ViewModelBase;
import com.google.android.gms.common.api.ResolvableApiException;
import com.firebase.ui.auth.data.model.PendingIntentRequiredException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.auth.api.credentials.CredentialRequestResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.firebase.ui.auth.ui.email.EmailLinkCatcherActivity;
import com.firebase.ui.auth.data.model.UserCancellationException;
import android.content.Intent;
import com.firebase.ui.auth.ui.idp.AuthMethodPickerActivity;
import com.firebase.ui.auth.ui.phone.PhoneActivity;
import android.os.Bundle;
import com.firebase.ui.auth.ui.email.EmailActivity;
import com.firebase.ui.auth.data.model.IntentRequiredException;
import com.firebase.ui.auth.ui.idp.SingleSignInActivity;
import com.firebase.ui.auth.util.GoogleApiUtils;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.firebase.ui.auth.data.model.User;
import android.text.TextUtils;
import java.util.Iterator;
import com.firebase.ui.auth.util.data.ProviderUtils;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.data.model.FlowParameters;
import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.firebase.auth.AuthResult;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.Resource;
import android.app.Application;
import com.firebase.ui.auth.viewmodel.SignInViewModelBase;

public class SignInKickstarter extends SignInViewModelBase
{
    public SignInKickstarter(final Application application) {
        super(application);
    }
    
    static void access$000(final SignInKickstarter signInKickstarter, final Resource result) {
        signInKickstarter.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$100(final SignInKickstarter signInKickstarter, final IdpResponse idpResponse, final AuthResult authResult) {
        signInKickstarter.handleSuccess(idpResponse, authResult);
    }
    
    static void access$200(final SignInKickstarter signInKickstarter, final Credential credential) {
        signInKickstarter.handleCredential(credential);
    }
    
    static void access$300(final SignInKickstarter signInKickstarter, final Resource result) {
        signInKickstarter.setResult((Resource<IdpResponse>)result);
    }
    
    static void access$400(final SignInKickstarter signInKickstarter) {
        signInKickstarter.startAuthMethodChoice();
    }
    
    static void access$500(final SignInKickstarter signInKickstarter, final IdpResponse idpResponse, final AuthResult authResult) {
        signInKickstarter.handleSuccess(idpResponse, authResult);
    }
    
    private List<String> getCredentialAccountTypes() {
        final ArrayList list = new ArrayList();
        final Iterator<AuthUI.IdpConfig> iterator = ((ViewModelBase<FlowParameters>)this).getArguments().providers.iterator();
        while (iterator.hasNext()) {
            final String providerId = iterator.next().getProviderId();
            if (providerId.equals("google.com")) {
                list.add(ProviderUtils.providerIdToAccountType(providerId));
            }
        }
        return list;
    }
    
    private void handleCredential(final Credential credential) {
        final String n1 = credential.N1();
        final String q1 = credential.Q1();
        if (TextUtils.isEmpty((CharSequence)q1)) {
            if (credential.K1() == null) {
                this.startAuthMethodChoice();
            }
            else {
                this.redirectSignIn(ProviderUtils.accountTypeToProviderId(credential.K1()), n1);
            }
        }
        else {
            final IdpResponse build = new IdpResponse.Builder(new User.Builder("password", n1).build()).build();
            this.setResult(Resource.forLoading());
            this.getAuth().u(n1, q1).i((OnSuccessListener)new OnSuccessListener<AuthResult>(this, build) {
                final SignInKickstarter this$0;
                final IdpResponse val$response;
                
                public void onSuccess(final AuthResult authResult) {
                    SignInKickstarter.access$500(this.this$0, this.val$response, authResult);
                }
                
                public /* bridge */ void onSuccess(final Object o) {
                    this.onSuccess((AuthResult)o);
                }
            }).f((OnFailureListener)new OnFailureListener(this, credential) {
                final SignInKickstarter this$0;
                final Credential val$credential;
                
                public void onFailure(final Exception ex) {
                    if (ex instanceof FirebaseAuthInvalidUserException || ex instanceof FirebaseAuthInvalidCredentialsException) {
                        GoogleApiUtils.getCredentialsClient(this.this$0.getApplication()).b(this.val$credential);
                    }
                    SignInKickstarter.access$400(this.this$0);
                }
            });
        }
    }
    
    private void redirectSignIn(final String s, final String s2) {
        s.hashCode();
        if (!s.equals("phone")) {
            if (!s.equals("password")) {
                this.setResult(Resource.forFailure(new IntentRequiredException(SingleSignInActivity.createIntent(this.getApplication(), ((ViewModelBase<FlowParameters>)this).getArguments(), new User.Builder(s, s2).build()), 109)));
            }
            else {
                this.setResult(Resource.forFailure(new IntentRequiredException(EmailActivity.createIntent(this.getApplication(), ((ViewModelBase<FlowParameters>)this).getArguments(), s2), 106)));
            }
        }
        else {
            final Bundle bundle = new Bundle();
            bundle.putString("extra_phone_number", s2);
            this.setResult((Resource<IdpResponse>)Resource.forFailure(new IntentRequiredException(PhoneActivity.createIntent(this.getApplication(), ((ViewModelBase<FlowParameters>)this).getArguments(), bundle), 107)));
        }
    }
    
    private void startAuthMethodChoice() {
        if (!((ViewModelBase<FlowParameters>)this).getArguments().shouldShowProviderChoice()) {
            final AuthUI.IdpConfig defaultOrFirstProvider = ((ViewModelBase<FlowParameters>)this).getArguments().getDefaultOrFirstProvider();
            final String providerId = defaultOrFirstProvider.getProviderId();
            providerId.hashCode();
            int n = -1;
            switch (providerId) {
                case "emailLink": {
                    n = 2;
                    break;
                }
                case "password": {
                    n = 1;
                    break;
                }
                case "phone": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    this.redirectSignIn(providerId, null);
                    break;
                }
                case 1:
                case 2: {
                    this.setResult(Resource.forFailure(new IntentRequiredException(EmailActivity.createIntent(this.getApplication(), ((ViewModelBase<FlowParameters>)this).getArguments()), 106)));
                    break;
                }
                case 0: {
                    this.setResult((Resource<IdpResponse>)Resource.forFailure(new IntentRequiredException(PhoneActivity.createIntent(this.getApplication(), ((ViewModelBase<FlowParameters>)this).getArguments(), defaultOrFirstProvider.getParams()), 107)));
                    break;
                }
            }
        }
        else {
            this.setResult(Resource.forFailure(new IntentRequiredException(AuthMethodPickerActivity.createIntent(this.getApplication(), ((ViewModelBase<FlowParameters>)this).getArguments()), 105)));
        }
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n != 101) {
            if (n != 109) {
                switch (n) {
                    default: {
                        return;
                    }
                    case 105:
                    case 106:
                    case 107: {
                        break;
                    }
                }
            }
            if (n2 == 113 || n2 == 114) {
                this.startAuthMethodChoice();
                return;
            }
            final IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
            if (fromResultIntent == null) {
                this.setResult(Resource.forFailure(new UserCancellationException()));
            }
            else if (fromResultIntent.isSuccessful()) {
                this.setResult(Resource.forSuccess(fromResultIntent));
            }
            else if (fromResultIntent.getError().getErrorCode() == 5) {
                this.handleMergeFailure(fromResultIntent);
            }
            else {
                this.setResult((Resource<IdpResponse>)Resource.forFailure(fromResultIntent.getError()));
            }
        }
        else if (n2 == -1) {
            this.handleCredential((Credential)intent.getParcelableExtra("com.google.android.gms.credentials.Credential"));
        }
        else {
            this.startAuthMethodChoice();
        }
    }
    
    public void start() {
        if (!TextUtils.isEmpty((CharSequence)((ViewModelBase<FlowParameters>)this).getArguments().emailLink)) {
            this.setResult(Resource.forFailure(new IntentRequiredException(EmailLinkCatcherActivity.createIntent(this.getApplication(), ((ViewModelBase<FlowParameters>)this).getArguments()), 106)));
            return;
        }
        final Task<AuthResult> k = this.getAuth().k();
        if (k != null) {
            k.i((OnSuccessListener)new OnSuccessListener<AuthResult>(this) {
                final SignInKickstarter this$0;
                
                public void onSuccess(final AuthResult authResult) {
                    SignInKickstarter.access$100(this.this$0, new IdpResponse.Builder(new User.Builder(authResult.getCredential().K1(), authResult.l0().M1()).build()).build(), authResult);
                }
                
                public /* bridge */ void onSuccess(final Object o) {
                    this.onSuccess((AuthResult)o);
                }
            }).f((OnFailureListener)new OnFailureListener(this) {
                final SignInKickstarter this$0;
                
                public void onFailure(final Exception ex) {
                    SignInKickstarter.access$000(this.this$0, Resource.forFailure(ex));
                }
            });
            return;
        }
        final AuthUI.IdpConfig configFromIdps = ProviderUtils.getConfigFromIdps(((ViewModelBase<FlowParameters>)this).getArguments().providers, "password");
        final int n = 1;
        final boolean b = configFromIdps != null;
        final List<String> credentialAccountTypes = this.getCredentialAccountTypes();
        int n2 = n;
        if (!b) {
            if (credentialAccountTypes.size() > 0) {
                n2 = n;
            }
            else {
                n2 = 0;
            }
        }
        if (((ViewModelBase<FlowParameters>)this).getArguments().enableCredentials && n2 != 0) {
            this.setResult(Resource.forLoading());
            GoogleApiUtils.getCredentialsClient(this.getApplication()).e(new CredentialRequest.Builder().c(b).b((String[])credentialAccountTypes.toArray(new String[credentialAccountTypes.size()])).a()).c((OnCompleteListener)new OnCompleteListener<CredentialRequestResponse>(this) {
                final SignInKickstarter this$0;
                
                public void onComplete(final Task<CredentialRequestResponse> task) {
                    try {
                        SignInKickstarter.access$200(this.this$0, ((CredentialRequestResponse)task.q((Class)ApiException.class)).k());
                    }
                    catch (final ApiException ex) {
                        SignInKickstarter.access$400(this.this$0);
                    }
                    catch (final ResolvableApiException ex2) {
                        if (ex2.getStatusCode() == 6) {
                            SignInKickstarter.access$300(this.this$0, Resource.forFailure(new PendingIntentRequiredException(ex2.getResolution(), 101)));
                        }
                        else {
                            SignInKickstarter.access$400(this.this$0);
                        }
                    }
                }
            });
        }
        else {
            this.startAuthMethodChoice();
        }
    }
}
