// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.OnFailureListener;

final class o implements OnFailureListener
{
    final TaskCompletionSource a;
    
    o(final zzf zzf, final TaskCompletionSource a) {
        this.a = a;
    }
    
    public final void onFailure(final Exception ex) {
        Log.e(zzf.c(), String.format("Failed to get reCAPTCHA token with error [%s]- calling backend without app verification", ex.getMessage()));
        this.a.c((Object)new zze(null, null));
    }
}
