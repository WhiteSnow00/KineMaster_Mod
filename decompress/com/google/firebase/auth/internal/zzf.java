// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.firebase.FirebaseApp;
import com.google.android.gms.safetynet.SafetyNetClient;
import java.io.UnsupportedEncodingException;
import android.util.Log;
import com.google.android.gms.internal.firebase_auth_api.zzvr;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.internal.firebase_auth_api.zzug;
import android.text.TextUtils;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.internal.firebase_auth_api.zztu;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import android.app.Activity;
import com.google.firebase.auth.FirebaseAuth;

public final class zzf
{
    private static final String a = "zzf";
    private static final zzf b;
    
    static {
        b = new zzf();
    }
    
    private zzf() {
    }
    
    public static zzf b() {
        return zzf.b;
    }
    
    static /* bridge */ String c() {
        return zzf.a;
    }
    
    static /* bridge */ void d(final zzf zzf, final FirebaseAuth firebaseAuth, final zzbm zzbm, final Activity activity, final TaskCompletionSource taskCompletionSource) {
        zzf.e(firebaseAuth, zzbm, activity, taskCompletionSource);
    }
    
    private final void e(final FirebaseAuth firebaseAuth, final zzbm zzbm, final Activity activity, final TaskCompletionSource taskCompletionSource) {
        zzbm.g(firebaseAuth.g().l(), firebaseAuth);
        Preconditions.k(activity);
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        Task task;
        if (!zzax.a().g(activity, taskCompletionSource2)) {
            task = Tasks.d((Exception)zztu.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        }
        else {
            final Intent intent = new Intent("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            intent.setClass((Context)activity, (Class)RecaptchaActivity.class);
            intent.setPackage(activity.getPackageName());
            intent.putExtra("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.g().p().b());
            if (!TextUtils.isEmpty((CharSequence)firebaseAuth.l())) {
                intent.putExtra("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.l());
            }
            intent.putExtra("com.google.firebase.auth.internal.CLIENT_VERSION", ((zzug)zzug.zza()).zzb());
            intent.putExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME", firebaseAuth.g().o());
            activity.startActivity(intent);
            task = taskCompletionSource2.a();
        }
        task.i((OnSuccessListener)new p(this, taskCompletionSource)).f((OnFailureListener)new o(this, taskCompletionSource));
    }
    
    public final Task a(final FirebaseAuth firebaseAuth, final String s, final Activity activity, final boolean b) {
        final zzw zzw = (zzw)firebaseAuth.i();
        SafetyNetClient a;
        if (b) {
            a = SafetyNet.a(firebaseAuth.g().l());
        }
        else {
            a = null;
        }
        final zzbm c = zzbm.c();
        Task task;
        if (!zzvr.zzg(firebaseAuth.g()) && !zzw.e()) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            final Task b2 = c.b();
            if (b2 != null) {
                if (b2.t()) {
                    task = Tasks.e((Object)new zze(null, (String)b2.p()));
                    return task;
                }
                final String a2 = zzf.a;
                Log.e(a2, "Error in previous reCAPTCHA flow: ".concat(String.valueOf(b2.o().getMessage())));
                Log.e(a2, "Continuing with application verification as normal");
            }
            if (a != null && !zzw.c()) {
                final FirebaseApp g = firebaseAuth.g();
                byte[] bytes = new byte[0];
                if (s != null) {
                    try {
                        bytes = s.getBytes("UTF-8");
                    }
                    catch (final UnsupportedEncodingException ex) {
                        Log.e(zzf.a, "Failed to getBytes with exception: ".concat(String.valueOf(ex.getMessage())));
                        bytes = bytes;
                    }
                }
                a.b(bytes, g.p().b()).i((OnSuccessListener)new m(this, taskCompletionSource, firebaseAuth, c, activity)).f((OnFailureListener)new a(this, firebaseAuth, c, activity, taskCompletionSource));
            }
            else {
                this.e(firebaseAuth, c, activity, taskCompletionSource);
            }
            task = taskCompletionSource.a();
        }
        else {
            task = Tasks.e((Object)new zze(null, null));
        }
        return task;
    }
}
