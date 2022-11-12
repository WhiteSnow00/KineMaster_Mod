// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.Objects;
import android.content.Context;
import com.google.android.gms.auth.api.signin.SignInAccount;
import android.view.accessibility.AccessibilityEvent;
import android.content.ActivityNotFoundException;
import android.util.Log;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import androidx.loader.app.a;
import android.os.Bundle;
import android.content.Intent;
import com.google.android.gms.common.annotation.KeepName;
import androidx.fragment.app.h;

@KeepName
public class SignInHubActivity extends h
{
    private static boolean f = false;
    private boolean a;
    private SignInConfiguration b;
    private boolean c;
    private int d;
    private Intent e;
    
    public SignInHubActivity() {
        this.a = false;
    }
    
    static /* bridge */ int q(final SignInHubActivity signInHubActivity) {
        return signInHubActivity.d;
    }
    
    static /* bridge */ Intent r(final SignInHubActivity signInHubActivity) {
        return signInHubActivity.e;
    }
    
    private final void s() {
        this.getSupportLoaderManager().c(0, null, (androidx.loader.app.a.a<Object>)new com.google.android.gms.auth.api.signin.internal.h(this, null));
        SignInHubActivity.f = false;
    }
    
    private final void t(final int n) {
        final Status status = new Status(n);
        final Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", (Parcelable)status);
        this.setResult(0, intent);
        this.finish();
        SignInHubActivity.f = false;
    }
    
    private final void u(final String s) {
        final Intent intent = new Intent(s);
        if (s.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        }
        else {
            intent.setPackage(this.getPackageName());
        }
        intent.putExtra("config", (Parcelable)this.b);
        try {
            this.startActivityForResult(intent, 40962);
        }
        catch (final ActivityNotFoundException ex) {
            this.a = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            this.t(17);
        }
    }
    
    public final boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        return true;
    }
    
    @Override
    protected final void onActivityResult(int n, int intExtra, final Intent e) {
        if (this.a) {
            return;
        }
        this.setResult(0);
        if (n != 40962) {
            return;
        }
        if (e != null) {
            final SignInAccount signInAccount = (SignInAccount)e.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.K1() != null) {
                final GoogleSignInAccount k1 = signInAccount.K1();
                final zbn c = zbn.c((Context)this);
                final GoogleSignInOptions k2 = this.b.K1();
                Objects.requireNonNull(k1);
                c.e(k2, k1);
                e.removeExtra("signInAccount");
                e.putExtra("googleSignInAccount", (Parcelable)k1);
                this.c = true;
                this.d = intExtra;
                this.e = e;
                this.s();
                return;
            }
            if (e.hasExtra("errorCode")) {
                intExtra = e.getIntExtra("errorCode", 8);
                if ((n = intExtra) == 13) {
                    n = 12501;
                }
                this.t(n);
                return;
            }
        }
        this.t(8);
    }
    
    @Override
    protected final void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = this.getIntent();
        final String action = intent.getAction();
        Objects.requireNonNull(action);
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            this.t(12500);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Log.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            this.finish();
            return;
        }
        final Bundle bundleExtra = intent.getBundleExtra("config");
        Objects.requireNonNull(bundleExtra);
        final SignInConfiguration b = (SignInConfiguration)bundleExtra.getParcelable("config");
        if (b == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            this.setResult(0);
            this.finish();
            return;
        }
        this.b = b;
        if (bundle != null) {
            final boolean boolean1 = bundle.getBoolean("signingInGoogleApiClients");
            this.c = boolean1;
            if (boolean1) {
                this.d = bundle.getInt("signInResultCode");
                final Intent e = (Intent)bundle.getParcelable("signInResultData");
                Objects.requireNonNull(e);
                this.e = e;
                this.s();
            }
            return;
        }
        if (SignInHubActivity.f) {
            this.setResult(0);
            this.t(12502);
            return;
        }
        SignInHubActivity.f = true;
        this.u(action);
    }
    
    public final void onDestroy() {
        super.onDestroy();
        SignInHubActivity.f = false;
    }
    
    @Override
    protected final void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.c);
        if (this.c) {
            bundle.putInt("signInResultCode", this.d);
            bundle.putParcelable("signInResultData", (Parcelable)this.e);
        }
    }
}
