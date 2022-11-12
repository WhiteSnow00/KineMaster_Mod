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
import com.google.android.gms.internal.firebase_auth_api.zzvr;
import com.google.android.gms.internal.firebase_auth_api.zzuj;
import com.google.firebase.auth.FirebaseAuth;
import java.util.UUID;
import android.net.Uri$Builder;
import android.content.SharedPreferences$Editor;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.concurrent.Executor;
import com.google.android.gms.internal.firebase_auth_api.zztw;
import java.util.Locale;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.AndroidUtilsLight;
import android.net.Uri;
import com.google.firebase.FirebaseApp;
import android.text.TextUtils;
import com.google.android.gms.common.util.DefaultClock;
import android.util.Log;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import android.content.Context;
import l0.a;
import android.content.Intent;
import com.google.android.gms.internal.firebase_auth_api.zzf;
import java.util.concurrent.ExecutorService;
import com.google.android.gms.internal.firebase_auth_api.zzty;
import androidx.fragment.app.h;

public class RecaptchaActivity extends h implements zzty
{
    private static final String b = "RecaptchaActivity";
    private static final ExecutorService c;
    private static long d;
    private static final zzbm e;
    private boolean a;
    
    static {
        c = ((zzc)zzf.zza()).zza(2);
        RecaptchaActivity.d = 0L;
        e = zzbm.c();
    }
    
    public RecaptchaActivity() {
        this.a = false;
    }
    
    private final void q() {
        RecaptchaActivity.d = 0L;
        this.a = false;
        final Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        l0.a.b((Context)this).d(intent);
        RecaptchaActivity.e.d((Context)this);
        this.finish();
    }
    
    private final void r(final Status status) {
        RecaptchaActivity.d = 0L;
        this.a = false;
        final Intent intent = new Intent();
        zzbl.c(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        l0.a.b((Context)this).d(intent);
        RecaptchaActivity.e.d((Context)this);
        this.finish();
    }
    
    @Override
    protected final void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final String action = this.getIntent().getAction();
        if (!"com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            Log.e(RecaptchaActivity.b, "Could not do operation - unknown action: ".concat(String.valueOf(action)));
            this.q();
            return;
        }
        final long a = DefaultClock.d().a();
        if (a - RecaptchaActivity.d < 30000L) {
            Log.e(RecaptchaActivity.b, "Could not start operation - already in progress");
            return;
        }
        RecaptchaActivity.d = a;
        if (bundle != null) {
            this.a = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
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
                this.r(zzbl.b(intent.getStringExtra("firebaseError")));
                return;
            }
            if (intent.hasExtra("link") && intent.hasExtra("eventId")) {
                final String stringExtra = intent.getStringExtra("link");
                final String c = zzj.b().c(this.getApplicationContext(), this.getPackageName(), intent.getStringExtra("eventId"));
                if (TextUtils.isEmpty((CharSequence)c)) {
                    Log.e(RecaptchaActivity.b, "Failed to find registration for this event - failing to prevent session injection.");
                    this.r(zzai.a("Failed to find registration for this reCAPTCHA event"));
                }
                String b = stringExtra;
                if (intent.getBooleanExtra("encryptionEnabled", true)) {
                    b = zzk.a(this.getApplicationContext(), FirebaseApp.n(c).q()).b(stringExtra);
                }
                final String queryParameter = Uri.parse(b).getQueryParameter("recaptchaToken");
                RecaptchaActivity.d = 0L;
                this.a = false;
                final Intent intent2 = new Intent();
                intent2.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
                intent2.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                if (!l0.a.b((Context)this).d(intent2)) {
                    final SharedPreferences$Editor edit = this.getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
                    edit.putString("recaptchaToken", queryParameter);
                    edit.putString("operation", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                    edit.putLong("timestamp", DefaultClock.d().a());
                    edit.commit();
                }
                else {
                    RecaptchaActivity.e.d((Context)this);
                }
                this.finish();
                return;
            }
            this.q();
        }
        else {
            if (!this.a) {
                final Intent intent3 = this.getIntent();
                final String packageName = this.getPackageName();
                try {
                    ((AsyncTask)new zztw(packageName, Hex.b(AndroidUtilsLight.a((Context)this, packageName)).toLowerCase(Locale.US), intent3, FirebaseApp.n(intent3.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME")), (com.google.android.gms.internal.firebase-auth-api.zzty)this)).executeOnExecutor((Executor)RecaptchaActivity.c, (Object[])new Void[0]);
                }
                catch (final PackageManager$NameNotFoundException ex) {
                    final String b2 = RecaptchaActivity.b;
                    final String string = ex.toString();
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Could not get package signature: ");
                    sb.append(packageName);
                    sb.append(" ");
                    sb.append(string);
                    Log.e(b2, sb.toString());
                    ((zzty)this).zze(packageName, null);
                }
                this.a = true;
                return;
            }
            this.q();
        }
    }
    
    protected final void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.a);
    }
    
    public final Context zza() {
        return this.getApplicationContext();
    }
    
    public final Uri$Builder zzb(final Intent intent, final String s, final String s2) {
        final String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        final String string = UUID.randomUUID().toString();
        final String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        final String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        final FirebaseApp n = FirebaseApp.n(stringExtra3);
        final FirebaseAuth instance = FirebaseAuth.getInstance(n);
        zzj.b().e(this.getApplicationContext(), s, string, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        final String c = zzk.a(this.getApplicationContext(), n.q()).c();
        if (TextUtils.isEmpty((CharSequence)c)) {
            Log.e(RecaptchaActivity.b, "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            this.r(zzai.a("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        String s3;
        if (!TextUtils.isEmpty((CharSequence)instance.j())) {
            s3 = instance.j();
        }
        else {
            s3 = zzuj.zza();
        }
        return new Uri$Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", s).appendQueryParameter("hl", s3).appendQueryParameter("eventId", string).appendQueryParameter("v", "X".concat(String.valueOf(stringExtra2))).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", s2).appendQueryParameter("publicKey", c);
    }
    
    public final String zzc(final String s) {
        return zzvr.zzb(s);
    }
    
    public final HttpURLConnection zzd(final URL url) {
        try {
            return (HttpURLConnection)url.openConnection();
        }
        catch (final IOException ex) {
            zzty.zza.c("Error generating connection", new Object[0]);
            return null;
        }
    }
    
    public final void zze(final String s, final Status status) {
        if (status == null) {
            this.q();
            return;
        }
        this.r(status);
    }
    
    public final void zzf(final Uri uri, final String s) {
        if (this.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) == null) {
            Log.e(RecaptchaActivity.b, "Device cannot resolve intent for: android.intent.action.VIEW");
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
