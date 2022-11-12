// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import android.app.Activity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnFailureListener;

final class a implements OnFailureListener
{
    final FirebaseAuth a;
    final zzbm b;
    final Activity c;
    final TaskCompletionSource d;
    final zzf e;
    
    a(final zzf e, final FirebaseAuth a, final zzbm b, final Activity c, final TaskCompletionSource d) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public final void onFailure(final Exception ex) {
        Log.e(zzf.c(), "Problem retrieving SafetyNet Token: ".concat(String.valueOf(ex.getMessage())));
        zzf.d(this.e, this.a, this.b, this.c, this.d);
    }
}
