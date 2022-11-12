// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase-auth-api.zzwq;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.internal.zzg;

@VisibleForTesting
class i implements zzg
{
    final FirebaseAuth a;
    
    i(final FirebaseAuth a) {
        this.a = a;
    }
    
    @Override
    public final void a(final zzwq zzwq, final FirebaseUser firebaseUser) {
        Preconditions.k(zzwq);
        Preconditions.k(firebaseUser);
        firebaseUser.c2(zzwq);
        this.a.D(firebaseUser, zzwq, true);
    }
}
