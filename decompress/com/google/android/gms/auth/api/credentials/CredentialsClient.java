// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.internal.auth_api.zbn;
import android.app.PendingIntent;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;
import android.content.Context;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import android.app.Activity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApi;

@Deprecated
public class CredentialsClient extends GoogleApi<Auth.AuthCredentialsOptions>
{
    CredentialsClient(final Activity activity, final Auth.AuthCredentialsOptions authCredentialsOptions) {
        super(activity, (Api<Api.ApiOptions>)Auth.b, (Api.ApiOptions)authCredentialsOptions, new ApiExceptionMapper());
    }
    
    CredentialsClient(final Context context, final Auth.AuthCredentialsOptions authCredentialsOptions) {
        super(context, (Api<Api.ApiOptions>)Auth.b, (Api.ApiOptions)authCredentialsOptions, new ApiExceptionMapper());
    }
    
    @Deprecated
    public Task<Void> b(final Credential credential) {
        return PendingResultUtil.c(Auth.e.delete(this.asGoogleApiClient(), credential));
    }
    
    @Deprecated
    public Task<Void> c() {
        return PendingResultUtil.c(Auth.e.disableAutoSignIn(this.asGoogleApiClient()));
    }
    
    @Deprecated
    public PendingIntent d(final HintRequest hintRequest) {
        return zbn.zba(this.getApplicationContext(), (Auth.AuthCredentialsOptions)this.getApiOptions(), hintRequest, ((Auth.AuthCredentialsOptions)this.getApiOptions()).d());
    }
    
    @Deprecated
    public Task<CredentialRequestResponse> e(final CredentialRequest credentialRequest) {
        return PendingResultUtil.a(Auth.e.request(this.asGoogleApiClient(), credentialRequest), new CredentialRequestResponse());
    }
    
    @Deprecated
    public Task<Void> f(final Credential credential) {
        return PendingResultUtil.c(Auth.e.save(this.asGoogleApiClient(), credential));
    }
}
