// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.firebase_auth_api.zzc;
import java.util.List;
import androidx.browser.customtabs.d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.ArrayList;
import com.google.android.gms.internal.firebase_auth_api.zztx;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import android.text.TextUtils;
import android.net.Uri$Builder;
import android.content.SharedPreferences$Editor;
import android.content.pm.PackageManager$NameNotFoundException;
import android.net.Uri;
import com.google.android.gms.internal.firebase_auth_api.zztw;
import com.google.android.gms.internal.firebase_auth_api.zzvr;
import java.util.Locale;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.firebase_auth_api.zzxq;
import com.google.firebase.FirebaseApp;
import com.google.android.gms.common.util.DefaultClock;
import android.util.Log;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import android.content.Context;
import l0.a;
import android.content.Intent;
import com.google.android.gms.internal.firebase_auth_api.zzf;
import java.util.concurrent.Executor;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.firebase_auth_api.zzty;
import androidx.fragment.app.h;

@KeepName
public class GenericIdpActivity extends h implements zzty
{
    private static long c;
    private static final zzbm d;
    private final Executor a;
    private boolean b;
    
    static {
        d = zzbm.c();
    }
    
    public GenericIdpActivity() {
        this.a = ((zzc)zzf.zza()).zza(1);
        this.b = false;
    }
    
