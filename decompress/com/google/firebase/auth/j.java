// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase-auth-api.zzwq;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.internal.zzbk;

@VisibleForTesting
final class j implements zzbk
{
    final FirebaseAuth a;
    
    j(final FirebaseAuth a) {
        this.a = a;
    }
    
    @Override
    public final void a(final zzwq zzwq, final FirebaseUser firebaseUser) {
        Preconditions.k(zzwq);
        Preconditions.k(firebaseUser);
        firebaseUser.c2(zzwq);
        FirebaseAuth.G(this.a, firebaseUser, zzwq, true, true);
    }
    
    @Override
    public final void zzb(final Status status) {
        if (status.M1() != 17011 && status.M1() != 17021 && status.M1() != 17005 && status.M1() != 17091) {
            return;
        }
        this.a.v();
    }
}
