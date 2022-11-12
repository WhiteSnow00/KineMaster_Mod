// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import java.util.Iterator;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import android.accounts.Account;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.PendingResults;
import java.util.Collection;
import java.util.HashSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import android.os.Parcelable;
import android.os.Bundle;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import android.content.Context;
import com.google.android.gms.common.logging.Logger;

public final class zbm
{
    private static final Logger a;
    
    static {
        a = new Logger("GoogleSignInCommon", new String[0]);
    }
    
    public static Intent a(final Context context, final GoogleSignInOptions googleSignInOptions) {
        zbm.a.a("getFallbackSignInIntent()", new Object[0]);
        final Intent c = c(context, googleSignInOptions);
        c.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return c;
    }
    
    public static Intent b(final Context context, final GoogleSignInOptions googleSignInOptions) {
        zbm.a.a("getNoImplementationSignInIntent()", new Object[0]);
        final Intent c = c(context, googleSignInOptions);
        c.setAction("com.google.android.gms.auth.NO_IMPL");
        return c;
    }
    
    public static Intent c(final Context context, final GoogleSignInOptions googleSignInOptions) {
        zbm.a.a("getSignInIntent()", new Object[0]);
        final SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        final Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, (Class)SignInHubActivity.class);
        final Bundle bundle = new Bundle();
        bundle.putParcelable("config", (Parcelable)signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }
    
    public static GoogleSignInResult d(final Intent intent) {
        if (intent == null) {
            return new GoogleSignInResult(null, Status.i);
        }
        final Status status = (Status)intent.getParcelableExtra("googleSignInStatus");
        final GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount)intent.getParcelableExtra("googleSignInAccount");
        if (googleSignInAccount == null) {
            Status i;
            if ((i = status) == null) {
                i = Status.i;
            }
            return new GoogleSignInResult(null, i);
        }
        return new GoogleSignInResult(googleSignInAccount, Status.g);
    }
    
    public static OptionalPendingResult e(final GoogleApiClient googleApiClient, final Context context, final GoogleSignInOptions googleSignInOptions, final boolean b) {
        final Logger a = zbm.a;
        a.a("silentSignIn()", new Object[0]);
        a.a("getEligibleSavedSignInResult()", new Object[0]);
        Preconditions.k(googleSignInOptions);
        final GoogleSignInOptions b2 = zbn.c(context).b();
        GoogleSignInResult googleSignInResult = null;
        Label_0207: {
            Label_0046: {
                if (b2 != null) {
                    final Account k1 = b2.k1();
                    final Account k2 = googleSignInOptions.k1();
                    if (k1 == null) {
                        if (k2 != null) {
                            break Label_0046;
                        }
                    }
                    else if (!k1.equals((Object)k2)) {
                        break Label_0046;
                    }
                    if (!googleSignInOptions.Q1()) {
                        if (googleSignInOptions.P1()) {
                            if (!b2.P1()) {
                                break Label_0046;
                            }
                            if (!Objects.b(googleSignInOptions.N1(), b2.N1())) {
                                break Label_0046;
                            }
                        }
                        if (new HashSet(b2.M1()).containsAll(new HashSet(googleSignInOptions.M1()))) {
                            final GoogleSignInAccount a2 = zbn.c(context).a();
                            if (a2 != null && !a2.T1()) {
                                googleSignInResult = new GoogleSignInResult(a2, Status.g);
                                break Label_0207;
                            }
                        }
                    }
                }
            }
            googleSignInResult = null;
        }
        if (googleSignInResult != null) {
            a.a("Eligible saved sign in result found", new Object[0]);
            return PendingResults.b(googleSignInResult, googleApiClient);
        }
        if (b) {
            return PendingResults.b(new GoogleSignInResult(null, new Status(4)), googleApiClient);
        }
        a.a("trySilentSignIn()", new Object[0]);
        return new OptionalPendingResultImpl(googleApiClient.h(new b(googleApiClient, context, googleSignInOptions)));
    }
    
    public static PendingResult f(final GoogleApiClient googleApiClient, final Context context, final boolean b) {
        zbm.a.a("Revoking access", new Object[0]);
        final String e = Storage.b(context).e();
        h(context);
        if (b) {
            return zbb.a(e);
        }
        return googleApiClient.i(new f(googleApiClient));
    }
    
    public static PendingResult g(final GoogleApiClient googleApiClient, final Context context, final boolean b) {
        zbm.a.a("Signing out", new Object[0]);
        h(context);
        if (b) {
            return PendingResults.c(Status.g, googleApiClient);
        }
        return googleApiClient.i(new d(googleApiClient));
    }
    
    private static void h(final Context context) {
        zbn.c(context).d();
        final Iterator<GoogleApiClient> iterator = GoogleApiClient.j().iterator();
        while (iterator.hasNext()) {
            iterator.next().o();
        }
        GoogleApiManager.a();
    }
}