    private final void r() {
        GenericIdpActivity.c = 0L;
        this.b = false;
        final Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!l0.a.b((Context)this).d(intent)) {
            GenericIdpActivity.d.f((Context)this, zzai.a("WEB_CONTEXT_CANCELED"));
        }
        else {
            GenericIdpActivity.d.d((Context)this);
        }
        this.finish();
    }
    
    private final void s(final Status status) {
        GenericIdpActivity.c = 0L;
        this.b = false;
        final Intent intent = new Intent();
        zzbl.c(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!l0.a.b((Context)this).d(intent)) {
            GenericIdpActivity.d.f(this.getApplicationContext(), status);
        }
        else {
            GenericIdpActivity.d.d((Context)this);
        }
        this.finish();
    }
    
    @Override
    protected final void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final String action = this.getIntent().getAction();
        if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            Log.e("GenericIdpActivity", "Could not do operation - unknown action: ".concat(String.valueOf(action)));
            this.r();
            return;
        }
        final long a = DefaultClock.d().a();
        if (a - GenericIdpActivity.c < 30000L) {
            Log.e("GenericIdpActivity", "Could not start operation - already in progress");
            return;
        }
        GenericIdpActivity.c = a;
        if (bundle != null) {
            this.b = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
        }
    }
    
    public final void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
    }
    
    @Override
    protected final void onResume() {
        super.onResume();
        if ("android.intent.action.VIEW".equals(this.getIntent().getAction())) {
            final Intent intent = this.getIntent();
            if (intent.hasExtra("firebaseError")) {
                this.s(zzbl.b(intent.getStringExtra("firebaseError")));
                return;
            }
            if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
                this.r();
                return;
            }
            final String stringExtra = intent.getStringExtra("link");
            final String stringExtra2 = intent.getStringExtra("eventId");
            final String packageName = this.getPackageName();
            final boolean booleanExtra = intent.getBooleanExtra("encryptionEnabled", true);
            final zzi a = zzj.b().a((Context)this, packageName, stringExtra2);
            if (a == null) {
                this.r();
            }
            String b = stringExtra;
            if (booleanExtra) {
                b = zzk.a(this.getApplicationContext(), FirebaseApp.n(a.a()).q()).b(stringExtra);
            }
            final zzxq zzxq = new zzxq(a, b);
            final String e = a.e();
            final String b2 = a.b();
            zzxq.zzf(e);
            if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(b2) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(b2) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(b2)) {
                Log.e("GenericIdpActivity", "unsupported operation: ".concat(b2));
                this.r();
                return;
            }
            GenericIdpActivity.c = 0L;
            this.b = false;
            final Intent intent2 = new Intent();
            SafeParcelableSerializer.e(zzxq, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
            intent2.putExtra("com.google.firebase.auth.internal.OPERATION", b2);
            intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
            if (!l0.a.b((Context)this).d(intent2)) {
                final SharedPreferences$Editor edit = this.getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
                edit.putString("verifyAssertionRequest", SafeParcelableSerializer.f(zzxq));
                edit.putString("operation", b2);
                edit.putString("tenantId", e);
                edit.putLong("timestamp", DefaultClock.d().a());
                edit.commit();
            }
            else {
                GenericIdpActivity.d.d((Context)this);
            }
            this.finish();
        }
        else {
            if (!this.b) {
                final String packageName2 = this.getPackageName();
                try {
                    final String lowerCase = Hex.b(AndroidUtilsLight.a((Context)this, packageName2)).toLowerCase(Locale.US);
                    final FirebaseApp n = FirebaseApp.n(this.getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
                    if (!zzvr.zzg(n)) {
                        ((AsyncTask)new zztw(packageName2, lowerCase, this.getIntent(), n, (com.google.android.gms.internal.firebase-auth-api.zzty)this)).executeOnExecutor(this.a, (Object[])new Void[0]);
                    }
                    else {
                        this.zzf(this.q(Uri.parse(zzvr.zza(n.p().b())).buildUpon(), this.getIntent(), packageName2, lowerCase).build(), packageName2);
                    }
                }
                catch (final PackageManager$NameNotFoundException ex) {
                    final String string = ex.toString();
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Could not get package signature: ");
                    sb.append(packageName2);
                    sb.append(" ");
                    sb.append(string);
                    Log.e("GenericIdpActivity", sb.toString());
                    ((zzty)this).zze(packageName2, null);
                }
                this.b = true;
                return;
            }
            this.r();
        }
    }
    
    protected final void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.b);
    }
    
    public final Uri$Builder q(final Uri$Builder uri$Builder, final Intent intent, final String s, final String s2) {
        final String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        final String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        final String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        final String stringExtra4 = intent.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        final ArrayList stringArrayListExtra = intent.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        String join;
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            join = TextUtils.join((CharSequence)",", (Iterable)stringArrayListExtra);
        }
        else {
            join = null;
        }
        final Bundle bundleExtra = intent.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS");
        String string;
        if (bundleExtra == null) {
            string = null;
        }
        else {
            final JSONObject jsonObject = new JSONObject();
            try {
                for (final String s3 : bundleExtra.keySet()) {
                    final String string2 = bundleExtra.getString(s3);
                    if (!TextUtils.isEmpty((CharSequence)string2)) {
                        jsonObject.put(s3, (Object)string2);
                    }
                }
            }
            catch (final JSONException ex) {
                Log.e("GenericIdpActivity", "Unexpected JSON exception when serializing developer specified custom params");
            }
            string = jsonObject.toString();
        }
        final String string3 = UUID.randomUUID().toString();
        final String zza = zztx.zza((com.google.android.gms.internal.firebase-auth-api.zzty)this, UUID.randomUUID().toString());
        final String action = intent.getAction();
        final String stringExtra5 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        zzj.b().d(this.getApplicationContext(), s, string3, zza, action, stringExtra2, stringExtra3, stringExtra4);
        final String c = zzk.a(this.getApplicationContext(), FirebaseApp.n(stringExtra4).q()).c();
        if (TextUtils.isEmpty((CharSequence)c)) {
            Log.e("GenericIdpActivity", "Could not generate an encryption key for Generic IDP - cancelling flow.");
            this.s(zzai.a("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        }
        if (zza == null) {
            return null;
        }
        uri$Builder.appendQueryParameter("eid", "p").appendQueryParameter("v", "X".concat(String.valueOf(stringExtra5))).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("providerId", stringExtra2).appendQueryParameter("sessionId", zza).appendQueryParameter("eventId", string3).appendQueryParameter("apn", s).appendQueryParameter("sha1Cert", s2).appendQueryParameter("publicKey", c);
        if (!TextUtils.isEmpty((CharSequence)join)) {
            uri$Builder.appendQueryParameter("scopes", join);
        }
        if (!TextUtils.isEmpty((CharSequence)string)) {
            uri$Builder.appendQueryParameter("customParameters", string);
        }
        if (!TextUtils.isEmpty((CharSequence)stringExtra3)) {
            uri$Builder.appendQueryParameter("tid", stringExtra3);
        }
        return uri$Builder;
    }
    
    public final Context zza() {
        return this.getApplicationContext();
    }
    
    public final Uri$Builder zzb(final Intent intent, final String s, final String s2) {
        return this.q(new Uri$Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, s, s2);
    }
    
    public final String zzc(final String s) {
        return zzvr.zzb(s);
    }
    
    public final HttpURLConnection zzd(final URL url) {
        try {
            return (HttpURLConnection)url.openConnection();
        }
        catch (final IOException ex) {
            Log.e("GenericIdpActivity", "Error generating URL connection");
            return null;
        }
    }
    
    public final void zze(final String s, final Status status) {
        if (status == null) {
            this.r();
            return;
        }
        this.s(status);
    }
    
    public final void zzf(final Uri uri, final String s) {
        if (this.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) == null) {
            Log.e("GenericIdpActivity", "Device cannot resolve intent for: android.intent.action.VIEW");
            ((zzty)this).zze(s, null);
            return;
        }
        final List queryIntentServices = this.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            final d a = new androidx.browser.customtabs.d.a().a();
            a.a.addFlags(1073741824);
            a.a.addFlags(268435456);
            a.a((Context)this, uri);
            return;
        }
        final Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.putExtra("com.android.browser.application_id", s);
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        this.startActivity(intent);
    }
}
