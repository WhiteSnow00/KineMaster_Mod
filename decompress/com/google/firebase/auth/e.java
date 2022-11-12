// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase-auth-api.zzwq;
import com.google.firebase.auth.internal.zzbk;

final class e implements zzbk
{
    final FirebaseAuth a;
    
    e(final FirebaseAuth a) {
        this.a = a;
    }
    
    @Override
    public final void a(final zzwq zzwq, final FirebaseUser firebaseUser) {
        FirebaseAuth.G(this.a, firebaseUser, zzwq, true, true);
    }
    
    @Override
    public final void zzb(final Status status) {
        final int m1 = status.M1();
        if (m1 != 17011 && m1 != 17021 && m1 != 17005) {
            return;
        }
        this.a.v();
    }
}
