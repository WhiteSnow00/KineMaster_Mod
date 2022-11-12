// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.internal.firebase_auth_api.zztu;
import com.google.android.gms.common.api.Status;
import android.util.Log;
import android.content.Intent;
import android.content.Context;
import android.app.Activity;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import android.content.BroadcastReceiver;

final class j extends BroadcastReceiver
{
    private final WeakReference a;
    private final TaskCompletionSource b;
    private final FirebaseAuth c;
    private final FirebaseUser d;
    final zzax e;
    
    j(final zzax e, final Activity activity, final TaskCompletionSource b, final FirebaseAuth c, final FirebaseUser d) {
        this.e = e;
        this.a = new WeakReference((T)activity);
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        if (this.a.get() == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.b.b((Exception)zztu.zza(new Status(17499, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.e(context);
            return;
        }
        if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            final String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
                zzax.d(this.e, intent, this.b, this.c, context);
                return;
            }
            if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
                zzax.b(this.e, intent, this.b, this.d, context);
                return;
            }
            if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
                zzax.c(this.e, intent, this.b, this.d, context);
                return;
            }
            final TaskCompletionSource b = this.b;
            final StringBuilder sb = new StringBuilder();
            sb.append("WEB_CONTEXT_CANCELED:Unknown operation received (");
            sb.append(stringExtra);
            sb.append(")");
            b.b((Exception)zztu.zza(zzai.a(sb.toString())));
        }
        else {
            if (zzbl.d(intent)) {
                this.b.b((Exception)zztu.zza(zzbl.a(intent)));
                zzax.e(context);
                return;
            }
            if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
                this.b.b((Exception)zztu.zza(zzai.a("WEB_CONTEXT_CANCELED")));
                zzax.e(context);
            }
        }
    }
}
