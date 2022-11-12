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
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import android.content.BroadcastReceiver;

final class k extends BroadcastReceiver
{
    private final WeakReference a;
    private final TaskCompletionSource b;
    final zzax c;
    
    k(final zzax c, final Activity activity, final TaskCompletionSource b) {
        this.c = c;
        this.a = new WeakReference((T)activity);
        this.b = b;
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
            if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(stringExtra)) {
                this.b.c((Object)intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
                zzax.e(context);
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
