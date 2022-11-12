// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.auth.api.signin.internal.zbm;
import android.content.Intent;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.common.GoogleApiAvailability;
import android.content.Context;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.auth.api.Auth;
import android.app.Activity;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.api.GoogleApi;

public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions>
{
    private static final b a;
    @VisibleForTesting
    static int b;
    
    static {
        a = new b(null);
        GoogleSignInClient.b = 1;
    }
    
    GoogleSignInClient(final Activity activity, final GoogleSignInOptions googleSignInOptions) {
        super(activity, (Api<Api.ApiOptions>)Auth.c, (Api.ApiOptions)googleSignInOptions, new ApiExceptionMapper());
    }
    
    GoogleSignInClient(final Context context, final GoogleSignInOptions googleSignInOptions) {
        super(context, (Api<Api.ApiOptions>)Auth.c, (Api.ApiOptions)googleSignInOptions, new ApiExceptionMapper());
    }
    
    private final int e() {
        synchronized (this) {
            int b;
            if ((b = GoogleSignInClient.b) == 1) {
                final Context applicationContext = this.getApplicationContext();
                final GoogleApiAvailability q = GoogleApiAvailability.q();
                final int j = q.j(applicationContext, 12451000);
                if (j == 0) {
                    GoogleSignInClient.b = 4;
                    b = 4;
                }
                else if (q.d(applicationContext, j, null) == null && DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") != 0) {
                    GoogleSignInClient.b = 3;
                    b = 3;
                }
                else {
                    GoogleSignInClient.b = 2;
                    b = 2;
                }
            }
            return b;
        }
    }
    
    public Intent b() {
        final Context applicationContext = this.getApplicationContext();
        final int e = this.e();
        final int n = e - 1;
        if (e == 0) {
            throw null;
        }
        if (n == 2) {
            return zbm.a(applicationContext, this.getApiOptions());
        }
        if (n != 3) {
            return zbm.b(applicationContext, this.getApiOptions());
        }
        return zbm.c(applicationContext, this.getApiOptions());
    }
    
    public Task<Void> c() {
        return PendingResultUtil.c((PendingResult<Result>)zbm.f(this.asGoogleApiClient(), this.getApplicationContext(), this.e() == 3));
    }
    
    public Task<GoogleSignInAccount> d() {
        return PendingResultUtil.b(zbm.e(this.asGoogleApiClient(), this.getApplicationContext(), this.getApiOptions(), this.e() == 3), (PendingResultUtil.ResultConverter<Result, GoogleSignInAccount>)GoogleSignInClient.a);
    }
    
    public Task<Void> signOut() {
        return PendingResultUtil.c((PendingResult<Result>)zbm.g(this.asGoogleApiClient(), this.getApplicationContext(), this.e() == 3));
    }
}
