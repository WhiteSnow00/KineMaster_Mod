// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.safetynet.SafetyNetApi$AttestationResponse;
import android.app.Activity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.OnSuccessListener;

final class m implements OnSuccessListener
{
    final TaskCompletionSource a;
    final FirebaseAuth b;
    final zzbm c;
    final Activity d;
    final zzf e;
    
    m(final zzf e, final TaskCompletionSource a, final FirebaseAuth b, final zzbm c, final Activity d) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public final /* bridge */ void onSuccess(final Object o) {
        final SafetyNetApi$AttestationResponse safetyNetApi$AttestationResponse = (SafetyNetApi$AttestationResponse)o;
        if (zzbf.a(safetyNetApi$AttestationResponse)) {
            this.a.c((Object)new zze(safetyNetApi$AttestationResponse.k(), null));
            return;
        }
        zzf.d(this.e, this.b, this.c, this.d, this.a);
    }
}
